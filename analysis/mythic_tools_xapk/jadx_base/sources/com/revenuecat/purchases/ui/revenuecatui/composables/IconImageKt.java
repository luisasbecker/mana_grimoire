package com.revenuecat.purchases.ui.revenuecatui.composables;

import android.net.Uri;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: IconImage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a6\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"IconImage", "", "uri", "Landroid/net/Uri;", "maxWidth", "Landroidx/compose/ui/unit/Dp;", "iconCornerRadius", "childModifier", "Landroidx/compose/ui/Modifier;", "IconImage-djqs-MU", "(Landroid/net/Uri;FFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "IconImagePreview", "(Landroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IconImageKt {
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: IconImage-djqs-MU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10632IconImagedjqsMU(final Uri uri, final float f, final float f2, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        float f3;
        int i4;
        Modifier modifier2;
        Modifier modifier3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-314692702);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconImage)P(3,2:c#ui.unit.Dp,1:c#ui.unit.Dp)*30@1142L841:IconImage.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(uri) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                f3 = f2;
                i3 |= composerStartRestartGroup.changed(f3) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
                }
                if ((i3 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                } else {
                    Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-314692702, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.IconImage (IconImage.kt:28)");
                    }
                    if (uri != null) {
                        modifier3 = companion;
                    } else {
                        Modifier modifierM2090widthInVpY3zN4$default = SizeKt.m2090widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2090widthInVpY3zN4$default);
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
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1858716279, "C35@1395L17:IconImage.kt#51odh9");
                        Modifier modifierClip = ClipKt.clip(SizeKt.m2090widthInVpY3zN4$default(AspectRatioKt.aspectRatio$default(companion, 1.0f, false, 2, null), 0.0f, f, 1, null), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(f3));
                        if (HelperFunctionsKt.isInPreviewMode(composerStartRestartGroup, 0)) {
                            composerStartRestartGroup.startReplaceGroup(1858903549);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "38@1535L11,36@1432L182");
                            BoxKt.Box(SizeKt.m2083size3ABfNKs(BackgroundKt.m1483backgroundbw27NRU$default(modifierClip, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), null, 2, null), f), composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            String string = uri.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
                            if (StringsKt.contains$default((CharSequence) string, (CharSequence) PaywallDataExtensionsKt.getDefaultAppIconPlaceholder(PaywallData.INSTANCE), false, 2, (Object) null)) {
                                composerStartRestartGroup.startReplaceGroup(1859184471);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "42@1720L28");
                                AppIconKt.AppIcon(modifierClip, composerStartRestartGroup, 0, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1859254438);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "44@1786L173");
                                String string2 = uri.toString();
                                Intrinsics.checkNotNullExpressionValue(string2, "uri.toString()");
                                modifier3 = companion;
                                RemoteImageKt.RemoteImage(string2, modifierClip, null, ContentScale.INSTANCE.getCrop(), null, null, 0.0f, null, composerStartRestartGroup, 3072, 244);
                                composerStartRestartGroup.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                        }
                        modifier3 = companion;
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
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.IconImageKt$IconImage$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i5) {
                            IconImageKt.m10632IconImagedjqsMU(uri, f, f2, modifier4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
                if (uri != null) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        f3 = f2;
        i4 = i2 & 8;
        if (i4 != 0) {
        }
        modifier2 = modifier;
        if ((i3 & 1171) == 1170) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IconImagePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(432450827);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconImagePreview)57@2051L142:IconImage.kt#51odh9");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(432450827, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.IconImagePreview (IconImage.kt:56)");
            }
            m10632IconImagedjqsMU(Uri.parse("https://assets.pawwalls.com/icon.jpg"), Dp.m9114constructorimpl(140.0f), Dp.m9114constructorimpl(16.0f), null, composerStartRestartGroup, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.IconImageKt.IconImagePreview.1
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
                    IconImageKt.IconImagePreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
