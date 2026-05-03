package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.DropdownMenuPositionProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u009f\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007¢\u0006\u0004\b \u0010!\u001a\u0090\u0001\u0010\"\u001a\u00020\u00012\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u001a2\u0015\b\u0002\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u001a2\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0007¢\u0006\u0002\u0010.\"\u0014\u0010/\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u00062"}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/unit/DpOffset;", "scrollState", "Landroidx/compose/foundation/ScrollState;", DiagnosticsEntry.PROPERTIES_KEY, "Landroidx/compose/ui/window/PopupProperties;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-IlH_yew", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Landroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "text", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "DefaultMenuProperties", "getDefaultMenuProperties", "()Landroidx/compose/ui/window/PopupProperties;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidMenu_androidKt {
    private static final PopupProperties DefaultMenuProperties = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);

    /* JADX WARN: Removed duplicated region for block: B:109:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ee  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with parameters for shape, color, elevation, and border.", replaceWith = @ReplaceWith(expression = "DropdownMenu(\n    expanded = expanded,\n    onDismissRequest = onDismissRequest,\n    modifier = modifier,\n    offset = offset,\n    scrollState = scrollState,\n    properties = properties,\n    shape = MenuDefaults.shape,\n    containerColor = MenuDefaults.containerColor,\n    tonalElevation = MenuDefaults.TonalElevation,\n    shadowElevation = MenuDefaults.ShadowElevation,\n    border = null,\n    content = content,\n)", imports = {}))
    /* JADX INFO: renamed from: DropdownMenu-4kj-_NE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3283DropdownMenu4kj_NE(final boolean z, final Function0 function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, final Function3 function3, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        Function0 function02;
        Modifier modifier2;
        int i4;
        long jM9170constructorimpl;
        ScrollState scrollStateRememberScrollState;
        int i5;
        PopupProperties popupProperties2;
        int i6;
        Composer composer2;
        final Modifier modifier3;
        final long j2;
        final ScrollState scrollState2;
        final PopupProperties popupProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        Modifier modifier4;
        int i8;
        ScrollState scrollState3;
        PopupProperties popupProperties4;
        int i9;
        Modifier modifier5;
        long j3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1518067413);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenu)N(expanded,onDismissRequest,modifier,offset:c#ui.unit.DpOffset,scrollState,properties,content)130@4963L5,131@5008L14,123@4724L465:AndroidMenu.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
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
                    jM9170constructorimpl = j;
                    i3 |= composerStartRestartGroup.changed(jM9170constructorimpl) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        scrollStateRememberScrollState = scrollState;
                        int i11 = composerStartRestartGroup.changed(scrollStateRememberScrollState) ? 16384 : 8192;
                        i3 |= i11;
                    } else {
                        scrollStateRememberScrollState = scrollState;
                    }
                    i3 |= i11;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i) == 0) {
                        popupProperties2 = popupProperties;
                        i3 |= composerStartRestartGroup.changed(popupProperties2) ? 131072 : 65536;
                    }
                    if ((i2 & 64) != 0) {
                        if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                        }
                        i6 = i3;
                        if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i6 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "119@4575L21");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i10 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    float fM9114constructorimpl = Dp.m9114constructorimpl(0.0f);
                                    float fM9114constructorimpl2 = Dp.m9114constructorimpl(0.0f);
                                    long jFloatToRawIntBits = Float.floatToRawIntBits(fM9114constructorimpl);
                                    i7 = -57345;
                                    modifier4 = modifier2;
                                    jM9170constructorimpl = DpOffset.m9170constructorimpl((((long) Float.floatToRawIntBits(fM9114constructorimpl2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (jFloatToRawIntBits << 32));
                                } else {
                                    i7 = -57345;
                                    modifier4 = modifier2;
                                }
                                if ((i2 & 16) != 0) {
                                    i8 = i6 & i7;
                                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                } else {
                                    i8 = i6;
                                }
                                if (i5 != 0) {
                                    j3 = jM9170constructorimpl;
                                    scrollState3 = scrollStateRememberScrollState;
                                    popupProperties4 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                                    i9 = 1518067413;
                                    modifier5 = modifier4;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i9, i8, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:123)");
                                    }
                                    composer2 = composerStartRestartGroup;
                                    m3285DropdownMenuIlH_yew(z2, function02, modifier5, j3, scrollState3, popupProperties4, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3811getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3810getShadowElevationD9Ej5fM(), null, function3, composer2, (i8 & 14) | 905969664 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8), ((i8 >> 15) & 112) | 6, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier5;
                                    j2 = j3;
                                    scrollState2 = scrollState3;
                                    popupProperties3 = popupProperties4;
                                } else {
                                    scrollState3 = scrollStateRememberScrollState;
                                    popupProperties4 = popupProperties2;
                                    i9 = 1518067413;
                                    modifier5 = modifier4;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i8 = i6 & (-57345);
                                    scrollState3 = scrollStateRememberScrollState;
                                    popupProperties4 = popupProperties2;
                                } else {
                                    scrollState3 = scrollStateRememberScrollState;
                                    popupProperties4 = popupProperties2;
                                    i8 = i6;
                                }
                                i9 = 1518067413;
                                modifier5 = modifier2;
                            }
                            j3 = jM9170constructorimpl;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = composerStartRestartGroup;
                            m3285DropdownMenuIlH_yew(z2, function02, modifier5, j3, scrollState3, popupProperties4, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3811getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3810getShadowElevationD9Ej5fM(), null, function3, composer2, (i8 & 14) | 905969664 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8), ((i8 >> 15) & 112) | 6, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier5;
                            j2 = j3;
                            scrollState2 = scrollState3;
                            popupProperties3 = popupProperties4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            j2 = jM9170constructorimpl;
                            scrollState2 = scrollStateRememberScrollState;
                            popupProperties3 = popupProperties2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$5(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 1572864;
                    i6 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                popupProperties2 = popupProperties;
                if ((i2 & 64) != 0) {
                }
                i6 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            jM9170constructorimpl = j;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            popupProperties2 = popupProperties;
            if ((i2 & 64) != 0) {
            }
            i6 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
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
        if (i5 != 0) {
        }
        popupProperties2 = popupProperties;
        if ((i2 & 64) != 0) {
        }
        i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @ReplaceWith(expression = "DropdownMenu(expanded,onDismissRequest, modifier, offset, rememberScrollState(), properties, content)", imports = {"androidx.compose.foundation.rememberScrollState"}))
    /* JADX INFO: renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3284DropdownMenuILWXrKs(final boolean z, final Function0 function0, Modifier modifier, long j, PopupProperties popupProperties, final Function3 function3, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        Function0 function02;
        Modifier modifier2;
        int i4;
        int i5;
        Function3 function32;
        Composer composer2;
        final PopupProperties popupProperties2;
        final Modifier modifier3;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composer3;
        long jM9170constructorimpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(1744198621);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenu)N(expanded,onDismissRequest,modifier,offset:c#ui.unit.DpOffset,properties,content)163@6066L21,158@5902L252:AndroidMenu.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
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
            if (i5 == 0) {
                i3 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    i3 |= composerStartRestartGroup.changed(popupProperties) ? 16384 : 8192;
                }
                if ((i2 & 32) == 0) {
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        function32 = function3;
                        i3 |= composerStartRestartGroup.changedInstance(function32) ? 131072 : 65536;
                    }
                    if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        popupProperties2 = popupProperties;
                        modifier3 = modifier2;
                        j2 = j;
                    } else {
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
                            ComposerKt.traceEventStart(1744198621, i3, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:158)");
                        }
                        Composer composer4 = composer3;
                        composer2 = composer4;
                        m3285DropdownMenuIlH_yew(z2, function02, modifier4, jM9170constructorimpl, ScrollKt.rememberScrollState(0, composer4, 0, 1), popupProperties3, null, 0L, 0.0f, 0.0f, null, function32, composer2, (i3 & 8190) | ((i3 << 3) & 458752), (i3 >> 12) & 112, 1984);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        j2 = jM9170constructorimpl;
                        popupProperties2 = popupProperties3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_ILWXrKs$lambda$6(z, function0, modifier3, j2, popupProperties2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function32 = function3;
                if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            if ((i2 & 32) == 0) {
            }
            function32 = function3;
            if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        function32 = function3;
        if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:216:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0120  */
    /* JADX INFO: renamed from: DropdownMenu-IlH_yew, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3285DropdownMenuIlH_yew(final boolean z, final Function0<Unit> function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, Shape shape, long j2, float f, float f2, BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function0<Unit> function02;
        int i5;
        Modifier modifier2;
        int i6;
        long jM9170constructorimpl;
        int i7;
        int i8;
        PopupProperties popupProperties2;
        Shape shape2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Composer composer2;
        final ScrollState scrollState2;
        final float f3;
        final long j3;
        final Modifier modifier3;
        final Shape shape3;
        final long j4;
        final float f4;
        final BorderStroke borderStroke2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ScrollState scrollStateRememberScrollState;
        Shape shape4;
        long containerColor;
        final BorderStroke borderStroke3;
        final Modifier modifier4;
        final Shape shape5;
        final ScrollState scrollState3;
        final long j5;
        final float f5;
        final float f6;
        boolean z2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1725609375);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenu)N(expanded,onDismissRequest,modifier,offset:c#ui.unit.DpOffset,scrollState,properties,shape,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,content)55@2074L42:AndroidMenu.android.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                function02 = function0;
                i4 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
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
                    jM9170constructorimpl = j;
                    i7 = 32;
                } else {
                    jM9170constructorimpl = j;
                    i7 = 32;
                    if ((i & 3072) == 0) {
                        i4 |= composerStartRestartGroup.changed(jM9170constructorimpl) ? 2048 : 1024;
                    }
                }
                if ((i & 24576) == 0) {
                    i4 |= ((i3 & 16) == 0 && composerStartRestartGroup.changed(scrollState)) ? 16384 : 8192;
                }
                i8 = i3 & 32;
                if (i8 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    popupProperties2 = popupProperties;
                } else {
                    popupProperties2 = popupProperties;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= composerStartRestartGroup.changed(popupProperties2) ? 131072 : 65536;
                    }
                }
                if ((i & 1572864) == 0) {
                    shape2 = shape;
                    i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(shape2)) ? 1048576 : 524288;
                } else {
                    shape2 = shape;
                }
                if ((i & 12582912) == 0) {
                    i4 |= ((i3 & 128) == 0 && composerStartRestartGroup.changed(j2)) ? 8388608 : 4194304;
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i4 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
                }
                i10 = i3 & 512;
                if (i10 == 0) {
                    if ((i & 805306368) == 0) {
                        i11 = i10;
                        i4 |= composerStartRestartGroup.changed(f2) ? 536870912 : 268435456;
                    }
                    i12 = i3 & 1024;
                    if (i12 == 0) {
                        i14 = i2 | 6;
                        i13 = i12;
                    } else if ((i2 & 6) == 0) {
                        i13 = i12;
                        i14 = i2 | (composerStartRestartGroup.changed(borderStroke) ? 4 : 2);
                    } else {
                        i13 = i12;
                        i14 = i2;
                    }
                    if ((i3 & 2048) == 0) {
                        i14 |= 48;
                    } else if ((i2 & 48) == 0) {
                        i14 |= composerStartRestartGroup.changedInstance(function3) ? i7 : 16;
                    }
                    i15 = i14;
                    if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 19) != 18, i4 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        scrollState2 = scrollState;
                        f3 = f2;
                        j3 = jM9170constructorimpl;
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j4 = j2;
                        f4 = f;
                        borderStroke2 = borderStroke;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "178@6461L21,182@6573L5,184@6621L14");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i6 != 0) {
                                jM9170constructorimpl = DpOffset.m9170constructorimpl((((long) Float.floatToRawIntBits(Dp.m9114constructorimpl(0.0f))) << i7) | (((long) Float.floatToRawIntBits(Dp.m9114constructorimpl(0.0f))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                            }
                            if ((i3 & 16) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i4 &= -57345;
                            } else {
                                scrollStateRememberScrollState = scrollState;
                            }
                            if (i8 != 0) {
                                popupProperties2 = DefaultMenuProperties;
                            }
                            if ((i3 & 64) != 0) {
                                shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i4 &= -3670017;
                            } else {
                                shape4 = shape2;
                            }
                            if ((i3 & 128) != 0) {
                                containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -29360129;
                            } else {
                                containerColor = j2;
                            }
                            float fM3811getTonalElevationD9Ej5fM = i9 != 0 ? MenuDefaults.INSTANCE.m3811getTonalElevationD9Ej5fM() : f;
                            float fM3810getShadowElevationD9Ej5fM = i11 != 0 ? MenuDefaults.INSTANCE.m3810getShadowElevationD9Ej5fM() : f2;
                            if (i13 != 0) {
                                modifier4 = companion;
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                                modifier4 = companion;
                            }
                            shape5 = shape4;
                            scrollState3 = scrollStateRememberScrollState;
                            j5 = containerColor;
                            f5 = fM3811getTonalElevationD9Ej5fM;
                            f6 = fM3810getShadowElevationD9Ej5fM;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                            }
                            scrollState3 = scrollState;
                            j5 = j2;
                            f5 = f;
                            f6 = f2;
                            borderStroke3 = borderStroke;
                            modifier4 = modifier2;
                            shape5 = shape2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1725609375, i4, i15, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:54)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245993, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            z2 = false;
                            objRememberedValue = new MutableTransitionState(false);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            z2 = false;
                        }
                        final MutableTransitionState mutableTransitionState = (MutableTransitionState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                        if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue() || ((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
                            composerStartRestartGroup.startReplaceGroup(1165905588);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "59@2261L51,60@2348L7,62@2404L251,72@2827L494,68@2665L656");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251986, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256762, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            if ((i4 & 7168) == 2048) {
                                z2 = true;
                            }
                            boolean zChanged = z2 | composerStartRestartGroup.changed(density);
                            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9170constructorimpl, density, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3$lambda$2(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function02, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i16) {
                                    ComposerKt.sourceInformation(composer3, "C73@2841L470:AndroidMenu.android.kt#uh7d8r");
                                    if (!composer3.shouldExecute((i16 & 3) != 2, i16 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-917492520, i16, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:73)");
                                    }
                                    MenuKt.m3824DropdownMenuContentQj0Zi0g(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j5, f5, f6, borderStroke3, function3, composer3, (MutableTransitionState.$stable << 3) | 384);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072 | ((i4 >> 9) & 896), 0);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1166965571);
                            composerStartRestartGroup.endReplaceGroup();
                            composer2 = composerStartRestartGroup;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j3 = jM9170constructorimpl;
                        modifier3 = modifier4;
                        scrollState2 = scrollState3;
                        shape3 = shape5;
                        j4 = j5;
                        f4 = f5;
                        f3 = f6;
                        borderStroke2 = borderStroke3;
                    }
                    final PopupProperties popupProperties3 = popupProperties2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, j3, scrollState2, popupProperties3, shape3, j4, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= 805306368;
                i11 = i10;
                i12 = i3 & 1024;
                if (i12 == 0) {
                }
                if ((i3 & 2048) == 0) {
                }
                i15 = i14;
                if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 19) != 18, i4 & 1)) {
                }
                final PopupProperties popupProperties32 = popupProperties2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            if ((i & 24576) == 0) {
            }
            i8 = i3 & 32;
            if (i8 != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i9 = i3 & 256;
            if (i9 != 0) {
            }
            i10 = i3 & 512;
            if (i10 == 0) {
            }
            i11 = i10;
            i12 = i3 & 1024;
            if (i12 == 0) {
            }
            if ((i3 & 2048) == 0) {
            }
            i15 = i14;
            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 19) != 18, i4 & 1)) {
            }
            final PopupProperties popupProperties322 = popupProperties2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function02 = function0;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        if ((i & 24576) == 0) {
        }
        i8 = i3 & 32;
        if (i8 != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i9 = i3 & 256;
        if (i9 != 0) {
        }
        i10 = i3 & 512;
        if (i10 == 0) {
        }
        i11 = i10;
        i12 = i3 & 1024;
        if (i12 == 0) {
        }
        if ((i3 & 2048) == 0) {
        }
        i15 = i14;
        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 19) != 18, i4 & 1)) {
        }
        final PopupProperties popupProperties3222 = popupProperties2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DropdownMenuItem(final Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i3;
        Function0<Unit> function02;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i6;
        boolean z2;
        MenuItemColors menuItemColorsItemColors;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final boolean z3;
        final MenuItemColors menuItemColors2;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i12;
        MutableInteractionSource mutableInteractionSource3;
        PaddingValues paddingValues3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-532959117);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItem)N(text,onClick,modifier,leadingIcon,trailingIcon,enabled,colors,contentPadding,interactionSource)180@6512L319:AndroidMenu.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function24 = function2;
        } else {
            function24 = function2;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(function24) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        int i13 = i2 & 4;
        if (i13 != 0) {
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
                            z2 = z;
                            i3 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
                        }
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                menuItemColorsItemColors = menuItemColors;
                                int i14 = composerStartRestartGroup.changed(menuItemColorsItemColors) ? 1048576 : 524288;
                                i3 |= i14;
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                            }
                            i3 |= i14;
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                        }
                        i7 = i2 & 128;
                        if (i7 != 0) {
                            i3 |= 12582912;
                        } else {
                            if ((i & 12582912) == 0) {
                                i8 = i7;
                                i3 |= composerStartRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                            }
                            i9 = i2 & 256;
                            if (i9 != 0) {
                                if ((i & 100663296) == 0) {
                                    i10 = i9;
                                    i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                                }
                                i11 = i3;
                                if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i11 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "194@8776L12");
                                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i13 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i4 != 0) {
                                            function25 = null;
                                        }
                                        if (i5 != 0) {
                                            function26 = null;
                                        }
                                        if (i6 != 0) {
                                            z2 = true;
                                        }
                                        if ((i2 & 64) != 0) {
                                            i12 = i11 & (-3670017);
                                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                        } else {
                                            i12 = i11;
                                        }
                                        PaddingValues dropdownMenuItemContentPadding = i8 != 0 ? MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding() : paddingValues;
                                        mutableInteractionSource3 = i10 != 0 ? null : mutableInteractionSource;
                                        paddingValues3 = dropdownMenuItemContentPadding;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i2 & 64) != 0) {
                                            i12 = i11 & (-3670017);
                                            paddingValues3 = paddingValues;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                        } else {
                                            paddingValues3 = paddingValues;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                            i12 = i11;
                                        }
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function29 = function26;
                                    boolean z4 = z2;
                                    MenuItemColors menuItemColors3 = menuItemColorsItemColors;
                                    Modifier modifier4 = modifier2;
                                    Function2<? super Composer, ? super Integer, Unit> function210 = function25;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-532959117, i12, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:179)");
                                    }
                                    composer2 = composerStartRestartGroup;
                                    MenuKt.DropdownMenuItemContent(function24, function02, modifier4, function210, function29, z4, menuItemColors3, paddingValues3, mutableInteractionSource3, composer2, i12 & 268435454);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    function27 = function210;
                                    function28 = function29;
                                    z3 = z4;
                                    menuItemColors2 = menuItemColors3;
                                    paddingValues2 = paddingValues3;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    modifier3 = modifier2;
                                    function27 = function25;
                                    function28 = function26;
                                    z3 = z2;
                                    menuItemColors2 = menuItemColorsItemColors;
                                    paddingValues2 = paddingValues;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$7(function2, function0, modifier3, function27, function28, z3, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i3 |= 100663296;
                            i10 = i9;
                            i11 = i3;
                            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i11 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i8 = i7;
                        i9 = i2 & 256;
                        if (i9 != 0) {
                        }
                        i10 = i9;
                        i11 = i3;
                        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i11 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    z2 = z;
                    if ((1572864 & i) == 0) {
                    }
                    i7 = i2 & 128;
                    if (i7 != 0) {
                    }
                    i8 = i7;
                    i9 = i2 & 256;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    i11 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i11 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function26 = function23;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                z2 = z;
                if ((1572864 & i) == 0) {
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                }
                i8 = i7;
                i9 = i2 & 256;
                if (i9 != 0) {
                }
                i10 = i9;
                i11 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i11 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
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
            z2 = z;
            if ((1572864 & i) == 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            i9 = i2 & 256;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i11 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
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
        z2 = z;
        if ((1572864 & i) == 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i2 & 256;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i11 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit DropdownMenuItem$lambda$7(Function2 function2, Function0 function0, Modifier modifier, Function2 function22, Function2 function23, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        DropdownMenuItem(function2, function0, modifier, function22, function23, z, menuItemColors, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenu_4kj__NE$lambda$5(boolean z, Function0 function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3283DropdownMenu4kj_NE(z, function0, modifier, j, scrollState, popupProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenu_ILWXrKs$lambda$6(boolean z, Function0 function0, Modifier modifier, long j, PopupProperties popupProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3284DropdownMenuILWXrKs(z, function0, modifier, j, popupProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenu_IlH_yew$lambda$3$lambda$2(MutableState mutableState, IntRect intRect, IntRect intRect2) {
        mutableState.setValue(TransformOrigin.m6725boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenu_IlH_yew$lambda$4(boolean z, Function0 function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, Shape shape, long j2, float f, float f2, BorderStroke borderStroke, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m3285DropdownMenuIlH_yew(z, function0, modifier, j, scrollState, popupProperties, shape, j2, f, f2, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    public static final PopupProperties getDefaultMenuProperties() {
        return DefaultMenuProperties;
    }
}
