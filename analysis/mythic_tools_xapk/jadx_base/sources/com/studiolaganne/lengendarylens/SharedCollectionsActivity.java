package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.PendingItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: SharedCollectionsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0014J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0016\u0010\u001b\u001a\u00020\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u0016\u0010\u001f\u001a\u00020\u00162\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001dH\u0002J \u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006H\u0002J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0006H\u0016J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0006H\u0016J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0006H\u0016J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0006H\u0016J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0006H\u0016J\u0010\u00100\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0006H\u0016J\u001c\u00101\u001a\u00020\u0016\"\u0004\b\u0000\u001022\f\u00103\u001a\b\u0012\u0004\u0012\u0002H204H\u0002J\b\u00105\u001a\u00020\u0016H\u0002J\u0018\u00106\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/studiolaganne/lengendarylens/SharedCollectionsActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "Lcom/studiolaganne/lengendarylens/PendingInviteActionListener;", "<init>", "()V", "currentUserId", "", "fcmReceiver", "Landroid/content/BroadcastReceiver;", "pendingInvitesSection", "Landroid/widget/LinearLayout;", "pendingInvitesRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "pendingInviteAdapter", "Lcom/studiolaganne/lengendarylens/PendingInviteAdapter;", "sharedCollectionsSection", "sharedCollectionsContainer", "noSharedCollectionsText", "Landroid/widget/TextView;", "overlay", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "fetchSharedCollections", "updatePendingItems", FirebaseAnalytics.Param.ITEMS, "", "Lcom/studiolaganne/lengendarylens/PendingItem;", "updateSharedCollections", "collections", "Lcom/studiolaganne/lengendarylens/MTSharedCollection;", "confirmUnshare", "collectionId", "targetUserId", "targetName", "", "performUnshareRequest", "dpToPx", "dp", "onAcceptInvite", "inviteId", "onRejectInvite", "onCancelInvite", "onAcceptUnshare", "onRejectUnshare", "onCancelUnshare", "showApiError", ExifInterface.GPS_DIRECTION_TRUE, "response", "Lretrofit2/Response;", "showInviteFriendDialog", "performInvite", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedCollectionsActivity extends BaseActivity implements PendingInviteActionListener {
    public static final int $stable = 8;
    private int currentUserId = -1;
    private BroadcastReceiver fcmReceiver;
    private TextView noSharedCollectionsText;
    private ConstraintLayout overlay;
    private PendingInviteAdapter pendingInviteAdapter;
    private RecyclerView pendingInvitesRecyclerView;
    private LinearLayout pendingInvitesSection;
    private LinearLayout sharedCollectionsContainer;
    private LinearLayout sharedCollectionsSection;

    private final void confirmUnshare(final int collectionId, final int targetUserId, String targetName) {
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.unshare_confirm_body, new Object[]{targetName});
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = getString(R.string.unshare_button);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SharedCollectionsActivity.confirmUnshare$lambda$0(this.f$0, collectionId, targetUserId, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SharedCollectionsActivity.confirmUnshare$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        negativeButton.show(supportFragmentManager, "unshare_confirm_dialog");
    }

    static final Unit confirmUnshare$lambda$0(SharedCollectionsActivity sharedCollectionsActivity, int i, int i2, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        sharedCollectionsActivity.performUnshareRequest(i, i2);
        return Unit.INSTANCE;
    }

    static final Unit confirmUnshare$lambda$1(CustomDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.dismiss();
        return Unit.INSTANCE;
    }

    private final int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchSharedCollections() {
        if (this.currentUserId == -1) {
            return;
        }
        ConstraintLayout constraintLayout = this.overlay;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlay");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        MTApiKt.getMtApi().getSharedCollections(this.currentUserId).enqueue(new Callback<MTSharedCollectionsResponse>() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity.fetchSharedCollections.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSharedCollectionsResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSharedCollectionsResponse> call, Response<MTSharedCollectionsResponse> response) {
                ArrayList arrayListEmptyList;
                ArrayList arrayListEmptyList2;
                ArrayList arrayListEmptyList3;
                List<MTSharedCollection> shared_collections;
                List<MTUnshareRequest> unshare_requests;
                List<MTSharedCollectionInvite> invites;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                if (response.isSuccessful()) {
                    MTSharedCollectionsResponse mTSharedCollectionsResponseBody = response.body();
                    if (mTSharedCollectionsResponseBody == null || (invites = mTSharedCollectionsResponseBody.getInvites()) == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : invites) {
                            if (Intrinsics.areEqual(((MTSharedCollectionInvite) obj).getStatus(), "requested")) {
                                arrayList.add(obj);
                            }
                        }
                        arrayListEmptyList = arrayList;
                    }
                    if (mTSharedCollectionsResponseBody == null || (unshare_requests = mTSharedCollectionsResponseBody.getUnshare_requests()) == null) {
                        arrayListEmptyList2 = CollectionsKt.emptyList();
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj2 : unshare_requests) {
                            if (Intrinsics.areEqual(((MTUnshareRequest) obj2).getStatus(), "requested")) {
                                arrayList2.add(obj2);
                            }
                        }
                        arrayListEmptyList2 = arrayList2;
                    }
                    List list = arrayListEmptyList;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(new PendingItem.Invite((MTSharedCollectionInvite) it.next()));
                    }
                    ArrayList arrayList4 = arrayList3;
                    List list2 = arrayListEmptyList2;
                    ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList5.add(new PendingItem.Unshare((MTUnshareRequest) it2.next()));
                    }
                    SharedCollectionsActivity.this.updatePendingItems(CollectionsKt.plus((Collection) arrayList4, (Iterable) arrayList5));
                    if (mTSharedCollectionsResponseBody == null || (shared_collections = mTSharedCollectionsResponseBody.getShared_collections()) == null) {
                        arrayListEmptyList3 = CollectionsKt.emptyList();
                    } else {
                        ArrayList arrayList6 = new ArrayList();
                        for (Object obj3 : shared_collections) {
                            if (Intrinsics.areEqual(((MTSharedCollection) obj3).getStatus(), AppMeasurementSdk.ConditionalUserProperty.ACTIVE)) {
                                arrayList6.add(obj3);
                            }
                        }
                        arrayListEmptyList3 = arrayList6;
                    }
                    SharedCollectionsActivity.this.updateSharedCollections(arrayListEmptyList3);
                }
            }
        });
    }

    static final Unit onCreate$lambda$0(SharedCollectionsActivity sharedCollectionsActivity) {
        sharedCollectionsActivity.finish();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$1(SharedCollectionsActivity sharedCollectionsActivity) {
        sharedCollectionsActivity.showInviteFriendDialog();
        return Unit.INSTANCE;
    }

    private final void performInvite(int currentUserId, int targetUserId) {
        ConstraintLayout constraintLayout = this.overlay;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlay");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        MTApiKt.getMtApi().inviteSharedCollection(currentUserId, new MTSharedCollectionInviteBody(targetUserId)).enqueue(new Callback<MTSharedCollectionInviteResponse>() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity.performInvite.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSharedCollectionInviteResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                Toast.makeText(SharedCollectionsActivity.this, R.string.invite_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSharedCollectionInviteResponse> call, Response<MTSharedCollectionInviteResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                boolean zIsSuccessful = response.isSuccessful();
                SharedCollectionsActivity sharedCollectionsActivity = SharedCollectionsActivity.this;
                if (!zIsSuccessful) {
                    sharedCollectionsActivity.showApiError(response);
                } else {
                    Toast.makeText(sharedCollectionsActivity, R.string.invite_success, 0).show();
                    SharedCollectionsActivity.this.fetchSharedCollections();
                }
            }
        });
    }

    private final void performUnshareRequest(int collectionId, int targetUserId) {
        if (this.currentUserId == -1) {
            return;
        }
        ConstraintLayout constraintLayout = this.overlay;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlay");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        MTApiKt.getMtApi().requestUnshare(this.currentUserId, collectionId, new MTUnshareRequestBody(targetUserId)).enqueue(new Callback<MTSuccessResponse>() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity.performUnshareRequest.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSuccessResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                Toast.makeText(SharedCollectionsActivity.this, R.string.invite_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSuccessResponse> call, Response<MTSuccessResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                boolean zIsSuccessful = response.isSuccessful();
                SharedCollectionsActivity sharedCollectionsActivity = SharedCollectionsActivity.this;
                if (!zIsSuccessful) {
                    sharedCollectionsActivity.showApiError(response);
                } else {
                    Toast.makeText(sharedCollectionsActivity, R.string.unshare_request_sent, 0).show();
                    SharedCollectionsActivity.this.fetchSharedCollections();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void showApiError(Response<T> response) {
        ResponseBody responseBodyErrorBody = response.errorBody();
        String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
        if (strString == null) {
            Toast.makeText(this, R.string.invite_error, 0).show();
            return;
        }
        try {
            MTResponse mTResponse = (MTResponse) new Gson().fromJson(strString, (Class) MTResponse.class);
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = getString(R.string.server_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
            String string2 = getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SharedCollectionsActivity.showApiError$lambda$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            Boolean.valueOf(positiveButton.show(supportFragmentManager, "api_error_dialog"));
        } catch (Exception unused) {
            Toast.makeText(this, R.string.invite_error, 0).show();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showApiError$lambda$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void showInviteFriendDialog() {
        SharedCollectionsActivity sharedCollectionsActivity = this;
        PreferencesManager preferencesManager = new PreferencesManager(sharedCollectionsActivity);
        final MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null) {
            return;
        }
        List<MTFriend> currentUserFriends = preferencesManager.getCurrentUserFriends();
        ArrayList arrayList = new ArrayList();
        for (Object obj : currentUserFriends) {
            if (Intrinsics.areEqual(((MTFriend) obj).getStatus(), "accepted")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        final Dialog dialog = new Dialog(sharedCollectionsActivity);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setDimAmount(0.5f);
        }
        View viewInflate = LayoutInflater.from(sharedCollectionsActivity).inflate(R.layout.dialog_invite_friend, (ViewGroup) null);
        dialog.setContentView(viewInflate);
        TextView textView = (TextView) viewInflate.findViewById(R.id.closeButton);
        EditText editText = (EditText) viewInflate.findViewById(R.id.searchEditText);
        final RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.friendsRecyclerView);
        final TextView textView2 = (TextView) viewInflate.findViewById(R.id.emptyStateText);
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.cancelButton);
        final MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.inviteButton);
        final InviteFriendAdapter inviteFriendAdapter = new InviteFriendAdapter(arrayList2, new Function1() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return SharedCollectionsActivity.showInviteFriendDialog$lambda$1(materialButton2, (Integer) obj2);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(sharedCollectionsActivity));
        recyclerView.setAdapter(inviteFriendAdapter);
        if (arrayList2.isEmpty()) {
            textView2.setVisibility(0);
            recyclerView.setVisibility(8);
            editText.setVisibility(8);
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity.showInviteFriendDialog.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String string;
                InviteFriendAdapter inviteFriendAdapter2 = inviteFriendAdapter;
                if (s == null || (string = s.toString()) == null) {
                    string = "";
                }
                inviteFriendAdapter2.filter(string);
                textView2.setVisibility(inviteFriendAdapter.getItemCount() == 0 ? 0 : 8);
                recyclerView.setVisibility(inviteFriendAdapter.getItemCount() == 0 ? 8 : 0);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity$$ExternalSyntheticLambda2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView3, int i, KeyEvent keyEvent) {
                return SharedCollectionsActivity.showInviteFriendDialog$lambda$2(this.f$0, textView3, i, keyEvent);
            }
        });
        Intrinsics.checkNotNull(textView);
        ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SharedCollectionsActivity.showInviteFriendDialog$lambda$3(dialog);
            }
        });
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SharedCollectionsActivity.showInviteFriendDialog$lambda$5(inviteFriendAdapter, dialog, this, currentUser, view);
            }
        });
        dialog.show();
        Window window3 = dialog.getWindow();
        if (window3 != null) {
            window3.setLayout(-1, -2);
        }
    }

    static final Unit showInviteFriendDialog$lambda$1(MaterialButton materialButton, Integer num) {
        boolean z = num != null;
        materialButton.setEnabled(z);
        materialButton.setAlpha(z ? 1.0f : 0.5f);
        return Unit.INSTANCE;
    }

    static final boolean showInviteFriendDialog$lambda$2(SharedCollectionsActivity sharedCollectionsActivity, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        Object systemService = sharedCollectionsActivity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
        return true;
    }

    static final Unit showInviteFriendDialog$lambda$3(Dialog dialog) {
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final void showInviteFriendDialog$lambda$5(InviteFriendAdapter inviteFriendAdapter, Dialog dialog, SharedCollectionsActivity sharedCollectionsActivity, MTUser mTUser, View view) {
        Integer selectedFriendId = inviteFriendAdapter.getSelectedFriendId();
        if (selectedFriendId != null) {
            int iIntValue = selectedFriendId.intValue();
            dialog.dismiss();
            sharedCollectionsActivity.performInvite(mTUser.getId(), iIntValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePendingItems(List<? extends PendingItem> items) {
        PendingInviteAdapter pendingInviteAdapter = this.pendingInviteAdapter;
        LinearLayout linearLayout = null;
        if (pendingInviteAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pendingInviteAdapter");
            pendingInviteAdapter = null;
        }
        pendingInviteAdapter.updateItems(items);
        LinearLayout linearLayout2 = this.pendingInvitesSection;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pendingInvitesSection");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setVisibility(items.isEmpty() ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSharedCollections(List<MTSharedCollection> collections) {
        TextView textView;
        LinearLayout linearLayout = this.sharedCollectionsContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedCollectionsContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        boolean zIsEmpty = collections.isEmpty();
        LinearLayout linearLayout2 = this.sharedCollectionsSection;
        int i = 0;
        if (zIsEmpty) {
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedCollectionsSection");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(0);
            TextView textView2 = this.noSharedCollectionsText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noSharedCollectionsText");
                textView = null;
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
            return;
        }
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedCollectionsSection");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(0);
        TextView textView3 = this.noSharedCollectionsText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noSharedCollectionsText");
            textView3 = null;
        }
        textView3.setVisibility(8);
        for (final MTSharedCollection mTSharedCollection : collections) {
            List<MTSharedCollectionMember> members = mTSharedCollection.getMembers();
            if (members != null) {
                SharedCollectionsActivity sharedCollectionsActivity = this;
                LinearLayout linearLayout3 = new LinearLayout(sharedCollectionsActivity);
                linearLayout3.setOrientation(1);
                linearLayout3.setBackgroundResource(R.drawable.black_box_with_line);
                linearLayout3.setPadding(dpToPx(16), dpToPx(16), dpToPx(16), dpToPx(16));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                int i2 = 12;
                layoutParams.bottomMargin = dpToPx(12);
                linearLayout3.setLayoutParams(layoutParams);
                TextView textView4 = new TextView(sharedCollectionsActivity);
                textView4.setText(getString(R.string.n_users, new Object[]{Integer.valueOf(members.size())}));
                textView4.setTextSize(13.0f);
                textView4.setTypeface(textView4.getResources().getFont(R.font.be_vietnam_pro_semibold));
                textView4.setTextColor(textView4.getResources().getColor(R.color.draw_orange, getTheme()));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.bottomMargin = dpToPx(12);
                textView4.setLayoutParams(layoutParams2);
                linearLayout3.addView(textView4);
                LinearLayout linearLayout4 = new LinearLayout(sharedCollectionsActivity);
                linearLayout4.setOrientation(i);
                linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                for (final MTSharedCollectionMember mTSharedCollectionMember : members) {
                    View viewBuildMemberAvatarView = SharedCollectionsActivityKt.buildMemberAvatarView(sharedCollectionsActivity, mTSharedCollectionMember.getPicture(), mTSharedCollectionMember.getFirstname(), mTSharedCollectionMember.getUsername());
                    if (mTSharedCollectionMember.getId() != this.currentUserId) {
                        FrameLayout frameLayout = new FrameLayout(sharedCollectionsActivity);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams3.setMarginEnd(dpToPx(i2));
                        frameLayout.setLayoutParams(layoutParams3);
                        ViewGroup.LayoutParams layoutParams4 = viewBuildMemberAvatarView.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams5 = layoutParams4 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams4 : null;
                        if (layoutParams5 != null) {
                            layoutParams5.setMarginEnd(i);
                        }
                        frameLayout.addView(viewBuildMemberAvatarView);
                        int iDpToPx = dpToPx(28);
                        TextView textView5 = new TextView(sharedCollectionsActivity);
                        textView5.setText("\uf127");
                        textView5.setTypeface(textView5.getResources().getFont(R.font.fa6solid));
                        textView5.setTextSize(14.0f);
                        textView5.setTextColor(textView5.getResources().getColor(R.color.almost_white, getTheme()));
                        textView5.setGravity(17);
                        textView5.setBackgroundResource(R.drawable.custom_exit_button_background);
                        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(iDpToPx, iDpToPx);
                        layoutParams6.gravity = 8388661;
                        textView5.setLayoutParams(layoutParams6);
                        TextView textView6 = textView5;
                        ViewExtensionsKt.setOnClickWithFade(textView6, new Function0() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SharedCollectionsActivity.updateSharedCollections$lambda$6(this.f$0, mTSharedCollection, mTSharedCollectionMember);
                            }
                        });
                        frameLayout.addView(textView6);
                        linearLayout4.addView(frameLayout);
                    } else {
                        linearLayout4.addView(viewBuildMemberAvatarView);
                    }
                    i = 0;
                    i2 = 12;
                }
                linearLayout3.addView(linearLayout4);
                LinearLayout linearLayout5 = this.sharedCollectionsContainer;
                if (linearLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedCollectionsContainer");
                    linearLayout5 = null;
                }
                linearLayout5.addView(linearLayout3);
                i = 0;
            }
        }
    }

    static final Unit updateSharedCollections$lambda$6(SharedCollectionsActivity sharedCollectionsActivity, MTSharedCollection mTSharedCollection, MTSharedCollectionMember mTSharedCollectionMember) {
        int id = mTSharedCollection.getId();
        int id2 = mTSharedCollectionMember.getId();
        String firstname = mTSharedCollectionMember.getFirstname();
        if (firstname == null && (firstname = mTSharedCollectionMember.getUsername()) == null) {
            firstname = "";
        }
        sharedCollectionsActivity.confirmUnshare(id, id2, firstname);
        return Unit.INSTANCE;
    }

    @Override // com.studiolaganne.lengendarylens.PendingInviteActionListener
    public void onAcceptInvite(int inviteId) {
        if (this.currentUserId == -1) {
            return;
        }
        ConstraintLayout constraintLayout = this.overlay;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlay");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        MTApiKt.getMtApi().acceptSharedCollectionInvite(this.currentUserId, inviteId).enqueue(new Callback<MTSharedCollectionAcceptResponse>() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity.onAcceptInvite.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSharedCollectionAcceptResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                Toast.makeText(SharedCollectionsActivity.this, R.string.invite_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSharedCollectionAcceptResponse> call, Response<MTSharedCollectionAcceptResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                boolean zIsSuccessful = response.isSuccessful();
                SharedCollectionsActivity sharedCollectionsActivity = SharedCollectionsActivity.this;
                if (!zIsSuccessful) {
                    sharedCollectionsActivity.showApiError(response);
                    return;
                }
                Toast.makeText(sharedCollectionsActivity, R.string.accept_invite_success, 0).show();
                SharedCollectionsActivity.this.fetchSharedCollections();
                PreferencesManager preferencesManager = new PreferencesManager(SharedCollectionsActivity.this);
                preferencesManager.incrementCollectionVersion();
                preferencesManager.incrementListsVersion();
                preferencesManager.incrementAllContainerVersions();
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.PendingInviteActionListener
    public void onAcceptUnshare(int collectionId) {
        if (this.currentUserId == -1) {
            return;
        }
        ConstraintLayout constraintLayout = this.overlay;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlay");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        MTApiKt.getMtApi().acceptUnshare(this.currentUserId, collectionId).enqueue(new Callback<MTSuccessResponse>() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity.onAcceptUnshare.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSuccessResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                Toast.makeText(SharedCollectionsActivity.this, R.string.invite_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSuccessResponse> call, Response<MTSuccessResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                boolean zIsSuccessful = response.isSuccessful();
                SharedCollectionsActivity sharedCollectionsActivity = SharedCollectionsActivity.this;
                if (!zIsSuccessful) {
                    sharedCollectionsActivity.showApiError(response);
                    return;
                }
                Toast.makeText(sharedCollectionsActivity, R.string.accept_unshare_success, 0).show();
                SharedCollectionsActivity.this.fetchSharedCollections();
                PreferencesManager preferencesManager = new PreferencesManager(SharedCollectionsActivity.this);
                preferencesManager.incrementCollectionVersion();
                preferencesManager.incrementListsVersion();
                preferencesManager.incrementAllContainerVersions();
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.PendingInviteActionListener
    public void onCancelInvite(int inviteId) {
        if (this.currentUserId == -1) {
            return;
        }
        ConstraintLayout constraintLayout = this.overlay;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlay");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        MTApiKt.getMtApi().rejectSharedCollectionInvite(this.currentUserId, inviteId).enqueue(new Callback<MTSuccessResponse>() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity.onCancelInvite.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSuccessResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                Toast.makeText(SharedCollectionsActivity.this, R.string.invite_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSuccessResponse> call, Response<MTSuccessResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                boolean zIsSuccessful = response.isSuccessful();
                SharedCollectionsActivity sharedCollectionsActivity = SharedCollectionsActivity.this;
                if (!zIsSuccessful) {
                    sharedCollectionsActivity.showApiError(response);
                } else {
                    Toast.makeText(sharedCollectionsActivity, R.string.cancel_invitation_success, 0).show();
                    SharedCollectionsActivity.this.fetchSharedCollections();
                }
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.PendingInviteActionListener
    public void onCancelUnshare(int collectionId) {
        if (this.currentUserId == -1) {
            return;
        }
        ConstraintLayout constraintLayout = this.overlay;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlay");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        MTApiKt.getMtApi().cancelUnshare(this.currentUserId, collectionId).enqueue(new Callback<MTSuccessResponse>() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity.onCancelUnshare.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSuccessResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                Toast.makeText(SharedCollectionsActivity.this, R.string.invite_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSuccessResponse> call, Response<MTSuccessResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                boolean zIsSuccessful = response.isSuccessful();
                SharedCollectionsActivity sharedCollectionsActivity = SharedCollectionsActivity.this;
                if (!zIsSuccessful) {
                    sharedCollectionsActivity.showApiError(response);
                } else {
                    Toast.makeText(sharedCollectionsActivity, R.string.cancel_unshare_success, 0).show();
                    SharedCollectionsActivity.this.fetchSharedCollections();
                }
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_collections);
        SharedCollectionsActivity sharedCollectionsActivity = this;
        PreferencesManager preferencesManager = new PreferencesManager(sharedCollectionsActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        this.currentUserId = currentUser != null ? currentUser.getId() : -1;
        preferencesManager.setInt(PreferencesManager.SHARED_COLLECTION_BADGE_COUNT, 0);
        View viewFindViewById = findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.overlay = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.backLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SharedCollectionsActivity.onCreate$lambda$0(this.f$0);
            }
        });
        View viewFindViewById3 = findViewById(R.id.inviteButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SharedCollectionsActivity.onCreate$lambda$1(this.f$0);
            }
        });
        View viewFindViewById4 = findViewById(R.id.pendingInvitesSection);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.pendingInvitesSection = (LinearLayout) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.pendingInvitesRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.pendingInvitesRecyclerView = (RecyclerView) viewFindViewById5;
        this.pendingInviteAdapter = new PendingInviteAdapter(this.currentUserId, this);
        RecyclerView recyclerView = this.pendingInvitesRecyclerView;
        BroadcastReceiver broadcastReceiver = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pendingInvitesRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(sharedCollectionsActivity));
        RecyclerView recyclerView2 = this.pendingInvitesRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pendingInvitesRecyclerView");
            recyclerView2 = null;
        }
        PendingInviteAdapter pendingInviteAdapter = this.pendingInviteAdapter;
        if (pendingInviteAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pendingInviteAdapter");
            pendingInviteAdapter = null;
        }
        recyclerView2.setAdapter(pendingInviteAdapter);
        View viewFindViewById6 = findViewById(R.id.sharedCollectionsSection);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.sharedCollectionsSection = (LinearLayout) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.sharedCollectionsContainer);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.sharedCollectionsContainer = (LinearLayout) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.noSharedCollectionsText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.noSharedCollectionsText = (TextView) viewFindViewById8;
        this.fcmReceiver = new BroadcastReceiver() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity.onCreate.3
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String stringExtra = intent != null ? intent.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE) : null;
                if (stringExtra != null) {
                    switch (stringExtra.hashCode()) {
                        case -1814490512:
                            if (!stringExtra.equals(PreferencesManager.MSG_TYPE_SHARED_COLLECTION_INVITE)) {
                                return;
                            }
                            break;
                        case -1208568283:
                            if (!stringExtra.equals(PreferencesManager.MSG_TYPE_SHARED_COLLECTION_REJECTED)) {
                                return;
                            }
                            break;
                        case -517166289:
                            if (!stringExtra.equals(PreferencesManager.MSG_TYPE_UNSHARE_COLLECTION_ACCEPTED)) {
                                return;
                            }
                            break;
                        case 610173073:
                            if (!stringExtra.equals(PreferencesManager.MSG_TYPE_UNSHARE_COLLECTION_INVITE)) {
                                return;
                            }
                            break;
                        case 1020862470:
                            if (!stringExtra.equals(PreferencesManager.MSG_TYPE_UNSHARE_COLLECTION_REJECTED)) {
                                return;
                            }
                            break;
                        case 1548370254:
                            if (!stringExtra.equals(PreferencesManager.MSG_TYPE_SHARED_COLLECTION_ACCEPTED)) {
                                return;
                            }
                            break;
                        default:
                            return;
                    }
                    SharedCollectionsActivity.this.fetchSharedCollections();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(PreferencesManager.MESSAGE_INTENT);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(sharedCollectionsActivity);
        BroadcastReceiver broadcastReceiver2 = this.fcmReceiver;
        if (broadcastReceiver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fcmReceiver");
        } else {
            broadcastReceiver = broadcastReceiver2;
        }
        localBroadcastManager.registerReceiver(broadcastReceiver, intentFilter);
        fetchSharedCollections();
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

    @Override // com.studiolaganne.lengendarylens.PendingInviteActionListener
    public void onRejectInvite(int inviteId) {
        if (this.currentUserId == -1) {
            return;
        }
        ConstraintLayout constraintLayout = this.overlay;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlay");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        MTApiKt.getMtApi().rejectSharedCollectionInvite(this.currentUserId, inviteId).enqueue(new Callback<MTSuccessResponse>() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity.onRejectInvite.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSuccessResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                Toast.makeText(SharedCollectionsActivity.this, R.string.invite_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSuccessResponse> call, Response<MTSuccessResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                boolean zIsSuccessful = response.isSuccessful();
                SharedCollectionsActivity sharedCollectionsActivity = SharedCollectionsActivity.this;
                if (!zIsSuccessful) {
                    sharedCollectionsActivity.showApiError(response);
                } else {
                    Toast.makeText(sharedCollectionsActivity, R.string.reject_invite_success, 0).show();
                    SharedCollectionsActivity.this.fetchSharedCollections();
                }
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.PendingInviteActionListener
    public void onRejectUnshare(int collectionId) {
        if (this.currentUserId == -1) {
            return;
        }
        ConstraintLayout constraintLayout = this.overlay;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlay");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        MTApiKt.getMtApi().cancelUnshare(this.currentUserId, collectionId).enqueue(new Callback<MTSuccessResponse>() { // from class: com.studiolaganne.lengendarylens.SharedCollectionsActivity.onRejectUnshare.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSuccessResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                Toast.makeText(SharedCollectionsActivity.this, R.string.invite_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSuccessResponse> call, Response<MTSuccessResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (SharedCollectionsActivity.this.isFinishing() || SharedCollectionsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = SharedCollectionsActivity.this.overlay;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("overlay");
                    constraintLayout2 = null;
                }
                constraintLayout2.setVisibility(8);
                boolean zIsSuccessful = response.isSuccessful();
                SharedCollectionsActivity sharedCollectionsActivity = SharedCollectionsActivity.this;
                if (!zIsSuccessful) {
                    sharedCollectionsActivity.showApiError(response);
                } else {
                    Toast.makeText(sharedCollectionsActivity, R.string.reject_unshare_success, 0).show();
                    SharedCollectionsActivity.this.fetchSharedCollections();
                }
            }
        });
    }
}
