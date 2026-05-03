package androidx.compose.foundation.text;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.handwriting.StylusHandwritingKt;
import androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifier;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNodeKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.foundation.text.selection.SelectedTextType;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aú\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001323\b\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0001¢\u0006\u0002\u0010%\u001a0\u0010&\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001fH\u0003¢\u0006\u0002\u0010*\u001a\u001c\u0010+\u001a\u00020\u0007*\u00020\u00072\u0006\u0010,\u001a\u00020-2\u0006\u0010'\u001a\u00020(H\u0002\u001a \u0010.\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0013H\u0000\u001a0\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u0002042\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00105\u001a\u000206H\u0002\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-H\u0002\u001a2\u00108\u001a\u00020\u0001*\u0002092\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\r2\u0006\u00105\u001a\u000206H\u0080@¢\u0006\u0002\u0010=\u001a\u001d\u0010>\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010@\u001a\u0015\u0010A\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\u0010B\u001a \u0010C\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u000206H\u0002\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\u00072\u0006\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020GH\u0002¨\u0006H²\u0006\n\u0010I\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "textScrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/text/TextFieldScrollerPosition;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", FirebaseAnalytics.Param.CONTENT, "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "previewKeyEventToDeselectOnBack", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/text/LegacyTextFieldState;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "endInputSession", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "notifyFocusedRect", "addContextMenuComponents", "textFieldSelectionManager", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "foundation", "writeable"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CoreTextFieldKt {
    /* JADX WARN: Removed duplicated region for block: B:105:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x078a  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x07aa  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x07e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:361:0x07e9  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0825  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x082d  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0836  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0842  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0884  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x08a5  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x08ab  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x08ad  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x08cd  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0910  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x091b  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x094e  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0950  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x095d  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0990  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0992  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x09a3  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x09a5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x09c0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0a17  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x0a4b  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x0a56  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x0a7b  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x0a7d  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0a84  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x0a8a  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x0a99  */
    /* JADX WARN: Removed duplicated region for block: B:464:0x0aa1  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x0ac4  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0ac7  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x0b09  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x0b2e  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0b39  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x0b9e  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x0ba6  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x0c16  */
    /* JADX WARN: Removed duplicated region for block: B:498:0x0c19  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x0c22  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0c72  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x0c95  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x0cba  */
    /* JADX WARN: Removed duplicated region for block: B:509:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CoreTextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z, int i, int i2, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z2, boolean z3, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, TextFieldScrollerPosition textFieldScrollerPosition, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        TextStyle textStyle2;
        int i8;
        int i9;
        Function1<? super TextLayoutResult, Unit> function13;
        int i10;
        MutableInteractionSource mutableInteractionSource2;
        int i11;
        SolidColor solidColor;
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
        final int i27;
        final KeyboardActions keyboardActions2;
        final boolean z4;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        final TextFieldScrollerPosition textFieldScrollerPosition2;
        Composer composer2;
        final Brush brush2;
        final MutableInteractionSource mutableInteractionSource3;
        final Function1<? super TextLayoutResult, Unit> function14;
        final TextStyle textStyle3;
        final Modifier modifier3;
        final VisualTransformation visualTransformation2;
        final boolean z5;
        final int i28;
        final ImeOptions imeOptions2;
        final boolean z6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        MutableInteractionSource mutableInteractionSource4;
        ImeOptions imeOptions3;
        KeyboardActions keyboardActions3;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> lambda$559628295$foundation;
        TextFieldScrollerPosition textFieldScrollerPosition3;
        boolean z7;
        boolean z8;
        int i29;
        final Function1<? super TextLayoutResult, Unit> function15;
        boolean z9;
        VisualTransformation visualTransformation3;
        Modifier modifier4;
        ImeOptions imeOptions4;
        int i30;
        int i31;
        Brush brush3;
        MutableInteractionSource mutableInteractionSource5;
        Brush brush4;
        LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter;
        WindowInfo windowInfo;
        int i32;
        TextFieldScrollerPosition textFieldScrollerPosition4;
        TextFieldScrollerPosition textFieldScrollerPosition5;
        AnnotatedString annotatedString;
        TextStyle textStyle4;
        boolean z10;
        FontFamily.Resolver resolver;
        FocusManager focusManager;
        final LegacyTextFieldState legacyTextFieldState;
        boolean z11;
        boolean zChangedInstance;
        final TextFieldSelectionManager textFieldSelectionManager;
        final LegacyTextFieldState legacyTextFieldState2;
        boolean z12;
        final TextInputService textInputService;
        ImeOptions imeOptions5;
        final OffsetMapping offsetMapping;
        CoroutineScope coroutineScope;
        BringIntoViewRequester bringIntoViewRequester;
        VisualTransformation visualTransformation4;
        String str;
        boolean z13;
        final TextFieldSelectionManager textFieldSelectionManager2;
        boolean zChanged;
        boolean z14;
        boolean z15;
        boolean z16;
        CoreTextFieldKt$CoreTextField$5$1 coreTextFieldKt$CoreTextField$5$1RememberedValue;
        State state;
        boolean zChangedInstance2;
        Object objRememberedValue;
        boolean zChangedInstance3;
        Object objRememberedValue2;
        FocusRequester focusRequester;
        boolean z17;
        boolean zChangedInstance4;
        final boolean z18;
        boolean zChangedInstance5;
        Object objRememberedValue3;
        final TextFieldValue textFieldValue2;
        final WindowInfo windowInfo2;
        boolean zChangedInstance6;
        Object objRememberedValue4;
        boolean z19;
        WindowInfo windowInfo3;
        boolean zChangedInstance7;
        Modifier modifier5;
        boolean zChangedInstance8;
        Object objRememberedValue5;
        boolean zChanged2;
        int i33;
        final Brush brushM2351resolveAutofillHighlightWkMShQ;
        boolean zChangedInstance9;
        Object objRememberedValue6;
        Composer composerStartRestartGroup = composer.startRestartGroup(31062401);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CoreTextField)N(value,onValueChange,modifier,textStyle,visualTransformation,onTextLayout,interactionSource,cursorBrush,softWrap,maxLines,minLines,imeOptions,keyboardActions,enabled,readOnly,decorationBox,textScrollerPosition)213@12062L29,214@12132L58,215@12236L72,220@12366L7,221@12427L7,222@12495L7,223@12560L7,224@12605L7,225@12674L7,246@13516L277,258@14098L21,260@14144L453,289@14997L26,292@15090L24,293@15148L37,295@15205L51,301@15494L7,303@15589L7,304@15646L7,314@16020L206,327@16443L1514,362@18064L42,363@18132L971,363@18111L992,389@19173L28,390@19269L992,412@20352L177,421@20630L577,439@21278L1606,492@23496L48,492@23470L74,494@23579L503,494@23550L532,526@24756L987,545@25860L7,546@25917L7,550@26055L327,559@26411L35,587@27673L5409,587@27620L5462:CoreTextField.kt#423gt5");
        if ((i3 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(textFieldValue) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i34 = i5 & 4;
        if (i34 != 0) {
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
                    textStyle2 = textStyle;
                    i6 |= composerStartRestartGroup.changed(textStyle2) ? 2048 : 1024;
                }
                i8 = i5 & 16;
                if (i8 != 0) {
                    i6 |= 24576;
                } else {
                    if ((i3 & 24576) == 0) {
                        i6 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                    }
                    i9 = i5 & 32;
                    if (i9 == 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function13 = function12;
                    } else {
                        function13 = function12;
                        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i6 |= composerStartRestartGroup.changedInstance(function13) ? 131072 : 65536;
                        }
                    }
                    i10 = i5 & 64;
                    if (i10 == 0) {
                        i6 |= 1572864;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if ((i3 & 1572864) == 0) {
                            i6 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                        }
                    }
                    i11 = i5 & 128;
                    if (i11 == 0) {
                        i6 |= 12582912;
                        solidColor = brush;
                    } else {
                        solidColor = brush;
                        if ((i3 & 12582912) == 0) {
                            i6 |= composerStartRestartGroup.changed(solidColor) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i5 & 256;
                    if (i12 == 0) {
                        i6 |= 100663296;
                    } else {
                        if ((i3 & 100663296) == 0) {
                            i13 = i12;
                            i6 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i14 = i5 & 512;
                        if (i14 != 0) {
                            i6 |= 805306368;
                        } else {
                            if ((i3 & 805306368) == 0) {
                                i15 = i14;
                                i6 |= composerStartRestartGroup.changed(i) ? 536870912 : 268435456;
                            }
                            i16 = i5 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 6) == 0) {
                                i17 = i16;
                                i18 = i4 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            if ((i4 & 48) == 0) {
                                i18 |= ((i5 & 2048) == 0 && composerStartRestartGroup.changed(imeOptions)) ? 32 : 16;
                            }
                            int i35 = i18;
                            i19 = i5 & 4096;
                            if (i19 == 0) {
                                i20 = i35 | 384;
                            } else if ((i4 & 384) == 0) {
                                i20 = i35 | (composerStartRestartGroup.changed(keyboardActions) ? 256 : 128);
                            } else {
                                i20 = i35;
                            }
                            i21 = i5 & 8192;
                            if (i21 == 0) {
                                i22 = i20 | 3072;
                            } else {
                                int i36 = i20;
                                if ((i4 & 3072) == 0) {
                                    i22 = i36 | (composerStartRestartGroup.changed(z2) ? 2048 : 1024);
                                } else {
                                    i22 = i36;
                                }
                            }
                            i23 = i5 & 16384;
                            if (i23 != 0) {
                                i24 = i22;
                                if ((i4 & 24576) == 0) {
                                    i24 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                                }
                                i25 = i5 & 32768;
                                if (i25 != 0) {
                                    i24 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i24 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
                                }
                                i26 = i5 & 65536;
                                if (i26 != 0) {
                                    i24 |= 1572864;
                                } else if ((i4 & 1572864) == 0) {
                                    i24 |= composerStartRestartGroup.changed(textFieldScrollerPosition) ? 1048576 : 524288;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (i24 & 599187) == 599186) ? false : true, i6 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "198@11387L2");
                                    if ((i3 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i34 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i7 != 0) {
                                            textStyle2 = TextStyle.INSTANCE.getDefault();
                                        }
                                        VisualTransformation none = i8 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                        if (i9 != 0) {
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213794269, "CC(remember):CoreTextField.kt#9igjgp");
                                            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue7 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda17
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj) {
                                                        return CoreTextFieldKt.CoreTextField$lambda$0$0((TextLayoutResult) obj);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                            }
                                            function13 = (Function1) objRememberedValue7;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        }
                                        if (i10 != 0) {
                                            mutableInteractionSource2 = null;
                                        }
                                        if (i11 != 0) {
                                            mutableInteractionSource4 = mutableInteractionSource2;
                                            solidColor = new SolidColor(Color.INSTANCE.m6361getUnspecified0d7_KjU(), null);
                                        } else {
                                            mutableInteractionSource4 = mutableInteractionSource2;
                                        }
                                        boolean z20 = i13 != 0 ? true : z;
                                        int i37 = i15 != 0 ? Integer.MAX_VALUE : i;
                                        int i38 = i17 != 0 ? 1 : i2;
                                        if ((i5 & 2048) != 0) {
                                            imeOptions3 = ImeOptions.INSTANCE.getDefault();
                                            i24 &= -113;
                                        } else {
                                            imeOptions3 = imeOptions;
                                        }
                                        keyboardActions3 = i19 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                        boolean z21 = i21 != 0 ? true : z2;
                                        boolean z22 = i23 != 0 ? false : z3;
                                        lambda$559628295$foundation = i25 != 0 ? ComposableSingletons$CoreTextFieldKt.INSTANCE.getLambda$559628295$foundation() : function3;
                                        textFieldScrollerPosition3 = i26 != 0 ? null : textFieldScrollerPosition;
                                        z7 = z21;
                                        z8 = z22;
                                        i29 = i24;
                                        function15 = function13;
                                        z9 = z20;
                                        visualTransformation3 = none;
                                        modifier4 = modifier2;
                                        imeOptions4 = imeOptions3;
                                        i30 = i38;
                                        i31 = i37;
                                        brush3 = solidColor;
                                        mutableInteractionSource5 = mutableInteractionSource4;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i5 & 2048) != 0) {
                                            i24 &= -113;
                                        }
                                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource2;
                                        brush3 = solidColor;
                                        mutableInteractionSource5 = mutableInteractionSource6;
                                        visualTransformation3 = visualTransformation;
                                        i31 = i;
                                        i30 = i2;
                                        keyboardActions3 = keyboardActions;
                                        z7 = z2;
                                        z8 = z3;
                                        lambda$559628295$foundation = function3;
                                        textFieldScrollerPosition3 = textFieldScrollerPosition;
                                        function15 = function13;
                                        modifier4 = modifier2;
                                        i29 = i24;
                                        z9 = z;
                                        imeOptions4 = imeOptions;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        brush4 = brush3;
                                        ComposerKt.traceEventStart(31062401, i6, i29, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:212)");
                                    } else {
                                        brush4 = brush3;
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213772642, "CC(remember):CoreTextField.kt#9igjgp");
                                    Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue8 = new FocusRequester();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                    }
                                    final FocusRequester focusRequester2 = (FocusRequester) objRememberedValue8;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213770373, "CC(remember):CoreTextField.kt#9igjgp");
                                    Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                                    int i39 = i6;
                                    if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue9 = LegacyPlatformTextInputServiceAdapter_androidKt.createLegacyPlatformTextInputServiceAdapter();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                                    }
                                    LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter2 = (LegacyPlatformTextInputServiceAdapter) objRememberedValue9;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213767031, "CC(remember):CoreTextField.kt#9igjgp");
                                    Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                                    boolean z23 = z9;
                                    if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue10 = new TextInputService(legacyPlatformTextInputServiceAdapter2);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                                    }
                                    final TextInputService textInputService2 = (TextInputService) objRememberedValue10;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                    TextStyle textStyle5 = textStyle2;
                                    final int i40 = i30;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume = composerStartRestartGroup.consume(localDensity);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    final Density density = (Density) objConsume;
                                    ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composerStartRestartGroup.consume(localFontFamilyResolver);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    FontFamily.Resolver resolver2 = (FontFamily.Resolver) objConsume2;
                                    ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume3 = composerStartRestartGroup.consume(localTextSelectionColors);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    long backgroundColor = ((TextSelectionColors) objConsume3).getBackgroundColor();
                                    ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume4 = composerStartRestartGroup.consume(localFocusManager);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    FocusManager focusManager2 = (FocusManager) objConsume4;
                                    ProvidableCompositionLocal<WindowInfo> localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume5 = composerStartRestartGroup.consume(localWindowInfo);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    WindowInfo windowInfo4 = (WindowInfo) objConsume5;
                                    KeyboardActions keyboardActions4 = keyboardActions3;
                                    ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume6 = composerStartRestartGroup.consume(localSoftwareKeyboardController);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) objConsume6;
                                    final Orientation orientation = (i31 == 1 && !z23 && imeOptions4.getSingleLine()) ? Orientation.Horizontal : Orientation.Vertical;
                                    Modifier modifier6 = modifier4;
                                    if (textFieldScrollerPosition3 == null) {
                                        composerStartRestartGroup.startReplaceGroup(-213744626);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "232@13005L70,232@12934L141");
                                        Object[] objArr = {orientation};
                                        legacyPlatformTextInputServiceAdapter = legacyPlatformTextInputServiceAdapter2;
                                        Saver<TextFieldScrollerPosition, Object> saver = TextFieldScrollerPosition.INSTANCE.getSaver();
                                        i32 = i31;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213742425, "CC(remember):CoreTextField.kt#9igjgp");
                                        boolean zChanged3 = composerStartRestartGroup.changed(orientation.ordinal());
                                        Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                                        if (zChanged3) {
                                            windowInfo = windowInfo4;
                                        } else {
                                            windowInfo = windowInfo4;
                                            if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            textFieldScrollerPosition4 = (TextFieldScrollerPosition) RememberSaveableKt.m5766rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue11, composerStartRestartGroup, 0);
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                        objRememberedValue11 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda2
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return CoreTextFieldKt.CoreTextField$lambda$4$0(orientation);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        textFieldScrollerPosition4 = (TextFieldScrollerPosition) RememberSaveableKt.m5766rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue11, composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        legacyPlatformTextInputServiceAdapter = legacyPlatformTextInputServiceAdapter2;
                                        windowInfo = windowInfo4;
                                        i32 = i31;
                                        composerStartRestartGroup.startReplaceGroup(-213745742);
                                        composerStartRestartGroup.endReplaceGroup();
                                        textFieldScrollerPosition4 = textFieldScrollerPosition3;
                                    }
                                    if (textFieldScrollerPosition4.getOrientation() != orientation) {
                                        throw new IllegalArgumentException("Mismatching scroller orientation; ".concat(orientation == Orientation.Vertical ? "only single-line, non-wrap text fields can scroll horizontally" : "single-line, non-wrap text fields can only scroll horizontally"));
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213725866, "CC(remember):CoreTextField.kt#9igjgp");
                                    int i41 = i39 & 14;
                                    boolean z24 = (i41 == 4) | ((i39 & 57344) == 16384);
                                    Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                                    if (z24 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                        TransformedText transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation3, textFieldValue.getAnnotatedString());
                                        TextRange composition = textFieldValue.getComposition();
                                        if (composition != null) {
                                            textFieldScrollerPosition5 = textFieldScrollerPosition4;
                                            TransformedText transformedTextM2480applyCompositionDecoration72CqOWE = TextFieldDelegate.INSTANCE.m2480applyCompositionDecoration72CqOWE(composition.getPackedValue(), transformedTextFilterWithValidation);
                                            if (transformedTextM2480applyCompositionDecoration72CqOWE != null) {
                                                objRememberedValue12 = transformedTextM2480applyCompositionDecoration72CqOWE;
                                            }
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                                        } else {
                                            textFieldScrollerPosition5 = textFieldScrollerPosition4;
                                        }
                                        objRememberedValue12 = transformedTextFilterWithValidation;
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                                    } else {
                                        textFieldScrollerPosition5 = textFieldScrollerPosition4;
                                    }
                                    TransformedText transformedText = (TransformedText) objRememberedValue12;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    AnnotatedString text = transformedText.getText();
                                    final OffsetMapping offsetMapping2 = transformedText.getOffsetMapping();
                                    RecomposeScope currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213705594, "CC(remember):CoreTextField.kt#9igjgp");
                                    boolean zChanged4 = composerStartRestartGroup.changed(softwareKeyboardController);
                                    Object objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged4 || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                                        annotatedString = text;
                                        textStyle4 = textStyle5;
                                        z10 = z23;
                                        resolver = resolver2;
                                        objRememberedValue13 = new LegacyTextFieldState(new TextDelegate(text, textStyle5, 0, 0, z23, 0, density, resolver2, null, 300, null), currentRecomposeScope, softwareKeyboardController);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                                    } else {
                                        annotatedString = text;
                                        textStyle4 = textStyle5;
                                        z10 = z23;
                                        resolver = resolver2;
                                    }
                                    LegacyTextFieldState legacyTextFieldState3 = (LegacyTextFieldState) objRememberedValue13;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    legacyTextFieldState3.m2445updatefnh65Uc(textFieldValue.getAnnotatedString(), annotatedString, textStyle4, z10, density, resolver, function1, keyboardActions4, focusManager2, backgroundColor);
                                    legacyTextFieldState3.getProcessor().reset(textFieldValue, legacyTextFieldState3.getInputSession());
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213678725, "CC(remember):CoreTextField.kt#9igjgp");
                                    Object objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                                        focusManager = focusManager2;
                                        objRememberedValue14 = new UndoManager(0, 1, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                                    } else {
                                        focusManager = focusManager2;
                                    }
                                    UndoManager undoManager = (UndoManager) objRememberedValue14;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                                    Object objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue15 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue15 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
                                    }
                                    final CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue15;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213673882, "CC(remember):CoreTextField.kt#9igjgp");
                                    Object objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                                    MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource5;
                                    if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue16 = BringIntoViewRequesterKt.BringIntoViewRequester();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                                    }
                                    final BringIntoViewRequester bringIntoViewRequester2 = (BringIntoViewRequester) objRememberedValue16;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213672044, "CC(remember):CoreTextField.kt#9igjgp");
                                    Object objRememberedValue17 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue17 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue17 = new TextFieldSelectionManager(undoManager);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue17);
                                    }
                                    final TextFieldSelectionManager textFieldSelectionManager3 = (TextFieldSelectionManager) objRememberedValue17;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    textFieldSelectionManager3.setOffsetMapping$foundation(offsetMapping2);
                                    textFieldSelectionManager3.setVisualTransformation$foundation(visualTransformation3);
                                    textFieldSelectionManager3.setOnValueChange$foundation(legacyTextFieldState3.getOnValueChange());
                                    textFieldSelectionManager3.setState$foundation(legacyTextFieldState3);
                                    textFieldSelectionManager3.setValue$foundation(textFieldValue);
                                    ProvidableCompositionLocal<Clipboard> localClipboard = CompositionLocalsKt.getLocalClipboard();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume7 = composerStartRestartGroup.consume(localClipboard);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    textFieldSelectionManager3.setClipboard$foundation((Clipboard) objConsume7);
                                    textFieldSelectionManager3.setCoroutineScope$foundation(coroutineScope2);
                                    ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume8 = composerStartRestartGroup.consume(localTextToolbar);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    textFieldSelectionManager3.setTextToolbar((TextToolbar) objConsume8);
                                    ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume9 = composerStartRestartGroup.consume(localHapticFeedback);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    textFieldSelectionManager3.setHapticFeedBack((HapticFeedback) objConsume9);
                                    textFieldSelectionManager3.setFocusRequester(focusRequester2);
                                    textFieldSelectionManager3.setEditable(!z8);
                                    final boolean z25 = z7;
                                    textFieldSelectionManager3.setEnabled(z25);
                                    if (ComposeFoundationFlags.isSmartSelectionEnabled) {
                                        composerStartRestartGroup.startReplaceGroup(1966756105);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "311@15921L87");
                                        textFieldSelectionManager3.setPlatformSelectionBehaviors$foundation(PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.EditableText, textStyle4.getLocaleList(), composerStartRestartGroup, 6));
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1951015297);
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    legacyTextFieldState3.getHasFocus();
                                    new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CoreTextFieldKt.CoreTextField$lambda$10(textFieldSelectionManager3, (AnnotatedString) obj);
                                        }
                                    };
                                    new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return TextFieldSelectionManager.copyWithResult$foundation$default(textFieldSelectionManager3, false, 1, null);
                                        }
                                    };
                                    new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return textFieldSelectionManager3.cutWithResult$foundation();
                                        }
                                    };
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1197772674, "CC(rememberClipboardEventsHandler)N(onPaste,onCopy,onCut,isEnabled):ClipboardEventsHandler.jvm.kt#423gt5");
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213630965, "CC(remember):CoreTextField.kt#9igjgp");
                                    int i42 = i29 & 7168;
                                    int i43 = i29;
                                    int i44 = i43 & 57344;
                                    boolean zChangedInstance10 = (i42 == 2048) | composerStartRestartGroup.changedInstance(legacyTextFieldState3) | (i44 == 16384) | composerStartRestartGroup.changedInstance(textInputService2) | (i41 == 4);
                                    int i45 = (i43 & 112) ^ 48;
                                    if (i45 <= 32 || !composerStartRestartGroup.changed(imeOptions4)) {
                                        legacyTextFieldState = legacyTextFieldState3;
                                        if ((i43 & 48) != 32) {
                                            z11 = false;
                                        }
                                        zChangedInstance = zChangedInstance10 | z11 | composerStartRestartGroup.changedInstance(offsetMapping2) | composerStartRestartGroup.changedInstance(coroutineScope2) | composerStartRestartGroup.changedInstance(bringIntoViewRequester2) | composerStartRestartGroup.changedInstance(textFieldSelectionManager3);
                                        Object objRememberedValue18 = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance) {
                                            textFieldSelectionManager = textFieldSelectionManager3;
                                            if (objRememberedValue18 != Composer.INSTANCE.getEmpty()) {
                                                visualTransformation4 = visualTransformation3;
                                                coroutineScope = coroutineScope2;
                                                str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                                imeOptions5 = imeOptions4;
                                                z12 = z8;
                                                legacyTextFieldState2 = legacyTextFieldState;
                                                z13 = z25;
                                                textFieldSelectionManager2 = textFieldSelectionManager;
                                                bringIntoViewRequester = bringIntoViewRequester2;
                                                offsetMapping = offsetMapping2;
                                                textInputService = textInputService2;
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            Modifier modifierTextFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion, z13, focusRequester2, mutableInteractionSource7, (Function1) objRememberedValue18);
                                            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z13 && !z12), composerStartRestartGroup, 0);
                                            Unit unit = Unit.INSTANCE;
                                            final boolean z26 = z13;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213577460, "CC(remember):CoreTextField.kt#9igjgp");
                                            zChanged = composerStartRestartGroup.changed(stateRememberUpdatedState) | composerStartRestartGroup.changedInstance(legacyTextFieldState2) | composerStartRestartGroup.changedInstance(textInputService) | composerStartRestartGroup.changedInstance(textFieldSelectionManager2);
                                            if (i45 > 32 || !composerStartRestartGroup.changed(imeOptions5)) {
                                                z14 = zChanged;
                                                if ((i43 & 48) != 32) {
                                                    z15 = false;
                                                }
                                                z16 = z14 | z15;
                                                coreTextFieldKt$CoreTextField$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (z16 || coreTextFieldKt$CoreTextField$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    CoreTextFieldKt$CoreTextField$5$1 coreTextFieldKt$CoreTextField$5$1 = new CoreTextFieldKt$CoreTextField$5$1(legacyTextFieldState2, stateRememberUpdatedState, textInputService, textFieldSelectionManager2, imeOptions5, null);
                                                    state = stateRememberUpdatedState;
                                                    coreTextFieldKt$CoreTextField$5$1RememberedValue = coreTextFieldKt$CoreTextField$5$1;
                                                    composerStartRestartGroup.updateRememberedValue(coreTextFieldKt$CoreTextField$5$1RememberedValue);
                                                } else {
                                                    state = stateRememberUpdatedState;
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                State state2 = state;
                                                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) coreTextFieldKt$CoreTextField$5$1RememberedValue, composerStartRestartGroup, 6);
                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213545091, "CC(remember):CoreTextField.kt#9igjgp");
                                                zChangedInstance2 = composerStartRestartGroup.changedInstance(legacyTextFieldState2);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (!zChangedInstance2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda7
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj) {
                                                            return CoreTextFieldKt.CoreTextField$lambda$16$0(legacyTextFieldState2, ((Boolean) obj).booleanValue());
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                Modifier modifierUpdateSelectionTouchMode = SelectionGesturesKt.updateSelectionTouchMode(companion2, (Function1) objRememberedValue);
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213541055, "CC(remember):CoreTextField.kt#9igjgp");
                                                zChangedInstance3 = composerStartRestartGroup.changedInstance(legacyTextFieldState2) | (i44 != 16384) | (i42 != 2048) | composerStartRestartGroup.changedInstance(offsetMapping) | composerStartRestartGroup.changedInstance(textFieldSelectionManager2);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (!zChangedInstance3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    final OffsetMapping offsetMapping3 = offsetMapping;
                                                    final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager2;
                                                    final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState2;
                                                    final boolean z27 = z12;
                                                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda8
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj) {
                                                            return CoreTextFieldKt.CoreTextField$lambda$17$0(legacyTextFieldState4, focusRequester2, z27, z26, textFieldSelectionManager4, offsetMapping3, (Offset) obj);
                                                        }
                                                    };
                                                    focusRequester = focusRequester2;
                                                    z17 = z26;
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                                } else {
                                                    focusRequester = focusRequester2;
                                                    z17 = z26;
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                Modifier modifierTapPressTextFieldModifier = TextFieldPressGestureFilterKt.tapPressTextFieldModifier(modifierUpdateSelectionTouchMode, mutableInteractionSource7, z17, (Function1) objRememberedValue2);
                                                MouseSelectionObserver mouseSelectionObserver = textFieldSelectionManager2.getMouseSelectionObserver();
                                                FocusRequester focusRequester3 = focusRequester;
                                                TextDragObserver touchSelectionObserver = textFieldSelectionManager2.getTouchSelectionObserver();
                                                final ImeOptions imeOptions6 = imeOptions5;
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213507214, "CC(remember):CoreTextField.kt#9igjgp");
                                                zChangedInstance4 = composerStartRestartGroup.changedInstance(textFieldSelectionManager2);
                                                PointerInputEventHandler pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance4) {
                                                    z18 = z17;
                                                    if (pointerInputEventHandlerRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    Modifier modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput(modifierTapPressTextFieldModifier, mouseSelectionObserver, touchSelectionObserver, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), PointerIcon.INSTANCE.getText(), false, 2, null);
                                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213497918, "CC(remember):CoreTextField.kt#9igjgp");
                                                    zChangedInstance5 = composerStartRestartGroup.changedInstance(legacyTextFieldState2) | (i41 == 4) | composerStartRestartGroup.changedInstance(offsetMapping);
                                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                                    if (zChangedInstance5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                        textFieldValue2 = textFieldValue;
                                                        objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda9
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj) {
                                                                return CoreTextFieldKt.CoreTextField$lambda$19$0(legacyTextFieldState2, textFieldValue2, offsetMapping, (DrawScope) obj);
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                                    } else {
                                                        textFieldValue2 = textFieldValue;
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    final Modifier modifierDrawBehind = DrawModifierKt.drawBehind(companion3, (Function1) objRememberedValue3);
                                                    Modifier.Companion companion4 = Modifier.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213476153, "CC(remember):CoreTextField.kt#9igjgp");
                                                    windowInfo2 = windowInfo;
                                                    zChangedInstance6 = (i42 != 2048) | composerStartRestartGroup.changedInstance(legacyTextFieldState2) | composerStartRestartGroup.changed(windowInfo2) | composerStartRestartGroup.changedInstance(textFieldSelectionManager2) | (i41 != 4) | composerStartRestartGroup.changedInstance(offsetMapping);
                                                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                                    if (!zChangedInstance6 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                        final TextFieldValue textFieldValue3 = textFieldValue2;
                                                        final OffsetMapping offsetMapping4 = offsetMapping;
                                                        final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager2;
                                                        final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState2;
                                                        objRememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda10
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj) {
                                                                return CoreTextFieldKt.CoreTextField$lambda$20$0(legacyTextFieldState5, z18, windowInfo2, textFieldSelectionManager5, textFieldValue3, offsetMapping4, (LayoutCoordinates) obj);
                                                            }
                                                        };
                                                        z19 = z18;
                                                        windowInfo3 = windowInfo2;
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                                    } else {
                                                        z19 = z18;
                                                        windowInfo3 = windowInfo2;
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    final Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion4, (Function1) objRememberedValue4);
                                                    final VisualTransformation visualTransformation5 = visualTransformation4;
                                                    boolean z28 = z19;
                                                    CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState2, z12, z28, visualTransformation5 instanceof PasswordVisualTransformation, offsetMapping, textFieldSelectionManager2, imeOptions6, focusRequester3);
                                                    Brush brush5 = brush4;
                                                    final OffsetMapping offsetMapping5 = offsetMapping;
                                                    final LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState2;
                                                    Modifier modifierCursor = TextFieldCursorKt.cursor(Modifier.INSTANCE, legacyTextFieldState6, textFieldValue, offsetMapping5, brush5, (z28 || z12 || !windowInfo3.isWindowFocused() || legacyTextFieldState2.hasHighlight()) ? false : true);
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213406735, "CC(remember):CoreTextField.kt#9igjgp");
                                                    zChangedInstance7 = composerStartRestartGroup.changedInstance(textFieldSelectionManager2);
                                                    Object objRememberedValue19 = composerStartRestartGroup.rememberedValue();
                                                    if (zChangedInstance7) {
                                                        modifier5 = modifierCursor;
                                                        if (objRememberedValue19 == Composer.INSTANCE.getEmpty()) {
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        EffectsKt.DisposableEffect(textFieldSelectionManager2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue19, composerStartRestartGroup, 0);
                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213403624, "CC(remember):CoreTextField.kt#9igjgp");
                                                        zChangedInstance8 = composerStartRestartGroup.changedInstance(legacyTextFieldState6) | composerStartRestartGroup.changedInstance(textInputService) | (i41 == 4) | ((i45 > 32 && composerStartRestartGroup.changed(imeOptions6)) || (i43 & 48) == 32);
                                                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                                        if (zChangedInstance8 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                            objRememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda19
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Object invoke(Object obj) {
                                                                    return CoreTextFieldKt.CoreTextField$lambda$22$0(legacyTextFieldState6, textInputService, textFieldValue, imeOptions6, (DisposableEffectScope) obj);
                                                                }
                                                            };
                                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        EffectsKt.DisposableEffect(imeOptions6, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue5, composerStartRestartGroup, (i43 >> 3) & 14);
                                                        int i46 = i32;
                                                        Modifier modifierM2495textFieldKeyInput2WJ9YEU = TextFieldKeyInputKt.m2495textFieldKeyInput2WJ9YEU(Modifier.INSTANCE, legacyTextFieldState6, textFieldSelectionManager2, textFieldValue, legacyTextFieldState6.getOnValueChange(), !z12, i46 != 1, offsetMapping5, undoManager, imeOptions6.getImeAction());
                                                        final boolean z29 = KeyboardType.m8783equalsimpl0(imeOptions6.getKeyboardType(), KeyboardType.INSTANCE.m8802getPasswordPjHm6EE()) && !KeyboardType.m8783equalsimpl0(imeOptions6.getKeyboardType(), KeyboardType.INSTANCE.m8801getNumberPasswordPjHm6EE());
                                                        Modifier.Companion companion5 = Modifier.INSTANCE;
                                                        boolean zCoreTextField$lambda$14 = CoreTextField$lambda$14(state2);
                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213365476, "CC(remember):CoreTextField.kt#9igjgp");
                                                        final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter3 = legacyPlatformTextInputServiceAdapter;
                                                        zChanged2 = composerStartRestartGroup.changed(z29) | composerStartRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter3);
                                                        Object objRememberedValue20 = composerStartRestartGroup.rememberedValue();
                                                        if (zChanged2) {
                                                            i33 = i46;
                                                            if (objRememberedValue20 == Composer.INSTANCE.getEmpty()) {
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            Modifier modifierStylusHandwriting = StylusHandwritingKt.stylusHandwriting(companion5, zCoreTextField$lambda$14, z29, (Function0) objRememberedValue20);
                                                            ProvidableCompositionLocal<Brush> localAutofillHighlightBrush = AutofillHighlightKt.getLocalAutofillHighlightBrush();
                                                            String str2 = str;
                                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str2);
                                                            Object objConsume10 = composerStartRestartGroup.consume(localAutofillHighlightBrush);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            ProvidableCompositionLocal<Color> localAutofillHighlightColor = AutofillHighlightKt.getLocalAutofillHighlightColor();
                                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str2);
                                                            Object objConsume11 = composerStartRestartGroup.consume(localAutofillHighlightColor);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            brushM2351resolveAutofillHighlightWkMShQ = AutofillHighlightKt.m2351resolveAutofillHighlightWkMShQ((Brush) objConsume10, ((Color) objConsume11).m6335unboximpl(), AutofillHighlight_androidKt.autofillHighlightColor());
                                                            Modifier.Companion companion6 = Modifier.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213324568, "CC(remember):CoreTextField.kt#9igjgp");
                                                            zChangedInstance9 = composerStartRestartGroup.changedInstance(legacyTextFieldState6) | composerStartRestartGroup.changed(brushM2351resolveAutofillHighlightWkMShQ);
                                                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                                            if (zChangedInstance9 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                                objRememberedValue6 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda21
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Object invoke(Object obj) {
                                                                        return CoreTextFieldKt.CoreTextField$lambda$24$0(legacyTextFieldState6, brushM2351resolveAutofillHighlightWkMShQ, (ContentDrawScope) obj);
                                                                    }
                                                                };
                                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            Modifier modifierDrawWithContent = DrawModifierKt.drawWithContent(companion6, (Function1) objRememberedValue6);
                                                            OverscrollEffect overscrollEffectRememberTextFieldOverscrollEffect = TextFieldScroll_androidKt.rememberTextFieldOverscrollEffect(composerStartRestartGroup, 0);
                                                            Modifier modifierThen = previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier6.then(modifierDrawWithContent), legacyPlatformTextInputServiceAdapter3, legacyTextFieldState6, textFieldSelectionManager2).then(modifierStylusHandwriting).then(modifierTextFieldFocusModifier), legacyTextFieldState6, focusManager), legacyTextFieldState6, textFieldSelectionManager2).then(modifierM2495textFieldKeyInput2WJ9YEU);
                                                            final TextFieldScrollerPosition textFieldScrollerPosition6 = textFieldScrollerPosition5;
                                                            Modifier modifierAddContextMenuComponents = addContextMenuComponents(OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(modifierThen, textFieldScrollerPosition6, mutableInteractionSource7, z28, overscrollEffectRememberTextFieldOverscrollEffect).then(modifierPointerHoverIcon$default).then(coreTextFieldSemanticsModifier), new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda22
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Object invoke(Object obj) {
                                                                    return CoreTextFieldKt.CoreTextField$lambda$25(legacyTextFieldState6, (LayoutCoordinates) obj);
                                                                }
                                                            }), textFieldSelectionManager2, coroutineScope);
                                                            final boolean z30 = !z28 && legacyTextFieldState6.getHasFocus() && legacyTextFieldState6.isInTouchMode() && windowInfo3.isWindowFocused();
                                                            final Modifier modifierTextFieldMagnifier = !z30 ? TextFieldSelectionManager_androidKt.textFieldMagnifier(Modifier.INSTANCE, textFieldSelectionManager2) : Modifier.INSTANCE;
                                                            final Modifier modifier7 = modifier5;
                                                            final int i47 = i33;
                                                            final TextStyle textStyle6 = textStyle4;
                                                            final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager2;
                                                            final BringIntoViewRequester bringIntoViewRequester3 = bringIntoViewRequester;
                                                            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function33 = lambda$559628295$foundation;
                                                            final boolean z31 = z12;
                                                            CoreTextFieldRootBox(modifierAddContextMenuComponents, textFieldSelectionManager6, ComposableLambdaKt.rememberComposableLambda(-814563849, true, new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda23
                                                                @Override // kotlin.jvm.functions.Function2
                                                                public final Object invoke(Object obj, Object obj2) {
                                                                    return CoreTextFieldKt.CoreTextField$lambda$26(function33, legacyTextFieldState6, textStyle6, i40, i47, textFieldScrollerPosition6, textFieldValue, visualTransformation5, modifier7, modifierDrawBehind, modifierOnGloballyPositioned, modifierTextFieldMagnifier, bringIntoViewRequester3, textFieldSelectionManager6, z30, z31, function15, offsetMapping5, density, (Composer) obj, ((Integer) obj2).intValue());
                                                                }
                                                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 384);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                            function32 = function33;
                                                            i27 = i40;
                                                            composer2 = composerStartRestartGroup;
                                                            function14 = function15;
                                                            imeOptions2 = imeOptions6;
                                                            textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                                            mutableInteractionSource3 = mutableInteractionSource7;
                                                            keyboardActions2 = keyboardActions4;
                                                            brush2 = brush5;
                                                            z6 = z28;
                                                            modifier3 = modifier6;
                                                            i28 = i33;
                                                            z5 = z10;
                                                            textStyle3 = textStyle4;
                                                            z4 = z12;
                                                            visualTransformation2 = visualTransformation5;
                                                        } else {
                                                            i33 = i46;
                                                        }
                                                        objRememberedValue20 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda20
                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                return CoreTextFieldKt.CoreTextField$lambda$23$0(z29, legacyPlatformTextInputServiceAdapter3);
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue20);
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        Modifier modifierStylusHandwriting2 = StylusHandwritingKt.stylusHandwriting(companion5, zCoreTextField$lambda$14, z29, (Function0) objRememberedValue20);
                                                        ProvidableCompositionLocal<Brush> localAutofillHighlightBrush2 = AutofillHighlightKt.getLocalAutofillHighlightBrush();
                                                        String str22 = str;
                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str22);
                                                        Object objConsume102 = composerStartRestartGroup.consume(localAutofillHighlightBrush2);
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        ProvidableCompositionLocal<Color> localAutofillHighlightColor2 = AutofillHighlightKt.getLocalAutofillHighlightColor();
                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str22);
                                                        Object objConsume112 = composerStartRestartGroup.consume(localAutofillHighlightColor2);
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        brushM2351resolveAutofillHighlightWkMShQ = AutofillHighlightKt.m2351resolveAutofillHighlightWkMShQ((Brush) objConsume102, ((Color) objConsume112).m6335unboximpl(), AutofillHighlight_androidKt.autofillHighlightColor());
                                                        Modifier.Companion companion62 = Modifier.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213324568, "CC(remember):CoreTextField.kt#9igjgp");
                                                        zChangedInstance9 = composerStartRestartGroup.changedInstance(legacyTextFieldState6) | composerStartRestartGroup.changed(brushM2351resolveAutofillHighlightWkMShQ);
                                                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                                        if (zChangedInstance9) {
                                                            objRememberedValue6 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda21
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Object invoke(Object obj) {
                                                                    return CoreTextFieldKt.CoreTextField$lambda$24$0(legacyTextFieldState6, brushM2351resolveAutofillHighlightWkMShQ, (ContentDrawScope) obj);
                                                                }
                                                            };
                                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            Modifier modifierDrawWithContent2 = DrawModifierKt.drawWithContent(companion62, (Function1) objRememberedValue6);
                                                            OverscrollEffect overscrollEffectRememberTextFieldOverscrollEffect2 = TextFieldScroll_androidKt.rememberTextFieldOverscrollEffect(composerStartRestartGroup, 0);
                                                            Modifier modifierThen2 = previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier6.then(modifierDrawWithContent2), legacyPlatformTextInputServiceAdapter3, legacyTextFieldState6, textFieldSelectionManager2).then(modifierStylusHandwriting2).then(modifierTextFieldFocusModifier), legacyTextFieldState6, focusManager), legacyTextFieldState6, textFieldSelectionManager2).then(modifierM2495textFieldKeyInput2WJ9YEU);
                                                            final TextFieldScrollerPosition textFieldScrollerPosition62 = textFieldScrollerPosition5;
                                                            Modifier modifierAddContextMenuComponents2 = addContextMenuComponents(OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(modifierThen2, textFieldScrollerPosition62, mutableInteractionSource7, z28, overscrollEffectRememberTextFieldOverscrollEffect2).then(modifierPointerHoverIcon$default).then(coreTextFieldSemanticsModifier), new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda22
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Object invoke(Object obj) {
                                                                    return CoreTextFieldKt.CoreTextField$lambda$25(legacyTextFieldState6, (LayoutCoordinates) obj);
                                                                }
                                                            }), textFieldSelectionManager2, coroutineScope);
                                                            if (z28) {
                                                                final Modifier modifierTextFieldMagnifier2 = !z30 ? TextFieldSelectionManager_androidKt.textFieldMagnifier(Modifier.INSTANCE, textFieldSelectionManager2) : Modifier.INSTANCE;
                                                                final Modifier modifier72 = modifier5;
                                                                final int i472 = i33;
                                                                final TextStyle textStyle62 = textStyle4;
                                                                final TextFieldSelectionManager textFieldSelectionManager62 = textFieldSelectionManager2;
                                                                final BringIntoViewRequester bringIntoViewRequester32 = bringIntoViewRequester;
                                                                final Function3 function332 = lambda$559628295$foundation;
                                                                final boolean z312 = z12;
                                                                CoreTextFieldRootBox(modifierAddContextMenuComponents2, textFieldSelectionManager62, ComposableLambdaKt.rememberComposableLambda(-814563849, true, new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda23
                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public final Object invoke(Object obj, Object obj2) {
                                                                        return CoreTextFieldKt.CoreTextField$lambda$26(function332, legacyTextFieldState6, textStyle62, i40, i472, textFieldScrollerPosition62, textFieldValue, visualTransformation5, modifier72, modifierDrawBehind, modifierOnGloballyPositioned, modifierTextFieldMagnifier2, bringIntoViewRequester32, textFieldSelectionManager62, z30, z312, function15, offsetMapping5, density, (Composer) obj, ((Integer) obj2).intValue());
                                                                    }
                                                                }, composerStartRestartGroup, 54), composerStartRestartGroup, 384);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                }
                                                                function32 = function332;
                                                                i27 = i40;
                                                                composer2 = composerStartRestartGroup;
                                                                function14 = function15;
                                                                imeOptions2 = imeOptions6;
                                                                textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                                                mutableInteractionSource3 = mutableInteractionSource7;
                                                                keyboardActions2 = keyboardActions4;
                                                                brush2 = brush5;
                                                                z6 = z28;
                                                                modifier3 = modifier6;
                                                                i28 = i33;
                                                                z5 = z10;
                                                                textStyle3 = textStyle4;
                                                                z4 = z12;
                                                                visualTransformation2 = visualTransformation5;
                                                            }
                                                        }
                                                    } else {
                                                        modifier5 = modifierCursor;
                                                    }
                                                    objRememberedValue19 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda18
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj) {
                                                            return CoreTextFieldKt.CoreTextField$lambda$21$0(textFieldSelectionManager2, (DisposableEffectScope) obj);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue19);
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    EffectsKt.DisposableEffect(textFieldSelectionManager2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue19, composerStartRestartGroup, 0);
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213403624, "CC(remember):CoreTextField.kt#9igjgp");
                                                    if (i45 > 32) {
                                                        zChangedInstance8 = composerStartRestartGroup.changedInstance(legacyTextFieldState6) | composerStartRestartGroup.changedInstance(textInputService) | (i41 == 4) | ((i45 > 32 && composerStartRestartGroup.changed(imeOptions6)) || (i43 & 48) == 32);
                                                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                                        if (zChangedInstance8) {
                                                            objRememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda19
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Object invoke(Object obj) {
                                                                    return CoreTextFieldKt.CoreTextField$lambda$22$0(legacyTextFieldState6, textInputService, textFieldValue, imeOptions6, (DisposableEffectScope) obj);
                                                                }
                                                            };
                                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            EffectsKt.DisposableEffect(imeOptions6, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue5, composerStartRestartGroup, (i43 >> 3) & 14);
                                                            int i462 = i32;
                                                            Modifier modifierM2495textFieldKeyInput2WJ9YEU2 = TextFieldKeyInputKt.m2495textFieldKeyInput2WJ9YEU(Modifier.INSTANCE, legacyTextFieldState6, textFieldSelectionManager2, textFieldValue, legacyTextFieldState6.getOnValueChange(), !z12, i462 != 1, offsetMapping5, undoManager, imeOptions6.getImeAction());
                                                            if (KeyboardType.m8783equalsimpl0(imeOptions6.getKeyboardType(), KeyboardType.INSTANCE.m8802getPasswordPjHm6EE())) {
                                                                Modifier.Companion companion52 = Modifier.INSTANCE;
                                                                boolean zCoreTextField$lambda$142 = CoreTextField$lambda$14(state2);
                                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213365476, "CC(remember):CoreTextField.kt#9igjgp");
                                                                final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter32 = legacyPlatformTextInputServiceAdapter;
                                                                zChanged2 = composerStartRestartGroup.changed(z29) | composerStartRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter32);
                                                                Object objRememberedValue202 = composerStartRestartGroup.rememberedValue();
                                                                if (zChanged2) {
                                                                }
                                                                objRememberedValue202 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda20
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        return CoreTextFieldKt.CoreTextField$lambda$23$0(z29, legacyPlatformTextInputServiceAdapter32);
                                                                    }
                                                                };
                                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue202);
                                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                                Modifier modifierStylusHandwriting22 = StylusHandwritingKt.stylusHandwriting(companion52, zCoreTextField$lambda$142, z29, (Function0) objRememberedValue202);
                                                                ProvidableCompositionLocal<Brush> localAutofillHighlightBrush22 = AutofillHighlightKt.getLocalAutofillHighlightBrush();
                                                                String str222 = str;
                                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str222);
                                                                Object objConsume1022 = composerStartRestartGroup.consume(localAutofillHighlightBrush22);
                                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                                ProvidableCompositionLocal<Color> localAutofillHighlightColor22 = AutofillHighlightKt.getLocalAutofillHighlightColor();
                                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, str222);
                                                                Object objConsume1122 = composerStartRestartGroup.consume(localAutofillHighlightColor22);
                                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                                brushM2351resolveAutofillHighlightWkMShQ = AutofillHighlightKt.m2351resolveAutofillHighlightWkMShQ((Brush) objConsume1022, ((Color) objConsume1122).m6335unboximpl(), AutofillHighlight_androidKt.autofillHighlightColor());
                                                                Modifier.Companion companion622 = Modifier.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213324568, "CC(remember):CoreTextField.kt#9igjgp");
                                                                zChangedInstance9 = composerStartRestartGroup.changedInstance(legacyTextFieldState6) | composerStartRestartGroup.changed(brushM2351resolveAutofillHighlightWkMShQ);
                                                                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                                                if (zChangedInstance9) {
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        zChangedInstance8 = composerStartRestartGroup.changedInstance(legacyTextFieldState6) | composerStartRestartGroup.changedInstance(textInputService) | (i41 == 4) | ((i45 > 32 && composerStartRestartGroup.changed(imeOptions6)) || (i43 & 48) == 32);
                                                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                                        if (zChangedInstance8) {
                                                        }
                                                    }
                                                } else {
                                                    z18 = z17;
                                                }
                                                pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$3$1
                                                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                                        Object objAwaitSelectionGestures = SelectionGesturesKt.awaitSelectionGestures(pointerInputScope, textFieldSelectionManager2.getMouseSelectionObserver(), textFieldSelectionManager2.getTouchSelectionObserver(), continuation);
                                                        return objAwaitSelectionGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitSelectionGestures : Unit.INSTANCE;
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                Modifier modifierPointerHoverIcon$default2 = PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput(modifierTapPressTextFieldModifier, mouseSelectionObserver, touchSelectionObserver, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), PointerIcon.INSTANCE.getText(), false, 2, null);
                                                Modifier.Companion companion32 = Modifier.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213497918, "CC(remember):CoreTextField.kt#9igjgp");
                                                zChangedInstance5 = composerStartRestartGroup.changedInstance(legacyTextFieldState2) | (i41 == 4) | composerStartRestartGroup.changedInstance(offsetMapping);
                                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                                if (zChangedInstance5) {
                                                    textFieldValue2 = textFieldValue;
                                                    objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda9
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj) {
                                                            return CoreTextFieldKt.CoreTextField$lambda$19$0(legacyTextFieldState2, textFieldValue2, offsetMapping, (DrawScope) obj);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    final Modifier modifierDrawBehind2 = DrawModifierKt.drawBehind(companion32, (Function1) objRememberedValue3);
                                                    Modifier.Companion companion42 = Modifier.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213476153, "CC(remember):CoreTextField.kt#9igjgp");
                                                    windowInfo2 = windowInfo;
                                                    zChangedInstance6 = (i42 != 2048) | composerStartRestartGroup.changedInstance(legacyTextFieldState2) | composerStartRestartGroup.changed(windowInfo2) | composerStartRestartGroup.changedInstance(textFieldSelectionManager2) | (i41 != 4) | composerStartRestartGroup.changedInstance(offsetMapping);
                                                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                                    if (zChangedInstance6) {
                                                        final TextFieldValue textFieldValue32 = textFieldValue2;
                                                        final OffsetMapping offsetMapping42 = offsetMapping;
                                                        final TextFieldSelectionManager textFieldSelectionManager52 = textFieldSelectionManager2;
                                                        final LegacyTextFieldState legacyTextFieldState52 = legacyTextFieldState2;
                                                        objRememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda10
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj) {
                                                                return CoreTextFieldKt.CoreTextField$lambda$20$0(legacyTextFieldState52, z18, windowInfo2, textFieldSelectionManager52, textFieldValue32, offsetMapping42, (LayoutCoordinates) obj);
                                                            }
                                                        };
                                                        z19 = z18;
                                                        windowInfo3 = windowInfo2;
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        final Modifier modifierOnGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion42, (Function1) objRememberedValue4);
                                                        final VisualTransformation visualTransformation52 = visualTransformation4;
                                                        boolean z282 = z19;
                                                        CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier2 = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState2, z12, z282, visualTransformation52 instanceof PasswordVisualTransformation, offsetMapping, textFieldSelectionManager2, imeOptions6, focusRequester3);
                                                        if (z282) {
                                                            Brush brush52 = brush4;
                                                            final OffsetMapping offsetMapping52 = offsetMapping;
                                                            final LegacyTextFieldState legacyTextFieldState62 = legacyTextFieldState2;
                                                            Modifier modifierCursor2 = TextFieldCursorKt.cursor(Modifier.INSTANCE, legacyTextFieldState62, textFieldValue, offsetMapping52, brush52, (z282 || z12 || !windowInfo3.isWindowFocused() || legacyTextFieldState2.hasHighlight()) ? false : true);
                                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213406735, "CC(remember):CoreTextField.kt#9igjgp");
                                                            zChangedInstance7 = composerStartRestartGroup.changedInstance(textFieldSelectionManager2);
                                                            Object objRememberedValue192 = composerStartRestartGroup.rememberedValue();
                                                            if (zChangedInstance7) {
                                                            }
                                                            objRememberedValue192 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda18
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Object invoke(Object obj) {
                                                                    return CoreTextFieldKt.CoreTextField$lambda$21$0(textFieldSelectionManager2, (DisposableEffectScope) obj);
                                                                }
                                                            };
                                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue192);
                                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                            EffectsKt.DisposableEffect(textFieldSelectionManager2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue192, composerStartRestartGroup, 0);
                                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213403624, "CC(remember):CoreTextField.kt#9igjgp");
                                                        }
                                                    }
                                                }
                                            } else {
                                                z14 = zChanged;
                                            }
                                            z15 = true;
                                            z16 = z14 | z15;
                                            coreTextFieldKt$CoreTextField$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (z16) {
                                                CoreTextFieldKt$CoreTextField$5$1 coreTextFieldKt$CoreTextField$5$12 = new CoreTextFieldKt$CoreTextField$5$1(legacyTextFieldState2, stateRememberUpdatedState, textInputService, textFieldSelectionManager2, imeOptions5, null);
                                                state = stateRememberUpdatedState;
                                                coreTextFieldKt$CoreTextField$5$1RememberedValue = coreTextFieldKt$CoreTextField$5$12;
                                                composerStartRestartGroup.updateRememberedValue(coreTextFieldKt$CoreTextField$5$1RememberedValue);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                State state22 = state;
                                                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) coreTextFieldKt$CoreTextField$5$1RememberedValue, composerStartRestartGroup, 6);
                                                Modifier.Companion companion22 = Modifier.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213545091, "CC(remember):CoreTextField.kt#9igjgp");
                                                zChangedInstance2 = composerStartRestartGroup.changedInstance(legacyTextFieldState2);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (!zChangedInstance2) {
                                                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda7
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj) {
                                                            return CoreTextFieldKt.CoreTextField$lambda$16$0(legacyTextFieldState2, ((Boolean) obj).booleanValue());
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    Modifier modifierUpdateSelectionTouchMode2 = SelectionGesturesKt.updateSelectionTouchMode(companion22, (Function1) objRememberedValue);
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213541055, "CC(remember):CoreTextField.kt#9igjgp");
                                                    zChangedInstance3 = composerStartRestartGroup.changedInstance(legacyTextFieldState2) | (i44 != 16384) | (i42 != 2048) | composerStartRestartGroup.changedInstance(offsetMapping) | composerStartRestartGroup.changedInstance(textFieldSelectionManager2);
                                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                    if (zChangedInstance3) {
                                                        final OffsetMapping offsetMapping32 = offsetMapping;
                                                        final TextFieldSelectionManager textFieldSelectionManager42 = textFieldSelectionManager2;
                                                        final LegacyTextFieldState legacyTextFieldState42 = legacyTextFieldState2;
                                                        final boolean z272 = z12;
                                                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda8
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj) {
                                                                return CoreTextFieldKt.CoreTextField$lambda$17$0(legacyTextFieldState42, focusRequester2, z272, z26, textFieldSelectionManager42, offsetMapping32, (Offset) obj);
                                                            }
                                                        };
                                                        focusRequester = focusRequester2;
                                                        z17 = z26;
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        Modifier modifierTapPressTextFieldModifier2 = TextFieldPressGestureFilterKt.tapPressTextFieldModifier(modifierUpdateSelectionTouchMode2, mutableInteractionSource7, z17, (Function1) objRememberedValue2);
                                                        MouseSelectionObserver mouseSelectionObserver2 = textFieldSelectionManager2.getMouseSelectionObserver();
                                                        FocusRequester focusRequester32 = focusRequester;
                                                        TextDragObserver touchSelectionObserver2 = textFieldSelectionManager2.getTouchSelectionObserver();
                                                        final ImeOptions imeOptions62 = imeOptions5;
                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213507214, "CC(remember):CoreTextField.kt#9igjgp");
                                                        zChangedInstance4 = composerStartRestartGroup.changedInstance(textFieldSelectionManager2);
                                                        PointerInputEventHandler pointerInputEventHandlerRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                        if (zChangedInstance4) {
                                                        }
                                                        pointerInputEventHandlerRememberedValue2 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$3$1
                                                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                                                Object objAwaitSelectionGestures = SelectionGesturesKt.awaitSelectionGestures(pointerInputScope, textFieldSelectionManager2.getMouseSelectionObserver(), textFieldSelectionManager2.getTouchSelectionObserver(), continuation);
                                                                return objAwaitSelectionGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitSelectionGestures : Unit.INSTANCE;
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue2);
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        Modifier modifierPointerHoverIcon$default22 = PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput(modifierTapPressTextFieldModifier2, mouseSelectionObserver2, touchSelectionObserver2, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue2), PointerIcon.INSTANCE.getText(), false, 2, null);
                                                        Modifier.Companion companion322 = Modifier.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213497918, "CC(remember):CoreTextField.kt#9igjgp");
                                                        zChangedInstance5 = composerStartRestartGroup.changedInstance(legacyTextFieldState2) | (i41 == 4) | composerStartRestartGroup.changedInstance(offsetMapping);
                                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                                        if (zChangedInstance5) {
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            textFieldSelectionManager = textFieldSelectionManager3;
                                        }
                                        final ImeOptions imeOptions7 = imeOptions4;
                                        final boolean z32 = z8;
                                        objRememberedValue18 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda6
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return CoreTextFieldKt.CoreTextField$lambda$13$0(legacyTextFieldState, z25, z32, textInputService2, textFieldValue, imeOptions7, offsetMapping2, textFieldSelectionManager, coroutineScope2, bringIntoViewRequester2, (FocusState) obj);
                                            }
                                        };
                                        legacyTextFieldState2 = legacyTextFieldState;
                                        z12 = z32;
                                        textInputService = textInputService2;
                                        imeOptions5 = imeOptions7;
                                        offsetMapping = offsetMapping2;
                                        coroutineScope = coroutineScope2;
                                        bringIntoViewRequester = bringIntoViewRequester2;
                                        visualTransformation4 = visualTransformation3;
                                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                        z13 = z25;
                                        textFieldSelectionManager2 = textFieldSelectionManager;
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue18);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        Modifier modifierTextFieldFocusModifier2 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion, z13, focusRequester2, mutableInteractionSource7, (Function1) objRememberedValue18);
                                        if (z13) {
                                            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z13 && !z12), composerStartRestartGroup, 0);
                                            Unit unit2 = Unit.INSTANCE;
                                            final boolean z262 = z13;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213577460, "CC(remember):CoreTextField.kt#9igjgp");
                                            zChanged = composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changedInstance(legacyTextFieldState2) | composerStartRestartGroup.changedInstance(textInputService) | composerStartRestartGroup.changedInstance(textFieldSelectionManager2);
                                            if (i45 > 32) {
                                                z14 = zChanged;
                                                if ((i43 & 48) != 32) {
                                                    z15 = true;
                                                }
                                                z16 = z14 | z15;
                                                coreTextFieldKt$CoreTextField$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (z16) {
                                                }
                                            }
                                        }
                                    } else {
                                        legacyTextFieldState = legacyTextFieldState3;
                                    }
                                    z11 = true;
                                    zChangedInstance = zChangedInstance10 | z11 | composerStartRestartGroup.changedInstance(offsetMapping2) | composerStartRestartGroup.changedInstance(coroutineScope2) | composerStartRestartGroup.changedInstance(bringIntoViewRequester2) | composerStartRestartGroup.changedInstance(textFieldSelectionManager3);
                                    Object objRememberedValue182 = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance) {
                                    }
                                    final ImeOptions imeOptions72 = imeOptions4;
                                    final boolean z322 = z8;
                                    objRememberedValue182 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda6
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CoreTextFieldKt.CoreTextField$lambda$13$0(legacyTextFieldState, z25, z322, textInputService2, textFieldValue, imeOptions72, offsetMapping2, textFieldSelectionManager, coroutineScope2, bringIntoViewRequester2, (FocusState) obj);
                                        }
                                    };
                                    legacyTextFieldState2 = legacyTextFieldState;
                                    z12 = z322;
                                    textInputService = textInputService2;
                                    imeOptions5 = imeOptions72;
                                    offsetMapping = offsetMapping2;
                                    coroutineScope = coroutineScope2;
                                    bringIntoViewRequester = bringIntoViewRequester2;
                                    visualTransformation4 = visualTransformation3;
                                    str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                    z13 = z25;
                                    textFieldSelectionManager2 = textFieldSelectionManager;
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue182);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    Modifier modifierTextFieldFocusModifier22 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion, z13, focusRequester2, mutableInteractionSource7, (Function1) objRememberedValue182);
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    i27 = i2;
                                    keyboardActions2 = keyboardActions;
                                    z4 = z3;
                                    function32 = function3;
                                    textFieldScrollerPosition2 = textFieldScrollerPosition;
                                    composer2 = composerStartRestartGroup;
                                    brush2 = solidColor;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    function14 = function13;
                                    textStyle3 = textStyle2;
                                    modifier3 = modifier2;
                                    visualTransformation2 = visualTransformation;
                                    z5 = z;
                                    i28 = i;
                                    imeOptions2 = imeOptions;
                                    z6 = z2;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return CoreTextFieldKt.CoreTextField$lambda$27(textFieldValue, function1, modifier3, textStyle3, visualTransformation2, function14, mutableInteractionSource3, brush2, z5, i28, i27, imeOptions2, keyboardActions2, z6, z4, function32, textFieldScrollerPosition2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i24 = i22 | 24576;
                            i25 = i5 & 32768;
                            if (i25 != 0) {
                            }
                            i26 = i5 & 65536;
                            if (i26 != 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (i24 & 599187) == 599186) ? false : true, i6 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i15 = i14;
                        i16 = i5 & 1024;
                        if (i16 == 0) {
                        }
                        if ((i4 & 48) == 0) {
                        }
                        int i352 = i18;
                        i19 = i5 & 4096;
                        if (i19 == 0) {
                        }
                        i21 = i5 & 8192;
                        if (i21 == 0) {
                        }
                        i23 = i5 & 16384;
                        if (i23 != 0) {
                        }
                        i25 = i5 & 32768;
                        if (i25 != 0) {
                        }
                        i26 = i5 & 65536;
                        if (i26 != 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (i24 & 599187) == 599186) ? false : true, i6 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i13 = i12;
                    i14 = i5 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i5 & 1024;
                    if (i16 == 0) {
                    }
                    if ((i4 & 48) == 0) {
                    }
                    int i3522 = i18;
                    i19 = i5 & 4096;
                    if (i19 == 0) {
                    }
                    i21 = i5 & 8192;
                    if (i21 == 0) {
                    }
                    i23 = i5 & 16384;
                    if (i23 != 0) {
                    }
                    i25 = i5 & 32768;
                    if (i25 != 0) {
                    }
                    i26 = i5 & 65536;
                    if (i26 != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (i24 & 599187) == 599186) ? false : true, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
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
                i13 = i12;
                i14 = i5 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i5 & 1024;
                if (i16 == 0) {
                }
                if ((i4 & 48) == 0) {
                }
                int i35222 = i18;
                i19 = i5 & 4096;
                if (i19 == 0) {
                }
                i21 = i5 & 8192;
                if (i21 == 0) {
                }
                i23 = i5 & 16384;
                if (i23 != 0) {
                }
                i25 = i5 & 32768;
                if (i25 != 0) {
                }
                i26 = i5 & 65536;
                if (i26 != 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (i24 & 599187) == 599186) ? false : true, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            textStyle2 = textStyle;
            i8 = i5 & 16;
            if (i8 != 0) {
            }
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
            i13 = i12;
            i14 = i5 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i5 & 1024;
            if (i16 == 0) {
            }
            if ((i4 & 48) == 0) {
            }
            int i352222 = i18;
            i19 = i5 & 4096;
            if (i19 == 0) {
            }
            i21 = i5 & 8192;
            if (i21 == 0) {
            }
            i23 = i5 & 16384;
            if (i23 != 0) {
            }
            i25 = i5 & 32768;
            if (i25 != 0) {
            }
            i26 = i5 & 65536;
            if (i26 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (i24 & 599187) == 599186) ? false : true, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 8;
        if (i7 == 0) {
        }
        textStyle2 = textStyle;
        i8 = i5 & 16;
        if (i8 != 0) {
        }
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
        i13 = i12;
        i14 = i5 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i5 & 1024;
        if (i16 == 0) {
        }
        if ((i4 & 48) == 0) {
        }
        int i3522222 = i18;
        i19 = i5 & 4096;
        if (i19 == 0) {
        }
        i21 = i5 & 8192;
        if (i21 == 0) {
        }
        i23 = i5 & 16384;
        if (i23 != 0) {
        }
        i25 = i5 & 32768;
        if (i25 != 0) {
        }
        i26 = i5 & 65536;
        if (i26 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (i24 & 599187) == 599186) ? false : true, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$0$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    static final Unit CoreTextField$lambda$10(TextFieldSelectionManager textFieldSelectionManager, AnnotatedString annotatedString) {
        textFieldSelectionManager.paste$foundation(annotatedString);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$13$0(LegacyTextFieldState legacyTextFieldState, boolean z, boolean z2, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping, TextFieldSelectionManager textFieldSelectionManager, CoroutineScope coroutineScope, BringIntoViewRequester bringIntoViewRequester, FocusState focusState) {
        TextLayoutResultProxy layoutResult;
        if (legacyTextFieldState.getHasFocus() == focusState.isFocused()) {
            return Unit.INSTANCE;
        }
        legacyTextFieldState.setHasFocus(focusState.isFocused());
        if (legacyTextFieldState.getHasFocus() && z && !z2) {
            startInputSession(textInputService, legacyTextFieldState, textFieldValue, imeOptions, offsetMapping);
        } else {
            endInputSession(legacyTextFieldState);
        }
        if (focusState.isFocused() && (layoutResult = legacyTextFieldState.getLayoutResult()) != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester, textFieldValue, legacyTextFieldState, layoutResult, offsetMapping, null), 3, null);
        }
        if (!focusState.isFocused()) {
            TextFieldSelectionManager.m2874deselect_kEHs6E$foundation$default(textFieldSelectionManager, null, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CoreTextField$lambda$14(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$16$0(LegacyTextFieldState legacyTextFieldState, boolean z) {
        legacyTextFieldState.setInTouchMode(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$17$0(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z, boolean z2, TextFieldSelectionManager textFieldSelectionManager, OffsetMapping offsetMapping, Offset offset) {
        tapToFocus(legacyTextFieldState, focusRequester, !z);
        if (legacyTextFieldState.getHasFocus() && z2) {
            if (legacyTextFieldState.getHandleState() != HandleState.Selection) {
                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                if (layoutResult != null) {
                    TextFieldDelegate.INSTANCE.m2483setCursorOffsetULxng0E$foundation(offset.m6090unboximpl(), layoutResult, legacyTextFieldState.getProcessor(), offsetMapping, legacyTextFieldState.getOnValueChange());
                    if (legacyTextFieldState.getTextDelegate().getText().length() > 0) {
                        legacyTextFieldState.setHandleState(HandleState.Cursor);
                    }
                }
            } else {
                textFieldSelectionManager.m2878deselect_kEHs6E$foundation(offset);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$19$0(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping, DrawScope drawScope) {
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult != null) {
            TextFieldDelegate.INSTANCE.m2481drawQ1vqE60$foundation(drawScope.getDrawContext().getCanvas(), textFieldValue, legacyTextFieldState.m2440getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState.m2437getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping, layoutResult.getValue(), legacyTextFieldState.getHighlightPaint(), legacyTextFieldState.getSelectionBackgroundColor());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$20$0(LegacyTextFieldState legacyTextFieldState, boolean z, WindowInfo windowInfo, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, OffsetMapping offsetMapping, LayoutCoordinates layoutCoordinates) {
        TextInputSession inputSession;
        legacyTextFieldState.setLayoutCoordinates(layoutCoordinates);
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult != null) {
            layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
        }
        if (z) {
            if (legacyTextFieldState.getHandleState() == HandleState.Selection) {
                if (legacyTextFieldState.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                    textFieldSelectionManager.showSelectionToolbar$foundation();
                } else {
                    textFieldSelectionManager.hideSelectionToolbar$foundation();
                }
                legacyTextFieldState.setShowSelectionHandleStart(TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                legacyTextFieldState.setShowSelectionHandleEnd(TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, false));
                legacyTextFieldState.setShowCursorHandle(TextRange.m8550getCollapsedimpl(textFieldValue.getSelection()));
            } else if (legacyTextFieldState.getHandleState() == HandleState.Cursor) {
                legacyTextFieldState.setShowCursorHandle(TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
            }
            notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
            TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
            if (layoutResult2 != null && (inputSession = legacyTextFieldState.getInputSession()) != null && legacyTextFieldState.getHasFocus()) {
                TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation(inputSession, textFieldValue, offsetMapping, layoutResult2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult CoreTextField$lambda$21$0(final TextFieldSelectionManager textFieldSelectionManager, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$lambda$21$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                textFieldSelectionManager.hideSelectionToolbar$foundation();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult CoreTextField$lambda$22$0(LegacyTextFieldState legacyTextFieldState, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, DisposableEffectScope disposableEffectScope) {
        if (legacyTextFieldState.getHasFocus()) {
            legacyTextFieldState.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation(textInputService, textFieldValue, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
        }
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$lambda$22$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$23$0(boolean z, LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter) {
        if (z) {
            legacyPlatformTextInputServiceAdapter.startStylusHandwriting();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$24$0(LegacyTextFieldState legacyTextFieldState, Brush brush, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        if (legacyTextFieldState.getAutofillHighlightOn() || legacyTextFieldState.getJustAutofilled()) {
            DrawScope.m6892drawRectAsUm42w$default(contentDrawScope, brush, 0L, 0L, 0.0f, null, null, 0, 126, null);
        }
        return Unit.INSTANCE;
    }

    static final Unit CoreTextField$lambda$25(LegacyTextFieldState legacyTextFieldState, LayoutCoordinates layoutCoordinates) {
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult != null) {
            layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
        }
        return Unit.INSTANCE;
    }

    static final Unit CoreTextField$lambda$26(Function3 function3, final LegacyTextFieldState legacyTextFieldState, final TextStyle textStyle, final int i, final int i2, final TextFieldScrollerPosition textFieldScrollerPosition, final TextFieldValue textFieldValue, final VisualTransformation visualTransformation, final Modifier modifier, final Modifier modifier2, final Modifier modifier3, final Modifier modifier4, final BringIntoViewRequester bringIntoViewRequester, final TextFieldSelectionManager textFieldSelectionManager, final boolean z, final boolean z2, final Function1 function1, final OffsetMapping offsetMapping, final Density density, Composer composer, int i3) {
        ComposerKt.sourceInformation(composer, "C588@27697L5379,588@27683L5393:CoreTextField.kt#423gt5");
        if (composer.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-814563849, i3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:588)");
            }
            function3.invoke(ComposableLambdaKt.rememberComposableLambda(-44346382, true, new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoreTextFieldKt.CoreTextField$lambda$26$0(legacyTextFieldState, textStyle, i, i2, textFieldScrollerPosition, textFieldValue, visualTransformation, modifier, modifier2, modifier3, modifier4, bringIntoViewRequester, textFieldSelectionManager, z, z2, function1, offsetMapping, density, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final Unit CoreTextField$lambda$26$0(final LegacyTextFieldState legacyTextFieldState, TextStyle textStyle, int i, final int i2, TextFieldScrollerPosition textFieldScrollerPosition, final TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, final TextFieldSelectionManager textFieldSelectionManager, final boolean z, final boolean z2, final Function1 function1, final OffsetMapping offsetMapping, final Density density, Composer composer, int i3) {
        ComposerKt.sourceInformation(composer, "C602@28548L22,611@28935L4131,611@28899L4167:CoreTextField.kt#423gt5");
        if (composer.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-44346382, i3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:591)");
            }
            Modifier modifierHeightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m2071heightInVpY3zN4$default(Modifier.INSTANCE, legacyTextFieldState.m2438getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle, i, i2);
            ComposerKt.sourceInformationMarkerStart(composer, 332827112, "CC(remember):CoreTextField.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(legacyTextFieldState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return legacyTextFieldState.getLayoutResult();
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SimpleLayoutKt.SimpleLayout(BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScroll_androidKt.textFieldScroll(modifierHeightInLines, textFieldScrollerPosition, textFieldValue, visualTransformation, (Function0) objRememberedValue).then(modifier).then(modifier2), textStyle).then(modifier3).then(modifier4), bringIntoViewRequester), ComposableLambdaKt.rememberComposableLambda(1412697320, true, new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoreTextFieldKt.CoreTextField$lambda$26$0$1(textFieldSelectionManager, legacyTextFieldState, z, z2, function1, textFieldValue, offsetMapping, density, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit CoreTextField$lambda$26$0$1(TextFieldSelectionManager textFieldSelectionManager, LegacyTextFieldState legacyTextFieldState, boolean z, boolean z2, Function1 function1, TextFieldValue textFieldValue, OffsetMapping offsetMapping, Density density, int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C612@28953L3502,677@32473L359:CoreTextField.kt#423gt5");
        boolean z3 = true;
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1412697320, i2, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:612)");
            }
            CoreTextFieldKt$CoreTextField$8$1$1$2 coreTextFieldKt$CoreTextField$8$1$1$2 = new CoreTextFieldKt$CoreTextField$8$1$1$2(legacyTextFieldState, function1, textFieldValue, offsetMapping, density, i);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            Updater.m5603setimpl(composerM5595constructorimpl, coreTextFieldKt$CoreTextField$8$1$1$2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1613409842, "C:CoreTextField.kt#423gt5");
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (legacyTextFieldState.getHandleState() == HandleState.None || legacyTextFieldState.getLayoutCoordinates() == null) {
                z3 = false;
                SelectionToolbarAndHandles(textFieldSelectionManager, z3, composer, 0);
                if (legacyTextFieldState.getHandleState() == HandleState.Cursor || z2 || !z) {
                    composer.startReplaceGroup(-747377894);
                } else {
                    composer.startReplaceGroup(-714666198);
                    ComposerKt.sourceInformation(composer, "689@32994L40");
                    TextFieldCursorHandle(textFieldSelectionManager, composer, 0);
                }
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
                Intrinsics.checkNotNull(layoutCoordinates);
                if (!layoutCoordinates.isAttached() || !z) {
                }
                SelectionToolbarAndHandles(textFieldSelectionManager, z3, composer, 0);
                if (legacyTextFieldState.getHandleState() == HandleState.Cursor) {
                    composer.startReplaceGroup(-747377894);
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit CoreTextField$lambda$27(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z, int i, int i2, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z2, boolean z3, Function3 function3, TextFieldScrollerPosition textFieldScrollerPosition, int i3, int i4, int i5, Composer composer, int i6) {
        CoreTextField(textFieldValue, function1, modifier, textStyle, visualTransformation, function12, mutableInteractionSource, brush, z, i, i2, imeOptions, keyboardActions, z2, z3, function3, textFieldScrollerPosition, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldScrollerPosition CoreTextField$lambda$4$0(Orientation orientation) {
        return new TextFieldScrollerPosition(orientation, 0.0f, 2, null);
    }

    private static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2036174316);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CoreTextFieldRootBox)N(modifier,manager,content)702@33241L83:CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2036174316, i2, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:701)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1799443472, "C702@33289L33:CoreTextField.kt#423gt5");
            ContextMenu_androidKt.ContextMenuArea(textFieldSelectionManager, function2, composerStartRestartGroup, (i2 >> 3) & 126);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoreTextFieldKt.CoreTextFieldRootBox$lambda$1(modifier, textFieldSelectionManager, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit CoreTextFieldRootBox$lambda$1(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, Function2 function2, int i, Composer composer, int i2) {
        CoreTextFieldRootBox(modifier, textFieldSelectionManager, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final void SelectionToolbarAndHandles(final TextFieldSelectionManager textFieldSelectionManager, final boolean z, Composer composer, final int i) {
        int i2;
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer composerStartRestartGroup = composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectionToolbarAndHandles)N(manager,show):CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626339208, i2, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1054)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(1530097388);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                LegacyTextFieldState state = textFieldSelectionManager.getState();
                TextLayoutResult textLayoutResult = null;
                if (state != null && (layoutResult = state.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                    LegacyTextFieldState state2 = textFieldSelectionManager.getState();
                    if (!(state2 != null ? state2.getIsLayoutResultStale() : true)) {
                        textLayoutResult = value;
                    }
                }
                if (textLayoutResult == null) {
                    composerStartRestartGroup.startReplaceGroup(1530097387);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1530097388);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (TextRange.m8550getCollapsedimpl(textFieldSelectionManager.getValue$foundation().getSelection())) {
                        composerStartRestartGroup.startReplaceGroup(2062097806);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2109807302);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        int iOriginalToTransformed = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m8556getStartimpl(textFieldSelectionManager.getValue$foundation().getSelection()));
                        int iOriginalToTransformed2 = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m8551getEndimpl(textFieldSelectionManager.getValue$foundation().getSelection()));
                        ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(iOriginalToTransformed);
                        ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(iOriginalToTransformed2 - 1, 0));
                        LegacyTextFieldState state3 = textFieldSelectionManager.getState();
                        if (state3 == null || !state3.getShowSelectionHandleStart()) {
                            composerStartRestartGroup.startReplaceGroup(2062097806);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(2110225306);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1070@48536L220");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, composerStartRestartGroup, ((i2 << 6) & 896) | 6);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        LegacyTextFieldState state4 = textFieldSelectionManager.getState();
                        if (state4 == null || !state4.getShowSelectionHandleEnd()) {
                            composerStartRestartGroup.startReplaceGroup(2062097806);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(2110574459);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1077@48888L219");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, composerStartRestartGroup, ((i2 << 6) & 896) | 6);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    LegacyTextFieldState state5 = textFieldSelectionManager.getState();
                    if (state5 != null) {
                        if (textFieldSelectionManager.isTextChanged$foundation()) {
                            state5.setShowFloatingToolbar(false);
                        }
                        if (state5.getHasFocus()) {
                            if (state5.getShowFloatingToolbar()) {
                                textFieldSelectionManager.showSelectionToolbar$foundation();
                            } else {
                                textFieldSelectionManager.hideSelectionToolbar$foundation();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1989076778);
                composerStartRestartGroup.endReplaceGroup();
                textFieldSelectionManager.hideSelectionToolbar$foundation();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoreTextFieldKt.SelectionToolbarAndHandles$lambda$1(textFieldSelectionManager, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SelectionToolbarAndHandles$lambda$1(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Composer composer, int i2) {
        SelectionToolbarAndHandles(textFieldSelectionManager, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i) {
        int i2;
        AnnotatedString transformedText$foundation;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1436003720);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldCursorHandle)N(manager):CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1436003720, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1101)");
            }
            LegacyTextFieldState state = textFieldSelectionManager.getState();
            if (state == null || !state.getShowCursorHandle() || (transformedText$foundation = textFieldSelectionManager.getTransformedText$foundation()) == null || transformedText$foundation.length() <= 0) {
                composerStartRestartGroup.startReplaceGroup(2132946858);
            } else {
                composerStartRestartGroup.startReplaceGroup(-2112351432);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1103@50051L50,1104@50164L7,1106@50224L12,1108@50309L645,1120@50986L385,1105@50181L1201");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1315066870, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(textFieldSelectionManager);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = textFieldSelectionManager.cursorDragObserver$foundation();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final long jM2880getCursorPositiontuRUvjQ$foundation = textFieldSelectionManager.m2880getCursorPositiontuRUvjQ$foundation((Density) objConsume);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1315061372, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(jM2880getCursorPositiontuRUvjQ$foundation);
                OffsetProvider offsetProviderRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || offsetProviderRememberedValue == Composer.INSTANCE.getEmpty()) {
                    offsetProviderRememberedValue = new OffsetProvider() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0 */
                        public final long mo2363provideF1C5BW0() {
                            return jM2880getCursorPositiontuRUvjQ$foundation;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(offsetProviderRememberedValue);
                }
                OffsetProvider offsetProvider = (OffsetProvider) offsetProviderRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1315058019, "CC(remember):CoreTextField.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(textDragObserver) | composerStartRestartGroup.changedInstance(textFieldSelectionManager);
                PointerInputEventHandler pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || pointerInputEventHandlerRememberedValue == Composer.INSTANCE.getEmpty()) {
                    pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1

                        /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: CoreTextField.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1", f = "CoreTextField.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ TextFieldSelectionManager $manager;
                            final /* synthetic */ TextDragObserver $observer;
                            final /* synthetic */ PointerInputScope $this_pointerInput;
                            private /* synthetic */ Object L$0;
                            int label;

                            /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* JADX INFO: compiled from: CoreTextField.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1", f = "CoreTextField.kt", i = {}, l = {1114}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                            static final class C00391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ TextDragObserver $observer;
                                final /* synthetic */ PointerInputScope $this_pointerInput;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C00391(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation<? super C00391> continuation) {
                                    super(2, continuation);
                                    this.$this_pointerInput = pointerInputScope;
                                    this.$observer = textDragObserver;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C00391(this.$this_pointerInput, this.$observer, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C00391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver(this.$this_pointerInput, this.$observer, this) == coroutine_suspended) {
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

                            /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2, reason: invalid class name */
                            /* JADX INFO: compiled from: CoreTextField.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2", f = "CoreTextField.kt", i = {}, l = {1117}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ TextFieldSelectionManager $manager;
                                final /* synthetic */ PointerInputScope $this_pointerInput;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass2(PointerInputScope pointerInputScope, TextFieldSelectionManager textFieldSelectionManager, Continuation<? super AnonymousClass2> continuation) {
                                    super(2, continuation);
                                    this.$this_pointerInput = pointerInputScope;
                                    this.$manager = textFieldSelectionManager;
                                }

                                static final Unit invokeSuspend$lambda$0(TextFieldSelectionManager textFieldSelectionManager, Offset offset) {
                                    textFieldSelectionManager.showSelectionToolbar$foundation();
                                    return Unit.INSTANCE;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass2(this.$this_pointerInput, this.$manager, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        PointerInputScope pointerInputScope = this.$this_pointerInput;
                                        final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
                                        this.label = 1;
                                        if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2$$ExternalSyntheticLambda0, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:129)
                                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
                                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:115)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            */
                                        /*
                                            this = this;
                                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                            int r1 = r9.label
                                            r2 = 1
                                            if (r1 == 0) goto L17
                                            if (r1 != r2) goto Lf
                                            kotlin.ResultKt.throwOnFailure(r10)
                                            goto L34
                                        Lf:
                                            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                                            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                                            r9.<init>(r10)
                                            throw r9
                                        L17:
                                            kotlin.ResultKt.throwOnFailure(r10)
                                            androidx.compose.ui.input.pointer.PointerInputScope r1 = r9.$this_pointerInput
                                            androidx.compose.foundation.text.selection.TextFieldSelectionManager r10 = r9.$manager
                                            androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2$$ExternalSyntheticLambda0 r5 = new androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2$$ExternalSyntheticLambda0
                                            r5.<init>(r10)
                                            r6 = r9
                                            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                                            r9.label = r2
                                            r2 = 0
                                            r3 = 0
                                            r4 = 0
                                            r7 = 7
                                            r8 = 0
                                            java.lang.Object r9 = androidx.compose.foundation.gestures.TapGestureDetectorKt.detectTapGestures$default(r1, r2, r3, r4, r5, r6, r7, r8)
                                            if (r9 != r0) goto L34
                                            return r0
                                        L34:
                                            kotlin.Unit r9 = kotlin.Unit.INSTANCE
                                            return r9
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, TextFieldSelectionManager textFieldSelectionManager, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$this_pointerInput = pointerInputScope;
                                    this.$observer = textDragObserver;
                                    this.$manager = textFieldSelectionManager;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_pointerInput, this.$observer, this.$manager, continuation);
                                    anonymousClass1.L$0 = obj;
                                    return anonymousClass1;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    if (this.label != 0) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new C00391(this.$this_pointerInput, this.$observer, null), 1, null);
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(this.$this_pointerInput, this.$manager, null), 1, null);
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, textDragObserver, textFieldSelectionManager, null), continuation);
                                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, textDragObserver, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1315036615, "CC(remember):CoreTextField.kt#9igjgp");
                    boolean zChanged3 = composerStartRestartGroup.changed(jM2880getCursorPositiontuRUvjQ$foundation);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CoreTextFieldKt.TextFieldCursorHandle$lambda$3$0(jM2880getCursorPositiontuRUvjQ$foundation, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidCursorHandle_androidKt.m2349CursorHandleUSBMPiE(offsetProvider, SemanticsModifierKt.semantics$default(modifierPointerInput, false, (Function1) objRememberedValue2, 1, null), 0L, composerStartRestartGroup, 0, 4);
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CoreTextFieldKt.TextFieldCursorHandle$lambda$4(textFieldSelectionManager, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit TextFieldCursorHandle$lambda$3$0(long j, SemanticsPropertyReceiver semanticsPropertyReceiver) {
            semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, j, SelectionHandleAnchor.Middle, true, null));
            return Unit.INSTANCE;
        }

        static final Unit TextFieldCursorHandle$lambda$4(TextFieldSelectionManager textFieldSelectionManager, int i, Composer composer, int i2) {
            TextFieldCursorHandle(textFieldSelectionManager, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            return Unit.INSTANCE;
        }

        private static final Modifier addContextMenuComponents(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, CoroutineScope coroutineScope) {
            return ComposeFoundationFlags.isNewContextMenuEnabled ? TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents(modifier, textFieldSelectionManager, coroutineScope) : modifier;
        }

        public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
            int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m8553getMaximpl(textFieldValue.getSelection()));
            Object objBringIntoView = bringIntoViewRequester.bringIntoView(iOriginalToTransformed < textLayoutResult.getLayoutInput().getText().length() ? textLayoutResult.getBoundingBox(iOriginalToTransformed) : iOriginalToTransformed != 0 ? textLayoutResult.getBoundingBox(iOriginalToTransformed - 1) : new Rect(0.0f, 0.0f, 1.0f, (int) (TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), continuation);
            return objBringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBringIntoView : Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void endInputSession(LegacyTextFieldState legacyTextFieldState) {
            TextInputSession inputSession = legacyTextFieldState.getInputSession();
            if (inputSession != null) {
                TextFieldDelegate.INSTANCE.onBlur$foundation(inputSession, legacyTextFieldState.getProcessor(), legacyTextFieldState.getOnValueChange());
            }
            legacyTextFieldState.setInputSession(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void notifyFocusedRect(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                if (layoutResult == null) {
                    return;
                }
                TextInputSession inputSession = legacyTextFieldState.getInputSession();
                if (inputSession == null) {
                    return;
                }
                LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
                if (layoutCoordinates == null) {
                    return;
                }
                TextFieldDelegate.INSTANCE.notifyFocusedRect$foundation(textFieldValue, legacyTextFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, legacyTextFieldState.getHasFocus(), offsetMapping);
                Unit unit = Unit.INSTANCE;
            } finally {
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            }
        }

        private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldSelectionManager textFieldSelectionManager) {
            return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.previewKeyEventToDeselectOnBack.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                    return m2415invokeZmokQxo(keyEvent.m7470unboximpl());
                }

                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                public final Boolean m2415invokeZmokQxo(android.view.KeyEvent keyEvent) {
                    boolean z;
                    if (legacyTextFieldState.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m2418cancelsTextSelectionZmokQxo(keyEvent)) {
                        z = true;
                        TextFieldSelectionManager.m2874deselect_kEHs6E$foundation$default(textFieldSelectionManager, null, 1, null);
                    } else {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void startInputSession(TextInputService textInputService, LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
            legacyTextFieldState.setInputSession(TextFieldDelegate.INSTANCE.onFocus$foundation(textInputService, textFieldValue, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
            notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
        }

        public static final void tapToFocus(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z) {
            SoftwareKeyboardController keyboardController;
            if (!legacyTextFieldState.getHasFocus()) {
                FocusRequester.m5985requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
            } else {
                if (!z || (keyboardController = legacyTextFieldState.getKeyboardController()) == null) {
                    return;
                }
                keyboardController.show();
            }
        }
    }
