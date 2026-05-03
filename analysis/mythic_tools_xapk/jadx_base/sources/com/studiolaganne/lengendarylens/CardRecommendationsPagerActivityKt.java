package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.core.content.res.ResourcesCompat;
import com.bumptech.glide.Glide;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: CardRecommendationsPagerActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\u001ai\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001aA\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001a\u001d\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u001e\u001a-\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\"\u001a1\u0010#\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0019H\u0003¢\u0006\u0002\u0010$\u001a+\u0010&\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0003¢\u0006\u0002\u0010(\u001a\u0015\u0010)\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\bH\u0003¢\u0006\u0002\u0010+\u001a\u001f\u0010,\u001a\u00020-*\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0003¢\u0006\u0002\u0010/\"\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060²\u0006\u0010\u00101\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\f\u00104\u001a\u0004\u0018\u00010\u0006X\u008a\u008e\u0002²\u0006\n\u00105\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u00106\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u00107\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u00108\u001a\u000209X\u008a\u0084\u0002²\u0006\n\u0010:\u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\n\u0010;\u001a\u00020\u0015X\u008a\u008e\u0002"}, d2 = {"RecommendationsPagerScreen", "", "initialCards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "startIndex", "", "categoryLabel", "", "initialAddedIds", "", "paginationState", "Lcom/studiolaganne/lengendarylens/PagerPaginationState;", "onClose", "Lkotlin/Function0;", "onAddToDeck", "Lkotlin/Function2;", "(Ljava/util/List;ILjava/lang/String;Ljava/util/Set;Lcom/studiolaganne/lengendarylens/PagerPaginationState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "RecommendationCardPage", "card", "isAdded", "", "beVietnamFont", "Landroidx/compose/ui/text/font/FontFamily;", "beVietnamRegular", "Lkotlin/Function1;", "(Lcom/studiolaganne/lengendarylens/MTFullCard;ZLandroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontFamily;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "CollectionPill", "coll", "Lcom/studiolaganne/lengendarylens/MTCardCollectionStatus;", "(Lcom/studiolaganne/lengendarylens/MTCardCollectionStatus;Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/runtime/Composer;I)V", "RecommendationInfoRow", "rec", "Lcom/studiolaganne/lengendarylens/MTRecommendationData;", "(Lcom/studiolaganne/lengendarylens/MTRecommendationData;ZLandroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/runtime/Composer;I)V", "RecommendationActionsRow", "(ZLandroidx/compose/ui/text/font/FontFamily;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "DFC_LAYOUTS", "OracleTextDialog", "onDismiss", "(Lcom/studiolaganne/lengendarylens/MTFullCard;Landroidx/compose/ui/text/font/FontFamily;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "OracleTextView", "text", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "noRippleClickable", "Landroidx/compose/ui/Modifier;", "onClick", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "app_release", "addedCardIds", "currentPage", "hasMorePages", "totalCards", "isLoadingMore", "showingBack", "showOracleDialog", "flipRotation", "", "displayFaceIndex", "showMenu"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CardRecommendationsPagerActivityKt {
    private static final Set<String> DFC_LAYOUTS = SetsKt.setOf((Object[]) new String[]{"modal_dfc", "transform", "reversible_card", "art_series", "double_faced_token"});

    private static final void CollectionPill(final MTCardCollectionStatus mTCardCollectionStatus, final FontFamily fontFamily, Composer composer, final int i) {
        int i2;
        final int i3;
        Composer composer2;
        Function2<? super Composer, ? super Integer, Unit> function2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String list_name;
        long jColor;
        String str;
        String deck_name;
        Composer composerStartRestartGroup = composer.startRestartGroup(170745405);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionPill)N(coll,beVietnamFont)734@30357L616:CardRecommendationsPagerActivity.kt#r9tj48");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changedInstance(mTCardCollectionStatus) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(fontFamily) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(170745405, i2, -1, "com.studiolaganne.lengendarylens.CollectionPill (CardRecommendationsPagerActivity.kt:713)");
            }
            if ((!Intrinsics.areEqual((Object) mTCardCollectionStatus.getIn_use(), (Object) true) || (deck_name = mTCardCollectionStatus.getDeck_name()) == null || StringsKt.isBlank(deck_name)) ? false : true) {
                composerStartRestartGroup.startReplaceGroup(1435334574);
                composerStartRestartGroup.endReplaceGroup();
                list_name = mTCardCollectionStatus.getDeck_name();
                Intrinsics.checkNotNull(list_name);
                jColor = ColorKt.Color(4290527000L);
                str = "\uf071";
            } else {
                String list_name2 = mTCardCollectionStatus.getList_name();
                if (list_name2 == null || StringsKt.isBlank(list_name2)) {
                    composerStartRestartGroup.startReplaceGroup(1435723903);
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        function2 = new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CardRecommendationsPagerActivityKt.CollectionPill$lambda$0(mTCardCollectionStatus, fontFamily, i, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        scopeUpdateScopeEndRestartGroup.updateScope(function2);
                    }
                    return;
                }
                composerStartRestartGroup.startReplaceGroup(1435499277);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                list_name = mTCardCollectionStatus.getList_name();
                Intrinsics.checkNotNull(list_name);
                if (Intrinsics.areEqual(list_name, "bulk")) {
                    composerStartRestartGroup.startReplaceGroup(877593055);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "727@30194L34");
                    list_name = StringResources_androidKt.stringResource(R.string.list_bulk, composerStartRestartGroup, 0);
                } else {
                    composerStartRestartGroup.startReplaceGroup(877594308);
                }
                composerStartRestartGroup.endReplaceGroup();
                jColor = ColorKt.Color(4279334724L);
                composerStartRestartGroup.endReplaceGroup();
                str = "\uf00c";
            }
            String str2 = str;
            Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(BackgroundKt.m1483backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(6.0f))), jColor, null, 2, null), Dp.m9114constructorimpl(10.0f), Dp.m9114constructorimpl(5.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -790246413, "C741@30600L215,748@30824L143:CardRecommendationsPagerActivity.kt#r9tj48");
            TextKt.m4288TextNvy7gAk(str2, PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9114constructorimpl(6.0f), 0.0f, 11, null), Color.INSTANCE.m6362getWhite0d7_KjU(), null, TextUnitKt.getSp(10), null, null, FontFamilyKt.FontFamily(FontKt.m8649FontYpTlLL0$default(R.font.fa6solid, null, 0, 0, 14, null)), 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 25008, 0, 261992);
            TextKt.m4288TextNvy7gAk(list_name, null, Color.INSTANCE.m6362getWhite0d7_KjU(), null, TextUnitKt.getSp(12), null, null, fontFamily, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, (29360128 & (i2 << 18)) | 24960, 0, 261994);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i3 = i;
        } else {
            i3 = i;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardRecommendationsPagerActivityKt.CollectionPill$lambda$2(mTCardCollectionStatus, fontFamily, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    static final Unit CollectionPill$lambda$0(MTCardCollectionStatus mTCardCollectionStatus, FontFamily fontFamily, int i, Composer composer, int i2) {
        CollectionPill(mTCardCollectionStatus, fontFamily, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit CollectionPill$lambda$2(MTCardCollectionStatus mTCardCollectionStatus, FontFamily fontFamily, int i, Composer composer, int i2) {
        CollectionPill(mTCardCollectionStatus, fontFamily, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final void OracleTextDialog(final MTFullCard mTFullCard, final FontFamily fontFamily, Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function02;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1096190636);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OracleTextDialog)N(card,beVietnamFont,onDismiss)965@38029L2193,965@37992L2230:CardRecommendationsPagerActivity.kt#r9tj48");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(mTFullCard) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(fontFamily) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1096190636, i2, -1, "com.studiolaganne.lengendarylens.OracleTextDialog (CardRecommendationsPagerActivity.kt:962)");
            }
            final long jColor = ColorKt.Color(4293761623L);
            function02 = function0;
            AndroidDialog_androidKt.Dialog(function02, null, ComposableLambdaKt.rememberComposableLambda(-1342244053, true, new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardRecommendationsPagerActivityKt.OracleTextDialog$lambda$0(jColor, mTFullCard, fontFamily, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 6) & 14) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function02 = function0;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardRecommendationsPagerActivityKt.OracleTextDialog$lambda$1(mTFullCard, fontFamily, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x0374 A[EDGE_INSN: B:95:0x0374->B:79:0x0374 BREAK  A[LOOP:0: B:33:0x01d3->B:99:?]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final Unit OracleTextDialog$lambda$0(long j, MTFullCard mTFullCard, FontFamily fontFamily, Composer composer, int i) {
        String printed_text;
        float f;
        Object obj;
        int i2;
        String str;
        int i3;
        boolean z;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C966@38039L2177:CardRecommendationsPagerActivity.kt#r9tj48");
        int i4 = 1;
        boolean z2 = false;
        if (composer2.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1342244053, i, -1, "com.studiolaganne.lengendarylens.OracleTextDialog.<anonymous> (CardRecommendationsPagerActivity.kt:966)");
            }
            float f2 = 0.0f;
            Object obj2 = null;
            Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(BorderKt.m1494borderxT4_qwU(BackgroundKt.m1482backgroundbw27NRU(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6351getBlack0d7_KjU(), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(12.0f))), Dp.m9114constructorimpl(1.5f), j, RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(12.0f))), Dp.m9114constructorimpl(16.0f));
            ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2037padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1485499580, "C973@38346L21,973@38304L1902:CardRecommendationsPagerActivity.kt#r9tj48");
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierVerticalScroll$default);
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
            ComposerKt.sourceInformationMarkerStart(composer2, -300974928, "C:CardRecommendationsPagerActivity.kt#r9tj48");
            List<MTFace> card_faces = mTFullCard.getCard_faces();
            String str2 = "";
            if (card_faces != null) {
                List<MTFace> list = card_faces;
                if ((list instanceof Collection) && list.isEmpty()) {
                    composer2.startReplaceGroup(-299463276);
                    ComposerKt.sourceInformation(composer2, "");
                    printed_text = mTFullCard.getPrinted_text();
                    if (printed_text == null) {
                        printed_text = "";
                    }
                    if (printed_text.length() <= 0) {
                    }
                    composer2.endReplaceGroup();
                    composer2.endReplaceGroup();
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
                    }
                } else {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MTFace mTFace = (MTFace) it.next();
                        String printed_text2 = mTFace.getPrinted_text();
                        if (printed_text2 == null) {
                            printed_text2 = mTFace.getOracle_text();
                        }
                        String str3 = printed_text2;
                        if (!(str3 == null || StringsKt.isBlank(str3))) {
                            if (card_faces == null || card_faces.size() <= 1) {
                                break;
                            }
                            composer2.startReplaceGroup(-300748753);
                            ComposerKt.sourceInformation(composer2, "");
                            int i5 = 0;
                            for (Object obj3 : card_faces) {
                                int i6 = i5 + 1;
                                if (i5 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                MTFace mTFace2 = (MTFace) obj3;
                                if (i5 > 0) {
                                    composer2.startReplaceGroup(224701821);
                                    ComposerKt.sourceInformation(composer2, "982@38760L41,983@38830L268,989@39127L41");
                                    SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(12.0f)), composer2, 6);
                                    BoxKt.Box(BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f2, i4, obj2), Dp.m9114constructorimpl(1.0f)), Color.m6324copywmQWz5c$default(Color.INSTANCE.m6362getWhite0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composer2, 6);
                                    SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(12.0f)), composer2, 6);
                                } else {
                                    composer2.startReplaceGroup(186266285);
                                }
                                composer2.endReplaceGroup();
                                String printed_name = mTFace2.getPrinted_name();
                                if (printed_name == null && (printed_name = mTFace2.getName()) == null) {
                                    printed_name = str2;
                                }
                                if (printed_name.length() > 0) {
                                    composer2.startReplaceGroup(225286202);
                                    ComposerKt.sourceInformation(composer2, "993@39352L246,999@39627L40");
                                    str = str2;
                                    i2 = i4;
                                    f = f2;
                                    obj = obj2;
                                    TextKt.m4288TextNvy7gAk(printed_name, null, Color.INSTANCE.m6362getWhite0d7_KjU(), null, TextUnitKt.getSp(15), null, null, fontFamily, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24960, 0, 261994);
                                    composer2 = composer;
                                    SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(8.0f)), composer2, 6);
                                    composer2.endReplaceGroup();
                                    i3 = 186266285;
                                } else {
                                    f = f2;
                                    obj = obj2;
                                    i2 = i4;
                                    str = str2;
                                    i3 = 186266285;
                                    composer2.startReplaceGroup(186266285);
                                    composer2.endReplaceGroup();
                                }
                                String printed_text3 = mTFace2.getPrinted_text();
                                if (printed_text3 == null && (printed_text3 = mTFace2.getOracle_text()) == null) {
                                    printed_text3 = str;
                                }
                                if (printed_text3.length() > 0) {
                                    composer2.startReplaceGroup(225779350);
                                    ComposerKt.sourceInformation(composer2, "1003@39858L31");
                                    z = false;
                                    OracleTextView(printed_text3, composer2, 0);
                                } else {
                                    z = false;
                                    composer2.startReplaceGroup(i3);
                                }
                                composer2.endReplaceGroup();
                                z2 = z;
                                i5 = i6;
                                obj2 = obj;
                                f2 = f;
                                i4 = i2;
                                str2 = str;
                            }
                            composer2.endReplaceGroup();
                        }
                    }
                    composer2.startReplaceGroup(-299463276);
                    ComposerKt.sourceInformation(composer2, "");
                    printed_text = mTFullCard.getPrinted_text();
                    if (printed_text == null && (printed_text = mTFullCard.getOracle_text()) == null) {
                        printed_text = "";
                    }
                    if (printed_text.length() <= 0) {
                        composer2.startReplaceGroup(-299336982);
                        ComposerKt.sourceInformation(composer2, "1009@40119L33");
                        OracleTextView(printed_text, composer2, 0);
                    } else {
                        composer2.startReplaceGroup(-339112741);
                    }
                    composer2.endReplaceGroup();
                    composer2.endReplaceGroup();
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
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit OracleTextDialog$lambda$1(MTFullCard mTFullCard, FontFamily fontFamily, Function0 function0, int i, Composer composer, int i2) {
        OracleTextDialog(mTFullCard, fontFamily, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final void OracleTextView(final String str, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1288001975);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OracleTextView)N(text)1020@40316L674,1019@40285L755:CardRecommendationsPagerActivity.kt#r9tj48");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1288001975, i2, -1, "com.studiolaganne.lengendarylens.OracleTextView (CardRecommendationsPagerActivity.kt:1018)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 819319641, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            boolean z = (i2 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CardRecommendationsPagerActivityKt.OracleTextView$lambda$0$0(str, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, composerStartRestartGroup, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardRecommendationsPagerActivityKt.OracleTextView$lambda$1(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView OracleTextView$lambda$0$0(String str, Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        TextView textView = new TextView(ctx);
        textView.setTextColor(-1);
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(ResourcesCompat.getFont(ctx, R.font.be_vietnam_pro_regular));
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setText(new SymbolToImage(ctx).stringToAttributedStringWithSymbols(str, (int) TypedValue.applyDimension(2, 16.0f, ctx.getResources().getDisplayMetrics()), new CharacterStyle[0]), TextView.BufferType.SPANNABLE);
        return textView;
    }

    static final Unit OracleTextView$lambda$1(String str, int i, Composer composer, int i2) {
        OracleTextView(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final void RecommendationActionsRow(boolean z, FontFamily fontFamily, final Function1<? super String, Unit> function1, Composer composer, final int i) {
        int i2;
        final boolean z2;
        final Function1<? super String, Unit> function12;
        final FontFamily fontFamily2;
        Modifier.Companion companionNoRippleClickable;
        final MutableState mutableState;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2004649078);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RecommendationActionsRow)N(isAdded,beVietnamFont,onAddToDeck)863@34697L34,866@34777L2917:CardRecommendationsPagerActivity.kt#r9tj48");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(fontFamily) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2004649078, i2, -1, "com.studiolaganne.lengendarylens.RecommendationActionsRow (CardRecommendationsPagerActivity.kt:862)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1972556492, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long jColor = ColorKt.Color(4292115280L);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1010604200, "C872@34979L765,894@35754L40,897@35850L1838:CardRecommendationsPagerActivity.kt#r9tj48");
            Modifier modifierClip = ClipKt.clip(BackgroundKt.m1482backgroundbw27NRU(Modifier.INSTANCE, z ? Color.m6324copywmQWz5c$default(Color.INSTANCE.m6355getGray0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null) : jColor, RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(8.0f))), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(8.0f)));
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-383031410);
                composerStartRestartGroup.endReplaceGroup();
                companionNoRippleClickable = Modifier.INSTANCE;
            } else {
                composerStartRestartGroup.startReplaceGroup(-383033521);
                ComposerKt.sourceInformation(composerStartRestartGroup, "881@35341L23,881@35323L41");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -383032963, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
                boolean z3 = (i2 & 896) == 256;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CardRecommendationsPagerActivityKt.RecommendationActionsRow$lambda$3$0$0(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionNoRippleClickable = noRippleClickable(companion, (Function0) objRememberedValue2, composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(modifierClip.then(companionNoRippleClickable), Dp.m9114constructorimpl(16.0f), Dp.m9114constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2038paddingVpY3zN4);
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
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1639631293, "C887@35533L43,886@35504L230:CardRecommendationsPagerActivity.kt#r9tj48");
            String strStringResource = StringResources_androidKt.stringResource(R.string.mythic_add_to_deck, composerStartRestartGroup, 0);
            Color.Companion companion2 = Color.INSTANCE;
            int i3 = i2;
            TextKt.m4288TextNvy7gAk(strStringResource, null, z ? companion2.m6355getGray0d7_KjU() : companion2.m6362getWhite0d7_KjU(), null, TextUnitKt.getSp(14), null, null, fontFamily, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, ((i2 << 18) & 29360128) | 24576, 0, 261994);
            fontFamily2 = fontFamily;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(12.0f)), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
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
            Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1516415176, "C899@35906L33,908@36279L267,898@35868L678,919@36646L20,920@36681L997,917@36560L1118:CardRecommendationsPagerActivity.kt#r9tj48");
            boolean z4 = !z;
            Modifier modifierM1482backgroundbw27NRU = BackgroundKt.m1482backgroundbw27NRU(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(40.0f)), z ? Color.m6324copywmQWz5c$default(Color.INSTANCE.m6355getGray0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null) : Color.m6324copywmQWz5c$default(Color.INSTANCE.m6362getWhite0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 603105386, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            boolean z5 = (i3 & 14) == 4;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                z2 = z;
                mutableState = mutableState2;
                objRememberedValue3 = new Function0() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CardRecommendationsPagerActivityKt.RecommendationActionsRow$lambda$3$2$0$0(z2, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                z2 = z;
                mutableState = mutableState2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconButtonKt.IconButton((Function0) objRememberedValue3, modifierM1482backgroundbw27NRU, z4, null, null, null, ComposableLambdaKt.rememberComposableLambda(163852203, true, new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardRecommendationsPagerActivityKt.RecommendationActionsRow$lambda$3$2$1(z2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572864, 56);
            boolean zRecommendationActionsRow$lambda$1 = RecommendationActionsRow$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 603129053, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CardRecommendationsPagerActivityKt.RecommendationActionsRow$lambda$3$2$2$0(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            function12 = function1;
            AndroidMenu_androidKt.m3285DropdownMenuIlH_yew(zRecommendationActionsRow$lambda$1, (Function0) objRememberedValue4, null, 0L, null, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1901490300, true, new Function3() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CardRecommendationsPagerActivityKt.RecommendationActionsRow$lambda$3$2$3(function1, fontFamily2, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 48, 2044);
            composerStartRestartGroup = composerStartRestartGroup;
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
            z2 = z;
            function12 = function1;
            fontFamily2 = fontFamily;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardRecommendationsPagerActivityKt.RecommendationActionsRow$lambda$4(z2, fontFamily2, function12, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean RecommendationActionsRow$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void RecommendationActionsRow$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationActionsRow$lambda$3$0$0(Function1 function1) {
        function1.invoke("main");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationActionsRow$lambda$3$2$0$0(boolean z, MutableState mutableState) {
        if (!z) {
            RecommendationActionsRow$lambda$2(mutableState, true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationActionsRow$lambda$3$2$1(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C909@36297L235:CardRecommendationsPagerActivity.kt#r9tj48");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(163852203, i, -1, "com.studiolaganne.lengendarylens.RecommendationActionsRow.<anonymous>.<anonymous>.<anonymous> (CardRecommendationsPagerActivity.kt:909)");
            }
            FontFamily FontFamily = FontFamilyKt.FontFamily(FontKt.m8649FontYpTlLL0$default(R.font.fa6solid, null, 0, 0, 14, null));
            Color.Companion companion = Color.INSTANCE;
            TextKt.m4288TextNvy7gAk("\uf142", null, z ? companion.m6355getGray0d7_KjU() : companion.m6362getWhite0d7_KjU(), null, TextUnitKt.getSp(16), null, null, FontFamily, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24582, 0, 261994);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationActionsRow$lambda$3$2$2$0(MutableState mutableState) {
        RecommendationActionsRow$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationActionsRow$lambda$3$2$3(final Function1 function1, final FontFamily fontFamily, final MutableState mutableState, ColumnScope DropdownMenu, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C922@36744L266,929@37042L114,921@36699L475,935@37236L265,942@37533L113,934@37191L473:CardRecommendationsPagerActivity.kt#r9tj48");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1901490300, i, -1, "com.studiolaganne.lengendarylens.RecommendationActionsRow.<anonymous>.<anonymous>.<anonymous> (CardRecommendationsPagerActivity.kt:921)");
            }
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1638000812, true, new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardRecommendationsPagerActivityKt.RecommendationActionsRow$lambda$3$2$3$0(fontFamily, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1971065834, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CardRecommendationsPagerActivityKt.RecommendationActionsRow$lambda$3$2$3$1$0(function1, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (Function0) objRememberedValue, null, null, null, false, null, null, null, composer, 6, 508);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1112142219, true, new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardRecommendationsPagerActivityKt.RecommendationActionsRow$lambda$3$2$3$2(fontFamily, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1971050123, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            boolean zChanged2 = composer.changed(function1);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CardRecommendationsPagerActivityKt.RecommendationActionsRow$lambda$3$2$3$3$0(function1, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda2, (Function0) objRememberedValue2, null, null, null, false, null, null, null, composer, 6, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationActionsRow$lambda$3$2$3$0(FontFamily fontFamily, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C924@36811L49,923@36770L218:CardRecommendationsPagerActivity.kt#r9tj48");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1638000812, i, -1, "com.studiolaganne.lengendarylens.RecommendationActionsRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CardRecommendationsPagerActivity.kt:923)");
            }
            TextKt.m4288TextNvy7gAk(StringResources_androidKt.stringResource(R.string.mythic_add_to_maybeboard, composer, 0), null, 0L, null, TextUnitKt.getSp(14), null, null, fontFamily, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24576, 0, 261998);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationActionsRow$lambda$3$2$3$1$0(Function1 function1, MutableState mutableState) {
        RecommendationActionsRow$lambda$2(mutableState, false);
        function1.invoke("maybeboard");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationActionsRow$lambda$3$2$3$2(FontFamily fontFamily, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C937@37303L48,936@37262L217:CardRecommendationsPagerActivity.kt#r9tj48");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1112142219, i, -1, "com.studiolaganne.lengendarylens.RecommendationActionsRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CardRecommendationsPagerActivity.kt:936)");
            }
            TextKt.m4288TextNvy7gAk(StringResources_androidKt.stringResource(R.string.mythic_add_to_sideboard, composer, 0), null, 0L, null, TextUnitKt.getSp(14), null, null, fontFamily, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24576, 0, 261998);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationActionsRow$lambda$3$2$3$3$0(Function1 function1, MutableState mutableState) {
        RecommendationActionsRow$lambda$2(mutableState, false);
        function1.invoke("sideboard");
        return Unit.INSTANCE;
    }

    static final Unit RecommendationActionsRow$lambda$4(boolean z, FontFamily fontFamily, Function1 function1, int i, Composer composer, int i2) {
        RecommendationActionsRow(z, fontFamily, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0216 A[PHI: r11
      0x0216: PHI (r11v31 java.lang.String) = (r11v26 java.lang.String), (r11v28 java.lang.String), (r11v32 java.lang.String) binds: [B:111:0x0220, B:115:0x022a, B:105:0x0213] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x027d A[PHI: r11
      0x027d: PHI (r11v45 java.lang.String) = (r11v40 java.lang.String), (r11v42 java.lang.String), (r11v46 java.lang.String) binds: [B:140:0x0287, B:144:0x0291, B:134:0x027a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RecommendationCardPage(MTFullCard mTFullCard, final boolean z, final FontFamily beVietnamFont, final FontFamily beVietnamRegular, final Function1<? super String, Unit> onAddToDeck, Composer composer, final int i) {
        int i2;
        String lowerCase;
        boolean z2;
        List<MTImageURIs> images;
        boolean z3;
        Object objRememberedValue;
        Object objRememberedValue2;
        Object objRememberedValue3;
        boolean zChanged;
        List<MTImageURIs> images2;
        MTImageURIs mTImageURIs;
        String png;
        String gatherer;
        MTImageURIs mTImageURIs2;
        String gatherer2;
        boolean z4;
        final MTFullCard card = mTFullCard;
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(beVietnamFont, "beVietnamFont");
        Intrinsics.checkNotNullParameter(beVietnamRegular, "beVietnamRegular");
        Intrinsics.checkNotNullParameter(onAddToDeck, "onAddToDeck");
        Composer composerStartRestartGroup = composer.startRestartGroup(2116839201);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RecommendationCardPage)N(card,isAdded,beVietnamFont,beVietnamRegular,onAddToDeck)513@21092L7,514@21131L7,522@21496L34,523@21559L34,525@21619L146,531@21795L64,533@21885L166,537@22075L166,560@22976L6500,555@22791L6685:CardRecommendationsPagerActivity.kt#r9tj48");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(card) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(beVietnamFont) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(beVietnamRegular) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onAddToDeck) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2116839201, i2, -1, "com.studiolaganne.lengendarylens.RecommendationCardPage (CardRecommendationsPagerActivity.kt:512)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float density = ((Density) objConsume2).getDensity();
            String layout = card.getLayout();
            if (layout != null) {
                lowerCase = layout.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            final boolean zAreEqual = Intrinsics.areEqual(lowerCase, "split");
            String type_line = card.getType_line();
            if (type_line != null) {
                String lowerCase2 = type_line.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (lowerCase2 != null) {
                    if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "battle", false, 2, (Object) null)) {
                        z2 = true;
                    }
                    boolean zContains = CollectionsKt.contains(DFC_LAYOUTS, lowerCase);
                    images = card.getImages();
                    if ((images == null ? images.size() : 0) >= 2) {
                        z3 = true;
                        boolean z5 = !zContains && z3;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1532006589, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        final MutableState mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1532004573, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        final MutableState mutableState2 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(!RecommendationCardPage$lambda$1(mutableState) ? 180.0f : 0.0f, AnimationSpecKt.tween$default(500, 0, null, 6, null), 0.0f, "flipRotation", null, composerStartRestartGroup, 3120, 20);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1531996991, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Integer.valueOf(CardRecommendationsPagerActivityKt.RecommendationCardPage$lambda$7$0(stateAnimateFloatAsState));
                                }
                            });
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        final State state = (State) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1531994009, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(card);
                        Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            images2 = card.getImages();
                            if (images2 != null || (mTImageURIs = (MTImageURIs) CollectionsKt.getOrNull(images2, 0)) == null) {
                                List<MTImageURIs> en_images = card.getEn_images();
                                mTImageURIs = en_images == null ? (MTImageURIs) CollectionsKt.getOrNull(en_images, 0) : null;
                            }
                            if (mTImageURIs != null || (png = mTImageURIs.getNormal()) == null) {
                                png = mTImageURIs == null ? mTImageURIs.getPng() : null;
                                if (png != null) {
                                    gatherer = png;
                                    composerStartRestartGroup.updateRememberedValue(gatherer);
                                    objRememberedValue4 = gatherer;
                                } else {
                                    png = mTImageURIs != null ? mTImageURIs.getLarge() : null;
                                    if (png == null) {
                                        gatherer = mTImageURIs != null ? mTImageURIs.getGatherer() : null;
                                    }
                                    composerStartRestartGroup.updateRememberedValue(gatherer);
                                    objRememberedValue4 = gatherer;
                                }
                            }
                        }
                        String str = (String) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1531987929, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
                        boolean zChanged2 = composerStartRestartGroup.changed(card);
                        Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            List<MTImageURIs> images3 = card.getImages();
                            if (images3 == null || (mTImageURIs2 = (MTImageURIs) CollectionsKt.getOrNull(images3, 1)) == null) {
                                List<MTImageURIs> en_images2 = card.getEn_images();
                                mTImageURIs2 = en_images2 != null ? (MTImageURIs) CollectionsKt.getOrNull(en_images2, 1) : null;
                            }
                            if (mTImageURIs2 == null || (png = mTImageURIs2.getNormal()) == null) {
                                String png2 = mTImageURIs2 != null ? mTImageURIs2.getPng() : null;
                                if (png2 != null) {
                                    gatherer2 = png2;
                                    composerStartRestartGroup.updateRememberedValue(gatherer2);
                                    objRememberedValue5 = gatherer2;
                                } else {
                                    png2 = mTImageURIs2 != null ? mTImageURIs2.getLarge() : null;
                                    if (png2 == null) {
                                        gatherer2 = mTImageURIs2 != null ? mTImageURIs2.getGatherer() : null;
                                    }
                                    composerStartRestartGroup.updateRememberedValue(gatherer2);
                                    objRememberedValue5 = gatherer2;
                                }
                            }
                        }
                        String str2 = (String) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (RecommendationCardPage$lambda$8(state) == 1 && str2 != null) {
                            str = str2;
                        }
                        if (str2 != null) {
                            composerStartRestartGroup.startReplaceGroup(-246696404);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "544@22407L72,544@22378L101");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1531977399, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
                            boolean zChangedInstance = composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changed(str2);
                            CardRecommendationsPagerActivityKt$RecommendationCardPage$1$1 cardRecommendationsPagerActivityKt$RecommendationCardPage$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance || cardRecommendationsPagerActivityKt$RecommendationCardPage$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                cardRecommendationsPagerActivityKt$RecommendationCardPage$1$1RememberedValue = new CardRecommendationsPagerActivityKt$RecommendationCardPage$1$1(context, str2, null);
                                composerStartRestartGroup.updateRememberedValue(cardRecommendationsPagerActivityKt$RecommendationCardPage$1$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(str2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) cardRecommendationsPagerActivityKt$RecommendationCardPage$1$1RememberedValue, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-268890079);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        MTCardCollectionStatus collection = card.getCollection();
                        if (collection == null) {
                            MTRecommendationData recommendation = card.getRecommendation();
                            collection = recommendation != null ? recommendation.getCollection() : null;
                        }
                        if (collection != null ? Intrinsics.areEqual((Object) collection.getIn_use(), (Object) true) : false) {
                            String deck_name = collection.getDeck_name();
                            if (!(deck_name == null || StringsKt.isBlank(deck_name))) {
                                z4 = true;
                            }
                            final float f = (!z ? 0.35f : 1.0f) * (z4 ? 0.6f : 1.0f);
                            final long jColor = ColorKt.Color(3435645642L);
                            final long jColor2 = ColorKt.Color(4282819302L);
                            card = mTFullCard;
                            final boolean z6 = z2;
                            final MTCardCollectionStatus mTCardCollectionStatus = collection;
                            int i3 = i2;
                            final String str3 = str;
                            final boolean z7 = z5;
                            composerStartRestartGroup = composerStartRestartGroup;
                            BoxWithConstraintsKt.BoxWithConstraints(PaddingKt.m2038paddingVpY3zN4(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9114constructorimpl(24.0f), Dp.m9114constructorimpl(64.0f)), Alignment.INSTANCE.getCenter(), false, ComposableLambdaKt.rememberComposableLambda(-629409013, true, new Function3() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda31
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CardRecommendationsPagerActivityKt.RecommendationCardPage$lambda$12(card, f, beVietnamFont, jColor2, beVietnamRegular, mTCardCollectionStatus, z, onAddToDeck, zAreEqual, z6, z7, stateAnimateFloatAsState, density, jColor, state, str3, context, mutableState, mutableState2, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3126, 4);
                            if (RecommendationCardPage$lambda$4(mutableState2)) {
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        } else {
                            z4 = false;
                            final float f2 = (!z ? 0.35f : 1.0f) * (z4 ? 0.6f : 1.0f);
                            final long jColor3 = ColorKt.Color(3435645642L);
                            final long jColor22 = ColorKt.Color(4282819302L);
                            card = mTFullCard;
                            final boolean z62 = z2;
                            final MTCardCollectionStatus mTCardCollectionStatus2 = collection;
                            int i32 = i2;
                            final String str32 = str;
                            final boolean z72 = z5;
                            composerStartRestartGroup = composerStartRestartGroup;
                            BoxWithConstraintsKt.BoxWithConstraints(PaddingKt.m2038paddingVpY3zN4(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9114constructorimpl(24.0f), Dp.m9114constructorimpl(64.0f)), Alignment.INSTANCE.getCenter(), false, ComposableLambdaKt.rememberComposableLambda(-629409013, true, new Function3() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda31
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CardRecommendationsPagerActivityKt.RecommendationCardPage$lambda$12(card, f2, beVietnamFont, jColor22, beVietnamRegular, mTCardCollectionStatus2, z, onAddToDeck, zAreEqual, z62, z72, stateAnimateFloatAsState, density, jColor3, state, str32, context, mutableState, mutableState2, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3126, 4);
                            if (RecommendationCardPage$lambda$4(mutableState2)) {
                                composerStartRestartGroup.startReplaceGroup(-268890079);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-239616035);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "707@29624L28,704@29514L148");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1531746499, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
                                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = new Function0() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CardRecommendationsPagerActivityKt.RecommendationCardPage$lambda$13$0(mutableState2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                OracleTextDialog(card, beVietnamFont, (Function0) objRememberedValue6, composerStartRestartGroup, (i32 & 14) | 384 | ((i32 >> 3) & 112));
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    } else {
                        List<MTImageURIs> en_images3 = card.getEn_images();
                        if ((en_images3 != null ? en_images3.size() : 0) < 2) {
                            z3 = false;
                        }
                        if (zContains) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1532006589, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            }
                            final MutableState mutableState3 = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1532004573, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            }
                            final MutableState mutableState22 = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final State stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(!RecommendationCardPage$lambda$1(mutableState3) ? 180.0f : 0.0f, AnimationSpecKt.tween$default(500, 0, null, 6, null), 0.0f, "flipRotation", null, composerStartRestartGroup, 3120, 20);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1531996991, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            }
                            final State state2 = (State) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1531994009, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(card);
                            Object objRememberedValue42 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                images2 = card.getImages();
                                if (images2 != null) {
                                    List<MTImageURIs> en_images4 = card.getEn_images();
                                    if (en_images4 == null) {
                                    }
                                    if (mTImageURIs != null) {
                                        if (mTImageURIs == null) {
                                        }
                                        if (png != null) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                z2 = false;
                boolean zContains2 = CollectionsKt.contains(DFC_LAYOUTS, lowerCase);
                images = card.getImages();
                if ((images == null ? images.size() : 0) >= 2) {
                }
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardRecommendationsPagerActivityKt.RecommendationCardPage$lambda$14(card, z, beVietnamFont, beVietnamRegular, onAddToDeck, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean RecommendationCardPage$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x07e1  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x083e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0860  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0870  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x089b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x08cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final Unit RecommendationCardPage$lambda$12(MTFullCard mTFullCard, final float f, FontFamily fontFamily, long j, FontFamily fontFamily2, MTCardCollectionStatus mTCardCollectionStatus, boolean z, Function1 function1, boolean z2, boolean z3, final boolean z4, final State state, final float f2, long j2, State state2, final String str, final Context context, final MutableState mutableState, final MutableState mutableState2, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i2;
        int i3;
        Composer composer2;
        boolean z5;
        int i4;
        FontFamily fontFamily3;
        int i5;
        int i6;
        MTRecommendationData recommendation;
        Object objRememberedValue;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C568@23443L6027:CardRecommendationsPagerActivity.kt#r9tj48");
        int i7 = (i & 6) == 0 ? i | (composer.changed(BoxWithConstraints) ? 4 : 2) : i;
        if (composer.shouldExecute((i7 & 19) != 18, i7 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-629409013, i7, -1, "com.studiolaganne.lengendarylens.RecommendationCardPage.<anonymous> (CardRecommendationsPagerActivity.kt:564)");
            }
            float fM9128unboximpl = ((Dp) ComparisonsKt.minOf(Dp.m9112boximpl(BoxWithConstraints.mo1933getMaxWidthD9Ej5fM()), Dp.m9112boximpl(Dp.m9114constructorimpl(Dp.m9114constructorimpl(BoxWithConstraints.mo1932getMaxHeightD9Ej5fM() * 0.58f) * 0.71590906f)))).m9128unboximpl();
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1032728476, "C572@23586L4091,655@27691L41,657@27746L267,694@29243L41,695@29297L163:CardRecommendationsPagerActivity.kt#r9tj48");
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 142752738, "C580@24121L296,576@23938L2887:CardRecommendationsPagerActivity.kt#r9tj48");
            boolean z6 = z2 || (z3 && RecommendationCardPage$lambda$8(state2) == 0);
            boolean z7 = z6;
            Modifier modifierAspectRatio$default = AspectRatioKt.aspectRatio$default(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, z6 ? Dp.m9114constructorimpl(fM9128unboximpl * 0.71590906f) : fM9128unboximpl), 0.71590906f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, -2073593545, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            boolean zChanged = composer.changed(z4) | composer.changed(state) | composer.changed(f2);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CardRecommendationsPagerActivityKt.RecommendationCardPage$lambda$12$0$0$0$0(z4, f2, state, (GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierAspectRatio$default, (Function1) objRememberedValue2);
            Modifier.Companion companionRotate = Modifier.INSTANCE;
            if (z7) {
                companionRotate = RotateKt.rotate(companionRotate, 90.0f);
            }
            Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(ClipKt.clip(modifierGraphicsLayer.then(companionRotate), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(20.0f))), ColorKt.Color(4280032284L), null, 2, null);
            Alignment center2 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM1483backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1184135828, "C:CardRecommendationsPagerActivity.kt#r9tj48");
            if (str != null) {
                composer.startReplaceGroup(-1184125785);
                ComposerKt.sourceInformation(composer, "594@24812L293,600@25144L410,593@24761L882");
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composer, 1070182094, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
                boolean zChanged2 = composer.changed(f);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CardRecommendationsPagerActivityKt.RecommendationCardPage$lambda$12$0$0$1$0$0(f, (Context) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                Function1 function12 = (Function1) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1070192835, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
                boolean zChanged3 = composer.changed(f) | composer.changedInstance(context) | composer.changed(str);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CardRecommendationsPagerActivityKt.RecommendationCardPage$lambda$12$0$0$1$1$0(f, context, str, (ImageView) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer2 = composer;
                AndroidView_androidKt.AndroidView(function12, modifierFillMaxSize$default, (Function1) objRememberedValue4, composer2, 48, 0);
                composer2.endReplaceGroup();
                str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str5 = "C72@3469L9:Box.kt#2w3rfo";
                str2 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                str6 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str3 = "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp";
                i2 = 6;
                i3 = 18;
            } else {
                composer.startReplaceGroup(-1183190887);
                ComposerKt.sourceInformation(composer, "611@25697L1088");
                Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical center3 = Arrangement.INSTANCE.getCenter();
                Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(16.0f));
                ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center3, centerHorizontally2, composer, 54);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifierM2037padding3ABfNKs);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor4);
                } else {
                    composer.useNode();
                }
                Composer composerM5595constructorimpl4 = Updater.m5595constructorimpl(composer);
                Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m5599initimpl(composerM5595constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m5601reconcileimpl(composerM5595constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1705727869, "C616@25974L336,623@26339L40,625@26453L49,624@26408L351:CardRecommendationsPagerActivity.kt#r9tj48");
                String printed_name = mTFullCard.getPrinted_name();
                if (printed_name == null && (printed_name = mTFullCard.getName()) == null) {
                    printed_name = "";
                }
                str2 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                str3 = "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp";
                str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str5 = "C72@3469L9:Box.kt#2w3rfo";
                str6 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                i2 = 6;
                i3 = 18;
                TextKt.m4288TextNvy7gAk(printed_name, null, Color.INSTANCE.m6362getWhite0d7_KjU(), null, TextUnitKt.getSp(20), null, null, fontFamily, 0L, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 24960, 0, 260970);
                SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(8.0f)), composer, 6);
                TextKt.m4288TextNvy7gAk(StringResources_androidKt.stringResource(R.string.mythic_image_unavailable, composer, 0), null, Color.INSTANCE.m6355getGray0d7_KjU(), null, TextUnitKt.getSp(12), null, null, fontFamily2, 0L, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 24960, 0, 260970);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (z4) {
                composer2.startReplaceGroup(145845235);
                ComposerKt.sourceInformation(composer2, "642@27239L30,642@27221L48,636@26885L760");
                Modifier modifierClip = ClipKt.clip(BorderKt.m1494borderxT4_qwU(BackgroundKt.m1482backgroundbw27NRU(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(60.0f)), Color.m6324copywmQWz5c$default(Color.INSTANCE.m6351getBlack0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), Dp.m9114constructorimpl(1.0f), Color.m6324copywmQWz5c$default(j2, 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                String str7 = str3;
                ComposerKt.sourceInformationMarkerStart(composer2, -2073494035, str7);
                Object objRememberedValue5 = composer2.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CardRecommendationsPagerActivityKt.RecommendationCardPage$lambda$12$0$0$2$0(mutableState);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierNoRippleClickable = noRippleClickable(modifierClip, (Function0) objRememberedValue5, composer2, 48);
                Alignment center4 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, str2);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, str4);
                int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, modifierNoRippleClickable);
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, str6);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor5);
                } else {
                    composer2.useNode();
                }
                Composer composerM5595constructorimpl5 = Updater.m5595constructorimpl(composer2);
                Updater.m5603setimpl(composerM5595constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m5599initimpl(composerM5595constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m5601reconcileimpl(composerM5595constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m5603setimpl(composerM5595constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, str5);
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -256575679, "C645@27379L244:CardRecommendationsPagerActivity.kt#r9tj48");
                z5 = true;
                str3 = str7;
                TextKt.m4288TextNvy7gAk("\uf01e", null, j2, null, TextUnitKt.getSp(32), null, null, FontFamilyKt.FontFamily(FontKt.m8649FontYpTlLL0$default(R.font.fa6solid, null, 0, 0, 14, null)), 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24966, 0, 261994);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
            } else {
                z5 = true;
                composer2.startReplaceGroup(119171347);
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(16.0f)), composer2, i2);
            String printed_name2 = mTFullCard.getPrinted_name();
            if (printed_name2 == null && (printed_name2 = mTFullCard.getName()) == null) {
                printed_name2 = "";
            }
            String str8 = str3;
            TextKt.m4288TextNvy7gAk(printed_name2, null, Color.m6324copywmQWz5c$default(Color.INSTANCE.m6362getWhite0d7_KjU(), f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(i3), null, null, fontFamily, 0L, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 24576, 0, 260970);
            Composer composer3 = composer;
            String printed_text = mTFullCard.getPrinted_text();
            if (printed_text == null) {
                printed_text = mTFullCard.getOracle_text();
            }
            String str9 = printed_text;
            if (str9 == null || StringsKt.isBlank(str9)) {
                List<MTFace> card_faces = mTFullCard.getCard_faces();
                if (card_faces != null) {
                    List<MTFace> list = card_faces;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        for (MTFace mTFace : list) {
                            String printed_text2 = mTFace.getPrinted_text();
                            if (printed_text2 == null) {
                                printed_text2 = mTFace.getOracle_text();
                            }
                            String str10 = printed_text2;
                            if (!((str10 == null || StringsKt.isBlank(str10)) ? z5 : false)) {
                                composer3.startReplaceGroup(1037176510);
                                ComposerKt.sourceInformation(composer3, "668@28258L40,670@28348L48,674@28612L27,674@28594L45,669@28315L342");
                                SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(4.0f)), composer3, 6);
                                String strStringResource = StringResources_androidKt.stringResource(R.string.mythic_show_oracle_text, composer3, 0);
                                long jM6324copywmQWz5c$default = Color.m6324copywmQWz5c$default(j, f, 0.0f, 0.0f, 0.0f, 14, null);
                                long sp = TextUnitKt.getSp(13);
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 1418942128, str8);
                                objRememberedValue = composer3.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function0() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda19
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CardRecommendationsPagerActivityKt.RecommendationCardPage$lambda$12$0$2$0(mutableState2);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                TextKt.m4288TextNvy7gAk(strStringResource, noRippleClickable(companion2, (Function0) objRememberedValue, composer3, 54), jM6324copywmQWz5c$default, null, sp, null, null, fontFamily2, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24576, 0, 261992);
                                composer3 = composer;
                                composer3.endReplaceGroup();
                                i4 = 1009148077;
                                if (mTCardCollectionStatus != null) {
                                    composer3.startReplaceGroup(1037627002);
                                    ComposerKt.sourceInformation(composer3, "679@28721L40,680@28778L58");
                                    i5 = 6;
                                    SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(8.0f)), composer3, 6);
                                    fontFamily3 = fontFamily;
                                    i6 = 0;
                                    CollectionPill(mTCardCollectionStatus, fontFamily3, composer3, 0);
                                } else {
                                    fontFamily3 = fontFamily;
                                    i5 = 6;
                                    i6 = 0;
                                    composer3.startReplaceGroup(i4);
                                }
                                composer3.endReplaceGroup();
                                recommendation = mTFullCard.getRecommendation();
                                if (recommendation != null) {
                                    composer3.startReplaceGroup(1037850171);
                                    ComposerKt.sourceInformation(composer3, "685@28941L40,686@28998L217");
                                    SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(8.0f)), composer3, i5);
                                    RecommendationInfoRow(recommendation, z, fontFamily3, fontFamily2, composer3, 0);
                                } else {
                                    composer3.startReplaceGroup(i4);
                                }
                                composer3.endReplaceGroup();
                                SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(16.0f)), composer3, i5);
                                RecommendationActionsRow(z, fontFamily3, function1, composer3, i6);
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
                        }
                    }
                    i4 = 1009148077;
                } else {
                    i4 = 1009148077;
                }
                composer3.startReplaceGroup(i4);
                composer3.endReplaceGroup();
                if (mTCardCollectionStatus != null) {
                }
                composer3.endReplaceGroup();
                recommendation = mTFullCard.getRecommendation();
                if (recommendation != null) {
                }
                composer3.endReplaceGroup();
                SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(16.0f)), composer3, i5);
                RecommendationActionsRow(z, fontFamily3, function1, composer3, i6);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ComposerKt.isTraceInProgress()) {
                }
            } else {
                composer3.startReplaceGroup(1037176510);
                ComposerKt.sourceInformation(composer3, "668@28258L40,670@28348L48,674@28612L27,674@28594L45,669@28315L342");
                SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(4.0f)), composer3, 6);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.mythic_show_oracle_text, composer3, 0);
                long jM6324copywmQWz5c$default2 = Color.m6324copywmQWz5c$default(j, f, 0.0f, 0.0f, 0.0f, 14, null);
                long sp2 = TextUnitKt.getSp(13);
                Modifier.Companion companion22 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, 1418942128, str8);
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                TextKt.m4288TextNvy7gAk(strStringResource2, noRippleClickable(companion22, (Function0) objRememberedValue, composer3, 54), jM6324copywmQWz5c$default2, null, sp2, null, null, fontFamily2, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24576, 0, 261992);
                composer3 = composer;
                composer3.endReplaceGroup();
                i4 = 1009148077;
                if (mTCardCollectionStatus != null) {
                }
                composer3.endReplaceGroup();
                recommendation = mTFullCard.getRecommendation();
                if (recommendation != null) {
                }
                composer3.endReplaceGroup();
                SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(16.0f)), composer3, i5);
                RecommendationActionsRow(z, fontFamily3, function1, composer3, i6);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationCardPage$lambda$12$0$0$0$0(boolean z, float f, State state, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        if (z) {
            graphicsLayer.setRotationY(RecommendationCardPage$lambda$6(state));
            graphicsLayer.setCameraDistance(f * 12.0f);
            if (RecommendationCardPage$lambda$6(state) > 90.0f) {
                graphicsLayer.setScaleX(-1.0f);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageView RecommendationCardPage$lambda$12$0$0$1$0$0(float f, Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        ImageView imageView = new ImageView(ctx);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setAlpha(f);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationCardPage$lambda$12$0$0$1$1$0(float f, Context context, String str, ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        imageView.setAlpha(f);
        Glide.with(context).load(str).placeholder(R.drawable.card_back).error(R.drawable.card_back_small_err).into(imageView);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationCardPage$lambda$12$0$0$2$0(MutableState mutableState) {
        RecommendationCardPage$lambda$2(mutableState, !RecommendationCardPage$lambda$1(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationCardPage$lambda$12$0$2$0(MutableState mutableState) {
        RecommendationCardPage$lambda$5(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationCardPage$lambda$13$0(MutableState mutableState) {
        RecommendationCardPage$lambda$5(mutableState, false);
        return Unit.INSTANCE;
    }

    static final Unit RecommendationCardPage$lambda$14(MTFullCard mTFullCard, boolean z, FontFamily fontFamily, FontFamily fontFamily2, Function1 function1, int i, Composer composer, int i2) {
        RecommendationCardPage(mTFullCard, z, fontFamily, fontFamily2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final void RecommendationCardPage$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean RecommendationCardPage$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void RecommendationCardPage$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final float RecommendationCardPage$lambda$6(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int RecommendationCardPage$lambda$7$0(State state) {
        return RecommendationCardPage$lambda$6(state) > 90.0f ? 1 : 0;
    }

    private static final int RecommendationCardPage$lambda$8(State<Integer> state) {
        return state.getValue().intValue();
    }

    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v8, types: [boolean, int] */
    private static final void RecommendationInfoRow(final MTRecommendationData mTRecommendationData, final boolean z, final FontFamily fontFamily, final FontFamily fontFamily2, Composer composer, final int i) {
        MTRecommendationData mTRecommendationData2;
        int i2;
        Composer composer2;
        int i3;
        String str;
        String str2;
        float f;
        float f2;
        String str3;
        int i4;
        String str4;
        String str5;
        boolean z2;
        ?? r3;
        boolean z3;
        boolean z4;
        String strValueOf;
        Composer composerStartRestartGroup = composer.startRestartGroup(1505659177);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RecommendationInfoRow)N(rec,isAdded,beVietnamFont,beVietnamRegular)766@31200L3332:CardRecommendationsPagerActivity.kt#r9tj48");
        if ((i & 6) == 0) {
            mTRecommendationData2 = mTRecommendationData;
            i2 = (composerStartRestartGroup.changedInstance(mTRecommendationData2) ? 4 : 2) | i;
        } else {
            mTRecommendationData2 = mTRecommendationData;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(fontFamily) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(fontFamily2) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1505659177, i2, -1, "com.studiolaganne.lengendarylens.RecommendationInfoRow (CardRecommendationsPagerActivity.kt:763)");
            }
            float f3 = z ? 0.35f : 1.0f;
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1974319514, "C:CardRecommendationsPagerActivity.kt#r9tj48");
            int similarity = (int) mTRecommendationData2.getSimilarity();
            if (similarity > 0) {
                composerStartRestartGroup.startReplaceGroup(1974299921);
                ComposerKt.sourceInformation(composerStartRestartGroup, "775@31505L54,774@31476L248,780@31737L39");
                f = f3;
                i3 = i2;
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                f2 = 8.0f;
                TextKt.m4288TextNvy7gAk(StringResources_androidKt.stringResource(R.string.mythic_similarity, new Object[]{Integer.valueOf(similarity)}, composerStartRestartGroup, 0), null, Color.m6324copywmQWz5c$default(ColorKt.Color(4292115280L), f3, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(13), null, null, fontFamily2, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, ((i2 << 12) & 29360128) | 24576, 0, 261994);
                composer2 = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(8.0f)), composer2, 6);
            } else {
                i3 = i2;
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                f = f3;
                f2 = 8.0f;
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(1943078581);
            }
            composer2.endReplaceGroup();
            if (mTRecommendationData2.getConfidence() >= 3) {
                composer2.startReplaceGroup(1974714670);
                ComposerKt.sourceInformation(composer2, "787@31935L636,802@32588L39");
                long jColor = ColorKt.Color(4281185648L);
                Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(BackgroundKt.m1482backgroundbw27NRU(Modifier.INSTANCE, Color.m6324copywmQWz5c$default(jColor, f * 0.08f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(4.0f))), Dp.m9114constructorimpl(6.0f), Dp.m9114constructorimpl(2.0f));
                ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                String str6 = str2;
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, str6);
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM2038paddingVpY3zN4);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, str);
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
                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m5599initimpl(composerM5595constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m5601reconcileimpl(composerM5595constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 2046511975, "C796@32317L49,795@32280L273:CardRecommendationsPagerActivity.kt#r9tj48");
                int i5 = ((i3 << 15) & 29360128) | 24576;
                i4 = i3;
                str4 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                Composer composer3 = composer2;
                str3 = "C72@3469L9:Box.kt#2w3rfo";
                TextKt.m4288TextNvy7gAk(StringResources_androidKt.stringResource(R.string.mythic_confidence_strong, composer2, 0), null, Color.m6324copywmQWz5c$default(jColor, f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(11), null, null, fontFamily, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, i5, 0, 261994);
                composer2 = composer3;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SpacerKt.Spacer(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(f2)), composer2, 6);
                composer2.endReplaceGroup();
                str5 = str6;
                r3 = 0;
            } else {
                str3 = "C72@3469L9:Box.kt#2w3rfo";
                String str7 = str2;
                i4 = i3;
                str4 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                if (mTRecommendationData2.getConfidence() >= 2) {
                    composer2.startReplaceGroup(1975519120);
                    ComposerKt.sourceInformation(composer2, "806@32746L634,821@33397L39");
                    long jColor2 = ColorKt.Color(4293761623L);
                    Modifier modifierM2038paddingVpY3zN42 = PaddingKt.m2038paddingVpY3zN4(BackgroundKt.m1482backgroundbw27NRU(Modifier.INSTANCE, Color.m6324copywmQWz5c$default(jColor2, f * 0.08f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(4.0f))), Dp.m9114constructorimpl(6.0f), Dp.m9114constructorimpl(2.0f));
                    ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, str4);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, str7);
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierM2038paddingVpY3zN42);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, str);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer2);
                    Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m5599initimpl(composerM5595constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m5601reconcileimpl(composerM5595constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, str3);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -926126048, "C815@33128L47,814@33091L271:CardRecommendationsPagerActivity.kt#r9tj48");
                    Composer composer4 = composer2;
                    z2 = false;
                    str5 = str7;
                    TextKt.m4288TextNvy7gAk(StringResources_androidKt.stringResource(R.string.mythic_confidence_good, composer2, 0), null, Color.m6324copywmQWz5c$default(jColor2, f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(11), null, null, fontFamily, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, ((i4 << 15) & 29360128) | 24576, 0, 261994);
                    composer2 = composer4;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    SpacerKt.Spacer(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(f2)), composer2, 6);
                } else {
                    str5 = str7;
                    z2 = false;
                    composer2.startReplaceGroup(1943078581);
                }
                composer2.endReplaceGroup();
                r3 = z2;
            }
            if (mTRecommendationData.getDeck_count() > 0) {
                composer2.startReplaceGroup(1976341054);
                ComposerKt.sourceInformation(composer2, "831@33732L47,830@33703L242");
                if (mTRecommendationData.getDeck_count() >= 1000) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    z4 = true;
                    strValueOf = String.format(Locale.US, "%.1fK", Arrays.copyOf(new Object[]{Double.valueOf(((double) mTRecommendationData.getDeck_count()) / 1000.0d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(strValueOf, "format(...)");
                } else {
                    z4 = true;
                    strValueOf = String.valueOf(mTRecommendationData.getDeck_count());
                }
                Composer composer5 = composer2;
                z3 = z4;
                TextKt.m4288TextNvy7gAk(StringResources_androidKt.stringResource(R.string.mythic_decks, new Object[]{strValueOf}, composer2, r3), null, Color.m6324copywmQWz5c$default(Color.INSTANCE.m6362getWhite0d7_KjU(), f * 0.6f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(13), null, null, fontFamily2, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer5, ((i4 << 12) & 29360128) | 24576, 0, 261994);
                composer2 = composer5;
            } else {
                z3 = true;
                composer2.startReplaceGroup(1943078581);
            }
            composer2.endReplaceGroup();
            if (Intrinsics.areEqual(mTRecommendationData.getRecent(), Boolean.valueOf(z3))) {
                composer2.startReplaceGroup(1976834450);
                ComposerKt.sourceInformation(composer2, "840@34025L39,841@34077L439");
                SpacerKt.Spacer(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(f2)), composer2, 6);
                Modifier modifierM2038paddingVpY3zN43 = PaddingKt.m2038paddingVpY3zN4(BackgroundKt.m1482backgroundbw27NRU(Modifier.INSTANCE, ColorKt.Color(4292115280L), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(4.0f))), Dp.m9114constructorimpl(6.0f), Dp.m9114constructorimpl(2.0f));
                ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, str4);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r3);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, str5);
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, r3));
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierM2038paddingVpY3zN43);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, str);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor4);
                } else {
                    composer2.useNode();
                }
                Composer composerM5595constructorimpl4 = Updater.m5595constructorimpl(composer2);
                Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m5599initimpl(composerM5595constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m5601reconcileimpl(composerM5595constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, str3);
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 2041493451, "C846@34292L210:CardRecommendationsPagerActivity.kt#r9tj48");
                Composer composer6 = composer2;
                TextKt.m4288TextNvy7gAk("NEW", null, Color.m6324copywmQWz5c$default(Color.INSTANCE.m6362getWhite0d7_KjU(), f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(10), null, null, fontFamily, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer6, ((i4 << 15) & 29360128) | 24582, 0, 261994);
                composer2 = composer6;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
            } else {
                composer2.startReplaceGroup(1943078581);
            }
            composer2.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardRecommendationsPagerActivityKt.RecommendationInfoRow$lambda$1(mTRecommendationData, z, fontFamily, fontFamily2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit RecommendationInfoRow$lambda$1(MTRecommendationData mTRecommendationData, boolean z, FontFamily fontFamily, FontFamily fontFamily2, int i, Composer composer, int i2) {
        RecommendationInfoRow(mTRecommendationData, z, fontFamily, fontFamily2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v14 */
    public static final void RecommendationsPagerScreen(final List<MTFullCard> initialCards, final int i, final String categoryLabel, final Set<String> initialAddedIds, final PagerPaginationState paginationState, final Function0<Unit> onClose, final Function2<? super MTFullCard, ? super String, Unit> onAddToDeck, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        FontFamily fontFamily;
        float f;
        String str;
        String str2;
        MutableState mutableState;
        PagerState pagerState;
        SnapshotStateList snapshotStateList;
        Composer composer3;
        BoxScopeInstance boxScopeInstance;
        String str3;
        String str4;
        FontFamily fontFamily2;
        BoxScopeInstance boxScopeInstance2;
        String str5;
        String str6;
        Composer composer4;
        String str7;
        BoxScopeInstance boxScopeInstance3;
        String str8;
        String str9;
        int i4;
        ?? r13;
        Composer composer5;
        Intrinsics.checkNotNullParameter(initialCards, "initialCards");
        Intrinsics.checkNotNullParameter(categoryLabel, "categoryLabel");
        Intrinsics.checkNotNullParameter(initialAddedIds, "initialAddedIds");
        Intrinsics.checkNotNullParameter(paginationState, "paginationState");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(onAddToDeck, "onAddToDeck");
        Composer composerStartRestartGroup = composer.startRestartGroup(1650211653);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RecommendationsPagerScreen)N(initialCards,startIndex,categoryLabel,initialAddedIds,paginationState,onClose,onAddToDeck)266@11388L7,267@11419L60,269@11505L44,270@11566L78,271@11668L59,272@11752L57,273@11832L50,274@11908L34,378@16297L14,378@16240L72,380@16345L204,380@16318L231,388@16555L4315:CardRecommendationsPagerActivity.kt#r9tj48");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(initialCards) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(categoryLabel) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(initialAddedIds) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(paginationState) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onClose) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onAddToDeck) ? 1048576 : 524288;
        }
        int i5 = i3;
        if (composerStartRestartGroup.shouldExecute((599187 & i5) != 599186, i5 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1650211653, i5, -1, "com.studiolaganne.lengendarylens.RecommendationsPagerScreen (CardRecommendationsPagerActivity.kt:260)");
            }
            long jColor = ColorKt.Color(4280426786L);
            FontFamily FontFamily = FontFamilyKt.FontFamily(FontKt.m8649FontYpTlLL0$default(R.font.be_vietnam_pro_semibold, null, 0, 0, 14, null));
            final FontFamily FontFamily2 = FontFamilyKt.FontFamily(FontKt.m8649FontYpTlLL0$default(R.font.be_vietnam_pro_regular, null, 0, 0, 14, null));
            long jColor2 = ColorKt.Color(4292115280L);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1010484417, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new PreferencesManager(context).getDeviceLanguage();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            String str10 = (String) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1010487153, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialAddedIds, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1010489139, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            Object obj = objRememberedValue3;
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                SnapshotStateList snapshotStateListMutableStateListOf = SnapshotStateKt.mutableStateListOf();
                snapshotStateListMutableStateListOf.addAll(initialCards);
                composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf);
                obj = snapshotStateListMutableStateListOf;
            }
            final SnapshotStateList snapshotStateList2 = (SnapshotStateList) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1010492384, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotIntStateKt.mutableIntStateOf(paginationState.getCurrentPage());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1010495070, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                fontFamily = FontFamily;
                MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(paginationState.getHasMorePages()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                objRememberedValue5 = mutableStateMutableStateOf$default;
            } else {
                fontFamily = FontFamily;
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1010497623, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(paginationState.getTotal(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1010500039, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            MutableState mutableState5 = (MutableState) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (snapshotStateList2.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(1264574046);
                ComposerKt.sourceInformation(composerStartRestartGroup, "363@15780L416");
                Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), jColor, null, 2, null);
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1483backgroundbw27NRU$default);
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
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 547803393, "C368@15961L50,367@15932L254:CardRecommendationsPagerActivity.kt#r9tj48");
                TextKt.m4288TextNvy7gAk(StringResources_androidKt.stringResource(R.string.mythic_no_recommendations, composerStartRestartGroup, 0), null, Color.INSTANCE.m6362getWhite0d7_KjU(), null, TextUnitKt.getSp(18), null, null, fontFamily, 0L, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 260970);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    function2 = new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$21(initialCards, i, categoryLabel, initialAddedIds, paginationState, onClose, onAddToDeck, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    };
                    scopeUpdateScopeEndRestartGroup.updateScope(function2);
                }
                return;
            }
            composerStartRestartGroup.startReplaceGroup(1248915357);
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1010640467, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function0() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(snapshotStateList2.size());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(i, 0.0f, (Function0) objRememberedValue8, composerStartRestartGroup, ((i5 >> 3) & 14) | 384, 2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1010642193, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(pagerStateRememberPagerState) | composerStartRestartGroup.changedInstance(paginationState);
            CardRecommendationsPagerActivityKt$RecommendationsPagerScreen$3$1 cardRecommendationsPagerActivityKt$RecommendationsPagerScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || cardRecommendationsPagerActivityKt$RecommendationsPagerScreen$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                f = 0.0f;
                str = "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp";
                Composer composer6 = composerStartRestartGroup;
                str2 = "C72@3469L9:Box.kt#2w3rfo";
                mutableState = mutableState5;
                pagerState = pagerStateRememberPagerState;
                snapshotStateList = snapshotStateList2;
                cardRecommendationsPagerActivityKt$RecommendationsPagerScreen$3$1RememberedValue = new CardRecommendationsPagerActivityKt$RecommendationsPagerScreen$3$1(pagerStateRememberPagerState, snapshotStateList2, mutableState3, mutableState5, paginationState, mutableIntState, mutableState4, str10, null);
                composer6.updateRememberedValue(cardRecommendationsPagerActivityKt$RecommendationsPagerScreen$3$1RememberedValue);
                composer3 = composer6;
            } else {
                snapshotStateList = snapshotStateList2;
                composer3 = composerStartRestartGroup;
                pagerState = pagerStateRememberPagerState;
                str2 = "C72@3469L9:Box.kt#2w3rfo";
                str = "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp";
                mutableState = mutableState5;
                f = 0.0f;
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) cardRecommendationsPagerActivityKt$RecommendationsPagerScreen$3$1RememberedValue, composer3, 0);
            Modifier modifierM1483backgroundbw27NRU$default2 = BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, f, 1, null), jColor, null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierM1483backgroundbw27NRU$default2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            final SnapshotStateList snapshotStateList3 = snapshotStateList;
            ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor2);
            } else {
                composer3.useNode();
            }
            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer3);
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, str2);
            BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, -1261075670, "C394@16749L535,391@16646L638,410@17313L2201:CardRecommendationsPagerActivity.kt#r9tj48");
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, f, 1, null);
            String str11 = str2;
            final FontFamily fontFamily3 = fontFamily;
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1965029776, true, new Function4() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                    return CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$24$0(snapshotStateList3, fontFamily3, FontFamily2, onAddToDeck, mutableState2, (PagerScope) obj2, ((Integer) obj3).intValue(), (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, composer3, 54);
            PagerState pagerState2 = pagerState;
            Composer composer7 = composer3;
            String str12 = str;
            PagerKt.m2293VerticalPager8jOkeI(pagerState2, modifierFillMaxSize$default, null, null, 0, 0.0f, null, null, false, false, null, null, null, null, composableLambdaRememberComposableLambda, composer7, 48, 24576, 16380);
            Modifier modifierAlign = boxScopeInstance5.align(PaddingKt.m2041paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9114constructorimpl(16.0f), Dp.m9114constructorimpl(64.0f), Dp.m9114constructorimpl(16.0f), 0.0f, 8, null), Alignment.INSTANCE.getTopCenter());
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer7, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer7, 54);
            ComposerKt.sourceInformationMarkerStart(composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer7, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer7.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer7, modifierAlign);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer7.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer7.startReusableNode();
            if (composer7.getInserting()) {
                composer7.createNode(constructor3);
            } else {
                composer7.useNode();
            }
            Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer7);
            Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer7, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer7, -79862978, "C419@17676L85,418@17638L523,435@18175L1329:CardRecommendationsPagerActivity.kt#r9tj48");
            ComposerKt.sourceInformationMarkerStart(composer7, -1942239440, str12);
            boolean zChangedInstance = composer7.changedInstance(paginationState) | ((i5 & 458752) == 131072);
            Object objRememberedValue9 = composer7.rememberedValue();
            if (zChangedInstance || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                boxScopeInstance = boxScopeInstance5;
                Function0 function0 = new Function0() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$24$1$0$0(onClose, paginationState, snapshotStateList3, mutableIntState, mutableState3, mutableState4);
                    }
                };
                composer7.updateRememberedValue(function0);
                objRememberedValue9 = function0;
            } else {
                boxScopeInstance = boxScopeInstance5;
            }
            ComposerKt.sourceInformationMarkerEnd(composer7);
            IconButtonKt.IconButton((Function0) objRememberedValue9, BackgroundKt.m1482backgroundbw27NRU(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(40.0f)), Color.m6324copywmQWz5c$default(Color.INSTANCE.m6351getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape()), false, null, null, null, ComposableSingletons$CardRecommendationsPagerActivityKt.INSTANCE.getLambda$747684541$app_release(), composer7, 1572864, 60);
            Composer composer8 = composer7;
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer8, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, centerVertically2, composer8, 54);
            ComposerKt.sourceInformationMarkerStart(composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer8, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer8.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer8, companion);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer8.startReusableNode();
            if (composer8.getInserting()) {
                composer8.createNode(constructor4);
            } else {
                composer8.useNode();
            }
            Composer composerM5595constructorimpl4 = Updater.m5595constructorimpl(composer8);
            Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer8, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer8, 1153841681, "C453@18977L513:CardRecommendationsPagerActivity.kt#r9tj48");
            if (categoryLabel.length() > 0) {
                composer8.startReplaceGroup(1153856002);
                ComposerKt.sourceInformation(composer8, "440@18397L545");
                Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(BackgroundKt.m1482backgroundbw27NRU(Modifier.INSTANCE, Color.m6324copywmQWz5c$default(Color.INSTANCE.m6351getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(16.0f))), Dp.m9114constructorimpl(12.0f), Dp.m9114constructorimpl(6.0f));
                ComposerKt.sourceInformationMarkerStart(composer8, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer8, 0));
                CompositionLocalMap currentCompositionLocalMap5 = composer8.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer8, modifierM2038paddingVpY3zN4);
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer8.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer8.startReusableNode();
                if (composer8.getInserting()) {
                    composer8.createNode(constructor5);
                } else {
                    composer8.useNode();
                }
                Composer composerM5595constructorimpl5 = Updater.m5595constructorimpl(composer8);
                Updater.m5603setimpl(composerM5595constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m5599initimpl(composerM5595constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m5601reconcileimpl(composerM5595constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m5603setimpl(composerM5595constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer8, 1833054614, str11);
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer8, -1142386448, "C445@18667L253:CardRecommendationsPagerActivity.kt#r9tj48");
                str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str5 = str11;
                str6 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                boxScopeInstance2 = boxScopeInstance;
                str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                TextKt.m4288TextNvy7gAk(categoryLabel, null, Color.m6324copywmQWz5c$default(Color.INSTANCE.m6362getWhite0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(12), null, null, FontFamily2, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer8, ((i5 >> 6) & 14) | 24960, 0, 261994);
                fontFamily2 = FontFamily2;
                Composer composer9 = composer8;
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                composer9.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                composer4 = composer9;
            } else {
                str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                fontFamily2 = FontFamily2;
                boxScopeInstance2 = boxScopeInstance;
                str5 = str11;
                str6 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                composer8.startReplaceGroup(1135608875);
                composer4 = composer8;
            }
            composer4.endReplaceGroup();
            Modifier modifierM2038paddingVpY3zN42 = PaddingKt.m2038paddingVpY3zN4(BackgroundKt.m1482backgroundbw27NRU(Modifier.INSTANCE, Color.m6324copywmQWz5c$default(Color.INSTANCE.m6351getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(16.0f))), Dp.m9114constructorimpl(12.0f), Dp.m9114constructorimpl(6.0f));
            String str13 = str6;
            ComposerKt.sourceInformationMarkerStart(composer4, 1042775818, str13);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            String str14 = str4;
            ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, str14);
            int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composer4.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer4, modifierM2038paddingVpY3zN42);
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
            String str15 = str3;
            ComposerKt.sourceInformationMarkerStart(composer4, -553112988, str15);
            if (!(composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor6);
            } else {
                composer4.useNode();
            }
            Composer composerM5595constructorimpl6 = Updater.m5595constructorimpl(composer4);
            Updater.m5603setimpl(composerM5595constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            String str16 = str5;
            ComposerKt.sourceInformationMarkerStart(composer4, 1833054614, str16);
            BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer4, 1467746269, "C458@19227L245:CardRecommendationsPagerActivity.kt#r9tj48");
            Composer composer10 = composer4;
            FontFamily fontFamily4 = fontFamily2;
            TextKt.m4288TextNvy7gAk((pagerState2.getCurrentPage() + 1) + " / " + snapshotStateList3.size(), null, Color.INSTANCE.m6362getWhite0d7_KjU(), null, TextUnitKt.getSp(14), null, null, fontFamily3, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer10, 24960, 0, 261994);
            Composer composer11 = composer10;
            ComposerKt.sourceInformationMarkerEnd(composer11);
            ComposerKt.sourceInformationMarkerEnd(composer11);
            composer11.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer11);
            ComposerKt.sourceInformationMarkerEnd(composer11);
            ComposerKt.sourceInformationMarkerEnd(composer11);
            ComposerKt.sourceInformationMarkerEnd(composer11);
            ComposerKt.sourceInformationMarkerEnd(composer11);
            composer11.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer11);
            ComposerKt.sourceInformationMarkerEnd(composer11);
            ComposerKt.sourceInformationMarkerEnd(composer11);
            ComposerKt.sourceInformationMarkerEnd(composer11);
            ComposerKt.sourceInformationMarkerEnd(composer11);
            composer11.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer11);
            ComposerKt.sourceInformationMarkerEnd(composer11);
            ComposerKt.sourceInformationMarkerEnd(composer11);
            if (RecommendationsPagerScreen$lambda$15(mutableState)) {
                composer11.startReplaceGroup(-1258258267);
                ComposerKt.sourceInformation(composer11, "470@19615L518");
                boxScopeInstance3 = boxScopeInstance2;
                Modifier modifierM2038paddingVpY3zN43 = PaddingKt.m2038paddingVpY3zN4(BackgroundKt.m1482backgroundbw27NRU(PaddingKt.m2041paddingqDBjuR0$default(boxScopeInstance3.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m9114constructorimpl(32.0f), 7, null), Color.m6324copywmQWz5c$default(Color.INSTANCE.m6351getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(16.0f))), Dp.m9114constructorimpl(16.0f), Dp.m9114constructorimpl(8.0f));
                i4 = 1042775818;
                ComposerKt.sourceInformationMarkerStart(composer11, 1042775818, str13);
                r13 = 0;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                str9 = str14;
                ComposerKt.sourceInformationMarkerStart(composer11, -1159599143, str9);
                int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer11, 0));
                CompositionLocalMap currentCompositionLocalMap7 = composer11.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer11, modifierM2038paddingVpY3zN43);
                Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer11, -553112988, str15);
                if (!(composer11.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer11.startReusableNode();
                if (composer11.getInserting()) {
                    composer11.createNode(constructor7);
                } else {
                    composer11.useNode();
                }
                Composer composerM5595constructorimpl7 = Updater.m5595constructorimpl(composer11);
                Updater.m5603setimpl(composerM5595constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m5599initimpl(composerM5595constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m5601reconcileimpl(composerM5595constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m5603setimpl(composerM5595constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer11, 1833054614, str16);
                BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer11, 712093843, "C477@19941L178:CardRecommendationsPagerActivity.kt#r9tj48");
                str7 = str16;
                str8 = str15;
                ProgressIndicatorKt.m3943CircularProgressIndicator4lLiAd8(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(20.0f)), jColor2, Dp.m9114constructorimpl(2.0f), 0L, 0, 0.0f, composer11, 438, 56);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                composer11.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(composer11);
            } else {
                str7 = str16;
                boxScopeInstance3 = boxScopeInstance2;
                str8 = str15;
                str9 = str14;
                i4 = 1042775818;
                r13 = 0;
                composer11.startReplaceGroup(-1277720253);
            }
            composer11.endReplaceGroup();
            if (RecommendationsPagerScreen$lambda$15(mutableState) || pagerState2.getCurrentPage() != 0 || snapshotStateList3.size() <= 1) {
                composer11.startReplaceGroup(-1277720253);
                composer5 = composer11;
            } else {
                composer11.startReplaceGroup(-1257604539);
                ComposerKt.sourceInformation(composer11, "487@20272L582");
                Modifier modifierM2038paddingVpY3zN44 = PaddingKt.m2038paddingVpY3zN4(BackgroundKt.m1482backgroundbw27NRU(PaddingKt.m2041paddingqDBjuR0$default(boxScopeInstance3.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m9114constructorimpl(32.0f), 7, null), Color.m6324copywmQWz5c$default(Color.INSTANCE.m6351getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(16.0f))), Dp.m9114constructorimpl(16.0f), Dp.m9114constructorimpl(8.0f));
                ComposerKt.sourceInformationMarkerStart(composer11, i4, str13);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r13);
                ComposerKt.sourceInformationMarkerStart(composer11, -1159599143, str9);
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer11, r13));
                CompositionLocalMap currentCompositionLocalMap8 = composer11.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer11, modifierM2038paddingVpY3zN44);
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer11, -553112988, str8);
                if (!(composer11.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer11.startReusableNode();
                if (composer11.getInserting()) {
                    composer11.createNode(constructor8);
                } else {
                    composer11.useNode();
                }
                Composer composerM5595constructorimpl8 = Updater.m5595constructorimpl(composer11);
                Updater.m5603setimpl(composerM5595constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m5599initimpl(composerM5595constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m5601reconcileimpl(composerM5595constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m5603setimpl(composerM5595constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer11, 1833054614, str7);
                BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer11, -2016358518, "C495@20631L42,494@20598L242:CardRecommendationsPagerActivity.kt#r9tj48");
                TextKt.m4288TextNvy7gAk(StringResources_androidKt.stringResource(R.string.mythic_swipe_hint, composer11, r13), null, Color.m6324copywmQWz5c$default(Color.INSTANCE.m6362getWhite0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(12), null, null, fontFamily4, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer11, 24960, 0, 261994);
                Composer composer12 = composer11;
                ComposerKt.sourceInformationMarkerEnd(composer12);
                ComposerKt.sourceInformationMarkerEnd(composer12);
                composer12.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer12);
                ComposerKt.sourceInformationMarkerEnd(composer12);
                ComposerKt.sourceInformationMarkerEnd(composer12);
                composer5 = composer12;
            }
            composer5.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            composer2 = composer5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                composer2 = composer5;
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$25(initialCards, i, categoryLabel, initialAddedIds, paginationState, onClose, onAddToDeck, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RecommendationsPagerScreen$lambda$10(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer RecommendationsPagerScreen$lambda$12(MutableState<Integer> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean RecommendationsPagerScreen$lambda$15(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RecommendationsPagerScreen$lambda$16(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Set<String> RecommendationsPagerScreen$lambda$2(MutableState<Set<String>> mutableState) {
        return mutableState.getValue();
    }

    static final Unit RecommendationsPagerScreen$lambda$21(List list, int i, String str, Set set, PagerPaginationState pagerPaginationState, Function0 function0, Function2 function2, int i2, Composer composer, int i3) {
        RecommendationsPagerScreen(list, i, str, set, pagerPaginationState, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationsPagerScreen$lambda$24$0(SnapshotStateList snapshotStateList, FontFamily fontFamily, FontFamily fontFamily2, final Function2 function2, final MutableState mutableState, PagerScope VerticalPager, int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(VerticalPager, "$this$VerticalPager");
        ComposerKt.sourceInformation(composer, "CN(page)402@17105L155,397@16887L387:CardRecommendationsPagerActivity.kt#r9tj48");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1965029776, i2, -1, "com.studiolaganne.lengendarylens.RecommendationsPagerScreen.<anonymous>.<anonymous> (CardRecommendationsPagerActivity.kt:395)");
        }
        final MTFullCard mTFullCard = (MTFullCard) snapshotStateList.get(i);
        boolean z = mTFullCard.getOracleid() != null && CollectionsKt.contains(RecommendationsPagerScreen$lambda$2(mutableState), mTFullCard.getOracleid());
        ComposerKt.sourceInformationMarkerStart(composer, 1392007051, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
        boolean zChanged = composer.changed(function2) | composer.changedInstance(mTFullCard);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$24$0$0$0(function2, mTFullCard, mutableState, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        RecommendationCardPage(mTFullCard, z, fontFamily, fontFamily2, (Function1) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationsPagerScreen$lambda$24$0$0$0(Function2 function2, MTFullCard mTFullCard, MutableState mutableState, String listType) {
        Intrinsics.checkNotNullParameter(listType, "listType");
        function2.invoke(mTFullCard, listType);
        String oracleid = mTFullCard.getOracleid();
        if (oracleid != null) {
            mutableState.setValue(SetsKt.plus(RecommendationsPagerScreen$lambda$2(mutableState), oracleid));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendationsPagerScreen$lambda$24$1$0$0(Function0 function0, PagerPaginationState pagerPaginationState, SnapshotStateList snapshotStateList, MutableIntState mutableIntState, MutableState mutableState, MutableState mutableState2) {
        RecommendationsPagerScreen$syncBackState(pagerPaginationState, snapshotStateList, mutableIntState, mutableState, mutableState2);
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit RecommendationsPagerScreen$lambda$25(List list, int i, String str, Set set, PagerPaginationState pagerPaginationState, Function0 function0, Function2 function2, int i2, Composer composer, int i3) {
        RecommendationsPagerScreen(list, i, str, set, pagerPaginationState, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int RecommendationsPagerScreen$lambda$6(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean RecommendationsPagerScreen$lambda$9(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RecommendationsPagerScreen$loadNextPage(final PagerPaginationState pagerPaginationState, final MutableState<Boolean> mutableState, final MutableState<Boolean> mutableState2, final MutableIntState mutableIntState, final SnapshotStateList<MTFullCard> snapshotStateList, final MutableState<Integer> mutableState3, String str) {
        if (RecommendationsPagerScreen$lambda$15(mutableState) || !RecommendationsPagerScreen$lambda$9(mutableState2)) {
            return;
        }
        RecommendationsPagerScreen$lambda$16(mutableState, true);
        final int iRecommendationsPagerScreen$lambda$6 = RecommendationsPagerScreen$lambda$6(mutableIntState) + 1;
        if (Intrinsics.areEqual(pagerPaginationState.getMode(), FirebaseAnalytics.Event.SEARCH)) {
            Integer numValueOf = pagerPaginationState.getUserId() > 0 ? Integer.valueOf(pagerPaginationState.getUserId()) : null;
            Integer numValueOf2 = pagerPaginationState.getDeckId() > 0 ? Integer.valueOf(pagerPaginationState.getDeckId()) : null;
            MTApi mtApi = MTApiKt.getMtApi();
            String searchScryfall = pagerPaginationState.getSearchScryfall();
            String searchName = pagerPaginationState.getSearchName();
            Integer numValueOf3 = Integer.valueOf(iRecommendationsPagerScreen$lambda$6);
            String searchOrderBy = pagerPaginationState.getSearchOrderBy();
            String searchOrderDirection = pagerPaginationState.getSearchOrderDirection();
            String searchSimilarTo = pagerPaginationState.getSearchSimilarTo();
            String searchSimilarMode = pagerPaginationState.getSearchSimilarMode();
            String searchFillGap = pagerPaginationState.getSearchFillGap();
            Boolean boolValueOf = Boolean.valueOf(pagerPaginationState.getFromCollection());
            MTApi.searchCards$default(mtApi, searchScryfall, searchName, numValueOf3, 50, null, searchOrderBy, searchOrderDirection, numValueOf2, true, searchSimilarTo, searchSimilarMode, searchFillGap, boolValueOf.booleanValue() ? boolValueOf : null, numValueOf, 16, null).enqueue(new Callback<MTCardsResponse>() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$RecommendationsPagerScreen$loadNextPage$2
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCardsResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$16(mutableState, false);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCardsResponse> call, Response<MTCardsResponse> response) {
                    MTCardsResponse mTCardsResponseBody;
                    Boolean has_next;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    boolean zBooleanValue = false;
                    CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$16(mutableState, false);
                    if (!response.isSuccessful() || (mTCardsResponseBody = response.body()) == null) {
                        return;
                    }
                    List<MTFullCard> cards = mTCardsResponseBody.getCards();
                    if (cards == null) {
                        cards = CollectionsKt.emptyList();
                    }
                    List<MTFullCard> list = cards;
                    snapshotStateList.addAll(list);
                    MutableIntState mutableIntState2 = mutableIntState;
                    MTPagination pagination = mTCardsResponseBody.getPagination();
                    mutableIntState2.setIntValue(pagination != null ? pagination.getPage() : iRecommendationsPagerScreen$lambda$6);
                    MutableState<Integer> mutableState4 = mutableState3;
                    MTPagination pagination2 = mTCardsResponseBody.getPagination();
                    mutableState4.setValue(pagination2 != null ? pagination2.getTotal() : null);
                    MutableState<Boolean> mutableState5 = mutableState2;
                    MTPagination pagination3 = mTCardsResponseBody.getPagination();
                    if (pagination3 != null && (has_next = pagination3.getHas_next()) != null) {
                        zBooleanValue = has_next.booleanValue();
                    } else if (!list.isEmpty()) {
                        zBooleanValue = true;
                    }
                    CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$10(mutableState5, zBooleanValue);
                    CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$syncBackState(pagerPaginationState, snapshotStateList, mutableIntState, mutableState2, mutableState3);
                }
            });
            return;
        }
        if (pagerPaginationState.getDeckId() <= 0 || pagerPaginationState.getCategoryKey().length() == 0) {
            RecommendationsPagerScreen$lambda$16(mutableState, false);
            return;
        }
        String locale = pagerPaginationState.getLocale();
        String str2 = (locale.length() <= 0 || Intrinsics.areEqual(locale, str)) ? null : locale;
        MTApi mtApi2 = MTApiKt.getMtApi();
        int deckId = pagerPaginationState.getDeckId();
        Integer numValueOf4 = null;
        String categoryKey = pagerPaginationState.getCategoryKey();
        Boolean boolValueOf2 = Boolean.valueOf(pagerPaginationState.getFromCollection());
        Boolean bool = boolValueOf2.booleanValue() ? boolValueOf2 : null;
        if (pagerPaginationState.getUserId() > 0) {
            numValueOf4 = Integer.valueOf(pagerPaginationState.getUserId());
        }
        mtApi2.getCardRecommendationsByCategory(deckId, categoryKey, iRecommendationsPagerScreen$lambda$6, bool, str2, numValueOf4).enqueue(new Callback<MTRecommendCategoryResponse>() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$RecommendationsPagerScreen$loadNextPage$4
            @Override // retrofit2.Callback
            public void onFailure(Call<MTRecommendCategoryResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$16(mutableState, false);
            }

            /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
            @Override // retrofit2.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResponse(Call<MTRecommendCategoryResponse> call, Response<MTRecommendCategoryResponse> response) {
                MTRecommendCategoryResponse mTRecommendCategoryResponseBody;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                boolean z = false;
                CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$16(mutableState, false);
                if (!response.isSuccessful() || (mTRecommendCategoryResponseBody = response.body()) == null) {
                    return;
                }
                List<MTFullCard> cards = mTRecommendCategoryResponseBody.getCards();
                if (cards == null) {
                    cards = CollectionsKt.emptyList();
                }
                List<MTFullCard> list = cards;
                snapshotStateList.addAll(list);
                MutableIntState mutableIntState2 = mutableIntState;
                Integer page = mTRecommendCategoryResponseBody.getPage();
                mutableIntState2.setIntValue(page != null ? page.intValue() : iRecommendationsPagerScreen$lambda$6);
                mutableState3.setValue(mTRecommendCategoryResponseBody.getTotal());
                Integer limit = mTRecommendCategoryResponseBody.getLimit();
                int iIntValue = limit != null ? limit.intValue() : cards.size();
                MutableState<Boolean> mutableState4 = mutableState2;
                if (iIntValue > 0 && CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$12(mutableState3) != null) {
                    int iRecommendationsPagerScreen$lambda$62 = CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$6(mutableIntState) * iIntValue;
                    Integer numRecommendationsPagerScreen$lambda$12 = CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$12(mutableState3);
                    Intrinsics.checkNotNull(numRecommendationsPagerScreen$lambda$12);
                    if (iRecommendationsPagerScreen$lambda$62 < numRecommendationsPagerScreen$lambda$12.intValue()) {
                    }
                } else if (!list.isEmpty()) {
                    z = true;
                }
                CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$10(mutableState4, z);
                CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$syncBackState(pagerPaginationState, snapshotStateList, mutableIntState, mutableState2, mutableState3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RecommendationsPagerScreen$syncBackState(PagerPaginationState pagerPaginationState, SnapshotStateList<MTFullCard> snapshotStateList, MutableIntState mutableIntState, MutableState<Boolean> mutableState, MutableState<Integer> mutableState2) {
        pagerPaginationState.setCurrentPage(RecommendationsPagerScreen$lambda$6(mutableIntState));
        pagerPaginationState.setHasMorePages(RecommendationsPagerScreen$lambda$9(mutableState));
        pagerPaginationState.setTotal(RecommendationsPagerScreen$lambda$12(mutableState2));
        pagerPaginationState.setLatestCards(snapshotStateList.toList());
    }

    private static final Modifier noRippleClickable(Modifier modifier, Function0<Unit> function0, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1826346253, "C(noRippleClickable)N(onClick)1040@41156L39:CardRecommendationsPagerActivity.kt#r9tj48");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1826346253, i, -1, "com.studiolaganne.lengendarylens.noRippleClickable (CardRecommendationsPagerActivity.kt:1039)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1522871948, "CC(remember):CardRecommendationsPagerActivity.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierM1514clickableO2vRcR0$default = ClickableKt.m1514clickableO2vRcR0$default(modifier, (MutableInteractionSource) objRememberedValue, null, false, null, null, function0, 28, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modifierM1514clickableO2vRcR0$default;
    }
}
