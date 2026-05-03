package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.common.MimeTypes;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment;
import com.studiolaganne.lengendarylens.ProfileBottomSheetFragment;
import com.studiolaganne.lengendarylens.PromoQRDialogFragment;
import com.studiolaganne.lengendarylens.QrCodeFragment;
import com.studiolaganne.lengendarylens.UpdateUsernameDialogFragment;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: ProfileBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 q2\u00020\u00012\u00020\u0002:\u0001qB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u0002032\u0006\u00108\u001a\u00020\fH\u0016J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\u0018\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020:H\u0002J\b\u0010A\u001a\u000203H\u0002J\b\u0010B\u001a\u000203H\u0002J\b\u0010C\u001a\u000203H\u0016J\u0012\u0010D\u001a\u0002032\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J&\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0010\u0010M\u001a\u00020\f2\u0006\u0010N\u001a\u00020\fH\u0002J\u000e\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020QJ\u0010\u0010R\u001a\u0002032\u0006\u0010S\u001a\u00020\fH\u0002J\b\u0010T\u001a\u000203H\u0002J\u001a\u0010U\u001a\u0002032\u0006\u0010V\u001a\u00020H2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u000e\u0010Y\u001a\u0002032\u0006\u0010Z\u001a\u00020\fJ\u0012\u0010[\u001a\u0004\u0018\u00010\f2\u0006\u0010\\\u001a\u00020\fH\u0002J\u0010\u0010]\u001a\u0002032\u0006\u0010^\u001a\u00020\fH\u0002J\b\u0010_\u001a\u000203H\u0002J\b\u0010`\u001a\u000203H\u0002J\b\u0010a\u001a\u000203H\u0002J\u0018\u0010b\u001a\u00020<2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020fH\u0002J\u0010\u0010g\u001a\u00020<2\u0006\u0010;\u001a\u00020<H\u0002J \u0010h\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010i\u001a\u0002062\u0006\u0010j\u001a\u000206H\u0002J\u0006\u0010k\u001a\u000203J\b\u0010l\u001a\u000203H\u0002J\u0012\u0010m\u001a\u0002032\b\u0010n\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010o\u001a\u0002032\u0006\u0010p\u001a\u00020\fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\f0\f0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020\f0XX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Lcom/studiolaganne/lengendarylens/ProfileBottomSheetFragment;", "Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "Lcom/studiolaganne/lengendarylens/QRScanCallback;", "<init>", "()V", "callback", "Lcom/studiolaganne/lengendarylens/ProfileCallback;", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "displayCurrentUserProfileAsRegularProfile", "", "eventURL", "", "formatsForFilter", "", "Lcom/studiolaganne/lengendarylens/MTFormat;", "filterDefinition", "Lcom/studiolaganne/lengendarylens/FilterDefinition;", "filterActive", "searchActive", "searchJob", "Lkotlinx/coroutines/Job;", "getSearchJob", "()Lkotlinx/coroutines/Job;", "setSearchJob", "(Lkotlinx/coroutines/Job;)V", "currentUserPrivacy", "Lcom/studiolaganne/lengendarylens/MTUserPrivacy;", "viewedUserPrivacy", "viewedUserCode", "privacyToolbarSetup", "qrCodeOK", "getQrCodeOK", "()Z", "setQrCodeOK", "(Z)V", "qrCodeBase64", "getQrCodeBase64", "()Ljava/lang/String;", "setQrCodeBase64", "(Ljava/lang/String;)V", "isCurrentUser", "pickPhotoLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "fragmentList", "", "Landroidx/fragment/app/Fragment;", "requestCameraPermissionLauncher", "kotlin.jvm.PlatformType", "onQRClosed", "", "onFriendCodeConfirmed", "userId", "", "onQRScanned", "value", "bitmapToPngBuffer", "", "bitmap", "Landroid/graphics/Bitmap;", "createMultipartBody", "Lokhttp3/MultipartBody$Part;", "partName", "buffer", "updateFilter", "showFilterBottomSheet", "onStart", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "formatFriendCode", "code", "setImageViewToGrayscale", "imageView", "Landroid/widget/ImageView;", "performSearch", SearchIntents.EXTRA_QUERY, "openAppSettings", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "validPromoHosts", "", "handleQRURL", "qrCode", "resolveRedirects", "url", "processPromoCodeURL", "urlStr", "showInvalidURLDialog", "showOverlay", "hideOverlay", "handleImageRotation", "imageUri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "cropToSquare", "resizeBitmap", "maxWidth", "maxHeight", "closeQRDialog", "setupPrivacyToolbar", "updatePrivacyToolbar", "privacy", "updateProfilePrivacy", "newType", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ProfileBottomSheetFragment extends TransparentBottomSheet implements QRScanCallback {
    private static final String ARG_USER_JSON = "user_json";
    public static final String TAG = "ProfileBottomSheetFragment";
    private ProfileCallback callback;
    private MTUserPrivacy currentUserPrivacy;
    private boolean displayCurrentUserProfileAsRegularProfile;
    private String eventURL;
    private boolean filterActive;
    private ActivityResultLauncher<Intent> pickPhotoLauncher;
    private boolean privacyToolbarSetup;
    private boolean qrCodeOK;
    private final ActivityResultLauncher<String> requestCameraPermissionLauncher;
    private boolean searchActive;
    private Job searchJob;
    private MTUser user;
    private final Set<String> validPromoHosts;
    private String viewedUserCode;
    private MTUserPrivacy viewedUserPrivacy;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private List<MTFormat> formatsForFilter = CollectionsKt.emptyList();
    private FilterDefinition filterDefinition = new FilterDefinition(null, null, null, null, null, null, 63, null);
    private String qrCodeBase64 = "";
    private boolean isCurrentUser = true;
    private List<Fragment> fragmentList = new ArrayList();

    /* JADX INFO: compiled from: ProfileBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/ProfileBottomSheetFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_USER_JSON", "newInstance", "Lcom/studiolaganne/lengendarylens/ProfileBottomSheetFragment;", "callback", "Lcom/studiolaganne/lengendarylens/ProfileCallback;", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "displayAsRegularProfile", "", "eventURL", "(Lcom/studiolaganne/lengendarylens/ProfileCallback;Lcom/studiolaganne/lengendarylens/MTUser;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/ProfileBottomSheetFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ProfileBottomSheetFragment newInstance$default(Companion companion, ProfileCallback profileCallback, MTUser mTUser, Boolean bool, String str, int i, Object obj) {
            if ((i & 4) != 0) {
                bool = false;
            }
            if ((i & 8) != 0) {
                str = null;
            }
            return companion.newInstance(profileCallback, mTUser, bool, str);
        }

        public final ProfileBottomSheetFragment newInstance(ProfileCallback callback, MTUser user, Boolean displayAsRegularProfile, String eventURL) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(user, "user");
            ProfileBottomSheetFragment profileBottomSheetFragment = new ProfileBottomSheetFragment();
            profileBottomSheetFragment.callback = callback;
            profileBottomSheetFragment.eventURL = eventURL;
            profileBottomSheetFragment.displayCurrentUserProfileAsRegularProfile = displayAsRegularProfile != null ? displayAsRegularProfile.booleanValue() : false;
            String json = new Gson().toJson(user);
            Bundle bundle = new Bundle();
            bundle.putString(ProfileBottomSheetFragment.ARG_USER_JSON, json);
            profileBottomSheetFragment.setArguments(bundle);
            return profileBottomSheetFragment;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$handleQRURL$1, reason: invalid class name */
    /* JADX INFO: compiled from: ProfileBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$handleQRURL$1", f = "ProfileBottomSheetFragment.kt", i = {0}, l = {1208}, m = "invokeSuspend", n = {"resolved"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$handleQRURL$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ProfileBottomSheetFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$handleQRURL$1$1", f = "ProfileBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C02111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $resolved;
            int label;
            final /* synthetic */ ProfileBottomSheetFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02111(ProfileBottomSheetFragment profileBottomSheetFragment, String str, Continuation<? super C02111> continuation) {
                super(2, continuation);
                this.this$0 = profileBottomSheetFragment;
                this.$resolved = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02111(this.this$0, this.$resolved, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (this.this$0.getContext() == null || this.this$0.getView() == null) {
                    return Unit.INSTANCE;
                }
                this.this$0.hideOverlay();
                if (this.$resolved == null || !CollectionsKt.contains(this.this$0.validPromoHosts, Uri.parse(this.$resolved).getHost())) {
                    this.this$0.showInvalidURLDialog();
                } else {
                    this.this$0.processPromoCodeURL(this.$resolved);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ProfileBottomSheetFragment.this.new AnonymousClass1(this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String strResolveRedirects = ProfileBottomSheetFragment.this.resolveRedirects(this.$url);
                this.L$0 = SpillingKt.nullOutSpilledVariable(strResolveRedirects);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C02111(ProfileBottomSheetFragment.this, strResolveRedirects, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$processPromoCodeURL$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ProfileBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/ProfileBottomSheetFragment$processPromoCodeURL$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTEventPromoResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C12281 implements Callback<MTEventPromoResponse> {
        final /* synthetic */ PreferencesManager $prefs;
        final /* synthetic */ ViewPager2 $viewPager;

        C12281(PreferencesManager preferencesManager, ViewPager2 viewPager2) {
            this.$prefs = preferencesManager;
            this.$viewPager = viewPager2;
        }

        static final Unit onFailure$lambda$4(boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit onResponse$lambda$2(boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        static final Unit onResponse$lambda$3(boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<MTEventPromoResponse> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = ProfileBottomSheetFragment.this.getString(R.string.promo_code_error_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = ProfileBottomSheetFragment.this.getString(R.string.promo_code_redeem_error);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = ProfileBottomSheetFragment.this.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$processPromoCodeURL$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileBottomSheetFragment.C12281.onFailure$lambda$4(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager childFragmentManager = ProfileBottomSheetFragment.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            positiveButton.show(childFragmentManager, "mtapi_promo_code_dialog");
            ProfileBottomSheetFragment.this.hideOverlay();
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<MTEventPromoResponse> call, Response<MTEventPromoResponse> response) {
            List<MTTheme> themes;
            List<MTTrophy> trophies;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (!response.isSuccessful()) {
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string = ProfileBottomSheetFragment.this.getString(R.string.promo_code_error_title);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CustomDialogFragment.Builder title = builder.setTitle(string);
                String string2 = ProfileBottomSheetFragment.this.getString(R.string.promo_code_redeem_error);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder body = title.setBody(string2);
                String string3 = ProfileBottomSheetFragment.this.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$processPromoCodeURL$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ProfileBottomSheetFragment.C12281.onResponse$lambda$3(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                });
                FragmentManager childFragmentManager = ProfileBottomSheetFragment.this.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                positiveButton.show(childFragmentManager, "mtapi_promo_code_dialog");
            } else {
                if (ProfileBottomSheetFragment.this.getContext() == null) {
                    return;
                }
                MTEventPromoResponse mTEventPromoResponseBody = response.body();
                if (mTEventPromoResponseBody != null && (trophies = mTEventPromoResponseBody.getTrophies()) != null) {
                    ProfileBottomSheetFragment profileBottomSheetFragment = ProfileBottomSheetFragment.this;
                    ViewPager2 viewPager2 = this.$viewPager;
                    if (!trophies.isEmpty()) {
                        Context contextRequireContext = profileBottomSheetFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
                        List<MTTrophy> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getCurrentUserTrophies());
                        for (MTTrophy mTTrophy : trophies) {
                            List<MTTrophy> list = mutableList;
                            if (!(list instanceof Collection) || !list.isEmpty()) {
                                Iterator<T> it = list.iterator();
                                while (it.hasNext()) {
                                    if (((MTTrophy) it.next()).getId() == mTTrophy.getId()) {
                                        break;
                                    }
                                }
                            }
                            mutableList.add(mTTrophy);
                        }
                        preferencesManager.saveCurrentUserTrophies(mutableList);
                        if (profileBottomSheetFragment.fragmentList.size() >= 2) {
                            Object obj = profileBottomSheetFragment.fragmentList.get(1);
                            UserAchievementsFragment userAchievementsFragment = obj instanceof UserAchievementsFragment ? (UserAchievementsFragment) obj : null;
                            if (userAchievementsFragment != null) {
                                userAchievementsFragment.updateTrophies();
                            }
                            if (viewPager2 != null) {
                                viewPager2.setCurrentItem(1);
                            }
                        }
                    }
                }
                boolean z = false;
                if (mTEventPromoResponseBody != null && (themes = mTEventPromoResponseBody.getThemes()) != null) {
                    PreferencesManager preferencesManager2 = this.$prefs;
                    ProfileBottomSheetFragment profileBottomSheetFragment2 = ProfileBottomSheetFragment.this;
                    if (!themes.isEmpty()) {
                        for (MTTheme mTTheme : themes) {
                            preferencesManager2.addThemePurchased(mTTheme.getGoogleproductid());
                            Map<String, Integer> mutableMap = MapsKt.toMutableMap(preferencesManager2.getAllThemeVersions());
                            mutableMap.put(mTTheme.getGoogleproductid(), Integer.valueOf(mTTheme.getVersion()));
                            preferencesManager2.saveAllThemeVersions(mutableMap);
                            List<MTTheme> mutableList2 = CollectionsKt.toMutableList((Collection) preferencesManager2.getLocalThemesCache());
                            List<MTTheme> list2 = mutableList2;
                            if ((list2 instanceof Collection) && list2.isEmpty()) {
                                mutableList2.add(mTTheme);
                                preferencesManager2.setBoolean(PreferencesManager.REFRESH_THEMES, true);
                            } else {
                                Iterator<T> it2 = list2.iterator();
                                while (it2.hasNext()) {
                                    if (((MTTheme) it2.next()).getId() == mTTheme.getId()) {
                                        break;
                                    }
                                }
                                mutableList2.add(mTTheme);
                                preferencesManager2.setBoolean(PreferencesManager.REFRESH_THEMES, true);
                            }
                            preferencesManager2.saveLocalThemesCache(mutableList2);
                        }
                        MTTheme mTTheme2 = (MTTheme) CollectionsKt.first((List) themes);
                        Intent intent = new Intent(profileBottomSheetFragment2.requireContext(), (Class<?>) DownloadThemeActivity.class);
                        intent.putExtra("fromQRCode", true);
                        List<MTTrophy> trophies2 = mTEventPromoResponseBody.getTrophies();
                        if (trophies2 != null && !trophies2.isEmpty()) {
                            intent.putExtra("withTrophyId", ((MTTrophy) CollectionsKt.first((List) trophies2)).getId());
                        }
                        intent.putExtra("theme", new Gson().toJson(mTTheme2));
                        intent.putExtra("byCode", true);
                        profileBottomSheetFragment2.startActivity(intent);
                        z = true;
                    }
                }
                this.$prefs.setForcedApiUpdate(true);
                if (!z) {
                    CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
                    String string4 = ProfileBottomSheetFragment.this.getString(R.string.promo_code_success_title);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    CustomDialogFragment.Builder title2 = builder2.setTitle(string4);
                    String string5 = ProfileBottomSheetFragment.this.getString(R.string.promo_code_redeem_success);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    CustomDialogFragment.Builder body2 = title2.setBody(string5);
                    String string6 = ProfileBottomSheetFragment.this.getString(R.string.ok);
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    CustomDialogFragment.Builder positiveButton2 = body2.setPositiveButton(string6, new Function2() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$processPromoCodeURL$1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return ProfileBottomSheetFragment.C12281.onResponse$lambda$2(((Boolean) obj2).booleanValue(), (CustomDialogFragment) obj3);
                        }
                    });
                    FragmentManager childFragmentManager2 = ProfileBottomSheetFragment.this.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
                    positiveButton2.show(childFragmentManager2, "mtapi_promo_code_dialog");
                }
            }
            ProfileBottomSheetFragment.this.hideOverlay();
        }
    }

    public ProfileBottomSheetFragment() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ProfileBottomSheetFragment.requestCameraPermissionLauncher$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.requestCameraPermissionLauncher = activityResultLauncherRegisterForActivityResult;
        this.validPromoHosts = SetsKt.setOf((Object[]) new String[]{"mythic.tools", "artifact.mythic.tools"});
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

    private final String formatFriendCode(String code) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideOverlay() {
        ConstraintLayout constraintLayout;
        View view = getView();
        if (view == null || (constraintLayout = (ConstraintLayout) view.findViewById(R.id.overlay)) == null) {
            return;
        }
        constraintLayout.setVisibility(8);
    }

    static final void onCreateView$lambda$0(final ProfileBottomSheetFragment profileBottomSheetFragment, ActivityResult result) {
        ConstraintLayout constraintLayout;
        Intrinsics.checkNotNullParameter(result, "result");
        if (profileBottomSheetFragment.getContext() == null) {
            return;
        }
        Intent data = result.getData();
        MTUser mTUser = null;
        Uri data2 = data != null ? data.getData() : null;
        if (data2 != null) {
            Context contextRequireContext = profileBottomSheetFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            MultipartBody.Part partCreateMultipartBody = profileBottomSheetFragment.createMultipartBody("file", profileBottomSheetFragment.bitmapToPngBuffer(profileBottomSheetFragment.resizeBitmap(profileBottomSheetFragment.cropToSquare(profileBottomSheetFragment.handleImageRotation(data2, contextRequireContext)), 128, 128)));
            View view = profileBottomSheetFragment.getView();
            if (view != null && (constraintLayout = (ConstraintLayout) view.findViewById(R.id.overlay)) != null) {
                constraintLayout.setVisibility(0);
            }
            MTApi mtApi = MTApiKt.getMtApi();
            MTUser mTUser2 = profileBottomSheetFragment.user;
            if (mTUser2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            } else {
                mTUser = mTUser2;
            }
            mtApi.updateProfilePicture(mTUser.getId(), partCreateMultipartBody).enqueue(new Callback<MTUserResponse>() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$onCreateView$1$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTUserResponse> call, Throwable t) {
                    ConstraintLayout constraintLayout2;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    View view2 = this.this$0.getView();
                    if (view2 == null || (constraintLayout2 = (ConstraintLayout) view2.findViewById(R.id.overlay)) == null) {
                        return;
                    }
                    constraintLayout2.setVisibility(8);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTUserResponse> call, Response<MTUserResponse> response) {
                    ConstraintLayout constraintLayout2;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (!response.isSuccessful()) {
                        Log.d("MTApi", "Update profile picture code error: " + response.errorBody());
                    } else {
                        if (this.this$0.getContext() == null) {
                            return;
                        }
                        MTUserResponse mTUserResponseBody = response.body();
                        MTUser user = mTUserResponseBody != null ? mTUserResponseBody.getUser() : null;
                        if (user != null) {
                            ProfileBottomSheetFragment profileBottomSheetFragment2 = this.this$0;
                            Context contextRequireContext2 = profileBottomSheetFragment2.requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                            new PreferencesManager(contextRequireContext2).saveCurrentUser(user);
                            ProfileCallback profileCallback = profileBottomSheetFragment2.callback;
                            if (profileCallback != null) {
                                profileCallback.onProfilePictureUpdated();
                            }
                            View view2 = profileBottomSheetFragment2.getView();
                            CachedImageView cachedImageView = view2 != null ? (CachedImageView) view2.findViewById(R.id.profile_icon) : null;
                            View view3 = profileBottomSheetFragment2.getView();
                            ImageView imageView = view3 != null ? (ImageView) view3.findViewById(R.id.no_photo_icon) : null;
                            if (cachedImageView != null) {
                                cachedImageView.reset();
                                cachedImageView.setAutoLoad(false);
                                String picture = user.getPicture();
                                if (picture == null) {
                                    picture = "";
                                }
                                cachedImageView.loadImage(picture);
                                cachedImageView.setVisibility(0);
                                if (imageView != null) {
                                    imageView.setVisibility(4);
                                }
                            }
                        }
                    }
                    View view4 = this.this$0.getView();
                    if (view4 == null || (constraintLayout2 = (ConstraintLayout) view4.findViewById(R.id.overlay)) == null) {
                        return;
                    }
                    constraintLayout2.setVisibility(8);
                }
            });
        }
    }

    static final Unit onViewCreated$lambda$0(ProfileBottomSheetFragment profileBottomSheetFragment) {
        ProfileCallback profileCallback = profileBottomSheetFragment.callback;
        if (profileCallback != null) {
            profileCallback.onProfileClose();
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$1(ProfileBottomSheetFragment profileBottomSheetFragment, LinearLayout linearLayout, LinearLayout linearLayout2) {
        profileBottomSheetFragment.filterDefinition = new FilterDefinition(null, null, null, null, null, null, 63, null);
        profileBottomSheetFragment.filterActive = false;
        linearLayout.setVisibility(0);
        linearLayout2.setVisibility(8);
        profileBottomSheetFragment.updateFilter();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$10(final ProfileBottomSheetFragment profileBottomSheetFragment, final View view) {
        if (profileBottomSheetFragment.getActivity() != null && profileBottomSheetFragment.isCurrentUser) {
            UpdateUsernameDialogFragment.Builder builder = new UpdateUsernameDialogFragment.Builder();
            String string = profileBottomSheetFragment.getString(R.string.update_username);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            UpdateUsernameDialogFragment.Builder title = builder.setTitle(string);
            MTUser mTUser = profileBottomSheetFragment.user;
            MTUser mTUser2 = null;
            if (mTUser == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
                mTUser = null;
            }
            UpdateUsernameDialogFragment.Builder user = title.setUser(mTUser);
            MTUser mTUser3 = profileBottomSheetFragment.user;
            if (mTUser3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            } else {
                mTUser2 = mTUser3;
            }
            String username = mTUser2.getUsername();
            if (username == null) {
                username = "";
            }
            user.setEditTextValue(username).setPositiveButtonCallback(new Function2() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileBottomSheetFragment.onViewCreated$lambda$10$0(this.f$0, view, (String) obj, (UpdateUsernameDialogFragment) obj2);
                }
            }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileBottomSheetFragment.onViewCreated$lambda$10$1((UpdateUsernameDialogFragment) obj);
                }
            }).build().show(profileBottomSheetFragment.requireActivity().getSupportFragmentManager(), "UpdateUsernameDialogFragment");
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$10$0(ProfileBottomSheetFragment profileBottomSheetFragment, View view, String newUsername, UpdateUsernameDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(newUsername, "newUsername");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (profileBottomSheetFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        MTUser mTUser = profileBottomSheetFragment.user;
        MTUser mTUser2 = null;
        if (mTUser == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
            mTUser = null;
        }
        mTUser.setUsername(newUsername);
        Context contextRequireContext = profileBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser mTUser3 = profileBottomSheetFragment.user;
        if (mTUser3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
        } else {
            mTUser2 = mTUser3;
        }
        preferencesManager.saveCurrentUser(mTUser2);
        ((TextView) view.findViewById(R.id.playerUsername)).setText("@" + newUsername);
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$10$1(UpdateUsernameDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$11(ProfileBottomSheetFragment profileBottomSheetFragment) {
        if (profileBottomSheetFragment.qrCodeOK) {
            if (profileBottomSheetFragment.getActivity() == null) {
                return Unit.INSTANCE;
            }
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(profileBottomSheetFragment.requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            MTUser mTUser = null;
            firebaseAnalytics.logEvent("qr_code_click_profile", null);
            QrCodeFragment.Builder qrCodeBase64 = new QrCodeFragment.Builder().setQrCodeBase64(profileBottomSheetFragment.qrCodeBase64);
            MTUser mTUser2 = profileBottomSheetFragment.user;
            if (mTUser2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            } else {
                mTUser = mTUser2;
            }
            String username = mTUser.getUsername();
            if (username == null) {
                username = "";
            }
            QrCodeFragment.Builder userName = qrCodeBase64.setUserName(username);
            FragmentManager supportFragmentManager = profileBottomSheetFragment.requireActivity().getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            userName.show(supportFragmentManager, "QrCodeFragment");
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$2(ProfileBottomSheetFragment profileBottomSheetFragment) {
        profileBottomSheetFragment.showFilterBottomSheet();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$26(ViewPager2 viewPager2, int i) {
        viewPager2.setCurrentItem(i);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$27(final ProfileBottomSheetFragment profileBottomSheetFragment) {
        if (profileBottomSheetFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = profileBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(profileBottomSheetFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("scan_promo_code_click_profile", null);
        if (ContextCompat.checkSelfPermission(profileBottomSheetFragment.requireContext(), "android.permission.CAMERA") == 0) {
            PromoQRDialogFragment.Builder onDismissListener = new PromoQRDialogFragment.Builder().setOnQRDetectedListener(new Function1() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileBottomSheetFragment.onViewCreated$lambda$27$4(this.f$0, (String) obj);
                }
            }).setOnDismissListener(new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ProfileBottomSheetFragment.onViewCreated$lambda$27$5(this.f$0);
                }
            });
            FragmentManager childFragmentManager = profileBottomSheetFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            onDismissListener.show(childFragmentManager);
        } else if (!preferencesManager.getBoolean(PreferencesManager.CAMERA_PERMISSION_ASKED_BEFORE, false)) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = profileBottomSheetFragment.getString(R.string.permissions_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = profileBottomSheetFragment.getString(R.string.camera_permission_rationale_event_qr);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
            String string3 = profileBottomSheetFragment.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileBottomSheetFragment.onViewCreated$lambda$27$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string4 = profileBottomSheetFragment.getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileBottomSheetFragment.onViewCreated$lambda$27$1((CustomDialogFragment) obj);
                }
            });
            FragmentManager childFragmentManager2 = profileBottomSheetFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            negativeButton.show(childFragmentManager2, "camera_permission_dialog");
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(profileBottomSheetFragment.requireActivity(), "android.permission.CAMERA")) {
            profileBottomSheetFragment.requestCameraPermissionLauncher.launch("android.permission.CAMERA");
        } else {
            CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
            String string5 = profileBottomSheetFragment.getString(R.string.permissions_title);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            CustomDialogFragment.Builder title2 = builder2.setTitle(string5);
            String string6 = profileBottomSheetFragment.getString(R.string.camera_permission_denied_message);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            CustomDialogFragment.Builder positiveButtonRed2 = title2.setBody(string6).setPositiveButtonRed();
            String string7 = profileBottomSheetFragment.getString(R.string.open_settings);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            CustomDialogFragment.Builder positiveButton2 = positiveButtonRed2.setPositiveButton(string7, new Function2() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileBottomSheetFragment.onViewCreated$lambda$27$2(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string8 = profileBottomSheetFragment.getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            CustomDialogFragment.Builder negativeButton2 = positiveButton2.setNegativeButton(string8, new Function1() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileBottomSheetFragment.onViewCreated$lambda$27$3((CustomDialogFragment) obj);
                }
            });
            FragmentManager childFragmentManager3 = profileBottomSheetFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager3, "getChildFragmentManager(...)");
            negativeButton2.show(childFragmentManager3, "camera_permission_settings_dialog");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$27$0(ProfileBottomSheetFragment profileBottomSheetFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        profileBottomSheetFragment.requestCameraPermissionLauncher.launch("android.permission.CAMERA");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$27$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$27$2(ProfileBottomSheetFragment profileBottomSheetFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        profileBottomSheetFragment.openAppSettings();
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$27$3(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$27$4(ProfileBottomSheetFragment profileBottomSheetFragment, String qrCode) {
        Intrinsics.checkNotNullParameter(qrCode, "qrCode");
        if (profileBottomSheetFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        profileBottomSheetFragment.handleQRURL(qrCode);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$27$5(ProfileBottomSheetFragment profileBottomSheetFragment) {
        profileBottomSheetFragment.closeQRDialog();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$3(ProfileBottomSheetFragment profileBottomSheetFragment) {
        profileBottomSheetFragment.showFilterBottomSheet();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$4(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, EditText editText, ProfileBottomSheetFragment profileBottomSheetFragment) {
        constraintLayout.setVisibility(8);
        constraintLayout2.setVisibility(8);
        constraintLayout3.setVisibility(0);
        editText.setText("");
        editText.requestFocus();
        FragmentActivity activity = profileBottomSheetFragment.getActivity();
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(editText, 1);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$5(ProfileBottomSheetFragment profileBottomSheetFragment, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3) {
        profileBottomSheetFragment.searchActive = false;
        constraintLayout.setVisibility(8);
        constraintLayout2.setVisibility(0);
        constraintLayout3.setVisibility(0);
        if (profileBottomSheetFragment.fragmentList.size() >= 4) {
            Fragment fragment = profileBottomSheetFragment.fragmentList.get(3);
            UserGamesFragment userGamesFragment = fragment instanceof UserGamesFragment ? (UserGamesFragment) fragment : null;
            if (userGamesFragment != null) {
                userGamesFragment.resetSearch();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$6(final ProfileBottomSheetFragment profileBottomSheetFragment) {
        Context contextRequireContext = profileBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        GameState currentGame = preferencesManager.getCurrentGame();
        if (currentGame == null || (currentGame.getPlaygroupId() == -1 && !currentGame.getGameSyncable())) {
            ProfileCallback profileCallback = profileBottomSheetFragment.callback;
            if (profileCallback != null) {
                profileCallback.onProfileLogout();
            }
            return Unit.INSTANCE;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = profileBottomSheetFragment.getString(R.string.game_in_progress_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = profileBottomSheetFragment.getString(R.string.game_in_progress_logout_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = profileBottomSheetFragment.getString(R.string.discard);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = body.setDestructiveButton(string3, new Function1() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileBottomSheetFragment.onViewCreated$lambda$6$0(preferencesManager, profileBottomSheetFragment, (CustomDialogFragment) obj);
            }
        }).setPositiveButtonRed();
        String string4 = profileBottomSheetFragment.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string4, new Function2() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ProfileBottomSheetFragment.onViewCreated$lambda$6$1(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = profileBottomSheetFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "CustomDialogFragment");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6$0(PreferencesManager preferencesManager, ProfileBottomSheetFragment profileBottomSheetFragment, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        preferencesManager.clearCurrentGame();
        ProfileCallback profileCallback = profileBottomSheetFragment.callback;
        if (profileCallback != null) {
            profileCallback.onProfileLogout();
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6$1(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$7(ProfileBottomSheetFragment profileBottomSheetFragment) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        ActivityResultLauncher<Intent> activityResultLauncher = profileBottomSheetFragment.pickPhotoLauncher;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(intent);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$8(final ProfileBottomSheetFragment profileBottomSheetFragment) {
        if (profileBottomSheetFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        if (profileBottomSheetFragment.isCurrentUser) {
            Context contextRequireContext = profileBottomSheetFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(profileBottomSheetFragment.requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("friend_code_click_profile", null);
            if (currentUser != null) {
                QRScanBottomSheetFragment.INSTANCE.newInstanceFriendCodeOnly(profileBottomSheetFragment, currentUser).show(profileBottomSheetFragment.getChildFragmentManager(), QRScanBottomSheetFragment.TAG);
            }
        } else {
            final String str = profileBottomSheetFragment.viewedUserCode;
            if (str == null) {
                return Unit.INSTANCE;
            }
            new AlertDialog.Builder(profileBottomSheetFragment.requireContext()).setTitle(profileBottomSheetFragment.getString(R.string.by_friend_code)).setMessage(profileBottomSheetFragment.formatFriendCode(str)).setPositiveButton(profileBottomSheetFragment.getString(R.string.copy), new DialogInterface.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda37
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ProfileBottomSheetFragment.onViewCreated$lambda$8$1(this.f$0, str, dialogInterface, i);
                }
            }).setNegativeButton(profileBottomSheetFragment.getString(R.string.close), (DialogInterface.OnClickListener) null).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$8$1(ProfileBottomSheetFragment profileBottomSheetFragment, String str, DialogInterface dialogInterface, int i) {
        Object systemService = profileBottomSheetFragment.requireContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Mythic code", str));
        Toast.makeText(profileBottomSheetFragment.requireContext(), profileBottomSheetFragment.getString(R.string.code_copied), 0).show();
        dialogInterface.dismiss();
    }

    static final Unit onViewCreated$lambda$9(final ProfileBottomSheetFragment profileBottomSheetFragment, final View view) {
        if (profileBottomSheetFragment.getActivity() != null && profileBottomSheetFragment.isCurrentUser) {
            UpdateUsernameDialogFragment.Builder builder = new UpdateUsernameDialogFragment.Builder();
            String string = profileBottomSheetFragment.getString(R.string.update_firstname);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            UpdateUsernameDialogFragment.Builder title = builder.setTitle(string);
            MTUser mTUser = profileBottomSheetFragment.user;
            MTUser mTUser2 = null;
            if (mTUser == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
                mTUser = null;
            }
            UpdateUsernameDialogFragment.Builder editFirstName = title.setUser(mTUser).setEditFirstName();
            MTUser mTUser3 = profileBottomSheetFragment.user;
            if (mTUser3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            } else {
                mTUser2 = mTUser3;
            }
            String firstname = mTUser2.getFirstname();
            if (firstname == null) {
                firstname = "";
            }
            editFirstName.setEditTextValue(firstname).setPositiveButtonCallback(new Function2() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda38
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileBottomSheetFragment.onViewCreated$lambda$9$0(this.f$0, view, (String) obj, (UpdateUsernameDialogFragment) obj2);
                }
            }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileBottomSheetFragment.onViewCreated$lambda$9$1((UpdateUsernameDialogFragment) obj);
                }
            }).build().show(profileBottomSheetFragment.requireActivity().getSupportFragmentManager(), "UpdateUsernameDialogFragment");
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$9$0(ProfileBottomSheetFragment profileBottomSheetFragment, View view, String newname, UpdateUsernameDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(newname, "newname");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (profileBottomSheetFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        MTUser mTUser = profileBottomSheetFragment.user;
        MTUser mTUser2 = null;
        if (mTUser == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
            mTUser = null;
        }
        mTUser.setFirstname(newname);
        Context contextRequireContext = profileBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser mTUser3 = profileBottomSheetFragment.user;
        if (mTUser3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
        } else {
            mTUser2 = mTUser3;
        }
        preferencesManager.saveCurrentUser(mTUser2);
        ((TextView) view.findViewById(R.id.playerFirstName)).setText(newname);
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$9$1(UpdateUsernameDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.dismiss();
        return Unit.INSTANCE;
    }

    private final void openAppSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", requireContext().getPackageName(), null));
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performSearch(String query) {
        this.searchActive = true;
        if (this.fragmentList.size() >= 4) {
            Fragment fragment = this.fragmentList.get(3);
            UserGamesFragment userGamesFragment = fragment instanceof UserGamesFragment ? (UserGamesFragment) fragment : null;
            if (userGamesFragment != null) {
                userGamesFragment.performSearch(query);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processPromoCodeURL(String urlStr) {
        Integer intOrNull;
        if (getContext() == null || getView() == null) {
            return;
        }
        View view = getView();
        ViewPager2 viewPager2 = view != null ? (ViewPager2) view.findViewById(R.id.view_pager) : null;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null) {
            return;
        }
        Log.d(TAG, "Processing promo code URL: " + urlStr);
        showOverlay();
        String strSubstringAfter = StringsKt.substringAfter(urlStr, "code=", "");
        String str = strSubstringAfter;
        int iIntValue = (str.length() != 0 || (intOrNull = StringsKt.toIntOrNull(StringsKt.substringAfter(urlStr, "mobile/event/", ""))) == null) ? -1 : intOrNull.intValue();
        MTPromoCodeBody mTPromoCodeBody = new MTPromoCodeBody(null, null, MTApiKt.getLocale());
        if (str.length() > 0) {
            mTPromoCodeBody.setCode(strSubstringAfter);
        }
        if (iIntValue != -1) {
            mTPromoCodeBody.setEvent(Integer.valueOf(iIntValue));
        }
        MTApiKt.getMtApi().redeemPromoCode(currentUser.getId(), mTPromoCodeBody).enqueue(new C12281(preferencesManager, viewPager2));
    }

    static final void requestCameraPermissionLauncher$lambda$0(final ProfileBottomSheetFragment profileBottomSheetFragment, boolean z) {
        if (profileBottomSheetFragment.getContext() == null) {
            return;
        }
        Context contextRequireContext = profileBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        preferencesManager.setBoolean(PreferencesManager.CAMERA_PERMISSION_ASKED_BEFORE, true);
        if (!z) {
            Toast.makeText(profileBottomSheetFragment.requireContext(), profileBottomSheetFragment.getString(R.string.camera_permission_denied_qr), 1).show();
            return;
        }
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (!preferencesManager.hasValidUser() || currentUser == null) {
            return;
        }
        PromoQRDialogFragment.Builder onDismissListener = new PromoQRDialogFragment.Builder().setOnQRDetectedListener(new Function1() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileBottomSheetFragment.requestCameraPermissionLauncher$lambda$0$0$0(this.f$0, (String) obj);
            }
        }).setOnDismissListener(new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBottomSheetFragment.requestCameraPermissionLauncher$lambda$0$0$1(this.f$0);
            }
        });
        FragmentManager childFragmentManager = profileBottomSheetFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        onDismissListener.show(childFragmentManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestCameraPermissionLauncher$lambda$0$0$0(ProfileBottomSheetFragment profileBottomSheetFragment, String qrCode) {
        Intrinsics.checkNotNullParameter(qrCode, "qrCode");
        if (profileBottomSheetFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        profileBottomSheetFragment.handleQRURL(qrCode);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestCameraPermissionLauncher$lambda$0$0$1(ProfileBottomSheetFragment profileBottomSheetFragment) {
        profileBottomSheetFragment.closeQRDialog();
        return Unit.INSTANCE;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final String resolveRedirects(String url) {
        try {
            okhttp3.Response responseExecute = new OkHttpClient.Builder().followRedirects(true).followSslRedirects(true).connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).build().newCall(new Request.Builder().url(url).head().build()).execute();
            try {
                String url2 = responseExecute.request().url().getUrl();
                CloseableKt.closeFinally(responseExecute, null);
                return url2;
            } finally {
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to resolve redirects for " + url, e);
            return null;
        }
    }

    private final void setupPrivacyToolbar() {
        View viewFindViewById;
        if (this.privacyToolbarSetup) {
            return;
        }
        this.privacyToolbarSetup = true;
        View view = getView();
        if (view == null || (viewFindViewById = view.findViewById(R.id.privacyToolbarLayout)) == null) {
            return;
        }
        final LinearLayout linearLayout = (LinearLayout) viewFindViewById.findViewById(R.id.privacySelectorContainer);
        TextView textView = (TextView) viewFindViewById.findViewById(R.id.sharingIcon);
        TextView textView2 = (TextView) viewFindViewById.findViewById(R.id.privacySettingsIcon);
        TextView textView3 = (TextView) viewFindViewById.findViewById(R.id.circlesIcon);
        Intrinsics.checkNotNull(textView3);
        ViewExtensionsKt.setOnClickWithFade(textView3, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBottomSheetFragment.setupPrivacyToolbar$lambda$0(this.f$0);
            }
        });
        if (linearLayout != null) {
            ViewExtensionsKt.setOnClickWithFade(linearLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ProfileBottomSheetFragment.setupPrivacyToolbar$lambda$1(this.f$0, linearLayout);
                }
            });
        }
        if (textView != null) {
            ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ProfileBottomSheetFragment.setupPrivacyToolbar$lambda$2(this.f$0);
                }
            });
        }
        if (textView2 != null) {
            ViewExtensionsKt.setOnClickWithFade(textView2, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ProfileBottomSheetFragment.setupPrivacyToolbar$lambda$3(this.f$0);
                }
            });
        }
    }

    static final Unit setupPrivacyToolbar$lambda$0(ProfileBottomSheetFragment profileBottomSheetFragment) {
        profileBottomSheetFragment.startActivity(new Intent(profileBottomSheetFragment.requireContext(), (Class<?>) CirclesListActivity.class));
        return Unit.INSTANCE;
    }

    static final Unit setupPrivacyToolbar$lambda$1(final ProfileBottomSheetFragment profileBottomSheetFragment, LinearLayout linearLayout) {
        String type;
        MTUserPrivacy mTUserPrivacy = profileBottomSheetFragment.currentUserPrivacy;
        if (mTUserPrivacy == null || (type = mTUserPrivacy.getType()) == null) {
            type = MTApiKt.PRIVACY_TYPE_UNLISTED;
        }
        Context contextRequireContext = profileBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PrivacyPopupMenu.show$default(new PrivacyPopupMenu(contextRequireContext, type, PrivacyContext.PROFILE, new Function1() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileBottomSheetFragment.setupPrivacyToolbar$lambda$1$0(this.f$0, (String) obj);
            }
        }), linearLayout, false, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupPrivacyToolbar$lambda$1$0(ProfileBottomSheetFragment profileBottomSheetFragment, String newType) {
        Intrinsics.checkNotNullParameter(newType, "newType");
        profileBottomSheetFragment.updateProfilePrivacy(newType);
        return Unit.INSTANCE;
    }

    static final Unit setupPrivacyToolbar$lambda$2(ProfileBottomSheetFragment profileBottomSheetFragment) {
        Context context = profileBottomSheetFragment.getContext();
        if (context == null) {
            return Unit.INSTANCE;
        }
        MythicLinkGenerator mythicLinkGenerator = MythicLinkGenerator.INSTANCE;
        MTUser mTUser = profileBottomSheetFragment.user;
        if (mTUser == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
            mTUser = null;
        }
        String userProfileUrl = mythicLinkGenerator.getUserProfileUrl(mTUser.getId());
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("profile_url", userProfileUrl));
        Toast.makeText(context, R.string.link_copied_to_clipboard, 0).show();
        return Unit.INSTANCE;
    }

    static final Unit setupPrivacyToolbar$lambda$3(final ProfileBottomSheetFragment profileBottomSheetFragment) {
        MTUserPrivacy mTUserPrivacy = profileBottomSheetFragment.currentUserPrivacy;
        if (mTUserPrivacy == null) {
            return Unit.INSTANCE;
        }
        PrivacySettingsDialogFragment.Builder onUserPrivacyUpdated = new PrivacySettingsDialogFragment.Builder().setPrivacyContext(PrivacyContext.PROFILE).setCurrentUserPrivacy(mTUserPrivacy).setOnUserPrivacyUpdated(new Function1() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileBottomSheetFragment.setupPrivacyToolbar$lambda$3$0(this.f$0, (MTUserPrivacy) obj);
            }
        });
        FragmentManager childFragmentManager = profileBottomSheetFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        onUserPrivacyUpdated.show(childFragmentManager, "PrivacySettingsDialog");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupPrivacyToolbar$lambda$3$0(ProfileBottomSheetFragment profileBottomSheetFragment, MTUserPrivacy updated) {
        Intrinsics.checkNotNullParameter(updated, "updated");
        profileBottomSheetFragment.currentUserPrivacy = updated;
        if (profileBottomSheetFragment.getContext() != null) {
            Context contextRequireContext = profileBottomSheetFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            new PreferencesManager(contextRequireContext).saveCurrentUserPrivacy(updated);
        }
        profileBottomSheetFragment.updatePrivacyToolbar(updated);
        return Unit.INSTANCE;
    }

    private final void showFilterBottomSheet() {
        FilterBottomSheetFragment.INSTANCE.newInstance(new FilterCallback() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$showFilterBottomSheet$bottomSheet$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.studiolaganne.lengendarylens.FilterCallback
            public void onApplyFilter(FilterDefinition filter) {
                String name;
                int i;
                List<MTTag> games;
                Object next;
                Intrinsics.checkNotNullParameter(filter, "filter");
                if (this.this$0.getContext() == null) {
                    return;
                }
                this.this$0.filterDefinition = filter;
                View view = this.this$0.getView();
                Object obj = null;
                LinearLayout linearLayout = view != null ? (LinearLayout) view.findViewById(R.id.masterFilterLayout) : null;
                View view2 = this.this$0.getView();
                LinearLayout linearLayout2 = view2 != null ? (LinearLayout) view2.findViewById(R.id.activeFilterLayout) : null;
                View view3 = this.this$0.getView();
                TextView textView = view3 != null ? (TextView) view3.findViewById(R.id.activeFilterTitle) : null;
                View view4 = this.this$0.getView();
                TextView textView2 = view4 != null ? (TextView) view4.findViewById(R.id.plusTextView) : null;
                View view5 = this.this$0.getView();
                TextView textView3 = view5 != null ? (TextView) view5.findViewById(R.id.tagName) : null;
                View view6 = this.this$0.getView();
                TextView textView4 = view6 != null ? (TextView) view6.findViewById(R.id.numFilterTextView) : null;
                View view7 = this.this$0.getView();
                LinearLayout linearLayout3 = view7 != null ? (LinearLayout) view7.findViewById(R.id.activeTagLayout) : null;
                if (filter.getFormatId() == null && filter.getSubformatId() == null && filter.getTagId() == null) {
                    this.this$0.filterActive = false;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                } else {
                    this.this$0.filterActive = true;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                    }
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
                    if (textView != null) {
                        textView.setText(name);
                    }
                    Integer subformatId = filter.getSubformatId();
                    if (subformatId != null) {
                        subformatId.intValue();
                        if (textView != null) {
                            String subformatName = filter.getSubformatName();
                            if (subformatName == null) {
                                subformatName = "";
                            }
                            textView.setText(((Object) name) + " - " + subformatName);
                        }
                        i++;
                    }
                    if (filter.getFormatId() == null && filter.getSubformatId() == null) {
                        if (textView != null) {
                            textView.setVisibility(8);
                        }
                        if (textView2 != null) {
                            textView2.setVisibility(8);
                        }
                    } else {
                        if (textView != null) {
                            textView.setVisibility(0);
                        }
                        if (textView2 != null) {
                            textView2.setVisibility(0);
                        }
                    }
                    Integer tagId = filter.getTagId();
                    if (tagId != null) {
                        ProfileBottomSheetFragment profileBottomSheetFragment = this.this$0;
                        tagId.intValue();
                        Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        objectRef.element = "";
                        Context contextRequireContext = profileBottomSheetFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                        MTUserTags currentUserTags = new PreferencesManager(contextRequireContext).getCurrentUserTags();
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
                        if (textView3 != null) {
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
                        }
                        if (linearLayout3 != null) {
                            linearLayout3.setVisibility(0);
                        }
                        i++;
                    } else if (linearLayout3 != null) {
                        linearLayout3.setVisibility(8);
                    }
                    if (textView4 != null) {
                        textView4.setText(String.valueOf(i));
                    }
                }
                this.this$0.updateFilter();
            }
        }, this.filterDefinition).show(getChildFragmentManager(), FilterBottomSheetFragment.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showInvalidURLDialog() {
        if (getContext() == null) {
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.promo_code_error_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.invalid_url);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ProfileBottomSheetFragment.showInvalidURLDialog$lambda$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "mtapi_promo_code_dialog");
    }

    static final Unit showInvalidURLDialog$lambda$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void showOverlay() {
        ConstraintLayout constraintLayout;
        View view = getView();
        if (view == null || (constraintLayout = (ConstraintLayout) view.findViewById(R.id.overlay)) == null) {
            return;
        }
        constraintLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFilter() {
        if (this.fragmentList.size() >= 4) {
            Fragment fragment = this.fragmentList.get(0);
            UserStatsFragment userStatsFragment = fragment instanceof UserStatsFragment ? (UserStatsFragment) fragment : null;
            if (userStatsFragment != null) {
                userStatsFragment.updateFilter(this.filterDefinition);
            }
            Fragment fragment2 = this.fragmentList.get(2);
            UserDecksFragment userDecksFragment = fragment2 instanceof UserDecksFragment ? (UserDecksFragment) fragment2 : null;
            if (userDecksFragment != null) {
                userDecksFragment.updateFilter(this.filterDefinition);
            }
            Fragment fragment3 = this.fragmentList.get(3);
            UserGamesFragment userGamesFragment = fragment3 instanceof UserGamesFragment ? (UserGamesFragment) fragment3 : null;
            if (userGamesFragment != null) {
                userGamesFragment.updateFilter(this.filterDefinition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updatePrivacyToolbar(MTUserPrivacy privacy) {
        View viewFindViewById;
        Pair pair;
        View view = getView();
        if (view == null || (viewFindViewById = view.findViewById(R.id.privacyToolbarLayout)) == null) {
            return;
        }
        if (privacy == null) {
            viewFindViewById.setVisibility(8);
            return;
        }
        viewFindViewById.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) viewFindViewById.findViewById(R.id.privacySelectorContainer);
        TextView textView = (TextView) viewFindViewById.findViewById(R.id.privacyLabel);
        TextView textView2 = (TextView) viewFindViewById.findViewById(R.id.sharingIcon);
        TextView textView3 = (TextView) viewFindViewById.findViewById(R.id.separatorIcon);
        ((TextView) viewFindViewById.findViewById(R.id.separatorIconCircles)).setVisibility(0);
        ((TextView) viewFindViewById.findViewById(R.id.circlesIcon)).setVisibility(0);
        String type = privacy.getType();
        if (type != null) {
            switch (type.hashCode()) {
                case -977423767:
                    pair = !type.equals(MTApiKt.PRIVACY_TYPE_PUBLIC) ? new Pair(Integer.valueOf(R.string.privacy_unlisted), Integer.valueOf(R.drawable.privacy_selector_background_unlisted)) : new Pair(Integer.valueOf(R.string.privacy_public), Integer.valueOf(R.drawable.privacy_selector_background_public));
                    break;
                case -903566235:
                    if (type.equals(MTApiKt.PRIVACY_TYPE_SHARED)) {
                        pair = new Pair(Integer.valueOf(R.string.privacy_shared), Integer.valueOf(R.drawable.privacy_selector_background_shared));
                        break;
                    }
                    break;
                case -314497661:
                    if (type.equals(MTApiKt.PRIVACY_TYPE_PRIVATE)) {
                        pair = new Pair(Integer.valueOf(R.string.privacy_private), Integer.valueOf(R.drawable.privacy_selector_background_private));
                        break;
                    }
                    break;
                case -216005226:
                    if (type.equals(MTApiKt.PRIVACY_TYPE_UNLISTED)) {
                        pair = new Pair(Integer.valueOf(R.string.privacy_unlisted), Integer.valueOf(R.drawable.privacy_selector_background_unlisted));
                        break;
                    }
                    break;
            }
        }
        int iIntValue = ((Number) pair.component1()).intValue();
        int iIntValue2 = ((Number) pair.component2()).intValue();
        if (textView != null) {
            textView.setText(getString(iIntValue));
        }
        if (linearLayout != null) {
            linearLayout.setBackgroundResource(iIntValue2);
        }
        boolean zAreEqual = Intrinsics.areEqual(privacy.getType(), MTApiKt.PRIVACY_TYPE_PRIVATE);
        if (textView2 != null) {
            textView2.setVisibility(zAreEqual ? 8 : 0);
        }
        if (textView3 != null) {
            textView3.setVisibility(zAreEqual ? 8 : 0);
        }
    }

    private final void updateProfilePrivacy(final String newType) {
        final PreferencesManager preferencesManager;
        MTUser currentUser;
        Context context = getContext();
        if (context == null || (currentUser = (preferencesManager = new PreferencesManager(context)).getCurrentUser()) == null) {
            return;
        }
        MTApiKt.getMtApi().updateUserPrivacy(currentUser.getId(), new MTUpdatePrivacyBody(newType, null, null, 6, null)).enqueue(new Callback<MTPrivacyResponse>() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment.updateProfilePrivacy.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTPrivacyResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTPrivacyResponse> call, Response<MTPrivacyResponse> response) {
                String type;
                MTUserPrivacyOptions options;
                List<MTCircle> circles;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (ProfileBottomSheetFragment.this.getContext() == null || ProfileBottomSheetFragment.this.getView() == null || !response.isSuccessful()) {
                    return;
                }
                MTPrivacyResponse mTPrivacyResponseBody = response.body();
                List<MTCircle> circles2 = null;
                MTUserPrivacy privacy = mTPrivacyResponseBody != null ? mTPrivacyResponseBody.getPrivacy() : null;
                if (privacy == null || (type = privacy.getType()) == null) {
                    type = newType;
                }
                if (privacy == null || (options = privacy.getOptions()) == null) {
                    MTUserPrivacy mTUserPrivacy = ProfileBottomSheetFragment.this.currentUserPrivacy;
                    options = mTUserPrivacy != null ? mTUserPrivacy.getOptions() : null;
                }
                if (privacy == null || (circles = privacy.getCircles()) == null) {
                    MTUserPrivacy mTUserPrivacy2 = ProfileBottomSheetFragment.this.currentUserPrivacy;
                    if (mTUserPrivacy2 != null) {
                        circles2 = mTUserPrivacy2.getCircles();
                    }
                } else {
                    circles2 = circles;
                }
                MTUserPrivacy mTUserPrivacy3 = new MTUserPrivacy(type, options, circles2);
                ProfileBottomSheetFragment.this.currentUserPrivacy = mTUserPrivacy3;
                preferencesManager.saveCurrentUserPrivacy(mTUserPrivacy3);
                ProfileBottomSheetFragment.this.updatePrivacyToolbar(mTUserPrivacy3);
            }
        });
    }

    public final void closeQRDialog() {
        Fragment fragmentFindFragmentByTag;
        if (getActivity() == null || (fragmentFindFragmentByTag = requireActivity().getSupportFragmentManager().findFragmentByTag("QrCodeFragment")) == null) {
            return;
        }
        ((QrCodeFragment) fragmentFindFragmentByTag).dismiss();
    }

    public final String getQrCodeBase64() {
        return this.qrCodeBase64;
    }

    public final boolean getQrCodeOK() {
        return this.qrCodeOK;
    }

    public final Job getSearchJob() {
        return this.searchJob;
    }

    public final void handleQRURL(String qrCode) {
        Intrinsics.checkNotNullParameter(qrCode, "qrCode");
        if (getContext() == null || getView() == null) {
            return;
        }
        String string = StringsKt.trim((CharSequence) qrCode).toString();
        Uri uri = Uri.parse(string);
        if (uri.getScheme() == null || uri.getHost() == null) {
            showInvalidURLDialog();
        } else if (CollectionsKt.contains(this.validPromoHosts, uri.getHost())) {
            processPromoCodeURL(string);
        } else {
            showOverlay();
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(string, null), 2, null);
        }
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
        this.pickPhotoLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda31
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ProfileBottomSheetFragment.onCreateView$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        this.isCurrentUser = false;
        if (currentUser != null) {
            int id = currentUser.getId();
            MTUser mTUser = this.user;
            if (mTUser == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
                mTUser = null;
            }
            this.isCurrentUser = id == mTUser.getId() && !this.displayCurrentUserProfileAsRegularProfile;
        }
        return inflater.inflate(R.layout.bottom_sheet_profile, container, false);
    }

    @Override // com.studiolaganne.lengendarylens.QRScanCallback
    public void onFriendCodeConfirmed(int userId) {
        ConstraintLayout constraintLayout;
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (!preferencesManager.hasValidUser() || currentUser == null || userId == -1 || userId == currentUser.getId()) {
            return;
        }
        View view = getView();
        if (view != null && (constraintLayout = (ConstraintLayout) view.findViewById(R.id.overlay)) != null) {
            constraintLayout.setVisibility(0);
        }
        MTApiKt.getMtApi().addFriend(currentUser.getId(), userId).enqueue(new ProfileBottomSheetFragment$onFriendCodeConfirmed$1$1(this, userId, preferencesManager));
    }

    @Override // com.studiolaganne.lengendarylens.QRScanCallback
    public void onQRClosed() {
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(QRScanBottomSheetFragment.TAG);
        QRScanBottomSheetFragment qRScanBottomSheetFragment = fragmentFindFragmentByTag instanceof QRScanBottomSheetFragment ? (QRScanBottomSheetFragment) fragmentFindFragmentByTag : null;
        if (qRScanBottomSheetFragment != null) {
            qRScanBottomSheetFragment.dismiss();
        }
    }

    @Override // com.studiolaganne.lengendarylens.QRScanCallback
    public void onQRScanned(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        View viewFindViewById;
        super.onStart();
        Dialog dialog = getDialog();
        BottomSheetDialog bottomSheetDialog = dialog instanceof BottomSheetDialog ? (BottomSheetDialog) dialog : null;
        if (bottomSheetDialog == null || (viewFindViewById = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet)) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(viewFindViewById);
        Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
        bottomSheetBehaviorFrom.setState(3);
        bottomSheetBehaviorFrom.setSkipCollapsed(true);
        bottomSheetBehaviorFrom.setDraggable(true);
        bottomSheetBehaviorFrom.setExpandedOffset(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0185  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        ConstraintLayout constraintLayout;
        LinearLayout linearLayout;
        MTUser mTUser;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.chevron_down);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBottomSheetFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        ImageView imageView = (ImageView) view.findViewById(R.id.clearFilterImage);
        final ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.filterLayout);
        final LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.masterFilterLayout);
        final LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.activeFilterLayout);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.filterSummaryLayout);
        final ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.searchNotesLayout);
        final ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(R.id.searchEditLayout);
        final EditText editText = (EditText) view.findViewById(R.id.searchNotesEditText);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.closeSearchImageView);
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.formatsForFilter = companion.getInstance(contextRequireContext).getFormats();
        Intrinsics.checkNotNull(imageView);
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBottomSheetFragment.onViewCreated$lambda$1(this.f$0, linearLayout2, linearLayout3);
            }
        });
        Intrinsics.checkNotNull(constraintLayout3);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout3, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBottomSheetFragment.onViewCreated$lambda$2(this.f$0);
            }
        });
        Intrinsics.checkNotNull(constraintLayout2);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBottomSheetFragment.onViewCreated$lambda$3(this.f$0);
            }
        });
        Intrinsics.checkNotNull(constraintLayout4);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout4, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBottomSheetFragment.onViewCreated$lambda$4(constraintLayout2, constraintLayout4, constraintLayout5, editText, this);
            }
        });
        Intrinsics.checkNotNull(imageView2);
        ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBottomSheetFragment.onViewCreated$lambda$5(this.f$0, constraintLayout5, constraintLayout4, constraintLayout2);
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment.onViewCreated.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String strValueOf = String.valueOf(s);
                boolean zAreEqual = Intrinsics.areEqual(strValueOf, "");
                ProfileBottomSheetFragment profileBottomSheetFragment = ProfileBottomSheetFragment.this;
                if (!zAreEqual) {
                    Job searchJob = profileBottomSheetFragment.getSearchJob();
                    if (searchJob != null) {
                        Job.DefaultImpls.cancel$default(searchJob, (CancellationException) null, 1, (Object) null);
                    }
                    ProfileBottomSheetFragment profileBottomSheetFragment2 = ProfileBottomSheetFragment.this;
                    profileBottomSheetFragment2.setSearchJob(BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(profileBottomSheetFragment2), Dispatchers.getIO(), null, new ProfileBottomSheetFragment$onViewCreated$7$afterTextChanged$1(ProfileBottomSheetFragment.this, strValueOf, null), 2, null));
                    return;
                }
                if (profileBottomSheetFragment.fragmentList.size() >= 4) {
                    Object obj = ProfileBottomSheetFragment.this.fragmentList.get(3);
                    UserGamesFragment userGamesFragment = obj instanceof UserGamesFragment ? (UserGamesFragment) obj : null;
                    if (userGamesFragment != null) {
                        userGamesFragment.resetSearch();
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
        TextView textView = (TextView) view.findViewById(R.id.logOutTextView);
        Intrinsics.checkNotNull(textView);
        ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBottomSheetFragment.onViewCreated$lambda$6(this.f$0);
            }
        });
        View viewFindViewById2 = view.findViewById(R.id.profileLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ConstraintLayout constraintLayout6 = (ConstraintLayout) viewFindViewById2;
        constraintLayout6.setOutlineProvider(new CircularOutlineProvider());
        constraintLayout6.setClipToOutline(true);
        CachedImageView cachedImageView = (CachedImageView) view.findViewById(R.id.profile_icon);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.no_photo_icon);
        MTUser mTUser2 = this.user;
        if (mTUser2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
            mTUser2 = null;
        }
        String picture = mTUser2.getPicture();
        String str = picture;
        boolean z = (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) ? false : true;
        if (z) {
            cachedImageView.setVisibility(0);
            imageView3.setVisibility(4);
            cachedImageView.reset();
            cachedImageView.setAutoLoad(false);
            cachedImageView.loadImage(picture);
        } else {
            cachedImageView.setVisibility(4);
            imageView3.setVisibility(0);
        }
        MythicProfileBorderView mythicProfileBorderView = (MythicProfileBorderView) view.findViewById(R.id.profileMythicBorder);
        if (this.isCurrentUser && z) {
            MythicPlusManager mythicPlusManager = MythicPlusManager.INSTANCE;
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            if (mythicPlusManager.isActive(contextRequireContext2)) {
                mythicProfileBorderView.setVisibility(0);
                mythicProfileBorderView.setPulseEnabled(true);
                mythicProfileBorderView.setHighlightEnabled(true);
                mythicProfileBorderView.startAnimation();
            }
        } else {
            mythicProfileBorderView.setVisibility(8);
            mythicProfileBorderView.stopAnimation();
        }
        ConstraintLayout constraintLayout7 = (ConstraintLayout) view.findViewById(R.id.editProfilePictureLayout);
        Intrinsics.checkNotNull(constraintLayout7);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout7, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBottomSheetFragment.onViewCreated$lambda$7(this.f$0);
            }
        });
        ConstraintLayout constraintLayout8 = (ConstraintLayout) view.findViewById(R.id.friendCodeButtonLayout);
        Intrinsics.checkNotNull(constraintLayout8);
        boolean z2 = false;
        ViewExtensionsKt.setOnClickWithFade(constraintLayout8, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBottomSheetFragment.onViewCreated$lambda$8(this.f$0);
            }
        });
        ImageView imageView4 = (ImageView) view.findViewById(R.id.editFirstnameImage);
        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.firstNameLayout);
        Intrinsics.checkNotNull(linearLayout4);
        ViewExtensionsKt.setOnClickWithFade(linearLayout4, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBottomSheetFragment.onViewCreated$lambda$9(this.f$0, view);
            }
        });
        ImageView imageView5 = (ImageView) view.findViewById(R.id.editUsernameImage);
        LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.userNameLayout);
        Intrinsics.checkNotNull(linearLayout5);
        ViewExtensionsKt.setOnClickWithFade(linearLayout5, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBottomSheetFragment.onViewCreated$lambda$10(this.f$0, view);
            }
        });
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.qrFrameLayout);
        ImageView imageView6 = (ImageView) view.findViewById(R.id.logoImage);
        Intrinsics.checkNotNull(imageView6);
        setImageViewToGrayscale(imageView6);
        final CachedImageView cachedImageView2 = (CachedImageView) view.findViewById(R.id.qrCodeImage);
        cachedImageView2.reset();
        String string = "";
        if (this.isCurrentUser) {
            constraintLayout = constraintLayout4;
            linearLayout = linearLayout2;
            Context contextRequireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
            string = new PreferencesManager(contextRequireContext3).getString(PreferencesManager.CURRENT_QR_CODE, "");
        } else {
            constraintLayout = constraintLayout4;
            linearLayout = linearLayout2;
        }
        String str2 = string;
        if (str2.length() > 0) {
            cachedImageView2.setFromBase64(string);
            this.qrCodeBase64 = string;
            this.qrCodeOK = true;
        }
        if (str2.length() == 0 && this.isCurrentUser) {
            MTApi mtApi = MTApiKt.getMtApi();
            MTUser mTUser3 = this.user;
            if (mTUser3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
                mTUser3 = null;
            }
            mtApi.qr(mTUser3.getId()).enqueue(new Callback<MTQrResponse>() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment.onViewCreated.13
                @Override // retrofit2.Callback
                public void onFailure(Call<MTQrResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTQrResponse> call, Response<MTQrResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (!response.isSuccessful() || ProfileBottomSheetFragment.this.getContext() == null) {
                        return;
                    }
                    MTQrResponse mTQrResponseBody = response.body();
                    String qr = mTQrResponseBody != null ? mTQrResponseBody.getQr() : null;
                    if (qr != null) {
                        ProfileBottomSheetFragment profileBottomSheetFragment = ProfileBottomSheetFragment.this;
                        CachedImageView cachedImageView3 = cachedImageView2;
                        Context contextRequireContext4 = profileBottomSheetFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                        new PreferencesManager(contextRequireContext4).setString(PreferencesManager.CURRENT_QR_CODE, qr);
                        cachedImageView3.setFromBase64(qr);
                        profileBottomSheetFragment.setQrCodeBase64(qr);
                        profileBottomSheetFragment.setQrCodeOK(true);
                    }
                }
            });
        }
        Intrinsics.checkNotNull(cachedImageView2);
        ViewExtensionsKt.setOnClickWithFade(cachedImageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBottomSheetFragment.onViewCreated$lambda$11(this.f$0);
            }
        });
        TextView textView2 = (TextView) view.findViewById(R.id.playerEmail);
        TextView textView3 = (TextView) view.findViewById(R.id.playerUsername);
        MTUser mTUser4 = this.user;
        if (mTUser4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
            mTUser4 = null;
        }
        textView2.setText(mTUser4.getEmail());
        MTUser mTUser5 = this.user;
        if (mTUser5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
            mTUser5 = null;
        }
        textView3.setText("@" + mTUser5.getUsername());
        TextView textView4 = (TextView) view.findViewById(R.id.playerFirstName);
        MTUser mTUser6 = this.user;
        if (mTUser6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
            mTUser6 = null;
        }
        textView4.setText(mTUser6.getFirstname());
        if (this.isCurrentUser) {
            Context contextRequireContext4 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
            this.currentUserPrivacy = new PreferencesManager(contextRequireContext4).getCurrentUserPrivacy();
            setupPrivacyToolbar();
            updatePrivacyToolbar(this.currentUserPrivacy);
            Unit unit = Unit.INSTANCE;
        } else {
            constraintLayout7.setVisibility(8);
            imageView5.setVisibility(8);
            imageView4.setVisibility(8);
            textView2.setVisibility(8);
            frameLayout.setVisibility(8);
            constraintLayout8.setVisibility(8);
            textView.setVisibility(8);
            view.findViewById(R.id.separator2).setVisibility(8);
            View viewFindViewById3 = view.findViewById(R.id.privacyToolbarLayout);
            if (viewFindViewById3 != null) {
                viewFindViewById3.setVisibility(8);
                Unit unit2 = Unit.INSTANCE;
            }
            ViewGroup.LayoutParams layoutParams = textView3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = -16;
            textView3.setLayoutParams(layoutParams2);
            Context contextRequireContext5 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
            MTUser currentUser = new PreferencesManager(contextRequireContext5).getCurrentUser();
            if (currentUser != null) {
                MTApi mtApi2 = MTApiKt.getMtApi();
                int id = currentUser.getId();
                MTUser mTUser7 = this.user;
                if (mTUser7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("user");
                    mTUser7 = null;
                }
                mtApi2.getUserById(id, mTUser7.getId()).enqueue(new Callback<MTUserResponse>() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$onViewCreated$15$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTUserResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTUserResponse> call, Response<MTUserResponse> response) {
                        MTUserPrivacyOptions options;
                        MTUserPrivacyOptions options2;
                        ConstraintLayout constraintLayout9;
                        MTUserPrivacyOptions options3;
                        MTUser user;
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (this.this$0.getContext() == null || view == null || !response.isSuccessful()) {
                            return;
                        }
                        MTUserResponse mTUserResponseBody = response.body();
                        this.this$0.viewedUserPrivacy = mTUserResponseBody != null ? mTUserResponseBody.getPrivacy() : null;
                        this.this$0.viewedUserCode = (mTUserResponseBody == null || (user = mTUserResponseBody.getUser()) == null) ? null : user.getCode();
                        MTUserPrivacy mTUserPrivacy = this.this$0.viewedUserPrivacy;
                        boolean zAreEqual = false;
                        if ((mTUserPrivacy == null || (options3 = mTUserPrivacy.getOptions()) == null) ? false : Intrinsics.areEqual((Object) options3.getShare_friend_code(), (Object) true)) {
                            String str3 = this.this$0.viewedUserCode;
                            if (!(str3 == null || str3.length() == 0) && (constraintLayout9 = (ConstraintLayout) view.findViewById(R.id.friendCodeButtonLayout)) != null) {
                                constraintLayout9.setVisibility(0);
                            }
                        }
                        Object orNull = CollectionsKt.getOrNull(this.this$0.fragmentList, 0);
                        UserStatsFragment userStatsFragment = orNull instanceof UserStatsFragment ? (UserStatsFragment) orNull : null;
                        if (userStatsFragment != null) {
                            MTUserPrivacy mTUserPrivacy2 = this.this$0.viewedUserPrivacy;
                            userStatsFragment.setPrivacyShared(!((mTUserPrivacy2 == null || (options2 = mTUserPrivacy2.getOptions()) == null) ? false : Intrinsics.areEqual((Object) options2.getShare_stats(), (Object) false)));
                        }
                        Object orNull2 = CollectionsKt.getOrNull(this.this$0.fragmentList, 3);
                        UserGamesFragment userGamesFragment = orNull2 instanceof UserGamesFragment ? (UserGamesFragment) orNull2 : null;
                        if (userGamesFragment != null) {
                            MTUserPrivacy mTUserPrivacy3 = this.this$0.viewedUserPrivacy;
                            if (mTUserPrivacy3 != null && (options = mTUserPrivacy3.getOptions()) != null) {
                                zAreEqual = Intrinsics.areEqual((Object) options.getShare_games(), (Object) false);
                            }
                            userGamesFragment.setPrivacyShared(!zAreEqual);
                        }
                    }
                });
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
        }
        Bundle bundle = new Bundle();
        MTUser mTUser8 = this.user;
        if (mTUser8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user");
            mTUser = null;
        } else {
            mTUser = mTUser8;
        }
        bundle.putInt("userId", mTUser.getId());
        int i = 5;
        if (this.isCurrentUser) {
            UserStatsFragment userStatsFragment = new UserStatsFragment();
            userStatsFragment.setArguments(bundle);
            Unit unit5 = Unit.INSTANCE;
            UserAchievementsFragment userAchievementsFragment = new UserAchievementsFragment();
            userAchievementsFragment.setArguments(bundle);
            Unit unit6 = Unit.INSTANCE;
            UserDecksFragment userDecksFragment = new UserDecksFragment();
            userDecksFragment.setArguments(bundle);
            Unit unit7 = Unit.INSTANCE;
            UserGamesFragment userGamesFragment = new UserGamesFragment();
            userGamesFragment.setArguments(bundle);
            Unit unit8 = Unit.INSTANCE;
            this.fragmentList = CollectionsKt.mutableListOf(userStatsFragment, userAchievementsFragment, userDecksFragment, userGamesFragment);
        } else {
            UserStatsFragment userStatsFragment2 = new UserStatsFragment();
            userStatsFragment2.setArguments(bundle);
            Unit unit9 = Unit.INSTANCE;
            UserAchievementsFragment userAchievementsFragment2 = new UserAchievementsFragment();
            userAchievementsFragment2.setArguments(bundle);
            Unit unit10 = Unit.INSTANCE;
            UserDecksFragment userDecksFragment2 = new UserDecksFragment();
            userDecksFragment2.setArguments(bundle);
            Unit unit11 = Unit.INSTANCE;
            UserGamesFragment userGamesFragment2 = new UserGamesFragment();
            userGamesFragment2.setArguments(bundle);
            Unit unit12 = Unit.INSTANCE;
            UserCollectionFragment userCollectionFragment = new UserCollectionFragment();
            userCollectionFragment.setArguments(bundle);
            Unit unit13 = Unit.INSTANCE;
            UserListsFragment userListsFragment = new UserListsFragment();
            userListsFragment.setArguments(bundle);
            Unit unit14 = Unit.INSTANCE;
            this.fragmentList = CollectionsKt.mutableListOf(userStatsFragment2, userAchievementsFragment2, userDecksFragment2, userGamesFragment2, userCollectionFragment, userListsFragment);
        }
        View viewFindViewById4 = view.findViewById(R.id.chipGrid);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        GridLayout gridLayout = (GridLayout) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.view_pager);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        final ViewPager2 viewPager2 = (ViewPager2) viewFindViewById5;
        viewPager2.setAdapter(new FragmentStateAdapter() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment.onViewCreated.26
            {
                super(ProfileBottomSheetFragment.this);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            public Fragment createFragment(int position) {
                if (position == 0) {
                    return (Fragment) ProfileBottomSheetFragment.this.fragmentList.get(0);
                }
                if (position == 1) {
                    return (Fragment) ProfileBottomSheetFragment.this.fragmentList.get(1);
                }
                if (position == 2) {
                    return (Fragment) ProfileBottomSheetFragment.this.fragmentList.get(2);
                }
                if (position == 3) {
                    return (Fragment) ProfileBottomSheetFragment.this.fragmentList.get(3);
                }
                if (position == 4) {
                    List list = ProfileBottomSheetFragment.this.fragmentList;
                    return (Fragment) (4 < list.size() ? list.get(4) : new Fragment());
                }
                if (position != 5) {
                    return new Fragment();
                }
                List list2 = ProfileBottomSheetFragment.this.fragmentList;
                return (Fragment) (5 < list2.size() ? list2.get(5) : new Fragment());
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return ProfileBottomSheetFragment.this.fragmentList.size();
            }
        });
        List listMutableListOf = CollectionsKt.mutableListOf(getString(R.string.stats_tab), getString(R.string.achievements_tab), getString(R.string.decks_tab), getString(R.string.games_tab));
        if (!this.isCurrentUser) {
            String string2 = getString(R.string.collection_tab);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            listMutableListOf.add(string2);
            String string3 = getString(R.string.lists_tab);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            listMutableListOf.add(string3);
        }
        gridLayout.setColumnCount(listMutableListOf.size() <= 4 ? listMutableListOf.size() : 3);
        gridLayout.removeAllViews();
        final ArrayList arrayList = new ArrayList();
        Typeface font = ResourcesCompat.getFont(requireContext(), R.font.baloo_da_2_bold);
        final int i2 = 0;
        for (Object obj : listMutableListOf) {
            int i3 = i2 + 1;
            Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
            TextView textView5 = new TextView(requireContext());
            textView5.setText((String) obj);
            textView5.setTextSize(12.0f);
            textView5.setTypeface(font);
            textView5.setGravity(17);
            textView5.setBackgroundResource(R.drawable.profile_chip_background);
            int i4 = (int) (8.0f * textView5.getResources().getDisplayMetrics().density);
            int i5 = (int) (textView5.getResources().getDisplayMetrics().density * 6.0f);
            textView5.setPadding(i4, i5, i4, i5);
            textView5.setSelected(i2 == 0 ? true : z2);
            textView5.setTextColor(i2 == 0 ? ContextCompat.getColor(textView5.getContext(), R.color.dark_background) : ContextCompat.getColor(textView5.getContext(), R.color.unselected_color_new));
            GridLayout.LayoutParams layoutParams3 = new GridLayout.LayoutParams();
            layoutParams3.width = z2 ? 1 : 0;
            layoutParams3.height = -2;
            int i6 = i;
            layoutParams3.columnSpec = GridLayout.spec(Integer.MIN_VALUE, 1.0f);
            int i7 = (int) (2.0f * gridLayout.getResources().getDisplayMetrics().density);
            layoutParams3.setMargins(i7, i7, i7, i7);
            TextView textView6 = textView5;
            ViewExtensionsKt.setOnClickWithFade(textView6, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ProfileBottomSheetFragment.onViewCreated$lambda$26(viewPager2, i2);
                }
            });
            gridLayout.addView(textView6, layoutParams3);
            arrayList.add(textView5);
            i = i6;
            i2 = i3;
            z2 = false;
        }
        final Set of = this.isCurrentUser ? SetsKt.setOf(1) : SetsKt.setOf((Object[]) new Integer[]{1, 4, Integer.valueOf(i)});
        final int i8 = 3;
        final ConstraintLayout constraintLayout9 = constraintLayout;
        final LinearLayout linearLayout6 = linearLayout;
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment.onViewCreated.28
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                int i9 = 0;
                for (TextView textView7 : arrayList) {
                    int i10 = i9 + 1;
                    textView7.setSelected(i9 == position);
                    ProfileBottomSheetFragment profileBottomSheetFragment = this;
                    textView7.setTextColor(i9 == position ? ContextCompat.getColor(profileBottomSheetFragment.requireContext(), R.color.dark_background) : ContextCompat.getColor(profileBottomSheetFragment.requireContext(), R.color.unselected_color_new));
                    i9 = i10;
                }
                if (of.contains(Integer.valueOf(position))) {
                    linearLayout6.setVisibility(8);
                    linearLayout3.setVisibility(8);
                    return;
                }
                boolean z3 = this.filterActive;
                LinearLayout linearLayout7 = linearLayout3;
                if (z3) {
                    linearLayout7.setVisibility(0);
                    linearLayout6.setVisibility(8);
                    constraintLayout9.setVisibility(8);
                    constraintLayout5.setVisibility(8);
                } else {
                    linearLayout7.setVisibility(8);
                    linearLayout6.setVisibility(0);
                    constraintLayout2.setVisibility(0);
                    if (this.searchActive) {
                        constraintLayout2.setVisibility(8);
                        constraintLayout9.setVisibility(8);
                        constraintLayout5.setVisibility(0);
                    } else {
                        constraintLayout9.setVisibility(0);
                        constraintLayout5.setVisibility(8);
                    }
                }
                if (position != i8) {
                    constraintLayout2.setVisibility(0);
                    constraintLayout9.setVisibility(8);
                    constraintLayout5.setVisibility(8);
                }
            }
        });
        ConstraintLayout constraintLayout10 = (ConstraintLayout) view.findViewById(R.id.promoCodeButtonLayout);
        if (this.isCurrentUser) {
            constraintLayout10.setVisibility(0);
        } else {
            constraintLayout10.setVisibility(8);
        }
        Intrinsics.checkNotNull(constraintLayout10);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout10, new Function0() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileBottomSheetFragment.onViewCreated$lambda$27(this.f$0);
            }
        });
        final String str3 = this.eventURL;
        if (str3 != null) {
            if (str3.length() > 0) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$$ExternalSyntheticLambda20
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.handleQRURL(str3);
                    }
                }, 500L);
            }
            Unit unit15 = Unit.INSTANCE;
            Unit unit16 = Unit.INSTANCE;
        }
    }

    public final void setImageViewToGrayscale(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    public final void setQrCodeBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qrCodeBase64 = str;
    }

    public final void setQrCodeOK(boolean z) {
        this.qrCodeOK = z;
    }

    public final void setSearchJob(Job job) {
        this.searchJob = job;
    }
}
