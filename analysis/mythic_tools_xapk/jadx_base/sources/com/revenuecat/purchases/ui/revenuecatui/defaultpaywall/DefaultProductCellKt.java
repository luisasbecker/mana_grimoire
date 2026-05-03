package com.revenuecat.purchases.ui.revenuecatui.defaultpaywall;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ui.revenuecatui.helpers.TestTag;
import com.revenuecat.purchases.ui.revenuecatui.icons.CheckCircleKt;
import com.revenuecat.purchases.ui.revenuecatui.icons.CircleOutlinedKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultProductCell.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aJ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2 = {"DefaultProductCell", "", "pkg", "Lcom/revenuecat/purchases/Package;", "accentColor", "Landroidx/compose/ui/graphics/Color;", "selectedFontColor", "isSelected", "", "onSelect", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "DefaultProductCell-qi6gXK8", "(Lcom/revenuecat/purchases/Package;JJZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsBc8Release", "backgroundColor", "contentColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DefaultProductCellKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0263  */
    /* JADX INFO: renamed from: DefaultProductCell-qi6gXK8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10797DefaultProductCellqi6gXK8(final Package pkg, final long j, final long j2, final boolean z, final Function0<Unit> onSelect, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        long j3;
        int i4;
        final Modifier modifier2;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1369842881);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DefaultProductCell)P(4,0:c#ui.graphics.Color,5:c#ui.graphics.Color!1,3)40@1623L183,44@1831L162,49@1999L1256:DefaultProductCell.kt#trihdm");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(pkg) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                j3 = j;
                i3 |= composerStartRestartGroup.changed(j3) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changed(j2) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(onSelect) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
                }
                if ((74899 & i3) == 74898 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                } else {
                    Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1369842881, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultProductCell (DefaultProductCell.kt:39)");
                    }
                    composerStartRestartGroup.startReplaceGroup(-241973088);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "41@1713L11");
                    long jM6324copywmQWz5c$default = !z ? j3 : Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurfaceVariant(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.endReplaceGroup();
                    State<Color> stateM1353animateColorAsStateeuL9pac = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(jM6324copywmQWz5c$default, null, "productCellBackground", null, composerStartRestartGroup, 384, 10);
                    composerStartRestartGroup.startReplaceGroup(-241966450);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "45@1927L11");
                    long onSurface = !z ? j2 : MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface();
                    composerStartRestartGroup.endReplaceGroup();
                    State<Color> stateM1353animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(onSurface, null, "productCellContent", null, composerStartRestartGroup, 384, 10);
                    Modifier modifier3 = companion;
                    Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(TestTagKt.testTag(SelectableKt.m2310selectableXHw0xAI$default(BackgroundKt.m1483backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(SizeKt.m2090widthInVpY3zN4$default(companion, 0.0f, Dp.m9114constructorimpl(560.0f), 1, null), 0.0f, 1, null), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(18.0f))), DefaultProductCell_qi6gXK8$lambda$0(stateM1353animateColorAsStateeuL9pac), null, 2, null), z, false, Role.m8320boximpl(Role.INSTANCE.m8332getRadioButtono7Vup1c()), onSelect, 2, null), TestTag.INSTANCE.selectButtonTestTag(pkg.getIdentifier())), Dp.m9114constructorimpl(16.0f));
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(12.0f));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2037padding3ABfNKs);
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
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1709002451, "C65@2564L205,73@2856L10,71@2779L306,83@3183L10,81@3095L154:DefaultProductCell.kt#trihdm");
                    IconKt.m3736Iconww6aTOc(!z ? CheckCircleKt.getCheckCircle() : CircleOutlinedKt.getCircleOutlined(), (String) null, (Modifier) null, Color.m6324copywmQWz5c$default(DefaultProductCell_qi6gXK8$lambda$1(stateM1353animateColorAsStateeuL9pac2), !z ? 1.0f : 0.5f, 0.0f, 0.0f, 0.0f, 14, null), composerStartRestartGroup, 48, 4);
                    String name = pkg.getProduct().getName();
                    TextStyle titleMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium();
                    TextKt.m4286Text4IGK_g(name, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), DefaultProductCell_qi6gXK8$lambda$1(stateM1353animateColorAsStateeuL9pac2), 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m9050getEllipsisgIe3tQ8(), false, 1, 0, (Function1) null, titleMedium, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 3120, 55256);
                    TextKt.m4286Text4IGK_g(pkg.getProduct().getPrice().getFormatted(), (Modifier) null, DefaultProductCell_qi6gXK8$lambda$1(stateM1353animateColorAsStateeuL9pac2), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 0, 0, 65530);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultProductCellKt$DefaultProductCell$2
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
                            DefaultProductCellKt.m10797DefaultProductCellqi6gXK8(pkg, j, j2, z, onSelect, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            modifier2 = modifier;
            if ((74899 & i3) == 74898) {
                if (i4 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.startReplaceGroup(-241973088);
                ComposerKt.sourceInformation(composerStartRestartGroup, "41@1713L11");
                if (!z) {
                }
                composerStartRestartGroup.endReplaceGroup();
                State<Color> stateM1353animateColorAsStateeuL9pac3 = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(jM6324copywmQWz5c$default, null, "productCellBackground", null, composerStartRestartGroup, 384, 10);
                composerStartRestartGroup.startReplaceGroup(-241966450);
                ComposerKt.sourceInformation(composerStartRestartGroup, "45@1927L11");
                if (!z) {
                }
                composerStartRestartGroup.endReplaceGroup();
                State<Color> stateM1353animateColorAsStateeuL9pac22 = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(onSurface, null, "productCellContent", null, composerStartRestartGroup, 384, 10);
                Modifier modifier32 = companion;
                Modifier modifierM2037padding3ABfNKs2 = PaddingKt.m2037padding3ABfNKs(TestTagKt.testTag(SelectableKt.m2310selectableXHw0xAI$default(BackgroundKt.m1483backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(SizeKt.m2090widthInVpY3zN4$default(companion, 0.0f, Dp.m9114constructorimpl(560.0f), 1, null), 0.0f, 1, null), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(18.0f))), DefaultProductCell_qi6gXK8$lambda$0(stateM1353animateColorAsStateeuL9pac3), null, 2, null), z, false, Role.m8320boximpl(Role.INSTANCE.m8332getRadioButtono7Vup1c()), onSelect, 2, null), TestTag.INSTANCE.selectButtonTestTag(pkg.getIdentifier())), Dp.m9114constructorimpl(16.0f));
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_42 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(12.0f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_42, centerVertically2, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2037padding3ABfNKs2);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                }
                composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl.getInserting()) {
                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1709002451, "C65@2564L205,73@2856L10,71@2779L306,83@3183L10,81@3095L154:DefaultProductCell.kt#trihdm");
                    IconKt.m3736Iconww6aTOc(!z ? CheckCircleKt.getCheckCircle() : CircleOutlinedKt.getCircleOutlined(), (String) null, (Modifier) null, Color.m6324copywmQWz5c$default(DefaultProductCell_qi6gXK8$lambda$1(stateM1353animateColorAsStateeuL9pac22), !z ? 1.0f : 0.5f, 0.0f, 0.0f, 0.0f, 14, null), composerStartRestartGroup, 48, 4);
                    String name2 = pkg.getProduct().getName();
                    TextStyle titleMedium2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium();
                    TextKt.m4286Text4IGK_g(name2, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), DefaultProductCell_qi6gXK8$lambda$1(stateM1353animateColorAsStateeuL9pac22), 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m9050getEllipsisgIe3tQ8(), false, 1, 0, (Function1) null, titleMedium2, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 3120, 55256);
                    TextKt.m4286Text4IGK_g(pkg.getProduct().getPrice().getFormatted(), (Modifier) null, DefaultProductCell_qi6gXK8$lambda$1(stateM1353animateColorAsStateeuL9pac22), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 0, 0, 65530);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier32;
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        j3 = j;
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        i4 = i2 & 32;
        if (i4 != 0) {
        }
        modifier2 = modifier;
        if ((74899 & i3) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final long DefaultProductCell_qi6gXK8$lambda$0(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    private static final long DefaultProductCell_qi6gXK8$lambda$1(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }
}
