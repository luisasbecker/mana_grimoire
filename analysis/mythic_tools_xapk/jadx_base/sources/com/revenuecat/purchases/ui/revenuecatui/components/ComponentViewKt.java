package com.revenuecat.purchases.ui.revenuecatui.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.header.HeaderComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.stickyfooter.StickyFooterComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.CountdownComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.HeaderComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ImageComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.PackageComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StickyFooterComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabControlButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabControlStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabControlToggleComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabsComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TimelineComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.VideoComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlButtonViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"ComponentView", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "onClick", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "Lkotlin/coroutines/Continuation;", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class ComponentViewKt {
    public static final /* synthetic */ void ComponentView(final ComponentStyle style, PaywallState.Loaded.Components state, Function2 onClick, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        PaywallState.Loaded.Components components;
        Function2 function2;
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-294729441);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComponentView)P(3,2,1):ComponentView.kt#dnqhhd");
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
            i3 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            components = state;
            function2 = onClick;
            modifier2 = modifier;
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-294729441, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.ComponentView (ComponentView.kt:51)");
            }
            if (style instanceof StackComponentStyle) {
                composerStartRestartGroup.startReplaceGroup(754743095);
                ComposerKt.sourceInformation(composerStartRestartGroup, "52@3392L132");
                components = state;
                function2 = onClick;
                StackComponentViewKt.StackComponentView((StackComponentStyle) style, components, function2, modifier3, 0.0f, composerStartRestartGroup, i3 & 8176, 16);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                components = state;
                Function2 function22 = onClick;
                if (style instanceof TextComponentStyle) {
                    composerStartRestartGroup.startReplaceGroup(754748246);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "58@3554L99");
                    TextComponentViewKt.TextComponentView((TextComponentStyle) style, components, modifier3, composerStartRestartGroup, (i3 & 112) | ((i3 >> 3) & 896), 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    modifier3 = modifier3;
                    composerStartRestartGroup.endReplaceGroup();
                } else if (style instanceof ImageComponentStyle) {
                    composerStartRestartGroup.startReplaceGroup(754752376);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "63@3684L69");
                    ImageComponentViewKt.ImageComponentView((ImageComponentStyle) style, components, modifier3, composerStartRestartGroup, (i3 & 112) | ((i3 >> 3) & 896), 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    modifier3 = modifier3;
                    composerStartRestartGroup.endReplaceGroup();
                } else if (style instanceof VideoComponentStyle) {
                    composerStartRestartGroup.startReplaceGroup(1922588331);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "65@3794L116");
                    VideoComponentViewKt.VideoComponentView((VideoComponentStyle) style, components, modifier3, null, composerStartRestartGroup, (i3 & 112) | ((i3 >> 3) & 896), 8);
                    modifier3 = modifier3;
                    composerStartRestartGroup.endReplaceGroup();
                } else if (style instanceof ButtonComponentStyle) {
                    composerStartRestartGroup.startReplaceGroup(754760844);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "71@3948L89");
                    function2 = function22;
                    ButtonComponentViewKt.ButtonComponentView((ButtonComponentStyle) style, components, function2, modifier3, composerStartRestartGroup, i3 & 8176, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    function2 = function22;
                    if (style instanceof HeaderComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754764760);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "72@4069L133");
                        HeaderComponentViewKt.HeaderComponentView((HeaderComponentStyle) style, components, function2, modifier3, composerStartRestartGroup, i3 & 8176, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof StickyFooterComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754770238);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "78@4240L139");
                        StickyFooterComponentViewKt.StickyFooterComponentView((StickyFooterComponentStyle) style, components, function2, modifier3, composerStartRestartGroup, i3 & 8176, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof PackageComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754775737);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "84@4412L134");
                        PackageComponentViewKt.PackageComponentView((PackageComponentStyle) style, components, function2, modifier3, composerStartRestartGroup, i3 & 8176, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        function22 = function2;
                        if (style instanceof IconComponentStyle) {
                            composerStartRestartGroup.startReplaceGroup(754780919);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "90@4576L68");
                            IconComponentViewKt.IconComponentView((IconComponentStyle) style, components, modifier3, composerStartRestartGroup, (i3 & 112) | ((i3 >> 3) & 896), 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            modifier3 = modifier3;
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (style instanceof TimelineComponentStyle) {
                            composerStartRestartGroup.startReplaceGroup(754784187);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "91@4678L72");
                            TimelineComponentViewKt.TimelineComponentView((TimelineComponentStyle) style, components, modifier3, composerStartRestartGroup, (i3 & 112) | ((i3 >> 3) & 896), 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            modifier3 = modifier3;
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (style instanceof CarouselComponentStyle) {
                            composerStartRestartGroup.startReplaceGroup(754787642);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "92@4784L135");
                            function2 = function22;
                            CarouselComponentViewKt.CarouselComponentView((CarouselComponentStyle) style, components, function2, modifier3, composerStartRestartGroup, i3 & 8176, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            function2 = function22;
                            if (style instanceof TabsComponentStyle) {
                                composerStartRestartGroup.startReplaceGroup(754792918);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "98@4949L131");
                                TabsComponentViewKt.TabsComponentView((TabsComponentStyle) style, components, function2, modifier3, composerStartRestartGroup, i3 & 8176, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (style instanceof TabControlStyle.Buttons) {
                                composerStartRestartGroup.startReplaceGroup(754800829);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "105@5196L138");
                                StackComponentViewKt.StackComponentView(((TabControlStyle.Buttons) style).getStack(), components, function2, modifier3, 0.0f, composerStartRestartGroup, i3 & 8176, 16);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (style instanceof TabControlStyle.Toggle) {
                                composerStartRestartGroup.startReplaceGroup(754808893);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "112@5448L138");
                                StackComponentViewKt.StackComponentView(((TabControlStyle.Toggle) style).getStack(), components, function2, modifier3, 0.0f, composerStartRestartGroup, i3 & 8176, 16);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                function22 = function2;
                                if (style instanceof TabControlButtonComponentStyle) {
                                    composerStartRestartGroup.startReplaceGroup(754814617);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "118@5628L102");
                                    TabControlButtonViewKt.TabControlButtonView((TabControlButtonComponentStyle) style, components, modifier3, composerStartRestartGroup, (i3 & 112) | ((i3 >> 3) & 896), 0);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    modifier3 = modifier3;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else if (style instanceof TabControlToggleComponentStyle) {
                                    composerStartRestartGroup.startReplaceGroup(754819225);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "123@5772L102");
                                    TabControlToggleViewKt.TabControlToggleView((TabControlToggleComponentStyle) style, components, modifier3, composerStartRestartGroup, (i3 & 112) | ((i3 >> 3) & 896), 0);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    modifier3 = modifier3;
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    if (!(style instanceof CountdownComponentStyle)) {
                                        composerStartRestartGroup.startReplaceGroup(754634387);
                                        composerStartRestartGroup.endReplaceGroup();
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    composerStartRestartGroup.startReplaceGroup(754823638);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "128@5909L131");
                                    function2 = function22;
                                    CountdownComponentViewKt.CountdownComponentView((CountdownComponentStyle) style, components, function2, modifier3, composerStartRestartGroup, i3 & 8176, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            }
                        }
                    }
                }
                function2 = function22;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final PaywallState.Loaded.Components components2 = components;
            final Function2 function23 = function2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewKt.ComponentView.1
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

                public final void invoke(Composer composer2, int i5) {
                    ComponentViewKt.ComponentView(style, components2, function23, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
