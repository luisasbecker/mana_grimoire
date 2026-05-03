package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÜ\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "icon", Constants.GP_IAP_TITLE, "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", DiagnosticsEntry.PROPERTIES_KEY, "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-Oix01E0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidAlertDialog_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:230:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011c  */
    /* JADX INFO: renamed from: AlertDialog-Oix01E0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3282AlertDialogOix01E0(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Shape shape2;
        int i10;
        long j5;
        int i11;
        int i12;
        int i13;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final float f2;
        final DialogProperties dialogProperties2;
        final Shape shape3;
        final Modifier modifier3;
        final long j6;
        final long j7;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final long j8;
        final long j9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long containerColor;
        long iconContentColor;
        long titleContentColor;
        long textContentColor;
        DialogProperties dialogProperties3;
        float f3;
        Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        Shape shape4;
        Modifier modifier4;
        int i14;
        Function2<? super Composer, ? super Integer, Unit> function215;
        Function2<? super Composer, ? super Integer, Unit> function216;
        long j10;
        long j11;
        int i15;
        int i16;
        long j12;
        long j13;
        Composer composerStartRestartGroup = composer.startRestartGroup(94478519);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialog)N(onDismissRequest,confirmButton,modifier,dismissButton,icon,title,text,shape,containerColor:c#ui.graphics.Color,iconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,textContentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,properties)46@1649L514:AndroidAlertDialog.android.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    modifier2 = modifier;
                    i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
                }
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function22) ? 2048 : 1024;
                    }
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            function26 = function23;
                            i4 |= composerStartRestartGroup.changedInstance(function26) ? 16384 : 8192;
                        }
                        i8 = i3 & 32;
                        if (i8 != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            function27 = function24;
                        } else {
                            function27 = function24;
                            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i4 |= composerStartRestartGroup.changedInstance(function27) ? 131072 : 65536;
                            }
                        }
                        i9 = i3 & 64;
                        if (i9 != 0) {
                            i4 |= 1572864;
                            function28 = function25;
                        } else {
                            function28 = function25;
                            if ((i & 1572864) == 0) {
                                i4 |= composerStartRestartGroup.changedInstance(function28) ? 1048576 : 524288;
                            }
                        }
                        if ((i & 12582912) == 0) {
                            if ((i3 & 128) == 0) {
                                shape2 = shape;
                                int i17 = composerStartRestartGroup.changed(shape2) ? 8388608 : 4194304;
                                i4 |= i17;
                            } else {
                                shape2 = shape;
                            }
                            i4 |= i17;
                        } else {
                            shape2 = shape;
                        }
                        if ((i & 100663296) == 0) {
                            i4 |= ((i3 & 256) == 0 && composerStartRestartGroup.changed(j)) ? 67108864 : 33554432;
                        }
                        if ((805306368 & i) == 0) {
                            i4 |= ((i3 & 512) == 0 && composerStartRestartGroup.changed(j2)) ? 536870912 : 268435456;
                        }
                        if ((i2 & 6) == 0) {
                            i10 = i2 | (((i3 & 1024) == 0 && composerStartRestartGroup.changed(j3)) ? 4 : 2);
                        } else {
                            i10 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            j5 = j4;
                            i10 |= ((i3 & 2048) == 0 && composerStartRestartGroup.changed(j5)) ? 32 : 16;
                        } else {
                            j5 = j4;
                        }
                        i11 = i3 & 4096;
                        if (i11 != 0) {
                            i10 |= 384;
                        } else {
                            if ((i2 & 384) == 0) {
                                i10 |= composerStartRestartGroup.changed(f) ? 256 : 128;
                            }
                            i12 = i3 & 8192;
                            if (i12 != 0) {
                                i13 = i12;
                                if ((i2 & 3072) == 0) {
                                    i10 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 1171) == 1170) ? false : true, i4 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@4977L5,62@5032L14,62@5098L16,62@5167L17,62@5236L16");
                                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i5 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function217 = i6 != 0 ? null : function22;
                                        if (i7 != 0) {
                                            function26 = null;
                                        }
                                        if (i8 != 0) {
                                            function27 = null;
                                        }
                                        if (i9 != 0) {
                                            function28 = null;
                                        }
                                        if ((i3 & 128) != 0) {
                                            i4 &= -29360129;
                                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                        }
                                        if ((i3 & 256) != 0) {
                                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                            i4 &= -234881025;
                                        } else {
                                            containerColor = j;
                                        }
                                        if ((i3 & 512) != 0) {
                                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                            i4 = (-1879048193) & i4;
                                        } else {
                                            iconContentColor = j2;
                                        }
                                        if ((i3 & 1024) != 0) {
                                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                            i10 &= -15;
                                        } else {
                                            titleContentColor = j3;
                                        }
                                        if ((i3 & 2048) != 0) {
                                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                            i10 &= -113;
                                        } else {
                                            textContentColor = j5;
                                        }
                                        float fM3274getTonalElevationD9Ej5fM = i11 != 0 ? AlertDialogDefaults.INSTANCE.m3274getTonalElevationD9Ej5fM() : f;
                                        if (i13 != 0) {
                                            f3 = fM3274getTonalElevationD9Ej5fM;
                                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                        } else {
                                            dialogProperties3 = dialogProperties;
                                            f3 = fM3274getTonalElevationD9Ej5fM;
                                        }
                                        function213 = function27;
                                        function214 = function28;
                                        shape4 = shape2;
                                        modifier4 = modifier2;
                                        i14 = 94478519;
                                        int i18 = i4;
                                        function215 = function26;
                                        function216 = function217;
                                        j10 = containerColor;
                                        j11 = titleContentColor;
                                        long j14 = textContentColor;
                                        i15 = i18;
                                        i16 = i10;
                                        j12 = iconContentColor;
                                        j13 = j14;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i3 & 128) != 0) {
                                            i4 &= -29360129;
                                        }
                                        if ((i3 & 256) != 0) {
                                            i4 &= -234881025;
                                        }
                                        if ((i3 & 512) != 0) {
                                            i4 &= -1879048193;
                                        }
                                        if ((i3 & 1024) != 0) {
                                            i10 &= -15;
                                        }
                                        if ((i3 & 2048) != 0) {
                                            i10 &= -113;
                                        }
                                        j11 = j3;
                                        f3 = f;
                                        dialogProperties3 = dialogProperties;
                                        j13 = j5;
                                        i15 = i4;
                                        function213 = function27;
                                        function214 = function28;
                                        shape4 = shape2;
                                        i16 = i10;
                                        modifier4 = modifier2;
                                        i14 = 94478519;
                                        j10 = j;
                                        j12 = j2;
                                        function215 = function26;
                                        function216 = function22;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i14, i15, i16, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                                    }
                                    composer2 = composerStartRestartGroup;
                                    AlertDialogKt.m3277AlertDialogImplwrnwzgE(function0, function2, modifier4, function216, function215, function213, function214, shape4, j10, j12, j11, j13, f3, dialogProperties3, composer2, i15 & 2147483646, i16 & 8190);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    function29 = function216;
                                    function210 = function215;
                                    function211 = function213;
                                    function212 = function214;
                                    shape3 = shape4;
                                    j8 = j10;
                                    j9 = j12;
                                    j6 = j11;
                                    j7 = j13;
                                    f2 = f3;
                                    dialogProperties2 = dialogProperties3;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    function29 = function22;
                                    f2 = f;
                                    dialogProperties2 = dialogProperties;
                                    shape3 = shape2;
                                    modifier3 = modifier2;
                                    j6 = j3;
                                    j7 = j5;
                                    function210 = function26;
                                    function211 = function27;
                                    function212 = function28;
                                    j8 = j;
                                    j9 = j2;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function29, function210, function211, function212, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i10 |= 3072;
                            i13 = i12;
                            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 1171) == 1170) ? false : true, i4 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i12 = i3 & 8192;
                        if (i12 != 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 1171) == 1170) ? false : true, i4 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    function26 = function23;
                    i8 = i3 & 32;
                    if (i8 != 0) {
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    if ((i & 100663296) == 0) {
                    }
                    if ((805306368 & i) == 0) {
                    }
                    if ((i2 & 6) == 0) {
                    }
                    if ((i2 & 48) == 0) {
                    }
                    i11 = i3 & 4096;
                    if (i11 != 0) {
                    }
                    i12 = i3 & 8192;
                    if (i12 != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 1171) == 1170) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                function26 = function23;
                i8 = i3 & 32;
                if (i8 != 0) {
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((805306368 & i) == 0) {
                }
                if ((i2 & 6) == 0) {
                }
                if ((i2 & 48) == 0) {
                }
                i11 = i3 & 4096;
                if (i11 != 0) {
                }
                i12 = i3 & 8192;
                if (i12 != 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 1171) == 1170) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            function26 = function23;
            i8 = i3 & 32;
            if (i8 != 0) {
            }
            i9 = i3 & 64;
            if (i9 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((805306368 & i) == 0) {
            }
            if ((i2 & 6) == 0) {
            }
            if ((i2 & 48) == 0) {
            }
            i11 = i3 & 4096;
            if (i11 != 0) {
            }
            i12 = i3 & 8192;
            if (i12 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 1171) == 1170) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        function26 = function23;
        i8 = i3 & 32;
        if (i8 != 0) {
        }
        i9 = i3 & 64;
        if (i9 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((805306368 & i) == 0) {
        }
        if ((i2 & 6) == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        i11 = i3 & 4096;
        if (i11 != 0) {
        }
        i12 = i3 & 8192;
        if (i12 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 1171) == 1170) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit AlertDialog_Oix01E0$lambda$0(Function0 function0, Function2 function2, Modifier modifier, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, int i, int i2, int i3, Composer composer, int i4) {
        m3282AlertDialogOix01E0(function0, function2, modifier, function22, function23, function24, function25, shape, j, j2, j3, j4, f, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }
}
