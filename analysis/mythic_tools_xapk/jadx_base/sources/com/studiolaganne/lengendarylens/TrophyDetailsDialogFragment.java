package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrophyDetailsDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0006H\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/TrophyDetailsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "dismissListener", "Lkotlin/Function0;", "", "trophies", "", "Lcom/studiolaganne/lengendarylens/MTTrophy;", "currentIndex", "", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "updateUI", "trophy", ViewHierarchyConstants.VIEW_KEY, "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TrophyDetailsDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private int currentIndex;
    private Function0<Unit> dismissListener;
    private List<MTTrophy> trophies = CollectionsKt.emptyList();

    /* JADX INFO: compiled from: TrophyDetailsDialogFragment.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\f\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/TrophyDetailsDialogFragment$Builder;", "", "<init>", "()V", "onDismiss", "Lkotlin/Function0;", "", "trophies", "", "Lcom/studiolaganne/lengendarylens/MTTrophy;", "currentIndex", "", "setOnDismissListener", "callback", "setTrophies", "setCurrentIndex", FirebaseAnalytics.Param.INDEX, "build", "Lcom/studiolaganne/lengendarylens/TrophyDetailsDialogFragment;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private int currentIndex;
        private Function0<Unit> onDismiss = new Function0() { // from class: com.studiolaganne.lengendarylens.TrophyDetailsDialogFragment$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };
        private List<MTTrophy> trophies = CollectionsKt.emptyList();

        public final TrophyDetailsDialogFragment build() {
            TrophyDetailsDialogFragment trophyDetailsDialogFragment = new TrophyDetailsDialogFragment();
            trophyDetailsDialogFragment.dismissListener = this.onDismiss;
            trophyDetailsDialogFragment.trophies = this.trophies;
            trophyDetailsDialogFragment.currentIndex = this.currentIndex;
            return trophyDetailsDialogFragment;
        }

        public final Builder setCurrentIndex(int index) {
            this.currentIndex = index;
            return this;
        }

        public final Builder setOnDismissListener(Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.onDismiss = callback;
            return this;
        }

        public final Builder setTrophies(List<MTTrophy> trophies) {
            Intrinsics.checkNotNullParameter(trophies, "trophies");
            this.trophies = trophies;
            return this;
        }

        public final boolean show(FragmentManager manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            return FragmentExtensionsKt.showSafely(build(), manager, "TrophyDetailsDialogFragment");
        }
    }

    static final Unit onCreateView$lambda$0(TrophyDetailsDialogFragment trophyDetailsDialogFragment) {
        trophyDetailsDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final boolean onCreateView$lambda$1(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUI(MTTrophy trophy, View view) {
        String name;
        String description;
        if (getContext() == null || view == null || trophy == null) {
            return;
        }
        View viewFindViewById = view.findViewById(R.id.trophyName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById;
        textView.setText(trophy.getName());
        View viewFindViewById2 = view.findViewById(R.id.trophyDescription);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById2;
        textView2.setText(trophy.getDescription());
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String deviceLanguage = new PreferencesManager(contextRequireContext).getDeviceLanguage();
        MTTrophyLocalization localization = trophy.getLocalization();
        if (localization != null && Intrinsics.areEqual(deviceLanguage, "fr")) {
            MTTrophyData fr = localization.getFr();
            if (fr == null || (name = fr.getName()) == null) {
                name = trophy.getName();
            }
            textView.setText(name);
            MTTrophyData fr2 = localization.getFr();
            if (fr2 == null || (description = fr2.getDescription()) == null) {
                description = trophy.getDescription();
            }
            textView2.setText(description);
        }
        View viewFindViewById3 = view.findViewById(R.id.trophyImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById3;
        RequestManager requestManagerWith = Glide.with(this);
        String image_url = trophy.getImage_url();
        if (image_url == null) {
            image_url = "";
        }
        requestManagerWith.load(image_url).placeholder(R.drawable.medal_outline).error(R.drawable.medal_outline).into(imageView);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.backImage);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.forwardImage);
        imageView2.setVisibility(8);
        imageView3.setVisibility(8);
        if (this.currentIndex > 0) {
            imageView2.setVisibility(0);
            Intrinsics.checkNotNull(imageView2);
            ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.TrophyDetailsDialogFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TrophyDetailsDialogFragment.updateUI$lambda$0$0$1(this.f$0);
                }
            });
        }
        if (this.currentIndex < this.trophies.size() - 1) {
            imageView3.setVisibility(0);
            Intrinsics.checkNotNull(imageView3);
            ViewExtensionsKt.setOnClickWithFade(imageView3, new Function0() { // from class: com.studiolaganne.lengendarylens.TrophyDetailsDialogFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TrophyDetailsDialogFragment.updateUI$lambda$0$0$2(this.f$0);
                }
            });
        }
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.stepUpProgressBar);
        TextView textView3 = (TextView) view.findViewById(R.id.stepUpDescription);
        Integer next_level_value = trophy.getNext_level_value();
        if (next_level_value == null) {
            progressBar.setVisibility(8);
            textView3.setVisibility(8);
            return;
        }
        int iIntValue = next_level_value.intValue();
        progressBar.setVisibility(0);
        textView3.setVisibility(0);
        Integer current_value = trophy.getCurrent_value();
        int iIntValue2 = current_value != null ? current_value.intValue() : 0;
        progressBar.setMax(iIntValue);
        progressBar.setProgress(iIntValue2);
        textView3.setText(getResources().getString(R.string.step_up_description) + " " + iIntValue2 + DomExceptionUtils.SEPARATOR + iIntValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUI$lambda$0$0$1(TrophyDetailsDialogFragment trophyDetailsDialogFragment) {
        int i = trophyDetailsDialogFragment.currentIndex - 1;
        trophyDetailsDialogFragment.currentIndex = i;
        trophyDetailsDialogFragment.updateUI((MTTrophy) CollectionsKt.getOrNull(trophyDetailsDialogFragment.trophies, i), trophyDetailsDialogFragment.getView());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUI$lambda$0$0$2(TrophyDetailsDialogFragment trophyDetailsDialogFragment) {
        int i = trophyDetailsDialogFragment.currentIndex + 1;
        trophyDetailsDialogFragment.currentIndex = i;
        trophyDetailsDialogFragment.updateUI((MTTrophy) CollectionsKt.getOrNull(trophyDetailsDialogFragment.trophies, i), trophyDetailsDialogFragment.getView());
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        if (this.trophies.isEmpty()) {
            Log.e("TrophyDetailsDialogFragment", "No trophies available to display.");
            return null;
        }
        final View viewInflate = inflater.inflate(R.layout.dialog_trophy_details, container, false);
        updateUI((MTTrophy) CollectionsKt.getOrNull(this.trophies, this.currentIndex), viewInflate);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.closeImage);
        Intrinsics.checkNotNull(imageView);
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.TrophyDetailsDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TrophyDetailsDialogFragment.onCreateView$lambda$0(this.f$0);
            }
        });
        View viewFindViewById = viewInflate.findViewById(R.id.trophyImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.studiolaganne.lengendarylens.TrophyDetailsDialogFragment$onCreateView$gestureDetector$1
            private final int SWIPE_THRESHOLD = 100;
            private final int SWIPE_VELOCITY_THRESHOLD = 100;

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Intrinsics.checkNotNullParameter(e2, "e2");
                if (e1 == null) {
                    return false;
                }
                float x = e2.getX() - e1.getX();
                if (Math.abs(x) <= Math.abs(e2.getY() - e1.getY()) || Math.abs(x) <= this.SWIPE_THRESHOLD || Math.abs(velocityX) <= this.SWIPE_VELOCITY_THRESHOLD) {
                    return false;
                }
                TrophyDetailsDialogFragment trophyDetailsDialogFragment = this.this$0;
                if (x > 0.0f) {
                    if (trophyDetailsDialogFragment.currentIndex > 0) {
                        this.this$0.currentIndex--;
                        TrophyDetailsDialogFragment trophyDetailsDialogFragment2 = this.this$0;
                        trophyDetailsDialogFragment2.updateUI((MTTrophy) CollectionsKt.getOrNull(trophyDetailsDialogFragment2.trophies, this.this$0.currentIndex), viewInflate);
                    }
                } else if (trophyDetailsDialogFragment.currentIndex < this.this$0.trophies.size() - 1) {
                    this.this$0.currentIndex++;
                    TrophyDetailsDialogFragment trophyDetailsDialogFragment3 = this.this$0;
                    trophyDetailsDialogFragment3.updateUI((MTTrophy) CollectionsKt.getOrNull(trophyDetailsDialogFragment3.trophies, this.this$0.currentIndex), viewInflate);
                }
                return true;
            }
        });
        ((ImageView) viewFindViewById).setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.TrophyDetailsDialogFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return TrophyDetailsDialogFragment.onCreateView$lambda$1(gestureDetector, view, motionEvent);
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.dismissListener;
        if (function0 != null) {
            function0.invoke();
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
        window.setDimAmount(0.9f);
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }
}
