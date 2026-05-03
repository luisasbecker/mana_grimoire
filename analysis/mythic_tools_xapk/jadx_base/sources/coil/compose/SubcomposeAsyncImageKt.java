package coil.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.size.SizeResolver;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: SubcomposeAsyncImage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a»\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a¯\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2&\b\u0002\u0010\u001e\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2&\b\u0002\u0010!\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2&\b\u0002\u0010#\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001a\u0095\u0001\u0010*\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010\u001e\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010!\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010#\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003¢\u0006\u0002\u0010+\u001a[\u0010,\u001a\u00020\u0001*\u00020\u00192\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020.2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010/\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"SubcomposeAsyncImage", "", AndroidContextPlugin.DEVICE_MODEL_KEY, "", "contentDescription", "", "imageLoader", "Lcoil/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", FirebaseAnalytics.Param.CONTENT, "Lcoil/compose/SubcomposeAsyncImageScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "SubcomposeAsyncImage-sKDTAoQ", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "loading", "Lkotlin/Function2;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "success", "Lcoil/compose/AsyncImagePainter$State$Success;", "error", "Lcoil/compose/AsyncImagePainter$State$Error;", "onLoading", "onSuccess", "onError", "SubcomposeAsyncImage-Q4Kwu38", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "contentOf", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function3;", "SubcomposeAsyncImageContent", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lcoil/compose/SubcomposeAsyncImageScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "coil-compose-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SubcomposeAsyncImageKt {
    /* JADX INFO: renamed from: SubcomposeAsyncImage-Q4Kwu38, reason: not valid java name */
    public static final void m9932SubcomposeAsyncImageQ4Kwu38(final Object obj, final String str, final ImageLoader imageLoader, Modifier modifier, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, final int i2, final int i3, final int i4) {
        int iM6902getDefaultFilterQualityfv9h1I;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(934816934);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubcomposeAsyncImage)P(9,3,7,10,8,14,5,12,13,11!1,4!,6:c#ui.graphics.FilterQuality)");
        Modifier modifier2 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function44 = (i4 & 16) != 0 ? null : function4;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function45 = (i4 & 32) != 0 ? null : function42;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function46 = (i4 & 64) != 0 ? null : function43;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function14 = (i4 & 128) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function15 = (i4 & 256) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Error, Unit> function16 = (i4 & 512) != 0 ? null : function13;
        Alignment center = (i4 & 1024) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i4 & 2048) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i4 & 4096) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 8192) != 0 ? null : colorFilter;
        if ((i4 & 16384) != 0) {
            iM6902getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6902getDefaultFilterQualityfv9h1I();
            i5 = i3 & (-57345);
        } else {
            iM6902getDefaultFilterQualityfv9h1I = i;
            i5 = i3;
        }
        final Modifier modifier3 = modifier2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(934816934, i2, i5, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:49)");
        }
        final Function1<? super AsyncImagePainter.State.Loading, Unit> function17 = function14;
        Function1<AsyncImagePainter.State, Unit> function1OnStateOf = UtilsKt.onStateOf(function17, function15, function16);
        final Function1<? super AsyncImagePainter.State.Error, Unit> function18 = function16;
        final ContentScale contentScale2 = fit;
        final ColorFilter colorFilter3 = colorFilter2;
        int i6 = i5;
        int i7 = i6 << 18;
        int i8 = (i2 & 112) | 520 | (i2 & 7168) | (i7 & 3670016) | (i7 & 29360128) | (i7 & 234881024) | (i7 & 1879048192);
        int i9 = (i6 >> 12) & 14;
        final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function47 = function46;
        final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function48 = function45;
        final Function1<? super AsyncImagePainter.State.Success, Unit> function19 = function15;
        final Alignment alignment2 = center;
        final float f3 = f2;
        final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function49 = function44;
        final int i10 = iM6902getDefaultFilterQualityfv9h1I;
        m9933SubcomposeAsyncImagesKDTAoQ(obj, str, imageLoader, modifier3, null, function1OnStateOf, alignment2, contentScale2, f3, colorFilter3, i10, contentOf(function44, function45, function46), composerStartRestartGroup, i8, i9, 16);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$1
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

            public final void invoke(Composer composer2, int i11) {
                SubcomposeAsyncImageKt.m9932SubcomposeAsyncImageQ4Kwu38(obj, str, imageLoader, modifier3, function49, function48, function47, function17, function19, function18, alignment2, contentScale2, f3, colorFilter3, i10, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
            }
        });
    }

    /* JADX INFO: renamed from: SubcomposeAsyncImage-sKDTAoQ, reason: not valid java name */
    public static final void m9933SubcomposeAsyncImagesKDTAoQ(final Object obj, final String str, final ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, final Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2, final int i3, final int i4) {
        int iM6902getDefaultFilterQualityfv9h1I;
        int i5;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function13;
        Function1<? super AsyncImagePainter.State, Unit> function14;
        final Alignment alignment2;
        final Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(10937794);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubcomposeAsyncImage)P(8,4,7,9,11,10!1,5!2,6:c#ui.graphics.FilterQuality)");
        Modifier modifier3 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function15 = (i4 & 32) != 0 ? null : function12;
        Alignment center = (i4 & 64) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i4 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        final float f2 = (i4 & 256) != 0 ? 1.0f : f;
        final ColorFilter colorFilter2 = (i4 & 512) != 0 ? null : colorFilter;
        if ((i4 & 1024) != 0) {
            iM6902getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m6902getDefaultFilterQualityfv9h1I();
            i5 = i3 & (-15);
        } else {
            iM6902getDefaultFilterQualityfv9h1I = i;
            i5 = i3;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(10937794, i2, i5, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:104)");
        }
        ImageRequest imageRequestUpdateRequest = AsyncImageKt.updateRequest(UtilsKt.requestOf(obj, composerStartRestartGroup, 8), fit, composerStartRestartGroup, 8 | ((i2 >> 18) & 112));
        int i6 = i2 >> 6;
        int i7 = i2 >> 9;
        final AsyncImagePainter asyncImagePainterM9908rememberAsyncImagePainter5jETZwI = AsyncImagePainterKt.m9908rememberAsyncImagePainter5jETZwI(imageRequestUpdateRequest, imageLoader, defaultTransform, function15, fit, iM6902getDefaultFilterQualityfv9h1I, composerStartRestartGroup, (i6 & 7168) | (i6 & 896) | 72 | (i7 & 57344) | ((i5 << 15) & 458752), 0);
        final SizeResolver sizeResolver = imageRequestUpdateRequest.getSizeResolver();
        if (sizeResolver instanceof ConstraintsSizeResolver) {
            function13 = defaultTransform;
            function14 = function15;
            alignment2 = center;
            composerStartRestartGroup.startReplaceableGroup(-247978567);
            final ContentScale contentScale2 = fit;
            final int i8 = i5;
            Modifier modifier4 = modifier3;
            BoxWithConstraintsKt.BoxWithConstraints(modifier4, alignment2, true, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1964284792, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                    invoke(boxWithConstraintsScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i9) {
                    int i10;
                    if ((i9 & 14) == 0) {
                        i10 = (composer2.changed(boxWithConstraintsScope) ? 4 : 2) | i9;
                    } else {
                        i10 = i9;
                    }
                    if ((i10 & 91) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1964284792, i9, -1, "coil.compose.SubcomposeAsyncImage.<anonymous> (SubcomposeAsyncImage.kt:150)");
                    }
                    ((ConstraintsSizeResolver) sizeResolver).m9912setConstraintsBRTryo0(boxWithConstraintsScope.mo1931getConstraintsmsEJaDk());
                    function3.invoke(new RealSubcomposeAsyncImageScope(boxWithConstraintsScope, asyncImagePainterM9908rememberAsyncImagePainter5jETZwI, str, alignment2, contentScale2, f2, colorFilter2), composer2, Integer.valueOf(i8 & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, (i7 & 14) | 3456 | ((i2 >> 15) & 112), 0);
            modifier2 = modifier4;
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-247979203);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, true, composerStartRestartGroup, (((((i7 & 14) | 384) | ((i2 >> 15) & 112)) >> 3) & 14) | 48);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            function13 = defaultTransform;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
            function14 = function15;
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m5603setimpl(composerM5595constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m5603setimpl(composerM5595constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m5568boximpl(SkippableUpdater.m5569constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            Alignment alignment3 = center;
            alignment2 = alignment3;
            function3.invoke(new RealSubcomposeAsyncImageScope(BoxScopeInstance.INSTANCE, asyncImagePainterM9908rememberAsyncImagePainter5jETZwI, str, alignment3, fit, f2, colorFilter2), composerStartRestartGroup, Integer.valueOf(i5 & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            modifier2 = modifier3;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final ContentScale contentScale3 = fit;
        final int i9 = iM6902getDefaultFilterQualityfv9h1I;
        final Alignment alignment4 = alignment2;
        final float f3 = f2;
        final ColorFilter colorFilter3 = colorFilter2;
        final Function1<? super AsyncImagePainter.State, Unit> function16 = function14;
        final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function17 = function13;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$4
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

            public final void invoke(Composer composer2, int i10) {
                SubcomposeAsyncImageKt.m9933SubcomposeAsyncImagesKDTAoQ(obj, str, imageLoader, modifier2, function17, function16, alignment4, contentScale3, f3, colorFilter3, i9, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SubcomposeAsyncImageContent(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, final int i, final int i2) {
        SubcomposeAsyncImageScope subcomposeAsyncImageScope2;
        int i3;
        Modifier modifier2;
        int i4;
        String str2;
        Alignment alignment2;
        ContentScale contentScale2;
        float f2;
        int i5;
        ColorFilter colorFilter2;
        int i6;
        AsyncImagePainter painter2;
        String contentDescription;
        Alignment alignment3;
        ContentScale contentScale3;
        float alpha;
        String str3;
        Alignment alignment4;
        int i7;
        Painter painter3;
        ColorFilter colorFilter3;
        int i8;
        Modifier modifier3;
        ContentScale contentScale4;
        Composer composer2;
        final Painter painter4;
        final String str4;
        final Alignment alignment5;
        final ColorFilter colorFilter4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-263982313);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubcomposeAsyncImageContent)P(5,6,3!1,4)");
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
            subcomposeAsyncImageScope2 = subcomposeAsyncImageScope;
        } else if ((i & 14) == 0) {
            subcomposeAsyncImageScope2 = subcomposeAsyncImageScope;
            i3 = (composerStartRestartGroup.changed(subcomposeAsyncImageScope2) ? 4 : 2) | i;
        } else {
            subcomposeAsyncImageScope2 = subcomposeAsyncImageScope;
            i3 = i;
        }
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 2;
            if (i4 != 0) {
                i3 |= 128;
            }
            if ((i & 7168) != 0) {
                if ((i2 & 4) == 0) {
                    str2 = str;
                    int i10 = composerStartRestartGroup.changed(str2) ? 2048 : 1024;
                    i3 |= i10;
                } else {
                    str2 = str;
                }
                i3 |= i10;
            } else {
                str2 = str;
            }
            if ((i & 57344) != 0) {
                if ((i2 & 8) == 0) {
                    alignment2 = alignment;
                    int i11 = composerStartRestartGroup.changed(alignment2) ? 16384 : 8192;
                    i3 |= i11;
                } else {
                    alignment2 = alignment;
                }
                i3 |= i11;
            } else {
                alignment2 = alignment;
            }
            if ((i & 458752) != 0) {
                if ((i2 & 16) == 0) {
                    contentScale2 = contentScale;
                    int i12 = composerStartRestartGroup.changed(contentScale2) ? 131072 : 65536;
                    i3 |= i12;
                } else {
                    contentScale2 = contentScale;
                }
                i3 |= i12;
            } else {
                contentScale2 = contentScale;
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 32) == 0) {
                    f2 = f;
                    int i13 = composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
                    i3 |= i13;
                } else {
                    f2 = f;
                }
                i3 |= i13;
            } else {
                f2 = f;
            }
            if ((i & 29360128) != 0) {
                i5 = 57344;
                colorFilter2 = colorFilter;
                i3 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(colorFilter2)) ? 8388608 : 4194304;
            } else {
                i5 = 57344;
                colorFilter2 = colorFilter;
            }
            if (i4 != 2) {
                i6 = 458752;
                if ((23967451 & i3) == 4793490 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    painter4 = painter;
                    composer2 = composerStartRestartGroup;
                    str4 = str2;
                    colorFilter4 = colorFilter2;
                    alignment5 = alignment2;
                }
                final float f3 = f2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final SubcomposeAsyncImageScope subcomposeAsyncImageScope3 = subcomposeAsyncImageScope2;
                final Modifier modifier4 = modifier2;
                final ContentScale contentScale5 = contentScale2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt.SubcomposeAsyncImageContent.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i14) {
                        SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(subcomposeAsyncImageScope3, modifier4, painter4, str4, alignment5, contentScale5, f3, colorFilter4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            i6 = 458752;
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 == 0) {
                    painter2 = subcomposeAsyncImageScope2.getPainter();
                    i3 &= -897;
                } else {
                    painter2 = painter;
                }
                if ((i2 & 4) == 0) {
                    contentDescription = subcomposeAsyncImageScope2.getContentDescription();
                    i3 &= -7169;
                } else {
                    contentDescription = str2;
                }
                if ((i2 & 8) == 0) {
                    alignment3 = subcomposeAsyncImageScope2.getAlignment();
                    i3 &= -57345;
                } else {
                    alignment3 = alignment2;
                }
                if ((i2 & 16) == 0) {
                    contentScale3 = subcomposeAsyncImageScope2.getContentScale();
                    i3 &= -458753;
                } else {
                    contentScale3 = contentScale2;
                }
                if ((i2 & 32) == 0) {
                    alpha = subcomposeAsyncImageScope2.getAlpha();
                    i3 &= -3670017;
                } else {
                    alpha = f2;
                }
                if ((i2 & 64) != 0) {
                    colorFilter2 = subcomposeAsyncImageScope2.getColorFilter();
                    i3 &= -29360129;
                }
                str3 = contentDescription;
                alignment4 = alignment3;
                f2 = alpha;
                i7 = i6;
                painter3 = painter2;
                colorFilter3 = colorFilter2;
                i8 = 3670016;
                modifier3 = modifier2;
                contentScale4 = contentScale3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if (i4 != 0) {
                    i3 &= -897;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -7169;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -57345;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -458753;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -3670017;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -29360129;
                }
                str3 = str2;
                i8 = 3670016;
                i7 = i6;
                colorFilter3 = colorFilter2;
                contentScale4 = contentScale2;
                modifier3 = modifier2;
                alignment4 = alignment2;
                painter3 = painter;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-263982313, i3, -1, "coil.compose.SubcomposeAsyncImageContent (SubcomposeAsyncImage.kt:202)");
            }
            int i14 = i3 >> 3;
            composer2 = composerStartRestartGroup;
            AsyncImageKt.Content(modifier3, painter3, str3, alignment4, contentScale4, f2, colorFilter3, composer2, (i14 & 14) | 64 | (i14 & 896) | (i14 & 7168) | (i14 & i5) | (i7 & i14) | (i14 & i8));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            painter4 = painter3;
            str4 = str3;
            alignment5 = alignment4;
            contentScale2 = contentScale4;
            colorFilter4 = colorFilter3;
            final float f32 = f2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 2;
        if (i4 != 0) {
        }
        if ((i & 7168) != 0) {
        }
        if ((i & 57344) != 0) {
        }
        if ((i & 458752) != 0) {
        }
        if ((i & 3670016) != 0) {
        }
        if ((i & 29360128) != 0) {
        }
        if (i4 != 2) {
        }
        composerStartRestartGroup.startDefaults();
        if ((i & 1) != 0) {
            if (i9 != 0) {
            }
            if (i4 == 0) {
            }
            if ((i2 & 4) == 0) {
            }
            if ((i2 & 8) == 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if ((i2 & 32) == 0) {
            }
            if ((i2 & 64) != 0) {
            }
            str3 = contentDescription;
            alignment4 = alignment3;
            f2 = alpha;
            i7 = i6;
            painter3 = painter2;
            colorFilter3 = colorFilter2;
            i8 = 3670016;
            modifier3 = modifier2;
            contentScale4 = contentScale3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i142 = i3 >> 3;
            composer2 = composerStartRestartGroup;
            AsyncImageKt.Content(modifier3, painter3, str3, alignment4, contentScale4, f2, colorFilter3, composer2, (i142 & 14) | 64 | (i142 & 896) | (i142 & 7168) | (i142 & i5) | (i7 & i142) | (i142 & i8));
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
            painter4 = painter3;
            str4 = str3;
            alignment5 = alignment4;
            contentScale2 = contentScale4;
            colorFilter4 = colorFilter3;
        }
        final float f322 = f2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf(final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43) {
        return (function4 == null && function42 == null && function43 == null) ? ComposableSingletons$SubcomposeAsyncImageKt.INSTANCE.m9911getLambda1$coil_compose_base_release() : ComposableLambdaKt.composableLambdaInstance(-1302781228, true, new Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt.contentOf.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, Integer num) {
                invoke(subcomposeAsyncImageScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:47:0x00b7  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x00cd  */
            /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, int i) {
                int i2;
                if ((i & 14) == 0) {
                    i2 = (composer.changed(subcomposeAsyncImageScope) ? 4 : 2) | i;
                } else {
                    i2 = i;
                }
                if ((i2 & 91) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1302781228, i2, -1, "coil.compose.contentOf.<anonymous> (SubcomposeAsyncImage.kt:227)");
                }
                AsyncImagePainter.State state = subcomposeAsyncImageScope.getPainter().getState();
                boolean z = false;
                boolean z2 = true;
                if (state instanceof AsyncImagePainter.State.Loading) {
                    composer.startReplaceableGroup(-418307549);
                    Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Loading, Composer, Integer, Unit> function44 = function4;
                    if (function44 != null) {
                        function44.invoke(subcomposeAsyncImageScope, (AsyncImagePainter.State.Loading) state, composer, Integer.valueOf((i2 & 14) | 64));
                        Unit unit = Unit.INSTANCE;
                    } else {
                        z = true;
                    }
                    composer.endReplaceableGroup();
                } else if (state instanceof AsyncImagePainter.State.Success) {
                    composer.startReplaceableGroup(-418307455);
                    Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Success, Composer, Integer, Unit> function45 = function42;
                    if (function45 != null) {
                        function45.invoke(subcomposeAsyncImageScope, (AsyncImagePainter.State.Success) state, composer, Integer.valueOf((i2 & 14) | 64));
                        Unit unit2 = Unit.INSTANCE;
                    } else {
                        z = true;
                    }
                    composer.endReplaceableGroup();
                } else {
                    if (!(state instanceof AsyncImagePainter.State.Error)) {
                        if (state instanceof AsyncImagePainter.State.Empty) {
                            composer.startReplaceableGroup(-418307275);
                            composer.endReplaceableGroup();
                        } else {
                            composer.startReplaceableGroup(-418307215);
                            composer.endReplaceableGroup();
                        }
                        if (z2) {
                            SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, composer, i2 & 14, 127);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            return;
                        }
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    composer.startReplaceableGroup(-418307363);
                    Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Error, Composer, Integer, Unit> function46 = function43;
                    if (function46 != null) {
                        function46.invoke(subcomposeAsyncImageScope, (AsyncImagePainter.State.Error) state, composer, Integer.valueOf((i2 & 14) | 64));
                        Unit unit3 = Unit.INSTANCE;
                    } else {
                        z = true;
                    }
                    composer.endReplaceableGroup();
                }
                z2 = z;
                if (z2) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        });
    }
}
