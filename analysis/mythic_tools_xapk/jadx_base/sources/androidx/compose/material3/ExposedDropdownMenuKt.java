package androidx.compose.material3;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.internal.BackHandler_androidKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSizeKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u0003*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001aa\u0010\u001b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b&\u0010'\u001a\"\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020/H\u0002\u001a\u000e\u00105\u001a\u000203*\u0004\u0018\u000106H\u0002\"\u0018\u0010(\u001a\u00020\u0003*\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u0018\u0010,\u001a\u00020\u0003*\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010+\"\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109*8\b\u0007\u0010\u0012\"\u00020\u000e2\u00020\u000eB*\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u001c\b\u0016\u0012\u0018\b\u000bB\u0014\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0006\b\u001a\u0012\u0002\b\f¨\u0006:²\u0006\f\u0010;\u001a\u0004\u0018\u000106X\u008a\u008e\u0002²\u0006\n\u0010<\u001a\u00020/X\u008a\u008e\u0002²\u0006\n\u0010=\u001a\u00020/X\u008a\u008e\u0002"}, d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "hasGreaterOrEqualPriorityThan", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "that", "hasGreaterOrEqualPriorityThan-vVDBVkM", "(Ljava/lang/String;Ljava/lang/String;)Z", "MenuAnchorType", "Lkotlin/Deprecated;", "message", "Renamed to ExposedDropdownMenuAnchorType", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "ExposedDropdownMenuAnchorType", "imports", "expandable", "Lkotlin/Function0;", "anchorType", "alwaysFocusable", "Landroidx/compose/runtime/MutableState;", "expandedDescription", "", "collapsedDescription", "toggleDescription", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "expandable-3-2CpT8", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/MutableState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Landroidx/compose/ui/Modifier;", "isClick", "Landroidx/compose/ui/input/key/KeyEvent;", "isClick-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isEnterMinusSpacebar", "isEnterMinusSpacebar-ZmokQxo", "calculateMaxHeight", "", "windowBounds", "Landroidx/compose/ui/unit/IntRect;", "anchorBounds", "Landroidx/compose/ui/geometry/Rect;", "verticalMargin", "getAnchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "material3", "anchorCoordinates", "anchorWidth", "menuMaxHeight"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuKt {
    private static final float ExposedDropdownMenuItemHorizontalPadding = Dp.m9114constructorimpl(16.0f);

    /* JADX WARN: Removed duplicated region for block: B:141:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ExposedDropdownMenuBox(boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function32;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i4;
        String str;
        boolean z2;
        Modifier modifier4;
        String str2;
        MutableIntState mutableIntState;
        int i5;
        final WindowBoundsCalculator windowBoundsCalculator;
        int i6;
        int i7;
        final int i8;
        final FocusRequester focusRequester;
        final MutableState mutableState;
        final MutableIntState mutableIntState2;
        final boolean z3 = z;
        Composer composerStartRestartGroup = composer.startRestartGroup(1597265892);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExposedDropdownMenuBox)N(expanded,onExpandedChange,modifier,content)142@6635L32,143@6699L7,147@6812L53,148@6889L33,149@6948L33,151@7008L29,152@7099L7,153@7137L31,154@7200L32,155@7261L37,156@7325L89,159@7441L34,162@7501L2786,217@10336L377,216@10293L458,242@11135L47,242@11124L58,246@11347L27,246@11315L59:ExposedDropdownMenu.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                function32 = function3;
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                Modifier.Companion companion = i9 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1597265892, i3, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:141)");
                }
                WindowBoundsCalculator windowBoundsCalculatorPlatformWindowBoundsCalculator = ExposedDropdownMenu_androidKt.platformWindowBoundsCalculator(composerStartRestartGroup, 0);
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density = (Density) objConsume;
                int iMo1618roundToPx0680j_4 = density.mo1618roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669211801, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669214245, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                MutableIntState mutableIntState3 = (MutableIntState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669216133, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final MutableIntState mutableIntState4 = (MutableIntState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669218049, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                FocusRequester focusRequester2 = (FocusRequester) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localSoftwareKeyboardController);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) objConsume2;
                Strings.Companion companion2 = Strings.INSTANCE;
                String strM4676getString2EP1pXo = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_dropdown_menu_expanded), composerStartRestartGroup, 0);
                Strings.Companion companion3 = Strings.INSTANCE;
                String strM4676getString2EP1pXo2 = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_dropdown_menu_collapsed), composerStartRestartGroup, 0);
                Strings.Companion companion4 = Strings.INSTANCE;
                String strM4676getString2EP1pXo3 = Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(R.string.m3c_dropdown_menu_toggle), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669228253, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    i4 = i3;
                    MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ExposedDropdownMenuAnchorType.m3630boximpl(ExposedDropdownMenuAnchorType.INSTANCE.m3638getPrimaryNotEditableoYjWRB4()), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                    objRememberedValue5 = mutableStateMutableStateOf$default;
                } else {
                    i4 = i3;
                }
                MutableState mutableState3 = (MutableState) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669231910, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    z2 = false;
                    str = strM4676getString2EP1pXo;
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    str = strM4676getString2EP1pXo;
                    z2 = false;
                }
                MutableState mutableState4 = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669236582, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                int i10 = i4 & 14;
                int i11 = i4 & 112;
                boolean zChanged = (i10 == 4 ? true : z2) | (i11 == 32 ? true : z2) | composerStartRestartGroup.changed(windowBoundsCalculatorPlatformWindowBoundsCalculator) | composerStartRestartGroup.changed(density);
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    modifier4 = companion;
                    str2 = "CC(remember):ExposedDropdownMenu.kt#9igjgp";
                    mutableIntState = mutableIntState3;
                    i5 = i10;
                    String str3 = str;
                    windowBoundsCalculator = windowBoundsCalculatorPlatformWindowBoundsCalculator;
                    i6 = i11;
                    i7 = i4;
                    i8 = iMo1618roundToPx0680j_4;
                    ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 = new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(focusRequester2, z, mutableState4, str3, strM4676getString2EP1pXo2, strM4676getString2EP1pXo3, softwareKeyboardController, mutableState3, function1, mutableIntState, mutableIntState4);
                    focusRequester = focusRequester2;
                    z3 = z;
                    composerStartRestartGroup.updateRememberedValue(exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1);
                    objRememberedValue7 = exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1;
                } else {
                    z3 = z;
                    modifier4 = companion;
                    str2 = "CC(remember):ExposedDropdownMenu.kt#9igjgp";
                    i6 = i11;
                    focusRequester = focusRequester2;
                    i7 = i4;
                    i8 = iMo1618roundToPx0680j_4;
                    mutableIntState = mutableIntState3;
                    i5 = i10;
                    windowBoundsCalculator = windowBoundsCalculatorPlatformWindowBoundsCalculator;
                }
                ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$12 = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669324893, str2);
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(windowBoundsCalculator) | composerStartRestartGroup.changed(i8);
                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    final MutableIntState mutableIntState5 = mutableIntState;
                    final int i12 = i8;
                    final WindowBoundsCalculator windowBoundsCalculator2 = windowBoundsCalculator;
                    objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$15$lambda$14(windowBoundsCalculator2, i12, mutableState2, mutableIntState5, mutableIntState4, (LayoutCoordinates) obj);
                        }
                    };
                    mutableState = mutableState2;
                    mutableIntState2 = mutableIntState4;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    mutableIntState2 = mutableIntState4;
                    mutableState = mutableState2;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier4, (Function1) objRememberedValue8);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnGloballyPositioned);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2140542826, "C228@10736L9:ExposedDropdownMenu.kt#uh7d8r");
                function32 = function3;
                function32.invoke(exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$12, composerStartRestartGroup, Integer.valueOf((i7 >> 6) & 112));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z3) {
                    composerStartRestartGroup.startReplaceGroup(209894723);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "232@10810L302,232@10781L331");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669339986, str2);
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(windowBoundsCalculator) | composerStartRestartGroup.changed(i8);
                    Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue9 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$18$lambda$17(windowBoundsCalculator, i8, mutableState, mutableIntState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) objRememberedValue9, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(210228190);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669350131, str2);
                int i13 = i5;
                boolean z4 = i13 == 4;
                Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (z4 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue10 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$20$lambda$19(z3, focusRequester);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue10, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669356895, str2);
                boolean z5 = i6 == 32;
                Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                if (z5 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue11 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$22$lambda$21(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BackHandler_androidKt.BackHandler(z3, (Function0) objRememberedValue11, composerStartRestartGroup, i13, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$23(z3, function1, modifier3, function32, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit ExposedDropdownMenuBox$lambda$15$lambda$14(WindowBoundsCalculator windowBoundsCalculator, int i, MutableState mutableState, MutableIntState mutableIntState, MutableIntState mutableIntState2, LayoutCoordinates layoutCoordinates) {
        mutableState.setValue(layoutCoordinates);
        mutableIntState.setIntValue((int) (layoutCoordinates.mo7777getSizeYbymL2g() >> 32));
        mutableIntState2.setIntValue(calculateMaxHeight(windowBoundsCalculator.getVisibleWindowBounds(), getAnchorBounds(ExposedDropdownMenuBox$lambda$2(mutableState)), i));
        return Unit.INSTANCE;
    }

    static final Unit ExposedDropdownMenuBox$lambda$18$lambda$17(WindowBoundsCalculator windowBoundsCalculator, int i, MutableState mutableState, MutableIntState mutableIntState) {
        mutableIntState.setIntValue(calculateMaxHeight(windowBoundsCalculator.getVisibleWindowBounds(), getAnchorBounds(ExposedDropdownMenuBox$lambda$2(mutableState)), i));
        return Unit.INSTANCE;
    }

    private static final LayoutCoordinates ExposedDropdownMenuBox$lambda$2(MutableState<LayoutCoordinates> mutableState) {
        return mutableState.getValue();
    }

    static final Unit ExposedDropdownMenuBox$lambda$20$lambda$19(boolean z, FocusRequester focusRequester) {
        if (z) {
            FocusRequester.m5985requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        }
        return Unit.INSTANCE;
    }

    static final Unit ExposedDropdownMenuBox$lambda$22$lambda$21(Function1 function1) {
        function1.invoke(false);
        return Unit.INSTANCE;
    }

    static final Unit ExposedDropdownMenuBox$lambda$23(boolean z, Function1 function1, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        ExposedDropdownMenuBox(z, function1, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$5(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$8(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    @Deprecated(message = "Renamed to ExposedDropdownMenuAnchorType", replaceWith = @ReplaceWith(expression = "ExposedDropdownMenuAnchorType", imports = {}))
    public static /* synthetic */ void MenuAnchorType$annotations() {
    }

    private static final int calculateMaxHeight(IntRect intRect, Rect rect, int i) {
        if (rect == null) {
            return 0;
        }
        int top = intRect.getTop() + i;
        int bottom = intRect.getBottom() - i;
        return Math.max((rect.getTop() > ((float) intRect.getBottom()) || rect.getBottom() < ((float) intRect.getTop())) ? bottom - top : MathKt.roundToInt(Math.max(rect.getTop() - top, bottom - rect.getBottom())), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: expandable-3-2CpT8, reason: not valid java name */
    public static final Modifier m3655expandable32CpT8(Modifier modifier, final boolean z, final Function0<Unit> function0, final String str, final MutableState<Boolean> mutableState, final String str2, final String str3, final String str4, final SoftwareKeyboardController softwareKeyboardController) {
        return SemanticsModifierKt.semantics$default(KeyInputModifierKt.onPreviewKeyEvent(SuspendingPointerInputFilterKt.pointerInput(modifier, function0, new PointerInputEventHandler() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$expandable$1

            /* JADX INFO: renamed from: androidx.compose.material3.ExposedDropdownMenuKt$expandable$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.ExposedDropdownMenuKt$expandable$1$1", f = "ExposedDropdownMenu.kt", i = {0}, l = {1426, 1430}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ String $anchorType;
                final /* synthetic */ Function0<Unit> $onExpandedChange;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(String str, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$anchorType = str;
                    this.$onExpandedChange = function0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$anchorType, this.$onExpandedChange, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
                
                    if (r11 == r0) goto L19;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    AwaitPointerEventScope awaitPointerEventScope;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = awaitPointerEventScope2;
                        this.label = 1;
                        obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, PointerEventPass.Initial, this, 1, null);
                        if (obj != coroutine_suspended) {
                            awaitPointerEventScope = awaitPointerEventScope2;
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        if (((PointerInputChange) obj) != null) {
                            this.$onExpandedChange.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    PointerInputChange pointerInputChange = (PointerInputChange) obj;
                    if (ExposedDropdownMenuAnchorType.m3633equalsimpl0(this.$anchorType, ExposedDropdownMenuAnchorType.INSTANCE.m3639getSecondaryEditableoYjWRB4())) {
                        pointerInputChange.consume();
                    }
                    this.L$0 = null;
                    this.label = 2;
                    obj = TapGestureDetectorKt.waitForUpOrCancellation(awaitPointerEventScope, PointerEventPass.Initial, this);
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass1(str, function0, null), continuation);
                return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
            }
        }), new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$expandable$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m3659invokeZmokQxo(keyEvent.m7470unboximpl());
            }

            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m3659invokeZmokQxo(android.view.KeyEvent keyEvent) {
                if (ExposedDropdownMenuKt.m3657isClickZmokQxo(keyEvent)) {
                    if (!ExposedDropdownMenuAnchorType.m3633equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m3637getPrimaryEditableoYjWRB4())) {
                        function0.invoke();
                    } else if (ExposedDropdownMenuKt.m3658isEnterMinusSpacebarZmokQxo(keyEvent)) {
                        function0.invoke();
                        return true;
                    }
                }
                if (ExposedDropdownMenuAnchorType.m3633equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m3637getPrimaryEditableoYjWRB4()) && z && (Key.m7173equalsimpl0(KeyEvent_androidKt.m7481getKeyZmokQxo(keyEvent), Key.INSTANCE.m7409getTabEK5gGoQ()) || Key.m7173equalsimpl0(KeyEvent_androidKt.m7481getKeyZmokQxo(keyEvent), Key.INSTANCE.m7246getDirectionDownEK5gGoQ()) || Key.m7173equalsimpl0(KeyEvent_androidKt.m7481getKeyZmokQxo(keyEvent), Key.INSTANCE.m7251getDirectionUpEK5gGoQ()))) {
                    mutableState.setValue(true);
                    return true;
                }
                mutableState.setValue(false);
                return false;
            }
        }), false, new Function1() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExposedDropdownMenuKt.expandable_3_2CpT8$lambda$25(str, z, str2, str3, str4, function0, softwareKeyboardController, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null);
    }

    static final Unit expandable_3_2CpT8$lambda$25(final String str, boolean z, String str2, String str3, String str4, final Function0 function0, final SoftwareKeyboardController softwareKeyboardController, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (ExposedDropdownMenuAnchorType.m3633equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m3639getSecondaryEditableoYjWRB4())) {
            SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8327getButtono7Vup1c());
            if (!z) {
                str2 = str3;
            }
            SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, str2);
            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str4);
        } else {
            SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8330getDropdownListo7Vup1c());
        }
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ExposedDropdownMenuKt.expandable_3_2CpT8$lambda$25$lambda$24(function0, str, softwareKeyboardController));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    static final boolean expandable_3_2CpT8$lambda$25$lambda$24(Function0 function0, String str, SoftwareKeyboardController softwareKeyboardController) {
        function0.invoke();
        if (!ExposedDropdownMenuAnchorType.m3633equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m3637getPrimaryEditableoYjWRB4()) || softwareKeyboardController == null) {
            return true;
        }
        softwareKeyboardController.show();
        return true;
    }

    private static final Rect getAnchorBounds(LayoutCoordinates layoutCoordinates) {
        return (layoutCoordinates == null || !layoutCoordinates.isAttached()) ? Rect.INSTANCE.getZero() : RectKt.m6120Recttz77jQw(LayoutCoordinatesKt.positionInWindow(layoutCoordinates), IntSizeKt.m9297toSizeozmzZPI(layoutCoordinates.mo7777getSizeYbymL2g()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hasGreaterOrEqualPriorityThan-vVDBVkM, reason: not valid java name */
    public static final boolean m3656hasGreaterOrEqualPriorityThanvVDBVkM(String str, String str2) {
        if (ExposedDropdownMenuAnchorType.m3633equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m3638getPrimaryNotEditableoYjWRB4()) || ExposedDropdownMenuAnchorType.m3633equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m3637getPrimaryEditableoYjWRB4())) {
            return true;
        }
        if (ExposedDropdownMenuAnchorType.m3633equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m3639getSecondaryEditableoYjWRB4())) {
            return ExposedDropdownMenuAnchorType.m3633equalsimpl0(str2, ExposedDropdownMenuAnchorType.INSTANCE.m3639getSecondaryEditableoYjWRB4());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isClick-ZmokQxo, reason: not valid java name */
    public static final boolean m3657isClickZmokQxo(android.view.KeyEvent keyEvent) {
        if (KeyEventType.m7474equalsimpl0(KeyEvent_androidKt.m7482getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7479getKeyUpCS__XNY())) {
            return m3658isEnterMinusSpacebarZmokQxo(keyEvent) || Key.m7173equalsimpl0(KeyEvent_androidKt.m7481getKeyZmokQxo(keyEvent), Key.INSTANCE.m7397getSpacebarEK5gGoQ());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isEnterMinusSpacebar-ZmokQxo, reason: not valid java name */
    public static final boolean m3658isEnterMinusSpacebarZmokQxo(android.view.KeyEvent keyEvent) {
        long jM7481getKeyZmokQxo = KeyEvent_androidKt.m7481getKeyZmokQxo(keyEvent);
        return Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7245getDirectionCenterEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7259getEnterEK5gGoQ()) || Key.m7173equalsimpl0(jM7481getKeyZmokQxo, Key.INSTANCE.m7351getNumPadEnterEK5gGoQ());
    }
}
