package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.AppBarRowKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppBarRow.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002"}, d2 = {"AppBarRow", "", "overflowIndicator", "Lkotlin/Function1;", "Landroidx/compose/material3/AppBarMenuState;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "maxItemCount", "", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/material3/AppBarRowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "material3", "scope", "Landroidx/compose/material3/AppBarRowScopeImpl;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AppBarRowKt {

    /* JADX INFO: renamed from: androidx.compose.material3.AppBarRowKt$AppBarRow$2, reason: invalid class name */
    /* JADX INFO: compiled from: AppBarRow.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass2 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ AppBarMenuState $menuState;
        final /* synthetic */ Function3<AppBarMenuState, Composer, Integer, Unit> $overflowIndicator;
        final /* synthetic */ AppBarOverflowState $overflowState;
        final /* synthetic */ State<AppBarRowScopeImpl> $scope$delegate;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function3<? super AppBarMenuState, ? super Composer, ? super Integer, Unit> function3, AppBarMenuState appBarMenuState, AppBarOverflowState appBarOverflowState, State<AppBarRowScopeImpl> state) {
            this.$overflowIndicator = function3;
            this.$menuState = appBarMenuState;
            this.$overflowState = appBarOverflowState;
            this.$scope$delegate = state;
        }

        static final Unit invoke$lambda$2$lambda$1$lambda$0(AppBarMenuState appBarMenuState) {
            appBarMenuState.dismiss();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C73@3453L640:AppBarRow.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-815780026, i, -1, "androidx.compose.material3.AppBarRow.<anonymous> (AppBarRow.kt:73)");
            }
            Function3<AppBarMenuState, Composer, Integer, Unit> function3 = this.$overflowIndicator;
            final AppBarMenuState appBarMenuState = this.$menuState;
            final AppBarOverflowState appBarOverflowState = this.$overflowState;
            final State<AppBarRowScopeImpl> state = this.$scope$delegate;
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -337072597, "C74@3483L28,77@3658L23,78@3709L362,75@3536L535:AppBarRow.kt#uh7d8r");
            function3.invoke(appBarMenuState, composer, 6);
            boolean zIsExpanded = appBarMenuState.isExpanded();
            ComposerKt.sourceInformationMarkerStart(composer, 1790247043, "CC(remember):AppBarRow.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.AppBarRowKt$AppBarRow$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppBarRowKt.AnonymousClass2.invoke$lambda$2$lambda$1$lambda$0(appBarMenuState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidMenu_androidKt.m3285DropdownMenuIlH_yew(zIsExpanded, (Function0) objRememberedValue, null, 0L, null, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1786124721, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarRowKt$AppBarRow$2$1$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                    invoke(columnScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope columnScope, Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C*84@4021L22:AppBarRow.kt#uh7d8r");
                    if (!composer2.shouldExecute((i2 & 17) != 16, i2 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1786124721, i2, -1, "androidx.compose.material3.AppBarRow.<anonymous>.<anonymous>.<anonymous> (AppBarRow.kt:79)");
                    }
                    List<AppBarItem> listSubList = AppBarRowKt.AppBarRow$lambda$2(state).getItems().subList(appBarOverflowState.getVisibleItemCount(), appBarOverflowState.getTotalItemCount());
                    AppBarMenuState appBarMenuState2 = appBarMenuState;
                    int size = listSubList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        listSubList.get(i3).MenuContent(appBarMenuState2, composer2, 6);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54), composer, 48, 48, 2044);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AppBarRow(final Function3<? super AppBarMenuState, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, int i, final Function1<? super AppBarRowScope, Unit> function1, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        int i6;
        Modifier.Companion companion;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1891322548);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AppBarRow)N(overflowIndicator,modifier,maxItemCount,content)57@2869L29,58@2916L108,61@3045L30,62@3100L29,64@3162L132,71@3363L50,72@3431L680,68@3300L901:AppBarRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i7 = i3 & 2;
        if (i7 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 != 0) {
                if ((i2 & 384) == 0) {
                    i6 = i;
                    i4 |= composerStartRestartGroup.changed(i6) ? 256 : 128;
                }
                if ((i3 & 8) != 0) {
                    i4 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 1171) != 1170, i4 & 1)) {
                    companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                    if (i5 != 0) {
                        i6 = Integer.MAX_VALUE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1891322548, i4, -1, "androidx.compose.material3.AppBarRow (AppBarRow.kt:56)");
                    }
                    final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composerStartRestartGroup, (i4 >> 9) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 789813920, "CC(remember):AppBarRow.kt#9igjgp");
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.AppBarRowKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AppBarRowKt.AppBarRow$lambda$1$lambda$0(stateRememberUpdatedState);
                            }
                        });
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final State state = (State) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 789817970, "CC(remember):AppBarRow.kt#9igjgp");
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new AppBarMenuState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    AppBarMenuState appBarMenuState = (AppBarMenuState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AppBarOverflowState appBarOverflowStateRememberAppBarOverflowState = AppBarDslKt.rememberAppBarOverflowState(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 789821816, "CC(remember):AppBarRow.kt#9igjgp");
                    boolean zChanged = ((i4 & 896) == 256) | composerStartRestartGroup.changed(appBarOverflowStateRememberAppBarOverflowState);
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new OverflowMeasurePolicy(appBarOverflowStateRememberAppBarOverflowState, i6, false);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    OverflowMeasurePolicy overflowMeasurePolicy = (OverflowMeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(68955781, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarRowKt.AppBarRow.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i8) {
                            ComposerKt.sourceInformation(composer2, "C*71@3394L15:AppBarRow.kt#uh7d8r");
                            if (!composer2.shouldExecute((i8 & 3) != 2, i8 & 1)) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(68955781, i8, -1, "androidx.compose.material3.AppBarRow.<anonymous> (AppBarRow.kt:71)");
                            }
                            List<AppBarItem> items = AppBarRowKt.AppBarRow$lambda$2(state).getItems();
                            int size = items.size();
                            for (int i9 = 0; i9 < size; i9++) {
                                items.get(i9).AppbarContent(composer2, 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-815780026, true, new AnonymousClass2(function3, appBarMenuState, appBarOverflowStateRememberAppBarOverflowState, state), composerStartRestartGroup, 54)});
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                    boolean zChanged2 = composerStartRestartGroup.changed(overflowMeasurePolicy);
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = MultiContentMeasurePolicyKt.createMeasurePolicy(overflowMeasurePolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                }
                final int i8 = i6;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarRowKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarRowKt.AppBarRow$lambda$5(function3, modifier3, i8, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 384;
            i6 = i;
            if ((i3 & 8) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 1171) != 1170, i4 & 1)) {
            }
            final int i82 = i6;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 4;
        if (i5 != 0) {
        }
        i6 = i;
        if ((i3 & 8) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 1171) != 1170, i4 & 1)) {
        }
        final int i822 = i6;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final AppBarRowScopeImpl AppBarRow$lambda$1$lambda$0(State state) {
        AppBarRowScopeImpl appBarRowScopeImpl = new AppBarRowScopeImpl(new AppBarScopeImpl());
        ((Function1) state.getValue()).invoke(appBarRowScopeImpl);
        return appBarRowScopeImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBarRowScopeImpl AppBarRow$lambda$2(State<AppBarRowScopeImpl> state) {
        return state.getValue();
    }

    static final Unit AppBarRow$lambda$5(Function3 function3, Modifier modifier, int i, Function1 function1, int i2, int i3, Composer composer, int i4) {
        AppBarRow(function3, modifier, i, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }
}
