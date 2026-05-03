package com.revenuecat.purchases.ui.revenuecatui.components.text;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.muxer.WebmConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.SizeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessor;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\r\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u000e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u000f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u0013\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a#\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u001a\u001a\u001d\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0003¢\u0006\u0002\u0010\u001f¨\u0006 ²\u0006\n\u0010!\u001a\u00020\u001cX\u008a\u0084\u0002"}, d2 = {"TextComponentView", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TextComponentView_Preview_Customizations", "(Landroidx/compose/runtime/Composer;I)V", "TextComponentView_Preview_Default", "TextComponentView_Preview_FontSize", "TextComponentView_Preview_HeadingXlExtraBold", "TextComponentView_Preview_HorizontalAlignment", "TextComponentView_Preview_LinearGradient", "TextComponentView_Preview_Markdown", "TextComponentView_Preview_MonospaceFont", "TextComponentView_Preview_RadialGradient", "TextComponentView_Preview_SansSerifFont", "TextComponentView_Preview_SerifFont", "discountPercentage", "", "pricePerMonthMicros", "", "mostExpensiveMicros", "(Ljava/lang/Long;Ljava/lang/Long;)Ljava/lang/Double;", "rememberProcessedText", "", "textState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/text/TextComponentState;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lcom/revenuecat/purchases/ui/revenuecatui/components/text/TextComponentState;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "revenuecatui_defaultsBc8Release", "processedText"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class TextComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:40:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextComponentView(final TextComponentStyle style, final PaywallState.Loaded.Components state, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        TextComponentState textComponentStateRememberUpdatedTextComponentState;
        boolean z;
        long jM6361getUnspecified0d7_KjU;
        TextStyle textStyleM8567copyNs73l9s$default;
        Composer composer2;
        Modifier modifier3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-661936570);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView)P(2,1)52@2878L93,58@3030L82,63@3151L15,84@3950L636:TextComponentView.kt#fyu9x8");
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
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-661936570, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView (TextComponentView.kt:50)");
                }
                textComponentStateRememberUpdatedTextComponentState = TextComponentStateKt.rememberUpdatedTextComponentState(style, state, composerStartRestartGroup, i3 & 126);
                String strRememberProcessedText = rememberProcessedText(state, textComponentStateRememberUpdatedTextComponentState, composerStartRestartGroup, (i3 >> 3) & 14);
                ColorStyle forCurrentTheme = ColorStyleKt.getForCurrentTheme(textComponentStateRememberUpdatedTextComponentState.getColor(), composerStartRestartGroup, 0);
                ColorStyles backgroundColor = textComponentStateRememberUpdatedTextComponentState.getBackgroundColor();
                composerStartRestartGroup.startReplaceGroup(-1878014542);
                ComposerKt.sourceInformation(composerStartRestartGroup, "64@3225L15");
                ColorStyle forCurrentTheme2 = backgroundColor != null ? null : ColorStyleKt.getForCurrentTheme(backgroundColor, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                z = forCurrentTheme instanceof ColorStyle.Solid;
                if (!z) {
                    jM6361getUnspecified0d7_KjU = ((ColorStyle.Solid) forCurrentTheme).m10538unboximpl();
                } else {
                    if (!(forCurrentTheme instanceof ColorStyle.Gradient)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    jM6361getUnspecified0d7_KjU = Color.INSTANCE.m6361getUnspecified0d7_KjU();
                }
                long j = jM6361getUnspecified0d7_KjU;
                if (!z) {
                    composerStartRestartGroup.startReplaceGroup(-1877999775);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "74@3677L7");
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyleM8567copyNs73l9s$default = TextStyle.m8569copyp1EtxEg$default((TextStyle) objConsume, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE(), null, null, null, 0, 0, null, 16646143, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (!(forCurrentTheme instanceof ColorStyle.Gradient)) {
                        composerStartRestartGroup.startReplaceGroup(-1878117789);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(1911669339);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@3797L7");
                    ProvidableCompositionLocal<TextStyle> localTextStyle2 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localTextStyle2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyleM8567copyNs73l9s$default = TextStyle.m8567copyNs73l9s$default((TextStyle) objConsume2, ((ColorStyle.Gradient) forCurrentTheme).m10530unboximpl(), 0.0f, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE(), null, null, null, 0, 0, null, 33292286, null);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (textComponentStateRememberUpdatedTextComponentState.getVisible()) {
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier2;
                } else {
                    modifier3 = modifier2;
                    MarkdownKt.m10642MarkdownDkhmgE0(strRememberProcessedText, PaddingKt.padding(ModifierExtensionsKt.applyIfNotNull(PaddingKt.padding(SizeKt.size$default(modifier2, textComponentStateRememberUpdatedTextComponentState.getSize(), textComponentStateRememberUpdatedTextComponentState.getHorizontalAlignment(), null, 4, null), textComponentStateRememberUpdatedTextComponentState.getMargin()), forCurrentTheme2, new Function2<Modifier, ColorStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView.1
                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, ColorStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return BackgroundKt.background$default(applyIfNotNull, it, (Shape) null, 2, (Object) null);
                        }
                    }), textComponentStateRememberUpdatedTextComponentState.getPadding()), j, textStyleM8567copyNs73l9s$default, TextUnitKt.getSp(textComponentStateRememberUpdatedTextComponentState.getFontSize()), textComponentStateRememberUpdatedTextComponentState.getFontWeight(), textComponentStateRememberUpdatedTextComponentState.getFontFamily(), textComponentStateRememberUpdatedTextComponentState.getHorizontalAlignment(), textComponentStateRememberUpdatedTextComponentState.m10605getTextAlignbuA522U(), false, false, false, composerStartRestartGroup, 0, 0, 3584);
                    composer2 = composerStartRestartGroup;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
                modifier4 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i5) {
                        TextComponentViewKt.TextComponentView(style, state, modifier4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & 147) == 146) {
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            textComponentStateRememberUpdatedTextComponentState = TextComponentStateKt.rememberUpdatedTextComponentState(style, state, composerStartRestartGroup, i3 & 126);
            String strRememberProcessedText2 = rememberProcessedText(state, textComponentStateRememberUpdatedTextComponentState, composerStartRestartGroup, (i3 >> 3) & 14);
            ColorStyle forCurrentTheme3 = ColorStyleKt.getForCurrentTheme(textComponentStateRememberUpdatedTextComponentState.getColor(), composerStartRestartGroup, 0);
            ColorStyles backgroundColor2 = textComponentStateRememberUpdatedTextComponentState.getBackgroundColor();
            composerStartRestartGroup.startReplaceGroup(-1878014542);
            ComposerKt.sourceInformation(composerStartRestartGroup, "64@3225L15");
            ColorStyle forCurrentTheme22 = backgroundColor2 != null ? null : ColorStyleKt.getForCurrentTheme(backgroundColor2, composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceGroup();
            z = forCurrentTheme3 instanceof ColorStyle.Solid;
            if (!z) {
            }
            long j2 = jM6361getUnspecified0d7_KjU;
            if (!z) {
            }
            if (textComponentStateRememberUpdatedTextComponentState.getVisible()) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_Customizations(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1310256028);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_Customizations)279@11025L19,267@10314L737:TextComponentView.kt#fyu9x8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1310256028, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_Customizations (TextComponentView.kt:266)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, world", new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(ColorKt.Color$default(255, 0, 0, 0, 8, null))), null, 2, null), 13, FontWeight.BLACK, null, HorizontalAlignment.LEADING, HorizontalAlignment.LEADING, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(ColorKt.Color$default(222, 222, 222, 0, 8, null))), null, 2, null), false, null, new Padding(10.0d, 10.0d, 20.0d, 20.0d), new Padding(20.0d, 20.0d, 10.0d, 10.0d), null, null, null, null, 62224, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, composerStartRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_Customizations.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    TextComponentViewKt.TextComponentView_Preview_Customizations(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_Default(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1838187961);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_Default)168@7167L19,163@6971L222:TextComponentView.kt#fyu9x8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1838187961, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_Default (TextComponentView.kt:162)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, world", new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65532, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, composerStartRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_Default.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    TextComponentViewKt.TextComponentView_Preview_Default(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_FontSize(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(793345132);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_FontSize)244@9589L19,237@9314L301:TextComponentView.kt#fyu9x8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(793345132, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_FontSize (TextComponentView.kt:236)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, world", new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), 28, null, null, null, null, null, false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 65016, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, composerStartRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_FontSize.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    TextComponentViewKt.TextComponentView_Preview_FontSize(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_HeadingXlExtraBold(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1682911299);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_HeadingXlExtraBold)177@7454L490:TextComponentView.kt#fyu9x8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1682911299, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_HeadingXlExtraBold (TextComponentView.kt:174)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, ComposableSingletons$TextComponentViewKt.INSTANCE.m10602getLambda2$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_HeadingXlExtraBold.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    TextComponentViewKt.TextComponentView_Preview_HeadingXlExtraBold(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_HorizontalAlignment(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-43764709);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_HorizontalAlignment)258@10048L19,251@9736L467:TextComponentView.kt#fyu9x8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-43764709, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_HorizontalAlignment (TextComponentView.kt:250)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, world", new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), 0, null, null, null, HorizontalAlignment.TRAILING, null, false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 64956, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), androidx.compose.foundation.layout.SizeKt.m2090widthInVpY3zN4$default(Modifier.INSTANCE, Dp.m9114constructorimpl(400.0f), 0.0f, 2, null), composerStartRestartGroup, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_HorizontalAlignment.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    TextComponentViewKt.TextComponentView_Preview_HorizontalAlignment(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_LinearGradient(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(702292295);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_LinearGradient)330@13155L19,299@11624L1557:TextComponentView.kt#fyu9x8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(702292295, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_LinearGradient (TextComponentView.kt:298)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Do not allow people to dim your shine because they are blinded. Tell them to put some sunglasses on.", new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(135.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6353getCyan0d7_KjU()), 10.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color$default(0, 102, 255, 0, 8, null)), 30.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color$default(WebmConstants.MkvEbmlElement.BLOCK_GROUP, 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, 0, 8, null)), 80.0f)}))), null, 2, null), 15, FontWeight.MEDIUM, null, HorizontalAlignment.LEADING, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), false, new Size(new SizeConstraint.Fixed(UInt.m11540constructorimpl(200), null), SizeConstraint.Fit.INSTANCE), new Padding(10.0d, 10.0d, 20.0d, 20.0d), new Padding(20.0d, 20.0d, 10.0d, 10.0d), null, null, null, null, 61776, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, composerStartRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_LinearGradient.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    TextComponentViewKt.TextComponentView_Preview_LinearGradient(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_Markdown(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1145662669);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_Markdown)292@11487L19,286@11149L364:TextComponentView.kt#fyu9x8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1145662669, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_Markdown (TextComponentView.kt:285)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, **bold**, *italic* or _italic2_ with ~strikethrough~, ~~strikethrough2~~ and `monospace`. Click [here](https://revenuecat.com)", new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65532, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, composerStartRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_Markdown.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    TextComponentViewKt.TextComponentView_Preview_Markdown(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_MonospaceFont(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-744412312);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_MonospaceFont)230@9208L19,223@8909L325:TextComponentView.kt#fyu9x8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-744412312, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_MonospaceFont (TextComponentView.kt:222)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, world", new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), 0, null, FontSpec.Generic.Monospace.INSTANCE, null, null, null, false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 65004, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, composerStartRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_MonospaceFont.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    TextComponentViewKt.TextComponentView_Preview_MonospaceFont(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_RadialGradient(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(261376653);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_RadialGradient)367@14788L19,337@13292L1522:TextComponentView.kt#fyu9x8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(261376653, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_RadialGradient (TextComponentView.kt:336)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Do not allow people to dim your shine because they are blinded. Tell them to put some sunglasses on.", new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Radial(CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6353getCyan0d7_KjU()), 10.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color$default(0, 102, 255, 0, 8, null)), 80.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color$default(WebmConstants.MkvEbmlElement.BLOCK_GROUP, 0, WebmConstants.MkvEbmlElement.BLOCK_GROUP, 0, 8, null)), 100.0f)}))), null, 2, null), 15, FontWeight.MEDIUM, null, HorizontalAlignment.LEADING, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), false, new Size(new SizeConstraint.Fixed(UInt.m11540constructorimpl(200), null), SizeConstraint.Fit.INSTANCE), new Padding(10.0d, 10.0d, 20.0d, 20.0d), new Padding(20.0d, 20.0d, 10.0d, 10.0d), null, null, null, null, 61776, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, composerStartRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_RadialGradient.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    TextComponentViewKt.TextComponentView_Preview_RadialGradient(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_SansSerifFont(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(570489761);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_SansSerifFont)216@8774L19,209@8475L325:TextComponentView.kt#fyu9x8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(570489761, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_SansSerifFont (TextComponentView.kt:208)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, world", new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), 0, null, FontSpec.Generic.SansSerif.INSTANCE, null, null, null, false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 65004, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, composerStartRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_SansSerifFont.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    TextComponentViewKt.TextComponentView_Preview_SansSerifFont(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_SerifFont(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2065783982);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_SerifFont)202@8340L19,195@8045L321:TextComponentView.kt#fyu9x8");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2065783982, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_SerifFont (TextComponentView.kt:194)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Hello, world", new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), 0, null, FontSpec.Generic.Serif.INSTANCE, null, null, null, false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), null, null, null, null, null, null, 65004, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, composerStartRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_SerifFont.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    TextComponentViewKt.TextComponentView_Preview_SerifFont(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double discountPercentage(Long l, Long l2) {
        if (l == null || l2 == null || l2.longValue() <= l.longValue()) {
            return null;
        }
        return Double.valueOf((l2.longValue() - l.longValue()) / l2.longValue());
    }

    private static final String rememberProcessedText(final PaywallState.Loaded.Components components, final TextComponentState textComponentState, Composer composer, int i) {
        composer.startReplaceGroup(-2070949083);
        ComposerKt.sourceInformation(composer, "C(rememberProcessedText)110@4881L1614:TextComponentView.kt#fyu9x8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2070949083, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.rememberProcessedText (TextComponentView.kt:109)");
        }
        composer.startReplaceGroup(1040262346);
        ComposerKt.sourceInformation(composer, "CC(remember):TextComponentView.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(components)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(textComponentState)) || (i & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt$rememberProcessedText$processedText$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    VariableProcessor.PackageContext packageContext;
                    Locale javaLocale = LocalizationKt.toJavaLocale(components.getLocale());
                    Locale javaLocale2 = LocalizationKt.toJavaLocale(components.getCurrencyLocale());
                    Package applicablePackage = textComponentState.getApplicablePackage();
                    if (applicablePackage != null) {
                        PaywallState.Loaded.Components components2 = components;
                        Price pricePricePerMonth$default = StoreProduct.pricePerMonth$default(applicablePackage.getProduct(), null, 1, null);
                        packageContext = new VariableProcessor.PackageContext(TextComponentViewKt.discountPercentage(pricePricePerMonth$default != null ? Long.valueOf(pricePricePerMonth$default.getAmountMicros()) : null, components2.getMostExpensivePricePerMonthMicros()), !components2.getShowPricesWithDecimals());
                    } else {
                        packageContext = null;
                    }
                    return VariableProcessorV2.INSTANCE.processVariables(textComponentState.getText(), textComponentState.getLocalizedVariableKeys(), components.getVariableConfig(), components.getVariableDataProvider(), packageContext, applicablePackage, textComponentState.getSubscriptionOption(), javaLocale2, javaLocale, components.getCurrentDate(), textComponentState.getCountdownTime(), textComponentState.getCountFrom(), components.getCustomVariables(), components.getDefaultCustomVariables());
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceGroup();
        String strRememberProcessedText$lambda$1 = rememberProcessedText$lambda$1((State) objRememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return strRememberProcessedText$lambda$1;
    }

    private static final String rememberProcessedText$lambda$1(State<String> state) {
        return state.getValue();
    }
}
