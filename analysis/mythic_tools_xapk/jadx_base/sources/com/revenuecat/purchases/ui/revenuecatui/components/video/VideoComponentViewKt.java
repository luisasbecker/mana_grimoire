package com.revenuecat.purchases.ui.revenuecatui.components.video;

import android.view.View;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.muxer.WebmConstants;
import androidx.work.Data;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.models.Checksum;
import com.revenuecat.purchases.paywalls.components.properties.VideoUrls;
import com.revenuecat.purchases.storage.FileRepository;
import com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.AspectRatio;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.AspectRatioKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.ShadowKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.SizeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ImageComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.VideoComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: VideoComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a(\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\tH\u0080@¢\u0006\u0002\u0010\u0010\u001a\u001d\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u0015\u001a\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u001c\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¨\u0006\u001d²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u0084\u0002²\u0006\n\u0010 \u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\u0018X\u008a\u008e\u0002"}, d2 = {"VideoComponentView", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/VideoComponentStyle;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "modifier", "Landroidx/compose/ui/Modifier;", "repository", "Lcom/revenuecat/purchases/storage/FileRepository;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/VideoComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/storage/FileRepository;Landroidx/compose/runtime/Composer;II)V", "cacheVideo", "url", "Ljava/net/URL;", "checksum", "Lcom/revenuecat/purchases/models/Checksum;", "(Ljava/net/URL;Lcom/revenuecat/purchases/models/Checksum;Lcom/revenuecat/purchases/storage/FileRepository;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rememberVideoContentState", "Ljava/net/URI;", "videoUrls", "Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;", "(Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;Lcom/revenuecat/purchases/storage/FileRepository;Landroidx/compose/runtime/Composer;I)Ljava/net/URI;", "resolveVideoUrl", "isVisibleInViewport", "", "Landroidx/compose/ui/geometry/Rect;", "viewportWidth", "", "viewportHeight", "revenuecatui_defaultsBc8Release", "composeShape", "Landroidx/compose/ui/graphics/Shape;", "isVisible", "videoReady"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VideoComponentViewKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$cacheVideo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: VideoComponentView.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt", f = "VideoComponentView.kt", i = {0}, l = {WebmConstants.MkvEbmlElement.CUE_TRACK_POSITIONS}, m = "cacheVideo", n = {"url"}, s = {"L$0"})
    static final class C08431 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08431(Continuation<? super C08431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VideoComponentViewKt.cacheVideo(null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void VideoComponentView(final VideoComponentStyle style, final PaywallState.Loaded.Components state, Modifier modifier, FileRepository fileRepository, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        FileRepository fileRepository2;
        Modifier modifier3;
        int i4;
        FileRepository fileRepository3;
        final VideoComponentState videoComponentStateRememberUpdatedVideoComponentState;
        FileRepository fileRepository4;
        Modifier modifier4;
        final FileRepository fileRepository5;
        final Modifier modifier5;
        Object objMutableStateOf$default;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(674356826);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VideoComponentView)P(3,2)52@2690L48,58@3028L84,60@3139L34,61@3200L45,62@3275L7,65@3385L806,98@4709L28,100@4819L46,101@4904L140,93@4444L1632:VideoComponentView.kt#26k46s");
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
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    fileRepository2 = fileRepository;
                    int i6 = composerStartRestartGroup.changedInstance(fileRepository2) ? 2048 : 1024;
                    i3 |= i6;
                } else {
                    fileRepository2 = fileRepository;
                }
                i3 |= i6;
            } else {
                fileRepository2 = fileRepository;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 8) == 0) {
                        modifier3 = companion;
                        i4 = i3 & (-7169);
                        fileRepository3 = Purchases.INSTANCE.getSharedInstance().getFileRepository();
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(674356826, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentView (VideoComponentView.kt:51)");
                        }
                        int i7 = i4 & 112;
                        videoComponentStateRememberUpdatedVideoComponentState = VideoComponentStateKt.rememberUpdatedVideoComponentState(style, state, composerStartRestartGroup, i4 & 126);
                        if (videoComponentStateRememberUpdatedVideoComponentState.getVisible()) {
                            fileRepository4 = fileRepository3;
                            modifier4 = modifier3;
                        } else {
                            ColorStyles overlay = videoComponentStateRememberUpdatedVideoComponentState.getOverlay();
                            composerStartRestartGroup.startReplaceGroup(-2077056168);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "55@2812L15");
                            ColorStyle forCurrentTheme = overlay == null ? null : ColorStyleKt.getForCurrentTheme(overlay, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                            BorderStyles border = videoComponentStateRememberUpdatedVideoComponentState.getBorder();
                            composerStartRestartGroup.startReplaceGroup(-2077054191);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*56@2879L32");
                            BorderStyle borderStyleRememberBorderStyle = border == null ? null : BorderStyleKt.rememberBorderStyle(border, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                            ShadowStyles shadow = videoComponentStateRememberUpdatedVideoComponentState.getShadow();
                            composerStartRestartGroup.startReplaceGroup(-2077051439);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*57@2965L32");
                            ShadowStyle shadowStyleRememberShadowStyle = shadow == null ? null : ShadowStyleKt.rememberShadowStyle(shadow, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                            Shape shape = videoComponentStateRememberUpdatedVideoComponentState.getShape();
                            composerStartRestartGroup.startReplaceGroup(-2077049187);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoComponentView.kt#9igjgp");
                            boolean zChanged = composerStartRestartGroup.changed(shape);
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$VideoComponentView$composeShape$2$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Shape invoke() {
                                        Shape shape2 = videoComponentStateRememberUpdatedVideoComponentState.getShape();
                                        return shape2 == null ? RectangleShapeKt.getRectangleShape() : shape2;
                                    }
                                });
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            final State state2 = (State) objRememberedValue;
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(-2077045685);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoComponentView.kt#9igjgp");
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                                objRememberedValue2 = mutableStateMutableStateOf$default;
                            }
                            final MutableState mutableState = (MutableState) objRememberedValue2;
                            composerStartRestartGroup.endReplaceGroup();
                            boolean zVideoComponentView$lambda$5 = VideoComponentView$lambda$5(mutableState);
                            composerStartRestartGroup.startReplaceGroup(-2077043722);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoComponentView.kt#9igjgp");
                            boolean zChanged2 = composerStartRestartGroup.changed(zVideoComponentView$lambda$5);
                            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objMutableStateOf$default);
                            } else {
                                objMutableStateOf$default = objRememberedValue3;
                            }
                            final MutableState mutableState2 = (MutableState) objMutableStateOf$default;
                            composerStartRestartGroup.endReplaceGroup();
                            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localView);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final View view = (View) objConsume;
                            NonEmptyMap fallbackSources = style.getFallbackSources();
                            composerStartRestartGroup.startReplaceGroup(-2077037041);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoComponentView.kt#9igjgp");
                            boolean zChanged3 = composerStartRestartGroup.changed(fallbackSources);
                            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                NonEmptyMap fallbackSources2 = style.getFallbackSources();
                                ImageComponentStyle imageComponentStyle = fallbackSources2 != null ? new ImageComponentStyle(fallbackSources2, style.getVisible(), style.getSize(), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)), null, null, null, style.getOverlay(), style.getContentScale(), style.getRcPackage(), null, style.getTabIndex(), null, CollectionsKt.emptyList(), style.getIgnoreTopWindowInsets(), Data.MAX_DATA_BYTES, null) : null;
                                composerStartRestartGroup.updateRememberedValue(imageComponentStyle);
                                objRememberedValue4 = imageComponentStyle;
                            }
                            ImageComponentStyle imageComponentStyle2 = (ImageComponentStyle) objRememberedValue4;
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(-2077008371);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "88@4331L59");
                            URI uriRememberVideoContentState = VideoComponentView$lambda$5(mutableState) ? rememberVideoContentState(videoComponentStateRememberUpdatedVideoComponentState.getVideoUrls(), fileRepository3, composerStartRestartGroup, (i4 >> 6) & 112) : null;
                            composerStartRestartGroup.endReplaceGroup();
                            ShadowStyle shadowStyle = shadowStyleRememberShadowStyle;
                            modifier4 = modifier3;
                            Modifier modifierPadding = PaddingKt.padding(ModifierExtensionsKt.applyIfNotNull(SizeKt.size$default(modifier3, videoComponentStateRememberUpdatedVideoComponentState.getSizePlusMargin(), null, null, 6, null), videoComponentStateRememberUpdatedVideoComponentState.getMarginAdjustedAspectRatio(), new Function2<Modifier, AspectRatio, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt.VideoComponentView.1
                                @Override // kotlin.jvm.functions.Function2
                                public final Modifier invoke(Modifier applyIfNotNull, AspectRatio it) {
                                    Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    return AspectRatioKt.aspectRatio(applyIfNotNull, it);
                                }
                            }), videoComponentStateRememberUpdatedVideoComponentState.getMargin());
                            composerStartRestartGroup.startReplaceGroup(-2076995451);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoComponentView.kt#9igjgp");
                            boolean zChanged4 = composerStartRestartGroup.changed(state2);
                            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (zChanged4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = (Function2) new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$VideoComponentView$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return ShadowKt.shadow(applyIfNotNull, it, VideoComponentViewKt.VideoComponentView$lambda$3(state2));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            Modifier modifierClip = ClipKt.clip(ModifierExtensionsKt.applyIfNotNull(modifierPadding, shadowStyle, (Function2) objRememberedValue5), VideoComponentView$lambda$3(state2));
                            composerStartRestartGroup.startReplaceGroup(-2076991913);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoComponentView.kt#9igjgp");
                            boolean zChanged5 = composerStartRestartGroup.changed(state2);
                            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (zChanged5 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = (Function2) new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$VideoComponentView$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return PaddingKt.m2037padding3ABfNKs(BorderKt.border(applyIfNotNull, it, VideoComponentViewKt.VideoComponentView$lambda$3(state2)), it.m10519getWidthD9Ej5fM());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            Modifier modifierApplyIfNotNull = ModifierExtensionsKt.applyIfNotNull(modifierClip, borderStyleRememberBorderStyle, (Function2) objRememberedValue6);
                            composerStartRestartGroup.startReplaceGroup(-2076989099);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoComponentView.kt#9igjgp");
                            boolean zChangedInstance = composerStartRestartGroup.changedInstance(view);
                            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue7 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$VideoComponentView$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                        invoke2(layoutCoordinates);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(LayoutCoordinates coordinates) {
                                        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
                                        VideoComponentViewKt.VideoComponentView$lambda$6(mutableState, VideoComponentViewKt.isVisibleInViewport(LayoutCoordinatesKt.boundsInWindow(coordinates, true), view.getWidth(), view.getHeight()));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierApplyIfNotNull, (Function1) objRememberedValue7);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnGloballyPositioned);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1306780363, "C:VideoComponentView.kt#26k46s");
                            composerStartRestartGroup.startReplaceGroup(-1204771987);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "119@5809L21,107@5175L674");
                            if (!VideoComponentView$lambda$5(mutableState) || uriRememberVideoContentState == null) {
                                fileRepository4 = fileRepository3;
                            } else {
                                String string = uriRememberVideoContentState.toString();
                                Intrinsics.checkNotNullExpressionValue(string, "videoUrl.toString()");
                                Modifier modifierPadding2 = PaddingKt.padding(ModifierExtensionsKt.applyIfNotNull(ModifierExtensionsKt.applyIfNotNull(SizeKt.size$default(Modifier.INSTANCE, videoComponentStateRememberUpdatedVideoComponentState.getSize(), null, null, 6, null), videoComponentStateRememberUpdatedVideoComponentState.getAspectRatio(), VideoComponentViewKt$VideoComponentView$5$1.INSTANCE), forCurrentTheme, VideoComponentViewKt$VideoComponentView$5$2.INSTANCE), videoComponentStateRememberUpdatedVideoComponentState.getPadding());
                                boolean showControls = style.getShowControls();
                                boolean autoplay = style.getAutoplay();
                                boolean loop = style.getLoop();
                                boolean muteAudio = style.getMuteAudio();
                                ContentScale contentScale = style.getContentScale();
                                composerStartRestartGroup.startReplaceGroup(-1204750723);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoComponentView.kt#9igjgp");
                                boolean zChanged6 = composerStartRestartGroup.changed(mutableState2);
                                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                if (zChanged6 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue8 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$VideoComponentView$5$3$1
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
                                            VideoComponentViewKt.VideoComponentView$lambda$9(mutableState2, true);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                fileRepository4 = fileRepository3;
                                VideoViewKt.VideoView(string, modifierPadding2, showControls, autoplay, loop, muteAudio, contentScale, (Function0) objRememberedValue8, composerStartRestartGroup, 0, 0);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(-1204746054);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "125@6012L40");
                            if (imageComponentStyle2 != null && !VideoComponentView$lambda$8(mutableState2)) {
                                ImageComponentViewKt.ImageComponentView(imageComponentStyle2, state, null, composerStartRestartGroup, i7, 4);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        fileRepository5 = fileRepository4;
                        modifier5 = modifier4;
                    } else {
                        modifier3 = companion;
                        i4 = i3;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    i4 = i3;
                    modifier3 = modifier2;
                }
                fileRepository3 = fileRepository2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i72 = i4 & 112;
                videoComponentStateRememberUpdatedVideoComponentState = VideoComponentStateKt.rememberUpdatedVideoComponentState(style, state, composerStartRestartGroup, i4 & 126);
                if (videoComponentStateRememberUpdatedVideoComponentState.getVisible()) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                fileRepository5 = fileRepository4;
                modifier5 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier5 = modifier2;
                fileRepository5 = fileRepository2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt.VideoComponentView.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i8) {
                        VideoComponentViewKt.VideoComponentView(style, state, modifier5, fileRepository5, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) != 0) {
        }
        if ((i3 & 1171) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 == 0) {
                }
                if ((i2 & 8) == 0) {
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Shape VideoComponentView$lambda$3(State<? extends Shape> state) {
        return state.getValue();
    }

    private static final boolean VideoComponentView$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoComponentView$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean VideoComponentView$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoComponentView$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object cacheVideo(URL url, Checksum checksum, FileRepository fileRepository, Continuation continuation) {
        C08431 c08431;
        if (continuation instanceof C08431) {
            c08431 = (C08431) continuation;
            if ((c08431.label & Integer.MIN_VALUE) != 0) {
                c08431.label -= Integer.MIN_VALUE;
            } else {
                c08431 = new C08431(continuation);
            }
        }
        Object obj = c08431.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08431.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                c08431.L$0 = url;
                c08431.label = 1;
                Object objGenerateOrGetCachedFileURL = fileRepository.generateOrGetCachedFileURL(url, checksum, c08431);
                url = objGenerateOrGetCachedFileURL;
                if (objGenerateOrGetCachedFileURL == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                URL url2 = (URL) c08431.L$0;
                ResultKt.throwOnFailure(obj);
                url = url2;
            }
        } catch (Exception e) {
            Logger.INSTANCE.e("Failed to cache video: " + url, e);
        }
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ boolean isVisibleInViewport(Rect rect, int i, int i2) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        return rect.getRight() > 0.0f && rect.getBottom() > 0.0f && rect.getLeft() < ((float) i) && rect.getTop() < ((float) i2);
    }

    private static final URI rememberVideoContentState(final VideoUrls videoUrls, final FileRepository fileRepository, Composer composer, int i) {
        composer.startReplaceGroup(541496876);
        ComposerKt.sourceInformation(composer, "C(rememberVideoContentState)P(1)141@6445L54,141@6413L86,146@6595L237,146@6565L267:VideoComponentView.kt#26k46s");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(541496876, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.video.rememberVideoContentState (VideoComponentView.kt:140)");
        }
        Object[] objArr = {videoUrls.getUrl()};
        composer.startReplaceGroup(-494481958);
        ComposerKt.sourceInformation(composer, "CC(remember):VideoComponentView.kt#9igjgp");
        int i2 = (i & 14) ^ 6;
        boolean z = true;
        boolean zChangedInstance = ((i2 > 4 && composer.changed(videoUrls)) || (i & 6) == 4) | composer.changedInstance(fileRepository);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function0) new Function0<URI>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$rememberVideoContentState$videoUrl$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final URI invoke() {
                    return VideoComponentViewKt.resolveVideoUrl(videoUrls, fileRepository);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceGroup();
        URI uri = (URI) RememberSaveableKt.m5765rememberSaveable(objArr, (Saver) null, (String) null, (Function0) objRememberedValue, composer, 0, 6);
        URL url = videoUrls.getUrl();
        composer.startReplaceGroup(-494476975);
        ComposerKt.sourceInformation(composer, "CC(remember):VideoComponentView.kt#9igjgp");
        if ((i2 <= 4 || !composer.changed(videoUrls)) && (i & 6) != 4) {
            z = false;
        }
        boolean zChangedInstance2 = composer.changedInstance(fileRepository) | z;
        VideoComponentViewKt$rememberVideoContentState$1$1 videoComponentViewKt$rememberVideoContentState$1$1RememberedValue = composer.rememberedValue();
        if (zChangedInstance2 || videoComponentViewKt$rememberVideoContentState$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            videoComponentViewKt$rememberVideoContentState$1$1RememberedValue = new VideoComponentViewKt$rememberVideoContentState$1$1(videoUrls, fileRepository, null);
            composer.updateRememberedValue(videoComponentViewKt$rememberVideoContentState$1$1RememberedValue);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(url, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) videoComponentViewKt$rememberVideoContentState$1$1RememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return uri;
    }

    public static final /* synthetic */ URI resolveVideoUrl(VideoUrls videoUrls, FileRepository repository) throws URISyntaxException {
        URI file;
        Intrinsics.checkNotNullParameter(videoUrls, "videoUrls");
        Intrinsics.checkNotNullParameter(repository, "repository");
        URI file2 = repository.getFile(videoUrls.getUrl(), videoUrls.getChecksum());
        if (file2 != null) {
            return file2;
        }
        URL urlLowRes = videoUrls.getUrlLowRes();
        if (urlLowRes != null) {
            if (Intrinsics.areEqual(urlLowRes, videoUrls.getUrl())) {
                urlLowRes = null;
            }
            if (urlLowRes != null && (file = repository.getFile(urlLowRes, videoUrls.getChecksumLowRes())) != null) {
                return file;
            }
        }
        URI uri = videoUrls.getUrl().toURI();
        Intrinsics.checkNotNullExpressionValue(uri, "videoUrls.url.toURI()");
        return uri;
    }
}
