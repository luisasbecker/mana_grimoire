package com.revenuecat.purchases.ui.revenuecatui.components;

import androidx.camera.video.AudioStats;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.facebook.appevents.internal.Constants;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.ImageComponent;
import com.revenuecat.purchases.paywalls.components.PackageComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.PaywallTransition;
import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TextComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
import com.revenuecat.purchases.paywalls.components.common.PromoOfferConfig;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.data.MockPurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ImagePreviewsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.OfferingToStateMapperKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0006\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002¨\u0006\b"}, d2 = {"LoadedPaywallComponents_Header_ZLayer_Preview", "", "(Landroidx/compose/runtime/Composer;I)V", "LoadedPaywallComponents_Preview_DirectImageAsBackground", "LoadedPaywallComponents_Preview_HeaderDirectHeroImage", "LoadedPaywallComponents_Preview_HeaderNestedStackWithImage", "LoadedPaywallComponents_Preview_HeaderNoZStackNoImage", "LoadedPaywallComponents_Preview_HeaderTextOnly", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class LoadedPaywallComponentsPreviewsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Header_ZLayer_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-187042489);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Header_ZLayer_Preview)195@9972L48,203@10294L20,203@10316L173,203@10268L221:LoadedPaywallComponentsPreviews.kt#dnqhhd");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-187042489, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Header_ZLayer_Preview (LoadedPaywallComponentsPreviews.kt:64)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            URL url = new URL("https://assets.pawwalls.com/1172568_1774614615_69db5d9d.webp");
            ButtonComponent buttonComponent = new ButtonComponent(ButtonComponent.Action.NavigateBack.INSTANCE, new StackComponent(CollectionsKt.listOf(new IconComponent("https://icons.pawwalls.com/icons", "x", new IconComponent.Formats("x.webp"), (Boolean) null, new Size(new SizeConstraint.Fixed(32, null), new SizeConstraint.Fixed(32, null)), new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6351getBlack0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), new Padding(6.0d, 6.0d, 6.0d, 6.0d), (Padding) null, new IconComponent.IconBackground(colorScheme2, MaskShape.Circle.INSTANCE, (Border) null, (Shadow) null, 12, (DefaultConstructorMarker) null), (List) null, 648, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32498, (DefaultConstructorMarker) null), (PaywallTransition) null, 4, (DefaultConstructorMarker) null);
            Offering offering = new Offering("header_zlayer", "Header with ZLayer image + text", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getMonthly()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_header_zlayer", "template", new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new ImageComponent(new ThemeImageUrls(new ImageUrls(url, url, url, 1024, 1024, null), (ImageUrls) null, 2, (DefaultConstructorMarker) null), (Boolean) null, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (String) null, (MaskShape) null, (ColorScheme) null, FitMode.FIT, (Padding) null, (Padding) null, (Border) null, (Shadow) null, (List) null, 4026, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m10429constructorimpl("overlay-text"), new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4284677123L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 14, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, (Padding) null, (List) null, 7292, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_LEADING), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32754, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m10429constructorimpl(Constants.GP_IAP_TITLE), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 24, HorizontalAlignment.CENTER, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, new Padding(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 50.0d, 50.0d), (List) null, 5212, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32738, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m10429constructorimpl("footer"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, 8188, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), (Size) null, (Float) null, colorScheme2, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32730, (DefaultConstructorMarker) null)), new HeaderComponent(new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf(buttonComponent), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_TRAILING), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32754, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(855638016))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, 30706, (DefaultConstructorMarker) null)))), MapsKt.mapOf(TuplesKt.to(LocaleId.m10392boximpl(LocaleId.m10393constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl(Constants.GP_IAP_TITLE)), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("overlay-text")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Featured"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("footer")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Try free for 1 week")))))), LocaleId.m10393constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, 960, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, null, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Header_ZLayer_Preview$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(-969555742, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Header_ZLayer_Preview.1

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Header_ZLayer_Preview$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Header_ZLayer_Preview$1$1", f = "LoadedPaywallComponentsPreviews.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class C01651 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    C01651(Continuation<? super C01651> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C01651(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((C01651) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                }

                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C204@10326L157:LoadedPaywallComponentsPreviews.kt#dnqhhd");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-969555742, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Header_ZLayer_Preview.<anonymous> (LoadedPaywallComponentsPreviews.kt:204)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new C01651(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer2, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Header_ZLayer_Preview.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Header_ZLayer_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_DirectImageAsBackground(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1936797168);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview_DirectImageAsBackground)918@45231L48,926@45553L20,926@45575L156,926@45527L204:LoadedPaywallComponentsPreviews.kt#dnqhhd");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1936797168, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_DirectImageAsBackground (LoadedPaywallComponentsPreviews.kt:830)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            URL url = new URL("https://assets.pawwalls.com/1172568_1774614837_7df8aa27.webp");
            Offering offering = new Offering("direct_image_background", "Direct image as background, no header", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getAnnual()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_direct_image_background", "template", new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m10429constructorimpl("overlay-text"), new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4294508801L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 14, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, (Padding) null, (List) null, 7292, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_LEADING), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fixed(300, null)), (Float) null, (ColorScheme) null, new Background.Image(new ThemeImageUrls(new ImageUrls(url, url, url, 1024, 1024, null), (ImageUrls) null, 2, (DefaultConstructorMarker) null), FitMode.FILL, (ColorScheme) null, 4, (DefaultConstructorMarker) null), (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32690, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m10429constructorimpl(Constants.GP_IAP_TITLE), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 24, HorizontalAlignment.CENTER, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, new Padding(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 50.0d, 50.0d), (List) null, 5212, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32738, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m10429constructorimpl("footer"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, 8188, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), (Size) null, (Float) null, colorScheme2, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32730, (DefaultConstructorMarker) null)), (HeaderComponent) null, 8, (DefaultConstructorMarker) null)), MapsKt.mapOf(TuplesKt.to(LocaleId.m10392boximpl(LocaleId.m10393constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl(Constants.GP_IAP_TITLE)), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("overlay-text")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Text in stack"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("footer")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Try free for 1 week")))))), LocaleId.m10393constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, 960, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_DirectImageAsBackground$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(677451755, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_DirectImageAsBackground.1

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_DirectImageAsBackground$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_DirectImageAsBackground$1$1", f = "LoadedPaywallComponentsPreviews.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class C01661 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    C01661(Continuation<? super C01661> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C01661(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((C01661) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                }

                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C927@45585L140:LoadedPaywallComponentsPreviews.kt#dnqhhd");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(677451755, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_DirectImageAsBackground.<anonymous> (LoadedPaywallComponentsPreviews.kt:927)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new C01661(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer2, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_DirectImageAsBackground.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_DirectImageAsBackground(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_HeaderDirectHeroImage(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1461797559);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview_HeaderDirectHeroImage)453@23107L48,461@23429L20,461@23451L156,461@23403L204:LoadedPaywallComponentsPreviews.kt#dnqhhd");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1461797559, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderDirectHeroImage (LoadedPaywallComponentsPreviews.kt:216)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6362getWhite0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme3 = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4283782485L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            URL url = new URL("https://assets.pawwalls.com/1172568_1774614837_7df8aa27.webp");
            ImageComponent imageComponent = new ImageComponent(new ThemeImageUrls(new ImageUrls(url, url, url, 1024, 1024, null), (ImageUrls) null, 2, (DefaultConstructorMarker) null), (Boolean) null, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (String) null, (MaskShape) null, new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(855638016))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), FitMode.FIT, (Padding) null, (Padding) null, (Border) null, (Shadow) null, (List) null, 3994, (DefaultConstructorMarker) null);
            ButtonComponent buttonComponent = new ButtonComponent(ButtonComponent.Action.NavigateBack.INSTANCE, new StackComponent(CollectionsKt.listOf(new IconComponent("https://icons.pawwalls.com/icons", "x", new IconComponent.Formats("x.webp"), (Boolean) null, new Size(new SizeConstraint.Fixed(32, null), new SizeConstraint.Fixed(32, null)), new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6351getBlack0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), new Padding(6.0d, 6.0d, 6.0d, 6.0d), (Padding) null, new IconComponent.IconBackground(colorScheme2, MaskShape.Circle.INSTANCE, (Border) null, (Shadow) null, 12, (DefaultConstructorMarker) null), (List) null, 648, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32498, (DefaultConstructorMarker) null), (PaywallTransition) null, 4, (DefaultConstructorMarker) null);
            Offering offering = new Offering("header_direct_hero", "Header with direct hero image", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getAnnual()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_header_direct_hero", "template", new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new TextComponent(LocalizationKey.m10429constructorimpl(Constants.GP_IAP_TITLE), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 24, HorizontalAlignment.CENTER, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, new Padding(16.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 50.0d, 50.0d), (List) null, 5212, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m10429constructorimpl("subtitle"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 15, HorizontalAlignment.CENTER, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, new Padding(8.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 24.0d, 24.0d), (List) null, 5244, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32738, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new PackageComponent("$rc_annual", true, new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m10429constructorimpl("package-info"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 14, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, (Padding) null, (List) null, 7292, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, new Shape.Rectangle(new CornerRadiuses.Dp(8.0d)), (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32242, (DefaultConstructorMarker) null), (PromoOfferConfig) null, (Boolean) null, (List) null, 56, (DefaultConstructorMarker) null), new PurchaseButtonComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m10429constructorimpl("cta"), new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4278979596L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, FontWeight.SEMI_BOLD, (Integer) null, 16, HorizontalAlignment.CENTER, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, (Padding) null, (List) null, 7260, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, new ColorScheme(new ColorInfo.Gradient.Linear(15.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4286377127L)), 0.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4286509283L)), 100.0f)})), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, new Padding(12.0d, 12.0d, 8.0d, 8.0d), (Padding) null, new Shape.Rectangle(new CornerRadiuses.Dp(12.0d)), (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(2156724156L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 8.0d, 4.0d, 4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, 30034, (DefaultConstructorMarker) null), (PurchaseButtonComponent.Action) null, (PurchaseButtonComponent.Method) null, 6, (DefaultConstructorMarker) null), new StackComponent(CollectionsKt.listOf(new ButtonComponent(ButtonComponent.Action.RestorePurchases.INSTANCE, new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m10429constructorimpl("restore"), colorScheme3, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.SEMI_BOLD, (Integer) null, 13, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, (Padding) null, (List) null, 7260, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.SPACE_BETWEEN), new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32754, (DefaultConstructorMarker) null), (PaywallTransition) null, 4, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Horizontal(VerticalAlignment.TOP, FlexDistribution.CENTER), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), Float.valueOf(32.0f), (ColorScheme) null, (Background) null, (Padding) null, new Padding(12.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32482, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, colorScheme2, (Background) null, new Padding(12.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 16.0d, 16.0d), (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(251658240))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, AudioStats.AUDIO_AMPLITUDE_NONE, -4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, 30546, (DefaultConstructorMarker) null)), new HeaderComponent(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{imageComponent, buttonComponent}), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_TRAILING), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, new Border(new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(1140850688))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 1.0d), (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 31730, (DefaultConstructorMarker) null)))), MapsKt.mapOf(TuplesKt.to(LocaleId.m10392boximpl(LocaleId.m10393constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl(Constants.GP_IAP_TITLE)), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("subtitle")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("AI-powered flashcards, smart scheduling, and progress tracking."))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("package-info")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Subscribe to Pro for just {{ product.price_per_period_abbreviated }}"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("cta")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Continue"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("restore")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Restore Purchases")))))), LocaleId.m10393constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, 960, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderDirectHeroImage$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(-122765852, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderDirectHeroImage.1

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderDirectHeroImage$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderDirectHeroImage$1$1", f = "LoadedPaywallComponentsPreviews.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class C01671 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    C01671(Continuation<? super C01671> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C01671(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((C01671) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                }

                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C462@23461L140:LoadedPaywallComponentsPreviews.kt#dnqhhd");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-122765852, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderDirectHeroImage.<anonymous> (LoadedPaywallComponentsPreviews.kt:462)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new C01671(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer2, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderDirectHeroImage.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderDirectHeroImage(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_HeaderNestedStackWithImage(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(847814897);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview_HeaderNestedStackWithImage)1075@52135L48,1083@52457L20,1083@52479L156,1083@52431L204:LoadedPaywallComponentsPreviews.kt#dnqhhd");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(847814897, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderNestedStackWithImage (LoadedPaywallComponentsPreviews.kt:938)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            URL url = new URL("https://assets.pawwalls.com/1172568_1774614837_7df8aa27.webp");
            ButtonComponent buttonComponent = new ButtonComponent(ButtonComponent.Action.NavigateBack.INSTANCE, new StackComponent(CollectionsKt.listOf(new IconComponent("https://icons.pawwalls.com/icons", "x", new IconComponent.Formats("x.webp"), (Boolean) null, new Size(new SizeConstraint.Fixed(32, null), new SizeConstraint.Fixed(32, null)), new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6351getBlack0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), new Padding(6.0d, 6.0d, 6.0d, 6.0d), (Padding) null, new IconComponent.IconBackground(colorScheme2, MaskShape.Circle.INSTANCE, (Border) null, (Shadow) null, 12, (DefaultConstructorMarker) null), (List) null, 648, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32498, (DefaultConstructorMarker) null), (PaywallTransition) null, 4, (DefaultConstructorMarker) null);
            Offering offering = new Offering("header_nested_stack_image", "Header with nested stack containing image", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getAnnual()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_header_nested_stack_image", "template", new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new ImageComponent(new ThemeImageUrls(new ImageUrls(url, url, url, 1024, 1024, null), (ImageUrls) null, 2, (DefaultConstructorMarker) null), (Boolean) null, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (String) null, (MaskShape) null, (ColorScheme) null, FitMode.FIT, (Padding) null, (Padding) null, (Border) null, (Shadow) null, (List) null, 4026, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m10429constructorimpl("overlay-text"), new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4294508801L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 14, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, (Padding) null, (List) null, 7292, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_LEADING), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32754, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32754, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m10429constructorimpl(Constants.GP_IAP_TITLE), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 24, HorizontalAlignment.CENTER, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, new Padding(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 50.0d, 50.0d), (List) null, 5212, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32738, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m10429constructorimpl("footer"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, 8188, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), (Size) null, (Float) null, colorScheme2, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32730, (DefaultConstructorMarker) null)), new HeaderComponent(new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf(buttonComponent), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_TRAILING), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32754, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(855638016))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, 30706, (DefaultConstructorMarker) null)))), MapsKt.mapOf(TuplesKt.to(LocaleId.m10392boximpl(LocaleId.m10393constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl(Constants.GP_IAP_TITLE)), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("overlay-text")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Text in stack"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("footer")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Try free for 1 week")))))), LocaleId.m10393constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, 960, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNestedStackWithImage$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(1295501622, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNestedStackWithImage.1

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNestedStackWithImage$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNestedStackWithImage$1$1", f = "LoadedPaywallComponentsPreviews.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class C01681 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    C01681(Continuation<? super C01681> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C01681(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((C01681) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                }

                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C1084@52489L140:LoadedPaywallComponentsPreviews.kt#dnqhhd");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1295501622, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderNestedStackWithImage.<anonymous> (LoadedPaywallComponentsPreviews.kt:1084)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new C01681(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer2, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNestedStackWithImage.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNestedStackWithImage(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_HeaderNoZStackNoImage(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1717104956);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview_HeaderNoZStackNoImage)810@40677L48,818@40999L20,818@41021L156,818@40973L204:LoadedPaywallComponentsPreviews.kt#dnqhhd");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1717104956, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderNoZStackNoImage (LoadedPaywallComponentsPreviews.kt:711)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            Offering offering = new Offering("header_no_zstack_no_image", "Header with no ZStack and no image", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getAnnual()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_header_no_zstack_no_image", "template", new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new TextComponent(LocalizationKey.m10429constructorimpl(Constants.GP_IAP_TITLE), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 24, HorizontalAlignment.CENTER, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, new Padding(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 50.0d, 50.0d), (List) null, 5212, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32738, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m10429constructorimpl("footer"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, 8188, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), (Size) null, (Float) null, colorScheme2, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32730, (DefaultConstructorMarker) null)), new HeaderComponent(new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf(new ButtonComponent(ButtonComponent.Action.NavigateBack.INSTANCE, new StackComponent(CollectionsKt.listOf(new IconComponent("https://icons.pawwalls.com/icons", "x", new IconComponent.Formats("x.webp"), (Boolean) null, new Size(new SizeConstraint.Fixed(32, null), new SizeConstraint.Fixed(32, null)), new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6351getBlack0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), new Padding(6.0d, 6.0d, 6.0d, 6.0d), (Padding) null, new IconComponent.IconBackground(colorScheme2, MaskShape.Circle.INSTANCE, (Border) null, (Shadow) null, 12, (DefaultConstructorMarker) null), (List) null, 648, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32498, (DefaultConstructorMarker) null), (PaywallTransition) null, 4, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_TRAILING), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32754, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(855638016))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, 30706, (DefaultConstructorMarker) null)))), MapsKt.mapOf(TuplesKt.to(LocaleId.m10392boximpl(LocaleId.m10393constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl(Constants.GP_IAP_TITLE)), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("footer")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Try free for 1 week")))))), LocaleId.m10393constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, 960, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNoZStackNoImage$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(-1238830633, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNoZStackNoImage.1

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNoZStackNoImage$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNoZStackNoImage$1$1", f = "LoadedPaywallComponentsPreviews.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class C01691 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    C01691(Continuation<? super C01691> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C01691(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((C01691) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                }

                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C819@41031L140:LoadedPaywallComponentsPreviews.kt#dnqhhd");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1238830633, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderNoZStackNoImage.<anonymous> (LoadedPaywallComponentsPreviews.kt:819)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new C01691(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer2, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNoZStackNoImage.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNoZStackNoImage(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_HeaderTextOnly(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(762914118);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview_HeaderTextOnly)691@35479L48,699@35801L20,699@35823L156,699@35775L204:LoadedPaywallComponentsPreviews.kt#dnqhhd");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(762914118, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderTextOnly (LoadedPaywallComponentsPreviews.kt:473)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme3 = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4283124041L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ButtonComponent buttonComponent = new ButtonComponent(ButtonComponent.Action.NavigateBack.INSTANCE, new StackComponent(CollectionsKt.listOf(new IconComponent("https://icons.pawwalls.com/icons", "x", new IconComponent.Formats("x.webp"), (Boolean) null, new Size(new SizeConstraint.Fixed(32, null), new SizeConstraint.Fixed(32, null)), new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6351getBlack0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), new Padding(6.0d, 6.0d, 6.0d, 6.0d), (Padding) null, new IconComponent.IconBackground(colorScheme2, MaskShape.Circle.INSTANCE, (Border) null, (Shadow) null, 12, (DefaultConstructorMarker) null), (List) null, 648, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32498, (DefaultConstructorMarker) null), (PaywallTransition) null, 4, (DefaultConstructorMarker) null);
            List listListOf = CollectionsKt.listOf((Object[]) new String[]{"feature-1", "feature-2"});
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                arrayList.add(new TextComponent(LocalizationKey.m10429constructorimpl((String) it.next()), colorScheme3, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 14, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), new Padding(2.0d, 2.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), (Padding) null, (List) null, 6268, (DefaultConstructorMarker) null));
            }
            Offering offering = new Offering("header_text_only", "Header with text only (no hero image)", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getAnnual()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_header_text_only", "template", new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new TextComponent(LocalizationKey.m10429constructorimpl(Constants.GP_IAP_TITLE), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 24, HorizontalAlignment.CENTER, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, new Padding(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 50.0d, 50.0d), (List) null, 5212, (DefaultConstructorMarker) null), new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.plus((Collection) CollectionsKt.listOf(new TextComponent(LocalizationKey.m10429constructorimpl("features-header"), colorScheme2, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 16, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, (Padding) null, (List) null, 7260, (DefaultConstructorMarker) null)), (Iterable) arrayList), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), Float.valueOf(4.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32738, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32626, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32738, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new PurchaseButtonComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m10429constructorimpl("cta"), new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4278979596L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, FontWeight.SEMI_BOLD, (Integer) null, 16, HorizontalAlignment.CENTER, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, (Padding) null, (List) null, 7260, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, new ColorScheme(new ColorInfo.Gradient.Linear(15.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4286377127L)), 0.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color(4286509283L)), 100.0f)})), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, new Padding(12.0d, 12.0d, 8.0d, 8.0d), (Padding) null, new Shape.Rectangle(new CornerRadiuses.Dp(12.0d)), (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32082, (DefaultConstructorMarker) null), (PurchaseButtonComponent.Action) null, (PurchaseButtonComponent.Method) null, 6, (DefaultConstructorMarker) null), new StackComponent(CollectionsKt.listOf(new ButtonComponent(ButtonComponent.Action.RestorePurchases.INSTANCE, new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m10429constructorimpl("restore"), colorScheme3, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.SEMI_BOLD, (Integer) null, 13, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Padding) null, (Padding) null, (List) null, 7260, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.SPACE_BETWEEN), new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32754, (DefaultConstructorMarker) null), (PaywallTransition) null, 4, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Horizontal(VerticalAlignment.TOP, FlexDistribution.CENTER), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(12.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32498, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, colorScheme2, (Background) null, new Padding(12.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 16.0d, 16.0d), (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(251658240))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, AudioStats.AUDIO_AMPLITUDE_NONE, -4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, 30546, (DefaultConstructorMarker) null)), new HeaderComponent(new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf(buttonComponent), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_TRAILING), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32754, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color(855638016))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, 30706, (DefaultConstructorMarker) null)))), MapsKt.mapOf(TuplesKt.to(LocaleId.m10392boximpl(LocaleId.m10393constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl(Constants.GP_IAP_TITLE)), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("features-header")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Features"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("feature-1")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Assignment Tracker"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("feature-2")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("AI-generated Study Plans"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("cta")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Continue"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("restore")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Restore Purchases")))))), LocaleId.m10393constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, 960, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderTextOnly$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(-2020160245, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderTextOnly.1

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderTextOnly$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderTextOnly$1$1", f = "LoadedPaywallComponentsPreviews.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class C01701 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    C01701(Continuation<? super C01701> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C01701(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((C01701) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                }

                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C700@35833L140:LoadedPaywallComponentsPreviews.kt#dnqhhd");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2020160245, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderTextOnly.<anonymous> (LoadedPaywallComponentsPreviews.kt:700)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new C01701(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer2, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderTextOnly.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderTextOnly(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
