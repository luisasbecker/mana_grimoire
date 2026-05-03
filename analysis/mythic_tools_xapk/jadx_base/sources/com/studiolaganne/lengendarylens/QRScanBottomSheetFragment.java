package com.studiolaganne.lengendarylens;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.DefaultDecoderFactory;
import com.studiolaganne.lengendarylens.QrCodeFragment;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: QRScanBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001$\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\"2\u000e\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140*2\u0006\u0010+\u001a\u00020,H\u0017¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020'H\u0016J\b\u0010/\u001a\u00020'H\u0016J\b\u00100\u001a\u00020'H\u0002J\b\u00101\u001a\u00020'H\u0002J\u0012\u00102\u001a\u00020'2\b\u00103\u001a\u0004\u0018\u000104H\u0016J&\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u0014H\u0002J\u001a\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u0002062\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0006\u0010?\u001a\u00020'R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006A"}, d2 = {"Lcom/studiolaganne/lengendarylens/QRScanBottomSheetFragment;", "Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "<init>", "()V", "callback", "Lcom/studiolaganne/lengendarylens/QRScanCallback;", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "gameMode", "", "friendCodeMode", "qrScanned", "getQrScanned", "()Z", "setQrScanned", "(Z)V", "qrCodeOK", "getQrCodeOK", "setQrCodeOK", "qrCodeBase64", "", "getQrCodeBase64", "()Ljava/lang/String;", "setQrCodeBase64", "(Ljava/lang/String;)V", "friendCode", "getFriendCode", "setFriendCode", "showingQR", "getShowingQR", "setShowingQR", "barcodeView", "Lcom/journeyapps/barcodescanner/DecoratedBarcodeView;", "cameraPermissionRequestCode", "", "qrCallback", "com/studiolaganne/lengendarylens/QRScanBottomSheetFragment$qrCallback$1", "Lcom/studiolaganne/lengendarylens/QRScanBottomSheetFragment$qrCallback$1;", "onRequestPermissionsResult", "", "requestCode", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onPause", "startQRCodeScanner", "restartQRCodeScanner", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "formatCode", "code", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "closeQRDialog", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class QRScanBottomSheetFragment extends TransparentBottomSheet {
    private static final String ARG_USER_JSON = "user_json";
    public static final String TAG = "QRScanBottomSheetFragment";
    private DecoratedBarcodeView barcodeView;
    private QRScanCallback callback;
    private boolean friendCodeMode;
    private boolean gameMode;
    private boolean qrCodeOK;
    private boolean qrScanned;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private MTUser user = new MTUser(false, 0, null, null, null, null, null, null, null, null, 1023, null);
    private String qrCodeBase64 = "";
    private String friendCode = "";
    private boolean showingQR = true;
    private final int cameraPermissionRequestCode = 100;
    private final QRScanBottomSheetFragment$qrCallback$1 qrCallback = new BarcodeCallback() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment$qrCallback$1
        @Override // com.journeyapps.barcodescanner.BarcodeCallback
        public void barcodeResult(BarcodeResult result) {
            if (result != null) {
                QRScanBottomSheetFragment qRScanBottomSheetFragment = this.this$0;
                String text = result.getText();
                Log.d("QRScan", "Scanned content: " + text);
                Intrinsics.checkNotNull(text);
                if (text.length() > 0) {
                    if (!qRScanBottomSheetFragment.getQrScanned()) {
                        qRScanBottomSheetFragment.setQrScanned(true);
                        QRScanCallback qRScanCallback = qRScanBottomSheetFragment.callback;
                        if (qRScanCallback != null) {
                            qRScanCallback.onQRScanned(text);
                        }
                    }
                    qRScanBottomSheetFragment.dismiss();
                }
            }
        }

        @Override // com.journeyapps.barcodescanner.BarcodeCallback
        public void possibleResultPoints(List<? extends ResultPoint> resultPoints) {
            Intrinsics.checkNotNullParameter(resultPoints, "resultPoints");
        }
    };

    /* JADX INFO: compiled from: QRScanBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/QRScanBottomSheetFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_USER_JSON", "newInstance", "Lcom/studiolaganne/lengendarylens/QRScanBottomSheetFragment;", "callback", "Lcom/studiolaganne/lengendarylens/QRScanCallback;", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "gameMode", "", "newInstanceFriendCodeOnly", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ QRScanBottomSheetFragment newInstance$default(Companion companion, QRScanCallback qRScanCallback, MTUser mTUser, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.newInstance(qRScanCallback, mTUser, z);
        }

        public final QRScanBottomSheetFragment newInstance(QRScanCallback callback, MTUser user, boolean gameMode) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(user, "user");
            QRScanBottomSheetFragment qRScanBottomSheetFragment = new QRScanBottomSheetFragment();
            qRScanBottomSheetFragment.callback = callback;
            qRScanBottomSheetFragment.gameMode = gameMode;
            qRScanBottomSheetFragment.friendCodeMode = false;
            String json = new Gson().toJson(user);
            Bundle bundle = new Bundle();
            bundle.putString(QRScanBottomSheetFragment.ARG_USER_JSON, json);
            qRScanBottomSheetFragment.setArguments(bundle);
            return qRScanBottomSheetFragment;
        }

        public final QRScanBottomSheetFragment newInstanceFriendCodeOnly(QRScanCallback callback, MTUser user) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(user, "user");
            QRScanBottomSheetFragment qRScanBottomSheetFragment = new QRScanBottomSheetFragment();
            qRScanBottomSheetFragment.callback = callback;
            qRScanBottomSheetFragment.gameMode = false;
            qRScanBottomSheetFragment.friendCodeMode = true;
            String json = new Gson().toJson(user);
            Bundle bundle = new Bundle();
            bundle.putString(QRScanBottomSheetFragment.ARG_USER_JSON, json);
            qRScanBottomSheetFragment.setArguments(bundle);
            return qRScanBottomSheetFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatCode(String code) {
        if (code.length() != 6) {
            return code;
        }
        String strSubstring = code.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = code.substring(2, 4);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        String strSubstring3 = code.substring(4, 6);
        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
        return strSubstring + " " + strSubstring2 + " " + strSubstring3;
    }

    static final Unit onCreateView$lambda$0(final QRScanBottomSheetFragment qRScanBottomSheetFragment) {
        String username;
        if (qRScanBottomSheetFragment.qrCodeOK) {
            if (qRScanBottomSheetFragment.getActivity() == null) {
                return Unit.INSTANCE;
            }
            DecoratedBarcodeView decoratedBarcodeView = qRScanBottomSheetFragment.barcodeView;
            if (decoratedBarcodeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
                decoratedBarcodeView = null;
            }
            decoratedBarcodeView.pause();
            QrCodeFragment.Builder qrCodeBase64 = new QrCodeFragment.Builder().setQrCodeBase64(qRScanBottomSheetFragment.qrCodeBase64);
            MTUser mTUser = qRScanBottomSheetFragment.user;
            if (mTUser == null || (username = mTUser.getUsername()) == null) {
                username = "";
            }
            QrCodeFragment.Builder onDismissListener = qrCodeBase64.setUserName(username).setOnDismissListener(new Function0() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return QRScanBottomSheetFragment.onCreateView$lambda$0$0(this.f$0);
                }
            });
            FragmentManager supportFragmentManager = qRScanBottomSheetFragment.requireActivity().getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            onDismissListener.show(supportFragmentManager, "QrCodeFragment");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(QRScanBottomSheetFragment qRScanBottomSheetFragment) {
        DecoratedBarcodeView decoratedBarcodeView = qRScanBottomSheetFragment.barcodeView;
        if (decoratedBarcodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
            decoratedBarcodeView = null;
        }
        decoratedBarcodeView.resume();
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$1(QRScanBottomSheetFragment qRScanBottomSheetFragment) {
        try {
            DecoratedBarcodeView decoratedBarcodeView = qRScanBottomSheetFragment.barcodeView;
            if (decoratedBarcodeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
                decoratedBarcodeView = null;
            }
            Field declaredField = decoratedBarcodeView.getClass().getDeclaredField("statusView");
            declaredField.setAccessible(true);
            DecoratedBarcodeView decoratedBarcodeView2 = qRScanBottomSheetFragment.barcodeView;
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

    static final Unit onViewCreated$lambda$0(QRScanBottomSheetFragment qRScanBottomSheetFragment) {
        QRScanCallback qRScanCallback = qRScanBottomSheetFragment.callback;
        if (qRScanCallback != null) {
            qRScanCallback.onQRClosed();
        }
        return Unit.INSTANCE;
    }

    static final void onViewCreated$lambda$1(QRScanBottomSheetFragment qRScanBottomSheetFragment, View view, View view2) {
        if (qRScanBottomSheetFragment.showingQR) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.qrMainLayout);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.friendMainLayout);
        linearLayout.setVisibility(0);
        linearLayout2.setVisibility(8);
        View viewFindViewById = view.findViewById(R.id.qrTabSelectedView);
        View viewFindViewById2 = view.findViewById(R.id.friendTabSelectedView);
        viewFindViewById.setVisibility(0);
        viewFindViewById2.setVisibility(4);
        ImageView imageView = (ImageView) view.findViewById(R.id.qrCodeTabIcon);
        TextView textView = (TextView) view.findViewById(R.id.qrCodeTabText);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.friendCodeTabIcon);
        TextView textView2 = (TextView) view.findViewById(R.id.friendCodeTabText);
        imageView.setAlpha(1.0f);
        textView.setAlpha(1.0f);
        imageView2.setAlpha(0.5f);
        textView2.setAlpha(0.75f);
        DecoratedBarcodeView decoratedBarcodeView = qRScanBottomSheetFragment.barcodeView;
        if (decoratedBarcodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
            decoratedBarcodeView = null;
        }
        decoratedBarcodeView.resume();
        qRScanBottomSheetFragment.showingQR = true;
    }

    static final void onViewCreated$lambda$2(QRScanBottomSheetFragment qRScanBottomSheetFragment, View view, View view2) {
        if (qRScanBottomSheetFragment.showingQR) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(qRScanBottomSheetFragment.requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            DecoratedBarcodeView decoratedBarcodeView = null;
            firebaseAnalytics.logEvent("friend_code_click_from_scan", null);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.qrMainLayout);
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.friendMainLayout);
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(0);
            View viewFindViewById = view.findViewById(R.id.qrTabSelectedView);
            View viewFindViewById2 = view.findViewById(R.id.friendTabSelectedView);
            viewFindViewById.setVisibility(4);
            viewFindViewById2.setVisibility(0);
            ImageView imageView = (ImageView) view.findViewById(R.id.qrCodeTabIcon);
            TextView textView = (TextView) view.findViewById(R.id.qrCodeTabText);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.friendCodeTabIcon);
            TextView textView2 = (TextView) view.findViewById(R.id.friendCodeTabText);
            imageView.setAlpha(0.5f);
            textView.setAlpha(0.75f);
            imageView2.setAlpha(1.0f);
            textView2.setAlpha(1.0f);
            DecoratedBarcodeView decoratedBarcodeView2 = qRScanBottomSheetFragment.barcodeView;
            if (decoratedBarcodeView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
            } else {
                decoratedBarcodeView = decoratedBarcodeView2;
            }
            decoratedBarcodeView.pause();
            qRScanBottomSheetFragment.showingQR = false;
        }
    }

    static final Unit onViewCreated$lambda$3(QRScanBottomSheetFragment qRScanBottomSheetFragment) {
        if (qRScanBottomSheetFragment.friendCode.length() == 0) {
            return Unit.INSTANCE;
        }
        Object systemService = qRScanBottomSheetFragment.requireContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Mythic code", qRScanBottomSheetFragment.friendCode));
        Toast.makeText(qRScanBottomSheetFragment.requireContext(), qRScanBottomSheetFragment.getResources().getString(R.string.code_copied), 0).show();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$4(EditText editText, QRScanBottomSheetFragment qRScanBottomSheetFragment) {
        String strReplace$default = StringsKt.replace$default(editText.getText().toString(), " ", "", false, 4, (Object) null);
        if (strReplace$default.length() != 6) {
            return Unit.INSTANCE;
        }
        String upperCase = strReplace$default.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        MTApiKt.getMtApi().userByCode(qRScanBottomSheetFragment.user.getId(), upperCase).enqueue(new QRScanBottomSheetFragment$onViewCreated$6$1(qRScanBottomSheetFragment));
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

    public final void closeQRDialog() {
        Fragment fragmentFindFragmentByTag;
        if (getActivity() == null || (fragmentFindFragmentByTag = requireActivity().getSupportFragmentManager().findFragmentByTag("QrCodeFragment")) == null) {
            return;
        }
        ((QrCodeFragment) fragmentFindFragmentByTag).dismiss();
    }

    public final String getFriendCode() {
        return this.friendCode;
    }

    public final String getQrCodeBase64() {
        return this.qrCodeBase64;
    }

    public final boolean getQrCodeOK() {
        return this.qrCodeOK;
    }

    public final boolean getQrScanned() {
        return this.qrScanned;
    }

    public final boolean getShowingQR() {
        return this.showingQR;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String string;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_USER_JSON)) == null) {
            this.user = new MTUser(false, 0, null, null, null, null, null, null, null, null, 1023, null);
            return;
        }
        Object objFromJson = new Gson().fromJson(string, (Class<Object>) MTUser.class);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        this.user = (MTUser) objFromJson;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_qr_code_scanner, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.barcode_scanner);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.barcodeView = (DecoratedBarcodeView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.qrCodeButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById2;
        DecoratedBarcodeView decoratedBarcodeView = null;
        if (this.friendCodeMode) {
            DecoratedBarcodeView decoratedBarcodeView2 = this.barcodeView;
            if (decoratedBarcodeView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
                decoratedBarcodeView2 = null;
            }
            decoratedBarcodeView2.setVisibility(8);
            View viewFindViewById3 = viewInflate.findViewById(R.id.tabsLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            ((LinearLayout) viewFindViewById3).setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.qrMainLayout);
            LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.friendMainLayout);
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(0);
            View viewFindViewById4 = viewInflate.findViewById(R.id.qrTabSelectedView);
            View viewFindViewById5 = viewInflate.findViewById(R.id.friendTabSelectedView);
            viewFindViewById4.setVisibility(4);
            viewFindViewById5.setVisibility(0);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.qrCodeTabIcon);
            TextView textView = (TextView) viewInflate.findViewById(R.id.qrCodeTabText);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.friendCodeTabIcon);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.friendCodeTabText);
            imageView.setAlpha(0.5f);
            textView.setAlpha(0.75f);
            imageView2.setAlpha(1.0f);
            textView2.setAlpha(1.0f);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(BarcodeFormat.QR_CODE);
            DecoratedBarcodeView decoratedBarcodeView3 = this.barcodeView;
            if (decoratedBarcodeView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
                decoratedBarcodeView3 = null;
            }
            decoratedBarcodeView3.getBarcodeView().setDecoderFactory(new DefaultDecoderFactory(arrayList));
            ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return QRScanBottomSheetFragment.onCreateView$lambda$0(this.f$0);
                }
            });
        }
        if (this.gameMode) {
            constraintLayout.setVisibility(8);
            View viewFindViewById6 = viewInflate.findViewById(R.id.tabsLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            ((LinearLayout) viewFindViewById6).setVisibility(8);
            View viewFindViewById7 = viewInflate.findViewById(R.id.helpText);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            ((TextView) viewFindViewById7).setText(getResources().getString(R.string.scan_qr_code_game));
        }
        DecoratedBarcodeView decoratedBarcodeView4 = this.barcodeView;
        if (decoratedBarcodeView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
        } else {
            decoratedBarcodeView = decoratedBarcodeView4;
        }
        decoratedBarcodeView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                QRScanBottomSheetFragment.onCreateView$lambda$1(this.f$0);
            }
        });
        if (!this.friendCodeMode) {
            if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.CAMERA") != 0) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.CAMERA"}, this.cameraPermissionRequestCode);
                return viewInflate;
            }
            startQRCodeScanner();
        }
        return viewInflate;
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
            decoratedBarcodeView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.restartQRCodeScanner();
                }
            }, 100L);
        }
    }

    @Override // com.studiolaganne.lengendarylens.TransparentBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DecoratedBarcodeView decoratedBarcodeView = this.barcodeView;
        if (decoratedBarcodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeView");
            decoratedBarcodeView = null;
        }
        decoratedBarcodeView.resume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.chevron_down);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return QRScanBottomSheetFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        ((ConstraintLayout) view.findViewById(R.id.qrCodeTab)).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QRScanBottomSheetFragment.onViewCreated$lambda$1(this.f$0, view, view2);
            }
        });
        ((ConstraintLayout) view.findViewById(R.id.friendCodeTab)).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QRScanBottomSheetFragment.onViewCreated$lambda$2(this.f$0, view, view2);
            }
        });
        CachedImageView cachedImageView = (CachedImageView) view.findViewById(R.id.profile_icon);
        ImageView imageView = (ImageView) view.findViewById(R.id.no_photo_icon);
        cachedImageView.setOutlineProvider(new CircularOutlineProvider());
        cachedImageView.setClipToOutline(true);
        String picture = this.user.getPicture();
        String str = picture;
        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            cachedImageView.setVisibility(4);
            imageView.setVisibility(0);
        } else {
            cachedImageView.setVisibility(0);
            imageView.setVisibility(4);
            cachedImageView.reset();
            cachedImageView.setAutoLoad(false);
            cachedImageView.loadImage(picture);
        }
        ((TextView) view.findViewById(R.id.playerUsername)).setText("@" + this.user.getUsername());
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.copyLayout);
        Intrinsics.checkNotNull(constraintLayout);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return QRScanBottomSheetFragment.onViewCreated$lambda$3(this.f$0);
            }
        });
        final ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.sendCodeButtonLayout);
        constraintLayout2.setEnabled(false);
        constraintLayout2.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_button_background_grey));
        final EditText editText = (EditText) view.findViewById(R.id.friendCodeEditText);
        editText.setImeOptions(6);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment.onViewCreated.5
            private boolean deletingHyphen;
            private int hyphenStart;
            private boolean isFormatting;
            private int textLengthBeforeChange;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                int i;
                if (this.isFormatting) {
                    return;
                }
                if (this.deletingHyphen && (i = this.hyphenStart) > 0) {
                    this.isFormatting = true;
                    int i2 = i - 1;
                    Intrinsics.checkNotNull(s);
                    if (i2 < s.length()) {
                        s.delete(i2, this.hyphenStart);
                    }
                    this.isFormatting = false;
                }
                int length = StringsKt.replace$default(String.valueOf(s), " ", "", false, 4, (Object) null).length();
                ConstraintLayout constraintLayout3 = constraintLayout2;
                if (length == 6) {
                    constraintLayout3.setEnabled(true);
                    constraintLayout2.setBackground(ContextCompat.getDrawable(this.requireContext(), R.drawable.custom_button_background));
                } else {
                    constraintLayout3.setEnabled(false);
                    constraintLayout2.setBackground(ContextCompat.getDrawable(this.requireContext(), R.drawable.custom_button_background_grey));
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Intrinsics.checkNotNull(s);
                this.textLengthBeforeChange = s.length();
                if (count == 1 && after == 0) {
                    boolean z = s.charAt(start) == ' ';
                    this.deletingHyphen = z;
                    if (z) {
                        this.hyphenStart = start;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (this.isFormatting) {
                    return;
                }
                this.isFormatting = true;
                StringBuilder sb = new StringBuilder();
                if (s != null) {
                    int i = 0;
                    for (int i2 = 0; i2 < s.length(); i2++) {
                        char cCharAt = s.charAt(i2);
                        if (cCharAt != ' ') {
                            if (i % 2 == 0 && i > 0) {
                                sb.append(' ');
                            }
                            sb.append(cCharAt);
                            i++;
                        }
                    }
                }
                EditText editText2 = editText;
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                String upperCase = string.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                editText2.setText(upperCase);
                EditText editText3 = editText;
                editText3.setSelection(editText3.getText().length());
                this.isFormatting = false;
            }
        });
        Intrinsics.checkNotNull(constraintLayout2);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return QRScanBottomSheetFragment.onViewCreated$lambda$4(editText, this);
            }
        });
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        String string = preferencesManager.getString(PreferencesManager.CURRENT_FRIEND_CODE, "");
        if (string.length() > 0) {
            ((TextView) view.findViewById(R.id.friendCodeTextView)).setText(formatCode(string));
            this.friendCode = string;
        } else {
            MTApiKt.getMtApi().friendCode(this.user.getId()).enqueue(new Callback<MTCodeResponse>() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment.onViewCreated.7
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCodeResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCodeResponse> call, Response<MTCodeResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (!response.isSuccessful() || QRScanBottomSheetFragment.this.getContext() == null) {
                        return;
                    }
                    MTCodeResponse mTCodeResponseBody = response.body();
                    String code = mTCodeResponseBody != null ? mTCodeResponseBody.getCode() : null;
                    if (code != null) {
                        PreferencesManager preferencesManager2 = preferencesManager;
                        View view2 = view;
                        QRScanBottomSheetFragment qRScanBottomSheetFragment = QRScanBottomSheetFragment.this;
                        preferencesManager2.setString(PreferencesManager.CURRENT_FRIEND_CODE, code);
                        ((TextView) view2.findViewById(R.id.friendCodeTextView)).setText(qRScanBottomSheetFragment.formatCode(code));
                        qRScanBottomSheetFragment.setFriendCode(code);
                    }
                }
            });
        }
        String string2 = preferencesManager.getString(PreferencesManager.CURRENT_QR_CODE, "");
        String str2 = string2;
        if (str2.length() > 0) {
            this.qrCodeBase64 = string2;
            this.qrCodeOK = true;
        }
        if (str2.length() == 0) {
            MTApiKt.getMtApi().qr(this.user.getId()).enqueue(new Callback<MTQrResponse>() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment.onViewCreated.8
                @Override // retrofit2.Callback
                public void onFailure(Call<MTQrResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTQrResponse> call, Response<MTQrResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (!response.isSuccessful() || QRScanBottomSheetFragment.this.getContext() == null) {
                        return;
                    }
                    MTQrResponse mTQrResponseBody = response.body();
                    String qr = mTQrResponseBody != null ? mTQrResponseBody.getQr() : null;
                    if (qr != null) {
                        PreferencesManager preferencesManager2 = preferencesManager;
                        QRScanBottomSheetFragment qRScanBottomSheetFragment = QRScanBottomSheetFragment.this;
                        preferencesManager2.setString(PreferencesManager.CURRENT_QR_CODE, qr);
                        qRScanBottomSheetFragment.setQrCodeBase64(qr);
                        qRScanBottomSheetFragment.setQrCodeOK(true);
                    }
                }
            });
        }
    }

    public final void setFriendCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.friendCode = str;
    }

    public final void setQrCodeBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qrCodeBase64 = str;
    }

    public final void setQrCodeOK(boolean z) {
        this.qrCodeOK = z;
    }

    public final void setQrScanned(boolean z) {
        this.qrScanned = z;
    }

    public final void setShowingQR(boolean z) {
        this.showingQR = z;
    }
}
