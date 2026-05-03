package androidx.compose.foundation.text;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.HoverInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequesterImpl;
import androidx.compose.foundation.text.handwriting.StylusHandwritingKt;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.foundation.text.input.internal.SingleLineCodepointTransformation;
import androidx.compose.foundation.text.input.internal.TextFieldCoreModifier;
import androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifier;
import androidx.compose.foundation.text.input.internal.TextFieldTextLayoutModifier;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.foundation.text.selection.SelectedTextType;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.muxer.WebmConstants;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: BasicTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÛ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u001228\b\u0002\u0010\u0013\u001a2\u0012\u0004\u0012\u00020\u0015\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014¢\u0006\u0002\b\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0002\u0010&\u001añ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u001228\b\u0002\u0010\u0013\u001a2\u0012\u0004\u0012\u00020\u0015\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014¢\u0006\u0002\b\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010)\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010*\u001a\u001c\u0010+\u001a\u00020\u0005*\u00020\u00052\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002\u001a\u0015\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020-H\u0001¢\u0006\u0002\u00102\u001a\u0015\u00103\u001a\u00020\u00012\u0006\u00101\u001a\u00020-H\u0001¢\u0006\u0002\u00102\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u00108\u001a\u0002092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u00072\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020C2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010D\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010G\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u00108\u001a\u00020H2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u00072\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020C2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010D\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010I\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u00108\u001a\u0002092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u00072\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020C2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010D\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010J\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u00108\u001a\u00020H2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u00072\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020C2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010D\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010K\"\u000e\u00104\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0004\n\u0002\u00107¨\u0006L²\u0006\n\u0010M\u001a\u00020NX\u008a\u0084\u0002²\u0006\n\u0010O\u001a\u00020NX\u008a\u0084\u0002²\u0006\n\u0010P\u001a\u00020NX\u008a\u0084\u0002²\u0006\n\u0010Q\u001a\u00020HX\u008a\u008e\u0002²\u0006\n\u0010R\u001a\u000209X\u008a\u008e\u0002"}, d2 = {"BasicTextField", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "isPassword", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/runtime/Composer;III)V", "addContextMenuComponents", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "TextFieldCursorHandle", "selectionState", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/runtime/Composer;I)V", "TextFieldSelectionHandles", "DefaultTextFieldDecorator", "MinTouchTargetSizeForHandles", "Landroidx/compose/ui/unit/DpSize;", "J", "value", "", "onValueChange", "Lkotlin/Function1;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "decorationBox", "Landroidx/compose/runtime/Composable;", "innerTextField", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation", "cursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "startHandleState", "endHandleState", "textFieldValueState", "lastTextValue"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicTextFieldKt {
    private static final TextFieldDecorator DefaultTextFieldDecorator = BasicTextFieldKt$DefaultTextFieldDecorator$1.INSTANCE;
    private static final long MinTouchTargetSizeForHandles = DpKt.m9136DpSizeYgX7TsA(Dp.m9114constructorimpl(40.0f), Dp.m9114constructorimpl(40.0f));

    /* JADX WARN: Removed duplicated region for block: B:108:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:232:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(final TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, MutableInteractionSource mutableInteractionSource, Brush brush, OutputTransformation outputTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState, Composer composer, final int i, final int i2, final int i3) {
        TextFieldState textFieldState2;
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        int i7;
        InputTransformation inputTransformation2;
        int i8;
        TextStyle textStyle2;
        int i9;
        KeyboardOptions keyboardOptions2;
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
        final TextFieldLineLimits textFieldLineLimits2;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function22;
        final TextFieldDecorator textFieldDecorator2;
        final boolean z5;
        final boolean z6;
        final InputTransformation inputTransformation3;
        final TextStyle textStyle3;
        final Modifier modifier3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActionHandler keyboardActionHandler2;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final OutputTransformation outputTransformation2;
        final ScrollState scrollState2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function23;
        MutableInteractionSource mutableInteractionSource3;
        ScrollState scrollStateRememberScrollState;
        TextFieldLineLimits textFieldLineLimits3;
        OutputTransformation outputTransformation3;
        Brush brush3;
        TextFieldDecorator textFieldDecorator3;
        KeyboardActionHandler keyboardActionHandler3;
        TextStyle textStyle4;
        Composer composerStartRestartGroup = composer.startRestartGroup(469439921);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicTextField)N(state,modifier,enabled,readOnly,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,lineLimits,onTextLayout,interactionSource,cursorBrush,outputTransformation,decorator,scrollState)202@12315L610:BasicTextField.kt#423gt5");
        if ((i & 6) == 0) {
            textFieldState2 = textFieldState;
            i4 = (composerStartRestartGroup.changed(textFieldState2) ? 4 : 2) | i;
        } else {
            textFieldState2 = textFieldState;
            i4 = i;
        }
        int i24 = i3 & 2;
        if (i24 != 0) {
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
                    z3 = z;
                    i4 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
                }
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        z4 = z2;
                        i4 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                    }
                    i7 = i3 & 16;
                    int i25 = 8192;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            inputTransformation2 = inputTransformation;
                            i4 |= composerStartRestartGroup.changed(inputTransformation2) ? 16384 : 8192;
                        }
                        i8 = i3 & 32;
                        if (i8 != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            textStyle2 = textStyle;
                        } else {
                            textStyle2 = textStyle;
                            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i4 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                            }
                        }
                        i9 = i3 & 64;
                        if (i9 != 0) {
                            i4 |= 1572864;
                            keyboardOptions2 = keyboardOptions;
                        } else {
                            keyboardOptions2 = keyboardOptions;
                            if ((i & 1572864) == 0) {
                                i4 |= composerStartRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                            }
                        }
                        i10 = i3 & 128;
                        if (i10 != 0) {
                            i4 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i4 |= composerStartRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                        }
                        i11 = i3 & 256;
                        if (i11 != 0) {
                            i4 |= 100663296;
                        } else {
                            if ((i & 100663296) == 0) {
                                i12 = i11;
                                i4 |= composerStartRestartGroup.changed(textFieldLineLimits) ? 67108864 : 33554432;
                            }
                            i13 = i3 & 512;
                            if (i13 != 0) {
                                if ((i & 805306368) == 0) {
                                    i14 = i13;
                                    i4 |= composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                                }
                                i15 = i3 & 1024;
                                if (i15 != 0) {
                                    i17 = i2 | 6;
                                    i16 = i15;
                                } else if ((i2 & 6) == 0) {
                                    i16 = i15;
                                    i17 = i2 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                } else {
                                    i16 = i15;
                                    i17 = i2;
                                }
                                i18 = i3 & 2048;
                                if (i18 != 0) {
                                    i17 |= 48;
                                    i19 = i18;
                                } else if ((i2 & 48) == 0) {
                                    i19 = i18;
                                    i17 |= composerStartRestartGroup.changed(brush) ? 32 : 16;
                                } else {
                                    i19 = i18;
                                }
                                int i26 = i17;
                                i20 = i3 & 4096;
                                if (i20 != 0) {
                                    i21 = i26 | 384;
                                } else if ((i2 & 384) == 0) {
                                    i21 = i26 | (composerStartRestartGroup.changed(outputTransformation) ? 256 : 128);
                                } else {
                                    i21 = i26;
                                }
                                i22 = i3 & 8192;
                                if (i22 != 0) {
                                    i23 = i21 | 3072;
                                } else {
                                    int i27 = i21;
                                    if ((i2 & 3072) == 0) {
                                        i23 = i27 | ((i2 & 4096) == 0 ? composerStartRestartGroup.changed(textFieldDecorator) : composerStartRestartGroup.changedInstance(textFieldDecorator) ? 2048 : 1024);
                                    } else {
                                        i23 = i27;
                                    }
                                }
                                if ((i2 & 24576) == 0) {
                                    if ((i3 & 16384) == 0 && composerStartRestartGroup.changed(scrollState)) {
                                        i25 = 16384;
                                    }
                                    i23 |= i25;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i23 & 9363) == 9362) ? false : true, i4 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "198@12169L21");
                                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i24 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i5 != 0) {
                                            z3 = true;
                                        }
                                        if (i6 != 0) {
                                            z4 = false;
                                        }
                                        if (i7 != 0) {
                                            inputTransformation2 = null;
                                        }
                                        TextStyle textStyle5 = i8 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                                        if (i9 != 0) {
                                            keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                                        }
                                        KeyboardActionHandler keyboardActionHandler4 = i10 != 0 ? null : keyboardActionHandler;
                                        TextFieldLineLimits textFieldLineLimits4 = i12 != 0 ? TextFieldLineLimits.INSTANCE.getDefault() : textFieldLineLimits;
                                        function23 = i14 != 0 ? null : function2;
                                        mutableInteractionSource3 = i16 != 0 ? null : mutableInteractionSource;
                                        SolidColor cursorBrush = i19 != 0 ? BasicTextFieldDefaults.INSTANCE.getCursorBrush() : brush;
                                        OutputTransformation outputTransformation4 = i20 != 0 ? null : outputTransformation;
                                        TextFieldDecorator textFieldDecorator4 = i22 == 0 ? textFieldDecorator : null;
                                        if ((i3 & 16384) != 0) {
                                            i23 &= -57345;
                                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                        } else {
                                            scrollStateRememberScrollState = scrollState;
                                        }
                                        textFieldLineLimits3 = textFieldLineLimits4;
                                        outputTransformation3 = outputTransformation4;
                                        brush3 = cursorBrush;
                                        textFieldDecorator3 = textFieldDecorator4;
                                        keyboardActionHandler3 = keyboardActionHandler4;
                                        textStyle4 = textStyle5;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i3 & 16384) != 0) {
                                            i23 &= -57345;
                                        }
                                        textFieldLineLimits3 = textFieldLineLimits;
                                        function23 = function2;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        brush3 = brush;
                                        outputTransformation3 = outputTransformation;
                                        textFieldDecorator3 = textFieldDecorator;
                                        scrollStateRememberScrollState = scrollState;
                                        textStyle4 = textStyle2;
                                        keyboardActionHandler3 = keyboardActionHandler;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(469439921, i4, i23, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:201)");
                                    }
                                    int i28 = (i23 & 14) | 384 | (i23 & 112);
                                    int i29 = i23 << 3;
                                    InputTransformation inputTransformation4 = inputTransformation2;
                                    KeyboardOptions keyboardOptions4 = keyboardOptions2;
                                    MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                                    composer2 = composerStartRestartGroup;
                                    TextFieldState textFieldState3 = textFieldState2;
                                    Modifier modifier4 = modifier2;
                                    TextFieldLineLimits textFieldLineLimits5 = textFieldLineLimits3;
                                    BasicTextField(textFieldState3, modifier4, z3, z4, inputTransformation4, textStyle4, keyboardOptions4, keyboardActionHandler3, textFieldLineLimits5, function23, mutableInteractionSource4, brush3, null, outputTransformation3, textFieldDecorator3, scrollStateRememberScrollState, false, composer2, i4 & 2147483646, i28 | (i29 & 7168) | (57344 & i29) | (i29 & 458752), 65536);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    z5 = z3;
                                    z6 = z4;
                                    inputTransformation3 = inputTransformation4;
                                    textStyle3 = textStyle4;
                                    keyboardOptions3 = keyboardOptions4;
                                    keyboardActionHandler2 = keyboardActionHandler3;
                                    textFieldLineLimits2 = textFieldLineLimits5;
                                    function22 = function23;
                                    mutableInteractionSource2 = mutableInteractionSource4;
                                    brush2 = brush3;
                                    outputTransformation2 = outputTransformation3;
                                    textFieldDecorator2 = textFieldDecorator3;
                                    scrollState2 = scrollStateRememberScrollState;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    textFieldLineLimits2 = textFieldLineLimits;
                                    function22 = function2;
                                    textFieldDecorator2 = textFieldDecorator;
                                    z5 = z3;
                                    z6 = z4;
                                    inputTransformation3 = inputTransformation2;
                                    textStyle3 = textStyle2;
                                    modifier3 = modifier2;
                                    keyboardOptions3 = keyboardOptions2;
                                    keyboardActionHandler2 = keyboardActionHandler;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    brush2 = brush;
                                    outputTransformation2 = outputTransformation;
                                    scrollState2 = scrollState;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return BasicTextFieldKt.BasicTextField$lambda$0(textFieldState, modifier3, z5, z6, inputTransformation3, textStyle3, keyboardOptions3, keyboardActionHandler2, textFieldLineLimits2, function22, mutableInteractionSource2, brush2, outputTransformation2, textFieldDecorator2, scrollState2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i4 |= 805306368;
                            i14 = i13;
                            i15 = i3 & 1024;
                            if (i15 != 0) {
                            }
                            i18 = i3 & 2048;
                            if (i18 != 0) {
                            }
                            int i262 = i17;
                            i20 = i3 & 4096;
                            if (i20 != 0) {
                            }
                            i22 = i3 & 8192;
                            if (i22 != 0) {
                            }
                            if ((i2 & 24576) == 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i23 & 9363) == 9362) ? false : true, i4 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i12 = i11;
                        i13 = i3 & 512;
                        if (i13 != 0) {
                        }
                        i14 = i13;
                        i15 = i3 & 1024;
                        if (i15 != 0) {
                        }
                        i18 = i3 & 2048;
                        if (i18 != 0) {
                        }
                        int i2622 = i17;
                        i20 = i3 & 4096;
                        if (i20 != 0) {
                        }
                        i22 = i3 & 8192;
                        if (i22 != 0) {
                        }
                        if ((i2 & 24576) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i23 & 9363) == 9362) ? false : true, i4 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    inputTransformation2 = inputTransformation;
                    i8 = i3 & 32;
                    if (i8 != 0) {
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                    }
                    i10 = i3 & 128;
                    if (i10 != 0) {
                    }
                    i11 = i3 & 256;
                    if (i11 != 0) {
                    }
                    i12 = i11;
                    i13 = i3 & 512;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    i15 = i3 & 1024;
                    if (i15 != 0) {
                    }
                    i18 = i3 & 2048;
                    if (i18 != 0) {
                    }
                    int i26222 = i17;
                    i20 = i3 & 4096;
                    if (i20 != 0) {
                    }
                    i22 = i3 & 8192;
                    if (i22 != 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i23 & 9363) == 9362) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z4 = z2;
                i7 = i3 & 16;
                int i252 = 8192;
                if (i7 == 0) {
                }
                inputTransformation2 = inputTransformation;
                i8 = i3 & 32;
                if (i8 != 0) {
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                }
                i10 = i3 & 128;
                if (i10 != 0) {
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                }
                i12 = i11;
                i13 = i3 & 512;
                if (i13 != 0) {
                }
                i14 = i13;
                i15 = i3 & 1024;
                if (i15 != 0) {
                }
                i18 = i3 & 2048;
                if (i18 != 0) {
                }
                int i262222 = i17;
                i20 = i3 & 4096;
                if (i20 != 0) {
                }
                i22 = i3 & 8192;
                if (i22 != 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i23 & 9363) == 9362) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z3 = z;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            z4 = z2;
            i7 = i3 & 16;
            int i2522 = 8192;
            if (i7 == 0) {
            }
            inputTransformation2 = inputTransformation;
            i8 = i3 & 32;
            if (i8 != 0) {
            }
            i9 = i3 & 64;
            if (i9 != 0) {
            }
            i10 = i3 & 128;
            if (i10 != 0) {
            }
            i11 = i3 & 256;
            if (i11 != 0) {
            }
            i12 = i11;
            i13 = i3 & 512;
            if (i13 != 0) {
            }
            i14 = i13;
            i15 = i3 & 1024;
            if (i15 != 0) {
            }
            i18 = i3 & 2048;
            if (i18 != 0) {
            }
            int i2622222 = i17;
            i20 = i3 & 4096;
            if (i20 != 0) {
            }
            i22 = i3 & 8192;
            if (i22 != 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i23 & 9363) == 9362) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        z3 = z;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        z4 = z2;
        i7 = i3 & 16;
        int i25222 = 8192;
        if (i7 == 0) {
        }
        inputTransformation2 = inputTransformation;
        i8 = i3 & 32;
        if (i8 != 0) {
        }
        i9 = i3 & 64;
        if (i9 != 0) {
        }
        i10 = i3 & 128;
        if (i10 != 0) {
        }
        i11 = i3 & 256;
        if (i11 != 0) {
        }
        i12 = i11;
        i13 = i3 & 512;
        if (i13 != 0) {
        }
        i14 = i13;
        i15 = i3 & 1024;
        if (i15 != 0) {
        }
        i18 = i3 & 2048;
        if (i18 != 0) {
        }
        int i26222222 = i17;
        i20 = i3 & 4096;
        if (i20 != 0) {
        }
        i22 = i3 & 8192;
        if (i22 != 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i23 & 9363) == 9362) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x08a5  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x08ca  */
    /* JADX WARN: Removed duplicated region for block: B:390:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(final TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, MutableInteractionSource mutableInteractionSource, Brush brush, CodepointTransformation codepointTransformation, OutputTransformation outputTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState, boolean z3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        InputTransformation inputTransformation2;
        int i8;
        TextStyle textStyle2;
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
        final KeyboardOptions keyboardOptions2;
        final KeyboardActionHandler keyboardActionHandler2;
        final TextFieldLineLimits textFieldLineLimits2;
        final CodepointTransformation codepointTransformation2;
        final ScrollState scrollState2;
        final boolean z6;
        Composer composer2;
        final boolean z7;
        final InputTransformation inputTransformation3;
        final Modifier modifier3;
        final boolean z8;
        final TextStyle textStyle3;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function22;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final OutputTransformation outputTransformation2;
        final TextFieldDecorator textFieldDecorator2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        KeyboardOptions keyboardOptions3;
        KeyboardActionHandler keyboardActionHandler3;
        TextFieldLineLimits textFieldLineLimits3;
        MutableInteractionSource mutableInteractionSource3;
        CodepointTransformation codepointTransformation3;
        ScrollState scrollStateRememberScrollState;
        int i28;
        final TextFieldDecorator textFieldDecorator3;
        boolean z9;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function23;
        final boolean z10;
        final TextStyle textStyle4;
        final Brush brush3;
        final ScrollState scrollState3;
        boolean z11;
        int i29;
        OutputTransformation outputTransformation3;
        boolean z12;
        MutableInteractionSource mutableInteractionSource4;
        final boolean z13;
        LayoutDirection layoutDirection;
        final TextFieldLineLimits textFieldLineLimits4;
        Density density;
        SingleLineCodepointTransformation singleLineCodepointTransformation;
        KeyboardOptions keyboardOptions4;
        final PlatformSelectionBehaviors platformSelectionBehaviors;
        Density density2;
        boolean z14;
        Clipboard clipboard;
        final TransformedTextFieldState transformedTextFieldState;
        boolean z15;
        Composer composerStartRestartGroup = composer.startRestartGroup(965149429);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicTextField)N(state,modifier,enabled,readOnly,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,lineLimits,onTextLayout,interactionSource,cursorBrush,codepointTransformation,outputTransformation,decorator,scrollState,isPassword)252@14291L7,253@14346L7,259@14716L25,260@14790L25,264@15134L107,269@15278L846,287@16322L48,294@16698L24,303@17116L35,304@17194L7,306@17244L617,321@17914L7,322@17968L7,325@18014L2260,372@20280L256,379@20553L510,379@20542L521,395@21111L51,395@21069L93,397@21191L35,405@21528L1339,462@24584L3165:BasicTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(textFieldState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i30 = i3 & 2;
        if (i30 != 0) {
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
                        z5 = z2;
                        i4 |= composerStartRestartGroup.changed(z5) ? 2048 : 1024;
                    }
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            inputTransformation2 = inputTransformation;
                            i4 |= composerStartRestartGroup.changed(inputTransformation2) ? 16384 : 8192;
                        }
                        i8 = i3 & 32;
                        if (i8 != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            textStyle2 = textStyle;
                        } else {
                            textStyle2 = textStyle;
                            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i4 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                            }
                        }
                        i9 = i3 & 64;
                        if (i9 != 0) {
                            i4 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                        }
                        i10 = i3 & 128;
                        if (i10 != 0) {
                            i4 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i4 |= composerStartRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                        }
                        i11 = i3 & 256;
                        if (i11 != 0) {
                            i4 |= 100663296;
                        } else {
                            if ((i & 100663296) == 0) {
                                i12 = i11;
                                i4 |= composerStartRestartGroup.changed(textFieldLineLimits) ? 67108864 : 33554432;
                            }
                            i13 = i3 & 512;
                            if (i13 != 0) {
                                if ((i & 805306368) == 0) {
                                    i14 = i13;
                                    i4 |= composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                                }
                                i15 = i3 & 1024;
                                if (i15 != 0) {
                                    i17 = i2 | 6;
                                    i16 = i15;
                                } else if ((i2 & 6) == 0) {
                                    i16 = i15;
                                    i17 = i2 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                } else {
                                    i16 = i15;
                                    i17 = i2;
                                }
                                i18 = i3 & 2048;
                                if (i18 != 0) {
                                    i17 |= 48;
                                    i19 = i18;
                                } else if ((i2 & 48) == 0) {
                                    i19 = i18;
                                    i17 |= composerStartRestartGroup.changed(brush) ? 32 : 16;
                                } else {
                                    i19 = i18;
                                }
                                int i31 = i17;
                                i20 = i3 & 4096;
                                if (i20 != 0) {
                                    i21 = i31 | 384;
                                } else {
                                    int i32 = i31;
                                    if ((i2 & 384) == 0) {
                                        i32 |= composerStartRestartGroup.changed(codepointTransformation) ? 256 : 128;
                                    }
                                    i21 = i32;
                                }
                                i22 = i3 & 8192;
                                if (i22 != 0) {
                                    i23 = i21 | 3072;
                                } else {
                                    int i33 = i21;
                                    if ((i2 & 3072) == 0) {
                                        i23 = i33 | (composerStartRestartGroup.changed(outputTransformation) ? 2048 : 1024);
                                    } else {
                                        i23 = i33;
                                    }
                                }
                                i24 = i3 & 16384;
                                if (i24 != 0) {
                                    i25 = i23 | 24576;
                                } else {
                                    int i34 = i23;
                                    if ((i2 & 24576) == 0) {
                                        i25 = i34 | ((i2 & 32768) == 0 ? composerStartRestartGroup.changed(textFieldDecorator) : composerStartRestartGroup.changedInstance(textFieldDecorator) ? 16384 : 8192);
                                    } else {
                                        i25 = i34;
                                    }
                                }
                                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i25 |= ((i3 & 32768) == 0 && composerStartRestartGroup.changed(scrollState)) ? 131072 : 65536;
                                }
                                i26 = i3 & 65536;
                                if (i26 != 0) {
                                    i25 |= 1572864;
                                } else if ((i2 & 1572864) == 0) {
                                    i25 |= composerStartRestartGroup.changed(z3) ? 1048576 : 524288;
                                }
                                i27 = i25;
                                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i27 & 599187) == 599186) ? false : true, i4 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "247@14085L21");
                                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i30 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i5 != 0) {
                                            z4 = true;
                                        }
                                        if (i6 != 0) {
                                            z5 = false;
                                        }
                                        if (i7 != 0) {
                                            inputTransformation2 = null;
                                        }
                                        if (i8 != 0) {
                                            textStyle2 = TextStyle.INSTANCE.getDefault();
                                        }
                                        keyboardOptions3 = i9 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        keyboardActionHandler3 = i10 != 0 ? null : keyboardActionHandler;
                                        textFieldLineLimits3 = i12 != 0 ? TextFieldLineLimits.INSTANCE.getDefault() : textFieldLineLimits;
                                        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function24 = i14 != 0 ? null : function2;
                                        mutableInteractionSource3 = i16 != 0 ? null : mutableInteractionSource;
                                        SolidColor cursorBrush = i19 != 0 ? BasicTextFieldDefaults.INSTANCE.getCursorBrush() : brush;
                                        codepointTransformation3 = i20 != 0 ? null : codepointTransformation;
                                        OutputTransformation outputTransformation4 = i22 != 0 ? null : outputTransformation;
                                        TextFieldDecorator textFieldDecorator4 = i24 != 0 ? null : textFieldDecorator;
                                        if ((i3 & 32768) != 0) {
                                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                            i28 = i27 & (-458753);
                                        } else {
                                            scrollStateRememberScrollState = scrollState;
                                            i28 = i27;
                                        }
                                        textFieldDecorator3 = textFieldDecorator4;
                                        z9 = z4;
                                        function23 = function24;
                                        z10 = z5;
                                        textStyle4 = textStyle2;
                                        brush3 = cursorBrush;
                                        scrollState3 = scrollStateRememberScrollState;
                                        if (i26 != 0) {
                                            i29 = i28;
                                            z11 = false;
                                        } else {
                                            z11 = z3;
                                            i29 = i28;
                                        }
                                        outputTransformation3 = outputTransformation4;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i3 & 32768) != 0) {
                                            keyboardActionHandler3 = keyboardActionHandler;
                                            textFieldLineLimits3 = textFieldLineLimits;
                                            function23 = function2;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                            brush3 = brush;
                                            codepointTransformation3 = codepointTransformation;
                                            outputTransformation3 = outputTransformation;
                                            textFieldDecorator3 = textFieldDecorator;
                                            scrollState3 = scrollState;
                                            z11 = z3;
                                            z9 = z4;
                                            z10 = z5;
                                            textStyle4 = textStyle2;
                                            i29 = i27 & (-458753);
                                            keyboardOptions3 = keyboardOptions;
                                        } else {
                                            keyboardOptions3 = keyboardOptions;
                                            keyboardActionHandler3 = keyboardActionHandler;
                                            textFieldLineLimits3 = textFieldLineLimits;
                                            function23 = function2;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                            brush3 = brush;
                                            codepointTransformation3 = codepointTransformation;
                                            outputTransformation3 = outputTransformation;
                                            textFieldDecorator3 = textFieldDecorator;
                                            scrollState3 = scrollState;
                                            z11 = z3;
                                            z9 = z4;
                                            z10 = z5;
                                            textStyle4 = textStyle2;
                                            i29 = i27;
                                        }
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(965149429, i4, i29, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:251)");
                                    }
                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume = composerStartRestartGroup.consume(localDensity);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    Density density3 = (Density) objConsume;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    LayoutDirection layoutDirection2 = (LayoutDirection) objConsume2;
                                    final boolean zAreEqual = Intrinsics.areEqual(textFieldLineLimits3, TextFieldLineLimits.SingleLine.INSTANCE);
                                    if (mutableInteractionSource3 == null) {
                                        composerStartRestartGroup.startReplaceGroup(-2038132442);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "257@14551L39");
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -204293540, "CC(remember):BasicTextField.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        z12 = z11;
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        z12 = z11;
                                        composerStartRestartGroup.startReplaceGroup(-204294191);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    Orientation orientation = zAreEqual ? Orientation.Horizontal : Orientation.Vertical;
                                    MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                    KeyboardActionHandler keyboardActionHandler4 = keyboardActionHandler3;
                                    boolean zBooleanValue = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource5, composerStartRestartGroup, 0).getValue().booleanValue();
                                    final boolean zBooleanValue2 = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource5, composerStartRestartGroup, 0).getValue().booleanValue();
                                    if (zBooleanValue) {
                                        composerStartRestartGroup.startReplaceGroup(-204276540);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "263@15075L7");
                                        ProvidableCompositionLocal<WindowInfo> localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume3 = composerStartRestartGroup.consume(localWindowInfo);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        boolean zIsWindowFocused = ((WindowInfo) objConsume3).isWindowFocused();
                                        composerStartRestartGroup.endReplaceGroup();
                                        z13 = zIsWindowFocused;
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-2037604207);
                                        composerStartRestartGroup.endReplaceGroup();
                                        z13 = false;
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -204274816, "CC(remember):BasicTextField.kt#9igjgp");
                                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        layoutDirection = layoutDirection2;
                                        textFieldLineLimits4 = textFieldLineLimits3;
                                        density = density3;
                                        objRememberedValue2 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_LATEST, 2, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    } else {
                                        layoutDirection = layoutDirection2;
                                        textFieldLineLimits4 = textFieldLineLimits3;
                                        density = density3;
                                    }
                                    final MutableSharedFlow mutableSharedFlow = (MutableSharedFlow) objRememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -204269469, "CC(remember):BasicTextField.kt#9igjgp");
                                    boolean z16 = ((i4 & 14) == 4) | ((i29 & 896) == 256) | ((i29 & 7168) == 2048);
                                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (z16 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        if (codepointTransformation3 == null) {
                                            SingleLineCodepointTransformation singleLineCodepointTransformation2 = SingleLineCodepointTransformation.INSTANCE;
                                            if (!zAreEqual) {
                                                singleLineCodepointTransformation2 = null;
                                            }
                                            singleLineCodepointTransformation = singleLineCodepointTransformation2;
                                        } else {
                                            singleLineCodepointTransformation = codepointTransformation3;
                                        }
                                        objRememberedValue3 = new TransformedTextFieldState(textFieldState, inputTransformation2, singleLineCodepointTransformation, outputTransformation3);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    final TransformedTextFieldState transformedTextFieldState2 = (TransformedTextFieldState) objRememberedValue3;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -204236859, "CC(remember):BasicTextField.kt#9igjgp");
                                    boolean zChanged = composerStartRestartGroup.changed(transformedTextFieldState2);
                                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue4 = new TextLayoutState();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                    }
                                    final TextLayoutState textLayoutState = (TextLayoutState) objRememberedValue4;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    final KeyboardOptions keyboardOptionsFillUnspecifiedValuesWith$foundation = keyboardOptions3.fillUnspecifiedValuesWith$foundation(inputTransformation2 != null ? inputTransformation2.getKeyboardOptions() : null);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                                    Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue5 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                    }
                                    CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue5;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    if (ComposeFoundationFlags.isSmartSelectionEnabled) {
                                        composerStartRestartGroup.startReplaceGroup(-2035832304);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "299@16959L85");
                                        LocaleList localeList = textStyle4.getLocaleList();
                                        if (localeList == null) {
                                            localeList = LocaleList.INSTANCE.getCurrent();
                                        }
                                        keyboardOptions4 = keyboardOptions3;
                                        PlatformSelectionBehaviors platformSelectionBehaviorsRememberPlatformSelectionBehaviors = PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.EditableText, localeList, composerStartRestartGroup, 6);
                                        composerStartRestartGroup.endReplaceGroup();
                                        platformSelectionBehaviors = platformSelectionBehaviorsRememberPlatformSelectionBehaviors;
                                    } else {
                                        keyboardOptions4 = keyboardOptions3;
                                        composerStartRestartGroup.startReplaceGroup(-2035643855);
                                        composerStartRestartGroup.endReplaceGroup();
                                        platformSelectionBehaviors = null;
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -204211464, "CC(remember):BasicTextField.kt#9igjgp");
                                    Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue6 = new ToolbarRequesterImpl();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                    }
                                    final ToolbarRequesterImpl toolbarRequesterImpl = (ToolbarRequesterImpl) objRememberedValue6;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ProvidableCompositionLocal<Clipboard> localClipboard = CompositionLocalsKt.getLocalClipboard();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume4 = composerStartRestartGroup.consume(localClipboard);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    Clipboard clipboard2 = (Clipboard) objConsume4;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -204206786, "CC(remember):BasicTextField.kt#9igjgp");
                                    boolean zChanged2 = composerStartRestartGroup.changed(transformedTextFieldState2);
                                    Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue7 = new TextFieldSelectionState(transformedTextFieldState2, textLayoutState, density, z9, z10, z13, z12, toolbarRequesterImpl, coroutineScope, platformSelectionBehaviors, clipboard2);
                                        density2 = density;
                                        z14 = z12;
                                        clipboard = clipboard2;
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                    } else {
                                        z14 = z12;
                                        clipboard = clipboard2;
                                        density2 = density;
                                    }
                                    final TextFieldSelectionState textFieldSelectionState = (TextFieldSelectionState) objRememberedValue7;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
                                    OutputTransformation outputTransformation5 = outputTransformation3;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume5 = composerStartRestartGroup.consume(localHapticFeedback);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    final HapticFeedback hapticFeedback = (HapticFeedback) objConsume5;
                                    int i35 = i29;
                                    ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume6 = composerStartRestartGroup.consume(localTextToolbar);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    TextToolbar textToolbar = (TextToolbar) objConsume6;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -204180503, "CC(remember):BasicTextField.kt#9igjgp");
                                    boolean zChanged3 = composerStartRestartGroup.changed(coroutineScope) | composerStartRestartGroup.changed(textToolbar);
                                    Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged3 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue8 = new BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1(textToolbar, coroutineScope);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                    }
                                    final BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 basicTextFieldKt$BasicTextField$textToolbarHandler$1$1 = (BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1) objRememberedValue8;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda7
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return BasicTextFieldKt.BasicTextField$lambda$8(textFieldSelectionState, (AnnotatedString) obj);
                                        }
                                    };
                                    new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return TextFieldSelectionState.copyWithResult$foundation$default(textFieldSelectionState, false, 1, null);
                                        }
                                    };
                                    new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda9
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return textFieldSelectionState.cutWithResult();
                                        }
                                    };
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1197772674, "CC(rememberClipboardEventsHandler)N(onPaste,onCopy,onCut,isEnabled):ClipboardEventsHandler.jvm.kt#423gt5");
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -204101005, "CC(remember):BasicTextField.kt#9igjgp");
                                    final Density density4 = density2;
                                    boolean zChanged4 = ((i4 & 896) == 256) | composerStartRestartGroup.changed(transformedTextFieldState2) | ((57344 & i4) == 16384) | composerStartRestartGroup.changedInstance(textFieldSelectionState) | composerStartRestartGroup.changedInstance(hapticFeedback) | composerStartRestartGroup.changedInstance(clipboard) | composerStartRestartGroup.changed(basicTextFieldKt$BasicTextField$textToolbarHandler$1$1) | composerStartRestartGroup.changed(density2) | ((i4 & 7168) == 2048) | ((i35 & 3670016) == 1048576);
                                    Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged4 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                        final Clipboard clipboard3 = clipboard;
                                        final InputTransformation inputTransformation4 = inputTransformation2;
                                        final boolean z17 = z14;
                                        final boolean z18 = z9;
                                        final boolean z19 = z10;
                                        objRememberedValue9 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda10
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return BasicTextFieldKt.BasicTextField$lambda$11$0(transformedTextFieldState2, inputTransformation4, textFieldSelectionState, hapticFeedback, clipboard3, basicTextFieldKt$BasicTextField$textToolbarHandler$1$1, density4, z18, z19, z17);
                                            }
                                        };
                                        transformedTextFieldState = transformedTextFieldState2;
                                        z15 = z18;
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                                    } else {
                                        transformedTextFieldState = transformedTextFieldState2;
                                        z15 = z9;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    EffectsKt.SideEffect((Function0) objRememberedValue9, composerStartRestartGroup, 0);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -204083608, "CC(remember):BasicTextField.kt#9igjgp");
                                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                                    Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue10 = new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda12
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return BasicTextFieldKt.BasicTextField$lambda$12$0(textFieldSelectionState, (DisposableEffectScope) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    EffectsKt.DisposableEffect(textFieldSelectionState, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue10, composerStartRestartGroup, 0);
                                    OverscrollEffect overscrollEffectRememberTextFieldOverscrollEffect = TextFieldScroll_androidKt.rememberTextFieldOverscrollEffect(composerStartRestartGroup, 0);
                                    final boolean z20 = (z14 || KeyboardType.m8783equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m8802getPasswordPjHm6EE()) || KeyboardType.m8783equalsimpl0(keyboardOptions4.getKeyboardType(), KeyboardType.INSTANCE.m8801getNumberPasswordPjHm6EE())) ? false : true;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -204068976, "CC(remember):BasicTextField.kt#9igjgp");
                                    boolean zChanged5 = composerStartRestartGroup.changed(z20) | composerStartRestartGroup.changedInstance(mutableSharedFlow);
                                    Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged5 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue11 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda13
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return BasicTextFieldKt.BasicTextField$lambda$13$0(z20, mutableSharedFlow);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    final boolean z21 = z15;
                                    keyboardActionHandler2 = keyboardActionHandler4;
                                    final Orientation orientation2 = orientation;
                                    Modifier modifierAddContextMenuComponents = addContextMenuComponents(PointerIconKt.pointerHoverIcon$default(ScrollableKt.scrollable$default(StylusHandwritingKt.stylusHandwriting(modifier2, z15, z20, (Function0) objRememberedValue11).then(new TextFieldDecoratorModifier(transformedTextFieldState, textLayoutState, textFieldSelectionState, inputTransformation2, z21, z10, keyboardOptionsFillUnspecifiedValuesWith$foundation, keyboardActionHandler4, zAreEqual, mutableInteractionSource4, z14, mutableSharedFlow)), scrollState3, orientation2, overscrollEffectRememberTextFieldOverscrollEffect, z21 && textFieldSelectionState.getDirectDragGestureInitiator() == TextFieldSelectionState.InputType.None, ScrollableDefaults.INSTANCE.reverseDirection(layoutDirection, orientation, false), null, mutableInteractionSource4, null, WebmConstants.MkvEbmlElement.BLOCK_GROUP, null), PointerIcon.INSTANCE.getText(), false, 2, null), textFieldSelectionState, coroutineScope);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAddContextMenuComponents);
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
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1520421984, "C463@24701L3042,463@24651L3092:BasicTextField.kt#423gt5");
                                    ContextMenu_androidKt.ContextMenuArea(textFieldSelectionState, z21, ComposableLambdaKt.rememberComposableLambda(-673241599, true, new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return BasicTextFieldKt.BasicTextField$lambda$14$0(textFieldDecorator3, textFieldLineLimits4, textLayoutState, textStyle4, z13, zBooleanValue2, transformedTextFieldState, textFieldSelectionState, brush3, z21, z10, scrollState3, orientation2, toolbarRequesterImpl, platformSelectionBehaviors, zAreEqual, function23, keyboardOptionsFillUnspecifiedValuesWith$foundation, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 3) & 112) | 384);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    composerStartRestartGroup.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2 = composerStartRestartGroup;
                                    z7 = z21;
                                    inputTransformation3 = inputTransformation2;
                                    modifier3 = modifier2;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    keyboardOptions2 = keyboardOptions4;
                                    codepointTransformation2 = codepointTransformation3;
                                    z6 = z14;
                                    outputTransformation2 = outputTransformation5;
                                    textFieldDecorator2 = textFieldDecorator3;
                                    textFieldLineLimits2 = textFieldLineLimits4;
                                    textStyle3 = textStyle4;
                                    brush2 = brush3;
                                    z8 = z10;
                                    scrollState2 = scrollState3;
                                    function22 = function23;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    keyboardOptions2 = keyboardOptions;
                                    keyboardActionHandler2 = keyboardActionHandler;
                                    textFieldLineLimits2 = textFieldLineLimits;
                                    codepointTransformation2 = codepointTransformation;
                                    scrollState2 = scrollState;
                                    z6 = z3;
                                    composer2 = composerStartRestartGroup;
                                    z7 = z4;
                                    inputTransformation3 = inputTransformation2;
                                    modifier3 = modifier2;
                                    z8 = z5;
                                    textStyle3 = textStyle2;
                                    function22 = function2;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    brush2 = brush;
                                    outputTransformation2 = outputTransformation;
                                    textFieldDecorator2 = textFieldDecorator;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda15
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return BasicTextFieldKt.BasicTextField$lambda$15(textFieldState, modifier3, z7, z8, inputTransformation3, textStyle3, keyboardOptions2, keyboardActionHandler2, textFieldLineLimits2, function22, mutableInteractionSource2, brush2, codepointTransformation2, outputTransformation2, textFieldDecorator2, scrollState2, z6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i4 |= 805306368;
                            i14 = i13;
                            i15 = i3 & 1024;
                            if (i15 != 0) {
                            }
                            i18 = i3 & 2048;
                            if (i18 != 0) {
                            }
                            int i312 = i17;
                            i20 = i3 & 4096;
                            if (i20 != 0) {
                            }
                            i22 = i3 & 8192;
                            if (i22 != 0) {
                            }
                            i24 = i3 & 16384;
                            if (i24 != 0) {
                            }
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            }
                            i26 = i3 & 65536;
                            if (i26 != 0) {
                            }
                            i27 = i25;
                            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i27 & 599187) == 599186) ? false : true, i4 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i12 = i11;
                        i13 = i3 & 512;
                        if (i13 != 0) {
                        }
                        i14 = i13;
                        i15 = i3 & 1024;
                        if (i15 != 0) {
                        }
                        i18 = i3 & 2048;
                        if (i18 != 0) {
                        }
                        int i3122 = i17;
                        i20 = i3 & 4096;
                        if (i20 != 0) {
                        }
                        i22 = i3 & 8192;
                        if (i22 != 0) {
                        }
                        i24 = i3 & 16384;
                        if (i24 != 0) {
                        }
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        }
                        i26 = i3 & 65536;
                        if (i26 != 0) {
                        }
                        i27 = i25;
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i27 & 599187) == 599186) ? false : true, i4 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    inputTransformation2 = inputTransformation;
                    i8 = i3 & 32;
                    if (i8 != 0) {
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                    }
                    i10 = i3 & 128;
                    if (i10 != 0) {
                    }
                    i11 = i3 & 256;
                    if (i11 != 0) {
                    }
                    i12 = i11;
                    i13 = i3 & 512;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    i15 = i3 & 1024;
                    if (i15 != 0) {
                    }
                    i18 = i3 & 2048;
                    if (i18 != 0) {
                    }
                    int i31222 = i17;
                    i20 = i3 & 4096;
                    if (i20 != 0) {
                    }
                    i22 = i3 & 8192;
                    if (i22 != 0) {
                    }
                    i24 = i3 & 16384;
                    if (i24 != 0) {
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    i26 = i3 & 65536;
                    if (i26 != 0) {
                    }
                    i27 = i25;
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i27 & 599187) == 599186) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z5 = z2;
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                inputTransformation2 = inputTransformation;
                i8 = i3 & 32;
                if (i8 != 0) {
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                }
                i10 = i3 & 128;
                if (i10 != 0) {
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                }
                i12 = i11;
                i13 = i3 & 512;
                if (i13 != 0) {
                }
                i14 = i13;
                i15 = i3 & 1024;
                if (i15 != 0) {
                }
                i18 = i3 & 2048;
                if (i18 != 0) {
                }
                int i312222 = i17;
                i20 = i3 & 4096;
                if (i20 != 0) {
                }
                i22 = i3 & 8192;
                if (i22 != 0) {
                }
                i24 = i3 & 16384;
                if (i24 != 0) {
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i26 = i3 & 65536;
                if (i26 != 0) {
                }
                i27 = i25;
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i27 & 599187) == 599186) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            z5 = z2;
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            inputTransformation2 = inputTransformation;
            i8 = i3 & 32;
            if (i8 != 0) {
            }
            i9 = i3 & 64;
            if (i9 != 0) {
            }
            i10 = i3 & 128;
            if (i10 != 0) {
            }
            i11 = i3 & 256;
            if (i11 != 0) {
            }
            i12 = i11;
            i13 = i3 & 512;
            if (i13 != 0) {
            }
            i14 = i13;
            i15 = i3 & 1024;
            if (i15 != 0) {
            }
            i18 = i3 & 2048;
            if (i18 != 0) {
            }
            int i3122222 = i17;
            i20 = i3 & 4096;
            if (i20 != 0) {
            }
            i22 = i3 & 8192;
            if (i22 != 0) {
            }
            i24 = i3 & 16384;
            if (i24 != 0) {
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i26 = i3 & 65536;
            if (i26 != 0) {
            }
            i27 = i25;
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i27 & 599187) == 599186) ? false : true, i4 & 1)) {
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
        z5 = z2;
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        inputTransformation2 = inputTransformation;
        i8 = i3 & 32;
        if (i8 != 0) {
        }
        i9 = i3 & 64;
        if (i9 != 0) {
        }
        i10 = i3 & 128;
        if (i10 != 0) {
        }
        i11 = i3 & 256;
        if (i11 != 0) {
        }
        i12 = i11;
        i13 = i3 & 512;
        if (i13 != 0) {
        }
        i14 = i13;
        i15 = i3 & 1024;
        if (i15 != 0) {
        }
        i18 = i3 & 2048;
        if (i18 != 0) {
        }
        int i31222222 = i17;
        i20 = i3 & 4096;
        if (i20 != 0) {
        }
        i22 = i3 & 8192;
        if (i22 != 0) {
        }
        i24 = i3 & 16384;
        if (i24 != 0) {
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i26 = i3 & 65536;
        if (i26 != 0) {
        }
        i27 = i25;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i27 & 599187) == 599186) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:263:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, int i2, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        boolean z4;
        int i8;
        boolean z5;
        int i9;
        TextStyle textStyle2;
        int i10;
        KeyboardOptions keyboardOptions2;
        int i11;
        KeyboardActions keyboardActions2;
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
        final int i26;
        final VisualTransformation visualTransformation2;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        final boolean z6;
        final KeyboardActions keyboardActions3;
        final boolean z7;
        final TextStyle textStyle3;
        final KeyboardOptions keyboardOptions3;
        final Modifier modifier3;
        final boolean z8;
        final int i27;
        final Function1<? super TextLayoutResult, Unit> function13;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i28;
        Function1<? super TextLayoutResult, Unit> function14;
        MutableInteractionSource mutableInteractionSource3;
        boolean z9;
        int i29;
        SolidColor solidColor;
        boolean z10;
        int i30;
        int i31;
        VisualTransformation visualTransformation3;
        KeyboardOptions keyboardOptions4;
        KeyboardActions keyboardActions4;
        MutableInteractionSource mutableInteractionSource4;
        Brush brush3;
        boolean z11;
        TextStyle textStyle4;
        int i32;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> lambda$486633673$foundation;
        boolean z12;
        Function1<? super TextLayoutResult, Unit> function15;
        Function1<? super TextLayoutResult, Unit> function16;
        Composer composerStartRestartGroup = composer.startRestartGroup(-971111025);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,keyboardOptions,keyboardActions,singleLine,maxLines,minLines,visualTransformation,onTextLayout,interactionSource,cursorBrush,decorationBox)909@47938L90,907@47876L741:BasicTextField.kt#423gt5");
        if ((i3 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(textFieldValue) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i33 = i5 & 4;
        if (i33 != 0) {
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
                    z4 = z;
                    i6 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                i8 = i5 & 16;
                if (i8 != 0) {
                    i6 |= 24576;
                } else {
                    if ((i3 & 24576) == 0) {
                        z5 = z2;
                        i6 |= composerStartRestartGroup.changed(z5) ? 16384 : 8192;
                    }
                    i9 = i5 & 32;
                    if (i9 == 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        textStyle2 = textStyle;
                    } else {
                        textStyle2 = textStyle;
                        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i6 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                        }
                    }
                    i10 = i5 & 64;
                    if (i10 == 0) {
                        i6 |= 1572864;
                        keyboardOptions2 = keyboardOptions;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                        if ((i3 & 1572864) == 0) {
                            i6 |= composerStartRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                        }
                    }
                    i11 = i5 & 128;
                    if (i11 == 0) {
                        i6 |= 12582912;
                        keyboardActions2 = keyboardActions;
                    } else {
                        keyboardActions2 = keyboardActions;
                        if ((i3 & 12582912) == 0) {
                            i6 |= composerStartRestartGroup.changed(keyboardActions2) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i5 & 256;
                    if (i12 == 0) {
                        i6 |= 100663296;
                    } else if ((i3 & 100663296) == 0) {
                        i6 |= composerStartRestartGroup.changed(z3) ? 67108864 : 33554432;
                    }
                    if ((i3 & 805306368) == 0) {
                        i6 |= ((i5 & 512) == 0 && composerStartRestartGroup.changed(i)) ? 536870912 : 268435456;
                    }
                    i13 = i5 & 1024;
                    if (i13 == 0) {
                        i15 = i4 | 6;
                        i14 = i13;
                    } else if ((i4 & 6) == 0) {
                        i14 = i13;
                        i15 = i4 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
                    } else {
                        i14 = i13;
                        i15 = i4;
                    }
                    i16 = i5 & 2048;
                    if (i16 == 0) {
                        i15 |= 48;
                        i17 = i16;
                    } else if ((i4 & 48) == 0) {
                        i17 = i16;
                        i15 |= composerStartRestartGroup.changed(visualTransformation) ? 32 : 16;
                    } else {
                        i17 = i16;
                    }
                    int i34 = i15;
                    i18 = i5 & 4096;
                    if (i18 == 0) {
                        i19 = i34 | 384;
                    } else if ((i4 & 384) == 0) {
                        i19 = i34 | (composerStartRestartGroup.changedInstance(function12) ? 256 : 128);
                    } else {
                        i19 = i34;
                    }
                    i20 = i5 & 8192;
                    if (i20 == 0) {
                        i21 = i19 | 3072;
                    } else {
                        int i35 = i19;
                        if ((i4 & 3072) == 0) {
                            i21 = i35 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024);
                        } else {
                            i21 = i35;
                        }
                    }
                    i22 = i5 & 16384;
                    if (i22 != 0) {
                        i23 = i21;
                        if ((i4 & 24576) == 0) {
                            i23 |= composerStartRestartGroup.changed(brush) ? 16384 : 8192;
                        }
                        i24 = i5 & 32768;
                        if (i24 != 0) {
                            i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i23 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
                        }
                        i25 = i23;
                        if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (74899 & i25) == 74898) ? false : true, i6 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "901@47615L2");
                            if ((i3 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i33 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i7 != 0) {
                                    z4 = true;
                                }
                                if (i8 != 0) {
                                    z5 = false;
                                }
                                if (i9 != 0) {
                                    textStyle2 = TextStyle.INSTANCE.getDefault();
                                }
                                if (i10 != 0) {
                                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                                }
                                KeyboardActions keyboardActions5 = i11 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions2;
                                boolean z13 = i12 != 0 ? false : z3;
                                if ((i5 & 512) != 0) {
                                    i28 = z13 ? 1 : Integer.MAX_VALUE;
                                    i6 &= -1879048193;
                                } else {
                                    i28 = i;
                                }
                                int i36 = i14 != 0 ? 1 : i2;
                                VisualTransformation none = i17 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                KeyboardActions keyboardActions6 = keyboardActions5;
                                if (i18 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1229772655, "CC(remember):BasicTextField.kt#9igjgp");
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda11
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return BasicTextFieldKt.BasicTextField$lambda$26$0((TextLayoutResult) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    function14 = (Function1) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    function14 = function12;
                                }
                                MutableInteractionSource mutableInteractionSource5 = i20 != 0 ? null : mutableInteractionSource;
                                Function1<? super TextLayoutResult, Unit> function17 = function14;
                                if (i22 != 0) {
                                    mutableInteractionSource3 = mutableInteractionSource5;
                                    z9 = z13;
                                    i29 = i6;
                                    solidColor = new SolidColor(Color.INSTANCE.m6351getBlack0d7_KjU(), null);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource5;
                                    z9 = z13;
                                    i29 = i6;
                                    solidColor = brush;
                                }
                                if (i24 != 0) {
                                    boolean z14 = z5;
                                    lambda$486633673$foundation = ComposableSingletons$BasicTextFieldKt.INSTANCE.getLambda$486633673$foundation();
                                    keyboardOptions4 = keyboardOptions2;
                                    z11 = z14;
                                    z10 = z9;
                                    i30 = i28;
                                    i31 = i36;
                                    visualTransformation3 = none;
                                    keyboardActions4 = keyboardActions6;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    brush3 = solidColor;
                                    textStyle4 = textStyle2;
                                    i32 = i29;
                                } else {
                                    z10 = z9;
                                    i30 = i28;
                                    i31 = i36;
                                    visualTransformation3 = none;
                                    keyboardOptions4 = keyboardOptions2;
                                    keyboardActions4 = keyboardActions6;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    brush3 = solidColor;
                                    z11 = z5;
                                    textStyle4 = textStyle2;
                                    i32 = i29;
                                    lambda$486633673$foundation = function3;
                                }
                                z12 = z4;
                                function15 = function17;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i5 & 512) != 0) {
                                    i6 &= -1879048193;
                                }
                                z10 = z3;
                                i30 = i;
                                i31 = i2;
                                brush3 = brush;
                                i32 = i6;
                                keyboardActions4 = keyboardActions2;
                                textStyle4 = textStyle2;
                                keyboardOptions4 = keyboardOptions2;
                                visualTransformation3 = visualTransformation;
                                mutableInteractionSource4 = mutableInteractionSource;
                                z12 = z4;
                                z11 = z5;
                                function15 = function12;
                                lambda$486633673$foundation = function3;
                            }
                            composerStartRestartGroup.endDefaults();
                            VisualTransformation visualTransformation4 = visualTransformation3;
                            if (ComposerKt.isTraceInProgress()) {
                                function16 = function15;
                                ComposerKt.traceEventStart(-971111025, i32, i25, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:906)");
                            } else {
                                function16 = function15;
                            }
                            Modifier modifier4 = modifier2;
                            Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function33 = lambda$486633673$foundation;
                            ImeOptions imeOptions$foundation = keyboardOptions4.toImeOptions$foundation(z10);
                            boolean z15 = !z10;
                            Brush brush4 = brush3;
                            int i37 = z10 ? 1 : i31;
                            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                            int i38 = z10 ? 1 : i30;
                            KeyboardOptions keyboardOptions5 = keyboardOptions4;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1229762231, "CC(remember):BasicTextField.kt#9igjgp");
                            boolean z16 = ((i32 & 14) == 4) | ((i32 & 112) == 32);
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z16 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BasicTextFieldKt.BasicTextField$lambda$27$0(textFieldValue, function1, (TextFieldValue) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i39 = i25 << 9;
                            int i40 = ((i32 >> 6) & 7168) | (i32 & Videoio.CAP_OPENNI_ASUS) | (i39 & 57344) | (i39 & 458752) | (i39 & 3670016) | (i39 & 29360128);
                            int i41 = (i32 & 7168) | ((i32 >> 15) & 896) | (57344 & i32) | (i25 & 458752);
                            composer2 = composerStartRestartGroup;
                            TextStyle textStyle5 = textStyle4;
                            boolean z17 = z10;
                            Function1<? super TextLayoutResult, Unit> function18 = function16;
                            CoreTextFieldKt.CoreTextField(textFieldValue, (Function1) objRememberedValue2, modifier4, textStyle5, visualTransformation4, function18, mutableInteractionSource6, brush4, z15, i38, i37, imeOptions$foundation, keyboardActions4, z12, z11, function33, null, composer2, i40, i41, 65536);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            keyboardActions3 = keyboardActions4;
                            function32 = function33;
                            i26 = i30;
                            i27 = i31;
                            z8 = z17;
                            visualTransformation2 = visualTransformation4;
                            brush2 = brush4;
                            z6 = z12;
                            keyboardOptions3 = keyboardOptions5;
                            function13 = function18;
                            z7 = z11;
                            mutableInteractionSource2 = mutableInteractionSource6;
                            textStyle3 = textStyle5;
                            modifier3 = modifier4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            i26 = i;
                            visualTransformation2 = visualTransformation;
                            function32 = function3;
                            z6 = z4;
                            keyboardActions3 = keyboardActions2;
                            z7 = z5;
                            textStyle3 = textStyle2;
                            keyboardOptions3 = keyboardOptions2;
                            modifier3 = modifier2;
                            z8 = z3;
                            i27 = i2;
                            function13 = function12;
                            mutableInteractionSource2 = mutableInteractionSource;
                            brush2 = brush;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BasicTextFieldKt.BasicTextField$lambda$28(textFieldValue, function1, modifier3, z6, z7, textStyle3, keyboardOptions3, keyboardActions3, z8, i26, i27, visualTransformation2, function13, mutableInteractionSource2, brush2, function32, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i23 = i21 | 24576;
                    i24 = i5 & 32768;
                    if (i24 != 0) {
                    }
                    i25 = i23;
                    if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (74899 & i25) == 74898) ? false : true, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z5 = z2;
                i9 = i5 & 32;
                if (i9 == 0) {
                }
                i10 = i5 & 64;
                if (i10 == 0) {
                }
                i11 = i5 & 128;
                if (i11 == 0) {
                }
                i12 = i5 & 256;
                if (i12 == 0) {
                }
                if ((i3 & 805306368) == 0) {
                }
                i13 = i5 & 1024;
                if (i13 == 0) {
                }
                i16 = i5 & 2048;
                if (i16 == 0) {
                }
                int i342 = i15;
                i18 = i5 & 4096;
                if (i18 == 0) {
                }
                i20 = i5 & 8192;
                if (i20 == 0) {
                }
                i22 = i5 & 16384;
                if (i22 != 0) {
                }
                i24 = i5 & 32768;
                if (i24 != 0) {
                }
                i25 = i23;
                if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (74899 & i25) == 74898) ? false : true, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z;
            i8 = i5 & 16;
            if (i8 != 0) {
            }
            z5 = z2;
            i9 = i5 & 32;
            if (i9 == 0) {
            }
            i10 = i5 & 64;
            if (i10 == 0) {
            }
            i11 = i5 & 128;
            if (i11 == 0) {
            }
            i12 = i5 & 256;
            if (i12 == 0) {
            }
            if ((i3 & 805306368) == 0) {
            }
            i13 = i5 & 1024;
            if (i13 == 0) {
            }
            i16 = i5 & 2048;
            if (i16 == 0) {
            }
            int i3422 = i15;
            i18 = i5 & 4096;
            if (i18 == 0) {
            }
            i20 = i5 & 8192;
            if (i20 == 0) {
            }
            i22 = i5 & 16384;
            if (i22 != 0) {
            }
            i24 = i5 & 32768;
            if (i24 != 0) {
            }
            i25 = i23;
            if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (74899 & i25) == 74898) ? false : true, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 8;
        if (i7 == 0) {
        }
        z4 = z;
        i8 = i5 & 16;
        if (i8 != 0) {
        }
        z5 = z2;
        i9 = i5 & 32;
        if (i9 == 0) {
        }
        i10 = i5 & 64;
        if (i10 == 0) {
        }
        i11 = i5 & 128;
        if (i11 == 0) {
        }
        i12 = i5 & 256;
        if (i12 == 0) {
        }
        if ((i3 & 805306368) == 0) {
        }
        i13 = i5 & 1024;
        if (i13 == 0) {
        }
        i16 = i5 & 2048;
        if (i16 == 0) {
        }
        int i34222 = i15;
        i18 = i5 & 4096;
        if (i18 == 0) {
        }
        i20 = i5 & 8192;
        if (i20 == 0) {
        }
        i22 = i5 & 16384;
        if (i22 != 0) {
        }
        i24 = i5 & 32768;
        if (i24 != 0) {
        }
        i25 = i23;
        if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (74899 & i25) == 74898) ? false : true, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:225:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011d  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void BasicTextField(final TextFieldValue textFieldValue, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, Composer composer, final int i2, final int i3, final int i4) {
        TextFieldValue textFieldValue2;
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        TextStyle textStyle2;
        int i9;
        KeyboardOptions keyboardOptions2;
        int i10;
        KeyboardActions keyboardActions2;
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
        Composer composer2;
        final boolean z4;
        final boolean z5;
        final boolean z6;
        final Function1 function13;
        final MutableInteractionSource mutableInteractionSource2;
        final TextStyle textStyle3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final Modifier modifier3;
        final int i25;
        final VisualTransformation visualTransformation2;
        final Brush brush2;
        final Function3 function32;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function1 function14;
        int i26;
        MutableInteractionSource mutableInteractionSource3;
        Brush solidColor;
        int i27;
        Composer composerStartRestartGroup = composer.startRestartGroup(1742344466);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,keyboardOptions,keyboardActions,singleLine,maxLines,visualTransformation,onTextLayout,interactionSource,cursorBrush,decorationBox)985@50780L2,986@50834L39,991@51075L580:BasicTextField.kt#423gt5");
        if ((i2 & 6) == 0) {
            textFieldValue2 = textFieldValue;
            i5 = (composerStartRestartGroup.changed(textFieldValue2) ? 4 : 2) | i2;
        } else {
            textFieldValue2 = textFieldValue;
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i28 = i4 & 4;
        if (i28 != 0) {
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
                    i5 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((i2 & 24576) == 0) {
                        i5 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
                    }
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        textStyle2 = textStyle;
                    } else {
                        textStyle2 = textStyle;
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i5 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                        }
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        keyboardOptions2 = keyboardOptions;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                        if ((i2 & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                        }
                    }
                    i10 = i4 & 128;
                    if (i10 == 0) {
                        i5 |= 12582912;
                        keyboardActions2 = keyboardActions;
                    } else {
                        keyboardActions2 = keyboardActions;
                        if ((i2 & 12582912) == 0) {
                            i5 |= composerStartRestartGroup.changed(keyboardActions2) ? 8388608 : 4194304;
                        }
                    }
                    i11 = i4 & 256;
                    if (i11 == 0) {
                        i5 |= 100663296;
                    } else if ((i2 & 100663296) == 0) {
                        i5 |= composerStartRestartGroup.changed(z3) ? 67108864 : 33554432;
                    }
                    i12 = i4 & 512;
                    if (i12 != 0) {
                        if ((i2 & 805306368) == 0) {
                            i13 = i12;
                            i5 |= composerStartRestartGroup.changed(i) ? 536870912 : 268435456;
                        }
                        i14 = i4 & 1024;
                        if (i14 != 0) {
                            i16 = i3 | 6;
                            i15 = i14;
                        } else if ((i3 & 6) == 0) {
                            i15 = i14;
                            i16 = i3 | (composerStartRestartGroup.changed(visualTransformation) ? 4 : 2);
                        } else {
                            i15 = i14;
                            i16 = i3;
                        }
                        i17 = i4 & 2048;
                        if (i17 != 0) {
                            i16 |= 48;
                            i18 = i17;
                        } else if ((i3 & 48) == 0) {
                            i18 = i17;
                            i16 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
                        } else {
                            i18 = i17;
                        }
                        int i29 = i16;
                        i19 = i4 & 4096;
                        if (i19 != 0) {
                            i20 = i29 | 384;
                        } else {
                            int i30 = i29;
                            if ((i3 & 384) == 0) {
                                i30 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
                            }
                            i20 = i30;
                        }
                        i21 = i4 & 8192;
                        if (i21 != 0) {
                            i22 = i20 | 3072;
                        } else {
                            int i31 = i20;
                            if ((i3 & 3072) == 0) {
                                i22 = i31 | (composerStartRestartGroup.changed(brush) ? 2048 : 1024);
                            } else {
                                i22 = i31;
                            }
                        }
                        i23 = i4 & 16384;
                        if (i23 != 0) {
                            i24 = i22 | 24576;
                        } else {
                            int i32 = i22;
                            if ((i3 & 24576) == 0) {
                                i32 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
                            }
                            i24 = i32;
                        }
                        if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i24 & 9363) == 9362) ? false : true, i5 & 1)) {
                            Modifier modifier4 = i28 != 0 ? Modifier.INSTANCE : modifier2;
                            boolean z7 = i6 != 0 ? true : z;
                            boolean z8 = i7 != 0 ? false : z2;
                            TextStyle textStyle4 = i8 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                            KeyboardOptions keyboardOptions4 = i9 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions2;
                            KeyboardActions keyboardActions4 = i10 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions2;
                            boolean z9 = i11 != 0 ? false : z3;
                            int i33 = i13 != 0 ? Integer.MAX_VALUE : i;
                            VisualTransformation none = i15 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                            if (i18 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -644195948, "CC(remember):BasicTextField.kt#9igjgp");
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda25
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return BasicTextFieldKt.BasicTextField$lambda$32$0((TextLayoutResult) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function14 = (Function1) objRememberedValue;
                            } else {
                                function14 = function12;
                            }
                            if (i19 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -644194183, "CC(remember):BasicTextField.kt#9igjgp");
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue2;
                                i26 = i21;
                            } else {
                                i26 = i21;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if (i26 != 0) {
                                composer2 = composerStartRestartGroup;
                                solidColor = new SolidColor(Color.INSTANCE.m6351getBlack0d7_KjU(), null);
                                i27 = i23;
                            } else {
                                composer2 = composerStartRestartGroup;
                                solidColor = brush;
                                i27 = i23;
                            }
                            Function3 function3M2385getLambda$665310900$foundation = i27 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m2385getLambda$665310900$foundation() : function3;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1742344466, i5, i24, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:990)");
                            }
                            int i34 = i24 << 3;
                            boolean z10 = z8;
                            BasicTextField(textFieldValue2, (Function1<? super TextFieldValue, Unit>) function1, modifier4, z7, z10, textStyle4, keyboardOptions4, keyboardActions4, z9, i33, 1, none, (Function1<? super TextLayoutResult, Unit>) function14, mutableInteractionSource3, solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) function3M2385getLambda$665310900$foundation, composer2, i5 & 2147483646, (i34 & 112) | 6 | (i34 & 896) | (i34 & 7168) | (57344 & i34) | (i34 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z4 = z7;
                            z5 = z10;
                            textStyle3 = textStyle4;
                            keyboardOptions3 = keyboardOptions4;
                            keyboardActions3 = keyboardActions4;
                            z6 = z9;
                            i25 = i33;
                            visualTransformation2 = none;
                            function13 = function14;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            brush2 = solidColor;
                            function32 = function3M2385getLambda$665310900$foundation;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            z4 = z;
                            z5 = z2;
                            z6 = z3;
                            function13 = function12;
                            mutableInteractionSource2 = mutableInteractionSource;
                            textStyle3 = textStyle2;
                            keyboardOptions3 = keyboardOptions2;
                            keyboardActions3 = keyboardActions2;
                            modifier3 = modifier2;
                            i25 = i;
                            visualTransformation2 = visualTransformation;
                            brush2 = brush;
                            function32 = function3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BasicTextFieldKt.BasicTextField$lambda$34(textFieldValue, function1, modifier3, z4, z5, textStyle3, keyboardOptions3, keyboardActions3, z6, i25, visualTransformation2, function13, mutableInteractionSource2, brush2, function32, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i5 |= 805306368;
                    i13 = i12;
                    i14 = i4 & 1024;
                    if (i14 != 0) {
                    }
                    i17 = i4 & 2048;
                    if (i17 != 0) {
                    }
                    int i292 = i16;
                    i19 = i4 & 4096;
                    if (i19 != 0) {
                    }
                    i21 = i4 & 8192;
                    if (i21 != 0) {
                    }
                    i23 = i4 & 16384;
                    if (i23 != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i24 & 9363) == 9362) ? false : true, i5 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                i10 = i4 & 128;
                if (i10 == 0) {
                }
                i11 = i4 & 256;
                if (i11 == 0) {
                }
                i12 = i4 & 512;
                if (i12 != 0) {
                }
                i13 = i12;
                i14 = i4 & 1024;
                if (i14 != 0) {
                }
                i17 = i4 & 2048;
                if (i17 != 0) {
                }
                int i2922 = i16;
                i19 = i4 & 4096;
                if (i19 != 0) {
                }
                i21 = i4 & 8192;
                if (i21 != 0) {
                }
                i23 = i4 & 16384;
                if (i23 != 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i24 & 9363) == 9362) ? false : true, i5 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            i10 = i4 & 128;
            if (i10 == 0) {
            }
            i11 = i4 & 256;
            if (i11 == 0) {
            }
            i12 = i4 & 512;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i4 & 1024;
            if (i14 != 0) {
            }
            i17 = i4 & 2048;
            if (i17 != 0) {
            }
            int i29222 = i16;
            i19 = i4 & 4096;
            if (i19 != 0) {
            }
            i21 = i4 & 8192;
            if (i21 != 0) {
            }
            i23 = i4 & 16384;
            if (i23 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i24 & 9363) == 9362) ? false : true, i5 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        i10 = i4 & 128;
        if (i10 == 0) {
        }
        i11 = i4 & 256;
        if (i11 == 0) {
        }
        i12 = i4 & 512;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i4 & 1024;
        if (i14 != 0) {
        }
        i17 = i4 & 2048;
        if (i17 != 0) {
        }
        int i292222 = i16;
        i19 = i4 & 4096;
        if (i19 != 0) {
        }
        i21 = i4 & 8192;
        if (i21 != 0) {
        }
        i23 = i4 & 16384;
        if (i23 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i24 & 9363) == 9362) ? false : true, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:278:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(final String str, final Function1<? super String, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, int i2, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        boolean z4;
        int i8;
        boolean z5;
        int i9;
        TextStyle textStyle2;
        int i10;
        KeyboardOptions keyboardOptions2;
        int i11;
        final KeyboardActions keyboardActions2;
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
        final boolean z6;
        final int i26;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        final boolean z7;
        final KeyboardOptions keyboardOptions3;
        final boolean z8;
        final TextStyle textStyle3;
        final Modifier modifier3;
        final int i27;
        final VisualTransformation visualTransformation2;
        final Function1<? super TextLayoutResult, Unit> function13;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i28;
        KeyboardActions keyboardActions3;
        Function1<? super TextLayoutResult, Unit> function14;
        MutableInteractionSource mutableInteractionSource3;
        int i29;
        SolidColor solidColor;
        KeyboardActions keyboardActions4;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> lambda$759698998$foundation;
        boolean z9;
        int i30;
        int i31;
        boolean z10;
        boolean z11;
        TextStyle textStyle4;
        Modifier modifier4;
        VisualTransformation visualTransformation3;
        Function1<? super TextLayoutResult, Unit> function15;
        Brush brush3;
        KeyboardOptions keyboardOptions4;
        MutableInteractionSource mutableInteractionSource4;
        int i32;
        Modifier modifier5;
        boolean z12;
        Object objRememberedValue;
        final MutableState mutableState;
        boolean zChanged;
        Object objRememberedValue2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2026950908);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,keyboardOptions,keyboardActions,singleLine,maxLines,minLines,visualTransformation,onTextLayout,interactionSource,cursorBrush,decorationBox)752@39049L57,758@39402L242,758@39391L253,769@39965L41,773@40083L373,771@40012L1033:BasicTextField.kt#423gt5");
        if ((i3 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i33 = i5 & 4;
        if (i33 != 0) {
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
                    z4 = z;
                    i6 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                i8 = i5 & 16;
                if (i8 != 0) {
                    i6 |= 24576;
                } else {
                    if ((i3 & 24576) == 0) {
                        z5 = z2;
                        i6 |= composerStartRestartGroup.changed(z5) ? 16384 : 8192;
                    }
                    i9 = i5 & 32;
                    if (i9 == 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        textStyle2 = textStyle;
                    } else {
                        textStyle2 = textStyle;
                        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i6 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                        }
                    }
                    i10 = i5 & 64;
                    if (i10 == 0) {
                        i6 |= 1572864;
                        keyboardOptions2 = keyboardOptions;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                        if ((i3 & 1572864) == 0) {
                            i6 |= composerStartRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                        }
                    }
                    i11 = i5 & 128;
                    if (i11 == 0) {
                        i6 |= 12582912;
                        keyboardActions2 = keyboardActions;
                    } else {
                        keyboardActions2 = keyboardActions;
                        if ((i3 & 12582912) == 0) {
                            i6 |= composerStartRestartGroup.changed(keyboardActions2) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i5 & 256;
                    if (i12 == 0) {
                        i6 |= 100663296;
                    } else if ((i3 & 100663296) == 0) {
                        i6 |= composerStartRestartGroup.changed(z3) ? 67108864 : 33554432;
                    }
                    if ((i3 & 805306368) == 0) {
                        i6 |= ((i5 & 512) == 0 && composerStartRestartGroup.changed(i)) ? 536870912 : 268435456;
                    }
                    i13 = i5 & 1024;
                    if (i13 == 0) {
                        i15 = i4 | 6;
                        i14 = i13;
                    } else if ((i4 & 6) == 0) {
                        i14 = i13;
                        i15 = i4 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
                    } else {
                        i14 = i13;
                        i15 = i4;
                    }
                    i16 = i5 & 2048;
                    if (i16 == 0) {
                        i15 |= 48;
                        i17 = i16;
                    } else if ((i4 & 48) == 0) {
                        i17 = i16;
                        i15 |= composerStartRestartGroup.changed(visualTransformation) ? 32 : 16;
                    } else {
                        i17 = i16;
                    }
                    int i34 = i15;
                    i18 = i5 & 4096;
                    if (i18 == 0) {
                        i19 = i34 | 384;
                    } else if ((i4 & 384) == 0) {
                        i19 = i34 | (composerStartRestartGroup.changedInstance(function12) ? 256 : 128);
                    } else {
                        i19 = i34;
                    }
                    i20 = i5 & 8192;
                    if (i20 == 0) {
                        i21 = i19 | 3072;
                    } else {
                        int i35 = i19;
                        if ((i4 & 3072) == 0) {
                            i21 = i35 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024);
                        } else {
                            i21 = i35;
                        }
                    }
                    i22 = i5 & 16384;
                    if (i22 != 0) {
                        i23 = i21;
                        if ((i4 & 24576) == 0) {
                            i23 |= composerStartRestartGroup.changed(brush) ? 16384 : 8192;
                        }
                        i24 = i5 & 32768;
                        if (i24 != 0) {
                            i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i23 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
                        }
                        i25 = i23;
                        if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (74899 & i25) == 74898) ? false : true, i6 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "744@38634L2");
                            if ((i3 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i33 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i7 != 0) {
                                    z4 = true;
                                }
                                if (i8 != 0) {
                                    z5 = false;
                                }
                                if (i9 != 0) {
                                    textStyle2 = TextStyle.INSTANCE.getDefault();
                                }
                                if (i10 != 0) {
                                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                                }
                                KeyboardActions keyboardActions5 = i11 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions2;
                                boolean z13 = i12 != 0 ? false : z3;
                                if ((i5 & 512) != 0) {
                                    i28 = z13 ? 1 : Integer.MAX_VALUE;
                                    i6 &= -1879048193;
                                } else {
                                    i28 = i;
                                }
                                int i36 = i14 != 0 ? 1 : i2;
                                VisualTransformation none = i17 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                if (i18 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015311170, "CC(remember):BasicTextField.kt#9igjgp");
                                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    keyboardActions3 = keyboardActions5;
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return BasicTextFieldKt.BasicTextField$lambda$16$0((TextLayoutResult) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    function14 = (Function1) objRememberedValue3;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    keyboardActions3 = keyboardActions5;
                                    function14 = function12;
                                }
                                MutableInteractionSource mutableInteractionSource5 = i20 != 0 ? null : mutableInteractionSource;
                                Function1<? super TextLayoutResult, Unit> function16 = function14;
                                if (i22 != 0) {
                                    mutableInteractionSource3 = mutableInteractionSource5;
                                    i29 = i6;
                                    solidColor = new SolidColor(Color.INSTANCE.m6351getBlack0d7_KjU(), null);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource5;
                                    i29 = i6;
                                    solidColor = brush;
                                }
                                if (i24 != 0) {
                                    i6 = i29;
                                    lambda$759698998$foundation = ComposableSingletons$BasicTextFieldKt.INSTANCE.getLambda$759698998$foundation();
                                    z9 = z13;
                                    i30 = i28;
                                    i31 = i36;
                                    z10 = z4;
                                    z11 = z5;
                                    textStyle4 = textStyle2;
                                    modifier4 = modifier2;
                                    visualTransformation3 = none;
                                    keyboardActions4 = keyboardActions3;
                                } else {
                                    keyboardActions4 = keyboardActions3;
                                    i6 = i29;
                                    lambda$759698998$foundation = function3;
                                    z9 = z13;
                                    i30 = i28;
                                    i31 = i36;
                                    z10 = z4;
                                    z11 = z5;
                                    textStyle4 = textStyle2;
                                    modifier4 = modifier2;
                                    visualTransformation3 = none;
                                }
                                function15 = function16;
                                brush3 = solidColor;
                                keyboardOptions4 = keyboardOptions2;
                                mutableInteractionSource4 = mutableInteractionSource3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i5 & 512) != 0) {
                                    i6 &= -1879048193;
                                }
                                z9 = z3;
                                i30 = i;
                                i31 = i2;
                                visualTransformation3 = visualTransformation;
                                lambda$759698998$foundation = function3;
                                keyboardActions4 = keyboardActions2;
                                z10 = z4;
                                keyboardOptions4 = keyboardOptions2;
                                z11 = z5;
                                textStyle4 = textStyle2;
                                modifier4 = modifier2;
                                function15 = function12;
                                mutableInteractionSource4 = mutableInteractionSource;
                                brush3 = brush;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2026950908, i6, i25, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:749)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015297835, "CC(remember):BasicTextField.kt#9igjgp");
                            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                i32 = i25;
                                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                i32 = i25;
                            }
                            final MutableState mutableState2 = (MutableState) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final TextFieldValue textFieldValueM8808copy3r_uNRQ$default = TextFieldValue.m8808copy3r_uNRQ$default(BasicTextField$lambda$18(mutableState2), str, 0L, (TextRange) null, 6, (Object) null);
                            KeyboardActions keyboardActions6 = keyboardActions4;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015286354, "CC(remember):BasicTextField.kt#9igjgp");
                            boolean zChanged2 = composerStartRestartGroup.changed(textFieldValueM8808copy3r_uNRQ$default);
                            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (zChanged2) {
                                modifier5 = modifier4;
                            } else {
                                modifier5 = modifier4;
                                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                EffectsKt.SideEffect((Function0) objRememberedValue5, composerStartRestartGroup, 0);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015268539, "CC(remember):BasicTextField.kt#9igjgp");
                                z12 = (i6 & 14) != 4;
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z12 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableState = (MutableState) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ImeOptions imeOptions$foundation = keyboardOptions4.toImeOptions$foundation(z9);
                                boolean z14 = !z9;
                                int i37 = i32;
                                int i38 = !z9 ? 1 : i31;
                                int i39 = !z9 ? 1 : i30;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015264431, "CC(remember):BasicTextField.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(mutableState) | ((i6 & 112) == 32);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return BasicTextFieldKt.BasicTextField$lambda$24$0(function1, mutableState2, mutableState, (TextFieldValue) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                int i40 = i37 << 9;
                                Modifier modifier6 = modifier5;
                                composer2 = composerStartRestartGroup;
                                CoreTextFieldKt.CoreTextField(textFieldValueM8808copy3r_uNRQ$default, (Function1) objRememberedValue2, modifier6, textStyle4, visualTransformation3, function15, mutableInteractionSource4, brush3, z14, i39, i38, imeOptions$foundation, keyboardActions6, z10, z11, lambda$759698998$foundation, null, composer2, (i6 & 896) | ((i6 >> 6) & 7168) | (57344 & i40) | (458752 & i40) | (3670016 & i40) | (i40 & 29360128), ((i6 >> 15) & 896) | (i6 & 7168) | (i6 & 57344) | (i37 & 458752), 65536);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                keyboardOptions3 = keyboardOptions4;
                                modifier3 = modifier6;
                                textStyle3 = textStyle4;
                                mutableInteractionSource2 = mutableInteractionSource4;
                                brush2 = brush3;
                                keyboardActions2 = keyboardActions6;
                                z7 = z10;
                                function32 = lambda$759698998$foundation;
                                z6 = z9;
                                visualTransformation2 = visualTransformation3;
                                function13 = function15;
                                z8 = z11;
                                i26 = i30;
                                i27 = i31;
                            }
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return BasicTextFieldKt.BasicTextField$lambda$20$0(textFieldValueM8808copy3r_uNRQ$default, mutableState2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.SideEffect((Function0) objRememberedValue5, composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015268539, "CC(remember):BasicTextField.kt#9igjgp");
                            if ((i6 & 14) != 4) {
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z12) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                mutableState = (MutableState) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ImeOptions imeOptions$foundation2 = keyboardOptions4.toImeOptions$foundation(z9);
                                boolean z142 = !z9;
                                int i372 = i32;
                                if (!z9) {
                                }
                                if (!z9) {
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015264431, "CC(remember):BasicTextField.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(mutableState) | ((i6 & 112) == 32);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged) {
                                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return BasicTextFieldKt.BasicTextField$lambda$24$0(function1, mutableState2, mutableState, (TextFieldValue) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    int i402 = i372 << 9;
                                    Modifier modifier62 = modifier5;
                                    composer2 = composerStartRestartGroup;
                                    CoreTextFieldKt.CoreTextField(textFieldValueM8808copy3r_uNRQ$default, (Function1) objRememberedValue2, modifier62, textStyle4, visualTransformation3, function15, mutableInteractionSource4, brush3, z142, i39, i38, imeOptions$foundation2, keyboardActions6, z10, z11, lambda$759698998$foundation, null, composer2, (i6 & 896) | ((i6 >> 6) & 7168) | (57344 & i402) | (458752 & i402) | (3670016 & i402) | (i402 & 29360128), ((i6 >> 15) & 896) | (i6 & 7168) | (i6 & 57344) | (i372 & 458752), 65536);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    keyboardOptions3 = keyboardOptions4;
                                    modifier3 = modifier62;
                                    textStyle3 = textStyle4;
                                    mutableInteractionSource2 = mutableInteractionSource4;
                                    brush2 = brush3;
                                    keyboardActions2 = keyboardActions6;
                                    z7 = z10;
                                    function32 = lambda$759698998$foundation;
                                    z6 = z9;
                                    visualTransformation2 = visualTransformation3;
                                    function13 = function15;
                                    z8 = z11;
                                    i26 = i30;
                                    i27 = i31;
                                }
                            }
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            z6 = z3;
                            i26 = i;
                            function32 = function3;
                            z7 = z4;
                            keyboardOptions3 = keyboardOptions2;
                            z8 = z5;
                            textStyle3 = textStyle2;
                            modifier3 = modifier2;
                            i27 = i2;
                            visualTransformation2 = visualTransformation;
                            function13 = function12;
                            mutableInteractionSource2 = mutableInteractionSource;
                            brush2 = brush;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BasicTextFieldKt.BasicTextField$lambda$25(str, function1, modifier3, z7, z8, textStyle3, keyboardOptions3, keyboardActions2, z6, i26, i27, visualTransformation2, function13, mutableInteractionSource2, brush2, function32, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i23 = i21 | 24576;
                    i24 = i5 & 32768;
                    if (i24 != 0) {
                    }
                    i25 = i23;
                    if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (74899 & i25) == 74898) ? false : true, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z5 = z2;
                i9 = i5 & 32;
                if (i9 == 0) {
                }
                i10 = i5 & 64;
                if (i10 == 0) {
                }
                i11 = i5 & 128;
                if (i11 == 0) {
                }
                i12 = i5 & 256;
                if (i12 == 0) {
                }
                if ((i3 & 805306368) == 0) {
                }
                i13 = i5 & 1024;
                if (i13 == 0) {
                }
                i16 = i5 & 2048;
                if (i16 == 0) {
                }
                int i342 = i15;
                i18 = i5 & 4096;
                if (i18 == 0) {
                }
                i20 = i5 & 8192;
                if (i20 == 0) {
                }
                i22 = i5 & 16384;
                if (i22 != 0) {
                }
                i24 = i5 & 32768;
                if (i24 != 0) {
                }
                i25 = i23;
                if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (74899 & i25) == 74898) ? false : true, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z;
            i8 = i5 & 16;
            if (i8 != 0) {
            }
            z5 = z2;
            i9 = i5 & 32;
            if (i9 == 0) {
            }
            i10 = i5 & 64;
            if (i10 == 0) {
            }
            i11 = i5 & 128;
            if (i11 == 0) {
            }
            i12 = i5 & 256;
            if (i12 == 0) {
            }
            if ((i3 & 805306368) == 0) {
            }
            i13 = i5 & 1024;
            if (i13 == 0) {
            }
            i16 = i5 & 2048;
            if (i16 == 0) {
            }
            int i3422 = i15;
            i18 = i5 & 4096;
            if (i18 == 0) {
            }
            i20 = i5 & 8192;
            if (i20 == 0) {
            }
            i22 = i5 & 16384;
            if (i22 != 0) {
            }
            i24 = i5 & 32768;
            if (i24 != 0) {
            }
            i25 = i23;
            if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (74899 & i25) == 74898) ? false : true, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 8;
        if (i7 == 0) {
        }
        z4 = z;
        i8 = i5 & 16;
        if (i8 != 0) {
        }
        z5 = z2;
        i9 = i5 & 32;
        if (i9 == 0) {
        }
        i10 = i5 & 64;
        if (i10 == 0) {
        }
        i11 = i5 & 128;
        if (i11 == 0) {
        }
        i12 = i5 & 256;
        if (i12 == 0) {
        }
        if ((i3 & 805306368) == 0) {
        }
        i13 = i5 & 1024;
        if (i13 == 0) {
        }
        i16 = i5 & 2048;
        if (i16 == 0) {
        }
        int i34222 = i15;
        i18 = i5 & 4096;
        if (i18 == 0) {
        }
        i20 = i5 & 8192;
        if (i20 == 0) {
        }
        i22 = i5 & 16384;
        if (i22 != 0) {
        }
        i24 = i5 & 32768;
        if (i24 != 0) {
        }
        i25 = i23;
        if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (74899 & i25) == 74898) ? false : true, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:225:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011d  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void BasicTextField(final String str, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, Composer composer, final int i2, final int i3, final int i4) {
        String str2;
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        TextStyle textStyle2;
        int i9;
        KeyboardOptions keyboardOptions2;
        int i10;
        KeyboardActions keyboardActions2;
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
        Composer composer2;
        final boolean z4;
        final boolean z5;
        final boolean z6;
        final Function1 function13;
        final MutableInteractionSource mutableInteractionSource2;
        final TextStyle textStyle3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final Modifier modifier3;
        final int i25;
        final VisualTransformation visualTransformation2;
        final Brush brush2;
        final Function3 function32;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function1 function14;
        int i26;
        MutableInteractionSource mutableInteractionSource3;
        Brush solidColor;
        int i27;
        Composer composerStartRestartGroup = composer.startRestartGroup(74291967);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,keyboardOptions,keyboardActions,singleLine,maxLines,visualTransformation,onTextLayout,interactionSource,cursorBrush,decorationBox)945@49253L2,946@49307L39,951@49548L580:BasicTextField.kt#423gt5");
        if ((i2 & 6) == 0) {
            str2 = str;
            i5 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i2;
        } else {
            str2 = str;
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i28 = i4 & 4;
        if (i28 != 0) {
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
                    i5 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((i2 & 24576) == 0) {
                        i5 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
                    }
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        textStyle2 = textStyle;
                    } else {
                        textStyle2 = textStyle;
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i5 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                        }
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        keyboardOptions2 = keyboardOptions;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                        if ((i2 & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                        }
                    }
                    i10 = i4 & 128;
                    if (i10 == 0) {
                        i5 |= 12582912;
                        keyboardActions2 = keyboardActions;
                    } else {
                        keyboardActions2 = keyboardActions;
                        if ((i2 & 12582912) == 0) {
                            i5 |= composerStartRestartGroup.changed(keyboardActions2) ? 8388608 : 4194304;
                        }
                    }
                    i11 = i4 & 256;
                    if (i11 == 0) {
                        i5 |= 100663296;
                    } else if ((i2 & 100663296) == 0) {
                        i5 |= composerStartRestartGroup.changed(z3) ? 67108864 : 33554432;
                    }
                    i12 = i4 & 512;
                    if (i12 != 0) {
                        if ((i2 & 805306368) == 0) {
                            i13 = i12;
                            i5 |= composerStartRestartGroup.changed(i) ? 536870912 : 268435456;
                        }
                        i14 = i4 & 1024;
                        if (i14 != 0) {
                            i16 = i3 | 6;
                            i15 = i14;
                        } else if ((i3 & 6) == 0) {
                            i15 = i14;
                            i16 = i3 | (composerStartRestartGroup.changed(visualTransformation) ? 4 : 2);
                        } else {
                            i15 = i14;
                            i16 = i3;
                        }
                        i17 = i4 & 2048;
                        if (i17 != 0) {
                            i16 |= 48;
                            i18 = i17;
                        } else if ((i3 & 48) == 0) {
                            i18 = i17;
                            i16 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
                        } else {
                            i18 = i17;
                        }
                        int i29 = i16;
                        i19 = i4 & 4096;
                        if (i19 != 0) {
                            i20 = i29 | 384;
                        } else {
                            int i30 = i29;
                            if ((i3 & 384) == 0) {
                                i30 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
                            }
                            i20 = i30;
                        }
                        i21 = i4 & 8192;
                        if (i21 != 0) {
                            i22 = i20 | 3072;
                        } else {
                            int i31 = i20;
                            if ((i3 & 3072) == 0) {
                                i22 = i31 | (composerStartRestartGroup.changed(brush) ? 2048 : 1024);
                            } else {
                                i22 = i31;
                            }
                        }
                        i23 = i4 & 16384;
                        if (i23 != 0) {
                            i24 = i22 | 24576;
                        } else {
                            int i32 = i22;
                            if ((i3 & 24576) == 0) {
                                i32 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
                            }
                            i24 = i32;
                        }
                        if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i24 & 9363) == 9362) ? false : true, i5 & 1)) {
                            Modifier modifier4 = i28 != 0 ? Modifier.INSTANCE : modifier2;
                            boolean z7 = i6 != 0 ? true : z;
                            boolean z8 = i7 != 0 ? false : z2;
                            TextStyle textStyle4 = i8 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                            KeyboardOptions keyboardOptions4 = i9 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions2;
                            KeyboardActions keyboardActions4 = i10 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions2;
                            boolean z9 = i11 != 0 ? false : z3;
                            int i33 = i13 != 0 ? Integer.MAX_VALUE : i;
                            VisualTransformation none = i15 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                            if (i18 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1619846591, "CC(remember):BasicTextField.kt#9igjgp");
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda20
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return BasicTextFieldKt.BasicTextField$lambda$29$0((TextLayoutResult) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function14 = (Function1) objRememberedValue;
                            } else {
                                function14 = function12;
                            }
                            if (i19 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1619844826, "CC(remember):BasicTextField.kt#9igjgp");
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue2;
                                i26 = i21;
                            } else {
                                i26 = i21;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if (i26 != 0) {
                                composer2 = composerStartRestartGroup;
                                solidColor = new SolidColor(Color.INSTANCE.m6351getBlack0d7_KjU(), null);
                                i27 = i23;
                            } else {
                                composer2 = composerStartRestartGroup;
                                solidColor = brush;
                                i27 = i23;
                            }
                            Function3 lambda$444370233$foundation = i27 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.getLambda$444370233$foundation() : function3;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(74291967, i5, i24, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:950)");
                            }
                            int i34 = i24 << 3;
                            boolean z10 = z8;
                            BasicTextField(str2, (Function1<? super String, Unit>) function1, modifier4, z7, z10, textStyle4, keyboardOptions4, keyboardActions4, z9, i33, 1, none, (Function1<? super TextLayoutResult, Unit>) function14, mutableInteractionSource3, solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) lambda$444370233$foundation, composer2, i5 & 2147483646, (i34 & 112) | 6 | (i34 & 896) | (i34 & 7168) | (57344 & i34) | (i34 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z4 = z7;
                            z5 = z10;
                            textStyle3 = textStyle4;
                            keyboardOptions3 = keyboardOptions4;
                            keyboardActions3 = keyboardActions4;
                            z6 = z9;
                            i25 = i33;
                            visualTransformation2 = none;
                            function13 = function14;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            brush2 = solidColor;
                            function32 = lambda$444370233$foundation;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            z4 = z;
                            z5 = z2;
                            z6 = z3;
                            function13 = function12;
                            mutableInteractionSource2 = mutableInteractionSource;
                            textStyle3 = textStyle2;
                            keyboardOptions3 = keyboardOptions2;
                            keyboardActions3 = keyboardActions2;
                            modifier3 = modifier2;
                            i25 = i;
                            visualTransformation2 = visualTransformation;
                            brush2 = brush;
                            function32 = function3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda21
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BasicTextFieldKt.BasicTextField$lambda$31(str, function1, modifier3, z4, z5, textStyle3, keyboardOptions3, keyboardActions3, z6, i25, visualTransformation2, function13, mutableInteractionSource2, brush2, function32, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i5 |= 805306368;
                    i13 = i12;
                    i14 = i4 & 1024;
                    if (i14 != 0) {
                    }
                    i17 = i4 & 2048;
                    if (i17 != 0) {
                    }
                    int i292 = i16;
                    i19 = i4 & 4096;
                    if (i19 != 0) {
                    }
                    i21 = i4 & 8192;
                    if (i21 != 0) {
                    }
                    i23 = i4 & 16384;
                    if (i23 != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i24 & 9363) == 9362) ? false : true, i5 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                i10 = i4 & 128;
                if (i10 == 0) {
                }
                i11 = i4 & 256;
                if (i11 == 0) {
                }
                i12 = i4 & 512;
                if (i12 != 0) {
                }
                i13 = i12;
                i14 = i4 & 1024;
                if (i14 != 0) {
                }
                i17 = i4 & 2048;
                if (i17 != 0) {
                }
                int i2922 = i16;
                i19 = i4 & 4096;
                if (i19 != 0) {
                }
                i21 = i4 & 8192;
                if (i21 != 0) {
                }
                i23 = i4 & 16384;
                if (i23 != 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i24 & 9363) == 9362) ? false : true, i5 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            i10 = i4 & 128;
            if (i10 == 0) {
            }
            i11 = i4 & 256;
            if (i11 == 0) {
            }
            i12 = i4 & 512;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i4 & 1024;
            if (i14 != 0) {
            }
            i17 = i4 & 2048;
            if (i17 != 0) {
            }
            int i29222 = i16;
            i19 = i4 & 4096;
            if (i19 != 0) {
            }
            i21 = i4 & 8192;
            if (i21 != 0) {
            }
            i23 = i4 & 16384;
            if (i23 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i24 & 9363) == 9362) ? false : true, i5 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        i10 = i4 & 128;
        if (i10 == 0) {
        }
        i11 = i4 & 256;
        if (i11 == 0) {
        }
        i12 = i4 & 512;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i4 & 1024;
        if (i14 != 0) {
        }
        i17 = i4 & 2048;
        if (i17 != 0) {
        }
        int i292222 = i16;
        i19 = i4 & 4096;
        if (i19 != 0) {
        }
        i21 = i4 & 8192;
        if (i21 != 0) {
        }
        i23 = i4 & 16384;
        if (i23 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i24 & 9363) == 9362) ? false : true, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit BasicTextField$lambda$0(TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, OutputTransformation outputTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState, int i, int i2, int i3, Composer composer, int i4) {
        BasicTextField(textFieldState, modifier, z, z2, inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, textFieldLineLimits, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) function2, mutableInteractionSource, brush, outputTransformation, textFieldDecorator, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$11$0(TransformedTextFieldState transformedTextFieldState, InputTransformation inputTransformation, TextFieldSelectionState textFieldSelectionState, HapticFeedback hapticFeedback, Clipboard clipboard, BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 basicTextFieldKt$BasicTextField$textToolbarHandler$1$1, Density density, boolean z, boolean z2, boolean z3) {
        transformedTextFieldState.update(inputTransformation);
        textFieldSelectionState.update(hapticFeedback, clipboard, basicTextFieldKt$BasicTextField$textToolbarHandler$1$1, density, z, z2, z3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BasicTextField$lambda$12$0(final TextFieldSelectionState textFieldSelectionState, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$lambda$12$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                textFieldSelectionState.dispose();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$13$0(boolean z, MutableSharedFlow mutableSharedFlow) {
        if (z) {
            mutableSharedFlow.tryEmit(Unit.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$14$0(TextFieldDecorator textFieldDecorator, final TextFieldLineLimits textFieldLineLimits, final TextLayoutState textLayoutState, final TextStyle textStyle, final boolean z, final boolean z2, final TransformedTextFieldState transformedTextFieldState, final TextFieldSelectionState textFieldSelectionState, final Brush brush, final boolean z3, final boolean z4, final ScrollState scrollState, final Orientation orientation, final ToolbarRequesterImpl toolbarRequesterImpl, final PlatformSelectionBehaviors platformSelectionBehaviors, final boolean z5, final Function2 function2, final KeyboardOptions keyboardOptions, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C465@24817L2916,465@24806L2927:BasicTextField.kt#423gt5");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-673241599, i, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous> (BasicTextField.kt:464)");
            }
            (textFieldDecorator == null ? DefaultTextFieldDecorator : textFieldDecorator).Decoration(ComposableLambdaKt.rememberComposableLambda(1969169726, true, new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTextFieldKt.BasicTextField$lambda$14$0$0(textFieldLineLimits, textLayoutState, textStyle, z, z2, transformedTextFieldState, textFieldSelectionState, brush, z3, z4, scrollState, orientation, toolbarRequesterImpl, platformSelectionBehaviors, z5, function2, keyboardOptions, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$14$0$0(TextFieldLineLimits textFieldLineLimits, TextLayoutState textLayoutState, TextStyle textStyle, boolean z, boolean z2, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, Brush brush, boolean z3, boolean z4, ScrollState scrollState, Orientation orientation, ToolbarRequesterImpl toolbarRequesterImpl, PlatformSelectionBehaviors platformSelectionBehaviors, boolean z5, Function2 function2, KeyboardOptions keyboardOptions, Composer composer, int i) {
        int maxHeightInLines;
        int minHeightInLines;
        ComposerKt.sourceInformation(composer, "C476@25178L2541:BasicTextField.kt#423gt5");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1969169726, i, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous>.<anonymous> (BasicTextField.kt:466)");
            }
            if (textFieldLineLimits instanceof TextFieldLineLimits.MultiLine) {
                TextFieldLineLimits.MultiLine multiLine = (TextFieldLineLimits.MultiLine) textFieldLineLimits;
                minHeightInLines = multiLine.getMinHeightInLines();
                maxHeightInLines = multiLine.getMaxHeightInLines();
            } else {
                maxHeightInLines = 1;
                minHeightInLines = 1;
            }
            Modifier modifierThen = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.m2071heightInVpY3zN4$default(Modifier.INSTANCE, textLayoutState.m2667getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle, minHeightInLines, maxHeightInLines), textStyle)).then(new TextFieldCoreModifier(z, z2, textLayoutState, transformedTextFieldState, textFieldSelectionState, brush, z3 && !z4, scrollState, orientation, toolbarRequesterImpl, platformSelectionBehaviors));
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierThen);
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
            ComposerKt.sourceInformationMarkerStart(composer, -811364182, "C503@26688L530:BasicTextField.kt#423gt5");
            BoxKt.Box(new TextFieldTextLayoutModifier(textLayoutState, transformedTextFieldState, textStyle, z5, function2, keyboardOptions), composer, 0);
            if (z3 && z && textFieldSelectionState.isInTouchMode()) {
                composer.startReplaceGroup(-810654004);
                ComposerKt.sourceInformation(composer, "520@27453L67");
                TextFieldSelectionHandles(textFieldSelectionState, composer, 0);
                if (z4) {
                    composer.startReplaceGroup(-837871074);
                } else {
                    composer.startReplaceGroup(-810526873);
                    ComposerKt.sourceInformation(composer, "522@27590L63");
                    TextFieldCursorHandle(textFieldSelectionState, composer, 0);
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-837871074);
            }
            composer.endReplaceGroup();
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

    static final Unit BasicTextField$lambda$15(TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, CodepointTransformation codepointTransformation, OutputTransformation outputTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState, boolean z3, int i, int i2, int i3, Composer composer, int i4) {
        BasicTextField(textFieldState, modifier, z, z2, inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, textFieldLineLimits, function2, mutableInteractionSource, brush, codepointTransformation, outputTransformation, textFieldDecorator, scrollState, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$16$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    private static final TextFieldValue BasicTextField$lambda$18(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$20$0(TextFieldValue textFieldValue, MutableState mutableState) {
        if (!TextRange.m8549equalsimpl0(textFieldValue.getSelection(), BasicTextField$lambda$18(mutableState).getSelection()) || !Intrinsics.areEqual(textFieldValue.getComposition(), BasicTextField$lambda$18(mutableState).getComposition())) {
            mutableState.setValue(textFieldValue);
        }
        return Unit.INSTANCE;
    }

    private static final String BasicTextField$lambda$22(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$24$0(Function1 function1, MutableState mutableState, MutableState mutableState2, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
        boolean zAreEqual = Intrinsics.areEqual(BasicTextField$lambda$22(mutableState2), textFieldValue.getText());
        mutableState2.setValue(textFieldValue.getText());
        if (!zAreEqual) {
            function1.invoke(textFieldValue.getText());
        }
        return Unit.INSTANCE;
    }

    static final Unit BasicTextField$lambda$25(String str, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, int i2, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, int i3, int i4, int i5, Composer composer, int i6) {
        BasicTextField(str, (Function1<? super String, Unit>) function1, modifier, z, z2, textStyle, keyboardOptions, keyboardActions, z3, i, i2, visualTransformation, (Function1<? super TextLayoutResult, Unit>) function12, mutableInteractionSource, brush, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$26$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$27$0(TextFieldValue textFieldValue, Function1 function1, TextFieldValue textFieldValue2) {
        if (!Intrinsics.areEqual(textFieldValue, textFieldValue2)) {
            function1.invoke(textFieldValue2);
        }
        return Unit.INSTANCE;
    }

    static final Unit BasicTextField$lambda$28(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, int i2, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, int i3, int i4, int i5, Composer composer, int i6) {
        BasicTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier, z, z2, textStyle, keyboardOptions, keyboardActions, z3, i, i2, visualTransformation, (Function1<? super TextLayoutResult, Unit>) function12, mutableInteractionSource, brush, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$29$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    static final Unit BasicTextField$lambda$31(String str, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, int i2, int i3, int i4, Composer composer, int i5) {
        BasicTextField(str, function1, modifier, z, z2, textStyle, keyboardOptions, keyboardActions, z3, i, visualTransformation, function12, mutableInteractionSource, brush, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$32$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    static final Unit BasicTextField$lambda$34(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, int i2, int i3, int i4, Composer composer, int i5) {
        BasicTextField(textFieldValue, function1, modifier, z, z2, textStyle, keyboardOptions, keyboardActions, z3, i, visualTransformation, function12, mutableInteractionSource, brush, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    static final Unit BasicTextField$lambda$8(TextFieldSelectionState textFieldSelectionState, AnnotatedString annotatedString) {
        textFieldSelectionState.onPasteEvent$foundation(annotatedString);
        return Unit.INSTANCE;
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionState textFieldSelectionState, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1991581797);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldCursorHandle)N(selectionState)544@28301L128:BasicTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1991581797, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (BasicTextField.kt:541)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1645301467, "CC(remember):BasicTextField.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(textFieldSelectionState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BasicTextFieldKt.TextFieldCursorHandle$lambda$0$0(textFieldSelectionState);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (TextFieldCursorHandle$lambda$1((State) objRememberedValue).getVisible()) {
                composerStartRestartGroup.startReplaceGroup(535433166);
                ComposerKt.sourceInformation(composerStartRestartGroup, "549@28518L100,553@28697L87,548@28475L383");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1645294551, "CC(remember):BasicTextField.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                OffsetProvider offsetProviderRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || offsetProviderRememberedValue == Composer.INSTANCE.getEmpty()) {
                    offsetProviderRememberedValue = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0, reason: not valid java name */
                        public final long mo2363provideF1C5BW0() {
                            return textFieldSelectionState.getCursorHandleState$foundation(true).m2711getPositionF1C5BW0();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(offsetProviderRememberedValue);
                }
                OffsetProvider offsetProvider = (OffsetProvider) offsetProviderRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1645288836, "CC(remember):BasicTextField.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                PointerInputEventHandler pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || pointerInputEventHandlerRememberedValue == Composer.INSTANCE.getEmpty()) {
                    pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldCursorHandle$2$1
                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object objCursorHandleGestures = textFieldSelectionState.cursorHandleGestures(pointerInputScope, continuation);
                            return objCursorHandleGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCursorHandleGestures : Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidCursorHandle_androidKt.m2349CursorHandleUSBMPiE(offsetProvider, SuspendingPointerInputFilterKt.pointerInput(companion, textFieldSelectionState, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), MinTouchTargetSizeForHandles, composerStartRestartGroup, 384, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(507182525);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTextFieldKt.TextFieldCursorHandle$lambda$4(textFieldSelectionState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldHandleState TextFieldCursorHandle$lambda$0$0(TextFieldSelectionState textFieldSelectionState) {
        return textFieldSelectionState.getCursorHandleState$foundation(false);
    }

    private static final TextFieldHandleState TextFieldCursorHandle$lambda$1(State<TextFieldHandleState> state) {
        return state.getValue();
    }

    static final Unit TextFieldCursorHandle$lambda$4(TextFieldSelectionState textFieldSelectionState, int i, Composer composer, int i2) {
        TextFieldCursorHandle(textFieldSelectionState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void TextFieldSelectionHandles(final TextFieldSelectionState textFieldSelectionState, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2025287684);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldSelectionHandles)N(selectionState)565@29064L240,594@30119L241:BasicTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2025287684, i2, -1, "androidx.compose.foundation.text.TextFieldSelectionHandles (BasicTextField.kt:562)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 681285076, "CC(remember):BasicTextField.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(textFieldSelectionState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BasicTextFieldKt.TextFieldSelectionHandles$lambda$0$0(textFieldSelectionState);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            State state = (State) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (TextFieldSelectionHandles$lambda$1(state).getVisible()) {
                composerStartRestartGroup.startReplaceGroup(-354703320);
                ComposerKt.sourceInformation(composerStartRestartGroup, "575@29395L167,584@29789L94,574@29349L662");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 681295595, "CC(remember):BasicTextField.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                OffsetProvider offsetProviderRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || offsetProviderRememberedValue == Composer.INSTANCE.getEmpty()) {
                    offsetProviderRememberedValue = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0 */
                        public final long mo2363provideF1C5BW0() {
                            return textFieldSelectionState.getSelectionHandleState$foundation(true, true).m2711getPositionF1C5BW0();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(offsetProviderRememberedValue);
                }
                OffsetProvider offsetProvider = (OffsetProvider) offsetProviderRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ResolvedTextDirection direction = TextFieldSelectionHandles$lambda$1(state).getDirection();
                boolean handlesCrossed = TextFieldSelectionHandles$lambda$1(state).getHandlesCrossed();
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 681308130, "CC(remember):BasicTextField.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                PointerInputEventHandler pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || pointerInputEventHandlerRememberedValue == Composer.INSTANCE.getEmpty()) {
                    pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$2$1
                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object objSelectionHandleGestures = textFieldSelectionState.selectionHandleGestures(pointerInputScope, true, continuation);
                            return objSelectionHandleGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSelectionHandleGestures : Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidSelectionHandles_androidKt.m2798SelectionHandlewLIcFTc(offsetProvider, true, direction, handlesCrossed, MinTouchTargetSizeForHandles, TextFieldSelectionHandles$lambda$1(state).getLineHeight(), SuspendingPointerInputFilterKt.pointerInput(companion, textFieldSelectionState, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), composerStartRestartGroup, 24624, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(-383839042);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 681318837, "CC(remember):BasicTextField.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(textFieldSelectionState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BasicTextFieldKt.TextFieldSelectionHandles$lambda$4$0(textFieldSelectionState);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            State state2 = (State) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (TextFieldSelectionHandles$lambda$5(state2).getVisible()) {
                composerStartRestartGroup.startReplaceGroup(-353657845);
                ComposerKt.sourceInformation(composerStartRestartGroup, "604@30449L168,613@30841L95,603@30403L659");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 681329324, "CC(remember):BasicTextField.kt#9igjgp");
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                OffsetProvider offsetProviderRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance3 || offsetProviderRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    offsetProviderRememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$3$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0 */
                        public final long mo2363provideF1C5BW0() {
                            return textFieldSelectionState.getSelectionHandleState$foundation(false, true).m2711getPositionF1C5BW0();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(offsetProviderRememberedValue2);
                }
                OffsetProvider offsetProvider2 = (OffsetProvider) offsetProviderRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ResolvedTextDirection direction2 = TextFieldSelectionHandles$lambda$5(state2).getDirection();
                boolean handlesCrossed2 = TextFieldSelectionHandles$lambda$5(state2).getHandlesCrossed();
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 681341795, "CC(remember):BasicTextField.kt#9igjgp");
                boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                PointerInputEventHandler pointerInputEventHandlerRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance4 || pointerInputEventHandlerRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    pointerInputEventHandlerRememberedValue2 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$4$1
                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object objSelectionHandleGestures = textFieldSelectionState.selectionHandleGestures(pointerInputScope, false, continuation);
                            return objSelectionHandleGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSelectionHandleGestures : Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidSelectionHandles_androidKt.m2798SelectionHandlewLIcFTc(offsetProvider2, false, direction2, handlesCrossed2, MinTouchTargetSizeForHandles, TextFieldSelectionHandles$lambda$5(state2).getLineHeight(), SuspendingPointerInputFilterKt.pointerInput(companion2, textFieldSelectionState, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue2), composerStartRestartGroup, 24624, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(-383839042);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTextFieldKt.TextFieldSelectionHandles$lambda$8(textFieldSelectionState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldHandleState TextFieldSelectionHandles$lambda$0$0(TextFieldSelectionState textFieldSelectionState) {
        return textFieldSelectionState.getSelectionHandleState$foundation(true, false);
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$1(State<TextFieldHandleState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldHandleState TextFieldSelectionHandles$lambda$4$0(TextFieldSelectionState textFieldSelectionState) {
        return textFieldSelectionState.getSelectionHandleState$foundation(false, false);
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$5(State<TextFieldHandleState> state) {
        return state.getValue();
    }

    static final Unit TextFieldSelectionHandles$lambda$8(TextFieldSelectionState textFieldSelectionState, int i, Composer composer, int i2) {
        TextFieldSelectionHandles(textFieldSelectionState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final Modifier addContextMenuComponents(Modifier modifier, TextFieldSelectionState textFieldSelectionState, CoroutineScope coroutineScope) {
        return ComposeFoundationFlags.isNewContextMenuEnabled ? TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents(modifier, textFieldSelectionState, coroutineScope) : modifier;
    }
}
