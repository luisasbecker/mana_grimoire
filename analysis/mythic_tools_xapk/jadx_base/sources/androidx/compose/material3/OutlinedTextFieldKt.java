package androidx.compose.material3;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.TextFieldLabelPosition;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OutlinedTextField.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a£\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2 \b\u0002\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#28\b\u0002\u0010$\u001a2\u0012\u0004\u0012\u00020&\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010'0\u0013¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0001\u0018\u00010%¢\u0006\u0002\b\u00112\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u000104H\u0007¢\u0006\u0002\u00105\u001aØ\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020\u00072\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u0010A\u001aØ\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u00106\u001a\u00020B2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020\u00072\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u0010C\u001a\u0088\u0002\u0010D\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010E\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u00102\u0019\u0010\u0012\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u00102\u0013\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010F\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010G\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0006\u0010=\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010H\u001a\u00020I2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00010\u000e2\u0011\u0010L\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010M\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0006\u0010N\u001a\u000202H\u0001¢\u0006\u0002\u0010O\u001a*\u0010P\u001a\u00020\u0005*\u00020\u00052\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020K0\u00132\u0006\u0010R\u001a\u00020S2\u0006\u0010N\u001a\u000202H\u0000\"\u0010\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0004\n\u0002\u0010V¨\u0006W"}, d2 = {"OutlinedTextField", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", Constants.ScionAnalytics.PARAM_LABEL, "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "placeholder", "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;IIII)V", "value", "", "onValueChange", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "labelProgress", "Landroidx/compose/material3/internal/FloatProducer;", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "container", "supporting", "paddingValues", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/TextFieldLabelPosition;Landroidx/compose/material3/internal/FloatProducer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "outlineCutout", "labelSize", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class OutlinedTextFieldKt {
    private static final float OutlinedTextFieldInnerPadding = Dp.m9114constructorimpl(4.0f);

    /* JADX INFO: renamed from: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$1, reason: invalid class name */
    /* JADX INFO: compiled from: OutlinedTextField.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InputTransformation $inputTransformation;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ KeyboardOptions $keyboardOptions;
        final /* synthetic */ Function3<TextFieldLabelScope, Composer, Integer, Unit> $label;
        final /* synthetic */ TextFieldLabelPosition $labelPosition;
        final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
        final /* synthetic */ TextFieldLineLimits $lineLimits;
        final /* synthetic */ TextStyle $mergedTextStyle;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ KeyboardActionHandler $onKeyboardAction;
        final /* synthetic */ Function2<Density, Function0<TextLayoutResult>, Unit> $onTextLayout;
        final /* synthetic */ OutputTransformation $outputTransformation;
        final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
        final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
        final /* synthetic */ boolean $readOnly;
        final /* synthetic */ ScrollState $scrollState;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
        final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
        final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Modifier modifier, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, TextFieldLabelPosition textFieldLabelPosition, boolean z, TextFieldColors textFieldColors, TextFieldState textFieldState, boolean z2, TextFieldLineLimits textFieldLineLimits, OutputTransformation outputTransformation, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, PaddingValues paddingValues, boolean z3, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function27, ScrollState scrollState, Shape shape) {
            this.$modifier = modifier;
            this.$label = function3;
            this.$labelPosition = textFieldLabelPosition;
            this.$isError = z;
            this.$colors = textFieldColors;
            this.$state = textFieldState;
            this.$enabled = z2;
            this.$lineLimits = textFieldLineLimits;
            this.$outputTransformation = outputTransformation;
            this.$interactionSource = mutableInteractionSource;
            this.$placeholder = function2;
            this.$leadingIcon = function22;
            this.$trailingIcon = function23;
            this.$prefix = function24;
            this.$suffix = function25;
            this.$supportingText = function26;
            this.$contentPadding = paddingValues;
            this.$readOnly = z3;
            this.$inputTransformation = inputTransformation;
            this.$mergedTextStyle = textStyle;
            this.$keyboardOptions = keyboardOptions;
            this.$onKeyboardAction = keyboardActionHandler;
            this.$onTextLayout = function27;
            this.$scrollState = scrollState;
            this.$shape = shape;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            Modifier.Companion companionM2041paddingqDBjuR0$default;
            ComposerKt.sourceInformation(composer, "C255@14761L38,290@16390L359,273@15619L1149,240@14014L2765:OutlinedTextField.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-416142558, i, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:240)");
            }
            Modifier modifier = this.$modifier;
            if (this.$label == null || (this.$labelPosition instanceof TextFieldLabelPosition.Above)) {
                composer.startReplaceGroup(-2026714080);
                composer.endReplaceGroup();
                companionM2041paddingqDBjuR0$default = Modifier.INSTANCE;
            } else {
                composer.startReplaceGroup(-2027097767);
                ComposerKt.sourceInformation(composer, "249@14513L2,250@14563L26");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -481023420, "CC(remember):OutlinedTextField.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Unit.INSTANCE;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                companionM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue), 0.0f, TextFieldImplKt.minimizedLabelHalfHeight(composer, 0), 0.0f, 0.0f, 13, null);
                composer.endReplaceGroup();
            }
            Modifier modifierThen = modifier.then(companionM2041paddingqDBjuR0$default);
            boolean z = this.$isError;
            Strings.Companion companion2 = Strings.INSTANCE;
            Modifier modifierM2067defaultMinSizeVpY3zN4 = SizeKt.m2067defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifierThen, z, Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(androidx.compose.ui.R.string.default_error_message), composer, 0)), OutlinedTextFieldDefaults.INSTANCE.m3928getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m3927getMinHeightD9Ej5fM());
            SolidColor solidColor = new SolidColor(this.$colors.m4205cursorColorvNxB06k$material3(this.$isError), null);
            OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
            TextFieldState textFieldState = this.$state;
            boolean z2 = this.$enabled;
            TextFieldLineLimits textFieldLineLimits = this.$lineLimits;
            OutputTransformation outputTransformation = this.$outputTransformation;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            TextFieldLabelPosition textFieldLabelPosition = this.$labelPosition;
            Function3<TextFieldLabelScope, Composer, Integer, Unit> function3 = this.$label;
            Function2<Composer, Integer, Unit> function2 = this.$placeholder;
            Function2<Composer, Integer, Unit> function22 = this.$leadingIcon;
            Function2<Composer, Integer, Unit> function23 = this.$trailingIcon;
            Function2<Composer, Integer, Unit> function24 = this.$prefix;
            Function2<Composer, Integer, Unit> function25 = this.$suffix;
            Function2<Composer, Integer, Unit> function26 = this.$supportingText;
            boolean z3 = this.$isError;
            TextFieldColors textFieldColors = this.$colors;
            PaddingValues paddingValues = this.$contentPadding;
            final boolean z4 = this.$enabled;
            final boolean z5 = this.$isError;
            final MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
            final TextFieldColors textFieldColors2 = this.$colors;
            final Shape shape = this.$shape;
            BasicTextFieldKt.BasicTextField(this.$state, modifierM2067defaultMinSizeVpY3zN4, this.$enabled, this.$readOnly, this.$inputTransformation, this.$mergedTextStyle, this.$keyboardOptions, this.$onKeyboardAction, this.$lineLimits, this.$onTextLayout, this.$interactionSource, solidColor, this.$outputTransformation, outlinedTextFieldDefaults.decorator(textFieldState, z2, textFieldLineLimits, outputTransformation, mutableInteractionSource, textFieldLabelPosition, function3, function2, function22, function23, function24, function25, function26, z3, textFieldColors, paddingValues, ComposableLambdaKt.rememberComposableLambda(-98391231, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.1.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C291@16442L285:OutlinedTextField.kt#uh7d8r");
                    if (!composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-98391231, i2, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:291)");
                    }
                    OutlinedTextFieldDefaults.INSTANCE.m3922Container4EFweAY(z4, z5, mutableInteractionSource2, null, textFieldColors2, shape, 0.0f, 0.0f, composer2, 100663296, 200);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54), composer, 0, 14155776, 0), this.$scrollState, composer, 0, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$3, reason: invalid class name */
    /* JADX INFO: compiled from: OutlinedTextField.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass3 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ KeyboardActions $keyboardActions;
        final /* synthetic */ KeyboardOptions $keyboardOptions;
        final /* synthetic */ Function2<Composer, Integer, Unit> $label;
        final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
        final /* synthetic */ int $maxLines;
        final /* synthetic */ TextStyle $mergedTextStyle;
        final /* synthetic */ int $minLines;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Function1<String, Unit> $onValueChange;
        final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
        final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
        final /* synthetic */ boolean $readOnly;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
        final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
        final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
        final /* synthetic */ String $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, TextFieldColors textFieldColors, String str, Function1<? super String, Unit> function1, boolean z2, boolean z3, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Shape shape) {
            this.$modifier = modifier;
            this.$label = function2;
            this.$isError = z;
            this.$colors = textFieldColors;
            this.$value = str;
            this.$onValueChange = function1;
            this.$enabled = z2;
            this.$readOnly = z3;
            this.$mergedTextStyle = textStyle;
            this.$keyboardOptions = keyboardOptions;
            this.$keyboardActions = keyboardActions;
            this.$singleLine = z4;
            this.$maxLines = i;
            this.$minLines = i2;
            this.$visualTransformation = visualTransformation;
            this.$interactionSource = mutableInteractionSource;
            this.$placeholder = function22;
            this.$leadingIcon = function23;
            this.$trailingIcon = function24;
            this.$prefix = function25;
            this.$suffix = function26;
            this.$supportingText = function27;
            this.$shape = shape;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            Modifier.Companion companionM2041paddingqDBjuR0$default;
            ComposerKt.sourceInformation(composer, "C420@23824L38,438@24644L1286,405@23127L2814:OutlinedTextField.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1874034984, i, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:405)");
            }
            Modifier modifier = this.$modifier;
            if (this.$label != null) {
                composer.startReplaceGroup(-903490605);
                ComposerKt.sourceInformation(composer, "414@23576L2,415@23626L26");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 1356337290, "CC(remember):OutlinedTextField.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$3$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Unit.INSTANCE;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                companionM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue), 0.0f, TextFieldImplKt.minimizedLabelHalfHeight(composer, 0), 0.0f, 0.0f, 13, null);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-903106918);
                composer.endReplaceGroup();
                companionM2041paddingqDBjuR0$default = Modifier.INSTANCE;
            }
            Modifier modifierThen = modifier.then(companionM2041paddingqDBjuR0$default);
            boolean z = this.$isError;
            Strings.Companion companion2 = Strings.INSTANCE;
            Modifier modifierM2067defaultMinSizeVpY3zN4 = SizeKt.m2067defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifierThen, z, Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(androidx.compose.ui.R.string.default_error_message), composer, 0)), OutlinedTextFieldDefaults.INSTANCE.m3928getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m3927getMinHeightD9Ej5fM());
            SolidColor solidColor = new SolidColor(this.$colors.m4205cursorColorvNxB06k$material3(this.$isError), null);
            final String str = this.$value;
            final boolean z2 = this.$enabled;
            final boolean z3 = this.$singleLine;
            final VisualTransformation visualTransformation = this.$visualTransformation;
            final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            final boolean z4 = this.$isError;
            final Function2<Composer, Integer, Unit> function2 = this.$label;
            final Function2<Composer, Integer, Unit> function22 = this.$placeholder;
            final Function2<Composer, Integer, Unit> function23 = this.$leadingIcon;
            final Function2<Composer, Integer, Unit> function24 = this.$trailingIcon;
            final Function2<Composer, Integer, Unit> function25 = this.$prefix;
            final Function2<Composer, Integer, Unit> function26 = this.$suffix;
            final Function2<Composer, Integer, Unit> function27 = this.$supportingText;
            final TextFieldColors textFieldColors = this.$colors;
            final Shape shape = this.$shape;
            BasicTextFieldKt.BasicTextField(this.$value, this.$onValueChange, modifierM2067defaultMinSizeVpY3zN4, this.$enabled, this.$readOnly, this.$mergedTextStyle, this.$keyboardOptions, this.$keyboardActions, this.$singleLine, this.$maxLines, this.$minLines, this.$visualTransformation, (Function1<? super TextLayoutResult, Unit>) null, this.$interactionSource, solidColor, ComposableLambdaKt.rememberComposableLambda(-1189274459, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.3.2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function28, Composer composer2, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function28, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function28, Composer composer2, int i2) {
                    int i3;
                    ComposerKt.sourceInformation(composer2, "CN(innerTextField)455@25498L391,439@24710L1202:OutlinedTextField.kt#uh7d8r");
                    if ((i2 & 6) == 0) {
                        i3 = i2 | (composer2.changedInstance(function28) ? 4 : 2);
                    } else {
                        i3 = i2;
                    }
                    if (!composer2.shouldExecute((i3 & 19) != 18, i3 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1189274459, i3, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:439)");
                    }
                    OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                    String str2 = str;
                    int i4 = i3;
                    boolean z5 = z2;
                    boolean z6 = z3;
                    VisualTransformation visualTransformation2 = visualTransformation;
                    MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                    boolean z7 = z4;
                    Function2<Composer, Integer, Unit> function29 = function2;
                    Function2<Composer, Integer, Unit> function210 = function22;
                    Function2<Composer, Integer, Unit> function211 = function23;
                    Function2<Composer, Integer, Unit> function212 = function24;
                    Function2<Composer, Integer, Unit> function213 = function25;
                    Function2<Composer, Integer, Unit> function214 = function26;
                    Function2<Composer, Integer, Unit> function215 = function27;
                    TextFieldColors textFieldColors2 = textFieldColors;
                    final boolean z8 = z2;
                    final boolean z9 = z4;
                    final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
                    final TextFieldColors textFieldColors3 = textFieldColors;
                    final Shape shape2 = shape;
                    outlinedTextFieldDefaults.DecorationBox(str2, function28, z5, z6, visualTransformation2, mutableInteractionSource2, z7, function29, function210, function211, function212, function213, function214, function215, textFieldColors2, null, ComposableLambdaKt.rememberComposableLambda(-656940872, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.3.2.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i5) {
                            ComposerKt.sourceInformation(composer3, "C456@25554L309:OutlinedTextField.kt#uh7d8r");
                            if (!composer3.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-656940872, i5, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:456)");
                            }
                            OutlinedTextFieldDefaults.INSTANCE.m3922Container4EFweAY(z8, z9, mutableInteractionSource3, null, textFieldColors3, shape2, 0.0f, 0.0f, composer3, 100663296, 200);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, (i4 << 3) & 112, 14155776, 32768);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54), composer, 0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5, reason: invalid class name */
    /* JADX INFO: compiled from: OutlinedTextField.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass5 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ KeyboardActions $keyboardActions;
        final /* synthetic */ KeyboardOptions $keyboardOptions;
        final /* synthetic */ Function2<Composer, Integer, Unit> $label;
        final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
        final /* synthetic */ int $maxLines;
        final /* synthetic */ TextStyle $mergedTextStyle;
        final /* synthetic */ int $minLines;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Function1<TextFieldValue, Unit> $onValueChange;
        final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
        final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
        final /* synthetic */ boolean $readOnly;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
        final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
        final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
        final /* synthetic */ TextFieldValue $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass5(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, TextFieldColors textFieldColors, TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, boolean z2, boolean z3, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Shape shape) {
            this.$modifier = modifier;
            this.$label = function2;
            this.$isError = z;
            this.$colors = textFieldColors;
            this.$value = textFieldValue;
            this.$onValueChange = function1;
            this.$enabled = z2;
            this.$readOnly = z3;
            this.$mergedTextStyle = textStyle;
            this.$keyboardOptions = keyboardOptions;
            this.$keyboardActions = keyboardActions;
            this.$singleLine = z4;
            this.$maxLines = i;
            this.$minLines = i2;
            this.$visualTransformation = visualTransformation;
            this.$interactionSource = mutableInteractionSource;
            this.$placeholder = function22;
            this.$leadingIcon = function23;
            this.$trailingIcon = function24;
            this.$prefix = function25;
            this.$suffix = function26;
            this.$supportingText = function27;
            this.$shape = shape;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            Modifier.Companion companionM2041paddingqDBjuR0$default;
            ComposerKt.sourceInformation(composer, "C587@33087L38,605@33907L1291,572@32390L2819:OutlinedTextField.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2094276683, i, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:572)");
            }
            Modifier modifier = this.$modifier;
            if (this.$label != null) {
                composer.startReplaceGroup(-1901539802);
                ComposerKt.sourceInformation(composer, "581@32839L2,582@32889L26");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 1739784151, "CC(remember):OutlinedTextField.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Unit.INSTANCE;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                companionM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue), 0.0f, TextFieldImplKt.minimizedLabelHalfHeight(composer, 0), 0.0f, 0.0f, 13, null);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1901156115);
                composer.endReplaceGroup();
                companionM2041paddingqDBjuR0$default = Modifier.INSTANCE;
            }
            Modifier modifierThen = modifier.then(companionM2041paddingqDBjuR0$default);
            boolean z = this.$isError;
            Strings.Companion companion2 = Strings.INSTANCE;
            Modifier modifierM2067defaultMinSizeVpY3zN4 = SizeKt.m2067defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifierThen, z, Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(androidx.compose.ui.R.string.default_error_message), composer, 0)), OutlinedTextFieldDefaults.INSTANCE.m3928getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m3927getMinHeightD9Ej5fM());
            SolidColor solidColor = new SolidColor(this.$colors.m4205cursorColorvNxB06k$material3(this.$isError), null);
            final TextFieldValue textFieldValue = this.$value;
            final boolean z2 = this.$enabled;
            final boolean z3 = this.$singleLine;
            final VisualTransformation visualTransformation = this.$visualTransformation;
            final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            final boolean z4 = this.$isError;
            final Function2<Composer, Integer, Unit> function2 = this.$label;
            final Function2<Composer, Integer, Unit> function22 = this.$placeholder;
            final Function2<Composer, Integer, Unit> function23 = this.$leadingIcon;
            final Function2<Composer, Integer, Unit> function24 = this.$trailingIcon;
            final Function2<Composer, Integer, Unit> function25 = this.$prefix;
            final Function2<Composer, Integer, Unit> function26 = this.$suffix;
            final Function2<Composer, Integer, Unit> function27 = this.$supportingText;
            final TextFieldColors textFieldColors = this.$colors;
            final Shape shape = this.$shape;
            BasicTextFieldKt.BasicTextField(this.$value, this.$onValueChange, modifierM2067defaultMinSizeVpY3zN4, this.$enabled, this.$readOnly, this.$mergedTextStyle, this.$keyboardOptions, this.$keyboardActions, this.$singleLine, this.$maxLines, this.$minLines, this.$visualTransformation, (Function1<? super TextLayoutResult, Unit>) null, this.$interactionSource, solidColor, ComposableLambdaKt.rememberComposableLambda(674541106, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function28, Composer composer2, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function28, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function28, Composer composer2, int i2) {
                    int i3;
                    ComposerKt.sourceInformation(composer2, "CN(innerTextField)622@34766L391,606@33973L1207:OutlinedTextField.kt#uh7d8r");
                    if ((i2 & 6) == 0) {
                        i3 = i2 | (composer2.changedInstance(function28) ? 4 : 2);
                    } else {
                        i3 = i2;
                    }
                    if (!composer2.shouldExecute((i3 & 19) != 18, i3 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(674541106, i3, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:606)");
                    }
                    OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                    String text = textFieldValue.getText();
                    int i4 = i3;
                    boolean z5 = z2;
                    boolean z6 = z3;
                    VisualTransformation visualTransformation2 = visualTransformation;
                    MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                    boolean z7 = z4;
                    Function2<Composer, Integer, Unit> function29 = function2;
                    Function2<Composer, Integer, Unit> function210 = function22;
                    Function2<Composer, Integer, Unit> function211 = function23;
                    Function2<Composer, Integer, Unit> function212 = function24;
                    Function2<Composer, Integer, Unit> function213 = function25;
                    Function2<Composer, Integer, Unit> function214 = function26;
                    Function2<Composer, Integer, Unit> function215 = function27;
                    TextFieldColors textFieldColors2 = textFieldColors;
                    final boolean z8 = z2;
                    final boolean z9 = z4;
                    final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
                    final TextFieldColors textFieldColors3 = textFieldColors;
                    final Shape shape2 = shape;
                    outlinedTextFieldDefaults.DecorationBox(text, function28, z5, z6, visualTransformation2, mutableInteractionSource2, z7, function29, function210, function211, function212, function213, function214, function215, textFieldColors2, null, ComposableLambdaKt.rememberComposableLambda(1409265477, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.2.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i5) {
                            ComposerKt.sourceInformation(composer3, "C623@34822L309:OutlinedTextField.kt#uh7d8r");
                            if (!composer3.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1409265477, i5, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:623)");
                            }
                            OutlinedTextFieldDefaults.INSTANCE.m3922Container4EFweAY(z8, z9, mutableInteractionSource3, null, textFieldColors3, shape2, 0.0f, 0.0f, composer3, 100663296, 200);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, (i4 << 3) & 112, 14155776, 32768);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54), composer, 0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x063f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:393:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedTextField(final TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, TextFieldLabelPosition textFieldLabelPosition, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, boolean z3, InputTransformation inputTransformation, OutputTransformation outputTransformation, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function27, ScrollState scrollState, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3, final int i4) {
        TextFieldState textFieldState2;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z4;
        int i7;
        boolean z5;
        TextStyle textStyle2;
        TextFieldLabelPosition attached;
        int i8;
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function32;
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
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final boolean z6;
        final InputTransformation inputTransformation2;
        final OutputTransformation outputTransformation2;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActionHandler keyboardActionHandler2;
        final TextFieldLineLimits textFieldLineLimits2;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function210;
        final ScrollState scrollState2;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final PaddingValues paddingValues2;
        final MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final boolean z7;
        final boolean z8;
        final TextStyle textStyle3;
        final TextFieldLabelPosition textFieldLabelPosition2;
        final Modifier modifier3;
        final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        TextFieldLineLimits textFieldLineLimits3;
        TextFieldColors textFieldColors3;
        TextStyle textStyle4;
        Modifier modifier4;
        TextFieldLabelPosition textFieldLabelPosition3;
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function34;
        Shape shape3;
        PaddingValues paddingValues3;
        InputTransformation inputTransformation3;
        boolean z9;
        OutputTransformation outputTransformation3;
        KeyboardOptions keyboardOptions3;
        KeyboardActionHandler keyboardActionHandler3;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function215;
        ScrollState scrollState3;
        int i33;
        Function2<? super Composer, ? super Integer, Unit> function216;
        Function2<? super Composer, ? super Integer, Unit> function217;
        Function2<? super Composer, ? super Integer, Unit> function218;
        Function2<? super Composer, ? super Integer, Unit> function219;
        Function2<? super Composer, ? super Integer, Unit> function220;
        TextFieldLineLimits textFieldLineLimits4;
        int i34;
        MutableInteractionSource mutableInteractionSource3;
        boolean z10;
        Function2<? super Composer, ? super Integer, Unit> function221;
        boolean z11;
        MutableInteractionSource mutableInteractionSource4;
        int i35;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2007078942);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextField)N(state,modifier,enabled,readOnly,textStyle,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,inputTransformation,outputTransformation,keyboardOptions,onKeyboardAction,lineLimits,onTextLayout,scrollState,shape,colors,contentPadding,interactionSource)239@14004L2781,239@13917L2868:OutlinedTextField.kt#uh7d8r");
        if ((i4 & 1) != 0) {
            i5 = i | 6;
            textFieldState2 = textFieldState;
        } else {
            textFieldState2 = textFieldState;
            if ((i & 6) == 0) {
                i5 = (composerStartRestartGroup.changed(textFieldState2) ? 4 : 2) | i;
            } else {
                i5 = i;
            }
        }
        int i36 = i4 & 2;
        if (i36 != 0) {
            i5 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i & 384) == 0) {
                    z4 = z;
                    i5 |= composerStartRestartGroup.changed(z4) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        z5 = z2;
                        i5 |= composerStartRestartGroup.changed(z5) ? 2048 : 1024;
                    }
                    if ((i & 24576) != 0) {
                        if ((i4 & 16) == 0) {
                            textStyle2 = textStyle;
                            if (composerStartRestartGroup.changed(textStyle2)) {
                                i35 = 16384;
                            }
                            i5 |= i35;
                        } else {
                            textStyle2 = textStyle;
                        }
                        i35 = 8192;
                        i5 |= i35;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        attached = textFieldLabelPosition;
                        i5 |= ((i4 & 32) == 0 && composerStartRestartGroup.changed(attached)) ? 131072 : 65536;
                    } else {
                        attached = textFieldLabelPosition;
                    }
                    i8 = i4 & 64;
                    if (i8 == 0) {
                        i5 |= 1572864;
                        function32 = function3;
                    } else {
                        function32 = function3;
                        if ((i & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                        }
                    }
                    i9 = i4 & 128;
                    if (i9 == 0) {
                        i5 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i5 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    i10 = i4 & 256;
                    if (i10 == 0) {
                        i5 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i11 = i10;
                            i5 |= composerStartRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
                        }
                        i12 = i4 & 512;
                        if (i12 != 0) {
                            i5 |= 805306368;
                        } else {
                            if ((i & 805306368) == 0) {
                                i13 = i12;
                                i5 |= composerStartRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
                            }
                            i14 = i4 & 1024;
                            if (i14 == 0) {
                                i16 = i2 | 6;
                                i15 = i14;
                            } else if ((i2 & 6) == 0) {
                                i15 = i14;
                                i16 = i2 | (composerStartRestartGroup.changedInstance(function24) ? 4 : 2);
                            } else {
                                i15 = i14;
                                i16 = i2;
                            }
                            i17 = i4 & 2048;
                            if (i17 == 0) {
                                i16 |= 48;
                                i18 = i17;
                            } else if ((i2 & 48) == 0) {
                                i18 = i17;
                                i16 |= composerStartRestartGroup.changedInstance(function25) ? 32 : 16;
                            } else {
                                i18 = i17;
                            }
                            int i37 = i16;
                            i19 = i5;
                            i20 = i4 & 4096;
                            if (i20 == 0) {
                                i21 = i37 | 384;
                            } else {
                                int i38 = i37;
                                if ((i2 & 384) == 0) {
                                    i38 |= composerStartRestartGroup.changedInstance(function26) ? 256 : 128;
                                }
                                i21 = i38;
                            }
                            i22 = i4 & 8192;
                            if (i22 == 0) {
                                i23 = i21 | 3072;
                            } else {
                                int i39 = i21;
                                if ((i2 & 3072) == 0) {
                                    i39 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                                }
                                i23 = i39;
                            }
                            i24 = i4 & 16384;
                            if (i24 != 0) {
                                i25 = i23;
                                if ((i2 & 24576) == 0) {
                                    i25 |= composerStartRestartGroup.changed(inputTransformation) ? 16384 : 8192;
                                }
                                i26 = i4 & 32768;
                                if (i26 != 0) {
                                    i25 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i25 |= composerStartRestartGroup.changed(outputTransformation) ? 131072 : 65536;
                                }
                                i27 = i4 & 65536;
                                if (i27 != 0) {
                                    i25 |= 1572864;
                                } else if ((i2 & 1572864) == 0) {
                                    i25 |= composerStartRestartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                                }
                                i28 = i4 & 131072;
                                if (i28 != 0) {
                                    i25 |= 12582912;
                                } else if ((i2 & 12582912) == 0) {
                                    i25 |= composerStartRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                                }
                                if ((i2 & 100663296) == 0) {
                                    i25 |= ((i4 & 262144) == 0 && composerStartRestartGroup.changed(textFieldLineLimits)) ? 67108864 : 33554432;
                                }
                                i29 = i4 & 524288;
                                if (i29 != 0) {
                                    i25 |= 805306368;
                                } else if ((i2 & 805306368) == 0) {
                                    i25 |= composerStartRestartGroup.changedInstance(function27) ? 536870912 : 268435456;
                                }
                                if ((i3 & 6) == 0) {
                                    i30 = i3 | (((i4 & 1048576) == 0 && composerStartRestartGroup.changed(scrollState)) ? 4 : 2);
                                } else {
                                    i30 = i3;
                                }
                                if ((i3 & 48) == 0) {
                                    i30 |= ((i4 & 2097152) == 0 && composerStartRestartGroup.changed(shape)) ? 32 : 16;
                                }
                                if ((i3 & 384) == 0) {
                                    i30 |= ((i4 & 4194304) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 256 : 128;
                                }
                                if ((i3 & 3072) == 0) {
                                    i30 |= ((8388608 & i4) == 0 && composerStartRestartGroup.changed(paddingValues)) ? 2048 : 1024;
                                }
                                int i40 = i30;
                                i31 = i4 & 16777216;
                                if (i31 != 0) {
                                    i32 = i40 | 24576;
                                } else {
                                    int i41 = i40;
                                    if ((i3 & 24576) == 0) {
                                        i41 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 16384 : 8192;
                                    }
                                    i32 = i41;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (i25 & 306783379) == 306783378 && (i32 & 9363) == 9362) ? false : true, i19 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "207@12265L7,223@13155L21,224@13223L5,225@13286L8");
                                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i36 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i6 != 0) {
                                            z4 = true;
                                        }
                                        if (i7 != 0) {
                                            z5 = false;
                                        }
                                        if ((i4 & 16) != 0) {
                                            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            textStyle2 = (TextStyle) objConsume;
                                            i19 &= -57345;
                                        }
                                        if ((i4 & 32) != 0) {
                                            attached = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
                                            i19 &= -458753;
                                        }
                                        if (i8 != 0) {
                                            function32 = null;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function222 = i9 != 0 ? null : function2;
                                        Function2<? super Composer, ? super Integer, Unit> function223 = i11 != 0 ? null : function22;
                                        Function2<? super Composer, ? super Integer, Unit> function224 = i13 != 0 ? null : function23;
                                        Function2<? super Composer, ? super Integer, Unit> function225 = i15 != 0 ? null : function24;
                                        Function2<? super Composer, ? super Integer, Unit> function226 = i18 != 0 ? null : function25;
                                        Function2<? super Composer, ? super Integer, Unit> function227 = i20 != 0 ? null : function26;
                                        boolean z12 = i22 != 0 ? false : z3;
                                        InputTransformation inputTransformation4 = i24 != 0 ? null : inputTransformation;
                                        OutputTransformation outputTransformation4 = i26 != 0 ? null : outputTransformation;
                                        KeyboardOptions keyboardOptions4 = i27 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        KeyboardActionHandler keyboardActionHandler4 = i28 != 0 ? null : keyboardActionHandler;
                                        if ((i4 & 262144) != 0) {
                                            textFieldLineLimits3 = TextFieldLineLimits.INSTANCE.getDefault();
                                            i25 &= -234881025;
                                        } else {
                                            textFieldLineLimits3 = textFieldLineLimits;
                                        }
                                        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function228 = i29 != 0 ? null : function27;
                                        ScrollState scrollStateRememberScrollState = (i4 & 1048576) != 0 ? ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1) : scrollState;
                                        Shape shape4 = (i4 & 2097152) != 0 ? OutlinedTextFieldDefaults.INSTANCE.getShape(composerStartRestartGroup, 6) : shape;
                                        TextFieldColors textFieldColorsColors = (i4 & 4194304) != 0 ? OutlinedTextFieldDefaults.INSTANCE.colors(composerStartRestartGroup, 6) : textFieldColors;
                                        PaddingValues paddingValuesM3921contentPaddinga9UjIt4$default = (i4 & 8388608) != 0 ? OutlinedTextFieldDefaults.m3921contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null) : paddingValues;
                                        if (i31 != 0) {
                                            Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function35 = function32;
                                            textFieldColors3 = textFieldColorsColors;
                                            textStyle4 = textStyle2;
                                            modifier4 = modifier2;
                                            textFieldLabelPosition3 = attached;
                                            function34 = function35;
                                            shape3 = shape4;
                                            paddingValues3 = paddingValuesM3921contentPaddinga9UjIt4$default;
                                            inputTransformation3 = inputTransformation4;
                                            z9 = z5;
                                            outputTransformation3 = outputTransformation4;
                                            keyboardOptions3 = keyboardOptions4;
                                            keyboardActionHandler3 = keyboardActionHandler4;
                                            function215 = function228;
                                            scrollState3 = scrollStateRememberScrollState;
                                            i33 = i19;
                                            function216 = function222;
                                            function217 = function223;
                                            function218 = function224;
                                            function219 = function226;
                                            function220 = function227;
                                            textFieldLineLimits4 = textFieldLineLimits3;
                                            i34 = i25;
                                            mutableInteractionSource3 = null;
                                        } else {
                                            Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function36 = function32;
                                            textFieldColors3 = textFieldColorsColors;
                                            textStyle4 = textStyle2;
                                            modifier4 = modifier2;
                                            textFieldLabelPosition3 = attached;
                                            function34 = function36;
                                            shape3 = shape4;
                                            paddingValues3 = paddingValuesM3921contentPaddinga9UjIt4$default;
                                            inputTransformation3 = inputTransformation4;
                                            z9 = z5;
                                            outputTransformation3 = outputTransformation4;
                                            keyboardOptions3 = keyboardOptions4;
                                            keyboardActionHandler3 = keyboardActionHandler4;
                                            function215 = function228;
                                            scrollState3 = scrollStateRememberScrollState;
                                            i33 = i19;
                                            function216 = function222;
                                            function217 = function223;
                                            function218 = function224;
                                            function219 = function226;
                                            function220 = function227;
                                            textFieldLineLimits4 = textFieldLineLimits3;
                                            i34 = i25;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                        }
                                        z10 = z4;
                                        function221 = function225;
                                        z11 = z12;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        i33 = (i4 & 16) != 0 ? i19 & (-57345) : i19;
                                        if ((i4 & 32) != 0) {
                                            i33 &= -458753;
                                        }
                                        if ((i4 & 262144) != 0) {
                                            i25 &= -234881025;
                                        }
                                        function216 = function2;
                                        function217 = function22;
                                        function218 = function23;
                                        function221 = function24;
                                        function219 = function25;
                                        function220 = function26;
                                        z11 = z3;
                                        inputTransformation3 = inputTransformation;
                                        outputTransformation3 = outputTransformation;
                                        keyboardOptions3 = keyboardOptions;
                                        keyboardActionHandler3 = keyboardActionHandler;
                                        textFieldLineLimits4 = textFieldLineLimits;
                                        function215 = function27;
                                        scrollState3 = scrollState;
                                        shape3 = shape;
                                        paddingValues3 = paddingValues;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        z10 = z4;
                                        z9 = z5;
                                        textStyle4 = textStyle2;
                                        modifier4 = modifier2;
                                        i34 = i25;
                                        textFieldLabelPosition3 = attached;
                                        function34 = function32;
                                        textFieldColors3 = textFieldColors;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2007078942, i33, i34, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:228)");
                                    }
                                    if (mutableInteractionSource3 == null) {
                                        composerStartRestartGroup.startReplaceGroup(1647415065);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "230@13518L39");
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -362499575, "CC(remember):OutlinedTextField.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-362500226);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    composerStartRestartGroup.startReplaceGroup(-362494116);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*234@13742L25");
                                    long jM8586getColor0d7_KjU = textStyle4.m8586getColor0d7_KjU();
                                    if (jM8586getColor0d7_KjU == 16) {
                                        jM8586getColor0d7_KjU = textFieldColors3.m4255textColorXeAY9LY$material3(z10, z11, FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource4, composerStartRestartGroup, 0).getValue().booleanValue());
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors3.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(-416142558, true, new AnonymousClass1(modifier4, function34, textFieldLabelPosition3, z11, textFieldColors3, textFieldState2, z10, textFieldLineLimits4, outputTransformation3, mutableInteractionSource4, function216, function217, function218, function221, function219, function220, paddingValues3, z9, inputTransformation3, textStyle4.merge(new TextStyle(jM8586getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActionHandler3, function215, scrollState3, shape3), composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    textStyle3 = textStyle4;
                                    composer2 = composerStartRestartGroup;
                                    modifier3 = modifier4;
                                    function33 = function34;
                                    textFieldLabelPosition2 = textFieldLabelPosition3;
                                    z6 = z11;
                                    z7 = z10;
                                    function28 = function216;
                                    function211 = function217;
                                    function212 = function218;
                                    function213 = function221;
                                    function29 = function219;
                                    z8 = z9;
                                    inputTransformation2 = inputTransformation3;
                                    keyboardActionHandler2 = keyboardActionHandler3;
                                    function210 = function215;
                                    scrollState2 = scrollState3;
                                    shape2 = shape3;
                                    textFieldColors2 = textFieldColors3;
                                    textFieldLineLimits2 = textFieldLineLimits4;
                                    outputTransformation2 = outputTransformation3;
                                    function214 = function220;
                                    paddingValues2 = paddingValues3;
                                    keyboardOptions2 = keyboardOptions3;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    function28 = function2;
                                    function29 = function25;
                                    z6 = z3;
                                    inputTransformation2 = inputTransformation;
                                    outputTransformation2 = outputTransformation;
                                    keyboardOptions2 = keyboardOptions;
                                    keyboardActionHandler2 = keyboardActionHandler;
                                    textFieldLineLimits2 = textFieldLineLimits;
                                    function210 = function27;
                                    scrollState2 = scrollState;
                                    shape2 = shape;
                                    textFieldColors2 = textFieldColors;
                                    paddingValues2 = paddingValues;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    composer2 = composerStartRestartGroup;
                                    z7 = z4;
                                    z8 = z5;
                                    textStyle3 = textStyle2;
                                    textFieldLabelPosition2 = attached;
                                    modifier3 = modifier2;
                                    function33 = function32;
                                    function211 = function22;
                                    function212 = function23;
                                    function213 = function24;
                                    function214 = function26;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return OutlinedTextFieldKt.OutlinedTextField$lambda$2(textFieldState, modifier3, z7, z8, textStyle3, textFieldLabelPosition2, function33, function28, function211, function212, function213, function29, function214, z6, inputTransformation2, outputTransformation2, keyboardOptions2, keyboardActionHandler2, textFieldLineLimits2, function210, scrollState2, shape2, textFieldColors2, paddingValues2, mutableInteractionSource2, i, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i25 = i23 | 24576;
                            i26 = i4 & 32768;
                            if (i26 != 0) {
                            }
                            i27 = i4 & 65536;
                            if (i27 != 0) {
                            }
                            i28 = i4 & 131072;
                            if (i28 != 0) {
                            }
                            if ((i2 & 100663296) == 0) {
                            }
                            i29 = i4 & 524288;
                            if (i29 != 0) {
                            }
                            if ((i3 & 6) == 0) {
                            }
                            if ((i3 & 48) == 0) {
                            }
                            if ((i3 & 384) == 0) {
                            }
                            if ((i3 & 3072) == 0) {
                            }
                            int i402 = i30;
                            i31 = i4 & 16777216;
                            if (i31 != 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (i25 & 306783379) == 306783378 && (i32 & 9363) == 9362) ? false : true, i19 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i13 = i12;
                        i14 = i4 & 1024;
                        if (i14 == 0) {
                        }
                        i17 = i4 & 2048;
                        if (i17 == 0) {
                        }
                        int i372 = i16;
                        i19 = i5;
                        i20 = i4 & 4096;
                        if (i20 == 0) {
                        }
                        i22 = i4 & 8192;
                        if (i22 == 0) {
                        }
                        i24 = i4 & 16384;
                        if (i24 != 0) {
                        }
                        i26 = i4 & 32768;
                        if (i26 != 0) {
                        }
                        i27 = i4 & 65536;
                        if (i27 != 0) {
                        }
                        i28 = i4 & 131072;
                        if (i28 != 0) {
                        }
                        if ((i2 & 100663296) == 0) {
                        }
                        i29 = i4 & 524288;
                        if (i29 != 0) {
                        }
                        if ((i3 & 6) == 0) {
                        }
                        if ((i3 & 48) == 0) {
                        }
                        if ((i3 & 384) == 0) {
                        }
                        if ((i3 & 3072) == 0) {
                        }
                        int i4022 = i30;
                        i31 = i4 & 16777216;
                        if (i31 != 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (i25 & 306783379) == 306783378 && (i32 & 9363) == 9362) ? false : true, i19 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i11 = i10;
                    i12 = i4 & 512;
                    if (i12 != 0) {
                    }
                    i13 = i12;
                    i14 = i4 & 1024;
                    if (i14 == 0) {
                    }
                    i17 = i4 & 2048;
                    if (i17 == 0) {
                    }
                    int i3722 = i16;
                    i19 = i5;
                    i20 = i4 & 4096;
                    if (i20 == 0) {
                    }
                    i22 = i4 & 8192;
                    if (i22 == 0) {
                    }
                    i24 = i4 & 16384;
                    if (i24 != 0) {
                    }
                    i26 = i4 & 32768;
                    if (i26 != 0) {
                    }
                    i27 = i4 & 65536;
                    if (i27 != 0) {
                    }
                    i28 = i4 & 131072;
                    if (i28 != 0) {
                    }
                    if ((i2 & 100663296) == 0) {
                    }
                    i29 = i4 & 524288;
                    if (i29 != 0) {
                    }
                    if ((i3 & 6) == 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    if ((i3 & 384) == 0) {
                    }
                    if ((i3 & 3072) == 0) {
                    }
                    int i40222 = i30;
                    i31 = i4 & 16777216;
                    if (i31 != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (i25 & 306783379) == 306783378 && (i32 & 9363) == 9362) ? false : true, i19 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z5 = z2;
                if ((i & 24576) != 0) {
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                i8 = i4 & 64;
                if (i8 == 0) {
                }
                i9 = i4 & 128;
                if (i9 == 0) {
                }
                i10 = i4 & 256;
                if (i10 == 0) {
                }
                i11 = i10;
                i12 = i4 & 512;
                if (i12 != 0) {
                }
                i13 = i12;
                i14 = i4 & 1024;
                if (i14 == 0) {
                }
                i17 = i4 & 2048;
                if (i17 == 0) {
                }
                int i37222 = i16;
                i19 = i5;
                i20 = i4 & 4096;
                if (i20 == 0) {
                }
                i22 = i4 & 8192;
                if (i22 == 0) {
                }
                i24 = i4 & 16384;
                if (i24 != 0) {
                }
                i26 = i4 & 32768;
                if (i26 != 0) {
                }
                i27 = i4 & 65536;
                if (i27 != 0) {
                }
                i28 = i4 & 131072;
                if (i28 != 0) {
                }
                if ((i2 & 100663296) == 0) {
                }
                i29 = i4 & 524288;
                if (i29 != 0) {
                }
                if ((i3 & 6) == 0) {
                }
                if ((i3 & 48) == 0) {
                }
                if ((i3 & 384) == 0) {
                }
                if ((i3 & 3072) == 0) {
                }
                int i402222 = i30;
                i31 = i4 & 16777216;
                if (i31 != 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (i25 & 306783379) == 306783378 && (i32 & 9363) == 9362) ? false : true, i19 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            z5 = z2;
            if ((i & 24576) != 0) {
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            i8 = i4 & 64;
            if (i8 == 0) {
            }
            i9 = i4 & 128;
            if (i9 == 0) {
            }
            i10 = i4 & 256;
            if (i10 == 0) {
            }
            i11 = i10;
            i12 = i4 & 512;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i4 & 1024;
            if (i14 == 0) {
            }
            i17 = i4 & 2048;
            if (i17 == 0) {
            }
            int i372222 = i16;
            i19 = i5;
            i20 = i4 & 4096;
            if (i20 == 0) {
            }
            i22 = i4 & 8192;
            if (i22 == 0) {
            }
            i24 = i4 & 16384;
            if (i24 != 0) {
            }
            i26 = i4 & 32768;
            if (i26 != 0) {
            }
            i27 = i4 & 65536;
            if (i27 != 0) {
            }
            i28 = i4 & 131072;
            if (i28 != 0) {
            }
            if ((i2 & 100663296) == 0) {
            }
            i29 = i4 & 524288;
            if (i29 != 0) {
            }
            if ((i3 & 6) == 0) {
            }
            if ((i3 & 48) == 0) {
            }
            if ((i3 & 384) == 0) {
            }
            if ((i3 & 3072) == 0) {
            }
            int i4022222 = i30;
            i31 = i4 & 16777216;
            if (i31 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (i25 & 306783379) == 306783378 && (i32 & 9363) == 9362) ? false : true, i19 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        z4 = z;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        z5 = z2;
        if ((i & 24576) != 0) {
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i8 = i4 & 64;
        if (i8 == 0) {
        }
        i9 = i4 & 128;
        if (i9 == 0) {
        }
        i10 = i4 & 256;
        if (i10 == 0) {
        }
        i11 = i10;
        i12 = i4 & 512;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i4 & 1024;
        if (i14 == 0) {
        }
        i17 = i4 & 2048;
        if (i17 == 0) {
        }
        int i3722222 = i16;
        i19 = i5;
        i20 = i4 & 4096;
        if (i20 == 0) {
        }
        i22 = i4 & 8192;
        if (i22 == 0) {
        }
        i24 = i4 & 16384;
        if (i24 != 0) {
        }
        i26 = i4 & 32768;
        if (i26 != 0) {
        }
        i27 = i4 & 65536;
        if (i27 != 0) {
        }
        i28 = i4 & 131072;
        if (i28 != 0) {
        }
        if ((i2 & 100663296) == 0) {
        }
        i29 = i4 & 524288;
        if (i29 != 0) {
        }
        if ((i3 & 6) == 0) {
        }
        if ((i3 & 48) == 0) {
        }
        if ((i3 & 384) == 0) {
        }
        if ((i3 & 3072) == 0) {
        }
        int i40222222 = i30;
        i31 = i4 & 16777216;
        if (i31 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (i25 & 306783379) == 306783378 && (i32 & 9363) == 9362) ? false : true, i19 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:358:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedTextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5, final int i6) {
        TextFieldValue textFieldValue2;
        int i7;
        Function1<? super TextFieldValue, Unit> function12;
        Modifier modifier2;
        int i8;
        boolean z5;
        int i9;
        boolean z6;
        TextStyle textStyle2;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function29;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final boolean z7;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActions keyboardActions2;
        final boolean z8;
        final int i34;
        final int i35;
        final MutableInteractionSource mutableInteractionSource2;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        Composer composer2;
        final boolean z9;
        final boolean z10;
        final TextStyle textStyle3;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        final VisualTransformation visualTransformation2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i36;
        int i37;
        Shape shape3;
        Function2<? super Composer, ? super Integer, Unit> function217;
        Function2<? super Composer, ? super Integer, Unit> function218;
        TextStyle textStyle4;
        Function2<? super Composer, ? super Integer, Unit> function219;
        Function2<? super Composer, ? super Integer, Unit> function220;
        Modifier modifier4;
        Function2<? super Composer, ? super Integer, Unit> function221;
        boolean z11;
        int i38;
        Function2<? super Composer, ? super Integer, Unit> function222;
        KeyboardOptions keyboardOptions3;
        KeyboardActions keyboardActions3;
        boolean z12;
        int i39;
        int i40;
        TextFieldColors textFieldColorsColors;
        VisualTransformation visualTransformation3;
        boolean z13;
        boolean z14;
        int i41;
        MutableInteractionSource mutableInteractionSource3;
        MutableInteractionSource mutableInteractionSource4;
        Composer composerStartRestartGroup = composer.startRestartGroup(2057288437);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,visualTransformation,keyboardOptions,keyboardActions,singleLine,maxLines,minLines,interactionSource,shape,colors)571@32380L2835,571@32293L2922:OutlinedTextField.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i3 | 6;
            textFieldValue2 = textFieldValue;
        } else {
            textFieldValue2 = textFieldValue;
            if ((i3 & 6) == 0) {
                i7 = (composerStartRestartGroup.changed(textFieldValue2) ? 4 : 2) | i3;
            } else {
                i7 = i3;
            }
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i3 & 48) == 0) {
                i7 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i42 = i6 & 4;
        if (i42 != 0) {
            i7 |= 384;
        } else {
            if ((i3 & 384) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else {
                if ((i3 & 3072) == 0) {
                    z5 = z;
                    i7 |= composerStartRestartGroup.changed(z5) ? 2048 : 1024;
                }
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else {
                    if ((i3 & 24576) == 0) {
                        z6 = z2;
                        i7 |= composerStartRestartGroup.changed(z6) ? 16384 : 8192;
                    }
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        textStyle2 = textStyle;
                        i7 |= ((i6 & 32) == 0 && composerStartRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                        function28 = function2;
                    } else {
                        function28 = function2;
                        if ((i3 & 1572864) == 0) {
                            i7 |= composerStartRestartGroup.changedInstance(function28) ? 1048576 : 524288;
                        }
                    }
                    i11 = i6 & 128;
                    if (i11 == 0) {
                        i7 |= 12582912;
                        function29 = function22;
                    } else {
                        function29 = function22;
                        if ((i3 & 12582912) == 0) {
                            i7 |= composerStartRestartGroup.changedInstance(function29) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i6 & 256;
                    if (i12 == 0) {
                        i7 |= 100663296;
                    } else {
                        if ((i3 & 100663296) == 0) {
                            i13 = i12;
                            i7 |= composerStartRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        }
                        i14 = i6 & 512;
                        if (i14 != 0) {
                            i7 |= 805306368;
                        } else {
                            if ((i3 & 805306368) == 0) {
                                i15 = i14;
                                i7 |= composerStartRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            }
                            i16 = i6 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 6) == 0) {
                                i17 = i16;
                                i18 = i4 | (composerStartRestartGroup.changedInstance(function25) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            i19 = i6 & 2048;
                            if (i19 == 0) {
                                i18 |= 48;
                                i20 = i19;
                            } else if ((i4 & 48) == 0) {
                                i20 = i19;
                                i18 |= composerStartRestartGroup.changedInstance(function26) ? 32 : 16;
                            } else {
                                i20 = i19;
                            }
                            int i43 = i18;
                            i21 = i7;
                            i22 = i6 & 4096;
                            if (i22 == 0) {
                                i23 = i43 | 384;
                            } else {
                                int i44 = i43;
                                if ((i4 & 384) == 0) {
                                    i44 |= composerStartRestartGroup.changedInstance(function27) ? 256 : 128;
                                }
                                i23 = i44;
                            }
                            i24 = i6 & 8192;
                            if (i24 == 0) {
                                i25 = i23 | 3072;
                            } else {
                                int i45 = i23;
                                if ((i4 & 3072) == 0) {
                                    i25 = i45 | (composerStartRestartGroup.changed(z3) ? 2048 : 1024);
                                } else {
                                    i25 = i45;
                                }
                            }
                            i26 = i6 & 16384;
                            if (i26 != 0) {
                                i27 = i25;
                                if ((i4 & 24576) == 0) {
                                    i27 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                                }
                                i28 = i6 & 32768;
                                if (i28 != 0) {
                                    i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i27 |= composerStartRestartGroup.changed(keyboardOptions) ? 131072 : 65536;
                                }
                                i29 = i6 & 65536;
                                if (i29 != 0) {
                                    i27 |= 1572864;
                                } else if ((i4 & 1572864) == 0) {
                                    i27 |= composerStartRestartGroup.changed(keyboardActions) ? 1048576 : 524288;
                                }
                                i30 = i6 & 131072;
                                if (i30 != 0) {
                                    i27 |= 12582912;
                                } else if ((i4 & 12582912) == 0) {
                                    i27 |= composerStartRestartGroup.changed(z4) ? 8388608 : 4194304;
                                }
                                if ((i4 & 100663296) == 0) {
                                    i27 |= ((i6 & 262144) == 0 && composerStartRestartGroup.changed(i)) ? 67108864 : 33554432;
                                }
                                i31 = i6 & 524288;
                                if (i31 != 0) {
                                    i27 |= 805306368;
                                } else if ((i4 & 805306368) == 0) {
                                    i27 |= composerStartRestartGroup.changed(i2) ? 536870912 : 268435456;
                                }
                                i32 = i6 & 1048576;
                                if (i32 != 0) {
                                    i33 = i5 | 6;
                                } else if ((i5 & 6) == 0) {
                                    i33 = i5 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                } else {
                                    i33 = i5;
                                }
                                if ((i5 & 48) == 0) {
                                    i33 |= ((i6 & 2097152) == 0 && composerStartRestartGroup.changed(shape)) ? 32 : 16;
                                }
                                if ((i5 & 384) == 0) {
                                    i33 |= ((i6 & 4194304) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 256 : 128;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "542@30932L7,558@31736L5,559@31799L8");
                                    if ((i3 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i42 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i8 != 0) {
                                            z5 = true;
                                        }
                                        if (i9 != 0) {
                                            z6 = false;
                                        }
                                        if ((i6 & 32) != 0) {
                                            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            i36 = i21 & (-458753);
                                            textStyle2 = (TextStyle) objConsume;
                                        } else {
                                            i36 = i21;
                                        }
                                        if (i10 != 0) {
                                            function28 = null;
                                        }
                                        if (i11 != 0) {
                                            function29 = null;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function223 = i13 != 0 ? null : function23;
                                        Function2<? super Composer, ? super Integer, Unit> function224 = i15 != 0 ? null : function24;
                                        Function2<? super Composer, ? super Integer, Unit> function225 = i17 != 0 ? null : function25;
                                        Function2<? super Composer, ? super Integer, Unit> function226 = i20 != 0 ? null : function26;
                                        Function2<? super Composer, ? super Integer, Unit> function227 = i22 != 0 ? null : function27;
                                        boolean z15 = i24 != 0 ? false : z3;
                                        VisualTransformation none = i26 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                        KeyboardOptions keyboardOptions4 = i28 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        KeyboardActions keyboardActions4 = i29 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                        boolean z16 = i30 != 0 ? false : z4;
                                        if ((i6 & 262144) != 0) {
                                            i37 = z16 ? 1 : Integer.MAX_VALUE;
                                            i27 &= -234881025;
                                        } else {
                                            i37 = i;
                                        }
                                        int i46 = i31 != 0 ? 1 : i2;
                                        MutableInteractionSource mutableInteractionSource5 = i32 == 0 ? mutableInteractionSource : null;
                                        Shape shape4 = (i6 & 2097152) != 0 ? OutlinedTextFieldDefaults.INSTANCE.getShape(composerStartRestartGroup, 6) : shape;
                                        if ((i6 & 4194304) != 0) {
                                            shape3 = shape4;
                                            function217 = function223;
                                            function218 = function224;
                                            function219 = function225;
                                            function220 = function29;
                                            function221 = function226;
                                            z11 = z15;
                                            i38 = i27;
                                            function222 = function227;
                                            keyboardOptions3 = keyboardOptions4;
                                            keyboardActions3 = keyboardActions4;
                                            z12 = z16;
                                            i39 = i37;
                                            i40 = i46;
                                            textFieldColorsColors = OutlinedTextFieldDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                            visualTransformation3 = none;
                                            z14 = z6;
                                            textStyle4 = textStyle2;
                                            modifier4 = modifier2;
                                            i41 = i36;
                                            z13 = z5;
                                        } else {
                                            shape3 = shape4;
                                            function217 = function223;
                                            function218 = function224;
                                            textStyle4 = textStyle2;
                                            function219 = function225;
                                            function220 = function29;
                                            modifier4 = modifier2;
                                            function221 = function226;
                                            z11 = z15;
                                            i38 = i27;
                                            function222 = function227;
                                            keyboardOptions3 = keyboardOptions4;
                                            keyboardActions3 = keyboardActions4;
                                            z12 = z16;
                                            i39 = i37;
                                            i40 = i46;
                                            textFieldColorsColors = textFieldColors;
                                            visualTransformation3 = none;
                                            z13 = z5;
                                            z14 = z6;
                                            i41 = i36;
                                        }
                                        mutableInteractionSource3 = mutableInteractionSource5;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        i41 = (i6 & 32) != 0 ? i21 & (-458753) : i21;
                                        if ((i6 & 262144) != 0) {
                                            i27 &= -234881025;
                                        }
                                        function217 = function23;
                                        function218 = function24;
                                        function219 = function25;
                                        function221 = function26;
                                        function222 = function27;
                                        z11 = z3;
                                        visualTransformation3 = visualTransformation;
                                        keyboardActions3 = keyboardActions;
                                        z12 = z4;
                                        i39 = i;
                                        i40 = i2;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        shape3 = shape;
                                        z14 = z6;
                                        textStyle4 = textStyle2;
                                        function220 = function29;
                                        modifier4 = modifier2;
                                        i38 = i27;
                                        keyboardOptions3 = keyboardOptions;
                                        textFieldColorsColors = textFieldColors;
                                        z13 = z5;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2057288437, i41, i38, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:560)");
                                    }
                                    if (mutableInteractionSource3 == null) {
                                        composerStartRestartGroup.startReplaceGroup(-502250010);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "562@31894L39");
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1369271708, "CC(remember):OutlinedTextField.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1369271057);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    composerStartRestartGroup.startReplaceGroup(1369277167);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*566@32118L25");
                                    long jM8586getColor0d7_KjU = textStyle4.m8586getColor0d7_KjU();
                                    if (jM8586getColor0d7_KjU == 16) {
                                        jM8586getColor0d7_KjU = textFieldColorsColors.m4255textColorXeAY9LY$material3(z13, z11, FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource4, composerStartRestartGroup, 0).getValue().booleanValue());
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColorsColors.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(-2094276683, true, new AnonymousClass5(modifier4, function28, z11, textFieldColorsColors, textFieldValue2, function12, z13, z14, textStyle4.merge(new TextStyle(jM8586getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z12, i39, i40, visualTransformation3, mutableInteractionSource4, function220, function217, function218, function219, function221, function222, shape3), composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    textStyle3 = textStyle4;
                                    composer2 = composerStartRestartGroup;
                                    modifier3 = modifier4;
                                    function212 = function28;
                                    z7 = z11;
                                    z9 = z13;
                                    z10 = z14;
                                    keyboardOptions2 = keyboardOptions3;
                                    keyboardActions2 = keyboardActions3;
                                    z8 = z12;
                                    i34 = i39;
                                    i35 = i40;
                                    visualTransformation2 = visualTransformation3;
                                    function213 = function220;
                                    function214 = function217;
                                    function215 = function218;
                                    function210 = function219;
                                    function211 = function222;
                                    shape2 = shape3;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    textFieldColors2 = textFieldColorsColors;
                                    function216 = function221;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    function210 = function25;
                                    function211 = function27;
                                    z7 = z3;
                                    keyboardOptions2 = keyboardOptions;
                                    keyboardActions2 = keyboardActions;
                                    z8 = z4;
                                    i34 = i;
                                    i35 = i2;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    shape2 = shape;
                                    textFieldColors2 = textFieldColors;
                                    composer2 = composerStartRestartGroup;
                                    z9 = z5;
                                    z10 = z6;
                                    textStyle3 = textStyle2;
                                    function212 = function28;
                                    function213 = function29;
                                    modifier3 = modifier2;
                                    function214 = function23;
                                    function215 = function24;
                                    function216 = function26;
                                    visualTransformation2 = visualTransformation;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return OutlinedTextFieldKt.OutlinedTextField$lambda$8(textFieldValue, function1, modifier3, z9, z10, textStyle3, function212, function213, function214, function215, function210, function216, function211, z7, visualTransformation2, keyboardOptions2, keyboardActions2, z8, i34, i35, mutableInteractionSource2, shape2, textFieldColors2, i3, i4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i27 = i25 | 24576;
                            i28 = i6 & 32768;
                            if (i28 != 0) {
                            }
                            i29 = i6 & 65536;
                            if (i29 != 0) {
                            }
                            i30 = i6 & 131072;
                            if (i30 != 0) {
                            }
                            if ((i4 & 100663296) == 0) {
                            }
                            i31 = i6 & 524288;
                            if (i31 != 0) {
                            }
                            i32 = i6 & 1048576;
                            if (i32 != 0) {
                            }
                            if ((i5 & 48) == 0) {
                            }
                            if ((i5 & 384) == 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i15 = i14;
                        i16 = i6 & 1024;
                        if (i16 == 0) {
                        }
                        i19 = i6 & 2048;
                        if (i19 == 0) {
                        }
                        int i432 = i18;
                        i21 = i7;
                        i22 = i6 & 4096;
                        if (i22 == 0) {
                        }
                        i24 = i6 & 8192;
                        if (i24 == 0) {
                        }
                        i26 = i6 & 16384;
                        if (i26 != 0) {
                        }
                        i28 = i6 & 32768;
                        if (i28 != 0) {
                        }
                        i29 = i6 & 65536;
                        if (i29 != 0) {
                        }
                        i30 = i6 & 131072;
                        if (i30 != 0) {
                        }
                        if ((i4 & 100663296) == 0) {
                        }
                        i31 = i6 & 524288;
                        if (i31 != 0) {
                        }
                        i32 = i6 & 1048576;
                        if (i32 != 0) {
                        }
                        if ((i5 & 48) == 0) {
                        }
                        if ((i5 & 384) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i13 = i12;
                    i14 = i6 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i6 & 1024;
                    if (i16 == 0) {
                    }
                    i19 = i6 & 2048;
                    if (i19 == 0) {
                    }
                    int i4322 = i18;
                    i21 = i7;
                    i22 = i6 & 4096;
                    if (i22 == 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 == 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 != 0) {
                    }
                    i28 = i6 & 32768;
                    if (i28 != 0) {
                    }
                    i29 = i6 & 65536;
                    if (i29 != 0) {
                    }
                    i30 = i6 & 131072;
                    if (i30 != 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    i31 = i6 & 524288;
                    if (i31 != 0) {
                    }
                    i32 = i6 & 1048576;
                    if (i32 != 0) {
                    }
                    if ((i5 & 48) == 0) {
                    }
                    if ((i5 & 384) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z6 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                i11 = i6 & 128;
                if (i11 == 0) {
                }
                i12 = i6 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i6 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i6 & 1024;
                if (i16 == 0) {
                }
                i19 = i6 & 2048;
                if (i19 == 0) {
                }
                int i43222 = i18;
                i21 = i7;
                i22 = i6 & 4096;
                if (i22 == 0) {
                }
                i24 = i6 & 8192;
                if (i24 == 0) {
                }
                i26 = i6 & 16384;
                if (i26 != 0) {
                }
                i28 = i6 & 32768;
                if (i28 != 0) {
                }
                i29 = i6 & 65536;
                if (i29 != 0) {
                }
                i30 = i6 & 131072;
                if (i30 != 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                i31 = i6 & 524288;
                if (i31 != 0) {
                }
                i32 = i6 & 1048576;
                if (i32 != 0) {
                }
                if ((i5 & 48) == 0) {
                }
                if ((i5 & 384) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z5 = z;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z6 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            i11 = i6 & 128;
            if (i11 == 0) {
            }
            i12 = i6 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i6 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i6 & 1024;
            if (i16 == 0) {
            }
            i19 = i6 & 2048;
            if (i19 == 0) {
            }
            int i432222 = i18;
            i21 = i7;
            i22 = i6 & 4096;
            if (i22 == 0) {
            }
            i24 = i6 & 8192;
            if (i24 == 0) {
            }
            i26 = i6 & 16384;
            if (i26 != 0) {
            }
            i28 = i6 & 32768;
            if (i28 != 0) {
            }
            i29 = i6 & 65536;
            if (i29 != 0) {
            }
            i30 = i6 & 131072;
            if (i30 != 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            i31 = i6 & 524288;
            if (i31 != 0) {
            }
            i32 = i6 & 1048576;
            if (i32 != 0) {
            }
            if ((i5 & 48) == 0) {
            }
            if ((i5 & 384) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z5 = z;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z6 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        i11 = i6 & 128;
        if (i11 == 0) {
        }
        i12 = i6 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i6 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i6 & 1024;
        if (i16 == 0) {
        }
        i19 = i6 & 2048;
        if (i19 == 0) {
        }
        int i4322222 = i18;
        i21 = i7;
        i22 = i6 & 4096;
        if (i22 == 0) {
        }
        i24 = i6 & 8192;
        if (i24 == 0) {
        }
        i26 = i6 & 16384;
        if (i26 != 0) {
        }
        i28 = i6 & 32768;
        if (i28 != 0) {
        }
        i29 = i6 & 65536;
        if (i29 != 0) {
        }
        i30 = i6 & 131072;
        if (i30 != 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        i31 = i6 & 524288;
        if (i31 != 0) {
        }
        i32 = i6 & 1048576;
        if (i32 != 0) {
        }
        if ((i5 & 48) == 0) {
        }
        if ((i5 & 384) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:358:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedTextField(final String str, final Function1<? super String, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5, final int i6) {
        String str2;
        int i7;
        Function1<? super String, Unit> function12;
        Modifier modifier2;
        int i8;
        boolean z5;
        int i9;
        boolean z6;
        TextStyle textStyle2;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function29;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final boolean z7;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActions keyboardActions2;
        final boolean z8;
        final int i34;
        final int i35;
        final MutableInteractionSource mutableInteractionSource2;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        Composer composer2;
        final boolean z9;
        final boolean z10;
        final TextStyle textStyle3;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        final VisualTransformation visualTransformation2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i36;
        int i37;
        Shape shape3;
        Function2<? super Composer, ? super Integer, Unit> function217;
        Function2<? super Composer, ? super Integer, Unit> function218;
        TextStyle textStyle4;
        Function2<? super Composer, ? super Integer, Unit> function219;
        Function2<? super Composer, ? super Integer, Unit> function220;
        Modifier modifier4;
        Function2<? super Composer, ? super Integer, Unit> function221;
        boolean z11;
        int i38;
        Function2<? super Composer, ? super Integer, Unit> function222;
        KeyboardOptions keyboardOptions3;
        KeyboardActions keyboardActions3;
        boolean z12;
        int i39;
        int i40;
        TextFieldColors textFieldColorsColors;
        VisualTransformation visualTransformation3;
        boolean z13;
        boolean z14;
        int i41;
        MutableInteractionSource mutableInteractionSource3;
        MutableInteractionSource mutableInteractionSource4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1901501544);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,visualTransformation,keyboardOptions,keyboardActions,singleLine,maxLines,minLines,interactionSource,shape,colors)404@23117L2830,404@23030L2917:OutlinedTextField.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i3 | 6;
            str2 = str;
        } else {
            str2 = str;
            if ((i3 & 6) == 0) {
                i7 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i3;
            } else {
                i7 = i3;
            }
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i3 & 48) == 0) {
                i7 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i42 = i6 & 4;
        if (i42 != 0) {
            i7 |= 384;
        } else {
            if ((i3 & 384) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else {
                if ((i3 & 3072) == 0) {
                    z5 = z;
                    i7 |= composerStartRestartGroup.changed(z5) ? 2048 : 1024;
                }
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else {
                    if ((i3 & 24576) == 0) {
                        z6 = z2;
                        i7 |= composerStartRestartGroup.changed(z6) ? 16384 : 8192;
                    }
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        textStyle2 = textStyle;
                        i7 |= ((i6 & 32) == 0 && composerStartRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                        function28 = function2;
                    } else {
                        function28 = function2;
                        if ((i3 & 1572864) == 0) {
                            i7 |= composerStartRestartGroup.changedInstance(function28) ? 1048576 : 524288;
                        }
                    }
                    i11 = i6 & 128;
                    if (i11 == 0) {
                        i7 |= 12582912;
                        function29 = function22;
                    } else {
                        function29 = function22;
                        if ((i3 & 12582912) == 0) {
                            i7 |= composerStartRestartGroup.changedInstance(function29) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i6 & 256;
                    if (i12 == 0) {
                        i7 |= 100663296;
                    } else {
                        if ((i3 & 100663296) == 0) {
                            i13 = i12;
                            i7 |= composerStartRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        }
                        i14 = i6 & 512;
                        if (i14 != 0) {
                            i7 |= 805306368;
                        } else {
                            if ((i3 & 805306368) == 0) {
                                i15 = i14;
                                i7 |= composerStartRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            }
                            i16 = i6 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 6) == 0) {
                                i17 = i16;
                                i18 = i4 | (composerStartRestartGroup.changedInstance(function25) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            i19 = i6 & 2048;
                            if (i19 == 0) {
                                i18 |= 48;
                                i20 = i19;
                            } else if ((i4 & 48) == 0) {
                                i20 = i19;
                                i18 |= composerStartRestartGroup.changedInstance(function26) ? 32 : 16;
                            } else {
                                i20 = i19;
                            }
                            int i43 = i18;
                            i21 = i7;
                            i22 = i6 & 4096;
                            if (i22 == 0) {
                                i23 = i43 | 384;
                            } else {
                                int i44 = i43;
                                if ((i4 & 384) == 0) {
                                    i44 |= composerStartRestartGroup.changedInstance(function27) ? 256 : 128;
                                }
                                i23 = i44;
                            }
                            i24 = i6 & 8192;
                            if (i24 == 0) {
                                i25 = i23 | 3072;
                            } else {
                                int i45 = i23;
                                if ((i4 & 3072) == 0) {
                                    i25 = i45 | (composerStartRestartGroup.changed(z3) ? 2048 : 1024);
                                } else {
                                    i25 = i45;
                                }
                            }
                            i26 = i6 & 16384;
                            if (i26 != 0) {
                                i27 = i25;
                                if ((i4 & 24576) == 0) {
                                    i27 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                                }
                                i28 = i6 & 32768;
                                if (i28 != 0) {
                                    i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i27 |= composerStartRestartGroup.changed(keyboardOptions) ? 131072 : 65536;
                                }
                                i29 = i6 & 65536;
                                if (i29 != 0) {
                                    i27 |= 1572864;
                                } else if ((i4 & 1572864) == 0) {
                                    i27 |= composerStartRestartGroup.changed(keyboardActions) ? 1048576 : 524288;
                                }
                                i30 = i6 & 131072;
                                if (i30 != 0) {
                                    i27 |= 12582912;
                                } else if ((i4 & 12582912) == 0) {
                                    i27 |= composerStartRestartGroup.changed(z4) ? 8388608 : 4194304;
                                }
                                if ((i4 & 100663296) == 0) {
                                    i27 |= ((i6 & 262144) == 0 && composerStartRestartGroup.changed(i)) ? 67108864 : 33554432;
                                }
                                i31 = i6 & 524288;
                                if (i31 != 0) {
                                    i27 |= 805306368;
                                } else if ((i4 & 805306368) == 0) {
                                    i27 |= composerStartRestartGroup.changed(i2) ? 536870912 : 268435456;
                                }
                                i32 = i6 & 1048576;
                                if (i32 != 0) {
                                    i33 = i5 | 6;
                                } else if ((i5 & 6) == 0) {
                                    i33 = i5 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                } else {
                                    i33 = i5;
                                }
                                if ((i5 & 48) == 0) {
                                    i33 |= ((i6 & 2097152) == 0 && composerStartRestartGroup.changed(shape)) ? 32 : 16;
                                }
                                if ((i5 & 384) == 0) {
                                    i33 |= ((i6 & 4194304) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 256 : 128;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "375@21669L7,391@22473L5,392@22536L8");
                                    if ((i3 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i42 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i8 != 0) {
                                            z5 = true;
                                        }
                                        if (i9 != 0) {
                                            z6 = false;
                                        }
                                        if ((i6 & 32) != 0) {
                                            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            i36 = i21 & (-458753);
                                            textStyle2 = (TextStyle) objConsume;
                                        } else {
                                            i36 = i21;
                                        }
                                        if (i10 != 0) {
                                            function28 = null;
                                        }
                                        if (i11 != 0) {
                                            function29 = null;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function223 = i13 != 0 ? null : function23;
                                        Function2<? super Composer, ? super Integer, Unit> function224 = i15 != 0 ? null : function24;
                                        Function2<? super Composer, ? super Integer, Unit> function225 = i17 != 0 ? null : function25;
                                        Function2<? super Composer, ? super Integer, Unit> function226 = i20 != 0 ? null : function26;
                                        Function2<? super Composer, ? super Integer, Unit> function227 = i22 != 0 ? null : function27;
                                        boolean z15 = i24 != 0 ? false : z3;
                                        VisualTransformation none = i26 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                        KeyboardOptions keyboardOptions4 = i28 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        KeyboardActions keyboardActions4 = i29 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                        boolean z16 = i30 != 0 ? false : z4;
                                        if ((i6 & 262144) != 0) {
                                            i37 = z16 ? 1 : Integer.MAX_VALUE;
                                            i27 &= -234881025;
                                        } else {
                                            i37 = i;
                                        }
                                        int i46 = i31 != 0 ? 1 : i2;
                                        MutableInteractionSource mutableInteractionSource5 = i32 == 0 ? mutableInteractionSource : null;
                                        Shape shape4 = (i6 & 2097152) != 0 ? OutlinedTextFieldDefaults.INSTANCE.getShape(composerStartRestartGroup, 6) : shape;
                                        if ((i6 & 4194304) != 0) {
                                            shape3 = shape4;
                                            function217 = function223;
                                            function218 = function224;
                                            function219 = function225;
                                            function220 = function29;
                                            function221 = function226;
                                            z11 = z15;
                                            i38 = i27;
                                            function222 = function227;
                                            keyboardOptions3 = keyboardOptions4;
                                            keyboardActions3 = keyboardActions4;
                                            z12 = z16;
                                            i39 = i37;
                                            i40 = i46;
                                            textFieldColorsColors = OutlinedTextFieldDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                            visualTransformation3 = none;
                                            z14 = z6;
                                            textStyle4 = textStyle2;
                                            modifier4 = modifier2;
                                            i41 = i36;
                                            z13 = z5;
                                        } else {
                                            shape3 = shape4;
                                            function217 = function223;
                                            function218 = function224;
                                            textStyle4 = textStyle2;
                                            function219 = function225;
                                            function220 = function29;
                                            modifier4 = modifier2;
                                            function221 = function226;
                                            z11 = z15;
                                            i38 = i27;
                                            function222 = function227;
                                            keyboardOptions3 = keyboardOptions4;
                                            keyboardActions3 = keyboardActions4;
                                            z12 = z16;
                                            i39 = i37;
                                            i40 = i46;
                                            textFieldColorsColors = textFieldColors;
                                            visualTransformation3 = none;
                                            z13 = z5;
                                            z14 = z6;
                                            i41 = i36;
                                        }
                                        mutableInteractionSource3 = mutableInteractionSource5;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        i41 = (i6 & 32) != 0 ? i21 & (-458753) : i21;
                                        if ((i6 & 262144) != 0) {
                                            i27 &= -234881025;
                                        }
                                        function217 = function23;
                                        function218 = function24;
                                        function219 = function25;
                                        function221 = function26;
                                        function222 = function27;
                                        z11 = z3;
                                        visualTransformation3 = visualTransformation;
                                        keyboardActions3 = keyboardActions;
                                        z12 = z4;
                                        i39 = i;
                                        i40 = i2;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        shape3 = shape;
                                        z14 = z6;
                                        textStyle4 = textStyle2;
                                        function220 = function29;
                                        modifier4 = modifier2;
                                        i38 = i27;
                                        keyboardOptions3 = keyboardOptions;
                                        textFieldColorsColors = textFieldColors;
                                        z13 = z5;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1901501544, i41, i38, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:393)");
                                    }
                                    if (mutableInteractionSource3 == null) {
                                        composerStartRestartGroup.startReplaceGroup(1310051731);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "395@22631L39");
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1981922383, "CC(remember):OutlinedTextField.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1981921732);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    composerStartRestartGroup.startReplaceGroup(1981927842);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*399@22855L25");
                                    long jM8586getColor0d7_KjU = textStyle4.m8586getColor0d7_KjU();
                                    if (jM8586getColor0d7_KjU == 16) {
                                        jM8586getColor0d7_KjU = textFieldColorsColors.m4255textColorXeAY9LY$material3(z13, z11, FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource4, composerStartRestartGroup, 0).getValue().booleanValue());
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColorsColors.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1874034984, true, new AnonymousClass3(modifier4, function28, z11, textFieldColorsColors, str2, function12, z13, z14, textStyle4.merge(new TextStyle(jM8586getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null)), keyboardOptions3, keyboardActions3, z12, i39, i40, visualTransformation3, mutableInteractionSource4, function220, function217, function218, function219, function221, function222, shape3), composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    textStyle3 = textStyle4;
                                    composer2 = composerStartRestartGroup;
                                    modifier3 = modifier4;
                                    function212 = function28;
                                    z7 = z11;
                                    z9 = z13;
                                    z10 = z14;
                                    keyboardOptions2 = keyboardOptions3;
                                    keyboardActions2 = keyboardActions3;
                                    z8 = z12;
                                    i34 = i39;
                                    i35 = i40;
                                    visualTransformation2 = visualTransformation3;
                                    function213 = function220;
                                    function214 = function217;
                                    function215 = function218;
                                    function210 = function219;
                                    function211 = function222;
                                    shape2 = shape3;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    textFieldColors2 = textFieldColorsColors;
                                    function216 = function221;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    function210 = function25;
                                    function211 = function27;
                                    z7 = z3;
                                    keyboardOptions2 = keyboardOptions;
                                    keyboardActions2 = keyboardActions;
                                    z8 = z4;
                                    i34 = i;
                                    i35 = i2;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    shape2 = shape;
                                    textFieldColors2 = textFieldColors;
                                    composer2 = composerStartRestartGroup;
                                    z9 = z5;
                                    z10 = z6;
                                    textStyle3 = textStyle2;
                                    function212 = function28;
                                    function213 = function29;
                                    modifier3 = modifier2;
                                    function214 = function23;
                                    function215 = function24;
                                    function216 = function26;
                                    visualTransformation2 = visualTransformation;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return OutlinedTextFieldKt.OutlinedTextField$lambda$5(str, function1, modifier3, z9, z10, textStyle3, function212, function213, function214, function215, function210, function216, function211, z7, visualTransformation2, keyboardOptions2, keyboardActions2, z8, i34, i35, mutableInteractionSource2, shape2, textFieldColors2, i3, i4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i27 = i25 | 24576;
                            i28 = i6 & 32768;
                            if (i28 != 0) {
                            }
                            i29 = i6 & 65536;
                            if (i29 != 0) {
                            }
                            i30 = i6 & 131072;
                            if (i30 != 0) {
                            }
                            if ((i4 & 100663296) == 0) {
                            }
                            i31 = i6 & 524288;
                            if (i31 != 0) {
                            }
                            i32 = i6 & 1048576;
                            if (i32 != 0) {
                            }
                            if ((i5 & 48) == 0) {
                            }
                            if ((i5 & 384) == 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i15 = i14;
                        i16 = i6 & 1024;
                        if (i16 == 0) {
                        }
                        i19 = i6 & 2048;
                        if (i19 == 0) {
                        }
                        int i432 = i18;
                        i21 = i7;
                        i22 = i6 & 4096;
                        if (i22 == 0) {
                        }
                        i24 = i6 & 8192;
                        if (i24 == 0) {
                        }
                        i26 = i6 & 16384;
                        if (i26 != 0) {
                        }
                        i28 = i6 & 32768;
                        if (i28 != 0) {
                        }
                        i29 = i6 & 65536;
                        if (i29 != 0) {
                        }
                        i30 = i6 & 131072;
                        if (i30 != 0) {
                        }
                        if ((i4 & 100663296) == 0) {
                        }
                        i31 = i6 & 524288;
                        if (i31 != 0) {
                        }
                        i32 = i6 & 1048576;
                        if (i32 != 0) {
                        }
                        if ((i5 & 48) == 0) {
                        }
                        if ((i5 & 384) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i13 = i12;
                    i14 = i6 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i6 & 1024;
                    if (i16 == 0) {
                    }
                    i19 = i6 & 2048;
                    if (i19 == 0) {
                    }
                    int i4322 = i18;
                    i21 = i7;
                    i22 = i6 & 4096;
                    if (i22 == 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 == 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 != 0) {
                    }
                    i28 = i6 & 32768;
                    if (i28 != 0) {
                    }
                    i29 = i6 & 65536;
                    if (i29 != 0) {
                    }
                    i30 = i6 & 131072;
                    if (i30 != 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    i31 = i6 & 524288;
                    if (i31 != 0) {
                    }
                    i32 = i6 & 1048576;
                    if (i32 != 0) {
                    }
                    if ((i5 & 48) == 0) {
                    }
                    if ((i5 & 384) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z6 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                i11 = i6 & 128;
                if (i11 == 0) {
                }
                i12 = i6 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i6 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i6 & 1024;
                if (i16 == 0) {
                }
                i19 = i6 & 2048;
                if (i19 == 0) {
                }
                int i43222 = i18;
                i21 = i7;
                i22 = i6 & 4096;
                if (i22 == 0) {
                }
                i24 = i6 & 8192;
                if (i24 == 0) {
                }
                i26 = i6 & 16384;
                if (i26 != 0) {
                }
                i28 = i6 & 32768;
                if (i28 != 0) {
                }
                i29 = i6 & 65536;
                if (i29 != 0) {
                }
                i30 = i6 & 131072;
                if (i30 != 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                i31 = i6 & 524288;
                if (i31 != 0) {
                }
                i32 = i6 & 1048576;
                if (i32 != 0) {
                }
                if ((i5 & 48) == 0) {
                }
                if ((i5 & 384) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z5 = z;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z6 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            i11 = i6 & 128;
            if (i11 == 0) {
            }
            i12 = i6 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i6 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i6 & 1024;
            if (i16 == 0) {
            }
            i19 = i6 & 2048;
            if (i19 == 0) {
            }
            int i432222 = i18;
            i21 = i7;
            i22 = i6 & 4096;
            if (i22 == 0) {
            }
            i24 = i6 & 8192;
            if (i24 == 0) {
            }
            i26 = i6 & 16384;
            if (i26 != 0) {
            }
            i28 = i6 & 32768;
            if (i28 != 0) {
            }
            i29 = i6 & 65536;
            if (i29 != 0) {
            }
            i30 = i6 & 131072;
            if (i30 != 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            i31 = i6 & 524288;
            if (i31 != 0) {
            }
            i32 = i6 & 1048576;
            if (i32 != 0) {
            }
            if ((i5 & 48) == 0) {
            }
            if ((i5 & 384) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z5 = z;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z6 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        i11 = i6 & 128;
        if (i11 == 0) {
        }
        i12 = i6 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i6 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i6 & 1024;
        if (i16 == 0) {
        }
        i19 = i6 & 2048;
        if (i19 == 0) {
        }
        int i4322222 = i18;
        i21 = i7;
        i22 = i6 & 4096;
        if (i22 == 0) {
        }
        i24 = i6 & 8192;
        if (i24 == 0) {
        }
        i26 = i6 & 16384;
        if (i26 != 0) {
        }
        i28 = i6 & 32768;
        if (i28 != 0) {
        }
        i29 = i6 & 65536;
        if (i29 != 0) {
        }
        i30 = i6 & 131072;
        if (i30 != 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        i31 = i6 & 524288;
        if (i31 != 0) {
        }
        i32 = i6 & 1048576;
        if (i32 != 0) {
        }
        if ((i5 & 48) == 0) {
        }
        if ((i5 & 384) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit OutlinedTextField$lambda$2(TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, TextFieldLabelPosition textFieldLabelPosition, Function3 function3, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, boolean z3, InputTransformation inputTransformation, OutputTransformation outputTransformation, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, Function2 function27, ScrollState scrollState, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, int i4, Composer composer, int i5) {
        OutlinedTextField(textFieldState, modifier, z, z2, textStyle, textFieldLabelPosition, function3, function2, function22, function23, function24, function25, function26, z3, inputTransformation, outputTransformation, keyboardOptions, keyboardActionHandler, textFieldLineLimits, function27, scrollState, shape, textFieldColors, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    static final Unit OutlinedTextField$lambda$5(String str, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, Function2 function27, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i3, int i4, int i5, int i6, Composer composer, int i7) {
        OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier, z, z2, textStyle, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function22, (Function2<? super Composer, ? super Integer, Unit>) function23, (Function2<? super Composer, ? super Integer, Unit>) function24, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function26, (Function2<? super Composer, ? super Integer, Unit>) function27, z3, visualTransformation, keyboardOptions, keyboardActions, z4, i, i2, mutableInteractionSource, shape, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    static final Unit OutlinedTextField$lambda$8(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, Function2 function27, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i3, int i4, int i5, int i6, Composer composer, int i7) {
        OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier, z, z2, textStyle, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function22, (Function2<? super Composer, ? super Integer, Unit>) function23, (Function2<? super Composer, ? super Integer, Unit>) function24, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function26, (Function2<? super Composer, ? super Integer, Unit>) function27, z3, visualTransformation, keyboardOptions, keyboardActions, z4, i, i2, mutableInteractionSource, shape, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:280:0x087b  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0883  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x08dd  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x08e9  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x08ed  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0920  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedTextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, final Function2<? super Composer, ? super Integer, Unit> function26, final boolean z, TextFieldLabelPosition textFieldLabelPosition, FloatProducer floatProducer, final Function1<? super Size, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        TextFieldLabelPosition textFieldLabelPosition2;
        Function2<? super Composer, ? super Integer, Unit> function29;
        final FloatProducer floatProducer2;
        Composer composer2;
        PaddingValues paddingValues2;
        Object outlinedTextFieldMeasurePolicy;
        int i5;
        int i6;
        int i7;
        float f;
        boolean z2;
        Object objRememberedValue;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Composer composerStartRestartGroup = composer.startRestartGroup(753699262);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextFieldLayout)N(modifier,textField,placeholder,label,leading,trailing,prefix,suffix,singleLine,labelPosition,labelProgress,onLabelMeasured,container,supporting,paddingValues)660@36112L32,662@36177L554,679@36779L7,680@36791L4040:OutlinedTextField.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function25) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(textFieldLabelPosition) ? 536870912 : 268435456;
        }
        int i8 = i3;
        if ((i2 & 6) == 0) {
            i4 = i2 | ((i2 & 8) == 0 ? composerStartRestartGroup.changed(floatProducer) : composerStartRestartGroup.changedInstance(floatProducer) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function27) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function28) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(paddingValues) ? 16384 : 8192;
        }
        int i9 = i4;
        if (composerStartRestartGroup.shouldExecute(((i8 & 306783379) == 306783378 && (i9 & 9363) == 9362) ? false : true, i8 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(753699262, i8, i9, "androidx.compose.material3.OutlinedTextFieldLayout (OutlinedTextField.kt:659)");
            }
            float fTextFieldHorizontalIconPadding = TextFieldImplKt.textFieldHorizontalIconPadding(composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1544458712, "CC(remember):OutlinedTextField.kt#9igjgp");
            int i10 = i9 & 14;
            boolean zChanged = ((234881024 & i8) == 67108864) | ((i9 & 112) == 32) | ((1879048192 & i8) == 536870912) | (i10 == 4 || ((i9 & 8) != 0 && composerStartRestartGroup.changed(floatProducer))) | ((i9 & 57344) == 16384) | composerStartRestartGroup.changed(fTextFieldHorizontalIconPadding);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                i5 = i10;
                i6 = i9;
                i7 = i8;
                composer2 = composerStartRestartGroup;
                paddingValues2 = paddingValues;
                outlinedTextFieldMeasurePolicy = new OutlinedTextFieldMeasurePolicy(function1, z, textFieldLabelPosition, floatProducer, paddingValues2, fTextFieldHorizontalIconPadding, null);
                composer2.updateRememberedValue(outlinedTextFieldMeasurePolicy);
            } else {
                i6 = i9;
                i5 = i10;
                outlinedTextFieldMeasurePolicy = objRememberedValue2;
                i7 = i8;
                composer2 = composerStartRestartGroup;
                paddingValues2 = paddingValues;
            }
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy2 = (OutlinedTextFieldMeasurePolicy) outlinedTextFieldMeasurePolicy;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume;
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer2);
            Updater.m5603setimpl(composerM5595constructorimpl2, outlinedTextFieldMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 2145696067, "C683@36860L11,751@39346L187:OutlinedTextField.kt#uh7d8r");
            function27.invoke(composer2, Integer.valueOf((i6 >> 6) & 14));
            if (function23 != null) {
                composer2.startReplaceGroup(2145628269);
                ComposerKt.sourceInformation(composer2, "686@36924L224");
                Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(LayoutIdKt.layoutId(Modifier.INSTANCE, "Leading"));
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierMinimumInteractiveComponentSize);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer2);
                Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 227456132, "C690@37121L9:OutlinedTextField.kt#uh7d8r");
                function23.invoke(composer2, Integer.valueOf((i7 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(2145874285);
                composer2.endReplaceGroup();
            }
            if (function24 != null) {
                composer2.startReplaceGroup(2145917003);
                ComposerKt.sourceInformation(composer2, "694@37215L226");
                Modifier modifierMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(LayoutIdKt.layoutId(Modifier.INSTANCE, "Trailing"));
                Alignment center2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierMinimumInteractiveComponentSize2);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                Composer composerM5595constructorimpl4 = Updater.m5595constructorimpl(composer2);
                Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    composerM5595constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM5595constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 531295628, "C698@37413L10:OutlinedTextField.kt#uh7d8r");
                function24.invoke(composer2, Integer.valueOf((i7 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(2146164941);
                composer2.endReplaceGroup();
            }
            float fCalculateStartPadding = PaddingKt.calculateStartPadding(paddingValues2, layoutDirection);
            float fCalculateEndPadding = PaddingKt.calculateEndPadding(paddingValues2, layoutDirection);
            if (function23 != null) {
                fCalculateStartPadding = Dp.m9114constructorimpl(RangesKt.coerceAtLeast(Dp.m9114constructorimpl(fCalculateStartPadding - fTextFieldHorizontalIconPadding), Dp.m9114constructorimpl(0.0f)));
            }
            float fM9114constructorimpl = fCalculateStartPadding;
            if (function24 != null) {
                fCalculateEndPadding = Dp.m9114constructorimpl(RangesKt.coerceAtLeast(Dp.m9114constructorimpl(fCalculateEndPadding - fTextFieldHorizontalIconPadding), Dp.m9114constructorimpl(0.0f)));
            }
            if (function25 != null) {
                composer2.startReplaceGroup(2146868920);
                ComposerKt.sourceInformation(composer2, "719@38172L309");
                Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m2071heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.PrefixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), fM9114constructorimpl, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, null);
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierM2041paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor4);
                } else {
                    composer2.useNode();
                }
                Composer composerM5595constructorimpl5 = Updater.m5595constructorimpl(composer2);
                Updater.m5603setimpl(composerM5595constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl5, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    composerM5595constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    composerM5595constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                Updater.m5603setimpl(composerM5595constructorimpl5, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 843401773, "C725@38455L8:OutlinedTextField.kt#uh7d8r");
                function25.invoke(composer2, Integer.valueOf((i7 >> 18) & 14));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(2147196621);
                composer2.endReplaceGroup();
            }
            if (function26 != null) {
                composer2.startReplaceGroup(2147239866);
                ComposerKt.sourceInformation(composer2, "729@38546L307");
                f = fCalculateEndPadding;
                Modifier modifierM2041paddingqDBjuR0$default2 = PaddingKt.m2041paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m2071heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SuffixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, f, 0.0f, 10, null);
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, modifierM2041paddingqDBjuR0$default2);
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor5);
                } else {
                    composer2.useNode();
                }
                Composer composerM5595constructorimpl6 = Updater.m5595constructorimpl(composer2);
                Updater.m5603setimpl(composerM5595constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl6, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl6.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                    composerM5595constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                    composerM5595constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                }
                Updater.m5603setimpl(composerM5595constructorimpl6, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1155507980, "C735@38827L8:OutlinedTextField.kt#uh7d8r");
                function26.invoke(composer2, Integer.valueOf((i7 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                f = fCalculateEndPadding;
                composer2.startReplaceGroup(-2147401651);
                composer2.endReplaceGroup();
            }
            Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.m2071heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null);
            if (function25 != null) {
                fM9114constructorimpl = Dp.m9114constructorimpl(0.0f);
            }
            Modifier modifierM2041paddingqDBjuR0$default3 = PaddingKt.m2041paddingqDBjuR0$default(modifierWrapContentHeight$default, fM9114constructorimpl, 0.0f, function26 == null ? f : Dp.m9114constructorimpl(0.0f), 0.0f, 10, null);
            if (function3 != null) {
                composer2.startReplaceGroup(-2147031666);
                ComposerKt.sourceInformation(composer2, "748@39255L63");
                function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, "Hint").then(modifierM2041paddingqDBjuR0$default3), composer2, Integer.valueOf((i7 >> 3) & 112));
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-2146940371);
                composer2.endReplaceGroup();
            }
            Modifier modifierThen = LayoutIdKt.layoutId(Modifier.INSTANCE, "TextField").then(modifierM2041paddingqDBjuR0$default3);
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer2, modifierThen);
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor6);
            } else {
                composer2.useNode();
            }
            Composer composerM5595constructorimpl7 = Updater.m5595constructorimpl(composer2);
            Updater.m5603setimpl(composerM5595constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl7, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl7.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                composerM5595constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                composerM5595constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            Updater.m5603setimpl(composerM5595constructorimpl7, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -332553027, "C755@39508L11:OutlinedTextField.kt#uh7d8r");
            function2.invoke(composer2, Integer.valueOf((i7 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            textFieldLabelPosition2 = textFieldLabelPosition;
            Modifier.Companion companionM2041paddingqDBjuR0$default = textFieldLabelPosition2 instanceof TextFieldLabelPosition.Above ? PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, TextFieldImplKt.getAboveLabelHorizontalPadding(), 0.0f, TextFieldImplKt.getAboveLabelHorizontalPadding(), TextFieldImplKt.getAboveLabelBottomPadding(), 2, null) : Modifier.INSTANCE;
            if (function22 != null) {
                composer2.startReplaceGroup(-2146287790);
                ComposerKt.sourceInformation(composer2, "771@40053L123,770@39995L379");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -2147442928, "CC(remember):OutlinedTextField.kt#9igjgp");
                if (i5 != 4) {
                    if ((i6 & 8) != 0) {
                        floatProducer2 = floatProducer;
                        if (composer2.changedInstance(floatProducer2)) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Dp.m9112boximpl(DpKt.m9157lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), floatProducer2.invoke()));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Modifier modifierThen2 = LayoutIdKt.layoutId(SizeKt.wrapContentHeight$default(TextFieldImplKt.textFieldLabelMinHeight(companion, (Function0) objRememberedValue), null, false, 3, null), "Label").then(companionM2041paddingqDBjuR0$default);
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer2, modifierThen2);
                        Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.useNode();
                        } else {
                            composer2.createNode(constructor7);
                        }
                        composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1779720363, "C778@40349L7:OutlinedTextField.kt#uh7d8r");
                        function22.invoke(composer2, Integer.valueOf((i7 >> 9) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceGroup();
                    } else {
                        floatProducer2 = floatProducer;
                    }
                    z2 = false;
                    objRememberedValue = composer2.rememberedValue();
                    if (z2) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Dp.m9112boximpl(DpKt.m9157lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), floatProducer2.invoke()));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Modifier modifierThen22 = LayoutIdKt.layoutId(SizeKt.wrapContentHeight$default(TextFieldImplKt.textFieldLabelMinHeight(companion, (Function0) objRememberedValue), null, false, 3, null), "Label").then(companionM2041paddingqDBjuR0$default);
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy62 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap72 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier72 = ComposedModifierKt.materializeModifier(composer2, modifierThen22);
                        Function0<ComposeUiNode> constructor72 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                        }
                        composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy62, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap72, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5595constructorimpl.getInserting()) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier72, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance62 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1779720363, "C778@40349L7:OutlinedTextField.kt#uh7d8r");
                            function22.invoke(composer2, Integer.valueOf((i7 >> 9) & 14));
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceGroup();
                        }
                    }
                } else {
                    floatProducer2 = floatProducer;
                }
                z2 = true;
                objRememberedValue = composer2.rememberedValue();
                if (z2) {
                }
            } else {
                floatProducer2 = floatProducer;
                composer2.startReplaceGroup(-2145892819);
                composer2.endReplaceGroup();
            }
            if (function28 != null) {
                composer2.startReplaceGroup(-2145844304);
                ComposerKt.sourceInformation(composer2, "783@40444L317");
                Modifier modifierPadding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m2071heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SupportingId), TextFieldImplKt.getMinSupportingTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldDefaults.m4264supportingTextPaddinga9UjIt4$material3$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap8 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer2, modifierPadding);
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor8);
                } else {
                    composer2.useNode();
                }
                Composer composerM5595constructorimpl8 = Updater.m5595constructorimpl(composer2);
                Updater.m5603setimpl(composerM5595constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl8.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                    composerM5595constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                    composerM5595constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                }
                Updater.m5603setimpl(composerM5595constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 2091826725, "C789@40731L12:OutlinedTextField.kt#uh7d8r");
                function29 = function28;
                function29.invoke(composer2, Integer.valueOf((i6 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                function29 = function28;
                composer2.startReplaceGroup(-2145508915);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            textFieldLabelPosition2 = textFieldLabelPosition;
            function29 = function28;
            floatProducer2 = floatProducer;
            composer2 = composerStartRestartGroup;
            paddingValues2 = paddingValues;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final FloatProducer floatProducer3 = floatProducer2;
            final TextFieldLabelPosition textFieldLabelPosition3 = textFieldLabelPosition2;
            final PaddingValues paddingValues3 = paddingValues2;
            final Function2<? super Composer, ? super Integer, Unit> function210 = function29;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OutlinedTextFieldKt.OutlinedTextFieldLayout$lambda$20(modifier, function2, function3, function22, function23, function24, function25, function26, z, textFieldLabelPosition3, floatProducer3, function1, function27, function210, paddingValues3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit OutlinedTextFieldLayout$lambda$20(Modifier modifier, Function2 function2, Function3 function3, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, boolean z, TextFieldLabelPosition textFieldLabelPosition, FloatProducer floatProducer, Function1 function1, Function2 function27, Function2 function28, PaddingValues paddingValues, int i, int i2, Composer composer, int i3) {
        OutlinedTextFieldLayout(modifier, function2, function3, function22, function23, function24, function25, function26, z, textFieldLabelPosition, floatProducer, function1, function27, function28, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    public static final Modifier outlineCutout(Modifier modifier, final Function0<Size> function0, final Alignment.Horizontal horizontal, final PaddingValues paddingValues) {
        return DrawModifierKt.drawWithContent(modifier, new Function1() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OutlinedTextFieldKt.outlineCutout$lambda$22(function0, paddingValues, horizontal, (ContentDrawScope) obj);
            }
        });
    }

    static final Unit outlineCutout$lambda$22(Function0 function0, PaddingValues paddingValues, Alignment.Horizontal horizontal, ContentDrawScope contentDrawScope) {
        long jM6154unboximpl = ((Size) function0.invoke()).m6154unboximpl();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM6154unboximpl >> 32));
        if (fIntBitsToFloat > 0.0f) {
            float f = contentDrawScope.mo1624toPx0680j_4(OutlinedTextFieldInnerPadding);
            float fAlign = horizontal.align(MathKt.roundToInt(fIntBitsToFloat), MathKt.roundToInt((Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() >> 32)) - r5) - contentDrawScope.mo1624toPx0680j_4(paddingValues.mo1988calculateRightPaddingu2uoSUM(contentDrawScope.getLayoutDirection()))), contentDrawScope.getLayoutDirection()) + contentDrawScope.mo1624toPx0680j_4(paddingValues.mo1987calculateLeftPaddingu2uoSUM(contentDrawScope.getLayoutDirection()));
            float f2 = fIntBitsToFloat / 2.0f;
            float f3 = fAlign + f2;
            float fCoerceAtLeast = RangesKt.coerceAtLeast((f3 - f2) - f, 0.0f);
            float fCoerceAtMost = RangesKt.coerceAtMost(f3 + f2 + f, Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() >> 32)));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (MuxerUtil.UNSIGNED_INT_MAX_VALUE & jM6154unboximpl));
            float f4 = (-fIntBitsToFloat2) / 2.0f;
            float f5 = fIntBitsToFloat2 / 2.0f;
            int iM6313getDifferencertfAjoo = ClipOp.INSTANCE.m6313getDifferencertfAjoo();
            DrawContext drawContext = contentDrawScope.getDrawContext();
            long jMo6820getSizeNHjbRc = drawContext.mo6820getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo6823clipRectN_I0leg(fCoerceAtLeast, f4, fCoerceAtMost, f5, iM6313getDifferencertfAjoo);
                contentDrawScope.drawContent();
            } finally {
                drawContext.getCanvas().restore();
                drawContext.mo6821setSizeuvyYCjk(jMo6820getSizeNHjbRc);
            }
        } else {
            contentDrawScope.drawContent();
        }
        return Unit.INSTANCE;
    }
}
