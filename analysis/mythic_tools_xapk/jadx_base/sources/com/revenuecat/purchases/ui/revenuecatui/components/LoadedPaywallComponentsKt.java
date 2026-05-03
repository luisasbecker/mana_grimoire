package com.revenuecat.purchases.ui.revenuecatui.components;

import android.content.res.Configuration;
import androidx.camera.video.AudioStats;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TextComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.SimpleSheetState;
import com.revenuecat.purchases.ui.revenuecatui.data.MockPurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.OfferingToStateMapperKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import java.net.URL;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: LoadedPaywallComponents.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0003¢\u0006\u0002\u0010\t\u001aC\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0015\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0012\u001aB\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\"\u0010\u0019\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\fH\u0082@¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002\u001a\r\u0010\u001f\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010 \u001a\u0014\u0010!\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001aE\u0010\"\u001a\u00020\u0001*\u00020#2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\"\u0010%\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\fH\u0002¢\u0006\u0002\u0010&¨\u0006'"}, d2 = {"HeaderOverlayLayout", "", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "modifier", "Landroidx/compose/ui/Modifier;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LoadedPaywallComponents", "clickHandler", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "LoadedPaywallComponents_BottomSheet_FitSize_Preview", "(Landroidx/compose/runtime/Composer;I)V", "LoadedPaywallComponents_BottomSheet_NullSize_Preview", "LoadedPaywallComponents_Preview", "LoadedPaywallComponents_Preview_Bless", "handleClick", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "externalClickHandler", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewBottomSheet", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Sheet;", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "previewHelloWorldPaywallState", "(Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "headerTopPadding", "show", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/SimpleSheetState;", "sheet", "onClick", "(Lcom/revenuecat/purchases/ui/revenuecatui/composables/SimpleSheetState;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Sheet;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class LoadedPaywallComponentsKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_FitSize_Preview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoadedPaywallComponents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_FitSize_Preview$1", f = "LoadedPaywallComponents.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06861 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C06861(Continuation<? super C06861> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06861(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C06861) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_FitSize_Preview$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoadedPaywallComponents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_FitSize_Preview$2", f = "LoadedPaywallComponents.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06872 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
        int label;

        C06872(Continuation<? super C06872> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06872(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
            return ((C06872) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_NullSize_Preview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoadedPaywallComponents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_NullSize_Preview$1", f = "LoadedPaywallComponents.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06881 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C06881(Continuation<? super C06881> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06881(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C06881) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_NullSize_Preview$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoadedPaywallComponents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_NullSize_Preview$2", f = "LoadedPaywallComponents.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06892 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
        int label;

        C06892(Continuation<? super C06892> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06892(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
            return ((C06892) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_Preview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoadedPaywallComponents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_Preview$1", f = "LoadedPaywallComponents.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06911 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
        int label;

        C06911(Continuation<? super C06911> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06911(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
            return ((C06911) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_Preview_Bless$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoadedPaywallComponents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_Preview_Bless$1", f = "LoadedPaywallComponents.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06931 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
        int label;

        C06931(Continuation<? super C06931> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06931(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
            return ((C06931) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$handleClick$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoadedPaywallComponents.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$handleClick$2", f = "LoadedPaywallComponents.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
    static final class C06952 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PaywallAction.External, Continuation<? super Unit>, Object> $externalClickHandler;
        final /* synthetic */ PaywallState.Loaded.Components $state;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C06952(PaywallState.Loaded.Components components, Function2<? super PaywallAction.External, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C06952> continuation) {
            super(2, continuation);
            this.$state = components;
            this.$externalClickHandler = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06952 c06952 = new C06952(this.$state, this.$externalClickHandler, continuation);
            c06952.L$0 = obj;
            return c06952;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C06952) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LoadedPaywallComponentsKt.handleClick((PaywallAction) this.L$0, this.$state, this.$externalClickHandler, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HeaderOverlayLayout(final PaywallState.Loaded.Components components, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(500821026);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HeaderOverlayLayout)P(2,1)147@7295L872,144@7225L942:LoadedPaywallComponents.kt#dnqhhd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(components) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(500821026, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.HeaderOverlayLayout (LoadedPaywallComponents.kt:143)");
            }
            composerStartRestartGroup.startReplaceGroup(40609606);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
            boolean z = (i3 & 14) == 4;
            MeasurePolicy measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$HeaderOverlayLayout$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo1260measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
                        long j2;
                        final Placeable placeableMo7769measureBRTryo0;
                        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                        Intrinsics.checkNotNullParameter(measurables, "measurables");
                        if (measurables.size() > 1) {
                            j2 = j;
                            placeableMo7769measureBRTryo0 = measurables.get(1).mo7769measureBRTryo0(Constraints.m9057copyZbe2FdA$default(j2, 0, 0, 0, 0, 11, null));
                        } else {
                            j2 = j;
                            placeableMo7769measureBRTryo0 = null;
                        }
                        components.setHeaderHeightPx$revenuecatui_defaultsBc8Release(placeableMo7769measureBRTryo0 != null ? placeableMo7769measureBRTryo0.getHeight() : 0);
                        final Placeable placeableMo7769measureBRTryo02 = measurables.get(0).mo7769measureBRTryo0(j2);
                        long j3 = j2;
                        return MeasureScope.layout$default(Layout, Constraints.m9067getMaxWidthimpl(j3), Constraints.m9066getMaxHeightimpl(j3), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$HeaderOverlayLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope layout) {
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                Placeable.PlacementScope.place$default(layout, placeableMo7769measureBRTryo02, 0, 0, 0.0f, 4, null);
                                Placeable placeable = placeableMo7769measureBRTryo0;
                                if (placeable != null) {
                                    Placeable.PlacementScope.place$default(layout, placeable, 0, 0, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            int i5 = ((i3 >> 6) & 14) | (i3 & 112);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i6 = ((i5 << 6) & 896) | 6;
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 6) & 14));
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.HeaderOverlayLayout.2
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

                public final void invoke(Composer composer2, int i7) {
                    LoadedPaywallComponentsKt.HeaderOverlayLayout(components, modifier2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LoadedPaywallComponents(final PaywallState.Loaded.Components state, final Function2<? super PaywallAction.External, ? super Continuation<? super Unit>, ? extends Object> clickHandler, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean zChangedInstance;
        LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1 loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        Composer composerStartRestartGroup = composer.startRestartGroup(1377748719);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents)P(2)74@4538L7,80@4743L41,81@4836L69,86@5030L1668,83@4911L1787:LoadedPaywallComponents.kt#dnqhhd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(clickHandler) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i3;
            if ((i4 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1377748719, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents (LoadedPaywallComponents.kt:73)");
                }
                ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localConfiguration);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                PaywallState.Loaded.Components.update$default(state, ((Configuration) objConsume).getLocales(), null, null, 6, null);
                final ComponentStyle stack = state.getStack();
                final ComponentStyle header = state.getHeader();
                final ComponentStyle stickyFooter = state.getStickyFooter();
                final BackgroundStyle backgroundStyleRememberBackgroundStyle = BackgroundStyleKt.rememberBackgroundStyle(state.getBackground(), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceGroup(174537305);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                zChangedInstance = ((i4 & 14) == 4) | composerStartRestartGroup.changedInstance(clickHandler);
                loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue = new LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1(state, clickHandler, null);
                    composerStartRestartGroup.updateRememberedValue(loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue);
                }
                final Function2 function2 = (Function2) loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                SimpleSheetState sheet = state.getSheet();
                Modifier modifierBackground$default = BackgroundKt.background$default(modifier4, backgroundStyleRememberBackgroundStyle, (Shape) null, 2, (Object) null);
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1179256774, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents.1
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
                        ComposerKt.sourceInformation(composer3, "C87@5102L1590,87@5040L1652:LoadedPaywallComponents.kt#dnqhhd");
                        if ((i6 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1179256774, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents.<anonymous> (LoadedPaywallComponents.kt:87)");
                        }
                        PaywallState.Loaded.Components components = state;
                        BackgroundStyle backgroundStyle = backgroundStyleRememberBackgroundStyle;
                        final PaywallState.Loaded.Components components2 = state;
                        final ComponentStyle componentStyle = stickyFooter;
                        final ComponentStyle componentStyle2 = stack;
                        final Function2<PaywallAction, Continuation<? super Unit>, Object> function22 = function2;
                        final ComponentStyle componentStyle3 = header;
                        WithOptionalBackgroundOverlayKt.WithOptionalBackgroundOverlay(components, backgroundStyle, null, null, ComposableLambdaKt.rememberComposableLambda(1882576877, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i7) {
                                ComposerKt.sourceInformation(composer4, "C88@5116L1566:LoadedPaywallComponents.kt#dnqhhd");
                                if ((i7 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1882576877, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents.<anonymous>.<anonymous> (LoadedPaywallComponents.kt:88)");
                                }
                                final PaywallState.Loaded.Components components3 = components2;
                                ComponentStyle componentStyle4 = componentStyle;
                                final ComponentStyle componentStyle5 = componentStyle2;
                                final Function2<PaywallAction, Continuation<? super Unit>, Object> function23 = function22;
                                final ComponentStyle componentStyle6 = componentStyle3;
                                ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                Modifier.Companion companion = Modifier.INSTANCE;
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, companion);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer4);
                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, -1052690853, "C92@5267L1075,89@5141L1201:LoadedPaywallComponents.kt#dnqhhd");
                                Composer composer5 = composer4;
                                LoadedPaywallComponentsKt.HeaderOverlayLayout(components3, ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), ComposableLambdaKt.rememberComposableLambda(-877486589, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                        invoke(composer6, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer6, int i8) {
                                        ComposerKt.sourceInformation(composer6, "C100@5613L21,103@5802L87,94@5346L566,*109@6059L243:LoadedPaywallComponents.kt#dnqhhd");
                                        if ((i8 & 3) == 2 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-877486589, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoadedPaywallComponents.kt:94)");
                                        }
                                        ComponentStyle componentStyle7 = componentStyle5;
                                        PaywallState.Loaded.Components components4 = components3;
                                        Function2<PaywallAction, Continuation<? super Unit>, Object> function24 = function23;
                                        boolean z = false;
                                        Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer6, 0, 1), false, null, false, 14, null);
                                        if (componentStyle6 != null && !components3.getMainStackHasHeroImage()) {
                                            z = true;
                                        }
                                        composer6.startReplaceGroup(-935420889);
                                        ComposerKt.sourceInformation(composer6, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                                        boolean zChanged = composer6.changed(components3);
                                        final PaywallState.Loaded.Components components5 = components3;
                                        Object objRememberedValue = composer6.rememberedValue();
                                        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$1$1$1$1$1$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Modifier invoke(Modifier conditional) {
                                                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                    return LoadedPaywallComponentsKt.headerTopPadding(conditional, components5);
                                                }
                                            };
                                            composer6.updateRememberedValue(objRememberedValue);
                                        }
                                        composer6.endReplaceGroup();
                                        ComponentViewKt.ComponentView(componentStyle7, components4, function24, ModifierExtensionsKt.conditional(modifierVerticalScroll$default, z, (Function1) objRememberedValue), composer6, 0, 0);
                                        ComponentStyle componentStyle8 = componentStyle6;
                                        if (componentStyle8 != null) {
                                            ComponentViewKt.ComponentView(componentStyle8, components3, function23, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composer6, 3072, 0);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer4, 54), composer5, 384, 0);
                                composer5.startReplaceGroup(1628648656);
                                ComposerKt.sourceInformation(composer5, "*118@6407L243");
                                if (componentStyle4 != null) {
                                    ComponentViewKt.ComponentView(componentStyle4, components3, function23, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composer5, 3072, 0);
                                    composer5 = composer5;
                                }
                                composer5.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, 24576, 12);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54);
                composer2 = composerStartRestartGroup;
                SimpleBottomSheetScaffoldKt.SimpleBottomSheetScaffold(sheet, modifierBackground$default, composableLambdaRememberComposableLambda, composer2, 384, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents.2
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
                        LoadedPaywallComponentsKt.LoadedPaywallComponents(state, clickHandler, modifier3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & 147) == 146) {
            if (i5 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Configuration> localConfiguration2 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localConfiguration2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            PaywallState.Loaded.Components.update$default(state, ((Configuration) objConsume2).getLocales(), null, null, 6, null);
            final ComponentStyle stack2 = state.getStack();
            final ComponentStyle header2 = state.getHeader();
            final ComponentStyle stickyFooter2 = state.getStickyFooter();
            final BackgroundStyle backgroundStyleRememberBackgroundStyle2 = BackgroundStyleKt.rememberBackgroundStyle(state.getBackground(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceGroup(174537305);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
            zChangedInstance = ((i4 & 14) == 4) | composerStartRestartGroup.changedInstance(clickHandler);
            loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue = new LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1(state, clickHandler, null);
                composerStartRestartGroup.updateRememberedValue(loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue);
                final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function22 = (Function2) loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                SimpleSheetState sheet2 = state.getSheet();
                Modifier modifierBackground$default2 = BackgroundKt.background$default(modifier4, backgroundStyleRememberBackgroundStyle2, (Shape) null, 2, (Object) null);
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1179256774, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents.1
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
                        ComposerKt.sourceInformation(composer3, "C87@5102L1590,87@5040L1652:LoadedPaywallComponents.kt#dnqhhd");
                        if ((i6 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1179256774, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents.<anonymous> (LoadedPaywallComponents.kt:87)");
                        }
                        PaywallState.Loaded.Components components = state;
                        BackgroundStyle backgroundStyle = backgroundStyleRememberBackgroundStyle2;
                        final PaywallState.Loaded.Components components2 = state;
                        final ComponentStyle componentStyle = stickyFooter2;
                        final ComponentStyle componentStyle2 = stack2;
                        final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function222 = function22;
                        final ComponentStyle componentStyle3 = header2;
                        WithOptionalBackgroundOverlayKt.WithOptionalBackgroundOverlay(components, backgroundStyle, null, null, ComposableLambdaKt.rememberComposableLambda(1882576877, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i7) {
                                ComposerKt.sourceInformation(composer4, "C88@5116L1566:LoadedPaywallComponents.kt#dnqhhd");
                                if ((i7 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1882576877, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents.<anonymous>.<anonymous> (LoadedPaywallComponents.kt:88)");
                                }
                                final PaywallState.Loaded.Components components3 = components2;
                                ComponentStyle componentStyle4 = componentStyle;
                                final ComponentStyle componentStyle5 = componentStyle2;
                                final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function23 = function222;
                                final ComponentStyle componentStyle6 = componentStyle3;
                                ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                Modifier.Companion companion = Modifier.INSTANCE;
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, companion);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer4);
                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, -1052690853, "C92@5267L1075,89@5141L1201:LoadedPaywallComponents.kt#dnqhhd");
                                Composer composer5 = composer4;
                                LoadedPaywallComponentsKt.HeaderOverlayLayout(components3, ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), ComposableLambdaKt.rememberComposableLambda(-877486589, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                        invoke(composer6, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer6, int i8) {
                                        ComposerKt.sourceInformation(composer6, "C100@5613L21,103@5802L87,94@5346L566,*109@6059L243:LoadedPaywallComponents.kt#dnqhhd");
                                        if ((i8 & 3) == 2 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-877486589, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoadedPaywallComponents.kt:94)");
                                        }
                                        ComponentStyle componentStyle7 = componentStyle5;
                                        PaywallState.Loaded.Components components4 = components3;
                                        Function2<PaywallAction, Continuation<? super Unit>, Object> function24 = function23;
                                        boolean z = false;
                                        Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer6, 0, 1), false, null, false, 14, null);
                                        if (componentStyle6 != null && !components3.getMainStackHasHeroImage()) {
                                            z = true;
                                        }
                                        composer6.startReplaceGroup(-935420889);
                                        ComposerKt.sourceInformation(composer6, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                                        boolean zChanged = composer6.changed(components3);
                                        final PaywallState.Loaded.Components components5 = components3;
                                        Object objRememberedValue = composer6.rememberedValue();
                                        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$1$1$1$1$1$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Modifier invoke(Modifier conditional) {
                                                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                    return LoadedPaywallComponentsKt.headerTopPadding(conditional, components5);
                                                }
                                            };
                                            composer6.updateRememberedValue(objRememberedValue);
                                        }
                                        composer6.endReplaceGroup();
                                        ComponentViewKt.ComponentView(componentStyle7, components4, function24, ModifierExtensionsKt.conditional(modifierVerticalScroll$default, z, (Function1) objRememberedValue), composer6, 0, 0);
                                        ComponentStyle componentStyle8 = componentStyle6;
                                        if (componentStyle8 != null) {
                                            ComponentViewKt.ComponentView(componentStyle8, components3, function23, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composer6, 3072, 0);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer4, 54), composer5, 384, 0);
                                composer5.startReplaceGroup(1628648656);
                                ComposerKt.sourceInformation(composer5, "*118@6407L243");
                                if (componentStyle4 != null) {
                                    ComponentViewKt.ComponentView(componentStyle4, components3, function23, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composer5, 3072, 0);
                                    composer5 = composer5;
                                }
                                composer5.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, 24576, 12);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54);
                composer2 = composerStartRestartGroup;
                SimpleBottomSheetScaffoldKt.SimpleBottomSheetScaffold(sheet2, modifierBackground$default2, composableLambdaRememberComposableLambda2, composer2, 384, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier4;
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_BottomSheet_FitSize_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(561912880);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_BottomSheet_FitSize_Preview)272@11525L31,280@11713L137:LoadedPaywallComponents.kt#dnqhhd");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(561912880, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_BottomSheet_FitSize_Preview (LoadedPaywallComponents.kt:271)");
            }
            PaywallState.Loaded.Components componentsPreviewHelloWorldPaywallState = previewHelloWorldPaywallState(composerStartRestartGroup, 0);
            show(componentsPreviewHelloWorldPaywallState.getSheet(), previewBottomSheet(new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE)), componentsPreviewHelloWorldPaywallState, new C06861(null));
            LoadedPaywallComponents(componentsPreviewHelloWorldPaywallState, new C06872(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents_BottomSheet_FitSize_Preview.3
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
                    LoadedPaywallComponentsKt.LoadedPaywallComponents_BottomSheet_FitSize_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_BottomSheet_NullSize_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-398756048);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_BottomSheet_NullSize_Preview)253@11118L31,261@11279L137:LoadedPaywallComponents.kt#dnqhhd");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-398756048, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_BottomSheet_NullSize_Preview (LoadedPaywallComponents.kt:252)");
            }
            PaywallState.Loaded.Components componentsPreviewHelloWorldPaywallState = previewHelloWorldPaywallState(composerStartRestartGroup, 0);
            show(componentsPreviewHelloWorldPaywallState.getSheet(), previewBottomSheet(null), componentsPreviewHelloWorldPaywallState, new C06881(null));
            LoadedPaywallComponents(componentsPreviewHelloWorldPaywallState, new C06892(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents_BottomSheet_NullSize_Preview.3
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
                    LoadedPaywallComponentsKt.LoadedPaywallComponents_BottomSheet_NullSize_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1173704376);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview)241@10835L31,242@10871L137:LoadedPaywallComponents.kt#dnqhhd");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1173704376, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview (LoadedPaywallComponents.kt:240)");
            }
            LoadedPaywallComponents(previewHelloWorldPaywallState(composerStartRestartGroup, 0), new C06911(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents_Preview.2
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
                    LoadedPaywallComponentsKt.LoadedPaywallComponents_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void LoadedPaywallComponents_Preview_Bless(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-485118556);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview_Bless)453@21489L48,461@21785L137:LoadedPaywallComponents.kt#dnqhhd");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-485118556, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_Bless (LoadedPaywallComponents.kt:291)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6351getBlack0d7_KjU())), new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6362getWhite0d7_KjU())));
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6362getWhite0d7_KjU())), new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6351getBlack0d7_KjU())));
            DefaultConstructorMarker defaultConstructorMarker = null;
            Integer num = null;
            Padding padding = null;
            List list = null;
            int i2 = 5372;
            FontWeight fontWeight = null;
            int i3 = 0;
            String str = "preview_paywall_id";
            String str2 = "template";
            Offering offering = new Offering("id", "description", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getMonthly()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData(str, str2, new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new StackComponent[]{new StackComponent(CollectionsKt.listOf(TestData.Components.INSTANCE.getMonthlyPackageComponent()), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.CENTER), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fill.INSTANCE), (Float) null, new ColorScheme(new ColorInfo.Gradient.Linear(60.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color(255, 255, 255, 255)), 40.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(ColorKt.Color$default(5, 124, 91, 0, 8, null)), 100.0f)})), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, (Padding) null, (Padding) null, (com.revenuecat.purchases.paywalls.components.properties.Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32722, (DefaultConstructorMarker) null), new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new TextComponent(LocalizationKey.m10429constructorimpl(Constants.GP_IAP_TITLE), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.SEMI_BOLD, num, 28, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), padding, new Padding(AudioStats.AUDIO_AMPLITUDE_NONE, 40.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), list, 5212, defaultConstructorMarker), new TextComponent(LocalizationKey.m10429constructorimpl("feature-1"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, fontWeight, num, i3, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), padding, new Padding(8.0d, 8.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), list, i2, defaultConstructorMarker), new TextComponent(LocalizationKey.m10429constructorimpl("feature-2"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, fontWeight, num, i3, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), padding, new Padding(8.0d, 8.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), list, i2, defaultConstructorMarker), new TextComponent(LocalizationKey.m10429constructorimpl("feature-3"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, fontWeight, num, i3, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), padding, new Padding(8.0d, 8.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), list, i2, defaultConstructorMarker), new TextComponent(LocalizationKey.m10429constructorimpl("feature-4"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, fontWeight, num, i3, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), padding, new Padding(8.0d, 8.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), list, i2, defaultConstructorMarker), new TextComponent(LocalizationKey.m10429constructorimpl("feature-5"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, fontWeight, num, i3, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), padding, new Padding(8.0d, 8.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), list, i2, defaultConstructorMarker), new TextComponent(LocalizationKey.m10429constructorimpl("feature-6"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, fontWeight, num, i3, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), padding, new Padding(8.0d, 8.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), list, i2, defaultConstructorMarker), new TextComponent(LocalizationKey.m10429constructorimpl("offer"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, fontWeight, num, i3, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), padding, new Padding(48.0d, 8.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), list, i2, defaultConstructorMarker), new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m10429constructorimpl("cta"), new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6362getWhite0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, 8156, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.CENTER), new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), (Float) null, new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(ColorKt.Color$default(5, 124, 91, 0, 8, null))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, new Padding(8.0d, 8.0d, 32.0d, 32.0d), new Padding(8.0d, 8.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), Shape.Pill.INSTANCE, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 31826, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m10429constructorimpl("terms"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, 8188, defaultConstructorMarker)}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.END), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fill.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, new Padding(16.0d, 16.0d, 32.0d, 32.0d), (Padding) null, (com.revenuecat.purchases.paywalls.components.properties.Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32626, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.BOTTOM), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fill.INSTANCE), (Float) null, colorScheme2, (Background) null, (Padding) null, (Padding) null, (com.revenuecat.purchases.paywalls.components.properties.Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32722, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), (StickyFooterComponent) null, (HeaderComponent) null, 8, (DefaultConstructorMarker) null)), MapsKt.mapOf(TuplesKt.to(LocaleId.m10392boximpl(LocaleId.m10393constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl(Constants.GP_IAP_TITLE)), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Unlock bless."))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("feature-1")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("✓ Enjoy a 7 day trial"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("feature-2")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("✓ Change currencies"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("feature-3")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("✓ Access more trend charts"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("feature-4")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("✓ Create custom categories"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("feature-5")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("✓ Get a special premium icon"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("feature-6")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("✓ Receive our love and gratitude for your support"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("offer")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Try 7 days free, then $19.98/year. Cancel anytime."))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("cta")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Continue"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("terms")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Privacy & Terms")))))), LocaleId.m10393constructorimpl("en_US"), 0, (List) null, (ExitOffers) (0 == true ? 1 : 0), (ProductChangeConfig) (0 == true ? 1 : 0), 960, defaultConstructorMarker)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            LoadedPaywallComponents(OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, null, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_Preview_Bless$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null), new C06931(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents_Preview_Bless.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num2) {
                    invoke(composer2, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    LoadedPaywallComponentsKt.LoadedPaywallComponents_Preview_Bless(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object handleClick(PaywallAction paywallAction, PaywallState.Loaded.Components components, Function2<? super PaywallAction.External, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        if (paywallAction instanceof PaywallAction.External) {
            Object objInvoke = function2.invoke(paywallAction, continuation);
            return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
        }
        if ((paywallAction instanceof PaywallAction.Internal) && (((PaywallAction.Internal) paywallAction) instanceof PaywallAction.Internal.NavigateTo)) {
            PaywallAction.Internal.NavigateTo navigateTo = (PaywallAction.Internal.NavigateTo) paywallAction;
            if (navigateTo.getDestination() instanceof PaywallAction.Internal.NavigateTo.Destination.Sheet) {
                show(components.getSheet(), ((PaywallAction.Internal.NavigateTo.Destination.Sheet) navigateTo.getDestination()).getSheet(), components, new C06952(components, function2, null));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier headerTopPadding(Modifier modifier, final PaywallState.Loaded.Components components) {
        return LayoutModifierKt.layout(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.headerTopPadding.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m10456invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m10456invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                final int headerHeightPx = components.getHeaderHeightPx();
                final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(ConstraintsKt.m9087offsetNN6EwU$default(j, 0, -headerHeightPx, 1, null));
                return MeasureScope.layout$default(layout, placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight() + headerHeightPx, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.headerTopPadding.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout2) {
                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                        Placeable.PlacementScope.place$default(layout2, placeableMo7769measureBRTryo0, 0, headerHeightPx, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        });
    }

    private static final ButtonComponentStyle.Action.NavigateTo.Destination.Sheet previewBottomSheet(Size size) {
        return new ButtonComponentStyle.Action.NavigateTo.Destination.Sheet("", "", PreviewHelpersKt.m10457previewStackComponentStyle7SJwSw(CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle$default("This is a bottom sheet.", null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65534, null), PreviewHelpersKt.previewTextComponentStyle$default("This is a bottom sheet.", null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65534, null), PreviewHelpersKt.previewTextComponentStyle$default("This is a bottom sheet.", null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65534, null)}), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : null, (31966 & 16) != 0 ? Dp.m9114constructorimpl(16.0f) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null))) : BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6362getWhite0d7_KjU())), null, 2, null))), (31966 & 64) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : null, (31966 & 128) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : null, (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : new Shape.Rectangle(new CornerRadiuses.Dp(16.0d, 16.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE)), (31966 & 512) != 0 ? new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), true, size);
    }

    static /* synthetic */ ButtonComponentStyle.Action.NavigateTo.Destination.Sheet previewBottomSheet$default(Size size, int i, Object obj) {
        if ((i & 1) != 0) {
            size = null;
        }
        return previewBottomSheet(size);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final PaywallState.Loaded.Components previewHelloWorldPaywallState(Composer composer, int i) {
        composer.startReplaceGroup(-1486758699);
        ComposerKt.sourceInformation(composer, "C(previewHelloWorldPaywallState)541@25264L48:LoadedPaywallComponents.kt#dnqhhd");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1486758699, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.previewHelloWorldPaywallState (LoadedPaywallComponents.kt:471)");
        }
        String str = "preview_paywall_id";
        String str2 = "template";
        Offering offering = new Offering("id", "description", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getMonthly()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData(str, str2, new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new TextComponent(LocalizationKey.m10429constructorimpl("hello-world"), new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6351getBlack0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, 8188, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), (Size) null, (Float) null, new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6353getCyan0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, (Padding) null, (Padding) null, (com.revenuecat.purchases.paywalls.components.properties.Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, 32730, (DefaultConstructorMarker) null), new Background.Color(new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6352getBlue0d7_KjU())), new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6359getRed0d7_KjU())))), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m10429constructorimpl("sticky-footer"), new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6351getBlack0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) (0 == true ? 1 : 0), (String) null, (FontWeight) (0 == true ? 1 : 0), (Integer) (0 == true ? 1 : 0), 0, (HorizontalAlignment) (0 == true ? 1 : 0), (Size) (0 == true ? 1 : 0), (Padding) null, (Padding) null, (List) null, 8188, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), (Size) null, (Float) null, new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6362getWhite0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, (Padding) null, (Padding) null, new Shape.Rectangle(new CornerRadiuses.Dp(10.0d, 10.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE)), (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6351getBlack0d7_KjU())), new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6363getYellow0d7_KjU()))), 10.0d, AudioStats.AUDIO_AMPLITUDE_NONE, -5.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, 30170, (DefaultConstructorMarker) null)), (HeaderComponent) null, 8, (DefaultConstructorMarker) null)), MapsKt.mapOf(TuplesKt.to(LocaleId.m10392boximpl(LocaleId.m10393constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("hello-world")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Hello, world!"))), TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("sticky-footer")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("Sticky Footer")))))), LocaleId.m10393constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, 960, (DefaultConstructorMarker) null)), null, 80, null);
        Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composer, 0);
        PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
        Intrinsics.checkNotNull(components);
        PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, null, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.previewHelloWorldPaywallState.1
            @Override // kotlin.jvm.functions.Function0
            public final Date invoke() {
                return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
            }
        }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return componentsPaywallState$default;
    }

    private static final void show(final SimpleSheetState simpleSheetState, final ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet, final PaywallState.Loaded.Components components, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2) {
        simpleSheetState.show(sheet.getBackgroundBlur(), ComposableLambdaKt.composableLambdaInstance(1290168816, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.show.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C219@10071L208,216@9962L502:LoadedPaywallComponents.kt#dnqhhd");
                if ((i & 3) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1290168816, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.show.<anonymous> (LoadedPaywallComponents.kt:216)");
                }
                ComponentStyle stack = sheet.getStack();
                PaywallState.Loaded.Components components2 = components;
                composer.startReplaceGroup(1730849339);
                ComposerKt.sourceInformation(composer, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                boolean zChanged = composer.changed(simpleSheetState) | composer.changedInstance(function2);
                SimpleSheetState simpleSheetState2 = simpleSheetState;
                Function2<PaywallAction, Continuation<? super Unit>, Object> function22 = function2;
                LoadedPaywallComponentsKt$show$1$1$1 loadedPaywallComponentsKt$show$1$1$1RememberedValue = composer.rememberedValue();
                if (zChanged || loadedPaywallComponentsKt$show$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    loadedPaywallComponentsKt$show$1$1$1RememberedValue = new LoadedPaywallComponentsKt$show$1$1$1(simpleSheetState2, function22, null);
                    composer.updateRememberedValue(loadedPaywallComponentsKt$show$1$1$1RememberedValue);
                }
                Function2 function23 = (Function2) loadedPaywallComponentsKt$show$1$1$1RememberedValue;
                composer.endReplaceGroup();
                ComponentViewKt.ComponentView(stack, components2, function23, ModifierExtensionsKt.conditional(ModifierExtensionsKt.applyIfNotNull(Modifier.INSTANCE, sheet.getSize(), new Function2<Modifier, Size, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.show.1.2
                    @Override // kotlin.jvm.functions.Function2
                    public final Modifier invoke(Modifier applyIfNotNull, Size it) {
                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return com.revenuecat.purchases.ui.revenuecatui.components.modifier.SizeKt.size$default(applyIfNotNull, it, null, null, 6, null);
                    }
                }), sheet.getSize() == null, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.show.1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Modifier invoke(Modifier conditional) {
                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                        return SizeKt.fillMaxWidth$default(conditional, 0.0f, 1, null);
                    }
                }), composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.show.2
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
                components.resetToDefaultPackage();
            }
        });
    }
}
