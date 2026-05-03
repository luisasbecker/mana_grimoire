package com.revenuecat.purchases.ui.revenuecatui.components.pkg;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.style.PackageComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PackageComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"PackageComponentView", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/PackageComponentStyle;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "clickHandler", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "Lkotlin/coroutines/Continuation;", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/PackageComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class PackageComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:50:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void PackageComponentView(final PackageComponentStyle style, final PaywallState.Loaded.Components state, final Function2 clickHandler, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final PackageComponentStyle packageComponentStyle;
        Function2 function2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2117109345);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PackageComponentView)P(3,2)21@842L73,28@1069L196,32@1327L188,25@960L562:PackageComponentView.kt#axw9sz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(style) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(state) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(clickHandler) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2117109345, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentView (PackageComponentView.kt:20)");
                }
                int i6 = i3 & 14;
                i4 = i3;
                int i7 = i4 & 112;
                if (PackageComponentStateKt.rememberUpdatedPackageComponentState(style, state, composerStartRestartGroup, i4 & 126).getVisible()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        final Modifier modifier4 = modifier2;
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentViewKt.PackageComponentView.1
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

                            public final void invoke(Composer composer3, int i8) {
                                PackageComponentViewKt.PackageComponentView(style, state, clickHandler, modifier4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                packageComponentStyle = style;
                Modifier modifier5 = modifier2;
                function2 = clickHandler;
                StackComponentStyle stackComponentStyle = packageComponentStyle.getStackComponentStyle();
                composerStartRestartGroup.startReplaceGroup(-1617522223);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PackageComponentView.kt#9igjgp");
                boolean zChangedInstance = (i6 == 4) | composerStartRestartGroup.changedInstance(function2);
                PackageComponentViewKt$PackageComponentView$2$1 packageComponentViewKt$PackageComponentView$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || packageComponentViewKt$PackageComponentView$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    packageComponentViewKt$PackageComponentView$2$1RememberedValue = new PackageComponentViewKt$PackageComponentView$2$1(packageComponentStyle, function2, null);
                    composerStartRestartGroup.updateRememberedValue(packageComponentViewKt$PackageComponentView$2$1RememberedValue);
                }
                Function2 function22 = (Function2) packageComponentViewKt$PackageComponentView$2$1RememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                boolean zIsSelectable = packageComponentStyle.isSelectable();
                composerStartRestartGroup.startReplaceGroup(-1617513975);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PackageComponentView.kt#9igjgp");
                boolean z = (i7 == 32) | (i6 == 4);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentViewKt$PackageComponentView$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Modifier invoke(Modifier conditional) {
                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                            PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = state.getSelectedPackageInfo();
                            boolean z2 = !Intrinsics.areEqual(selectedPackageInfo != null ? selectedPackageInfo.getUniqueId() : null, packageComponentStyle.getUniqueId());
                            final PaywallState.Loaded.Components components = state;
                            final PackageComponentStyle packageComponentStyle2 = packageComponentStyle;
                            return ClickableKt.m1516clickableXHw0xAI$default(conditional, z2, null, null, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentViewKt$PackageComponentView$3$1.1
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
                                    components.update(packageComponentStyle2.getUniqueId());
                                }
                            }, 6, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
                StackComponentViewKt.StackComponentView(stackComponentStyle, state, function22, ModifierExtensionsKt.conditional(modifier5, zIsSelectable, (Function1) objRememberedValue), 0.0f, composer2, i7, 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                packageComponentStyle = style;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier2;
                function2 = clickHandler;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final PackageComponentStyle packageComponentStyle2 = packageComponentStyle;
                final Function2 function23 = function2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentViewKt.PackageComponentView.4
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

                    public final void invoke(Composer composer3, int i8) {
                        PackageComponentViewKt.PackageComponentView(packageComponentStyle2, state, function23, modifier3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i3 & 1171) == 1170) {
            if (i5 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i62 = i3 & 14;
            i4 = i3;
            int i72 = i4 & 112;
            if (PackageComponentStateKt.rememberUpdatedPackageComponentState(style, state, composerStartRestartGroup, i4 & 126).getVisible()) {
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
