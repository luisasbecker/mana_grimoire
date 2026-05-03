package androidx.compose.material;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
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
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
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
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
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
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.messaging.Constants;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0085\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H\u0007¢\u0006\u0002\u0010$\u001a\u0093\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u00101\u001a\u0087\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u00102\u001a\u0093\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010%\u001a\u0002032\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u00104\u001a\u0087\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010%\u001a\u0002032\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u00105\u001aÁ\u0001\u00106\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\r2\u0019\u0010\u000e\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010(¢\u0006\u0002\b\r2\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u00108\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u00109\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010:\u001a\u00020;2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u00010(2\u0011\u0010>\u001a\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\r2\u0006\u0010?\u001a\u00020@H\u0001¢\u0006\u0002\u0010A\u001aW\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020/2\u0006\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020/2\u0006\u0010:\u001a\u00020;2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020;2\u0006\u0010?\u001a\u00020@H\u0002¢\u0006\u0004\bK\u0010L\u001aW\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020/2\u0006\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u00020/2\u0006\u0010R\u001a\u00020/2\u0006\u0010:\u001a\u00020;2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020;2\u0006\u0010?\u001a\u00020@H\u0002¢\u0006\u0004\bS\u0010L\u001a|\u0010T\u001a\u00020\u0001*\u00020U2\u0006\u0010V\u001a\u00020/2\u0006\u0010W\u001a\u00020/2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010Y2\u0006\u0010[\u001a\u00020Y2\b\u0010\\\u001a\u0004\u0018\u00010Y2\b\u0010]\u001a\u0004\u0018\u00010Y2\u0006\u0010^\u001a\u00020Y2\u0006\u0010:\u001a\u00020;2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010J\u001a\u00020;2\u0006\u0010_\u001a\u00020`2\u0006\u0010?\u001a\u00020@H\u0002\u001a#\u0010a\u001a\u00020\u0005*\u00020\u00052\u0006\u0010b\u001a\u00020=2\u0006\u0010?\u001a\u00020@H\u0000¢\u0006\u0004\bc\u0010d\"\u0010\u0010e\u001a\u00020fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010g\"\u0016\u0010h\u001a\u00020iX\u0080\u0004¢\u0006\n\n\u0002\u0010l\u001a\u0004\bj\u0010k\"\u000e\u0010m\u001a\u00020&X\u0080T¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"OutlinedTextField", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", Constants.ScionAnalytics.PARAM_LABEL, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "value", "", "onValueChange", "Lkotlin/Function1;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", OutlinedTextFieldKt.BorderId, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "constraints", "Landroidx/compose/ui/unit/Constraints;", AndroidContextPlugin.SCREEN_DENSITY_KEY, "calculateWidth-O3s9Psw", "(IIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "calculateHeight-O3s9Psw", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "height", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "borderPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "Landroidx/compose/ui/unit/TextUnit;", "getOutlinedTextFieldTopPadding", "()J", "J", "BorderId", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class OutlinedTextFieldKt {
    public static final String BorderId = "border";
    private static final float OutlinedTextFieldInnerPadding = Dp.m9114constructorimpl(4.0f);
    private static final long OutlinedTextFieldTopPadding = TextUnitKt.getSp(8);

    /* JADX INFO: renamed from: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3, reason: invalid class name */
    /* JADX INFO: compiled from: OutlinedTextField.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass3 implements TextFieldDecorator {
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ Function2<Composer, Integer, Unit> $label;
        final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
        final /* synthetic */ TextFieldLineLimits $lineLimits;
        final /* synthetic */ OutputTransformation $outputTransformation;
        final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(OutputTransformation outputTransformation, TextFieldState textFieldState, TextFieldLineLimits textFieldLineLimits, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, TextFieldColors textFieldColors) {
            this.$outputTransformation = outputTransformation;
            this.$state = textFieldState;
            this.$lineLimits = textFieldLineLimits;
            this.$enabled = z;
            this.$interactionSource = mutableInteractionSource;
            this.$isError = z2;
            this.$label = function2;
            this.$placeholder = function22;
            this.$leadingIcon = function23;
            this.$trailingIcon = function24;
            this.$shape = shape;
            this.$colors = textFieldColors;
        }

        static final Unit Decoration$lambda$2(boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, TextFieldColors textFieldColors, Shape shape, Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C247@13223L61:OutlinedTextField.kt#jmzs0o");
            if (composer.shouldExecute((i & 3) != 2, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(413830957, i, -1, "androidx.compose.material.OutlinedTextField.<no name provided>.Decoration.<anonymous> (OutlinedTextField.kt:247)");
                }
                TextFieldDefaults.INSTANCE.m3208BorderBoxnbWgWpA(z, z2, mutableInteractionSource, textFieldColors, shape, 0.0f, 0.0f, composer, 12582912, 96);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composer.skipToGroupEnd();
            }
            return Unit.INSTANCE;
        }

        static final Unit Decoration$lambda$3(AnonymousClass3 anonymousClass3, Function2 function2, int i, Composer composer, int i2) {
            anonymousClass3.Decoration(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            return Unit.INSTANCE;
        }

        @Override // androidx.compose.foundation.text.input.TextFieldDecorator
        public final void Decoration(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
            int i2;
            Composer composer2;
            TextFieldBuffer textFieldBuffer;
            String string;
            final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
            Composer composerStartRestartGroup = composer.startRestartGroup(1251830469);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)N(innerTextField)246@13183L119,232@12557L760:OutlinedTextField.kt#jmzs0o");
            if ((i & 6) == 0) {
                i2 = i | (composerStartRestartGroup.changedInstance(function22) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= composerStartRestartGroup.changed(this) ? 32 : 16;
            }
            if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1251830469, i2, -1, "androidx.compose.material.OutlinedTextField.<no name provided>.Decoration (OutlinedTextField.kt:219)");
                }
                OutputTransformation outputTransformation = this.$outputTransformation;
                TextFieldState textFieldState = this.$state;
                if (outputTransformation == null) {
                    string = textFieldState.getText().toString();
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
                        string = textFieldBufferStartEdit.asCharSequence().toString();
                    } catch (Throwable th) {
                        textFieldState.finishEditing();
                        throw th;
                    }
                }
                TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                VisualTransformation none = VisualTransformation.INSTANCE.getNone();
                boolean zAreEqual = Intrinsics.areEqual(this.$lineLimits, TextFieldLineLimits.SingleLine.INSTANCE);
                final boolean z = this.$enabled;
                final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                final boolean z2 = this.$isError;
                Function2<Composer, Integer, Unit> function23 = this.$label;
                Function2<Composer, Integer, Unit> function24 = this.$placeholder;
                Function2<Composer, Integer, Unit> function25 = this.$leadingIcon;
                Function2<Composer, Integer, Unit> function26 = this.$trailingIcon;
                final Shape shape = this.$shape;
                final TextFieldColors textFieldColors = this.$colors;
                composer2 = composerStartRestartGroup;
                function22 = function2;
                textFieldDefaults.OutlinedTextFieldDecorationBox(string, function22, z, zAreEqual, none, mutableInteractionSource, z2, function23, function24, function25, function26, shape, textFieldColors, null, ComposableLambdaKt.rememberComposableLambda(413830957, true, new Function2() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OutlinedTextFieldKt.AnonymousClass3.Decoration$lambda$2(z, z2, mutableInteractionSource, textFieldColors, shape, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i2 << 3) & 112) | 24576, 221184, 8192);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OutlinedTextFieldKt.AnonymousClass3.Decoration$lambda$3(this.f$0, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: OutlinedTextField.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:319:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedTextField(final TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z3, InputTransformation inputTransformation, OutputTransformation outputTransformation, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, ScrollState scrollState, Shape shape, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        TextStyle textStyle2;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function27;
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
        Composer composer2;
        final boolean z5;
        final OutputTransformation outputTransformation2;
        final KeyboardOptions keyboardOptions2;
        final ScrollState scrollState2;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final MutableInteractionSource mutableInteractionSource2;
        final TextStyle textStyle3;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final boolean z7;
        final InputTransformation inputTransformation2;
        final KeyboardActionHandler keyboardActionHandler2;
        final TextFieldLineLimits textFieldLineLimits2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z8;
        Function2<? super Composer, ? super Integer, Unit> function212;
        Function2<? super Composer, ? super Integer, Unit> function213;
        InputTransformation inputTransformation3;
        OutputTransformation outputTransformation3;
        KeyboardOptions keyboardOptions3;
        KeyboardActionHandler keyboardActionHandler3;
        TextFieldLineLimits textFieldLineLimits3;
        ScrollState scrollStateRememberScrollState;
        Shape outlinedTextFieldShape;
        Composer composer3;
        TextFieldColors textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
        int i24;
        MutableInteractionSource mutableInteractionSource3;
        int i25;
        int i26;
        boolean z9;
        MutableInteractionSource mutableInteractionSource4;
        TextStyle textStyle4;
        Modifier.Companion companionM2041paddingqDBjuR0$default;
        int i27;
        Composer composerStartRestartGroup = composer.startRestartGroup(1708163690);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextField)N(state,modifier,enabled,readOnly,textStyle,label,placeholder,leadingIcon,trailingIcon,isError,inputTransformation,outputTransformation,keyboardOptions,onKeyboardAction,lineLimits,scrollState,shape,colors,interactionSource)185@10504L7,202@11180L38,210@11525L20,187@10517L2817:OutlinedTextField.kt#jmzs0o");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(textFieldState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i28 = i3 & 2;
        if (i28 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    z4 = z;
                    i4 |= composerStartRestartGroup.changed(z4) ? 256 : 128;
                }
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                    }
                    int i29 = 8192;
                    if ((i & 24576) != 0) {
                        if ((i3 & 16) == 0) {
                            textStyle2 = textStyle;
                            if (composerStartRestartGroup.changed(textStyle2)) {
                                i27 = 16384;
                            }
                            i4 |= i27;
                        } else {
                            textStyle2 = textStyle;
                        }
                        i27 = 8192;
                        i4 |= i27;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function25 = function2;
                    } else {
                        function25 = function2;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function25) ? 131072 : 65536;
                        }
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                        function26 = function22;
                    } else {
                        function26 = function22;
                        if ((i & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function26) ? 1048576 : 524288;
                        }
                    }
                    i9 = i3 & 128;
                    if (i9 == 0) {
                        i4 |= 12582912;
                        function27 = function23;
                    } else {
                        function27 = function23;
                        if ((i & 12582912) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function27) ? 8388608 : 4194304;
                        }
                    }
                    i10 = i3 & 256;
                    if (i10 == 0) {
                        i4 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i11 = i10;
                            i4 |= composerStartRestartGroup.changedInstance(function24) ? 67108864 : 33554432;
                        }
                        i12 = i3 & 512;
                        if (i12 != 0) {
                            i4 |= 805306368;
                        } else {
                            if ((i & 805306368) == 0) {
                                i13 = i12;
                                i4 |= composerStartRestartGroup.changed(z3) ? 536870912 : 268435456;
                            }
                            i14 = i3 & 1024;
                            if (i14 == 0) {
                                i16 = i2 | 6;
                                i15 = i14;
                            } else if ((i2 & 6) == 0) {
                                i15 = i14;
                                i16 = i2 | (composerStartRestartGroup.changed(inputTransformation) ? 4 : 2);
                            } else {
                                i15 = i14;
                                i16 = i2;
                            }
                            i17 = i3 & 2048;
                            if (i17 == 0) {
                                i16 |= 48;
                                i18 = i17;
                            } else if ((i2 & 48) == 0) {
                                i18 = i17;
                                i16 |= composerStartRestartGroup.changed(outputTransformation) ? 32 : 16;
                            } else {
                                i18 = i17;
                            }
                            int i30 = i16;
                            i19 = i3 & 4096;
                            if (i19 == 0) {
                                i20 = i30 | 384;
                            } else {
                                int i31 = i30;
                                if ((i2 & 384) == 0) {
                                    i31 |= composerStartRestartGroup.changed(keyboardOptions) ? 256 : 128;
                                }
                                i20 = i31;
                            }
                            i21 = i3 & 8192;
                            if (i21 != 0) {
                                i22 = i20;
                                if ((i2 & 3072) == 0) {
                                    i22 |= composerStartRestartGroup.changed(keyboardActionHandler) ? 2048 : 1024;
                                }
                                if ((i2 & 24576) == 0) {
                                    if ((i3 & 16384) == 0 && composerStartRestartGroup.changed(textFieldLineLimits)) {
                                        i29 = 16384;
                                    }
                                    i22 |= i29;
                                }
                                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i22 |= ((i3 & 32768) == 0 && composerStartRestartGroup.changed(scrollState)) ? 131072 : 65536;
                                }
                                if ((i2 & 1572864) == 0) {
                                    i22 |= ((i3 & 65536) == 0 && composerStartRestartGroup.changed(shape)) ? 1048576 : 524288;
                                }
                                if ((i2 & 12582912) == 0) {
                                    i22 |= ((i3 & 131072) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 8388608 : 4194304;
                                }
                                i23 = i3 & 262144;
                                if (i23 != 0) {
                                    i22 |= 100663296;
                                } else if ((i2 & 100663296) == 0) {
                                    i22 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i22 & 38347923) == 38347922) ? false : true, i4 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "163@9330L7,174@9893L21,175@9953L22,176@10025L25");
                                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        Modifier.Companion companion = i28 != 0 ? Modifier.INSTANCE : modifier2;
                                        boolean z10 = i5 != 0 ? true : z4;
                                        z8 = i6 != 0 ? false : z2;
                                        if ((i3 & 16) != 0) {
                                            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            textStyle2 = (TextStyle) objConsume;
                                            i4 &= -57345;
                                        }
                                        TextStyle textStyle5 = textStyle2;
                                        int i32 = i4;
                                        Function2<? super Composer, ? super Integer, Unit> function214 = i7 != 0 ? null : function25;
                                        Function2<? super Composer, ? super Integer, Unit> function215 = i8 != 0 ? null : function26;
                                        function212 = i9 != 0 ? null : function27;
                                        function213 = i11 != 0 ? null : function24;
                                        boolean z11 = i13 != 0 ? false : z3;
                                        inputTransformation3 = i15 != 0 ? null : inputTransformation;
                                        outputTransformation3 = i18 != 0 ? null : outputTransformation;
                                        keyboardOptions3 = i19 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        keyboardActionHandler3 = i21 != 0 ? null : keyboardActionHandler;
                                        if ((i3 & 16384) != 0) {
                                            i22 &= -57345;
                                            textFieldLineLimits3 = TextFieldLineLimits.INSTANCE.getDefault();
                                        } else {
                                            textFieldLineLimits3 = textFieldLineLimits;
                                        }
                                        if ((32768 & i3) != 0) {
                                            i22 &= -458753;
                                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                        } else {
                                            scrollStateRememberScrollState = scrollState;
                                        }
                                        if ((i3 & 65536) != 0) {
                                            i22 &= -3670017;
                                            outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                                        } else {
                                            outlinedTextFieldShape = shape;
                                        }
                                        int i33 = i22;
                                        if ((i3 & 131072) != 0) {
                                            textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m3214outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                                            composer3 = composerStartRestartGroup;
                                            i24 = i33 & (-29360129);
                                        } else {
                                            composer3 = composerStartRestartGroup;
                                            textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                            i24 = i33;
                                        }
                                        if (i23 != 0) {
                                            modifier2 = companion;
                                            i25 = i24;
                                            z4 = z10;
                                            textStyle2 = textStyle5;
                                            i26 = i32;
                                            function25 = function214;
                                            function26 = function215;
                                            z9 = z11;
                                            mutableInteractionSource3 = null;
                                        } else {
                                            mutableInteractionSource3 = mutableInteractionSource;
                                            modifier2 = companion;
                                            i25 = i24;
                                            z4 = z10;
                                            textStyle2 = textStyle5;
                                            i26 = i32;
                                            function25 = function214;
                                            function26 = function215;
                                            z9 = z11;
                                        }
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i3 & 16) != 0) {
                                            i4 &= -57345;
                                        }
                                        if ((i3 & 16384) != 0) {
                                            i22 &= -57345;
                                        }
                                        if ((32768 & i3) != 0) {
                                            i22 &= -458753;
                                        }
                                        if ((i3 & 65536) != 0) {
                                            i22 &= -3670017;
                                        }
                                        if ((i3 & 131072) != 0) {
                                            i22 &= -29360129;
                                        }
                                        composer3 = composerStartRestartGroup;
                                        z8 = z2;
                                        function213 = function24;
                                        z9 = z3;
                                        inputTransformation3 = inputTransformation;
                                        outputTransformation3 = outputTransformation;
                                        keyboardOptions3 = keyboardOptions;
                                        keyboardActionHandler3 = keyboardActionHandler;
                                        textFieldLineLimits3 = textFieldLineLimits;
                                        scrollStateRememberScrollState = scrollState;
                                        outlinedTextFieldShape = shape;
                                        textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                        i26 = i4;
                                        function212 = function27;
                                        i25 = i22;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    composer3.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1708163690, i26, i25, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:178)");
                                    }
                                    if (mutableInteractionSource3 == null) {
                                        composer3.startReplaceGroup(1133009585);
                                        ComposerKt.sourceInformation(composer3, "180@10194L39");
                                        ComposerKt.sourceInformationMarkerStart(composer3, 867832689, "CC(remember):OutlinedTextField.kt#9igjgp");
                                        Object objRememberedValue = composer3.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composer3.updateRememberedValue(objRememberedValue);
                                        }
                                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceGroup();
                                    } else {
                                        composer3.startReplaceGroup(867832038);
                                        composer3.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    composer3.startReplaceGroup(867837784);
                                    ComposerKt.sourceInformation(composer3, "*182@10373L18");
                                    long jM8586getColor0d7_KjU = textStyle2.m8586getColor0d7_KjU();
                                    if (jM8586getColor0d7_KjU == 16) {
                                        jM8586getColor0d7_KjU = textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs.textColor(z4, composer3, ((i26 >> 6) & 14) | ((i25 >> 18) & 112)).getValue().m6335unboximpl();
                                    }
                                    composer3.endReplaceGroup();
                                    TextStyle textStyleMerge = textStyle2.merge(new TextStyle(jM8586getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composer3.consume(localDensity);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Density density = (Density) objConsume2;
                                    if (function25 != null) {
                                        composer3.startReplaceGroup(1133480847);
                                        ComposerKt.sourceInformation(composer3, "196@10930L2");
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        textStyle4 = textStyle2;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 867856204, "CC(remember):OutlinedTextField.kt#9igjgp");
                                        Object objRememberedValue2 = composer3.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material.OutlinedTextFieldKt$$ExternalSyntheticLambda6
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    return OutlinedTextFieldKt.OutlinedTextField$lambda$2$0((SemanticsPropertyReceiver) obj);
                                                }
                                            };
                                            composer3.updateRememberedValue(objRememberedValue2);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        companionM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SemanticsModifierKt.semantics(companion2, true, (Function1) objRememberedValue2), 0.0f, density.mo1619toDpGaN1DYA(OutlinedTextFieldTopPadding), 0.0f, 0.0f, 13, null);
                                        composer3.endReplaceGroup();
                                    } else {
                                        textStyle4 = textStyle2;
                                        composer3.startReplaceGroup(1133866208);
                                        composer3.endReplaceGroup();
                                        companionM2041paddingqDBjuR0$default = Modifier.INSTANCE;
                                    }
                                    boolean z12 = z9;
                                    SolidColor solidColor = new SolidColor(textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs.cursorColor(z9, composer3, ((i26 >> 27) & 14) | ((i25 >> 18) & 112)).getValue().m6335unboximpl(), null);
                                    int i34 = i25 << 12;
                                    Composer composer4 = composer3;
                                    MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                    boolean z13 = z4;
                                    boolean z14 = z8;
                                    InputTransformation inputTransformation4 = inputTransformation3;
                                    OutputTransformation outputTransformation4 = outputTransformation3;
                                    KeyboardOptions keyboardOptions4 = keyboardOptions3;
                                    KeyboardActionHandler keyboardActionHandler4 = keyboardActionHandler3;
                                    TextFieldLineLimits textFieldLineLimits4 = textFieldLineLimits3;
                                    ScrollState scrollState3 = scrollStateRememberScrollState;
                                    BasicTextFieldKt.BasicTextField(textFieldState, SizeKt.m2067defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier2.then(companionM2041paddingqDBjuR0$default), z9, Strings_androidKt.m3171getString4foXLRw(Strings.INSTANCE.m3165getDefaultErrorMessageUdPEhr4(), composer3, 6)), TextFieldDefaults.INSTANCE.m3211getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m3210getMinHeightD9Ej5fM()), z13, z14, inputTransformation4, textStyleMerge, keyboardOptions4, keyboardActionHandler4, textFieldLineLimits4, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) null, mutableInteractionSource5, solidColor, outputTransformation4, new AnonymousClass3(outputTransformation3, textFieldState, textFieldLineLimits3, z4, mutableInteractionSource4, z12, function25, function26, function212, function213, outlinedTextFieldShape, textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs), scrollState3, composer4, (i26 & 8078) | (57344 & i34) | (3670016 & i34) | (29360128 & i34) | (i34 & 234881024), ((i25 << 3) & 896) | ((i25 >> 3) & 57344), 512);
                                    composer2 = composer4;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    textFieldColors2 = textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    function28 = function25;
                                    function29 = function26;
                                    modifier3 = modifier2;
                                    z6 = z4;
                                    textStyle3 = textStyle4;
                                    z5 = z8;
                                    function210 = function212;
                                    function211 = function213;
                                    z7 = z12;
                                    inputTransformation2 = inputTransformation3;
                                    outputTransformation2 = outputTransformation3;
                                    keyboardOptions2 = keyboardOptions3;
                                    keyboardActionHandler2 = keyboardActionHandler3;
                                    textFieldLineLimits2 = textFieldLineLimits3;
                                    scrollState2 = scrollStateRememberScrollState;
                                    shape2 = outlinedTextFieldShape;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    z5 = z2;
                                    outputTransformation2 = outputTransformation;
                                    keyboardOptions2 = keyboardOptions;
                                    scrollState2 = scrollState;
                                    shape2 = shape;
                                    textFieldColors2 = textFieldColors;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    textStyle3 = textStyle2;
                                    function28 = function25;
                                    function29 = function26;
                                    modifier3 = modifier2;
                                    function210 = function27;
                                    z6 = z4;
                                    function211 = function24;
                                    z7 = z3;
                                    inputTransformation2 = inputTransformation;
                                    keyboardActionHandler2 = keyboardActionHandler;
                                    textFieldLineLimits2 = textFieldLineLimits;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.OutlinedTextFieldKt$$ExternalSyntheticLambda7
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return OutlinedTextFieldKt.OutlinedTextField$lambda$4(textFieldState, modifier3, z6, z5, textStyle3, function28, function29, function210, function211, z7, inputTransformation2, outputTransformation2, keyboardOptions2, keyboardActionHandler2, textFieldLineLimits2, scrollState2, shape2, textFieldColors2, mutableInteractionSource2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i22 = i20 | 3072;
                            if ((i2 & 24576) == 0) {
                            }
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            }
                            if ((i2 & 1572864) == 0) {
                            }
                            if ((i2 & 12582912) == 0) {
                            }
                            i23 = i3 & 262144;
                            if (i23 != 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i22 & 38347923) == 38347922) ? false : true, i4 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i13 = i12;
                        i14 = i3 & 1024;
                        if (i14 == 0) {
                        }
                        i17 = i3 & 2048;
                        if (i17 == 0) {
                        }
                        int i302 = i16;
                        i19 = i3 & 4096;
                        if (i19 == 0) {
                        }
                        i21 = i3 & 8192;
                        if (i21 != 0) {
                        }
                        if ((i2 & 24576) == 0) {
                        }
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        }
                        if ((i2 & 1572864) == 0) {
                        }
                        if ((i2 & 12582912) == 0) {
                        }
                        i23 = i3 & 262144;
                        if (i23 != 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i22 & 38347923) == 38347922) ? false : true, i4 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i11 = i10;
                    i12 = i3 & 512;
                    if (i12 != 0) {
                    }
                    i13 = i12;
                    i14 = i3 & 1024;
                    if (i14 == 0) {
                    }
                    i17 = i3 & 2048;
                    if (i17 == 0) {
                    }
                    int i3022 = i16;
                    i19 = i3 & 4096;
                    if (i19 == 0) {
                    }
                    i21 = i3 & 8192;
                    if (i21 != 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    if ((i2 & 1572864) == 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i23 = i3 & 262144;
                    if (i23 != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i22 & 38347923) == 38347922) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                int i292 = 8192;
                if ((i & 24576) != 0) {
                }
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                i9 = i3 & 128;
                if (i9 == 0) {
                }
                i10 = i3 & 256;
                if (i10 == 0) {
                }
                i11 = i10;
                i12 = i3 & 512;
                if (i12 != 0) {
                }
                i13 = i12;
                i14 = i3 & 1024;
                if (i14 == 0) {
                }
                i17 = i3 & 2048;
                if (i17 == 0) {
                }
                int i30222 = i16;
                i19 = i3 & 4096;
                if (i19 == 0) {
                }
                i21 = i3 & 8192;
                if (i21 != 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                if ((i2 & 1572864) == 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i23 = i3 & 262144;
                if (i23 != 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i22 & 38347923) == 38347922) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            int i2922 = 8192;
            if ((i & 24576) != 0) {
            }
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            i9 = i3 & 128;
            if (i9 == 0) {
            }
            i10 = i3 & 256;
            if (i10 == 0) {
            }
            i11 = i10;
            i12 = i3 & 512;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i3 & 1024;
            if (i14 == 0) {
            }
            i17 = i3 & 2048;
            if (i17 == 0) {
            }
            int i302222 = i16;
            i19 = i3 & 4096;
            if (i19 == 0) {
            }
            i21 = i3 & 8192;
            if (i21 != 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if ((i2 & 1572864) == 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i23 = i3 & 262144;
            if (i23 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i22 & 38347923) == 38347922) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        z4 = z;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        int i29222 = 8192;
        if ((i & 24576) != 0) {
        }
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        i9 = i3 & 128;
        if (i9 == 0) {
        }
        i10 = i3 & 256;
        if (i10 == 0) {
        }
        i11 = i10;
        i12 = i3 & 512;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i3 & 1024;
        if (i14 == 0) {
        }
        i17 = i3 & 2048;
        if (i17 == 0) {
        }
        int i3022222 = i16;
        i19 = i3 & 4096;
        if (i19 == 0) {
        }
        i21 = i3 & 8192;
        if (i21 != 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if ((i2 & 1572864) == 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i23 = i3 & 262144;
        if (i23 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i22 & 38347923) == 38347922) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x06f2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:331:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedTextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        int i8;
        boolean z5;
        TextStyle textStyle2;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function26;
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
        Composer composer2;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final VisualTransformation visualTransformation2;
        final KeyboardActions keyboardActions2;
        final int i27;
        final int i28;
        final MutableInteractionSource mutableInteractionSource2;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final boolean z7;
        final TextStyle textStyle3;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final boolean z8;
        final KeyboardOptions keyboardOptions2;
        final boolean z9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        TextStyle textStyle4;
        Function2<? super Composer, ? super Integer, Unit> function211;
        Function2<? super Composer, ? super Integer, Unit> function212;
        Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        int i29;
        KeyboardActions keyboardActions3;
        int i30;
        MutableInteractionSource mutableInteractionSource3;
        Shape outlinedTextFieldShape;
        Composer composer3;
        TextFieldColors textFieldColors3;
        KeyboardActions keyboardActions4;
        boolean z10;
        TextStyle textStyle5;
        int i31;
        boolean z11;
        VisualTransformation visualTransformation3;
        KeyboardOptions keyboardOptions3;
        boolean z12;
        int i32;
        int i33;
        int i34;
        boolean z13;
        MutableInteractionSource mutableInteractionSource4;
        int i35;
        Modifier.Companion companionM2041paddingqDBjuR0$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(-365650761);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,label,placeholder,leadingIcon,trailingIcon,isError,visualTransformation,keyboardOptions,keyboardActions,singleLine,maxLines,minLines,interactionSource,shape,colors)553@29149L7,570@29825L38,579@30209L20,588@30563L1032,555@29162L2440:OutlinedTextField.kt#jmzs0o");
        if ((i3 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(textFieldValue) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i36 = i5 & 4;
        if (i36 != 0) {
            i6 |= 384;
        } else {
            if ((i3 & 384) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i7 = i5 & 8;
            if (i7 == 0) {
                i6 |= 3072;
            } else {
                if ((i3 & 3072) == 0) {
                    i6 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
                }
                i8 = i5 & 16;
                if (i8 != 0) {
                    i6 |= 24576;
                } else {
                    if ((i3 & 24576) == 0) {
                        z5 = z2;
                        i6 |= composerStartRestartGroup.changed(z5) ? 16384 : 8192;
                    }
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        textStyle2 = textStyle;
                        i6 |= ((i5 & 32) == 0 && composerStartRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i9 = i5 & 64;
                    if (i9 == 0) {
                        i6 |= 1572864;
                        function25 = function2;
                    } else {
                        function25 = function2;
                        if ((i3 & 1572864) == 0) {
                            i6 |= composerStartRestartGroup.changedInstance(function25) ? 1048576 : 524288;
                        }
                    }
                    i10 = i5 & 128;
                    if (i10 == 0) {
                        i6 |= 12582912;
                        function26 = function22;
                    } else {
                        function26 = function22;
                        if ((i3 & 12582912) == 0) {
                            i6 |= composerStartRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
                        }
                    }
                    i11 = i5 & 256;
                    if (i11 == 0) {
                        i6 |= 100663296;
                    } else {
                        if ((i3 & 100663296) == 0) {
                            i12 = i11;
                            i6 |= composerStartRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        }
                        i13 = i5 & 512;
                        if (i13 != 0) {
                            i6 |= 805306368;
                        } else {
                            if ((i3 & 805306368) == 0) {
                                i14 = i13;
                                i6 |= composerStartRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            }
                            i15 = i5 & 1024;
                            if (i15 == 0) {
                                i17 = i4 | 6;
                                i16 = i15;
                            } else if ((i4 & 6) == 0) {
                                i16 = i15;
                                i17 = i4 | (composerStartRestartGroup.changed(z3) ? 4 : 2);
                            } else {
                                i16 = i15;
                                i17 = i4;
                            }
                            i18 = i5 & 2048;
                            if (i18 == 0) {
                                i17 |= 48;
                                i19 = i18;
                            } else if ((i4 & 48) == 0) {
                                i19 = i18;
                                i17 |= composerStartRestartGroup.changed(visualTransformation) ? 32 : 16;
                            } else {
                                i19 = i18;
                            }
                            int i37 = i17;
                            i20 = i5 & 4096;
                            if (i20 != 0) {
                                i21 = i37;
                                if ((i4 & 384) == 0) {
                                    i21 |= composerStartRestartGroup.changed(keyboardOptions) ? 256 : 128;
                                }
                                if ((i4 & 3072) == 0) {
                                    i21 |= ((i5 & 8192) == 0 && composerStartRestartGroup.changed(keyboardActions)) ? 2048 : 1024;
                                }
                                int i38 = i21;
                                i22 = i5 & 16384;
                                if (i22 != 0) {
                                    i23 = i38 | 24576;
                                } else if ((i4 & 24576) == 0) {
                                    i23 = i38 | (composerStartRestartGroup.changed(z4) ? 16384 : 8192);
                                } else {
                                    i23 = i38;
                                }
                                if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i23 |= ((i5 & 32768) == 0 && composerStartRestartGroup.changed(i)) ? 131072 : 65536;
                                }
                                i24 = i5 & 65536;
                                if (i24 != 0) {
                                    i23 |= 1572864;
                                } else if ((i4 & 1572864) == 0) {
                                    i23 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                                }
                                i25 = i5 & 131072;
                                if (i25 != 0) {
                                    i23 |= 12582912;
                                } else if ((i4 & 12582912) == 0) {
                                    i23 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                                }
                                if ((i4 & 100663296) == 0) {
                                    i23 |= ((i5 & 262144) == 0 && composerStartRestartGroup.changed(shape)) ? 67108864 : 33554432;
                                }
                                if ((i4 & 805306368) == 0) {
                                    i23 |= ((i5 & 524288) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 536870912 : 268435456;
                                }
                                i26 = i23;
                                if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (306783379 & i26) == 306783378) ? false : true, i6 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "531@28011L7,544@28655L22,545@28727L25");
                                    if ((i3 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        companion = i36 != 0 ? Modifier.INSTANCE : modifier2;
                                        boolean z14 = i7 != 0 ? true : z;
                                        boolean z15 = i8 != 0 ? false : z5;
                                        if ((i5 & 32) != 0) {
                                            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            i6 &= -458753;
                                            textStyle4 = (TextStyle) objConsume;
                                        } else {
                                            textStyle4 = textStyle2;
                                        }
                                        int i39 = i6;
                                        function211 = i9 != 0 ? null : function25;
                                        function212 = i10 != 0 ? null : function26;
                                        function213 = i12 != 0 ? null : function23;
                                        function214 = i14 != 0 ? null : function24;
                                        boolean z16 = i16 != 0 ? false : z3;
                                        VisualTransformation none = i19 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                        KeyboardOptions keyboardOptions4 = i20 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        if ((i5 & 8192) != 0) {
                                            i29 = i26 & (-7169);
                                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                        } else {
                                            i29 = i26;
                                            keyboardActions3 = keyboardActions;
                                        }
                                        boolean z17 = i22 != 0 ? false : z4;
                                        if ((32768 & i5) != 0) {
                                            i29 &= -458753;
                                            i30 = z17 ? 1 : Integer.MAX_VALUE;
                                        } else {
                                            i30 = i;
                                        }
                                        int i40 = i24 != 0 ? 1 : i2;
                                        mutableInteractionSource3 = i25 != 0 ? null : mutableInteractionSource;
                                        if ((262144 & i5) != 0) {
                                            i29 &= -234881025;
                                            outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                                        } else {
                                            outlinedTextFieldShape = shape;
                                        }
                                        int i41 = i29;
                                        if ((i5 & 524288) != 0) {
                                            TextFieldColors textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m3214outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                                            composer3 = composerStartRestartGroup;
                                            keyboardActions4 = keyboardActions3;
                                            i34 = i41 & (-1879048193);
                                            z10 = z14;
                                            z5 = z15;
                                            textStyle5 = textStyle4;
                                            i31 = i39;
                                            visualTransformation3 = none;
                                            keyboardOptions3 = keyboardOptions4;
                                            z12 = z17;
                                            i32 = i30;
                                            i33 = i40;
                                            textFieldColors3 = textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
                                            z11 = z16;
                                        } else {
                                            composer3 = composerStartRestartGroup;
                                            textFieldColors3 = textFieldColors;
                                            keyboardActions4 = keyboardActions3;
                                            z10 = z14;
                                            z5 = z15;
                                            textStyle5 = textStyle4;
                                            i31 = i39;
                                            z11 = z16;
                                            visualTransformation3 = none;
                                            keyboardOptions3 = keyboardOptions4;
                                            z12 = z17;
                                            i32 = i30;
                                            i33 = i40;
                                            i34 = i41;
                                        }
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i5 & 32) != 0) {
                                            i6 &= -458753;
                                        }
                                        if ((i5 & 8192) != 0) {
                                            i26 &= -7169;
                                        }
                                        if ((32768 & i5) != 0) {
                                            i26 &= -458753;
                                        }
                                        if ((262144 & i5) != 0) {
                                            i26 &= -234881025;
                                        }
                                        if ((i5 & 524288) != 0) {
                                            i26 &= -1879048193;
                                        }
                                        TextStyle textStyle6 = textStyle2;
                                        i34 = i26;
                                        textStyle5 = textStyle6;
                                        z10 = z;
                                        function213 = function23;
                                        function214 = function24;
                                        z11 = z3;
                                        keyboardOptions3 = keyboardOptions;
                                        z12 = z4;
                                        i33 = i2;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        outlinedTextFieldShape = shape;
                                        composer3 = composerStartRestartGroup;
                                        i31 = i6;
                                        function211 = function25;
                                        companion = modifier2;
                                        function212 = function26;
                                        visualTransformation3 = visualTransformation;
                                        keyboardActions4 = keyboardActions;
                                        i32 = i;
                                        textFieldColors3 = textFieldColors;
                                    }
                                    composer3.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        z13 = z5;
                                        ComposerKt.traceEventStart(-365650761, i31, i34, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:546)");
                                    } else {
                                        z13 = z5;
                                    }
                                    if (mutableInteractionSource3 == null) {
                                        composer3.startReplaceGroup(-1063705564);
                                        ComposerKt.sourceInformation(composer3, "548@28839L39");
                                        ComposerKt.sourceInformationMarkerStart(composer3, 796970910, "CC(remember):OutlinedTextField.kt#9igjgp");
                                        Object objRememberedValue = composer3.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composer3.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceGroup();
                                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        composer3.startReplaceGroup(796970259);
                                        composer3.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    composer3.startReplaceGroup(796976005);
                                    ComposerKt.sourceInformation(composer3, "*550@29018L18");
                                    long jM8586getColor0d7_KjU = textStyle5.m8586getColor0d7_KjU();
                                    if (jM8586getColor0d7_KjU == 16) {
                                        jM8586getColor0d7_KjU = textFieldColors3.textColor(z10, composer3, ((i31 >> 9) & 14) | ((i34 >> 24) & 112)).getValue().m6335unboximpl();
                                    }
                                    composer3.endReplaceGroup();
                                    TextStyle textStyleMerge = textStyle5.merge(new TextStyle(jM8586getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                    TextStyle textStyle7 = textStyle5;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composer3.consume(localDensity);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Density density = (Density) objConsume2;
                                    if (function211 != null) {
                                        composer3.startReplaceGroup(-1063234302);
                                        ComposerKt.sourceInformation(composer3, "564@29575L2");
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        i35 = i31;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 796994425, "CC(remember):OutlinedTextField.kt#9igjgp");
                                        Object objRememberedValue2 = composer3.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material.OutlinedTextFieldKt$$ExternalSyntheticLambda2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    return OutlinedTextFieldKt.OutlinedTextField$lambda$15$0((SemanticsPropertyReceiver) obj);
                                                }
                                            };
                                            composer3.updateRememberedValue(objRememberedValue2);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        companionM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SemanticsModifierKt.semantics(companion2, true, (Function1) objRememberedValue2), 0.0f, density.mo1619toDpGaN1DYA(OutlinedTextFieldTopPadding), 0.0f, 0.0f, 13, null);
                                        composer3.endReplaceGroup();
                                    } else {
                                        i35 = i31;
                                        composer3.startReplaceGroup(-1062848941);
                                        composer3.endReplaceGroup();
                                        companionM2041paddingqDBjuR0$default = Modifier.INSTANCE;
                                    }
                                    Modifier modifier4 = companion;
                                    final boolean z18 = z11;
                                    final TextFieldColors textFieldColors4 = textFieldColors3;
                                    final boolean z19 = z10;
                                    final boolean z20 = z12;
                                    final VisualTransformation visualTransformation4 = visualTransformation3;
                                    final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                    final Function2<? super Composer, ? super Integer, Unit> function215 = function211;
                                    final Function2<? super Composer, ? super Integer, Unit> function216 = function212;
                                    final Function2<? super Composer, ? super Integer, Unit> function217 = function213;
                                    final Function2<? super Composer, ? super Integer, Unit> function218 = function214;
                                    final Shape shape3 = outlinedTextFieldShape;
                                    int i42 = i34 << 12;
                                    boolean z21 = z13;
                                    Composer composer4 = composer3;
                                    BasicTextFieldKt.BasicTextField(textFieldValue, function1, SizeKt.m2067defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(companion.then(companionM2041paddingqDBjuR0$default), z11, Strings_androidKt.m3171getString4foXLRw(Strings.INSTANCE.m3165getDefaultErrorMessageUdPEhr4(), composer3, 6)), TextFieldDefaults.INSTANCE.m3211getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m3210getMinHeightD9Ej5fM()), z10, z21, textStyleMerge, keyboardOptions3, keyboardActions4, z12, i32, i33, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource4, new SolidColor(textFieldColors3.cursorColor(z11, composer3, (i34 & 14) | ((i34 >> 24) & 112)).getValue().m6335unboximpl(), null), ComposableLambdaKt.rememberComposableLambda(-1881867558, true, new Function3() { // from class: androidx.compose.material.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                                            return OutlinedTextFieldKt.OutlinedTextField$lambda$17(textFieldValue, z19, z20, visualTransformation4, mutableInteractionSource5, z18, function215, function216, function217, function218, shape3, textFieldColors4, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                        }
                                    }, composer3, 54), composer4, (i35 & 64638) | (3670016 & i42) | (29360128 & i42) | (234881024 & i42) | (i42 & 1879048192), ((i34 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i34 & 112), 4096);
                                    composer2 = composer4;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    VisualTransformation visualTransformation5 = visualTransformation3;
                                    z9 = z12;
                                    visualTransformation2 = visualTransformation5;
                                    textStyle3 = textStyle7;
                                    textFieldColors2 = textFieldColors4;
                                    z6 = z10;
                                    z7 = z21;
                                    i27 = i32;
                                    i28 = i33;
                                    modifier3 = modifier4;
                                    function28 = function211;
                                    function29 = function212;
                                    function210 = function213;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    shape2 = outlinedTextFieldShape;
                                    keyboardOptions2 = keyboardOptions3;
                                    keyboardActions2 = keyboardActions4;
                                    function27 = function214;
                                    z8 = z18;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    z6 = z;
                                    function27 = function24;
                                    visualTransformation2 = visualTransformation;
                                    keyboardActions2 = keyboardActions;
                                    i27 = i;
                                    i28 = i2;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    shape2 = shape;
                                    textFieldColors2 = textFieldColors;
                                    z7 = z5;
                                    textStyle3 = textStyle2;
                                    function28 = function25;
                                    modifier3 = modifier2;
                                    function29 = function26;
                                    function210 = function23;
                                    z8 = z3;
                                    keyboardOptions2 = keyboardOptions;
                                    z9 = z4;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.OutlinedTextFieldKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return OutlinedTextFieldKt.OutlinedTextField$lambda$18(textFieldValue, function1, modifier3, z6, z7, textStyle3, function28, function29, function210, function27, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i27, i28, mutableInteractionSource2, shape2, textFieldColors2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i21 = i37 | 384;
                            if ((i4 & 3072) == 0) {
                            }
                            int i382 = i21;
                            i22 = i5 & 16384;
                            if (i22 != 0) {
                            }
                            if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            }
                            i24 = i5 & 65536;
                            if (i24 != 0) {
                            }
                            i25 = i5 & 131072;
                            if (i25 != 0) {
                            }
                            if ((i4 & 100663296) == 0) {
                            }
                            if ((i4 & 805306368) == 0) {
                            }
                            i26 = i23;
                            if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (306783379 & i26) == 306783378) ? false : true, i6 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i14 = i13;
                        i15 = i5 & 1024;
                        if (i15 == 0) {
                        }
                        i18 = i5 & 2048;
                        if (i18 == 0) {
                        }
                        int i372 = i17;
                        i20 = i5 & 4096;
                        if (i20 != 0) {
                        }
                        if ((i4 & 3072) == 0) {
                        }
                        int i3822 = i21;
                        i22 = i5 & 16384;
                        if (i22 != 0) {
                        }
                        if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        }
                        i24 = i5 & 65536;
                        if (i24 != 0) {
                        }
                        i25 = i5 & 131072;
                        if (i25 != 0) {
                        }
                        if ((i4 & 100663296) == 0) {
                        }
                        if ((i4 & 805306368) == 0) {
                        }
                        i26 = i23;
                        if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (306783379 & i26) == 306783378) ? false : true, i6 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i12 = i11;
                    i13 = i5 & 512;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    i15 = i5 & 1024;
                    if (i15 == 0) {
                    }
                    i18 = i5 & 2048;
                    if (i18 == 0) {
                    }
                    int i3722 = i17;
                    i20 = i5 & 4096;
                    if (i20 != 0) {
                    }
                    if ((i4 & 3072) == 0) {
                    }
                    int i38222 = i21;
                    i22 = i5 & 16384;
                    if (i22 != 0) {
                    }
                    if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    i24 = i5 & 65536;
                    if (i24 != 0) {
                    }
                    i25 = i5 & 131072;
                    if (i25 != 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    if ((i4 & 805306368) == 0) {
                    }
                    i26 = i23;
                    if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (306783379 & i26) == 306783378) ? false : true, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z5 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                i9 = i5 & 64;
                if (i9 == 0) {
                }
                i10 = i5 & 128;
                if (i10 == 0) {
                }
                i11 = i5 & 256;
                if (i11 == 0) {
                }
                i12 = i11;
                i13 = i5 & 512;
                if (i13 != 0) {
                }
                i14 = i13;
                i15 = i5 & 1024;
                if (i15 == 0) {
                }
                i18 = i5 & 2048;
                if (i18 == 0) {
                }
                int i37222 = i17;
                i20 = i5 & 4096;
                if (i20 != 0) {
                }
                if ((i4 & 3072) == 0) {
                }
                int i382222 = i21;
                i22 = i5 & 16384;
                if (i22 != 0) {
                }
                if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i24 = i5 & 65536;
                if (i24 != 0) {
                }
                i25 = i5 & 131072;
                if (i25 != 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                if ((i4 & 805306368) == 0) {
                }
                i26 = i23;
                if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (306783379 & i26) == 306783378) ? false : true, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i8 = i5 & 16;
            if (i8 != 0) {
            }
            z5 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            i9 = i5 & 64;
            if (i9 == 0) {
            }
            i10 = i5 & 128;
            if (i10 == 0) {
            }
            i11 = i5 & 256;
            if (i11 == 0) {
            }
            i12 = i11;
            i13 = i5 & 512;
            if (i13 != 0) {
            }
            i14 = i13;
            i15 = i5 & 1024;
            if (i15 == 0) {
            }
            i18 = i5 & 2048;
            if (i18 == 0) {
            }
            int i372222 = i17;
            i20 = i5 & 4096;
            if (i20 != 0) {
            }
            if ((i4 & 3072) == 0) {
            }
            int i3822222 = i21;
            i22 = i5 & 16384;
            if (i22 != 0) {
            }
            if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i24 = i5 & 65536;
            if (i24 != 0) {
            }
            i25 = i5 & 131072;
            if (i25 != 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            if ((i4 & 805306368) == 0) {
            }
            i26 = i23;
            if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (306783379 & i26) == 306783378) ? false : true, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 8;
        if (i7 == 0) {
        }
        i8 = i5 & 16;
        if (i8 != 0) {
        }
        z5 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i9 = i5 & 64;
        if (i9 == 0) {
        }
        i10 = i5 & 128;
        if (i10 == 0) {
        }
        i11 = i5 & 256;
        if (i11 == 0) {
        }
        i12 = i11;
        i13 = i5 & 512;
        if (i13 != 0) {
        }
        i14 = i13;
        i15 = i5 & 1024;
        if (i15 == 0) {
        }
        i18 = i5 & 2048;
        if (i18 == 0) {
        }
        int i3722222 = i17;
        i20 = i5 & 4096;
        if (i20 != 0) {
        }
        if ((i4 & 3072) == 0) {
        }
        int i38222222 = i21;
        i22 = i5 & 16384;
        if (i22 != 0) {
        }
        if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i24 = i5 & 65536;
        if (i24 != 0) {
        }
        i25 = i5 & 131072;
        if (i25 != 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        if ((i4 & 805306368) == 0) {
        }
        i26 = i23;
        if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (306783379 & i26) == 306783378) ? false : true, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:296:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0121  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void OutlinedTextField(final TextFieldValue textFieldValue, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        boolean z5;
        int i7;
        boolean z6;
        TextStyle textStyle2;
        int i8;
        Function2 function25;
        int i9;
        Function2 function26;
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
        Composer composer2;
        final Function2 function27;
        final VisualTransformation visualTransformation2;
        final KeyboardActions keyboardActions2;
        final int i26;
        final MutableInteractionSource mutableInteractionSource2;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final boolean z7;
        final boolean z8;
        final TextStyle textStyle3;
        final Function2 function28;
        final Modifier modifier3;
        final Function2 function29;
        final Function2 function210;
        final boolean z9;
        final KeyboardOptions keyboardOptions2;
        final boolean z10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        TextStyle textStyle4;
        int i27;
        KeyboardActions keyboardActions3;
        MutableInteractionSource mutableInteractionSource3;
        Shape outlinedTextFieldShape;
        TextFieldColors textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
        KeyboardActions keyboardActions4;
        Modifier modifier4;
        boolean z11;
        int i28;
        Function2 function211;
        Function2 function212;
        Function2 function213;
        Function2 function214;
        boolean z12;
        VisualTransformation visualTransformation3;
        KeyboardOptions keyboardOptions3;
        boolean z13;
        int i29;
        MutableInteractionSource mutableInteractionSource4;
        Shape shape3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1710103060);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,label,placeholder,leadingIcon,trailingIcon,isError,visualTransformation,keyboardOptions,keyboardActions,singleLine,maxLines,interactionSource,shape,colors)643@32719L417:OutlinedTextField.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(textFieldValue) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i30 = i4 & 4;
        if (i30 != 0) {
            i5 |= 384;
        } else {
            if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    z5 = z;
                    i5 |= composerStartRestartGroup.changed(z5) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((i2 & 24576) == 0) {
                        z6 = z2;
                        i5 |= composerStartRestartGroup.changed(z6) ? 16384 : 8192;
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        textStyle2 = textStyle;
                        i5 |= ((i4 & 32) == 0 && composerStartRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i8 = i4 & 64;
                    if (i8 == 0) {
                        i5 |= 1572864;
                        function25 = function2;
                    } else {
                        function25 = function2;
                        if ((i2 & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function25) ? 1048576 : 524288;
                        }
                    }
                    i9 = i4 & 128;
                    if (i9 == 0) {
                        i5 |= 12582912;
                        function26 = function22;
                    } else {
                        function26 = function22;
                        if ((i2 & 12582912) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
                        }
                    }
                    i10 = i4 & 256;
                    if (i10 == 0) {
                        i5 |= 100663296;
                    } else {
                        if ((i2 & 100663296) == 0) {
                            i11 = i10;
                            i5 |= composerStartRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        }
                        i12 = i4 & 512;
                        if (i12 != 0) {
                            i5 |= 805306368;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i13 = i12;
                                i5 |= composerStartRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            }
                            i14 = i4 & 1024;
                            if (i14 == 0) {
                                i16 = i3 | 6;
                                i15 = i14;
                            } else if ((i3 & 6) == 0) {
                                i15 = i14;
                                i16 = i3 | (composerStartRestartGroup.changed(z3) ? 4 : 2);
                            } else {
                                i15 = i14;
                                i16 = i3;
                            }
                            i17 = i4 & 2048;
                            if (i17 == 0) {
                                i16 |= 48;
                                i18 = i17;
                            } else if ((i3 & 48) == 0) {
                                i18 = i17;
                                i16 |= composerStartRestartGroup.changed(visualTransformation) ? 32 : 16;
                            } else {
                                i18 = i17;
                            }
                            int i31 = i16;
                            i19 = i4 & 4096;
                            if (i19 != 0) {
                                i20 = i31;
                                if ((i3 & 384) == 0) {
                                    i20 |= composerStartRestartGroup.changed(keyboardOptions) ? 256 : 128;
                                }
                                if ((i3 & 3072) == 0) {
                                    i20 |= ((i4 & 8192) == 0 && composerStartRestartGroup.changed(keyboardActions)) ? 2048 : 1024;
                                }
                                int i32 = i20;
                                i21 = i4 & 16384;
                                if (i21 != 0) {
                                    i22 = i32 | 24576;
                                } else if ((i3 & 24576) == 0) {
                                    i22 = i32 | (composerStartRestartGroup.changed(z4) ? 16384 : 8192);
                                } else {
                                    i22 = i32;
                                }
                                i23 = i4 & 32768;
                                if (i23 != 0) {
                                    i22 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i22 |= composerStartRestartGroup.changed(i) ? 131072 : 65536;
                                }
                                i24 = i4 & 65536;
                                if (i24 != 0) {
                                    i22 |= 1572864;
                                } else if ((i3 & 1572864) == 0) {
                                    i22 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
                                }
                                if ((i3 & 12582912) == 0) {
                                    i22 |= ((i4 & 131072) == 0 && composerStartRestartGroup.changed(shape)) ? 8388608 : 4194304;
                                }
                                if ((i3 & 100663296) == 0) {
                                    i22 |= ((i4 & 262144) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 67108864 : 33554432;
                                }
                                i25 = i22;
                                if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (38347923 & i25) == 38347922) ? false : true, i5 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "628@31980L7,639@32534L39,640@32612L22,641@32684L25");
                                    if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        Modifier.Companion companion = i30 != 0 ? Modifier.INSTANCE : modifier2;
                                        boolean z14 = i6 != 0 ? true : z5;
                                        boolean z15 = i7 != 0 ? false : z6;
                                        if ((i4 & 32) != 0) {
                                            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            i5 &= -458753;
                                            textStyle4 = (TextStyle) objConsume;
                                        } else {
                                            textStyle4 = textStyle2;
                                        }
                                        int i33 = i5;
                                        Function2 function215 = i8 != 0 ? null : function25;
                                        Function2 function216 = i9 != 0 ? null : function26;
                                        Function2 function217 = i11 != 0 ? null : function23;
                                        Function2 function218 = i13 != 0 ? null : function24;
                                        boolean z16 = i15 != 0 ? false : z3;
                                        VisualTransformation none = i18 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                        KeyboardOptions keyboardOptions4 = i19 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        if ((i4 & 8192) != 0) {
                                            i27 = i25 & (-7169);
                                            keyboardActions3 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                                        } else {
                                            i27 = i25;
                                            keyboardActions3 = keyboardActions;
                                        }
                                        boolean z17 = i21 != 0 ? false : z4;
                                        int i34 = i23 != 0 ? Integer.MAX_VALUE : i;
                                        if (i24 != 0) {
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1563408517, "CC(remember):OutlinedTextField.kt#9igjgp");
                                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                        } else {
                                            mutableInteractionSource3 = mutableInteractionSource;
                                        }
                                        if ((i4 & 131072) != 0) {
                                            i27 &= -29360129;
                                            outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                                        } else {
                                            outlinedTextFieldShape = shape;
                                        }
                                        int i35 = i27;
                                        if ((262144 & i4) != 0) {
                                            composer2 = composerStartRestartGroup;
                                            keyboardActions4 = keyboardActions3;
                                            modifier4 = companion;
                                            textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m3214outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 0, 48, 2097151);
                                            i25 = i35 & (-234881025);
                                            z11 = z14;
                                            z6 = z15;
                                            textStyle2 = textStyle4;
                                            i28 = i33;
                                            function211 = function215;
                                            function212 = function216;
                                            function213 = function217;
                                            function214 = function218;
                                            z12 = z16;
                                            visualTransformation3 = none;
                                            keyboardOptions3 = keyboardOptions4;
                                            z13 = z17;
                                            i29 = i34;
                                            mutableInteractionSource4 = mutableInteractionSource3;
                                            shape3 = outlinedTextFieldShape;
                                        } else {
                                            composer2 = composerStartRestartGroup;
                                            textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                            keyboardActions4 = keyboardActions3;
                                            modifier4 = companion;
                                            z11 = z14;
                                            z6 = z15;
                                            textStyle2 = textStyle4;
                                            i28 = i33;
                                            function211 = function215;
                                            function212 = function216;
                                            function213 = function217;
                                            function214 = function218;
                                            z12 = z16;
                                            visualTransformation3 = none;
                                            keyboardOptions3 = keyboardOptions4;
                                            z13 = z17;
                                            i29 = i34;
                                            mutableInteractionSource4 = mutableInteractionSource3;
                                            shape3 = outlinedTextFieldShape;
                                            i25 = i35;
                                        }
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i4 & 32) != 0) {
                                            i5 &= -458753;
                                        }
                                        if ((i4 & 8192) != 0) {
                                            i25 &= -7169;
                                        }
                                        if ((i4 & 131072) != 0) {
                                            i25 &= -29360129;
                                        }
                                        if ((262144 & i4) != 0) {
                                            i25 &= -234881025;
                                        }
                                        function213 = function23;
                                        z12 = z3;
                                        keyboardOptions3 = keyboardOptions;
                                        keyboardActions4 = keyboardActions;
                                        z13 = z4;
                                        i29 = i;
                                        mutableInteractionSource4 = mutableInteractionSource;
                                        shape3 = shape;
                                        textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                        composer2 = composerStartRestartGroup;
                                        z11 = z5;
                                        i28 = i5;
                                        function211 = function25;
                                        modifier4 = modifier2;
                                        function212 = function26;
                                        function214 = function24;
                                        visualTransformation3 = visualTransformation;
                                    }
                                    composer2.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1710103060, i28, i25, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:642)");
                                    }
                                    int i36 = i28 & 2147483646;
                                    int i37 = (i25 & 14) | 1572864 | (i25 & 112) | (i25 & 896) | (i25 & 7168) | (57344 & i25) | (458752 & i25);
                                    int i38 = i25 << 3;
                                    OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier4, z11, z6, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function211, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function213, (Function2<? super Composer, ? super Integer, Unit>) function214, z12, visualTransformation3, keyboardOptions3, keyboardActions4, z13, i29, 1, mutableInteractionSource4, shape3, textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs, composer2, i36, i37 | (29360128 & i38) | (234881024 & i38) | (i38 & 1879048192), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    z7 = z11;
                                    z8 = z6;
                                    textStyle3 = textStyle2;
                                    function28 = function211;
                                    function29 = function212;
                                    function210 = function213;
                                    function27 = function214;
                                    z9 = z12;
                                    visualTransformation2 = visualTransformation3;
                                    keyboardOptions2 = keyboardOptions3;
                                    keyboardActions2 = keyboardActions4;
                                    z10 = z13;
                                    i26 = i29;
                                    mutableInteractionSource2 = mutableInteractionSource4;
                                    shape2 = shape3;
                                    textFieldColors2 = textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    function27 = function24;
                                    visualTransformation2 = visualTransformation;
                                    keyboardActions2 = keyboardActions;
                                    i26 = i;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    shape2 = shape;
                                    textFieldColors2 = textFieldColors;
                                    z7 = z5;
                                    z8 = z6;
                                    textStyle3 = textStyle2;
                                    function28 = function25;
                                    modifier3 = modifier2;
                                    function29 = function26;
                                    function210 = function23;
                                    z9 = z3;
                                    keyboardOptions2 = keyboardOptions;
                                    z10 = z4;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.OutlinedTextFieldKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return OutlinedTextFieldKt.OutlinedTextField$lambda$20(textFieldValue, function1, modifier3, z7, z8, textStyle3, function28, function29, function210, function27, z9, visualTransformation2, keyboardOptions2, keyboardActions2, z10, i26, mutableInteractionSource2, shape2, textFieldColors2, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i20 = i31 | 384;
                            if ((i3 & 3072) == 0) {
                            }
                            int i322 = i20;
                            i21 = i4 & 16384;
                            if (i21 != 0) {
                            }
                            i23 = i4 & 32768;
                            if (i23 != 0) {
                            }
                            i24 = i4 & 65536;
                            if (i24 != 0) {
                            }
                            if ((i3 & 12582912) == 0) {
                            }
                            if ((i3 & 100663296) == 0) {
                            }
                            i25 = i22;
                            if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (38347923 & i25) == 38347922) ? false : true, i5 & 1)) {
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
                        int i312 = i16;
                        i19 = i4 & 4096;
                        if (i19 != 0) {
                        }
                        if ((i3 & 3072) == 0) {
                        }
                        int i3222 = i20;
                        i21 = i4 & 16384;
                        if (i21 != 0) {
                        }
                        i23 = i4 & 32768;
                        if (i23 != 0) {
                        }
                        i24 = i4 & 65536;
                        if (i24 != 0) {
                        }
                        if ((i3 & 12582912) == 0) {
                        }
                        if ((i3 & 100663296) == 0) {
                        }
                        i25 = i22;
                        if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (38347923 & i25) == 38347922) ? false : true, i5 & 1)) {
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
                    int i3122 = i16;
                    i19 = i4 & 4096;
                    if (i19 != 0) {
                    }
                    if ((i3 & 3072) == 0) {
                    }
                    int i32222 = i20;
                    i21 = i4 & 16384;
                    if (i21 != 0) {
                    }
                    i23 = i4 & 32768;
                    if (i23 != 0) {
                    }
                    i24 = i4 & 65536;
                    if (i24 != 0) {
                    }
                    if ((i3 & 12582912) == 0) {
                    }
                    if ((i3 & 100663296) == 0) {
                    }
                    i25 = i22;
                    if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (38347923 & i25) == 38347922) ? false : true, i5 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z6 = z2;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
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
                int i31222 = i16;
                i19 = i4 & 4096;
                if (i19 != 0) {
                }
                if ((i3 & 3072) == 0) {
                }
                int i322222 = i20;
                i21 = i4 & 16384;
                if (i21 != 0) {
                }
                i23 = i4 & 32768;
                if (i23 != 0) {
                }
                i24 = i4 & 65536;
                if (i24 != 0) {
                }
                if ((i3 & 12582912) == 0) {
                }
                if ((i3 & 100663296) == 0) {
                }
                i25 = i22;
                if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (38347923 & i25) == 38347922) ? false : true, i5 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z5 = z;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            z6 = z2;
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
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
            int i312222 = i16;
            i19 = i4 & 4096;
            if (i19 != 0) {
            }
            if ((i3 & 3072) == 0) {
            }
            int i3222222 = i20;
            i21 = i4 & 16384;
            if (i21 != 0) {
            }
            i23 = i4 & 32768;
            if (i23 != 0) {
            }
            i24 = i4 & 65536;
            if (i24 != 0) {
            }
            if ((i3 & 12582912) == 0) {
            }
            if ((i3 & 100663296) == 0) {
            }
            i25 = i22;
            if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (38347923 & i25) == 38347922) ? false : true, i5 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z5 = z;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        z6 = z2;
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
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
        int i3122222 = i16;
        i19 = i4 & 4096;
        if (i19 != 0) {
        }
        if ((i3 & 3072) == 0) {
        }
        int i32222222 = i20;
        i21 = i4 & 16384;
        if (i21 != 0) {
        }
        i23 = i4 & 32768;
        if (i23 != 0) {
        }
        i24 = i4 & 65536;
        if (i24 != 0) {
        }
        if ((i3 & 12582912) == 0) {
        }
        if ((i3 & 100663296) == 0) {
        }
        i25 = i22;
        if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (38347923 & i25) == 38347922) ? false : true, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x069e  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:328:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedTextField(final String str, final Function1<? super String, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        int i8;
        boolean z5;
        TextStyle textStyle2;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function26;
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
        Composer composer2;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final VisualTransformation visualTransformation2;
        final KeyboardActions keyboardActions2;
        final int i28;
        final int i29;
        final MutableInteractionSource mutableInteractionSource2;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final boolean z7;
        final TextStyle textStyle3;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final boolean z8;
        final KeyboardOptions keyboardOptions2;
        final boolean z9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        TextStyle textStyle4;
        Function2<? super Composer, ? super Integer, Unit> function211;
        Function2<? super Composer, ? super Integer, Unit> function212;
        Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        int i30;
        MutableInteractionSource mutableInteractionSource3;
        Shape outlinedTextFieldShape;
        int i31;
        Composer composer3;
        TextFieldColors textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
        boolean z10;
        TextStyle textStyle5;
        int i32;
        boolean z11;
        VisualTransformation visualTransformation3;
        KeyboardOptions keyboardOptions3;
        KeyboardActions keyboardActions3;
        boolean z12;
        int i33;
        int i34;
        int i35;
        boolean z13;
        MutableInteractionSource mutableInteractionSource4;
        TextStyle textStyle6;
        Modifier.Companion companionM2041paddingqDBjuR0$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(801000036);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,label,placeholder,leadingIcon,trailingIcon,isError,visualTransformation,keyboardOptions,keyboardActions,singleLine,maxLines,minLines,interactionSource,shape,colors)346@19208L7,363@19884L38,372@20268L20,381@20622L1027,348@19221L2435:OutlinedTextField.kt#jmzs0o");
        if ((i3 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i36 = i5 & 4;
        if (i36 != 0) {
            i6 |= 384;
        } else {
            if ((i3 & 384) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i7 = i5 & 8;
            if (i7 == 0) {
                i6 |= 3072;
            } else {
                if ((i3 & 3072) == 0) {
                    i6 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
                }
                i8 = i5 & 16;
                if (i8 != 0) {
                    i6 |= 24576;
                } else {
                    if ((i3 & 24576) == 0) {
                        z5 = z2;
                        i6 |= composerStartRestartGroup.changed(z5) ? 16384 : 8192;
                    }
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        textStyle2 = textStyle;
                        i6 |= ((i5 & 32) == 0 && composerStartRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i9 = i5 & 64;
                    if (i9 == 0) {
                        i6 |= 1572864;
                        function25 = function2;
                    } else {
                        function25 = function2;
                        if ((i3 & 1572864) == 0) {
                            i6 |= composerStartRestartGroup.changedInstance(function25) ? 1048576 : 524288;
                        }
                    }
                    i10 = i5 & 128;
                    if (i10 == 0) {
                        i6 |= 12582912;
                        function26 = function22;
                    } else {
                        function26 = function22;
                        if ((i3 & 12582912) == 0) {
                            i6 |= composerStartRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
                        }
                    }
                    i11 = i5 & 256;
                    if (i11 == 0) {
                        i6 |= 100663296;
                    } else {
                        if ((i3 & 100663296) == 0) {
                            i12 = i11;
                            i6 |= composerStartRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        }
                        i13 = i5 & 512;
                        if (i13 == 0) {
                            if ((i3 & 805306368) == 0) {
                                i14 = i13;
                                i6 |= composerStartRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            }
                            i15 = i5 & 1024;
                            if (i15 == 0) {
                                i17 = i4 | 6;
                                i16 = i15;
                            } else if ((i4 & 6) == 0) {
                                i16 = i15;
                                i17 = i4 | (composerStartRestartGroup.changed(z3) ? 4 : 2);
                            } else {
                                i16 = i15;
                                i17 = i4;
                            }
                            i18 = i5 & 2048;
                            if (i18 == 0) {
                                i17 |= 48;
                                i19 = i18;
                            } else if ((i4 & 48) == 0) {
                                i19 = i18;
                                i17 |= composerStartRestartGroup.changed(visualTransformation) ? 32 : 16;
                            } else {
                                i19 = i18;
                            }
                            int i37 = i17;
                            i20 = i5 & 4096;
                            if (i20 == 0) {
                                i21 = i37 | 384;
                            } else {
                                int i38 = i37;
                                if ((i4 & 384) == 0) {
                                    i38 |= composerStartRestartGroup.changed(keyboardOptions) ? 256 : 128;
                                }
                                i21 = i38;
                            }
                            i22 = i5 & 8192;
                            if (i22 == 0) {
                                i23 = i21 | 3072;
                            } else {
                                int i39 = i21;
                                if ((i4 & 3072) == 0) {
                                    i23 = i39 | (composerStartRestartGroup.changed(keyboardActions) ? 2048 : 1024);
                                } else {
                                    i23 = i39;
                                }
                            }
                            i24 = i5 & 16384;
                            if (i24 == 0) {
                                i25 = i23 | 24576;
                            } else {
                                int i40 = i23;
                                if ((i4 & 24576) == 0) {
                                    i25 = i40 | (composerStartRestartGroup.changed(z4) ? 16384 : 8192);
                                } else {
                                    i25 = i40;
                                }
                            }
                            if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i25 |= ((i5 & 32768) == 0 && composerStartRestartGroup.changed(i)) ? 131072 : 65536;
                            }
                            i26 = i5 & 65536;
                            if (i26 == 0) {
                                i25 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i25 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i27 = i5 & 131072;
                            if (i27 == 0) {
                                i25 |= 12582912;
                            } else if ((i4 & 12582912) == 0) {
                                i25 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                            }
                            if ((i4 & 100663296) == 0) {
                                i25 |= ((i5 & 262144) == 0 && composerStartRestartGroup.changed(shape)) ? 67108864 : 33554432;
                            }
                            if ((i4 & 805306368) == 0) {
                                i25 |= ((i5 & 524288) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 536870912 : 268435456;
                            }
                            if (composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i25 & 306783379) != 306783378, i6 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                z6 = z;
                                function27 = function24;
                                visualTransformation2 = visualTransformation;
                                keyboardActions2 = keyboardActions;
                                i28 = i;
                                i29 = i2;
                                mutableInteractionSource2 = mutableInteractionSource;
                                shape2 = shape;
                                textFieldColors2 = textFieldColors;
                                z7 = z5;
                                textStyle3 = textStyle2;
                                function28 = function25;
                                modifier3 = modifier2;
                                function29 = function26;
                                function210 = function23;
                                z8 = z3;
                                keyboardOptions2 = keyboardOptions;
                                z9 = z4;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "324@18064L7,337@18714L22,338@18786L25");
                                if ((i3 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    companion = i36 != 0 ? Modifier.INSTANCE : modifier2;
                                    boolean z14 = i7 != 0 ? true : z;
                                    boolean z15 = i8 != 0 ? false : z5;
                                    if ((i5 & 32) != 0) {
                                        ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        i6 &= -458753;
                                        textStyle4 = (TextStyle) objConsume;
                                    } else {
                                        textStyle4 = textStyle2;
                                    }
                                    int i41 = i6;
                                    function211 = i9 != 0 ? null : function25;
                                    function212 = i10 != 0 ? null : function26;
                                    function213 = i12 != 0 ? null : function23;
                                    function214 = i14 != 0 ? null : function24;
                                    boolean z16 = i16 != 0 ? false : z3;
                                    VisualTransformation none = i19 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                    KeyboardOptions keyboardOptions4 = i20 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                    KeyboardActions keyboardActions4 = i22 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                    boolean z17 = i24 != 0 ? false : z4;
                                    if ((32768 & i5) != 0) {
                                        i25 &= -458753;
                                        i30 = z17 ? 1 : Integer.MAX_VALUE;
                                    } else {
                                        i30 = i;
                                    }
                                    int i42 = i26 != 0 ? 1 : i2;
                                    mutableInteractionSource3 = i27 != 0 ? null : mutableInteractionSource;
                                    if ((262144 & i5) != 0) {
                                        outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                                        i31 = i25 & (-234881025);
                                    } else {
                                        outlinedTextFieldShape = shape;
                                        i31 = i25;
                                    }
                                    if ((i5 & 524288) != 0) {
                                        composer3 = composerStartRestartGroup;
                                        textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m3214outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                                        i35 = i31 & (-1879048193);
                                        z10 = z14;
                                        z5 = z15;
                                        textStyle5 = textStyle4;
                                        i32 = i41;
                                        z11 = z16;
                                        visualTransformation3 = none;
                                        keyboardOptions3 = keyboardOptions4;
                                        keyboardActions3 = keyboardActions4;
                                        z12 = z17;
                                        i33 = i30;
                                        i34 = i42;
                                    } else {
                                        composer3 = composerStartRestartGroup;
                                        textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                        z10 = z14;
                                        z5 = z15;
                                        textStyle5 = textStyle4;
                                        i32 = i41;
                                        z11 = z16;
                                        visualTransformation3 = none;
                                        keyboardOptions3 = keyboardOptions4;
                                        keyboardActions3 = keyboardActions4;
                                        z12 = z17;
                                        i33 = i30;
                                        i34 = i42;
                                        i35 = i31;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i5 & 32) != 0) {
                                        i6 &= -458753;
                                    }
                                    if ((32768 & i5) != 0) {
                                        i25 &= -458753;
                                    }
                                    if ((262144 & i5) != 0) {
                                        i25 &= -234881025;
                                    }
                                    if ((i5 & 524288) != 0) {
                                        i25 &= -1879048193;
                                    }
                                    z10 = z;
                                    function213 = function23;
                                    function214 = function24;
                                    keyboardOptions3 = keyboardOptions;
                                    z12 = z4;
                                    i34 = i2;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    outlinedTextFieldShape = shape;
                                    composer3 = composerStartRestartGroup;
                                    i32 = i6;
                                    textStyle5 = textStyle2;
                                    function211 = function25;
                                    companion = modifier2;
                                    function212 = function26;
                                    i35 = i25;
                                    z11 = z3;
                                    visualTransformation3 = visualTransformation;
                                    keyboardActions3 = keyboardActions;
                                    i33 = i;
                                    textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                composer3.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    z13 = z5;
                                    ComposerKt.traceEventStart(801000036, i32, i35, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:339)");
                                } else {
                                    z13 = z5;
                                }
                                if (mutableInteractionSource3 == null) {
                                    composer3.startReplaceGroup(-245181289);
                                    ComposerKt.sourceInformation(composer3, "341@18898L39");
                                    ComposerKt.sourceInformationMarkerStart(composer3, 961922251, "CC(remember):OutlinedTextField.kt#9igjgp");
                                    Object objRememberedValue = composer3.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer3.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceGroup();
                                } else {
                                    composer3.startReplaceGroup(961921600);
                                    composer3.endReplaceGroup();
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                }
                                composer3.startReplaceGroup(961927346);
                                ComposerKt.sourceInformation(composer3, "*343@19077L18");
                                long jM8586getColor0d7_KjU = textStyle5.m8586getColor0d7_KjU();
                                if (jM8586getColor0d7_KjU == 16) {
                                    jM8586getColor0d7_KjU = textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs.textColor(z10, composer3, ((i32 >> 9) & 14) | ((i35 >> 24) & 112)).getValue().m6335unboximpl();
                                }
                                composer3.endReplaceGroup();
                                TextStyle textStyleMerge = textStyle5.merge(new TextStyle(jM8586getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                int i43 = i32;
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                int i44 = i35;
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composer3.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Density density = (Density) objConsume2;
                                if (function211 != null) {
                                    composer3.startReplaceGroup(-244710027);
                                    ComposerKt.sourceInformation(composer3, "357@19634L2");
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    textStyle6 = textStyle5;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 961945766, "CC(remember):OutlinedTextField.kt#9igjgp");
                                    Object objRememberedValue2 = composer3.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material.OutlinedTextFieldKt$$ExternalSyntheticLambda9
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return OutlinedTextFieldKt.OutlinedTextField$lambda$7$0((SemanticsPropertyReceiver) obj);
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    companionM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SemanticsModifierKt.semantics(companion2, true, (Function1) objRememberedValue2), 0.0f, density.mo1619toDpGaN1DYA(OutlinedTextFieldTopPadding), 0.0f, 0.0f, 13, null);
                                    composer3.endReplaceGroup();
                                } else {
                                    textStyle6 = textStyle5;
                                    composer3.startReplaceGroup(-244324666);
                                    composer3.endReplaceGroup();
                                    companionM2041paddingqDBjuR0$default = Modifier.INSTANCE;
                                }
                                Modifier modifier4 = companion;
                                final boolean z18 = z11;
                                final boolean z19 = z10;
                                final TextFieldColors textFieldColors3 = textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
                                final boolean z20 = z12;
                                final VisualTransformation visualTransformation4 = visualTransformation3;
                                final Function2<? super Composer, ? super Integer, Unit> function215 = function211;
                                final Function2<? super Composer, ? super Integer, Unit> function216 = function212;
                                final Function2<? super Composer, ? super Integer, Unit> function217 = function213;
                                final Function2<? super Composer, ? super Integer, Unit> function218 = function214;
                                final Shape shape3 = outlinedTextFieldShape;
                                int i45 = i44 << 12;
                                TextStyle textStyle7 = textStyle6;
                                Composer composer4 = composer3;
                                boolean z21 = z13;
                                BasicTextFieldKt.BasicTextField(str, function1, SizeKt.m2067defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(companion.then(companionM2041paddingqDBjuR0$default), z11, Strings_androidKt.m3171getString4foXLRw(Strings.INSTANCE.m3165getDefaultErrorMessageUdPEhr4(), composer3, 6)), TextFieldDefaults.INSTANCE.m3211getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m3210getMinHeightD9Ej5fM()), z10, z21, textStyleMerge, keyboardOptions3, keyboardActions3, z12, i33, i34, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource5, new SolidColor(textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs.cursorColor(z11, composer3, (i44 & 14) | ((i44 >> 24) & 112)).getValue().m6335unboximpl(), null), ComposableLambdaKt.rememberComposableLambda(-591103097, true, new Function3() { // from class: androidx.compose.material.OutlinedTextFieldKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return OutlinedTextFieldKt.OutlinedTextField$lambda$9(str, z19, z20, visualTransformation4, mutableInteractionSource5, z18, function215, function216, function217, function218, shape3, textFieldColors3, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer3, 54), composer4, (i43 & 64638) | (3670016 & i45) | (29360128 & i45) | (234881024 & i45) | (i45 & 1879048192), ((i44 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i44 & 112), 4096);
                                composer2 = composer4;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                VisualTransformation visualTransformation5 = visualTransformation3;
                                z9 = z12;
                                visualTransformation2 = visualTransformation5;
                                textFieldColors2 = textFieldColors3;
                                z6 = z10;
                                z7 = z21;
                                i28 = i33;
                                i29 = i34;
                                modifier3 = modifier4;
                                textStyle3 = textStyle7;
                                function28 = function211;
                                function29 = function212;
                                function210 = function213;
                                mutableInteractionSource2 = mutableInteractionSource3;
                                shape2 = outlinedTextFieldShape;
                                keyboardOptions2 = keyboardOptions3;
                                keyboardActions2 = keyboardActions3;
                                function27 = function214;
                                z8 = z18;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.OutlinedTextFieldKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return OutlinedTextFieldKt.OutlinedTextField$lambda$10(str, function1, modifier3, z6, z7, textStyle3, function28, function29, function210, function27, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i28, i29, mutableInteractionSource2, shape2, textFieldColors2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i6 |= 805306368;
                        i14 = i13;
                        i15 = i5 & 1024;
                        if (i15 == 0) {
                        }
                        i18 = i5 & 2048;
                        if (i18 == 0) {
                        }
                        int i372 = i17;
                        i20 = i5 & 4096;
                        if (i20 == 0) {
                        }
                        i22 = i5 & 8192;
                        if (i22 == 0) {
                        }
                        i24 = i5 & 16384;
                        if (i24 == 0) {
                        }
                        if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        }
                        i26 = i5 & 65536;
                        if (i26 == 0) {
                        }
                        i27 = i5 & 131072;
                        if (i27 == 0) {
                        }
                        if ((i4 & 100663296) == 0) {
                        }
                        if ((i4 & 805306368) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i25 & 306783379) != 306783378, i6 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i12 = i11;
                    i13 = i5 & 512;
                    if (i13 == 0) {
                    }
                    i14 = i13;
                    i15 = i5 & 1024;
                    if (i15 == 0) {
                    }
                    i18 = i5 & 2048;
                    if (i18 == 0) {
                    }
                    int i3722 = i17;
                    i20 = i5 & 4096;
                    if (i20 == 0) {
                    }
                    i22 = i5 & 8192;
                    if (i22 == 0) {
                    }
                    i24 = i5 & 16384;
                    if (i24 == 0) {
                    }
                    if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    i26 = i5 & 65536;
                    if (i26 == 0) {
                    }
                    i27 = i5 & 131072;
                    if (i27 == 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    if ((i4 & 805306368) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i25 & 306783379) != 306783378, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z5 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                i9 = i5 & 64;
                if (i9 == 0) {
                }
                i10 = i5 & 128;
                if (i10 == 0) {
                }
                i11 = i5 & 256;
                if (i11 == 0) {
                }
                i12 = i11;
                i13 = i5 & 512;
                if (i13 == 0) {
                }
                i14 = i13;
                i15 = i5 & 1024;
                if (i15 == 0) {
                }
                i18 = i5 & 2048;
                if (i18 == 0) {
                }
                int i37222 = i17;
                i20 = i5 & 4096;
                if (i20 == 0) {
                }
                i22 = i5 & 8192;
                if (i22 == 0) {
                }
                i24 = i5 & 16384;
                if (i24 == 0) {
                }
                if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i26 = i5 & 65536;
                if (i26 == 0) {
                }
                i27 = i5 & 131072;
                if (i27 == 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                if ((i4 & 805306368) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i25 & 306783379) != 306783378, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i8 = i5 & 16;
            if (i8 != 0) {
            }
            z5 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            i9 = i5 & 64;
            if (i9 == 0) {
            }
            i10 = i5 & 128;
            if (i10 == 0) {
            }
            i11 = i5 & 256;
            if (i11 == 0) {
            }
            i12 = i11;
            i13 = i5 & 512;
            if (i13 == 0) {
            }
            i14 = i13;
            i15 = i5 & 1024;
            if (i15 == 0) {
            }
            i18 = i5 & 2048;
            if (i18 == 0) {
            }
            int i372222 = i17;
            i20 = i5 & 4096;
            if (i20 == 0) {
            }
            i22 = i5 & 8192;
            if (i22 == 0) {
            }
            i24 = i5 & 16384;
            if (i24 == 0) {
            }
            if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i26 = i5 & 65536;
            if (i26 == 0) {
            }
            i27 = i5 & 131072;
            if (i27 == 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            if ((i4 & 805306368) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i25 & 306783379) != 306783378, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 8;
        if (i7 == 0) {
        }
        i8 = i5 & 16;
        if (i8 != 0) {
        }
        z5 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i9 = i5 & 64;
        if (i9 == 0) {
        }
        i10 = i5 & 128;
        if (i10 == 0) {
        }
        i11 = i5 & 256;
        if (i11 == 0) {
        }
        i12 = i11;
        i13 = i5 & 512;
        if (i13 == 0) {
        }
        i14 = i13;
        i15 = i5 & 1024;
        if (i15 == 0) {
        }
        i18 = i5 & 2048;
        if (i18 == 0) {
        }
        int i3722222 = i17;
        i20 = i5 & 4096;
        if (i20 == 0) {
        }
        i22 = i5 & 8192;
        if (i22 == 0) {
        }
        i24 = i5 & 16384;
        if (i24 == 0) {
        }
        if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i26 = i5 & 65536;
        if (i26 == 0) {
        }
        i27 = i5 & 131072;
        if (i27 == 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        if ((i4 & 805306368) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i25 & 306783379) != 306783378, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:293:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0121  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void OutlinedTextField(final String str, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        boolean z5;
        int i7;
        boolean z6;
        TextStyle textStyle2;
        int i8;
        Function2 function25;
        int i9;
        Function2 function26;
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
        Composer composer2;
        final Function2 function27;
        final VisualTransformation visualTransformation2;
        final KeyboardActions keyboardActions2;
        final int i27;
        final MutableInteractionSource mutableInteractionSource2;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final boolean z7;
        final boolean z8;
        final TextStyle textStyle3;
        final Function2 function28;
        final Modifier modifier3;
        final Function2 function29;
        final Function2 function210;
        final boolean z9;
        final KeyboardOptions keyboardOptions2;
        final boolean z10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        TextStyle textStyle4;
        MutableInteractionSource mutableInteractionSource3;
        Shape outlinedTextFieldShape;
        TextFieldColors textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
        Modifier modifier4;
        boolean z11;
        int i28;
        Function2 function211;
        Function2 function212;
        Function2 function213;
        Function2 function214;
        boolean z12;
        VisualTransformation visualTransformation3;
        KeyboardOptions keyboardOptions3;
        KeyboardActions keyboardActions3;
        boolean z13;
        int i29;
        MutableInteractionSource mutableInteractionSource4;
        Shape shape3;
        int i30;
        Composer composerStartRestartGroup = composer.startRestartGroup(1453565505);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,label,placeholder,leadingIcon,trailingIcon,isError,visualTransformation,keyboardOptions,keyboardActions,singleLine,maxLines,interactionSource,shape,colors)436@22763L417:OutlinedTextField.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i31 = i4 & 4;
        if (i31 != 0) {
            i5 |= 384;
        } else {
            if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    z5 = z;
                    i5 |= composerStartRestartGroup.changed(z5) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((i2 & 24576) == 0) {
                        z6 = z2;
                        i5 |= composerStartRestartGroup.changed(z6) ? 16384 : 8192;
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        textStyle2 = textStyle;
                        i5 |= ((i4 & 32) == 0 && composerStartRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i8 = i4 & 64;
                    if (i8 == 0) {
                        i5 |= 1572864;
                        function25 = function2;
                    } else {
                        function25 = function2;
                        if ((i2 & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function25) ? 1048576 : 524288;
                        }
                    }
                    i9 = i4 & 128;
                    if (i9 == 0) {
                        i5 |= 12582912;
                        function26 = function22;
                    } else {
                        function26 = function22;
                        if ((i2 & 12582912) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
                        }
                    }
                    i10 = i4 & 256;
                    if (i10 == 0) {
                        i5 |= 100663296;
                    } else {
                        if ((i2 & 100663296) == 0) {
                            i11 = i10;
                            i5 |= composerStartRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        }
                        i12 = i4 & 512;
                        if (i12 == 0) {
                            if ((i2 & 805306368) == 0) {
                                i13 = i12;
                                i5 |= composerStartRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            }
                            i14 = i4 & 1024;
                            if (i14 == 0) {
                                i16 = i3 | 6;
                                i15 = i14;
                            } else if ((i3 & 6) == 0) {
                                i15 = i14;
                                i16 = i3 | (composerStartRestartGroup.changed(z3) ? 4 : 2);
                            } else {
                                i15 = i14;
                                i16 = i3;
                            }
                            i17 = i4 & 2048;
                            if (i17 == 0) {
                                i16 |= 48;
                                i18 = i17;
                            } else if ((i3 & 48) == 0) {
                                i18 = i17;
                                i16 |= composerStartRestartGroup.changed(visualTransformation) ? 32 : 16;
                            } else {
                                i18 = i17;
                            }
                            int i32 = i16;
                            i19 = i4 & 4096;
                            if (i19 == 0) {
                                i20 = i32 | 384;
                            } else {
                                int i33 = i32;
                                if ((i3 & 384) == 0) {
                                    i33 |= composerStartRestartGroup.changed(keyboardOptions) ? 256 : 128;
                                }
                                i20 = i33;
                            }
                            i21 = i4 & 8192;
                            if (i21 == 0) {
                                i22 = i20 | 3072;
                            } else {
                                int i34 = i20;
                                if ((i3 & 3072) == 0) {
                                    i22 = i34 | (composerStartRestartGroup.changed(keyboardActions) ? 2048 : 1024);
                                } else {
                                    i22 = i34;
                                }
                            }
                            i23 = i4 & 16384;
                            if (i23 == 0) {
                                i24 = i22 | 24576;
                            } else {
                                int i35 = i22;
                                if ((i3 & 24576) == 0) {
                                    i24 = i35 | (composerStartRestartGroup.changed(z4) ? 16384 : 8192);
                                } else {
                                    i24 = i35;
                                }
                            }
                            i25 = i4 & 32768;
                            if (i25 == 0) {
                                i24 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i24 |= composerStartRestartGroup.changed(i) ? 131072 : 65536;
                            }
                            i26 = i4 & 65536;
                            if (i26 == 0) {
                                i24 |= 1572864;
                            } else if ((i3 & 1572864) == 0) {
                                i24 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
                            }
                            if ((i3 & 12582912) == 0) {
                                i24 |= ((i4 & 131072) == 0 && composerStartRestartGroup.changed(shape)) ? 8388608 : 4194304;
                            }
                            if ((i3 & 100663296) == 0) {
                                i24 |= ((i4 & 262144) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 67108864 : 33554432;
                            }
                            if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i24 & 38347923) != 38347922, i5 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                function27 = function24;
                                visualTransformation2 = visualTransformation;
                                keyboardActions2 = keyboardActions;
                                i27 = i;
                                mutableInteractionSource2 = mutableInteractionSource;
                                shape2 = shape;
                                textFieldColors2 = textFieldColors;
                                z7 = z5;
                                z8 = z6;
                                textStyle3 = textStyle2;
                                function28 = function25;
                                modifier3 = modifier2;
                                function29 = function26;
                                function210 = function23;
                                z9 = z3;
                                keyboardOptions2 = keyboardOptions;
                                z10 = z4;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "421@22018L7,432@22578L39,433@22656L22,434@22728L25");
                                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i31 != 0 ? Modifier.INSTANCE : modifier2;
                                    boolean z14 = i6 != 0 ? true : z5;
                                    boolean z15 = i7 != 0 ? false : z6;
                                    if ((i4 & 32) != 0) {
                                        ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        i5 &= -458753;
                                        textStyle4 = (TextStyle) objConsume;
                                    } else {
                                        textStyle4 = textStyle2;
                                    }
                                    int i36 = i5;
                                    Function2 function215 = i8 != 0 ? null : function25;
                                    Function2 function216 = i9 != 0 ? null : function26;
                                    Function2 function217 = i11 != 0 ? null : function23;
                                    Function2 function218 = i13 != 0 ? null : function24;
                                    boolean z16 = i15 != 0 ? false : z3;
                                    VisualTransformation none = i18 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                    KeyboardOptions keyboardOptions4 = i19 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                    KeyboardActions keyboardActions4 = i21 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                    boolean z17 = i23 != 0 ? false : z4;
                                    int i37 = i25 != 0 ? Integer.MAX_VALUE : i;
                                    if (i26 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1012103976, "CC(remember):OutlinedTextField.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    if ((i4 & 131072) != 0) {
                                        i24 &= -29360129;
                                        outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                                    } else {
                                        outlinedTextFieldShape = shape;
                                    }
                                    int i38 = i24;
                                    if ((262144 & i4) != 0) {
                                        composer2 = composerStartRestartGroup;
                                        modifier4 = companion;
                                        z11 = z14;
                                        textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m3214outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 0, 48, 2097151);
                                        i30 = i38 & (-234881025);
                                        z6 = z15;
                                        textStyle2 = textStyle4;
                                        i28 = i36;
                                        function211 = function215;
                                        function212 = function216;
                                        function213 = function217;
                                        function214 = function218;
                                        z12 = z16;
                                        visualTransformation3 = none;
                                        keyboardOptions3 = keyboardOptions4;
                                        keyboardActions3 = keyboardActions4;
                                        z13 = z17;
                                        i29 = i37;
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                        shape3 = outlinedTextFieldShape;
                                    } else {
                                        composer2 = composerStartRestartGroup;
                                        textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                        modifier4 = companion;
                                        z11 = z14;
                                        z6 = z15;
                                        textStyle2 = textStyle4;
                                        i28 = i36;
                                        function211 = function215;
                                        function212 = function216;
                                        function213 = function217;
                                        function214 = function218;
                                        z12 = z16;
                                        visualTransformation3 = none;
                                        keyboardOptions3 = keyboardOptions4;
                                        keyboardActions3 = keyboardActions4;
                                        z13 = z17;
                                        i29 = i37;
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                        shape3 = outlinedTextFieldShape;
                                        i30 = i38;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i4 & 32) != 0) {
                                        i5 &= -458753;
                                    }
                                    if ((i4 & 131072) != 0) {
                                        i24 &= -29360129;
                                    }
                                    if ((262144 & i4) != 0) {
                                        i24 &= -234881025;
                                    }
                                    function213 = function23;
                                    z12 = z3;
                                    keyboardOptions3 = keyboardOptions;
                                    keyboardActions3 = keyboardActions;
                                    i29 = i;
                                    mutableInteractionSource4 = mutableInteractionSource;
                                    shape3 = shape;
                                    textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                    composer2 = composerStartRestartGroup;
                                    z11 = z5;
                                    i28 = i5;
                                    function211 = function25;
                                    modifier4 = modifier2;
                                    function212 = function26;
                                    i30 = i24;
                                    function214 = function24;
                                    visualTransformation3 = visualTransformation;
                                    z13 = z4;
                                }
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1453565505, i28, i30, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:435)");
                                }
                                int i39 = i28 & 2147483646;
                                int i40 = (i30 & 14) | 1572864 | (i30 & 112) | (i30 & 896) | (i30 & 7168) | (57344 & i30) | (458752 & i30);
                                int i41 = i30 << 3;
                                OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier4, z11, z6, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) function211, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function213, (Function2<? super Composer, ? super Integer, Unit>) function214, z12, visualTransformation3, keyboardOptions3, keyboardActions3, z13, i29, 1, mutableInteractionSource4, shape3, textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs, composer2, i39, i40 | (29360128 & i41) | (234881024 & i41) | (i41 & 1879048192), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                z7 = z11;
                                z8 = z6;
                                textStyle3 = textStyle2;
                                function28 = function211;
                                function29 = function212;
                                function210 = function213;
                                function27 = function214;
                                z9 = z12;
                                visualTransformation2 = visualTransformation3;
                                keyboardOptions2 = keyboardOptions3;
                                keyboardActions2 = keyboardActions3;
                                z10 = z13;
                                i27 = i29;
                                mutableInteractionSource2 = mutableInteractionSource4;
                                shape2 = shape3;
                                textFieldColors2 = textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.OutlinedTextFieldKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return OutlinedTextFieldKt.OutlinedTextField$lambda$12(str, function1, modifier3, z7, z8, textStyle3, function28, function29, function210, function27, z9, visualTransformation2, keyboardOptions2, keyboardActions2, z10, i27, mutableInteractionSource2, shape2, textFieldColors2, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i5 |= 805306368;
                        i13 = i12;
                        i14 = i4 & 1024;
                        if (i14 == 0) {
                        }
                        i17 = i4 & 2048;
                        if (i17 == 0) {
                        }
                        int i322 = i16;
                        i19 = i4 & 4096;
                        if (i19 == 0) {
                        }
                        i21 = i4 & 8192;
                        if (i21 == 0) {
                        }
                        i23 = i4 & 16384;
                        if (i23 == 0) {
                        }
                        i25 = i4 & 32768;
                        if (i25 == 0) {
                        }
                        i26 = i4 & 65536;
                        if (i26 == 0) {
                        }
                        if ((i3 & 12582912) == 0) {
                        }
                        if ((i3 & 100663296) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i24 & 38347923) != 38347922, i5 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i11 = i10;
                    i12 = i4 & 512;
                    if (i12 == 0) {
                    }
                    i13 = i12;
                    i14 = i4 & 1024;
                    if (i14 == 0) {
                    }
                    i17 = i4 & 2048;
                    if (i17 == 0) {
                    }
                    int i3222 = i16;
                    i19 = i4 & 4096;
                    if (i19 == 0) {
                    }
                    i21 = i4 & 8192;
                    if (i21 == 0) {
                    }
                    i23 = i4 & 16384;
                    if (i23 == 0) {
                    }
                    i25 = i4 & 32768;
                    if (i25 == 0) {
                    }
                    i26 = i4 & 65536;
                    if (i26 == 0) {
                    }
                    if ((i3 & 12582912) == 0) {
                    }
                    if ((i3 & 100663296) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i24 & 38347923) != 38347922, i5 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z6 = z2;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
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
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i4 & 1024;
                if (i14 == 0) {
                }
                i17 = i4 & 2048;
                if (i17 == 0) {
                }
                int i32222 = i16;
                i19 = i4 & 4096;
                if (i19 == 0) {
                }
                i21 = i4 & 8192;
                if (i21 == 0) {
                }
                i23 = i4 & 16384;
                if (i23 == 0) {
                }
                i25 = i4 & 32768;
                if (i25 == 0) {
                }
                i26 = i4 & 65536;
                if (i26 == 0) {
                }
                if ((i3 & 12582912) == 0) {
                }
                if ((i3 & 100663296) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i24 & 38347923) != 38347922, i5 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z5 = z;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            z6 = z2;
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
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
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i4 & 1024;
            if (i14 == 0) {
            }
            i17 = i4 & 2048;
            if (i17 == 0) {
            }
            int i322222 = i16;
            i19 = i4 & 4096;
            if (i19 == 0) {
            }
            i21 = i4 & 8192;
            if (i21 == 0) {
            }
            i23 = i4 & 16384;
            if (i23 == 0) {
            }
            i25 = i4 & 32768;
            if (i25 == 0) {
            }
            i26 = i4 & 65536;
            if (i26 == 0) {
            }
            if ((i3 & 12582912) == 0) {
            }
            if ((i3 & 100663296) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i24 & 38347923) != 38347922, i5 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z5 = z;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        z6 = z2;
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
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
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i4 & 1024;
        if (i14 == 0) {
        }
        i17 = i4 & 2048;
        if (i17 == 0) {
        }
        int i3222222 = i16;
        i19 = i4 & 4096;
        if (i19 == 0) {
        }
        i21 = i4 & 8192;
        if (i21 == 0) {
        }
        i23 = i4 & 16384;
        if (i23 == 0) {
        }
        i25 = i4 & 32768;
        if (i25 == 0) {
        }
        i26 = i4 & 65536;
        if (i26 == 0) {
        }
        if ((i3 & 12582912) == 0) {
        }
        if ((i3 & 100663296) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i24 & 38347923) != 38347922, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit OutlinedTextField$lambda$10(String str, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i3, int i4, int i5, Composer composer, int i6) {
        OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier, z, z2, textStyle, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function22, (Function2<? super Composer, ? super Integer, Unit>) function23, (Function2<? super Composer, ? super Integer, Unit>) function24, z3, visualTransformation, keyboardOptions, keyboardActions, z4, i, i2, mutableInteractionSource, shape, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    static final Unit OutlinedTextField$lambda$12(String str, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i2, int i3, int i4, Composer composer, int i5) {
        OutlinedTextField(str, function1, modifier, z, z2, textStyle, function2, function22, function23, function24, z3, visualTransformation, keyboardOptions, keyboardActions, z4, i, mutableInteractionSource, shape, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutlinedTextField$lambda$15$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    static final Unit OutlinedTextField$lambda$17(TextFieldValue textFieldValue, final boolean z, boolean z2, VisualTransformation visualTransformation, final MutableInteractionSource mutableInteractionSource, final boolean z3, Function2 function2, Function2 function22, Function2 function23, Function2 function24, final Shape shape, final TextFieldColors textFieldColors, Function2 function25, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "CN(innerTextField)603@31268L294,589@30617L964:OutlinedTextField.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = i | (composer.changedInstance(function25) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1881867558, i2, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:589)");
            }
            TextFieldDefaults.INSTANCE.OutlinedTextFieldDecorationBox(textFieldValue.getText(), function25, z, z2, visualTransformation, mutableInteractionSource, z3, function2, function22, function23, function24, shape, textFieldColors, null, ComposableLambdaKt.rememberComposableLambda(-185364670, true, new Function2() { // from class: androidx.compose.material.OutlinedTextFieldKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OutlinedTextFieldKt.OutlinedTextField$lambda$17$0(z, z3, mutableInteractionSource, textFieldColors, shape, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, (i2 << 3) & 112, 221184, 8192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutlinedTextField$lambda$17$0(boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, TextFieldColors textFieldColors, Shape shape, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C604@31312L228:OutlinedTextField.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-185364670, i, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:604)");
            }
            TextFieldDefaults.INSTANCE.m3208BorderBoxnbWgWpA(z, z2, mutableInteractionSource, textFieldColors, shape, 0.0f, 0.0f, composer, 12582912, 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit OutlinedTextField$lambda$18(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i3, int i4, int i5, Composer composer, int i6) {
        OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier, z, z2, textStyle, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function22, (Function2<? super Composer, ? super Integer, Unit>) function23, (Function2<? super Composer, ? super Integer, Unit>) function24, z3, visualTransformation, keyboardOptions, keyboardActions, z4, i, i2, mutableInteractionSource, shape, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutlinedTextField$lambda$2$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    static final Unit OutlinedTextField$lambda$20(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i2, int i3, int i4, Composer composer, int i5) {
        OutlinedTextField(textFieldValue, function1, modifier, z, z2, textStyle, function2, function22, function23, function24, z3, visualTransformation, keyboardOptions, keyboardActions, z4, i, mutableInteractionSource, shape, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    static final Unit OutlinedTextField$lambda$4(TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z3, InputTransformation inputTransformation, OutputTransformation outputTransformation, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, ScrollState scrollState, Shape shape, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        OutlinedTextField(textFieldState, modifier, z, z2, textStyle, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function22, (Function2<? super Composer, ? super Integer, Unit>) function23, (Function2<? super Composer, ? super Integer, Unit>) function24, z3, inputTransformation, outputTransformation, keyboardOptions, keyboardActionHandler, textFieldLineLimits, scrollState, shape, textFieldColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutlinedTextField$lambda$7$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    static final Unit OutlinedTextField$lambda$9(String str, final boolean z, boolean z2, VisualTransformation visualTransformation, final MutableInteractionSource mutableInteractionSource, final boolean z3, Function2 function2, Function2 function22, Function2 function23, Function2 function24, final Shape shape, final TextFieldColors textFieldColors, Function2 function25, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "CN(innerTextField)396@21322L294,382@20676L959:OutlinedTextField.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = i | (composer.changedInstance(function25) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-591103097, i2, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:382)");
            }
            TextFieldDefaults.INSTANCE.OutlinedTextFieldDecorationBox(str, function25, z, z2, visualTransformation, mutableInteractionSource, z3, function2, function22, function23, function24, shape, textFieldColors, null, ComposableLambdaKt.rememberComposableLambda(-1118701585, true, new Function2() { // from class: androidx.compose.material.OutlinedTextFieldKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OutlinedTextFieldKt.OutlinedTextField$lambda$9$0(z, z3, mutableInteractionSource, textFieldColors, shape, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, (i2 << 3) & 112, 221184, 8192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutlinedTextField$lambda$9$0(boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, TextFieldColors textFieldColors, Shape shape, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C397@21366L228:OutlinedTextField.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1118701585, i, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:397)");
            }
            TextFieldDefaults.INSTANCE.m3208BorderBoxnbWgWpA(z, z2, mutableInteractionSource, textFieldColors, shape, 0.0f, 0.0f, composer, 12582912, 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void OutlinedTextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final float f, final Function1<? super Size, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function25, final PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(36320288);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextFieldLayout)N(modifier,textField,placeholder,label,leading,trailing,singleLine,animationProgress,onLabelMeasured,border,paddingValues)687@33864L268,695@34180L7,696@34192L2415:OutlinedTextField.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
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
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function25) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(paddingValues) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if (composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i4 & 3) == 2) ? false : true, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(36320288, i3, i4, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:685)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544073420, "CC(remember):OutlinedTextField.kt#9igjgp");
            boolean z2 = ((i4 & 14) == 4) | ((3670016 & i3) == 1048576) | ((234881024 & i3) == 67108864) | ((29360128 & i3) == 8388608);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new OutlinedTextFieldMeasurePolicy(function1, z, f, paddingValues);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume;
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) objRememberedValue;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Updater.m5603setimpl(composerM5595constructorimpl, outlinedTextFieldMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1336985421, "C704@34696L8,744@36249L183:OutlinedTextField.kt#jmzs0o");
            function25.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
            if (function23 != null) {
                composerStartRestartGroup.startReplaceGroup(1336978507);
                ComposerKt.sourceInformation(composerStartRestartGroup, "707@34757L224");
                Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(LayoutIdKt.layoutId(Modifier.INSTANCE, "Leading"));
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierMinimumInteractiveComponentSize);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                i5 = i3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2068226786, "C711@34954L9:OutlinedTextField.kt#jmzs0o");
                function23.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                i5 = i3;
                composerStartRestartGroup.startReplaceGroup(1302508491);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (function24 != null) {
                composerStartRestartGroup.startReplaceGroup(1337267241);
                ComposerKt.sourceInformation(composerStartRestartGroup, "715@35048L226");
                Modifier modifierMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(LayoutIdKt.layoutId(Modifier.INSTANCE, "Trailing"));
                Alignment center2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierMinimumInteractiveComponentSize2);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 479587178, "C719@35246L10:OutlinedTextField.kt#jmzs0o");
                function24.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(1302508491);
            }
            composerStartRestartGroup.endReplaceGroup();
            float fCalculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
            float fCalculateEndPadding = PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
            Modifier.Companion companion = Modifier.INSTANCE;
            if (function23 != null) {
                fCalculateStartPadding = Dp.m9114constructorimpl(RangesKt.coerceAtLeast(Dp.m9114constructorimpl(fCalculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m9114constructorimpl(0.0f)));
            }
            float f2 = fCalculateStartPadding;
            if (function24 != null) {
                fCalculateEndPadding = Dp.m9114constructorimpl(RangesKt.coerceAtLeast(Dp.m9114constructorimpl(fCalculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m9114constructorimpl(0.0f)));
            }
            Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(companion, f2, 0.0f, fCalculateEndPadding, 0.0f, 10, null);
            if (function3 != null) {
                composerStartRestartGroup.startReplaceGroup(1338367152);
                ComposerKt.sourceInformation(composerStartRestartGroup, "741@36162L59");
                function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, "Hint").then(modifierM2041paddingqDBjuR0$default), composerStartRestartGroup, Integer.valueOf((i5 >> 3) & 112));
            } else {
                composerStartRestartGroup.startReplaceGroup(1302508491);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierThen = LayoutIdKt.layoutId(Modifier.INSTANCE, "TextField").then(modifierM2041paddingqDBjuR0$default);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl4 = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composerM5595constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM5595constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -842047077, "C748@36407L11:OutlinedTextField.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function22 != null) {
                composerStartRestartGroup.startReplaceGroup(1338685429);
                ComposerKt.sourceInformation(composerStartRestartGroup, "752@36483L54");
                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "Label");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor5);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5595constructorimpl5 = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    composerM5595constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    composerM5595constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                Updater.m5603setimpl(composerM5595constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1905963083, "C752@36528L7:OutlinedTextField.kt#jmzs0o");
                function26 = function22;
                function26.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function26 = function22;
                composerStartRestartGroup.startReplaceGroup(1302508491);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function26 = function22;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.OutlinedTextFieldKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OutlinedTextFieldKt.OutlinedTextFieldLayout$lambda$2(modifier, function2, function3, function26, function23, function24, z, f, function1, function25, paddingValues, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit OutlinedTextFieldLayout$lambda$2(Modifier modifier, Function2 function2, Function3 function3, Function2 function22, Function2 function23, Function2 function24, boolean z, float f, Function1 function1, Function2 function25, PaddingValues paddingValues, int i, int i2, Composer composer, int i3) {
        OutlinedTextFieldLayout(modifier, function2, function3, function22, function23, function24, z, f, function1, function25, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m3097calculateHeightO3s9Psw(int i, int i2, int i3, int i4, int i5, float f, long j, float f2, PaddingValues paddingValues) {
        int iMax = Math.max(i3, Math.max(i5, MathHelpersKt.lerp(i4, 0, f)));
        float top = paddingValues.getTop() * f2;
        return ConstraintsKt.m9083constrainHeightK40F9xA(j, Math.max(i, Math.max(i2, MathKt.roundToInt(MathHelpersKt.lerp(top, Math.max(top, i4 / 2.0f), f) + iMax + (paddingValues.getBottom() * f2)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateWidth-O3s9Psw, reason: not valid java name */
    public static final int m3098calculateWidthO3s9Psw(int i, int i2, int i3, int i4, int i5, float f, long j, float f2, PaddingValues paddingValues) {
        return ConstraintsKt.m9084constrainWidthK40F9xA(j, Math.max(i + Math.max(i3, Math.max(MathHelpersKt.lerp(i4, 0, f), i5)) + i2, MathKt.roundToInt((i4 + (Dp.m9114constructorimpl(paddingValues.mo1987calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr) + paddingValues.mo1988calculateRightPaddingu2uoSUM(LayoutDirection.Ltr)) * f2)) * f)));
    }

    public static final long getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }

    /* JADX INFO: renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m3099outlineCutout12SF9DM(Modifier modifier, final long j, final PaddingValues paddingValues) {
        return DrawModifierKt.drawWithContent(modifier, new Function1() { // from class: androidx.compose.material.OutlinedTextFieldKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OutlinedTextFieldKt.outlineCutout_12SF9DM$lambda$0(j, paddingValues, (ContentDrawScope) obj);
            }
        });
    }

    static final Unit outlineCutout_12SF9DM$lambda$0(long j, PaddingValues paddingValues, ContentDrawScope contentDrawScope) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        if (fIntBitsToFloat > 0.0f) {
            float f = contentDrawScope.mo1624toPx0680j_4(OutlinedTextFieldInnerPadding);
            float f2 = contentDrawScope.mo1624toPx0680j_4(paddingValues.mo1987calculateLeftPaddingu2uoSUM(contentDrawScope.getLayoutDirection())) - f;
            float fIntBitsToFloat2 = fIntBitsToFloat + f2 + (f * 2.0f);
            float fIntBitsToFloat3 = WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()] == 1 ? Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() >> 32)) - fIntBitsToFloat2 : RangesKt.coerceAtLeast(f2, 0.0f);
            if (WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                fIntBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() >> 32)) - RangesKt.coerceAtLeast(f2, 0.0f);
            }
            float f3 = fIntBitsToFloat2;
            float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
            float f4 = (-fIntBitsToFloat4) / 2.0f;
            float f5 = fIntBitsToFloat4 / 2.0f;
            int iM6313getDifferencertfAjoo = ClipOp.INSTANCE.m6313getDifferencertfAjoo();
            DrawContext drawContext = contentDrawScope.getDrawContext();
            long jMo6820getSizeNHjbRc = drawContext.mo6820getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo6823clipRectN_I0leg(fIntBitsToFloat3, f4, f3, f5, iM6313getDifferencertfAjoo);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, float f, boolean z, float f2, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int iRoundToInt = MathKt.roundToInt(paddingValues.getTop() * f2);
        int iRoundToInt2 = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f2);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f2;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), i), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2 - placeable2.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, MathKt.roundToInt(placeable == null ? 0.0f : (TextFieldImplKt.widthOrZero(placeable) - horizontalIconPadding) * (1.0f - f)) + iRoundToInt2, MathHelpersKt.lerp(z ? Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), i) : iRoundToInt, -(placeable4.getHeight() / 2), f), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable), Math.max(z ? Alignment.INSTANCE.getCenterVertically().align(placeable3.getHeight(), i) : iRoundToInt, TextFieldImplKt.heightOrZero(placeable4) / 2), 0.0f, 4, null);
        if (placeable5 != null) {
            if (z) {
                iRoundToInt = Alignment.INSTANCE.getCenterVertically().align(placeable5.getHeight(), i);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, TextFieldImplKt.widthOrZero(placeable), Math.max(iRoundToInt, TextFieldImplKt.heightOrZero(placeable4) / 2), 0.0f, 4, null);
        }
        Placeable.PlacementScope.m7835place70tqf50$default(placementScope, placeable6, IntOffset.INSTANCE.m9253getZeronOccac(), 0.0f, 2, null);
    }
}
