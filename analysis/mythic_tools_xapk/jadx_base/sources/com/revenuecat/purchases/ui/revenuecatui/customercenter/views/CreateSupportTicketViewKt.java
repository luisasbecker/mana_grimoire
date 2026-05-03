package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import android.util.Patterns;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextFieldColors;
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
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonConfig;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CreateSupportTicketData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CreateSupportTicketView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a-\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\f\u001a;\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0002\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0017\u001a\r\u0010\u0018\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0017\u001a\u001d\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u001b\u001a%\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0003¢\u0006\u0002\u0010\u001f\u001a5\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010$\u001a;\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010)\u001a\u0010\u0010*\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0013H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006+²\u0006\n\u0010&\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010,\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\tX\u008a\u008e\u0002²\u0006\u0010\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030#X\u008a\u0084\u0002²\u0006\u0010\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030#X\u008a\u0084\u0002"}, d2 = {"MAX_DESCRIPTION_LENGTH", "", "CreateSupportTicketContent", "", "emailState", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/EmailInputState;", "descriptionState", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/DescriptionInputState;", "isSubmitting", "", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/EmailInputState;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/DescriptionInputState;ZLcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Landroidx/compose/runtime/Composer;I)V", "CreateSupportTicketView", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CreateSupportTicketData;", "modifier", "Landroidx/compose/ui/Modifier;", "initialEmail", "", "initialDescription", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CreateSupportTicketData;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "CreateSupportTicketView_Preview", "(Landroidx/compose/runtime/Composer;I)V", "CreateSupportTicketView_WithDataPreview", "DescriptionInputField", ServerProtocol.DIALOG_PARAM_STATE, "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/DescriptionInputState;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Landroidx/compose/runtime/Composer;I)V", "EmailInputField", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/EmailInputState;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/runtime/Composer;I)V", "ErrorSnackbar", "hasError", "onErrorShow", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SubmitTicketButton", "email", "description", "onSubmit", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Landroidx/compose/runtime/Composer;I)V", "isValidEmail", "revenuecatui_defaultsBc8Release", "emailDirty", "emailHasFocus", "currentOnSubmit", "currentOnErrorShow"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class CreateSupportTicketViewKt {
    private static final int MAX_DESCRIPTION_LENGTH = 250;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateSupportTicketContent(final EmailInputState emailInputState, final DescriptionInputState descriptionInputState, final boolean z, final CustomerCenterConfigData.Localization localization, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1823655295);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CreateSupportTicketContent)P(1)196@7570L21,192@7441L849:CreateSupportTicketView.kt#870w7w");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(emailInputState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(descriptionInputState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(localization) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1823655295, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketContent (CreateSupportTicketView.kt:191)");
            }
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m2037padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), CustomerCenterConstants.Layout.INSTANCE.m10700getSECTION_SPACINGD9Ej5fM()), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2070388682, "C201@7745L7,198@7610L153,204@7773L64,206@7847L111,211@7968L51,213@8029L255:CreateSupportTicketView.kt#870w7w");
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = (i2 >> 6) & 112;
            EmailInputField(emailInputState, localization, (FocusManager) objConsume, composerStartRestartGroup, (i2 & 14) | i3);
            SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, CustomerCenterConstants.Layout.INSTANCE.m10701getSECTION_TITLE_BOTTOM_PADDINGD9Ej5fM()), composerStartRestartGroup, 6);
            DescriptionInputField(descriptionInputState, localization, composerStartRestartGroup, ((i2 >> 3) & 14) | i3);
            SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, CustomerCenterConstants.Layout.INSTANCE.m10700getSECTION_SPACINGD9Ej5fM()), composerStartRestartGroup, 6);
            SubmitTicketButton(emailInputState.getEmail(), descriptionInputState.getDescription(), z, descriptionInputState.getOnSubmit(), localization, composerStartRestartGroup, (i2 & 896) | ((i2 << 3) & 57344));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.CreateSupportTicketContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    CreateSupportTicketViewKt.CreateSupportTicketContent(emailInputState, descriptionInputState, z, localization, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0206  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void CreateSupportTicketView(final CreateSupportTicketData data, final CustomerCenterConfigData.Localization localization, Modifier modifier, String str, String str2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        String str3;
        int i5;
        String str4;
        Modifier.Companion companion;
        final String str5;
        final String str6;
        boolean z;
        Object objRememberedValue;
        final MutableState mutableState;
        final MutableState mutableState2;
        final MutableState mutableState3;
        boolean z2;
        Object objRememberedValue2;
        final MutableState mutableState4;
        final MutableState mutableState5;
        final MutableState mutableState6;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean zChanged;
        Object objRememberedValue3;
        boolean zChanged2;
        Object objRememberedValue4;
        boolean zChanged3;
        Object objRememberedValue5;
        boolean zChanged4;
        Modifier modifier3;
        int i6;
        MutableState mutableState7;
        final MutableState mutableState8;
        Object obj;
        boolean zChanged5;
        Object objRememberedValue6;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Composer composerStartRestartGroup = composer.startRestartGroup(-600550951);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CreateSupportTicketView)P(!1,3,4,2)61@3000L32,61@2983L49,62@3055L42,63@3123L42,64@3206L38,64@3189L55,65@3269L42,66@3332L42,68@3380L1714:CreateSupportTicketView.kt#870w7w");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(data) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(localization) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
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
                    str3 = str;
                    i3 |= composerStartRestartGroup.changed(str3) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        str4 = str2;
                        i3 |= composerStartRestartGroup.changed(str4) ? 16384 : 8192;
                    }
                    if ((i3 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                        companion = i7 == 0 ? Modifier.INSTANCE : modifier2;
                        str5 = i4 == 0 ? "" : str3;
                        str6 = i5 == 0 ? str4 : "";
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-600550951, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketView (CreateSupportTicketView.kt:60)");
                        }
                        Object[] objArr = new Object[0];
                        composerStartRestartGroup.startReplaceGroup(-1778578414);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                        z = (i3 & 7168) != 2048;
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = (Function0) new Function0<MutableState<String>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$email$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final MutableState<String> invoke() {
                                    return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str5, null, 2, null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        mutableState = (MutableState) RememberSaveableKt.m5765rememberSaveable(objArr, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 0, 6);
                        mutableState2 = (MutableState) RememberSaveableKt.m5765rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<MutableState<Boolean>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$emailDirty$2
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final MutableState<Boolean> invoke() {
                                return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            }
                        }, composerStartRestartGroup, 3072, 6);
                        mutableState3 = (MutableState) RememberSaveableKt.m5765rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<MutableState<Boolean>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$emailHasFocus$2
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final MutableState<Boolean> invoke() {
                                return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            }
                        }, composerStartRestartGroup, 3072, 6);
                        Object[] objArr2 = new Object[0];
                        composerStartRestartGroup.startReplaceGroup(-1778571816);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                        z2 = (57344 & i3) != 16384;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = (Function0) new Function0<MutableState<String>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$description$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final MutableState<String> invoke() {
                                    return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str6, null, 2, null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        mutableState4 = (MutableState) RememberSaveableKt.m5765rememberSaveable(objArr2, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 6);
                        mutableState5 = (MutableState) RememberSaveableKt.m5765rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<MutableState<Boolean>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$isSubmitting$2
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final MutableState<Boolean> invoke() {
                                return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            }
                        }, composerStartRestartGroup, 3072, 6);
                        mutableState6 = (MutableState) RememberSaveableKt.m5765rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<MutableState<Boolean>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$hasError$2
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final MutableState<Boolean> invoke() {
                                return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            }
                        }, composerStartRestartGroup, 3072, 6);
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        boolean z3 = true;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1301361271, "C72@3562L105,76@3702L22,82@3999L169,89@4310L451,69@3429L1440,109@4953L20,107@4879L209:CreateSupportTicketView.kt#870w7w");
                        String strCreateSupportTicketView$lambda$1 = CreateSupportTicketView$lambda$1(mutableState);
                        composerStartRestartGroup.startReplaceGroup(319076762);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = (Function1) new Function1<String, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(String str7) {
                                    invoke2(str7);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(String it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    mutableState.setValue(it);
                                    if (CreateSupportTicketViewKt.CreateSupportTicketView$lambda$3(mutableState2)) {
                                        return;
                                    }
                                    CreateSupportTicketViewKt.CreateSupportTicketView$lambda$4(mutableState2, true);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function1 function1 = (Function1) objRememberedValue3;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(319081159);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(mutableState3);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = (Function1) new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z4) {
                                    CreateSupportTicketViewKt.CreateSupportTicketView$lambda$6(mutableState3, z4);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        Function1 function12 = (Function1) objRememberedValue4;
                        composerStartRestartGroup.endReplaceGroup();
                        EmailInputState emailInputState = new EmailInputState(strCreateSupportTicketView$lambda$1, function1, function12, (CreateSupportTicketView$lambda$3(mutableState2) || CreateSupportTicketView$lambda$5(mutableState3) || isValidEmail(CreateSupportTicketView$lambda$1(mutableState))) ? false : true, !CreateSupportTicketView$lambda$10(mutableState5));
                        String strCreateSupportTicketView$lambda$8 = CreateSupportTicketView$lambda$8(mutableState4);
                        composerStartRestartGroup.startReplaceGroup(319090810);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                        zChanged3 = composerStartRestartGroup.changed(mutableState4);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = (Function1) new Function1<String, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$1$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(String str7) {
                                    invoke2(str7);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(String newValue) {
                                    Intrinsics.checkNotNullParameter(newValue, "newValue");
                                    if (newValue.length() <= 250) {
                                        mutableState4.setValue(newValue);
                                    }
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        Function1 function13 = (Function1) objRememberedValue5;
                        composerStartRestartGroup.endReplaceGroup();
                        boolean z4 = !CreateSupportTicketView$lambda$10(mutableState5);
                        boolean z5 = CreateSupportTicketView$lambda$10(mutableState5) && isValidEmail(StringsKt.trim((CharSequence) CreateSupportTicketView$lambda$1(mutableState)).toString());
                        composerStartRestartGroup.startReplaceGroup(319101044);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                        boolean zChanged6 = composerStartRestartGroup.changed(mutableState5) | composerStartRestartGroup.changed(mutableState6);
                        if ((i3 & 14) != 4) {
                            z3 = false;
                        }
                        zChanged4 = zChanged6 | z3 | composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState4);
                        Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            modifier3 = companion;
                            str4 = str6;
                            i6 = i3;
                            str3 = str5;
                            mutableState7 = mutableState5;
                            mutableState8 = mutableState6;
                            obj = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$1$4$1
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
                                    CreateSupportTicketViewKt.CreateSupportTicketView$lambda$11(mutableState5, true);
                                    CreateSupportTicketViewKt.CreateSupportTicketView$lambda$13(mutableState6, false);
                                    Function4 onSubmit = data.getOnSubmit();
                                    String string = StringsKt.trim((CharSequence) CreateSupportTicketViewKt.CreateSupportTicketView$lambda$1(mutableState)).toString();
                                    String strCreateSupportTicketView$lambda$82 = CreateSupportTicketViewKt.CreateSupportTicketView$lambda$8(mutableState4);
                                    AnonymousClass1 anonymousClass1 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$1$4$1.1
                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                        }
                                    };
                                    final MutableState<Boolean> mutableState9 = mutableState5;
                                    final MutableState<Boolean> mutableState10 = mutableState6;
                                    onSubmit.invoke(string, strCreateSupportTicketView$lambda$82, anonymousClass1, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$1$4$1.2
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
                                            CreateSupportTicketViewKt.CreateSupportTicketView$lambda$11(mutableState9, false);
                                            CreateSupportTicketViewKt.CreateSupportTicketView$lambda$13(mutableState10, true);
                                        }
                                    });
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(obj);
                        } else {
                            mutableState7 = mutableState5;
                            modifier3 = companion;
                            str3 = str5;
                            mutableState8 = mutableState6;
                            obj = objRememberedValue7;
                            i6 = i3;
                            str4 = str6;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        CreateSupportTicketContent(emailInputState, new DescriptionInputState(strCreateSupportTicketView$lambda$8, function13, z4, z5, (Function0) obj), CreateSupportTicketView$lambda$10(mutableState7), localization, composerStartRestartGroup, (i6 << 6) & 7168);
                        boolean zCreateSupportTicketView$lambda$12 = CreateSupportTicketView$lambda$12(mutableState8);
                        composerStartRestartGroup.startReplaceGroup(319121189);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                        zChanged5 = composerStartRestartGroup.changed(mutableState8);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged5 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$1$5$1
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
                                    CreateSupportTicketViewKt.CreateSupportTicketView$lambda$13(mutableState8, false);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ErrorSnackbar(zCreateSupportTicketView$lambda$12, (Function0) objRememberedValue6, localization, boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), composerStartRestartGroup, (i6 << 3) & 896, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                    }
                    final String str7 = str3;
                    final String str8 = str4;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.CreateSupportTicketView.2
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
                                CreateSupportTicketViewKt.CreateSupportTicketView(data, localization, modifier4, str7, str8, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                str4 = str2;
                if ((i3 & 9363) == 9362) {
                    if (i7 == 0) {
                    }
                    if (i4 == 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Object[] objArr3 = new Object[0];
                    composerStartRestartGroup.startReplaceGroup(-1778578414);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                    if ((i3 & 7168) != 2048) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = (Function0) new Function0<MutableState<String>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$email$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final MutableState<String> invoke() {
                                return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str5, null, 2, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableState = (MutableState) RememberSaveableKt.m5765rememberSaveable(objArr3, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 0, 6);
                        mutableState2 = (MutableState) RememberSaveableKt.m5765rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<MutableState<Boolean>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$emailDirty$2
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final MutableState<Boolean> invoke() {
                                return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            }
                        }, composerStartRestartGroup, 3072, 6);
                        mutableState3 = (MutableState) RememberSaveableKt.m5765rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<MutableState<Boolean>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$emailHasFocus$2
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final MutableState<Boolean> invoke() {
                                return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            }
                        }, composerStartRestartGroup, 3072, 6);
                        Object[] objArr22 = new Object[0];
                        composerStartRestartGroup.startReplaceGroup(-1778571816);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                        if ((57344 & i3) != 16384) {
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue2 = (Function0) new Function0<MutableState<String>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$description$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final MutableState<String> invoke() {
                                    return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str6, null, 2, null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableState4 = (MutableState) RememberSaveableKt.m5765rememberSaveable(objArr22, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 6);
                            mutableState5 = (MutableState) RememberSaveableKt.m5765rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<MutableState<Boolean>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$isSubmitting$2
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final MutableState<Boolean> invoke() {
                                    return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                }
                            }, composerStartRestartGroup, 3072, 6);
                            mutableState6 = (MutableState) RememberSaveableKt.m5765rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<MutableState<Boolean>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$hasError$2
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final MutableState<Boolean> invoke() {
                                    return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                }
                            }, composerStartRestartGroup, 3072, 6);
                            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            boolean z32 = true;
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
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1301361271, "C72@3562L105,76@3702L22,82@3999L169,89@4310L451,69@3429L1440,109@4953L20,107@4879L209:CreateSupportTicketView.kt#870w7w");
                                String strCreateSupportTicketView$lambda$12 = CreateSupportTicketView$lambda$1(mutableState);
                                composerStartRestartGroup.startReplaceGroup(319076762);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2);
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged) {
                                    objRememberedValue3 = (Function1) new Function1<String, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(String str72) {
                                            invoke2(str72);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(String it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            mutableState.setValue(it);
                                            if (CreateSupportTicketViewKt.CreateSupportTicketView$lambda$3(mutableState2)) {
                                                return;
                                            }
                                            CreateSupportTicketViewKt.CreateSupportTicketView$lambda$4(mutableState2, true);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    Function1 function14 = (Function1) objRememberedValue3;
                                    composerStartRestartGroup.endReplaceGroup();
                                    composerStartRestartGroup.startReplaceGroup(319081159);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                                    zChanged2 = composerStartRestartGroup.changed(mutableState3);
                                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                    if (!zChanged2) {
                                        objRememberedValue4 = (Function1) new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$1$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                                invoke(bool.booleanValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(boolean z42) {
                                                CreateSupportTicketViewKt.CreateSupportTicketView$lambda$6(mutableState3, z42);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                        Function1 function122 = (Function1) objRememberedValue4;
                                        composerStartRestartGroup.endReplaceGroup();
                                        if (CreateSupportTicketView$lambda$3(mutableState2)) {
                                            EmailInputState emailInputState2 = new EmailInputState(strCreateSupportTicketView$lambda$12, function14, function122, (CreateSupportTicketView$lambda$3(mutableState2) || CreateSupportTicketView$lambda$5(mutableState3) || isValidEmail(CreateSupportTicketView$lambda$1(mutableState))) ? false : true, !CreateSupportTicketView$lambda$10(mutableState5));
                                            String strCreateSupportTicketView$lambda$82 = CreateSupportTicketView$lambda$8(mutableState4);
                                            composerStartRestartGroup.startReplaceGroup(319090810);
                                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                                            zChanged3 = composerStartRestartGroup.changed(mutableState4);
                                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                            if (!zChanged3) {
                                                objRememberedValue5 = (Function1) new Function1<String, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$1$3$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(String str72) {
                                                        invoke2(str72);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(String newValue) {
                                                        Intrinsics.checkNotNullParameter(newValue, "newValue");
                                                        if (newValue.length() <= 250) {
                                                            mutableState4.setValue(newValue);
                                                        }
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                                Function1 function132 = (Function1) objRememberedValue5;
                                                composerStartRestartGroup.endReplaceGroup();
                                                boolean z42 = !CreateSupportTicketView$lambda$10(mutableState5);
                                                if (CreateSupportTicketView$lambda$10(mutableState5)) {
                                                    composerStartRestartGroup.startReplaceGroup(319101044);
                                                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                                                    boolean zChanged62 = composerStartRestartGroup.changed(mutableState5) | composerStartRestartGroup.changed(mutableState6);
                                                    if ((i3 & 14) != 4) {
                                                    }
                                                    zChanged4 = zChanged62 | z32 | composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState4);
                                                    Object objRememberedValue72 = composerStartRestartGroup.rememberedValue();
                                                    if (zChanged4) {
                                                        modifier3 = companion;
                                                        str4 = str6;
                                                        i6 = i3;
                                                        str3 = str5;
                                                        mutableState7 = mutableState5;
                                                        mutableState8 = mutableState6;
                                                        obj = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$1$4$1
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
                                                                CreateSupportTicketViewKt.CreateSupportTicketView$lambda$11(mutableState5, true);
                                                                CreateSupportTicketViewKt.CreateSupportTicketView$lambda$13(mutableState6, false);
                                                                Function4 onSubmit = data.getOnSubmit();
                                                                String string = StringsKt.trim((CharSequence) CreateSupportTicketViewKt.CreateSupportTicketView$lambda$1(mutableState)).toString();
                                                                String strCreateSupportTicketView$lambda$822 = CreateSupportTicketViewKt.CreateSupportTicketView$lambda$8(mutableState4);
                                                                AnonymousClass1 anonymousClass1 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$1$4$1.1
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                                                        invoke2();
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                    public final void invoke2() {
                                                                    }
                                                                };
                                                                final MutableState<Boolean> mutableState9 = mutableState5;
                                                                final MutableState<Boolean> mutableState10 = mutableState6;
                                                                onSubmit.invoke(string, strCreateSupportTicketView$lambda$822, anonymousClass1, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$1$4$1.2
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
                                                                        CreateSupportTicketViewKt.CreateSupportTicketView$lambda$11(mutableState9, false);
                                                                        CreateSupportTicketViewKt.CreateSupportTicketView$lambda$13(mutableState10, true);
                                                                    }
                                                                });
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(obj);
                                                        composerStartRestartGroup.endReplaceGroup();
                                                        CreateSupportTicketContent(emailInputState2, new DescriptionInputState(strCreateSupportTicketView$lambda$82, function132, z42, z5, (Function0) obj), CreateSupportTicketView$lambda$10(mutableState7), localization, composerStartRestartGroup, (i6 << 6) & 7168);
                                                        boolean zCreateSupportTicketView$lambda$122 = CreateSupportTicketView$lambda$12(mutableState8);
                                                        composerStartRestartGroup.startReplaceGroup(319121189);
                                                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                                                        zChanged5 = composerStartRestartGroup.changed(mutableState8);
                                                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                                        if (!zChanged5) {
                                                            objRememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView$1$5$1
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
                                                                    CreateSupportTicketViewKt.CreateSupportTicketView$lambda$13(mutableState8, false);
                                                                }
                                                            };
                                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                                            composerStartRestartGroup.endReplaceGroup();
                                                            ErrorSnackbar(zCreateSupportTicketView$lambda$122, (Function0) objRememberedValue6, localization, boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), composerStartRestartGroup, (i6 << 3) & 896, 0);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            composerStartRestartGroup.endNode();
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                            }
                                                            modifier4 = modifier3;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                final String str72 = str3;
                final String str82 = str4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            str3 = str;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            str4 = str2;
            if ((i3 & 9363) == 9362) {
            }
            final String str722 = str3;
            final String str822 = str4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        str3 = str;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        str4 = str2;
        if ((i3 & 9363) == 9362) {
        }
        final String str7222 = str3;
        final String str8222 = str4;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CreateSupportTicketView$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean CreateSupportTicketView$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateSupportTicketView$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean CreateSupportTicketView$lambda$12(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateSupportTicketView$lambda$13(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CreateSupportTicketView$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateSupportTicketView$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean CreateSupportTicketView$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateSupportTicketView$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CreateSupportTicketView$lambda$8(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateSupportTicketView_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1094842373);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CreateSupportTicketView_Preview)125@5499L329,125@5472L356:CreateSupportTicketView.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1094842373, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketView_Preview (CreateSupportTicketView.kt:119)");
            }
            final CreateSupportTicketData createSupportTicketData = new CreateSupportTicketData(new Function4<String, String, Function0<? extends Unit>, Function0<? extends Unit>, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView_Preview$mockData$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, Function0<? extends Unit> function0, Function0<? extends Unit> function02) {
                    invoke2(str, str2, (Function0<Unit>) function0, (Function0<Unit>) function02);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str, String str2, Function0<Unit> function0, Function0<Unit> function02) {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 1>");
                    Intrinsics.checkNotNullParameter(function0, "<anonymous parameter 2>");
                    Intrinsics.checkNotNullParameter(function02, "<anonymous parameter 3>");
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView_Preview$mockData$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView_Preview$mockData$3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            });
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(-1460784282, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.CreateSupportTicketView_Preview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C129@5619L11,126@5509L313:CreateSupportTicketView.kt#870w7w");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1460784282, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketView_Preview.<anonymous> (CreateSupportTicketView.kt:126)");
                    }
                    Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), null, 2, null);
                    CreateSupportTicketData createSupportTicketData2 = createSupportTicketData;
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1483backgroundbw27NRU$default);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1937963910, "C131@5668L144:CreateSupportTicketView.kt#870w7w");
                    CreateSupportTicketViewKt.CreateSupportTicketView(createSupportTicketData2, CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), null, null, null, composer2, 0, 28);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.CreateSupportTicketView_Preview.2
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
                    CreateSupportTicketViewKt.CreateSupportTicketView_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateSupportTicketView_WithDataPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1452070229);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CreateSupportTicketView_WithDataPreview)147@6153L462,147@6126L489:CreateSupportTicketView.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1452070229, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketView_WithDataPreview (CreateSupportTicketView.kt:141)");
            }
            final CreateSupportTicketData createSupportTicketData = new CreateSupportTicketData(new Function4<String, String, Function0<? extends Unit>, Function0<? extends Unit>, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView_WithDataPreview$mockData$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, Function0<? extends Unit> function0, Function0<? extends Unit> function02) {
                    invoke2(str, str2, (Function0<Unit>) function0, (Function0<Unit>) function02);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str, String str2, Function0<Unit> function0, Function0<Unit> function02) {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 1>");
                    Intrinsics.checkNotNullParameter(function0, "<anonymous parameter 2>");
                    Intrinsics.checkNotNullParameter(function02, "<anonymous parameter 3>");
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView_WithDataPreview$mockData$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView_WithDataPreview$mockData$3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            });
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(1169956790, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.CreateSupportTicketView_WithDataPreview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C151@6273L11,148@6163L446:CreateSupportTicketView.kt#870w7w");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1169956790, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketView_WithDataPreview.<anonymous> (CreateSupportTicketView.kt:148)");
                    }
                    Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), null, 2, null);
                    CreateSupportTicketData createSupportTicketData2 = createSupportTicketData;
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1483backgroundbw27NRU$default);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -541853819, "C153@6322L277:CreateSupportTicketView.kt#870w7w");
                    CreateSupportTicketViewKt.CreateSupportTicketView(createSupportTicketData2, CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), null, "user@example.com", "I'm having an issue with my subscription.", composer2, 27648, 4);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.CreateSupportTicketView_WithDataPreview.2
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
                    CreateSupportTicketViewKt.CreateSupportTicketView_WithDataPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DescriptionInputField(final DescriptionInputState descriptionInputState, final CustomerCenterConfigData.Localization localization, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-202186622);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DescriptionInputField)P(1)285@10373L36,312@11258L75,290@10536L207,297@10770L146,287@10415L936:CreateSupportTicketView.kt#870w7w");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(descriptionInputState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(localization) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-202186622, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.DescriptionInputField (CreateSupportTicketView.kt:278)");
            }
            final String strReplace$default = StringsKt.replace$default(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.CHARACTERS_REMAINING), "{{ count }}", descriptionInputState.getDescription().length() + " / 250", false, 4, (Object) null);
            final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(descriptionInputState.getOnSubmit(), composerStartRestartGroup, 0);
            String description = descriptionInputState.getDescription();
            int i3 = i2;
            Function1<String, Unit> onDescriptionChange = descriptionInputState.getOnDescriptionChange();
            boolean enabled = descriptionInputState.getEnabled();
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9114constructorimpl(200.0f)), "description_field");
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m8744getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
            composerStartRestartGroup.startReplaceGroup(248605445);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateRememberUpdatedState) | ((i3 & 14) == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<KeyboardActionScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$DescriptionInputField$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                        invoke2(keyboardActionScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(KeyboardActionScope $receiver) {
                        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                        if (!descriptionInputState.getShowDone() || StringsKt.isBlank(descriptionInputState.getDescription())) {
                            return;
                        }
                        CreateSupportTicketViewKt.DescriptionInputField$lambda$23(stateRememberUpdatedState).invoke();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            composer2 = composerStartRestartGroup;
            OutlinedTextFieldKt.OutlinedTextField(description, (Function1<? super String, Unit>) onDescriptionChange, modifierTestTag, enabled, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(870248988, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.DescriptionInputField.2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C291@10550L183:CreateSupportTicketView.kt#870w7w");
                    if ((i4 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(870248988, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.DescriptionInputField.<anonymous> (CreateSupportTicketView.kt:291)");
                    }
                    TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.DESCRIPTION), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1857613335, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.DescriptionInputField.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C300@10871L10,298@10784L122:CreateSupportTicketView.kt#870w7w");
                    if ((i4 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1857613335, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.DescriptionInputField.<anonymous> (CreateSupportTicketView.kt:298)");
                    }
                    TextKt.m4286Text4IGK_g(strReplace$default, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodySmall(), composer3, 0, 0, 65534);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), false, (VisualTransformation) null, keyboardOptions, new KeyboardActions((Function1) objRememberedValue, null, null, null, null, null, 62, null), false, 10, 6, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer2, 1573248, 906166656, 0, 7499696);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.DescriptionInputField.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    CreateSupportTicketViewKt.DescriptionInputField(descriptionInputState, localization, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> DescriptionInputField$lambda$23(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EmailInputField(final EmailInputState emailInputState, final CustomerCenterConfigData.Localization localization, final FocusManager focusManager, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(449665849);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EmailInputField)P(2,1)261@9500L88,270@9845L47,232@8569L201,239@8794L207,229@8460L1440:CreateSupportTicketView.kt#870w7w");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(emailInputState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(localization) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(focusManager) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(449665849, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.EmailInputField (CreateSupportTicketView.kt:228)");
            }
            String email = emailInputState.getEmail();
            int i3 = i2;
            Function1<String, Unit> onEmailChange = emailInputState.getOnEmailChange();
            boolean showError = emailInputState.getShowError();
            composerStartRestartGroup.startReplaceGroup(464966584);
            ComposerKt.sourceInformation(composerStartRestartGroup, "248@9098L239");
            ComposableLambda composableLambdaRememberComposableLambda = emailInputState.getShowError() ? ComposableLambdaKt.rememberComposableLambda(-959949005, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.EmailInputField.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C249@9116L207:CreateSupportTicketView.kt#870w7w");
                    if ((i4 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-959949005, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.EmailInputField.<anonymous> (CreateSupportTicketView.kt:249)");
                    }
                    TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.INVALID_EMAIL_ERROR), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54) : null;
            composerStartRestartGroup.endReplaceGroup();
            boolean enabled = emailInputState.getEnabled();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            composerStartRestartGroup.startReplaceGroup(464980338);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
            boolean z = (i3 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<FocusState, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$EmailInputField$2$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                        invoke2(focusState);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(FocusState focusState) {
                        Intrinsics.checkNotNullParameter(focusState, "focusState");
                        emailInputState.getOnFocusChanged().invoke(Boolean.valueOf(focusState.isFocused()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierTestTag = TestTagKt.testTag(FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, (Function1) objRememberedValue), "email_field");
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m8799getEmailPjHm6EE(), ImeAction.INSTANCE.m8746getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
            composerStartRestartGroup.startReplaceGroup(464991337);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(focusManager);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function1) new Function1<KeyboardActionScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$EmailInputField$3$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                        invoke2(keyboardActionScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(KeyboardActionScope $receiver) {
                        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                        focusManager.mo5969moveFocus3ESFkO8(FocusDirection.INSTANCE.m5959getDowndhqQ8s());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceGroup();
            composer2 = composerStartRestartGroup;
            OutlinedTextFieldKt.OutlinedTextField(email, (Function1<? super String, Unit>) onEmailChange, modifierTestTag, enabled, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-664568609, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.EmailInputField.4
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C233@8583L177:CreateSupportTicketView.kt#870w7w");
                    if ((i4 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-664568609, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.EmailInputField.<anonymous> (CreateSupportTicketView.kt:233)");
                    }
                    TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.EMAIL), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1544555872, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.EmailInputField.5
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C240@8808L183:CreateSupportTicketView.kt#870w7w");
                    if ((i4 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1544555872, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.EmailInputField.<anonymous> (CreateSupportTicketView.kt:240)");
                    }
                    TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.ENTER_EMAIL), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, showError, (VisualTransformation) null, keyboardOptions, new KeyboardActions(null, null, (Function1) objRememberedValue2, null, null, null, 59, null), true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer2, 14155776, 12779520, 0, 8146736);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.EmailInputField.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    CreateSupportTicketViewKt.EmailInputField(emailInputState, localization, focusManager, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ErrorSnackbar(final boolean z, final Function0<Unit> function0, final CustomerCenterConfigData.Localization localization, Modifier modifier, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        Modifier modifier2;
        Object objRememberedValue;
        SnackbarHostState snackbarHostState;
        String strCommonLocalizedString;
        State stateRememberUpdatedState;
        boolean zChanged;
        CreateSupportTicketViewKt$ErrorSnackbar$1$1 createSupportTicketViewKt$ErrorSnackbar$1$1RememberedValue;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-777272283);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ErrorSnackbar)P(!1,3)344@12158L32,348@12377L33,350@12441L136,350@12416L161,357@12583L352:CreateSupportTicketView.kt#870w7w");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(localization) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-777272283, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ErrorSnackbar (CreateSupportTicketView.kt:343)");
                }
                composerStartRestartGroup.startReplaceGroup(1117747163);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                snackbarHostState = (SnackbarHostState) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                strCommonLocalizedString = localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.SUPPORT_TICKET_FAILED);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function0, composerStartRestartGroup, (i3 >> 3) & 14);
                Boolean boolValueOf = Boolean.valueOf(z2);
                composerStartRestartGroup.startReplaceGroup(1117756323);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
                int i5 = i3 & 14;
                zChanged = (i5 != 4) | composerStartRestartGroup.changed(strCommonLocalizedString) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                createSupportTicketViewKt$ErrorSnackbar$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || createSupportTicketViewKt$ErrorSnackbar$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    createSupportTicketViewKt$ErrorSnackbar$1$1RememberedValue = new CreateSupportTicketViewKt$ErrorSnackbar$1$1(z2, snackbarHostState, strCommonLocalizedString, stateRememberUpdatedState, null);
                    composerStartRestartGroup.updateRememberedValue(createSupportTicketViewKt$ErrorSnackbar$1$1RememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) createSupportTicketViewKt$ErrorSnackbar$1$1RememberedValue, composerStartRestartGroup, i5);
                Modifier modifier4 = companion;
                SnackbarHostKt.SnackbarHost(snackbarHostState, PaddingKt.m2037padding3ABfNKs(companion, CustomerCenterConstants.Layout.INSTANCE.m10700getSECTION_SPACINGD9Ej5fM()), ComposableSingletons$CreateSupportTicketViewKt.INSTANCE.m10725getLambda1$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 390, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.ErrorSnackbar.2
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
                        CreateSupportTicketViewKt.ErrorSnackbar(z, function0, localization, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
            composerStartRestartGroup.startReplaceGroup(1117747163);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            snackbarHostState = (SnackbarHostState) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            strCommonLocalizedString = localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.SUPPORT_TICKET_FAILED);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function0, composerStartRestartGroup, (i3 >> 3) & 14);
            Boolean boolValueOf2 = Boolean.valueOf(z2);
            composerStartRestartGroup.startReplaceGroup(1117756323);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CreateSupportTicketView.kt#9igjgp");
            int i52 = i3 & 14;
            zChanged = (i52 != 4) | composerStartRestartGroup.changed(strCommonLocalizedString) | composerStartRestartGroup.changed(stateRememberUpdatedState);
            createSupportTicketViewKt$ErrorSnackbar$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                createSupportTicketViewKt$ErrorSnackbar$1$1RememberedValue = new CreateSupportTicketViewKt$ErrorSnackbar$1$1(z2, snackbarHostState, strCommonLocalizedString, stateRememberUpdatedState, null);
                composerStartRestartGroup.updateRememberedValue(createSupportTicketViewKt$ErrorSnackbar$1$1RememberedValue);
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) createSupportTicketViewKt$ErrorSnackbar$1$1RememberedValue, composerStartRestartGroup, i52);
                Modifier modifier42 = companion;
                SnackbarHostKt.SnackbarHost(snackbarHostState, PaddingKt.m2037padding3ABfNKs(companion, CustomerCenterConstants.Layout.INSTANCE.m10700getSECTION_SPACINGD9Ej5fM()), ComposableSingletons$CreateSupportTicketViewKt.INSTANCE.m10725getLambda1$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 390, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier42;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> ErrorSnackbar$lambda$26(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SubmitTicketButton(final String str, final String str2, final boolean z, Function0<Unit> function0, final CustomerCenterConfigData.Localization localization, Composer composer, final int i) {
        int i2;
        Function0<Unit> function02;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1201248039);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubmitTicketButton)P(1!2,4)325@11561L373:CreateSupportTicketView.kt#870w7w");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(localization) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            function02 = function0;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1201248039, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SubmitTicketButton (CreateSupportTicketView.kt:324)");
            }
            function02 = function0;
            SettingsButtonKt.SettingsButton(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.SUBMIT_TICKET), function02, new SettingsButtonConfig((z || !isValidEmail(str) || StringsKt.isBlank(str2)) ? false : true, z), null, null, composerStartRestartGroup, (i2 >> 6) & 112, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0<Unit> function03 = function02;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.SubmitTicketButton.1
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
                    CreateSupportTicketViewKt.SubmitTicketButton(str, str2, z, function03, localization, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final boolean isValidEmail(String str) {
        String str2 = str;
        return !StringsKt.isBlank(str2) && Patterns.EMAIL_ADDRESS.matcher(str2).matches();
    }
}
