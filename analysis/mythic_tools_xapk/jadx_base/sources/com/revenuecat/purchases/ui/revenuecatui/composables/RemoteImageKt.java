package com.revenuecat.purchases.ui.revenuecatui.composables;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import coil.ImageLoader;
import coil.compose.AsyncImageKt;
import coil.compose.AsyncImagePainter;
import coil.compose.AsyncImagePainterKt;
import coil.request.CachePolicy;
import coil.request.ImageRequest;
import coil.transform.Transformation;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.ui.revenuecatui.composables.ImageSource;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PurchasesExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ImagePreviewsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RemoteImage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\u001ay\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015H\u0003¢\u0006\u0002\u0010\u0017\u001aW\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0003¢\u0006\u0002\u0010\u001c\u001a\u0015\u0010\u001d\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u001e\u001aY\u0010\u001f\u001a\u00020\u00012\b\b\u0001\u0010 \u001a\u00020!2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0001¢\u0006\u0002\u0010\"\u001ac\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0001¢\u0006\u0002\u0010&¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u008e\u0002"}, d2 = {"AsyncImage", "", "source", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/ImageSource;", "imageRequest", "Lcoil/request/ImageRequest;", "imageLoader", "Lcoil/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "contentDescription", "", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "onError", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State$Error;", "(Lcom/revenuecat/purchases/ui/revenuecatui/composables/ImageSource;Lcoil/request/ImageRequest;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;FLandroidx/compose/ui/graphics/ColorFilter;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Image", "placeholderSource", "transformation", "Lcoil/transform/Transformation;", "(Lcom/revenuecat/purchases/ui/revenuecatui/composables/ImageSource;Lcom/revenuecat/purchases/ui/revenuecatui/composables/ImageSource;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;Lcoil/transform/Transformation;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "ImageForPreviews", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "LocalImage", "resource", "", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;Lcoil/transform/Transformation;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "RemoteImage", "urlString", "placeholderUrlString", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;Lcoil/transform/Transformation;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsBc8Release", "cachePolicy", "Lcoil/request/CachePolicy;"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RemoteImageKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AsyncImage(final ImageSource imageSource, final ImageRequest imageRequest, final ImageLoader imageLoader, Modifier modifier, Painter painter, final ContentScale contentScale, final String str, final float f, ColorFilter colorFilter, Function1<? super AsyncImagePainter.State.Error, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        ImageLoader imageLoader2;
        Modifier modifier2;
        int i4;
        Painter painter2;
        ContentScale contentScale2;
        String str2;
        float f2;
        int i5;
        int i6;
        final Function1<? super AsyncImagePainter.State.Error, Unit> function12;
        boolean z;
        Object objRememberedValue;
        Composer composer2;
        final Function1<? super AsyncImagePainter.State.Error, Unit> function13;
        final Modifier modifier3;
        final Painter painter3;
        final ColorFilter colorFilter2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1661786347);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AsyncImage)P(9,5,4,6,8,3,2)198@6807L327,189@6504L637:RemoteImage.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(imageSource) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            obj = imageRequest;
        } else {
            obj = imageRequest;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(obj) ? 32 : 16;
            }
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
            imageLoader2 = imageLoader;
        } else {
            imageLoader2 = imageLoader;
            if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(imageLoader2) ? 256 : 128;
            }
        }
        int i7 = i2 & 8;
        if (i7 != 0) {
            i3 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    painter2 = painter;
                    i3 |= composerStartRestartGroup.changedInstance(painter2) ? 16384 : 8192;
                }
                if ((i2 & 32) != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        contentScale2 = contentScale;
                        i3 |= composerStartRestartGroup.changed(contentScale2) ? 131072 : 65536;
                    }
                    if ((i2 & 64) == 0) {
                        i3 |= 1572864;
                        str2 = str;
                    } else {
                        str2 = str;
                        if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changed(str2) ? 1048576 : 524288;
                        }
                    }
                    if ((i2 & 128) != 0) {
                        if ((i & 12582912) == 0) {
                            f2 = f;
                            i3 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
                        }
                        i5 = i2 & 256;
                        if (i5 != 0) {
                            i3 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i3 |= composerStartRestartGroup.changed(colorFilter) ? 67108864 : 33554432;
                        }
                        i6 = i2 & 512;
                        if (i6 != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                        }
                        if ((i3 & 306783379) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            colorFilter2 = colorFilter;
                            function13 = function1;
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier2;
                            painter3 = painter2;
                        } else {
                            if (i7 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                painter2 = null;
                            }
                            ColorFilter colorFilter3 = i5 == 0 ? null : colorFilter;
                            function12 = i6 == 0 ? function1 : null;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1661786347, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.AsyncImage (RemoteImage.kt:188)");
                            }
                            composerStartRestartGroup.startReplaceGroup(1702092759);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):RemoteImage.kt#9igjgp");
                            z = ((i3 & 14) != 4) | ((1879048192 & i3) != 536870912);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = (Function1) new Function1<AsyncImagePainter.State.Error, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt$AsyncImage$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
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
                                        String str3;
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        ImageSource imageSource2 = imageSource;
                                        if (imageSource2 instanceof ImageSource.Local) {
                                            str3 = "Error loading local image: '" + ((ImageSource.Local) imageSource).getResource() + '\'';
                                        } else {
                                            if (!(imageSource2 instanceof ImageSource.Remote)) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            str3 = "Error loading image from '" + ((ImageSource.Remote) imageSource).getUrlString() + '\'';
                                        }
                                        Logger.INSTANCE.e(str3, it.getResult().getThrowable());
                                        Function1<AsyncImagePainter.State.Error, Unit> function14 = function12;
                                        if (function14 != null) {
                                            function14.invoke(it);
                                        }
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            Function1 function14 = (Function1) objRememberedValue;
                            composerStartRestartGroup.endReplaceGroup();
                            int i8 = i3 >> 15;
                            composer2 = composerStartRestartGroup;
                            Modifier modifier4 = modifier2;
                            Painter painter4 = painter2;
                            AsyncImageKt.m9900AsyncImageQ4Kwu38(obj, str2, imageLoader2, modifier4, painter4, null, null, null, null, function14, null, contentScale2, f2, colorFilter3, 0, composer2, ((i3 >> 3) & 14) | (i8 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3), ((i3 >> 12) & 112) | (i8 & 896) | (i8 & 7168), 17888);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function13 = function12;
                            modifier3 = modifier4;
                            painter3 = painter4;
                            colorFilter2 = colorFilter3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt.AsyncImage.2
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

                                public final void invoke(Composer composer3, int i9) {
                                    RemoteImageKt.AsyncImage(imageSource, imageRequest, imageLoader, modifier3, painter3, contentScale, str, f, colorFilter2, function13, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 12582912;
                    f2 = f;
                    i5 = i2 & 256;
                    if (i5 != 0) {
                    }
                    i6 = i2 & 512;
                    if (i6 != 0) {
                    }
                    if ((i3 & 306783379) == 306783378) {
                        if (i7 != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composerStartRestartGroup.startReplaceGroup(1702092759);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):RemoteImage.kt#9igjgp");
                        z = ((i3 & 14) != 4) | ((1879048192 & i3) != 536870912);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = (Function1) new Function1<AsyncImagePainter.State.Error, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt$AsyncImage$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
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
                                    String str3;
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    ImageSource imageSource2 = imageSource;
                                    if (imageSource2 instanceof ImageSource.Local) {
                                        str3 = "Error loading local image: '" + ((ImageSource.Local) imageSource).getResource() + '\'';
                                    } else {
                                        if (!(imageSource2 instanceof ImageSource.Remote)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        str3 = "Error loading image from '" + ((ImageSource.Remote) imageSource).getUrlString() + '\'';
                                    }
                                    Logger.INSTANCE.e(str3, it.getResult().getThrowable());
                                    Function1<AsyncImagePainter.State.Error, Unit> function142 = function12;
                                    if (function142 != null) {
                                        function142.invoke(it);
                                    }
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            Function1 function142 = (Function1) objRememberedValue;
                            composerStartRestartGroup.endReplaceGroup();
                            int i82 = i3 >> 15;
                            composer2 = composerStartRestartGroup;
                            Modifier modifier42 = modifier2;
                            Painter painter42 = painter2;
                            AsyncImageKt.m9900AsyncImageQ4Kwu38(obj, str2, imageLoader2, modifier42, painter42, null, null, null, null, function142, null, contentScale2, f2, colorFilter3, 0, composer2, ((i3 >> 3) & 14) | (i82 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3), ((i3 >> 12) & 112) | (i82 & 896) | (i82 & 7168), 17888);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function13 = function12;
                            modifier3 = modifier42;
                            painter3 = painter42;
                            colorFilter2 = colorFilter3;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                contentScale2 = contentScale;
                if ((i2 & 64) == 0) {
                }
                if ((i2 & 128) != 0) {
                }
                f2 = f;
                i5 = i2 & 256;
                if (i5 != 0) {
                }
                i6 = i2 & 512;
                if (i6 != 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            painter2 = painter;
            if ((i2 & 32) != 0) {
            }
            contentScale2 = contentScale;
            if ((i2 & 64) == 0) {
            }
            if ((i2 & 128) != 0) {
            }
            f2 = f;
            i5 = i2 & 256;
            if (i5 != 0) {
            }
            i6 = i2 & 512;
            if (i6 != 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        painter2 = painter;
        if ((i2 & 32) != 0) {
        }
        contentScale2 = contentScale;
        if ((i2 & 64) == 0) {
        }
        if ((i2 & 128) != 0) {
        }
        f2 = f;
        i5 = i2 & 256;
        if (i5 != 0) {
        }
        i6 = i2 & 512;
        if (i6 != 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Image(final ImageSource imageSource, final ImageSource imageSource2, Modifier modifier, final ContentScale contentScale, final String str, final Transformation transformation, final float f, final ColorFilter colorFilter, Composer composer, final int i, final int i2) {
        final ImageSource imageSource3;
        int i3;
        Modifier modifier2;
        ContentScale contentScale2;
        String str2;
        Transformation transformation2;
        float f2;
        ColorFilter colorFilter2;
        final Modifier.Companion companion;
        ImageLoader imageLoader;
        boolean zIsInPreviewMode;
        Object objRememberedValue;
        Painter painter;
        MutableState mutableState;
        int i4;
        AsyncImagePainter asyncImagePainterM9907rememberAsyncImagePainter3HmZ8SU;
        Modifier modifier3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(49748314);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Image)P(6,5,4,3,2,7)113@3799L7,114@3833L17,119@3980L48,120@4071L7,125@4322L7,133@4622L17:RemoteImage.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            imageSource3 = imageSource;
        } else if ((i & 6) == 0) {
            imageSource3 = imageSource;
            i3 = (composerStartRestartGroup.changed(imageSource3) ? 4 : 2) | i;
        } else {
            imageSource3 = imageSource;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(imageSource2) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    contentScale2 = contentScale;
                    i3 |= composerStartRestartGroup.changed(contentScale2) ? 2048 : 1024;
                }
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        str2 = str;
                        i3 |= composerStartRestartGroup.changed(str2) ? 16384 : 8192;
                    }
                    if ((i2 & 32) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else {
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            transformation2 = transformation;
                            i3 |= composerStartRestartGroup.changedInstance(transformation2) ? 131072 : 65536;
                        }
                        if ((i2 & 64) != 0) {
                            i3 |= 1572864;
                        } else {
                            if ((i & 1572864) == 0) {
                                f2 = f;
                                i3 |= composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
                            }
                            if ((i2 & 128) != 0) {
                                if ((i & 12582912) == 0) {
                                    colorFilter2 = colorFilter;
                                    i3 |= composerStartRestartGroup.changed(colorFilter2) ? 8388608 : 4194304;
                                }
                                if ((i3 & 4793491) == 4793490 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    modifier4 = modifier2;
                                } else {
                                    companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(49748314, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Image (RemoteImage.kt:111)");
                                    }
                                    ProvidableCompositionLocal<ImageLoader> localPreviewImageLoader = ImagePreviewsKt.getLocalPreviewImageLoader();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object objConsume = composerStartRestartGroup.consume(localPreviewImageLoader);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    imageLoader = (ImageLoader) objConsume;
                                    zIsInPreviewMode = HelperFunctionsKt.isInPreviewMode(composerStartRestartGroup, 0);
                                    composerStartRestartGroup.startReplaceGroup(1183181582);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "116@3923L26");
                                    if (!zIsInPreviewMode && imageLoader == null) {
                                        ImageForPreviews(companion, composerStartRestartGroup, (i3 >> 6) & 14);
                                        composerStartRestartGroup.endReplaceGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                                        if (scopeUpdateScopeEndRestartGroup2 != null) {
                                            final ContentScale contentScale3 = contentScale2;
                                            final String str3 = str2;
                                            final Transformation transformation3 = transformation2;
                                            final float f3 = f2;
                                            final ColorFilter colorFilter3 = colorFilter2;
                                            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt.Image.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                    invoke(composer2, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer2, int i6) {
                                                    RemoteImageKt.Image(imageSource3, imageSource2, companion, contentScale3, str3, transformation3, f3, colorFilter3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                    Modifier modifier5 = companion;
                                    composerStartRestartGroup.endReplaceGroup();
                                    composerStartRestartGroup.startReplaceGroup(1183185530);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):RemoteImage.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CachePolicy.ENABLED, null, 2, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    MutableState mutableState2 = (MutableState) objRememberedValue;
                                    composerStartRestartGroup.endReplaceGroup();
                                    ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composerStartRestartGroup.consume(localContext);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    Context applicationContext = ((Context) objConsume2).getApplicationContext();
                                    if (!zIsInPreviewMode) {
                                        imageLoader = null;
                                    }
                                    composerStartRestartGroup.startReplaceGroup(1183190105);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "121@4169L94");
                                    if (imageLoader == null) {
                                        composerStartRestartGroup.startReplaceGroup(1183191624);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):RemoteImage.kt#9igjgp");
                                        boolean zChanged = composerStartRestartGroup.changed(applicationContext);
                                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            Purchases.Companion companion2 = Purchases.INSTANCE;
                                            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                                            objRememberedValue2 = PurchasesExtensionsKt.getImageLoaderTyped(companion2, applicationContext);
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                        }
                                        imageLoader = (ImageLoader) objRememberedValue2;
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                    ImageLoader imageLoader2 = imageLoader;
                                    composerStartRestartGroup.endReplaceGroup();
                                    ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object objConsume3 = composerStartRestartGroup.consume(localContext2);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ImageRequest imageRequestBuild = new ImageRequest.Builder((Context) objConsume3).data(imageSource.getData()).crossfade(200).transformations(CollectionsKt.listOfNotNull(transformation)).diskCachePolicy(Image$lambda$2(mutableState2)).memoryCachePolicy(Image$lambda$2(mutableState2)).build();
                                    Painter previewPlaceholderBlocking = !HelperFunctionsKt.isInPreviewMode(composerStartRestartGroup, 0) ? ImagePreviewsKt.getPreviewPlaceholderBlocking(imageLoader2, imageRequestBuild) : null;
                                    composerStartRestartGroup.startReplaceGroup(1183210383);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*135@4762L305");
                                    if (imageSource2 != null) {
                                        mutableState = mutableState2;
                                        asyncImagePainterM9907rememberAsyncImagePainter3HmZ8SU = null;
                                        i4 = i3;
                                        painter = previewPlaceholderBlocking;
                                    } else {
                                        painter = previewPlaceholderBlocking;
                                        mutableState = mutableState2;
                                        i4 = i3;
                                        asyncImagePainterM9907rememberAsyncImagePainter3HmZ8SU = AsyncImagePainterKt.m9907rememberAsyncImagePainter3HmZ8SU(imageSource2.getData(), imageLoader2, painter, null, null, null, null, new Function1<AsyncImagePainter.State.Error, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt$Image$placeholder$1$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(AsyncImagePainter.State.Error error) {
                                                invoke2(error);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(AsyncImagePainter.State.Error errorState) {
                                                Intrinsics.checkNotNullParameter(errorState, "errorState");
                                                Logger.INSTANCE.e("Error loading placeholder image", errorState.getResult().getThrowable());
                                            }
                                        }, contentScale, 0, composerStartRestartGroup, ((i3 << 15) & 234881024) | 12582912, 632);
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    AsyncImagePainter asyncImagePainter = asyncImagePainterM9907rememberAsyncImagePainter3HmZ8SU == null ? asyncImagePainterM9907rememberAsyncImagePainter3HmZ8SU : painter;
                                    if (Image$lambda$2(mutableState) != CachePolicy.ENABLED) {
                                        composerStartRestartGroup.startReplaceGroup(-1974786927);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "155@5526L149,145@5151L535");
                                        composerStartRestartGroup.startReplaceGroup(1183235103);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):RemoteImage.kt#9igjgp");
                                        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            final MutableState mutableState3 = mutableState;
                                            objRememberedValue3 = (Function1) new Function1<AsyncImagePainter.State.Error, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt$Image$2$1
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
                                                    Logger.INSTANCE.w("Image failed to load. Will try again disabling cache");
                                                    mutableState3.setValue(CachePolicy.WRITE_ONLY);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                        int i6 = i4 << 3;
                                        int i7 = i4 << 6;
                                        int i8 = (i4 & 14) | 805306368 | (i6 & 7168) | (458752 & i7) | (i7 & 3670016) | (29360128 & i6) | (i6 & 234881024);
                                        modifier3 = modifier5;
                                        AsyncImage(imageSource, imageRequestBuild, imageLoader2, modifier3, asyncImagePainter, contentScale, str, f, colorFilter, (Function1) objRememberedValue3, composerStartRestartGroup, i8, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        modifier3 = modifier5;
                                        composerStartRestartGroup.startReplaceGroup(-1974239746);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "161@5708L362");
                                        int i9 = i4 << 3;
                                        int i10 = i4 << 6;
                                        AsyncImage(imageSource, imageRequestBuild, imageLoader2, modifier3, asyncImagePainter, contentScale, str, f, colorFilter, null, composerStartRestartGroup, (i4 & 14) | (i9 & 7168) | (458752 & i10) | (i10 & 3670016) | (29360128 & i9) | (i9 & 234881024), 512);
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier4 = modifier3;
                                }
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt.Image.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                            invoke(composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i11) {
                                            RemoteImageKt.Image(imageSource, imageSource2, modifier4, contentScale, str, transformation, f, colorFilter, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i3 |= 12582912;
                            colorFilter2 = colorFilter;
                            if ((i3 & 4793491) == 4793490) {
                                if (i5 == 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                ProvidableCompositionLocal<ImageLoader> localPreviewImageLoader2 = ImagePreviewsKt.getLocalPreviewImageLoader();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume4 = composerStartRestartGroup.consume(localPreviewImageLoader2);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                imageLoader = (ImageLoader) objConsume4;
                                zIsInPreviewMode = HelperFunctionsKt.isInPreviewMode(composerStartRestartGroup, 0);
                                composerStartRestartGroup.startReplaceGroup(1183181582);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "116@3923L26");
                                if (!zIsInPreviewMode) {
                                }
                                Modifier modifier52 = companion;
                                composerStartRestartGroup.endReplaceGroup();
                                composerStartRestartGroup.startReplaceGroup(1183185530);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):RemoteImage.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                }
                                MutableState mutableState22 = (MutableState) objRememberedValue;
                                composerStartRestartGroup.endReplaceGroup();
                                ProvidableCompositionLocal<Context> localContext3 = AndroidCompositionLocals_androidKt.getLocalContext();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume22 = composerStartRestartGroup.consume(localContext3);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Context applicationContext2 = ((Context) objConsume22).getApplicationContext();
                                if (!zIsInPreviewMode) {
                                }
                                composerStartRestartGroup.startReplaceGroup(1183190105);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "121@4169L94");
                                if (imageLoader == null) {
                                }
                                ImageLoader imageLoader22 = imageLoader;
                                composerStartRestartGroup.endReplaceGroup();
                                ProvidableCompositionLocal<Context> localContext22 = AndroidCompositionLocals_androidKt.getLocalContext();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume32 = composerStartRestartGroup.consume(localContext22);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ImageRequest imageRequestBuild2 = new ImageRequest.Builder((Context) objConsume32).data(imageSource.getData()).crossfade(200).transformations(CollectionsKt.listOfNotNull(transformation)).diskCachePolicy(Image$lambda$2(mutableState22)).memoryCachePolicy(Image$lambda$2(mutableState22)).build();
                                if (!HelperFunctionsKt.isInPreviewMode(composerStartRestartGroup, 0)) {
                                }
                                composerStartRestartGroup.startReplaceGroup(1183210383);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*135@4762L305");
                                if (imageSource2 != null) {
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                if (asyncImagePainterM9907rememberAsyncImagePainter3HmZ8SU == null) {
                                }
                                if (Image$lambda$2(mutableState) != CachePolicy.ENABLED) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier4 = modifier3;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        f2 = f;
                        if ((i2 & 128) != 0) {
                        }
                        colorFilter2 = colorFilter;
                        if ((i3 & 4793491) == 4793490) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    transformation2 = transformation;
                    if ((i2 & 64) != 0) {
                    }
                    f2 = f;
                    if ((i2 & 128) != 0) {
                    }
                    colorFilter2 = colorFilter;
                    if ((i3 & 4793491) == 4793490) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                str2 = str;
                if ((i2 & 32) == 0) {
                }
                transformation2 = transformation;
                if ((i2 & 64) != 0) {
                }
                f2 = f;
                if ((i2 & 128) != 0) {
                }
                colorFilter2 = colorFilter;
                if ((i3 & 4793491) == 4793490) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            contentScale2 = contentScale;
            if ((i2 & 16) != 0) {
            }
            str2 = str;
            if ((i2 & 32) == 0) {
            }
            transformation2 = transformation;
            if ((i2 & 64) != 0) {
            }
            f2 = f;
            if ((i2 & 128) != 0) {
            }
            colorFilter2 = colorFilter;
            if ((i3 & 4793491) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        contentScale2 = contentScale;
        if ((i2 & 16) != 0) {
        }
        str2 = str;
        if ((i2 & 32) == 0) {
        }
        transformation2 = transformation;
        if ((i2 & 64) != 0) {
        }
        f2 = f;
        if ((i2 & 128) != 0) {
        }
        colorFilter2 = colorFilter;
        if ((i3 & 4793491) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final CachePolicy Image$lambda$2(MutableState<CachePolicy> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ImageForPreviews(Modifier modifier, Composer composer, final int i) {
        int i2;
        final Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-523416196);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ImageForPreviews)213@7270L11,212@7212L85:RemoteImage.kt#51odh9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-523416196, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.ImageForPreviews (RemoteImage.kt:211)");
            }
            modifier2 = modifier;
            BoxKt.Box(BackgroundKt.m1483backgroundbw27NRU$default(modifier2, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), null, 2, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt.ImageForPreviews.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    RemoteImageKt.ImageForPreviews(modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LocalImage(final int i, Modifier modifier, ContentScale contentScale, String str, Transformation transformation, float f, ColorFilter colorFilter, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        ContentScale fit;
        int i6;
        String str2;
        int i7;
        Transformation transformation2;
        int i8;
        float f2;
        int i9;
        final Modifier modifier3;
        final ContentScale contentScale2;
        final String str3;
        final Transformation transformation3;
        final float f3;
        final ColorFilter colorFilter2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(473194970);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LocalImage)P(5,4,3,2,6)44@1837L306:RemoteImage.kt#51odh9");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i2 & 384) == 0) {
                    fit = contentScale;
                    i4 |= composerStartRestartGroup.changed(fit) ? 256 : 128;
                }
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i2 & 3072) == 0) {
                        str2 = str;
                        i4 |= composerStartRestartGroup.changed(str2) ? 2048 : 1024;
                    }
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else {
                        if ((i2 & 24576) == 0) {
                            transformation2 = transformation;
                            i4 |= composerStartRestartGroup.changedInstance(transformation2) ? 16384 : 8192;
                        }
                        i8 = i3 & 32;
                        if (i8 == 0) {
                            if ((196608 & i2) == 0) {
                                f2 = f;
                                i4 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
                            }
                            i9 = i3 & 64;
                            if (i9 == 0) {
                                i4 |= 1572864;
                            } else if ((i2 & 1572864) == 0) {
                                i4 |= composerStartRestartGroup.changed(colorFilter) ? 1048576 : 524288;
                            }
                            if ((i4 & 599187) == 599186 || !composerStartRestartGroup.getSkipping()) {
                                Modifier.Companion companion = i10 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i5 != 0) {
                                    fit = ContentScale.INSTANCE.getFit();
                                }
                                if (i6 != 0) {
                                    str2 = null;
                                }
                                if (i7 != 0) {
                                    transformation2 = null;
                                }
                                if (i8 != 0) {
                                    f2 = 1.0f;
                                }
                                ColorFilter colorFilter3 = i9 == 0 ? colorFilter : null;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(473194970, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.LocalImage (RemoteImage.kt:43)");
                                }
                                int i11 = i4 << 3;
                                String str4 = str2;
                                Modifier modifier4 = companion;
                                ColorFilter colorFilter4 = colorFilter3;
                                float f4 = f2;
                                Transformation transformation4 = transformation2;
                                ContentScale contentScale3 = fit;
                                Image(new ImageSource.Local(i), null, modifier4, contentScale3, str4, transformation4, f4, colorFilter4, composerStartRestartGroup, (i11 & 896) | 48 | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | (i11 & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                contentScale2 = contentScale3;
                                str3 = str4;
                                transformation3 = transformation4;
                                f3 = f4;
                                colorFilter2 = colorFilter4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                contentScale2 = fit;
                                str3 = str2;
                                transformation3 = transformation2;
                                f3 = f2;
                                colorFilter2 = colorFilter;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt.LocalImage.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i12) {
                                        RemoteImageKt.LocalImage(i, modifier3, contentScale2, str3, transformation3, f3, colorFilter2, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        f2 = f;
                        i9 = i3 & 64;
                        if (i9 == 0) {
                        }
                        if ((i4 & 599187) == 599186) {
                            if (i10 == 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 == 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i112 = i4 << 3;
                            String str42 = str2;
                            Modifier modifier42 = companion;
                            ColorFilter colorFilter42 = colorFilter3;
                            float f42 = f2;
                            Transformation transformation42 = transformation2;
                            ContentScale contentScale32 = fit;
                            Image(new ImageSource.Local(i), null, modifier42, contentScale32, str42, transformation42, f42, colorFilter42, composerStartRestartGroup, (i112 & 896) | 48 | (i112 & 7168) | (57344 & i112) | (458752 & i112) | (3670016 & i112) | (i112 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier42;
                            contentScale2 = contentScale32;
                            str3 = str42;
                            transformation3 = transformation42;
                            f3 = f42;
                            colorFilter2 = colorFilter42;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    transformation2 = transformation;
                    i8 = i3 & 32;
                    if (i8 == 0) {
                    }
                    f2 = f;
                    i9 = i3 & 64;
                    if (i9 == 0) {
                    }
                    if ((i4 & 599187) == 599186) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                str2 = str;
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                transformation2 = transformation;
                i8 = i3 & 32;
                if (i8 == 0) {
                }
                f2 = f;
                i9 = i3 & 64;
                if (i9 == 0) {
                }
                if ((i4 & 599187) == 599186) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            fit = contentScale;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            str2 = str;
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            transformation2 = transformation;
            i8 = i3 & 32;
            if (i8 == 0) {
            }
            f2 = f;
            i9 = i3 & 64;
            if (i9 == 0) {
            }
            if ((i4 & 599187) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        fit = contentScale;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        str2 = str;
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        transformation2 = transformation;
        i8 = i3 & 32;
        if (i8 == 0) {
        }
        f2 = f;
        i9 = i3 & 64;
        if (i9 == 0) {
        }
        if ((i4 & 599187) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RemoteImage(final String urlString, Modifier modifier, String str, ContentScale contentScale, String str2, Transformation transformation, float f, ColorFilter colorFilter, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        String str3;
        int i5;
        ContentScale fit;
        int i6;
        String str4;
        int i7;
        Transformation transformation2;
        int i8;
        int i9;
        int i10;
        final String str5;
        final Modifier modifier3;
        final ContentScale contentScale2;
        final String str6;
        final Transformation transformation3;
        final float f2;
        final ColorFilter colorFilter2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Composer composerStartRestartGroup = composer.startRestartGroup(1251566412);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RemoteImage)P(7,4,5,3,2,6)72@2690L356:RemoteImage.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(urlString) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    str3 = str;
                    i3 |= composerStartRestartGroup.changed(str3) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        fit = contentScale;
                        i3 |= composerStartRestartGroup.changed(fit) ? 2048 : 1024;
                    }
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            str4 = str2;
                            i3 |= composerStartRestartGroup.changed(str4) ? 16384 : 8192;
                        }
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else {
                            if ((196608 & i) == 0) {
                                transformation2 = transformation;
                                i3 |= composerStartRestartGroup.changedInstance(transformation2) ? 131072 : 65536;
                            }
                            i8 = i2 & 64;
                            if (i8 == 0) {
                                i3 |= 1572864;
                            } else if ((i & 1572864) == 0) {
                                i3 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
                            }
                            i9 = i2 & 128;
                            if (i9 != 0) {
                                if ((i & 12582912) == 0) {
                                    i10 = i9;
                                    i3 |= composerStartRestartGroup.changed(colorFilter) ? 8388608 : 4194304;
                                }
                                if ((i3 & 4793491) == 4793490 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    colorFilter2 = colorFilter;
                                    modifier3 = modifier2;
                                    str5 = str3;
                                    contentScale2 = fit;
                                    str6 = str4;
                                    transformation3 = transformation2;
                                    f2 = f;
                                } else {
                                    if (i11 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        str3 = null;
                                    }
                                    if (i5 != 0) {
                                        fit = ContentScale.INSTANCE.getFit();
                                    }
                                    if (i6 != 0) {
                                        str4 = null;
                                    }
                                    if (i7 != 0) {
                                        transformation2 = null;
                                    }
                                    float f3 = i8 == 0 ? 1.0f : f;
                                    ColorFilter colorFilter3 = i10 == 0 ? null : colorFilter;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1251566412, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImage (RemoteImage.kt:71)");
                                    }
                                    float f4 = f3;
                                    ContentScale contentScale3 = fit;
                                    Transformation transformation4 = transformation2;
                                    String str7 = str4;
                                    Modifier modifier4 = modifier2;
                                    Image(new ImageSource.Remote(urlString), str3 != null ? new ImageSource.Remote(str3) : null, modifier4, contentScale3, str7, transformation4, f4, colorFilter3, composerStartRestartGroup, ((i3 << 3) & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (i3 & 29360128), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    str5 = str3;
                                    modifier3 = modifier4;
                                    contentScale2 = contentScale3;
                                    str6 = str7;
                                    transformation3 = transformation4;
                                    f2 = f4;
                                    colorFilter2 = colorFilter3;
                                }
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt.RemoteImage.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                            invoke(composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i12) {
                                            RemoteImageKt.RemoteImage(urlString, modifier3, str5, contentScale2, str6, transformation3, f2, colorFilter2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i3 |= 12582912;
                            i10 = i9;
                            if ((i3 & 4793491) == 4793490) {
                                if (i11 != 0) {
                                }
                                if (i4 != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if (i6 != 0) {
                                }
                                if (i7 != 0) {
                                }
                                if (i8 == 0) {
                                }
                                if (i10 == 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                float f42 = f3;
                                ContentScale contentScale32 = fit;
                                Transformation transformation42 = transformation2;
                                String str72 = str4;
                                Modifier modifier42 = modifier2;
                                Image(new ImageSource.Remote(urlString), str3 != null ? new ImageSource.Remote(str3) : null, modifier42, contentScale32, str72, transformation42, f42, colorFilter3, composerStartRestartGroup, ((i3 << 3) & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (i3 & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                str5 = str3;
                                modifier3 = modifier42;
                                contentScale2 = contentScale32;
                                str6 = str72;
                                transformation3 = transformation42;
                                f2 = f42;
                                colorFilter2 = colorFilter3;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        transformation2 = transformation;
                        i8 = i2 & 64;
                        if (i8 == 0) {
                        }
                        i9 = i2 & 128;
                        if (i9 != 0) {
                        }
                        i10 = i9;
                        if ((i3 & 4793491) == 4793490) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    str4 = str2;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    transformation2 = transformation;
                    i8 = i2 & 64;
                    if (i8 == 0) {
                    }
                    i9 = i2 & 128;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    if ((i3 & 4793491) == 4793490) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                fit = contentScale;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                str4 = str2;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                transformation2 = transformation;
                i8 = i2 & 64;
                if (i8 == 0) {
                }
                i9 = i2 & 128;
                if (i9 != 0) {
                }
                i10 = i9;
                if ((i3 & 4793491) == 4793490) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            str3 = str;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            fit = contentScale;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            str4 = str2;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            transformation2 = transformation;
            i8 = i2 & 64;
            if (i8 == 0) {
            }
            i9 = i2 & 128;
            if (i9 != 0) {
            }
            i10 = i9;
            if ((i3 & 4793491) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        str3 = str;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        fit = contentScale;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        str4 = str2;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        transformation2 = transformation;
        i8 = i2 & 64;
        if (i8 == 0) {
        }
        i9 = i2 & 128;
        if (i9 != 0) {
        }
        i10 = i9;
        if ((i3 & 4793491) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
