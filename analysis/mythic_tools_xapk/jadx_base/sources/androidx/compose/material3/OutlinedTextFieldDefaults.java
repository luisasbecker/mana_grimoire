package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.material3.TextFieldLabelPosition;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.internal.TextFieldType;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.messaging.Constants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: compiled from: TextFieldDefaults.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2 \b\u0002\u0010!\u001a\u001a\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010.\u001a\u00020\u00182\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\u0013\b\u0002\u00103\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u00104JY\u00105\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\tH\u0007¢\u0006\u0004\b:\u0010;J\u009c\u0002\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020>2\u0011\u0010?\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020B2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u00182\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\u0013\b\u0002\u00103\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u0010CJ5\u00101\u001a\u0002022\b\b\u0002\u0010D\u001a\u00020\t2\b\b\u0002\u0010E\u001a\u00020\t2\b\b\u0002\u0010F\u001a\u00020\t2\b\b\u0002\u0010G\u001a\u00020\t¢\u0006\u0004\bH\u0010IJ\r\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u0010JJ¿\u0003\u0010/\u001a\u0002002\b\b\u0002\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020L2\b\b\u0002\u0010N\u001a\u00020L2\b\b\u0002\u0010O\u001a\u00020L2\b\b\u0002\u0010P\u001a\u00020L2\b\b\u0002\u0010Q\u001a\u00020L2\b\b\u0002\u0010R\u001a\u00020L2\b\b\u0002\u0010S\u001a\u00020L2\b\b\u0002\u0010T\u001a\u00020L2\b\b\u0002\u0010U\u001a\u00020L2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010W2\b\b\u0002\u0010X\u001a\u00020L2\b\b\u0002\u0010Y\u001a\u00020L2\b\b\u0002\u0010Z\u001a\u00020L2\b\b\u0002\u0010[\u001a\u00020L2\b\b\u0002\u0010\\\u001a\u00020L2\b\b\u0002\u0010]\u001a\u00020L2\b\b\u0002\u0010^\u001a\u00020L2\b\b\u0002\u0010_\u001a\u00020L2\b\b\u0002\u0010`\u001a\u00020L2\b\b\u0002\u0010a\u001a\u00020L2\b\b\u0002\u0010b\u001a\u00020L2\b\b\u0002\u0010c\u001a\u00020L2\b\b\u0002\u0010d\u001a\u00020L2\b\b\u0002\u0010e\u001a\u00020L2\b\b\u0002\u0010f\u001a\u00020L2\b\b\u0002\u0010g\u001a\u00020L2\b\b\u0002\u0010h\u001a\u00020L2\b\b\u0002\u0010i\u001a\u00020L2\b\b\u0002\u0010j\u001a\u00020L2\b\b\u0002\u0010k\u001a\u00020L2\b\b\u0002\u0010l\u001a\u00020L2\b\b\u0002\u0010m\u001a\u00020L2\b\b\u0002\u0010n\u001a\u00020L2\b\b\u0002\u0010o\u001a\u00020L2\b\b\u0002\u0010p\u001a\u00020L2\b\b\u0002\u0010q\u001a\u00020L2\b\b\u0002\u0010r\u001a\u00020L2\b\b\u0002\u0010s\u001a\u00020L2\b\b\u0002\u0010t\u001a\u00020L2\b\b\u0002\u0010u\u001a\u00020L2\b\b\u0002\u0010v\u001a\u00020L2\b\b\u0002\u0010w\u001a\u00020LH\u0007¢\u0006\u0004\bx\u0010yJP\u0010~\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\tH\u0007¢\u0006\u0005\b\u007f\u0010\u0080\u0001R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u000f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0011\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0018\u0010z\u001a\u000200*\u00020{8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}¨\u0006\u0081\u0001"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "FocusedBorderThickness", "getFocusedBorderThickness-D9Ej5fM", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/text/input/TextFieldState;", "enabled", "", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", Constants.ScionAnalytics.PARAM_LABEL, "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "placeholder", "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Landroidx/compose/foundation/text/input/TextFieldState;ZLandroidx/compose/foundation/text/input/TextFieldLineLimits;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)Landroidx/compose/foundation/text/input/TextFieldDecorator;", TextFieldImplKt.ContainerId, "modifier", "Landroidx/compose/ui/Modifier;", "focusedBorderThickness", "unfocusedBorderThickness", "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "start", ViewHierarchyConstants.DIMENSION_TOP_KEY, "end", "bottom", "contentPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "defaultOutlinedTextFieldColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultOutlinedTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "ContainerBox", "ContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OutlinedTextFieldDefaults {
    public static final int $stable = 0;
    public static final OutlinedTextFieldDefaults INSTANCE = new OutlinedTextFieldDefaults();
    private static final float MinHeight = Dp.m9114constructorimpl(56.0f);
    private static final float MinWidth = Dp.m9114constructorimpl(280.0f);
    private static final float UnfocusedBorderThickness = Dp.m9114constructorimpl(1.0f);
    private static final float FocusedBorderThickness = Dp.m9114constructorimpl(2.0f);

    /* JADX INFO: renamed from: androidx.compose.material3.OutlinedTextFieldDefaults$decorator$2, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldDefaults.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass2 implements TextFieldDecorator {
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ Function2<Composer, Integer, Unit> $container;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ Function3<TextFieldLabelScope, Composer, Integer, Unit> $label;
        final /* synthetic */ TextFieldLabelPosition $labelPosition;
        final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
        final /* synthetic */ TextFieldLineLimits $lineLimits;
        final /* synthetic */ OutputTransformation $outputTransformation;
        final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
        final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
        final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
        final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(OutputTransformation outputTransformation, TextFieldState textFieldState, TextFieldLineLimits textFieldLineLimits, TextFieldLabelPosition textFieldLabelPosition, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, boolean z, boolean z2, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, Function2<? super Composer, ? super Integer, Unit> function27) {
            this.$outputTransformation = outputTransformation;
            this.$state = textFieldState;
            this.$lineLimits = textFieldLineLimits;
            this.$labelPosition = textFieldLabelPosition;
            this.$label = function3;
            this.$placeholder = function2;
            this.$leadingIcon = function22;
            this.$trailingIcon = function23;
            this.$prefix = function24;
            this.$suffix = function25;
            this.$supportingText = function26;
            this.$enabled = z;
            this.$isError = z2;
            this.$interactionSource = interactionSource;
            this.$contentPadding = paddingValues;
            this.$colors = textFieldColors;
            this.$container = function27;
        }

        static final Unit Decoration$lambda$2(AnonymousClass2 anonymousClass2, Function2 function2, int i, Composer composer, int i2) {
            anonymousClass2.Decoration(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            return Unit.INSTANCE;
        }

        @Override // androidx.compose.foundation.text.input.TextFieldDecorator
        public final void Decoration(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
            int i2;
            Composer composer2;
            TextFieldBuffer textFieldBuffer;
            CharSequence charSequenceAsCharSequence;
            Composer composerStartRestartGroup = composer.startRestartGroup(794272399);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)N(innerTextField)1006@52904L720:TextFieldDefaults.kt#uh7d8r");
            if ((i & 6) == 0) {
                i2 = i | (composerStartRestartGroup.changedInstance(function2) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= composerStartRestartGroup.changed(this) ? 32 : 16;
            }
            if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(794272399, i2, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.decorator.<no name provided>.Decoration (TextFieldDefaults.kt:994)");
                }
                OutputTransformation outputTransformation = this.$outputTransformation;
                TextFieldState textFieldState = this.$state;
                if (outputTransformation == null) {
                    charSequenceAsCharSequence = textFieldState.getText();
                } else {
                    TextFieldBuffer textFieldBufferStartEdit = textFieldState.startEdit();
                    try {
                        textFieldState.commitEdit(textFieldBufferStartEdit);
                        textFieldState.finishEditing();
                        OutputTransformation outputTransformation2 = this.$outputTransformation;
                        if (textFieldBufferStartEdit == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("buffer");
                            textFieldBuffer = null;
                        } else {
                            textFieldBuffer = textFieldBufferStartEdit;
                        }
                        outputTransformation2.transformOutput(textFieldBuffer);
                        charSequenceAsCharSequence = textFieldBufferStartEdit.asCharSequence();
                    } catch (Throwable th) {
                        textFieldState.finishEditing();
                        throw th;
                    }
                }
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, charSequenceAsCharSequence, function2, this.$labelPosition, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$prefix, this.$suffix, this.$supportingText, Intrinsics.areEqual(this.$lineLimits, TextFieldLineLimits.SingleLine.INSTANCE), this.$enabled, this.$isError, this.$interactionSource, this.$contentPadding, this.$colors, this.$container, composer2, ((i2 << 6) & 896) | 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$decorator$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OutlinedTextFieldDefaults.AnonymousClass2.Decoration$lambda$2(this.f$0, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
    }

    private OutlinedTextFieldDefaults() {
    }

    static final Unit ContainerBox_nbWgWpA$lambda$7(OutlinedTextFieldDefaults outlinedTextFieldDefaults, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f, float f2, int i, int i2, Composer composer, int i3) {
        outlinedTextFieldDefaults.m3923ContainerBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit Container_4EFweAY$lambda$0(OutlinedTextFieldDefaults outlinedTextFieldDefaults, boolean z, boolean z2, InteractionSource interactionSource, Modifier modifier, TextFieldColors textFieldColors, Shape shape, float f, float f2, int i, int i2, Composer composer, int i3) {
        outlinedTextFieldDefaults.m3922Container4EFweAY(z, z2, interactionSource, modifier, textFieldColors, shape, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit DecorationBox$lambda$3(OutlinedTextFieldDefaults outlinedTextFieldDefaults, String str, Function2 function2, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, Function2 function27, Function2 function28, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 function29, int i, int i2, int i3, Composer composer, int i4) {
        outlinedTextFieldDefaults.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z3, function22, function23, function24, function25, function26, function27, function28, textFieldColors, paddingValues, function29, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: contentPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3921contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults outlinedTextFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return outlinedTextFieldDefaults.m3925contentPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f3  */
    /* JADX INFO: renamed from: Container-4EFweAY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3922Container4EFweAY(final boolean z, final boolean z2, final InteractionSource interactionSource, Modifier modifier, TextFieldColors textFieldColors, Shape shape, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        TextFieldColors textFieldColors2;
        Shape shape2;
        float f3;
        float f4;
        Composer composer2;
        final Modifier modifier3;
        final TextFieldColors textFieldColors3;
        final Shape shape3;
        final float f5;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        TextFieldColors textFieldColorsColors;
        Shape shape4;
        float f7;
        Modifier modifier4;
        int i4;
        TextFieldColors textFieldColors4;
        Shape shape5;
        float f8;
        float f9;
        Composer composerStartRestartGroup = composer.startRestartGroup(1035477640);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Container)N(enabled,isError,interactionSource,modifier,colors,shape,focusedBorderThickness:c#ui.unit.Dp,unfocusedBorderThickness:c#ui.unit.Dp)1055@55084L25,1057@55155L222,1069@55662L7,1067@55495L189,1071@55693L153:TextFieldDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(interactionSource) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    textFieldColors2 = textFieldColors;
                    int i6 = composerStartRestartGroup.changed(textFieldColors2) ? 16384 : 8192;
                    i3 |= i6;
                } else {
                    textFieldColors2 = textFieldColors;
                }
                i3 |= i6;
            } else {
                textFieldColors2 = textFieldColors;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    shape2 = shape;
                    int i7 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                    i3 |= i7;
                } else {
                    shape2 = shape;
                }
                i3 |= i7;
            } else {
                shape2 = shape;
            }
            if ((1572864 & i) != 0) {
                if ((i2 & 64) == 0) {
                    f3 = f;
                    int i8 = composerStartRestartGroup.changed(f3) ? 1048576 : 524288;
                    i3 |= i8;
                } else {
                    f3 = f;
                }
                i3 |= i8;
            } else {
                f3 = f;
            }
            if ((12582912 & i) != 0) {
                if ((i2 & 128) == 0) {
                    f4 = f2;
                    int i9 = composerStartRestartGroup.changed(f4) ? 8388608 : 4194304;
                    i3 |= i9;
                } else {
                    f4 = f2;
                }
                i3 |= i9;
            } else {
                f4 = f2;
            }
            if ((i2 & 256) == 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                i3 |= composerStartRestartGroup.changed(this) ? 67108864 : 33554432;
            }
            if (composerStartRestartGroup.shouldExecute((38347923 & i3) == 38347922, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                textFieldColors3 = textFieldColors2;
                shape3 = shape2;
                f5 = f3;
                f6 = f4;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1050@54844L8,1051@54903L5");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 16) != 0) {
                        textFieldColorsColors = colors(composerStartRestartGroup, (i3 >> 24) & 14);
                        i3 &= -57345;
                    } else {
                        textFieldColorsColors = textFieldColors2;
                    }
                    if ((i2 & 32) != 0) {
                        shape4 = INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        f7 = FocusedBorderThickness;
                        i3 &= -3670017;
                    } else {
                        f7 = f3;
                    }
                    if ((i2 & 128) != 0) {
                        shape5 = shape4;
                        f9 = UnfocusedBorderThickness;
                        modifier4 = companion;
                        i4 = i3 & (-29360129);
                        textFieldColors4 = textFieldColorsColors;
                        f8 = f7;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1035477640, i4, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.Container (TextFieldDefaults.kt:1054)");
                        }
                        int i10 = i4 >> 6;
                        boolean zBooleanValue = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, i10 & 14).getValue().booleanValue();
                        State<BorderStroke> stateM4683animateBorderStrokeAsStateNuRrP5Q = TextFieldImplKt.m4683animateBorderStrokeAsStateNuRrP5Q(z, z2, zBooleanValue, textFieldColors4, f8, f9, composerStartRestartGroup, (i10 & 458752) | ((i4 >> 3) & 7168) | (i4 & 126) | (57344 & i10));
                        Modifier modifier5 = modifier4;
                        Shape shape6 = shape5;
                        final State<Color> stateM1353animateColorAsStateeuL9pac = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(textFieldColors4.m4203containerColorXeAY9LY$material3(z, z2, zBooleanValue), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                        composer2 = composerStartRestartGroup;
                        BoxKt.Box(TextFieldImplKt.textFieldBackground(BorderKt.border(modifier5, stateM4683animateBorderStrokeAsStateNuRrP5Q.getValue(), shape6), new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new PropertyReference0Impl(stateM1353animateColorAsStateeuL9pac) { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$Container$1
                            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                            public Object get() {
                                return ((State) this.receiver).getValue();
                            }
                        }), shape6), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f5 = f8;
                        f6 = f9;
                        shape3 = shape6;
                        textFieldColors3 = textFieldColors4;
                        modifier3 = modifier5;
                    } else {
                        modifier4 = companion;
                        i4 = i3;
                        textFieldColors4 = textFieldColorsColors;
                        shape5 = shape4;
                        f8 = f7;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                    }
                    i4 = i3;
                    textFieldColors4 = textFieldColors2;
                    f8 = f3;
                    shape5 = shape2;
                    modifier4 = modifier2;
                }
                f9 = f4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i102 = i4 >> 6;
                boolean zBooleanValue2 = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, i102 & 14).getValue().booleanValue();
                State<BorderStroke> stateM4683animateBorderStrokeAsStateNuRrP5Q2 = TextFieldImplKt.m4683animateBorderStrokeAsStateNuRrP5Q(z, z2, zBooleanValue2, textFieldColors4, f8, f9, composerStartRestartGroup, (i102 & 458752) | ((i4 >> 3) & 7168) | (i4 & 126) | (57344 & i102));
                Modifier modifier52 = modifier4;
                Shape shape62 = shape5;
                final Object stateM1353animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(textFieldColors4.m4203containerColorXeAY9LY$material3(z, z2, zBooleanValue2), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                composer2 = composerStartRestartGroup;
                BoxKt.Box(TextFieldImplKt.textFieldBackground(BorderKt.border(modifier52, stateM4683animateBorderStrokeAsStateNuRrP5Q2.getValue(), shape62), new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new PropertyReference0Impl(stateM1353animateColorAsStateeuL9pac2) { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$Container$1
                    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                    public Object get() {
                        return ((State) this.receiver).getValue();
                    }
                }), shape62), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                f5 = f8;
                f6 = f9;
                shape3 = shape62;
                textFieldColors3 = textFieldColors4;
                modifier3 = modifier52;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OutlinedTextFieldDefaults.Container_4EFweAY$lambda$0(this.f$0, z, z2, interactionSource, modifier3, textFieldColors3, shape3, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((12582912 & i) != 0) {
        }
        if ((i2 & 256) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i3) == 38347922, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0104  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to OutlinedTextFieldDefaults.Container", replaceWith = @ReplaceWith(expression = "Container(\n    enabled = enabled,\n    isError = isError,\n    interactionSource = interactionSource,\n    colors = colors,\n    shape = shape,\n    focusedBorderThickness = focusedBorderThickness,\n    unfocusedBorderThickness = unfocusedBorderThickness,\n)", imports = {}))
    /* JADX INFO: renamed from: ContainerBox-nbWgWpA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3923ContainerBoxnbWgWpA(final boolean z, final boolean z2, final InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f, float f2, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        boolean z4;
        InteractionSource interactionSource2;
        TextFieldColors textFieldColorsColors;
        Shape shape2;
        float f3;
        float f4;
        final TextFieldColors textFieldColors2;
        final Shape shape3;
        final float f5;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1461761386);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContainerBox)N(enabled,isError,interactionSource,colors,shape,focusedBorderThickness:c#ui.unit.Dp,unfocusedBorderThickness:c#ui.unit.Dp)1482@80172L348:TextFieldDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else if ((i & 6) == 0) {
            z3 = z;
            i3 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
        } else {
            z3 = z;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                z4 = z2;
                i3 |= composerStartRestartGroup.changed(z4) ? 32 : 16;
            }
            if ((i2 & 4) != 0) {
                if ((i & 384) == 0) {
                    interactionSource2 = interactionSource;
                    i3 |= composerStartRestartGroup.changed(interactionSource2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        textFieldColorsColors = textFieldColors;
                        int i4 = composerStartRestartGroup.changed(textFieldColorsColors) ? 2048 : 1024;
                        i3 |= i4;
                    } else {
                        textFieldColorsColors = textFieldColors;
                    }
                    i3 |= i4;
                } else {
                    textFieldColorsColors = textFieldColors;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        int i5 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                        i3 |= i5;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i5;
                } else {
                    shape2 = shape;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        f3 = f;
                        int i6 = composerStartRestartGroup.changed(f3) ? 131072 : 65536;
                        i3 |= i6;
                    } else {
                        f3 = f;
                    }
                    i3 |= i6;
                } else {
                    f3 = f;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        f4 = f2;
                        int i7 = composerStartRestartGroup.changed(f4) ? 1048576 : 524288;
                        i3 |= i7;
                    } else {
                        f4 = f2;
                    }
                    i3 |= i7;
                } else {
                    f4 = f2;
                }
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= composerStartRestartGroup.changed(this) ? 8388608 : 4194304;
                }
                if (composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1477@79964L8,1478@80023L5");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if ((i2 & 8) != 0) {
                            textFieldColorsColors = colors(composerStartRestartGroup, (i3 >> 21) & 14);
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            f3 = FocusedBorderThickness;
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            f4 = UnfocusedBorderThickness;
                            i3 &= -3670017;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1461761386, i3, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox (TextFieldDefaults.kt:1482)");
                        }
                        int i8 = (i3 & 14) | 3072 | (i3 & 112) | (i3 & 896);
                        int i9 = i3 << 3;
                        int i10 = (i9 & 234881024) | i8 | (57344 & i9) | (458752 & i9) | (3670016 & i9) | (29360128 & i9);
                        InteractionSource interactionSource3 = interactionSource2;
                        textFieldColors2 = textFieldColorsColors;
                        shape3 = shape2;
                        f5 = f3;
                        f6 = f4;
                        m3922Container4EFweAY(z3, z4, interactionSource3, Modifier.INSTANCE, textFieldColors2, shape3, f5, f6, composerStartRestartGroup, i10, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i82 = (i3 & 14) | 3072 | (i3 & 112) | (i3 & 896);
                        int i92 = i3 << 3;
                        int i102 = (i92 & 234881024) | i82 | (57344 & i92) | (458752 & i92) | (3670016 & i92) | (29360128 & i92);
                        InteractionSource interactionSource32 = interactionSource2;
                        textFieldColors2 = textFieldColorsColors;
                        shape3 = shape2;
                        f5 = f3;
                        f6 = f4;
                        m3922Container4EFweAY(z3, z4, interactionSource32, Modifier.INSTANCE, textFieldColors2, shape3, f5, f6, composerStartRestartGroup, i102, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    textFieldColors2 = textFieldColorsColors;
                    shape3 = shape2;
                    f5 = f3;
                    f6 = f4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OutlinedTextFieldDefaults.ContainerBox_nbWgWpA$lambda$7(this.f$0, z, z2, interactionSource, textFieldColors2, shape3, f5, f6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 384;
            interactionSource2 = interactionSource;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            if ((1572864 & i) == 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        z4 = z2;
        if ((i2 & 4) != 0) {
        }
        interactionSource2 = interactionSource;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        if ((1572864 & i) == 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:276:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void DecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function29, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        boolean z4;
        int i5;
        final boolean z5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final TextFieldColors textFieldColors2;
        final PaddingValues paddingValues2;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function217;
        final TextFieldColors textFieldColorsColors;
        PaddingValues paddingValuesM3921contentPaddinga9UjIt4$default;
        PaddingValues paddingValues3;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        Function2<? super Composer, ? super Integer, Unit> function219;
        Function2<? super Composer, ? super Integer, Unit> function220;
        int i21;
        boolean z7;
        Function2<? super Composer, ? super Integer, Unit> function221;
        Function2<? super Composer, ? super Integer, Unit> function222;
        TextFieldColors textFieldColors3;
        Function2<? super Composer, ? super Integer, Unit> function223;
        boolean z8;
        Function2<? super Composer, ? super Integer, Unit> function224;
        boolean z9;
        int i22;
        ComposableLambda composableLambdaRememberComposableLambda;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1732281618);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DecorationBox)N(value,innerTextField,enabled,singleLine,visualTransformation,interactionSource,isError,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,colors,contentPadding,container)1170@61544L129,1176@61727L751:TextFieldDefaults.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
            }
            if ((i3 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                i4 |= composerStartRestartGroup.changed(z) ? 256 : 128;
            }
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    i4 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                int i23 = 8192;
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                }
                if ((i3 & 32) != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
                }
                i5 = i3 & 64;
                if (i5 != 0) {
                    i4 |= 1572864;
                    z5 = z3;
                } else {
                    z5 = z3;
                    if ((i & 1572864) == 0) {
                        i4 |= composerStartRestartGroup.changed(z5) ? 1048576 : 524288;
                    }
                }
                i6 = i3 & 128;
                if (i6 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                }
                i7 = i3 & 256;
                if (i7 != 0) {
                    i4 |= 100663296;
                } else {
                    if ((i & 100663296) == 0) {
                        i8 = i7;
                        i4 |= composerStartRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                    }
                    i9 = i3 & 512;
                    if (i9 == 0) {
                        i4 |= 805306368;
                    } else {
                        if ((i & 805306368) == 0) {
                            i10 = i9;
                            i4 |= composerStartRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                        }
                        i11 = i3 & 1024;
                        if (i11 != 0) {
                            i13 = i2 | 6;
                            i12 = i11;
                        } else if ((i2 & 6) == 0) {
                            i12 = i11;
                            i13 = i2 | (composerStartRestartGroup.changedInstance(function25) ? 4 : 2);
                        } else {
                            i12 = i11;
                            i13 = i2;
                        }
                        i14 = i3 & 2048;
                        if (i14 != 0) {
                            i13 |= 48;
                            i15 = i14;
                        } else if ((i2 & 48) == 0) {
                            i15 = i14;
                            i13 |= composerStartRestartGroup.changedInstance(function26) ? 32 : 16;
                        } else {
                            i15 = i14;
                        }
                        int i24 = i13;
                        i16 = i3 & 4096;
                        if (i16 != 0) {
                            i17 = i24 | 384;
                        } else if ((i2 & 384) == 0) {
                            i17 = i24 | (composerStartRestartGroup.changedInstance(function27) ? 256 : 128);
                        } else {
                            i17 = i24;
                        }
                        i18 = i3 & 8192;
                        if (i18 == 0) {
                            i19 = i17;
                            if ((i2 & 3072) == 0) {
                                i19 |= composerStartRestartGroup.changedInstance(function28) ? 2048 : 1024;
                            }
                            if ((i2 & 24576) == 0) {
                                if ((i3 & 16384) == 0 && composerStartRestartGroup.changed(textFieldColors)) {
                                    i23 = 16384;
                                }
                                i19 |= i23;
                            }
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i19 |= ((i3 & 32768) == 0 && composerStartRestartGroup.changed(paddingValues)) ? 131072 : 65536;
                            }
                            i20 = i3 & 65536;
                            if (i20 == 0) {
                                i19 |= 1572864;
                            } else if ((i2 & 1572864) == 0) {
                                i19 |= composerStartRestartGroup.changedInstance(function29) ? 1048576 : 524288;
                            }
                            if ((i3 & 131072) == 0) {
                                i19 |= 12582912;
                            } else if ((i2 & 12582912) == 0) {
                                i19 |= composerStartRestartGroup.changed(this) ? 8388608 : 4194304;
                            }
                            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i19 & 4793491) != 4793490, i4 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                function210 = function24;
                                function211 = function25;
                                function212 = function26;
                                function213 = function27;
                                function214 = function28;
                                textFieldColors2 = textFieldColors;
                                paddingValues2 = paddingValues;
                                function215 = function29;
                                z6 = z5;
                                function216 = function23;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "1154@60977L8,1156@61089L408");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i5 != 0) {
                                        z5 = false;
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function225 = i6 != 0 ? null : function22;
                                    function217 = i8 != 0 ? null : function23;
                                    Function2<? super Composer, ? super Integer, Unit> function226 = i10 != 0 ? null : function24;
                                    Function2<? super Composer, ? super Integer, Unit> function227 = i12 != 0 ? null : function25;
                                    Function2<? super Composer, ? super Integer, Unit> function228 = i15 != 0 ? null : function26;
                                    Function2<? super Composer, ? super Integer, Unit> function229 = i16 != 0 ? null : function27;
                                    Function2<? super Composer, ? super Integer, Unit> function230 = i18 != 0 ? null : function28;
                                    if ((i3 & 16384) != 0) {
                                        textFieldColorsColors = colors(composerStartRestartGroup, (i19 >> 21) & 14);
                                        i19 &= -57345;
                                    } else {
                                        textFieldColorsColors = textFieldColors;
                                    }
                                    if ((i3 & 32768) != 0) {
                                        paddingValuesM3921contentPaddinga9UjIt4$default = m3921contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        i19 &= -458753;
                                    } else {
                                        paddingValuesM3921contentPaddinga9UjIt4$default = paddingValues;
                                    }
                                    if (i20 != 0) {
                                        PaddingValues paddingValues4 = paddingValuesM3921contentPaddinga9UjIt4$default;
                                        Function2<? super Composer, ? super Integer, Unit> function231 = function225;
                                        TextFieldColors textFieldColors4 = textFieldColorsColors;
                                        ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox.1
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i25) {
                                                ComposerKt.sourceInformation(composer3, "C1163@61333L5,1157@61103L384:TextFieldDefaults.kt#uh7d8r");
                                                if (!composer3.shouldExecute((i25 & 3) != 2, i25 & 1)) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-896270173, i25, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox.<anonymous> (TextFieldDefaults.kt:1157)");
                                                }
                                                OutlinedTextFieldDefaults.INSTANCE.m3922Container4EFweAY(z, z5, interactionSource, Modifier.INSTANCE, textFieldColorsColors, OutlinedTextFieldDefaults.INSTANCE.getShape(composer3, 6), OutlinedTextFieldDefaults.INSTANCE.m3926getFocusedBorderThicknessD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m3929getUnfocusedBorderThicknessD9Ej5fM(), composer3, 114822144, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54);
                                        paddingValues3 = paddingValues4;
                                        function219 = function226;
                                        function220 = function229;
                                        i21 = i19;
                                        z7 = false;
                                        function221 = function230;
                                        function222 = function228;
                                        textFieldColors3 = textFieldColors4;
                                        function223 = composableLambdaRememberComposableLambda2;
                                        z8 = z5;
                                        function224 = function227;
                                        z9 = true;
                                        function218 = function231;
                                    } else {
                                        TextFieldColors textFieldColors5 = textFieldColorsColors;
                                        paddingValues3 = paddingValuesM3921contentPaddinga9UjIt4$default;
                                        function218 = function225;
                                        function219 = function226;
                                        function220 = function229;
                                        i21 = i19;
                                        z7 = false;
                                        function221 = function230;
                                        function222 = function228;
                                        textFieldColors3 = textFieldColors5;
                                        function223 = function29;
                                        z8 = z5;
                                        function224 = function227;
                                        z9 = true;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i3 & 16384) != 0) {
                                        i19 &= -57345;
                                    }
                                    if ((32768 & i3) != 0) {
                                        i19 &= -458753;
                                    }
                                    function218 = function22;
                                    function217 = function23;
                                    function219 = function24;
                                    function222 = function26;
                                    function220 = function27;
                                    function221 = function28;
                                    paddingValues3 = paddingValues;
                                    function223 = function29;
                                    z8 = z5;
                                    i21 = i19;
                                    z7 = false;
                                    z9 = true;
                                    function224 = function25;
                                    textFieldColors3 = textFieldColors;
                                }
                                composerStartRestartGroup.endDefaults();
                                Function2<? super Composer, ? super Integer, Unit> function232 = function220;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1732281618, i4, i21, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1168)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1724716623, "CC(remember):TextFieldDefaults.kt#9igjgp");
                                boolean z10 = (i4 & 14) == 4 ? z9 : z7;
                                if ((57344 & i4) == 16384) {
                                    z7 = z9;
                                }
                                boolean z11 = z10 | z7;
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    i22 = i21;
                                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, 2, null));
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    i22 = i21;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                String text = ((TransformedText) objRememberedValue).getText().getText();
                                TextFieldType textFieldType = TextFieldType.Outlined;
                                TextFieldLabelPosition.Attached attached = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
                                if (function218 == null) {
                                    composerStartRestartGroup.startReplaceGroup(1927058812);
                                    composerStartRestartGroup.endReplaceGroup();
                                    function22 = function218;
                                    composableLambdaRememberComposableLambda = null;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1927058813);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*1182@62008L15");
                                    function22 = function218;
                                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1459717586, z9, new Function3<TextFieldLabelScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$2$1
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldLabelScope textFieldLabelScope, Composer composer3, Integer num) {
                                            invoke(textFieldLabelScope, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(TextFieldLabelScope textFieldLabelScope, Composer composer3, int i25) {
                                            ComposerKt.sourceInformation(composer3, "C1182@62013L8:TextFieldDefaults.kt#uh7d8r");
                                            if (!composer3.shouldExecute((i25 & 17) != 16, i25 & 1)) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1459717586, i25, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox.<anonymous>.<anonymous> (TextFieldDefaults.kt:1182)");
                                            }
                                            function218.invoke(composer3, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                int i25 = i4 >> 9;
                                int i26 = i22 << 21;
                                int i27 = ((i4 << 3) & 896) | 6 | (458752 & i25) | (3670016 & i25) | (i26 & 29360128) | (i26 & 234881024) | (i26 & 1879048192);
                                int i28 = (i4 & 896) | ((i22 >> 9) & 14) | ((i4 >> 6) & 112) | (i25 & 7168) | ((i4 >> 3) & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128);
                                composer2 = composerStartRestartGroup;
                                Function2<? super Composer, ? super Integer, Unit> function233 = function217;
                                TextFieldImplKt.CommonDecorationBox(textFieldType, text, function2, attached, composableLambdaRememberComposableLambda, function233, function219, function224, function222, function232, function221, z4, z, z8, interactionSource, paddingValues3, textFieldColors3, function223, composer2, i27, i28);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function213 = function232;
                                function214 = function221;
                                paddingValues2 = paddingValues3;
                                function215 = function223;
                                function211 = function224;
                                function212 = function222;
                                function216 = function233;
                                function210 = function219;
                                z6 = z8;
                                textFieldColors2 = textFieldColors3;
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function234 = function22;
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return OutlinedTextFieldDefaults.DecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z6, function234, function216, function210, function211, function212, function213, function214, textFieldColors2, paddingValues2, function215, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i19 = i17 | 3072;
                        if ((i2 & 24576) == 0) {
                        }
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        }
                        i20 = i3 & 65536;
                        if (i20 == 0) {
                        }
                        if ((i3 & 131072) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i19 & 4793491) != 4793490, i4 & 1)) {
                        }
                        final Function2 function2342 = function22;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i10 = i9;
                    i11 = i3 & 1024;
                    if (i11 != 0) {
                    }
                    i14 = i3 & 2048;
                    if (i14 != 0) {
                    }
                    int i242 = i13;
                    i16 = i3 & 4096;
                    if (i16 != 0) {
                    }
                    i18 = i3 & 8192;
                    if (i18 == 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    i20 = i3 & 65536;
                    if (i20 == 0) {
                    }
                    if ((i3 & 131072) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i19 & 4793491) != 4793490, i4 & 1)) {
                    }
                    final Function2 function23422 = function22;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i8 = i7;
                i9 = i3 & 512;
                if (i9 == 0) {
                }
                i10 = i9;
                i11 = i3 & 1024;
                if (i11 != 0) {
                }
                i14 = i3 & 2048;
                if (i14 != 0) {
                }
                int i2422 = i13;
                i16 = i3 & 4096;
                if (i16 != 0) {
                }
                i18 = i3 & 8192;
                if (i18 == 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i20 = i3 & 65536;
                if (i20 == 0) {
                }
                if ((i3 & 131072) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i19 & 4793491) != 4793490, i4 & 1)) {
                }
                final Function2 function234222 = function22;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z4 = z2;
            int i232 = 8192;
            if ((i3 & 16) != 0) {
            }
            if ((i3 & 32) != 0) {
            }
            i5 = i3 & 64;
            if (i5 != 0) {
            }
            i6 = i3 & 128;
            if (i6 != 0) {
            }
            i7 = i3 & 256;
            if (i7 != 0) {
            }
            i8 = i7;
            i9 = i3 & 512;
            if (i9 == 0) {
            }
            i10 = i9;
            i11 = i3 & 1024;
            if (i11 != 0) {
            }
            i14 = i3 & 2048;
            if (i14 != 0) {
            }
            int i24222 = i13;
            i16 = i3 & 4096;
            if (i16 != 0) {
            }
            i18 = i3 & 8192;
            if (i18 == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i20 = i3 & 65536;
            if (i20 == 0) {
            }
            if ((i3 & 131072) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i19 & 4793491) != 4793490, i4 & 1)) {
            }
            final Function2 function2342222 = function22;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) == 0) {
        }
        z4 = z2;
        int i2322 = 8192;
        if ((i3 & 16) != 0) {
        }
        if ((i3 & 32) != 0) {
        }
        i5 = i3 & 64;
        if (i5 != 0) {
        }
        i6 = i3 & 128;
        if (i6 != 0) {
        }
        i7 = i3 & 256;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i3 & 512;
        if (i9 == 0) {
        }
        i10 = i9;
        i11 = i3 & 1024;
        if (i11 != 0) {
        }
        i14 = i3 & 2048;
        if (i14 != 0) {
        }
        int i242222 = i13;
        i16 = i3 & 4096;
        if (i16 != 0) {
        }
        i18 = i3 & 8192;
        if (i18 == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i20 = i3 & 65536;
        if (i20 == 0) {
        }
        if ((i3 & 131072) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i19 & 4793491) != 4793490, i4 & 1)) {
        }
        final Function2 function23422222 = function22;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    public final TextFieldColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -471651810, "C(colors)1215@63265L11,1215@63277L30:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-471651810, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1215)");
        }
        TextFieldColors defaultOutlinedTextFieldColors = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultOutlinedTextFieldColors;
    }

    /* JADX INFO: renamed from: colors-0hiis_0, reason: not valid java name */
    public final TextFieldColors m3924colors0hiis_0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        long j43;
        TextSelectionColors textSelectionColors2;
        ComposerKt.sourceInformationMarkerStart(composer, 1767617725, "C(colors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,errorTextColor:c#ui.graphics.Color,focusedContainerColor:c#ui.graphics.Color,unfocusedContainerColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,errorContainerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedBorderColor:c#ui.graphics.Color,unfocusedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,errorBorderColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,errorPlaceholderColor:c#ui.graphics.Color,focusedSupportingTextColor:c#ui.graphics.Color,unfocusedSupportingTextColor:c#ui.graphics.Color,disabledSupportingTextColor:c#ui.graphics.Color,errorSupportingTextColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,errorPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,errorSuffixColor:c#ui.graphics.Color)1317@70088L11,1317@70100L30:TextFieldDefaults.kt#uh7d8r");
        long jM6361getUnspecified0d7_KjU = (i6 & 1) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j;
        long jM6361getUnspecified0d7_KjU2 = (i6 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j2;
        long jM6361getUnspecified0d7_KjU3 = (i6 & 4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j3;
        long jM6361getUnspecified0d7_KjU4 = (i6 & 8) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j4;
        long jM6361getUnspecified0d7_KjU5 = (i6 & 16) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j5;
        long jM6361getUnspecified0d7_KjU6 = (i6 & 32) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j6;
        long jM6361getUnspecified0d7_KjU7 = (i6 & 64) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j7;
        long jM6361getUnspecified0d7_KjU8 = (i6 & 128) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j8;
        long jM6361getUnspecified0d7_KjU9 = (i6 & 256) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j9;
        long jM6361getUnspecified0d7_KjU10 = (i6 & 512) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j10;
        TextSelectionColors textSelectionColors3 = (i6 & 1024) != 0 ? null : textSelectionColors;
        long jM6361getUnspecified0d7_KjU11 = (i6 & 2048) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j11;
        long jM6361getUnspecified0d7_KjU12 = (i6 & 4096) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j12;
        long jM6361getUnspecified0d7_KjU13 = (i6 & 8192) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j13;
        long jM6361getUnspecified0d7_KjU14 = (i6 & 16384) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j14;
        long jM6361getUnspecified0d7_KjU15 = (32768 & i6) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j15;
        long jM6361getUnspecified0d7_KjU16 = (65536 & i6) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j16;
        long jM6361getUnspecified0d7_KjU17 = (131072 & i6) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j17;
        long jM6361getUnspecified0d7_KjU18 = (262144 & i6) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j18;
        long jM6361getUnspecified0d7_KjU19 = (524288 & i6) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j19;
        long jM6361getUnspecified0d7_KjU20 = (1048576 & i6) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j20;
        long jM6361getUnspecified0d7_KjU21 = (2097152 & i6) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j21;
        long jM6361getUnspecified0d7_KjU22 = (4194304 & i6) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j22;
        long jM6361getUnspecified0d7_KjU23 = (8388608 & i6) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j23;
        long jM6361getUnspecified0d7_KjU24 = (16777216 & i6) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j24;
        long jM6361getUnspecified0d7_KjU25 = (33554432 & i6) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j25;
        long jM6361getUnspecified0d7_KjU26 = (67108864 & i6) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j26;
        long jM6361getUnspecified0d7_KjU27 = (134217728 & i6) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j27;
        long jM6361getUnspecified0d7_KjU28 = (268435456 & i6) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j28;
        long jM6361getUnspecified0d7_KjU29 = (536870912 & i6) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j29;
        long jM6361getUnspecified0d7_KjU30 = (i6 & 1073741824) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j30;
        long jM6361getUnspecified0d7_KjU31 = (i7 & 1) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j31;
        long jM6361getUnspecified0d7_KjU32 = (i7 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j32;
        long jM6361getUnspecified0d7_KjU33 = (i7 & 4) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j33;
        long jM6361getUnspecified0d7_KjU34 = (i7 & 8) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j34;
        long jM6361getUnspecified0d7_KjU35 = (i7 & 16) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j35;
        long jM6361getUnspecified0d7_KjU36 = (i7 & 32) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j36;
        long jM6361getUnspecified0d7_KjU37 = (i7 & 64) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j37;
        long jM6361getUnspecified0d7_KjU38 = (i7 & 128) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j38;
        long jM6361getUnspecified0d7_KjU39 = (i7 & 256) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j39;
        long jM6361getUnspecified0d7_KjU40 = (i7 & 512) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j40;
        long jM6361getUnspecified0d7_KjU41 = (i7 & 1024) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j41;
        long jM6361getUnspecified0d7_KjU42 = (i7 & 2048) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j42;
        if (ComposerKt.isTraceInProgress()) {
            j43 = jM6361getUnspecified0d7_KjU42;
            textSelectionColors2 = textSelectionColors3;
            ComposerKt.traceEventStart(1767617725, i, i2, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1317)");
        } else {
            j43 = jM6361getUnspecified0d7_KjU42;
            textSelectionColors2 = textSelectionColors3;
        }
        TextFieldColors textFieldColorsM4204copyejIjP34 = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i5 >> 6) & 112).m4204copyejIjP34(jM6361getUnspecified0d7_KjU, jM6361getUnspecified0d7_KjU2, jM6361getUnspecified0d7_KjU3, jM6361getUnspecified0d7_KjU4, jM6361getUnspecified0d7_KjU5, jM6361getUnspecified0d7_KjU6, jM6361getUnspecified0d7_KjU7, jM6361getUnspecified0d7_KjU8, jM6361getUnspecified0d7_KjU9, jM6361getUnspecified0d7_KjU10, textSelectionColors2, jM6361getUnspecified0d7_KjU11, jM6361getUnspecified0d7_KjU12, jM6361getUnspecified0d7_KjU13, jM6361getUnspecified0d7_KjU14, jM6361getUnspecified0d7_KjU15, jM6361getUnspecified0d7_KjU16, jM6361getUnspecified0d7_KjU17, jM6361getUnspecified0d7_KjU18, jM6361getUnspecified0d7_KjU19, jM6361getUnspecified0d7_KjU20, jM6361getUnspecified0d7_KjU21, jM6361getUnspecified0d7_KjU22, jM6361getUnspecified0d7_KjU23, jM6361getUnspecified0d7_KjU24, jM6361getUnspecified0d7_KjU25, jM6361getUnspecified0d7_KjU26, jM6361getUnspecified0d7_KjU27, jM6361getUnspecified0d7_KjU28, jM6361getUnspecified0d7_KjU29, jM6361getUnspecified0d7_KjU30, jM6361getUnspecified0d7_KjU31, jM6361getUnspecified0d7_KjU32, jM6361getUnspecified0d7_KjU33, jM6361getUnspecified0d7_KjU34, jM6361getUnspecified0d7_KjU35, jM6361getUnspecified0d7_KjU36, jM6361getUnspecified0d7_KjU37, jM6361getUnspecified0d7_KjU38, jM6361getUnspecified0d7_KjU39, jM6361getUnspecified0d7_KjU40, jM6361getUnspecified0d7_KjU41, j43);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM4204copyejIjP34;
    }

    /* JADX INFO: renamed from: contentPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m3925contentPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m2033PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    public final TextFieldDecorator decorator(TextFieldState textFieldState, boolean z, TextFieldLineLimits textFieldLineLimits, OutputTransformation outputTransformation, InteractionSource interactionSource, TextFieldLabelPosition textFieldLabelPosition, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, boolean z2, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function27, Composer composer, int i, int i2, int i3) {
        OutlinedTextFieldDefaults outlinedTextFieldDefaults;
        final TextFieldColors textFieldColorsColors;
        final boolean z3;
        final InteractionSource interactionSource2;
        boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        ComposerKt.sourceInformationMarkerStart(composer, -449059361, "C(decorator)N(state,enabled,lineLimits,outputTransformation,interactionSource,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,colors,contentPadding,container)980@51820L8,982@51932L371:TextFieldDefaults.kt#uh7d8r");
        TextFieldLabelPosition attached = (i3 & 32) != 0 ? new TextFieldLabelPosition.Attached(false, null, null, 7, null) : textFieldLabelPosition;
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function32 = (i3 & 64) != 0 ? null : function3;
        Function2<? super Composer, ? super Integer, Unit> function28 = (i3 & 128) != 0 ? null : function2;
        Function2<? super Composer, ? super Integer, Unit> function29 = (i3 & 256) != 0 ? null : function22;
        Function2<? super Composer, ? super Integer, Unit> function210 = (i3 & 512) != 0 ? null : function23;
        Function2<? super Composer, ? super Integer, Unit> function211 = (i3 & 1024) != 0 ? null : function24;
        Function2<? super Composer, ? super Integer, Unit> function212 = (i3 & 2048) != 0 ? null : function25;
        Function2<? super Composer, ? super Integer, Unit> function213 = (i3 & 4096) != 0 ? null : function26;
        final boolean z5 = (i3 & 8192) != 0 ? false : z2;
        if ((i3 & 16384) != 0) {
            outlinedTextFieldDefaults = this;
            textFieldColorsColors = outlinedTextFieldDefaults.colors(composer, (i2 >> 21) & 14);
        } else {
            outlinedTextFieldDefaults = this;
            textFieldColorsColors = textFieldColors;
        }
        PaddingValues paddingValuesM3921contentPaddinga9UjIt4$default = (32768 & i3) != 0 ? m3921contentPaddinga9UjIt4$default(outlinedTextFieldDefaults, 0.0f, 0.0f, 0.0f, 0.0f, 15, null) : paddingValues;
        if ((i3 & 65536) != 0) {
            z3 = z;
            interactionSource2 = interactionSource;
            z4 = z5;
            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-163468598, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults.decorator.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposerKt.sourceInformation(composer2, "C988@52139L5,983@51946L347:TextFieldDefaults.kt#uh7d8r");
                    if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-163468598, i4, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.decorator.<anonymous> (TextFieldDefaults.kt:983)");
                    }
                    OutlinedTextFieldDefaults.INSTANCE.m3922Container4EFweAY(z3, z5, interactionSource2, null, textFieldColorsColors, OutlinedTextFieldDefaults.INSTANCE.getShape(composer2, 6), OutlinedTextFieldDefaults.INSTANCE.m3926getFocusedBorderThicknessD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m3929getUnfocusedBorderThicknessD9Ej5fM(), composer2, 114819072, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54);
        } else {
            z3 = z;
            interactionSource2 = interactionSource;
            z4 = z5;
            function2RememberComposableLambda = function27;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-449059361, i, i2, "androidx.compose.material3.OutlinedTextFieldDefaults.decorator (TextFieldDefaults.kt:993)");
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(outputTransformation, textFieldState, textFieldLineLimits, attached, function32, function28, function29, function210, function211, function212, function213, z3, z4, interactionSource2, paddingValuesM3921contentPaddinga9UjIt4$default, textFieldColorsColors, function2RememberComposableLambda);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return anonymousClass2;
    }

    public final TextFieldColors getDefaultOutlinedTextFieldColors(ColorScheme colorScheme, Composer composer, int i) {
        TextFieldColors textFieldColors;
        ComposerKt.sourceInformationMarkerStart(composer, -292363577, "C(<get-defaultOutlinedTextFieldColors>):TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-292363577, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-defaultOutlinedTextFieldColors> (TextFieldDefaults.kt:1365)");
        }
        TextFieldColors defaultOutlinedTextFieldColorsCached = colorScheme.getDefaultOutlinedTextFieldColorsCached();
        if (defaultOutlinedTextFieldColorsCached == null) {
            composer.startReplaceGroup(390452338);
            composer.endReplaceGroup();
            textFieldColors = null;
        } else {
            composer.startReplaceGroup(390452339);
            ComposerKt.sourceInformation(composer, "*1367@72895L7");
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextSelectionColors textSelectionColors = (TextSelectionColors) objConsume;
            if (!Intrinsics.areEqual(defaultOutlinedTextFieldColorsCached.getTextSelectionColors(), textSelectionColors)) {
                defaultOutlinedTextFieldColorsCached = TextFieldColors.m4202copyejIjP34$default(defaultOutlinedTextFieldColorsCached, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, textSelectionColors, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1025, 2047, null);
                colorScheme.setDefaultOutlinedTextFieldColorsCached$material3(defaultOutlinedTextFieldColorsCached);
            }
            composer.endReplaceGroup();
            textFieldColors = defaultOutlinedTextFieldColorsCached;
        }
        if (textFieldColors == null) {
            composer.startReplaceGroup(-1788321191);
            ComposerKt.sourceInformation(composer, "1389@74318L7");
            long jFromToken = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusInputColor());
            long jFromToken2 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputColor());
            long jM6324copywmQWz5c$default = Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null);
            long jFromToken3 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorInputColor());
            long jM6360getTransparent0d7_KjU = Color.INSTANCE.m6360getTransparent0d7_KjU();
            long jM6360getTransparent0d7_KjU2 = Color.INSTANCE.m6360getTransparent0d7_KjU();
            long jM6360getTransparent0d7_KjU3 = Color.INSTANCE.m6360getTransparent0d7_KjU();
            long jM6360getTransparent0d7_KjU4 = Color.INSTANCE.m6360getTransparent0d7_KjU();
            long jFromToken4 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getCaretColor());
            long jFromToken5 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor());
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors2 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localTextSelectionColors2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldColors textFieldColors2 = new TextFieldColors(jFromToken, jFromToken2, jM6324copywmQWz5c$default, jFromToken3, jM6360getTransparent0d7_KjU, jM6360getTransparent0d7_KjU2, jM6360getTransparent0d7_KjU3, jM6360getTransparent0d7_KjU4, jFromToken4, jFromToken5, (TextSelectionColors) objConsume2, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getOutlineColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getLabelColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getSupportingColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), Color.m6324copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), null);
            colorScheme.setDefaultOutlinedTextFieldColorsCached$material3(textFieldColors2);
            composer.endReplaceGroup();
            textFieldColors = textFieldColors2;
        } else {
            composer.startReplaceGroup(-1788515437);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColors;
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m3926getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m3927getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m3928getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1066756961, "C(<get-shape>)887@46101L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1066756961, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:887)");
        }
        Shape value = ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m3929getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }
}
