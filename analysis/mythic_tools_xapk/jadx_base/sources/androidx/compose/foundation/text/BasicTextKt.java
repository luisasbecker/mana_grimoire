package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNodeKt;
import androidx.compose.foundation.text.modifiers.TextStringSimpleElement;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: BasicText.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0099\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0016\u0010 \u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0004\b!\u0010\"\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001aH\u0007¢\u0006\u0004\b#\u0010$\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b#\u0010%\u001a\u0081\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001aH\u0007¢\u0006\u0004\b\u001e\u0010&\u001a\u001e\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002\u001a@\u0010,\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020/\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000.\u0018\u00010-2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030-2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e00H\u0002\u001aÉ\u0001\u00105\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00106\u001a\u0002072\u0014\u00108\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020:09\u0018\u00010-2\u001c\u0010;\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010<0-\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0014\u0010?\u001a\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\bA\u0010B\u001a·\u0001\u0010C\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00182\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010D\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00106\u001a\u0002072\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0014\u0010?\u001a\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003¢\u0006\u0004\bE\u0010F¨\u0006G²\u0006\n\u0010H\u001a\u00020\u0018X\u008a\u008e\u0002"}, d2 = {"BasicText", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "BasicText-RWo7tUw", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-CL7eQgs", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Landroidx/compose/runtime/Composer;III)V", "BasicText-VhcvRP8", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "measureWithTextRangeMeasureConstraints", "", "Lkotlin/Pair;", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "shouldMeasureLinks", "textModifier", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "placeholders", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "textModifier-CL7eQgs", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/TextAutoSize;)Landroidx/compose/ui/Modifier;", "LayoutWithLinksAndInlineContent", "hasInlineContent", "LayoutWithLinksAndInlineContent-11Od_4g", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;ZLjava/util/Map;Landroidx/compose/ui/text/TextStyle;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/TextAutoSize;Landroidx/compose/runtime/Composer;III)V", "foundation", "displayedText"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicTextKt {
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010c  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: BasicText-4YKlhWE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2369BasicText4YKlhWE(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, Map map, Composer composer, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        TextStyle textStyle2;
        int i7;
        Function1 function12;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Composer composer2;
        final int i13;
        final int i14;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final Function1 function13;
        final boolean z2;
        final Map map2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i15;
        Modifier modifier4;
        int i16;
        Function1 function14;
        Composer composerStartRestartGroup = composer.startRestartGroup(-648605928);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,inlineContent)409@18970L274:BasicText.kt#423gt5");
        if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i17 = i4 & 2;
        if (i17 != 0) {
            i5 |= 48;
        } else {
            if ((i3 & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i3 & 384) == 0) {
                    textStyle2 = textStyle;
                    i5 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i3 & 3072) == 0) {
                        function12 = function1;
                        i5 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else {
                        if ((i3 & 24576) == 0) {
                            i5 |= composerStartRestartGroup.changed(i) ? 16384 : 8192;
                        }
                        i9 = i4 & 32;
                        if (i9 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else {
                            if ((196608 & i3) == 0) {
                                i5 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
                            }
                            i10 = i4 & 64;
                            if (i10 == 0) {
                                i5 |= 1572864;
                            } else if ((i3 & 1572864) == 0) {
                                i5 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i11 = i4 & 128;
                            if (i11 != 0) {
                                if ((i3 & 12582912) == 0) {
                                    i12 = i11;
                                    i5 |= composerStartRestartGroup.changedInstance(map) ? 8388608 : 4194304;
                                }
                                if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                                    if (i17 != 0) {
                                        modifier4 = Modifier.INSTANCE;
                                        i15 = i8;
                                    } else {
                                        i15 = i8;
                                        modifier4 = modifier2;
                                    }
                                    TextStyle textStyle4 = i6 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                                    if (i7 != 0) {
                                        function14 = null;
                                        i16 = i9;
                                    } else {
                                        i16 = i9;
                                        function14 = function12;
                                    }
                                    int iM9049getClipgIe3tQ8 = i15 != 0 ? TextOverflow.INSTANCE.m9049getClipgIe3tQ8() : i;
                                    boolean z3 = i16 != 0 ? true : z;
                                    int i18 = i10 != 0 ? Integer.MAX_VALUE : i2;
                                    Map mapEmptyMap = i12 != 0 ? MapsKt.emptyMap() : map;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-648605928, i5, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:408)");
                                    }
                                    composer2 = composerStartRestartGroup;
                                    m2372BasicTextCL7eQgs(annotatedString, modifier4, textStyle4, function14, iM9049getClipgIe3tQ8, z3, i18, 1, mapEmptyMap, null, null, composer2, (i5 & 14) | 12582912 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | ((i5 << 3) & 234881024), 0, 1536);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    textStyle3 = textStyle4;
                                    function13 = function14;
                                    i13 = iM9049getClipgIe3tQ8;
                                    z2 = z3;
                                    i14 = i18;
                                    map2 = mapEmptyMap;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    i13 = i;
                                    i14 = i2;
                                    modifier3 = modifier2;
                                    textStyle3 = textStyle2;
                                    function13 = function12;
                                    z2 = z;
                                    map2 = map;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda12
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return BasicTextKt.BasicText_4YKlhWE$lambda$0(annotatedString, modifier3, textStyle3, function13, i13, z2, i14, map2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i5 |= 12582912;
                            i12 = i11;
                            if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i10 = i4 & 64;
                        if (i10 == 0) {
                        }
                        i11 = i4 & 128;
                        if (i11 != 0) {
                        }
                        i12 = i11;
                        if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i9 = i4 & 32;
                    if (i9 != 0) {
                    }
                    i10 = i4 & 64;
                    if (i10 == 0) {
                    }
                    i11 = i4 & 128;
                    if (i11 != 0) {
                    }
                    i12 = i11;
                    if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function12 = function1;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i4 & 32;
                if (i9 != 0) {
                }
                i10 = i4 & 64;
                if (i10 == 0) {
                }
                i11 = i4 & 128;
                if (i11 != 0) {
                }
                i12 = i11;
                if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            textStyle2 = textStyle;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            function12 = function1;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i4 & 32;
            if (i9 != 0) {
            }
            i10 = i4 & 64;
            if (i10 == 0) {
            }
            i11 = i4 & 128;
            if (i11 != 0) {
            }
            i12 = i11;
            if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        textStyle2 = textStyle;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        function12 = function1;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i4 & 32;
        if (i9 != 0) {
        }
        i10 = i4 & 64;
        if (i10 == 0) {
        }
        i11 = i4 & 128;
        if (i11 != 0) {
        }
        i12 = i11;
        if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010c  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* JADX INFO: renamed from: BasicText-4YKlhWE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2370BasicText4YKlhWE(final String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, Composer composer, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        TextStyle textStyle2;
        int i8;
        Function1 function12;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Composer composer2;
        final int i14;
        final int i15;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final Function1 function13;
        final boolean z2;
        final int i16;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i17;
        Modifier modifier4;
        int i18;
        Function1 function14;
        Composer composerStartRestartGroup = composer.startRestartGroup(1542716361);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines)433@19643L86:BasicText.kt#423gt5");
        if ((i4 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i19 = i5 & 2;
        if (i19 != 0) {
            i6 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i4 & 384) == 0) {
                    textStyle2 = textStyle;
                    i6 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i4 & 3072) == 0) {
                        function12 = function1;
                        i6 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else {
                        if ((i4 & 24576) == 0) {
                            i6 |= composerStartRestartGroup.changed(i) ? 16384 : 8192;
                        }
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else {
                            if ((196608 & i4) == 0) {
                                i6 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
                            }
                            i11 = i5 & 64;
                            if (i11 == 0) {
                                i6 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i6 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i12 = i5 & 128;
                            if (i12 != 0) {
                                if ((i4 & 12582912) == 0) {
                                    i13 = i12;
                                    i6 |= composerStartRestartGroup.changed(i3) ? 8388608 : 4194304;
                                }
                                if (composerStartRestartGroup.shouldExecute((i6 & 4793491) != 4793490, i6 & 1)) {
                                    if (i19 != 0) {
                                        modifier4 = Modifier.INSTANCE;
                                        i17 = i9;
                                    } else {
                                        i17 = i9;
                                        modifier4 = modifier2;
                                    }
                                    TextStyle textStyle4 = i7 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                                    if (i8 != 0) {
                                        function14 = null;
                                        i18 = i10;
                                    } else {
                                        i18 = i10;
                                        function14 = function12;
                                    }
                                    int iM9049getClipgIe3tQ8 = i17 != 0 ? TextOverflow.INSTANCE.m9049getClipgIe3tQ8() : i;
                                    boolean z3 = i18 != 0 ? true : z;
                                    int i20 = i11 != 0 ? Integer.MAX_VALUE : i2;
                                    int i21 = i13 != 0 ? 1 : i3;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1542716361, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:433)");
                                    }
                                    composer2 = composerStartRestartGroup;
                                    m2374BasicTextRWo7tUw(str, modifier4, textStyle4, (Function1<? super TextLayoutResult, Unit>) function14, iM9049getClipgIe3tQ8, z3, i20, i21, (ColorProducer) null, (TextAutoSize) null, composer2, i6 & 33554430, 768);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    textStyle3 = textStyle4;
                                    function13 = function14;
                                    i14 = iM9049getClipgIe3tQ8;
                                    z2 = z3;
                                    i15 = i20;
                                    i16 = i21;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    i14 = i;
                                    i15 = i2;
                                    modifier3 = modifier2;
                                    textStyle3 = textStyle2;
                                    function13 = function12;
                                    z2 = z;
                                    i16 = i3;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return BasicTextKt.BasicText_4YKlhWE$lambda$1(str, modifier3, textStyle3, function13, i14, z2, i15, i16, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i6 |= 12582912;
                            i13 = i12;
                            if (composerStartRestartGroup.shouldExecute((i6 & 4793491) != 4793490, i6 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i11 = i5 & 64;
                        if (i11 == 0) {
                        }
                        i12 = i5 & 128;
                        if (i12 != 0) {
                        }
                        i13 = i12;
                        if (composerStartRestartGroup.shouldExecute((i6 & 4793491) != 4793490, i6 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 == 0) {
                    }
                    i12 = i5 & 128;
                    if (i12 != 0) {
                    }
                    i13 = i12;
                    if (composerStartRestartGroup.shouldExecute((i6 & 4793491) != 4793490, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function12 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 == 0) {
                }
                i12 = i5 & 128;
                if (i12 != 0) {
                }
                i13 = i12;
                if (composerStartRestartGroup.shouldExecute((i6 & 4793491) != 4793490, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            textStyle2 = textStyle;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            function12 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 == 0) {
            }
            i12 = i5 & 128;
            if (i12 != 0) {
            }
            i13 = i12;
            if (composerStartRestartGroup.shouldExecute((i6 & 4793491) != 4793490, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        textStyle2 = textStyle;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        function12 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 == 0) {
        }
        i12 = i5 & 128;
        if (i12 != 0) {
        }
        i13 = i12;
        if (composerStartRestartGroup.shouldExecute((i6 & 4793491) != 4793490, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e6  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: BasicText-BpD7jsM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2371BasicTextBpD7jsM(final String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, Composer composer, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        TextStyle textStyle2;
        int i7;
        int i8;
        int i9;
        boolean z2;
        int i10;
        Composer composer2;
        final int i11;
        final int i12;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final Function1 function12;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i13;
        TextStyle textStyle4;
        int i14;
        int iM9049getClipgIe3tQ8;
        Composer composerStartRestartGroup = composer.startRestartGroup(1022429478);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines)385@18278L235:BasicText.kt#423gt5");
        if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i15 = i4 & 2;
        if (i15 != 0) {
            i5 |= 48;
        } else {
            if ((i3 & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i3 & 384) == 0) {
                    textStyle2 = textStyle;
                    i5 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i3 & 3072) == 0) {
                        i5 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else {
                        if ((i3 & 24576) == 0) {
                            i5 |= composerStartRestartGroup.changed(i) ? 16384 : 8192;
                        }
                        i9 = i4 & 32;
                        if (i9 == 0) {
                            if ((196608 & i3) == 0) {
                                z2 = z;
                                i5 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
                            }
                            i10 = i4 & 64;
                            if (i10 == 0) {
                                i5 |= 1572864;
                            } else if ((i3 & 1572864) == 0) {
                                i5 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                i11 = i;
                                i12 = i2;
                                modifier3 = modifier2;
                                textStyle3 = textStyle2;
                                function12 = function1;
                            } else {
                                Modifier modifier4 = i15 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i6 != 0) {
                                    textStyle4 = TextStyle.INSTANCE.getDefault();
                                    i13 = i8;
                                } else {
                                    i13 = i8;
                                    textStyle4 = textStyle2;
                                }
                                Function1 function13 = i7 != 0 ? null : function1;
                                if (i13 != 0) {
                                    iM9049getClipgIe3tQ8 = TextOverflow.INSTANCE.m9049getClipgIe3tQ8();
                                    i14 = i9;
                                } else {
                                    i14 = i9;
                                    iM9049getClipgIe3tQ8 = i;
                                }
                                if (i14 != 0) {
                                    z2 = true;
                                }
                                int i16 = i10 != 0 ? Integer.MAX_VALUE : i2;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1022429478, i5, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:384)");
                                }
                                composer2 = composerStartRestartGroup;
                                m2374BasicTextRWo7tUw(str, modifier4, textStyle4, (Function1<? super TextLayoutResult, Unit>) function13, iM9049getClipgIe3tQ8, z2, i16, 1, (ColorProducer) null, (TextAutoSize) null, composer2, (i5 & 14) | 12582912 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (i5 & 3670016), 768);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                textStyle3 = textStyle4;
                                function12 = function13;
                                i11 = iM9049getClipgIe3tQ8;
                                i12 = i16;
                            }
                            final boolean z3 = z2;
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BasicTextKt.BasicText_BpD7jsM$lambda$0(str, modifier3, textStyle3, function12, i11, z3, i12, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        z2 = z;
                        i10 = i4 & 64;
                        if (i10 == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                        }
                        final boolean z32 = z2;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i9 = i4 & 32;
                    if (i9 == 0) {
                    }
                    z2 = z;
                    i10 = i4 & 64;
                    if (i10 == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                    }
                    final boolean z322 = z2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i4 & 32;
                if (i9 == 0) {
                }
                z2 = z;
                i10 = i4 & 64;
                if (i10 == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                }
                final boolean z3222 = z2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            textStyle2 = textStyle;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i4 & 32;
            if (i9 == 0) {
            }
            z2 = z;
            i10 = i4 & 64;
            if (i10 == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
            }
            final boolean z32222 = z2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        textStyle2 = textStyle;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i4 & 32;
        if (i9 == 0) {
        }
        z2 = z;
        i10 = i4 & 64;
        if (i10 == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
        }
        final boolean z322222 = z2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:213:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0122  */
    /* JADX INFO: renamed from: BasicText-CL7eQgs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2372BasicTextCL7eQgs(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, Map<String, InlineTextContent> map, ColorProducer colorProducer, TextAutoSize textAutoSize, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        TextStyle textStyle2;
        int i9;
        Function1<? super TextLayoutResult, Unit> function12;
        int i10;
        int iM9049getClipgIe3tQ8;
        int i11;
        int i12;
        final int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        final AnnotatedString annotatedString2;
        Composer composer2;
        final Modifier modifier2;
        final int i23;
        final Map<String, InlineTextContent> map2;
        final ColorProducer colorProducer2;
        final int i24;
        final TextStyle textStyle3;
        final Function1<? super TextLayoutResult, Unit> function13;
        final boolean z2;
        final TextAutoSize textAutoSize2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i25;
        Modifier modifier3;
        TextStyle textStyle4;
        Function1<? super TextLayoutResult, Unit> function14;
        int i26;
        int i27;
        SelectionController selectionController;
        boolean z3;
        int i28;
        Function1<? super TextLayoutResult, Unit> function15;
        int i29;
        TextStyle textStyle5;
        long jLongValue;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1343466571);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,inlineContent,color,autoSize)202@10280L7,219@11037L7:BasicText.kt#423gt5");
        if ((i4 & 6) == 0) {
            i7 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i30 = i6 & 2;
        if (i30 != 0) {
            i7 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                i7 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else {
                if ((i4 & 384) == 0) {
                    textStyle2 = textStyle;
                    i7 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else {
                    if ((i4 & 3072) == 0) {
                        function12 = function1;
                        i7 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else {
                        if ((i4 & 24576) == 0) {
                            iM9049getClipgIe3tQ8 = i;
                            i7 |= composerStartRestartGroup.changed(iM9049getClipgIe3tQ8) ? 16384 : 8192;
                        }
                        i11 = i6 & 32;
                        if (i11 != 0) {
                            i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i7 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
                        }
                        i12 = i6 & 64;
                        if (i12 != 0) {
                            i7 |= 1572864;
                            i13 = i2;
                        } else {
                            i13 = i2;
                            if ((i4 & 1572864) == 0) {
                                i7 |= composerStartRestartGroup.changed(i13) ? 1048576 : 524288;
                            }
                        }
                        i14 = i6 & 128;
                        if (i14 != 0) {
                            i7 |= 12582912;
                        } else {
                            if ((i4 & 12582912) == 0) {
                                i15 = i14;
                                i7 |= composerStartRestartGroup.changed(i3) ? 8388608 : 4194304;
                            }
                            i16 = i6 & 256;
                            if (i16 == 0) {
                                i7 |= 100663296;
                            } else {
                                if ((i4 & 100663296) == 0) {
                                    i17 = i16;
                                    i7 |= composerStartRestartGroup.changedInstance(map) ? 67108864 : 33554432;
                                }
                                i18 = i6 & 512;
                                if (i18 != 0) {
                                    i7 |= 805306368;
                                } else {
                                    if ((i4 & 805306368) == 0) {
                                        i19 = i18;
                                        i7 |= composerStartRestartGroup.changedInstance(colorProducer) ? 536870912 : 268435456;
                                    }
                                    i20 = i6 & 1024;
                                    if (i20 == 0) {
                                        i22 = i5 | 6;
                                    } else {
                                        if ((i5 & 6) != 0) {
                                            i21 = i5;
                                            if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i21 & 3) == 2) ? false : true, i7 & 1)) {
                                                Modifier.Companion companion = i30 != 0 ? Modifier.INSTANCE : modifier;
                                                TextStyle textStyle6 = i8 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                                                Function1<? super TextLayoutResult, Unit> function16 = i9 != 0 ? null : function12;
                                                if (i10 != 0) {
                                                    iM9049getClipgIe3tQ8 = TextOverflow.INSTANCE.m9049getClipgIe3tQ8();
                                                }
                                                boolean z4 = i11 != 0 ? true : z;
                                                if (i12 != 0) {
                                                    i13 = Integer.MAX_VALUE;
                                                }
                                                int i31 = i13;
                                                int i32 = iM9049getClipgIe3tQ8;
                                                int i33 = i15 != 0 ? 1 : i3;
                                                Map<String, InlineTextContent> mapEmptyMap = i17 != 0 ? MapsKt.emptyMap() : map;
                                                ColorProducer colorProducer3 = i19 != 0 ? null : colorProducer;
                                                TextAutoSize textAutoSize3 = i20 != 0 ? null : textAutoSize;
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1343466571, i7, i21, "androidx.compose.foundation.text.BasicText (BasicText.kt:200)");
                                                }
                                                HeightInLinesModifierKt.validateMinMaxLines(i33, i31);
                                                ProvidableCompositionLocal<SelectionRegistrar> localSelectionRegistrar = SelectionRegistrarKt.getLocalSelectionRegistrar();
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                                Object objConsume = composerStartRestartGroup.consume(localSelectionRegistrar);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                final SelectionRegistrar selectionRegistrar = (SelectionRegistrar) objConsume;
                                                if (selectionRegistrar != null) {
                                                    i25 = i21;
                                                    composerStartRestartGroup.startReplaceGroup(1588268245);
                                                    ComposerKt.sourceInformation(composerStartRestartGroup, "205@10428L7,207@10582L77,207@10499L160,210@10672L180");
                                                    ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                                                    modifier3 = companion;
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                                    Object objConsume2 = composerStartRestartGroup.consume(localTextSelectionColors);
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    long backgroundColor = ((TextSelectionColors) objConsume2).getBackgroundColor();
                                                    textStyle4 = textStyle6;
                                                    Object[] objArr = {selectionRegistrar};
                                                    function14 = function16;
                                                    Saver<Long, Long> saverSelectionIdSaver = selectionIdSaver(selectionRegistrar);
                                                    i26 = i7;
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713809186, "CC(remember):BasicText.kt#9igjgp");
                                                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(selectionRegistrar);
                                                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                    if (zChangedInstance) {
                                                        i27 = i31;
                                                    } else {
                                                        i27 = i31;
                                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        jLongValue = ((Number) RememberSaveableKt.m5766rememberSaveable(objArr, (Saver) saverSelectionIdSaver, (Function0) objRememberedValue2, composerStartRestartGroup, 0)).longValue();
                                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713812169, "CC(remember):BasicText.kt#9igjgp");
                                                        zChanged = composerStartRestartGroup.changed(jLongValue) | composerStartRestartGroup.changed(selectionRegistrar) | composerStartRestartGroup.changed(backgroundColor);
                                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                            objRememberedValue = new SelectionController(jLongValue, selectionRegistrar, backgroundColor, null, 8, null);
                                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                        }
                                                        selectionController = (SelectionController) objRememberedValue;
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        composerStartRestartGroup.endReplaceGroup();
                                                    }
                                                    objRememberedValue2 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda19
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Object invoke() {
                                                            return Long.valueOf(selectionRegistrar.nextSelectableId());
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    jLongValue = ((Number) RememberSaveableKt.m5766rememberSaveable(objArr, (Saver) saverSelectionIdSaver, (Function0) objRememberedValue2, composerStartRestartGroup, 0)).longValue();
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713812169, "CC(remember):BasicText.kt#9igjgp");
                                                    zChanged = composerStartRestartGroup.changed(jLongValue) | composerStartRestartGroup.changed(selectionRegistrar) | composerStartRestartGroup.changed(backgroundColor);
                                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                    if (!zChanged) {
                                                        objRememberedValue = new SelectionController(jLongValue, selectionRegistrar, backgroundColor, null, 8, null);
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                        selectionController = (SelectionController) objRememberedValue;
                                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                        composerStartRestartGroup.endReplaceGroup();
                                                    }
                                                } else {
                                                    i25 = i21;
                                                    modifier3 = companion;
                                                    textStyle4 = textStyle6;
                                                    function14 = function16;
                                                    i26 = i7;
                                                    i27 = i31;
                                                    composerStartRestartGroup.startReplaceGroup(1588759409);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    selectionController = null;
                                                }
                                                boolean zHasInlineContent = AnnotatedStringResolveInlineContentKt.hasInlineContent(annotatedString);
                                                boolean zHasLinks = TextAnnotatedStringNodeKt.hasLinks(annotatedString);
                                                ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                                Object objConsume3 = composerStartRestartGroup.consume(localFontFamilyResolver);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                FontFamily.Resolver resolver = (FontFamily.Resolver) objConsume3;
                                                if (zHasInlineContent || zHasLinks) {
                                                    annotatedString2 = annotatedString;
                                                    z3 = z4;
                                                    i28 = i32;
                                                    function15 = function14;
                                                    SelectionController selectionController2 = selectionController;
                                                    i29 = i27;
                                                    composerStartRestartGroup.startReplaceGroup(1590022070);
                                                    ComposerKt.sourceInformation(composerStartRestartGroup, "253@12268L39,269@12876L292,255@12317L895");
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713863100, "CC(remember):BasicText.kt#9igjgp");
                                                    boolean z5 = (i26 & 14) == 4;
                                                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                                    if (z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(annotatedString2, null, 2, null);
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                                    }
                                                    final MutableState mutableState = (MutableState) objRememberedValue3;
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    AnnotatedString annotatedStringBasicText_CL7eQgs$lambda$3 = BasicText_CL7eQgs$lambda$3(mutableState);
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713882809, "CC(remember):BasicText.kt#9igjgp");
                                                    boolean zChanged2 = composerStartRestartGroup.changed(mutableState);
                                                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                                    if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                        objRememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda20
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj) {
                                                                return BasicTextKt.BasicText_CL7eQgs$lambda$5$0(mutableState, (TextAnnotatedStringNode.TextSubstitutionValue) obj);
                                                            }
                                                        };
                                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    int i34 = i26 << 6;
                                                    composer2 = composerStartRestartGroup;
                                                    Modifier modifier4 = modifier3;
                                                    TextStyle textStyle7 = textStyle4;
                                                    m2377LayoutWithLinksAndInlineContent11Od_4g(modifier4, annotatedStringBasicText_CL7eQgs$lambda$3, function15, zHasInlineContent, mapEmptyMap, textStyle7, i28, z3, i29, i33, resolver, selectionController2, colorProducer3, (Function1) objRememberedValue4, textAutoSize3, composer2, ((i26 >> 3) & Videoio.CAP_OPENNI_ASUS) | ((i26 >> 12) & 57344) | ((i26 << 9) & 458752) | (3670016 & i34) | (29360128 & i34) | (234881024 & i34) | (i34 & 1879048192), ((i26 >> 21) & 896) | ((i25 << 12) & 57344), 0);
                                                    textStyle5 = textStyle7;
                                                    modifier3 = modifier4;
                                                    composer2.endReplaceGroup();
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(1589006262);
                                                    ComposerKt.sourceInformation(composerStartRestartGroup, "222@11096L174,230@11349L746");
                                                    TextStyle textStyle8 = textStyle4;
                                                    BasicText_androidKt.BackgroundTextMeasurement(annotatedString, textStyle8, resolver, null, composerStartRestartGroup, (i26 & 14) | 3072 | ((i26 >> 3) & 112));
                                                    z3 = z4;
                                                    annotatedString2 = annotatedString;
                                                    i28 = i32;
                                                    function15 = function14;
                                                    SelectionController selectionController3 = selectionController;
                                                    i29 = i27;
                                                    Modifier modifierM2378textModifierCL7eQgs = m2378textModifierCL7eQgs(modifier3, annotatedString2, textStyle8, function15, i28, z3, i29, i33, resolver, null, null, selectionController3, colorProducer3, null, textAutoSize3);
                                                    EmptyMeasurePolicy emptyMeasurePolicy = EmptyMeasurePolicy.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                                                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2378textModifierCL7eQgs);
                                                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
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
                                                    Updater.m5603setimpl(composerM5595constructorimpl, emptyMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                                    Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                                    composerStartRestartGroup.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    composer2 = composerStartRestartGroup;
                                                    textStyle5 = textStyle8;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                i23 = i33;
                                                colorProducer2 = colorProducer3;
                                                textAutoSize2 = textAutoSize3;
                                                map2 = mapEmptyMap;
                                                i13 = i29;
                                                z2 = z3;
                                                i24 = i28;
                                                function13 = function15;
                                                textStyle3 = textStyle5;
                                                modifier2 = modifier3;
                                            } else {
                                                annotatedString2 = annotatedString;
                                                composer2 = composerStartRestartGroup;
                                                composer2.skipToGroupEnd();
                                                modifier2 = modifier;
                                                i23 = i3;
                                                map2 = map;
                                                colorProducer2 = colorProducer;
                                                i24 = iM9049getClipgIe3tQ8;
                                                textStyle3 = textStyle2;
                                                function13 = function12;
                                                z2 = z;
                                                textAutoSize2 = textAutoSize;
                                            }
                                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                            if (scopeUpdateScopeEndRestartGroup != null) {
                                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda1
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(Object obj, Object obj2) {
                                                        return BasicTextKt.BasicText_CL7eQgs$lambda$6(annotatedString2, modifier2, textStyle3, function13, i24, z2, i13, i23, map2, colorProducer2, textAutoSize2, i4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                                    }
                                                });
                                                return;
                                            }
                                            return;
                                        }
                                        i22 = i5 | ((i5 & 8) == 0 ? composerStartRestartGroup.changed(textAutoSize) : composerStartRestartGroup.changedInstance(textAutoSize) ? 4 : 2);
                                    }
                                    i21 = i22;
                                    if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i21 & 3) == 2) ? false : true, i7 & 1)) {
                                    }
                                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup != null) {
                                    }
                                }
                                i19 = i18;
                                i20 = i6 & 1024;
                                if (i20 == 0) {
                                }
                                i21 = i22;
                                if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i21 & 3) == 2) ? false : true, i7 & 1)) {
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                }
                            }
                            i17 = i16;
                            i18 = i6 & 512;
                            if (i18 != 0) {
                            }
                            i19 = i18;
                            i20 = i6 & 1024;
                            if (i20 == 0) {
                            }
                            i21 = i22;
                            if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i21 & 3) == 2) ? false : true, i7 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i15 = i14;
                        i16 = i6 & 256;
                        if (i16 == 0) {
                        }
                        i17 = i16;
                        i18 = i6 & 512;
                        if (i18 != 0) {
                        }
                        i19 = i18;
                        i20 = i6 & 1024;
                        if (i20 == 0) {
                        }
                        i21 = i22;
                        if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i21 & 3) == 2) ? false : true, i7 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    iM9049getClipgIe3tQ8 = i;
                    i11 = i6 & 32;
                    if (i11 != 0) {
                    }
                    i12 = i6 & 64;
                    if (i12 != 0) {
                    }
                    i14 = i6 & 128;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i6 & 256;
                    if (i16 == 0) {
                    }
                    i17 = i16;
                    i18 = i6 & 512;
                    if (i18 != 0) {
                    }
                    i19 = i18;
                    i20 = i6 & 1024;
                    if (i20 == 0) {
                    }
                    i21 = i22;
                    if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i21 & 3) == 2) ? false : true, i7 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function12 = function1;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                iM9049getClipgIe3tQ8 = i;
                i11 = i6 & 32;
                if (i11 != 0) {
                }
                i12 = i6 & 64;
                if (i12 != 0) {
                }
                i14 = i6 & 128;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i6 & 256;
                if (i16 == 0) {
                }
                i17 = i16;
                i18 = i6 & 512;
                if (i18 != 0) {
                }
                i19 = i18;
                i20 = i6 & 1024;
                if (i20 == 0) {
                }
                i21 = i22;
                if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i21 & 3) == 2) ? false : true, i7 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            textStyle2 = textStyle;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            function12 = function1;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            iM9049getClipgIe3tQ8 = i;
            i11 = i6 & 32;
            if (i11 != 0) {
            }
            i12 = i6 & 64;
            if (i12 != 0) {
            }
            i14 = i6 & 128;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i6 & 256;
            if (i16 == 0) {
            }
            i17 = i16;
            i18 = i6 & 512;
            if (i18 != 0) {
            }
            i19 = i18;
            i20 = i6 & 1024;
            if (i20 == 0) {
            }
            i21 = i22;
            if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i21 & 3) == 2) ? false : true, i7 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        textStyle2 = textStyle;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        function12 = function1;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        iM9049getClipgIe3tQ8 = i;
        i11 = i6 & 32;
        if (i11 != 0) {
        }
        i12 = i6 & 64;
        if (i12 != 0) {
        }
        i14 = i6 & 128;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i6 & 256;
        if (i16 == 0) {
        }
        i17 = i16;
        i18 = i6 & 512;
        if (i18 != 0) {
        }
        i19 = i18;
        i20 = i6 & 1024;
        if (i20 == 0) {
        }
        i21 = i22;
        if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i21 & 3) == 2) ? false : true, i7 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011b  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: BasicText-RWo7tUw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2373BasicTextRWo7tUw(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, Map map, ColorProducer colorProducer, Composer composer, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        TextStyle textStyle2;
        int i8;
        Function1 function12;
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
        Composer composer2;
        final int i19;
        final Map map2;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final Function1 function13;
        final int i20;
        final boolean z2;
        final int i21;
        final ColorProducer colorProducer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i22;
        Modifier modifier4;
        int i23;
        boolean z3;
        int i24;
        int i25;
        int i26;
        int i27;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1064305212);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,inlineContent,color)360@17696L195:BasicText.kt#423gt5");
        if ((i4 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i28 = i5 & 2;
        if (i28 != 0) {
            i6 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i4 & 384) == 0) {
                    textStyle2 = textStyle;
                    i6 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i4 & 3072) == 0) {
                        function12 = function1;
                        i6 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else {
                        if ((i4 & 24576) == 0) {
                            i10 = i;
                            i6 |= composerStartRestartGroup.changed(i10) ? 16384 : 8192;
                        }
                        i11 = i5 & 32;
                        if (i11 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else {
                            if ((196608 & i4) == 0) {
                                i6 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
                            }
                            i12 = i5 & 64;
                            if (i12 == 0) {
                                i6 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i6 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i13 = i5 & 128;
                            if (i13 == 0) {
                                i6 |= 12582912;
                            } else {
                                if ((i4 & 12582912) == 0) {
                                    i14 = i13;
                                    i6 |= composerStartRestartGroup.changed(i3) ? 8388608 : 4194304;
                                }
                                i15 = i5 & 256;
                                if (i15 != 0) {
                                    i6 |= 100663296;
                                } else {
                                    if ((i4 & 100663296) == 0) {
                                        i16 = i15;
                                        i6 |= composerStartRestartGroup.changedInstance(map) ? 67108864 : 33554432;
                                    }
                                    i17 = i5 & 512;
                                    if (i17 != 0) {
                                        if ((i4 & 805306368) == 0) {
                                            i18 = i17;
                                            i6 |= composerStartRestartGroup.changedInstance(colorProducer) ? 536870912 : 268435456;
                                        }
                                        if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                                            if (i28 != 0) {
                                                modifier4 = Modifier.INSTANCE;
                                                i22 = i11;
                                            } else {
                                                i22 = i11;
                                                modifier4 = modifier2;
                                            }
                                            TextStyle textStyle4 = i7 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                                            Function1 function14 = i8 != 0 ? null : function12;
                                            int iM9049getClipgIe3tQ8 = i9 != 0 ? TextOverflow.INSTANCE.m9049getClipgIe3tQ8() : i10;
                                            if (i22 != 0) {
                                                i23 = i14;
                                                z3 = true;
                                            } else {
                                                i23 = i14;
                                                z3 = z;
                                            }
                                            if (i12 != 0) {
                                                int i29 = i16;
                                                i25 = Integer.MAX_VALUE;
                                                i24 = i29;
                                            } else {
                                                i24 = i16;
                                                i25 = i2;
                                            }
                                            if (i23 != 0) {
                                                i26 = i18;
                                                i27 = 1;
                                            } else {
                                                i26 = i18;
                                                i27 = i3;
                                            }
                                            Map mapEmptyMap = i24 != 0 ? MapsKt.emptyMap() : map;
                                            ColorProducer colorProducer3 = i26 != 0 ? null : colorProducer;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1064305212, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:359)");
                                            }
                                            composer2 = composerStartRestartGroup;
                                            m2372BasicTextCL7eQgs(annotatedString, modifier4, textStyle4, function14, iM9049getClipgIe3tQ8, z3, i25, i27, mapEmptyMap, colorProducer3, null, composer2, i6 & 2147483646, 0, 1024);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            modifier3 = modifier4;
                                            textStyle3 = textStyle4;
                                            function13 = function14;
                                            i20 = iM9049getClipgIe3tQ8;
                                            z2 = z3;
                                            i19 = i25;
                                            i21 = i27;
                                            map2 = mapEmptyMap;
                                            colorProducer2 = colorProducer3;
                                        } else {
                                            composer2 = composerStartRestartGroup;
                                            composer2.skipToGroupEnd();
                                            i19 = i2;
                                            map2 = map;
                                            modifier3 = modifier2;
                                            textStyle3 = textStyle2;
                                            function13 = function12;
                                            i20 = i10;
                                            z2 = z;
                                            i21 = i3;
                                            colorProducer2 = colorProducer;
                                        }
                                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                        if (scopeUpdateScopeEndRestartGroup != null) {
                                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda11
                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(Object obj, Object obj2) {
                                                    return BasicTextKt.BasicText_RWo7tUw$lambda$3(annotatedString, modifier3, textStyle3, function13, i20, z2, i19, i21, map2, colorProducer2, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                    i6 |= 805306368;
                                    i18 = i17;
                                    if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                                    }
                                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup != null) {
                                    }
                                }
                                i16 = i15;
                                i17 = i5 & 512;
                                if (i17 != 0) {
                                }
                                i18 = i17;
                                if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                }
                            }
                            i14 = i13;
                            i15 = i5 & 256;
                            if (i15 != 0) {
                            }
                            i16 = i15;
                            i17 = i5 & 512;
                            if (i17 != 0) {
                            }
                            i18 = i17;
                            if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i12 = i5 & 64;
                        if (i12 == 0) {
                        }
                        i13 = i5 & 128;
                        if (i13 == 0) {
                        }
                        i14 = i13;
                        i15 = i5 & 256;
                        if (i15 != 0) {
                        }
                        i16 = i15;
                        i17 = i5 & 512;
                        if (i17 != 0) {
                        }
                        i18 = i17;
                        if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i10 = i;
                    i11 = i5 & 32;
                    if (i11 != 0) {
                    }
                    i12 = i5 & 64;
                    if (i12 == 0) {
                    }
                    i13 = i5 & 128;
                    if (i13 == 0) {
                    }
                    i14 = i13;
                    i15 = i5 & 256;
                    if (i15 != 0) {
                    }
                    i16 = i15;
                    i17 = i5 & 512;
                    if (i17 != 0) {
                    }
                    i18 = i17;
                    if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function12 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i;
                i11 = i5 & 32;
                if (i11 != 0) {
                }
                i12 = i5 & 64;
                if (i12 == 0) {
                }
                i13 = i5 & 128;
                if (i13 == 0) {
                }
                i14 = i13;
                i15 = i5 & 256;
                if (i15 != 0) {
                }
                i16 = i15;
                i17 = i5 & 512;
                if (i17 != 0) {
                }
                i18 = i17;
                if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            textStyle2 = textStyle;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            function12 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i;
            i11 = i5 & 32;
            if (i11 != 0) {
            }
            i12 = i5 & 64;
            if (i12 == 0) {
            }
            i13 = i5 & 128;
            if (i13 == 0) {
            }
            i14 = i13;
            i15 = i5 & 256;
            if (i15 != 0) {
            }
            i16 = i15;
            i17 = i5 & 512;
            if (i17 != 0) {
            }
            i18 = i17;
            if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        textStyle2 = textStyle;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        function12 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i;
        i11 = i5 & 32;
        if (i11 != 0) {
        }
        i12 = i5 & 64;
        if (i12 == 0) {
        }
        i13 = i5 & 128;
        if (i13 == 0) {
        }
        i14 = i13;
        i15 = i5 & 256;
        if (i15 != 0) {
        }
        i16 = i15;
        i17 = i5 & 512;
        if (i17 != 0) {
        }
        i18 = i17;
        if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011f A[PHI: r21
      0x011f: PHI (r21v15 int) = (r21v4 int), (r21v10 int), (r21v11 int) binds: [B:97:0x011d, B:107:0x013a, B:106:0x0137] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0122  */
    /* JADX INFO: renamed from: BasicText-RWo7tUw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2374BasicTextRWo7tUw(final String str, Modifier modifier, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, ColorProducer colorProducer, TextAutoSize textAutoSize, Composer composer, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        TextStyle textStyle2;
        int i8;
        Function1<? super TextLayoutResult, Unit> function12;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        final boolean z2;
        final int i18;
        final TextAutoSize textAutoSize2;
        Composer composer2;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final Function1<? super TextLayoutResult, Unit> function13;
        final int i19;
        final int i20;
        final ColorProducer colorProducer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i21;
        int i22;
        SelectionController selectionController;
        int i23;
        TextStyle textStyle4;
        Modifier modifier4;
        Modifier modifierM2378textModifierCL7eQgs;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1040751001);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,color,autoSize)104@5458L7,119@6129L7,121@6142L94,154@7432L41:BasicText.kt#423gt5");
        if ((i4 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i24 = i5 & 2;
        if (i24 != 0) {
            i6 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i4 & 384) == 0) {
                    textStyle2 = textStyle;
                    i6 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i4 & 3072) == 0) {
                        function12 = function1;
                        i6 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else {
                        if ((i4 & 24576) == 0) {
                            i10 = i;
                            i6 |= composerStartRestartGroup.changed(i10) ? 16384 : 8192;
                        }
                        i11 = i5 & 32;
                        if (i11 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i6 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
                        }
                        i12 = i5 & 64;
                        if (i12 != 0) {
                            i6 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            i6 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                        }
                        i13 = i5 & 128;
                        if (i13 != 0) {
                            i6 |= 12582912;
                        } else {
                            if ((i4 & 12582912) == 0) {
                                i14 = i13;
                                i6 |= composerStartRestartGroup.changed(i3) ? 8388608 : 4194304;
                            }
                            i15 = i5 & 256;
                            if (i15 != 0) {
                                if ((i4 & 100663296) == 0) {
                                    i16 = i15;
                                    i6 |= composerStartRestartGroup.changedInstance(colorProducer) ? 67108864 : 33554432;
                                }
                                i17 = i5 & 512;
                                int i25 = 805306368;
                                if (i17 != 0) {
                                    i6 |= i25;
                                } else if ((i4 & 805306368) == 0) {
                                    i25 = (i4 & 1073741824) == 0 ? composerStartRestartGroup.changed(textAutoSize) : composerStartRestartGroup.changedInstance(textAutoSize) ? 536870912 : 268435456;
                                    i6 |= i25;
                                }
                                if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                                    if (i24 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i7 != 0) {
                                        textStyle2 = TextStyle.INSTANCE.getDefault();
                                    }
                                    Function1<? super TextLayoutResult, Unit> function14 = i8 != 0 ? null : function12;
                                    int iM9049getClipgIe3tQ8 = i9 != 0 ? TextOverflow.INSTANCE.m9049getClipgIe3tQ8() : i10;
                                    boolean z3 = i11 != 0 ? true : z;
                                    int i26 = i12 != 0 ? Integer.MAX_VALUE : i2;
                                    int i27 = i14 != 0 ? 1 : i3;
                                    ColorProducer colorProducer3 = i16 != 0 ? null : colorProducer;
                                    TextAutoSize textAutoSize3 = i17 != 0 ? null : textAutoSize;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1040751001, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:102)");
                                    }
                                    HeightInLinesModifierKt.validateMinMaxLines(i27, i26);
                                    ProvidableCompositionLocal<SelectionRegistrar> localSelectionRegistrar = SelectionRegistrarKt.getLocalSelectionRegistrar();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume = composerStartRestartGroup.consume(localSelectionRegistrar);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    final SelectionRegistrar selectionRegistrar = (SelectionRegistrar) objConsume;
                                    if (selectionRegistrar != null) {
                                        composerStartRestartGroup.startReplaceGroup(356423075);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "107@5606L7,109@5760L77,109@5677L160,112@5850L180");
                                        ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume2 = composerStartRestartGroup.consume(localTextSelectionColors);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        long backgroundColor = ((TextSelectionColors) objConsume2).getBackgroundColor();
                                        Object[] objArr = {selectionRegistrar};
                                        Saver<Long, Long> saverSelectionIdSaver = selectionIdSaver(selectionRegistrar);
                                        i21 = i26;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 565693588, "CC(remember):BasicText.kt#9igjgp");
                                        boolean zChangedInstance = composerStartRestartGroup.changedInstance(selectionRegistrar);
                                        i22 = i6;
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = new Function0() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda14
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return Long.valueOf(selectionRegistrar.nextSelectableId());
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        long jLongValue = ((Number) RememberSaveableKt.m5766rememberSaveable(objArr, (Saver) saverSelectionIdSaver, (Function0) objRememberedValue, composerStartRestartGroup, 0)).longValue();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 565696571, "CC(remember):BasicText.kt#9igjgp");
                                        boolean zChanged = composerStartRestartGroup.changed(jLongValue) | composerStartRestartGroup.changed(selectionRegistrar) | composerStartRestartGroup.changed(backgroundColor);
                                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue2 = new SelectionController(jLongValue, selectionRegistrar, backgroundColor, null, 8, null);
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endReplaceGroup();
                                        selectionController = (SelectionController) objRememberedValue2;
                                    } else {
                                        i21 = i26;
                                        i22 = i6;
                                        composerStartRestartGroup.startReplaceGroup(356914239);
                                        composerStartRestartGroup.endReplaceGroup();
                                        selectionController = null;
                                    }
                                    ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume3 = composerStartRestartGroup.consume(localFontFamilyResolver);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    FontFamily.Resolver resolver = (FontFamily.Resolver) objConsume3;
                                    BasicText_androidKt.BackgroundTextMeasurement(str, textStyle2, resolver, composerStartRestartGroup, (i22 & 14) | ((i22 >> 3) & 112));
                                    if (selectionController == null && function14 == null && textAutoSize3 == null) {
                                        composerStartRestartGroup.startReplaceGroup(357875859);
                                        composerStartRestartGroup.endReplaceGroup();
                                        int i28 = i27;
                                        TextStyle textStyle5 = textStyle2;
                                        textStyle4 = textStyle5;
                                        i23 = i28;
                                        modifierM2378textModifierCL7eQgs = modifier2.then(new TextStringSimpleElement(str, textStyle5, resolver, iM9049getClipgIe3tQ8, z3, i21, i28, colorProducer3, null));
                                        modifier4 = modifier2;
                                    } else {
                                        i23 = i27;
                                        textStyle4 = textStyle2;
                                        composerStartRestartGroup.startReplaceGroup(357232113);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "133@6715L7");
                                        AnnotatedString annotatedString = new AnnotatedString(str, null, 2, null);
                                        ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver2 = CompositionLocalsKt.getLocalFontFamilyResolver();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume4 = composerStartRestartGroup.consume(localFontFamilyResolver2);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        modifier4 = modifier2;
                                        modifierM2378textModifierCL7eQgs = m2378textModifierCL7eQgs(modifier4, annotatedString, textStyle4, function14, iM9049getClipgIe3tQ8, z3, i21, i23, (FontFamily.Resolver) objConsume4, null, null, selectionController, colorProducer3, null, textAutoSize3);
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                    EmptyMeasurePolicy emptyMeasurePolicy = EmptyMeasurePolicy.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2378textModifierCL7eQgs);
                                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
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
                                    Updater.m5603setimpl(composerM5595constructorimpl, emptyMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                    Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                    composerStartRestartGroup.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2 = composerStartRestartGroup;
                                    modifier3 = modifier4;
                                    textStyle3 = textStyle4;
                                    function13 = function14;
                                    i19 = iM9049getClipgIe3tQ8;
                                    z2 = z3;
                                    i20 = i21;
                                    i18 = i23;
                                    colorProducer2 = colorProducer3;
                                    textAutoSize2 = textAutoSize3;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    z2 = z;
                                    i18 = i3;
                                    textAutoSize2 = textAutoSize;
                                    composer2 = composerStartRestartGroup;
                                    modifier3 = modifier2;
                                    textStyle3 = textStyle2;
                                    function13 = function12;
                                    i19 = i10;
                                    i20 = i2;
                                    colorProducer2 = colorProducer;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda15
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return BasicTextKt.BasicText_RWo7tUw$lambda$2(str, modifier3, textStyle3, function13, i19, z2, i20, i18, colorProducer2, textAutoSize2, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i6 |= 100663296;
                            i16 = i15;
                            i17 = i5 & 512;
                            int i252 = 805306368;
                            if (i17 != 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i14 = i13;
                        i15 = i5 & 256;
                        if (i15 != 0) {
                        }
                        i16 = i15;
                        i17 = i5 & 512;
                        int i2522 = 805306368;
                        if (i17 != 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i10 = i;
                    i11 = i5 & 32;
                    if (i11 != 0) {
                    }
                    i12 = i5 & 64;
                    if (i12 != 0) {
                    }
                    i13 = i5 & 128;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    i15 = i5 & 256;
                    if (i15 != 0) {
                    }
                    i16 = i15;
                    i17 = i5 & 512;
                    int i25222 = 805306368;
                    if (i17 != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function12 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i;
                i11 = i5 & 32;
                if (i11 != 0) {
                }
                i12 = i5 & 64;
                if (i12 != 0) {
                }
                i13 = i5 & 128;
                if (i13 != 0) {
                }
                i14 = i13;
                i15 = i5 & 256;
                if (i15 != 0) {
                }
                i16 = i15;
                i17 = i5 & 512;
                int i252222 = 805306368;
                if (i17 != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            textStyle2 = textStyle;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            function12 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i;
            i11 = i5 & 32;
            if (i11 != 0) {
            }
            i12 = i5 & 64;
            if (i12 != 0) {
            }
            i13 = i5 & 128;
            if (i13 != 0) {
            }
            i14 = i13;
            i15 = i5 & 256;
            if (i15 != 0) {
            }
            i16 = i15;
            i17 = i5 & 512;
            int i2522222 = 805306368;
            if (i17 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        textStyle2 = textStyle;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        function12 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i;
        i11 = i5 & 32;
        if (i11 != 0) {
        }
        i12 = i5 & 64;
        if (i12 != 0) {
        }
        i13 = i5 & 128;
        if (i13 != 0) {
        }
        i14 = i13;
        i15 = i5 & 256;
        if (i15 != 0) {
        }
        i16 = i15;
        i17 = i5 & 512;
        int i25222222 = 805306368;
        if (i17 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i6 & 306783379) != 306783378, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0123  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* JADX INFO: renamed from: BasicText-VhcvRP8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2375BasicTextVhcvRP8(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, Map map, Composer composer, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        TextStyle textStyle2;
        int i8;
        Function1 function12;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Composer composer2;
        final int i16;
        final int i17;
        final Map map2;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final Function1 function13;
        final boolean z2;
        final int i18;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i19;
        TextStyle textStyle4;
        int i20;
        int iM9049getClipgIe3tQ8;
        int i21;
        int i22;
        int i23;
        int i24;
        Composer composerStartRestartGroup = composer.startRestartGroup(851408699);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,inlineContent)448@20200L281:BasicText.kt#423gt5");
        if ((i4 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i25 = i5 & 2;
        if (i25 != 0) {
            i6 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i4 & 384) == 0) {
                    textStyle2 = textStyle;
                    i6 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i4 & 3072) == 0) {
                        function12 = function1;
                        i6 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else {
                        if ((i4 & 24576) == 0) {
                            i6 |= composerStartRestartGroup.changed(i) ? 16384 : 8192;
                        }
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else {
                            if ((196608 & i4) == 0) {
                                i6 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
                            }
                            i11 = i5 & 64;
                            if (i11 == 0) {
                                i6 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i6 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i12 = i5 & 128;
                            if (i12 == 0) {
                                i6 |= 12582912;
                            } else {
                                if ((i4 & 12582912) == 0) {
                                    i13 = i12;
                                    i6 |= composerStartRestartGroup.changed(i3) ? 8388608 : 4194304;
                                }
                                i14 = i5 & 256;
                                if (i14 == 0) {
                                    if ((i4 & 100663296) == 0) {
                                        i15 = i14;
                                        i6 |= composerStartRestartGroup.changedInstance(map) ? 67108864 : 33554432;
                                    }
                                    if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                                        composer2 = composerStartRestartGroup;
                                        composer2.skipToGroupEnd();
                                        i16 = i;
                                        i17 = i2;
                                        map2 = map;
                                        modifier3 = modifier2;
                                        textStyle3 = textStyle2;
                                        function13 = function12;
                                        z2 = z;
                                        i18 = i3;
                                    } else {
                                        Modifier modifier4 = i25 != 0 ? Modifier.INSTANCE : modifier2;
                                        if (i7 != 0) {
                                            textStyle4 = TextStyle.INSTANCE.getDefault();
                                            i19 = i10;
                                        } else {
                                            i19 = i10;
                                            textStyle4 = textStyle2;
                                        }
                                        Function1 function14 = i8 != 0 ? null : function12;
                                        if (i9 != 0) {
                                            iM9049getClipgIe3tQ8 = TextOverflow.INSTANCE.m9049getClipgIe3tQ8();
                                            i20 = i11;
                                        } else {
                                            i20 = i11;
                                            iM9049getClipgIe3tQ8 = i;
                                        }
                                        boolean z3 = i19 != 0 ? true : z;
                                        if (i20 != 0) {
                                            int i26 = i13;
                                            i22 = Integer.MAX_VALUE;
                                            i21 = i26;
                                        } else {
                                            i21 = i13;
                                            i22 = i2;
                                        }
                                        if (i21 != 0) {
                                            i23 = i15;
                                            i24 = 1;
                                        } else {
                                            i23 = i15;
                                            i24 = i3;
                                        }
                                        Map mapEmptyMap = i23 != 0 ? MapsKt.emptyMap() : map;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(851408699, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:448)");
                                        }
                                        composer2 = composerStartRestartGroup;
                                        m2372BasicTextCL7eQgs(annotatedString, modifier4, textStyle4, function14, iM9049getClipgIe3tQ8, z3, i22, i24, mapEmptyMap, null, null, composer2, i6 & 268435454, 0, 1536);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier3 = modifier4;
                                        textStyle3 = textStyle4;
                                        function13 = function14;
                                        i16 = iM9049getClipgIe3tQ8;
                                        z2 = z3;
                                        i17 = i22;
                                        i18 = i24;
                                        map2 = mapEmptyMap;
                                    }
                                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup == null) {
                                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda13
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj, Object obj2) {
                                                return BasicTextKt.BasicText_VhcvRP8$lambda$1(annotatedString, modifier3, textStyle3, function13, i16, z2, i17, i18, map2, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i6 |= 100663296;
                                i15 = i14;
                                if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                }
                            }
                            i13 = i12;
                            i14 = i5 & 256;
                            if (i14 == 0) {
                            }
                            i15 = i14;
                            if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i11 = i5 & 64;
                        if (i11 == 0) {
                        }
                        i12 = i5 & 128;
                        if (i12 == 0) {
                        }
                        i13 = i12;
                        i14 = i5 & 256;
                        if (i14 == 0) {
                        }
                        i15 = i14;
                        if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 == 0) {
                    }
                    i12 = i5 & 128;
                    if (i12 == 0) {
                    }
                    i13 = i12;
                    i14 = i5 & 256;
                    if (i14 == 0) {
                    }
                    i15 = i14;
                    if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function12 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 == 0) {
                }
                i12 = i5 & 128;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i5 & 256;
                if (i14 == 0) {
                }
                i15 = i14;
                if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            textStyle2 = textStyle;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            function12 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 == 0) {
            }
            i12 = i5 & 128;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i5 & 256;
            if (i14 == 0) {
            }
            i15 = i14;
            if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        textStyle2 = textStyle;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        function12 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 == 0) {
        }
        i12 = i5 & 128;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i5 & 256;
        if (i14 == 0) {
        }
        i15 = i14;
        if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0123  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: BasicText-VhcvRP8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2376BasicTextVhcvRP8(final String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, ColorProducer colorProducer, Composer composer, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        TextStyle textStyle2;
        int i8;
        Function1 function12;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Composer composer2;
        final int i16;
        final int i17;
        final ColorProducer colorProducer2;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final Function1 function13;
        final boolean z2;
        final int i18;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i19;
        TextStyle textStyle4;
        int i20;
        int iM9049getClipgIe3tQ8;
        int i21;
        int i22;
        int i23;
        int i24;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1186827822);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,color)318@15279L93:BasicText.kt#423gt5");
        if ((i4 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i25 = i5 & 2;
        if (i25 != 0) {
            i6 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i4 & 384) == 0) {
                    textStyle2 = textStyle;
                    i6 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i4 & 3072) == 0) {
                        function12 = function1;
                        i6 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    }
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else {
                        if ((i4 & 24576) == 0) {
                            i6 |= composerStartRestartGroup.changed(i) ? 16384 : 8192;
                        }
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else {
                            if ((196608 & i4) == 0) {
                                i6 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
                            }
                            i11 = i5 & 64;
                            if (i11 == 0) {
                                i6 |= 1572864;
                            } else if ((i4 & 1572864) == 0) {
                                i6 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i12 = i5 & 128;
                            if (i12 == 0) {
                                i6 |= 12582912;
                            } else {
                                if ((i4 & 12582912) == 0) {
                                    i13 = i12;
                                    i6 |= composerStartRestartGroup.changed(i3) ? 8388608 : 4194304;
                                }
                                i14 = i5 & 256;
                                if (i14 == 0) {
                                    if ((i4 & 100663296) == 0) {
                                        i15 = i14;
                                        i6 |= composerStartRestartGroup.changedInstance(colorProducer) ? 67108864 : 33554432;
                                    }
                                    if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                                        composer2 = composerStartRestartGroup;
                                        composer2.skipToGroupEnd();
                                        i16 = i;
                                        i17 = i2;
                                        colorProducer2 = colorProducer;
                                        modifier3 = modifier2;
                                        textStyle3 = textStyle2;
                                        function13 = function12;
                                        z2 = z;
                                        i18 = i3;
                                    } else {
                                        Modifier modifier4 = i25 != 0 ? Modifier.INSTANCE : modifier2;
                                        if (i7 != 0) {
                                            textStyle4 = TextStyle.INSTANCE.getDefault();
                                            i19 = i10;
                                        } else {
                                            i19 = i10;
                                            textStyle4 = textStyle2;
                                        }
                                        Function1 function14 = i8 != 0 ? null : function12;
                                        if (i9 != 0) {
                                            iM9049getClipgIe3tQ8 = TextOverflow.INSTANCE.m9049getClipgIe3tQ8();
                                            i20 = i11;
                                        } else {
                                            i20 = i11;
                                            iM9049getClipgIe3tQ8 = i;
                                        }
                                        boolean z3 = i19 != 0 ? true : z;
                                        if (i20 != 0) {
                                            int i26 = i13;
                                            i22 = Integer.MAX_VALUE;
                                            i21 = i26;
                                        } else {
                                            i21 = i13;
                                            i22 = i2;
                                        }
                                        if (i21 != 0) {
                                            i23 = i15;
                                            i24 = 1;
                                        } else {
                                            i23 = i15;
                                            i24 = i3;
                                        }
                                        ColorProducer colorProducer3 = i23 != 0 ? null : colorProducer;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1186827822, i6, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:317)");
                                        }
                                        composer2 = composerStartRestartGroup;
                                        m2374BasicTextRWo7tUw(str, modifier4, textStyle4, (Function1<? super TextLayoutResult, Unit>) function14, iM9049getClipgIe3tQ8, z3, i22, i24, colorProducer3, (TextAutoSize) null, composer2, i6 & 268435454, 512);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier3 = modifier4;
                                        textStyle3 = textStyle4;
                                        function13 = function14;
                                        i16 = iM9049getClipgIe3tQ8;
                                        z2 = z3;
                                        i17 = i22;
                                        i18 = i24;
                                        colorProducer2 = colorProducer3;
                                    }
                                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup == null) {
                                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda16
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj, Object obj2) {
                                                return BasicTextKt.BasicText_VhcvRP8$lambda$0(str, modifier3, textStyle3, function13, i16, z2, i17, i18, colorProducer2, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i6 |= 100663296;
                                i15 = i14;
                                if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                }
                            }
                            i13 = i12;
                            i14 = i5 & 256;
                            if (i14 == 0) {
                            }
                            i15 = i14;
                            if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i11 = i5 & 64;
                        if (i11 == 0) {
                        }
                        i12 = i5 & 128;
                        if (i12 == 0) {
                        }
                        i13 = i12;
                        i14 = i5 & 256;
                        if (i14 == 0) {
                        }
                        i15 = i14;
                        if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 == 0) {
                    }
                    i12 = i5 & 128;
                    if (i12 == 0) {
                    }
                    i13 = i12;
                    i14 = i5 & 256;
                    if (i14 == 0) {
                    }
                    i15 = i14;
                    if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function12 = function1;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 == 0) {
                }
                i12 = i5 & 128;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i5 & 256;
                if (i14 == 0) {
                }
                i15 = i14;
                if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            textStyle2 = textStyle;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            function12 = function1;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 == 0) {
            }
            i12 = i5 & 128;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i5 & 256;
            if (i14 == 0) {
            }
            i15 = i14;
            if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        textStyle2 = textStyle;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        function12 = function1;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 == 0) {
        }
        i12 = i5 & 128;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i5 & 256;
        if (i14 == 0) {
        }
        i15 = i14;
        if (composerStartRestartGroup.shouldExecute((i6 & 38347923) == 38347922, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit BasicText_4YKlhWE$lambda$0(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, Map map, int i3, int i4, Composer composer, int i5) {
        m2369BasicText4YKlhWE(annotatedString, modifier, textStyle, function1, i, z, i2, map, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    static final Unit BasicText_4YKlhWE$lambda$1(String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, int i4, int i5, Composer composer, int i6) {
        m2370BasicText4YKlhWE(str, modifier, textStyle, function1, i, z, i2, i3, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    static final Unit BasicText_BpD7jsM$lambda$0(String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, int i4, Composer composer, int i5) {
        m2371BasicTextBpD7jsM(str, modifier, textStyle, function1, i, z, i2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    private static final AnnotatedString BasicText_CL7eQgs$lambda$3(MutableState<AnnotatedString> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicText_CL7eQgs$lambda$5$0(MutableState mutableState, TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
        mutableState.setValue(textSubstitutionValue.isShowingSubstitution() ? textSubstitutionValue.getSubstitution() : textSubstitutionValue.getOriginal());
        return Unit.INSTANCE;
    }

    static final Unit BasicText_CL7eQgs$lambda$6(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, Map map, ColorProducer colorProducer, TextAutoSize textAutoSize, int i4, int i5, int i6, Composer composer, int i7) {
        m2372BasicTextCL7eQgs(annotatedString, modifier, textStyle, function1, i, z, i2, i3, map, colorProducer, textAutoSize, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    static final Unit BasicText_RWo7tUw$lambda$2(String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, ColorProducer colorProducer, TextAutoSize textAutoSize, int i4, int i5, Composer composer, int i6) {
        m2374BasicTextRWo7tUw(str, modifier, textStyle, (Function1<? super TextLayoutResult, Unit>) function1, i, z, i2, i3, colorProducer, textAutoSize, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    static final Unit BasicText_RWo7tUw$lambda$3(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, Map map, ColorProducer colorProducer, int i4, int i5, Composer composer, int i6) {
        m2373BasicTextRWo7tUw(annotatedString, modifier, textStyle, function1, i, z, i2, i3, map, colorProducer, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    static final Unit BasicText_VhcvRP8$lambda$0(String str, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, ColorProducer colorProducer, int i4, int i5, Composer composer, int i6) {
        m2376BasicTextVhcvRP8(str, modifier, textStyle, function1, i, z, i2, i3, colorProducer, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    static final Unit BasicText_VhcvRP8$lambda$1(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, Map map, int i4, int i5, Composer composer, int i6) {
        m2375BasicTextVhcvRP8(annotatedString, modifier, textStyle, function1, i, z, i2, i3, map, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:242:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0127  */
    /* JADX INFO: renamed from: LayoutWithLinksAndInlineContent-11Od_4g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m2377LayoutWithLinksAndInlineContent11Od_4g(final Modifier modifier, final AnnotatedString annotatedString, final Function1<? super TextLayoutResult, Unit> function1, final boolean z, Map<String, InlineTextContent> map, final TextStyle textStyle, final int i, final boolean z2, final int i2, final int i3, final FontFamily.Resolver resolver, final SelectionController selectionController, final ColorProducer colorProducer, final Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function12, final TextAutoSize textAutoSize, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        final Map<String, InlineTextContent> map2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final TextLinkScope textLinkScope;
        int i10;
        Function0 function0;
        List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> list;
        Function1 function13;
        final MutableState mutableState;
        int i11;
        TextMeasurePolicy textMeasurePolicy;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2118572703);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LayoutWithLinksAndInlineContent)N(modifier,text,onTextLayout,hasInlineContent,inlineContent,style,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,fontFamilyResolver,selectionController,color,onShowTranslation,autoSize)678@28236L162,694@28726L117,685@28404L1429:BasicText.kt#423gt5");
        if ((i4 & 6) == 0) {
            i7 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        if ((i4 & 48) == 0) {
            i7 |= composerStartRestartGroup.changed(annotatedString) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i7 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        int i12 = i6 & 16;
        if (i12 == 0) {
            if ((i4 & 24576) == 0) {
                i7 |= composerStartRestartGroup.changedInstance(map) ? 16384 : 8192;
            }
            if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i7 |= composerStartRestartGroup.changed(textStyle) ? 131072 : 65536;
            }
            if ((i4 & 1572864) == 0) {
                i7 |= composerStartRestartGroup.changed(i) ? 1048576 : 524288;
            }
            if ((i4 & 12582912) == 0) {
                i7 |= composerStartRestartGroup.changed(z2) ? 8388608 : 4194304;
            }
            if ((i4 & 100663296) == 0) {
                i7 |= composerStartRestartGroup.changed(i2) ? 67108864 : 33554432;
            }
            if ((i4 & 805306368) == 0) {
                i7 |= composerStartRestartGroup.changed(i3) ? 536870912 : 268435456;
            }
            if ((i5 & 6) != 0) {
                i8 = i5 | (composerStartRestartGroup.changedInstance(resolver) ? 4 : 2);
            } else {
                i8 = i5;
            }
            if ((i5 & 48) == 0) {
                i8 |= composerStartRestartGroup.changedInstance(selectionController) ? 32 : 16;
            }
            if ((i5 & 384) == 0) {
                i8 |= composerStartRestartGroup.changedInstance(colorProducer) ? 256 : 128;
            }
            if ((i5 & 3072) == 0) {
                i8 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
            }
            if ((i5 & 24576) == 0) {
                i8 |= (32768 & i5) == 0 ? composerStartRestartGroup.changed(textAutoSize) : composerStartRestartGroup.changedInstance(textAutoSize) ? 16384 : 8192;
            }
            i9 = i8;
            if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i9 & 9363) != 9362, i7 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                map2 = map;
            } else {
                Map<String, InlineTextContent> mapEmptyMap = i12 != 0 ? MapsKt.emptyMap() : map;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2118572703, i7, i9, "androidx.compose.foundation.text.LayoutWithLinksAndInlineContent (BasicText.kt:646)");
                }
                if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                    composerStartRestartGroup.startReplaceGroup(145641571);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "650@27301L38");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -133848793, "CC(remember):BasicText.kt#9igjgp");
                    boolean z3 = (i7 & 112) == 32;
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new TextLinkScope(annotatedString);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    textLinkScope = (TextLinkScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(145707228);
                    composerStartRestartGroup.endReplaceGroup();
                    textLinkScope = null;
                }
                if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                    composerStartRestartGroup.startReplaceGroup(145905443);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "657@27566L70");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -133840281, "CC(remember):BasicText.kt#9igjgp");
                    i10 = i9;
                    boolean zChanged = ((i7 & 112) == 32) | composerStartRestartGroup.changed(textLinkScope);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$1$0(textLinkScope, annotatedString);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    function0 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    i10 = i9;
                    composerStartRestartGroup.startReplaceGroup(146002721);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "659@27666L8");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -133837143, "CC(remember):BasicText.kt#9igjgp");
                    boolean z4 = (i7 & 112) == 32;
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z4 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$2$0(annotatedString);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function0 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                }
                Function0 function02 = function0;
                Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> pairResolveInlineContent = z ? AnnotatedStringResolveInlineContentKt.resolveInlineContent(annotatedString, mapEmptyMap) : new Pair<>(null, null);
                List<AnnotatedString.Range<Placeholder>> listComponent1 = pairResolveInlineContent.component1();
                List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> listComponent2 = pairResolveInlineContent.component2();
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(146318828);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "670@27983L61");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -133826946, "CC(remember):BasicText.kt#9igjgp");
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    list = listComponent2;
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        function13 = null;
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        function13 = null;
                    }
                    mutableState = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    list = listComponent2;
                    function13 = null;
                    composerStartRestartGroup.startReplaceGroup(146406588);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableState = null;
                }
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(146499837);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "675@28166L44");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -133821107, "CC(remember):BasicText.kt#9igjgp");
                    boolean zChanged2 = composerStartRestartGroup.changed(mutableState);
                    Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        i11 = i7;
                    } else {
                        i11 = i7;
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        }
                        function13 = (Function1) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$4$0(mutableState, (List) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    function13 = (Function1) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    i11 = i7;
                    composerStartRestartGroup.startReplaceGroup(146571260);
                    composerStartRestartGroup.endReplaceGroup();
                }
                Function1 function14 = function13;
                int i13 = (i11 >> 3) & 14;
                final MutableState mutableState2 = mutableState;
                final TextLinkScope textLinkScope2 = textLinkScope;
                List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> list2 = list;
                BasicText_androidKt.BackgroundTextMeasurement(annotatedString, textStyle, resolver, listComponent1, composerStartRestartGroup, ((i10 << 6) & 896) | ((i11 >> 12) & 112) | i13);
                AnnotatedString annotatedString2 = (AnnotatedString) function02.invoke();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -133803114, "CC(remember):BasicText.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(textLinkScope2) | ((i11 & 896) == 256);
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$6$0(textLinkScope2, function1, (TextLayoutResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Map<String, InlineTextContent> map3 = mapEmptyMap;
                Modifier modifierM2378textModifierCL7eQgs = m2378textModifierCL7eQgs(modifier, annotatedString2, textStyle, (Function1) objRememberedValue6, i, z2, i2, i3, resolver, listComponent1, function14, selectionController, colorProducer, function12, textAutoSize);
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(147927697);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "717@29664L55,718@29754L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -133773160, "CC(remember):BasicText.kt#9igjgp");
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(textLinkScope2);
                    Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$8$0(textLinkScope2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Function0 function03 = (Function0) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -133770296, "CC(remember):BasicText.kt#9igjgp");
                    boolean zChanged3 = composerStartRestartGroup.changed(mutableState2);
                    Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$9$0(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    TextMeasurePolicy textMeasurePolicy2 = new TextMeasurePolicy(function03, (Function0) objRememberedValue8);
                    composerStartRestartGroup.endReplaceGroup();
                    textMeasurePolicy = textMeasurePolicy2;
                } else {
                    composerStartRestartGroup.startReplaceGroup(147750935);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "713@29493L55");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -133778632, "CC(remember):BasicText.kt#9igjgp");
                    boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(textLinkScope2);
                    Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue9 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$7$0(textLinkScope2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LinksTextMeasurePolicy linksTextMeasurePolicy = new LinksTextMeasurePolicy((Function0) objRememberedValue9);
                    composerStartRestartGroup.endReplaceGroup();
                    textMeasurePolicy = linksTextMeasurePolicy;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2378textModifierCL7eQgs);
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
                Updater.m5603setimpl(composerM5595constructorimpl, textMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -433564842, "C:BasicText.kt#423gt5");
                if (textLinkScope2 == null) {
                    composerStartRestartGroup.startReplaceGroup(-433557001);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-291080374);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "687@28455L18");
                    textLinkScope2.LinksComposables(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                }
                if (list2 == null) {
                    composerStartRestartGroup.startReplaceGroup(-433506223);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-433506222);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*688@28511L48");
                    AnnotatedStringResolveInlineContentKt.InlineChildren(annotatedString, list2, composerStartRestartGroup, i13);
                    Unit unit2 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit3 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                map2 = map3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$10(modifier, annotatedString, function1, z, map2, textStyle, i, z2, i2, i3, resolver, selectionController, colorProducer, function12, textAutoSize, i4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i7 |= 24576;
        if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if ((i4 & 1572864) == 0) {
        }
        if ((i4 & 12582912) == 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        if ((i4 & 805306368) == 0) {
        }
        if ((i5 & 6) != 0) {
        }
        if ((i5 & 48) == 0) {
        }
        if ((i5 & 384) == 0) {
        }
        if ((i5 & 3072) == 0) {
        }
        if ((i5 & 24576) == 0) {
        }
        i9 = i8;
        if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i9 & 9363) != 9362, i7 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString LayoutWithLinksAndInlineContent_11Od_4g$lambda$1$0(TextLinkScope textLinkScope, AnnotatedString annotatedString) {
        AnnotatedString annotatedStringApplyAnnotators$foundation;
        return (textLinkScope == null || (annotatedStringApplyAnnotators$foundation = textLinkScope.applyAnnotators$foundation()) == null) ? annotatedString : annotatedStringApplyAnnotators$foundation;
    }

    static final Unit LayoutWithLinksAndInlineContent_11Od_4g$lambda$10(Modifier modifier, AnnotatedString annotatedString, Function1 function1, boolean z, Map map, TextStyle textStyle, int i, boolean z2, int i2, int i3, FontFamily.Resolver resolver, SelectionController selectionController, ColorProducer colorProducer, Function1 function12, TextAutoSize textAutoSize, int i4, int i5, int i6, Composer composer, int i7) {
        m2377LayoutWithLinksAndInlineContent11Od_4g(modifier, annotatedString, function1, z, map, textStyle, i, z2, i2, i3, resolver, selectionController, colorProducer, function12, textAutoSize, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString LayoutWithLinksAndInlineContent_11Od_4g$lambda$2$0(AnnotatedString annotatedString) {
        return annotatedString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LayoutWithLinksAndInlineContent_11Od_4g$lambda$4$0(MutableState mutableState, List list) {
        if (mutableState != null) {
            mutableState.setValue(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LayoutWithLinksAndInlineContent_11Od_4g$lambda$6$0(TextLinkScope textLinkScope, Function1 function1, TextLayoutResult textLayoutResult) {
        if (textLinkScope != null) {
            textLinkScope.setTextLayoutResult(textLayoutResult);
        }
        if (function1 != null) {
            function1.invoke(textLayoutResult);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LayoutWithLinksAndInlineContent_11Od_4g$lambda$7$0(TextLinkScope textLinkScope) {
        if (textLinkScope != null) {
            return textLinkScope.getShouldMeasureLinks().invoke().booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LayoutWithLinksAndInlineContent_11Od_4g$lambda$8$0(TextLinkScope textLinkScope) {
        if (textLinkScope != null) {
            return textLinkScope.getShouldMeasureLinks().invoke().booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List LayoutWithLinksAndInlineContent_11Od_4g$lambda$9$0(MutableState mutableState) {
        if (mutableState != null) {
            return (List) mutableState.getValue();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Pair<Placeable, Function0<IntOffset>>> measureWithTextRangeMeasureConstraints(List<? extends Measurable> list, Function0<Boolean> function0) {
        if (!function0.invoke().booleanValue()) {
            return null;
        }
        TextRangeLayoutMeasureScope textRangeLayoutMeasureScope = new TextRangeLayoutMeasureScope();
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = list.get(i);
            Object parentData = measurable.getParentData();
            Intrinsics.checkNotNull(parentData, "null cannot be cast to non-null type androidx.compose.foundation.text.TextRangeLayoutModifier");
            TextRangeLayoutMeasureResult textRangeLayoutMeasureResultMeasure = ((TextRangeLayoutModifier) parentData).getMeasurePolicy().measure(textRangeLayoutMeasureScope);
            arrayList.add(new Pair(measurable.mo7769measureBRTryo0(Constraints.INSTANCE.m9076fitPrioritizingWidthZbe2FdA(textRangeLayoutMeasureResultMeasure.getWidth(), textRangeLayoutMeasureResultMeasure.getWidth(), textRangeLayoutMeasureResultMeasure.getHeight(), textRangeLayoutMeasureResultMeasure.getHeight())), textRangeLayoutMeasureResultMeasure.getPlace()));
        }
        return arrayList;
    }

    private static final Saver<Long, Long> selectionIdSaver(final SelectionRegistrar selectionRegistrar) {
        return SaverKt.Saver(new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BasicTextKt.selectionIdSaver$lambda$0(selectionRegistrar, (SaverScope) obj, ((Long) obj2).longValue());
            }
        }, new Function1() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(((Long) obj).longValue());
            }
        });
    }

    static final Long selectionIdSaver$lambda$0(SelectionRegistrar selectionRegistrar, SaverScope saverScope, long j) {
        if (SelectionRegistrarKt.hasSelection(selectionRegistrar, j)) {
            return Long.valueOf(j);
        }
        return null;
    }

    /* JADX INFO: renamed from: textModifier-CL7eQgs, reason: not valid java name */
    private static final Modifier m2378textModifierCL7eQgs(Modifier modifier, AnnotatedString annotatedString, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController, ColorProducer colorProducer, Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function13, TextAutoSize textAutoSize) {
        if (selectionController == null) {
            return modifier.then(Modifier.INSTANCE).then(new TextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, null, colorProducer, textAutoSize, function13, null));
        }
        return modifier.then(selectionController.getModifier()).then(new SelectableTextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, selectionController, colorProducer, textAutoSize, null));
    }
}
