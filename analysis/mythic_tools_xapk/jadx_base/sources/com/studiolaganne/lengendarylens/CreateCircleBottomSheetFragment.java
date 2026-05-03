package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: CreateCircleBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\rJ&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010%\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020+H\u0002J\u0018\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u000fH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/studiolaganne/lengendarylens/CreateCircleBottomSheetFragment;", "Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "createCallback", "Lcom/studiolaganne/lengendarylens/CreateCircleCallback;", "editCallback", "Lcom/studiolaganne/lengendarylens/EditCircleCallback;", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "editingCircle", "Lcom/studiolaganne/lengendarylens/MTCircle;", "<init>", "(Lcom/studiolaganne/lengendarylens/CreateCircleCallback;Lcom/studiolaganne/lengendarylens/EditCircleCallback;Lcom/studiolaganne/lengendarylens/MTUser;Lcom/studiolaganne/lengendarylens/MTCircle;)V", "callback", "(Lcom/studiolaganne/lengendarylens/CreateCircleCallback;Lcom/studiolaganne/lengendarylens/MTUser;)V", "isEditMode", "", "()Z", "circleName", "", "circleDescription", "friendsAdapter", "Lcom/studiolaganne/lengendarylens/SelectableFriendsAdapter;", "playgroupsAdapter", "Lcom/studiolaganne/lengendarylens/SelectablePlaygroupsAdapter;", "currentTab", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "showApiError", "errorBody", "updateSubmitButtonState", "submitButton", "Landroidx/constraintlayout/widget/ConstraintLayout;", "submitText", "Landroid/widget/TextView;", "updateTabStyles", "tabFriends", "tabPlaygroups", "updateEmptyState", "emptyStateText", "isEmpty", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateCircleBottomSheetFragment extends TransparentBottomSheet {
    private static final int TAB_FRIENDS = 0;
    private static final int TAB_PLAYGROUPS = 1;
    public static final String TAG = "CreateCircleBottomSheetFragment";
    private String circleDescription;
    private String circleName;
    private final CreateCircleCallback createCallback;
    private int currentTab;
    private final EditCircleCallback editCallback;
    private final MTCircle editingCircle;
    private SelectableFriendsAdapter friendsAdapter;
    private SelectablePlaygroupsAdapter playgroupsAdapter;
    private final MTUser user;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CreateCircleBottomSheetFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/CreateCircleBottomSheetFragment$Companion;", "", "<init>", "()V", "TAG", "", "TAB_FRIENDS", "", "TAB_PLAYGROUPS", "newEditInstance", "Lcom/studiolaganne/lengendarylens/CreateCircleBottomSheetFragment;", "callback", "Lcom/studiolaganne/lengendarylens/EditCircleCallback;", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "circle", "Lcom/studiolaganne/lengendarylens/MTCircle;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CreateCircleBottomSheetFragment newEditInstance(EditCircleCallback callback, MTUser user, MTCircle circle) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(circle, "circle");
            return new CreateCircleBottomSheetFragment(null, callback, user, circle);
        }
    }

    public CreateCircleBottomSheetFragment(CreateCircleCallback createCircleCallback, EditCircleCallback editCircleCallback, MTUser user, MTCircle mTCircle) {
        Intrinsics.checkNotNullParameter(user, "user");
        this.createCallback = createCircleCallback;
        this.editCallback = editCircleCallback;
        this.user = user;
        this.editingCircle = mTCircle;
        this.circleName = "";
        this.circleDescription = "";
    }

    public /* synthetic */ CreateCircleBottomSheetFragment(CreateCircleCallback createCircleCallback, EditCircleCallback editCircleCallback, MTUser mTUser, MTCircle mTCircle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : createCircleCallback, (i & 2) != 0 ? null : editCircleCallback, mTUser, (i & 8) != 0 ? null : mTCircle);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreateCircleBottomSheetFragment(CreateCircleCallback callback, MTUser user) {
        this(callback, null, user, null);
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(user, "user");
    }

    private final boolean isEditMode() {
        return this.editingCircle != null;
    }

    static final Unit onViewCreated$lambda$1(CreateCircleBottomSheetFragment createCircleBottomSheetFragment) {
        createCircleBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$5(CreateCircleBottomSheetFragment createCircleBottomSheetFragment, TextView textView, TextView textView2, EditText editText, RecyclerView recyclerView, TextView textView3, List list) {
        if (createCircleBottomSheetFragment.currentTab != 0) {
            createCircleBottomSheetFragment.currentTab = 0;
            createCircleBottomSheetFragment.updateTabStyles(textView, textView2);
            editText.setText("");
            editText.setHint(createCircleBottomSheetFragment.getString(R.string.search_friends_hint));
            SelectableFriendsAdapter selectableFriendsAdapter = createCircleBottomSheetFragment.friendsAdapter;
            if (selectableFriendsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendsAdapter");
                selectableFriendsAdapter = null;
            }
            recyclerView.setAdapter(selectableFriendsAdapter);
            createCircleBottomSheetFragment.updateEmptyState(textView3, list.isEmpty());
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$6(CreateCircleBottomSheetFragment createCircleBottomSheetFragment, TextView textView, TextView textView2, EditText editText, RecyclerView recyclerView, TextView textView3, List list) {
        if (createCircleBottomSheetFragment.currentTab != 1) {
            createCircleBottomSheetFragment.currentTab = 1;
            createCircleBottomSheetFragment.updateTabStyles(textView, textView2);
            editText.setText("");
            editText.setHint(createCircleBottomSheetFragment.getString(R.string.search_playgroups_hint));
            SelectablePlaygroupsAdapter selectablePlaygroupsAdapter = createCircleBottomSheetFragment.playgroupsAdapter;
            if (selectablePlaygroupsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playgroupsAdapter");
                selectablePlaygroupsAdapter = null;
            }
            recyclerView.setAdapter(selectablePlaygroupsAdapter);
            createCircleBottomSheetFragment.updateEmptyState(textView3, list.isEmpty());
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$7(final CreateCircleBottomSheetFragment createCircleBottomSheetFragment, final View view) {
        if (createCircleBottomSheetFragment.getContext() != null && createCircleBottomSheetFragment.circleName.length() != 0) {
            ((ConstraintLayout) view.findViewById(R.id.overlay)).setVisibility(0);
            SelectableFriendsAdapter selectableFriendsAdapter = createCircleBottomSheetFragment.friendsAdapter;
            if (selectableFriendsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendsAdapter");
                selectableFriendsAdapter = null;
            }
            List<Integer> selectedIds = selectableFriendsAdapter.getSelectedIds();
            if (selectedIds.isEmpty()) {
                selectedIds = null;
            }
            List<Integer> list = selectedIds;
            SelectablePlaygroupsAdapter selectablePlaygroupsAdapter = createCircleBottomSheetFragment.playgroupsAdapter;
            if (selectablePlaygroupsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playgroupsAdapter");
                selectablePlaygroupsAdapter = null;
            }
            List<Integer> selectedIds2 = selectablePlaygroupsAdapter.getSelectedIds();
            if (selectedIds2.isEmpty()) {
                selectedIds2 = null;
            }
            List<Integer> list2 = selectedIds2;
            if (createCircleBottomSheetFragment.isEditMode()) {
                String str = createCircleBottomSheetFragment.circleName;
                String str2 = createCircleBottomSheetFragment.circleDescription;
                MTEditCircleBody mTEditCircleBody = new MTEditCircleBody(str, str2.length() != 0 ? str2 : null, new MTEditCircleMembersBody(list, list2));
                MTApi mtApi = MTApiKt.getMtApi();
                int id = createCircleBottomSheetFragment.user.getId();
                MTCircle mTCircle = createCircleBottomSheetFragment.editingCircle;
                Intrinsics.checkNotNull(mTCircle);
                mtApi.editCircle(id, mTCircle.getId(), mTEditCircleBody).enqueue(new Callback<MTCirclesResponse>() { // from class: com.studiolaganne.lengendarylens.CreateCircleBottomSheetFragment$onViewCreated$10$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCirclesResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        ((ConstraintLayout) view.findViewById(R.id.overlay)).setVisibility(8);
                        this.this$0.dismiss();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCirclesResponse> call, Response<MTCirclesResponse> response) {
                        List<MTCircle> listEmptyList;
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (!response.isSuccessful()) {
                            CreateCircleBottomSheetFragment createCircleBottomSheetFragment2 = this.this$0;
                            ResponseBody responseBodyErrorBody = response.errorBody();
                            createCircleBottomSheetFragment2.showApiError(responseBodyErrorBody != null ? responseBodyErrorBody.string() : null);
                            ((ConstraintLayout) view.findViewById(R.id.overlay)).setVisibility(8);
                            return;
                        }
                        MTCirclesResponse mTCirclesResponseBody = response.body();
                        if (mTCirclesResponseBody == null || (listEmptyList = mTCirclesResponseBody.getCircles()) == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        EditCircleCallback editCircleCallback = this.this$0.editCallback;
                        if (editCircleCallback != null) {
                            editCircleCallback.onCircleEdited(listEmptyList);
                        }
                        this.this$0.dismiss();
                    }
                });
            } else {
                String str3 = createCircleBottomSheetFragment.circleName;
                String str4 = createCircleBottomSheetFragment.circleDescription;
                MTApiKt.getMtApi().createCircle(createCircleBottomSheetFragment.user.getId(), new MTCreateCircleBody(str3, str4.length() != 0 ? str4 : null, list, list2)).enqueue(new Callback<MTCirclesResponse>() { // from class: com.studiolaganne.lengendarylens.CreateCircleBottomSheetFragment$onViewCreated$10$2
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCirclesResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        ((ConstraintLayout) view.findViewById(R.id.overlay)).setVisibility(8);
                        this.this$0.dismiss();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCirclesResponse> call, Response<MTCirclesResponse> response) {
                        List<MTCircle> listEmptyList;
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (!response.isSuccessful()) {
                            CreateCircleBottomSheetFragment createCircleBottomSheetFragment2 = this.this$0;
                            ResponseBody responseBodyErrorBody = response.errorBody();
                            createCircleBottomSheetFragment2.showApiError(responseBodyErrorBody != null ? responseBodyErrorBody.string() : null);
                            ((ConstraintLayout) view.findViewById(R.id.overlay)).setVisibility(8);
                            return;
                        }
                        MTCirclesResponse mTCirclesResponseBody = response.body();
                        if (mTCirclesResponseBody == null || (listEmptyList = mTCirclesResponseBody.getCircles()) == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        CreateCircleCallback createCircleCallback = this.this$0.createCallback;
                        if (createCircleCallback != null) {
                            createCircleCallback.onCircleCreated(listEmptyList);
                        }
                        this.this$0.dismiss();
                    }
                });
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showApiError(String errorBody) {
        MTResponse mTResponse;
        if (errorBody == null || (mTResponse = (MTResponse) new Gson().fromJson(errorBody, MTResponse.class)) == null) {
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.server_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
        String string2 = getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.CreateCircleBottomSheetFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CreateCircleBottomSheetFragment.showApiError$lambda$0$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "mtapi_error_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showApiError$lambda$0$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEmptyState(TextView emptyStateText, boolean isEmpty) {
        emptyStateText.setVisibility(isEmpty ? 0 : 8);
        emptyStateText.setText(this.currentTab == 0 ? getString(R.string.no_friends_to_add) : getString(R.string.no_playgroups_to_add));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSubmitButtonState(ConstraintLayout submitButton, TextView submitText) {
        submitButton.setEnabled(this.circleName.length() > 0);
        float f = submitButton.isEnabled() ? 1.0f : 0.5f;
        submitButton.setAlpha(f);
        submitText.setAlpha(f);
    }

    private final void updateTabStyles(TextView tabFriends, TextView tabPlaygroups) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        int color = ContextCompat.getColor(context, R.color.selected_color_new);
        int color2 = ContextCompat.getColor(context, R.color.text_color);
        if (this.currentTab == 0) {
            tabFriends.setTextColor(color);
            tabFriends.getPaint().setUnderlineText(true);
            tabPlaygroups.setTextColor(color2);
            tabPlaygroups.getPaint().setUnderlineText(false);
        } else {
            tabPlaygroups.setTextColor(color);
            tabPlaygroups.getPaint().setUnderlineText(true);
            tabFriends.setTextColor(color2);
            tabFriends.getPaint().setUnderlineText(false);
        }
        tabFriends.invalidate();
        tabPlaygroups.invalidate();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.bottom_sheet_circle, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        MTCircleMembers members;
        List<MTCirclePlaygroup> playgroups;
        MTCircleMembers members2;
        List<MTPrivacyUser> users;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context context = getContext();
        if (context == null) {
            return;
        }
        PreferencesManager preferencesManager = new PreferencesManager(context);
        TextView textView = (TextView) view.findViewById(R.id.sheetTitle);
        EditText editText = (EditText) view.findViewById(R.id.playgroupName);
        EditText editText2 = (EditText) view.findViewById(R.id.playgroupDescription);
        View viewFindViewById = view.findViewById(R.id.createButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.createButtonText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final TextView textView2 = (TextView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tabFriends);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        final TextView textView3 = (TextView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.tabPlaygroups);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        final TextView textView4 = (TextView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.searchEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        final EditText editText3 = (EditText) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.membersRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        final RecyclerView recyclerView = (RecyclerView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.emptyStateText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        final TextView textView5 = (TextView) viewFindViewById7;
        if (isEditMode()) {
            textView.setText(getString(R.string.edit_circle));
            textView2.setText(getString(R.string.edit_circle_button));
            MTCircle mTCircle = this.editingCircle;
            if (mTCircle != null) {
                String name = mTCircle.getName();
                if (name == null) {
                    name = "";
                }
                this.circleName = name;
                String description = mTCircle.getDescription();
                if (description == null) {
                    description = "";
                }
                this.circleDescription = description;
                editText.setText(this.circleName);
                editText2.setText(this.circleDescription);
            }
        }
        updateSubmitButtonState(constraintLayout, textView2);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.CreateCircleBottomSheetFragment.onViewCreated.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CreateCircleBottomSheetFragment.this.circleName = StringsKt.trim((CharSequence) String.valueOf(s)).toString();
                CreateCircleBottomSheetFragment.this.updateSubmitButtonState(constraintLayout, textView2);
            }
        });
        editText2.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.CreateCircleBottomSheetFragment.onViewCreated.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CreateCircleBottomSheetFragment.this.circleDescription = StringsKt.trim((CharSequence) String.valueOf(s)).toString();
            }
        });
        View viewFindViewById8 = view.findViewById(R.id.chevron_down);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById8, new Function0() { // from class: com.studiolaganne.lengendarylens.CreateCircleBottomSheetFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CreateCircleBottomSheetFragment.onViewCreated$lambda$1(this.f$0);
            }
        });
        List<MTFriend> currentUserFriends = preferencesManager.getCurrentUserFriends();
        ArrayList arrayList = new ArrayList();
        for (Object obj : currentUserFriends) {
            if (Intrinsics.areEqual(((MTFriend) obj).getStatus(), "accepted")) {
                arrayList.add(obj);
            }
        }
        final ArrayList arrayList2 = arrayList;
        final List<MTPlaygroup> currentUserPlaygroups = preferencesManager.getCurrentUserPlaygroups();
        this.friendsAdapter = new SelectableFriendsAdapter(arrayList2);
        this.playgroupsAdapter = new SelectablePlaygroupsAdapter(currentUserPlaygroups);
        SelectableFriendsAdapter selectableFriendsAdapter = null;
        if (isEditMode()) {
            MTCircle mTCircle2 = this.editingCircle;
            if (mTCircle2 != null && (members2 = mTCircle2.getMembers()) != null && (users = members2.getUsers()) != null) {
                for (MTPrivacyUser mTPrivacyUser : users) {
                    SelectableFriendsAdapter selectableFriendsAdapter2 = this.friendsAdapter;
                    if (selectableFriendsAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("friendsAdapter");
                        selectableFriendsAdapter2 = null;
                    }
                    selectableFriendsAdapter2.m11240getSelectedIds().add(Integer.valueOf(mTPrivacyUser.getId()));
                }
            }
            MTCircle mTCircle3 = this.editingCircle;
            if (mTCircle3 != null && (members = mTCircle3.getMembers()) != null && (playgroups = members.getPlaygroups()) != null) {
                for (MTCirclePlaygroup mTCirclePlaygroup : playgroups) {
                    SelectablePlaygroupsAdapter selectablePlaygroupsAdapter = this.playgroupsAdapter;
                    if (selectablePlaygroupsAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("playgroupsAdapter");
                        selectablePlaygroupsAdapter = null;
                    }
                    selectablePlaygroupsAdapter.m11241getSelectedIds().add(Integer.valueOf(mTCirclePlaygroup.getId()));
                }
            }
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        SelectableFriendsAdapter selectableFriendsAdapter3 = this.friendsAdapter;
        if (selectableFriendsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendsAdapter");
        } else {
            selectableFriendsAdapter = selectableFriendsAdapter3;
        }
        recyclerView.setAdapter(selectableFriendsAdapter);
        updateEmptyState(textView5, arrayList2.isEmpty());
        ViewExtensionsKt.setOnClickWithFade(textView3, new Function0() { // from class: com.studiolaganne.lengendarylens.CreateCircleBottomSheetFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CreateCircleBottomSheetFragment.onViewCreated$lambda$5(this.f$0, textView3, textView4, editText3, recyclerView, textView5, arrayList2);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(textView4, new Function0() { // from class: com.studiolaganne.lengendarylens.CreateCircleBottomSheetFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CreateCircleBottomSheetFragment.onViewCreated$lambda$6(this.f$0, textView3, textView4, editText3, recyclerView, textView5, currentUserPlaygroups);
            }
        });
        editText3.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.CreateCircleBottomSheetFragment.onViewCreated.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = StringsKt.trim((CharSequence) String.valueOf(s)).toString();
                int i = CreateCircleBottomSheetFragment.this.currentTab;
                CreateCircleBottomSheetFragment createCircleBottomSheetFragment = CreateCircleBottomSheetFragment.this;
                RecyclerView.Adapter adapter = null;
                if (i == 0) {
                    SelectableFriendsAdapter selectableFriendsAdapter4 = createCircleBottomSheetFragment.friendsAdapter;
                    if (selectableFriendsAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("friendsAdapter");
                        selectableFriendsAdapter4 = null;
                    }
                    selectableFriendsAdapter4.filter(string);
                    CreateCircleBottomSheetFragment createCircleBottomSheetFragment2 = CreateCircleBottomSheetFragment.this;
                    TextView textView6 = textView5;
                    SelectableFriendsAdapter selectableFriendsAdapter5 = createCircleBottomSheetFragment2.friendsAdapter;
                    if (selectableFriendsAdapter5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("friendsAdapter");
                    } else {
                        adapter = selectableFriendsAdapter5;
                    }
                    createCircleBottomSheetFragment2.updateEmptyState(textView6, adapter.getItemCount() == 0);
                    return;
                }
                SelectablePlaygroupsAdapter selectablePlaygroupsAdapter2 = createCircleBottomSheetFragment.playgroupsAdapter;
                if (selectablePlaygroupsAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playgroupsAdapter");
                    selectablePlaygroupsAdapter2 = null;
                }
                selectablePlaygroupsAdapter2.filter(string);
                CreateCircleBottomSheetFragment createCircleBottomSheetFragment3 = CreateCircleBottomSheetFragment.this;
                TextView textView7 = textView5;
                SelectablePlaygroupsAdapter selectablePlaygroupsAdapter3 = createCircleBottomSheetFragment3.playgroupsAdapter;
                if (selectablePlaygroupsAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playgroupsAdapter");
                } else {
                    adapter = selectablePlaygroupsAdapter3;
                }
                createCircleBottomSheetFragment3.updateEmptyState(textView7, adapter.getItemCount() == 0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.CreateCircleBottomSheetFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CreateCircleBottomSheetFragment.onViewCreated$lambda$7(this.f$0, view);
            }
        });
    }
}
