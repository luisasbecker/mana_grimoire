package androidx.constraintlayout.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.compose.MotionLayoutScope;
import androidx.constraintlayout.compose.carousel.CarouselSwipeableKt;
import androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$carouselSwipeable$1;
import androidx.constraintlayout.compose.carousel.CarouselSwipeableState;
import androidx.constraintlayout.compose.carousel.FractionalThreshold;
import androidx.constraintlayout.compose.carousel.SwipeableDefaults;
import androidx.constraintlayout.compose.carousel.ThresholdConfig;
import androidx.exifinterface.media.ExifInterface;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MotionCarousel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001af\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a,\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010\u001c\u001aP\u0010\u001d\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001e*\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u001f2(\b\u0004\u0010 \u001a\"\u0012\u0013\u0012\u0011H\u001e¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0002\u0010$\u001ao\u0010%\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001e*\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u001f2G\b\u0004\u0010 \u001aA\u0012\u0013\u0012\u0011H\u001e¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u001d\u0012\u001b\u0012\b\u0012\u00060'R\u00020(0\u001a¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0002\u0010*¨\u0006+²\u0006\n\u0010,\u001a\u00020-X\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020/X\u008a\u008e\u0002²\u0006\n\u00100\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"ItemHolder", "", "i", "", "slotPrefix", "", "showSlot", "", "function", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ILjava/lang/String;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "MotionCarousel", "motionScene", "Landroidx/constraintlayout/compose/MotionScene;", "initialSlotIndex", "numSlots", "backwardTransition", "forwardTransition", "showSlots", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/MotionCarouselScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/constraintlayout/compose/MotionScene;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberStateOfItemsProvider", "Landroidx/compose/runtime/State;", "Landroidx/constraintlayout/compose/MotionItemsProvider;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", FirebaseAnalytics.Param.ITEMS, ExifInterface.GPS_DIRECTION_TRUE, "", "itemContent", "Lkotlin/ParameterName;", "name", "item", "(Landroidx/constraintlayout/compose/MotionCarouselScope;Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "itemsWithProperties", "Lkotlin/Function2;", "Landroidx/constraintlayout/compose/MotionLayoutScope$MotionProperties;", "Landroidx/constraintlayout/compose/MotionLayoutScope;", DiagnosticsEntry.PROPERTIES_KEY, "(Landroidx/constraintlayout/compose/MotionCarouselScope;Ljava/util/List;Lkotlin/jvm/functions/Function4;)V", "constraintlayout-compose_release", "componentWidth", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/constraintlayout/compose/CarouselState;", "currentIndex"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MotionCarouselKt {
    public static final void ItemHolder(final int i, final String str, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1970516035);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemHolder)P(1,3,2)259@10665L83:MotionCarousel.kt#fysre8");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1970516035, i3, -1, "androidx.constraintlayout.compose.ItemHolder (MotionCarousel.kt:250)");
            }
            Modifier modifierLayoutId$default = ConstraintLayoutTagKt.layoutId$default(Modifier.INSTANCE, str + i, null, 2, null);
            if (z) {
                modifierLayoutId$default = BorderKt.m1494borderxT4_qwU(ClipKt.clip(modifierLayoutId$default, RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(20.0f))), Dp.m9114constructorimpl(2.0f), ColorKt.Color(0, 0, 0, 60), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(20.0f)));
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1063080426, "C259@10738L8:MotionCarousel.kt#fysre8");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.ItemHolder.2
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

                public final void invoke(Composer composer2, int i4) {
                    MotionCarouselKt.ItemHolder(i, str, z, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MotionCarousel(final MotionScene motionScene, final int i, final int i2, String str, String str2, String str3, boolean z, final Function1<? super MotionCarouselScope, Unit> function1, Composer composer, final int i3, final int i4) {
        MotionScene motionScene2;
        int i5;
        int i6;
        String str4;
        int i7;
        String str5;
        int i8;
        String str6;
        int i9;
        final boolean z2;
        final int i10;
        Object objRememberedValue;
        String str7;
        float floatValue;
        Object objRememberedValue2;
        Object objRememberedValue3;
        final MutableIntState mutableIntState;
        String str8;
        int i11;
        Map mapMapOf;
        Object objRememberedValue4;
        MutableState mutableState;
        float f;
        String str9;
        float f2;
        final androidx.compose.runtime.State<MotionItemsProvider> state;
        Object objRememberedValue5;
        Object objRememberedValue6;
        Object objRememberedValue7;
        final String str10;
        final String str11;
        MutableState mutableState2;
        MotionCarouselKt$MotionCarousel$1$1 motionCarouselKt$MotionCarousel$1$1;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1035994944);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MotionCarousel)P(4,3,5!1,2,7,6)153@6669L37,155@6734L39,156@6799L47,159@6937L107,162@7069L33,177@7610L46,230@9571L49,215@8950L1326:MotionCarousel.kt#fysre8");
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
            motionScene2 = motionScene;
        } else {
            motionScene2 = motionScene;
            if ((i3 & 6) == 0) {
                i5 = (composerStartRestartGroup.changed(motionScene2) ? 4 : 2) | i3;
            } else {
                i5 = i3;
            }
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
            i6 = i2;
        } else {
            i6 = i2;
            if ((i3 & 384) == 0) {
                i5 |= composerStartRestartGroup.changed(i6) ? 256 : 128;
            }
        }
        int i12 = i4 & 8;
        if (i12 != 0) {
            i5 |= 3072;
        } else {
            if ((i3 & 3072) == 0) {
                str4 = str;
                i5 |= composerStartRestartGroup.changed(str4) ? 2048 : 1024;
            }
            i7 = i4 & 16;
            if (i7 == 0) {
                i5 |= 24576;
            } else {
                if ((i3 & 24576) == 0) {
                    str5 = str2;
                    i5 |= composerStartRestartGroup.changed(str5) ? 16384 : 8192;
                }
                i8 = i4 & 32;
                if (i8 == 0) {
                    if ((196608 & i3) == 0) {
                        str6 = str3;
                        i5 |= composerStartRestartGroup.changed(str6) ? 131072 : 65536;
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        z2 = z;
                    } else {
                        z2 = z;
                        if ((i3 & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changed(z2) ? 1048576 : 524288;
                        }
                    }
                    if ((i4 & 128) == 0) {
                        i5 |= 12582912;
                    } else if ((i3 & 12582912) == 0) {
                        i5 |= composerStartRestartGroup.changedInstance(function1) ? 8388608 : 4194304;
                    }
                    i10 = i5;
                    if ((4793491 & i10) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        String str12 = i12 == 0 ? "backward" : str4;
                        if (i7 != 0) {
                            str5 = "forward";
                        }
                        final String str13 = i8 == 0 ? "slot" : str6;
                        final boolean z3 = i9 == 0 ? false : z2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1035994944, i10, -1, "androidx.constraintlayout.compose.MotionCarousel (MotionCarousel.kt:147)");
                        }
                        androidx.compose.runtime.State<MotionItemsProvider> stateRememberStateOfItemsProvider = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i10 >> 21) & 14);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(1000.0f);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        final MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        String str14 = str5;
                        str7 = str12;
                        CarouselSwipeableState carouselSwipeableStateRememberCarouselSwipeableState = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
                        floatValue = carouselSwipeableStateRememberCarouselSwipeableState.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new CarouselState(MotionCarouselDirection.FORWARD, 0, 0, false, false), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        MutableState mutableState3 = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableIntState = (MutableIntState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (MotionCarousel$lambda$7(mutableIntState) != 0) {
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), "next"));
                        } else if (MotionCarousel$lambda$7(mutableIntState) == stateRememberStateOfItemsProvider.getValue().getItemsCount() - 1) {
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"));
                        } else {
                            str8 = "start";
                            i11 = 2;
                            mapMapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(-MotionCarousel$lambda$1(mutableFloatState)), "previous"), TuplesKt.to(Float.valueOf(0.0f), "start"), TuplesKt.to(Float.valueOf(MotionCarousel$lambda$1(mutableFloatState)), "next"));
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            Map map = mapMapOf;
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str14, null, i11, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            mutableState = (MutableState) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (floatValue >= 0.0f || MotionCarousel$lambda$4(mutableState3).getIndex() <= 0) {
                                MotionCarousel$lambda$4(mutableState3).setDirection(MotionCarouselDirection.FORWARD);
                                mutableState.setValue(str14);
                                f = floatValue;
                            } else {
                                MotionCarousel$lambda$4(mutableState3).setDirection(MotionCarouselDirection.BACKWARD);
                                mutableState.setValue(str7);
                                f = (-1.0f) * floatValue;
                            }
                            composerStartRestartGroup.startReplaceGroup(1162062662);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                                str9 = str14;
                                f2 = f;
                                if (MotionCarousel$lambda$4(mutableState3).getDirection() == MotionCarouselDirection.FORWARD && ((String) carouselSwipeableStateRememberCarouselSwipeableState.getCurrentValue()).equals("next")) {
                                    composerStartRestartGroup.startReplaceGroup(1664382685);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "193@8202L260,193@8181L281");
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162069496, "CC(remember):MotionCarousel.kt#9igjgp");
                                    boolean zChanged = composerStartRestartGroup.changed(stateRememberStateOfItemsProvider) | composerStartRestartGroup.changed(carouselSwipeableStateRememberCarouselSwipeableState);
                                    Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                        state = stateRememberStateOfItemsProvider;
                                        mutableState2 = mutableState3;
                                        motionCarouselKt$MotionCarousel$1$1 = new MotionCarouselKt$MotionCarousel$1$1(stateRememberStateOfItemsProvider, carouselSwipeableStateRememberCarouselSwipeableState, str8, mutableState3, null);
                                        composerStartRestartGroup.updateRememberedValue(motionCarouselKt$MotionCarousel$1$1);
                                    } else {
                                        motionCarouselKt$MotionCarousel$1$1 = objRememberedValue8;
                                        state = stateRememberStateOfItemsProvider;
                                        mutableState2 = mutableState3;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    EffectsKt.LaunchedEffect((Object) true, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) motionCarouselKt$MotionCarousel$1$1, composerStartRestartGroup, 6);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    state = stateRememberStateOfItemsProvider;
                                    String str15 = str8;
                                    mutableState2 = mutableState3;
                                    if (MotionCarousel$lambda$4(mutableState2).getDirection() == MotionCarouselDirection.BACKWARD && ((String) carouselSwipeableStateRememberCarouselSwipeableState.getCurrentValue()).equals("previous")) {
                                        composerStartRestartGroup.startReplaceGroup(1664841950);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "204@8666L227,204@8645L248");
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162084311, "CC(remember):MotionCarousel.kt#9igjgp");
                                        boolean zChanged2 = composerStartRestartGroup.changed(carouselSwipeableStateRememberCarouselSwipeableState);
                                        MotionCarouselKt$MotionCarousel$2$1 motionCarouselKt$MotionCarousel$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChanged2 || motionCarouselKt$MotionCarousel$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                            motionCarouselKt$MotionCarousel$2$1RememberedValue = new MotionCarouselKt$MotionCarousel$2$1(carouselSwipeableStateRememberCarouselSwipeableState, str15, mutableState2, null);
                                            composerStartRestartGroup.updateRememberedValue(motionCarouselKt$MotionCarousel$2$1RememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        EffectsKt.LaunchedEffect((Object) true, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) motionCarouselKt$MotionCarousel$2$1RememberedValue, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1665103342);
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                }
                                mutableIntState.setIntValue(MotionCarousel$lambda$4(mutableState2).getIndex());
                            } else {
                                str9 = str14;
                                f2 = f;
                                state = stateRememberStateOfItemsProvider;
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            String str16 = (String) mutableState.getValue();
                            Modifier modifierM9585carouselSwipeablepPrIpRY = CarouselSwipeableKt.m9585carouselSwipeablepPrIpRY(BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6362getWhite0d7_KjU(), null, 2, null), carouselSwipeableStateRememberCarouselSwipeableState, map, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                                @Override // kotlin.jvm.functions.Function2
                                public final ThresholdConfig invoke(String str17, String str18) {
                                    return new FractionalThreshold(0.3f);
                                }
                            }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m9590getVelocityThresholdD9Ej5fM() : 0.0f);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$4$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                        m9512invokeozmzZPI(intSize.m9289unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                    public final void m9512invokeozmzZPI(long j) {
                                        mutableFloatState.setFloatValue(IntSize.m9285getWidthimpl(j));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierM9585carouselSwipeablepPrIpRY, (Function1) objRememberedValue5);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                            int iM9469getNonebfy_xzQ = DebugFlags.INSTANCE.m9469getNonebfy_xzQ();
                            final InvalidationStrategy defaultInvalidationStrategy = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            final MutableState mutableState4 = (MutableState) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            Object obj = objRememberedValue7;
                            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                Ref ref = new Ref();
                                ref.setValue(CompositionSource.Unknown);
                                composerStartRestartGroup.updateRememberedValue(ref);
                                obj = ref;
                            }
                            final Ref ref2 = (Ref) obj;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final int i13 = i6;
                            Function3<MotionLayoutScope, Composer, Integer, Unit> function3 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                                    invoke(motionLayoutScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i14) {
                                    ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-23317463, i14, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                                    }
                                    mutableState4.setValue(Unit.INSTANCE);
                                    if (defaultInvalidationStrategy.getOnObservedStateChange() == null && ref2.getValue() == CompositionSource.Unknown) {
                                        ref2.setValue(CompositionSource.Content);
                                    }
                                    composer2.startReplaceGroup(-1854403913);
                                    ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                                    composer2.startReplaceGroup(1187106508);
                                    ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                                    int i15 = 0;
                                    while (i15 < i13) {
                                        final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i15) - i;
                                        final boolean z4 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state.getValue()).getItemsCount();
                                        String str17 = str13;
                                        boolean z5 = z3;
                                        final int i16 = i15;
                                        final androidx.compose.runtime.State state2 = state;
                                        final String str18 = str13;
                                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
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

                                            public final void invoke(Composer composer3, int i17) {
                                                ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                                if ((i17 & 3) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2020349941, i17, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                                }
                                                if (z4) {
                                                    if (state2.getValue().hasItemsWithProperties()) {
                                                        composer3.startReplaceGroup(-2023112919);
                                                        ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                        state2.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str18 + i16, composer3, 0)).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    } else {
                                                        composer3.startReplaceGroup(-2022913031);
                                                        ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                        state2.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    }
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer2, 54);
                                        int i17 = i10;
                                        MotionCarouselKt.ItemHolder(i16, str17, z5, composableLambdaRememberComposableLambda, composer2, ((i17 >> 12) & 896) | ((i17 >> 12) & 112) | 3072);
                                        i15 = i16 + 1;
                                    }
                                    composer2.endReplaceGroup();
                                    composer2.endReplaceGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            };
                            String str17 = str13;
                            boolean z4 = z3;
                            MotionLayoutKt.m9528MotionLayoutCoreSehEMGo(motionScene2, f2, str16, 257, iM9469getNonebfy_xzQ, modifierOnSizeChanged, mutableState4, ref2, defaultInvalidationStrategy, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function3, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i10 & 14) | (Ref.$stable << 21));
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str10 = str17;
                            z2 = z4;
                            str11 = str9;
                        }
                        str8 = "start";
                        i11 = 2;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        Map map2 = mapMapOf;
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        }
                        mutableState = (MutableState) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (floatValue >= 0.0f) {
                            MotionCarousel$lambda$4(mutableState3).setDirection(MotionCarouselDirection.FORWARD);
                            mutableState.setValue(str14);
                            f = floatValue;
                            composerStartRestartGroup.startReplaceGroup(1162062662);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            if (carouselSwipeableStateRememberCarouselSwipeableState.isAnimationRunning()) {
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            String str162 = (String) mutableState.getValue();
                            Modifier modifierM9585carouselSwipeablepPrIpRY2 = CarouselSwipeableKt.m9585carouselSwipeablepPrIpRY(BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6362getWhite0d7_KjU(), null, 2, null), carouselSwipeableStateRememberCarouselSwipeableState, map2, Orientation.Horizontal, (424 & 8) != 0, (424 & 16) != 0 ? false : true, (424 & 32) != 0 ? null : null, (424 & 64) != 0 ? CarouselSwipeableKt$carouselSwipeable$1.INSTANCE : new Function2<String, String, ThresholdConfig>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.3
                                @Override // kotlin.jvm.functions.Function2
                                public final ThresholdConfig invoke(String str172, String str18) {
                                    return new FractionalThreshold(0.3f);
                                }
                            }, (424 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map2.keySet(), 0.0f, 0.0f, 6, null) : null, (424 & 256) != 0 ? SwipeableDefaults.INSTANCE.m9590getVelocityThresholdD9Ej5fM() : 0.0f);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162113093, "CC(remember):MotionCarousel.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierOnSizeChanged2 = OnRemeasuredModifierKt.onSizeChanged(modifierM9585carouselSwipeablepPrIpRY2, (Function1) objRememberedValue5);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
                            int iM9469getNonebfy_xzQ2 = DebugFlags.INSTANCE.m9469getNonebfy_xzQ();
                            final InvalidationStrategy defaultInvalidationStrategy2 = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            }
                            final MutableState mutableState42 = (MutableState) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            Object obj2 = objRememberedValue7;
                            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            }
                            final Ref ref22 = (Ref) obj2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final int i132 = i6;
                            Function3<MotionLayoutScope, Composer, Integer, Unit> function32 = new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$$inlined$MotionLayout-6oYECBM$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                                    invoke(motionLayoutScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(final MotionLayoutScope motionLayoutScope, Composer composer2, int i14) {
                                    ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-23317463, i14, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                                    }
                                    mutableState42.setValue(Unit.INSTANCE);
                                    if (defaultInvalidationStrategy2.getOnObservedStateChange() == null && ref22.getValue() == CompositionSource.Unknown) {
                                        ref22.setValue(CompositionSource.Content);
                                    }
                                    composer2.startReplaceGroup(-1854403913);
                                    ComposerKt.sourceInformation(composer2, "C:MotionCarousel.kt#fysre8");
                                    composer2.startReplaceGroup(1187106508);
                                    ComposerKt.sourceInformation(composer2, "*235@9838L422,235@9801L459");
                                    int i15 = 0;
                                    while (i15 < i132) {
                                        final int iMotionCarousel$lambda$7 = (MotionCarouselKt.MotionCarousel$lambda$7(mutableIntState) + i15) - i;
                                        final boolean z42 = iMotionCarousel$lambda$7 >= 0 && iMotionCarousel$lambda$7 < ((MotionItemsProvider) state.getValue()).getItemsCount();
                                        String str172 = str13;
                                        boolean z5 = z3;
                                        final int i16 = i15;
                                        final androidx.compose.runtime.State<? extends MotionItemsProvider> state2 = state;
                                        final String str18 = str13;
                                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2020349941, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$5$1
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

                                            public final void invoke(Composer composer3, int i17) {
                                                ComposerKt.sourceInformation(composer3, "C:MotionCarousel.kt#fysre8");
                                                if ((i17 & 3) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2020349941, i17, -1, "androidx.constraintlayout.compose.MotionCarousel.<anonymous>.<anonymous> (MotionCarousel.kt:236)");
                                                }
                                                if (z42) {
                                                    if (state2.getValue().hasItemsWithProperties()) {
                                                        composer3.startReplaceGroup(-2023112919);
                                                        ComposerKt.sourceInformation(composer3, "238@10004L33,239@10105L8");
                                                        state2.getValue().getContent(iMotionCarousel$lambda$7, motionLayoutScope.motionProperties(str18 + i16, composer3, 0)).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    } else {
                                                        composer3.startReplaceGroup(-2022913031);
                                                        ComposerKt.sourceInformation(composer3, "241@10198L8");
                                                        state2.getValue().getContent(iMotionCarousel$lambda$7).invoke(composer3, 0);
                                                        composer3.endReplaceGroup();
                                                    }
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer2, 54);
                                        int i17 = i10;
                                        MotionCarouselKt.ItemHolder(i16, str172, z5, composableLambdaRememberComposableLambda, composer2, ((i17 >> 12) & 896) | ((i17 >> 12) & 112) | 3072);
                                        i15 = i16 + 1;
                                    }
                                    composer2.endReplaceGroup();
                                    composer2.endReplaceGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            };
                            String str172 = str13;
                            boolean z42 = z3;
                            MotionLayoutKt.m9528MotionLayoutCoreSehEMGo(motionScene2, f2, str162, 257, iM9469getNonebfy_xzQ2, modifierOnSizeChanged2, mutableState42, ref22, defaultInvalidationStrategy2, ComposableLambdaKt.rememberComposableLambda(-23317463, true, function32, composerStartRestartGroup, 54), composerStartRestartGroup, 806879232 | (i10 & 14) | (Ref.$stable << 21));
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            str10 = str172;
                            z2 = z42;
                            str11 = str9;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        str7 = str4;
                        str11 = str5;
                        str10 = str6;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        final String str18 = str7;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.MotionCarousel.6
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

                            public final void invoke(Composer composer2, int i14) {
                                MotionCarouselKt.MotionCarousel(motionScene, i, i2, str18, str11, str10, z2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                            }
                        });
                        return;
                    }
                    return;
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                str6 = str3;
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                if ((i4 & 128) == 0) {
                }
                i10 = i5;
                if ((4793491 & i10) == 4793490) {
                    if (i12 == 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    androidx.compose.runtime.State<MotionItemsProvider> stateRememberStateOfItemsProvider2 = rememberStateOfItemsProvider(function1, composerStartRestartGroup, (i10 >> 21) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162022299, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    final MutableFloatState mutableFloatState2 = (MutableFloatState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String str142 = str5;
                    str7 = str12;
                    CarouselSwipeableState carouselSwipeableStateRememberCarouselSwipeableState2 = CarouselSwipeableKt.rememberCarouselSwipeableState("start", null, null, composerStartRestartGroup, 6, 6);
                    floatValue = carouselSwipeableStateRememberCarouselSwipeableState2.getOffset().getFloatValue() / MotionCarousel$lambda$1(mutableFloatState2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162028863, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    MutableState mutableState32 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162033013, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    }
                    mutableIntState = (MutableIntState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (MotionCarousel$lambda$7(mutableIntState) != 0) {
                    }
                    str8 = "start";
                    i11 = 2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1162050338, "CC(remember):MotionCarousel.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    Map map22 = mapMapOf;
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    }
                    mutableState = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (floatValue >= 0.0f) {
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            str5 = str2;
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            str6 = str3;
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            if ((i4 & 128) == 0) {
            }
            i10 = i5;
            if ((4793491 & i10) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        str4 = str;
        i7 = i4 & 16;
        if (i7 == 0) {
        }
        str5 = str2;
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        str6 = str3;
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        if ((i4 & 128) == 0) {
        }
        i10 = i5;
        if ((4793491 & i10) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final float MotionCarousel$lambda$1(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CarouselState MotionCarousel$lambda$4(MutableState<CarouselState> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MotionCarousel$lambda$7(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    public static final <T> void items(MotionCarouselScope motionCarouselScope, final List<? extends T> list, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3) {
        motionCarouselScope.items(list.size(), ComposableLambdaKt.composableLambdaInstance(85623574, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.items.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer, Integer num2) {
                invoke(num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            public final void invoke(int i, Composer composer, int i2) {
                ComposerKt.sourceInformation(composer, "C278@11161L25:MotionCarousel.kt#fysre8");
                if ((i2 & 6) == 0) {
                    i2 |= composer.changed(i) ? 4 : 2;
                }
                if ((i2 & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(85623574, i2, -1, "androidx.constraintlayout.compose.items.<anonymous> (MotionCarousel.kt:278)");
                }
                function3.invoke((T) list.get(i), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    public static final <T> void itemsWithProperties(MotionCarouselScope motionCarouselScope, final List<? extends T> list, final Function4<? super T, ? super androidx.compose.runtime.State<MotionLayoutScope.MotionProperties>, ? super Composer, ? super Integer, Unit> function4) {
        motionCarouselScope.itemsWithProperties(list.size(), ComposableLambdaKt.composableLambdaInstance(1304172608, true, new Function4<Integer, androidx.compose.runtime.State<? extends MotionLayoutScope.MotionProperties>, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt.itemsWithProperties.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, androidx.compose.runtime.State<? extends MotionLayoutScope.MotionProperties> state, Composer composer, Integer num2) {
                invoke(num.intValue(), (androidx.compose.runtime.State<MotionLayoutScope.MotionProperties>) state, composer, num2.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            public final void invoke(int i, androidx.compose.runtime.State<MotionLayoutScope.MotionProperties> state, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "C302@11988L37:MotionCarousel.kt#fysre8");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(i) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(state) ? 32 : 16;
                }
                if ((i3 & 147) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1304172608, i3, -1, "androidx.constraintlayout.compose.itemsWithProperties.<anonymous> (MotionCarousel.kt:302)");
                }
                function4.invoke((T) list.get(i), state, composer, Integer.valueOf(i3 & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    private static final androidx.compose.runtime.State<MotionItemsProvider> rememberStateOfItemsProvider(Function1<? super MotionCarouselScope, Unit> function1, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1507876322, "C(rememberStateOfItemsProvider)308@12208L29,309@12249L84:MotionCarousel.kt#fysre8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1507876322, i, -1, "androidx.constraintlayout.compose.rememberStateOfItemsProvider (MotionCarousel.kt:307)");
        }
        final androidx.compose.runtime.State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, i & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 1350480360, "CC(remember):MotionCarousel.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<MotionCarouselScopeImpl>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$rememberStateOfItemsProvider$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final MotionCarouselScopeImpl invoke() {
                    MotionCarouselScopeImpl motionCarouselScopeImpl = new MotionCarouselScopeImpl();
                    stateRememberUpdatedState.getValue().invoke(motionCarouselScopeImpl);
                    return motionCarouselScopeImpl;
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        androidx.compose.runtime.State<MotionItemsProvider> state = (androidx.compose.runtime.State) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return state;
    }
}
