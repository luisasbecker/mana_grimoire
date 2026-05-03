package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.appevents.internal.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AndroidAlertDialog.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a§\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", Constants.GP_IAP_TITLE, "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", DiagnosticsEntry.PROPERTIES_KEY, "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-6oU6zVQ", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "buttons", "AlertDialog-wqdebIU", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidAlertDialog_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:106:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0115  */
    /* JADX INFO: renamed from: AlertDialog-6oU6zVQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2900AlertDialog6oU6zVQ(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, long j, long j2, DialogProperties dialogProperties, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Shape medium;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Shape shape2;
        final long j3;
        final long j4;
        final DialogProperties dialogProperties2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i12;
        long jM2987getSurface0d7_KjU;
        long jM3001contentColorForek8zF_U;
        DialogProperties dialogProperties3;
        long j5;
        Function2<? super Composer, ? super Integer, Unit> function211;
        int i13;
        long j6;
        Modifier modifier4;
        Function2<? super Composer, ? super Integer, Unit> function212;
        Shape shape3;
        int i14;
        Composer composerStartRestartGroup = composer.startRestartGroup(1967984963);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialog)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)41@1490L354:AndroidAlertDialog.android.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i15 = i2 & 4;
        if (i15 != 0) {
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
                    function25 = function22;
                    i3 |= composerStartRestartGroup.changedInstance(function25) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        function26 = function23;
                        i3 |= composerStartRestartGroup.changedInstance(function26) ? 16384 : 8192;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else {
                        if ((196608 & i) == 0) {
                            function27 = function24;
                            i3 |= composerStartRestartGroup.changedInstance(function27) ? 131072 : 65536;
                        }
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                medium = shape;
                                int i16 = composerStartRestartGroup.changed(medium) ? 1048576 : 524288;
                                i3 |= i16;
                            } else {
                                medium = shape;
                            }
                            i3 |= i16;
                        } else {
                            medium = shape;
                        }
                        if ((i & 12582912) == 0) {
                            if ((i2 & 128) == 0) {
                                i14 = i3;
                                i8 = i15;
                                int i17 = composerStartRestartGroup.changed(j) ? 8388608 : 4194304;
                                i7 = i14 | i17;
                            } else {
                                i14 = i3;
                                i8 = i15;
                            }
                            i7 = i14 | i17;
                        } else {
                            i7 = i3;
                            i8 = i15;
                        }
                        if ((i & 100663296) == 0) {
                            i7 |= ((i2 & 256) == 0 && composerStartRestartGroup.changed(j2)) ? 67108864 : 33554432;
                        }
                        i9 = i7;
                        i10 = i2 & 512;
                        if (i10 == 0) {
                            if ((i & 805306368) == 0) {
                                i11 = i10;
                                i9 |= composerStartRestartGroup.changed(dialogProperties) ? 536870912 : 268435456;
                            }
                            if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier3 = modifier2;
                                function28 = function25;
                                function29 = function26;
                                function210 = function27;
                                shape2 = medium;
                                j3 = j;
                                j4 = j2;
                                dialogProperties2 = dialogProperties;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i8 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function25 = null;
                                    }
                                    if (i5 != 0) {
                                        function26 = null;
                                    }
                                    if (i6 != 0) {
                                        function27 = null;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i9 &= -3670017;
                                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                    }
                                    if ((i2 & 128) != 0) {
                                        i9 &= -29360129;
                                        i12 = -234881025;
                                        jM2987getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2987getSurface0d7_KjU();
                                    } else {
                                        i12 = -234881025;
                                        jM2987getSurface0d7_KjU = j;
                                    }
                                    if ((i2 & 256) != 0) {
                                        jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(jM2987getSurface0d7_KjU, composerStartRestartGroup, (i9 >> 21) & 14);
                                        i9 &= i12;
                                    } else {
                                        jM3001contentColorForek8zF_U = j2;
                                    }
                                    dialogProperties3 = i11 != 0 ? new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null) : dialogProperties;
                                    j5 = jM2987getSurface0d7_KjU;
                                    function211 = function26;
                                    i13 = i9;
                                    j6 = jM3001contentColorForek8zF_U;
                                    modifier4 = modifier2;
                                    function212 = function27;
                                    shape3 = medium;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 64) != 0) {
                                        i9 &= -3670017;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i9 &= -29360129;
                                    }
                                    if ((i2 & 256) != 0) {
                                        i9 &= -234881025;
                                    }
                                    j5 = j;
                                    j6 = j2;
                                    dialogProperties3 = dialogProperties;
                                    function211 = function26;
                                    function212 = function27;
                                    shape3 = medium;
                                    i13 = i9;
                                    modifier4 = modifier2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1967984963, i13, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                                int i18 = (2147483646 & i13) >> 3;
                                composer2 = composerStartRestartGroup;
                                m2901AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function25, function2), composerStartRestartGroup, 54), modifier4, function211, function212, shape3, j5, j6, dialogProperties3, composer2, (i13 & 896) | (i13 & 14) | 48 | (i18 & 7168) | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (29360128 & i18) | (i18 & 234881024), 0);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function28 = function25;
                                modifier3 = modifier4;
                                function29 = function211;
                                function210 = function212;
                                shape2 = shape3;
                                j3 = j5;
                                j4 = j6;
                                dialogProperties2 = dialogProperties3;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function28, function29, function210, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i9 |= 805306368;
                        i11 = i10;
                        if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    function27 = function24;
                    if ((1572864 & i) == 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    if ((i & 100663296) == 0) {
                    }
                    i9 = i7;
                    i10 = i2 & 512;
                    if (i10 == 0) {
                    }
                    i11 = i10;
                    if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function26 = function23;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                function27 = function24;
                if ((1572864 & i) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i9 = i7;
                i10 = i2 & 512;
                if (i10 == 0) {
                }
                i11 = i10;
                if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function25 = function22;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function26 = function23;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            function27 = function24;
            if ((1572864 & i) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i9 = i7;
            i10 = i2 & 512;
            if (i10 == 0) {
            }
            i11 = i10;
            if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function25 = function22;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function26 = function23;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        function27 = function24;
        if ((1572864 & i) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i9 = i7;
        i10 = i2 & 512;
        if (i10 == 0) {
        }
        i11 = i10;
        if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0124  */
    /* JADX INFO: renamed from: AlertDialog-wqdebIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2901AlertDialogwqdebIU(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long j, long j2, DialogProperties dialogProperties, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Shape medium;
        long jM2987getSurface0d7_KjU;
        int i6;
        int i7;
        int i8;
        int i9;
        Composer composer2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Shape shape2;
        final long j3;
        final DialogProperties dialogProperties2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM3001contentColorForek8zF_U;
        DialogProperties dialogProperties3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1409209698);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialog)N(onDismissRequest,buttons,modifier,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)66@2171L303:AndroidAlertDialog.android.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            function24 = function2;
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 32 : 16;
        } else {
            function24 = function2;
        }
        int i10 = i2 & 4;
        if (i10 != 0) {
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
                    function25 = function22;
                    i3 |= composerStartRestartGroup.changedInstance(function25) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        function26 = function23;
                        i3 |= composerStartRestartGroup.changedInstance(function26) ? 16384 : 8192;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            medium = shape;
                            int i11 = composerStartRestartGroup.changed(medium) ? 131072 : 65536;
                            i3 |= i11;
                        } else {
                            medium = shape;
                        }
                        i3 |= i11;
                    } else {
                        medium = shape;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            jM2987getSurface0d7_KjU = j;
                            int i12 = composerStartRestartGroup.changed(jM2987getSurface0d7_KjU) ? 1048576 : 524288;
                            i3 |= i12;
                        } else {
                            jM2987getSurface0d7_KjU = j;
                        }
                        i3 |= i12;
                    } else {
                        jM2987getSurface0d7_KjU = j;
                    }
                    if ((i & 12582912) != 0) {
                        i6 = i3 | (((i2 & 128) == 0 && composerStartRestartGroup.changed(j2)) ? 8388608 : 4194304);
                    } else {
                        i6 = i3;
                    }
                    int i13 = i6;
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i9 = i13 | 100663296;
                        i8 = i7;
                    } else if ((i & 100663296) == 0) {
                        i8 = i7;
                        i9 = i13 | (composerStartRestartGroup.changed(dialogProperties) ? 67108864 : 33554432);
                    } else {
                        i8 = i7;
                        i9 = i13;
                    }
                    if (composerStartRestartGroup.shouldExecute((i9 & 38347923) == 38347922, i9 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function27 = function26;
                        shape2 = medium;
                        j3 = j2;
                        dialogProperties2 = dialogProperties;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@6141L6,77@6199L6,77@6241L32");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function25 = null;
                            }
                            if (i5 != 0) {
                                function26 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i9 &= -458753;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 64) != 0) {
                                jM2987getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2987getSurface0d7_KjU();
                                i9 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(jM2987getSurface0d7_KjU, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3001contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            }
                            int i14 = i9;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1409209698, i14, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:66)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -214309806, "CC(AlertDialogImpl)N(onDismissRequest,buttons,modifier,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)180@7953L276,180@7884L345:AlertDialog.kt#jmzs0o");
                            DialogProperties dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-488319269, true, new AlertDialogKt$AlertDialogImpl$2(function24, modifier2, function25, function26, medium, jM2987getSurface0d7_KjU, jM3001contentColorForek8zF_U), composerStartRestartGroup, 54), composerStartRestartGroup, (i14 & 14) | 384 | (((268435454 & i14) >> 21) & 112), 0);
                            composer2 = composerStartRestartGroup;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function27 = function26;
                            shape2 = medium;
                            j3 = jM3001contentColorForek8zF_U;
                            dialogProperties2 = dialogProperties4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i9 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i9 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i9 &= -29360129;
                            }
                            jM3001contentColorForek8zF_U = j2;
                        }
                        dialogProperties3 = dialogProperties;
                        int i142 = i9;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -214309806, "CC(AlertDialogImpl)N(onDismissRequest,buttons,modifier,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)180@7953L276,180@7884L345:AlertDialog.kt#jmzs0o");
                        DialogProperties dialogProperties42 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties42, ComposableLambdaKt.rememberComposableLambda(-488319269, true, new AlertDialogKt$AlertDialogImpl$2(function24, modifier2, function25, function26, medium, jM2987getSurface0d7_KjU, jM3001contentColorForek8zF_U), composerStartRestartGroup, 54), composerStartRestartGroup, (i142 & 14) | 384 | (((268435454 & i142) >> 21) & 112), 0);
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier2;
                        function27 = function26;
                        shape2 = medium;
                        j3 = jM3001contentColorForek8zF_U;
                        dialogProperties2 = dialogProperties42;
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function28 = function25;
                    final long j4 = jM2987getSurface0d7_KjU;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_wqdebIU$lambda$0(function0, function2, modifier3, function28, function27, shape2, j4, j3, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                function26 = function23;
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                if ((i & 12582912) != 0) {
                }
                int i132 = i6;
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i9 & 38347923) == 38347922, i9 & 1)) {
                }
                final Function2 function282 = function25;
                final long j42 = jM2987getSurface0d7_KjU;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function25 = function22;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            function26 = function23;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            if ((i & 12582912) != 0) {
            }
            int i1322 = i6;
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i9 & 38347923) == 38347922, i9 & 1)) {
            }
            final Function2 function2822 = function25;
            final long j422 = jM2987getSurface0d7_KjU;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function25 = function22;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        function26 = function23;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        int i13222 = i6;
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i9 & 38347923) == 38347922, i9 & 1)) {
        }
        final Function2 function28222 = function25;
        final long j4222 = jM2987getSurface0d7_KjU;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit AlertDialog_6oU6zVQ$lambda$0(Function0 function0, Function2 function2, Modifier modifier, Function2 function22, Function2 function23, Function2 function24, Shape shape, long j, long j2, DialogProperties dialogProperties, int i, int i2, Composer composer, int i3) {
        m2900AlertDialog6oU6zVQ(function0, function2, modifier, function22, function23, function24, shape, j, j2, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit AlertDialog_wqdebIU$lambda$0(Function0 function0, Function2 function2, Modifier modifier, Function2 function22, Function2 function23, Shape shape, long j, long j2, DialogProperties dialogProperties, int i, int i2, Composer composer, int i3) {
        m2901AlertDialogwqdebIU(function0, function2, modifier, function22, function23, shape, j, j2, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }
}
