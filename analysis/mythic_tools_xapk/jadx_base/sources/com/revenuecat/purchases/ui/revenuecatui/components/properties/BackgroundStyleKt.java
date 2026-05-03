package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import android.content.Context;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.compose.AsyncImagePainterKt;
import coil.request.CachePolicy;
import coil.request.ImageRequest;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.FitModeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ThemeImageUrlsKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PurchasesExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ImagePreviewsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackgroundStyle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0002\u0010\u0018\u001a2\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001a*\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fH\u0000¨\u0006\"²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u008e\u0002"}, d2 = {"Background_Preview_ColorGradientLinear", "", "(Landroidx/compose/runtime/Composer;I)V", "Background_Preview_ColorGradientRadial", "Background_Preview_ColorHex", "getImageRequest", "Lcoil/request/ImageRequest;", "context", "Landroid/content/Context;", "url", "", "cachePolicy", "Lcoil/request/CachePolicy;", "rememberAsyncImagePainter", "Lcoil/compose/AsyncImagePainter;", "imageUrls", "Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "(Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/runtime/Composer;I)Lcoil/compose/AsyncImagePainter;", "rememberBackgroundStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle;", "background", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle;", "toBackgroundStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "aliases", "", "Lcom/revenuecat/purchases/ColorAlias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BackgroundStyleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Background_Preview_ColorGradientLinear(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1587277957);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Background_Preview_ColorGradientLinear)233@9163L941:BackgroundStyle.kt#nqkcqm");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1587277957, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.Background_Preview_ColorGradientLinear (BackgroundStyle.kt:232)");
            }
            BoxKt.Box(BackgroundKt.background$default(SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(100.0f)), BackgroundStyle.Color.m10502boximpl(BackgroundStyle.Color.m10503constructorimpl(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(90.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6359getRed0d7_KjU()), 0.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6356getGreen0d7_KjU()), 50.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6352getBlue0d7_KjU()), 100.0f)}))))), (Shape) null, 2, (Object) null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt.Background_Preview_ColorGradientLinear.1
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
                    BackgroundStyleKt.Background_Preview_ColorGradientLinear(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Background_Preview_ColorGradientRadial(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1823976651);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Background_Preview_ColorGradientRadial)263@10188L902:BackgroundStyle.kt#nqkcqm");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1823976651, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.Background_Preview_ColorGradientRadial (BackgroundStyle.kt:262)");
            }
            BoxKt.Box(BackgroundKt.background$default(SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(100.0f)), BackgroundStyle.Color.m10502boximpl(BackgroundStyle.Color.m10503constructorimpl(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Radial(CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6359getRed0d7_KjU()), 0.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6356getGreen0d7_KjU()), 50.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6352getBlue0d7_KjU()), 100.0f)}))))), (Shape) null, 2, (Object) null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt.Background_Preview_ColorGradientRadial.1
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
                    BackgroundStyleKt.Background_Preview_ColorGradientRadial(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Background_Preview_ColorHex(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(529543697);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Background_Preview_ColorHex)223@8930L149:BackgroundStyle.kt#nqkcqm");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(529543697, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.Background_Preview_ColorHex (BackgroundStyle.kt:222)");
            }
            BoxKt.Box(BackgroundKt.background$default(SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(100.0f)), BackgroundStyle.Color.m10502boximpl(BackgroundStyle.Color.m10503constructorimpl(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())))), (Shape) null, 2, (Object) null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt.Background_Preview_ColorHex.1
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
                    BackgroundStyleKt.Background_Preview_ColorHex(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final ImageRequest getImageRequest(Context context, String str, CachePolicy cachePolicy) {
        return new ImageRequest.Builder(context).data(str).diskCachePolicy(cachePolicy).memoryCachePolicy(cachePolicy).build();
    }

    private static final AsyncImagePainter rememberAsyncImagePainter(ImageUrls imageUrls, ContentScale contentScale, Composer composer, int i) {
        ImageLoader imageLoader;
        ImageRequest imageRequest;
        AsyncImagePainter asyncImagePainterM9907rememberAsyncImagePainter3HmZ8SU;
        composer.startReplaceGroup(618155120);
        ComposerKt.sourceInformation(composer, "C(rememberAsyncImagePainter)P(1)179@7268L48,180@7348L7,181@7409L7,182@7443L17,186@7647L127,205@8414L149,189@7786L821:BackgroundStyle.kt#nqkcqm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(618155120, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.rememberAsyncImagePainter (BackgroundStyle.kt:178)");
        }
        composer.startReplaceGroup(756632259);
        ComposerKt.sourceInformation(composer, "CC(remember):BackgroundStyle.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CachePolicy.ENABLED, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        composer.endReplaceGroup();
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        ProvidableCompositionLocal<ImageLoader> localPreviewImageLoader = ImagePreviewsKt.getLocalPreviewImageLoader();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localPreviewImageLoader);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ImageLoader imageLoader2 = (ImageLoader) objConsume2;
        boolean zIsInPreviewMode = HelperFunctionsKt.isInPreviewMode(composer, 0);
        ImageLoader imageLoader3 = zIsInPreviewMode ? imageLoader2 : null;
        composer.startReplaceGroup(756639231);
        ComposerKt.sourceInformation(composer, "183@7532L91");
        if (imageLoader3 == null) {
            composer.startReplaceGroup(756640750);
            ComposerKt.sourceInformation(composer, "CC(remember):BackgroundStyle.kt#9igjgp");
            boolean zChanged = composer.changed(context);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Purchases.Companion companion = Purchases.INSTANCE;
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                objRememberedValue2 = PurchasesExtensionsKt.getImageLoaderTyped(companion, applicationContext);
                composer.updateRememberedValue(objRememberedValue2);
            }
            imageLoader3 = (ImageLoader) objRememberedValue2;
            composer.endReplaceGroup();
        }
        composer.endReplaceGroup();
        Object webp = imageUrls.getWebp();
        Object objRememberAsyncImagePainter$lambda$7 = rememberAsyncImagePainter$lambda$7(mutableState);
        composer.startReplaceGroup(756644466);
        ComposerKt.sourceInformation(composer, "CC(remember):BackgroundStyle.kt#9igjgp");
        boolean zChanged2 = composer.changed(webp) | composer.changed(context) | composer.changed(objRememberAsyncImagePainter$lambda$7);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            String string = imageUrls.getWebp().toString();
            Intrinsics.checkNotNullExpressionValue(string, "imageUrls.webp.toString()");
            objRememberedValue3 = getImageRequest(context, string, rememberAsyncImagePainter$lambda$7(mutableState));
            composer.updateRememberedValue(objRememberedValue3);
        }
        ImageRequest imageRequest2 = (ImageRequest) objRememberedValue3;
        composer.endReplaceGroup();
        composer.startReplaceGroup(756652882);
        ComposerKt.sourceInformation(composer, "195@8050L287");
        if (!zIsInPreviewMode || imageLoader2 == null) {
            String string2 = imageUrls.getWebpLowRes().toString();
            Intrinsics.checkNotNullExpressionValue(string2, "imageUrls.webpLowRes.toString()");
            imageLoader = imageLoader3;
            imageRequest = imageRequest2;
            asyncImagePainterM9907rememberAsyncImagePainter3HmZ8SU = AsyncImagePainterKt.m9907rememberAsyncImagePainter3HmZ8SU(getImageRequest(context, string2, rememberAsyncImagePainter$lambda$7(mutableState)), imageLoader, null, null, null, null, null, null, contentScale, 0, composer, ((i << 21) & 234881024) | 27648, 740);
        } else {
            asyncImagePainterM9907rememberAsyncImagePainter3HmZ8SU = ImagePreviewsKt.getPreviewPlaceholderBlocking(imageLoader3, imageRequest2);
            imageLoader = imageLoader3;
            imageRequest = imageRequest2;
        }
        Painter painter = asyncImagePainterM9907rememberAsyncImagePainter3HmZ8SU;
        composer.endReplaceGroup();
        composer.startReplaceGroup(756669032);
        ComposerKt.sourceInformation(composer, "CC(remember):BackgroundStyle.kt#9igjgp");
        Object objRememberedValue4 = composer.rememberedValue();
        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = (Function1) new Function1<AsyncImagePainter.State.Error, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt$rememberAsyncImagePainter$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AsyncImagePainter.State.Error error) {
                    invoke2(error);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AsyncImagePainter.State.Error it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Logger.INSTANCE.w("AsyncImagePainter failed to load. Will try again disabling cache");
                    mutableState.setValue(CachePolicy.WRITE_ONLY);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        composer.endReplaceGroup();
        AsyncImagePainter asyncImagePainterM9907rememberAsyncImagePainter3HmZ8SU2 = AsyncImagePainterKt.m9907rememberAsyncImagePainter3HmZ8SU(imageRequest, imageLoader, painter, null, null, null, null, (Function1) objRememberedValue4, contentScale, 0, composer, ((i << 21) & 234881024) | 12610560, TypedValues.MotionType.TYPE_DRAW_PATH);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return asyncImagePainterM9907rememberAsyncImagePainter3HmZ8SU2;
    }

    private static final CachePolicy rememberAsyncImagePainter$lambda$7(MutableState<CachePolicy> mutableState) {
        return mutableState.getValue();
    }

    public static final /* synthetic */ BackgroundStyle rememberBackgroundStyle(BackgroundStyles background, Composer composer, int i) {
        BackgroundStyle.Video videoM10502boximpl;
        Intrinsics.checkNotNullParameter(background, "background");
        composer.startReplaceGroup(1019071422);
        ComposerKt.sourceInformation(composer, "C(rememberBackgroundStyle):BackgroundStyle.kt#nqkcqm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1019071422, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.rememberBackgroundStyle (BackgroundStyle.kt:143)");
        }
        boolean z = true;
        if (background instanceof BackgroundStyles.Color) {
            composer.startReplaceGroup(-1590418969);
            ComposerKt.sourceInformation(composer, "145@5946L15,146@5974L96");
            ColorStyle forCurrentTheme = ColorStyleKt.getForCurrentTheme(((BackgroundStyles.Color) background).m10515unboximpl(), composer, 0);
            composer.startReplaceGroup(779982346);
            ComposerKt.sourceInformation(composer, "CC(remember):BackgroundStyle.kt#9igjgp");
            if ((((i & 14) ^ 6) <= 4 || !composer.changed(background)) && (i & 6) != 4) {
                z = false;
            }
            boolean zChanged = composer.changed(forCurrentTheme) | z;
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = BackgroundStyle.Color.m10502boximpl(BackgroundStyle.Color.m10503constructorimpl(forCurrentTheme));
                composer.updateRememberedValue(objRememberedValue);
            }
            ColorStyle colorStyleM10508unboximpl = ((BackgroundStyle.Color) objRememberedValue).m10508unboximpl();
            composer.endReplaceGroup();
            composer.endReplaceGroup();
            videoM10502boximpl = BackgroundStyle.Color.m10502boximpl(colorStyleM10508unboximpl);
        } else if (background instanceof BackgroundStyles.Image) {
            composer.startReplaceGroup(-1590195521);
            ComposerKt.sourceInformation(composer, "152@6236L19,153@6282L58,154@6353L260");
            BackgroundStyles.Image image = (BackgroundStyles.Image) background;
            ColorStyles colorOverlay = image.getColorOverlay();
            composer.startReplaceGroup(779988729);
            ComposerKt.sourceInformation(composer, "151@6176L15");
            ColorStyle forCurrentTheme2 = colorOverlay == null ? null : ColorStyleKt.getForCurrentTheme(colorOverlay, composer, 0);
            composer.endReplaceGroup();
            ImageUrls urlsForCurrentTheme = ThemeImageUrlsKt.getUrlsForCurrentTheme(image.getSources(), composer, 0);
            Object objRememberAsyncImagePainter = rememberAsyncImagePainter(urlsForCurrentTheme, image.getContentScale(), composer, 0);
            composer.startReplaceGroup(779994638);
            ComposerKt.sourceInformation(composer, "CC(remember):BackgroundStyle.kt#9igjgp");
            boolean zChanged2 = composer.changed(urlsForCurrentTheme) | composer.changed(forCurrentTheme2) | composer.changed(objRememberAsyncImagePainter);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new BackgroundStyle.Image((Painter) objRememberAsyncImagePainter, image.getContentScale(), forCurrentTheme2);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceGroup();
            composer.endReplaceGroup();
            videoM10502boximpl = (BackgroundStyle.Image) objRememberedValue2;
        } else {
            if (!(background instanceof BackgroundStyles.Video)) {
                composer.startReplaceGroup(779791050);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(-1589658663);
            ComposerKt.sourceInformation(composer, "163@6675L423");
            composer.startReplaceGroup(780005105);
            ComposerKt.sourceInformation(composer, "CC(remember):BackgroundStyle.kt#9igjgp");
            if ((((i & 14) ^ 6) <= 4 || !composer.changed(background)) && (i & 6) != 4) {
                z = false;
            }
            Object objRememberedValue3 = composer.rememberedValue();
            if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                BackgroundStyles.Video video = (BackgroundStyles.Video) background;
                Object video2 = new BackgroundStyle.Video(video.getSources(), video.getFallbackImage(), video.getLoop(), video.getMuteAudio(), video.getContentScale(), video.getColorOverlay());
                composer.updateRememberedValue(video2);
                objRememberedValue3 = video2;
            }
            composer.endReplaceGroup();
            composer.endReplaceGroup();
            videoM10502boximpl = (BackgroundStyle.Video) objRememberedValue3;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return videoM10502boximpl;
    }

    public static final /* synthetic */ Result toBackgroundStyles(Background background, Map aliases) {
        Intrinsics.checkNotNullParameter(background, "<this>");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        if (background instanceof Background.Color) {
            Result colorStyles = ColorStyleKt.toColorStyles(((Background.Color) background).getValue(), aliases);
            if (colorStyles instanceof Result.Success) {
                return new Result.Success(BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl((ColorStyles) ((Result.Success) colorStyles).getValue())));
            }
            if (colorStyles instanceof Result.Error) {
                return colorStyles;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (background instanceof Background.Image) {
            Background.Image image = (Background.Image) background;
            ColorScheme colorOverlay = image.getColorOverlay();
            Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(colorOverlay != null ? ColorStyleKt.toColorStyles(colorOverlay, aliases) : null);
            if (resultOrSuccessfullyNull instanceof Result.Success) {
                return new Result.Success(new BackgroundStyles.Image(image.getValue(), FitModeKt.toContentScale(image.getFitMode()), (ColorStyles) ((Result.Success) resultOrSuccessfullyNull).getValue()));
            }
            if (resultOrSuccessfullyNull instanceof Result.Error) {
                return resultOrSuccessfullyNull;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!(background instanceof Background.Video)) {
            if (background instanceof Background.Unknown) {
                return new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.UnsupportedBackgroundType((Background.Unknown) background), new PaywallValidationError.UnsupportedBackgroundType[0]));
            }
            throw new NoWhenBranchMatchedException();
        }
        Background.Video video = (Background.Video) background;
        ColorScheme colorOverlay2 = video.getColorOverlay();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(colorOverlay2 != null ? ColorStyleKt.toColorStyles(colorOverlay2, aliases) : null);
        if (resultOrSuccessfullyNull2 instanceof Result.Success) {
            return new Result.Success(new BackgroundStyles.Video(video.getValue(), video.getFallbackImage(), video.getLoop(), video.getMuteAudio(), FitModeKt.toContentScale(video.getFitMode()), (ColorStyles) ((Result.Success) resultOrSuccessfullyNull2).getValue()));
        }
        if (resultOrSuccessfullyNull2 instanceof Result.Error) {
            return resultOrSuccessfullyNull2;
        }
        throw new NoWhenBranchMatchedException();
    }
}
