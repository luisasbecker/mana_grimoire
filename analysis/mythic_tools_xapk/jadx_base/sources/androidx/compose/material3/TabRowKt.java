package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a}\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u0014\u0010\u0012\u001a\u009b\u0001\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u009b\u0001\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u001e\u0010\u001c\u001ak\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\b \u0010!\u001a\u008b\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\b#\u0010$\u001a{\u0010%\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072,\u0010\t\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\b+\u0010!\u001a\u009d\u0001\u0010,\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032,\u0010\t\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0004\b-\u0010.\u001a\u0091\u0001\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b/\u00100\u001a\u0091\u0001\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b1\u00100\u001a\u008d\u0001\u00102\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072.\b\u0002\u0010\t\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b3\u0010\u0012\u001a\u0097\u0001\u00104\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192.\b\u0002\u0010\t\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b5\u00106¨\u00067"}, d2 = {"PrimaryTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "indicator", "Lkotlin/Function1;", "Landroidx/compose/material3/TabIndicatorScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "divider", "Lkotlin/Function0;", "tabs", "PrimaryTabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SecondaryTabRow", "SecondaryTabRow-pAZo6Ak", "PrimaryScrollableTabRow", "scrollState", "Landroidx/compose/foundation/ScrollState;", "edgePadding", "Landroidx/compose/ui/unit/Dp;", "minTabWidth", "PrimaryScrollableTabRow-cx2KkNY", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow", "SecondaryScrollableTabRow-cx2KkNY", "TabRowImpl", "TabRowImpl-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ScrollableTabRowImpl", "ScrollableTabRowImpl-xam5sdo", "(ILandroidx/compose/ui/Modifier;JJFFLandroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabRowWithSubcomposeImpl", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "TabRowWithSubcomposeImpl-DTcfvLk", "ScrollableTabRowWithSubcomposeImpl", "ScrollableTabRowWithSubcomposeImpl-qhFBPw4", "(ILkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "PrimaryScrollableTabRow-qhFBPw4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow-qhFBPw4", "TabRow", "TabRow-pAZo6Ak", "ScrollableTabRow", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TabRowKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fe  */
    /* JADX INFO: renamed from: PrimaryScrollableTabRow-cx2KkNY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4190PrimaryScrollableTabRowcx2KkNY(final int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, float f2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        ScrollState scrollState2;
        long j3;
        long j4;
        int i5;
        float f3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function2M3528getLambda$773954579$material3;
        final ScrollState scrollState3;
        final long j5;
        final long j6;
        final float f4;
        final ComposableLambda composableLambdaRememberComposableLambda;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        ScrollState scrollStateRememberScrollState;
        long primaryContainerColor;
        long primaryContentColor;
        int i11;
        float fM4189getScrollableTabRowMinTabWidthD9Ej5fM;
        ScrollState scrollState4;
        long j7;
        float f6;
        long j8;
        Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(450849184);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PrimaryScrollableTabRow)N(selectedTabIndex,modifier,scrollState,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,minTabWidth:c#ui.unit.Dp,tabs)270@14011L363:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i12 = i3 & 2;
        if (i12 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    scrollState2 = scrollState;
                    int i13 = composerStartRestartGroup.changed(scrollState2) ? 256 : 128;
                    i4 |= i13;
                } else {
                    scrollState2 = scrollState;
                }
                i4 |= i13;
            } else {
                scrollState2 = scrollState;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j3 = j;
                    int i14 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    i4 |= i14;
                } else {
                    j3 = j;
                }
                i4 |= i14;
            } else {
                j3 = j;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16) == 0) {
                    j4 = j2;
                    int i15 = composerStartRestartGroup.changed(j4) ? 16384 : 8192;
                    i4 |= i15;
                } else {
                    j4 = j2;
                }
                i4 |= i15;
            } else {
                j4 = j2;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else {
                if ((196608 & i2) == 0) {
                    f3 = f;
                    i4 |= composerStartRestartGroup.changed(f3) ? 131072 : 65536;
                }
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else {
                    if ((i2 & 12582912) == 0) {
                        i8 = i7;
                        i4 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    i9 = i3 & 256;
                    if (i9 == 0) {
                        i4 |= 100663296;
                    } else {
                        if ((i2 & 100663296) == 0) {
                            i10 = i9;
                            i4 |= composerStartRestartGroup.changed(f2) ? 67108864 : 33554432;
                        }
                        if ((i3 & 512) == 0) {
                            if ((i2 & 805306368) == 0) {
                                i4 |= composerStartRestartGroup.changedInstance(function22) ? 536870912 : 268435456;
                            }
                            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i4 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                function2M3528getLambda$773954579$material3 = function2;
                                scrollState3 = scrollState2;
                                j5 = j3;
                                j6 = j4;
                                f4 = f3;
                                composableLambdaRememberComposableLambda = function3;
                                f5 = f2;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
                                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    companion = i12 != 0 ? Modifier.INSTANCE : modifier;
                                    if ((i3 & 4) != 0) {
                                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                        i4 &= -897;
                                    } else {
                                        scrollStateRememberScrollState = scrollState2;
                                    }
                                    if ((i3 & 8) != 0) {
                                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                        i4 &= -7169;
                                    } else {
                                        primaryContainerColor = j3;
                                    }
                                    if ((i3 & 16) != 0) {
                                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                        i4 &= -57345;
                                    } else {
                                        primaryContentColor = j4;
                                    }
                                    float fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = i5 != 0 ? TabRowDefaults.INSTANCE.m4188getScrollableTabRowEdgeStartPaddingD9Ej5fM() : f3;
                                    composableLambdaRememberComposableLambda = i6 != 0 ? ComposableLambdaKt.rememberComposableLambda(835301263, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$1
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer2, Integer num) {
                                            invoke(tabIndicatorScope, composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer2, int i16) {
                                            int i17;
                                            ComposerKt.sourceInformation(composer2, "C261@13657L159:TabRow.kt#uh7d8r");
                                            if ((i16 & 6) == 0) {
                                                i17 = ((i16 & 8) == 0 ? composer2.changed(tabIndicatorScope) : composer2.changedInstance(tabIndicatorScope) ? 4 : 2) | i16;
                                            } else {
                                                i17 = i16;
                                            }
                                            if (!composer2.shouldExecute((i17 & 19) != 18, i17 & 1)) {
                                                composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(835301263, i17, -1, "androidx.compose.material3.PrimaryScrollableTabRow.<anonymous> (TabRow.kt:261)");
                                            }
                                            TabRowDefaults.INSTANCE.m4186PrimaryIndicator10LGxhE(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, true), Dp.INSTANCE.m9134getUnspecifiedD9Ej5fM(), 0.0f, 0L, null, composer2, 196656, 28);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54) : function3;
                                    function2M3528getLambda$773954579$material3 = i8 != 0 ? ComposableSingletons$TabRowKt.INSTANCE.m3528getLambda$773954579$material3() : function2;
                                    if (i10 != 0) {
                                        i11 = i4;
                                        long j9 = primaryContentColor;
                                        scrollState4 = scrollStateRememberScrollState;
                                        j7 = primaryContainerColor;
                                        fM4189getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4189getScrollableTabRowMinTabWidthD9Ej5fM();
                                        f6 = fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                        j8 = j9;
                                    } else {
                                        i11 = i4;
                                        long j10 = primaryContentColor;
                                        fM4189getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                        scrollState4 = scrollStateRememberScrollState;
                                        j7 = primaryContainerColor;
                                        f6 = fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                        j8 = j10;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i3 & 4) != 0) {
                                        i4 &= -897;
                                    }
                                    if ((i3 & 8) != 0) {
                                        i4 &= -7169;
                                    }
                                    if ((i3 & 16) != 0) {
                                        i4 &= -57345;
                                    }
                                    long j11 = j4;
                                    scrollState4 = scrollState2;
                                    j8 = j11;
                                    float f7 = f3;
                                    i11 = i4;
                                    j7 = j3;
                                    f6 = f7;
                                    companion = modifier;
                                    composableLambdaRememberComposableLambda = function3;
                                    function2M3528getLambda$773954579$material3 = function2;
                                    fM4189getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    modifier3 = companion;
                                    ComposerKt.traceEventStart(450849184, i11, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
                                } else {
                                    modifier3 = companion;
                                }
                                int i16 = i11 >> 3;
                                int i17 = (i11 & 126) | (i16 & 896) | (i16 & 7168) | (i16 & 57344) | ((i11 >> 9) & 458752) | ((i11 << 12) & 3670016);
                                int i18 = i11 << 3;
                                int i19 = i17 | (29360128 & i18) | (i18 & 234881024) | (1879048192 & i11);
                                Modifier modifier4 = modifier3;
                                m4194ScrollableTabRowImplxam5sdo(i, modifier4, j7, j8, f6, fM4189getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, function2M3528getLambda$773954579$material3, function22, composerStartRestartGroup, i19);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                f5 = fM4189getScrollableTabRowMinTabWidthD9Ej5fM;
                                long j12 = j7;
                                modifier2 = modifier4;
                                scrollState3 = scrollState4;
                                f4 = f6;
                                j6 = j8;
                                j5 = j12;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TabRowKt.PrimaryScrollableTabRow_cx2KkNY$lambda$2(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, function2M3528getLambda$773954579$material3, f5, function22, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= 805306368;
                        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i4 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i10 = i9;
                    if ((i3 & 512) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i8 = i7;
                i9 = i3 & 256;
                if (i9 == 0) {
                }
                i10 = i9;
                if ((i3 & 512) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            f3 = f;
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            i9 = i3 & 256;
            if (i9 == 0) {
            }
            i10 = i9;
            if ((i3 & 512) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        if ((i2 & 24576) != 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        f3 = f;
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i3 & 256;
        if (i9 == 0) {
        }
        i10 = i9;
        if ((i3 & 512) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fe  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for Binary Compatibility.")
    /* JADX INFO: renamed from: PrimaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m4191PrimaryScrollableTabRowqhFBPw4(final int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3 function3, Function2 function2, final Function2 function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        ScrollState scrollStateRememberScrollState;
        long primaryContainerColor;
        long primaryContentColor;
        int i5;
        float fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
        int i6;
        int i7;
        int i8;
        final Modifier modifier3;
        final ScrollState scrollState2;
        final long j3;
        final long j4;
        final float f2;
        final Function3 function32;
        final Function2 function23;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ScrollState scrollState3;
        Function2 function2M3525getLambda$306947391$material3;
        int i9;
        long j5;
        float f3;
        Function3 function33;
        Modifier modifier4;
        long j6;
        Composer composerStartRestartGroup = composer.startRestartGroup(1501129198);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PrimaryScrollableTabRow)N(selectedTabIndex,modifier,scrollState,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,tabs)1205@51273L397:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    scrollStateRememberScrollState = scrollState;
                    int i11 = composerStartRestartGroup.changed(scrollStateRememberScrollState) ? 256 : 128;
                    i4 |= i11;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i4 |= i11;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    primaryContainerColor = j;
                    int i12 = composerStartRestartGroup.changed(primaryContainerColor) ? 2048 : 1024;
                    i4 |= i12;
                } else {
                    primaryContainerColor = j;
                }
                i4 |= i12;
            } else {
                primaryContainerColor = j;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16) == 0) {
                    primaryContentColor = j2;
                    int i13 = composerStartRestartGroup.changed(primaryContentColor) ? 16384 : 8192;
                    i4 |= i13;
                } else {
                    primaryContentColor = j2;
                }
                i4 |= i13;
            } else {
                primaryContentColor = j2;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else {
                if ((196608 & i2) == 0) {
                    fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
                    i4 |= composerStartRestartGroup.changed(fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM) ? 131072 : 65536;
                }
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else {
                    if ((i2 & 12582912) == 0) {
                        i8 = i7;
                        i4 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    if ((i3 & 256) != 0) {
                        if ((i2 & 100663296) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
                        }
                        if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1191@50656L21,1192@50722L21,1193@50786L19,1196@50956L198");
                            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i10 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                }
                                if ((i3 & 8) != 0) {
                                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -7169;
                                }
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                }
                                if (i5 != 0) {
                                    fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4188getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                                }
                                ComposableLambda composableLambdaRememberComposableLambda = i6 != 0 ? ComposableLambdaKt.rememberComposableLambda(-1872002465, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$3
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer2, Integer num) {
                                        invoke(tabIndicatorScope, composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer2, int i14) {
                                        int i15;
                                        ComposerKt.sourceInformation(composer2, "C1197@50985L159:TabRow.kt#uh7d8r");
                                        if ((i14 & 6) == 0) {
                                            i15 = ((i14 & 8) == 0 ? composer2.changed(tabIndicatorScope) : composer2.changedInstance(tabIndicatorScope) ? 4 : 2) | i14;
                                        } else {
                                            i15 = i14;
                                        }
                                        if (!composer2.shouldExecute((i15 & 19) != 18, i15 & 1)) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1872002465, i15, -1, "androidx.compose.material3.PrimaryScrollableTabRow.<anonymous> (TabRow.kt:1197)");
                                        }
                                        TabRowDefaults.INSTANCE.m4186PrimaryIndicator10LGxhE(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, true), Dp.INSTANCE.m9134getUnspecifiedD9Ej5fM(), 0.0f, 0L, null, composer2, 196656, 28);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54) : function3;
                                if (i8 != 0) {
                                    long j7 = primaryContainerColor;
                                    function33 = composableLambdaRememberComposableLambda;
                                    modifier4 = modifier2;
                                    f3 = fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                    long j8 = primaryContentColor;
                                    function2M3525getLambda$306947391$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3525getLambda$306947391$material3();
                                    i9 = i4;
                                    scrollState3 = scrollStateRememberScrollState;
                                    j5 = j7;
                                    j6 = j8;
                                } else {
                                    scrollState3 = scrollStateRememberScrollState;
                                    long j9 = primaryContentColor;
                                    function2M3525getLambda$306947391$material3 = function2;
                                    i9 = i4;
                                    j5 = primaryContainerColor;
                                    f3 = fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                    function33 = composableLambdaRememberComposableLambda;
                                    modifier4 = modifier2;
                                    j6 = j9;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                modifier4 = modifier2;
                                scrollState3 = scrollStateRememberScrollState;
                                j6 = primaryContentColor;
                                function2M3525getLambda$306947391$material3 = function2;
                                i9 = i4;
                                j5 = primaryContainerColor;
                                f3 = fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                function33 = function3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1501129198, i9, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:1205)");
                            }
                            m4190PrimaryScrollableTabRowcx2KkNY(i, modifier4, scrollState3, j5, j6, f3, function33, function2M3525getLambda$306947391$material3, TabRowDefaults.INSTANCE.m4189getScrollableTabRowMinTabWidthD9Ej5fM(), function22, composerStartRestartGroup, (i9 & 14) | 100663296 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i9) | (29360128 & i9) | ((i9 << 3) & 1879048192), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function23 = function2M3525getLambda$306947391$material3;
                            function32 = function33;
                            f2 = f3;
                            j4 = j6;
                            j3 = j5;
                            scrollState2 = scrollState3;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            scrollState2 = scrollStateRememberScrollState;
                            j3 = primaryContainerColor;
                            j4 = primaryContentColor;
                            f2 = fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            function32 = function3;
                            function23 = function2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabRowKt.PrimaryScrollableTabRow_qhFBPw4$lambda$8(i, modifier3, scrollState2, j3, j4, f2, function32, function23, function22, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 100663296;
                    if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i8 = i7;
                if ((i3 & 256) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            if ((i3 & 256) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        if ((i2 & 24576) != 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        if ((i3 & 256) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit PrimaryScrollableTabRow_cx2KkNY$lambda$2(int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3 function3, Function2 function2, float f2, Function2 function22, int i2, int i3, Composer composer, int i4) {
        m4190PrimaryScrollableTabRowcx2KkNY(i, modifier, scrollState, j, j2, f, function3, function2, f2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit PrimaryScrollableTabRow_qhFBPw4$lambda$8(int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3 function3, Function2 function2, Function2 function22, int i2, int i3, Composer composer, int i4) {
        m4191PrimaryScrollableTabRowqhFBPw4(i, modifier, scrollState, j, j2, f, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e9  */
    /* JADX INFO: renamed from: PrimaryTabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4192PrimaryTabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        long primaryContainerColor;
        long j3;
        int i5;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Composer composer2;
        final Modifier modifier2;
        final long j4;
        final long j5;
        final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long primaryContentColor;
        Modifier modifier3;
        long j6;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function34;
        Function2<? super Composer, ? super Integer, Unit> function2M3524getLambda$1429684928$material3;
        int i7;
        long j7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1012974221);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PrimaryTabRow)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)163@7987L76:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i8 = i3 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    primaryContainerColor = j;
                    int i9 = composerStartRestartGroup.changed(primaryContainerColor) ? 256 : 128;
                    i4 |= i9;
                } else {
                    primaryContainerColor = j;
                }
                i4 |= i9;
            } else {
                primaryContainerColor = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j3 = j2;
                    int i10 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    i4 |= i10;
                } else {
                    j3 = j2;
                }
                i4 |= i10;
            } else {
                j3 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((i2 & 24576) == 0) {
                    function32 = function3;
                    i4 |= composerStartRestartGroup.changedInstance(function32) ? 16384 : 8192;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i2) == 0) {
                        function23 = function2;
                        i4 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    }
                    if ((i3 & 64) != 0) {
                        if ((i2 & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function22) ? 1048576 : 524288;
                        }
                        if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "152@7536L21,153@7600L19,154@7679L189");
                            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i8 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i3 & 4) != 0) {
                                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                    i4 &= -7169;
                                } else {
                                    primaryContentColor = j3;
                                }
                                ComposableLambda composableLambdaRememberComposableLambda = i5 != 0 ? ComposableLambdaKt.rememberComposableLambda(1338273762, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryTabRow$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer3, Integer num) {
                                        invoke(tabIndicatorScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer3, int i11) {
                                        int i12;
                                        ComposerKt.sourceInformation(composer3, "C155@7704L158:TabRow.kt#uh7d8r");
                                        if ((i11 & 6) == 0) {
                                            i12 = ((i11 & 8) == 0 ? composer3.changed(tabIndicatorScope) : composer3.changedInstance(tabIndicatorScope) ? 4 : 2) | i11;
                                        } else {
                                            i12 = i11;
                                        }
                                        if (!composer3.shouldExecute((i12 & 19) != 18, i12 & 1)) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1338273762, i12, -1, "androidx.compose.material3.PrimaryTabRow.<anonymous> (TabRow.kt:155)");
                                        }
                                        TabRowDefaults.INSTANCE.m4186PrimaryIndicator10LGxhE(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, true), Dp.INSTANCE.m9134getUnspecifiedD9Ej5fM(), 0.0f, 0L, null, composer3, 196656, 28);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54) : function32;
                                if (i6 != 0) {
                                    modifier3 = companion;
                                    j7 = primaryContentColor;
                                    j6 = primaryContainerColor;
                                    function34 = composableLambdaRememberComposableLambda;
                                    function2M3524getLambda$1429684928$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3524getLambda$1429684928$material3();
                                    i7 = -1012974221;
                                } else {
                                    modifier3 = companion;
                                    j6 = primaryContainerColor;
                                    function34 = composableLambdaRememberComposableLambda;
                                    function2M3524getLambda$1429684928$material3 = function23;
                                    i7 = -1012974221;
                                    j7 = primaryContentColor;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                modifier3 = modifier;
                                function34 = function32;
                                function2M3524getLambda$1429684928$material3 = function23;
                                i7 = -1012974221;
                                j6 = primaryContainerColor;
                                j7 = j3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i7, i4, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:162)");
                            }
                            composer2 = composerStartRestartGroup;
                            m4200TabRowImplDTcfvLk(modifier3, j6, j7, function34, function2M3524getLambda$1429684928$material3, function22, composer2, (i4 >> 3) & 524286);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            j4 = j6;
                            j5 = j7;
                            function33 = function34;
                            function24 = function2M3524getLambda$1429684928$material3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = modifier;
                            j4 = primaryContainerColor;
                            j5 = j3;
                            function33 = function32;
                            function24 = function23;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabRowKt.PrimaryTabRow_pAZo6Ak$lambda$0(i, modifier2, j4, j5, function33, function24, function22, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 1572864;
                    if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function23 = function2;
                if ((i3 & 64) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function32 = function3;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            function23 = function2;
            if ((i3 & 64) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        function32 = function3;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        function23 = function2;
        if ((i3 & 64) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit PrimaryTabRow_pAZo6Ak$lambda$0(int i, Modifier modifier, long j, long j2, Function3 function3, Function2 function2, Function2 function22, int i2, int i3, Composer composer, int i4) {
        m4192PrimaryTabRowpAZo6Ak(i, modifier, j, j2, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010a  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Replaced with PrimaryScrollableTabRow and SecondaryScrollableTabRow tab variants.", replaceWith = @ReplaceWith(expression = "SecondaryScrollableTabRow(selectedTabIndex, modifier, containerColor, contentColor, edgePadding, indicator, divider, tabs)", imports = {}))
    /* JADX INFO: renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4193ScrollableTabRowsKfQg0A(final int i, Modifier modifier, long j, long j2, float f, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        long primaryContainerColor;
        long j3;
        int i5;
        float f2;
        int i6;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        int i7;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final long j4;
        final long j5;
        final float fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long primaryContentColor;
        int i8;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34;
        Function2<? super Composer, ? super Integer, Unit> function2M3526getLambda$358046007$material3;
        Composer composerStartRestartGroup = composer.startRestartGroup(847049916);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScrollableTabRow)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,tabs)1423@61760L21,1414@61436L352:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i9 = i3 & 2;
        if (i9 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    primaryContainerColor = j;
                    int i10 = composerStartRestartGroup.changed(primaryContainerColor) ? 256 : 128;
                    i4 |= i10;
                } else {
                    primaryContainerColor = j;
                }
                i4 |= i10;
            } else {
                primaryContainerColor = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j3 = j2;
                    int i11 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    i4 |= i11;
                } else {
                    j3 = j2;
                }
                i4 |= i11;
            } else {
                j3 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((i2 & 24576) == 0) {
                    f2 = f;
                    i4 |= composerStartRestartGroup.changed(f2) ? 16384 : 8192;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i2) == 0) {
                        function32 = function3;
                        i4 |= composerStartRestartGroup.changedInstance(function32) ? 131072 : 65536;
                    }
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                    }
                    if ((i3 & 128) != 0) {
                        if ((i2 & 12582912) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                        }
                        if (composerStartRestartGroup.shouldExecute((i4 & 4793491) != 4793490, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1402@60906L21,1403@60970L19,1406@61153L164");
                            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i9 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i3 & 4) != 0) {
                                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                    i4 &= -7169;
                                } else {
                                    primaryContentColor = j3;
                                }
                                fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = i5 != 0 ? TabRowDefaults.INSTANCE.m4188getScrollableTabRowEdgeStartPaddingD9Ej5fM() : f2;
                                ComposableLambda composableLambdaRememberComposableLambda = i6 != 0 ? ComposableLambdaKt.rememberComposableLambda(-720441215, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer2, Integer num) {
                                        invoke((List<TabPosition>) list, composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(List<TabPosition> list, Composer composer2, int i12) {
                                        ComposerKt.sourceInformation(composer2, "CN(tabPositions)1407@61198L109:TabRow.kt#uh7d8r");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-720441215, i12, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:1407)");
                                        }
                                        TabRowDefaults.INSTANCE.m4187SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(i)), 0.0f, 0L, composer2, 3072, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54) : function32;
                                if (i7 != 0) {
                                    int i12 = i4;
                                    modifier2 = companion;
                                    function34 = composableLambdaRememberComposableLambda;
                                    function2M3526getLambda$358046007$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3526getLambda$358046007$material3();
                                    i8 = i12;
                                    long j6 = primaryContainerColor;
                                    j5 = primaryContentColor;
                                    j4 = j6;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(847049916, i8, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:1413)");
                                    }
                                    int i13 = i8 << 3;
                                    m4195ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function34, modifier2, j4, j5, fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM, function2M3526getLambda$358046007$material3, function22, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), composerStartRestartGroup, (i13 & 896) | (i8 & 14) | ((i8 >> 12) & 112) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i8) | (i8 & 29360128), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function23 = function2M3526getLambda$358046007$material3;
                                    function33 = function34;
                                } else {
                                    long j7 = primaryContainerColor;
                                    j5 = primaryContentColor;
                                    j4 = j7;
                                    i8 = i4;
                                    modifier2 = companion;
                                    function34 = composableLambdaRememberComposableLambda;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                i8 = i4;
                                j4 = primaryContainerColor;
                                j5 = j3;
                                fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                                function34 = function32;
                                modifier2 = modifier;
                            }
                            function2M3526getLambda$358046007$material3 = function2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i132 = i8 << 3;
                            m4195ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function34, modifier2, j4, j5, fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM, function2M3526getLambda$358046007$material3, function22, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), composerStartRestartGroup, (i132 & 896) | (i8 & 14) | ((i8 >> 12) & 112) | (i132 & 7168) | (57344 & i132) | (458752 & i132) | (3670016 & i8) | (i8 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function23 = function2M3526getLambda$358046007$material3;
                            function33 = function34;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            function23 = function2;
                            j4 = primaryContainerColor;
                            j5 = j3;
                            fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = f2;
                            function33 = function32;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$11(i, modifier2, j4, j5, fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM, function33, function23, function22, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 12582912;
                    if (composerStartRestartGroup.shouldExecute((i4 & 4793491) != 4793490, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function32 = function3;
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                if ((i3 & 128) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 4793491) != 4793490, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            f2 = f;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            function32 = function3;
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            if ((i3 & 128) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 4793491) != 4793490, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        f2 = f;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        function32 = function3;
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        if ((i3 & 128) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 4793491) != 4793490, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: renamed from: ScrollableTabRowImpl-xam5sdo, reason: not valid java name */
    private static final void m4194ScrollableTabRowImplxam5sdo(final int i, final Modifier modifier, final long j, final long j2, final float f, final float f2, final ScrollState scrollState, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2) {
        int i3;
        ScrollState scrollState2;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(414860860);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScrollableTabRowImpl)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,minTabWidth:c#ui.unit.Dp,scrollState,indicator,divider,tabs)522@24247L5677,522@24165L5759:TabRow.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            scrollState2 = scrollState;
            i3 |= composerStartRestartGroup.changed(scrollState2) ? 1048576 : 524288;
        } else {
            scrollState2 = scrollState;
        }
        if ((i2 & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            function23 = function2;
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
        } else {
            function23 = function2;
        }
        if ((i2 & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 536870912 : 268435456;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(414860860, i3, -1, "androidx.compose.material3.ScrollableTabRowImpl (TabRow.kt:521)");
            }
            final ScrollState scrollState3 = scrollState2;
            final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4145SurfaceT9BRK9s(modifier, null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1878374785, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C523@24278L24,525@24450L14,527@24579L7,529@24631L263,537@24916L1219,568@26144L3774:TabRow.kt#uh7d8r");
                    if (!composer3.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1878374785, i4, -1, "androidx.compose.material3.ScrollableTabRowImpl.<anonymous> (TabRow.kt:523)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composer3, 683737348, "CC(remember):Effects.kt#9igjgp");
                    Object objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3);
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer3, 6);
                    FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer3, 6);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1231916616, "CC(remember):TabRow.kt#9igjgp");
                    boolean zChanged = composer3.changed(scrollState3) | composer3.changed(coroutineScope);
                    ScrollState scrollState4 = scrollState3;
                    Object objRememberedValue2 = composer3.rememberedValue();
                    if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new ScrollableTabData(scrollState4, coroutineScope, finiteAnimationSpecValue);
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    ScrollableTabData scrollableTabData = (ScrollableTabData) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1231926692, "CC(remember):TabRow.kt#9igjgp");
                    Object objRememberedValue3 = composer3.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new TabRowKt$ScrollableTabRowImpl$1$scope$1$1(finiteAnimationSpecValue2);
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    final TabRowKt$ScrollableTabRowImpl$1$scope$1$1 tabRowKt$ScrollableTabRowImpl$1$scope$1$1 = (TabRowKt$ScrollableTabRowImpl$1$scope$1$1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                    Function2<Composer, Integer, Unit> function25 = function24;
                    Function2<Composer, Integer, Unit> function26 = function22;
                    ScrollState scrollState5 = scrollState3;
                    float f3 = f;
                    float f4 = f2;
                    int i5 = i;
                    final Function3<TabIndicatorScope, Composer, Integer, Unit> function32 = function3;
                    ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart, false);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, companion);
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
                    ComposerKt.sourceInformationMarkerStart(composer3, 738154596, "C569@26204L9,571@26274L21,578@26594L3314,570@26226L3682:TabRow.kt#uh7d8r");
                    function25.invoke(composer3, 0);
                    List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function26, ComposableLambdaKt.rememberComposableLambda(509386037, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1$1$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i6) {
                            ComposerKt.sourceInformation(composer4, "C571@26282L11:TabRow.kt#uh7d8r");
                            if (!composer4.shouldExecute((i6 & 3) != 2, i6 & 1)) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(509386037, i6, -1, "androidx.compose.material3.ScrollableTabRowImpl.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:571)");
                            }
                            function32.invoke(tabRowKt$ScrollableTabRowImpl$1$scope$1$1, composer4, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54)});
                    Modifier modifierClipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollState5, false, null, false, 14, null)));
                    ComposerKt.sourceInformationMarkerStart(composer3, 578012857, "CC(remember):TabRow.kt#9igjgp");
                    boolean zChanged2 = composer3.changed(f3) | composer3.changed(f4) | composer3.changed(i5) | composer3.changedInstance(scrollableTabData);
                    Object objRememberedValue4 = composer3.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = (MultiContentMeasurePolicy) new TabRowKt$ScrollableTabRowImpl$1$1$2$1(f3, f4, tabRowKt$ScrollableTabRowImpl$1$scope$1$1, i5, scrollableTabData);
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
                    ComposerKt.sourceInformationMarkerStart(composer3, -290764973, "CC(remember):Layout.kt#9igjgp");
                    boolean zChanged3 = composer3.changed(multiContentMeasurePolicy);
                    Object objRememberedValue5 = composer3.rememberedValue();
                    if (zChanged3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierClipToBounds);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor2);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer3);
                    Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts.invoke(composer3, 0);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
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
            }, composerStartRestartGroup, 54), composer2, ((i3 >> 3) & 14) | 12582912 | (i3 & 896) | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.ScrollableTabRowImpl_xam5sdo$lambda$5(i, modifier, j, j2, f, f2, scrollState, function3, function2, function22, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ScrollableTabRowImpl_xam5sdo$lambda$5(int i, Modifier modifier, long j, long j2, float f, float f2, ScrollState scrollState, Function3 function3, Function2 function2, Function2 function22, int i2, Composer composer, int i3) {
        m4194ScrollableTabRowImplxam5sdo(i, modifier, j, j2, f, f2, scrollState, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0100  */
    /* JADX INFO: renamed from: ScrollableTabRowWithSubcomposeImpl-qhFBPw4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m4195ScrollableTabRowWithSubcomposeImplqhFBPw4(final int i, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, long j, long j2, float f, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final ScrollState scrollState, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier modifier2;
        long primaryContainerColor;
        long primaryContentColor;
        int i6;
        float fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
        int i7;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final long j4;
        final float f2;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> lambda$2075817209$material3;
        Composer composerStartRestartGroup = composer.startRestartGroup(901781420);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScrollableTabRowWithSubcomposeImpl)N(selectedTabIndex,indicator,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,divider,tabs,scrollState)835@36626L4172,835@36544L4254:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i2 & 384) == 0) {
                    modifier2 = modifier;
                    i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
                }
                if ((i2 & 3072) == 0) {
                    if ((i3 & 8) == 0) {
                        primaryContainerColor = j;
                        int i8 = composerStartRestartGroup.changed(primaryContainerColor) ? 2048 : 1024;
                        i4 |= i8;
                    } else {
                        primaryContainerColor = j;
                    }
                    i4 |= i8;
                } else {
                    primaryContainerColor = j;
                }
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        primaryContentColor = j2;
                        int i9 = composerStartRestartGroup.changed(primaryContentColor) ? 16384 : 8192;
                        i4 |= i9;
                    } else {
                        primaryContentColor = j2;
                    }
                    i4 |= i9;
                } else {
                    primaryContentColor = j2;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i2) == 0) {
                        fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
                        i4 |= composerStartRestartGroup.changed(fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM) ? 131072 : 65536;
                    }
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                    }
                    if ((i3 & 128) == 0) {
                        i4 |= 12582912;
                    } else {
                        if ((i2 & 12582912) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                        }
                        if ((i3 & 256) == 0) {
                            if ((i2 & 100663296) == 0) {
                                i4 |= composerStartRestartGroup.changed(scrollState) ? 67108864 : 33554432;
                            }
                            if (composerStartRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i4 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier3 = modifier2;
                                j3 = primaryContainerColor;
                                j4 = primaryContentColor;
                                f2 = fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                function23 = function2;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "828@36241L21,829@36305L19");
                                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i5 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if ((i3 & 8) != 0) {
                                        primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                        i4 &= -7169;
                                    }
                                    if ((i3 & 16) != 0) {
                                        primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                        i4 &= -57345;
                                    }
                                    if (i6 != 0) {
                                        fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4188getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                                    }
                                    if (i7 != 0) {
                                        lambda$2075817209$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                                    }
                                    long j5 = primaryContentColor;
                                    float f3 = fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                    Modifier modifier4 = modifier2;
                                    long j6 = primaryContainerColor;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(901781420, i4, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:834)");
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function24 = lambda$2075817209$material3;
                                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(2077251399, true, new TabRowKt$ScrollableTabRowWithSubcomposeImpl$1(scrollState, f3, function22, function24, function3, i), composerStartRestartGroup, 54);
                                    int i10 = ((i4 >> 6) & 14) | 12582912;
                                    int i11 = i4 >> 3;
                                    composer2 = composerStartRestartGroup;
                                    SurfaceKt.m4145SurfaceT9BRK9s(modifier4, null, j6, j5, 0.0f, 0.0f, null, composableLambdaRememberComposableLambda, composer2, i10 | (i11 & 896) | (i11 & 7168), 114);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    f2 = f3;
                                    function23 = function24;
                                    modifier3 = modifier4;
                                    j3 = j6;
                                    j4 = j5;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i3 & 8) != 0) {
                                        i4 &= -7169;
                                    }
                                    if ((i3 & 16) != 0) {
                                        i4 &= -57345;
                                    }
                                }
                                lambda$2075817209$material3 = function2;
                                long j52 = primaryContentColor;
                                float f32 = fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                Modifier modifier42 = modifier2;
                                long j62 = primaryContainerColor;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                Function2<? super Composer, ? super Integer, Unit> function242 = lambda$2075817209$material3;
                                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(2077251399, true, new TabRowKt$ScrollableTabRowWithSubcomposeImpl$1(scrollState, f32, function22, function242, function3, i), composerStartRestartGroup, 54);
                                int i102 = ((i4 >> 6) & 14) | 12582912;
                                int i112 = i4 >> 3;
                                composer2 = composerStartRestartGroup;
                                SurfaceKt.m4145SurfaceT9BRK9s(modifier42, null, j62, j52, 0.0f, 0.0f, null, composableLambdaRememberComposableLambda2, composer2, i102 | (i112 & 896) | (i112 & 7168), 114);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                f2 = f32;
                                function23 = function242;
                                modifier3 = modifier42;
                                j3 = j62;
                                j4 = j52;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TabRowKt.ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$7(i, function3, modifier3, j3, j4, f2, function23, function22, scrollState, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= 100663296;
                        if (composerStartRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i4 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    if ((i3 & 256) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                if ((i3 & 128) == 0) {
                }
                if ((i3 & 256) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            if ((i2 & 3072) == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            if ((i3 & 128) == 0) {
            }
            if ((i3 & 256) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        modifier2 = modifier;
        if ((i2 & 3072) == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        if ((i3 & 128) == 0) {
        }
        if ((i3 & 256) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$7(int i, Function3 function3, Modifier modifier, long j, long j2, float f, Function2 function2, Function2 function22, ScrollState scrollState, int i2, int i3, Composer composer, int i4) {
        m4195ScrollableTabRowWithSubcomposeImplqhFBPw4(i, function3, modifier, j, j2, f, function2, function22, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit ScrollableTabRow_sKfQg0A$lambda$11(int i, Modifier modifier, long j, long j2, float f, Function3 function3, Function2 function2, Function2 function22, int i2, int i3, Composer composer, int i4) {
        m4193ScrollableTabRowsKfQg0A(i, modifier, j, j2, f, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fe  */
    /* JADX INFO: renamed from: SecondaryScrollableTabRow-cx2KkNY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4196SecondaryScrollableTabRowcx2KkNY(final int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, float f2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        ScrollState scrollState2;
        long j3;
        long j4;
        int i5;
        float f3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> lambda$303717663$material3;
        final ScrollState scrollState3;
        final long j5;
        final long j6;
        final float f4;
        final ComposableLambda composableLambdaRememberComposableLambda;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        ScrollState scrollStateRememberScrollState;
        long secondaryContainerColor;
        long secondaryContentColor;
        int i11;
        float fM4189getScrollableTabRowMinTabWidthD9Ej5fM;
        ScrollState scrollState4;
        long j7;
        float f6;
        long j8;
        Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(519094802);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SecondaryScrollableTabRow)N(selectedTabIndex,modifier,scrollState,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,minTabWidth:c#ui.unit.Dp,tabs)340@17697L363:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i12 = i3 & 2;
        if (i12 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    scrollState2 = scrollState;
                    int i13 = composerStartRestartGroup.changed(scrollState2) ? 256 : 128;
                    i4 |= i13;
                } else {
                    scrollState2 = scrollState;
                }
                i4 |= i13;
            } else {
                scrollState2 = scrollState;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j3 = j;
                    int i14 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    i4 |= i14;
                } else {
                    j3 = j;
                }
                i4 |= i14;
            } else {
                j3 = j;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16) == 0) {
                    j4 = j2;
                    int i15 = composerStartRestartGroup.changed(j4) ? 16384 : 8192;
                    i4 |= i15;
                } else {
                    j4 = j2;
                }
                i4 |= i15;
            } else {
                j4 = j2;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else {
                if ((196608 & i2) == 0) {
                    f3 = f;
                    i4 |= composerStartRestartGroup.changed(f3) ? 131072 : 65536;
                }
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else {
                    if ((i2 & 12582912) == 0) {
                        i8 = i7;
                        i4 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    i9 = i3 & 256;
                    if (i9 == 0) {
                        i4 |= 100663296;
                    } else {
                        if ((i2 & 100663296) == 0) {
                            i10 = i9;
                            i4 |= composerStartRestartGroup.changed(f2) ? 67108864 : 33554432;
                        }
                        if ((i3 & 512) == 0) {
                            if ((i2 & 805306368) == 0) {
                                i4 |= composerStartRestartGroup.changedInstance(function22) ? 536870912 : 268435456;
                            }
                            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i4 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                lambda$303717663$material3 = function2;
                                scrollState3 = scrollState2;
                                j5 = j3;
                                j6 = j4;
                                f4 = f3;
                                composableLambdaRememberComposableLambda = function3;
                                f5 = f2;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
                                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    companion = i12 != 0 ? Modifier.INSTANCE : modifier;
                                    if ((i3 & 4) != 0) {
                                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                        i4 &= -897;
                                    } else {
                                        scrollStateRememberScrollState = scrollState2;
                                    }
                                    if ((i3 & 8) != 0) {
                                        secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                                        i4 &= -7169;
                                    } else {
                                        secondaryContainerColor = j3;
                                    }
                                    if ((i3 & 16) != 0) {
                                        secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                                        i4 &= -57345;
                                    } else {
                                        secondaryContentColor = j4;
                                    }
                                    float fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = i5 != 0 ? TabRowDefaults.INSTANCE.m4188getScrollableTabRowEdgeStartPaddingD9Ej5fM() : f3;
                                    composableLambdaRememberComposableLambda = i6 != 0 ? ComposableLambdaKt.rememberComposableLambda(610355265, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$1
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer2, Integer num) {
                                            invoke(tabIndicatorScope, composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer2, int i16) {
                                            ComposerKt.sourceInformation(composer2, "C332@17381L121:TabRow.kt#uh7d8r");
                                            if ((i16 & 6) == 0) {
                                                i16 |= (i16 & 8) == 0 ? composer2.changed(tabIndicatorScope) : composer2.changedInstance(tabIndicatorScope) ? 4 : 2;
                                            }
                                            if (!composer2.shouldExecute((i16 & 19) != 18, i16 & 1)) {
                                                composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(610355265, i16, -1, "androidx.compose.material3.SecondaryScrollableTabRow.<anonymous> (TabRow.kt:332)");
                                            }
                                            TabRowDefaults.INSTANCE.m4187SecondaryIndicator9IZ8Weo(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, false), 0.0f, 0L, composer2, 3072, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54) : function3;
                                    lambda$303717663$material3 = i8 != 0 ? ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3() : function2;
                                    if (i10 != 0) {
                                        i11 = i4;
                                        long j9 = secondaryContentColor;
                                        scrollState4 = scrollStateRememberScrollState;
                                        j7 = secondaryContainerColor;
                                        fM4189getScrollableTabRowMinTabWidthD9Ej5fM = TabRowDefaults.INSTANCE.m4189getScrollableTabRowMinTabWidthD9Ej5fM();
                                        f6 = fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                        j8 = j9;
                                    } else {
                                        i11 = i4;
                                        long j10 = secondaryContentColor;
                                        fM4189getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                        scrollState4 = scrollStateRememberScrollState;
                                        j7 = secondaryContainerColor;
                                        f6 = fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                        j8 = j10;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i3 & 4) != 0) {
                                        i4 &= -897;
                                    }
                                    if ((i3 & 8) != 0) {
                                        i4 &= -7169;
                                    }
                                    if ((i3 & 16) != 0) {
                                        i4 &= -57345;
                                    }
                                    long j11 = j4;
                                    scrollState4 = scrollState2;
                                    j8 = j11;
                                    float f7 = f3;
                                    i11 = i4;
                                    j7 = j3;
                                    f6 = f7;
                                    companion = modifier;
                                    composableLambdaRememberComposableLambda = function3;
                                    lambda$303717663$material3 = function2;
                                    fM4189getScrollableTabRowMinTabWidthD9Ej5fM = f2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    modifier3 = companion;
                                    ComposerKt.traceEventStart(519094802, i11, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
                                } else {
                                    modifier3 = companion;
                                }
                                int i16 = i11 >> 3;
                                int i17 = (i11 & 126) | (i16 & 896) | (i16 & 7168) | (i16 & 57344) | ((i11 >> 9) & 458752) | ((i11 << 12) & 3670016);
                                int i18 = i11 << 3;
                                int i19 = i17 | (29360128 & i18) | (i18 & 234881024) | (1879048192 & i11);
                                Modifier modifier4 = modifier3;
                                m4194ScrollableTabRowImplxam5sdo(i, modifier4, j7, j8, f6, fM4189getScrollableTabRowMinTabWidthD9Ej5fM, scrollState4, composableLambdaRememberComposableLambda, lambda$303717663$material3, function22, composerStartRestartGroup, i19);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                f5 = fM4189getScrollableTabRowMinTabWidthD9Ej5fM;
                                long j12 = j7;
                                modifier2 = modifier4;
                                scrollState3 = scrollState4;
                                f4 = f6;
                                j6 = j8;
                                j5 = j12;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TabRowKt.SecondaryScrollableTabRow_cx2KkNY$lambda$3(i, modifier2, scrollState3, j5, j6, f4, composableLambdaRememberComposableLambda, lambda$303717663$material3, f5, function22, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= 805306368;
                        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i4 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i10 = i9;
                    if ((i3 & 512) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i8 = i7;
                i9 = i3 & 256;
                if (i9 == 0) {
                }
                i10 = i9;
                if ((i3 & 512) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            f3 = f;
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            i9 = i3 & 256;
            if (i9 == 0) {
            }
            i10 = i9;
            if ((i3 & 512) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        if ((i2 & 24576) != 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        f3 = f;
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i3 & 256;
        if (i9 == 0) {
        }
        i10 = i9;
        if ((i3 & 512) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fe  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for Binary Compatibility.")
    /* JADX INFO: renamed from: SecondaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m4197SecondaryScrollableTabRowqhFBPw4(final int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3 function3, Function2 function2, final Function2 function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        ScrollState scrollStateRememberScrollState;
        long secondaryContainerColor;
        long secondaryContentColor;
        int i5;
        float fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
        int i6;
        int i7;
        int i8;
        final Modifier modifier3;
        final ScrollState scrollState2;
        final long j3;
        final long j4;
        final float f2;
        final Function3 function32;
        final Function2 function23;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ScrollState scrollState3;
        Function2 lambda$1187266255$material3;
        int i9;
        long j5;
        float f3;
        Function3 function33;
        Modifier modifier4;
        long j6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-712886596);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SecondaryScrollableTabRow)N(selectedTabIndex,modifier,scrollState,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,tabs)1236@52486L399:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    scrollStateRememberScrollState = scrollState;
                    int i11 = composerStartRestartGroup.changed(scrollStateRememberScrollState) ? 256 : 128;
                    i4 |= i11;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i4 |= i11;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    secondaryContainerColor = j;
                    int i12 = composerStartRestartGroup.changed(secondaryContainerColor) ? 2048 : 1024;
                    i4 |= i12;
                } else {
                    secondaryContainerColor = j;
                }
                i4 |= i12;
            } else {
                secondaryContainerColor = j;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16) == 0) {
                    secondaryContentColor = j2;
                    int i13 = composerStartRestartGroup.changed(secondaryContentColor) ? 16384 : 8192;
                    i4 |= i13;
                } else {
                    secondaryContentColor = j2;
                }
                i4 |= i13;
            } else {
                secondaryContentColor = j2;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else {
                if ((196608 & i2) == 0) {
                    fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
                    i4 |= composerStartRestartGroup.changed(fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM) ? 131072 : 65536;
                }
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else {
                    if ((i2 & 12582912) == 0) {
                        i8 = i7;
                        i4 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    if ((i3 & 256) != 0) {
                        if ((i2 & 100663296) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
                        }
                        if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1223@51903L21,1224@51969L23,1225@52035L21,1228@52207L160");
                            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i10 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                }
                                if ((i3 & 8) != 0) {
                                    secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -7169;
                                }
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                    secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                                }
                                if (i5 != 0) {
                                    fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m4188getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                                }
                                ComposableLambda composableLambdaRememberComposableLambda = i6 != 0 ? ComposableLambdaKt.rememberComposableLambda(407893741, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$3
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer2, Integer num) {
                                        invoke(tabIndicatorScope, composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer2, int i14) {
                                        ComposerKt.sourceInformation(composer2, "C1229@52236L121:TabRow.kt#uh7d8r");
                                        if ((i14 & 6) == 0) {
                                            i14 |= (i14 & 8) == 0 ? composer2.changed(tabIndicatorScope) : composer2.changedInstance(tabIndicatorScope) ? 4 : 2;
                                        }
                                        if (!composer2.shouldExecute((i14 & 19) != 18, i14 & 1)) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(407893741, i14, -1, "androidx.compose.material3.SecondaryScrollableTabRow.<anonymous> (TabRow.kt:1229)");
                                        }
                                        TabRowDefaults.INSTANCE.m4187SecondaryIndicator9IZ8Weo(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, false), 0.0f, 0L, composer2, 3072, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54) : function3;
                                if (i8 != 0) {
                                    long j7 = secondaryContainerColor;
                                    function33 = composableLambdaRememberComposableLambda;
                                    modifier4 = modifier2;
                                    f3 = fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                    long j8 = secondaryContentColor;
                                    lambda$1187266255$material3 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$1187266255$material3();
                                    i9 = i4;
                                    scrollState3 = scrollStateRememberScrollState;
                                    j5 = j7;
                                    j6 = j8;
                                } else {
                                    scrollState3 = scrollStateRememberScrollState;
                                    long j9 = secondaryContentColor;
                                    lambda$1187266255$material3 = function2;
                                    i9 = i4;
                                    j5 = secondaryContainerColor;
                                    f3 = fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                    function33 = composableLambdaRememberComposableLambda;
                                    modifier4 = modifier2;
                                    j6 = j9;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                modifier4 = modifier2;
                                scrollState3 = scrollStateRememberScrollState;
                                j6 = secondaryContentColor;
                                lambda$1187266255$material3 = function2;
                                i9 = i4;
                                j5 = secondaryContainerColor;
                                f3 = fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                                function33 = function3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-712886596, i9, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:1236)");
                            }
                            m4196SecondaryScrollableTabRowcx2KkNY(i, modifier4, scrollState3, j5, j6, f3, function33, lambda$1187266255$material3, TabRowDefaults.INSTANCE.m4189getScrollableTabRowMinTabWidthD9Ej5fM(), function22, composerStartRestartGroup, (i9 & 14) | 100663296 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i9) | (29360128 & i9) | ((i9 << 3) & 1879048192), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function23 = lambda$1187266255$material3;
                            function32 = function33;
                            f2 = f3;
                            j4 = j6;
                            j3 = j5;
                            scrollState2 = scrollState3;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            scrollState2 = scrollStateRememberScrollState;
                            j3 = secondaryContainerColor;
                            j4 = secondaryContentColor;
                            f2 = fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            function32 = function3;
                            function23 = function2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabRowKt.SecondaryScrollableTabRow_qhFBPw4$lambda$9(i, modifier3, scrollState2, j3, j4, f2, function32, function23, function22, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 100663296;
                    if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i8 = i7;
                if ((i3 & 256) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            if ((i3 & 256) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        if ((i2 & 24576) != 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        fM4188getScrollableTabRowEdgeStartPaddingD9Ej5fM = f;
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        if ((i3 & 256) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 38347923) != 38347922, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit SecondaryScrollableTabRow_cx2KkNY$lambda$3(int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3 function3, Function2 function2, float f2, Function2 function22, int i2, int i3, Composer composer, int i4) {
        m4196SecondaryScrollableTabRowcx2KkNY(i, modifier, scrollState, j, j2, f, function3, function2, f2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit SecondaryScrollableTabRow_qhFBPw4$lambda$9(int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3 function3, Function2 function2, Function2 function22, int i2, int i3, Composer composer, int i4) {
        m4197SecondaryScrollableTabRowqhFBPw4(i, modifier, scrollState, j, j2, f, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e9  */
    /* JADX INFO: renamed from: SecondaryTabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4198SecondaryTabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        long secondaryContainerColor;
        long j3;
        int i5;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Composer composer2;
        final Modifier modifier2;
        final long j4;
        final long j5;
        final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long secondaryContentColor;
        Modifier modifier3;
        long j6;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function34;
        Function2<? super Composer, ? super Integer, Unit> function2M3527getLambda$463596174$material3;
        int i7;
        long j7;
        Composer composerStartRestartGroup = composer.startRestartGroup(563434725);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SecondaryTabRow)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)214@10853L76:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i8 = i3 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    secondaryContainerColor = j;
                    int i9 = composerStartRestartGroup.changed(secondaryContainerColor) ? 256 : 128;
                    i4 |= i9;
                } else {
                    secondaryContainerColor = j;
                }
                i4 |= i9;
            } else {
                secondaryContainerColor = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j3 = j2;
                    int i10 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    i4 |= i10;
                } else {
                    j3 = j2;
                }
                i4 |= i10;
            } else {
                j3 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((i2 & 24576) == 0) {
                    function32 = function3;
                    i4 |= composerStartRestartGroup.changedInstance(function32) ? 16384 : 8192;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i2) == 0) {
                        function23 = function2;
                        i4 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    }
                    if ((i3 & 64) != 0) {
                        if ((i2 & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function22) ? 1048576 : 524288;
                        }
                        if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "203@10407L23,204@10473L21,206@10574L160");
                            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i8 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i3 & 4) != 0) {
                                    secondaryContainerColor = TabRowDefaults.INSTANCE.getSecondaryContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    secondaryContentColor = TabRowDefaults.INSTANCE.getSecondaryContentColor(composerStartRestartGroup, 6);
                                    i4 &= -7169;
                                } else {
                                    secondaryContentColor = j3;
                                }
                                ComposableLambda composableLambdaRememberComposableLambda = i5 != 0 ? ComposableLambdaKt.rememberComposableLambda(959948692, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryTabRow$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer3, Integer num) {
                                        invoke(tabIndicatorScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer3, int i11) {
                                        ComposerKt.sourceInformation(composer3, "C207@10603L121:TabRow.kt#uh7d8r");
                                        if ((i11 & 6) == 0) {
                                            i11 |= (i11 & 8) == 0 ? composer3.changed(tabIndicatorScope) : composer3.changedInstance(tabIndicatorScope) ? 4 : 2;
                                        }
                                        if (!composer3.shouldExecute((i11 & 19) != 18, i11 & 1)) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(959948692, i11, -1, "androidx.compose.material3.SecondaryTabRow.<anonymous> (TabRow.kt:207)");
                                        }
                                        TabRowDefaults.INSTANCE.m4187SecondaryIndicator9IZ8Weo(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, false), 0.0f, 0L, composer3, 3072, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54) : function32;
                                if (i6 != 0) {
                                    modifier3 = companion;
                                    j7 = secondaryContentColor;
                                    j6 = secondaryContainerColor;
                                    function34 = composableLambdaRememberComposableLambda;
                                    function2M3527getLambda$463596174$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3527getLambda$463596174$material3();
                                    i7 = 563434725;
                                } else {
                                    modifier3 = companion;
                                    j6 = secondaryContainerColor;
                                    function34 = composableLambdaRememberComposableLambda;
                                    function2M3527getLambda$463596174$material3 = function23;
                                    i7 = 563434725;
                                    j7 = secondaryContentColor;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                modifier3 = modifier;
                                function34 = function32;
                                function2M3527getLambda$463596174$material3 = function23;
                                i7 = 563434725;
                                j6 = secondaryContainerColor;
                                j7 = j3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i7, i4, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:213)");
                            }
                            composer2 = composerStartRestartGroup;
                            m4200TabRowImplDTcfvLk(modifier3, j6, j7, function34, function2M3527getLambda$463596174$material3, function22, composer2, (i4 >> 3) & 524286);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            j4 = j6;
                            j5 = j7;
                            function33 = function34;
                            function24 = function2M3527getLambda$463596174$material3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = modifier;
                            j4 = secondaryContainerColor;
                            j5 = j3;
                            function33 = function32;
                            function24 = function23;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabRowKt.SecondaryTabRow_pAZo6Ak$lambda$1(i, modifier2, j4, j5, function33, function24, function22, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 1572864;
                    if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function23 = function2;
                if ((i3 & 64) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function32 = function3;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            function23 = function2;
            if ((i3 & 64) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        function32 = function3;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        function23 = function2;
        if ((i3 & 64) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit SecondaryTabRow_pAZo6Ak$lambda$1(int i, Modifier modifier, long j, long j2, Function3 function3, Function2 function2, Function2 function22, int i2, int i3, Composer composer, int i4) {
        m4198SecondaryTabRowpAZo6Ak(i, modifier, j, j2, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e9  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Replaced with PrimaryTabRow and SecondaryTabRow.", replaceWith = @ReplaceWith(expression = "SecondaryTabRow(selectedTabIndex, modifier, containerColor, contentColor, indicator, divider, tabs)", imports = {}))
    /* JADX INFO: renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4199TabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        long primaryContainerColor;
        long j3;
        int i5;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Composer composer2;
        final Modifier modifier2;
        final long j4;
        final long j5;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long primaryContentColor;
        Modifier modifier3;
        long j6;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34;
        Function2<? super Composer, ? super Integer, Unit> function2M3523getLambda$1132537920$material3;
        int i7;
        long j7;
        Composer composerStartRestartGroup = composer.startRestartGroup(1445190381);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabRow)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)1349@57943L90:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i8 = i3 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    primaryContainerColor = j;
                    int i9 = composerStartRestartGroup.changed(primaryContainerColor) ? 256 : 128;
                    i4 |= i9;
                } else {
                    primaryContainerColor = j;
                }
                i4 |= i9;
            } else {
                primaryContainerColor = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j3 = j2;
                    int i10 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    i4 |= i10;
                } else {
                    j3 = j2;
                }
                i4 |= i10;
            } else {
                j3 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((i2 & 24576) == 0) {
                    function32 = function3;
                    i4 |= composerStartRestartGroup.changedInstance(function32) ? 16384 : 8192;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i2) == 0) {
                        function23 = function2;
                        i4 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    }
                    if ((i3 & 64) != 0) {
                        if ((i2 & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function22) ? 1048576 : 524288;
                        }
                        if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1336@57402L21,1337@57466L19,1339@57578L246");
                            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i8 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i3 & 4) != 0) {
                                    primaryContainerColor = TabRowDefaults.INSTANCE.getPrimaryContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    primaryContentColor = TabRowDefaults.INSTANCE.getPrimaryContentColor(composerStartRestartGroup, 6);
                                    i4 &= -7169;
                                } else {
                                    primaryContentColor = j3;
                                }
                                ComposableLambda composableLambdaRememberComposableLambda = i5 != 0 ? ComposableLambdaKt.rememberComposableLambda(906699528, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer3, Integer num) {
                                        invoke((List<TabPosition>) list, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(List<TabPosition> list, Composer composer3, int i11) {
                                        ComposerKt.sourceInformation(composer3, "CN(tabPositions):TabRow.kt#uh7d8r");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(906699528, i11, -1, "androidx.compose.material3.TabRow.<anonymous> (TabRow.kt:1340)");
                                        }
                                        if (i < list.size()) {
                                            composer3.startReplaceGroup(436390614);
                                            ComposerKt.sourceInformation(composer3, "1341@57683L117");
                                            TabRowDefaults.INSTANCE.m4187SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(i)), 0.0f, 0L, composer3, 3072, 6);
                                            composer3.endReplaceGroup();
                                        } else {
                                            composer3.startReplaceGroup(436548218);
                                            composer3.endReplaceGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54) : function32;
                                if (i6 != 0) {
                                    modifier3 = companion;
                                    j7 = primaryContentColor;
                                    j6 = primaryContainerColor;
                                    function34 = composableLambdaRememberComposableLambda;
                                    function2M3523getLambda$1132537920$material3 = ComposableSingletons$TabRowKt.INSTANCE.m3523getLambda$1132537920$material3();
                                    i7 = 1445190381;
                                } else {
                                    modifier3 = companion;
                                    j6 = primaryContainerColor;
                                    function34 = composableLambdaRememberComposableLambda;
                                    function2M3523getLambda$1132537920$material3 = function23;
                                    i7 = 1445190381;
                                    j7 = primaryContentColor;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                modifier3 = modifier;
                                function34 = function32;
                                function2M3523getLambda$1132537920$material3 = function23;
                                i7 = 1445190381;
                                j6 = primaryContainerColor;
                                j7 = j3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i7, i4, -1, "androidx.compose.material3.TabRow (TabRow.kt:1348)");
                            }
                            composer2 = composerStartRestartGroup;
                            m4201TabRowWithSubcomposeImplDTcfvLk(modifier3, j6, j7, function34, function2M3523getLambda$1132537920$material3, function22, composer2, (i4 >> 3) & 524286);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            j4 = j6;
                            j5 = j7;
                            function33 = function34;
                            function24 = function2M3523getLambda$1132537920$material3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = modifier;
                            j4 = primaryContainerColor;
                            j5 = j3;
                            function33 = function32;
                            function24 = function23;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$10(i, modifier2, j4, j5, function33, function24, function22, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 1572864;
                    if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function23 = function2;
                if ((i3 & 64) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function32 = function3;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            function23 = function2;
            if ((i3 & 64) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        function32 = function3;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        function23 = function2;
        if ((i3 & 64) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: renamed from: TabRowImpl-DTcfvLk, reason: not valid java name */
    private static final void m4200TabRowImplDTcfvLk(Modifier modifier, final long j, final long j2, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1955286154);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabRowImpl)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)403@19706L4058,399@19575L4189:TabRow.kt#uh7d8r");
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i2 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1955286154, i2, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:398)");
            }
            int i3 = i2 << 3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4145SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(830280655, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C405@19861L11,406@19893L1219,440@21223L21,441@21257L2501,438@21122L2636:TabRow.kt#uh7d8r");
                    if (!composer3.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(830280655, i4, -1, "androidx.compose.material3.TabRowImpl.<anonymous> (TabRow.kt:405)");
                    }
                    FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer3, 6);
                    ComposerKt.sourceInformationMarkerStart(composer3, -964200398, "CC(remember):TabRow.kt#9igjgp");
                    Object objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new TabRowKt$TabRowImpl$1$scope$1$1(finiteAnimationSpecValue);
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    final TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1 = (TabRowKt$TabRowImpl$1$scope$1$1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    final Function3<TabIndicatorScope, Composer, Integer, Unit> function32 = function3;
                    List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function22, function2, ComposableLambdaKt.rememberComposableLambda(-1333331860, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i5) {
                            ComposerKt.sourceInformation(composer4, "C440@21231L11:TabRow.kt#uh7d8r");
                            if (!composer4.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1333331860, i5, -1, "androidx.compose.material3.TabRowImpl.<anonymous>.<anonymous> (TabRow.kt:440)");
                            }
                            function32.invoke(tabRowKt$TabRowImpl$1$scope$1$1, composer4, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54)});
                    ComposerKt.sourceInformationMarkerStart(composer3, -964155468, "CC(remember):TabRow.kt#9igjgp");
                    TabRowKt$TabRowImpl$1$2$1 tabRowKt$TabRowImpl$1$2$1RememberedValue = composer3.rememberedValue();
                    if (tabRowKt$TabRowImpl$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        tabRowKt$TabRowImpl$1$2$1RememberedValue = new TabRowKt$TabRowImpl$1$2$1(tabRowKt$TabRowImpl$1$scope$1$1);
                        composer3.updateRememberedValue(tabRowKt$TabRowImpl$1$2$1RememberedValue);
                    }
                    MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) tabRowKt$TabRowImpl$1$2$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
                    ComposerKt.sourceInformationMarkerStart(composer3, -290764973, "CC(remember):Layout.kt#9igjgp");
                    Object objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default);
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
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts.invoke(composer3, 0);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, (i3 & 896) | 12582912 | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.TabRowImpl_DTcfvLk$lambda$4(modifier3, j, j2, function3, function2, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit TabRowImpl_DTcfvLk$lambda$4(Modifier modifier, long j, long j2, Function3 function3, Function2 function2, Function2 function22, int i, Composer composer, int i2) {
        m4200TabRowImplDTcfvLk(modifier, j, j2, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: TabRowWithSubcomposeImpl-DTcfvLk, reason: not valid java name */
    private static final void m4201TabRowWithSubcomposeImplDTcfvLk(Modifier modifier, final long j, final long j2, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(148841506);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabRowWithSubcomposeImpl)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)767@33784L2218,763@33653L2349:TabRow.kt#uh7d8r");
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i2 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(148841506, i2, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:762)");
            }
            int i3 = i2 << 3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4145SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1815327065, true, new TabRowKt$TabRowWithSubcomposeImpl$1(function22, function2, function3), composerStartRestartGroup, 54), composer2, (i3 & 896) | 12582912 | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.TabRowWithSubcomposeImpl_DTcfvLk$lambda$6(modifier3, j, j2, function3, function2, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit TabRowWithSubcomposeImpl_DTcfvLk$lambda$6(Modifier modifier, long j, long j2, Function3 function3, Function2 function2, Function2 function22, int i, Composer composer, int i2) {
        m4201TabRowWithSubcomposeImplDTcfvLk(modifier, j, j2, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit TabRow_pAZo6Ak$lambda$10(int i, Modifier modifier, long j, long j2, Function3 function3, Function2 function2, Function2 function22, int i2, int i3, Composer composer, int i4) {
        m4199TabRowpAZo6Ak(i, modifier, j, j2, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }
}
