package com.studiolaganne.lengendarylens;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeckCardsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"createDeckCardsLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "displayMode", "Lcom/studiolaganne/lengendarylens/DeckDisplayMode;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeckCardsAdapterKt {

    /* JADX INFO: compiled from: DeckCardsAdapter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeckDisplayMode.values().length];
            try {
                iArr[DeckDisplayMode.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeckDisplayMode.ONE_COLUMN_STACKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeckDisplayMode.TWO_COLUMN_STACKS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final GridLayoutManager createDeckCardsLayoutManager(Context context, DeckDisplayMode displayMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(displayMode, "displayMode");
        int i = WhenMappings.$EnumSwitchMapping$0[displayMode.ordinal()];
        int i2 = 1;
        if (i != 1 && i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i2 = 2;
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, i2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.studiolaganne.lengendarylens.DeckCardsAdapterKt$createDeckCardsLayoutManager$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                return 1;
            }
        });
        return gridLayoutManager;
    }
}
