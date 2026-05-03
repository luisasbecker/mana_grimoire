package com.studiolaganne.lengendarylens;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.common.MimeTypes;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.studiolaganne.lengendarylens.CustomDeleteDialogFragment;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.PlaygroupDetailsActivity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: PlaygroupDetailsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020$H\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\bH\u0016J\u0010\u00102\u001a\u00020-2\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020-2\u0006\u00106\u001a\u000204H\u0016J\u0010\u00107\u001a\u00020-2\u0006\u00108\u001a\u000204H\u0016J\u0010\u00109\u001a\u00020-2\u0006\u0010:\u001a\u000204H\u0016J\u0010\u0010;\u001a\u00020-2\u0006\u00108\u001a\u000204H\u0016J\u0010\u0010<\u001a\u00020-2\u0006\u00103\u001a\u000204H\u0016J\u0010\u0010=\u001a\u00020-2\u0006\u00103\u001a\u000204H\u0016J\u0010\u0010>\u001a\u00020-2\u0006\u00103\u001a\u000204H\u0002J\b\u0010?\u001a\u00020-H\u0002J\b\u0010@\u001a\u00020-H\u0002J\u0010\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020*H\u0002J\b\u0010C\u001a\u00020-H\u0014J\u0012\u0010D\u001a\u00020-2\b\u0010E\u001a\u0004\u0018\u00010FH\u0014J\u0018\u0010G\u001a\u00020&2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u00020&2\u0006\u0010%\u001a\u00020&H\u0002J \u0010M\u001a\u00020&2\u0006\u0010%\u001a\u00020&2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020OH\u0002J\u0006\u0010Q\u001a\u00020\u001bJ\b\u0010R\u001a\u00020-H\u0002J\b\u0010S\u001a\u00020-H\u0002J\b\u0010T\u001a\u00020-H\u0002R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006U"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupDetailsActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "Lcom/studiolaganne/lengendarylens/PlaygroupUserClickListener;", "Lcom/studiolaganne/lengendarylens/EditPlaygroupCallback;", "Lcom/studiolaganne/lengendarylens/InviteToPlaygroupCallback;", "<init>", "()V", "currentPlaygroup", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "getCurrentPlaygroup", "()Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "setCurrentPlaygroup", "(Lcom/studiolaganne/lengendarylens/MTPlaygroup;)V", "pickPhotoLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "fragmentList", "", "Landroidx/fragment/app/Fragment;", "msgReceiver", "Landroid/content/BroadcastReceiver;", "formatsForFilter", "", "Lcom/studiolaganne/lengendarylens/MTFormat;", "filterDefinition", "Lcom/studiolaganne/lengendarylens/FilterDefinition;", "filterActive", "", "searchActive", "searchJob", "Lkotlinx/coroutines/Job;", "getSearchJob", "()Lkotlinx/coroutines/Job;", "setSearchJob", "(Lkotlinx/coroutines/Job;)V", "bitmapToPngBuffer", "", "bitmap", "Landroid/graphics/Bitmap;", "createMultipartBody", "Lokhttp3/MultipartBody$Part;", "partName", "", "buffer", "onInviteToPlaygroup", "", "friend", "Lcom/studiolaganne/lengendarylens/MTFriend;", "onPlaygroupEdited", "playgroup", "onUserFriendRequest", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "onUserAdminPromote", "userToPromote", "onUserAdminRemove", "userToRemove", "onTransferOwnership", "userToTransferTo", "onUserRemove", "onUserLeave", "onUserPending", "onPlaygroupDelete", "updateFilter", "showFilterBottomSheet", "performSearch", SearchIntents.EXTRA_QUERY, "onDestroy", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "handleImageRotation", "imageUri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "cropToSquare", "resizeBitmap", "maxWidth", "", "maxHeight", "isShowingMessages", "updateMessagesFromRemote", "updatePlaygroupFromRemote", "updateUI", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupDetailsActivity extends BaseActivity implements PlaygroupUserClickListener, EditPlaygroupCallback, InviteToPlaygroupCallback {
    public static final int $stable = 8;
    private MTPlaygroup currentPlaygroup;
    private boolean filterActive;
    private BroadcastReceiver msgReceiver;
    private ActivityResultLauncher<Intent> pickPhotoLauncher;
    private boolean searchActive;
    private Job searchJob;
    private List<Fragment> fragmentList = new ArrayList();
    private List<MTFormat> formatsForFilter = CollectionsKt.emptyList();
    private FilterDefinition filterDefinition = new FilterDefinition(null, null, null, null, null, null, 63, null);

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$onCreate$20, reason: invalid class name */
    /* JADX INFO: compiled from: PlaygroupDetailsActivity.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/studiolaganne/lengendarylens/PlaygroupDetailsActivity$onCreate$20", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass20 extends ViewPager2.OnPageChangeCallback {
        final /* synthetic */ ConstraintLayout $filterLayout;
        final /* synthetic */ ConstraintLayout $searchEditLayout;
        final /* synthetic */ ConstraintLayout $searchNotesLayout;
        final /* synthetic */ ViewPager2 $viewPager;

        AnonymousClass20(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ViewPager2 viewPager2) {
            this.$searchNotesLayout = constraintLayout;
            this.$searchEditLayout = constraintLayout2;
            this.$filterLayout = constraintLayout3;
            this.$viewPager = viewPager2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPageSelected$lambda$0$0(PlaygroupDetailsActivity playgroupDetailsActivity) {
            Object obj = playgroupDetailsActivity.fragmentList.get(2);
            PlaygroupStatsFragment playgroupStatsFragment = obj instanceof PlaygroupStatsFragment ? (PlaygroupStatsFragment) obj : null;
            if (playgroupStatsFragment != null) {
                playgroupStatsFragment.updateStats();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            LinearLayout linearLayout = (LinearLayout) PlaygroupDetailsActivity.this.findViewById(R.id.masterFilterLayout);
            LinearLayout linearLayout2 = (LinearLayout) PlaygroupDetailsActivity.this.findViewById(R.id.activeFilterLayout);
            if (position == 3) {
                if (PlaygroupDetailsActivity.this.filterActive) {
                    linearLayout2.setVisibility(0);
                    linearLayout.setVisibility(8);
                    this.$searchNotesLayout.setVisibility(8);
                    this.$searchEditLayout.setVisibility(8);
                } else {
                    linearLayout2.setVisibility(8);
                    linearLayout.setVisibility(0);
                    this.$filterLayout.setVisibility(0);
                    if (PlaygroupDetailsActivity.this.searchActive) {
                        this.$filterLayout.setVisibility(8);
                        this.$searchNotesLayout.setVisibility(8);
                        this.$searchEditLayout.setVisibility(0);
                    } else {
                        this.$searchNotesLayout.setVisibility(0);
                        this.$searchEditLayout.setVisibility(8);
                    }
                }
            }
            if (position == 2) {
                this.$searchNotesLayout.setVisibility(8);
                this.$searchEditLayout.setVisibility(8);
                if (PlaygroupDetailsActivity.this.filterActive) {
                    linearLayout2.setVisibility(0);
                    linearLayout.setVisibility(8);
                } else {
                    linearLayout2.setVisibility(8);
                    linearLayout.setVisibility(0);
                    this.$filterLayout.setVisibility(0);
                }
                if (PlaygroupDetailsActivity.this.getCurrentPlaygroup() != null) {
                    ViewPager2 viewPager2 = this.$viewPager;
                    final PlaygroupDetailsActivity playgroupDetailsActivity = PlaygroupDetailsActivity.this;
                    viewPager2.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$onCreate$20$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            PlaygroupDetailsActivity.AnonymousClass20.onPageSelected$lambda$0$0(playgroupDetailsActivity);
                        }
                    });
                }
            }
            if (position == 0 || position == 1) {
                this.$searchNotesLayout.setVisibility(8);
                this.$searchEditLayout.setVisibility(8);
                linearLayout2.setVisibility(8);
                linearLayout.setVisibility(8);
            }
        }
    }

    private final byte[] bitmapToPngBuffer(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    private final MultipartBody.Part createMultipartBody(String partName, byte[] buffer) {
        return MultipartBody.Part.INSTANCE.createFormData(partName, "picture.png", RequestBody.Companion.create$default(RequestBody.INSTANCE, buffer, MediaType.INSTANCE.parse(MimeTypes.IMAGE_PNG), 0, 0, 6, (Object) null));
    }

    private final Bitmap cropToSquare(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMin = Math.min(width, height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (width - iMin) / 2, (height - iMin) / 2, iMin, iMin);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    private final Bitmap handleImageRotation(Uri imageUri, Context context) throws IOException {
        ContentResolver contentResolver = context.getContentResolver();
        InputStream inputStreamOpenInputStream = contentResolver.openInputStream(imageUri);
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
        InputStream inputStreamOpenInputStream2 = contentResolver.openInputStream(imageUri);
        ExifInterface exifInterface = inputStreamOpenInputStream2 != null ? new ExifInterface(inputStreamOpenInputStream2) : null;
        Integer numValueOf = exifInterface != null ? Integer.valueOf(exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1)) : null;
        int i = (numValueOf != null && numValueOf.intValue() == 6) ? 90 : (numValueOf != null && numValueOf.intValue() == 3) ? SensibleDefaults.X_OFFSET : (numValueOf != null && numValueOf.intValue() == 8) ? 270 : 0;
        Matrix matrix = new Matrix();
        if (i != 0) {
            matrix.preRotate(i);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), matrix, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        if (inputStreamOpenInputStream != null) {
            inputStreamOpenInputStream.close();
        }
        if (inputStreamOpenInputStream2 != null) {
            inputStreamOpenInputStream2.close();
        }
        return bitmapCreateBitmap;
    }

    static final Unit onCreate$lambda$1(PlaygroupDetailsActivity playgroupDetailsActivity, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout, ViewPager2 viewPager2) {
        playgroupDetailsActivity.filterDefinition = new FilterDefinition(null, null, null, null, null, null, 63, null);
        playgroupDetailsActivity.filterActive = false;
        linearLayout.setVisibility(0);
        linearLayout2.setVisibility(8);
        playgroupDetailsActivity.updateFilter();
        constraintLayout.setVisibility(8);
        if (viewPager2.getCurrentItem() == 3) {
            constraintLayout.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$11(PlaygroupDetailsActivity playgroupDetailsActivity) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        ActivityResultLauncher<Intent> activityResultLauncher = playgroupDetailsActivity.pickPhotoLauncher;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(intent);
        }
        return Unit.INSTANCE;
    }

    static final void onCreate$lambda$17(PlaygroupDetailsActivity playgroupDetailsActivity, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setText(i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : playgroupDetailsActivity.getString(R.string.games_tab) : playgroupDetailsActivity.getString(R.string.stats_tab) : playgroupDetailsActivity.getString(R.string.players_tab) : playgroupDetailsActivity.getString(R.string.messages_tab));
    }

    static final void onCreate$lambda$18(PlaygroupDetailsActivity playgroupDetailsActivity) {
        playgroupDetailsActivity.updateMessagesFromRemote();
        playgroupDetailsActivity.updatePlaygroupFromRemote();
    }

    static final Unit onCreate$lambda$2(PlaygroupDetailsActivity playgroupDetailsActivity) {
        playgroupDetailsActivity.showFilterBottomSheet();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$3(PlaygroupDetailsActivity playgroupDetailsActivity) {
        playgroupDetailsActivity.showFilterBottomSheet();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$4(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, EditText editText, PlaygroupDetailsActivity playgroupDetailsActivity) {
        constraintLayout.setVisibility(8);
        constraintLayout2.setVisibility(8);
        constraintLayout3.setVisibility(0);
        editText.setText("");
        editText.requestFocus();
        Object systemService = playgroupDetailsActivity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$5(PlaygroupDetailsActivity playgroupDetailsActivity, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3) {
        playgroupDetailsActivity.searchActive = false;
        constraintLayout.setVisibility(8);
        constraintLayout2.setVisibility(0);
        constraintLayout3.setVisibility(0);
        if (playgroupDetailsActivity.fragmentList.size() >= 4) {
            Fragment fragment = playgroupDetailsActivity.fragmentList.get(3);
            PlaygroupGamesFragment playgroupGamesFragment = fragment instanceof PlaygroupGamesFragment ? (PlaygroupGamesFragment) fragment : null;
            if (playgroupGamesFragment != null) {
                playgroupGamesFragment.resetSearch();
            }
        }
        return Unit.INSTANCE;
    }

    static final void onCreate$lambda$7(final PlaygroupDetailsActivity playgroupDetailsActivity, MTUser mTUser, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (playgroupDetailsActivity.isDestroyed() || playgroupDetailsActivity.isFinishing()) {
            return;
        }
        Intent data = result.getData();
        Uri data2 = data != null ? data.getData() : null;
        if (data2 != null) {
            MultipartBody.Part partCreateMultipartBody = playgroupDetailsActivity.createMultipartBody("file", playgroupDetailsActivity.bitmapToPngBuffer(playgroupDetailsActivity.resizeBitmap(playgroupDetailsActivity.cropToSquare(playgroupDetailsActivity.handleImageRotation(data2, playgroupDetailsActivity)), 128, 128)));
            final ConstraintLayout constraintLayout = (ConstraintLayout) playgroupDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            TextView textView = (TextView) playgroupDetailsActivity.findViewById(R.id.connectingTextView);
            if (textView != null) {
                textView.setText(playgroupDetailsActivity.getString(R.string.updating));
            }
            MTPlaygroup mTPlaygroup = playgroupDetailsActivity.currentPlaygroup;
            MTApiKt.getMtApi().updatePlaygroupPicture(mTUser != null ? mTUser.getId() : -1, mTPlaygroup != null ? mTPlaygroup.getId() : -1, partCreateMultipartBody).enqueue(new Callback<MTSinglePlaygroupResponse>() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$onCreate$10$1$3
                @Override // retrofit2.Callback
                public void onFailure(Call<MTSinglePlaygroupResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    if (constraintLayout2 != null) {
                        constraintLayout2.setVisibility(8);
                    }
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTSinglePlaygroupResponse> call, Response<MTSinglePlaygroupResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (!response.isSuccessful()) {
                        ResponseBody responseBodyErrorBody = response.errorBody();
                        Log.d("MTApi", "Update playgroup picture code error: " + (responseBodyErrorBody != null ? responseBodyErrorBody.string() : null));
                    } else {
                        if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                            return;
                        }
                        MTSinglePlaygroupResponse mTSinglePlaygroupResponseBody = response.body();
                        MTPlaygroup playgroup = mTSinglePlaygroupResponseBody != null ? mTSinglePlaygroupResponseBody.getPlaygroup() : null;
                        if (playgroup != null) {
                            PlaygroupDetailsActivity playgroupDetailsActivity2 = this.this$0;
                            PreferencesManager preferencesManager = new PreferencesManager(playgroupDetailsActivity2);
                            List<MTPlaygroup> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getCurrentUserPlaygroups());
                            Iterator<MTPlaygroup> it = mutableList.iterator();
                            int i = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i = -1;
                                    break;
                                } else if (it.next().getId() == playgroup.getId()) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            if (i != -1) {
                                mutableList.set(i, playgroup);
                                preferencesManager.saveCurrentUserPlaygroups(mutableList);
                            }
                            preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                            View viewFindViewById = playgroupDetailsActivity2.findViewById(R.id.profile_icon);
                            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                            CachedImageView cachedImageView = (CachedImageView) viewFindViewById;
                            View viewFindViewById2 = playgroupDetailsActivity2.findViewById(R.id.no_photo_icon);
                            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                            ImageView imageView = (ImageView) viewFindViewById2;
                            String picture = playgroup.getPicture();
                            String str = picture;
                            if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
                                imageView.setVisibility(0);
                                cachedImageView.setVisibility(8);
                            } else {
                                imageView.setVisibility(8);
                                cachedImageView.setVisibility(0);
                                cachedImageView.setAutoLoad(false);
                                cachedImageView.reset();
                                cachedImageView.loadImage(picture);
                            }
                        }
                    }
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    if (constraintLayout2 != null) {
                        constraintLayout2.setVisibility(8);
                    }
                }
            });
        }
    }

    static final Unit onCreate$lambda$8(PlaygroupDetailsActivity playgroupDetailsActivity) {
        playgroupDetailsActivity.finish();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$9(final PlaygroupDetailsActivity playgroupDetailsActivity, final MTUser mTUser, ConstraintLayout constraintLayout, final PreferencesManager preferencesManager) {
        List<Integer> admins;
        MTPlaygroup mTPlaygroup = playgroupDetailsActivity.currentPlaygroup;
        boolean z = false;
        if (mTPlaygroup != null && (admins = mTPlaygroup.getAdmins()) != null) {
            if (CollectionsKt.contains(admins, mTUser != null ? Integer.valueOf(mTUser.getId()) : null)) {
                z = true;
            }
        }
        MTPlaygroup mTPlaygroup2 = playgroupDetailsActivity.currentPlaygroup;
        boolean zAreEqual = Intrinsics.areEqual(mTPlaygroup2 != null ? mTPlaygroup2.getOwner() : null, mTUser != null ? Integer.valueOf(mTUser.getId()) : null);
        IconPopupMenu iconPopupMenu = new IconPopupMenu(playgroupDetailsActivity);
        if (z) {
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.edit_playgroup, "\uf044", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlaygroupDetailsActivity.onCreate$lambda$9$0(mTUser, playgroupDetailsActivity);
                }
            }, 28, (Object) null);
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.invite_playgroup, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlaygroupDetailsActivity.onCreate$lambda$9$1(preferencesManager, playgroupDetailsActivity);
                }
            }, 30, (Object) null);
        }
        IconPopupMenu.addItem$default(iconPopupMenu, R.string.new_game_playgroup, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupDetailsActivity.onCreate$lambda$9$2(mTUser, playgroupDetailsActivity);
            }
        }, 30, (Object) null);
        iconPopupMenu.addDivider();
        IconPopupMenu.addItem$default(iconPopupMenu, R.string.leave_playgroup, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupDetailsActivity.onCreate$lambda$9$3(mTUser, playgroupDetailsActivity);
            }
        }, 30, (Object) null);
        if (zAreEqual) {
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.delete_playgroup, "\uf2ed", true, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlaygroupDetailsActivity.onCreate$lambda$9$4(mTUser, playgroupDetailsActivity);
                }
            }, 24, (Object) null);
        }
        iconPopupMenu.show(constraintLayout);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$9$0(MTUser mTUser, PlaygroupDetailsActivity playgroupDetailsActivity) {
        MTPlaygroup mTPlaygroup;
        if (mTUser != null && (mTPlaygroup = playgroupDetailsActivity.currentPlaygroup) != null) {
            new EditPlaygroupBottomSheetFragment(playgroupDetailsActivity, mTUser, mTPlaygroup).show(playgroupDetailsActivity.getSupportFragmentManager(), EditPlaygroupBottomSheetFragment.TAG);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$9$1(PreferencesManager preferencesManager, PlaygroupDetailsActivity playgroupDetailsActivity) {
        List<MTFriend> currentUserFriends = preferencesManager.getCurrentUserFriends();
        ArrayList arrayList = new ArrayList();
        for (Object obj : currentUserFriends) {
            if (!Intrinsics.areEqual(((MTFriend) obj).getStatus(), "pending")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        MTPlaygroup mTPlaygroup = playgroupDetailsActivity.currentPlaygroup;
        if (mTPlaygroup != null) {
            new InviteToPlaygroupBottomSheetFragment(playgroupDetailsActivity, arrayList2, mTPlaygroup).show(playgroupDetailsActivity.getSupportFragmentManager(), InviteToPlaygroupBottomSheetFragment.TAG);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$9$2(MTUser mTUser, PlaygroupDetailsActivity playgroupDetailsActivity) {
        MTPlaygroup mTPlaygroup;
        if (mTUser != null && (mTPlaygroup = playgroupDetailsActivity.currentPlaygroup) != null) {
            PlaygroupDetailsActivity playgroupDetailsActivity2 = playgroupDetailsActivity;
            if (new PreferencesManager(playgroupDetailsActivity2).hasGame()) {
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string = playgroupDetailsActivity.getString(R.string.game_in_progress_title);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CustomDialogFragment.Builder title = builder.setTitle(string);
                String string2 = playgroupDetailsActivity.getString(R.string.game_in_progress_body_delete_first);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder body = title.setBody(string2);
                String string3 = playgroupDetailsActivity.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PlaygroupDetailsActivity.onCreate$lambda$9$2$0$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                });
                FragmentManager supportFragmentManager = playgroupDetailsActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                positiveButton.show(supportFragmentManager, "game_in_progress_dialog");
            } else {
                Intent intent = new Intent(playgroupDetailsActivity2, (Class<?>) MainActivity.class);
                intent.setFlags(603979776);
                intent.putExtra("newGamePlaygroupId", mTPlaygroup.getId());
                playgroupDetailsActivity.startActivity(intent);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$9$2$0$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$9$3(MTUser mTUser, PlaygroupDetailsActivity playgroupDetailsActivity) {
        if (mTUser != null) {
            playgroupDetailsActivity.onUserLeave(mTUser);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$9$4(MTUser mTUser, PlaygroupDetailsActivity playgroupDetailsActivity) {
        if (mTUser != null) {
            playgroupDetailsActivity.onPlaygroupDelete(mTUser);
        }
        return Unit.INSTANCE;
    }

    private final void onPlaygroupDelete(MTUser user) {
        CustomDeleteDialogFragment.Builder builder = new CustomDeleteDialogFragment.Builder();
        String string = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDeleteDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.delete_playgroup_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        title.setBody(string2).setPositiveButtonCallback(new Function3() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PlaygroupDetailsActivity.onPlaygroupDelete$lambda$0(this.f$0, (String) obj, ((Boolean) obj2).booleanValue(), (CustomDeleteDialogFragment) obj3);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaygroupDetailsActivity.onPlaygroupDelete$lambda$1((CustomDeleteDialogFragment) obj);
            }
        }).build().show(getSupportFragmentManager(), "delete_playgroup_dialog");
    }

    static final Unit onPlaygroupDelete$lambda$0(PlaygroupDetailsActivity playgroupDetailsActivity, String str, boolean z, CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        PreferencesManager preferencesManager = new PreferencesManager(playgroupDetailsActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) playgroupDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            ((TextView) playgroupDetailsActivity.findViewById(R.id.connectingTextView)).setText(playgroupDetailsActivity.getString(R.string.deleting));
            MTPlaygroup mTPlaygroup = playgroupDetailsActivity.currentPlaygroup;
            MTApiKt.getMtApi().deletePlaygroup(currentUser.getId(), mTPlaygroup != null ? mTPlaygroup.getId() : -1).enqueue(new PlaygroupDetailsActivity$onPlaygroupDelete$dialog$1$1$2(playgroupDetailsActivity, constraintLayout, preferencesManager));
        }
        return Unit.INSTANCE;
    }

    static final Unit onPlaygroupDelete$lambda$1(CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onTransferOwnership$lambda$0(final PlaygroupDetailsActivity playgroupDetailsActivity, MTUser mTUser, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        final PreferencesManager preferencesManager = new PreferencesManager(playgroupDetailsActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            final ConstraintLayout constraintLayout = (ConstraintLayout) playgroupDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            ((TextView) playgroupDetailsActivity.findViewById(R.id.connectingTextView)).setText(playgroupDetailsActivity.getString(R.string.transfering));
            MTPlaygroup mTPlaygroup = playgroupDetailsActivity.currentPlaygroup;
            MTApiKt.getMtApi().transferOwnership(currentUser.getId(), mTPlaygroup != null ? mTPlaygroup.getId() : -1, mTUser.getId()).enqueue(new Callback<MTSinglePlaygroupResponse>() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$onTransferOwnership$1$1$2
                @Override // retrofit2.Callback
                public void onFailure(Call<MTSinglePlaygroupResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    if (constraintLayout2 != null) {
                        constraintLayout2.setVisibility(8);
                    }
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTSinglePlaygroupResponse> call, Response<MTSinglePlaygroupResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (response.isSuccessful()) {
                        if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                            return;
                        }
                        MTSinglePlaygroupResponse mTSinglePlaygroupResponseBody = response.body();
                        MTPlaygroup playgroup = mTSinglePlaygroupResponseBody != null ? mTSinglePlaygroupResponseBody.getPlaygroup() : null;
                        if (playgroup != null) {
                            PreferencesManager preferencesManager2 = preferencesManager;
                            PlaygroupDetailsActivity playgroupDetailsActivity2 = this.this$0;
                            List<MTPlaygroup> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager2.getCurrentUserPlaygroups());
                            Iterator<MTPlaygroup> it = mutableList.iterator();
                            int i = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i = -1;
                                    break;
                                } else if (it.next().getId() == playgroup.getId()) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            if (i != -1) {
                                mutableList.set(i, playgroup);
                                preferencesManager2.saveCurrentUserPlaygroups(mutableList);
                            }
                            preferencesManager2.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                            playgroupDetailsActivity2.setCurrentPlaygroup(playgroup);
                            playgroupDetailsActivity2.updateUI();
                        }
                    }
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    if (constraintLayout2 != null) {
                        constraintLayout2.setVisibility(8);
                    }
                }
            });
        }
        return Unit.INSTANCE;
    }

    static final Unit onTransferOwnership$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onUserAdminPromote$lambda$0(final PlaygroupDetailsActivity playgroupDetailsActivity, MTUser mTUser, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        final PreferencesManager preferencesManager = new PreferencesManager(playgroupDetailsActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            final ConstraintLayout constraintLayout = (ConstraintLayout) playgroupDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            ((TextView) playgroupDetailsActivity.findViewById(R.id.connectingTextView)).setText(playgroupDetailsActivity.getString(R.string.promoting));
            MTPlaygroup mTPlaygroup = playgroupDetailsActivity.currentPlaygroup;
            MTApiKt.getMtApi().promoteToAdmin(currentUser.getId(), mTPlaygroup != null ? mTPlaygroup.getId() : -1, mTUser.getId()).enqueue(new Callback<MTSinglePlaygroupResponse>() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$onUserAdminPromote$1$1$2
                @Override // retrofit2.Callback
                public void onFailure(Call<MTSinglePlaygroupResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    if (constraintLayout2 != null) {
                        constraintLayout2.setVisibility(8);
                    }
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTSinglePlaygroupResponse> call, Response<MTSinglePlaygroupResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (response.isSuccessful()) {
                        if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                            return;
                        }
                        MTSinglePlaygroupResponse mTSinglePlaygroupResponseBody = response.body();
                        MTPlaygroup playgroup = mTSinglePlaygroupResponseBody != null ? mTSinglePlaygroupResponseBody.getPlaygroup() : null;
                        if (playgroup != null) {
                            PreferencesManager preferencesManager2 = preferencesManager;
                            PlaygroupDetailsActivity playgroupDetailsActivity2 = this.this$0;
                            List<MTPlaygroup> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager2.getCurrentUserPlaygroups());
                            Iterator<MTPlaygroup> it = mutableList.iterator();
                            int i = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i = -1;
                                    break;
                                } else if (it.next().getId() == playgroup.getId()) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            if (i != -1) {
                                mutableList.set(i, playgroup);
                                preferencesManager2.saveCurrentUserPlaygroups(mutableList);
                            }
                            preferencesManager2.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                            playgroupDetailsActivity2.setCurrentPlaygroup(playgroup);
                            playgroupDetailsActivity2.updateUI();
                        }
                    }
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    if (constraintLayout2 != null) {
                        constraintLayout2.setVisibility(8);
                    }
                }
            });
        }
        return Unit.INSTANCE;
    }

    static final Unit onUserAdminPromote$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onUserAdminRemove$lambda$0(final PlaygroupDetailsActivity playgroupDetailsActivity, MTUser mTUser, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        final PreferencesManager preferencesManager = new PreferencesManager(playgroupDetailsActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            final ConstraintLayout constraintLayout = (ConstraintLayout) playgroupDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            ((TextView) playgroupDetailsActivity.findViewById(R.id.connectingTextView)).setText(playgroupDetailsActivity.getString(R.string.removing));
            MTPlaygroup mTPlaygroup = playgroupDetailsActivity.currentPlaygroup;
            MTApiKt.getMtApi().removeAdmin(currentUser.getId(), mTPlaygroup != null ? mTPlaygroup.getId() : -1, mTUser.getId()).enqueue(new Callback<MTSinglePlaygroupResponse>() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$onUserAdminRemove$1$1$2
                @Override // retrofit2.Callback
                public void onFailure(Call<MTSinglePlaygroupResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    if (constraintLayout2 != null) {
                        constraintLayout2.setVisibility(8);
                    }
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTSinglePlaygroupResponse> call, Response<MTSinglePlaygroupResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (response.isSuccessful()) {
                        if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                            return;
                        }
                        MTSinglePlaygroupResponse mTSinglePlaygroupResponseBody = response.body();
                        MTPlaygroup playgroup = mTSinglePlaygroupResponseBody != null ? mTSinglePlaygroupResponseBody.getPlaygroup() : null;
                        if (playgroup != null) {
                            PreferencesManager preferencesManager2 = preferencesManager;
                            PlaygroupDetailsActivity playgroupDetailsActivity2 = this.this$0;
                            List<MTPlaygroup> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager2.getCurrentUserPlaygroups());
                            Iterator<MTPlaygroup> it = mutableList.iterator();
                            int i = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i = -1;
                                    break;
                                } else if (it.next().getId() == playgroup.getId()) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            if (i != -1) {
                                mutableList.set(i, playgroup);
                                preferencesManager2.saveCurrentUserPlaygroups(mutableList);
                            }
                            preferencesManager2.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                            playgroupDetailsActivity2.setCurrentPlaygroup(playgroup);
                            playgroupDetailsActivity2.updateUI();
                        }
                    }
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    if (constraintLayout2 != null) {
                        constraintLayout2.setVisibility(8);
                    }
                }
            });
        }
        return Unit.INSTANCE;
    }

    static final Unit onUserAdminRemove$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onUserLeave$lambda$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onUserLeave$lambda$1(PlaygroupDetailsActivity playgroupDetailsActivity, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        PreferencesManager preferencesManager = new PreferencesManager(playgroupDetailsActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) playgroupDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            ((TextView) playgroupDetailsActivity.findViewById(R.id.connectingTextView)).setText(playgroupDetailsActivity.getString(R.string.leaving_playgroup));
            MTPlaygroup mTPlaygroup = playgroupDetailsActivity.currentPlaygroup;
            MTApiKt.getMtApi().leavePlaygroup(currentUser.getId(), mTPlaygroup != null ? mTPlaygroup.getId() : -1).enqueue(new PlaygroupDetailsActivity$onUserLeave$2$1$2(playgroupDetailsActivity, constraintLayout, preferencesManager));
        }
        return Unit.INSTANCE;
    }

    static final Unit onUserLeave$lambda$2(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onUserPending$lambda$1(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onUserPending$lambda$2(PlaygroupDetailsActivity playgroupDetailsActivity, MTUser mTUser, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (playgroupDetailsActivity.isFinishing() || playgroupDetailsActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        PreferencesManager preferencesManager = new PreferencesManager(playgroupDetailsActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        MTApi mtApi = MTApiKt.getMtApi();
        int id = currentUser != null ? currentUser.getId() : -1;
        MTPlaygroup mTPlaygroup = playgroupDetailsActivity.currentPlaygroup;
        mtApi.removeUserFromPlaygroup(id, mTPlaygroup != null ? mTPlaygroup.getId() : -1, mTUser.getId()).enqueue(new PlaygroupDetailsActivity$onUserPending$3$1(playgroupDetailsActivity, preferencesManager));
        return Unit.INSTANCE;
    }

    static final Unit onUserRemove$lambda$0(final PlaygroupDetailsActivity playgroupDetailsActivity, MTUser mTUser, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        final PreferencesManager preferencesManager = new PreferencesManager(playgroupDetailsActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            final ConstraintLayout constraintLayout = (ConstraintLayout) playgroupDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            ((TextView) playgroupDetailsActivity.findViewById(R.id.connectingTextView)).setText(playgroupDetailsActivity.getString(R.string.leaving_playgroup));
            MTPlaygroup mTPlaygroup = playgroupDetailsActivity.currentPlaygroup;
            MTApiKt.getMtApi().removeUserFromPlaygroup(currentUser.getId(), mTPlaygroup != null ? mTPlaygroup.getId() : -1, mTUser.getId()).enqueue(new Callback<MTSinglePlaygroupResponse>() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$onUserRemove$1$1$2
                @Override // retrofit2.Callback
                public void onFailure(Call<MTSinglePlaygroupResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    if (constraintLayout2 != null) {
                        constraintLayout2.setVisibility(8);
                    }
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTSinglePlaygroupResponse> call, Response<MTSinglePlaygroupResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (response.isSuccessful()) {
                        if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                            return;
                        }
                        MTSinglePlaygroupResponse mTSinglePlaygroupResponseBody = response.body();
                        MTPlaygroup playgroup = mTSinglePlaygroupResponseBody != null ? mTSinglePlaygroupResponseBody.getPlaygroup() : null;
                        if (playgroup != null) {
                            PreferencesManager preferencesManager2 = preferencesManager;
                            PlaygroupDetailsActivity playgroupDetailsActivity2 = this.this$0;
                            List<MTPlaygroup> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager2.getCurrentUserPlaygroups());
                            Iterator<MTPlaygroup> it = mutableList.iterator();
                            int i = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i = -1;
                                    break;
                                } else if (it.next().getId() == playgroup.getId()) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            if (i != -1) {
                                mutableList.set(i, playgroup);
                                preferencesManager2.saveCurrentUserPlaygroups(mutableList);
                            }
                            preferencesManager2.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                            playgroupDetailsActivity2.setCurrentPlaygroup(playgroup);
                            playgroupDetailsActivity2.updateUI();
                        }
                    }
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    if (constraintLayout2 != null) {
                        constraintLayout2.setVisibility(8);
                    }
                }
            });
        }
        return Unit.INSTANCE;
    }

    static final Unit onUserRemove$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performSearch(String query) {
        this.searchActive = true;
        if (this.fragmentList.size() >= 4) {
            Fragment fragment = this.fragmentList.get(3);
            PlaygroupGamesFragment playgroupGamesFragment = fragment instanceof PlaygroupGamesFragment ? (PlaygroupGamesFragment) fragment : null;
            if (playgroupGamesFragment != null) {
                playgroupGamesFragment.performSearch(query);
            }
        }
    }

    private final Bitmap resizeBitmap(Bitmap bitmap, int maxWidth, int maxHeight) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = width / height;
        if (width > height) {
            maxHeight = (int) (maxWidth / f);
        } else if (height > width) {
            maxWidth = (int) (maxHeight * f);
        }
        Log.d("MultipartBody", "Resizing bitmap (" + bitmap.getWidth() + " x " + bitmap.getHeight() + ") to " + maxWidth + " x " + maxHeight);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, maxWidth, maxHeight, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return bitmapCreateScaledBitmap;
    }

    private final void showFilterBottomSheet() {
        FilterBottomSheetFragment.INSTANCE.newInstance(new FilterCallback() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$showFilterBottomSheet$bottomSheet$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.studiolaganne.lengendarylens.FilterCallback
            public void onApplyFilter(FilterDefinition filter) {
                String name;
                int i;
                List<MTTag> games;
                Object next;
                Intrinsics.checkNotNullParameter(filter, "filter");
                if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                    return;
                }
                this.this$0.filterDefinition = filter;
                LinearLayout linearLayout = (LinearLayout) this.this$0.findViewById(R.id.masterFilterLayout);
                LinearLayout linearLayout2 = (LinearLayout) this.this$0.findViewById(R.id.activeFilterLayout);
                TextView textView = (TextView) this.this$0.findViewById(R.id.activeFilterTitle);
                TextView textView2 = (TextView) this.this$0.findViewById(R.id.plusTextView);
                TextView textView3 = (TextView) this.this$0.findViewById(R.id.tagName);
                TextView textView4 = (TextView) this.this$0.findViewById(R.id.numFilterTextView);
                LinearLayout linearLayout3 = (LinearLayout) this.this$0.findViewById(R.id.activeTagLayout);
                if (filter.getFormatId() == null && filter.getSubformatId() == null && filter.getTagId() == null) {
                    this.this$0.filterActive = false;
                    linearLayout.setVisibility(0);
                    linearLayout2.setVisibility(8);
                } else {
                    this.this$0.filterActive = true;
                    linearLayout.setVisibility(8);
                    linearLayout2.setVisibility(0);
                    Object obj = null;
                    String str = "";
                    if (filter.getFormatId() != null) {
                        Iterator it = this.this$0.formatsForFilter.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            int id = ((MTFormat) next).getId();
                            Integer formatId = filter.getFormatId();
                            if (formatId != null && id == formatId.intValue()) {
                                break;
                            }
                        }
                        MTFormat mTFormat = (MTFormat) next;
                        name = mTFormat != null ? mTFormat.getName() : "";
                        i = 1;
                    } else {
                        name = "";
                        i = 0;
                    }
                    textView.setText(name);
                    Integer subformatId = filter.getSubformatId();
                    if (subformatId != null) {
                        subformatId.intValue();
                        String subformatName = filter.getSubformatName();
                        if (subformatName == null) {
                            subformatName = "";
                        }
                        textView.setText(((Object) name) + " - " + subformatName);
                        i++;
                    }
                    if (filter.getFormatId() == null && filter.getSubformatId() == null) {
                        textView.setVisibility(8);
                        textView2.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                        textView2.setVisibility(0);
                    }
                    Integer tagId = filter.getTagId();
                    if (tagId != null) {
                        PlaygroupDetailsActivity playgroupDetailsActivity = this.this$0;
                        tagId.intValue();
                        Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        objectRef.element = "";
                        MTUserTags currentUserTags = new PreferencesManager(playgroupDetailsActivity).getCurrentUserTags();
                        if (currentUserTags != null && (games = currentUserTags.getGames()) != null) {
                            Iterator<T> it2 = games.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                Object next2 = it2.next();
                                if (Intrinsics.areEqual(((MTTag) next2).getId(), filter.getTagId())) {
                                    obj = next2;
                                    break;
                                }
                            }
                            MTTag mTTag = (MTTag) obj;
                            T t = str;
                            if (mTTag != null) {
                                String name2 = mTTag.getName();
                                t = str;
                                if (name2 != null) {
                                    t = name2;
                                }
                            }
                            objectRef.element = t;
                        }
                        String string = (String) objectRef.element;
                        if (string.length() > 0) {
                            StringBuilder sb = new StringBuilder();
                            String strValueOf = String.valueOf(string.charAt(0));
                            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                            StringBuilder sbAppend = sb.append((Object) upperCase);
                            String strSubstring = string.substring(1);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            string = sbAppend.append(strSubstring).toString();
                        }
                        textView3.setText(string);
                        linearLayout3.setVisibility(0);
                        i++;
                    } else {
                        linearLayout3.setVisibility(8);
                    }
                    textView4.setText(String.valueOf(i));
                }
                this.this$0.updateFilter();
            }
        }, this.filterDefinition).show(getSupportFragmentManager(), FilterBottomSheetFragment.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFilter() {
        if (this.fragmentList.size() >= 4) {
            Fragment fragment = this.fragmentList.get(2);
            PlaygroupStatsFragment playgroupStatsFragment = fragment instanceof PlaygroupStatsFragment ? (PlaygroupStatsFragment) fragment : null;
            if (playgroupStatsFragment != null) {
                playgroupStatsFragment.updateFilter(this.filterDefinition);
            }
            Fragment fragment2 = this.fragmentList.get(3);
            PlaygroupGamesFragment playgroupGamesFragment = fragment2 instanceof PlaygroupGamesFragment ? (PlaygroupGamesFragment) fragment2 : null;
            if (playgroupGamesFragment != null) {
                playgroupGamesFragment.updateFilter(this.filterDefinition);
            }
        }
    }

    private final void updateMessagesFromRemote() {
        if (isFinishing() || isDestroyed() || this.currentPlaygroup == null) {
            return;
        }
        Fragment fragment = this.fragmentList.get(0);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.PlaygroupMessagesFragment");
        ((PlaygroupMessagesFragment) fragment).updateUIFromRemote();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePlaygroupFromRemote() {
        MTPlaygroup mTPlaygroup;
        final PreferencesManager preferencesManager;
        MTUser currentUser;
        if (isFinishing() || isDestroyed() || (mTPlaygroup = this.currentPlaygroup) == null || (currentUser = (preferencesManager = new PreferencesManager(this)).getCurrentUser()) == null) {
            return;
        }
        MTApiKt.getMtApi().getPlaygroupById(currentUser.getId(), mTPlaygroup.getId()).enqueue(new Callback<MTSinglePlaygroupResponse>() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$updatePlaygroupFromRemote$1$1$1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSinglePlaygroupResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSinglePlaygroupResponse> call, Response<MTSinglePlaygroupResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isSuccessful()) {
                    ResponseBody responseBodyErrorBody = response.errorBody();
                    Log.d("MTApi", "Get playgroup code error: " + (responseBodyErrorBody != null ? responseBodyErrorBody.string() : null));
                    return;
                }
                if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                    return;
                }
                MTSinglePlaygroupResponse mTSinglePlaygroupResponseBody = response.body();
                MTPlaygroup playgroup = mTSinglePlaygroupResponseBody != null ? mTSinglePlaygroupResponseBody.getPlaygroup() : null;
                if (playgroup != null) {
                    PlaygroupDetailsActivity playgroupDetailsActivity = this.this$0;
                    PreferencesManager preferencesManager2 = preferencesManager;
                    playgroupDetailsActivity.setCurrentPlaygroup(playgroup);
                    List<MTPlaygroup> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager2.getCurrentUserPlaygroups());
                    Iterator<MTPlaygroup> it = mutableList.iterator();
                    int i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i = -1;
                            break;
                        } else if (it.next().getId() == playgroup.getId()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i != -1) {
                        mutableList.set(i, playgroup);
                        preferencesManager2.saveCurrentUserPlaygroups(mutableList);
                    }
                    preferencesManager2.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                    playgroupDetailsActivity.updateUI();
                    Object obj = playgroupDetailsActivity.fragmentList.get(2);
                    PlaygroupStatsFragment playgroupStatsFragment = obj instanceof PlaygroupStatsFragment ? (PlaygroupStatsFragment) obj : null;
                    if (playgroupStatsFragment != null) {
                        playgroupStatsFragment.updateUI(playgroup);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUI() {
        MTPlaygroup mTPlaygroup;
        if (isDestroyed() || isFinishing() || (mTPlaygroup = this.currentPlaygroup) == null) {
            return;
        }
        View viewFindViewById = findViewById(R.id.playgroupName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = findViewById(R.id.playgroupDescription);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        View viewFindViewById3 = findViewById(R.id.profile_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        CachedImageView cachedImageView = (CachedImageView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.no_photo_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById4;
        ((TextView) viewFindViewById).setText(mTPlaygroup.getName());
        ((TextView) viewFindViewById2).setText(mTPlaygroup.getDescription());
        String picture = mTPlaygroup.getPicture();
        String str = picture;
        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            imageView.setVisibility(0);
            cachedImageView.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            cachedImageView.setVisibility(0);
            cachedImageView.setAutoLoad(false);
            cachedImageView.reset();
            cachedImageView.loadImage(picture);
        }
        TextView textView = (TextView) findViewById(R.id.playersText);
        if (mTPlaygroup.getUsers().size() > 1) {
            String string = getString(R.string.x_players);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textView.setText(StringsKt.replace$default(string, "{1}", String.valueOf(mTPlaygroup.getUsers().size()), false, 4, (Object) null));
        } else {
            textView.setText(getString(R.string.one_player));
        }
        Fragment fragment = this.fragmentList.get(1);
        PlaygroupUsersFragment playgroupUsersFragment = fragment instanceof PlaygroupUsersFragment ? (PlaygroupUsersFragment) fragment : null;
        if (playgroupUsersFragment != null) {
            playgroupUsersFragment.updateUI(mTPlaygroup);
        }
    }

    public final MTPlaygroup getCurrentPlaygroup() {
        return this.currentPlaygroup;
    }

    public final Job getSearchJob() {
        return this.searchJob;
    }

    public final boolean isShowingMessages() {
        View viewFindViewById = findViewById(R.id.view_pager);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        return ((ViewPager2) viewFindViewById).getCurrentItem() == 0;
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Object next;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgroup_details);
        int intExtra = getIntent().getIntExtra("playgroupId", -1);
        if (intExtra == -1) {
            finish();
            return;
        }
        View viewFindViewById = findViewById(R.id.tabs);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TabLayout tabLayout = (TabLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.view_pager);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final ViewPager2 viewPager2 = (ViewPager2) viewFindViewById2;
        PlaygroupDetailsActivity playgroupDetailsActivity = this;
        final PreferencesManager preferencesManager = new PreferencesManager(playgroupDetailsActivity);
        final MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            Iterator<T> it = preferencesManager.getCurrentUserPlaygroups().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((MTPlaygroup) next).getId() == intExtra) {
                        break;
                    }
                }
            }
            this.currentPlaygroup = (MTPlaygroup) next;
        }
        ImageView imageView = (ImageView) findViewById(R.id.clearFilterImage);
        final ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.filterLayout);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.masterFilterLayout);
        final LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.activeFilterLayout);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R.id.filterSummaryLayout);
        final ConstraintLayout constraintLayout3 = (ConstraintLayout) findViewById(R.id.searchNotesLayout);
        final ConstraintLayout constraintLayout4 = (ConstraintLayout) findViewById(R.id.searchEditLayout);
        final EditText editText = (EditText) findViewById(R.id.searchNotesEditText);
        ImageView imageView2 = (ImageView) findViewById(R.id.closeSearchImageView);
        this.formatsForFilter = DecksDBHelper.INSTANCE.getInstance(playgroupDetailsActivity).getFormats();
        Intrinsics.checkNotNull(imageView);
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupDetailsActivity.onCreate$lambda$1(this.f$0, linearLayout, linearLayout2, constraintLayout3, viewPager2);
            }
        });
        Intrinsics.checkNotNull(constraintLayout2);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupDetailsActivity.onCreate$lambda$2(this.f$0);
            }
        });
        Intrinsics.checkNotNull(constraintLayout);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupDetailsActivity.onCreate$lambda$3(this.f$0);
            }
        });
        Intrinsics.checkNotNull(constraintLayout3);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout3, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupDetailsActivity.onCreate$lambda$4(constraintLayout, constraintLayout3, constraintLayout4, editText, this);
            }
        });
        Intrinsics.checkNotNull(imageView2);
        ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupDetailsActivity.onCreate$lambda$5(this.f$0, constraintLayout4, constraintLayout3, constraintLayout);
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity.onCreate.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String strValueOf = String.valueOf(s);
                boolean zAreEqual = Intrinsics.areEqual(strValueOf, "");
                PlaygroupDetailsActivity playgroupDetailsActivity2 = PlaygroupDetailsActivity.this;
                if (!zAreEqual) {
                    Job searchJob = playgroupDetailsActivity2.getSearchJob();
                    if (searchJob != null) {
                        Job.DefaultImpls.cancel$default(searchJob, (CancellationException) null, 1, (Object) null);
                    }
                    PlaygroupDetailsActivity playgroupDetailsActivity3 = PlaygroupDetailsActivity.this;
                    playgroupDetailsActivity3.setSearchJob(BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(playgroupDetailsActivity3), Dispatchers.getIO(), null, new PlaygroupDetailsActivity$onCreate$7$afterTextChanged$1(PlaygroupDetailsActivity.this, strValueOf, null), 2, null));
                    return;
                }
                if (playgroupDetailsActivity2.fragmentList.size() >= 4) {
                    Object obj = PlaygroupDetailsActivity.this.fragmentList.get(3);
                    PlaygroupGamesFragment playgroupGamesFragment = obj instanceof PlaygroupGamesFragment ? (PlaygroupGamesFragment) obj : null;
                    if (playgroupGamesFragment != null) {
                        playgroupGamesFragment.resetSearch();
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity.onCreate.8
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent msgIntent) {
                String stringExtra;
                String stringExtra2;
                String stringExtra3 = msgIntent != null ? msgIntent.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE) : null;
                Log.d("PlaygroupDetailsActivity", "----->>>> Received message type: " + stringExtra3);
                String str = "-1";
                if (Intrinsics.areEqual(stringExtra3, PreferencesManager.MSG_TYPE_PLAYGROUP_JOIN)) {
                    if (msgIntent == null || (stringExtra2 = msgIntent.getStringExtra("message_playgroupId")) == null) {
                        stringExtra2 = "-1";
                    }
                    Integer intOrNull = StringsKt.toIntOrNull(stringExtra2);
                    int iIntValue = intOrNull != null ? intOrNull.intValue() : -1;
                    MTPlaygroup currentPlaygroup = PlaygroupDetailsActivity.this.getCurrentPlaygroup();
                    if (currentPlaygroup != null) {
                        PlaygroupDetailsActivity playgroupDetailsActivity2 = PlaygroupDetailsActivity.this;
                        if (currentPlaygroup.getId() == iIntValue) {
                            playgroupDetailsActivity2.updatePlaygroupFromRemote();
                        }
                    }
                }
                if (Intrinsics.areEqual(stringExtra3, PreferencesManager.MSG_TYPE_PLAYGROUP_MESSAGE)) {
                    if (msgIntent != null && (stringExtra = msgIntent.getStringExtra("message_playgroupId")) != null) {
                        str = stringExtra;
                    }
                    Integer intOrNull2 = StringsKt.toIntOrNull(str);
                    int iIntValue2 = intOrNull2 != null ? intOrNull2.intValue() : -1;
                    MTPlaygroup currentPlaygroup2 = PlaygroupDetailsActivity.this.getCurrentPlaygroup();
                    if (currentPlaygroup2 != null) {
                        PlaygroupDetailsActivity playgroupDetailsActivity3 = PlaygroupDetailsActivity.this;
                        if (currentPlaygroup2.getId() == iIntValue2) {
                            Object obj = playgroupDetailsActivity3.fragmentList.get(0);
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.PlaygroupMessagesFragment");
                            ((PlaygroupMessagesFragment) obj).updateUIFromRemote();
                        }
                    }
                }
            }
        };
        this.msgReceiver = broadcastReceiver;
        LocalBroadcastManager.getInstance(playgroupDetailsActivity).registerReceiver(broadcastReceiver, new IntentFilter(PreferencesManager.MESSAGE_INTENT));
        this.pickPhotoLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda31
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PlaygroupDetailsActivity.onCreate$lambda$7(this.f$0, currentUser, (ActivityResult) obj);
            }
        });
        View viewFindViewById3 = findViewById(R.id.backLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupDetailsActivity.onCreate$lambda$8(this.f$0);
            }
        });
        View viewFindViewById4 = findViewById(R.id.dotsLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        final ConstraintLayout constraintLayout5 = (ConstraintLayout) viewFindViewById4;
        ViewExtensionsKt.setOnClickWithFade(constraintLayout5, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupDetailsActivity.onCreate$lambda$9(this.f$0, currentUser, constraintLayout5, preferencesManager);
            }
        });
        View viewFindViewById5 = findViewById(R.id.profileLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        ConstraintLayout constraintLayout6 = (ConstraintLayout) viewFindViewById5;
        constraintLayout6.setOutlineProvider(new CircularOutlineProvider());
        constraintLayout6.setClipToOutline(true);
        View viewFindViewById6 = findViewById(R.id.editProfilePictureLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        ConstraintLayout constraintLayout7 = (ConstraintLayout) viewFindViewById6;
        constraintLayout7.setVisibility(8);
        MTPlaygroup mTPlaygroup = this.currentPlaygroup;
        if (mTPlaygroup != null) {
            if (CollectionsKt.contains(mTPlaygroup.getAdmins(), currentUser != null ? Integer.valueOf(currentUser.getId()) : null)) {
                constraintLayout7.setVisibility(0);
            }
        }
        ViewExtensionsKt.setOnClickWithFade(constraintLayout7, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupDetailsActivity.onCreate$lambda$11(this.f$0);
            }
        });
        Bundle bundle = new Bundle();
        bundle.putInt("playgroupId", intExtra);
        PlaygroupMessagesFragment playgroupMessagesFragment = new PlaygroupMessagesFragment();
        playgroupMessagesFragment.setArguments(bundle);
        Unit unit = Unit.INSTANCE;
        PlaygroupUsersFragment playgroupUsersFragment = new PlaygroupUsersFragment();
        playgroupUsersFragment.setArguments(bundle);
        Unit unit2 = Unit.INSTANCE;
        PlaygroupStatsFragment playgroupStatsFragment = new PlaygroupStatsFragment();
        playgroupStatsFragment.setArguments(bundle);
        Unit unit3 = Unit.INSTANCE;
        PlaygroupGamesFragment playgroupGamesFragment = new PlaygroupGamesFragment();
        playgroupGamesFragment.setArguments(bundle);
        Unit unit4 = Unit.INSTANCE;
        this.fragmentList = CollectionsKt.mutableListOf(playgroupMessagesFragment, playgroupUsersFragment, playgroupStatsFragment, playgroupGamesFragment);
        viewPager2.setAdapter(new FragmentStateAdapter() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity.onCreate.19
            {
                super(PlaygroupDetailsActivity.this);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            public Fragment createFragment(int position) {
                return position != 0 ? position != 1 ? position != 2 ? position != 3 ? new Fragment() : (Fragment) PlaygroupDetailsActivity.this.fragmentList.get(3) : (Fragment) PlaygroupDetailsActivity.this.fragmentList.get(2) : (Fragment) PlaygroupDetailsActivity.this.fragmentList.get(1) : (Fragment) PlaygroupDetailsActivity.this.fragmentList.get(0);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return PlaygroupDetailsActivity.this.fragmentList.size();
            }
        });
        viewPager2.registerOnPageChangeCallback(new AnonymousClass20(constraintLayout3, constraintLayout4, constraintLayout, viewPager2));
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda4
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                PlaygroupDetailsActivity.onCreate$lambda$17(this.f$0, tab, i);
            }
        }).attach();
        updateUI();
        viewPager2.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                PlaygroupDetailsActivity.onCreate$lambda$18(this.f$0);
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.msgReceiver != null) {
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
            BroadcastReceiver broadcastReceiver = this.msgReceiver;
            Intrinsics.checkNotNull(broadcastReceiver);
            localBroadcastManager.unregisterReceiver(broadcastReceiver);
        }
    }

    @Override // com.studiolaganne.lengendarylens.InviteToPlaygroupCallback
    public void onInviteToPlaygroup(MTFriend friend) {
        Intrinsics.checkNotNullParameter(friend, "friend");
        PreferencesManager preferencesManager = new PreferencesManager(this);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            TextView textView = (TextView) findViewById(R.id.connectingTextView);
            String string = getString(R.string.inviting_user);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textView.setText(StringsKt.replace$default(string, "{1}", friend.getFirstname(), false, 4, (Object) null));
            MTPlaygroup mTPlaygroup = this.currentPlaygroup;
            int id = mTPlaygroup != null ? mTPlaygroup.getId() : -1;
            MTInviteBody mTInviteBody = new MTInviteBody(null, 1, null);
            mTInviteBody.setId(String.valueOf(friend.getId()));
            MTApiKt.getMtApi().inviteToPlaygroup(currentUser.getId(), id, mTInviteBody).enqueue(new PlaygroupDetailsActivity$onInviteToPlaygroup$1$2(this, constraintLayout, preferencesManager));
        }
    }

    @Override // com.studiolaganne.lengendarylens.EditPlaygroupCallback
    public void onPlaygroupEdited(MTPlaygroup playgroup) {
        Intrinsics.checkNotNullParameter(playgroup, "playgroup");
        View viewFindViewById = findViewById(R.id.playgroupName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = findViewById(R.id.playgroupDescription);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ((TextView) viewFindViewById).setText(playgroup.getName());
        ((TextView) viewFindViewById2).setText(playgroup.getDescription());
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupUserClickListener
    public void onTransferOwnership(final MTUser userToTransferTo) {
        Intrinsics.checkNotNullParameter(userToTransferTo, "userToTransferTo");
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.transfer_ownership_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String firstname = userToTransferTo.getFirstname();
        if (firstname == null) {
            firstname = getString(R.string.this_user);
            Intrinsics.checkNotNullExpressionValue(firstname, "getString(...)");
        }
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(StringsKt.replace$default(string2, "{1}", firstname, false, 4, (Object) null)).setPositiveButtonRed();
        String string3 = getString(R.string.transfer_button);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PlaygroupDetailsActivity.onTransferOwnership$lambda$0(this.f$0, userToTransferTo, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaygroupDetailsActivity.onTransferOwnership$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        negativeButton.show(supportFragmentManager, "remove_admin_dialog");
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupUserClickListener
    public void onUserAdminPromote(final MTUser userToPromote) {
        Intrinsics.checkNotNullParameter(userToPromote, "userToPromote");
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.promote_admin_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = getString(R.string.promote_button);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PlaygroupDetailsActivity.onUserAdminPromote$lambda$0(this.f$0, userToPromote, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaygroupDetailsActivity.onUserAdminPromote$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        negativeButton.show(supportFragmentManager, "promote_admin_dialog");
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupUserClickListener
    public void onUserAdminRemove(final MTUser userToRemove) {
        Intrinsics.checkNotNullParameter(userToRemove, "userToRemove");
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.remove_admin_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String firstname = userToRemove.getFirstname();
        if (firstname == null) {
            firstname = getString(R.string.this_user);
            Intrinsics.checkNotNullExpressionValue(firstname, "getString(...)");
        }
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(StringsKt.replace$default(string2, "{1}", firstname, false, 4, (Object) null)).setPositiveButtonRed();
        String string3 = getString(R.string.remove_button);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PlaygroupDetailsActivity.onUserAdminRemove$lambda$0(this.f$0, userToRemove, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaygroupDetailsActivity.onUserAdminRemove$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        negativeButton.show(supportFragmentManager, "remove_admin_dialog");
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupUserClickListener
    public void onUserFriendRequest(MTUser user) {
        Intrinsics.checkNotNullParameter(user, "user");
        PreferencesManager preferencesManager = new PreferencesManager(this);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            ((TextView) findViewById(R.id.connectingTextView)).setText(getString(R.string.sending_friend_request));
            MTApiKt.getMtApi().addFriend(currentUser.getId(), user.getId()).enqueue(new PlaygroupDetailsActivity$onUserFriendRequest$1$1(this, constraintLayout, user, preferencesManager));
        }
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupUserClickListener
    public void onUserLeave(MTUser user) {
        Intrinsics.checkNotNullParameter(user, "user");
        MTPlaygroup mTPlaygroup = this.currentPlaygroup;
        if (mTPlaygroup != null && mTPlaygroup.getAdmins().contains(Integer.valueOf(user.getId())) && mTPlaygroup.getAdmins().size() == 1) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = getString(R.string.cannot_leave_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = getString(R.string.cannot_leave_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlaygroupDetailsActivity.onUserLeave$lambda$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            positiveButton.show(supportFragmentManager, "cannot_leave_dialog");
            return;
        }
        CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
        String string4 = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder title2 = builder2.setTitle(string4);
        String string5 = getString(R.string.leave_playgroup_body);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title2.setBody(string5).setPositiveButtonRed();
        String string6 = getString(R.string.leave_playgroup_short);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        CustomDialogFragment.Builder positiveButton2 = positiveButtonRed.setPositiveButton(string6, new Function2() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PlaygroupDetailsActivity.onUserLeave$lambda$1(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string7 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton2.setNegativeButton(string7, new Function1() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaygroupDetailsActivity.onUserLeave$lambda$2((CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager2 = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
        negativeButton.show(supportFragmentManager2, "leave_playgroup_dialog");
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupUserClickListener
    public void onUserPending(final MTUser user) {
        MTPlaygroup mTPlaygroup;
        Intrinsics.checkNotNullParameter(user, "user");
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        if (currentUser == null || (mTPlaygroup = this.currentPlaygroup) == null || mTPlaygroup.getAdmins().contains(Integer.valueOf(currentUser.getId()))) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = getString(R.string.friend_request_pending_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = getString(R.string.friend_request_pending_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlaygroupDetailsActivity.onUserPending$lambda$1(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string4 = getString(R.string.remove_invite);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder destructiveButton = positiveButton.setDestructiveButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PlaygroupDetailsActivity.onUserPending$lambda$2(this.f$0, user, (CustomDialogFragment) obj);
                }
            });
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            destructiveButton.show(supportFragmentManager, "friend_request_pending_dialog");
        }
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupUserClickListener
    public void onUserRemove(final MTUser userToRemove) {
        Intrinsics.checkNotNullParameter(userToRemove, "userToRemove");
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.remove_from_playgroup_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String firstname = userToRemove.getFirstname();
        if (firstname == null) {
            firstname = "";
        }
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(StringsKt.replace$default(string2, "{1}", firstname, false, 4, (Object) null)).setPositiveButtonRed();
        String string3 = getString(R.string.remove_button);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PlaygroupDetailsActivity.onUserRemove$lambda$0(this.f$0, userToRemove, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaygroupDetailsActivity.onUserRemove$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        negativeButton.show(supportFragmentManager, "leave_playgroup_dialog");
    }

    public final void setCurrentPlaygroup(MTPlaygroup mTPlaygroup) {
        this.currentPlaygroup = mTPlaygroup;
    }

    public final void setSearchJob(Job job) {
        this.searchJob = job;
    }
}
