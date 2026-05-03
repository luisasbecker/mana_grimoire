package com.studiolaganne.lengendarylens;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: QRScanBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/QRScanBottomSheetFragment$onViewCreated$6$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTUserResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class QRScanBottomSheetFragment$onViewCreated$6$1 implements Callback<MTUserResponse> {
    final /* synthetic */ QRScanBottomSheetFragment this$0;

    QRScanBottomSheetFragment$onViewCreated$6$1(QRScanBottomSheetFragment qRScanBottomSheetFragment) {
        this.this$0 = qRScanBottomSheetFragment;
    }

    static final Unit onFailure$lambda$2(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$0$0(QRScanBottomSheetFragment qRScanBottomSheetFragment, MTUser mTUser, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        QRScanCallback qRScanCallback = qRScanBottomSheetFragment.callback;
        if (qRScanCallback != null) {
            qRScanCallback.onFriendCodeConfirmed(mTUser.getId());
        }
        qRScanBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$0$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onResponse$lambda$1(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTUserResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = this.this$0.getString(R.string.invalid_code_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = this.this$0.getString(R.string.invalid_code_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = this.this$0.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment$onViewCreated$6$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return QRScanBottomSheetFragment$onViewCreated$6$1.onFailure$lambda$2(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "CustomDialogFragment");
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTUserResponse> call, Response<MTUserResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (!response.isSuccessful()) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = this.this$0.getString(R.string.invalid_code_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = this.this$0.getString(R.string.invalid_code_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = this.this$0.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment$onViewCreated$6$1$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QRScanBottomSheetFragment$onViewCreated$6$1.onResponse$lambda$1(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            positiveButton.show(childFragmentManager, "CustomDialogFragment");
            return;
        }
        if (this.this$0.getContext() == null) {
            return;
        }
        MTUserResponse mTUserResponseBody = response.body();
        final MTUser user = mTUserResponseBody != null ? mTUserResponseBody.getUser() : null;
        if (user != null) {
            final QRScanBottomSheetFragment qRScanBottomSheetFragment = this.this$0;
            CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
            String string4 = qRScanBottomSheetFragment.getString(R.string.invite_friend_by_code_title);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder title2 = builder2.setTitle(string4);
            String string5 = qRScanBottomSheetFragment.getString(R.string.invite_friend_by_code_body);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            String firstname = user.getFirstname();
            String strReplace$default = StringsKt.replace$default(string5, "{1}", firstname == null ? "unknown" : firstname, false, 4, (Object) null);
            String username = user.getUsername();
            CustomDialogFragment.Builder body2 = title2.setBody(StringsKt.replace$default(strReplace$default, "{2}", username == null ? "unknown" : username, false, 4, (Object) null));
            String string6 = qRScanBottomSheetFragment.getString(R.string.invite);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            CustomDialogFragment.Builder positiveButtonRed = body2.setPositiveButton(string6, new Function2() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment$onViewCreated$6$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QRScanBottomSheetFragment$onViewCreated$6$1.onResponse$lambda$0$0(qRScanBottomSheetFragment, user, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            }).setPositiveButtonRed();
            String string7 = qRScanBottomSheetFragment.getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButtonRed.setNegativeButton(string7, new Function1() { // from class: com.studiolaganne.lengendarylens.QRScanBottomSheetFragment$onViewCreated$6$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return QRScanBottomSheetFragment$onViewCreated$6$1.onResponse$lambda$0$1((CustomDialogFragment) obj);
                }
            });
            FragmentManager childFragmentManager2 = qRScanBottomSheetFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            negativeButton.show(childFragmentManager2, "CustomDialogFragment");
        }
    }
}
