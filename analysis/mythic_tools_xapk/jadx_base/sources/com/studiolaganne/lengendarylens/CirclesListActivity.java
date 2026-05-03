package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CirclesListActivity;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.util.ArrayList;
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

/* JADX INFO: compiled from: CirclesListActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0016\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0012\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u000fH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/CirclesListActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "Lcom/studiolaganne/lengendarylens/CirclesListClickListener;", "Lcom/studiolaganne/lengendarylens/CreateCircleCallback;", "Lcom/studiolaganne/lengendarylens/EditCircleCallback;", "<init>", "()V", "circles", "", "Lcom/studiolaganne/lengendarylens/MTCircle;", "adapter", "Lcom/studiolaganne/lengendarylens/CirclesListAdapter;", "emptyState", "Landroid/widget/TextView;", "updateCircles", "", "newCircles", "onCircleTap", "circle", "onCircleDelete", "performDeleteCircle", "onCircleCreated", "onCircleEdited", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "fetchCircles", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CirclesListActivity extends BaseActivity implements CirclesListClickListener, CreateCircleCallback, EditCircleCallback {
    public static final int $stable = 8;
    private CirclesListAdapter adapter;
    private List<MTCircle> circles = CollectionsKt.emptyList();
    private TextView emptyState;

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CirclesListActivity$performDeleteCircle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CirclesListActivity.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/CirclesListActivity$performDeleteCircle$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTCirclesResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C11321 implements Callback<MTCirclesResponse> {
        final /* synthetic */ ConstraintLayout $overlay;

        C11321(ConstraintLayout constraintLayout) {
            this.$overlay = constraintLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$0$0$0(boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<MTCirclesResponse> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            if (CirclesListActivity.this.isFinishing() || CirclesListActivity.this.isDestroyed()) {
                return;
            }
            this.$overlay.setVisibility(8);
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<MTCirclesResponse> call, Response<MTCirclesResponse> response) {
            List<MTCircle> listEmptyList;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (CirclesListActivity.this.isFinishing() || CirclesListActivity.this.isDestroyed()) {
                return;
            }
            if (response.isSuccessful()) {
                MTCirclesResponse mTCirclesResponseBody = response.body();
                if (mTCirclesResponseBody == null || (listEmptyList = mTCirclesResponseBody.getCircles()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                CirclesListActivity.this.updateCircles(listEmptyList);
            } else {
                ResponseBody responseBodyErrorBody = response.errorBody();
                String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
                if (strString != null) {
                    CirclesListActivity circlesListActivity = CirclesListActivity.this;
                    MTResponse mTResponse = (MTResponse) new Gson().fromJson(strString, MTResponse.class);
                    if (mTResponse != null) {
                        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                        String string = circlesListActivity.getString(R.string.server_error);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
                        String string2 = circlesListActivity.getString(R.string.ok);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.CirclesListActivity$performDeleteCircle$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CirclesListActivity.C11321.onResponse$lambda$0$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                            }
                        });
                        FragmentManager supportFragmentManager = circlesListActivity.getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                        positiveButton.show(supportFragmentManager, "mtapi_error_dialog");
                    }
                }
            }
            this.$overlay.setVisibility(8);
        }
    }

    private final void fetchCircles() {
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        if (currentUser == null) {
            return;
        }
        final ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
        constraintLayout.setVisibility(0);
        MTApiKt.getMtApi().getCircles(currentUser.getId()).enqueue(new Callback<MTCirclesResponse>() { // from class: com.studiolaganne.lengendarylens.CirclesListActivity.fetchCircles.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCirclesResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (CirclesListActivity.this.isFinishing() || CirclesListActivity.this.isDestroyed()) {
                    return;
                }
                constraintLayout.setVisibility(8);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCirclesResponse> call, Response<MTCirclesResponse> response) {
                List<MTCircle> listEmptyList;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (CirclesListActivity.this.isFinishing() || CirclesListActivity.this.isDestroyed()) {
                    return;
                }
                if (response.isSuccessful()) {
                    MTCirclesResponse mTCirclesResponseBody = response.body();
                    if (mTCirclesResponseBody == null || (listEmptyList = mTCirclesResponseBody.getCircles()) == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    CirclesListActivity.this.updateCircles(listEmptyList);
                }
                constraintLayout.setVisibility(8);
            }
        });
    }

    static final Unit onCircleDelete$lambda$0(CirclesListActivity circlesListActivity, MTCircle mTCircle, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        circlesListActivity.performDeleteCircle(mTCircle);
        return Unit.INSTANCE;
    }

    static final Unit onCircleDelete$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$0(CirclesListActivity circlesListActivity) {
        circlesListActivity.finish();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$2(CirclesListActivity circlesListActivity) {
        if (circlesListActivity.isDestroyed() || circlesListActivity.isFinishing()) {
            return Unit.INSTANCE;
        }
        MTUser currentUser = new PreferencesManager(circlesListActivity).getCurrentUser();
        if (currentUser == null) {
            return Unit.INSTANCE;
        }
        new CreateCircleBottomSheetFragment(circlesListActivity, currentUser).show(circlesListActivity.getSupportFragmentManager(), CreateCircleBottomSheetFragment.TAG);
        return Unit.INSTANCE;
    }

    private final void performDeleteCircle(MTCircle circle) {
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        if (currentUser == null) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
        constraintLayout.setVisibility(0);
        MTApiKt.getMtApi().deleteCircle(currentUser.getId(), circle.getId()).enqueue(new C11321(constraintLayout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCircles(List<MTCircle> newCircles) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : newCircles) {
            if (!Intrinsics.areEqual((Object) ((MTCircle) obj).is_auto_created(), (Object) true)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        this.circles = arrayList2;
        CirclesListAdapter circlesListAdapter = this.adapter;
        TextView textView = null;
        if (circlesListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            circlesListAdapter = null;
        }
        circlesListAdapter.updateCircles(arrayList2);
        TextView textView2 = this.emptyState;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyState");
        } else {
            textView = textView2;
        }
        textView.setVisibility(arrayList2.isEmpty() ? 0 : 8);
    }

    @Override // com.studiolaganne.lengendarylens.CreateCircleCallback
    public void onCircleCreated(List<MTCircle> circles) {
        Intrinsics.checkNotNullParameter(circles, "circles");
        updateCircles(circles);
    }

    @Override // com.studiolaganne.lengendarylens.CirclesListClickListener
    public void onCircleDelete(final MTCircle circle) {
        Intrinsics.checkNotNullParameter(circle, "circle");
        String name = circle.getName();
        if (name == null) {
            name = "";
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.delete_circle_confirm_body, new Object[]{name});
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = getString(R.string.delete);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.CirclesListActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CirclesListActivity.onCircleDelete$lambda$0(this.f$0, circle, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.CirclesListActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CirclesListActivity.onCircleDelete$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        negativeButton.show(supportFragmentManager, "delete_circle_dialog");
    }

    @Override // com.studiolaganne.lengendarylens.EditCircleCallback
    public void onCircleEdited(List<MTCircle> circles) {
        Intrinsics.checkNotNullParameter(circles, "circles");
        updateCircles(circles);
    }

    @Override // com.studiolaganne.lengendarylens.CirclesListClickListener
    public void onCircleTap(MTCircle circle) {
        Intrinsics.checkNotNullParameter(circle, "circle");
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        if (currentUser == null) {
            return;
        }
        CreateCircleBottomSheetFragment.INSTANCE.newEditInstance(this, currentUser, circle).show(getSupportFragmentManager(), CreateCircleBottomSheetFragment.TAG);
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circles_list);
        View viewFindViewById = findViewById(R.id.backLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.CirclesListActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CirclesListActivity.onCreate$lambda$0(this.f$0);
            }
        });
        CirclesListActivity circlesListActivity = this;
        TextView textView = new TextView(circlesListActivity);
        textView.setText(getString(R.string.no_circles));
        textView.setTextColor(textView.getResources().getColor(R.color.text_color, getTheme()));
        textView.setTextSize(14.0f);
        textView.setTypeface(textView.getResources().getFont(R.font.be_vietnam_pro_semibold));
        textView.setVisibility(8);
        textView.setPadding(0, 60, 0, 0);
        textView.setTextAlignment(4);
        this.emptyState = textView;
        View viewFindViewById2 = findViewById(R.id.circlesRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById2;
        recyclerView.setLayoutManager(new LinearLayoutManager(circlesListActivity));
        CirclesListAdapter circlesListAdapter = new CirclesListAdapter(this.circles, this);
        this.adapter = circlesListAdapter;
        recyclerView.setAdapter(circlesListAdapter);
        ViewParent parent = recyclerView.getParent();
        TextView textView2 = null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            TextView textView3 = this.emptyState;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyState");
            } else {
                textView2 = textView3;
            }
            viewGroup.addView(textView2, viewGroup.indexOfChild(recyclerView) + 1);
        }
        View viewFindViewById3 = findViewById(R.id.createButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.CirclesListActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CirclesListActivity.onCreate$lambda$2(this.f$0);
            }
        });
        fetchCircles();
    }
}
