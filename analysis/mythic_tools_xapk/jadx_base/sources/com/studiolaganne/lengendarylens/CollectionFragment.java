package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.studiolaganne.lengendarylens.CollectionFragment;
import com.studiolaganne.lengendarylens.CollectionHelpDialogFragment;
import com.studiolaganne.lengendarylens.CollectionImportResult;
import com.studiolaganne.lengendarylens.CsvPreviewDialogFragment;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.ImportConfirmationDialogFragment;
import com.studiolaganne.lengendarylens.ImportCsvDialogFragment;
import com.studiolaganne.lengendarylens.MTGCsvImporter;
import com.studiolaganne.lengendarylens.databinding.FragmentCollectionBinding;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: CollectionFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 q2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001qB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000fH\u0002J\u0016\u0010#\u001a\u00020\u00142\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J\u0018\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000fH\u0002J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020,H\u0002J\u0016\u0010-\u001a\u00020\u00142\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0%H\u0002J\u0016\u00100\u001a\u00020\u00142\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0%H\u0002J\u0016\u00101\u001a\u00020\u00142\f\u00102\u001a\b\u0012\u0004\u0012\u00020/0%H\u0002J\u001e\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u000207H\u0082@¢\u0006\u0002\u00108J4\u00109\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:2\u0006\u00105\u001a\u0002042\u0006\u0010<\u001a\u0002042\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>0%H\u0082@¢\u0006\u0002\u0010?J`\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u0002042\u0006\u0010B\u001a\u0002042\u0006\u0010C\u001a\u0002042\u0006\u0010D\u001a\u0002042\u0006\u0010E\u001a\u0002042\u0006\u0010F\u001a\u0002042&\u0010G\u001a\"\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r\u0012\f\u0012\n\u0012\u0004\u0012\u00020I\u0018\u00010%0H0%H\u0002J0\u0010J\u001a\u00020\u000f2&\u0010G\u001a\"\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r\u0012\f\u0012\n\u0012\u0004\u0012\u00020I\u0018\u00010%0H0%H\u0002J\b\u0010K\u001a\u00020\u0014H\u0002J\u0010\u0010L\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u000fH\u0002J\u001e\u0010N\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u000f2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000f0%H\u0002J\u0010\u0010P\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u000fH\u0002J\b\u0010Q\u001a\u00020\u0014H\u0016J$\u0010R\u001a\u00020\u00142\u0006\u0010S\u001a\u00020\u000f2\b\u0010T\u001a\u0004\u0018\u00010\u000f2\b\u0010U\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010V\u001a\u00020\u00142\u0006\u0010W\u001a\u00020\u000f2\u0006\u0010X\u001a\u00020\u000fH\u0016J\u0010\u0010Y\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020\u000fH\u0016J\u0012\u0010[\u001a\u00020\u00142\b\u0010\\\u001a\u0004\u0018\u00010]H\u0002J\u0012\u0010^\u001a\u00020\u00142\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J&\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010f2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010g\u001a\u00020\u00142\u0006\u0010h\u001a\u00020\rH\u0016J\b\u0010i\u001a\u00020\u0014H\u0016J\b\u0010l\u001a\u00020\u0014H\u0002J\b\u0010m\u001a\u00020\u0014H\u0002J\u001a\u0010n\u001a\u00020\u00142\u0006\u0010o\u001a\u00020b2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\b\u0010p\u001a\u00020\u0014H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/SignInCallback;", "Lcom/studiolaganne/lengendarylens/ImportCsvDialogListener;", "Lcom/studiolaganne/lengendarylens/CollectionRootListener;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentCollectionBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentCollectionBinding;", "isVisible", "", "layoutType", "", "fragmentList", "", "collectionSetup", "downloadAndShareFile", "", "url", "shareFile", "file", "Ljava/io/File;", "exportCollection", "onImportRequested", "showImportDialog", "onImportCollection", "result", "Lcom/studiolaganne/lengendarylens/CollectionImportResult;", "processCsvImport", "inputStream", "Ljava/io/InputStream;", "fileName", "processTxtImport", "parsedCards", "", "Lcom/studiolaganne/lengendarylens/ParsedCard;", "showCsvPreviewDialog", "parseResult", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$CsvParseResult;", "csvContent", "handleImportResult", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$ImportResult;", "showImportConfirmation", "containers", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "processImportWithNameConflictResolution", "processContainersImport", "resolvedContainers", "createContainerSync", "", "userId", "editBody", "Lcom/studiolaganne/lengendarylens/MTEditListBody;", "(ILcom/studiolaganne/lengendarylens/MTEditListBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addCardsToContainerSync", "Lretrofit2/Response;", "Lcom/studiolaganne/lengendarylens/MTCardListResponse;", "containerId", "cards", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "(IILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showImportResults", "totalContainers", "processedContainers", "failedContainers", "totalCards", "processedCards", "failedCards", "results", "Lkotlin/Triple;", "Lcom/studiolaganne/lengendarylens/MTSimpleCard;", "buildDetailedResultMessage", "refreshCollectionAndLists", "showSuccess", "message", "showPartialSuccess", "errors", "showError", "onSignInCancel", "onSignInSuccess", "token", "firstname", "email", "onOAuthSignInSuccess", "code", "type", "onSignInFailure", NotificationCompat.CATEGORY_MESSAGE, "handleSuccessfulFirebaseLogin", "response", "Lcom/studiolaganne/lengendarylens/MTLoginResponse;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHiddenChanged", "hidden", "onResume", "lastKnownCollectionVersion", "lastKnownListsVersion", "updateBadgeDot", "checkAndRefreshIfNeeded", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "updateUISetup", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionFragment extends Fragment implements SignInCallback, ImportCsvDialogListener, CollectionRootListener {
    private FragmentCollectionBinding _binding;
    private boolean collectionSetup;
    private int lastKnownCollectionVersion;
    private int lastKnownListsVersion;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private boolean isVisible = true;
    private String layoutType = "grid";
    private List<Fragment> fragmentList = new ArrayList();

    /* JADX INFO: compiled from: CollectionFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/CollectionFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final CollectionFragment newInstance() {
            return new CollectionFragment();
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CollectionFragment$downloadAndShareFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionFragment.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/CollectionFragment$downloadAndShareFile$1", "Lokhttp3/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "Lokio/IOException;", "onResponse", "response", "Lokhttp3/Response;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 implements Callback {
        AnonymousClass1() {
        }

        static final void onFailure$lambda$0(CollectionFragment collectionFragment) {
            if (collectionFragment.getContext() == null || collectionFragment._binding == null) {
                return;
            }
            collectionFragment.getBinding().overlay.setVisibility(8);
            Toast.makeText(collectionFragment.requireContext(), R.string.download_error_body, 1).show();
        }

        static final void onResponse$lambda$1(CollectionFragment collectionFragment) {
            if (collectionFragment.getContext() == null || collectionFragment._binding == null) {
                return;
            }
            collectionFragment.getBinding().overlay.setVisibility(8);
            Toast.makeText(collectionFragment.requireContext(), R.string.download_error_body, 1).show();
        }

        static final void onResponse$lambda$3(CollectionFragment collectionFragment, File file) {
            if (collectionFragment.getContext() == null || collectionFragment._binding == null) {
                return;
            }
            collectionFragment.shareFile(file);
        }

        static final void onResponse$lambda$4(CollectionFragment collectionFragment) {
            if (collectionFragment.getContext() == null || collectionFragment._binding == null) {
                return;
            }
            collectionFragment.getBinding().overlay.setVisibility(8);
            Toast.makeText(collectionFragment.requireContext(), R.string.download_error_body, 1).show();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e, "e");
            if (CollectionFragment.this.getContext() == null || CollectionFragment.this._binding == null) {
                return;
            }
            FragmentActivity fragmentActivityRequireActivity = CollectionFragment.this.requireActivity();
            final CollectionFragment collectionFragment = CollectionFragment.this;
            fragmentActivityRequireActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$downloadAndShareFile$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CollectionFragment.AnonymousClass1.onFailure$lambda$0(collectionFragment);
                }
            });
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            FragmentActivity activity;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (!response.isSuccessful()) {
                if (CollectionFragment.this.getContext() == null || CollectionFragment.this._binding == null || (activity = CollectionFragment.this.getActivity()) == null) {
                    return;
                }
                final CollectionFragment collectionFragment = CollectionFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$downloadAndShareFile$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CollectionFragment.AnonymousClass1.onResponse$lambda$1(collectionFragment);
                    }
                });
                return;
            }
            try {
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody == null) {
                    throw new IOException("Empty response body");
                }
                InputStream inputStreamByteStream = responseBodyBody.byteStream();
                final File file = new File(CollectionFragment.this.requireContext().getCacheDir(), "collection_export_" + System.currentTimeMillis() + ".csv");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    ByteStreamsKt.copyTo$default(inputStreamByteStream, fileOutputStream, 0, 2, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    FragmentActivity fragmentActivityRequireActivity = CollectionFragment.this.requireActivity();
                    final CollectionFragment collectionFragment2 = CollectionFragment.this;
                    fragmentActivityRequireActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$downloadAndShareFile$1$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            CollectionFragment.AnonymousClass1.onResponse$lambda$3(collectionFragment2, file);
                        }
                    });
                } finally {
                }
            } catch (IOException unused) {
                FragmentActivity fragmentActivityRequireActivity2 = CollectionFragment.this.requireActivity();
                final CollectionFragment collectionFragment3 = CollectionFragment.this;
                fragmentActivityRequireActivity2.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$downloadAndShareFile$1$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        CollectionFragment.AnonymousClass1.onResponse$lambda$4(collectionFragment3);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CollectionFragment$onOAuthSignInSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionFragment.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/CollectionFragment$onOAuthSignInSuccess$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTLoginResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C11341 implements retrofit2.Callback<MTLoginResponse> {
        final /* synthetic */ PreferencesManager $prefs;

        C11341(PreferencesManager preferencesManager) {
            this.$prefs = preferencesManager;
        }

        static final Unit onResponse$lambda$0(final PreferencesManager preferencesManager, final CollectionFragment collectionFragment, final retrofit2.Response response, AuthResult authResult) {
            Task<GetTokenResult> idToken;
            FirebaseUser user = authResult.getUser();
            if (user != null && (idToken = user.getIdToken(true)) != null) {
                final Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$onOAuthSignInSuccess$1$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CollectionFragment.C11341.onResponse$lambda$0$0(preferencesManager, collectionFragment, response, (GetTokenResult) obj);
                    }
                };
                idToken.addOnSuccessListener(new OnSuccessListener() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$onOAuthSignInSuccess$1$$ExternalSyntheticLambda4
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        function1.invoke(obj);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$0$0(PreferencesManager preferencesManager, CollectionFragment collectionFragment, retrofit2.Response response, GetTokenResult getTokenResult) {
            String token = getTokenResult.getToken();
            String str = token;
            if (str == null || str.length() == 0) {
                Log.w("MTApi", "FIREBASE SIGNIN: Token was null or empty");
                collectionFragment.getBinding().overlay.setVisibility(8);
            } else {
                preferencesManager.setString(PreferencesManager.FIREBASE_TOKEN, token);
                preferencesManager.setString(PreferencesManager.AUTH_PROVIDER, FirebaseAuthProvider.PROVIDER_ID);
                preferencesManager.setTokenExpiryTime(System.currentTimeMillis() + 3300000);
                collectionFragment.handleSuccessfulFirebaseLogin((MTLoginResponse) response.body());
                collectionFragment.getBinding().overlay.setVisibility(8);
            }
            return Unit.INSTANCE;
        }

        static final void onResponse$lambda$2(CollectionFragment collectionFragment, Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            Log.e("MTApi", "Firebase sign-in with custom token failed", e);
            collectionFragment.getBinding().overlay.setVisibility(8);
        }

        @Override // retrofit2.Callback
        public void onFailure(retrofit2.Call<MTLoginResponse> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            if (CollectionFragment.this.getContext() == null || CollectionFragment.this._binding == null) {
                return;
            }
            CollectionFragment.this.getBinding().overlay.setVisibility(8);
            Log.d("MTApi", "Login failed: " + t.getLocalizedMessage());
        }

        @Override // retrofit2.Callback
        public void onResponse(retrofit2.Call<MTLoginResponse> call, final retrofit2.Response<MTLoginResponse> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (CollectionFragment.this.getContext() == null || CollectionFragment.this._binding == null) {
                return;
            }
            if (response.isSuccessful()) {
                if (CollectionFragment.this.getContext() == null) {
                    return;
                }
                MTLoginResponse mTLoginResponseBody = response.body();
                String customToken = mTLoginResponseBody != null ? mTLoginResponseBody.getCustomToken() : null;
                String str = customToken;
                if (str != null && str.length() != 0) {
                    Task<AuthResult> taskSignInWithCustomToken = FirebaseAuth.getInstance().signInWithCustomToken(customToken);
                    final PreferencesManager preferencesManager = this.$prefs;
                    final CollectionFragment collectionFragment = CollectionFragment.this;
                    final Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$onOAuthSignInSuccess$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CollectionFragment.C11341.onResponse$lambda$0(preferencesManager, collectionFragment, response, (AuthResult) obj);
                        }
                    };
                    Task<AuthResult> taskAddOnSuccessListener = taskSignInWithCustomToken.addOnSuccessListener(new OnSuccessListener() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$onOAuthSignInSuccess$1$$ExternalSyntheticLambda1
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public final void onSuccess(Object obj) {
                            function1.invoke(obj);
                        }
                    });
                    final CollectionFragment collectionFragment2 = CollectionFragment.this;
                    taskAddOnSuccessListener.addOnFailureListener(new OnFailureListener() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$onOAuthSignInSuccess$1$$ExternalSyntheticLambda2
                        @Override // com.google.android.gms.tasks.OnFailureListener
                        public final void onFailure(Exception exc) {
                            CollectionFragment.C11341.onResponse$lambda$2(collectionFragment2, exc);
                        }
                    });
                    return;
                }
            }
            CollectionFragment.this.getBinding().overlay.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CollectionFragment$onSignInSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionFragment.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/CollectionFragment$onSignInSuccess$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTLoginResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C11351 implements retrofit2.Callback<MTLoginResponse> {
        final /* synthetic */ PreferencesManager $prefs;

        C11351(PreferencesManager preferencesManager) {
            this.$prefs = preferencesManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$0$0(PurchasesError it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$0$1(CollectionFragment collectionFragment, CustomerInfo customerInfo, boolean z) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            MythicPlusManager mythicPlusManager = MythicPlusManager.INSTANCE;
            Context contextRequireContext = collectionFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            mythicPlusManager.handleCustomerInfoUpdate(contextRequireContext, customerInfo);
            return Unit.INSTANCE;
        }

        @Override // retrofit2.Callback
        public void onFailure(retrofit2.Call<MTLoginResponse> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            if (CollectionFragment.this.getContext() == null || CollectionFragment.this._binding == null) {
                return;
            }
            CollectionFragment.this.getBinding().overlay.setVisibility(8);
            Log.d("MTApi", "Login failed: " + t.getLocalizedMessage());
        }

        @Override // retrofit2.Callback
        public void onResponse(retrofit2.Call<MTLoginResponse> call, retrofit2.Response<MTLoginResponse> response) {
            List<MTPlaygroup> listEmptyList;
            List<MTFriend> listEmptyList2;
            List<MTDeck> listEmptyList3;
            MTUserLists lists;
            List<MTCardContainer> global;
            MTUserPrivacy privacy;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (CollectionFragment.this.getContext() == null || CollectionFragment.this._binding == null) {
                return;
            }
            if (response.isSuccessful()) {
                if (CollectionFragment.this.getContext() == null) {
                    return;
                }
                MTLoginResponse mTLoginResponseBody = response.body();
                MTUser user = mTLoginResponseBody != null ? mTLoginResponseBody.getUser() : null;
                MTLoginResponse mTLoginResponseBody2 = response.body();
                if (mTLoginResponseBody2 == null || (listEmptyList = mTLoginResponseBody2.getPlaygroups()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                MTLoginResponse mTLoginResponseBody3 = response.body();
                if (mTLoginResponseBody3 == null || (listEmptyList2 = mTLoginResponseBody3.getFriends()) == null) {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                MTLoginResponse mTLoginResponseBody4 = response.body();
                if (mTLoginResponseBody4 == null || (listEmptyList3 = mTLoginResponseBody4.getDecks()) == null) {
                    listEmptyList3 = CollectionsKt.emptyList();
                }
                if (user != null) {
                    final CollectionFragment collectionFragment = CollectionFragment.this;
                    PreferencesManager preferencesManager = this.$prefs;
                    FirebaseAnalytics.getInstance(collectionFragment.requireContext()).setUserProperty("is_logged_in", "true");
                    CustomerIOHelper.INSTANCE.maybeIdentifyAfterLogin(user, preferencesManager);
                    ListenerConversionsKt.logInWith(Purchases.INSTANCE.getSharedInstance(), String.valueOf(user.getId()), new Function1() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$onSignInSuccess$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CollectionFragment.C11351.onResponse$lambda$0$0((PurchasesError) obj);
                        }
                    }, new Function2() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$onSignInSuccess$1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CollectionFragment.C11351.onResponse$lambda$0$1(collectionFragment, (CustomerInfo) obj, ((Boolean) obj2).booleanValue());
                        }
                    });
                    preferencesManager.saveCurrentUser(user);
                    preferencesManager.saveCurrentUserPlaygroups(listEmptyList);
                    preferencesManager.saveCurrentUserFriends(listEmptyList2);
                    preferencesManager.saveCurrentUserDecks(listEmptyList3);
                    preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                    FragmentActivity activity = collectionFragment.getActivity();
                    MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
                    if (mainActivity != null) {
                        mainActivity.userLoggedIn();
                    }
                    MTLoginResponse mTLoginResponseBody5 = response.body();
                    MTFavorites favorites = mTLoginResponseBody5 != null ? mTLoginResponseBody5.getFavorites() : null;
                    if (favorites != null) {
                        preferencesManager.saveCurrentUserFavorites(favorites);
                    }
                    MTLoginResponse mTLoginResponseBody6 = response.body();
                    MTUserTags tags = mTLoginResponseBody6 != null ? mTLoginResponseBody6.getTags() : null;
                    if (tags != null) {
                        preferencesManager.saveCurrentUserTags(tags);
                    }
                    MTLoginResponse mTLoginResponseBody7 = response.body();
                    List<MTTrophy> trophies = mTLoginResponseBody7 != null ? mTLoginResponseBody7.getTrophies() : null;
                    if (trophies != null) {
                        preferencesManager.saveCurrentUserTrophies(trophies);
                    }
                    MTLoginResponse mTLoginResponseBody8 = response.body();
                    if (mTLoginResponseBody8 != null && (privacy = mTLoginResponseBody8.getPrivacy()) != null) {
                        preferencesManager.saveCurrentUserPrivacy(privacy);
                    }
                    MTLoginResponse mTLoginResponseBody9 = response.body();
                    MTCollection collection = mTLoginResponseBody9 != null ? mTLoginResponseBody9.getCollection() : null;
                    if (collection != null) {
                        preferencesManager.saveCurrentUserCollection(collection);
                    }
                    MTLoginResponse mTLoginResponseBody10 = response.body();
                    MTUserLists lists2 = mTLoginResponseBody10 != null ? mTLoginResponseBody10.getLists() : null;
                    if (lists2 != null) {
                        preferencesManager.saveCurrentUserLists(lists2);
                    }
                    MTLoginResponse mTLoginResponseBody11 = response.body();
                    if (mTLoginResponseBody11 != null && (lists = mTLoginResponseBody11.getLists()) != null && (global = lists.getGlobal()) != null) {
                        for (MTCardContainer mTCardContainer : global) {
                            if (Intrinsics.areEqual(mTCardContainer.getName(), PreferencesManager.RECENT_CARDS_LIST_NAME)) {
                                PreferencesManager.INSTANCE.setRecentCardListId(mTCardContainer.getId());
                            }
                        }
                    }
                    collectionFragment.updateUISetup();
                }
            }
            CollectionFragment.this.getBinding().overlay.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CollectionFragment$processContainersImport$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.CollectionFragment$processContainersImport$1", f = "CollectionFragment.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {Videoio.CAP_PROP_XI_ACQ_TRANSPORT_BUFFER_SIZE, 570, 662}, m = "invokeSuspend", n = {"$this$launch", "container", "editBody", "$this$launch", "container", "cards", "containerId", "$this$launch", "container", "cards", "$i$a$-let-CollectionFragment$processContainersImport$1$3"}, s = {"L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "I$0", "L$0", "L$6", "L$7", "I$0"}, v = 1)
    static final class C11361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MTCardContainer $bulkContainer;
        final /* synthetic */ MTUser $currentUser;
        final /* synthetic */ Ref.IntRef $failedCards;
        final /* synthetic */ Ref.IntRef $failedContainers;
        final /* synthetic */ List<MTCardContainer> $nonBulkContainers;
        final /* synthetic */ Ref.IntRef $processedCards;
        final /* synthetic */ Ref.IntRef $processedContainers;
        final /* synthetic */ List<Triple<String, Boolean, List<MTSimpleCard>>> $results;
        final /* synthetic */ int $totalCards;
        final /* synthetic */ int $totalContainers;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        final /* synthetic */ CollectionFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11361(List<MTCardContainer> list, List<Triple<String, Boolean, List<MTSimpleCard>>> list2, Ref.IntRef intRef, Ref.IntRef intRef2, MTCardContainer mTCardContainer, CollectionFragment collectionFragment, int i, int i2, Ref.IntRef intRef3, Ref.IntRef intRef4, MTUser mTUser, Continuation<? super C11361> continuation) {
            super(2, continuation);
            this.$nonBulkContainers = list;
            this.$results = list2;
            this.$failedContainers = intRef;
            this.$processedContainers = intRef2;
            this.$bulkContainer = mTCardContainer;
            this.this$0 = collectionFragment;
            this.$totalContainers = i;
            this.$totalCards = i2;
            this.$processedCards = intRef3;
            this.$failedCards = intRef4;
            this.$currentUser = mTUser;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11361 c11361 = new C11361(this.$nonBulkContainers, this.$results, this.$failedContainers, this.$processedContainers, this.$bulkContainer, this.this$0, this.$totalContainers, this.$totalCards, this.$processedCards, this.$failedCards, this.$currentUser, continuation);
            c11361.L$0 = obj;
            return c11361;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(5:54|55|331|56|(4:137|(4:140|(2:142|391)(2:143|390)|144|138)|389|145)(2:60|(4:128|(4:131|(2:133|388)(2:134|387)|135|129)|386|136)(2:62|(7:64|(13:67|(2:69|70)(1:71)|318|72|(1:74)(1:75)|76|(1:78)(1:79)|80|(2:81|(5:83|(1:85)(1:86)|87|(4:89|(1:91)(1:92)|93|(4:95|(1:97)(1:98)|99|(2:375|101)(1:379))(1:378))(1:377)|102)(2:376|103))|104|(2:108|373)(1:374)|109|65)|372|110|(4:113|(2:115|382)(2:116|381)|117|111)|380|118)(4:119|(4:122|(2:124|385)(2:125|384)|126|120)|383|127)))) */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x03d9, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x03da, code lost:
        
            r24 = r4;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:148:0x03de A[Catch: Exception -> 0x042d, TryCatch #0 {Exception -> 0x042d, blocks: (B:72:0x01ef, B:74:0x01f8, B:76:0x01fe, B:78:0x0207, B:80:0x020d, B:81:0x0217, B:83:0x021d, B:85:0x0231, B:87:0x023f, B:89:0x0245, B:91:0x024f, B:93:0x0255, B:95:0x025b, B:97:0x0265, B:99:0x026b, B:104:0x027b, B:106:0x027f, B:109:0x0287, B:159:0x042f, B:110:0x0295, B:111:0x02b4, B:113:0x02ba, B:115:0x02c6, B:117:0x02cd, B:118:0x02cf, B:119:0x02fc, B:120:0x0323, B:122:0x0329, B:124:0x0335, B:126:0x033c, B:127:0x033e, B:128:0x0345, B:129:0x0366, B:131:0x036c, B:133:0x0378, B:135:0x037f, B:136:0x0381, B:137:0x038f, B:138:0x039f, B:140:0x03a5, B:142:0x03b1, B:144:0x03b8, B:145:0x03ba, B:148:0x03de, B:149:0x03f4, B:151:0x03fa, B:153:0x0406, B:155:0x040d, B:156:0x040f), top: B:318:0x01ef }] */
        /* JADX WARN: Removed duplicated region for block: B:159:0x042f A[Catch: Exception -> 0x042d, TRY_LEAVE, TryCatch #0 {Exception -> 0x042d, blocks: (B:72:0x01ef, B:74:0x01f8, B:76:0x01fe, B:78:0x0207, B:80:0x020d, B:81:0x0217, B:83:0x021d, B:85:0x0231, B:87:0x023f, B:89:0x0245, B:91:0x024f, B:93:0x0255, B:95:0x025b, B:97:0x0265, B:99:0x026b, B:104:0x027b, B:106:0x027f, B:109:0x0287, B:159:0x042f, B:110:0x0295, B:111:0x02b4, B:113:0x02ba, B:115:0x02c6, B:117:0x02cd, B:118:0x02cf, B:119:0x02fc, B:120:0x0323, B:122:0x0329, B:124:0x0335, B:126:0x033c, B:127:0x033e, B:128:0x0345, B:129:0x0366, B:131:0x036c, B:133:0x0378, B:135:0x037f, B:136:0x0381, B:137:0x038f, B:138:0x039f, B:140:0x03a5, B:142:0x03b1, B:144:0x03b8, B:145:0x03ba, B:148:0x03de, B:149:0x03f4, B:151:0x03fa, B:153:0x0406, B:155:0x040d, B:156:0x040f), top: B:318:0x01ef }] */
        /* JADX WARN: Removed duplicated region for block: B:162:0x04a6 A[Catch: Exception -> 0x082a, TryCatch #2 {Exception -> 0x082a, blocks: (B:161:0x045c, B:24:0x0098, B:26:0x009e, B:162:0x04a6, B:164:0x04b0, B:166:0x04c4, B:167:0x04c8, B:23:0x0091), top: B:322:0x0091 }] */
        /* JADX WARN: Removed duplicated region for block: B:177:0x0509 A[Catch: Exception -> 0x0783, TryCatch #13 {Exception -> 0x0783, blocks: (B:175:0x0505, B:177:0x0509, B:179:0x0511, B:181:0x0517, B:183:0x051d, B:185:0x0526, B:186:0x0531, B:188:0x0537, B:195:0x0569, B:200:0x0578, B:205:0x0587, B:206:0x0591, B:208:0x0597), top: B:343:0x0505 }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x009e A[Catch: Exception -> 0x082a, TRY_LEAVE, TryCatch #2 {Exception -> 0x082a, blocks: (B:161:0x045c, B:24:0x0098, B:26:0x009e, B:162:0x04a6, B:164:0x04b0, B:166:0x04c4, B:167:0x04c8, B:23:0x0091), top: B:322:0x0091 }] */
        /* JADX WARN: Removed duplicated region for block: B:272:0x0738 A[Catch: Exception -> 0x077f, TryCatch #6 {Exception -> 0x077f, blocks: (B:213:0x05b8, B:215:0x05be, B:217:0x05c8, B:219:0x05ce, B:221:0x05d4, B:223:0x05de, B:225:0x05e4, B:230:0x05f5, B:232:0x05f9, B:235:0x0601, B:236:0x060d, B:237:0x0629, B:239:0x062f, B:241:0x063b, B:243:0x0642, B:244:0x0644, B:245:0x066f, B:246:0x068f, B:248:0x0695, B:250:0x06a1, B:252:0x06a8, B:253:0x06aa, B:254:0x06b1, B:255:0x06cb, B:257:0x06d1, B:259:0x06dd, B:261:0x06e4, B:262:0x06e6, B:263:0x06f4, B:264:0x0701, B:266:0x0707, B:268:0x0713, B:270:0x071a, B:271:0x071c, B:272:0x0738, B:273:0x0745, B:275:0x074b, B:277:0x0757, B:279:0x075e, B:280:0x0760), top: B:330:0x0507 }] */
        /* JADX WARN: Removed duplicated region for block: B:294:0x07b2 A[Catch: Exception -> 0x07eb, TryCatch #1 {Exception -> 0x07eb, blocks: (B:291:0x078d, B:292:0x07ac, B:294:0x07b2, B:296:0x07be, B:298:0x07c5, B:299:0x07c7), top: B:320:0x078d }] */
        /* JADX WARN: Removed duplicated region for block: B:309:0x0822 A[Catch: Exception -> 0x0828, TRY_LEAVE, TryCatch #9 {Exception -> 0x0828, blocks: (B:301:0x07e3, B:305:0x07f0, B:307:0x07f4, B:309:0x0822), top: B:335:0x07e3 }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00f9 A[Catch: Exception -> 0x0119, TryCatch #8 {Exception -> 0x0119, blocks: (B:51:0x0175, B:54:0x017b, B:31:0x00d0, B:34:0x00f0, B:36:0x00f9, B:43:0x012b, B:45:0x0131, B:46:0x0135, B:48:0x0141, B:42:0x0124), top: B:333:0x0175 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0131 A[Catch: Exception -> 0x0119, TryCatch #8 {Exception -> 0x0119, blocks: (B:51:0x0175, B:54:0x017b, B:31:0x00d0, B:34:0x00f0, B:36:0x00f9, B:43:0x012b, B:45:0x0131, B:46:0x0135, B:48:0x0141, B:42:0x0124), top: B:333:0x0175 }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0141 A[Catch: Exception -> 0x0119, TryCatch #8 {Exception -> 0x0119, blocks: (B:51:0x0175, B:54:0x017b, B:31:0x00d0, B:34:0x00f0, B:36:0x00f9, B:43:0x012b, B:45:0x0131, B:46:0x0135, B:48:0x0141, B:42:0x0124), top: B:333:0x0175 }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x017b A[Catch: Exception -> 0x0119, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x0119, blocks: (B:51:0x0175, B:54:0x017b, B:31:0x00d0, B:34:0x00f0, B:36:0x00f9, B:43:0x012b, B:45:0x0131, B:46:0x0135, B:48:0x0141, B:42:0x0124), top: B:333:0x0175 }] */
        /* JADX WARN: Type inference failed for: r10v18 */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r10v9, types: [int] */
        /* JADX WARN: Type inference failed for: r4v70 */
        /* JADX WARN: Type inference failed for: r4v71, types: [int] */
        /* JADX WARN: Type inference failed for: r4v72, types: [int] */
        /* JADX WARN: Type inference failed for: r5v22 */
        /* JADX WARN: Type inference failed for: r5v23, types: [int] */
        /* JADX WARN: Type inference failed for: r5v29 */
        /* JADX WARN: Type inference failed for: r5v30, types: [int] */
        /* JADX WARN: Type inference failed for: r5v35 */
        /* JADX WARN: Type inference failed for: r5v36, types: [int] */
        /* JADX WARN: Type inference failed for: r5v41 */
        /* JADX WARN: Type inference failed for: r5v42, types: [int] */
        /* JADX WARN: Type inference failed for: r5v82 */
        /* JADX WARN: Type inference failed for: r5v83 */
        /* JADX WARN: Type inference failed for: r5v84 */
        /* JADX WARN: Type inference failed for: r5v85 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:159:0x042f -> B:160:0x0453). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0086 -> B:161:0x045c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00f9 -> B:24:0x0098). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0171 -> B:333:0x0175). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            String str;
            boolean z;
            boolean z2;
            String str2;
            Iterator<MTCardContainer> it;
            MTCardContainer next;
            Object objWithContext;
            int iIntValue;
            List<MTFullCard> list;
            List<MTFullCard> cards;
            List<MTFullCard> list2;
            String str3;
            boolean z3;
            List<Triple<String, Boolean, List<MTSimpleCard>>> list3;
            Ref.IntRef intRef;
            Ref.IntRef intRef2;
            Ref.IntRef intRef3;
            String str4;
            List<MTFullCard> list4;
            CoroutineDispatcher io2;
            Object objWithContext2;
            Ref.IntRef intRef4;
            MTAddCardsResult result;
            String str5;
            List<MTFullCard> list5;
            Object next2;
            String name;
            String str6;
            Iterator it2;
            retrofit2.Response response;
            MTAddCardsResult result2;
            String lang;
            List<MTAddCardResult> list6;
            List<MTFullCard> list7;
            Object next3;
            String name2;
            String str7;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            String str8 = "";
            int i2 = 2;
            Continuation continuation = null;
            boolean z4 = true;
            z4 = true;
            z4 = true;
            z4 = true;
            try {
            } catch (Exception e) {
                e = e;
                str = str8;
                z = z4;
                z2 = false;
                this.$results.add(new Triple<>(next.getName(), Boxing.boxBoolean(z2), null));
                this.$failedContainers.element++;
                Boxing.boxInt(Log.e("Import", "Error processing container " + next.getName() + ": " + e.getMessage()));
                z4 = z;
                str8 = str;
                i2 = 2;
                continuation = null;
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    it = this.$nonBulkContainers.iterator();
                    if (it.hasNext()) {
                    }
                    return coroutine_suspended;
                } catch (Exception e2) {
                    e = e2;
                    str2 = "Import";
                    this.this$0.getBinding().overlay.setVisibility(8);
                    this.this$0.showError("Import error: " + e.getMessage());
                    Log.e(str2, "Overall import error: " + e.getMessage());
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        list4 = (List) this.L$7;
                        Ref.IntRef intRef5 = (Ref.IntRef) this.L$5;
                        intRef4 = (Ref.IntRef) this.L$4;
                        intRef2 = (Ref.IntRef) this.L$3;
                        intRef = (Ref.IntRef) this.L$2;
                        list3 = (List) this.L$1;
                        try {
                            ResultKt.throwOnFailure(obj);
                            intRef3 = intRef5;
                            str3 = "";
                            str4 = "Import";
                            z3 = true;
                            objWithContext2 = obj;
                            try {
                                response = (retrofit2.Response) objWithContext2;
                                try {
                                    if (response == null) {
                                        MTCardListResponse mTCardListResponse = (MTCardListResponse) response.body();
                                        if (mTCardListResponse == null || (result2 = mTCardListResponse.getResult()) == null) {
                                            int i3 = intRef2.element;
                                            Iterator it3 = list4.iterator();
                                            int iIntValue2 = 0;
                                            while (it3.hasNext()) {
                                                Integer quantity = ((MTFullCard) it3.next()).getQuantity();
                                                iIntValue2 += quantity != null ? quantity.intValue() : z3 ? 1 : 0;
                                            }
                                            intRef2.element = i3 + iIntValue2;
                                            list3.add(new Triple<>("Bulk", Boxing.boxBoolean(false), null));
                                            int i4 = intRef.element;
                                            intRef.element = i4 + 1;
                                            Boxing.boxInt(i4);
                                        } else {
                                            List<MTAddCardResult> failed_cards = result2.getFailed_cards();
                                            if (failed_cards == null) {
                                                list3.add(new Triple<>("Bulk", Boxing.boxBoolean(z3), null));
                                                int i5 = intRef4.element;
                                                Iterator it4 = list4.iterator();
                                                int iIntValue3 = 0;
                                                while (it4.hasNext()) {
                                                    Integer quantity2 = ((MTFullCard) it4.next()).getQuantity();
                                                    iIntValue3 += quantity2 != null ? quantity2.intValue() : z3 ? 1 : 0;
                                                }
                                                intRef4.element = i5 + iIntValue3;
                                                int i6 = intRef3.element;
                                                intRef3.element = i6 + 1;
                                                Boxing.boxInt(i6);
                                            } else if (failed_cards.isEmpty()) {
                                                list3.add(new Triple<>("Bulk", Boxing.boxBoolean(z3), null));
                                                intRef3.element++;
                                                int i7 = intRef4.element;
                                                Iterator it5 = list4.iterator();
                                                int iIntValue4 = 0;
                                                while (it5.hasNext()) {
                                                    Integer quantity3 = ((MTFullCard) it5.next()).getQuantity();
                                                    iIntValue4 += quantity3 != null ? quantity3.intValue() : z3 ? 1 : 0;
                                                }
                                                intRef4.element = i7 + iIntValue4;
                                                Unit unit = Unit.INSTANCE;
                                            } else {
                                                ArrayList arrayList = new ArrayList();
                                                for (MTAddCardResult mTAddCardResult : failed_cards) {
                                                    MTSimpleCard mTSimpleCard = new MTSimpleCard(null, null, null, null, null, null, null, null, null, 511, null);
                                                    MTAddCardOriginalData original_data = mTAddCardResult.getOriginal_data();
                                                    if (original_data != null) {
                                                        try {
                                                            lang = original_data.getLang();
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            try {
                                                                list3.add(new Triple<>("Bulk", Boxing.boxBoolean(false), null));
                                                                intRef.element++;
                                                                int i8 = intRef2.element;
                                                                it2 = list4.iterator();
                                                                int iIntValue5 = 0;
                                                                while (it2.hasNext()) {
                                                                }
                                                                intRef2.element = i8 + iIntValue5;
                                                                str2 = str4;
                                                            } catch (Exception e4) {
                                                                e = e4;
                                                                str2 = str4;
                                                                this.this$0.getBinding().overlay.setVisibility(8);
                                                                this.this$0.showError("Import error: " + e.getMessage());
                                                                Log.e(str2, "Overall import error: " + e.getMessage());
                                                            }
                                                            try {
                                                                Boxing.boxInt(Log.e(str2, "Error processing Bulk container: " + e.getMessage()));
                                                                Unit unit2 = Unit.INSTANCE;
                                                                this.this$0.getBinding().overlay.setVisibility(8);
                                                                this.this$0.showImportResults(this.$totalContainers, this.$processedContainers.element, this.$failedContainers.element, this.$totalCards, this.$processedCards.element, this.$failedCards.element, this.$results);
                                                                if (this.$processedContainers.element > 0) {
                                                                }
                                                            } catch (Exception e5) {
                                                                e = e5;
                                                                this.this$0.getBinding().overlay.setVisibility(8);
                                                                this.this$0.showError("Import error: " + e.getMessage());
                                                                Log.e(str2, "Overall import error: " + e.getMessage());
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    } else {
                                                        lang = null;
                                                    }
                                                    mTSimpleCard.setLang(lang);
                                                    MTAddCardOriginalData original_data2 = mTAddCardResult.getOriginal_data();
                                                    mTSimpleCard.setCollector_number(original_data2 != null ? original_data2.getCollector_number() : null);
                                                    MTAddCardOriginalData original_data3 = mTAddCardResult.getOriginal_data();
                                                    mTSimpleCard.setSet_code(original_data3 != null ? original_data3.getSet_code() : null);
                                                    Iterator it6 = list4.iterator();
                                                    while (true) {
                                                        if (!it6.hasNext()) {
                                                            list6 = failed_cards;
                                                            list7 = list4;
                                                            next3 = null;
                                                            break;
                                                        }
                                                        next3 = it6.next();
                                                        MTFullCard mTFullCard = (MTFullCard) next3;
                                                        list6 = failed_cards;
                                                        String lang2 = mTFullCard.getLang();
                                                        MTAddCardOriginalData original_data4 = mTAddCardResult.getOriginal_data();
                                                        if (original_data4 != null) {
                                                            String lang3 = original_data4.getLang();
                                                            list7 = list4;
                                                            str7 = lang3;
                                                        } else {
                                                            list7 = list4;
                                                            str7 = null;
                                                        }
                                                        if (Intrinsics.areEqual(lang2, str7)) {
                                                            String collector_number = mTFullCard.getCollector_number();
                                                            MTAddCardOriginalData original_data5 = mTAddCardResult.getOriginal_data();
                                                            if (Intrinsics.areEqual(collector_number, original_data5 != null ? original_data5.getCollector_number() : null)) {
                                                                String set_code = mTFullCard.getSet_code();
                                                                MTAddCardOriginalData original_data6 = mTAddCardResult.getOriginal_data();
                                                                if (Intrinsics.areEqual(set_code, original_data6 != null ? original_data6.getSet_code() : null)) {
                                                                    break;
                                                                }
                                                            } else {
                                                                continue;
                                                            }
                                                        }
                                                        failed_cards = list6;
                                                        list4 = list7;
                                                    }
                                                    MTFullCard mTFullCard2 = (MTFullCard) next3;
                                                    if (mTFullCard2 == null || (name2 = mTFullCard2.getName()) == null) {
                                                        name2 = str3;
                                                    }
                                                    mTSimpleCard.setName(name2);
                                                    arrayList.add(mTSimpleCard);
                                                    failed_cards = list6;
                                                    list4 = list7;
                                                }
                                                List<MTAddCardResult> list8 = failed_cards;
                                                intRef2.element += list8.size();
                                                int i9 = intRef4.element;
                                                Iterator it7 = list4.iterator();
                                                int iIntValue6 = 0;
                                                while (it7.hasNext()) {
                                                    Integer quantity4 = ((MTFullCard) it7.next()).getQuantity();
                                                    iIntValue6 += quantity4 != null ? quantity4.intValue() : z3 ? 1 : 0;
                                                }
                                                intRef4.element = i9 + (iIntValue6 - list8.size());
                                                list3.add(new Triple<>("Bulk", Boxing.boxBoolean(false), arrayList));
                                                intRef3.element++;
                                                int i10 = intRef.element;
                                                intRef.element = i10 + 1;
                                                Boxing.boxInt(i10);
                                            }
                                        }
                                    } else {
                                        int i11 = intRef2.element;
                                        Iterator it8 = list4.iterator();
                                        int iIntValue7 = 0;
                                        while (it8.hasNext()) {
                                            Integer quantity5 = ((MTFullCard) it8.next()).getQuantity();
                                            iIntValue7 += quantity5 != null ? quantity5.intValue() : z3 ? 1 : 0;
                                        }
                                        intRef2.element = i11 + iIntValue7;
                                        list3.add(new Triple<>("Bulk", Boxing.boxBoolean(false), null));
                                        int i12 = intRef.element;
                                        intRef.element = i12 + 1;
                                        Boxing.boxInt(i12);
                                    }
                                    str2 = str4;
                                } catch (Exception e6) {
                                    e = e6;
                                    list4 = list;
                                }
                            } catch (Exception e7) {
                                e = e7;
                            }
                        } catch (Exception e8) {
                            e = e8;
                            str4 = "Import";
                            z3 = true;
                            list3.add(new Triple<>("Bulk", Boxing.boxBoolean(false), null));
                            intRef.element++;
                            int i82 = intRef2.element;
                            it2 = list4.iterator();
                            int iIntValue52 = 0;
                            while (it2.hasNext()) {
                                Integer quantity6 = ((MTFullCard) it2.next()).getQuantity();
                                iIntValue52 += quantity6 != null ? quantity6.intValue() : z3;
                            }
                            intRef2.element = i82 + iIntValue52;
                            str2 = str4;
                            Boxing.boxInt(Log.e(str2, "Error processing Bulk container: " + e.getMessage()));
                            Unit unit22 = Unit.INSTANCE;
                            this.this$0.getBinding().overlay.setVisibility(8);
                            this.this$0.showImportResults(this.$totalContainers, this.$processedContainers.element, this.$failedContainers.element, this.$totalCards, this.$processedCards.element, this.$failedCards.element, this.$results);
                            if (this.$processedContainers.element > 0) {
                            }
                            return Unit.INSTANCE;
                        }
                        Unit unit222 = Unit.INSTANCE;
                        this.this$0.getBinding().overlay.setVisibility(8);
                        this.this$0.showImportResults(this.$totalContainers, this.$processedContainers.element, this.$failedContainers.element, this.$totalCards, this.$processedCards.element, this.$failedCards.element, this.$results);
                        if (this.$processedContainers.element > 0) {
                            this.this$0.refreshCollectionAndLists();
                        }
                        return Unit.INSTANCE;
                    }
                    List<MTFullCard> list9 = (List) this.L$3;
                    next = (MTCardContainer) this.L$2;
                    it = (Iterator) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    List<MTFullCard> list10 = list9;
                    z2 = false;
                    Object objWithContext3 = obj;
                    try {
                    } catch (Exception e9) {
                        e = e9;
                        str = str8;
                        z = z4;
                    }
                    retrofit2.Response response2 = (retrofit2.Response) objWithContext3;
                    Ref.IntRef intRef6 = this.$failedCards;
                    if (response2 == null) {
                        Ref.IntRef intRef7 = this.$processedCards;
                        List<Triple<String, Boolean, List<MTSimpleCard>>> list11 = this.$results;
                        Ref.IntRef intRef8 = this.$processedContainers;
                        z = z4;
                        Ref.IntRef intRef9 = this.$failedContainers;
                        MTCardListResponse mTCardListResponse2 = (MTCardListResponse) response2.body();
                        if (mTCardListResponse2 == null || (result = mTCardListResponse2.getResult()) == null) {
                            str = str8;
                            int i13 = intRef6.element;
                            Iterator it9 = list10.iterator();
                            ?? IntValue = z2;
                            while (it9.hasNext()) {
                                Integer quantity7 = ((MTFullCard) it9.next()).getQuantity();
                                IntValue += quantity7 != null ? quantity7.intValue() : z ? 1 : 0;
                            }
                            intRef6.element = i13 + IntValue;
                            list11.add(new Triple<>(next.getName(), Boxing.boxBoolean(z2), null));
                            int i14 = intRef9.element;
                            intRef9.element = i14 + 1;
                            Boxing.boxInt(i14);
                        } else {
                            List<MTAddCardResult> failed_cards2 = result.getFailed_cards();
                            if (failed_cards2 == null) {
                                str = str8;
                                list11.add(new Triple<>(next.getName(), Boxing.boxBoolean(z), null));
                                int i15 = intRef7.element;
                                Iterator it10 = list10.iterator();
                                ?? IntValue2 = z2;
                                while (it10.hasNext()) {
                                    Integer quantity8 = ((MTFullCard) it10.next()).getQuantity();
                                    IntValue2 += quantity8 != null ? quantity8.intValue() : z ? 1 : 0;
                                }
                                intRef7.element = i15 + IntValue2;
                                int i16 = intRef8.element;
                                intRef8.element = i16 + 1;
                                Boxing.boxInt(i16);
                            } else if (failed_cards2.isEmpty()) {
                                str = str8;
                                list11.add(new Triple<>(next.getName(), Boxing.boxBoolean(z), null));
                                intRef8.element++;
                                int i17 = intRef7.element;
                                Iterator it11 = list10.iterator();
                                ?? IntValue3 = z2;
                                while (it11.hasNext()) {
                                    Integer quantity9 = ((MTFullCard) it11.next()).getQuantity();
                                    IntValue3 += quantity9 != null ? quantity9.intValue() : z ? 1 : 0;
                                }
                                intRef7.element = i17 + IntValue3;
                                Unit unit3 = Unit.INSTANCE;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                for (MTAddCardResult mTAddCardResult2 : failed_cards2) {
                                    MTSimpleCard mTSimpleCard2 = new MTSimpleCard(null, null, null, null, null, null, null, null, null, 511, null);
                                    List<MTAddCardResult> list12 = failed_cards2;
                                    MTAddCardOriginalData original_data7 = mTAddCardResult2.getOriginal_data();
                                    if (original_data7 != null) {
                                        String lang4 = original_data7.getLang();
                                        str = str8;
                                        str5 = lang4;
                                    } else {
                                        str = str8;
                                        str5 = null;
                                    }
                                    try {
                                    } catch (Exception e10) {
                                        e = e10;
                                        this.$results.add(new Triple<>(next.getName(), Boxing.boxBoolean(z2), null));
                                        this.$failedContainers.element++;
                                        Boxing.boxInt(Log.e("Import", "Error processing container " + next.getName() + ": " + e.getMessage()));
                                        z4 = z;
                                        str8 = str;
                                        i2 = 2;
                                        continuation = null;
                                        if (it.hasNext()) {
                                        }
                                        return coroutine_suspended;
                                    }
                                    mTSimpleCard2.setLang(str5);
                                    MTAddCardOriginalData original_data8 = mTAddCardResult2.getOriginal_data();
                                    mTSimpleCard2.setCollector_number(original_data8 != null ? original_data8.getCollector_number() : null);
                                    MTAddCardOriginalData original_data9 = mTAddCardResult2.getOriginal_data();
                                    mTSimpleCard2.setSet_code(original_data9 != null ? original_data9.getSet_code() : null);
                                    Iterator it12 = list10.iterator();
                                    while (true) {
                                        if (!it12.hasNext()) {
                                            list5 = list10;
                                            next2 = null;
                                            break;
                                        }
                                        next2 = it12.next();
                                        MTFullCard mTFullCard3 = (MTFullCard) next2;
                                        Iterator it13 = it12;
                                        String lang5 = mTFullCard3.getLang();
                                        MTAddCardOriginalData original_data10 = mTAddCardResult2.getOriginal_data();
                                        if (original_data10 != null) {
                                            String lang6 = original_data10.getLang();
                                            list5 = list10;
                                            str6 = lang6;
                                        } else {
                                            list5 = list10;
                                            str6 = null;
                                        }
                                        if (Intrinsics.areEqual(lang5, str6)) {
                                            String collector_number2 = mTFullCard3.getCollector_number();
                                            MTAddCardOriginalData original_data11 = mTAddCardResult2.getOriginal_data();
                                            if (Intrinsics.areEqual(collector_number2, original_data11 != null ? original_data11.getCollector_number() : null)) {
                                                String set_code2 = mTFullCard3.getSet_code();
                                                MTAddCardOriginalData original_data12 = mTAddCardResult2.getOriginal_data();
                                                if (Intrinsics.areEqual(set_code2, original_data12 != null ? original_data12.getSet_code() : null)) {
                                                    break;
                                                }
                                            } else {
                                                continue;
                                            }
                                        }
                                        it12 = it13;
                                        list10 = list5;
                                    }
                                    MTFullCard mTFullCard4 = (MTFullCard) next2;
                                    if (mTFullCard4 == null || (name = mTFullCard4.getName()) == null) {
                                        name = str;
                                    }
                                    mTSimpleCard2.setName(name);
                                    arrayList2.add(mTSimpleCard2);
                                    failed_cards2 = list12;
                                    str8 = str;
                                    list10 = list5;
                                }
                                List<MTAddCardResult> list13 = failed_cards2;
                                str = str8;
                                intRef6.element += list13.size();
                                int i18 = intRef7.element;
                                Iterator it14 = list10.iterator();
                                ?? IntValue4 = z2;
                                while (it14.hasNext()) {
                                    Integer quantity10 = ((MTFullCard) it14.next()).getQuantity();
                                    IntValue4 += quantity10 != null ? quantity10.intValue() : z ? 1 : 0;
                                }
                                intRef7.element = i18 + (IntValue4 - list13.size());
                                list11.add(new Triple<>(next.getName(), Boxing.boxBoolean(z2), arrayList2));
                                intRef8.element++;
                                int i19 = intRef9.element;
                                intRef9.element = i19 + 1;
                                Boxing.boxInt(i19);
                            }
                        }
                    } else {
                        str = str8;
                        List<MTFullCard> list14 = list10;
                        z = z4;
                        List<Triple<String, Boolean, List<MTSimpleCard>>> list15 = this.$results;
                        Ref.IntRef intRef10 = this.$failedContainers;
                        int i20 = intRef6.element;
                        Iterator it15 = list14.iterator();
                        ?? IntValue5 = z2;
                        while (it15.hasNext()) {
                            Integer quantity11 = ((MTFullCard) it15.next()).getQuantity();
                            IntValue5 += quantity11 != null ? quantity11.intValue() : z ? 1 : 0;
                        }
                        intRef6.element = i20 + IntValue5;
                        list15.add(new Triple<>(next.getName(), Boxing.boxBoolean(z2), null));
                        int i21 = intRef10.element;
                        intRef10.element = i21 + 1;
                        Boxing.boxInt(i21);
                    }
                    z4 = z;
                    str8 = str;
                    i2 = 2;
                    continuation = null;
                    if (it.hasNext()) {
                        next = it.next();
                        if (next.getId() == 0) {
                            try {
                            } catch (Exception e11) {
                                e = e11;
                                z2 = false;
                                str = str8;
                                z = z4 ? 1 : 0;
                                this.$results.add(new Triple<>(next.getName(), Boxing.boxBoolean(z2), null));
                                this.$failedContainers.element++;
                                Boxing.boxInt(Log.e("Import", "Error processing container " + next.getName() + ": " + e.getMessage()));
                                z4 = z;
                                str8 = str;
                                i2 = 2;
                                continuation = null;
                                if (it.hasNext()) {
                                }
                                return coroutine_suspended;
                            }
                            list = null;
                            MTEditListBody mTEditListBody = new MTEditListBody(next.getName(), null, null, next.getType(), null, null, 54, null);
                            CoroutineDispatcher io3 = Dispatchers.getIO();
                            CollectionFragment collectionFragment = this.this$0;
                            z2 = false;
                            this.L$0 = coroutineScope;
                            this.L$1 = it;
                            this.L$2 = next;
                            this.L$3 = SpillingKt.nullOutSpilledVariable(mTEditListBody);
                            this.label = z4 ? 1 : 0;
                            objWithContext = BuildersKt.withContext(io3, new CollectionFragment$processContainersImport$1$containerId$newContainerId$1(collectionFragment, this.$currentUser, mTEditListBody, continuation), this);
                            if (objWithContext == coroutine_suspended) {
                            }
                            iIntValue = ((Number) objWithContext).intValue();
                            if (iIntValue == -1) {
                                this.$results.add(new Triple<>(next.getName(), Boxing.boxBoolean(z2), continuation));
                                this.$failedContainers.element += z4 ? 1 : 0;
                                if (it.hasNext()) {
                                    str3 = str8;
                                    z3 = z4 ? 1 : 0;
                                    MTCardContainer mTCardContainer = this.$bulkContainer;
                                    if (mTCardContainer == null) {
                                        str2 = "Import";
                                        this.this$0.getBinding().overlay.setVisibility(8);
                                        this.this$0.showImportResults(this.$totalContainers, this.$processedContainers.element, this.$failedContainers.element, this.$totalCards, this.$processedCards.element, this.$failedCards.element, this.$results);
                                        if (this.$processedContainers.element > 0) {
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    list3 = this.$results;
                                    intRef = this.$failedContainers;
                                    intRef2 = this.$failedCards;
                                    CollectionFragment collectionFragment2 = this.this$0;
                                    MTUser mTUser = this.$currentUser;
                                    Ref.IntRef intRef11 = this.$processedCards;
                                    intRef3 = this.$processedContainers;
                                    List<MTFullCard> cards2 = mTCardContainer.getCards();
                                    if (cards2 == null) {
                                        cards2 = CollectionsKt.emptyList();
                                    }
                                    if (cards2.isEmpty()) {
                                        str2 = "Import";
                                        Unit unit2222 = Unit.INSTANCE;
                                        this.this$0.getBinding().overlay.setVisibility(8);
                                        this.this$0.showImportResults(this.$totalContainers, this.$processedContainers.element, this.$failedContainers.element, this.$totalCards, this.$processedCards.element, this.$failedCards.element, this.$results);
                                        if (this.$processedContainers.element > 0) {
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    try {
                                        io2 = Dispatchers.getIO();
                                        str4 = "Import";
                                    } catch (Exception e12) {
                                        e = e12;
                                        str4 = "Import";
                                    }
                                    try {
                                        CollectionFragment$processContainersImport$1$3$addResponse$1 collectionFragment$processContainersImport$1$3$addResponse$1 = new CollectionFragment$processContainersImport$1$3$addResponse$1(collectionFragment2, mTUser, cards2, null);
                                        this.L$0 = coroutineScope;
                                        this.L$1 = list3;
                                        this.L$2 = intRef;
                                        this.L$3 = intRef2;
                                        this.L$4 = intRef11;
                                        this.L$5 = intRef3;
                                        this.L$6 = SpillingKt.nullOutSpilledVariable(mTCardContainer);
                                        this.L$7 = cards2;
                                        this.I$0 = 0;
                                        this.label = 3;
                                        objWithContext2 = BuildersKt.withContext(io2, collectionFragment$processContainersImport$1$3$addResponse$1, this);
                                    } catch (Exception e13) {
                                        e = e13;
                                        list4 = cards2;
                                        list3.add(new Triple<>("Bulk", Boxing.boxBoolean(false), null));
                                        intRef.element++;
                                        int i822 = intRef2.element;
                                        it2 = list4.iterator();
                                        int iIntValue522 = 0;
                                        while (it2.hasNext()) {
                                        }
                                        intRef2.element = i822 + iIntValue522;
                                        str2 = str4;
                                        Boxing.boxInt(Log.e(str2, "Error processing Bulk container: " + e.getMessage()));
                                        Unit unit22222 = Unit.INSTANCE;
                                        this.this$0.getBinding().overlay.setVisibility(8);
                                        this.this$0.showImportResults(this.$totalContainers, this.$processedContainers.element, this.$failedContainers.element, this.$totalCards, this.$processedCards.element, this.$failedCards.element, this.$results);
                                        if (this.$processedContainers.element > 0) {
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    if (objWithContext2 != coroutine_suspended) {
                                        intRef4 = intRef11;
                                        list4 = cards2;
                                        response = (retrofit2.Response) objWithContext2;
                                        if (response == null) {
                                        }
                                        str2 = str4;
                                        Unit unit222222 = Unit.INSTANCE;
                                        this.this$0.getBinding().overlay.setVisibility(8);
                                        this.this$0.showImportResults(this.$totalContainers, this.$processedContainers.element, this.$failedContainers.element, this.$totalCards, this.$processedCards.element, this.$failedCards.element, this.$results);
                                        if (this.$processedContainers.element > 0) {
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                            int i22 = iIntValue;
                            cards = next.getCards();
                            if (cards == null) {
                                cards = CollectionsKt.emptyList();
                            }
                            list2 = cards;
                            if (list2.isEmpty()) {
                                str = str8;
                                z = z4 ? 1 : 0;
                                this.$results.add(new Triple<>(next.getName(), Boxing.boxBoolean(z), null));
                                int i23 = this.$processedContainers.element;
                                this.$processedContainers.element = i23 + 1;
                                Boxing.boxInt(i23);
                                z4 = z;
                                str8 = str;
                                i2 = 2;
                                continuation = null;
                                if (it.hasNext()) {
                                }
                            } else {
                                CoroutineDispatcher io4 = Dispatchers.getIO();
                                CollectionFragment$processContainersImport$1$addResponse$1 collectionFragment$processContainersImport$1$addResponse$1 = new CollectionFragment$processContainersImport$1$addResponse$1(this.this$0, this.$currentUser, i22, list2, null);
                                list10 = list2;
                                this.L$0 = coroutineScope;
                                this.L$1 = it;
                                this.L$2 = next;
                                this.L$3 = list10;
                                this.I$0 = i22;
                                this.label = i2;
                                objWithContext3 = BuildersKt.withContext(io4, collectionFragment$processContainersImport$1$addResponse$1, this);
                                if (objWithContext3 == coroutine_suspended) {
                                }
                                retrofit2.Response response22 = (retrofit2.Response) objWithContext3;
                                Ref.IntRef intRef62 = this.$failedCards;
                                if (response22 == null) {
                                }
                                z4 = z;
                                str8 = str;
                                i2 = 2;
                                continuation = null;
                                if (it.hasNext()) {
                                }
                            }
                        } else {
                            z2 = false;
                            iIntValue = next.getId();
                            int i222 = iIntValue;
                            cards = next.getCards();
                            if (cards == null) {
                            }
                            list2 = cards;
                            if (list2.isEmpty()) {
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                next = (MTCardContainer) this.L$2;
                it = (Iterator) this.L$1;
                ResultKt.throwOnFailure(obj);
                objWithContext = obj;
                z2 = false;
                iIntValue = ((Number) objWithContext).intValue();
                if (iIntValue == -1) {
                }
                int i2222 = iIntValue;
                cards = next.getCards();
                if (cards == null) {
                }
                list2 = cards;
                if (list2.isEmpty()) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CollectionFragment$processCsvImport$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.CollectionFragment$processCsvImport$1", f = "CollectionFragment.kt", i = {0, 0, 0, 1}, l = {292, 298}, m = "invokeSuspend", n = {"csvContent", "importer", "parseResult", "e"}, s = {"L$0", "L$1", "L$2", "L$0"}, v = 1)
    static final class C11371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InputStream $inputStream;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ CollectionFragment this$0;

        /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CollectionFragment$processCsvImport$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: CollectionFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.studiolaganne.lengendarylens.CollectionFragment$processCsvImport$1$1", f = "CollectionFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C02011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $csvContent;
            final /* synthetic */ MTGCsvImporter.CsvParseResult $parseResult;
            int label;
            final /* synthetic */ CollectionFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02011(CollectionFragment collectionFragment, MTGCsvImporter.CsvParseResult csvParseResult, String str, Continuation<? super C02011> continuation) {
                super(2, continuation);
                this.this$0 = collectionFragment;
                this.$parseResult = csvParseResult;
                this.$csvContent = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02011(this.this$0, this.$parseResult, this.$csvContent, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (this.this$0._binding == null) {
                    return Unit.INSTANCE;
                }
                this.this$0.getBinding().overlay.setVisibility(8);
                this.this$0.showCsvPreviewDialog(this.$parseResult, this.$csvContent);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CollectionFragment$processCsvImport$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: CollectionFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.studiolaganne.lengendarylens.CollectionFragment$processCsvImport$1$2", f = "CollectionFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            int label;
            final /* synthetic */ CollectionFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(CollectionFragment collectionFragment, Exception exc, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = collectionFragment;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (this.this$0._binding == null) {
                    return Unit.INSTANCE;
                }
                this.this$0.getBinding().overlay.setVisibility(8);
                this.this$0.showError("Import error: " + this.$e.getMessage());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11371(InputStream inputStream, CollectionFragment collectionFragment, Continuation<? super C11371> continuation) {
            super(2, continuation);
            this.$inputStream = inputStream;
            this.this$0 = collectionFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C11371(this.$inputStream, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x008f, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.studiolaganne.lengendarylens.CollectionFragment.C11371.C02011(r9.this$0, r5, r10, null), r9) == r0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00bc, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.studiolaganne.lengendarylens.CollectionFragment.C11371.AnonymousClass2(r9.this$0, r10, null), r9) != r0) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00be, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Reader inputStreamReader = new InputStreamReader(this.$inputStream, Charsets.UTF_8);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    try {
                        String text = TextStreamsKt.readText(bufferedReader);
                        CloseableKt.closeFinally(bufferedReader, null);
                        MTGCsvImporter mTGCsvImporter = new MTGCsvImporter();
                        MTGCsvImporter.CsvParseResult csvParseResultImportFromCsvWithDetection = mTGCsvImporter.importFromCsvWithDetection(text);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(text);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(mTGCsvImporter);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(csvParseResultImportFromCsvWithDetection);
                        this.label = 1;
                    } finally {
                    }
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(e);
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object addCardsToContainerSync(int i, int i2, List<MTFullCard> list, Continuation<? super retrofit2.Response<MTCardListResponse>> continuation) {
        String lowerCase;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        List<MTFullCard> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (MTFullCard mTFullCard : list2) {
            String lang = mTFullCard.getLang();
            String name = mTFullCard.getName();
            String collector_number = mTFullCard.getCollector_number();
            String set_code = mTFullCard.getSet_code();
            if (set_code != null) {
                lowerCase = set_code.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            Integer quantity = mTFullCard.getQuantity();
            String condition = mTFullCard.getCondition();
            String finish = mTFullCard.getFinish();
            Boolean altered = mTFullCard.getAltered();
            Boolean signed = mTFullCard.getSigned();
            arrayList.add(new MTFullCard(null, altered, null, null, null, collector_number, null, null, null, condition, null, null, null, null, null, null, null, null, null, null, finish, null, null, null, null, null, null, null, lang, null, null, null, null, null, null, null, mTFullCard.getMissprint(), name, null, null, null, null, null, null, mTFullCard.getPurchase_price(), null, quantity, null, null, lowerCase, null, null, signed, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1200177, 127, null));
        }
        List<MTFullCard> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        for (MTFullCard mTFullCard2 : mutableList) {
            List<String> finishes = mTFullCard2.getFinishes();
            if (finishes == null) {
                finishes = CollectionsKt.emptyList();
            }
            if (finishes.size() == 1) {
                String str = finishes.get(0);
                if (Intrinsics.areEqual(str, "foil") || Intrinsics.areEqual(str, "etched")) {
                    mTFullCard2.setFinish(str);
                }
            }
        }
        MTApiKt.getMtApi().addCardsToList(i, i2, null, null, null, null, null, null, new MTCardListBody(mutableList)).enqueue(new retrofit2.Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$addCardsToContainerSync$2$1
            @Override // retrofit2.Callback
            public void onFailure(retrofit2.Call<MTCardListResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (this.this$0.getContext() == null || this.this$0._binding == null) {
                    return;
                }
                Log.e("Import", "Add cards error: " + t.getMessage());
                cancellableContinuationImpl2.resume((retrofit2.Response<MTCardListResponse>) null, new Function1<Throwable, Unit>() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$addCardsToContainerSync$2$1$onFailure$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                });
            }

            @Override // retrofit2.Callback
            public void onResponse(retrofit2.Call<MTCardListResponse> call, retrofit2.Response<MTCardListResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (this.this$0.getContext() == null || this.this$0._binding == null) {
                    return;
                }
                cancellableContinuationImpl2.resume(response, new Function1<Throwable, Unit>() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$addCardsToContainerSync$2$1$onResponse$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                });
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0182  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String buildDetailedResultMessage(List<? extends Triple<String, Boolean, ? extends List<MTSimpleCard>>> results) {
        int i;
        int i2;
        String upperCase;
        StringBuilder sb = new StringBuilder();
        List<? extends Triple<String, Boolean, ? extends List<MTSimpleCard>>> list = results;
        boolean z = list instanceof Collection;
        int i3 = 0;
        if (z && list.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = list.iterator();
            i = 0;
            while (it.hasNext()) {
                if (((Boolean) ((Triple) it.next()).getSecond()).booleanValue() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (z && list.isEmpty()) {
            i2 = 0;
        } else {
            Iterator<T> it2 = list.iterator();
            i2 = 0;
            while (it2.hasNext()) {
                if (!((Boolean) ((Triple) it2.next()).getSecond()).booleanValue() && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (!z || !list.isEmpty()) {
            Iterator<T> it3 = list.iterator();
            while (it3.hasNext()) {
                Triple triple = (Triple) it3.next();
                if (!((Boolean) triple.getSecond()).booleanValue() && triple.getThird() != null) {
                    Object third = triple.getThird();
                    Intrinsics.checkNotNull(third);
                    if (!((Collection) third).isEmpty() && (i3 = i3 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
        }
        sb.append(getString(R.string.import_summary, Integer.valueOf(i + i3), Integer.valueOf(i2)));
        sb.append("\n\n");
        Iterator<T> it4 = list.iterator();
        while (it4.hasNext()) {
            Triple triple2 = (Triple) it4.next();
            String str = (String) triple2.component1();
            boolean zBooleanValue = ((Boolean) triple2.component2()).booleanValue();
            List<MTSimpleCard> list2 = (List) triple2.component3();
            String str2 = zBooleanValue ? "✅" : "❌";
            if (zBooleanValue) {
                sb.append(str2 + " " + str + "\n");
            } else if (list2 == null || list2.isEmpty()) {
                String string = getString(R.string.import_failed_all_cards);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                sb.append(str2 + " " + str + " - " + string + "\n");
            } else {
                String string2 = getString(R.string.import_failed_with_missing_cards);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                sb.append("⚠️ " + str + " - " + StringsKt.replace$default(string2, "{1}", String.valueOf(list2.size()), false, 4, (Object) null) + "\n");
                for (MTSimpleCard mTSimpleCard : list2) {
                    String name = mTSimpleCard.getName();
                    if (name.length() == 0) {
                        name = "---";
                    }
                    String set_code = mTSimpleCard.getSet_code();
                    if (set_code != null) {
                        upperCase = set_code.toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                        if (upperCase == null) {
                            upperCase = "?";
                        }
                    }
                    String collector_number = mTSimpleCard.getCollector_number();
                    String str3 = collector_number != null ? collector_number : "?";
                    String lang = mTSimpleCard.getLang();
                    if (lang == null) {
                        lang = "--";
                    }
                    sb.append("   • " + ((Object) name) + " (" + upperCase + " #" + str3 + " - " + lang + ")\n");
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        String string3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        return string3;
    }

    private final void checkAndRefreshIfNeeded() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        this.lastKnownCollectionVersion = preferencesManager.getCollectionVersion();
        this.lastKnownListsVersion = preferencesManager.getListsVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object createContainerSync(int i, MTEditListBody mTEditListBody, Continuation<? super Integer> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        MTApiKt.getMtApi().createList(i, mTEditListBody).enqueue(new retrofit2.Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$createContainerSync$2$1
            @Override // retrofit2.Callback
            public void onFailure(retrofit2.Call<MTCardListResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (this.this$0.getContext() == null || this.this$0._binding == null) {
                    return;
                }
                Log.e("Import", "Create container error: " + t.getMessage());
                cancellableContinuationImpl2.resume(-1, new Function1<Throwable, Unit>() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$createContainerSync$2$1$onFailure$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                });
            }

            @Override // retrofit2.Callback
            public void onResponse(retrofit2.Call<MTCardListResponse> call, retrofit2.Response<MTCardListResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (this.this$0.getContext() == null || this.this$0._binding == null) {
                    return;
                }
                if (!response.isSuccessful()) {
                    cancellableContinuationImpl2.resume(-1, new Function1<Throwable, Unit>() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$createContainerSync$2$1$onResponse$3
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    });
                    return;
                }
                MTCardListResponse mTCardListResponseBody = response.body();
                MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                CancellableContinuation<Integer> cancellableContinuation = cancellableContinuationImpl2;
                if (list != null) {
                    cancellableContinuation.resume(Integer.valueOf(list.getId()), new Function1<Throwable, Unit>() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$createContainerSync$2$1$onResponse$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    });
                } else {
                    cancellableContinuation.resume(-1, new Function1<Throwable, Unit>() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$createContainerSync$2$1$onResponse$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    });
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadAndShareFile(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request requestBuild = new Request.Builder().url(url).build();
        getBinding().overlay.setVisibility(0);
        okHttpClient.newCall(requestBuild).enqueue(new AnonymousClass1());
    }

    private final void exportCollection() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("collection_export_start", null);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser == null) {
            return;
        }
        retrofit2.Call<MTDBResponse> callExportCollection = MTApiKt.getMtApi().exportCollection(currentUser.getId());
        getBinding().overlay.setVisibility(0);
        callExportCollection.enqueue(new retrofit2.Callback<MTDBResponse>() { // from class: com.studiolaganne.lengendarylens.CollectionFragment.exportCollection.1
            @Override // retrofit2.Callback
            public void onFailure(retrofit2.Call<MTDBResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (CollectionFragment.this.getContext() == null || CollectionFragment.this._binding == null) {
                    return;
                }
                FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(CollectionFragment.this.requireContext());
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
                firebaseAnalytics2.logEvent("collection_export_failure", null);
                CollectionFragment.this.getBinding().overlay.setVisibility(8);
                Toast.makeText(CollectionFragment.this.requireContext(), R.string.export_collection_error, 1).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(retrofit2.Call<MTDBResponse> call, retrofit2.Response<MTDBResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (CollectionFragment.this.getContext() == null || CollectionFragment.this._binding == null) {
                    return;
                }
                if (!response.isSuccessful()) {
                    FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(CollectionFragment.this.requireContext());
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
                    firebaseAnalytics2.logEvent("collection_export_error", null);
                    CollectionFragment.this.getBinding().overlay.setVisibility(8);
                    Toast.makeText(CollectionFragment.this.requireContext(), R.string.export_collection_error, 1).show();
                    return;
                }
                MTDBResponse mTDBResponseBody = response.body();
                String url = mTDBResponseBody != null ? mTDBResponseBody.getUrl() : null;
                String str = url;
                if (str != null && str.length() != 0) {
                    FirebaseAnalytics firebaseAnalytics3 = FirebaseAnalytics.getInstance(CollectionFragment.this.requireContext());
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics3, "getInstance(...)");
                    firebaseAnalytics3.logEvent("collection_export_ok", null);
                    CollectionFragment.this.downloadAndShareFile(url);
                    return;
                }
                FirebaseAnalytics firebaseAnalytics4 = FirebaseAnalytics.getInstance(CollectionFragment.this.requireContext());
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics4, "getInstance(...)");
                firebaseAnalytics4.logEvent("collection_export_error", null);
                CollectionFragment.this.getBinding().overlay.setVisibility(8);
                Toast.makeText(CollectionFragment.this.requireContext(), R.string.export_collection_error, 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentCollectionBinding getBinding() {
        FragmentCollectionBinding fragmentCollectionBinding = this._binding;
        Intrinsics.checkNotNull(fragmentCollectionBinding);
        return fragmentCollectionBinding;
    }

    private final void handleImportResult(final MTGCsvImporter.ImportResult result) {
        int iIntValue;
        Iterator<T> it = result.getContainers().iterator();
        int i = 0;
        while (it.hasNext()) {
            List<MTFullCard> cards = ((MTCardContainer) it.next()).getCards();
            if (cards != null) {
                Iterator<T> it2 = cards.iterator();
                iIntValue = 0;
                while (it2.hasNext()) {
                    Integer quantity = ((MTFullCard) it2.next()).getQuantity();
                    iIntValue += quantity != null ? quantity.intValue() : 1;
                }
            } else {
                iIntValue = 0;
            }
            i += iIntValue;
        }
        result.getContainers().size();
        if (result.getErrors().isEmpty()) {
            showImportConfirmation(result.getContainers());
            return;
        }
        String string = getString(R.string.import_partial, Integer.valueOf(i), Integer.valueOf(result.getErrors().size()));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Iterator<T> it3 = result.getErrors().iterator();
        while (it3.hasNext()) {
            Log.e("ImportCSV", (String) it3.next());
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string2 = getString(R.string.import_warning_title);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = builder.setTitle(string2).setBody(string + "\n\n" + getString(R.string.import_warning_message));
        String string3 = getString(R.string.continue_anyway);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CollectionFragment.handleImportResult$lambda$2(this.f$0, result, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionFragment.handleImportResult$lambda$3(this.f$0, (CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "import_warning_dialog");
    }

    static final Unit handleImportResult$lambda$2(CollectionFragment collectionFragment, MTGCsvImporter.ImportResult importResult, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        collectionFragment.showImportConfirmation(importResult.getContainers());
        return Unit.INSTANCE;
    }

    static final Unit handleImportResult$lambda$3(CollectionFragment collectionFragment, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        Toast.makeText(collectionFragment.requireContext(), collectionFragment.getString(R.string.import_canceled), 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSuccessfulFirebaseLogin(MTLoginResponse response) {
        List<MTPlaygroup> listEmptyList;
        List<MTFriend> listEmptyList2;
        List<MTDeck> listEmptyList3;
        List<MTCardContainer> global;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser user = response != null ? response.getUser() : null;
        if (response == null || (listEmptyList = response.getPlaygroups()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (response == null || (listEmptyList2 = response.getFriends()) == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        if (response == null || (listEmptyList3 = response.getDecks()) == null) {
            listEmptyList3 = CollectionsKt.emptyList();
        }
        if (response != null) {
            response.getResult();
        }
        if (user != null) {
            FirebaseAnalytics.getInstance(requireContext()).setUserProperty("is_logged_in", "true");
            preferencesManager.saveCurrentUser(user);
            preferencesManager.saveCurrentUserPlaygroups(listEmptyList);
            preferencesManager.saveCurrentUserFriends(listEmptyList2);
            preferencesManager.saveCurrentUserDecks(listEmptyList3);
            MTCollection collection = response.getCollection();
            if (collection != null) {
                preferencesManager.saveCurrentUserCollection(collection);
            }
            MTUserLists lists = response.getLists();
            if (lists != null) {
                preferencesManager.saveCurrentUserLists(lists);
            }
            MTUserLists lists2 = response.getLists();
            if (lists2 != null && (global = lists2.getGlobal()) != null) {
                for (MTCardContainer mTCardContainer : global) {
                    if (Intrinsics.areEqual(mTCardContainer.getName(), PreferencesManager.RECENT_CARDS_LIST_NAME)) {
                        PreferencesManager.INSTANCE.setRecentCardListId(mTCardContainer.getId());
                    }
                }
            }
            preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
            FragmentActivity activity = getActivity();
            MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
            if (mainActivity != null) {
                mainActivity.userLoggedIn();
            }
            MTFavorites favorites = response.getFavorites();
            if (favorites != null) {
                preferencesManager.saveCurrentUserFavorites(favorites);
            }
            MTUserTags tags = response.getTags();
            if (tags != null) {
                preferencesManager.saveCurrentUserTags(tags);
            }
            List<MTTrophy> trophies = response.getTrophies();
            if (trophies != null) {
                preferencesManager.saveCurrentUserTrophies(trophies);
            }
            MTUserPrivacy privacy = response.getPrivacy();
            if (privacy != null) {
                preferencesManager.saveCurrentUserPrivacy(privacy);
            }
            updateUISetup();
        }
    }

    @JvmStatic
    public static final CollectionFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final Unit onSignInFailure$lambda$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$0(CollectionFragment collectionFragment) {
        if (collectionFragment.getContext() != null && collectionFragment.collectionSetup) {
            Context contextRequireContext = collectionFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            if (Intrinsics.areEqual(collectionFragment.layoutType, "grid")) {
                collectionFragment.layoutType = "cards";
                preferencesManager.setString(PreferencesManager.LAST_COLLECTION_LAYOUT_TYPE, "cards");
                collectionFragment.getBinding().toggleLayoutTextView.setText("\uf022");
            } else {
                collectionFragment.layoutType = "grid";
                preferencesManager.setString(PreferencesManager.LAST_COLLECTION_LAYOUT_TYPE, "grid");
                collectionFragment.getBinding().toggleLayoutTextView.setText("\uf84c");
            }
            Fragment fragment = collectionFragment.fragmentList.get(0);
            CollectionRootFragment collectionRootFragment = fragment instanceof CollectionRootFragment ? (CollectionRootFragment) fragment : null;
            if (collectionRootFragment != null) {
                collectionRootFragment.refreshLayoutType();
            }
            Fragment fragment2 = collectionFragment.fragmentList.get(2);
            ListsRootFragment listsRootFragment = fragment2 instanceof ListsRootFragment ? (ListsRootFragment) fragment2 : null;
            if (listsRootFragment != null) {
                listsRootFragment.refreshLayoutType();
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$1(CollectionFragment collectionFragment) {
        if (collectionFragment.getContext() == null || collectionFragment._binding == null) {
            return Unit.INSTANCE;
        }
        new CollectionHelpDialogFragment.Builder().setOnDismissListener(new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        }).build().show(collectionFragment.getChildFragmentManager(), "collection_help_dialog");
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$2(final CollectionFragment collectionFragment) {
        if (collectionFragment.getContext() == null || collectionFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = collectionFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        boolean z = new PreferencesManager(contextRequireContext).getInt(PreferencesManager.SHARED_COLLECTION_BADGE_COUNT, 0) > 0;
        Context contextRequireContext2 = collectionFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        IconPopupMenu iconPopupMenuAddItem$default = IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(new IconPopupMenu(contextRequireContext2), R.string.import_action, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionFragment.onViewCreated$lambda$2$0(this.f$0);
            }
        }, 30, (Object) null), R.string.export_action, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionFragment.onViewCreated$lambda$2$1(this.f$0);
            }
        }, 30, (Object) null).addDivider(), R.string.share_collection_menu, (String) null, false, z, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionFragment.onViewCreated$lambda$2$2(this.f$0);
            }
        }, 22, (Object) null);
        TextView menuTextView = collectionFragment.getBinding().menuTextView;
        Intrinsics.checkNotNullExpressionValue(menuTextView, "menuTextView");
        iconPopupMenuAddItem$default.show(menuTextView);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2$0(CollectionFragment collectionFragment) {
        collectionFragment.showImportDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2$1(CollectionFragment collectionFragment) {
        collectionFragment.exportCollection();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2$2(CollectionFragment collectionFragment) {
        collectionFragment.startActivity(new Intent(collectionFragment.requireContext(), (Class<?>) SharedCollectionsActivity.class));
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$3(CollectionFragment collectionFragment) {
        if (collectionFragment.getContext() == null || collectionFragment._binding == null) {
            return Unit.INSTANCE;
        }
        collectionFragment.getBinding().marketplaceSelectorView.showMarketplaceSelectionDialog();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$4(CollectionFragment collectionFragment) {
        if (collectionFragment.getContext() == null || collectionFragment._binding == null) {
            return Unit.INSTANCE;
        }
        collectionFragment.getBinding().marketplaceSelectorView.showMarketplaceSelectionDialog();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$5(final CollectionFragment collectionFragment, String marketplace) {
        Intrinsics.checkNotNullParameter(marketplace, "marketplace");
        if (collectionFragment.getContext() == null || collectionFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = collectionFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).syncCurrentSettingsToAPI(new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionFragment.onViewCreated$lambda$5$0(this.f$0);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5$0(CollectionFragment collectionFragment) {
        if (collectionFragment.getContext() != null && collectionFragment._binding != null) {
            collectionFragment.refreshCollectionAndLists();
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$6(CollectionFragment collectionFragment) {
        if (collectionFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Intent intent = new Intent(collectionFragment.requireContext(), (Class<?>) SignUpActivity.class);
        intent.addFlags(335544320);
        collectionFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$7(CollectionFragment collectionFragment) {
        if (collectionFragment.getContext() == null || collectionFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("collection_login_click");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(collectionFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("collection_login_click", null);
        SignInBottomSheetFragment.INSTANCE.newInstance(collectionFragment).show(collectionFragment.getChildFragmentManager(), SignInBottomSheetFragment.TAG);
        return Unit.INSTANCE;
    }

    private final void processContainersImport(List<MTCardContainer> resolvedContainers) {
        Object next;
        int iIntValue;
        if (getContext() == null || this._binding == null) {
            return;
        }
        getBinding().overlay.setVisibility(0);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser == null) {
            getBinding().overlay.setVisibility(8);
            Toast.makeText(requireContext(), R.string.error_adding_card, 1).show();
            return;
        }
        int size = resolvedContainers.size();
        List<MTCardContainer> list = resolvedContainers;
        Iterator<T> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            List<MTFullCard> cards = ((MTCardContainer) it.next()).getCards();
            if (cards != null) {
                Iterator<T> it2 = cards.iterator();
                iIntValue = 0;
                while (it2.hasNext()) {
                    Integer quantity = ((MTFullCard) it2.next()).getQuantity();
                    iIntValue += quantity != null ? quantity.intValue() : 1;
                }
            } else {
                iIntValue = 0;
            }
            i += iIntValue;
        }
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        Ref.IntRef intRef3 = new Ref.IntRef();
        Ref.IntRef intRef4 = new Ref.IntRef();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it3 = list.iterator();
        while (true) {
            if (it3.hasNext()) {
                next = it3.next();
                if (((MTCardContainer) next).getId() == 4) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        MTCardContainer mTCardContainer = (MTCardContainer) next;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (((MTCardContainer) obj).getId() != 4) {
                arrayList2.add(obj);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new C11361(arrayList2, arrayList, intRef3, intRef, mTCardContainer, this, size, i, intRef2, intRef4, currentUser, null), 2, null);
    }

    private final void processCsvImport(InputStream inputStream, String fileName) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C11371(inputStream, this, null), 2, null);
    }

    private final void processImportWithNameConflictResolution(List<MTCardContainer> containers) {
        List<MTCardContainer> user;
        if (getContext() == null || this._binding == null) {
            return;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("collection_import_process", null);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTCollection currentUserCollection = preferencesManager.getCurrentUserCollection();
        if (currentUserCollection == null) {
            currentUserCollection = new MTCollection(null, null, null, null, 0, 0, null, null, 255, null);
        }
        MTUserLists currentUserLists = preferencesManager.getCurrentUserLists();
        if (currentUserLists == null) {
            currentUserLists = new MTUserLists(null, null, 3, null);
        }
        String str = new SimpleDateFormat("yyyyMMdd_HHmm", Locale.getDefault()).format(new Date());
        ArrayList arrayList = new ArrayList();
        for (MTCardContainer mTCardContainer : containers) {
            if (mTCardContainer.getId() == 4) {
                arrayList.add(mTCardContainer);
            } else if (mTCardContainer.getId() == 0) {
                MTCardContainer mTCardContainerCopy$default = MTCardContainer.copy$default(mTCardContainer, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
                Integer type = mTCardContainer.getType();
                if (type != null && type.intValue() == 2) {
                    List<MTCardContainer> boxes = currentUserCollection.getBoxes();
                    if (boxes != null) {
                        List<MTCardContainer> list = boxes;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                if (StringsKt.equals(((MTCardContainer) it.next()).getName(), mTCardContainer.getName(), true)) {
                                    mTCardContainerCopy$default.setName(mTCardContainer.getName() + " (Imported - " + str + ")");
                                    break;
                                }
                            }
                        }
                    }
                    arrayList.add(mTCardContainerCopy$default);
                } else if (type != null && type.intValue() == 1) {
                    List<MTCardContainer> binders = currentUserCollection.getBinders();
                    if (binders != null) {
                        List<MTCardContainer> list2 = binders;
                        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                            Iterator<T> it2 = list2.iterator();
                            while (it2.hasNext()) {
                                if (StringsKt.equals(((MTCardContainer) it2.next()).getName(), mTCardContainer.getName(), true)) {
                                    mTCardContainerCopy$default.setName(mTCardContainer.getName() + " (Imported - " + str + ")");
                                    break;
                                }
                            }
                        }
                    }
                    arrayList.add(mTCardContainerCopy$default);
                } else {
                    if (type != null && type.intValue() == 0 && (user = currentUserLists.getUser()) != null) {
                        List<MTCardContainer> list3 = user;
                        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                            Iterator<T> it3 = list3.iterator();
                            while (it3.hasNext()) {
                                if (StringsKt.equals(((MTCardContainer) it3.next()).getName(), mTCardContainer.getName(), true)) {
                                    mTCardContainerCopy$default.setName(mTCardContainer.getName() + " (Imported - " + str + ")");
                                    break;
                                }
                            }
                        }
                    }
                    arrayList.add(mTCardContainerCopy$default);
                }
            } else {
                arrayList.add(mTCardContainer);
            }
        }
        processContainersImport(arrayList);
    }

    private final void processTxtImport(List<ParsedCard> parsedCards) {
        String str;
        if (getContext() == null || this._binding == null || parsedCards.isEmpty()) {
            if (parsedCards.isEmpty()) {
                Toast.makeText(requireContext(), getString(R.string.no_valid_cards_found), 0).show();
            }
            getBinding().overlay.setVisibility(8);
            return;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("collection_import_txt", null);
        String str2 = new SimpleDateFormat("yyyyMMdd_HHmm", Locale.getDefault()).format(new Date());
        List<ParsedCard> list = parsedCards;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ParsedCard parsedCard : list) {
            String setCode = parsedCard.getSetCode();
            if (setCode != null) {
                String lowerCase = setCode.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                str = lowerCase;
            } else {
                str = null;
            }
            arrayList.add(new MTFullCard(null, null, null, null, null, parsedCard.getCollectorNumber(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, parsedCard.getFinish(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, parsedCard.getCardName(), null, null, null, null, null, null, null, null, Integer.valueOf(parsedCard.getQuantity()), null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1048609, -147489, 127, null));
        }
        MTCardContainer mTCardContainer = new MTCardContainer(null, null, null, 0, "TXT Import - " + str2, 2, "Box", null, arrayList, null, null, null, null, null, null, null, 65159, null);
        getBinding().overlay.setVisibility(8);
        showImportConfirmation(CollectionsKt.listOf(mTCardContainer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshCollectionAndLists() {
        for (Fragment fragment : this.fragmentList) {
            if (fragment instanceof CollectionRootFragment) {
                ((CollectionRootFragment) fragment).refreshFromRemote();
            } else if (fragment instanceof DecksRootFragment) {
                ((DecksRootFragment) fragment).refreshFromRemote();
            } else if (fragment instanceof ListsRootFragment) {
                ((ListsRootFragment) fragment).refreshFromRemote();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void shareFile(File file) {
        try {
            Uri uriForFile = FileProvider.getUriForFile(requireContext(), requireContext().getPackageName() + ".fileprovider", file);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/csv");
            intent.putExtra("android.intent.extra.STREAM", uriForFile);
            intent.putExtra("android.intent.extra.SUBJECT", "Mythic Tools Collection Export (" + System.currentTimeMillis() + ")");
            intent.addFlags(1);
            getBinding().overlay.setVisibility(8);
            startActivity(Intent.createChooser(intent, "Export Collection"));
        } catch (Exception unused) {
            getBinding().overlay.setVisibility(8);
            Toast.makeText(requireContext(), R.string.failed_share, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCsvPreviewDialog(MTGCsvImporter.CsvParseResult parseResult, String csvContent) {
        if (getContext() == null || this._binding == null) {
            return;
        }
        CsvPreviewDialogFragment.Builder onCancel = new CsvPreviewDialogFragment.Builder().setParseResult(parseResult).setCsvContent(csvContent).setOnContinue(new Function2() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CollectionFragment.showCsvPreviewDialog$lambda$0(this.f$0, (MTGCsvImporter.ImportResult) obj, (Map) obj2);
            }
        }).setOnCancel(new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionFragment.showCsvPreviewDialog$lambda$1(this.f$0);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        onCancel.show(childFragmentManager, CsvPreviewDialogFragment.TAG);
    }

    static final Unit showCsvPreviewDialog$lambda$0(CollectionFragment collectionFragment, MTGCsvImporter.ImportResult importResult, Map map) {
        Intrinsics.checkNotNullParameter(importResult, "importResult");
        if (map != null) {
            Log.d("ImportCSV", "User provided custom column mappings: " + map);
        }
        collectionFragment.handleImportResult(importResult);
        return Unit.INSTANCE;
    }

    static final Unit showCsvPreviewDialog$lambda$1(CollectionFragment collectionFragment) {
        Toast.makeText(collectionFragment.requireContext(), collectionFragment.getString(R.string.import_canceled), 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showError(String message) {
        Toast.makeText(requireContext(), message, 1).show();
    }

    private final void showImportConfirmation(List<MTCardContainer> containers) {
        if (getContext() == null || this._binding == null) {
            return;
        }
        ImportConfirmationDialogFragment.Builder onCancel = new ImportConfirmationDialogFragment.Builder().setContainers(containers).setOnConfirm(new Function1() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionFragment.showImportConfirmation$lambda$0(this.f$0, (List) obj);
            }
        }).setOnCancel(new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionFragment.showImportConfirmation$lambda$1(this.f$0);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        onCancel.show(childFragmentManager, "import_confirmation_dialog");
    }

    static final Unit showImportConfirmation$lambda$0(CollectionFragment collectionFragment, List selectedContainers) {
        Intrinsics.checkNotNullParameter(selectedContainers, "selectedContainers");
        if (selectedContainers.isEmpty()) {
            Toast.makeText(collectionFragment.requireContext(), collectionFragment.getString(R.string.import_canceled), 0).show();
        } else {
            collectionFragment.processImportWithNameConflictResolution(selectedContainers);
        }
        return Unit.INSTANCE;
    }

    static final Unit showImportConfirmation$lambda$1(CollectionFragment collectionFragment) {
        Toast.makeText(collectionFragment.requireContext(), collectionFragment.getString(R.string.import_canceled), 0).show();
        return Unit.INSTANCE;
    }

    private final void showImportDialog() {
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("collection_import_start", null);
        new ImportCsvDialogFragment.Builder().setListener(this).build().show(getParentFragmentManager(), ImportCsvDialogFragment.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showImportResults(int totalContainers, int processedContainers, int failedContainers, int totalCards, int processedCards, int failedCards, List<? extends Triple<String, Boolean, ? extends List<MTSimpleCard>>> results) {
        if (getContext() == null) {
            return;
        }
        if (failedContainers == 0 && failedCards == 0) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("collection_import_finished_ok", null);
            String string = getString(R.string.import_success, Integer.valueOf(processedCards), Integer.valueOf(processedContainers));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showSuccess(string);
            return;
        }
        if (processedContainers <= 0) {
            FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
            firebaseAnalytics2.logEvent("collection_import_finished_error", null);
            String string2 = getString(R.string.import_failed);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            showError(string2);
            return;
        }
        String string3 = getString(R.string.import_partial, Integer.valueOf(processedCards), Integer.valueOf(failedCards));
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        FirebaseAnalytics firebaseAnalytics3 = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics3, "getInstance(...)");
        firebaseAnalytics3.logEvent("collection_import_finished_partial", null);
        String strBuildDetailedResultMessage = buildDetailedResultMessage(results);
        Toast.makeText(requireContext(), string3, 1).show();
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string4 = getString(R.string.import_results);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder body = builder.setTitle(string4).setBody(strBuildDetailedResultMessage);
        String string5 = getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string5, new Function2() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CollectionFragment.showImportResults$lambda$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "import_results_dialog");
    }

    static final Unit showImportResults$lambda$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void showPartialSuccess(String message, List<String> errors) {
        Toast.makeText(requireContext(), message, 1).show();
        for (String str : errors) {
        }
    }

    private final void showSuccess(String message) {
        Toast.makeText(requireContext(), message, 1).show();
    }

    private final void updateBadgeDot() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        getBinding().menuBadgeDot.setVisibility(new PreferencesManager(contextRequireContext).getInt(PreferencesManager.SHARED_COLLECTION_BADGE_COUNT, 0) <= 0 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUISetup() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        LinearLayout topBar = getBinding().topBar;
        Intrinsics.checkNotNullExpressionValue(topBar, "topBar");
        TabLayout tabs = getBinding().tabs;
        Intrinsics.checkNotNullExpressionValue(tabs, "tabs");
        ViewPager2 viewPager = getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
        ConstraintLayout accountInfo = getBinding().accountInfo;
        Intrinsics.checkNotNullExpressionValue(accountInfo, "accountInfo");
        if (preferencesManager.getCurrentUser() == null) {
            topBar.setVisibility(8);
            tabs.setVisibility(8);
            viewPager.setVisibility(8);
            accountInfo.setVisibility(0);
            return;
        }
        accountInfo.setVisibility(8);
        topBar.setVisibility(0);
        tabs.setVisibility(0);
        viewPager.setVisibility(0);
        viewPager.setUserInputEnabled(false);
        if (this.collectionSetup) {
            return;
        }
        this.fragmentList = CollectionsKt.mutableListOf(new CollectionRootFragment(), new DecksRootFragment(), new ListsRootFragment());
        viewPager.setAdapter(new FragmentStateAdapter() { // from class: com.studiolaganne.lengendarylens.CollectionFragment.updateUISetup.1
            {
                super(CollectionFragment.this);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            public Fragment createFragment(int position) {
                return position != 0 ? position != 1 ? position != 2 ? new Fragment() : (Fragment) CollectionFragment.this.fragmentList.get(2) : (Fragment) CollectionFragment.this.fragmentList.get(1) : (Fragment) CollectionFragment.this.fragmentList.get(0);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return CollectionFragment.this.fragmentList.size();
            }
        });
        new TabLayoutMediator(tabs, viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda3
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                CollectionFragment.updateUISetup$lambda$0(this.f$0, tab, i);
            }
        }).attach();
        this.collectionSetup = true;
    }

    static final void updateUISetup$lambda$0(CollectionFragment collectionFragment, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setText(i != 0 ? i != 1 ? i != 2 ? null : collectionFragment.getString(R.string.lists_tab) : collectionFragment.getString(R.string.decks_tab) : collectionFragment.getString(R.string.collection_tab));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentCollectionBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        this.isVisible = !hidden;
        if (hidden || getActivity() == null) {
            return;
        }
        checkAndRefreshIfNeeded();
        updateUISetup();
        updateBadgeDot();
    }

    @Override // com.studiolaganne.lengendarylens.ImportCsvDialogListener
    public void onImportCollection(CollectionImportResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("collection_import_confirm", null);
        if (result instanceof CollectionImportResult.CsvImport) {
            if (this._binding == null) {
                return;
            }
            getBinding().overlay.setVisibility(0);
            CollectionImportResult.CsvImport csvImport = (CollectionImportResult.CsvImport) result;
            processCsvImport(csvImport.getInputStream(), csvImport.getFileName());
            return;
        }
        if (!(result instanceof CollectionImportResult.TxtImport)) {
            throw new NoWhenBranchMatchedException();
        }
        if (this._binding == null) {
            return;
        }
        getBinding().overlay.setVisibility(0);
        processTxtImport(((CollectionImportResult.TxtImport) result).getParsedCards());
    }

    @Override // com.studiolaganne.lengendarylens.CollectionRootListener
    public void onImportRequested() {
        showImportDialog();
    }

    @Override // com.studiolaganne.lengendarylens.SignInCallback
    public void onOAuthSignInSuccess(String code, String type) {
        String str;
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(type, "type");
        if (getContext() == null || this._binding == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("collection_oauth_success");
        FirebaseAnalytics.getInstance(requireContext()).logEvent("collection_oauth_success", null);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(SignInBottomSheetFragment.TAG);
        SignInBottomSheetFragment signInBottomSheetFragment = fragmentFindFragmentByTag instanceof SignInBottomSheetFragment ? (SignInBottomSheetFragment) fragmentFindFragmentByTag : null;
        if (signInBottomSheetFragment != null) {
            signInBottomSheetFragment.dismiss();
        }
        String string = preferencesManager.getString(PreferencesManager.FCM_TOKEN, "");
        if (Intrinsics.areEqual(string, "")) {
            try {
                String result = FirebaseMessaging.getInstance().getToken().getResult();
                Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                str = result;
            } catch (Exception e) {
                Log.d(FirebaseMessaging.INSTANCE_ID_SCOPE, "Failed to get FCM token: " + e.getLocalizedMessage());
                str = string;
            }
        } else {
            str = string;
        }
        MTLoginBody mTLoginBody = new MTLoginBody(str, preferencesManager.getDeviceLanguage(), null, null, code, type, 12, null);
        getBinding().overlay.setVisibility(0);
        MTApiKt.getMtApi().exchange(mTLoginBody).enqueue(new C11341(preferencesManager));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this._binding != null) {
            getBinding().marketplaceSelectorView.updateIcon();
        }
        checkAndRefreshIfNeeded();
        updateUISetup();
        updateBadgeDot();
    }

    @Override // com.studiolaganne.lengendarylens.SignInCallback
    public void onSignInCancel() {
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(SignInBottomSheetFragment.TAG);
        SignInBottomSheetFragment signInBottomSheetFragment = fragmentFindFragmentByTag instanceof SignInBottomSheetFragment ? (SignInBottomSheetFragment) fragmentFindFragmentByTag : null;
        if (signInBottomSheetFragment != null) {
            signInBottomSheetFragment.dismiss();
        }
    }

    @Override // com.studiolaganne.lengendarylens.SignInCallback
    public void onSignInFailure(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getContext() == null || this._binding == null) {
            return;
        }
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(SignInBottomSheetFragment.TAG);
        SignInBottomSheetFragment signInBottomSheetFragment = fragmentFindFragmentByTag instanceof SignInBottomSheetFragment ? (SignInBottomSheetFragment) fragmentFindFragmentByTag : null;
        if (signInBottomSheetFragment != null) {
            signInBottomSheetFragment.dismiss();
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.login_error_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.login_error_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CollectionFragment.onSignInFailure$lambda$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "login_error_dialog");
    }

    @Override // com.studiolaganne.lengendarylens.SignInCallback
    public void onSignInSuccess(String token, String firstname, String email) {
        String str;
        Intrinsics.checkNotNullParameter(token, "token");
        if (getContext() == null || this._binding == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("collection_login_success");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("collection_login_success", null);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(SignInBottomSheetFragment.TAG);
        SignInBottomSheetFragment signInBottomSheetFragment = fragmentFindFragmentByTag instanceof SignInBottomSheetFragment ? (SignInBottomSheetFragment) fragmentFindFragmentByTag : null;
        if (signInBottomSheetFragment != null) {
            signInBottomSheetFragment.dismiss();
        }
        String string = preferencesManager.getString(PreferencesManager.FCM_TOKEN, "");
        if (Intrinsics.areEqual(string, "")) {
            try {
                String result = FirebaseMessaging.getInstance().getToken().getResult();
                Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                str = result;
            } catch (Exception e) {
                Log.d(FirebaseMessaging.INSTANCE_ID_SCOPE, "Failed to get FCM token: " + e.getLocalizedMessage());
                str = string;
            }
        } else {
            str = string;
        }
        MTLoginBody mTLoginBody = new MTLoginBody(str, preferencesManager.getDeviceLanguage(), firstname, email, null, null, 48, null);
        getBinding().overlay.setVisibility(0);
        MTApiKt.getMtApi().signin(mTLoginBody).enqueue(new C11351(preferencesManager));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String string = new PreferencesManager(contextRequireContext).getString(PreferencesManager.LAST_COLLECTION_LAYOUT_TYPE, "grid");
        this.layoutType = string;
        if (Intrinsics.areEqual(string, "grid")) {
            getBinding().toggleLayoutTextView.setText("\uf84c");
        } else {
            getBinding().toggleLayoutTextView.setText("\uf022");
        }
        TextView toggleLayoutTextView = getBinding().toggleLayoutTextView;
        Intrinsics.checkNotNullExpressionValue(toggleLayoutTextView, "toggleLayoutTextView");
        ViewExtensionsKt.setOnClickWithFade(toggleLayoutTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        TextView helpTextView = getBinding().helpTextView;
        Intrinsics.checkNotNullExpressionValue(helpTextView, "helpTextView");
        ViewExtensionsKt.setOnClickWithFade(helpTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionFragment.onViewCreated$lambda$1(this.f$0);
            }
        });
        TextView menuTextView = getBinding().menuTextView;
        Intrinsics.checkNotNullExpressionValue(menuTextView, "menuTextView");
        ViewExtensionsKt.setOnClickWithFade(menuTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionFragment.onViewCreated$lambda$2(this.f$0);
            }
        });
        MarketplaceSelectorView marketplaceSelectorView = getBinding().marketplaceSelectorView;
        Intrinsics.checkNotNullExpressionValue(marketplaceSelectorView, "marketplaceSelectorView");
        ViewExtensionsKt.setOnClickWithFade(marketplaceSelectorView, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionFragment.onViewCreated$lambda$3(this.f$0);
            }
        });
        LinearLayout marketplaceSelectorContainer = getBinding().marketplaceSelectorContainer;
        Intrinsics.checkNotNullExpressionValue(marketplaceSelectorContainer, "marketplaceSelectorContainer");
        ViewExtensionsKt.setOnClickWithFade(marketplaceSelectorContainer, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionFragment.onViewCreated$lambda$4(this.f$0);
            }
        });
        getBinding().marketplaceSelectorView.setOnMarketplaceChangedListener(new Function1() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionFragment.onViewCreated$lambda$5(this.f$0, (String) obj);
            }
        });
        ConstraintLayout signUpButtonLayout = getBinding().signUpButtonLayout;
        Intrinsics.checkNotNullExpressionValue(signUpButtonLayout, "signUpButtonLayout");
        ViewExtensionsKt.setOnClickWithFade(signUpButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionFragment.onViewCreated$lambda$6(this.f$0);
            }
        });
        TextView signInTextView = getBinding().signInTextView;
        Intrinsics.checkNotNullExpressionValue(signInTextView, "signInTextView");
        ViewExtensionsKt.setOnClickWithFade(signInTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.CollectionFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CollectionFragment.onViewCreated$lambda$7(this.f$0);
            }
        });
        this.collectionSetup = false;
        updateUISetup();
    }
}
