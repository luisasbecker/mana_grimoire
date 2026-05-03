package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.internal.ChildParentSemanticsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IconButton.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u001aX\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000e\u001ab\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0011\u001aX\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0003¢\u0006\u0002\u0010\u0013\u001af\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00182\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0019\u001ap\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00182\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001a\u001ap\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00182\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0003¢\u0006\u0002\u0010\u001a\u001ab\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001d\u001ap\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\u00182\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001f\u001ab\u0010 \u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001d\u001ap\u0010!\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\u00182\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001f\u001an\u0010\"\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010%\u001a|\u0010&\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\u00182\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010'\u001ab\u0010(\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0003¢\u0006\u0002\u0010)\u001ap\u0010*\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0003¢\u0006\u0002\u0010+¨\u0006,"}, d2 = {"IconButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "colors", "Landroidx/compose/material3/IconButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "shape", "Landroidx/compose/ui/graphics/Shape;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconButtonImpl", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "IconToggleButton", "checked", "onCheckedChange", "Lkotlin/Function1;", "Landroidx/compose/material3/IconToggleButtonColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconToggleButtonImpl", "FilledIconButton", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FilledIconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FilledTonalIconButton", "FilledTonalIconToggleButton", "OutlinedIconButton", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OutlinedIconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SurfaceIconButton", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SurfaceIconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IconButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:119:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledIconButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape filledShape;
        IconButtonColors iconButtonColorsFilledIconButtonColors;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final Modifier modifier3;
        final boolean z3;
        final Shape shape2;
        final IconButtonColors iconButtonColors2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z4;
        Shape shape3;
        MutableInteractionSource mutableInteractionSource4;
        IconButtonColors iconButtonColors3;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(947208840);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilledIconButton)N(onClick,modifier,enabled,shape,colors,interactionSource,content)385@16887L252:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
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
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        filledShape = shape;
                        int i7 = composerStartRestartGroup.changed(filledShape) ? 2048 : 1024;
                        i3 |= i7;
                    } else {
                        filledShape = shape;
                    }
                    i3 |= i7;
                } else {
                    filledShape = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        iconButtonColorsFilledIconButtonColors = iconButtonColors;
                        int i8 = composerStartRestartGroup.changed(iconButtonColorsFilledIconButtonColors) ? 16384 : 8192;
                        i3 |= i8;
                    } else {
                        iconButtonColorsFilledIconButtonColors = iconButtonColors;
                    }
                    i3 |= i8;
                } else {
                    iconButtonColorsFilledIconButtonColors = iconButtonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                    }
                    if ((i2 & 64) != 0) {
                        if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                        }
                        if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "380@16696L11,381@16759L24");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                                }
                                if (i5 != 0) {
                                    mutableInteractionSource4 = null;
                                    z4 = z2;
                                    shape3 = filledShape;
                                } else {
                                    z4 = z2;
                                    shape3 = filledShape;
                                    mutableInteractionSource4 = mutableInteractionSource2;
                                }
                                iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                                modifier4 = companion;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                z4 = z2;
                                shape3 = filledShape;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                                modifier4 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(947208840, i3, -1, "androidx.compose.material3.FilledIconButton (IconButton.kt:385)");
                            }
                            int i9 = (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3);
                            int i10 = i3 << 3;
                            composer2 = composerStartRestartGroup;
                            SurfaceIconButton(function02, modifier4, z4, shape3, iconButtonColors3, null, mutableInteractionSource4, function2, composer2, i9 | (3670016 & i10) | (i10 & 29360128));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z3 = z4;
                            shape2 = shape3;
                            iconButtonColors2 = iconButtonColors3;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            z3 = z2;
                            shape2 = filledShape;
                            iconButtonColors2 = iconButtonColorsFilledIconButtonColors;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return IconButtonKt.FilledIconButton$lambda$10(function0, modifier3, z3, shape2, iconButtonColors2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 1572864;
                    if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 64) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 64) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 64) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit FilledIconButton$lambda$10(Function0 function0, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        FilledIconButton(function0, modifier, z, shape, iconButtonColors, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledIconToggleButton(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, Shape shape, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        Function1<? super Boolean, Unit> function12;
        Modifier modifier2;
        int i4;
        boolean z4;
        Shape filledShape;
        IconToggleButtonColors iconToggleButtonColorsFilledIconToggleButtonColors;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        int i6;
        Composer composer2;
        final Modifier modifier3;
        final boolean z5;
        final Shape shape2;
        final IconToggleButtonColors iconToggleButtonColors2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        MutableInteractionSource mutableInteractionSource4;
        boolean z6;
        Shape shape3;
        int i7;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-713829427);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilledIconToggleButton)N(checked,onCheckedChange,modifier,enabled,shape,colors,interactionSource,content)441@19585L24,438@19452L336:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
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
                    z4 = z2;
                    i3 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        filledShape = shape;
                        int i9 = composerStartRestartGroup.changed(filledShape) ? 16384 : 8192;
                        i3 |= i9;
                    } else {
                        filledShape = shape;
                    }
                    i3 |= i9;
                } else {
                    filledShape = shape;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        iconToggleButtonColorsFilledIconToggleButtonColors = iconToggleButtonColors;
                        int i10 = composerStartRestartGroup.changed(iconToggleButtonColorsFilledIconToggleButtonColors) ? 131072 : 65536;
                        i3 |= i10;
                    } else {
                        iconToggleButtonColorsFilledIconToggleButtonColors = iconToggleButtonColors;
                    }
                    i3 |= i10;
                } else {
                    iconToggleButtonColorsFilledIconToggleButtonColors = iconToggleButtonColors;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else {
                    if ((i & 1572864) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                    }
                    if ((i2 & 128) != 0) {
                        if ((i & 12582912) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                        }
                        i6 = i3;
                        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "433@19249L11,434@19318L30");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                companion = i8 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i6 &= -57345;
                                    filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    iconToggleButtonColorsFilledIconToggleButtonColors = IconButtonDefaults.INSTANCE.filledIconToggleButtonColors(composerStartRestartGroup, 6);
                                    i6 &= -458753;
                                }
                                if (i5 != 0) {
                                    mutableInteractionSource4 = null;
                                    z6 = z4;
                                    shape3 = filledShape;
                                    i7 = i6;
                                }
                                IconToggleButtonColors iconToggleButtonColors3 = iconToggleButtonColorsFilledIconToggleButtonColors;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-713829427, i7, -1, "androidx.compose.material3.FilledIconToggleButton (IconButton.kt:438)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1204705317, "CC(remember):IconButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return IconButtonKt.FilledIconToggleButton$lambda$12$lambda$11((SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                int i11 = i7 << 3;
                                composer2 = composerStartRestartGroup;
                                SurfaceIconToggleButton(z3, function12, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), z6, shape3, iconToggleButtonColors3, null, mutableInteractionSource4, function2, composer2, (i7 & 14) | 1572864 | (i7 & 112) | (i7 & 7168) | (57344 & i7) | (458752 & i7) | (29360128 & i11) | (i11 & 234881024));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = companion;
                                z5 = z6;
                                shape2 = shape3;
                                iconToggleButtonColors2 = iconToggleButtonColors3;
                                mutableInteractionSource3 = mutableInteractionSource4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i6 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i6 &= -458753;
                                }
                                companion = modifier2;
                            }
                            z6 = z4;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            i7 = i6;
                            shape3 = filledShape;
                            IconToggleButtonColors iconToggleButtonColors32 = iconToggleButtonColorsFilledIconToggleButtonColors;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1204705317, "CC(remember):IconButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i112 = i7 << 3;
                            composer2 = composerStartRestartGroup;
                            SurfaceIconToggleButton(z3, function12, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), z6, shape3, iconToggleButtonColors32, null, mutableInteractionSource4, function2, composer2, (i7 & 14) | 1572864 | (i7 & 112) | (i7 & 7168) | (57344 & i7) | (458752 & i7) | (29360128 & i112) | (i112 & 234881024));
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = companion;
                            z5 = z6;
                            shape2 = shape3;
                            iconToggleButtonColors2 = iconToggleButtonColors32;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            z5 = z4;
                            shape2 = filledShape;
                            iconToggleButtonColors2 = iconToggleButtonColorsFilledIconToggleButtonColors;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return IconButtonKt.FilledIconToggleButton$lambda$13(z, function1, modifier3, z5, shape2, iconToggleButtonColors2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 12582912;
                    i6 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 128) != 0) {
                }
                i6 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z2;
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) != 0) {
            }
            i6 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z4 = z2;
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) != 0) {
        }
        i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit FilledIconToggleButton$lambda$12$lambda$11(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8329getCheckboxo7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit FilledIconToggleButton$lambda$13(boolean z, Function1 function1, Modifier modifier, boolean z2, Shape shape, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        FilledIconToggleButton(z, function1, modifier, z2, shape, iconToggleButtonColors, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledTonalIconButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape filledShape;
        IconButtonColors iconButtonColorsFilledTonalIconButtonColors;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final Modifier modifier3;
        final boolean z3;
        final Shape shape2;
        final IconButtonColors iconButtonColors2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z4;
        Shape shape3;
        MutableInteractionSource mutableInteractionSource4;
        IconButtonColors iconButtonColors3;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-399178234);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilledTonalIconButton)N(onClick,modifier,enabled,shape,colors,interactionSource,content)495@22273L252:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
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
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        filledShape = shape;
                        int i7 = composerStartRestartGroup.changed(filledShape) ? 2048 : 1024;
                        i3 |= i7;
                    } else {
                        filledShape = shape;
                    }
                    i3 |= i7;
                } else {
                    filledShape = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        iconButtonColorsFilledTonalIconButtonColors = iconButtonColors;
                        int i8 = composerStartRestartGroup.changed(iconButtonColorsFilledTonalIconButtonColors) ? 16384 : 8192;
                        i3 |= i8;
                    } else {
                        iconButtonColorsFilledTonalIconButtonColors = iconButtonColors;
                    }
                    i3 |= i8;
                } else {
                    iconButtonColorsFilledTonalIconButtonColors = iconButtonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                    }
                    if ((i2 & 64) != 0) {
                        if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                        }
                        if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "490@22077L11,491@22140L29");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    iconButtonColorsFilledTonalIconButtonColors = IconButtonDefaults.INSTANCE.filledTonalIconButtonColors(composerStartRestartGroup, 6);
                                }
                                if (i5 != 0) {
                                    mutableInteractionSource4 = null;
                                    z4 = z2;
                                    shape3 = filledShape;
                                } else {
                                    z4 = z2;
                                    shape3 = filledShape;
                                    mutableInteractionSource4 = mutableInteractionSource2;
                                }
                                iconButtonColors3 = iconButtonColorsFilledTonalIconButtonColors;
                                modifier4 = companion;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                z4 = z2;
                                shape3 = filledShape;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                iconButtonColors3 = iconButtonColorsFilledTonalIconButtonColors;
                                modifier4 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-399178234, i3, -1, "androidx.compose.material3.FilledTonalIconButton (IconButton.kt:495)");
                            }
                            int i9 = (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3);
                            int i10 = i3 << 3;
                            composer2 = composerStartRestartGroup;
                            SurfaceIconButton(function02, modifier4, z4, shape3, iconButtonColors3, null, mutableInteractionSource4, function2, composer2, i9 | (3670016 & i10) | (i10 & 29360128));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z3 = z4;
                            shape2 = shape3;
                            iconButtonColors2 = iconButtonColors3;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            z3 = z2;
                            shape2 = filledShape;
                            iconButtonColors2 = iconButtonColorsFilledTonalIconButtonColors;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return IconButtonKt.FilledTonalIconButton$lambda$14(function0, modifier3, z3, shape2, iconButtonColors2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 1572864;
                    if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 64) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 64) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 64) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit FilledTonalIconButton$lambda$14(Function0 function0, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        FilledTonalIconButton(function0, modifier, z, shape, iconButtonColors, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledTonalIconToggleButton(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, Shape shape, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        Function1<? super Boolean, Unit> function12;
        Modifier modifier2;
        int i4;
        boolean z4;
        Shape filledShape;
        IconToggleButtonColors iconToggleButtonColorsFilledTonalIconToggleButtonColors;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        int i6;
        Composer composer2;
        final Modifier modifier3;
        final boolean z5;
        final Shape shape2;
        final IconToggleButtonColors iconToggleButtonColors2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        MutableInteractionSource mutableInteractionSource4;
        boolean z6;
        Shape shape3;
        int i7;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-436409269);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilledTonalIconToggleButton)N(checked,onCheckedChange,modifier,enabled,shape,colors,interactionSource,content)557@25342L24,554@25209L336:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
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
                    z4 = z2;
                    i3 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        filledShape = shape;
                        int i9 = composerStartRestartGroup.changed(filledShape) ? 16384 : 8192;
                        i3 |= i9;
                    } else {
                        filledShape = shape;
                    }
                    i3 |= i9;
                } else {
                    filledShape = shape;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        iconToggleButtonColorsFilledTonalIconToggleButtonColors = iconToggleButtonColors;
                        int i10 = composerStartRestartGroup.changed(iconToggleButtonColorsFilledTonalIconToggleButtonColors) ? 131072 : 65536;
                        i3 |= i10;
                    } else {
                        iconToggleButtonColorsFilledTonalIconToggleButtonColors = iconToggleButtonColors;
                    }
                    i3 |= i10;
                } else {
                    iconToggleButtonColorsFilledTonalIconToggleButtonColors = iconToggleButtonColors;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else {
                    if ((i & 1572864) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                    }
                    if ((i2 & 128) != 0) {
                        if ((i & 12582912) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                        }
                        i6 = i3;
                        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "549@25001L11,550@25070L35");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                companion = i8 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i6 &= -57345;
                                    filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    iconToggleButtonColorsFilledTonalIconToggleButtonColors = IconButtonDefaults.INSTANCE.filledTonalIconToggleButtonColors(composerStartRestartGroup, 6);
                                    i6 &= -458753;
                                }
                                if (i5 != 0) {
                                    mutableInteractionSource4 = null;
                                    z6 = z4;
                                    shape3 = filledShape;
                                    i7 = i6;
                                }
                                IconToggleButtonColors iconToggleButtonColors3 = iconToggleButtonColorsFilledTonalIconToggleButtonColors;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-436409269, i7, -1, "androidx.compose.material3.FilledTonalIconToggleButton (IconButton.kt:554)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1517505123, "CC(remember):IconButton.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return IconButtonKt.FilledTonalIconToggleButton$lambda$16$lambda$15((SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                int i11 = i7 << 3;
                                composer2 = composerStartRestartGroup;
                                SurfaceIconToggleButton(z3, function12, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), z6, shape3, iconToggleButtonColors3, null, mutableInteractionSource4, function2, composer2, (i7 & 14) | 1572864 | (i7 & 112) | (i7 & 7168) | (57344 & i7) | (458752 & i7) | (29360128 & i11) | (i11 & 234881024));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = companion;
                                z5 = z6;
                                shape2 = shape3;
                                iconToggleButtonColors2 = iconToggleButtonColors3;
                                mutableInteractionSource3 = mutableInteractionSource4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i6 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i6 &= -458753;
                                }
                                companion = modifier2;
                            }
                            z6 = z4;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            i7 = i6;
                            shape3 = filledShape;
                            IconToggleButtonColors iconToggleButtonColors32 = iconToggleButtonColorsFilledTonalIconToggleButtonColors;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1517505123, "CC(remember):IconButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i112 = i7 << 3;
                            composer2 = composerStartRestartGroup;
                            SurfaceIconToggleButton(z3, function12, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), z6, shape3, iconToggleButtonColors32, null, mutableInteractionSource4, function2, composer2, (i7 & 14) | 1572864 | (i7 & 112) | (i7 & 7168) | (57344 & i7) | (458752 & i7) | (29360128 & i112) | (i112 & 234881024));
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = companion;
                            z5 = z6;
                            shape2 = shape3;
                            iconToggleButtonColors2 = iconToggleButtonColors32;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            z5 = z4;
                            shape2 = filledShape;
                            iconToggleButtonColors2 = iconToggleButtonColorsFilledTonalIconToggleButtonColors;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return IconButtonKt.FilledTonalIconToggleButton$lambda$17(z, function1, modifier3, z5, shape2, iconToggleButtonColors2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 12582912;
                    i6 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 128) != 0) {
                }
                i6 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z2;
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) != 0) {
            }
            i6 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z4 = z2;
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) != 0) {
        }
        i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit FilledTonalIconToggleButton$lambda$16$lambda$15(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8329getCheckboxo7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit FilledTonalIconToggleButton$lambda$17(boolean z, Function1 function1, Modifier modifier, boolean z2, Shape shape, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        FilledTonalIconToggleButton(z, function1, modifier, z2, shape, iconToggleButtonColors, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IconButton(final Function0<Unit> function0, Modifier modifier, boolean z, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, Shape shape, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        IconButtonColors iconButtonColors2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Shape standardShape;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Composer composer2;
        final Modifier modifier3;
        final boolean z3;
        final IconButtonColors iconButtonColors3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1413012038);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconButton)N(onClick,modifier,enabled,colors,interactionSource,shape,content)151@6684L226:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
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
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        iconButtonColors2 = iconButtonColors;
                        int i7 = composerStartRestartGroup.changed(iconButtonColors2) ? 2048 : 1024;
                        i3 |= i7;
                    } else {
                        iconButtonColors2 = iconButtonColors;
                    }
                    i3 |= i7;
                } else {
                    iconButtonColors2 = iconButtonColors;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            standardShape = shape;
                            int i8 = composerStartRestartGroup.changed(standardShape) ? 131072 : 65536;
                            i3 |= i8;
                        } else {
                            standardShape = shape;
                        }
                        i3 |= i8;
                    } else {
                        standardShape = shape;
                    }
                    if ((i2 & 64) == 0) {
                        i3 |= 1572864;
                        function22 = function2;
                    } else {
                        function22 = function2;
                        if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function22) ? 1048576 : 524288;
                        }
                    }
                    if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z3 = z2;
                        iconButtonColors3 = iconButtonColors2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "146@6509L18,148@6624L13");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                            }
                            if (i5 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                modifier4 = companion;
                                standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                            } else {
                                modifier4 = companion;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            modifier4 = modifier2;
                        }
                        IconButtonColors iconButtonColors4 = iconButtonColors2;
                        MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                        boolean z4 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1413012038, i3, -1, "androidx.compose.material3.IconButton (IconButton.kt:151)");
                        }
                        int i9 = i3 << 3;
                        composer2 = composerStartRestartGroup;
                        IconButtonImpl(modifier4, function02, z4, standardShape, iconButtonColors4, mutableInteractionSource4, function22, composer2, ((i3 >> 3) & 14) | (i9 & 112) | (i3 & 896) | ((i3 >> 6) & 7168) | (57344 & i9) | (i9 & 458752) | (i3 & 3670016));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z3 = z4;
                        iconButtonColors3 = iconButtonColors4;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    }
                    final Shape shape2 = standardShape;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return IconButtonKt.IconButton$lambda$1(function0, modifier3, z3, iconButtonColors3, mutableInteractionSource3, shape2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((196608 & i) != 0) {
                }
                if ((i2 & 64) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                }
                final Shape shape22 = standardShape;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) != 0) {
            }
            if ((i2 & 64) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
            }
            final Shape shape222 = standardShape;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((196608 & i) != 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
        }
        final Shape shape2222 = standardShape;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cb  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with `shape`", replaceWith = @ReplaceWith(expression = "IconButton(onClick, modifier, enabled, colors, interactionSource, shape, content)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void IconButton(final Function0 function0, Modifier modifier, boolean z, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, final Function2 function2, Composer composer, final int i, final int i2) {
        Function0 function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        IconButtonColors iconButtonColors2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Function2 function22;
        final Modifier modifier3;
        final boolean z3;
        final IconButtonColors iconButtonColors3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        IconButtonColors iconButtonColors4;
        Modifier modifier4;
        IconButtonColors iconButtonColors5;
        MutableInteractionSource mutableInteractionSource4;
        boolean z4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2096213317);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconButton)N(onClick,modifier,enabled,colors,interactionSource,content)100@4337L13,94@4203L171:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
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
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        iconButtonColors2 = iconButtonColors;
                        int i7 = composerStartRestartGroup.changed(iconButtonColors2) ? 2048 : 1024;
                        i3 |= i7;
                    } else {
                        iconButtonColors2 = iconButtonColors;
                    }
                    i3 |= i7;
                } else {
                    iconButtonColors2 = iconButtonColors;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    }
                    if ((i2 & 32) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function22 = function2;
                    } else {
                        function22 = function2;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function22) ? 131072 : 65536;
                        }
                    }
                    if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z3 = z2;
                        iconButtonColors3 = iconButtonColors2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "90@4081L18");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                            boolean z5 = i4 == 0 ? z2 : true;
                            if ((i2 & 8) != 0) {
                                iconButtonColors4 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                iconButtonColors4 = iconButtonColors2;
                            }
                            if (i5 != 0) {
                                mutableInteractionSource4 = null;
                                modifier4 = companion;
                                iconButtonColors5 = iconButtonColors4;
                            } else {
                                modifier4 = companion;
                                iconButtonColors5 = iconButtonColors4;
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            z4 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            modifier4 = modifier2;
                            iconButtonColors5 = iconButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            z4 = z2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2096213317, i3, -1, "androidx.compose.material3.IconButton (IconButton.kt:93)");
                        }
                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                        IconButton(function02, modifier4, z4, iconButtonColors5, mutableInteractionSource5, IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6), function22, composerStartRestartGroup, (65534 & i3) | ((i3 << 3) & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z3 = z4;
                        iconButtonColors3 = iconButtonColors5;
                        mutableInteractionSource3 = mutableInteractionSource5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return IconButtonKt.IconButton$lambda$0(function0, modifier3, z3, iconButtonColors3, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 32) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit IconButton$lambda$0(Function0 function0, Modifier modifier, boolean z, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        IconButton(function0, modifier, z, iconButtonColors, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit IconButton$lambda$1(Function0 function0, Modifier modifier, boolean z, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, Shape shape, Function2 function2, int i, int i2, Composer composer, int i3) {
        IconButton(function0, modifier, z, iconButtonColors, mutableInteractionSource, shape, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final void IconButtonImpl(final Modifier modifier, final Function0<Unit> function0, final boolean z, final Shape shape, final IconButtonColors iconButtonColors, final MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        MutableInteractionSource mutableInteractionSource2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1134296466);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconButtonImpl)N(modifier,onClick,enabled,shape,colors,interactionSource,content)174@7337L779:IconButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(iconButtonColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1134296466, i2, -1, "androidx.compose.material3.IconButtonImpl (IconButton.kt:171)");
            }
            if (mutableInteractionSource == null) {
                composerStartRestartGroup.startReplaceGroup(977045485);
                ComposerKt.sourceInformation(composerStartRestartGroup, "173@7293L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 862801589, "CC(remember):IconButton.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(862800938);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource2 = mutableInteractionSource;
            }
            int i3 = i2;
            Modifier modifierChildSemantics$default = ChildParentSemanticsKt.childSemantics$default(ClickableKt.m1514clickableO2vRcR0$default(BackgroundKt.m1482backgroundbw27NRU(ClipKt.clip(SizeKt.m2084size6HolHcs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), IconButtonDefaults.m3706smallContainerSizeNwlBFI$material3$default(IconButtonDefaults.INSTANCE, 0, 1, null)), shape), iconButtonColors.m3699containerColorvNxB06k$material3(z), shape), mutableInteractionSource2, RippleKt.m3978rippleH2RKhps$default(false, 0.0f, 0L, 7, null), z, null, Role.m8320boximpl(Role.INSTANCE.m8327getButtono7Vup1c()), function0, 8, null), null, 1, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierChildSemantics$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -414233073, "C192@8026L84:IconButton.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(iconButtonColors.m3700contentColorvNxB06k$material3(z))), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 15) & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconButtonKt.IconButtonImpl$lambda$4(modifier, function0, z, shape, iconButtonColors, mutableInteractionSource, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit IconButtonImpl$lambda$4(Modifier modifier, Function0 function0, boolean z, Shape shape, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, Composer composer, int i2) {
        IconButtonImpl(modifier, function0, z, shape, iconButtonColors, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IconToggleButton(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, Shape shape, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        Function1<? super Boolean, Unit> function12;
        Modifier modifier2;
        int i4;
        boolean z4;
        IconToggleButtonColors iconToggleButtonColors2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape2;
        int i6;
        Composer composer2;
        final Modifier modifier3;
        final boolean z5;
        final IconToggleButtonColors iconToggleButtonColors3;
        final MutableInteractionSource mutableInteractionSource3;
        final Shape shape3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        IconToggleButtonColors iconToggleButtonColors4;
        MutableInteractionSource mutableInteractionSource4;
        Shape standardShape;
        int i8;
        Modifier modifier4;
        int i9;
        boolean z6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1031402037);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconToggleButton)N(checked,onCheckedChange,modifier,enabled,colors,interactionSource,shape,content)299@13114L275:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
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
                    z4 = z2;
                    i3 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                        int i11 = composerStartRestartGroup.changed(iconToggleButtonColors2) ? 16384 : 8192;
                        i3 |= i11;
                    } else {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                    }
                    i3 |= i11;
                } else {
                    iconToggleButtonColors2 = iconToggleButtonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            shape2 = shape;
                            int i12 = composerStartRestartGroup.changed(shape2) ? 1048576 : 524288;
                            i3 |= i12;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 128) != 0) {
                        if ((i & 12582912) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                        }
                        i6 = i3;
                        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "294@12933L24,296@13054L13");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i7 = i6 & (-57345);
                                    iconToggleButtonColors2 = IconButtonDefaults.INSTANCE.iconToggleButtonColors(composerStartRestartGroup, 6);
                                } else {
                                    i7 = i6;
                                }
                                if (i5 != 0) {
                                    mutableInteractionSource2 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                                    z6 = z4;
                                    iconToggleButtonColors4 = iconToggleButtonColors2;
                                    mutableInteractionSource4 = mutableInteractionSource2;
                                    modifier4 = companion;
                                    i9 = (-3670017) & i7;
                                    i8 = -1031402037;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i8, i9, -1, "androidx.compose.material3.IconToggleButton (IconButton.kt:299)");
                                    }
                                    composer2 = composerStartRestartGroup;
                                    IconToggleButtonImpl(z3, function12, modifier4, z6, iconToggleButtonColors4, mutableInteractionSource4, standardShape, function2, composer2, i9 & 33554430, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    z5 = z6;
                                    iconToggleButtonColors3 = iconToggleButtonColors4;
                                    mutableInteractionSource3 = mutableInteractionSource4;
                                    shape3 = standardShape;
                                } else {
                                    iconToggleButtonColors4 = iconToggleButtonColors2;
                                    mutableInteractionSource4 = mutableInteractionSource2;
                                    standardShape = shape2;
                                    i8 = -1031402037;
                                    modifier4 = companion;
                                    i9 = i7;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                i9 = (i2 & 16) != 0 ? i6 & (-57345) : i6;
                                if ((i2 & 64) != 0) {
                                    i9 &= -3670017;
                                }
                                iconToggleButtonColors4 = iconToggleButtonColors2;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                standardShape = shape2;
                                i8 = -1031402037;
                                modifier4 = modifier2;
                            }
                            z6 = z4;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = composerStartRestartGroup;
                            IconToggleButtonImpl(z3, function12, modifier4, z6, iconToggleButtonColors4, mutableInteractionSource4, standardShape, function2, composer2, i9 & 33554430, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier4;
                            z5 = z6;
                            iconToggleButtonColors3 = iconToggleButtonColors4;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            shape3 = standardShape;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            z5 = z4;
                            iconToggleButtonColors3 = iconToggleButtonColors2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape3 = shape2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return IconButtonKt.IconToggleButton$lambda$6(z, function1, modifier3, z5, iconToggleButtonColors3, mutableInteractionSource3, shape3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 12582912;
                    i6 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((1572864 & i) != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                i6 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z2;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((1572864 & i) != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            i6 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z4 = z2;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((1572864 & i) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e9  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with `shape`", replaceWith = @ReplaceWith(expression = "IconToggleButton(checked, onCheckedChange, modifier, enabled, colors, interactionSource, shape, content)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void IconToggleButton(final boolean z, final Function1 function1, Modifier modifier, boolean z2, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, final Function2 function2, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        Function1 function12;
        Modifier modifier2;
        int i4;
        boolean z4;
        IconToggleButtonColors iconToggleButtonColors2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final Modifier modifier3;
        final boolean z5;
        final IconToggleButtonColors iconToggleButtonColors3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        MutableInteractionSource mutableInteractionSource4;
        boolean z6;
        IconToggleButtonColors iconToggleButtonColors4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1307193856);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconToggleButton)N(checked,onCheckedChange,modifier,enabled,colors,interactionSource,content)251@10719L13,244@10554L202:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
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
            } else {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    i3 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                        int i7 = composerStartRestartGroup.changed(iconToggleButtonColors2) ? 16384 : 8192;
                        i3 |= i7;
                    } else {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                    }
                    i3 |= i7;
                } else {
                    iconToggleButtonColors2 = iconToggleButtonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                    }
                    if ((i2 & 64) != 0) {
                        if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                        }
                        if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "240@10426L24");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    iconToggleButtonColors2 = IconButtonDefaults.INSTANCE.iconToggleButtonColors(composerStartRestartGroup, 6);
                                }
                                if (i5 != 0) {
                                    modifier4 = companion;
                                    mutableInteractionSource4 = null;
                                    z6 = z4;
                                    iconToggleButtonColors4 = iconToggleButtonColors2;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1307193856, i3, -1, "androidx.compose.material3.IconToggleButton (IconButton.kt:243)");
                                    }
                                    composer2 = composerStartRestartGroup;
                                    IconToggleButton(z3, function12, modifier4, z6, iconToggleButtonColors4, mutableInteractionSource4, IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6), function2, composer2, (524286 & i3) | ((i3 << 3) & 29360128), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    z5 = z6;
                                    iconToggleButtonColors3 = iconToggleButtonColors4;
                                    mutableInteractionSource3 = mutableInteractionSource4;
                                } else {
                                    modifier4 = companion;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                modifier4 = modifier2;
                            }
                            iconToggleButtonColors4 = iconToggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            z6 = z4;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = composerStartRestartGroup;
                            IconToggleButton(z3, function12, modifier4, z6, iconToggleButtonColors4, mutableInteractionSource4, IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6), function2, composer2, (524286 & i3) | ((i3 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier4;
                            z5 = z6;
                            iconToggleButtonColors3 = iconToggleButtonColors4;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            z5 = z4;
                            iconToggleButtonColors3 = iconToggleButtonColors2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return IconButtonKt.IconToggleButton$lambda$5(z, function1, modifier3, z5, iconToggleButtonColors3, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 1572864;
                    if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 64) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z2;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 64) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z4 = z2;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 64) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit IconToggleButton$lambda$5(boolean z, Function1 function1, Modifier modifier, boolean z2, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        IconToggleButton(z, function1, modifier, z2, iconToggleButtonColors, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit IconToggleButton$lambda$6(boolean z, Function1 function1, Modifier modifier, boolean z2, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, Shape shape, Function2 function2, int i, int i2, Composer composer, int i3) {
        IconToggleButton(z, function1, modifier, z2, iconToggleButtonColors, mutableInteractionSource, shape, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void IconToggleButtonImpl(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, Shape shape, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        IconToggleButtonColors iconToggleButtonColorsIconToggleButtonVibrantColors;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Shape standardShape;
        int i6;
        final Modifier modifier3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        int i8;
        Modifier modifier4;
        MutableInteractionSource mutableInteractionSource3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1724745099);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconToggleButtonImpl)N(checked,onCheckedChange,modifier,enabled,colors,interactionSource,shape,content)329@14159L32,323@13928L814:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
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
                    z3 = z2;
                    i3 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        iconToggleButtonColorsIconToggleButtonVibrantColors = iconToggleButtonColors;
                        int i10 = composerStartRestartGroup.changed(iconToggleButtonColorsIconToggleButtonVibrantColors) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        iconToggleButtonColorsIconToggleButtonVibrantColors = iconToggleButtonColors;
                    }
                    i3 |= i10;
                } else {
                    iconToggleButtonColorsIconToggleButtonVibrantColors = iconToggleButtonColors;
                }
                i5 = i2 & 32;
                if (i5 == 0) {
                    if ((196608 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            standardShape = shape;
                            int i11 = composerStartRestartGroup.changed(standardShape) ? 1048576 : 524288;
                            i3 |= i11;
                        } else {
                            standardShape = shape;
                        }
                        i3 |= i11;
                    } else {
                        standardShape = shape;
                    }
                    if ((i2 & 128) == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    i6 = i3;
                    if (composerStartRestartGroup.shouldExecute((4793491 & i3) == 4793490, i6 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "316@13619L31,318@13747L13");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i9 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i7 = i6 & (-57345);
                                iconToggleButtonColorsIconToggleButtonVibrantColors = IconButtonDefaults.INSTANCE.iconToggleButtonVibrantColors(composerStartRestartGroup, 6);
                            } else {
                                i7 = i6;
                            }
                            if (i5 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 64) != 0) {
                                standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                                i8 = i7 & (-3670017);
                            } else {
                                i8 = i7;
                            }
                            z4 = z3;
                            modifier4 = companion;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            int i12 = (i2 & 16) != 0 ? i6 & (-57345) : i6;
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                            }
                            boolean z5 = z3;
                            modifier4 = modifier2;
                            z4 = z5;
                            i8 = i12;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1724745099, i8, -1, "androidx.compose.material3.IconToggleButtonImpl (IconButton.kt:320)");
                        }
                        if (mutableInteractionSource2 == null) {
                            composerStartRestartGroup.startReplaceGroup(1187972528);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "322@13884L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -377320302, "CC(remember):IconButton.kt#9igjgp");
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-377320953);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        int i13 = ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 896);
                        Modifier modifierM2314toggleableO2vRcR0 = ToggleableKt.m2314toggleableO2vRcR0(BackgroundKt.m1483backgroundbw27NRU$default(ClipKt.clip(SizeKt.m2084size6HolHcs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier4), IconButtonDefaults.m3706smallContainerSizeNwlBFI$material3$default(IconButtonDefaults.INSTANCE, 0, 1, null)), standardShape), iconToggleButtonColorsIconToggleButtonVibrantColors.containerColor$material3(z4, z, composerStartRestartGroup, i13).getValue().m6335unboximpl(), null, 2, null), z, mutableInteractionSource3, RippleKt.m3978rippleH2RKhps$default(false, 0.0f, 0L, 7, null), z4, Role.m8320boximpl(Role.INSTANCE.m8329getCheckboxo7Vup1c()), function1);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2314toggleableO2vRcR0);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 190782627, "C340@14607L30,341@14652L84:IconButton.kt#uh7d8r");
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(iconToggleButtonColorsIconToggleButtonVibrantColors.contentColor$material3(z4, z, composerStartRestartGroup, i13).getValue().m6335unboximpl())), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i8 >> 18) & 112));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                    }
                    final IconToggleButtonColors iconToggleButtonColors2 = iconToggleButtonColorsIconToggleButtonVibrantColors;
                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                    final Shape shape2 = standardShape;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return IconButtonKt.IconToggleButtonImpl$lambda$9(z, function1, modifier3, z4, iconToggleButtonColors2, mutableInteractionSource4, shape2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((1572864 & i) != 0) {
                }
                if ((i2 & 128) == 0) {
                }
                i6 = i3;
                if (composerStartRestartGroup.shouldExecute((4793491 & i3) == 4793490, i6 & 1)) {
                }
                final IconToggleButtonColors iconToggleButtonColors22 = iconToggleButtonColorsIconToggleButtonVibrantColors;
                final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                final Shape shape22 = standardShape;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z2;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((1572864 & i) != 0) {
            }
            if ((i2 & 128) == 0) {
            }
            i6 = i3;
            if (composerStartRestartGroup.shouldExecute((4793491 & i3) == 4793490, i6 & 1)) {
            }
            final IconToggleButtonColors iconToggleButtonColors222 = iconToggleButtonColorsIconToggleButtonVibrantColors;
            final MutableInteractionSource mutableInteractionSource422 = mutableInteractionSource2;
            final Shape shape222 = standardShape;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z2;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((1572864 & i) != 0) {
        }
        if ((i2 & 128) == 0) {
        }
        i6 = i3;
        if (composerStartRestartGroup.shouldExecute((4793491 & i3) == 4793490, i6 & 1)) {
        }
        final IconToggleButtonColors iconToggleButtonColors2222 = iconToggleButtonColorsIconToggleButtonVibrantColors;
        final MutableInteractionSource mutableInteractionSource4222 = mutableInteractionSource2;
        final Shape shape2222 = standardShape;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit IconToggleButtonImpl$lambda$9(boolean z, Function1 function1, Modifier modifier, boolean z2, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, Shape shape, Function2 function2, int i, int i2, Composer composer, int i3) {
        IconToggleButtonImpl(z, function1, modifier, z2, iconToggleButtonColors, mutableInteractionSource, shape, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedIconButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape outlinedShape;
        IconButtonColors iconButtonColorsOutlinedIconButtonColors;
        BorderStroke borderStroke2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final Modifier modifier3;
        final boolean z3;
        final Shape shape2;
        final IconButtonColors iconButtonColors2;
        final BorderStroke borderStroke3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z4;
        IconButtonColors iconButtonColors3;
        BorderStroke borderStroke4;
        MutableInteractionSource mutableInteractionSource4;
        Modifier modifier4;
        Shape shape3;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1481353380);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedIconButton)N(onClick,modifier,enabled,shape,colors,border,interactionSource,content)616@28361L254:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
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
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        outlinedShape = shape;
                        int i8 = composerStartRestartGroup.changed(outlinedShape) ? 2048 : 1024;
                        i3 |= i8;
                    } else {
                        outlinedShape = shape;
                    }
                    i3 |= i8;
                } else {
                    outlinedShape = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        iconButtonColorsOutlinedIconButtonColors = iconButtonColors;
                        int i9 = composerStartRestartGroup.changed(iconButtonColorsOutlinedIconButtonColors) ? 16384 : 8192;
                        i3 |= i9;
                    } else {
                        iconButtonColorsOutlinedIconButtonColors = iconButtonColors;
                    }
                    i3 |= i9;
                } else {
                    iconButtonColorsOutlinedIconButtonColors = iconButtonColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        borderStroke2 = borderStroke;
                        int i10 = composerStartRestartGroup.changed(borderStroke2) ? 131072 : 65536;
                        i3 |= i10;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    i3 |= i10;
                } else {
                    borderStroke2 = borderStroke;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else {
                    if ((1572864 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                    }
                    if ((i2 & 128) != 0) {
                        if ((i & 12582912) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "610@28084L13,611@28149L26,612@28224L33");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    outlinedShape = IconButtonDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    iconButtonColorsOutlinedIconButtonColors = IconButtonDefaults.INSTANCE.outlinedIconButtonColors(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    BorderStroke borderStrokeOutlinedIconButtonBorder = IconButtonDefaults.INSTANCE.outlinedIconButtonBorder(z2, composerStartRestartGroup, ((i3 >> 6) & 14) | 48);
                                    i3 &= -458753;
                                    borderStroke2 = borderStrokeOutlinedIconButtonBorder;
                                }
                                if (i5 != 0) {
                                    mutableInteractionSource4 = null;
                                    z4 = z2;
                                    shape3 = outlinedShape;
                                    iconButtonColors3 = iconButtonColorsOutlinedIconButtonColors;
                                    borderStroke4 = borderStroke2;
                                    modifier4 = companion;
                                } else {
                                    z4 = z2;
                                    iconButtonColors3 = iconButtonColorsOutlinedIconButtonColors;
                                    borderStroke4 = borderStroke2;
                                    mutableInteractionSource4 = mutableInteractionSource2;
                                    modifier4 = companion;
                                    shape3 = outlinedShape;
                                }
                                i6 = -1481353380;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                z4 = z2;
                                iconButtonColors3 = iconButtonColorsOutlinedIconButtonColors;
                                borderStroke4 = borderStroke2;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                i6 = -1481353380;
                                modifier4 = modifier2;
                                shape3 = outlinedShape;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.OutlinedIconButton (IconButton.kt:616)");
                            }
                            composer2 = composerStartRestartGroup;
                            SurfaceIconButton(function02, modifier4, z4, shape3, iconButtonColors3, borderStroke4, mutableInteractionSource4, function2, composer2, i3 & 33554430);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z3 = z4;
                            shape2 = shape3;
                            iconButtonColors2 = iconButtonColors3;
                            borderStroke3 = borderStroke4;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            z3 = z2;
                            shape2 = outlinedShape;
                            iconButtonColors2 = iconButtonColorsOutlinedIconButtonColors;
                            borderStroke3 = borderStroke2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return IconButtonKt.OutlinedIconButton$lambda$18(function0, modifier3, z3, shape2, iconButtonColors2, borderStroke3, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 12582912;
                    if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 128) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit OutlinedIconButton$lambda$18(Function0 function0, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        OutlinedIconButton(function0, modifier, z, shape, iconButtonColors, borderStroke, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedIconToggleButton(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, Shape shape, IconToggleButtonColors iconToggleButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        Shape outlinedShape;
        IconToggleButtonColors iconToggleButtonColorsOutlinedIconToggleButtonColors;
        BorderStroke borderStrokeOutlinedIconToggleButtonBorder;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape2;
        final IconToggleButtonColors iconToggleButtonColors2;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1703707081);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedIconToggleButton)N(checked,onCheckedChange,modifier,enabled,shape,colors,border,interactionSource,content)677@31487L24,674@31354L338:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        z3 = z2;
                        i3 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                    }
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            outlinedShape = shape;
                            int i10 = composerStartRestartGroup.changed(outlinedShape) ? 16384 : 8192;
                            i3 |= i10;
                        } else {
                            outlinedShape = shape;
                        }
                        i3 |= i10;
                    } else {
                        outlinedShape = shape;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            iconToggleButtonColorsOutlinedIconToggleButtonColors = iconToggleButtonColors;
                            int i11 = composerStartRestartGroup.changed(iconToggleButtonColorsOutlinedIconToggleButtonColors) ? 131072 : 65536;
                            i3 |= i11;
                        } else {
                            iconToggleButtonColorsOutlinedIconToggleButtonColors = iconToggleButtonColors;
                        }
                        i3 |= i11;
                    } else {
                        iconToggleButtonColorsOutlinedIconToggleButtonColors = iconToggleButtonColors;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            borderStrokeOutlinedIconToggleButtonBorder = borderStroke;
                            int i12 = composerStartRestartGroup.changed(borderStrokeOutlinedIconToggleButtonBorder) ? 1048576 : 524288;
                            i3 |= i12;
                        } else {
                            borderStrokeOutlinedIconToggleButtonBorder = borderStroke;
                        }
                        i3 |= i12;
                    } else {
                        borderStrokeOutlinedIconToggleButtonBorder = borderStroke;
                    }
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else {
                        if ((12582912 & i) == 0) {
                            mutableInteractionSource2 = mutableInteractionSource;
                            i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 8388608 : 4194304;
                        }
                        if ((i2 & 256) == 0) {
                            if ((i & 100663296) == 0) {
                                i3 |= composerStartRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
                            }
                            i7 = i3;
                            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i7 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                z4 = z3;
                                shape2 = outlinedShape;
                                iconToggleButtonColors2 = iconToggleButtonColorsOutlinedIconToggleButtonColors;
                                borderStroke2 = borderStrokeOutlinedIconToggleButtonBorder;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "668@31050L13,669@31121L32,670@31202L48");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i4 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i5 != 0) {
                                        z3 = true;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i8 = i7 & (-57345);
                                        outlinedShape = IconButtonDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                                    } else {
                                        i8 = i7;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i8 &= -458753;
                                        iconToggleButtonColorsOutlinedIconToggleButtonColors = IconButtonDefaults.INSTANCE.outlinedIconToggleButtonColors(composerStartRestartGroup, 6);
                                    }
                                    if ((i2 & 64) != 0) {
                                        borderStrokeOutlinedIconToggleButtonBorder = IconButtonDefaults.INSTANCE.outlinedIconToggleButtonBorder(z3, z, composerStartRestartGroup, ((i8 >> 9) & 14) | 384 | ((i8 << 3) & 112));
                                        i9 = i8 & (-3670017);
                                    } else {
                                        i9 = i8;
                                    }
                                    if (i6 != 0) {
                                        mutableInteractionSource2 = null;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    i9 = (i2 & 16) != 0 ? i7 & (-57345) : i7;
                                    if ((i2 & 32) != 0) {
                                        i9 &= -458753;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i9 &= -3670017;
                                    }
                                }
                                Shape shape3 = outlinedShape;
                                BorderStroke borderStroke3 = borderStrokeOutlinedIconToggleButtonBorder;
                                Modifier modifier4 = modifier2;
                                IconToggleButtonColors iconToggleButtonColors3 = iconToggleButtonColorsOutlinedIconToggleButtonColors;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1703707081, i9, -1, "androidx.compose.material3.OutlinedIconToggleButton (IconButton.kt:674)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -879944465, "CC(remember):IconButton.kt#9igjgp");
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return IconButtonKt.OutlinedIconToggleButton$lambda$20$lambda$19((SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                boolean z5 = z3;
                                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                SurfaceIconToggleButton(z, function1, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z5, shape3, iconToggleButtonColors3, borderStroke3, mutableInteractionSource4, function2, composerStartRestartGroup, i9 & 268434558);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                mutableInteractionSource3 = mutableInteractionSource4;
                                borderStroke2 = borderStroke3;
                                iconToggleButtonColors2 = iconToggleButtonColors3;
                                shape2 = shape3;
                                z4 = z5;
                                modifier3 = modifier4;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return IconButtonKt.OutlinedIconToggleButton$lambda$21(z, function1, modifier3, z4, shape2, iconToggleButtonColors2, borderStroke2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 100663296;
                        i7 = i3;
                        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i7 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i2 & 256) == 0) {
                    }
                    i7 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i7 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z3 = z2;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 256) == 0) {
                }
                i7 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i7 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z3 = z2;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 256) == 0) {
            }
            i7 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i7 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z3 = z2;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 256) == 0) {
        }
        i7 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i7 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit OutlinedIconToggleButton$lambda$20$lambda$19(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8329getCheckboxo7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit OutlinedIconToggleButton$lambda$21(boolean z, Function1 function1, Modifier modifier, boolean z2, Shape shape, IconToggleButtonColors iconToggleButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        OutlinedIconToggleButton(z, function1, modifier, z2, shape, iconToggleButtonColors, borderStroke, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final void SurfaceIconButton(final Function0<Unit> function0, final Modifier modifier, final boolean z, final Shape shape, final IconButtonColors iconButtonColors, final BorderStroke borderStroke, final MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-171935091);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SurfaceIconButton)N(onClick,modifier,enabled,shape,colors,border,interactionSource,content)700@32102L22,707@32355L192,698@32028L519:IconButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(iconButtonColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(borderStroke) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
        }
        if (composerStartRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-171935091, i2, -1, "androidx.compose.material3.SurfaceIconButton (IconButton.kt:698)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020852125, "CC(remember):IconButton.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IconButtonKt.SurfaceIconButton$lambda$23$lambda$22((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2 << 9;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4148Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue, 1, null), z, shape, iconButtonColors.m3699containerColorvNxB06k$material3(z), iconButtonColors.m3700contentColorvNxB06k$material3(z), 0.0f, 0.0f, borderStroke, mutableInteractionSource, ComposableLambdaKt.rememberComposableLambda(669231714, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.SurfaceIconButton.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C708@32365L176:IconButton.kt#uh7d8r");
                    if (!composer3.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(669231714, i4, -1, "androidx.compose.material3.SurfaceIconButton.<anonymous> (IconButton.kt:708)");
                    }
                    Modifier modifierM2084size6HolHcs = SizeKt.m2084size6HolHcs(Modifier.INSTANCE, IconButtonDefaults.m3706smallContainerSizeNwlBFI$material3$default(IconButtonDefaults.INSTANCE, 0, 1, null));
                    Alignment center = Alignment.INSTANCE.getCenter();
                    Function2<Composer, Integer, Unit> function22 = function2;
                    ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierM2084size6HolHcs);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer3);
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 495427006, "C712@32522L9:IconButton.kt#uh7d8r");
                    function22.invoke(composer3, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, (i2 & 8078) | (234881024 & i3) | (i3 & 1879048192), 6, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconButtonKt.SurfaceIconButton$lambda$24(function0, modifier, z, shape, iconButtonColors, borderStroke, mutableInteractionSource, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SurfaceIconButton$lambda$23$lambda$22(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8327getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit SurfaceIconButton$lambda$24(Function0 function0, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, Composer composer, int i2) {
        SurfaceIconButton(function0, modifier, z, shape, iconButtonColors, borderStroke, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final void SurfaceIconToggleButton(final boolean z, final Function1<? super Boolean, Unit> function1, final Modifier modifier, final boolean z2, final Shape shape, final IconToggleButtonColors iconToggleButtonColors, final BorderStroke borderStroke, final MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Function1<? super Boolean, Unit> function12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1118363928);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SurfaceIconToggleButton)N(checked,onCheckedChange,modifier,enabled,shape,colors,border,interactionSource,content)732@33049L24,735@33148L32,736@33218L30,739@33334L192,729@32932L594:IconButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            function12 = function1;
            i2 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
        } else {
            function12 = function1;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(iconToggleButtonColors) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(borderStroke) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1118363928, i2, -1, "androidx.compose.material3.SurfaceIconToggleButton (IconButton.kt:728)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1005894784, "CC(remember):IconButton.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IconButtonKt.SurfaceIconToggleButton$lambda$26$lambda$25((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2 >> 9;
            int i4 = (i3 & 896) | (i3 & 14) | ((i2 << 3) & 112);
            SurfaceKt.m4147Surfaced85dljk(z, function12, SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue, 1, null), z2, shape, iconToggleButtonColors.containerColor$material3(z2, z, composerStartRestartGroup, i4).getValue().m6335unboximpl(), iconToggleButtonColors.contentColor$material3(z2, z, composerStartRestartGroup, i4).getValue().m6335unboximpl(), 0.0f, 0.0f, borderStroke, mutableInteractionSource, ComposableLambdaKt.rememberComposableLambda(1492028158, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.SurfaceIconToggleButton.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    ComposerKt.sourceInformation(composer2, "C740@33344L176:IconButton.kt#uh7d8r");
                    if (!composer2.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1492028158, i5, -1, "androidx.compose.material3.SurfaceIconToggleButton.<anonymous> (IconButton.kt:740)");
                    }
                    Modifier modifierM2084size6HolHcs = SizeKt.m2084size6HolHcs(Modifier.INSTANCE, IconButtonDefaults.m3706smallContainerSizeNwlBFI$material3$default(IconButtonDefaults.INSTANCE, 0, 1, null));
                    Alignment center = Alignment.INSTANCE.getCenter();
                    Function2<Composer, Integer, Unit> function22 = function2;
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2084size6HolHcs);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -555521886, "C744@33501L9:IconButton.kt#uh7d8r");
                    function22.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (64638 & i2) | (1879048192 & (i2 << 9)), ((i2 >> 21) & 14) | 48, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconButtonKt.SurfaceIconToggleButton$lambda$27(z, function1, modifier, z2, shape, iconToggleButtonColors, borderStroke, mutableInteractionSource, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SurfaceIconToggleButton$lambda$26$lambda$25(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8329getCheckboxo7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit SurfaceIconToggleButton$lambda$27(boolean z, Function1 function1, Modifier modifier, boolean z2, Shape shape, IconToggleButtonColors iconToggleButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, Composer composer, int i2) {
        SurfaceIconToggleButton(z, function1, modifier, z2, shape, iconToggleButtonColors, borderStroke, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }
}
