package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionStatusView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0010J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionStatusView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mainIconLabel", "Landroid/widget/TextView;", "proxyLabel", "currentStatus", "Lcom/studiolaganne/lengendarylens/CollectionStatus;", "currentFontSize", "", "setupViews", "", "setStatus", "status", "setIconSize", "sizeInSp", "updateUI", "getStatus", "setCustomIconText", "iconText", "", "useSolidFont", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionStatusView extends ConstraintLayout {
    public static final int $stable = 8;
    private float currentFontSize;
    private CollectionStatus currentStatus;
    private TextView mainIconLabel;
    private TextView proxyLabel;

    /* JADX INFO: compiled from: CollectionStatusView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CollectionStatus.values().length];
            try {
                iArr[CollectionStatus.EXACT_MATCH_FETCHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CollectionStatus.EXACT_MATCH_NOT_FETCHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CollectionStatus.PARTIAL_MATCH_NOT_FETCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CollectionStatus.NO_MATCH_IN_COLLECTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CollectionStatus.PROXY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CollectionStatusView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CollectionStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.currentFontSize = 24.0f;
        ConstraintLayout.inflate(context, R.layout.view_collection_status, this);
        setupViews();
    }

    public /* synthetic */ CollectionStatusView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ void setCustomIconText$default(CollectionStatusView collectionStatusView, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        collectionStatusView.setCustomIconText(str, z);
    }

    private final void setupViews() {
        View viewFindViewById = findViewById(R.id.mainIconLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mainIconLabel = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.proxyLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.proxyLabel = (TextView) viewFindViewById2;
    }

    private final void updateUI() {
        CollectionStatus collectionStatus = this.currentStatus;
        if (collectionStatus == null) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[collectionStatus.ordinal()];
        TextView textView = null;
        if (i == 1) {
            TextView textView2 = this.mainIconLabel;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
                textView2 = null;
            }
            textView2.setTypeface(getResources().getFont(R.font.fa6solid));
            TextView textView3 = this.mainIconLabel;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
                textView3 = null;
            }
            textView3.setText("\uf058");
            TextView textView4 = this.mainIconLabel;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
                textView4 = null;
            }
            textView4.setTextColor(ContextCompat.getColor(getContext(), R.color.selected_color_new));
            TextView textView5 = this.proxyLabel;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("proxyLabel");
            } else {
                textView = textView5;
            }
            textView.setVisibility(8);
            return;
        }
        if (i == 2) {
            TextView textView6 = this.mainIconLabel;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
                textView6 = null;
            }
            textView6.setTypeface(getResources().getFont(R.font.fa6regular));
            TextView textView7 = this.mainIconLabel;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
                textView7 = null;
            }
            textView7.setText("\uf058");
            TextView textView8 = this.mainIconLabel;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
                textView8 = null;
            }
            textView8.setTextColor(ContextCompat.getColor(getContext(), R.color.text_color));
            TextView textView9 = this.proxyLabel;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("proxyLabel");
            } else {
                textView = textView9;
            }
            textView.setVisibility(8);
            return;
        }
        if (i == 3) {
            TextView textView10 = this.mainIconLabel;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
                textView10 = null;
            }
            textView10.setTypeface(getResources().getFont(R.font.fa6solid));
            TextView textView11 = this.mainIconLabel;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
                textView11 = null;
            }
            textView11.setText("\uf059");
            TextView textView12 = this.mainIconLabel;
            if (textView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
                textView12 = null;
            }
            textView12.setTextColor(ContextCompat.getColor(getContext(), R.color.text_color));
            TextView textView13 = this.proxyLabel;
            if (textView13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("proxyLabel");
            } else {
                textView = textView13;
            }
            textView.setVisibility(8);
            return;
        }
        if (i == 4) {
            TextView textView14 = this.mainIconLabel;
            if (textView14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
                textView14 = null;
            }
            textView14.setTypeface(getResources().getFont(R.font.fa6regular));
            TextView textView15 = this.mainIconLabel;
            if (textView15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
                textView15 = null;
            }
            textView15.setText("\uf111");
            TextView textView16 = this.mainIconLabel;
            if (textView16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
                textView16 = null;
            }
            textView16.setTextColor(ContextCompat.getColor(getContext(), R.color.text_color));
            TextView textView17 = this.proxyLabel;
            if (textView17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("proxyLabel");
            } else {
                textView = textView17;
            }
            textView.setVisibility(8);
            return;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        TextView textView18 = this.mainIconLabel;
        if (textView18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
            textView18 = null;
        }
        textView18.setTypeface(getResources().getFont(R.font.fa6solid));
        TextView textView19 = this.mainIconLabel;
        if (textView19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
            textView19 = null;
        }
        textView19.setText("\uf111");
        TextView textView20 = this.mainIconLabel;
        if (textView20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
            textView20 = null;
        }
        textView20.setTextColor(ContextCompat.getColor(getContext(), R.color.selected_color_new));
        TextView textView21 = this.proxyLabel;
        if (textView21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("proxyLabel");
            textView21 = null;
        }
        textView21.setVisibility(0);
        TextView textView22 = this.proxyLabel;
        if (textView22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("proxyLabel");
        } else {
            textView = textView22;
        }
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
    }

    /* JADX INFO: renamed from: getStatus, reason: from getter */
    public final CollectionStatus getCurrentStatus() {
        return this.currentStatus;
    }

    public final void setCustomIconText(String iconText, boolean useSolidFont) {
        Intrinsics.checkNotNullParameter(iconText, "iconText");
        TextView textView = this.mainIconLabel;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
            textView = null;
        }
        textView.setTypeface(useSolidFont ? getResources().getFont(R.font.fa6solid) : getResources().getFont(R.font.fa6regular));
        TextView textView3 = this.mainIconLabel;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
        } else {
            textView2 = textView3;
        }
        textView2.setText(iconText);
    }

    public final void setIconSize(float sizeInSp) {
        this.currentFontSize = sizeInSp;
        TextView textView = this.mainIconLabel;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainIconLabel");
            textView = null;
        }
        textView.setTextSize(sizeInSp);
        TextView textView3 = this.proxyLabel;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("proxyLabel");
        } else {
            textView2 = textView3;
        }
        textView2.setTextSize(sizeInSp * 0.66f);
    }

    public final void setStatus(CollectionStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.currentStatus = status;
        updateUI();
    }
}
