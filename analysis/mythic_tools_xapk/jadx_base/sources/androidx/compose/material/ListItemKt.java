package androidx.compose.material;

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
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0015\b\u0002\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\r\u001a8\u0010\u000e\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0013\u001a4\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0013\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u0006H\u0002¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "secondaryText", "singleLineSecondaryText", "", "overlineText", "trailing", "text", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BaselinesOffsetColumn", "offsets", "", "Landroidx/compose/ui/unit/Dp;", FirebaseAnalytics.Param.CONTENT, "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OffsetToBaselineOrCenter", TypedValues.CycleType.S_WAVE_OFFSET, "OffsetToBaselineOrCenter-Kz89ssw", "(FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "applyTextStyle", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "(Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ListItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void BaselinesOffsetColumn(final List<Dp> list, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(872528548);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BaselinesOffsetColumn)N(offsets,modifier,content)365@13317L1092,365@13291L1118:ListItem.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(872528548, i3, -1, "androidx.compose.material.BaselinesOffsetColumn (ListItem.kt:364)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 981317992, "CC(remember):ListItem.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(list);
            ListItemKt$BaselinesOffsetColumn$1$1 listItemKt$BaselinesOffsetColumn$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || listItemKt$BaselinesOffsetColumn$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                listItemKt$BaselinesOffsetColumn$1$1RememberedValue = new ListItemKt$BaselinesOffsetColumn$1$1(list);
                composerStartRestartGroup.updateRememberedValue(listItemKt$BaselinesOffsetColumn$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) listItemKt$BaselinesOffsetColumn$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i5 = ((i3 >> 6) & 14) | (i3 & 112);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i6 = ((i5 << 6) & 896) | 6;
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 6) & 14));
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ListItemKt.BaselinesOffsetColumn$lambda$1(list, modifier2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit BaselinesOffsetColumn$lambda$1(List list, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        BaselinesOffsetColumn(list, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ListItem(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i7;
        final Modifier modifier2;
        final boolean z2;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1618131318);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ListItem)N(modifier,icon,secondaryText,singleLineSecondaryText,overlineText,trailing,text)88@3495L10,90@3578L4,91@3668L6,92@3769L4,93@3862L4,95@3951L2:ListItem.kt#jmzs0o");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                function26 = function2;
                i3 |= composerStartRestartGroup.changedInstance(function26) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    function27 = function22;
                    i3 |= composerStartRestartGroup.changedInstance(function27) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        i3 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
                    }
                    i6 = i2 & 16;
                    if (i6 != 0) {
                        if ((i & 24576) == 0) {
                            function28 = function23;
                            i3 |= composerStartRestartGroup.changedInstance(function28) ? 16384 : 8192;
                        }
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function24) ? 131072 : 65536;
                        }
                        if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function25) ? 1048576 : 524288;
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                            Modifier.Companion companion = i8 != 0 ? Modifier.INSTANCE : modifier;
                            Function2<? super Composer, ? super Integer, Unit> function213 = i9 != 0 ? null : function26;
                            Function2<? super Composer, ? super Integer, Unit> function214 = i4 != 0 ? null : function27;
                            boolean z3 = i5 != 0 ? true : z;
                            Function2<? super Composer, ? super Integer, Unit> function215 = i6 != 0 ? null : function28;
                            Function2<? super Composer, ? super Integer, Unit> function216 = i7 == 0 ? function24 : null;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1618131318, i3, -1, "androidx.compose.material.ListItem (ListItem.kt:87)");
                            }
                            Typography typography = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            Function2<Composer, Integer, Unit> function2ApplyTextStyle = applyTextStyle(typography.getSubtitle1(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function25);
                            Intrinsics.checkNotNull(function2ApplyTextStyle);
                            Function2<Composer, Integer, Unit> function2ApplyTextStyle2 = applyTextStyle(typography.getBody2(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), function214);
                            Function2<Composer, Integer, Unit> function2ApplyTextStyle3 = applyTextStyle(typography.getOverline(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function215);
                            Function2<Composer, Integer, Unit> function2ApplyTextStyle4 = applyTextStyle(typography.getCaption(), ContentAlpha.INSTANCE.getHigh(composerStartRestartGroup, 6), function216);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 246061688, "CC(remember):ListItem.kt#9igjgp");
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ListItemKt.ListItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                            if (function2ApplyTextStyle2 == null && function2ApplyTextStyle3 == null) {
                                composerStartRestartGroup.startReplaceGroup(-961949257);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "98@4040L61");
                                OneLine.INSTANCE.ListItem(modifierSemantics, function213, function2ApplyTextStyle, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 24576, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else if ((function2ApplyTextStyle3 == null && z3) || function2ApplyTextStyle2 == null) {
                                composerStartRestartGroup.startReplaceGroup(-961749989);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "102@4237L185");
                                TwoLine.INSTANCE.ListItem(modifierSemantics, function213, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-961536647);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "111@4454L185");
                                ThreeLine.INSTANCE.ListItem(modifierSemantics, function213, function2ApplyTextStyle, function2ApplyTextStyle2, function2ApplyTextStyle3, function2ApplyTextStyle4, composerStartRestartGroup, (i3 & 112) | 1572864, 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function211 = function214;
                            z2 = z3;
                            function212 = function215;
                            function210 = function213;
                            function29 = function216;
                            modifier2 = companion;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            z2 = z;
                            function29 = function24;
                            function210 = function26;
                            function211 = function27;
                            function212 = function28;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ListItemKt.ListItem$lambda$1(modifier2, function210, function211, z2, function212, function29, function25, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 24576;
                    function28 = function23;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    if ((i & 1572864) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                }
                function28 = function23;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function27 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            function28 = function23;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        function26 = function2;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function27 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        function28 = function23;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListItem$lambda$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    static final Unit ListItem$lambda$1(Modifier modifier, Function2 function2, Function2 function22, boolean z, Function2 function23, Function2 function24, Function2 function25, int i, int i2, Composer composer, int i3) {
        ListItem(modifier, function2, function22, z, function23, function24, function25, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: OffsetToBaselineOrCenter-Kz89ssw, reason: not valid java name */
    public static final void m3069OffsetToBaselineOrCenterKz89ssw(final float f, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(953221030);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OffsetToBaselineOrCenter)N(offset:c#ui.unit.Dp,modifier,content)404@14961L830,404@14935L856:ListItem.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(953221030, i3, -1, "androidx.compose.material.OffsetToBaselineOrCenter (ListItem.kt:403)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1217381476, "CC(remember):ListItem.kt#9igjgp");
            boolean z = (i3 & 14) == 4;
            ListItemKt$OffsetToBaselineOrCenter$1$1 listItemKt$OffsetToBaselineOrCenter$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || listItemKt$OffsetToBaselineOrCenter$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                listItemKt$OffsetToBaselineOrCenter$1$1RememberedValue = new ListItemKt$OffsetToBaselineOrCenter$1$1(f);
                composerStartRestartGroup.updateRememberedValue(listItemKt$OffsetToBaselineOrCenter$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) listItemKt$OffsetToBaselineOrCenter$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i5 = ((((i3 & 112) | ((i3 >> 6) & 14)) << 6) & 896) | 6;
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 6) & 14));
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ListItemKt.OffsetToBaselineOrCenter_Kz89ssw$lambda$1(f, modifier2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit OffsetToBaselineOrCenter_Kz89ssw$lambda$1(float f, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        m3069OffsetToBaselineOrCenterKz89ssw(f, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final Function2<Composer, Integer, Unit> applyTextStyle(final TextStyle textStyle, final float f, final Function2<? super Composer, ? super Integer, Unit> function2) {
        if (function2 == null) {
            return null;
        }
        final LineHeightStyle lineHeightStyle = new LineHeightStyle(LineHeightStyle.Alignment.INSTANCE.m8960getProportionalPIaL0Z0(), LineHeightStyle.Trim.INSTANCE.m8981getBothEVpEnUU(), (DefaultConstructorMarker) null);
        return ComposableLambdaKt.composableLambdaInstance(-1000595778, true, new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ListItemKt.applyTextStyle$lambda$0(f, textStyle, lineHeightStyle, function2, (Composer) obj, ((Integer) obj2).intValue());
            }
        });
    }

    static final Unit applyTextStyle$lambda$0(float f, final TextStyle textStyle, final LineHeightStyle lineHeightStyle, final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C438@16234L97,438@16168L163:ListItem.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1000595778, i, -1, "androidx.compose.material.applyTextStyle.<anonymous> (ListItem.kt:438)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(f)), ComposableLambdaKt.rememberComposableLambda(-925826178, true, new Function2() { // from class: androidx.compose.material.ListItemKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ListItemKt.applyTextStyle$lambda$0$0(textStyle, lineHeightStyle, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyTextStyle$lambda$0$0(TextStyle textStyle, LineHeightStyle lineHeightStyle, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C439@16248L73:ListItem.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-925826178, i, -1, "androidx.compose.material.applyTextStyle.<anonymous>.<anonymous> (ListItem.kt:439)");
            }
            TextKt.ProvideTextStyle(TextStyle.m8569copyp1EtxEg$default(textStyle, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, lineHeightStyle, 0, 0, null, 15728639, null), function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
