package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BracketHelpDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/BracketHelpDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "bulletPrefix", "", "onStart", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "bindSection1", "v", "bindSection2", "bindSection3", "bindSection4", "bindSection5", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BracketHelpDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private final String bulletPrefix = "• ";

    private final void bindSection1(View v) {
        ((TextView) v.findViewById(R.id.section1_bullet1)).setText(this.bulletPrefix + getString(R.string.bracket_help_1_bullet_1));
        ((TextView) v.findViewById(R.id.section1_bullet2)).setText(this.bulletPrefix + getString(R.string.bracket_help_1_bullet_2));
        ((TextView) v.findViewById(R.id.section1_bullet3)).setText(this.bulletPrefix + getString(R.string.bracket_help_1_bullet_3));
        ((TextView) v.findViewById(R.id.section1_bullet4)).setText(this.bulletPrefix + getString(R.string.bracket_help_1_bullet_4));
        ((TextView) v.findViewById(R.id.section1_footer)).setText(getString(R.string.bracket_help_1_footer));
    }

    private final void bindSection2(View v) {
        ((TextView) v.findViewById(R.id.section2_bullet1)).setText(this.bulletPrefix + getString(R.string.bracket_help_2_bullet_1));
        ((TextView) v.findViewById(R.id.section2_bullet2)).setText(this.bulletPrefix + getString(R.string.bracket_help_2_bullet_2));
        ((TextView) v.findViewById(R.id.section2_bullet3)).setText(this.bulletPrefix + getString(R.string.bracket_help_2_bullet_3));
        ((TextView) v.findViewById(R.id.section2_bullet4)).setText(this.bulletPrefix + getString(R.string.bracket_help_2_bullet_4));
        ((TextView) v.findViewById(R.id.section2_footer)).setText(getString(R.string.bracket_help_2_footer));
    }

    private final void bindSection3(View v) {
        ((TextView) v.findViewById(R.id.section3_bullet1)).setText(this.bulletPrefix + getString(R.string.bracket_help_3_bullet_1));
        ((TextView) v.findViewById(R.id.section3_bullet2)).setText(this.bulletPrefix + getString(R.string.bracket_help_3_bullet_2));
        ((TextView) v.findViewById(R.id.section3_bullet3)).setText(this.bulletPrefix + getString(R.string.bracket_help_3_bullet_3));
        ((TextView) v.findViewById(R.id.section3_bullet4)).setText(this.bulletPrefix + getString(R.string.bracket_help_3_bullet_4));
        ((TextView) v.findViewById(R.id.section3_footer)).setText(getString(R.string.bracket_help_3_footer));
    }

    private final void bindSection4(View v) {
        ((TextView) v.findViewById(R.id.section4_bullet1)).setText(this.bulletPrefix + getString(R.string.bracket_help_4_bullet_1));
        ((TextView) v.findViewById(R.id.section4_bullet2)).setText(this.bulletPrefix + getString(R.string.bracket_help_4_bullet_2));
        ((TextView) v.findViewById(R.id.section4_bullet3)).setText(this.bulletPrefix + getString(R.string.bracket_help_4_bullet_3));
        ((TextView) v.findViewById(R.id.section4_bullet4)).setText(this.bulletPrefix + getString(R.string.bracket_help_4_bullet_4));
        ((TextView) v.findViewById(R.id.section4_bullet5)).setText(this.bulletPrefix + getString(R.string.bracket_help_4_bullet_5));
        ((TextView) v.findViewById(R.id.section4_footer)).setText(getString(R.string.bracket_help_4_footer));
    }

    private final void bindSection5(View v) {
        ((TextView) v.findViewById(R.id.section5_bullet1)).setText(this.bulletPrefix + getString(R.string.bracket_help_5_bullet_1));
        ((TextView) v.findViewById(R.id.section5_bullet2)).setText(this.bulletPrefix + getString(R.string.bracket_help_5_bullet_2));
        ((TextView) v.findViewById(R.id.section5_bullet3)).setText(this.bulletPrefix + getString(R.string.bracket_help_5_bullet_3));
        ((TextView) v.findViewById(R.id.section5_footer)).setText(getString(R.string.bracket_help_5_footer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$0(int i, Ref.IntRef intRef, List list, List list2, ScrollView scrollView, View view, int i2) {
        onCreateView$setExpanded(intRef, list, list2, scrollView, view, i2, i);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$3(BracketHelpDialogFragment bracketHelpDialogFragment) {
        bracketHelpDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    private static final void onCreateView$setExpanded(Ref.IntRef intRef, List<? extends LinearLayout> list, List<? extends ImageView> list2, final ScrollView scrollView, final View view, final int i, int i2) {
        if (intRef.element != i2) {
            if (intRef.element >= 0) {
                list.get(intRef.element).setVisibility(8);
                list2.get(intRef.element).setRotation(0.0f);
            }
            list.get(i2).setVisibility(0);
            list2.get(i2).setRotation(180.0f);
            intRef.element = i2;
            scrollView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.BracketHelpDialogFragment$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    BracketHelpDialogFragment.onCreateView$setExpanded$lambda$1(view, scrollView, i);
                }
            });
            return;
        }
        list.get(i2).setVisibility(8);
        list2.get(i2).setRotation(0.0f);
        intRef.element = -1;
        ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -2;
        } else {
            layoutParams = null;
        }
        scrollView.setLayoutParams(layoutParams);
    }

    static final void onCreateView$setExpanded$lambda$1(View view, ScrollView scrollView, int i) {
        view.measure(View.MeasureSpec.makeMeasureSpec(scrollView.getWidth(), 1073741824), 0);
        int measuredHeight = view.getMeasuredHeight();
        ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = RangesKt.coerceAtMost(measuredHeight, i);
        } else {
            layoutParams = null;
        }
        scrollView.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_bracket_help, container, false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        setCancelable(true);
        Intrinsics.checkNotNull(viewInflate);
        bindSection1(viewInflate);
        bindSection2(viewInflate);
        bindSection3(viewInflate);
        bindSection4(viewInflate);
        bindSection5(viewInflate);
        List listListOf = CollectionsKt.listOf((Object[]) new LinearLayout[]{viewInflate.findViewById(R.id.section1_header), viewInflate.findViewById(R.id.section2_header), viewInflate.findViewById(R.id.section3_header), viewInflate.findViewById(R.id.section4_header), viewInflate.findViewById(R.id.section5_header)});
        final List listListOf2 = CollectionsKt.listOf((Object[]) new LinearLayout[]{viewInflate.findViewById(R.id.section1_content), viewInflate.findViewById(R.id.section2_content), viewInflate.findViewById(R.id.section3_content), viewInflate.findViewById(R.id.section4_content), viewInflate.findViewById(R.id.section5_content)});
        final List listListOf3 = CollectionsKt.listOf((Object[]) new ImageView[]{viewInflate.findViewById(R.id.section1_chevron), viewInflate.findViewById(R.id.section2_chevron), viewInflate.findViewById(R.id.section3_chevron), viewInflate.findViewById(R.id.section4_chevron), viewInflate.findViewById(R.id.section5_chevron)});
        final ScrollView scrollView = (ScrollView) viewInflate.findViewById(R.id.scroll_view);
        final View childAt = scrollView.getChildAt(0);
        final int i = (int) (((double) getResources().getDisplayMetrics().heightPixels) * 0.75d);
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final int i2 = 0;
        for (Object obj : listListOf) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LinearLayout linearLayout = (LinearLayout) obj;
            Intrinsics.checkNotNull(linearLayout);
            ViewExtensionsKt.setOnClickWithFade(linearLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.BracketHelpDialogFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BracketHelpDialogFragment.onCreateView$lambda$2$0(i2, intRef, listListOf2, listListOf3, scrollView, childAt, i);
                }
            });
            i2 = i3;
        }
        View viewFindViewById = viewInflate.findViewById(R.id.close_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.BracketHelpDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BracketHelpDialogFragment.onCreateView$lambda$3(this.f$0);
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setDimAmount(0.95f);
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.95d), (int) (((double) getResources().getDisplayMetrics().heightPixels) * 0.85d));
    }
}
