package androidx.navigationevent.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.NavigationEventInfo;
import androidx.navigationevent.NavigationEventTransitionState;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: NavigationEventHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001aq\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\r\u001aE\u0010\u000e\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\u000f\u001aE\u0010\u0010\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"NavigationEventHandler", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/navigationevent/compose/NavigationEventState;", "Landroidx/navigationevent/NavigationEventInfo;", "isForwardEnabled", "", "onForwardCancelled", "Lkotlin/Function0;", "onForwardCompleted", "isBackEnabled", "onBackCancelled", "onBackCompleted", "(Landroidx/navigationevent/compose/NavigationEventState;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "NavigationBackHandler", "(Landroidx/navigationevent/compose/NavigationEventState;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "NavigationForwardHandler", "navigationevent-compose"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationEventHandlerKt {
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationBackHandler(final NavigationEventState<? extends NavigationEventInfo> navigationEventState, boolean z, Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i, final int i2) {
        NavigationEventState<? extends NavigationEventInfo> navigationEventState2;
        int i3;
        boolean z2;
        int i4;
        Function0<Unit> function03;
        final boolean z3;
        final Function0<Unit> function04;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<Unit> function05;
        Composer composerStartRestartGroup = composer.startRestartGroup(1220469155);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationBackHandler)N(state,isBackEnabled,onBackCancelled,onBackCompleted)144@6491L2,149@6612L2,150@6645L2,147@6536L296:NavigationEventHandler.kt#wc8b4r");
        if ((i & 6) == 0) {
            navigationEventState2 = navigationEventState;
            i3 = (composerStartRestartGroup.changed(navigationEventState2) ? 4 : 2) | i;
        } else {
            navigationEventState2 = navigationEventState;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function03 = function0;
                    i3 |= composerStartRestartGroup.changedInstance(function03) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function02) ? 2048 : 1024;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
                    boolean z4 = i5 == 0 ? z2 : true;
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 344791685, "CC(remember):NavigationEventHandler.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function05 = (Function0) objRememberedValue;
                    } else {
                        function05 = function03;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1220469155, i3, -1, "androidx.navigationevent.compose.NavigationBackHandler (NavigationEventHandler.kt:146)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 344795557, "CC(remember):NavigationEventHandler.kt#9igjgp");
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function0 function06 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 344796613, "CC(remember):NavigationEventHandler.kt#9igjgp");
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function07 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i6 = (i3 & 14) | 3504;
                    int i7 = i3 << 9;
                    NavigationEventHandler(navigationEventState2, false, function06, function07, z4, function05, function02, composerStartRestartGroup, i6 | (57344 & i7) | (458752 & i7) | (i7 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z4;
                    function04 = function05;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z3 = z2;
                    function04 = function03;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationEventHandlerKt.NavigationBackHandler$lambda$24(navigationEventState, z3, function04, function02, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 384;
            function03 = function0;
            if ((i & 3072) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        z2 = z;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        function03 = function0;
        if ((i & 3072) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit NavigationBackHandler$lambda$24(NavigationEventState navigationEventState, boolean z, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        NavigationBackHandler(navigationEventState, z, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationEventHandler(final NavigationEventState<? extends NavigationEventInfo> navigationEventState, boolean z, Function0<Unit> function0, Function0<Unit> function02, boolean z2, Function0<Unit> function03, Function0<Unit> function04, Composer composer, final int i, final int i2) {
        int i3;
        boolean z3;
        int i4;
        Function0<Unit> function05;
        int i5;
        Function0<Unit> function06;
        int i6;
        boolean z4;
        int i7;
        final Function0<Unit> function07;
        int i8;
        final boolean z5;
        final Function0<Unit> function08;
        final boolean z6;
        final Function0<Unit> function09;
        final Function0<Unit> function010;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Object obj;
        final ComposeNavigationEventHandler composeNavigationEventHandler;
        Composer composerStartRestartGroup = composer.startRestartGroup(898330592);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationEventHandler)N(state,isForwardEnabled,onForwardCancelled,onForwardCompleted,isBackEnabled,onBackCancelled,onBackCompleted)73@3839L2,74@3880L2,77@3982L2,78@4020L2,81@4106L7,87@4303L276,96@4596L467,96@4585L478,108@5093L373,108@5069L397:NavigationEventHandler.kt#wc8b4r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(navigationEventState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                z3 = z;
                i3 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    function05 = function0;
                    i3 |= composerStartRestartGroup.changedInstance(function05) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        function06 = function02;
                        i3 |= composerStartRestartGroup.changedInstance(function06) ? 2048 : 1024;
                    }
                    i6 = i2 & 16;
                    if (i6 != 0) {
                        if ((i & 24576) == 0) {
                            z4 = z2;
                            i3 |= composerStartRestartGroup.changed(z4) ? 16384 : 8192;
                        }
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            function07 = function03;
                        } else {
                            function07 = function03;
                            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i3 |= composerStartRestartGroup.changedInstance(function07) ? 131072 : 65536;
                            }
                        }
                        i8 = i2 & 64;
                        if (i8 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function04) ? 1048576 : 524288;
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                            z5 = i9 != 0 ? true : z3;
                            if (i4 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 7279202, "CC(remember):NavigationEventHandler.kt#9igjgp");
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function08 = (Function0) objRememberedValue;
                            } else {
                                function08 = function05;
                            }
                            if (i5 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 7280514, "CC(remember):NavigationEventHandler.kt#9igjgp");
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda15
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function09 = (Function0) objRememberedValue2;
                            } else {
                                function09 = function06;
                            }
                            z6 = i6 != 0 ? true : z4;
                            if (i7 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 7283778, "CC(remember):NavigationEventHandler.kt#9igjgp");
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function07 = (Function0) objRememberedValue3;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 7284994, "CC(remember):NavigationEventHandler.kt#9igjgp");
                                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function010 = (Function0) objRememberedValue4;
                            } else {
                                function010 = function04;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(898330592, i3, -1, "androidx.navigationevent.compose.NavigationEventHandler (NavigationEventHandler.kt:79)");
                            }
                            NavigationEventDispatcherOwner current = LocalNavigationEventDispatcherOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                            if (current == null) {
                                throw new IllegalStateException("No NavigationEventDispatcher was provided via LocalNavigationEventDispatcherOwner".toString());
                            }
                            final NavigationEventDispatcher navigationEventDispatcher = current.getNavigationEventDispatcher();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 7294324, "CC(remember):NavigationEventHandler.kt#9igjgp");
                            int i10 = i3 & 14;
                            boolean z7 = i10 == 4;
                            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (z7 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new ComposeNavigationEventHandler(navigationEventState.getCurrentInfo(), new Function1() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return NavigationEventHandlerKt.NavigationEventHandler$lambda$10$lambda$9(navigationEventState, (NavigationEventTransitionState) obj2);
                                    }
                                });
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposeNavigationEventHandler composeNavigationEventHandler2 = (ComposeNavigationEventHandler) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 7303891, "CC(remember):NavigationEventHandler.kt#9igjgp");
                            boolean zChangedInstance = composerStartRestartGroup.changedInstance(composeNavigationEventHandler2) | ((i3 & 112) == 32) | ((i3 & 896) == 256) | ((i3 & 7168) == 2048) | ((57344 & i3) == 16384) | ((458752 & i3) == 131072) | ((i3 & 3670016) == 1048576) | (i10 == 4);
                            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                composeNavigationEventHandler = composeNavigationEventHandler2;
                                obj = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return NavigationEventHandlerKt.NavigationEventHandler$lambda$12$lambda$11(composeNavigationEventHandler, z5, function08, function09, z6, function07, function010, navigationEventState);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(obj);
                            } else {
                                obj = objRememberedValue6;
                                composeNavigationEventHandler = composeNavigationEventHandler2;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.SideEffect((Function0) obj, composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 7319701, "CC(remember):NavigationEventHandler.kt#9igjgp");
                            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(composeNavigationEventHandler) | (i10 == 4) | composerStartRestartGroup.changedInstance(navigationEventDispatcher);
                            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue7 = new Function1() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return NavigationEventHandlerKt.NavigationEventHandler$lambda$16$lambda$15(navigationEventState, composeNavigationEventHandler, navigationEventDispatcher, (DisposableEffectScope) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.DisposableEffect(navigationEventState, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue7, composerStartRestartGroup, i10);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            z5 = z3;
                            function08 = function05;
                            z6 = z4;
                            function09 = function06;
                            function010 = function04;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return NavigationEventHandlerKt.NavigationEventHandler$lambda$17(navigationEventState, z5, function08, function09, z6, function07, function010, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 24576;
                    z4 = z2;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function06 = function02;
                i6 = i2 & 16;
                if (i6 != 0) {
                }
                z4 = z2;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function05 = function0;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function06 = function02;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            z4 = z2;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            i8 = i2 & 64;
            if (i8 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        z3 = z;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function05 = function0;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function06 = function02;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        z4 = z2;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        i8 = i2 & 64;
        if (i8 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit NavigationEventHandler$lambda$10$lambda$9(NavigationEventState navigationEventState, NavigationEventTransitionState navigationEventTransitionState) {
        navigationEventState.setTransitionState$navigationevent_compose(navigationEventTransitionState);
        return Unit.INSTANCE;
    }

    static final Unit NavigationEventHandler$lambda$12$lambda$11(ComposeNavigationEventHandler composeNavigationEventHandler, boolean z, Function0 function0, Function0 function02, boolean z2, Function0 function03, Function0 function04, NavigationEventState navigationEventState) {
        composeNavigationEventHandler.setForwardEnabled(z);
        composeNavigationEventHandler.setCurrentOnForwardCancelled(function0);
        composeNavigationEventHandler.setCurrentOnForwardCompleted(function02);
        composeNavigationEventHandler.setBackEnabled(z2);
        composeNavigationEventHandler.setCurrentOnBackCancelled(function03);
        composeNavigationEventHandler.setCurrentOnBackCompleted(function04);
        composeNavigationEventHandler.setInfo(navigationEventState.getCurrentInfo(), navigationEventState.getBackInfo(), navigationEventState.getForwardInfo());
        return Unit.INSTANCE;
    }

    static final DisposableEffectResult NavigationEventHandler$lambda$16$lambda$15(final NavigationEventState navigationEventState, final ComposeNavigationEventHandler composeNavigationEventHandler, NavigationEventDispatcher navigationEventDispatcher, DisposableEffectScope disposableEffectScope) {
        if (navigationEventState.getSourceHandler$navigationevent_compose() != null) {
            throw new IllegalArgumentException(("NavigationEventState '" + navigationEventState + "' is already registered with a NavigationEventHandler '" + composeNavigationEventHandler + "'.").toString());
        }
        ComposeNavigationEventHandler composeNavigationEventHandler2 = composeNavigationEventHandler;
        navigationEventState.setSourceHandler$navigationevent_compose(composeNavigationEventHandler2);
        NavigationEventDispatcher.addHandler$default(navigationEventDispatcher, composeNavigationEventHandler2, 0, 2, null);
        return new DisposableEffectResult() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$NavigationEventHandler$lambda$16$lambda$15$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                composeNavigationEventHandler.remove();
                navigationEventState.setSourceHandler$navigationevent_compose(null);
            }
        };
    }

    static final Unit NavigationEventHandler$lambda$17(NavigationEventState navigationEventState, boolean z, Function0 function0, Function0 function02, boolean z2, Function0 function03, Function0 function04, int i, int i2, Composer composer, int i3) {
        NavigationEventHandler(navigationEventState, z, function0, function02, z2, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationForwardHandler(final NavigationEventState<? extends NavigationEventInfo> navigationEventState, boolean z, Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i, final int i2) {
        NavigationEventState<? extends NavigationEventInfo> navigationEventState2;
        int i3;
        boolean z2;
        int i4;
        final Function0<Unit> function03;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<Unit> function04;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1737636087);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationForwardHandler)N(state,isForwardEnabled,onForwardCancelled,onForwardCompleted)179@7856L2,187@8120L2,188@8150L2,182@7904L302:NavigationEventHandler.kt#wc8b4r");
        if ((i & 6) == 0) {
            navigationEventState2 = navigationEventState;
            i3 = (composerStartRestartGroup.changed(navigationEventState2) ? 4 : 2) | i;
        } else {
            navigationEventState2 = navigationEventState;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function02) ? 2048 : 1024;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
                    boolean z4 = i5 != 0 ? true : z2;
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 874004363, "CC(remember):NavigationEventHandler.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function04 = (Function0) objRememberedValue;
                    } else {
                        function04 = function0;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1737636087, i3, -1, "androidx.navigationevent.compose.NavigationForwardHandler (NavigationEventHandler.kt:181)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 874012811, "CC(remember):NavigationEventHandler.kt#9igjgp");
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function0 function05 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 874013771, "CC(remember):NavigationEventHandler.kt#9igjgp");
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    NavigationEventHandler(navigationEventState2, z4, function04, function02, false, function05, (Function0) objRememberedValue3, composerStartRestartGroup, (i3 & 14) | 1794048 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z4;
                    function03 = function04;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function03 = function0;
                    z3 = z2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.navigationevent.compose.NavigationEventHandlerKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationEventHandlerKt.NavigationForwardHandler$lambda$31(navigationEventState, z3, function03, function02, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 384;
            if ((i & 3072) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        z2 = z;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        if ((i & 3072) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit NavigationForwardHandler$lambda$31(NavigationEventState navigationEventState, boolean z, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        NavigationForwardHandler(navigationEventState, z, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }
}
