package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingFunctionsKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.ClickableTextKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.SurfaceKt;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.TextUnitKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: OnboardingActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001d\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0010\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0017X\u008a\u0084\u0002"}, d2 = {"OnboardingScreen", "", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "onLoginClick", "Lkotlin/Function0;", "onGetStartedClick", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "getPageName", "", "page", "", "InfoBadge", "iconResId", "text", "(ILjava/lang/String;Landroidx/compose/runtime/Composer;I)V", "OnboardingPage", "(ILandroidx/compose/runtime/Composer;I)V", "app_release", "animationStarted", "", "showContent", "animationProgress", "", "contentAlpha"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OnboardingActivityKt {
    public static final void InfoBadge(final int i, final String text, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(1050296737);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InfoBadge)N(iconResId,text)321@12912L761:OnboardingActivity.kt#r9tj48");
        if ((i2 & 6) == 0) {
            i3 = i2 | (composerStartRestartGroup.changed(i) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(text) ? 32 : 16;
        }
        int i4 = i3;
        if (composerStartRestartGroup.shouldExecute((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1050296737, i4, -1, "com.studiolaganne.lengendarylens.InfoBadge (OnboardingActivity.kt:319)");
            }
            FontFamily FontFamily = FontFamilyKt.FontFamily(FontKt.m8649FontYpTlLL0$default(R.font.be_vietnam_pro_semibold, null, 0, 0, 14, null));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(BorderKt.m1494borderxT4_qwU(BackgroundKt.m1482backgroundbw27NRU(Modifier.INSTANCE, ColorKt.Color(4280032284L), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(8.0f))), Dp.m9114constructorimpl(1.0f), ColorKt.Color(4292115280L), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(8.0f))), Dp.m9114constructorimpl(12.0f), Dp.m9114constructorimpl(6.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2038paddingVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 633218008, "C332@13305L31,331@13277L191,337@13477L39,338@13525L142:OnboardingActivity.kt#r9tj48");
            IconKt.m3735Iconww6aTOc(PainterResources_androidKt.painterResource(i, composerStartRestartGroup, i4 & 14), (String) null, SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(18.0f)), ColorKt.Color(4292115280L), composerStartRestartGroup, Painter.$stable | 3504, 0);
            SpacerKt.Spacer(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(8.0f)), composerStartRestartGroup, 6);
            composer2 = composerStartRestartGroup;
            TextKt.m4288TextNvy7gAk(text, null, Color.INSTANCE.m6362getWhite0d7_KjU(), null, TextUnitKt.getSp(15), null, null, FontFamily, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, ((i4 >> 3) & 14) | 24960, 0, 261994);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.studiolaganne.lengendarylens.OnboardingActivityKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingActivityKt.InfoBadge$lambda$1(i, text, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit InfoBadge$lambda$1(int i, String str, int i2, Composer composer, int i3) {
        InfoBadge(i, str, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void OnboardingPage(final int i, Composer composer, final int i2) {
        int i3;
        AnnotatedString.Builder builder;
        int iPushStyle;
        Composer composerStartRestartGroup = composer.startRestartGroup(395890513);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingPage)N(page)353@13843L15217:OnboardingActivity.kt#r9tj48");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(395890513, i3, -1, "com.studiolaganne.lengendarylens.OnboardingPage (OnboardingActivity.kt:349)");
            }
            FontFamily FontFamily = FontFamilyKt.FontFamily(FontKt.m8649FontYpTlLL0$default(R.font.be_vietnam_pro_semibold, null, 0, 0, 14, null));
            Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9114constructorimpl(16.0f));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2037padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1343332470, "C359@13992L15062:OnboardingActivity.kt#r9tj48");
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center2, centerHorizontally, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m5599initimpl(composerM5595constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1081672859, "C:OnboardingActivity.kt#r9tj48");
            if (i == 0) {
                composerStartRestartGroup.startReplaceGroup(1081359882);
                ComposerKt.sourceInformation(composerStartRestartGroup, "366@14226L2856,423@17104L41,433@17583L262");
                BoxWithConstraintsKt.BoxWithConstraints(ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null), null, false, ComposableSingletons$OnboardingActivityKt.INSTANCE.m10944getLambda$444036325$app_release(), composerStartRestartGroup, 3072, 6);
                SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(20.0f)), composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceGroup(-796309338);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*430@17491L47");
                builder = new AnnotatedString.Builder(0, 1, null);
                composerStartRestartGroup.startReplaceGroup(-796308019);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*427@17349L47");
                iPushStyle = builder.pushStyle(new SpanStyle(ColorKt.Color(4292115280L), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
                try {
                    builder.append(StringResources_androidKt.stringResource(R.string.onboarding_page1_part1, composerStartRestartGroup, 0));
                    Unit unit = Unit.INSTANCE;
                    builder.pop(iPushStyle);
                    composerStartRestartGroup.endReplaceGroup();
                    builder.append(" ");
                    builder.append(StringResources_androidKt.stringResource(R.string.onboarding_page1_part2, composerStartRestartGroup, 0));
                    AnnotatedString annotatedString = builder.toAnnotatedString();
                    composerStartRestartGroup.endReplaceGroup();
                    TextKt.m4289TextZ58ophY(annotatedString, null, Color.INSTANCE.m6362getWhite0d7_KjU(), null, TextUnitKt.getSp(22), null, null, FontFamily, 0L, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, null, composerStartRestartGroup, 24960, 0, 523114);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                }
            } else if (i != 1) {
                if (i != 2) {
                    composerStartRestartGroup.startReplaceGroup(1067155093);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1091281463);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "567@24190L4822");
                    Modifier modifierM2039paddingVpY3zN4$default = PaddingKt.m2039paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9114constructorimpl(12.0f), 0.0f, 2, null);
                    Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2039paddingVpY3zN4$default);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composerStartRestartGroup);
                    Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m5599initimpl(composerM5595constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m5601reconcileimpl(composerM5595constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1596893108, "C573@24466L38,575@24530L3302,637@27858L38,652@28669L321:OnboardingActivity.kt#r9tj48");
                    SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.95f), null, false, 3, null), null, false, ComposableSingletons$OnboardingActivityKt.INSTANCE.m10946getLambda$757908263$app_release(), composerStartRestartGroup, 3078, 6);
                    SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceGroup(-1888042653);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*644@28241L47,649@28569L47");
                    builder = new AnnotatedString.Builder(0, 1, null);
                    composerStartRestartGroup.startReplaceGroup(-1888041550);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*641@28087L47");
                    iPushStyle = builder.pushStyle(new SpanStyle(ColorKt.Color(4292115280L), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
                    try {
                        builder.append(StringResources_androidKt.stringResource(R.string.onboarding_page3_part1, composerStartRestartGroup, 0));
                        Unit unit3 = Unit.INSTANCE;
                        builder.pop(iPushStyle);
                        composerStartRestartGroup.endReplaceGroup();
                        builder.append(" ");
                        builder.append(StringResources_androidKt.stringResource(R.string.onboarding_page3_part2, composerStartRestartGroup, 0));
                        builder.append(" ");
                        composerStartRestartGroup.startReplaceGroup(-1888029774);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*647@28455L47");
                        iPushStyle = builder.pushStyle(new SpanStyle(ColorKt.Color(4292115280L), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
                        try {
                            builder.append(StringResources_androidKt.stringResource(R.string.onboarding_page3_part3, composerStartRestartGroup, 0));
                            Unit unit4 = Unit.INSTANCE;
                            builder.pop(iPushStyle);
                            composerStartRestartGroup.endReplaceGroup();
                            builder.append(StringResources_androidKt.stringResource(R.string.onboarding_page3_part4, composerStartRestartGroup, 0));
                            AnnotatedString annotatedString2 = builder.toAnnotatedString();
                            composerStartRestartGroup.endReplaceGroup();
                            TextKt.m4289TextZ58ophY(annotatedString2, null, Color.INSTANCE.m6362getWhite0d7_KjU(), null, TextUnitKt.getSp(22), null, null, FontFamilyKt.FontFamily(FontKt.m8649FontYpTlLL0$default(R.font.be_vietnam_pro_semibold, null, 0, 0, 14, null)), 0L, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, null, composerStartRestartGroup, 24960, 0, 523114);
                            composerStartRestartGroup = composerStartRestartGroup;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } finally {
                        }
                    } finally {
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
                Unit unit5 = Unit.INSTANCE;
            } else {
                composerStartRestartGroup.startReplaceGroup(1085092096);
                ComposerKt.sourceInformation(composerStartRestartGroup, "442@17907L5483,548@23412L41,558@23866L262");
                BoxWithConstraintsKt.BoxWithConstraints(ColumnScope.weight$default(columnScopeInstance, PaddingKt.m2039paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), Dp.m9114constructorimpl(24.0f), 0.0f, 2, null), 1.0f, false, 2, null), Alignment.INSTANCE.getCenter(), false, ComposableSingletons$OnboardingActivityKt.INSTANCE.m10943getLambda$4194428$app_release(), composerStartRestartGroup, 3120, 4);
                SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(12.0f)), composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceGroup(-796107507);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*555@23774L47");
                builder = new AnnotatedString.Builder(0, 1, null);
                composerStartRestartGroup.startReplaceGroup(-796106188);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*552@23632L47");
                iPushStyle = builder.pushStyle(new SpanStyle(ColorKt.Color(4292115280L), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
                try {
                    builder.append(StringResources_androidKt.stringResource(R.string.onboarding_page2_part1, composerStartRestartGroup, 0));
                    Unit unit6 = Unit.INSTANCE;
                    builder.pop(iPushStyle);
                    composerStartRestartGroup.endReplaceGroup();
                    builder.append(" ");
                    builder.append(StringResources_androidKt.stringResource(R.string.onboarding_page2_part2, composerStartRestartGroup, 0));
                    AnnotatedString annotatedString3 = builder.toAnnotatedString();
                    composerStartRestartGroup.endReplaceGroup();
                    TextKt.m4289TextZ58ophY(annotatedString3, null, Color.INSTANCE.m6362getWhite0d7_KjU(), null, TextUnitKt.getSp(22), null, null, FontFamily, 0L, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, null, composerStartRestartGroup, 24960, 0, 523114);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit7 = Unit.INSTANCE;
                } finally {
                }
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.studiolaganne.lengendarylens.OnboardingActivityKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingActivityKt.OnboardingPage$lambda$1(i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit OnboardingPage$lambda$1(int i, int i2, Composer composer, int i3) {
        OnboardingPage(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void OnboardingScreen(final FirebaseAnalytics firebaseAnalytics, final Function0<Unit> onLoginClick, final Function0<Unit> onGetStartedClick, Composer composer, final int i) {
        int i2;
        Composer composer2;
        PagerState pagerState;
        float f;
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
        Intrinsics.checkNotNullParameter(onLoginClick, "onLoginClick");
        Intrinsics.checkNotNullParameter(onGetStartedClick, "onGetStartedClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(802555564);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnboardingScreen)N(firebaseAnalytics,onLoginClick,onGetStartedClick)109@4281L34,110@4339L34,113@4459L5,113@4428L37,116@4534L348,116@4495L387,126@4909L134,126@4888L155,133@5074L170,138@5270L152,146@5518L7063,143@5428L7153:OnboardingActivity.kt#r9tj48");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(firebaseAnalytics) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onLoginClick) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onGetStartedClick) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(802555564, i2, -1, "com.studiolaganne.lengendarylens.OnboardingScreen (OnboardingActivity.kt:102)");
            }
            long jColor = ColorKt.Color(4279242768L);
            final long jColor2 = ColorKt.Color(4292115280L);
            final FontFamily FontFamily = FontFamilyKt.FontFamily(FontKt.m8649FontYpTlLL0$default(R.font.baloo_da_2_bold, null, 0, 0, 14, null));
            final FontFamily FontFamily2 = FontFamilyKt.FontFamily(FontKt.m8649FontYpTlLL0$default(R.font.be_vietnam_pro_semibold, null, 0, 0, 14, null));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1838204082, "CC(remember):OnboardingActivity.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1838202226, "CC(remember):OnboardingActivity.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1838198415, "CC(remember):OnboardingActivity.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.studiolaganne.lengendarylens.OnboardingActivityKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(OnboardingActivityKt.OnboardingScreen$lambda$6$0());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 384, 3);
            Integer numValueOf = Integer.valueOf(pagerStateRememberPagerState.getCurrentPage());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1838195672, "CC(remember):OnboardingActivity.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(pagerStateRememberPagerState) | composerStartRestartGroup.changedInstance(firebaseAnalytics);
            OnboardingActivityKt$OnboardingScreen$1$1 onboardingActivityKt$OnboardingScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || onboardingActivityKt$OnboardingScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                onboardingActivityKt$OnboardingScreen$1$1RememberedValue = new OnboardingActivityKt$OnboardingScreen$1$1(firebaseAnalytics, mutableState2, pagerStateRememberPagerState, null);
                composerStartRestartGroup.updateRememberedValue(onboardingActivityKt$OnboardingScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) onboardingActivityKt$OnboardingScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1838183886, "CC(remember):OnboardingActivity.kt#9igjgp");
            OnboardingActivityKt$OnboardingScreen$2$1 onboardingActivityKt$OnboardingScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (onboardingActivityKt$OnboardingScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                onboardingActivityKt$OnboardingScreen$2$1RememberedValue = new OnboardingActivityKt$OnboardingScreen$2$1(500, mutableState, mutableState2, null);
                composerStartRestartGroup.updateRememberedValue(onboardingActivityKt$OnboardingScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect((Object) true, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) onboardingActivityKt$OnboardingScreen$2$1RememberedValue, composerStartRestartGroup, 6);
            if (OnboardingScreen$lambda$1(mutableState)) {
                pagerState = pagerStateRememberPagerState;
                f = 1.0f;
            } else {
                pagerState = pagerStateRememberPagerState;
                f = 0.0f;
            }
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, AnimationSpecKt.tween$default(500, 0, EasingFunctionsKt.getEaseOutQuad(), 2, null), 0.0f, null, null, composerStartRestartGroup, 0, 28);
            final State<Float> stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(OnboardingScreen$lambda$4(mutableState2) ? 1.0f : 0.0f, AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null), 0.0f, null, null, composerStartRestartGroup, 0, 28);
            final PagerState pagerState2 = pagerState;
            SurfaceKt.m4145SurfaceT9BRK9s(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, jColor, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-689364089, true, new Function2() { // from class: com.studiolaganne.lengendarylens.OnboardingActivityKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingActivityKt.OnboardingScreen$lambda$11(stateAnimateFloatAsState, FontFamily, mutableState2, stateAnimateFloatAsState2, pagerState2, onGetStartedClick, FontFamily2, firebaseAnalytics, onLoginClick, jColor2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12583302, Imgproc.COLOR_YUV2BGRA_YVYU);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.studiolaganne.lengendarylens.OnboardingActivityKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingActivityKt.OnboardingScreen$lambda$12(firebaseAnalytics, onLoginClick, onGetStartedClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean OnboardingScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final float OnboardingScreen$lambda$10(State<Float> state) {
        return state.getValue().floatValue();
    }

    static final Unit OnboardingScreen$lambda$11(final State state, final FontFamily fontFamily, final MutableState mutableState, final State state2, final PagerState pagerState, final Function0 function0, final FontFamily fontFamily2, final FirebaseAnalytics firebaseAnalytics, final Function0 function02, final long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C148@5583L6992,148@5529L7046:OnboardingActivity.kt#r9tj48");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-689364089, i, -1, "com.studiolaganne.lengendarylens.OnboardingScreen.<anonymous> (OnboardingActivity.kt:148)");
            }
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(1183001969, true, new Function3() { // from class: com.studiolaganne.lengendarylens.OnboardingActivityKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingActivityKt.OnboardingScreen$lambda$11$0(state, fontFamily, mutableState, state2, pagerState, function0, fontFamily2, firebaseAnalytics, function02, j, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3078, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingScreen$lambda$11$0(State state, FontFamily fontFamily, MutableState mutableState, State state2, final PagerState pagerState, final Function0 function0, final FontFamily fontFamily2, final FirebaseAnalytics firebaseAnalytics, final Function0 function02, long j, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C163@6208L54,162@6175L306,171@6533L927:OnboardingActivity.kt#r9tj48");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1183001969, i2, -1, "com.studiolaganne.lengendarylens.OnboardingScreen.<anonymous>.<anonymous> (OnboardingActivity.kt:150)");
            }
            float fM9114constructorimpl = Dp.m9114constructorimpl(Dp.m9114constructorimpl(BoxWithConstraints.mo1932getMaxHeightD9Ej5fM() / 2.0f) - Dp.m9114constructorimpl(100.0f));
            float fM9114constructorimpl2 = Dp.m9114constructorimpl(80.0f);
            float fM9157lerpMdfbLM = DpKt.m9157lerpMdfbLM(Dp.m9114constructorimpl(Dp.m9114constructorimpl(BoxWithConstraints.mo1933getMaxWidthD9Ej5fM() / 2.0f) - Dp.m9114constructorimpl(Dp.m9114constructorimpl(160.0f) / 2.0f)), Dp.m9114constructorimpl(Dp.m9114constructorimpl(Dp.m9114constructorimpl(Dp.m9114constructorimpl(BoxWithConstraints.mo1933getMaxWidthD9Ej5fM() - Dp.m9114constructorimpl(32.0f)) - Dp.m9114constructorimpl(12.0f)) - Dp.m9114constructorimpl(130.0f)) / 2.0f), OnboardingScreen$lambda$9(state));
            float fM9114constructorimpl3 = Dp.m9114constructorimpl(Dp.m9114constructorimpl(BoxWithConstraints.mo1932getMaxHeightD9Ej5fM() / 2.0f) + Dp.m9114constructorimpl(60.0f));
            float fM9114constructorimpl4 = Dp.m9114constructorimpl(80.0f);
            float fM9157lerpMdfbLM2 = DpKt.m9157lerpMdfbLM(Dp.m9114constructorimpl(Dp.m9114constructorimpl(BoxWithConstraints.mo1933getMaxWidthD9Ej5fM() / 2.0f) - Dp.m9114constructorimpl(Dp.m9114constructorimpl(180.0f) / 2.0f)), Dp.m9114constructorimpl(Dp.m9114constructorimpl(Dp.m9114constructorimpl(Dp.m9114constructorimpl(Dp.m9114constructorimpl(Dp.m9114constructorimpl(BoxWithConstraints.mo1933getMaxWidthD9Ej5fM() - Dp.m9114constructorimpl(32.0f)) - Dp.m9114constructorimpl(12.0f)) - Dp.m9114constructorimpl(130.0f)) / 2.0f) + Dp.m9114constructorimpl(32.0f)) + Dp.m9114constructorimpl(16.0f)), OnboardingScreen$lambda$9(state));
            float fM9157lerpMdfbLM3 = DpKt.m9157lerpMdfbLM(Dp.m9114constructorimpl(160.0f), Dp.m9114constructorimpl(32.0f), OnboardingScreen$lambda$9(state));
            long jM9328lerpC3pnCVY = TextUnitKt.m9328lerpC3pnCVY(TextUnitKt.getSp(32), TextUnitKt.getSp(20), OnboardingScreen$lambda$9(state));
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.onboarding_background, composer, 0), "Background Pattern", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenter(), ContentScale.INSTANCE.getFit(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 28080, 96);
            Modifier modifierM2069height3ABfNKs = SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BoxWithConstraints.mo1932getMaxHeightD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2069height3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1030895193, "C178@6780L43,177@6743L335,186@7120L326:OnboardingActivity.kt#r9tj48");
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_round, composer, 0), "Mythic Tools Logo", SizeKt.m2083size3ABfNKs(OffsetKt.m1996offsetVpY3zN4(Modifier.INSTANCE, fM9157lerpMdfbLM, DpKt.m9157lerpMdfbLM(fM9114constructorimpl, fM9114constructorimpl2, OnboardingScreen$lambda$9(state))), fM9157lerpMdfbLM3), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 48, 120);
            TextKt.m4288TextNvy7gAk("Mythic Tools", OffsetKt.m1996offsetVpY3zN4(Modifier.INSTANCE, fM9157lerpMdfbLM2, DpKt.m9157lerpMdfbLM(fM9114constructorimpl3, fM9114constructorimpl4, OnboardingScreen$lambda$9(state))), Color.INSTANCE.m6362getWhite0d7_KjU(), null, jM9328lerpC3pnCVY, null, null, fontFamily, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 390, 0, 261992);
            Composer composer2 = composer;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (OnboardingScreen$lambda$4(mutableState)) {
                composer2.startReplaceGroup(-1687862883);
                ComposerKt.sourceInformation(composer2, "198@7571L4980");
                Modifier modifierAlpha = AlphaKt.alpha(PaddingKt.m2041paddingqDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9114constructorimpl(24.0f), 7, null), OnboardingScreen$lambda$10(state2));
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierAlpha);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer2);
                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m5599initimpl(composerM5595constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m5601reconcileimpl(composerM5595constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -234890074, "C205@7864L42,207@7928L287,216@8237L215,222@8495L24,238@9216L48,225@8583L394,241@9442L1343,224@8541L2244,269@10807L41,294@12201L7,283@11500L652,281@11405L1065,302@12492L41:OnboardingActivity.kt#r9tj48");
                SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(120.0f)), composer2, 6);
                PagerKt.m2291HorizontalPager8jOkeI(pagerState, ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null), null, null, 0, 0.0f, null, null, false, false, null, null, null, null, ComposableSingletons$OnboardingActivityKt.INSTANCE.m10945getLambda$584823137$app_release(), composer, 0, 24576, 16380);
                AnimatedPageIndicatorKt.m10914AnimatedPageIndicatorNsDo4u0(3, pagerState.getCurrentPage(), PaddingKt.m2039paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9114constructorimpl(24.0f), 1, null), 0L, 0L, 0.0f, 0.0f, 0.0f, composer, 390, Imgcodecs.IMWRITE_PNG_ALL_FILTERS);
                ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                    composer.updateRememberedValue(objRememberedValue);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierM2069height3ABfNKs2 = SizeKt.m2069height3ABfNKs(PaddingKt.m2039paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9114constructorimpl(24.0f), 0.0f, 2, null), Dp.m9114constructorimpl(52.0f));
                ButtonColors buttonColorsM3340buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m3340buttonColorsro_MJ88(Color.INSTANCE.m6360getTransparent0d7_KjU(), 0L, 0L, 0L, composer, (ButtonDefaults.$stable << 12) | 6, 14);
                composer2 = composer;
                RoundedCornerShape roundedCornerShapeM2345RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(12.0f));
                PaddingValues paddingValuesM2030PaddingValues0680j_4 = PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f));
                ComposerKt.sourceInformationMarkerStart(composer2, 269536298, "CC(remember):OnboardingActivity.kt#9igjgp");
                boolean zChanged = composer2.changed(pagerState) | composer2.changed(function0) | composer2.changedInstance(coroutineScope);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.studiolaganne.lengendarylens.OnboardingActivityKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OnboardingActivityKt.OnboardingScreen$lambda$11$0$1$0$0(pagerState, function0, coroutineScope);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ButtonKt.Button((Function0) objRememberedValue2, modifierM2069height3ABfNKs2, false, roundedCornerShapeM2345RoundedCornerShape0680j_4, buttonColorsM3340buttonColorsro_MJ88, null, null, paddingValuesM2030PaddingValues0680j_4, null, ComposableLambdaKt.rememberComposableLambda(-1334725616, true, new Function3() { // from class: com.studiolaganne.lengendarylens.OnboardingActivityKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return OnboardingActivityKt.OnboardingScreen$lambda$11$0$1$1(pagerState, fontFamily2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, 817889328, 356);
                SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(20.0f)), composer2, 6);
                composer2.startReplaceGroup(269610221);
                ComposerKt.sourceInformation(composer2, "*272@10944L56");
                AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                builder.append(StringResources_androidKt.stringResource(R.string.already_account_onboarding, composer2, 0));
                builder.append(" ");
                builder.pushStringAnnotation(FirebaseAnalytics.Event.LOGIN, FirebaseAnalytics.Event.LOGIN);
                composer2.startReplaceGroup(269618043);
                ComposerKt.sourceInformation(composer2, "*276@11256L48");
                int iPushStyle = builder.pushStyle(new SpanStyle(j, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
                try {
                    builder.append(StringResources_androidKt.stringResource(R.string.sign_in_onboarding, composer2, 0));
                    Unit unit = Unit.INSTANCE;
                    builder.pop(iPushStyle);
                    composer2.endReplaceGroup();
                    builder.pop();
                    final AnnotatedString annotatedString = builder.toAnnotatedString();
                    composer2.endReplaceGroup();
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composer2.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    TextStyle textStyleM8569copyp1EtxEg$default = TextStyle.m8569copyp1EtxEg$default((TextStyle) objConsume, Color.INSTANCE.m6362getWhite0d7_KjU(), TextUnitKt.getSp(14), null, null, null, fontFamily2, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8992getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744412, null);
                    ComposerKt.sourceInformationMarkerStart(composer2, 269629900, "CC(remember):OnboardingActivity.kt#9igjgp");
                    boolean zChanged2 = composer2.changed(annotatedString) | composer2.changed(pagerState) | composer2.changedInstance(firebaseAnalytics) | composer2.changed(function02);
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.studiolaganne.lengendarylens.OnboardingActivityKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OnboardingActivityKt.OnboardingScreen$lambda$11$0$1$3$0(annotatedString, firebaseAnalytics, function02, pagerState, ((Integer) obj).intValue());
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ClickableTextKt.m2381ClickableText4YKlhWE(annotatedString, null, textStyleM8569copyp1EtxEg$default, false, 0, 0, null, (Function1) objRememberedValue3, composer2, 0, Imgproc.COLOR_YUV2BGRA_YVYU);
                    SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(20.0f)), composer2, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                } catch (Throwable th) {
                    builder.pop(iPushStyle);
                    throw th;
                }
            } else {
                composer2.startReplaceGroup(-1695511823);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingScreen$lambda$11$0$1$0$0(PagerState pagerState, Function0 function0, CoroutineScope coroutineScope) {
        if (pagerState.getCurrentPage() == 2) {
            function0.invoke();
        } else {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OnboardingActivityKt$OnboardingScreen$3$1$2$1$1$1(pagerState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingScreen$lambda$11$0$1$1(PagerState pagerState, FontFamily fontFamily, RowScope Button, Composer composer, int i) {
        String strStringResource;
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C242@9468L1295:OnboardingActivity.kt#r9tj48");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1334725616, i, -1, "com.studiolaganne.lengendarylens.OnboardingScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OnboardingActivity.kt:242)");
            }
            Modifier modifierBackground$default = BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m6272horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m6315boximpl(ColorKt.Color(4289552702L)), Color.m6315boximpl(ColorKt.Color(4287249949L))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(12.0f)), 0.0f, 4, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierBackground$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1422254038, "C256@10234L503:OnboardingActivity.kt#r9tj48");
            if (pagerState.getCurrentPage() == 2) {
                composer.startReplaceGroup(1422319323);
                ComposerKt.sourceInformation(composer, "258@10350L41");
                strStringResource = StringResources_androidKt.stringResource(R.string.get_started, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1422437371);
                ComposerKt.sourceInformation(composer, "260@10469L41");
                strStringResource = StringResources_androidKt.stringResource(R.string.next_button, composer, 0);
                composer.endReplaceGroup();
            }
            TextKt.m4288TextNvy7gAk(strStringResource, null, Color.INSTANCE.m6362getWhite0d7_KjU(), null, TextUnitKt.getSp(18), null, null, fontFamily, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24960, 0, 261994);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingScreen$lambda$11$0$1$3$0(AnnotatedString annotatedString, FirebaseAnalytics firebaseAnalytics, Function0 function0, PagerState pagerState, int i) {
        if (((AnnotatedString.Range) CollectionsKt.firstOrNull((List) annotatedString.getStringAnnotations(FirebaseAnalytics.Event.LOGIN, i, i))) != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("from_page", pagerState.getCurrentPage());
            bundle.putString("page_name", getPageName(pagerState.getCurrentPage()));
            firebaseAnalytics.logEvent("onboarding_sign_in_tapped", bundle);
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    static final Unit OnboardingScreen$lambda$12(FirebaseAnalytics firebaseAnalytics, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        OnboardingScreen(firebaseAnalytics, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OnboardingScreen$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean OnboardingScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OnboardingScreen$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int OnboardingScreen$lambda$6$0() {
        return 3;
    }

    private static final float OnboardingScreen$lambda$9(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getPageName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "unknown_page" : "deck_stats_page" : "card_page" : "video_page";
    }
}
