package com.revenuecat.purchases.ui.revenuecatui.defaultpaywall;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.helpers.AppStyleExtractor;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorComputationHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallWarning;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: DefaultPaywallView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a6\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\rH\u0003ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001aF\u0010\u0010\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001au\u0010\u001a\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\"2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0001¢\u0006\u0002\u0010%\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\n\n\u0002\u0010\u0004\u0012\u0004\b\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&²\u0006\f\u0010'\u001a\u0004\u0018\u00010\bX\u008a\u008e\u0002²\u0006\u0010\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cX\u008a\u008e\u0002"}, d2 = {"RevenueCatBrandRed", "Landroidx/compose/ui/graphics/Color;", "getRevenueCatBrandRed$annotations", "()V", "J", "AppIconSection", "", "bitmap", "Landroid/graphics/Bitmap;", "appName", "", "shadowColor", "modifier", "Landroidx/compose/ui/Modifier;", "AppIconSection-cf5BqRc", "(Landroid/graphics/Bitmap;Ljava/lang/String;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DefaultPaywallFooter", "onPurchase", "Lkotlin/Function0;", "onRestore", "purchaseEnabled", "", "mainColor", "foregroundOnAccentColor", "DefaultPaywallFooter-ZkgLGzA", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZJJLandroidx/compose/runtime/Composer;I)V", "DefaultPaywallView", "packages", "", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "selectedPackage", "warning", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "onSelectPackage", "Lkotlin/Function1;", "previewOverrides", "Lcom/revenuecat/purchases/ui/revenuecatui/defaultpaywall/DefaultPaywallPreviewOverrides;", "(Ljava/util/List;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/defaultpaywall/DefaultPaywallPreviewOverrides;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsBc8Release", "appIconBitmap", "prominentColors"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DefaultPaywallViewKt {
    private static final long RevenueCatBrandRed = ColorKt.Color(4294071387L);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to inline method: androidx.compose.ui.draw.ShadowKt.shadow-s4CzXII$default(androidx.compose.ui.Modifier, float, androidx.compose.ui.graphics.Shape, boolean, long, long, int, java.lang.Object):androidx.compose.ui.Modifier */
    /* JADX WARN: Not passed register '(r4v7 'fM9114constructorimpl' float)' in method call: androidx.compose.ui.draw.ShadowKt.shadow-s4CzXII$default(androidx.compose.ui.Modifier, float, androidx.compose.ui.graphics.Shape, boolean, long, long, int, java.lang.Object):androidx.compose.ui.Modifier */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: AppIconSection-cf5BqRc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10792AppIconSectioncf5BqRc(final Bitmap bitmap, final String str, final long j, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        String str2;
        long j2;
        int i4;
        Modifier modifier2;
        final Modifier.Companion companion;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        float f;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(897617685);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AppIconSection)P(1!1,3:c#ui.graphics.Color)299@11797L1293:DefaultPaywallView.kt#trihdm");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(bitmap) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                str2 = str;
                i3 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= 384;
                j2 = j;
            } else {
                j2 = j;
                if ((i & 384) == 0) {
                    i3 |= composerStartRestartGroup.changed(j2) ? 256 : 128;
                }
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
                }
                if ((i3 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    composer2 = composerStartRestartGroup;
                } else {
                    companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(897617685, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.AppIconSection (DefaultPaywallView.kt:298)");
                    }
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(16.0f));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.useNode();
                    } else {
                        composerStartRestartGroup.createNode(constructor);
                    }
                    composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1844040054, "C329@12850L10,332@12991L11,327@12782L302:DefaultPaywallView.kt#trihdm");
                    composerStartRestartGroup.startReplaceGroup(79062105);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*305@12002L760");
                    if (bitmap != null) {
                        f = 0.0f;
                    } else {
                        Modifier modifierM5923shadows4CzXII$default = ShadowKt.m5923shadows4CzXII$default(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(120.0f)), Dp.m9114constructorimpl(6.0f), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(31.0f)), false, Color.m6324copywmQWz5c$default(j2, 0.2f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6324copywmQWz5c$default(j, 0.2f, 0.0f, 0.0f, 0.0f, 14, null), 4, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5923shadows4CzXII$default);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor2);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                        Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 767538345, "C316@12430L318:DefaultPaywallView.kt#trihdm");
                        f = 0.0f;
                        ImageKt.m1540Image5hnEew(AndroidImageBitmap_androidKt.asImageBitmap(bitmap), "App Icon", ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(31.0f))), null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, composerStartRestartGroup, 24624, 232);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                    String str3 = str2;
                    TextKt.m4286Text4IGK_g(str3, PaddingKt.m2039paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9114constructorimpl(16.0f), f, 2, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge(), composer2, ((i3 >> 3) & 14) | 196656, 0, 64984);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$AppIconSection$2
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
                            DefaultPaywallViewKt.m10792AppIconSectioncf5BqRc(bitmap, str, j, companion, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 3072;
            modifier2 = modifier;
            if ((i3 & 1171) == 1170) {
                if (i4 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_42 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(16.0f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_42, centerHorizontally2, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                }
                composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl.getInserting()) {
                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1844040054, "C329@12850L10,332@12991L11,327@12782L302:DefaultPaywallView.kt#trihdm");
                    composerStartRestartGroup.startReplaceGroup(79062105);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*305@12002L760");
                    if (bitmap != null) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                    String str32 = str2;
                    TextKt.m4286Text4IGK_g(str32, PaddingKt.m2039paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9114constructorimpl(16.0f), f, 2, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge(), composer2, ((i3 >> 3) & 14) | 196656, 0, 64984);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        str2 = str;
        if ((i2 & 4) == 0) {
        }
        i4 = i2 & 8;
        if (i4 != 0) {
        }
        modifier2 = modifier;
        if ((i3 & 1171) == 1170) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: DefaultPaywallFooter-ZkgLGzA, reason: not valid java name */
    public static final void m10793DefaultPaywallFooterZkgLGzA(final Function0<Unit> function0, final Function0<Unit> function02, final boolean z, final long j, final long j2, Composer composer, final int i) {
        int i2;
        Function0<Unit> function03;
        boolean z2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1968152504);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DefaultPaywallFooter)P(2,3,4,1:c#ui.graphics.Color,0:c#ui.graphics.Color)249@10240L11,246@10141L1503:DefaultPaywallView.kt#trihdm");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            function03 = function02;
            i2 |= composerStartRestartGroup.changedInstance(function03) ? 32 : 16;
        } else {
            function03 = function02;
        }
        if ((i & 384) == 0) {
            z2 = z;
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        } else {
            z2 = z;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1968152504, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallFooter (DefaultPaywallView.kt:245)");
            }
            Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), 0.95f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1483backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1980285397, "C252@10343L1295:DefaultPaywallView.kt#trihdm");
            Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(WindowInsetsPadding_androidKt.navigationBarsPadding(SizeKt.fillMaxWidth$default(SizeKt.m2090widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, ReadableContentWidth.INSTANCE.m10800getDpD9Ej5fM(), 1, null), 0.0f, 1, null)), Dp.m9114constructorimpl(16.0f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2037padding3ABfNKs);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -390253150, "C263@10762L139,260@10633L615,278@11262L40,283@11472L11,282@11405L107,280@11316L312:DefaultPaywallView.kt#trihdm");
            ButtonKt.Button(function0, SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(SizeKt.m2090widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9114constructorimpl(480.0f), 1, null), 0.0f, 1, null), Dp.m9114constructorimpl(52.0f)), z2, null, ButtonDefaults.INSTANCE.m3340buttonColorsro_MJ88(j, j2, 0L, 0L, composerStartRestartGroup, ((i2 >> 9) & 126) | (ButtonDefaults.$stable << 12), 12), null, null, null, null, ComposableSingletons$DefaultPaywallViewKt.INSTANCE.m10790getLambda2$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, (i2 & 14) | 805306416 | (i2 & 896), Videoio.CAP_PROP_XI_CC_MATRIX_21);
            SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(8.0f)), composerStartRestartGroup, 6);
            ButtonKt.TextButton(function03, null, false, null, ButtonDefaults.INSTANCE.m3351textButtonColorsro_MJ88(0L, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 13), null, null, null, null, ComposableSingletons$DefaultPaywallViewKt.INSTANCE.m10791getLambda3$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, ((i2 >> 3) & 14) | 805306368, Videoio.CAP_PROP_XI_CC_MATRIX_33);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallFooter$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    DefaultPaywallViewKt.m10793DefaultPaywallFooterZkgLGzA(function0, function02, z, j, j2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:205:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DefaultPaywallView(final List<TemplateConfiguration.PackageInfo> packages, final TemplateConfiguration.PackageInfo packageInfo, final PaywallWarning paywallWarning, final Function1<? super TemplateConfiguration.PackageInfo, Unit> onSelectPackage, final Function0<Unit> onPurchase, final Function0<Unit> onRestore, Modifier modifier, DefaultPaywallPreviewOverrides defaultPaywallPreviewOverrides, Composer composer, final int i, final int i2) {
        int i3;
        PaywallWarning paywallWarning2;
        int i4;
        Modifier modifier2;
        int i5;
        DefaultPaywallPreviewOverrides defaultPaywallPreviewOverrides2;
        Context context;
        Boolean boolIsDebugBuild;
        boolean zBooleanValue;
        final String appName;
        Object objRememberedValue;
        MutableState mutableState;
        List<Color> prominentColors;
        boolean zChanged;
        Object objRememberedValue2;
        MutableState mutableState2;
        boolean zChangedInstance;
        MutableState mutableState3;
        final MutableState mutableState4;
        DefaultPaywallViewKt$DefaultPaywallView$1$1 defaultPaywallViewKt$DefaultPaywallView$1$1;
        boolean z;
        long primary;
        long onPrimary;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Composer composer2;
        final DefaultPaywallPreviewOverrides defaultPaywallPreviewOverrides3;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(packages, "packages");
        Intrinsics.checkNotNullParameter(onSelectPackage, "onSelectPackage");
        Intrinsics.checkNotNullParameter(onPurchase, "onPurchase");
        Intrinsics.checkNotNullParameter(onRestore, "onRestore");
        Composer composerStartRestartGroup = composer.startRestartGroup(-145140846);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DefaultPaywallView)P(4,6,7,3,1,2)79@3500L7,80@3530L21,89@3868L60,93@4055L119,97@4235L384,97@4180L439,137@5714L4226:DefaultPaywallView.kt#trihdm");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(packages) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(packageInfo) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= 384;
                paywallWarning2 = paywallWarning;
            } else {
                paywallWarning2 = paywallWarning;
                if ((i & 384) == 0) {
                    i3 |= composerStartRestartGroup.changed(paywallWarning2) ? 256 : 128;
                }
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(onSelectPackage) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(onPurchase) ? 16384 : 8192;
            }
            if ((i2 & 32) == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(onRestore) ? 131072 : 65536;
            }
            i4 = i2 & 64;
            if (i4 == 0) {
                i3 |= 1572864;
            } else {
                if ((1572864 & i) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 1048576 : 524288;
                }
                i5 = i2 & 128;
                if (i5 == 0) {
                    if ((12582912 & i) == 0) {
                        defaultPaywallPreviewOverrides2 = defaultPaywallPreviewOverrides;
                        i3 |= composerStartRestartGroup.changedInstance(defaultPaywallPreviewOverrides2) ? 8388608 : 4194304;
                    }
                    if ((i3 & 4793491) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                        DefaultPaywallPreviewOverrides defaultPaywallPreviewOverrides4 = i5 == 0 ? null : defaultPaywallPreviewOverrides2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-145140846, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallView (DefaultPaywallView.kt:78)");
                        }
                        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localContext);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        context = (Context) objConsume;
                        boolean zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                        boolIsDebugBuild = defaultPaywallPreviewOverrides4 == null ? defaultPaywallPreviewOverrides4.isDebugBuild() : null;
                        composerStartRestartGroup.startReplaceGroup(-332621739);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "83@3618L105");
                        if (boolIsDebugBuild != null) {
                            composerStartRestartGroup.startReplaceGroup(-332620685);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DefaultPaywallView.kt#9igjgp");
                            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            zBooleanValue = ((Boolean) objRememberedValue3).booleanValue();
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            zBooleanValue = boolIsDebugBuild.booleanValue();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        appName = defaultPaywallPreviewOverrides4 == null ? defaultPaywallPreviewOverrides4.getAppName() : null;
                        composerStartRestartGroup.startReplaceGroup(-332616071);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "88@3792L50");
                        if (appName == null) {
                            composerStartRestartGroup.startReplaceGroup(-332615172);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DefaultPaywallView.kt#9igjgp");
                            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = AppStyleExtractor.INSTANCE.getAppName(context);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            appName = (String) objRememberedValue4;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-332612730);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DefaultPaywallView.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(defaultPaywallPreviewOverrides4 != null ? defaultPaywallPreviewOverrides4.getAppIconBitmap() : null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                            objRememberedValue = mutableStateMutableStateOf$default;
                        }
                        mutableState = (MutableState) objRememberedValue;
                        composerStartRestartGroup.endReplaceGroup();
                        prominentColors = defaultPaywallPreviewOverrides4 == null ? defaultPaywallPreviewOverrides4.getProminentColors() : null;
                        Bitmap bitmapDefaultPaywallView$lambda$3 = DefaultPaywallView$lambda$3(mutableState);
                        composerStartRestartGroup.startReplaceGroup(-332606687);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DefaultPaywallView.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(bitmapDefaultPaywallView$lambda$3) | composerStartRestartGroup.changed(prominentColors);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            MutableState mutableStateMutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(prominentColors != null ? CollectionsKt.emptyList() : prominentColors, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default2);
                            objRememberedValue2 = mutableStateMutableStateOf$default2;
                        }
                        mutableState2 = (MutableState) objRememberedValue2;
                        composerStartRestartGroup.endReplaceGroup();
                        Bitmap bitmapDefaultPaywallView$lambda$32 = DefaultPaywallView$lambda$3(mutableState);
                        composerStartRestartGroup.startReplaceGroup(-332600662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DefaultPaywallView.kt#9igjgp");
                        zChangedInstance = composerStartRestartGroup.changedInstance(prominentColors) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changedInstance(context);
                        Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            mutableState3 = mutableState2;
                            mutableState4 = mutableState;
                            defaultPaywallViewKt$DefaultPaywallView$1$1 = new DefaultPaywallViewKt$DefaultPaywallView$1$1(prominentColors, mutableState, mutableState3, context, null);
                            composerStartRestartGroup.updateRememberedValue(defaultPaywallViewKt$DefaultPaywallView$1$1);
                        } else {
                            mutableState3 = mutableState2;
                            defaultPaywallViewKt$DefaultPaywallView$1$1 = objRememberedValue5;
                            mutableState4 = mutableState;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(bitmapDefaultPaywallView$lambda$32, prominentColors, (Function2) defaultPaywallViewKt$DefaultPaywallView$1$1, composerStartRestartGroup, 0);
                        final PaywallWarning paywallWarning3 = !zBooleanValue ? paywallWarning2 : null;
                        z = paywallWarning3 == null;
                        if (DefaultPaywallView$lambda$6(mutableState3).isEmpty()) {
                            composerStartRestartGroup.startReplaceGroup(-1720010872);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "122@5197L11");
                            List<Color> listDefaultPaywallView$lambda$6 = DefaultPaywallView$lambda$6(mutableState3);
                            Color.Companion companion2 = Color.INSTANCE;
                            Color colorM10848selectColorWithBestContrast4WTKRHQ = ColorComputationHelpersKt.m10848selectColorWithBestContrast4WTKRHQ(listDefaultPaywallView$lambda$6, zIsSystemInDarkTheme ? companion2.m6351getBlack0d7_KjU() : companion2.m6362getWhite0d7_KjU());
                            primary = colorM10848selectColorWithBestContrast4WTKRHQ == null ? MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary() : colorM10848selectColorWithBestContrast4WTKRHQ.m6335unboximpl();
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1720073337);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "116@4887L11");
                            primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        long j = !z ? RevenueCatBrandRed : primary;
                        composerStartRestartGroup.startReplaceGroup(-332565442);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "134@5681L11");
                        if (z) {
                            List<Color> listDefaultPaywallView$lambda$62 = DefaultPaywallView$lambda$6(mutableState3);
                            Color.Companion companion3 = Color.INSTANCE;
                            Color colorM10848selectColorWithBestContrast4WTKRHQ2 = ColorComputationHelpersKt.m10848selectColorWithBestContrast4WTKRHQ(CollectionsKt.plus((Collection) listDefaultPaywallView$lambda$62, (Iterable) CollectionsKt.listOf(Color.m6315boximpl(zIsSystemInDarkTheme ? companion3.m6351getBlack0d7_KjU() : companion3.m6362getWhite0d7_KjU()))), primary);
                            onPrimary = colorM10848selectColorWithBestContrast4WTKRHQ2 == null ? MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimary() : colorM10848selectColorWithBestContrast4WTKRHQ2.m6335unboximpl();
                        } else {
                            onPrimary = Color.INSTANCE.m6362getWhite0d7_KjU();
                        }
                        final long j2 = onPrimary;
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifierBackground$default = BackgroundKt.background$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Brush.Companion.m6280verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m6315boximpl(Color.m6324copywmQWz5c$default(j, 0.2f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m6315boximpl(Color.m6324copywmQWz5c$default(j, 0.0f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Modifier modifier4 = companion;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.useNode();
                        } else {
                            composerStartRestartGroup.createNode(constructor);
                        }
                        composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2097683251, "C152@6184L427,163@6623L3311,149@6055L3879:DefaultPaywallView.kt#trihdm");
                        final long j3 = j;
                        final boolean z2 = z;
                        composer2 = composerStartRestartGroup;
                        ScaffoldKt.m3981ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, ComposableLambdaKt.rememberComposableLambda(-1275945433, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i6) {
                                ComposerKt.sourceInformation(composer3, "C154@6251L328:DefaultPaywallView.kt#trihdm");
                                if ((i6 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1275945433, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallView.<anonymous>.<anonymous> (DefaultPaywallView.kt:153)");
                                }
                                if (!packages.isEmpty()) {
                                    DefaultPaywallViewKt.m10793DefaultPaywallFooterZkgLGzA(onPurchase, onRestore, packageInfo != null, j3, j2, composer3, 0);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), null, null, 0, Color.INSTANCE.m6360getTransparent0d7_KjU(), 0L, null, ComposableLambdaKt.rememberComposableLambda(-291497059, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer3, Integer num) {
                                invoke(paddingValues, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(PaddingValues paddingValues, Composer composer3, int i6) {
                                int i7;
                                int i8;
                                long j4;
                                long j5;
                                TemplateConfiguration.PackageInfo packageInfo2;
                                Function1<TemplateConfiguration.PackageInfo, Unit> function1;
                                List<TemplateConfiguration.PackageInfo> list;
                                PaywallWarning paywallWarning4;
                                String str;
                                long j6;
                                Composer composer4 = composer3;
                                Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                                ComposerKt.sourceInformation(composer4, "C164@6654L3270:DefaultPaywallView.kt#trihdm");
                                if ((i6 & 6) == 0) {
                                    i7 = i6 | (composer4.changed(paddingValues) ? 4 : 2);
                                } else {
                                    i7 = i6;
                                }
                                if ((i7 & 19) == 18 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-291497059, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallView.<anonymous>.<anonymous> (DefaultPaywallView.kt:164)");
                                }
                                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Alignment topCenter = Alignment.INSTANCE.getTopCenter();
                                List<TemplateConfiguration.PackageInfo> list2 = packages;
                                long j7 = j3;
                                long j8 = j2;
                                TemplateConfiguration.PackageInfo packageInfo3 = packageInfo;
                                Function1<TemplateConfiguration.PackageInfo, Unit> function12 = onSelectPackage;
                                boolean z3 = z2;
                                PaywallWarning paywallWarning5 = paywallWarning3;
                                String str2 = appName;
                                MutableState<Bitmap> mutableState5 = mutableState4;
                                ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topCenter, false);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxSize$default);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor2);
                                } else {
                                    composer4.useNode();
                                }
                                Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer4);
                                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, 991320756, "C168@6798L3112:DefaultPaywallView.kt#trihdm");
                                Modifier modifierM2090widthInVpY3zN4$default = SizeKt.m2090widthInVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, ReadableContentWidth.INSTANCE.m10800getDpD9Ej5fM(), 1, null);
                                ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer4, modifierM2090widthInVpY3zN4$default);
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor3);
                                } else {
                                    composer4.useNode();
                                }
                                Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer4);
                                Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, -91854882, "C173@6981L1526,203@8529L38,212@9014L878,205@8589L1303:DefaultPaywallView.kt#trihdm");
                                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(24.0f));
                                ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, centerHorizontally, composer4, 54);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default);
                                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor4);
                                } else {
                                    composer4.useNode();
                                }
                                Composer composerM5595constructorimpl4 = Updater.m5595constructorimpl(composer4);
                                Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                    composerM5595constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                    composerM5595constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, -2138276183, "C178@7248L79:DefaultPaywallView.kt#trihdm");
                                SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(paddingValues.getTop() + Dp.m9114constructorimpl(32.0f))), composer4, 0);
                                composer4.startReplaceGroup(1177952101);
                                ComposerKt.sourceInformation(composer4, "184@7676L10,185@7754L11,182@7570L428");
                                if (z3) {
                                    TextStyle titleMedium = MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getTitleMedium();
                                    long onSurface = MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSurface();
                                    FontWeight bold = FontWeight.INSTANCE.getBold();
                                    int iM8992getCentere0LSkKk = TextAlign.INSTANCE.m8992getCentere0LSkKk();
                                    Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    TextAlign textAlignM8985boximpl = TextAlign.m8985boximpl(iM8992getCentere0LSkKk);
                                    paywallWarning4 = paywallWarning5;
                                    j4 = j7;
                                    function1 = function12;
                                    j5 = j8;
                                    packageInfo2 = packageInfo3;
                                    i8 = 0;
                                    str = str2;
                                    list = list2;
                                    TextKt.m4286Text4IGK_g("RevenueCat Paywalls", modifierFillMaxWidth$default2, onSurface, 0L, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, textAlignM8985boximpl, 0L, 0, false, 0, 0, (Function1) null, titleMedium, composer3, 196662, 0, 64984);
                                    composer4 = composer3;
                                } else {
                                    i8 = 0;
                                    j4 = j7;
                                    j5 = j8;
                                    packageInfo2 = packageInfo3;
                                    function1 = function12;
                                    list = list2;
                                    paywallWarning4 = paywallWarning5;
                                    str = str2;
                                }
                                composer4.endReplaceGroup();
                                if (paywallWarning4 != null) {
                                    composer4.startReplaceGroup(-2137487916);
                                    ComposerKt.sourceInformation(composer4, "193@8107L81");
                                    DefaultPaywallWarningKt.m10796DefaultPaywallWarning3IgeMak(paywallWarning4, DefaultPaywallViewKt.RevenueCatBrandRed, null, composer4, 48, 4);
                                    composer4.endReplaceGroup();
                                    j6 = j4;
                                } else {
                                    composer4.startReplaceGroup(-2137342092);
                                    ComposerKt.sourceInformation(composer4, "195@8250L209");
                                    j6 = j4;
                                    DefaultPaywallViewKt.m10792AppIconSectioncf5BqRc(DefaultPaywallViewKt.DefaultPaywallView$lambda$3(mutableState5), str, j6, null, composer3, 0, 8);
                                    composer4 = composer3;
                                    composer4.endReplaceGroup();
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, i8);
                                Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SelectableGroupKt.selectableGroup(Modifier.INSTANCE), 0.0f, 0.0f, 0.0f, paddingValues.getBottom(), 7, null);
                                PaddingValues paddingValuesM2030PaddingValues0680j_4 = PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f));
                                Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                                Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_42 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(8.0f));
                                composer4.startReplaceGroup(1936762612);
                                ComposerKt.sourceInformation(composer4, "CC(remember):DefaultPaywallView.kt#9igjgp");
                                final long j9 = j5;
                                final TemplateConfiguration.PackageInfo packageInfo4 = packageInfo2;
                                final Function1<TemplateConfiguration.PackageInfo, Unit> function13 = function1;
                                boolean zChangedInstance2 = composer4.changedInstance(list) | composer4.changed(j6) | composer4.changed(j9) | composer4.changed(packageInfo4) | composer4.changed(function13);
                                Object objRememberedValue6 = composer4.rememberedValue();
                                if (zChangedInstance2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    final List<TemplateConfiguration.PackageInfo> list3 = list;
                                    final long j10 = j6;
                                    objRememberedValue6 = (Function1) new Function1<LazyListScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                            invoke2(lazyListScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(LazyListScope LazyColumn) {
                                            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                            final List<TemplateConfiguration.PackageInfo> list4 = list3;
                                            final AnonymousClass1 anonymousClass1 = new Function1<TemplateConfiguration.PackageInfo, Object>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(TemplateConfiguration.PackageInfo it) {
                                                    Intrinsics.checkNotNullParameter(it, "it");
                                                    return it.getRcPackage().getIdentifier();
                                                }
                                            };
                                            final long j11 = j10;
                                            final long j12 = j9;
                                            final TemplateConfiguration.PackageInfo packageInfo5 = packageInfo4;
                                            final Function1<TemplateConfiguration.PackageInfo, Unit> function14 = function13;
                                            final DefaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1$invoke$$inlined$items$default$1 defaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1$invoke$$inlined$items$default$1 = new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1$invoke$$inlined$items$default$1
                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                    return invoke((TemplateConfiguration.PackageInfo) obj);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Void invoke(TemplateConfiguration.PackageInfo packageInfo6) {
                                                    return null;
                                                }
                                            };
                                            LazyColumn.items(list4.size(), anonymousClass1 != null ? new Function1<Integer, Object>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1$invoke$$inlined$items$default$2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                public final Object invoke(int i9) {
                                                    return anonymousClass1.invoke(list4.get(i9));
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                                    return invoke(num.intValue());
                                                }
                                            } : null, new Function1<Integer, Object>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1$invoke$$inlined$items$default$3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                public final Object invoke(int i9) {
                                                    return defaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1$invoke$$inlined$items$default$1.invoke(list4.get(i9));
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                                    return invoke(num.intValue());
                                                }
                                            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1$invoke$$inlined$items$default$4
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(4);
                                                }

                                                @Override // kotlin.jvm.functions.Function4
                                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer5, Integer num2) {
                                                    invoke(lazyItemScope, num.intValue(), composer5, num2.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LazyItemScope lazyItemScope, int i9, Composer composer5, int i10) {
                                                    int i11;
                                                    ComposerKt.sourceInformation(composer5, "C152@7074L22:LazyDsl.kt#428nma");
                                                    if ((i10 & 6) == 0) {
                                                        i11 = (composer5.changed(lazyItemScope) ? 4 : 2) | i10;
                                                    } else {
                                                        i11 = i10;
                                                    }
                                                    if ((i10 & 48) == 0) {
                                                        i11 |= composer5.changed(i9) ? 32 : 16;
                                                    }
                                                    if ((i11 & 147) == 146 && composer5.getSkipping()) {
                                                        composer5.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-632812321, i11, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                                                    }
                                                    final TemplateConfiguration.PackageInfo packageInfo6 = (TemplateConfiguration.PackageInfo) list4.get(i9);
                                                    composer5.startReplaceGroup(-350675214);
                                                    ComposerKt.sourceInformation(composer5, "C*222@9562L32,217@9227L398:DefaultPaywallView.kt#trihdm");
                                                    Package rcPackage = packageInfo6.getRcPackage();
                                                    long j13 = j11;
                                                    long j14 = j12;
                                                    boolean zAreEqual = Intrinsics.areEqual(packageInfo5, packageInfo6);
                                                    composer5.startReplaceGroup(819982243);
                                                    ComposerKt.sourceInformation(composer5, "CC(remember):DefaultPaywallView.kt#9igjgp");
                                                    boolean zChanged2 = composer5.changed(function14) | composer5.changed(packageInfo6);
                                                    Object objRememberedValue7 = composer5.rememberedValue();
                                                    if (zChanged2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                        final Function1 function15 = function14;
                                                        objRememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1$2$1$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
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
                                                                function15.invoke(packageInfo6);
                                                            }
                                                        };
                                                        composer5.updateRememberedValue(objRememberedValue7);
                                                    }
                                                    composer5.endReplaceGroup();
                                                    DefaultProductCellKt.m10797DefaultProductCellqi6gXK8(rcPackage, j13, j14, zAreEqual, (Function0) objRememberedValue7, null, composer5, 0, 32);
                                                    composer5.endReplaceGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }));
                                            if (list3.isEmpty()) {
                                                return;
                                            }
                                            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$DefaultPaywallViewKt.INSTANCE.m10789getLambda1$revenuecatui_defaultsBc8Release(), 3, null);
                                        }
                                    };
                                    composer4.updateRememberedValue(objRememberedValue6);
                                }
                                composer4.endReplaceGroup();
                                LazyDslKt.LazyColumn(modifierM2041paddingqDBjuR0$default, null, paddingValuesM2030PaddingValues0680j_4, false, horizontalOrVerticalM1907spacedBy0680j_42, centerHorizontally2, null, false, (Function1) objRememberedValue6, composer3, 221568, 202);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composer2, 806879622, Videoio.CAP_PROP_XI_AEAG_ROI_HEIGHT);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        defaultPaywallPreviewOverrides3 = defaultPaywallPreviewOverrides4;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        defaultPaywallPreviewOverrides3 = defaultPaywallPreviewOverrides2;
                        composer2 = composerStartRestartGroup;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt.DefaultPaywallView.3
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

                            public final void invoke(Composer composer3, int i6) {
                                DefaultPaywallViewKt.DefaultPaywallView(packages, packageInfo, paywallWarning, onSelectPackage, onPurchase, onRestore, modifier3, defaultPaywallPreviewOverrides3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 12582912;
                defaultPaywallPreviewOverrides2 = defaultPaywallPreviewOverrides;
                if ((i3 & 4793491) == 4793490) {
                    if (i4 == 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localContext2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    context = (Context) objConsume2;
                    boolean zIsSystemInDarkTheme2 = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                    if (defaultPaywallPreviewOverrides4 == null) {
                    }
                    composerStartRestartGroup.startReplaceGroup(-332621739);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "83@3618L105");
                    if (boolIsDebugBuild != null) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (defaultPaywallPreviewOverrides4 == null) {
                    }
                    composerStartRestartGroup.startReplaceGroup(-332616071);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "88@3792L50");
                    if (appName == null) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-332612730);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DefaultPaywallView.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    mutableState = (MutableState) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    if (defaultPaywallPreviewOverrides4 == null) {
                    }
                    Bitmap bitmapDefaultPaywallView$lambda$33 = DefaultPaywallView$lambda$3(mutableState);
                    composerStartRestartGroup.startReplaceGroup(-332606687);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DefaultPaywallView.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(bitmapDefaultPaywallView$lambda$33) | composerStartRestartGroup.changed(prominentColors);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        MutableState mutableStateMutableStateOf$default22 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(prominentColors != null ? CollectionsKt.emptyList() : prominentColors, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default22);
                        objRememberedValue2 = mutableStateMutableStateOf$default22;
                        mutableState2 = (MutableState) objRememberedValue2;
                        composerStartRestartGroup.endReplaceGroup();
                        Bitmap bitmapDefaultPaywallView$lambda$322 = DefaultPaywallView$lambda$3(mutableState);
                        composerStartRestartGroup.startReplaceGroup(-332600662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DefaultPaywallView.kt#9igjgp");
                        zChangedInstance = composerStartRestartGroup.changedInstance(prominentColors) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changedInstance(context);
                        Object objRememberedValue52 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            mutableState3 = mutableState2;
                            mutableState4 = mutableState;
                            defaultPaywallViewKt$DefaultPaywallView$1$1 = new DefaultPaywallViewKt$DefaultPaywallView$1$1(prominentColors, mutableState, mutableState3, context, null);
                            composerStartRestartGroup.updateRememberedValue(defaultPaywallViewKt$DefaultPaywallView$1$1);
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(bitmapDefaultPaywallView$lambda$322, prominentColors, (Function2) defaultPaywallViewKt$DefaultPaywallView$1$1, composerStartRestartGroup, 0);
                            if (!zBooleanValue) {
                            }
                            if (paywallWarning3 == null) {
                            }
                            if (DefaultPaywallView$lambda$6(mutableState3).isEmpty()) {
                            }
                            if (!z) {
                            }
                            composerStartRestartGroup.startReplaceGroup(-332565442);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "134@5681L11");
                            if (z) {
                            }
                            final long j22 = onPrimary;
                            composerStartRestartGroup.endReplaceGroup();
                            Modifier modifierBackground$default2 = BackgroundKt.background$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Brush.Companion.m6280verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m6315boximpl(Color.m6324copywmQWz5c$default(j, 0.2f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m6315boximpl(Color.m6324copywmQWz5c$default(j, 0.0f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default2);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Modifier modifier42 = companion;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                            }
                            composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!composerM5595constructorimpl.getInserting()) {
                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2097683251, "C152@6184L427,163@6623L3311,149@6055L3879:DefaultPaywallView.kt#trihdm");
                                final long j32 = j;
                                final boolean z22 = z;
                                composer2 = composerStartRestartGroup;
                                ScaffoldKt.m3981ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, ComposableLambdaKt.rememberComposableLambda(-1275945433, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i6) {
                                        ComposerKt.sourceInformation(composer3, "C154@6251L328:DefaultPaywallView.kt#trihdm");
                                        if ((i6 & 3) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1275945433, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallView.<anonymous>.<anonymous> (DefaultPaywallView.kt:153)");
                                        }
                                        if (!packages.isEmpty()) {
                                            DefaultPaywallViewKt.m10793DefaultPaywallFooterZkgLGzA(onPurchase, onRestore, packageInfo != null, j32, j22, composer3, 0);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54), null, null, 0, Color.INSTANCE.m6360getTransparent0d7_KjU(), 0L, null, ComposableLambdaKt.rememberComposableLambda(-291497059, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer3, Integer num) {
                                        invoke(paddingValues, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(PaddingValues paddingValues, Composer composer3, int i6) {
                                        int i7;
                                        int i8;
                                        long j4;
                                        long j5;
                                        TemplateConfiguration.PackageInfo packageInfo2;
                                        Function1<TemplateConfiguration.PackageInfo, Unit> function1;
                                        List<TemplateConfiguration.PackageInfo> list;
                                        PaywallWarning paywallWarning4;
                                        String str;
                                        long j6;
                                        Composer composer4 = composer3;
                                        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                                        ComposerKt.sourceInformation(composer4, "C164@6654L3270:DefaultPaywallView.kt#trihdm");
                                        if ((i6 & 6) == 0) {
                                            i7 = i6 | (composer4.changed(paddingValues) ? 4 : 2);
                                        } else {
                                            i7 = i6;
                                        }
                                        if ((i7 & 19) == 18 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-291497059, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallView.<anonymous>.<anonymous> (DefaultPaywallView.kt:164)");
                                        }
                                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        Alignment topCenter = Alignment.INSTANCE.getTopCenter();
                                        List<TemplateConfiguration.PackageInfo> list2 = packages;
                                        long j7 = j32;
                                        long j8 = j22;
                                        TemplateConfiguration.PackageInfo packageInfo3 = packageInfo;
                                        Function1<TemplateConfiguration.PackageInfo, Unit> function12 = onSelectPackage;
                                        boolean z3 = z22;
                                        PaywallWarning paywallWarning5 = paywallWarning3;
                                        String str2 = appName;
                                        MutableState<Bitmap> mutableState5 = mutableState4;
                                        ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(topCenter, false);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap22 = composer4.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier22 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxSize$default);
                                        Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor22);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer4);
                                        Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier22, ComposeUiNode.INSTANCE.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer4, 991320756, "C168@6798L3112:DefaultPaywallView.kt#trihdm");
                                        Modifier modifierM2090widthInVpY3zN4$default = SizeKt.m2090widthInVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, ReadableContentWidth.INSTANCE.m10800getDpD9Ej5fM(), 1, null);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer4, modifierM2090widthInVpY3zN4$default);
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor3);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer4);
                                        Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                            composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                            composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                        }
                                        Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer4, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer4, -91854882, "C173@6981L1526,203@8529L38,212@9014L878,205@8589L1303:DefaultPaywallView.kt#trihdm");
                                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                        Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(24.0f));
                                        ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, centerHorizontally, composer4, 54);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default);
                                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor4);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer composerM5595constructorimpl4 = Updater.m5595constructorimpl(composer4);
                                        Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (composerM5595constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                            composerM5595constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                            composerM5595constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                        }
                                        Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer4, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer4, -2138276183, "C178@7248L79:DefaultPaywallView.kt#trihdm");
                                        SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(paddingValues.getTop() + Dp.m9114constructorimpl(32.0f))), composer4, 0);
                                        composer4.startReplaceGroup(1177952101);
                                        ComposerKt.sourceInformation(composer4, "184@7676L10,185@7754L11,182@7570L428");
                                        if (z3) {
                                            TextStyle titleMedium = MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getTitleMedium();
                                            long onSurface = MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSurface();
                                            FontWeight bold = FontWeight.INSTANCE.getBold();
                                            int iM8992getCentere0LSkKk = TextAlign.INSTANCE.m8992getCentere0LSkKk();
                                            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            TextAlign textAlignM8985boximpl = TextAlign.m8985boximpl(iM8992getCentere0LSkKk);
                                            paywallWarning4 = paywallWarning5;
                                            j4 = j7;
                                            function1 = function12;
                                            j5 = j8;
                                            packageInfo2 = packageInfo3;
                                            i8 = 0;
                                            str = str2;
                                            list = list2;
                                            TextKt.m4286Text4IGK_g("RevenueCat Paywalls", modifierFillMaxWidth$default2, onSurface, 0L, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, textAlignM8985boximpl, 0L, 0, false, 0, 0, (Function1) null, titleMedium, composer3, 196662, 0, 64984);
                                            composer4 = composer3;
                                        } else {
                                            i8 = 0;
                                            j4 = j7;
                                            j5 = j8;
                                            packageInfo2 = packageInfo3;
                                            function1 = function12;
                                            list = list2;
                                            paywallWarning4 = paywallWarning5;
                                            str = str2;
                                        }
                                        composer4.endReplaceGroup();
                                        if (paywallWarning4 != null) {
                                            composer4.startReplaceGroup(-2137487916);
                                            ComposerKt.sourceInformation(composer4, "193@8107L81");
                                            DefaultPaywallWarningKt.m10796DefaultPaywallWarning3IgeMak(paywallWarning4, DefaultPaywallViewKt.RevenueCatBrandRed, null, composer4, 48, 4);
                                            composer4.endReplaceGroup();
                                            j6 = j4;
                                        } else {
                                            composer4.startReplaceGroup(-2137342092);
                                            ComposerKt.sourceInformation(composer4, "195@8250L209");
                                            j6 = j4;
                                            DefaultPaywallViewKt.m10792AppIconSectioncf5BqRc(DefaultPaywallViewKt.DefaultPaywallView$lambda$3(mutableState5), str, j6, null, composer3, 0, 8);
                                            composer4 = composer3;
                                            composer4.endReplaceGroup();
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, i8);
                                        Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SelectableGroupKt.selectableGroup(Modifier.INSTANCE), 0.0f, 0.0f, 0.0f, paddingValues.getBottom(), 7, null);
                                        PaddingValues paddingValuesM2030PaddingValues0680j_4 = PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f));
                                        Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                                        Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_42 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(8.0f));
                                        composer4.startReplaceGroup(1936762612);
                                        ComposerKt.sourceInformation(composer4, "CC(remember):DefaultPaywallView.kt#9igjgp");
                                        final long j9 = j5;
                                        final TemplateConfiguration.PackageInfo packageInfo4 = packageInfo2;
                                        final Function1<? super TemplateConfiguration.PackageInfo, Unit> function13 = function1;
                                        boolean zChangedInstance2 = composer4.changedInstance(list) | composer4.changed(j6) | composer4.changed(j9) | composer4.changed(packageInfo4) | composer4.changed(function13);
                                        Object objRememberedValue6 = composer4.rememberedValue();
                                        if (zChangedInstance2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                            final List<TemplateConfiguration.PackageInfo> list3 = list;
                                            final long j10 = j6;
                                            objRememberedValue6 = (Function1) new Function1<LazyListScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                                    invoke2(lazyListScope);
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(LazyListScope LazyColumn) {
                                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                                    final List list4 = list3;
                                                    final Function1 anonymousClass1 = new Function1<TemplateConfiguration.PackageInfo, Object>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(TemplateConfiguration.PackageInfo it) {
                                                            Intrinsics.checkNotNullParameter(it, "it");
                                                            return it.getRcPackage().getIdentifier();
                                                        }
                                                    };
                                                    final long j11 = j10;
                                                    final long j12 = j9;
                                                    final TemplateConfiguration.PackageInfo packageInfo5 = packageInfo4;
                                                    final Function1 function14 = function13;
                                                    final Function1 defaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1$invoke$$inlined$items$default$1 = new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1$invoke$$inlined$items$default$1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                            return invoke((TemplateConfiguration.PackageInfo) obj);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Void invoke(TemplateConfiguration.PackageInfo packageInfo6) {
                                                            return null;
                                                        }
                                                    };
                                                    LazyColumn.items(list4.size(), anonymousClass1 != null ? new Function1<Integer, Object>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1$invoke$$inlined$items$default$2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        public final Object invoke(int i9) {
                                                            return anonymousClass1.invoke(list4.get(i9));
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                                            return invoke(num.intValue());
                                                        }
                                                    } : null, new Function1<Integer, Object>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1$invoke$$inlined$items$default$3
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        public final Object invoke(int i9) {
                                                            return defaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1$invoke$$inlined$items$default$1.invoke(list4.get(i9));
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                                            return invoke(num.intValue());
                                                        }
                                                    }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1$invoke$$inlined$items$default$4
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(4);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function4
                                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer5, Integer num2) {
                                                            invoke(lazyItemScope, num.intValue(), composer5, num2.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(LazyItemScope lazyItemScope, int i9, Composer composer5, int i10) {
                                                            int i11;
                                                            ComposerKt.sourceInformation(composer5, "C152@7074L22:LazyDsl.kt#428nma");
                                                            if ((i10 & 6) == 0) {
                                                                i11 = (composer5.changed(lazyItemScope) ? 4 : 2) | i10;
                                                            } else {
                                                                i11 = i10;
                                                            }
                                                            if ((i10 & 48) == 0) {
                                                                i11 |= composer5.changed(i9) ? 32 : 16;
                                                            }
                                                            if ((i11 & 147) == 146 && composer5.getSkipping()) {
                                                                composer5.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-632812321, i11, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                                                            }
                                                            final TemplateConfiguration.PackageInfo packageInfo6 = (TemplateConfiguration.PackageInfo) list4.get(i9);
                                                            composer5.startReplaceGroup(-350675214);
                                                            ComposerKt.sourceInformation(composer5, "C*222@9562L32,217@9227L398:DefaultPaywallView.kt#trihdm");
                                                            Package rcPackage = packageInfo6.getRcPackage();
                                                            long j13 = j11;
                                                            long j14 = j12;
                                                            boolean zAreEqual = Intrinsics.areEqual(packageInfo5, packageInfo6);
                                                            composer5.startReplaceGroup(819982243);
                                                            ComposerKt.sourceInformation(composer5, "CC(remember):DefaultPaywallView.kt#9igjgp");
                                                            boolean zChanged2 = composer5.changed(function14) | composer5.changed(packageInfo6);
                                                            Object objRememberedValue7 = composer5.rememberedValue();
                                                            if (zChanged2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                                final Function1<? super TemplateConfiguration.PackageInfo, Unit> function15 = function14;
                                                                objRememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallView$2$2$1$1$2$1$2$1$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
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
                                                                        function15.invoke(packageInfo6);
                                                                    }
                                                                };
                                                                composer5.updateRememberedValue(objRememberedValue7);
                                                            }
                                                            composer5.endReplaceGroup();
                                                            DefaultProductCellKt.m10797DefaultProductCellqi6gXK8(rcPackage, j13, j14, zAreEqual, (Function0) objRememberedValue7, null, composer5, 0, 32);
                                                            composer5.endReplaceGroup();
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }));
                                                    if (list3.isEmpty()) {
                                                        return;
                                                    }
                                                    LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$DefaultPaywallViewKt.INSTANCE.m10789getLambda1$revenuecatui_defaultsBc8Release(), 3, null);
                                                }
                                            };
                                            composer4.updateRememberedValue(objRememberedValue6);
                                        }
                                        composer4.endReplaceGroup();
                                        LazyDslKt.LazyColumn(modifierM2041paddingqDBjuR0$default, null, paddingValuesM2030PaddingValues0680j_4, false, horizontalOrVerticalM1907spacedBy0680j_42, centerHorizontally2, null, false, (Function1) objRememberedValue6, composer3, 221568, 202);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54), composer2, 806879622, Videoio.CAP_PROP_XI_AEAG_ROI_HEIGHT);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                defaultPaywallPreviewOverrides3 = defaultPaywallPreviewOverrides4;
                                modifier3 = modifier42;
                            }
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 128;
            if (i5 == 0) {
            }
            defaultPaywallPreviewOverrides2 = defaultPaywallPreviewOverrides;
            if ((i3 & 4793491) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        i4 = i2 & 64;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 128;
        if (i5 == 0) {
        }
        defaultPaywallPreviewOverrides2 = defaultPaywallPreviewOverrides;
        if ((i3 & 4793491) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap DefaultPaywallView$lambda$3(MutableState<Bitmap> mutableState) {
        return mutableState.getValue();
    }

    private static final List<Color> DefaultPaywallView$lambda$6(MutableState<List<Color>> mutableState) {
        return mutableState.getValue();
    }

    private static /* synthetic */ void getRevenueCatBrandRed$annotations() {
    }
}
