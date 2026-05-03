package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerSelectFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlayerSelectFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "positiveButtonListener", "Lkotlin/Function1;", "", "negativeButtonListener", "onDismiss", "", "skin", "Lcom/studiolaganne/lengendarylens/PlayerToss;", "internalRotation", "", "fragmentView", "Landroid/view/View;", "handler", "Landroid/os/Handler;", "skipped", "dpToPx", "dp", "context", "Landroid/content/Context;", "onStart", "dialog", "Landroid/content/DialogInterface;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlayerSelectFragment extends DialogFragment {
    public static final int $stable = 8;
    private View fragmentView;
    private int internalRotation;
    private Function1<? super PlayerSelectFragment, Unit> negativeButtonListener;
    private Function1<? super Boolean, Unit> onDismiss;
    private Function1<? super PlayerSelectFragment, Unit> positiveButtonListener;
    private PlayerToss skin;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private boolean skipped = true;

    /* JADX INFO: compiled from: PlayerSelectFragment.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\t\u001a\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bJ\u001a\u0010\r\u001a\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bJ\u001a\u0010\u000e\u001a\u00020\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u000bJ\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlayerSelectFragment$Builder;", "", "<init>", "()V", "dialogFragment", "Lcom/studiolaganne/lengendarylens/PlayerSelectFragment;", "setPlayerTossSkin", "skin", "Lcom/studiolaganne/lengendarylens/PlayerToss;", "setPositiveButton", "onClick", "Lkotlin/Function1;", "", "setNegativeButton", "setOnDismissListener", "onDismiss", "", "show", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "setFragmentView", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "setRotation", Key.ROTATION, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final PlayerSelectFragment dialogFragment = new PlayerSelectFragment();

        public final Builder setFragmentView(View view) {
            this.dialogFragment.fragmentView = view;
            return this;
        }

        public final Builder setNegativeButton(Function1<? super PlayerSelectFragment, Unit> onClick) {
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.dialogFragment.negativeButtonListener = onClick;
            return this;
        }

        public final Builder setOnDismissListener(Function1<? super Boolean, Unit> onDismiss) {
            Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
            this.dialogFragment.onDismiss = onDismiss;
            return this;
        }

        public final Builder setPlayerTossSkin(PlayerToss skin) {
            this.dialogFragment.skin = skin;
            return this;
        }

        public final Builder setPositiveButton(Function1<? super PlayerSelectFragment, Unit> onClick) {
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.dialogFragment.positiveButtonListener = onClick;
            return this;
        }

        public final Builder setRotation(int rotation) {
            this.dialogFragment.internalRotation = rotation;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(this.dialogFragment, manager, tag);
        }
    }

    static final Unit onCreateView$lambda$4(PlayerSelectFragment playerSelectFragment) {
        playerSelectFragment.skipped = false;
        Function1<? super PlayerSelectFragment, Unit> function1 = playerSelectFragment.positiveButtonListener;
        if (function1 != null) {
            function1.invoke(playerSelectFragment);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$5(PlayerSelectFragment playerSelectFragment) {
        playerSelectFragment.skipped = true;
        Function1<? super PlayerSelectFragment, Unit> function1 = playerSelectFragment.negativeButtonListener;
        if (function1 != null) {
            function1.invoke(playerSelectFragment);
        }
        return Unit.INSTANCE;
    }

    static final void onViewCreated$lambda$0(PlayerSelectFragment playerSelectFragment, ConstraintLayout constraintLayout, View view, TextView textView, ImageView imageView) {
        PlayerToss playerToss = playerSelectFragment.skin;
        if (playerToss != null) {
            String backgroundColor = playerToss.getBackgroundColor();
            MessageData enMessage = null;
            if (backgroundColor != null && backgroundColor.length() > 0) {
                int colorFromHex = SkinManager.INSTANCE.getInstance().getColorFromHex(backgroundColor);
                Drawable background = constraintLayout.getBackground();
                GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(colorFromHex);
                }
            }
            String borderColor = playerToss.getBorderColor();
            if (borderColor != null && borderColor.length() > 0) {
                int colorFromHex2 = SkinManager.INSTANCE.getInstance().getColorFromHex(borderColor);
                Drawable background2 = constraintLayout.getBackground();
                GradientDrawable gradientDrawable2 = background2 instanceof GradientDrawable ? (GradientDrawable) background2 : null;
                if (gradientDrawable2 != null) {
                    Context context = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    gradientDrawable2.setStroke(playerSelectFragment.dpToPx(3, context), colorFromHex2);
                }
            }
            Context contextRequireContext = playerSelectFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            boolean zAreEqual = Intrinsics.areEqual(new PreferencesManager(contextRequireContext).getDeviceLanguage(), "fr");
            PlayerToss playerToss2 = playerSelectFragment.skin;
            if (zAreEqual) {
                if (playerToss2 != null) {
                    enMessage = playerToss2.getFrMessage();
                }
            } else if (playerToss2 != null) {
                enMessage = playerToss2.getEnMessage();
            }
            if (enMessage != null) {
                textView.setText(enMessage.getText());
                String color = enMessage.getColor();
                if (color != null && color.length() > 0) {
                    textView.setTextColor(SkinManager.INSTANCE.getInstance().getColorFromHex(color));
                }
                imageView.setVisibility(8);
                textView.requestLayout();
                imageView.requestLayout();
                constraintLayout.requestLayout();
            }
        }
    }

    public final int dpToPx(int dp, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_player_select, container, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.root_layout);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewInflate.findViewById(R.id.skip_layout);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.close_image);
        constraintLayout.setRotation(this.internalRotation);
        constraintLayout2.setRotation(this.internalRotation);
        imageView.setRotation(45.0f);
        if (this.positiveButtonListener != null) {
            constraintLayout.setVisibility(0);
        } else {
            constraintLayout.setVisibility(4);
        }
        if (this.negativeButtonListener != null) {
            constraintLayout2.setVisibility(0);
        } else {
            constraintLayout2.setVisibility(4);
        }
        View viewFindViewById = viewInflate.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.PlayerSelectFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlayerSelectFragment.onCreateView$lambda$4(this.f$0);
            }
        });
        View viewFindViewById2 = viewInflate.findViewById(R.id.skip_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.PlayerSelectFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlayerSelectFragment.onCreateView$lambda$5(this.f$0);
            }
        });
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        int i = this.internalRotation;
        if (i == 90) {
            ViewGroup.LayoutParams layoutParams = constraintLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.startToStart = 0;
            layoutParams2.endToEnd = -1;
            layoutParams2.topToTop = 0;
            layoutParams2.bottomToBottom = 0;
            constraintLayout2.setLayoutParams(layoutParams2);
            return viewInflate;
        }
        if (i != 270) {
            return viewInflate;
        }
        ViewGroup.LayoutParams layoutParams3 = constraintLayout2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        layoutParams4.startToStart = -1;
        layoutParams4.endToEnd = 0;
        layoutParams4.topToTop = 0;
        layoutParams4.bottomToBottom = 0;
        constraintLayout2.setLayoutParams(layoutParams4);
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function1<? super Boolean, Unit> function1 = this.onDismiss;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(this.skipped));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        int i = (int) (((double) getResources().getDisplayMetrics().widthPixels) * 1.0d);
        window.setLayout(i, i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.root_layout);
        final TextView textView = (TextView) view.findViewById(R.id.main_text);
        final ImageView imageView = (ImageView) view.findViewById(R.id.dice_image);
        view.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlayerSelectFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PlayerSelectFragment.onViewCreated$lambda$0(this.f$0, constraintLayout, view, textView, imageView);
            }
        });
    }
}
