package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.studiolaganne.lengendarylens.PromoQRDialogFragment;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromoQRDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u000f\b\u0007\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\r2\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0017¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0016J\u001a\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006+"}, d2 = {"Lcom/studiolaganne/lengendarylens/PromoQRDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "qrDetectedListener", "Lkotlin/Function1;", "", "", "dismissListener", "Lkotlin/Function0;", "barcodeView", "Lcom/journeyapps/barcodescanner/DecoratedBarcodeView;", "cameraPermissionRequestCode", "", "qrCallback", "com/studiolaganne/lengendarylens/PromoQRDialogFragment$qrCallback$1", "Lcom/studiolaganne/lengendarylens/PromoQRDialogFragment$qrCallback$1;", "onRequestPermissionsResult", "requestCode", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onPause", "startQRCodeScanner", "restartQRCodeScanner", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PromoQRDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private DecoratedBarcodeView barcodeView;
    private Function0<Unit> dismissListener;
    private Function1<? super String, Unit> qrDetectedListener;
    private final int cameraPermissionRequestCode = 100;
    private final PromoQRDialogFragment$qrCallback$1 qrCallback = new BarcodeCallback() { // from class: com.studiolaganne.lengendarylens.PromoQRDialogFragment$qrCallback$1
        @Override // com.journeyapps.barcodescanner.BarcodeCallback
        public void barcodeResult(BarcodeResult result) {
            if (result != null) {
                PromoQRDialogFragment promoQRDialogFragment = this.this$0;
                String text = result.getText();
                Log.d("QRScan", "Scanned content: " + text);
                Intrinsics.checkNotNull(text);
                if (text.length() <= 0) {
                    Log.d("QRScan", "Scanned content is empty");
                    return;
                }
                Function1 function1 = promoQRDialogFragment.qrDetectedListener;
                if (function1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qrDetectedListener");
                    function1 = null;
                }
                function1.invoke(text);
                promoQRDialogFragment.dismiss();
            }
        }

        @Override // com.journeyapps.barcodescanner.BarcodeCallback
        public void possibleResultPoints(List<? extends ResultPoint> resultPoints) {
            Intrinsics.checkNotNullParameter(resultPoints, "resultPoints");
        }
    };

    /* JADX INFO: compiled from: PromoQRDialogFragment.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005J\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\tJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/PromoQRDialogFragment$Builder;", "", "<init>", "()V", "qrDetectedListener", "Lkotlin/Function1;", "", "", "onDismiss", "Lkotlin/Function0;", "rotationAngle", "", "setOnQRDetectedListener", "callback", "setOnDismissListener", "build", "Lcom/studiolaganne/lengendarylens/PromoQRDialogFragment;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private float rotationAngle;
        private Function1<? super String, Unit> qrDetectedListener = new Function1() { // from class: com.studiolaganne.lengendarylens.PromoQRDialogFragment$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PromoQRDialogFragment.Builder.qrDetectedListener$lambda$0((String) obj);
            }
        };
        private Function0<Unit> onDismiss = new Function0() { // from class: com.studiolaganne.lengendarylens.PromoQRDialogFragment$Builder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };

        static final Unit qrDetectedListener$lambda$0(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        public final PromoQRDialogFragment build() {
            PromoQRDialogFragment promoQRDialogFragment = new PromoQRDialogFragment();
            promoQRDialogFragment.qrDetectedListener = this.qrDetectedListener;
            promoQRDialogFragment.dismissListener = this.onDismiss;
            return promoQRDialogFragment;
        }

        public final Builder setOnDismissListener(Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.onDismiss = callback;
            return this;
        }

        public final Builder setOnQRDetectedListener(Function1<? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.qrDetectedListener = callback;
            return this;
        }

        public final boolean show(FragmentManager manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            return FragmentExtensionsKt.showSafely(build(), manager, "PromoQRDialogFragment");
        }
    }

    static final void onCreateView$lambda$0(PromoQRDialogFragment promoQRDialogFragment) {
        try {
            DecoratedBarcodeView decoratedBarcodeView = promoQRDialogFragment.barcodeView;
            if (decoratedBarcodeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
                decoratedBarcodeView = null;
            }
            Field declaredField = decoratedBarcodeView.getClass().getDeclaredField("statusView");
            declaredField.setAccessible(true);
            DecoratedBarcodeView decoratedBarcodeView2 = promoQRDialogFragment.barcodeView;
            if (decoratedBarcodeView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
                decoratedBarcodeView2 = null;
            }
            Object obj = declaredField.get(decoratedBarcodeView2);
            TextView textView = obj instanceof TextView ? (TextView) obj : null;
            if (textView != null) {
                textView.setVisibility(8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static final Unit onViewCreated$lambda$0(PromoQRDialogFragment promoQRDialogFragment) {
        promoQRDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restartQRCodeScanner() {
        DecoratedBarcodeView decoratedBarcodeView = this.barcodeView;
        if (decoratedBarcodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
            decoratedBarcodeView = null;
        }
        decoratedBarcodeView.pause();
        startQRCodeScanner();
    }

    private final void startQRCodeScanner() {
        DecoratedBarcodeView decoratedBarcodeView = this.barcodeView;
        DecoratedBarcodeView decoratedBarcodeView2 = null;
        if (decoratedBarcodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
            decoratedBarcodeView = null;
        }
        decoratedBarcodeView.resume();
        DecoratedBarcodeView decoratedBarcodeView3 = this.barcodeView;
        if (decoratedBarcodeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
        } else {
            decoratedBarcodeView2 = decoratedBarcodeView3;
        }
        decoratedBarcodeView2.decodeContinuous(this.qrCallback);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        View viewInflate = inflater.inflate(R.layout.dialog_promo_qr, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.barcode_scanner);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        DecoratedBarcodeView decoratedBarcodeView = (DecoratedBarcodeView) viewFindViewById;
        this.barcodeView = decoratedBarcodeView;
        if (decoratedBarcodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
            decoratedBarcodeView = null;
        }
        decoratedBarcodeView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.studiolaganne.lengendarylens.PromoQRDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                PromoQRDialogFragment.onCreateView$lambda$0(this.f$0);
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

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        DecoratedBarcodeView decoratedBarcodeView = this.barcodeView;
        if (decoratedBarcodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
            decoratedBarcodeView = null;
        }
        decoratedBarcodeView.pause();
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == this.cameraPermissionRequestCode) {
            if ((grantResults.length == 0) || grantResults[0] != 0) {
                return;
            }
            DecoratedBarcodeView decoratedBarcodeView = this.barcodeView;
            if (decoratedBarcodeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
                decoratedBarcodeView = null;
            }
            decoratedBarcodeView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.PromoQRDialogFragment$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.restartQRCodeScanner();
                }
            }, 100L);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DecoratedBarcodeView decoratedBarcodeView = this.barcodeView;
        if (decoratedBarcodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
            decoratedBarcodeView = null;
        }
        decoratedBarcodeView.resume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setDimAmount(0.9f);
            window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.95d), -2);
        }
        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.CAMERA") != 0) {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.CAMERA"}, this.cameraPermissionRequestCode);
        } else {
            startQRCodeScanner();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.cancelButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.PromoQRDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PromoQRDialogFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
    }
}
