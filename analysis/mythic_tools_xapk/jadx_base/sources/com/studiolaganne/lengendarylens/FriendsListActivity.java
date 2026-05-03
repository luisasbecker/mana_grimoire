package com.studiolaganne.lengendarylens;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.ProfileBottomSheetFragment;
import com.studiolaganne.lengendarylens.QRScanBottomSheetFragment;
import com.studiolaganne.lengendarylens.QrCodeFragment;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: FriendsListActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u000eH\u0016J\u0018\u0010 \u001a\u00020\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J\u0018\u0010!\u001a\u00020\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\nH\u0016J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020\u0014H\u0014J\u0012\u0010*\u001a\u00020\u00142\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u001dH\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/studiolaganne/lengendarylens/FriendsListActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "Lcom/studiolaganne/lengendarylens/FriendsListClickListener;", "Lcom/studiolaganne/lengendarylens/AcceptFriendCallback;", "Lcom/studiolaganne/lengendarylens/QRScanCallback;", "Lcom/studiolaganne/lengendarylens/ProfileCallback;", "<init>", "()V", NativeProtocol.AUDIENCE_FRIENDS, "", "Lcom/studiolaganne/lengendarylens/MTFriend;", "qrCodeOK", "", "qrCodeBase64", "", "fcmReceiver", "Landroid/content/BroadcastReceiver;", "requestCameraPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "openAppSettings", "", "updateFriends", "friendlist", "onProfileClose", "onProfileLogout", "onProfilePictureUpdated", "onQRClosed", "onFriendCodeConfirmed", "userId", "", "onQRScanned", "value", "onFriendAccepted", "onFriendDeclined", "onFriendTap", "friend", "onFriendWaitDialog", "user", "onFriendPending", "onFriendRemove", "onFriendInvite", "onDestroy", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "fetchFriendListAndShowPending", "friendId", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FriendsListActivity extends BaseActivity implements FriendsListClickListener, AcceptFriendCallback, QRScanCallback, ProfileCallback {
    public static final int $stable = 8;
    private BroadcastReceiver fcmReceiver;
    private boolean qrCodeOK;
    private List<MTFriend> friends = CollectionsKt.emptyList();
    private String qrCodeBase64 = "";
    private final ActivityResultLauncher<String> requestCameraPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity$$ExternalSyntheticLambda4
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            FriendsListActivity.requestCameraPermissionLauncher$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchFriendListAndShowPending(final int friendId) {
        final PreferencesManager preferencesManager;
        final MTUser currentUser;
        if (isFinishing() || isDestroyed() || (currentUser = (preferencesManager = new PreferencesManager(this)).getCurrentUser()) == null) {
            return;
        }
        MTApiKt.getMtApi().getFriends(currentUser.getId()).enqueue(new Callback<MTFriendResponse>() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity$fetchFriendListAndShowPending$1$1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTFriendResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTFriendResponse> call, Response<MTFriendResponse> response) throws IOException {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                ResponseBody responseBodyErrorBody = response.errorBody();
                if (responseBodyErrorBody != null) {
                    responseBodyErrorBody.string();
                }
                if (!response.isSuccessful() || this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                    return;
                }
                MTFriendResponse mTFriendResponseBody = response.body();
                Object obj = null;
                List<MTFriend> friends = mTFriendResponseBody != null ? mTFriendResponseBody.getFriends() : null;
                if (friends != null) {
                    PreferencesManager preferencesManager2 = preferencesManager;
                    FriendsListActivity friendsListActivity = this.this$0;
                    int i = friendId;
                    MTUser mTUser = currentUser;
                    preferencesManager2.saveCurrentUserFriends(friends);
                    friendsListActivity.updateFriends(friends);
                    Iterator<T> it = friends.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (((MTFriend) next).getId() == i) {
                            obj = next;
                            break;
                        }
                    }
                    MTFriend mTFriend = (MTFriend) obj;
                    if (mTFriend != null) {
                        new AcceptFriendBottomSheetFragment(friendsListActivity, mTUser, mTFriend).show(friendsListActivity.getSupportFragmentManager(), AcceptFriendBottomSheetFragment.TAG);
                    }
                }
            }
        });
    }

    static final Unit onCreate$lambda$1(FriendsListActivity friendsListActivity) {
        friendsListActivity.finish();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$3(final FriendsListActivity friendsListActivity, PreferencesManager preferencesManager, MTUser mTUser) {
        if (friendsListActivity.isDestroyed() || friendsListActivity.isFinishing()) {
            return Unit.INSTANCE;
        }
        FriendsListActivity friendsListActivity2 = friendsListActivity;
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(friendsListActivity2);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("add_friend_tap_list", null);
        if (preferencesManager.hasValidUser() && mTUser != null) {
            if (ContextCompat.checkSelfPermission(friendsListActivity2, "android.permission.CAMERA") == 0) {
                QRScanBottomSheetFragment.Companion.newInstance$default(QRScanBottomSheetFragment.INSTANCE, friendsListActivity, mTUser, false, 4, null).show(friendsListActivity.getSupportFragmentManager(), QRScanBottomSheetFragment.TAG);
            } else if (!preferencesManager.getBoolean(PreferencesManager.CAMERA_PERMISSION_ASKED_BEFORE, false)) {
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string = friendsListActivity.getString(R.string.permissions_title);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CustomDialogFragment.Builder title = builder.setTitle(string);
                String string2 = friendsListActivity.getString(R.string.camera_permission_rationale);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
                String string3 = friendsListActivity.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FriendsListActivity.onCreate$lambda$3$0$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                });
                String string4 = friendsListActivity.getString(R.string.cancel);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FriendsListActivity.onCreate$lambda$3$0$1((CustomDialogFragment) obj);
                    }
                });
                FragmentManager supportFragmentManager = friendsListActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                negativeButton.show(supportFragmentManager, "camera_permission_dialog");
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(friendsListActivity, "android.permission.CAMERA")) {
                friendsListActivity.requestCameraPermissionLauncher.launch("android.permission.CAMERA");
            } else {
                CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
                String string5 = friendsListActivity.getString(R.string.permissions_title);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                CustomDialogFragment.Builder title2 = builder2.setTitle(string5);
                String string6 = friendsListActivity.getString(R.string.camera_permission_denied_message);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                CustomDialogFragment.Builder positiveButtonRed2 = title2.setBody(string6).setPositiveButtonRed();
                String string7 = friendsListActivity.getString(R.string.open_settings);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                CustomDialogFragment.Builder positiveButton2 = positiveButtonRed2.setPositiveButton(string7, new Function2() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FriendsListActivity.onCreate$lambda$3$0$2(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                });
                String string8 = friendsListActivity.getString(R.string.cancel);
                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                CustomDialogFragment.Builder negativeButton2 = positiveButton2.setNegativeButton(string8, new Function1() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FriendsListActivity.onCreate$lambda$3$0$3((CustomDialogFragment) obj);
                    }
                });
                FragmentManager supportFragmentManager2 = friendsListActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
                negativeButton2.show(supportFragmentManager2, "camera_permission_settings_dialog");
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$3$0$0(FriendsListActivity friendsListActivity, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        friendsListActivity.requestCameraPermissionLauncher.launch("android.permission.CAMERA");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$3$0$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$3$0$2(FriendsListActivity friendsListActivity, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        friendsListActivity.openAppSettings();
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$3$0$3(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$4(FriendsListActivity friendsListActivity, MTUser mTUser) {
        String username;
        if (friendsListActivity.qrCodeOK) {
            if (friendsListActivity.isFinishing() || friendsListActivity.isDestroyed()) {
                return Unit.INSTANCE;
            }
            QrCodeFragment.Builder qrCodeBase64 = new QrCodeFragment.Builder().setQrCodeBase64(friendsListActivity.qrCodeBase64);
            if (mTUser == null || (username = mTUser.getUsername()) == null) {
                username = "";
            }
            QrCodeFragment.Builder userName = qrCodeBase64.setUserName(username);
            FragmentManager supportFragmentManager = friendsListActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            userName.show(supportFragmentManager, "QrCodeFragment");
        }
        return Unit.INSTANCE;
    }

    static final Unit onFriendRemove$lambda$0(FriendsListActivity friendsListActivity, MTFriend mTFriend, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        PreferencesManager preferencesManager = new PreferencesManager(friendsListActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) friendsListActivity.findViewById(R.id.overlay);
            constraintLayout.setVisibility(0);
            MTApiKt.getMtApi().removeFriend(currentUser.getId(), mTFriend.getId()).enqueue(new FriendsListActivity$onFriendRemove$1$1$1(friendsListActivity, preferencesManager, constraintLayout));
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onFriendRemove$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onFriendWaitDialog$lambda$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onFriendWaitDialog$lambda$1(FriendsListActivity friendsListActivity, MTFriend mTFriend, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (friendsListActivity.isFinishing() || friendsListActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        PreferencesManager preferencesManager = new PreferencesManager(friendsListActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        MTApiKt.getMtApi().removeFriend(currentUser != null ? currentUser.getId() : -1, mTFriend.getId()).enqueue(new FriendsListActivity$onFriendWaitDialog$2$1(friendsListActivity, preferencesManager));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onQRScanned$lambda$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void openAppSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        startActivity(intent);
    }

    static final void requestCameraPermissionLauncher$lambda$0(FriendsListActivity friendsListActivity, boolean z) {
        if (friendsListActivity.isDestroyed() || friendsListActivity.isFinishing()) {
            return;
        }
        FriendsListActivity friendsListActivity2 = friendsListActivity;
        new PreferencesManager(friendsListActivity2).setBoolean(PreferencesManager.CAMERA_PERMISSION_ASKED_BEFORE, true);
        if (!z) {
            Toast.makeText(friendsListActivity2, friendsListActivity.getString(R.string.camera_permission_denied_friend), 1).show();
            return;
        }
        PreferencesManager preferencesManager = new PreferencesManager(friendsListActivity2);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (!preferencesManager.hasValidUser() || currentUser == null) {
            return;
        }
        QRScanBottomSheetFragment.Companion.newInstance$default(QRScanBottomSheetFragment.INSTANCE, friendsListActivity, currentUser, false, 4, null).show(friendsListActivity.getSupportFragmentManager(), QRScanBottomSheetFragment.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFriends(List<MTFriend> friendlist) {
        if (friendlist == null) {
            friendlist = CollectionsKt.emptyList();
        }
        this.friends = friendlist;
        View viewFindViewById = findViewById(R.id.friendsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((RecyclerView) viewFindViewById).setAdapter(new FriendsListAdapter(this.friends, this, false, null, 12, null));
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);
        this.fcmReceiver = new BroadcastReceiver() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity.onCreate.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String stringExtra = intent != null ? intent.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE) : null;
                if (!Intrinsics.areEqual(stringExtra, PreferencesManager.MSG_TYPE_FRIENDSHIP_REQUEST)) {
                    if (!Intrinsics.areEqual(stringExtra, PreferencesManager.MSG_TYPE_FRIENDSHIP_ACCEPTED) || context == null) {
                        return;
                    }
                    FriendsListActivity.this.fetchFriendListAndShowPending(-1);
                    return;
                }
                if (context == null) {
                    return;
                }
                String stringExtra2 = intent.getStringExtra("message_fromUserId");
                Integer intOrNull = stringExtra2 != null ? StringsKt.toIntOrNull(stringExtra2) : null;
                if (intOrNull != null) {
                    FriendsListActivity friendsListActivity = FriendsListActivity.this;
                    intOrNull.intValue();
                    Fragment fragmentFindFragmentByTag = friendsListActivity.getSupportFragmentManager().findFragmentByTag(QRScanBottomSheetFragment.TAG);
                    QRScanBottomSheetFragment qRScanBottomSheetFragment = fragmentFindFragmentByTag instanceof QRScanBottomSheetFragment ? (QRScanBottomSheetFragment) fragmentFindFragmentByTag : null;
                    if (qRScanBottomSheetFragment != null) {
                        qRScanBottomSheetFragment.closeQRDialog();
                    }
                    if (qRScanBottomSheetFragment != null) {
                        qRScanBottomSheetFragment.dismiss();
                    }
                    friendsListActivity.fetchFriendListAndShowPending(intOrNull.intValue());
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(PreferencesManager.MESSAGE_INTENT);
        FriendsListActivity friendsListActivity = this;
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(friendsListActivity);
        BroadcastReceiver broadcastReceiver = this.fcmReceiver;
        if (broadcastReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fcmReceiver");
            broadcastReceiver = null;
        }
        localBroadcastManager.registerReceiver(broadcastReceiver, intentFilter);
        final PreferencesManager preferencesManager = new PreferencesManager(friendsListActivity);
        final MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            this.friends = preferencesManager.getCurrentUserFriends();
        }
        View viewFindViewById = findViewById(R.id.backLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FriendsListActivity.onCreate$lambda$1(this.f$0);
            }
        });
        View viewFindViewById2 = findViewById(R.id.qrLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        });
        View viewFindViewById3 = findViewById(R.id.friendsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById3;
        recyclerView.setLayoutManager(new LinearLayoutManager(friendsListActivity));
        recyclerView.setAdapter(new FriendsListAdapter(this.friends, this, false, null, 12, null));
        View viewFindViewById4 = findViewById(R.id.inviteButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById4, new Function0() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FriendsListActivity.onCreate$lambda$3(this.f$0, preferencesManager, currentUser);
            }
        });
        String string = preferencesManager.getString(PreferencesManager.CURRENT_QR_CODE, "");
        String str = string;
        if (str.length() > 0) {
            this.qrCodeBase64 = string;
            this.qrCodeOK = true;
        }
        if (str.length() == 0) {
            MTApiKt.getMtApi().qr(currentUser != null ? currentUser.getId() : -1).enqueue(new Callback<MTQrResponse>() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity.onCreate.6
                @Override // retrofit2.Callback
                public void onFailure(Call<MTQrResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTQrResponse> call, Response<MTQrResponse> response) throws IOException {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    ResponseBody responseBodyErrorBody = response.errorBody();
                    if (responseBodyErrorBody != null) {
                        responseBodyErrorBody.string();
                    }
                    if (!response.isSuccessful() || FriendsListActivity.this.isFinishing() || FriendsListActivity.this.isDestroyed()) {
                        return;
                    }
                    MTQrResponse mTQrResponseBody = response.body();
                    String qr = mTQrResponseBody != null ? mTQrResponseBody.getQr() : null;
                    if (qr != null) {
                        PreferencesManager preferencesManager2 = preferencesManager;
                        FriendsListActivity friendsListActivity2 = FriendsListActivity.this;
                        preferencesManager2.setString(PreferencesManager.CURRENT_QR_CODE, qr);
                        friendsListActivity2.qrCodeBase64 = qr;
                        friendsListActivity2.qrCodeOK = true;
                    }
                }
            });
        }
        View viewFindViewById5 = findViewById(R.id.qrLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById5, new Function0() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FriendsListActivity.onCreate$lambda$4(this.f$0, currentUser);
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        BroadcastReceiver broadcastReceiver = this.fcmReceiver;
        if (broadcastReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fcmReceiver");
            broadcastReceiver = null;
        }
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
    }

    @Override // com.studiolaganne.lengendarylens.AcceptFriendCallback
    public void onFriendAccepted(List<MTFriend> friendlist) {
        updateFriends(friendlist);
    }

    @Override // com.studiolaganne.lengendarylens.QRScanCallback
    public void onFriendCodeConfirmed(int userId) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        PreferencesManager preferencesManager = new PreferencesManager(this);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (!preferencesManager.hasValidUser() || currentUser == null || userId == -1 || userId == currentUser.getId()) {
            return;
        }
        ((ConstraintLayout) findViewById(R.id.overlay)).setVisibility(0);
        ((TextView) findViewById(R.id.connectingTextView)).setText(getString(R.string.adding));
        MTApiKt.getMtApi().addFriend(currentUser.getId(), userId).enqueue(new FriendsListActivity$onFriendCodeConfirmed$1$1(this, userId, preferencesManager));
    }

    @Override // com.studiolaganne.lengendarylens.AcceptFriendCallback
    public void onFriendDeclined(List<MTFriend> friendlist) {
        updateFriends(friendlist);
    }

    @Override // com.studiolaganne.lengendarylens.FriendsListClickListener
    public void onFriendInvite(MTFriend user) {
        Intrinsics.checkNotNullParameter(user, "user");
    }

    @Override // com.studiolaganne.lengendarylens.FriendsListClickListener
    public void onFriendPending(MTFriend friend) {
        Intrinsics.checkNotNullParameter(friend, "friend");
        FriendsListActivity friendsListActivity = this;
        MTUser currentUser = new PreferencesManager(friendsListActivity).getCurrentUser();
        if (currentUser != null) {
            Breadcrumbs.INSTANCE.leaveBreadcrumb("accept_friend_tap_from_list");
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(friendsListActivity);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("accept_friend_tap_from_list", null);
            new AcceptFriendBottomSheetFragment(this, currentUser, friend).show(getSupportFragmentManager(), AcceptFriendBottomSheetFragment.TAG);
        }
    }

    @Override // com.studiolaganne.lengendarylens.FriendsListClickListener
    public void onFriendRemove(final MTFriend friend) {
        Intrinsics.checkNotNullParameter(friend, "friend");
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getResources().getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getResources().getString(R.string.remove_friend_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(StringsKt.replace$default(string2, "{username}", friend.getFirstname(), false, 4, (Object) null)).setPositiveButtonRed();
        String string3 = getResources().getString(R.string.remove_button);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FriendsListActivity.onFriendRemove$lambda$0(this.f$0, friend, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getResources().getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FriendsListActivity.onFriendRemove$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        negativeButton.show(supportFragmentManager, "CustomDialogFragment");
    }

    @Override // com.studiolaganne.lengendarylens.FriendsListClickListener
    public void onFriendTap(MTFriend friend) {
        Intrinsics.checkNotNullParameter(friend, "friend");
        ProfileBottomSheetFragment.Companion.newInstance$default(ProfileBottomSheetFragment.INSTANCE, this, new MTUser(false, friend.getId(), friend.getFirstname(), friend.getEmail(), friend.getUsername(), friend.getPicture(), null, null, null, null, 960, null), null, null, 12, null).show(getSupportFragmentManager(), ProfileBottomSheetFragment.TAG);
    }

    @Override // com.studiolaganne.lengendarylens.FriendsListClickListener
    public void onFriendWaitDialog(final MTFriend user) {
        Intrinsics.checkNotNullParameter(user, "user");
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.friend_request_pending_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.friend_request_pending_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FriendsListActivity.onFriendWaitDialog$lambda$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.remove_invite);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder destructiveButton = positiveButton.setDestructiveButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FriendsListActivity.onFriendWaitDialog$lambda$1(this.f$0, user, (CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        destructiveButton.show(supportFragmentManager, "friend_request_pending_dialog");
    }

    @Override // com.studiolaganne.lengendarylens.ProfileCallback
    public void onProfileClose() {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(ProfileBottomSheetFragment.TAG);
        ProfileBottomSheetFragment profileBottomSheetFragment = fragmentFindFragmentByTag instanceof ProfileBottomSheetFragment ? (ProfileBottomSheetFragment) fragmentFindFragmentByTag : null;
        if (profileBottomSheetFragment != null) {
            profileBottomSheetFragment.dismiss();
        }
    }

    @Override // com.studiolaganne.lengendarylens.ProfileCallback
    public void onProfileLogout() {
    }

    @Override // com.studiolaganne.lengendarylens.ProfileCallback
    public void onProfilePictureUpdated() {
    }

    @Override // com.studiolaganne.lengendarylens.QRScanCallback
    public void onQRClosed() {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(QRScanBottomSheetFragment.TAG);
        QRScanBottomSheetFragment qRScanBottomSheetFragment = fragmentFindFragmentByTag instanceof QRScanBottomSheetFragment ? (QRScanBottomSheetFragment) fragmentFindFragmentByTag : null;
        if (qRScanBottomSheetFragment != null) {
            qRScanBottomSheetFragment.dismiss();
        }
    }

    @Override // com.studiolaganne.lengendarylens.QRScanCallback
    public void onQRScanned(String value) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(value, "value");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        PreferencesManager preferencesManager = new PreferencesManager(this);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (!preferencesManager.hasValidUser() || currentUser == null) {
            return;
        }
        byte[] bArrDecode = Base64.decode(StringsKt.substringAfterLast$default(value, DomExceptionUtils.SEPARATOR, (String) null, 2, (Object) null), 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        String str = new String(bArrDecode, Charsets.UTF_8);
        if (str.length() != 0) {
            Integer intOrNull = StringsKt.toIntOrNull(str);
            if (intOrNull == null || (iIntValue = intOrNull.intValue()) == -1 || iIntValue == currentUser.getId()) {
                return;
            }
            ((ConstraintLayout) findViewById(R.id.overlay)).setVisibility(0);
            ((TextView) findViewById(R.id.connectingTextView)).setText(getString(R.string.adding));
            MTApiKt.getMtApi().addFriend(currentUser.getId(), iIntValue).enqueue(new FriendsListActivity$onQRScanned$1$2$1(this, iIntValue, preferencesManager));
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.qr_error_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.qr_error_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.FriendsListActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FriendsListActivity.onQRScanned$lambda$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        positiveButton.show(supportFragmentManager, "qr_code_error_dialog");
    }
}
