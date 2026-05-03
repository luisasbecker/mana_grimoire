package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AndroidMenu.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001ac\u0010\u0017\u001a\u00020\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001f\"\u0014\u0010 \u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/unit/DpOffset;", DiagnosticsEntry.PROPERTIES_KEY, "Landroidx/compose/ui/window/PopupProperties;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "scrollState", "Landroidx/compose/foundation/ScrollState;", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "onClick", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DefaultMenuProperties", "getDefaultMenuProperties", "()Landroidx/compose/ui/window/PopupProperties;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidMenu_androidKt {
    private static final PopupProperties DefaultMenuProperties = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);

    /* JADX WARN: Removed duplicated region for block: B:101:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0152  */
    /* JADX INFO: renamed from: DropdownMenu-4kj-_NE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2902DropdownMenu4kj_NE(final boolean z, final Function0<Unit> function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        long jM9170constructorimpl;
        ScrollState scrollStateRememberScrollState;
        int i5;
        PopupProperties popupProperties2;
        int i6;
        final Modifier modifier3;
        final ScrollState scrollState2;
        final PopupProperties popupProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        int i8;
        PopupProperties popupProperties4;
        final Modifier modifier4;
        final ScrollState scrollState3;
        Object objRememberedValue;
        final MutableTransitionState mutableTransitionState;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1275450738);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenu)N(expanded,onDismissRequest,modifier,offset:c#ui.unit.DpOffset,scrollState,properties,content)76@2730L42:AndroidMenu.android.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
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
                    jM9170constructorimpl = j;
                    i3 |= composerStartRestartGroup.changed(jM9170constructorimpl) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        scrollStateRememberScrollState = scrollState;
                        int i10 = composerStartRestartGroup.changed(scrollStateRememberScrollState) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        scrollStateRememberScrollState = scrollState;
                    }
                    i3 |= i10;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i5 = i2 & 32;
                if (i5 == 0) {
                    if ((196608 & i) == 0) {
                        popupProperties2 = popupProperties;
                        i3 |= composerStartRestartGroup.changed(popupProperties2) ? 131072 : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                    }
                    i6 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i6 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        scrollState2 = scrollStateRememberScrollState;
                        popupProperties3 = popupProperties2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "122@5703L21");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                float fM9114constructorimpl = Dp.m9114constructorimpl(0.0f);
                                float fM9114constructorimpl2 = Dp.m9114constructorimpl(0.0f);
                                long jFloatToRawIntBits = Float.floatToRawIntBits(fM9114constructorimpl);
                                i7 = -57345;
                                jM9170constructorimpl = DpOffset.m9170constructorimpl((((long) Float.floatToRawIntBits(fM9114constructorimpl2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (jFloatToRawIntBits << 32));
                            } else {
                                i7 = -57345;
                            }
                            if ((i2 & 16) != 0) {
                                i8 = i6 & i7;
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            } else {
                                i8 = i6;
                            }
                            if (i5 != 0) {
                                popupProperties4 = DefaultMenuProperties;
                                modifier4 = modifier2;
                                scrollState3 = scrollStateRememberScrollState;
                            } else {
                                modifier4 = modifier2;
                                scrollState3 = scrollStateRememberScrollState;
                                popupProperties4 = popupProperties2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1275450738, i8, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:75)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642488284, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new MutableTransitionState(false);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableTransitionState = (MutableTransitionState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                            if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue() || ((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
                                composerStartRestartGroup.startReplaceGroup(-622294666);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m6725boximpl(TransformOrigin.INSTANCE.m6738getCenterSzJe1aQ()), null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                final MutableState mutableState = (MutableState) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Density density = (Density) objConsume;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9170constructorimpl, density, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 112) | 3072 | ((i8 >> 9) & 896), 0);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-625181200);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            popupProperties3 = popupProperties4;
                            scrollState2 = scrollState3;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i8 = i6 & (-57345);
                                modifier4 = modifier2;
                                scrollState3 = scrollStateRememberScrollState;
                                popupProperties4 = popupProperties2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642488284, "CC(remember):AndroidMenu.android.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                }
                                mutableTransitionState = (MutableTransitionState) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                                    composerStartRestartGroup.startReplaceGroup(-622294666);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "80@2920L51,81@3007L7,83@3109L139,91@3420L283,87@3258L445");
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642494373, "CC(remember):AndroidMenu.android.kt#9igjgp");
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    }
                                    final MutableState mutableState2 = (MutableState) objRememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    Density density2 = (Density) objConsume2;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642500509, "CC(remember):AndroidMenu.android.kt#9igjgp");
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    AndroidPopup_androidKt.Popup(new DropdownMenuPositionProvider(jM9170constructorimpl, density2, (Function2) objRememberedValue3, null), function0, popupProperties4, ComposableLambdaKt.rememberComposableLambda(1788768427, true, new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$3(mutableTransitionState, mutableState2, scrollState3, modifier4, function3, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 112) | 3072 | ((i8 >> 9) & 896), 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    popupProperties3 = popupProperties4;
                                    scrollState2 = scrollState3;
                                    modifier3 = modifier4;
                                }
                            } else {
                                modifier4 = modifier2;
                                scrollState3 = scrollStateRememberScrollState;
                                popupProperties4 = popupProperties2;
                                i8 = i6;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642488284, "CC(remember):AndroidMenu.android.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                }
                                mutableTransitionState = (MutableTransitionState) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                                }
                            }
                        }
                    }
                    final long j2 = jM9170constructorimpl;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$4(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                popupProperties2 = popupProperties;
                if ((i & 1572864) == 0) {
                }
                i6 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i6 & 1)) {
                }
                final long j22 = jM9170constructorimpl;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            jM9170constructorimpl = j;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 == 0) {
            }
            popupProperties2 = popupProperties;
            if ((i & 1572864) == 0) {
            }
            i6 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i6 & 1)) {
            }
            final long j222 = jM9170constructorimpl;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        jM9170constructorimpl = j;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        popupProperties2 = popupProperties;
        if ((i & 1572864) == 0) {
        }
        i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i6 & 1)) {
        }
        final long j2222 = jM9170constructorimpl;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @ReplaceWith(expression = "DropdownMenu(expanded,onDismissRequest, modifier, offset, rememberScrollState(), properties, content)", imports = {"androidx.compose.foundation.rememberScrollState"}))
    /* JADX INFO: renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2903DropdownMenuILWXrKs(final boolean z, final Function0 function0, Modifier modifier, long j, PopupProperties popupProperties, final Function3 function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        Function3 function32;
        final Modifier modifier3;
        Composer composer2;
        final long j2;
        final PopupProperties popupProperties2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composer3;
        long jM9170constructorimpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2042390678);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenu)N(expanded,onDismissRequest,modifier,offset:c#ui.unit.DpOffset,properties,content)61@2359L21,56@2195L252:AndroidMenu.android.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changed(j) ? 2048 : 1024;
            }
            i5 = i2 & 16;
            if (i5 != 0) {
                if ((i & 24576) == 0) {
                    i3 |= composerStartRestartGroup.changed(popupProperties) ? 16384 : 8192;
                }
                if ((196608 & i) == 0) {
                    function32 = function3;
                    i3 |= composerStartRestartGroup.changedInstance(function32) ? 131072 : 65536;
                } else {
                    function32 = function3;
                }
                if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                    Modifier modifier4 = i6 != 0 ? Modifier.INSTANCE : modifier2;
                    if (i4 != 0) {
                        float fM9114constructorimpl = Dp.m9114constructorimpl(0.0f);
                        composer3 = composerStartRestartGroup;
                        jM9170constructorimpl = DpOffset.m9170constructorimpl((((long) Float.floatToRawIntBits(Dp.m9114constructorimpl(0.0f))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(fM9114constructorimpl)) << 32));
                    } else {
                        composer3 = composerStartRestartGroup;
                        jM9170constructorimpl = j;
                    }
                    PopupProperties popupProperties3 = i5 != 0 ? new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null) : popupProperties;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2042390678, i3, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:56)");
                    }
                    int i7 = i3 & 8190;
                    int i8 = i3 << 3;
                    m2902DropdownMenu4kj_NE(z, function0, modifier4, jM9170constructorimpl, ScrollKt.rememberScrollState(0, composer3, 0, 1), popupProperties3, function32, composer3, i7 | (458752 & i8) | (i8 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composer3;
                    modifier3 = modifier4;
                    j2 = jM9170constructorimpl;
                    popupProperties2 = popupProperties3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    j2 = j;
                    popupProperties2 = popupProperties;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_ILWXrKs$lambda$0(z, function0, modifier3, j2, popupProperties2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 24576;
            if ((196608 & i) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        if ((196608 & i) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DropdownMenuItem(final Function0<Unit> function0, Modifier modifier, boolean z, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        final PaddingValues paddingValues2;
        final Modifier modifier3;
        final boolean z3;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(670540513);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItem)N(onClick,modifier,enabled,contentPadding,interactionSource,content)112@3970L160:AndroidMenu.android.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
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
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        i3 |= composerStartRestartGroup.changed(paddingValues) ? 2048 : 1024;
                    }
                    i6 = i2 & 16;
                    if (i6 != 0) {
                        if ((i & 24576) == 0) {
                            i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 16384 : 8192;
                        }
                        if ((196608 & i) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
                        }
                        if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                            Modifier modifier4 = i7 != 0 ? Modifier.INSTANCE : modifier2;
                            boolean z4 = i4 != 0 ? true : z2;
                            PaddingValues dropdownMenuItemContentPadding = i5 != 0 ? MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding() : paddingValues;
                            MutableInteractionSource mutableInteractionSource3 = i6 != 0 ? null : mutableInteractionSource;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(670540513, i3, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:112)");
                            }
                            MenuKt.DropdownMenuItemContent(function0, modifier4, z4, dropdownMenuItemContentPadding, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 524286, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z3 = z4;
                            paddingValues2 = dropdownMenuItemContentPadding;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            paddingValues2 = paddingValues;
                            modifier3 = modifier2;
                            z3 = z2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function0, modifier3, z3, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 24576;
                    if ((196608 & i) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                }
                if ((196608 & i) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            if ((196608 & i) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        if ((196608 & i) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit DropdownMenuItem$lambda$0(Function0 function0, Modifier modifier, boolean z, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        DropdownMenuItem(function0, modifier, z, paddingValues, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenu_4kj__NE$lambda$2$0(MutableState mutableState, IntRect intRect, IntRect intRect2) {
        mutableState.setValue(TransformOrigin.m6725boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenu_4kj__NE$lambda$3(MutableTransitionState mutableTransitionState, MutableState mutableState, ScrollState scrollState, Modifier modifier, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C92@3434L259:AndroidMenu.android.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1788768427, i, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:92)");
            }
            MenuKt.DropdownMenuContent(mutableTransitionState, mutableState, scrollState, modifier, function3, composer, MutableTransitionState.$stable | 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenu_4kj__NE$lambda$4(boolean z, Function0 function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2902DropdownMenu4kj_NE(z, function0, modifier, j, scrollState, popupProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenu_ILWXrKs$lambda$0(boolean z, Function0 function0, Modifier modifier, long j, PopupProperties popupProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2903DropdownMenuILWXrKs(z, function0, modifier, j, popupProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final PopupProperties getDefaultMenuProperties() {
        return DefaultMenuProperties;
    }
}
