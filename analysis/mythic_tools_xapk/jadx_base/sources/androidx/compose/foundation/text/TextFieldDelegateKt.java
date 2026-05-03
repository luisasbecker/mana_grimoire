package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.muxer.MuxerUtil;
import com.facebook.internal.AnalyticsEvents;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TextFieldDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0010\u001a.\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001a"}, d2 = {"DefaultWidthCharCount", "", "EmptyTextReplacement", "", "getEmptyTextReplacement", "()Ljava/lang/String;", "computeSizeForDefaultText", "Landroidx/compose/ui/unit/IntSize;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Landroidx/compose/ui/text/TextStyle;", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "text", "maxLines", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/lang/String;I)J", "focusedRectInRoot", "Landroidx/compose/ui/geometry/Rect;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusOffset", "sizeForDefaultText", "Lkotlin/Function0;", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldDelegateKt {
    public static final int DefaultWidthCharCount = 10;
    private static final String EmptyTextReplacement = StringsKt.repeat("H", 10);

    public static final long computeSizeForDefaultText(TextStyle textStyle, Density density, FontFamily.Resolver resolver, String str, int i) {
        Paragraph paragraphM8435ParagraphUl8oQg4 = ParagraphKt.m8435ParagraphUl8oQg4(str, textStyle, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), density, resolver, (64 & 32) != 0 ? CollectionsKt.emptyList() : CollectionsKt.emptyList(), (64 & 64) != 0 ? CollectionsKt.emptyList() : null, (64 & 128) != 0 ? Integer.MAX_VALUE : i, (64 & 256) != 0 ? TextOverflow.INSTANCE.m9049getClipgIe3tQ8() : TextOverflow.INSTANCE.m9049getClipgIe3tQ8());
        return IntSize.m9280constructorimpl((((long) TextDelegateKt.ceilToIntPx(paragraphM8435ParagraphUl8oQg4.getMinIntrinsicWidth())) << 32) | (((long) TextDelegateKt.ceilToIntPx(paragraphM8435ParagraphUl8oQg4.getHeight())) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    public static /* synthetic */ long computeSizeForDefaultText$default(TextStyle textStyle, Density density, FontFamily.Resolver resolver, String str, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str = EmptyTextReplacement;
        }
        if ((i2 & 16) != 0) {
            i = 1;
        }
        return computeSizeForDefaultText(textStyle, density, resolver, str, i);
    }

    public static final Rect focusedRectInRoot(TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, int i, Function0<IntSize> function0) {
        Rect boundingBox = i < textLayoutResult.getLayoutInput().getText().length() ? textLayoutResult.getBoundingBox(i) : i != 0 ? textLayoutResult.getBoundingBox(i - 1) : new Rect(0.0f, 0.0f, 1.0f, (int) (function0.invoke().m9289unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        long jMo7780localToRootMKHz9U = layoutCoordinates.mo7780localToRootMKHz9U(Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(boundingBox.getTop())) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(boundingBox.getLeft())) << 32)));
        return RectKt.m6120Recttz77jQw(Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jMo7780localToRootMKHz9U >> 32)))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jMo7780localToRootMKHz9U & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), Size.m6140constructorimpl((((long) Float.floatToRawIntBits(boundingBox.getBottom() - boundingBox.getTop())) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(boundingBox.getRight() - boundingBox.getLeft())) << 32)));
    }

    public static final String getEmptyTextReplacement() {
        return EmptyTextReplacement;
    }
}
