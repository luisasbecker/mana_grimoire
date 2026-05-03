package androidx.compose.foundation;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Image.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a_\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0017\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Image", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "Image-5h-nEew", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ImageKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Consider usage of the Image composable that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "Image(bitmap, contentDescription, modifier, alignment, contentScale, alpha, colorFilter, DefaultFilterQuality)", imports = {"androidx.compose.foundation", "androidx.compose.ui.graphics.DefaultAlpha", "androidx.compose.ui.Alignment", "androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality", "androidx.compose.ui.layout.ContentScale.Fit"}))
    public static final /* synthetic */ void Image(ImageBitmap imageBitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2123228673, "C(Image)N(bitmap,contentDescription,modifier,alignment,contentScale,alpha,colorFilter)99@4665L178:Image.kt#71ulvw");
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        Alignment center = (i2 & 8) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i2 & 16) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i2 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2123228673, i, -1, "androidx.compose.foundation.Image (Image.kt:98)");
        }
        m1540Image5hnEew(imageBitmap, str, modifier2, center, fit, f2, colorFilter2, FilterQuality.INSTANCE.m6425getLowfv9h1I(), composer, i & 4194302, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Image(final Painter painter, final String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        ContentScale contentScale2;
        int i6;
        float f2;
        int i7;
        final Alignment alignment2;
        final ColorFilter colorFilter2;
        final Modifier modifier3;
        final ContentScale contentScale3;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companionSemantics$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(1142754848);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Image)N(painter,contentDescription,modifier,alignment,contentScale,alpha,colorFilter)271@12440L88,260@12135L393:Image.kt#71ulvw");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(painter) : composerStartRestartGroup.changedInstance(painter) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    i3 |= composerStartRestartGroup.changed(alignment) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        contentScale2 = contentScale;
                        i3 |= composerStartRestartGroup.changed(contentScale2) ? 16384 : 8192;
                    }
                    i6 = i2 & 32;
                    if (i6 != 0) {
                        if ((196608 & i) == 0) {
                            f2 = f;
                            i3 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
                        }
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changed(colorFilter) ? 1048576 : 524288;
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                            Modifier.Companion companion = i8 != 0 ? Modifier.INSTANCE : modifier2;
                            Alignment center = i4 != 0 ? Alignment.INSTANCE.getCenter() : alignment;
                            ContentScale fit = i5 != 0 ? ContentScale.INSTANCE.getFit() : contentScale2;
                            float f4 = i6 != 0 ? 1.0f : f2;
                            ColorFilter colorFilter3 = i7 != 0 ? null : colorFilter;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1142754848, i3, -1, "androidx.compose.foundation.Image (Image.kt:247)");
                            }
                            if (str != null) {
                                composerStartRestartGroup.startReplaceGroup(1899222916);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "250@11847L115");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324207053, "CC(remember):Image.kt#9igjgp");
                                boolean z = (i3 & 112) == 32;
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ImageKt.Image$lambda$0$0(str, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                companionSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) objRememberedValue, 1, null);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1899381698);
                                composerStartRestartGroup.endReplaceGroup();
                                companionSemantics$default = Modifier.INSTANCE;
                            }
                            ColorFilter colorFilter4 = colorFilter3;
                            Modifier modifier4 = companion;
                            Alignment alignment3 = center;
                            Modifier modifierPaint$default = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(companionSemantics$default)), painter, false, alignment3, fit, f4, colorFilter4, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1324188104, "CC(remember):Image.kt#9igjgp");
                            ImageKt$Image$1$1 imageKt$Image$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (imageKt$Image$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                imageKt$Image$1$1RememberedValue = ImageKt$Image$1$1.INSTANCE;
                                composerStartRestartGroup.updateRememberedValue(imageKt$Image$1$1RememberedValue);
                            }
                            MeasurePolicy measurePolicy = (MeasurePolicy) imageKt$Image$1$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPaint$default);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
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
                            Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            colorFilter2 = colorFilter4;
                            f3 = f4;
                            contentScale3 = fit;
                            alignment2 = alignment3;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            alignment2 = alignment;
                            colorFilter2 = colorFilter;
                            modifier3 = modifier2;
                            contentScale3 = contentScale2;
                            f3 = f2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ImageKt.Image$lambda$2(painter, str, modifier3, alignment2, contentScale3, f3, colorFilter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    f2 = f;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                contentScale2 = contentScale;
                i6 = i2 & 32;
                if (i6 != 0) {
                }
                f2 = f;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            contentScale2 = contentScale;
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            f2 = f;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        contentScale2 = contentScale;
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        f2 = f;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    public static final void Image(ImageVector imageVector, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1595907091, "C(Image)N(imageVector,contentDescription,modifier,alignment,contentScale,alpha,colorFilter)203@9457L34,202@9432L270:Image.kt#71ulvw");
        if ((i2 & 4) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            alignment = Alignment.INSTANCE.getCenter();
        }
        Alignment alignment2 = alignment;
        if ((i2 & 16) != 0) {
            contentScale = ContentScale.INSTANCE.getFit();
        }
        ContentScale contentScale2 = contentScale;
        if ((i2 & 32) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1595907091, i, -1, "androidx.compose.foundation.Image (Image.kt:202)");
        }
        Image(VectorPainterKt.rememberVectorPainter(imageVector, composer, i & 14), str, modifier, alignment2, contentScale2, f2, colorFilter2, composer, VectorPainter.$stable | (i & 112) | (i & 896) | (i & 7168) | (57344 & i) | (458752 & i) | (3670016 & i), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Image$lambda$0$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8331getImageo7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Image$lambda$2(Painter painter, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, int i2, Composer composer, int i3) {
        Image(painter, str, modifier, alignment, contentScale, f, colorFilter, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: Image-5h-nEew, reason: not valid java name */
    public static final void m1540Image5hnEew(ImageBitmap imageBitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -1396260732, "C(Image)N(bitmap,contentDescription,modifier,alignment,contentScale,alpha,colorFilter,filterQuality:c#ui.graphics.FilterQuality)157@7327L73,158@7405L249:Image.kt#71ulvw");
        Modifier.Companion companion = (i3 & 4) != 0 ? Modifier.INSTANCE : modifier;
        Alignment center = (i3 & 8) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i3 & 16) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i3 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i3 & 64) != 0 ? null : colorFilter;
        int iM6902getDefaultFilterQualityfv9h1I = (i3 & 128) != 0 ? DrawScope.INSTANCE.m6902getDefaultFilterQualityfv9h1I() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1396260732, i2, -1, "androidx.compose.foundation.Image (Image.kt:156)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1776755635, "CC(remember):Image.kt#9igjgp");
        boolean zChanged = composer.changed(imageBitmap);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = BitmapPainterKt.m7022BitmapPainterQZhYCtY$default(imageBitmap, 0L, 0L, iM6902getDefaultFilterQualityfv9h1I, 6, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Image((BitmapPainter) objRememberedValue, str, companion, center, fit, f2, colorFilter2, composer, (i2 & 3670016) | BitmapPainter.$stable | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }
}
