package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.window.reflection.WindowExtensionsConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SelectionAdjustment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a4\u0010\u000b\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a,\u0010\u0015\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0014\u0010\u0017\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002\u001a\u001c\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\tH\u0002¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0001X\u008a\u0084\u0002"}, d2 = {"updateSelectionBoundary", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "info", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "previousSelectionAnchor", "isExpanding", "", "currentRawOffset", "", "isStart", "snapToWordBoundary", "currentLine", "currentOffset", "otherOffset", "crossed", "adjustToBoundaries", "Landroidx/compose/foundation/text/selection/Selection;", WindowExtensionsConstants.LAYOUT_PACKAGE, "boundaryFunction", "Landroidx/compose/foundation/text/selection/BoundaryFunction;", "anchorOnBoundary", "slot", "ensureAtLeastOneChar", "expandOneChar", "changeOffset", "newOffset", "foundation", "currentRawLine", "anchorSnappedToWordBoundary"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionAdjustmentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Selection adjustToBoundaries(SelectionLayout selectionLayout, BoundaryFunction boundaryFunction) {
        boolean z = selectionLayout.getCrossStatus() == CrossStatus.CROSSED;
        return new Selection(anchorOnBoundary(selectionLayout.getStartInfo(), z, true, selectionLayout.getStartSlot(), boundaryFunction), anchorOnBoundary(selectionLayout.getEndInfo(), z, false, selectionLayout.getEndSlot(), boundaryFunction), z);
    }

    private static final Selection.AnchorInfo anchorOnBoundary(SelectableInfo selectableInfo, boolean z, boolean z2, int i, BoundaryFunction boundaryFunction) {
        int rawStartHandleOffset = z2 ? selectableInfo.getRawStartHandleOffset() : selectableInfo.getRawEndHandleOffset();
        if (i != selectableInfo.getSlot()) {
            return selectableInfo.anchorForOffset(rawStartHandleOffset);
        }
        long jMo2802getBoundaryfzxv0v0 = boundaryFunction.mo2802getBoundaryfzxv0v0(selectableInfo, rawStartHandleOffset);
        return selectableInfo.anchorForOffset(z ^ z2 ? TextRange.m8556getStartimpl(jMo2802getBoundaryfzxv0v0) : TextRange.m8551getEndimpl(jMo2802getBoundaryfzxv0v0));
    }

    private static final Selection.AnchorInfo changeOffset(Selection.AnchorInfo anchorInfo, SelectableInfo selectableInfo, int i) {
        return Selection.AnchorInfo.copy$default(anchorInfo, selectableInfo.getTextLayoutResult().getBidiRunDirection(i), i, 0L, 4, null);
    }

    public static final Selection ensureAtLeastOneChar(Selection selection, SelectionLayout selectionLayout) {
        if (SelectionLayoutKt.isCollapsed(selection, selectionLayout)) {
            return (selectionLayout.getSize() > 1 || selectionLayout.getPreviousSelection() == null || selectionLayout.getInfo().getInputText().length() == 0) ? selection : expandOneChar(selection, selectionLayout);
        }
        return selection;
    }

    private static final Selection expandOneChar(Selection selection, SelectionLayout selectionLayout) {
        SelectableInfo currentInfo = selectionLayout.getInfo();
        String inputText = currentInfo.getInputText();
        int rawStartHandleOffset = currentInfo.getRawStartHandleOffset();
        int length = inputText.length();
        if (rawStartHandleOffset == 0) {
            int iFindFollowingBreak = StringHelpers_androidKt.findFollowingBreak(inputText, 0);
            return selectionLayout.getIsStartHandle() ? Selection.copy$default(selection, changeOffset(selection.getStart(), currentInfo, iFindFollowingBreak), null, true, 2, null) : Selection.copy$default(selection, null, changeOffset(selection.getEnd(), currentInfo, iFindFollowingBreak), false, 1, null);
        }
        if (rawStartHandleOffset == length) {
            int iFindPrecedingBreak = StringHelpers_androidKt.findPrecedingBreak(inputText, length);
            return selectionLayout.getIsStartHandle() ? Selection.copy$default(selection, changeOffset(selection.getStart(), currentInfo, iFindPrecedingBreak), null, false, 2, null) : Selection.copy$default(selection, null, changeOffset(selection.getEnd(), currentInfo, iFindPrecedingBreak), true, 1, null);
        }
        Selection previousSelection = selectionLayout.getPreviousSelection();
        boolean z = previousSelection != null && previousSelection.getHandlesCrossed();
        int iFindPrecedingBreak2 = selectionLayout.getIsStartHandle() ^ z ? StringHelpers_androidKt.findPrecedingBreak(inputText, rawStartHandleOffset) : StringHelpers_androidKt.findFollowingBreak(inputText, rawStartHandleOffset);
        return selectionLayout.getIsStartHandle() ? Selection.copy$default(selection, changeOffset(selection.getStart(), currentInfo, iFindPrecedingBreak2), null, z, 2, null) : Selection.copy$default(selection, null, changeOffset(selection.getEnd(), currentInfo, iFindPrecedingBreak2), z, 1, null);
    }

    private static final boolean isExpanding(SelectableInfo selectableInfo, int i, boolean z) {
        if (selectableInfo.getRawPreviousHandleOffset() == -1) {
            return true;
        }
        if (i == selectableInfo.getRawPreviousHandleOffset()) {
            return false;
        }
        return z ^ (selectableInfo.getRawCrossStatus() == CrossStatus.CROSSED) ? i < selectableInfo.getRawPreviousHandleOffset() : i > selectableInfo.getRawPreviousHandleOffset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Selection.AnchorInfo snapToWordBoundary(SelectableInfo selectableInfo, int i, int i2, int i3, boolean z, boolean z2) {
        long jM8528getWordBoundaryjx7JFs = selectableInfo.getTextLayoutResult().m8528getWordBoundaryjx7JFs(i2);
        int iM8556getStartimpl = selectableInfo.getTextLayoutResult().getLineForOffset(TextRange.m8556getStartimpl(jM8528getWordBoundaryjx7JFs)) == i ? TextRange.m8556getStartimpl(jM8528getWordBoundaryjx7JFs) : i >= selectableInfo.getTextLayoutResult().getLineCount() ? selectableInfo.getTextLayoutResult().getLineStart(selectableInfo.getTextLayoutResult().getLineCount() - 1) : selectableInfo.getTextLayoutResult().getLineStart(i);
        int iM8551getEndimpl = selectableInfo.getTextLayoutResult().getLineForOffset(TextRange.m8551getEndimpl(jM8528getWordBoundaryjx7JFs)) == i ? TextRange.m8551getEndimpl(jM8528getWordBoundaryjx7JFs) : i >= selectableInfo.getTextLayoutResult().getLineCount() ? TextLayoutResult.getLineEnd$default(selectableInfo.getTextLayoutResult(), selectableInfo.getTextLayoutResult().getLineCount() - 1, false, 2, null) : TextLayoutResult.getLineEnd$default(selectableInfo.getTextLayoutResult(), i, false, 2, null);
        if (iM8556getStartimpl == i3) {
            return selectableInfo.anchorForOffset(iM8551getEndimpl);
        }
        if (iM8551getEndimpl == i3) {
            return selectableInfo.anchorForOffset(iM8556getStartimpl);
        }
        if (!(z ^ z2) ? i2 >= iM8556getStartimpl : i2 > iM8551getEndimpl) {
            iM8556getStartimpl = iM8551getEndimpl;
        }
        return selectableInfo.anchorForOffset(iM8556getStartimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Selection.AnchorInfo updateSelectionBoundary(final SelectionLayout selectionLayout, final SelectableInfo selectableInfo, Selection.AnchorInfo anchorInfo) {
        final int rawStartHandleOffset = selectionLayout.getIsStartHandle() ? selectableInfo.getRawStartHandleOffset() : selectableInfo.getRawEndHandleOffset();
        if ((selectionLayout.getIsStartHandle() ? selectionLayout.getStartSlot() : selectionLayout.getEndSlot()) != selectableInfo.getSlot()) {
            return selectableInfo.anchorForOffset(rawStartHandleOffset);
        }
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustmentKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(selectableInfo.getTextLayoutResult().getLineForOffset(rawStartHandleOffset));
            }
        });
        final int rawEndHandleOffset = selectionLayout.getIsStartHandle() ? selectableInfo.getRawEndHandleOffset() : selectableInfo.getRawStartHandleOffset();
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustmentKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SelectableInfo selectableInfo2 = selectableInfo;
                int i = rawStartHandleOffset;
                int i2 = rawEndHandleOffset;
                SelectionLayout selectionLayout2 = selectionLayout;
                return SelectionAdjustmentKt.snapToWordBoundary(selectableInfo2, SelectionAdjustmentKt.updateSelectionBoundary$lambda$1(lazy), i, i2, selectionLayout2.getIsStartHandle(), selectionLayout2.getCrossStatus() == CrossStatus.CROSSED);
            }
        });
        if (selectableInfo.getSelectableId() != anchorInfo.getSelectableId()) {
            return updateSelectionBoundary$lambda$3(lazy2);
        }
        int rawPreviousHandleOffset = selectableInfo.getRawPreviousHandleOffset();
        if (rawStartHandleOffset == rawPreviousHandleOffset) {
            return anchorInfo;
        }
        if (updateSelectionBoundary$lambda$1(lazy) != selectableInfo.getTextLayoutResult().getLineForOffset(rawPreviousHandleOffset)) {
            return updateSelectionBoundary$lambda$3(lazy2);
        }
        int offset = anchorInfo.getOffset();
        long jM8528getWordBoundaryjx7JFs = selectableInfo.getTextLayoutResult().m8528getWordBoundaryjx7JFs(offset);
        return !isExpanding(selectableInfo, rawStartHandleOffset, selectionLayout.getIsStartHandle()) ? selectableInfo.anchorForOffset(rawStartHandleOffset) : (offset == TextRange.m8556getStartimpl(jM8528getWordBoundaryjx7JFs) || offset == TextRange.m8551getEndimpl(jM8528getWordBoundaryjx7JFs)) ? updateSelectionBoundary$lambda$3(lazy2) : selectableInfo.anchorForOffset(rawStartHandleOffset);
    }

    private static final int updateSelectionBoundary$lambda$1(Lazy<Integer> lazy) {
        return lazy.getValue().intValue();
    }

    private static final Selection.AnchorInfo updateSelectionBoundary$lambda$3(Lazy<Selection.AnchorInfo> lazy) {
        return lazy.getValue();
    }
}
