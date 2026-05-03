package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AndroidPopup.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aR\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001aD\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0010\u001a \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0002\u001a(\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u001b2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bH\u0001¢\u0006\u0002\u0010\"\u001a+\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0013\b\b\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bH\u0083\b¢\u0006\u0002\u0010&\u001a\f\u0010'\u001a\u00020\u0015*\u00020(H\u0000\u001a\u0014\u0010)\u001a\u00020\u0012*\u00020\t2\u0006\u0010*\u001a\u00020\u0015H\u0002\u001a\f\u0010+\u001a\u00020,*\u00020-H\u0002\u001a\u001c\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020(2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001bH\u0007\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001d¨\u00061²\u0006\u0015\u00102\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bX\u008a\u0084\u0002"}, d2 = {"Popup", "", "alignment", "Landroidx/compose/ui/Alignment;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/unit/IntOffset;", "onDismissRequest", "Lkotlin/Function0;", DiagnosticsEntry.PROPERTIES_KEY, "Landroidx/compose/ui/window/PopupProperties;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "Popup-K5zGePQ", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PopupPropertiesBaseFlags", "", "createFlags", "focusable", "", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "clippingEnabled", "LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalIsInPopupLayout", "getLocalIsInPopupLayout", "PopupTestTag", ViewHierarchyConstants.TAG_KEY, "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isFlagSecureEnabled", "Landroid/view/View;", "flagsWithSecureFlagInherited", "isParentFlagSecureEnabled", "toIntBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/graphics/Rect;", "isPopupLayout", ViewHierarchyConstants.VIEW_KEY, "testTag", "ui", "currentContent"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidPopup_androidKt {
    private static final int PopupPropertiesBaseFlags = 262144;
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(null, new Function0<String>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$LocalPopupTestTag$1
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "DEFAULT_TEST_TAG";
        }
    }, 1, null);
    private static final ProvidableCompositionLocal<Boolean> LocalIsInPopupLayout = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Boolean>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$LocalIsInPopupLayout$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return false;
        }
    }, 1, null);

    /* JADX WARN: Removed duplicated region for block: B:124:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Popup(PopupPositionProvider popupPositionProvider, Function0<Unit> function0, PopupProperties popupProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function02;
        int i4;
        PopupProperties popupProperties2;
        final Function0<Unit> function03;
        final PopupProperties popupProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i5;
        boolean z;
        String str;
        int i6;
        final LayoutDirection layoutDirection;
        final PopupPositionProvider popupPositionProvider2 = popupPositionProvider;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1772091631);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Popup)P(2,1,3)299@13430L7,300@13469L7,301@13513L7,302@13568L7,303@13604L28,304@13659L29,305@13724L21,305@13707L38,307@13875L7,308@13905L1203,338@15144L388,338@15114L418,353@15549L219,353@15538L230,362@15814L126,362@15774L166,374@16531L147,374@16503L175,387@16947L573,395@17528L99,384@16856L771:AndroidPopup.android.kt#2oxthz");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(popupPositionProvider2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                function02 = function0;
                i3 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    popupProperties2 = popupProperties;
                    i3 |= composerStartRestartGroup.changed(popupProperties2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
                    final Function0<Unit> function04 = i7 != 0 ? null : function02;
                    final PopupProperties popupProperties4 = i4 != 0 ? new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null) : popupProperties2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1772091631, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:298)");
                    }
                    ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localView);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    View view = (View) objConsume;
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Density density = (Density) objConsume2;
                    ProvidableCompositionLocal<String> providableCompositionLocal = LocalPopupTestTag;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String str2 = (String) objConsume3;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final LayoutDirection layoutDirection2 = (LayoutDirection) objConsume4;
                    CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                    final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i3 >> 9) & 14);
                    Object[] objArr = new Object[0];
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121974854, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    AndroidPopup_androidKt$Popup$popupId$1$1 androidPopup_androidKt$Popup$popupId$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (androidPopup_androidKt$Popup$popupId$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        androidPopup_androidKt$Popup$popupId$1$1RememberedValue = new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final UUID invoke() {
                                return UUID.randomUUID();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(androidPopup_androidKt$Popup$popupId$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    UUID uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr, (Function0) androidPopup_androidKt$Popup$popupId$1$1RememberedValue, composerStartRestartGroup, 48);
                    ProvidableCompositionLocal<Boolean> providableCompositionLocal2 = LocalIsInPopupLayout;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(providableCompositionLocal2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    boolean zBooleanValue = ((Boolean) objConsume5).booleanValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121981828, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        i5 = i3;
                        i6 = 32;
                        str = str2;
                        final PopupLayout popupLayout = new PopupLayout(function04, popupProperties4, str, view, density, popupPositionProvider2, uuid, zBooleanValue, null, 256, null);
                        popupPositionProvider2 = popupPositionProvider2;
                        z = true;
                        popupLayout.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-297523940, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i8) {
                                ComposerKt.sourceInformation(composer2, "C321@14454L616,321@14393L677:AndroidPopup.android.kt#2oxthz");
                                if (!composer2.shouldExecute((i8 & 3) != 2, i8 & 1)) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-297523940, i8, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:321)");
                                }
                                ProvidedValue<Boolean> providedValueProvides = AndroidPopup_androidKt.getLocalIsInPopupLayout().provides(true);
                                final PopupLayout popupLayout2 = popupLayout;
                                final State<Function2<Composer, Integer, Unit>> state = stateRememberUpdatedState;
                                CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(1022273628, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i9) {
                                        ComposerKt.sourceInformation(composer3, "C323@14540L16,325@14667L146,322@14480L568:AndroidPopup.android.kt#2oxthz");
                                        if (!composer3.shouldExecute((i9 & 3) != 2, i9 & 1)) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1022273628, i9, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:322)");
                                        }
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1142551508, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                        AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1 androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue = composer3.rememberedValue();
                                        if (androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                            androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1
                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    invoke2(semanticsPropertyReceiver);
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    SemanticsPropertiesKt.popup(semanticsPropertyReceiver);
                                                }
                                            };
                                            composer3.updateRememberedValue(androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) androidPopup_androidKt$Popup$popupLayout$1$1$1$1$1$1RememberedValue, 1, null);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1142547314, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                        boolean zChangedInstance = composer3.changedInstance(popupLayout2);
                                        final PopupLayout popupLayout3 = popupLayout2;
                                        Object objRememberedValue2 = composer3.rememberedValue();
                                        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue2 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$1$2$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                                    m9367invokeozmzZPI(intSize.m9289unboximpl());
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                                public final void m9367invokeozmzZPI(long j) {
                                                    popupLayout3.m9370setPopupContentSizefhxjrPA(IntSize.m9277boximpl(j));
                                                    popupLayout3.updatePosition();
                                                }
                                            };
                                            composer3.updateRememberedValue(objRememberedValue2);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Modifier modifierAlpha = AlphaKt.alpha(OnRemeasuredModifierKt.onSizeChanged(modifierSemantics$default, (Function1) objRememberedValue2), popupLayout2.getCanCalculatePosition() ? 1.0f : 0.0f);
                                        Function2 function2Popup$lambda$0 = AndroidPopup_androidKt.Popup$lambda$0(state);
                                        ComposerKt.sourceInformationMarkerStart(composer3, 26279861, "CC(SimpleStack)P(1)449@19649L899,449@19602L946:AndroidPopup.android.kt#2oxthz");
                                        ComposerKt.sourceInformationMarkerStart(composer3, -514852264, "CC(remember):AndroidPopup.android.kt#9igjgp");
                                        AndroidPopup_androidKt$SimpleStack$1$1 androidPopup_androidKt$SimpleStack$1$1RememberedValue = composer3.rememberedValue();
                                        if (androidPopup_androidKt$SimpleStack$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                            androidPopup_androidKt$SimpleStack$1$1RememberedValue = AndroidPopup_androidKt$SimpleStack$1$1.INSTANCE;
                                            composer3.updateRememberedValue(androidPopup_androidKt$SimpleStack$1$1RememberedValue);
                                        }
                                        MeasurePolicy measurePolicy = (MeasurePolicy) androidPopup_androidKt$SimpleStack$1$1RememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierAlpha);
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
                                        Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                        Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                        function2Popup$lambda$0.invoke(composer3, 0);
                                        composer3.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        composerStartRestartGroup.updateRememberedValue(popupLayout);
                        objRememberedValue = popupLayout;
                    } else {
                        i5 = i3;
                        z = true;
                        str = str2;
                        i6 = 32;
                    }
                    final PopupLayout popupLayout2 = (PopupLayout) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122020661, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    int i8 = i5;
                    int i9 = i8 & 112;
                    int i10 = i8 & 896;
                    LayoutDirection layoutDirection3 = layoutDirection2;
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(popupLayout2) | (i9 == i6 ? z : false) | (i10 == 256 ? z : false) | composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(layoutDirection3.ordinal());
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        final String str3 = str;
                        objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                popupLayout2.show();
                                popupLayout2.updateParameters(function04, popupProperties4, str3, layoutDirection2);
                                final PopupLayout popupLayout3 = popupLayout2;
                                return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        popupLayout3.disposeComposition();
                                        popupLayout3.dismiss();
                                    }
                                };
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.DisposableEffect(popupLayout2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122033452, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(popupLayout2) | (i9 == i6 ? z : false) | (i10 == 256 ? z : false) | composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(layoutDirection3.ordinal());
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        final String str4 = str;
                        layoutDirection = layoutDirection2;
                        objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                popupLayout2.updateParameters(function04, popupProperties4, str4, layoutDirection2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        layoutDirection = layoutDirection2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122041839, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    int i11 = i8 & 14;
                    boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(popupLayout2) | (i11 == 4 ? z : false);
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                popupLayout2.setPositionProvider(popupPositionProvider2);
                                popupLayout2.updatePosition();
                                return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                    }
                                };
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.DisposableEffect(popupPositionProvider2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composerStartRestartGroup, i11);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122064804, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(popupLayout2);
                    AndroidPopup_androidKt$Popup$5$1 androidPopup_androidKt$Popup$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance4 || androidPopup_androidKt$Popup$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        androidPopup_androidKt$Popup$5$1RememberedValue = new AndroidPopup_androidKt$Popup$5$1(popupLayout2, null);
                        composerStartRestartGroup.updateRememberedValue(androidPopup_androidKt$Popup$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(popupLayout2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) androidPopup_androidKt$Popup$5$1RememberedValue, composerStartRestartGroup, 0);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122078542, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(popupLayout2);
                    Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                invoke2(layoutCoordinates);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                                Intrinsics.checkNotNull(parentLayoutCoordinates);
                                popupLayout2.updateParentLayoutCoordinates(parentLayoutCoordinates);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) objRememberedValue5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2122096660, "CC(remember):AndroidPopup.android.kt#9igjgp");
                    boolean zChangedInstance6 = composerStartRestartGroup.changedInstance(popupLayout2) | composerStartRestartGroup.changed(layoutDirection3.ordinal());
                    MeasurePolicy measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance6 || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo1260measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                popupLayout2.setParentLayoutDirection(layoutDirection);
                                return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                    }
                                }, 4, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnGloballyPositioned);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -958253783, "C:AndroidPopup.android.kt#2oxthz");
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function03 = function04;
                    popupProperties3 = popupProperties4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function03 = function02;
                    popupProperties3 = popupProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.9
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i12) {
                            AndroidPopup_androidKt.Popup(popupPositionProvider2, function03, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 384;
            popupProperties2 = popupProperties;
            if ((i & 3072) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        function02 = function0;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        popupProperties2 = popupProperties;
        if ((i & 3072) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> Popup$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Popup-K5zGePQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m9366PopupK5zGePQ(Alignment alignment, long j, Function0<Unit> function0, PopupProperties popupProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Alignment alignment2;
        int i3;
        long j2;
        int i4;
        Function0<Unit> function02;
        int i5;
        PopupProperties popupProperties2;
        Function2<? super Composer, ? super Integer, Unit> function22;
        final Alignment topStart;
        final long jM9236constructorimpl;
        final Function0<Unit> function03;
        final PopupProperties popupProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(71005054);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Popup)P(!1,2:c#ui.unit.IntOffset,3,4)271@12454L82,273@12542L166:AndroidPopup.android.kt#2oxthz");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            alignment2 = alignment;
        } else if ((i & 6) == 0) {
            alignment2 = alignment;
            i3 = (composerStartRestartGroup.changed(alignment2) ? 4 : 2) | i;
        } else {
            alignment2 = alignment;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                j2 = j;
                i3 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    function02 = function0;
                    i3 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 == 0) {
                    if ((i & 3072) == 0) {
                        popupProperties2 = popupProperties;
                        i3 |= composerStartRestartGroup.changed(popupProperties2) ? 2048 : 1024;
                    }
                    if ((i & 24576) != 0) {
                        function22 = function2;
                        i3 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
                    } else {
                        function22 = function2;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        topStart = alignment2;
                        jM9236constructorimpl = j2;
                        function03 = function02;
                        popupProperties3 = popupProperties2;
                    } else {
                        topStart = i6 != 0 ? Alignment.INSTANCE.getTopStart() : alignment2;
                        jM9236constructorimpl = i7 != 0 ? IntOffset.m9236constructorimpl(0L) : j2;
                        DefaultConstructorMarker defaultConstructorMarker = null;
                        Function0<Unit> function04 = i4 != 0 ? null : function02;
                        PopupProperties popupProperties4 = i5 != 0 ? new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null) : popupProperties2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(71005054, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:269)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483613200, "CC(remember):AndroidPopup.android.kt#9igjgp");
                        boolean z = ((i3 & 14) == 4) | ((i3 & 112) == 32);
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jM9236constructorimpl, defaultConstructorMarker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Popup((AlignmentOffsetPositionProvider) objRememberedValue, function04, popupProperties4, function22, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function03 = function04;
                        popupProperties3 = popupProperties4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i8) {
                                AndroidPopup_androidKt.m9366PopupK5zGePQ(topStart, jM9236constructorimpl, function03, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 3072;
                popupProperties2 = popupProperties;
                if ((i & 24576) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function02 = function0;
            i5 = i2 & 8;
            if (i5 == 0) {
            }
            popupProperties2 = popupProperties;
            if ((i & 24576) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        j2 = j;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function02 = function0;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        popupProperties2 = popupProperties;
        if ((i & 24576) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    public static final void PopupTestTag(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1357513789);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PopupTestTag)P(1)441@19264L75:AndroidPopup.android.kt#2oxthz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1357513789, i2, -1, "androidx.compose.ui.window.PopupTestTag (AndroidPopup.android.kt:440)");
            }
            CompositionLocalKt.CompositionLocalProvider(LocalPopupTestTag.provides(str), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.PopupTestTag.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    AndroidPopup_androidKt.PopupTestTag(str, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 26279861, "CC(SimpleStack)P(1)449@19649L899,449@19602L946:AndroidPopup.android.kt#2oxthz");
        ComposerKt.sourceInformationMarkerStart(composer, -514852264, "CC(remember):AndroidPopup.android.kt#9igjgp");
        AndroidPopup_androidKt$SimpleStack$1$1 androidPopup_androidKt$SimpleStack$1$1RememberedValue = composer.rememberedValue();
        if (androidPopup_androidKt$SimpleStack$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            androidPopup_androidKt$SimpleStack$1$1RememberedValue = AndroidPopup_androidKt$SimpleStack$1$1.INSTANCE;
            composer.updateRememberedValue(androidPopup_androidKt$SimpleStack$1$1RememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) androidPopup_androidKt$SimpleStack$1$1RememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i2 = ((i << 3) & 112) | ((i >> 3) & 14) | 384;
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        int i3 = ((i2 << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        function2.invoke(composer, Integer.valueOf((i3 >> 6) & 14));
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int createFlags(boolean z, SecureFlagPolicy secureFlagPolicy, boolean z2) {
        int i = !z ? 262152 : 262144;
        if (secureFlagPolicy == SecureFlagPolicy.SecureOn) {
            i |= 8192;
        }
        return !z2 ? i | 512 : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int flagsWithSecureFlagInherited(PopupProperties popupProperties, boolean z) {
        return (popupProperties.getInheritSecurePolicy() && z) ? popupProperties.getFlags() | 8192 : (!popupProperties.getInheritSecurePolicy() || z) ? popupProperties.getFlags() : popupProperties.getFlags() & (-8193);
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalIsInPopupLayout() {
        return LocalIsInPopupLayout;
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    public static final boolean isFlagSecureEnabled(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }

    public static final boolean isPopupLayout(View view, String str) {
        if (view instanceof PopupLayout) {
            return str == null || Intrinsics.areEqual(str, ((PopupLayout) view).getTestTag());
        }
        return false;
    }

    public static /* synthetic */ boolean isPopupLayout$default(View view, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return isPopupLayout(view, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRect toIntBounds(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }
}
