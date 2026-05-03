package androidx.compose.foundation;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AndroidExternalSurface.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001aZ\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0002\u0010\u0016\u001aR\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"rememberAndroidExternalSurfaceState", "Landroidx/compose/foundation/AndroidExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidExternalSurfaceState;", "AndroidExternalSurface", "", "modifier", "Landroidx/compose/ui/Modifier;", "isOpaque", "", "surfaceSize", "Landroidx/compose/ui/unit/IntSize;", "zOrder", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "isSecure", "onInit", "Lkotlin/Function1;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Lkotlin/ExtensionFunctionType;", "AndroidExternalSurface-58FFMhA", "(Landroidx/compose/ui/Modifier;ZJIZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberAndroidEmbeddedExternalSurfaceState", "Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "AndroidEmbeddedExternalSurface", "transform", "Landroidx/compose/ui/graphics/Matrix;", "AndroidEmbeddedExternalSurface-sv6N_fY", "(Landroidx/compose/ui/Modifier;ZJ[FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidExternalSurface_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0135  */
    /* JADX INFO: renamed from: AndroidEmbeddedExternalSurface-sv6N_fY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1477AndroidEmbeddedExternalSurfacesv6N_fY(Modifier modifier, boolean z, long j, float[] fArr, final Function1<? super AndroidExternalSurfaceScope, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z2;
        long jM9290getZeroYbymL2g;
        int i4;
        Function1<? super AndroidExternalSurfaceScope, Unit> function12;
        final float[] fArr2;
        final Modifier modifier3;
        final boolean z3;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final float[] fArr3;
        final boolean z4;
        final AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState;
        Object objRememberedValue;
        Object objRememberedValue2;
        boolean zChangedInstance;
        Object objRememberedValue3;
        final long j3;
        Composer composerStartRestartGroup = composer.startRestartGroup(217541314);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AndroidEmbeddedExternalSurface)N(modifier,isOpaque,surfaceSize:c#ui.unit.IntSize,transform:c#ui.graphics.Matrix,onInit)433@18602L45,436@18684L19,438@18752L2,439@18773L639,435@18653L766:AndroidExternalSurface.android.kt#71ulvw");
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
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                jM9290getZeroYbymL2g = j;
                i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM9290getZeroYbymL2g)) ? 256 : 128;
            } else {
                jM9290getZeroYbymL2g = j;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(fArr != null ? Matrix.m6567boximpl(fArr) : null) ? 2048 : 1024;
            }
            if ((i & 24576) != 0) {
                function12 = function1;
                i3 |= composerStartRestartGroup.changedInstance(function12) ? 16384 : 8192;
            } else {
                function12 = function1;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                fArr2 = fArr;
                modifier3 = modifier2;
                z3 = z2;
                j2 = jM9290getZeroYbymL2g;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        jM9290getZeroYbymL2g = IntSize.INSTANCE.m9290getZeroYbymL2g();
                    }
                    if (i4 != 0) {
                        z4 = z2;
                        fArr3 = null;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(217541314, i3, -1, "androidx.compose.foundation.AndroidEmbeddedExternalSurface (AndroidExternalSurface.android.kt:432)");
                        }
                        androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState = rememberAndroidEmbeddedExternalSurfaceState(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1396184267, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$0$0((Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Function1 function13 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1396182108, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$1$0((TextureView) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function14 = (Function1) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1396180799, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                        zChangedInstance = ((((i3 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(jM9290getZeroYbymL2g)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState) | ((57344 & i3) == 16384) | ((i3 & 112) == 32) | composerStartRestartGroup.changedInstance(fArr3 != null ? Matrix.m6567boximpl(fArr3) : null);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            j3 = jM9290getZeroYbymL2g;
                            final Function1<? super AndroidExternalSurfaceScope, Unit> function15 = function12;
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$2$0(j3, androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState, function15, z4, fArr3, (TextureView) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            j3 = jM9290getZeroYbymL2g;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifier4 = companion;
                        AndroidView_androidKt.AndroidView(function13, modifier4, function14, null, (Function1) objRememberedValue3, composerStartRestartGroup, ((i3 << 3) & 112) | 390, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        j2 = j3;
                        z3 = z4;
                        fArr2 = fArr3;
                    } else {
                        fArr3 = fArr;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    fArr3 = fArr;
                    companion = modifier2;
                }
                z4 = z2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState = rememberAndroidEmbeddedExternalSurfaceState(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1396184267, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                Function1 function132 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1396182108, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                Function1 function142 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1396180799, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                if (((i3 & 896) ^ 384) <= 256) {
                    zChangedInstance = ((((i3 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(jM9290getZeroYbymL2g)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState) | ((57344 & i3) == 16384) | ((i3 & 112) == 32) | composerStartRestartGroup.changedInstance(fArr3 != null ? Matrix.m6567boximpl(fArr3) : null);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        j3 = jM9290getZeroYbymL2g;
                        final Function1 function152 = function12;
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$2$0(j3, androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState, function152, z4, fArr3, (TextureView) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifier42 = companion;
                        AndroidView_androidKt.AndroidView(function132, modifier42, function142, null, (Function1) objRememberedValue3, composerStartRestartGroup, ((i3 << 3) & 112) | 390, 8);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier42;
                        j2 = j3;
                        z3 = z4;
                        fArr2 = fArr3;
                    }
                } else {
                    zChangedInstance = ((((i3 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(jM9290getZeroYbymL2g)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState) | ((57344 & i3) == 16384) | ((i3 & 112) == 32) | composerStartRestartGroup.changedInstance(fArr3 != null ? Matrix.m6567boximpl(fArr3) : null);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                    }
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$3(modifier3, z3, j2, fArr2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        z2 = z;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        if ((i & 24576) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextureView AndroidEmbeddedExternalSurface_sv6N_fY$lambda$0$0(Context context) {
        return new TextureView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$1$0(TextureView textureView) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$2$0(long j, AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState, Function1 function1, boolean z, float[] fArr, TextureView textureView) {
        android.graphics.Matrix matrix;
        SurfaceTexture surfaceTexture;
        if (!IntSize.m9283equalsimpl0(j, IntSize.INSTANCE.m9290getZeroYbymL2g()) && (surfaceTexture = textureView.getSurfaceTexture()) != null) {
            surfaceTexture.setDefaultBufferSize((int) (j >> 32), (int) (MuxerUtil.UNSIGNED_INT_MAX_VALUE & j));
        }
        androidEmbeddedExternalSurfaceState.m1465setSurfaceSizeozmzZPI(j);
        if (textureView.getSurfaceTextureListener() != androidEmbeddedExternalSurfaceState) {
            function1.invoke(androidEmbeddedExternalSurfaceState);
            textureView.setSurfaceTextureListener(androidEmbeddedExternalSurfaceState);
        }
        textureView.setOpaque(z);
        if (fArr != null) {
            matrix = androidEmbeddedExternalSurfaceState.getMatrix();
            AndroidMatrixConversions_androidKt.m6192setFromEL8BTi8(matrix, fArr);
        } else {
            matrix = null;
        }
        textureView.setTransform(matrix);
        return Unit.INSTANCE;
    }

    static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$3(Modifier modifier, boolean z, long j, float[] fArr, Function1 function1, int i, int i2, Composer composer, int i3) {
        m1477AndroidEmbeddedExternalSurfacesv6N_fY(modifier, z, j, fArr, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cb  */
    /* JADX INFO: renamed from: AndroidExternalSurface-58FFMhA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1478AndroidExternalSurface58FFMhA(Modifier modifier, boolean z, long j, int i, boolean z2, final Function1<? super AndroidExternalSurfaceScope, Unit> function1, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        boolean z3;
        long jM9290getZeroYbymL2g;
        int i5;
        int iM1473getBehindB_4ceCc;
        int i6;
        boolean z4;
        final Modifier modifier3;
        final boolean z5;
        final long j2;
        final boolean z6;
        final int i7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        long j3;
        int i8;
        boolean z7;
        Composer composerStartRestartGroup = composer.startRestartGroup(640888974);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AndroidExternalSurface)N(modifier,isOpaque,surfaceSize:c#ui.unit.IntSize,zOrder:c#foundation.AndroidExternalSurfaceZOrder,isSecure,onInit)275@12030L37,278@12104L150,285@12303L2,286@12324L774,277@12073L1032:AndroidExternalSurface.android.kt#71ulvw");
        int i9 = i3 & 1;
        if (i9 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                z3 = z;
                i4 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                jM9290getZeroYbymL2g = j;
                i4 |= ((i3 & 4) == 0 && composerStartRestartGroup.changed(jM9290getZeroYbymL2g)) ? 256 : 128;
            } else {
                jM9290getZeroYbymL2g = j;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    iM1473getBehindB_4ceCc = i;
                    i4 |= composerStartRestartGroup.changed(iM1473getBehindB_4ceCc) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 == 0) {
                    if ((i2 & 24576) == 0) {
                        z4 = z2;
                        i4 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function1) ? 131072 : 65536;
                    }
                    if (composerStartRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z5 = z3;
                        j2 = jM9290getZeroYbymL2g;
                        z6 = z4;
                        i7 = iM1473getBehindB_4ceCc;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i9 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i10 != 0) {
                                z3 = true;
                            }
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                                jM9290getZeroYbymL2g = IntSize.INSTANCE.m9290getZeroYbymL2g();
                            }
                            if (i5 != 0) {
                                iM1473getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m1473getBehindB_4ceCc();
                            }
                            if (i6 != 0) {
                                z4 = false;
                            }
                            modifier4 = companion;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            modifier4 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(640888974, i4, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:274)");
                        }
                        final AndroidExternalSurfaceState androidExternalSurfaceStateRememberAndroidExternalSurfaceState = rememberAndroidExternalSurfaceState(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713993348, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                        boolean zChangedInstance = ((458752 & i4) == 131072) | composerStartRestartGroup.changedInstance(androidExternalSurfaceStateRememberAndroidExternalSurfaceState);
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Function1 function12 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713999568, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$1$0((SurfaceView) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function13 = (Function1) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1714001012, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                        boolean z8 = ((57344 & i4) == 16384) | ((((i4 & 896) ^ 384) > 256 && composerStartRestartGroup.changed(jM9290getZeroYbymL2g)) || (i4 & 384) == 256) | ((i4 & 112) == 32) | ((i4 & 7168) == 2048);
                        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (z8 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            final boolean z9 = z3;
                            final long j4 = jM9290getZeroYbymL2g;
                            final boolean z10 = z4;
                            final int i11 = iM1473getBehindB_4ceCc;
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j4, z9, i11, z10, (SurfaceView) obj);
                                }
                            };
                            j3 = j4;
                            i8 = i11;
                            z7 = z10;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            j3 = jM9290getZeroYbymL2g;
                            z7 = z4;
                            i8 = iM1473getBehindB_4ceCc;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidView_androidKt.AndroidView(function12, modifier4, function13, null, (Function1) objRememberedValue3, composerStartRestartGroup, ((i4 << 3) & 112) | 384, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j2 = j3;
                        z5 = z3;
                        modifier3 = modifier4;
                        z6 = z7;
                        i7 = i8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$3(modifier3, z5, j2, i7, z6, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= 24576;
                z4 = z2;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            iM1473getBehindB_4ceCc = i;
            i6 = i3 & 16;
            if (i6 == 0) {
            }
            z4 = z2;
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        z3 = z;
        if ((i2 & 384) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        iM1473getBehindB_4ceCc = i;
        i6 = i3 & 16;
        if (i6 == 0) {
        }
        z4 = z2;
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SurfaceView AndroidExternalSurface_58FFMhA$lambda$0$0(Function1 function1, AndroidExternalSurfaceState androidExternalSurfaceState, Context context) {
        SurfaceView surfaceView = new SurfaceView(context);
        function1.invoke(androidExternalSurfaceState);
        surfaceView.getHolder().addCallback(androidExternalSurfaceState);
        return surfaceView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidExternalSurface_58FFMhA$lambda$1$0(SurfaceView surfaceView) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidExternalSurface_58FFMhA$lambda$2$0(long j, boolean z, int i, boolean z2, SurfaceView surfaceView) {
        if (IntSize.m9283equalsimpl0(j, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
            surfaceView.getHolder().setSizeFromLayout();
        } else {
            surfaceView.getHolder().setFixedSize((int) (j >> 32), (int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        }
        surfaceView.getHolder().setFormat(z ? -1 : -3);
        if (AndroidExternalSurfaceZOrder.m1469equalsimpl0(i, AndroidExternalSurfaceZOrder.INSTANCE.m1473getBehindB_4ceCc())) {
            surfaceView.setZOrderOnTop(false);
        } else if (AndroidExternalSurfaceZOrder.m1469equalsimpl0(i, AndroidExternalSurfaceZOrder.INSTANCE.m1474getMediaOverlayB_4ceCc())) {
            surfaceView.setZOrderMediaOverlay(true);
        } else if (AndroidExternalSurfaceZOrder.m1469equalsimpl0(i, AndroidExternalSurfaceZOrder.INSTANCE.m1475getOnTopB_4ceCc())) {
            surfaceView.setZOrderOnTop(true);
        }
        surfaceView.setSecure(z2);
        return Unit.INSTANCE;
    }

    static final Unit AndroidExternalSurface_58FFMhA$lambda$3(Modifier modifier, boolean z, long j, int i, boolean z2, Function1 function1, int i2, int i3, Composer composer, int i4) {
        m1478AndroidExternalSurface58FFMhA(modifier, z, j, i, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    private static final AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1057437053, "C(rememberAndroidEmbeddedExternalSurfaceState)371@14901L24,372@14937L55:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1057437053, i, -1, "androidx.compose.foundation.rememberAndroidEmbeddedExternalSurfaceState (AndroidExternalSurface.android.kt:370)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
            composer.updateRememberedValue(objRememberedValue);
        }
        CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1710245786, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new AndroidEmbeddedExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(objRememberedValue2);
        }
        AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = (AndroidEmbeddedExternalSurfaceState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return androidEmbeddedExternalSurfaceState;
    }

    private static final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -873615933, "C(rememberAndroidExternalSurfaceState)188@7180L24,189@7216L47:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-873615933, i, -1, "androidx.compose.foundation.rememberAndroidExternalSurfaceState (AndroidExternalSurface.android.kt:187)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
            composer.updateRememberedValue(objRememberedValue);
        }
        CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -2026284846, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new AndroidExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(objRememberedValue2);
        }
        AndroidExternalSurfaceState androidExternalSurfaceState = (AndroidExternalSurfaceState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return androidExternalSurfaceState;
    }
}
