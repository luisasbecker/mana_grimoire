package com.studiolaganne.lengendarylens;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.studiolaganne.lengendarylens.BrowseListCardItem;
import com.studiolaganne.lengendarylens.BrowseListFragment;
import com.studiolaganne.lengendarylens.CardPickerBottomSheetFragment;
import com.studiolaganne.lengendarylens.CollectionImportResult;
import com.studiolaganne.lengendarylens.ContainerImportConfirmationDialogFragment;
import com.studiolaganne.lengendarylens.CsvPreviewDialogFragment;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.EditContainerDialogFragment;
import com.studiolaganne.lengendarylens.ExportTxtDialogFragment;
import com.studiolaganne.lengendarylens.FilterDialogFragment;
import com.studiolaganne.lengendarylens.ImportCsvDialogFragment;
import com.studiolaganne.lengendarylens.MTGCsvImporter;
import com.studiolaganne.lengendarylens.MoveCardDialogFragment;
import com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment;
import com.studiolaganne.lengendarylens.UnifiedFiltersBottomSheetFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentBrowseListBinding;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: BrowseListFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 Ë\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0002Ë\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u000eH\u0002J\u0010\u0010E\u001a\u00020C2\u0006\u0010F\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020CH\u0002J\b\u0010I\u001a\u00020CH\u0002J\u0010\u0010J\u001a\u00020C2\u0006\u0010D\u001a\u00020\u000eH\u0002J\b\u0010K\u001a\u00020CH\u0002J\u0010\u0010L\u001a\u00020C2\u0006\u0010M\u001a\u00020NH\u0016J\u0018\u0010O\u001a\u00020C2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u000eH\u0002J\u0016\u0010S\u001a\u00020C2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020U0\u0018H\u0002J\u0018\u0010V\u001a\u00020C2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u000eH\u0002J\u0010\u0010Z\u001a\u00020C2\u0006\u0010M\u001a\u00020[H\u0002J\u0016\u0010\\\u001a\u00020C2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J\u0016\u0010^\u001a\u00020C2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J4\u0010_\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010`2\u0006\u0010b\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\u00102\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0082@¢\u0006\u0002\u0010dJ.\u0010e\u001a\u00020C2\u0006\u00108\u001a\u00020\u00102\u0006\u0010f\u001a\u00020\u00102\u0006\u0010g\u001a\u00020\u00102\f\u0010h\u001a\b\u0012\u0004\u0012\u00020i0\u0018H\u0002J\b\u0010j\u001a\u00020CH\u0002J\b\u0010k\u001a\u00020CH\u0002J\b\u0010l\u001a\u00020CH\u0002J\b\u0010m\u001a\u00020CH\u0002J \u0010n\u001a\u00020C2\u0006\u0010o\u001a\u00020\u001c2\u0006\u0010p\u001a\u00020\u00102\b\b\u0002\u0010q\u001a\u00020\u0010J\u001e\u0010r\u001a\u00020C2\u0006\u0010o\u001a\u00020\u001c2\u0006\u0010p\u001a\u00020\u00102\u0006\u0010q\u001a\u00020\u0010J\u000e\u0010s\u001a\u00020\u00132\u0006\u0010p\u001a\u00020\u0010J\u000e\u0010t\u001a\u00020\u00102\u0006\u0010p\u001a\u00020\u0010J\u000e\u0010u\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J\u0018\u0010v\u001a\u00020C2\u0006\u0010o\u001a\u00020\u001c2\u0006\u0010p\u001a\u00020\u0010H\u0016J\u0018\u0010w\u001a\u00020C2\u0006\u0010o\u001a\u00020\u001c2\u0006\u0010p\u001a\u00020\u0010H\u0016J \u0010x\u001a\u00020C2\u0006\u0010o\u001a\u00020\u001c2\u0006\u0010p\u001a\u00020\u00102\u0006\u0010y\u001a\u00020\u0010H\u0016J\u0010\u0010z\u001a\u00020C2\u0006\u0010{\u001a\u00020\u0010H\u0002J!\u0010|\u001a\u00020C2\u0006\u0010}\u001a\u00020~2\u0006\u0010{\u001a\u00020\u00102\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\"\u0010\u0081\u0001\u001a\u00020C2\u0006\u0010}\u001a\u00020~2\u0006\u0010{\u001a\u00020\u00102\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\"\u0010\u0082\u0001\u001a\u00020C2\u000e\u0010\u0083\u0001\u001a\t\u0012\u0005\u0012\u00030\u0084\u00010`2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\u0013\u0010\u008b\u0001\u001a\u00020C2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0016J\u0013\u0010\u008e\u0001\u001a\u00020C2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0016J\u0013\u0010\u008f\u0001\u001a\u00020C2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0016J\u0012\u0010\u0090\u0001\u001a\u00020C2\u0007\u0010\u0091\u0001\u001a\u00020\u000eH\u0016J\u001a\u0010\u0092\u0001\u001a\u00020C2\u0006\u0010o\u001a\u00020\u001c2\u0007\u0010\u0093\u0001\u001a\u00020\u0010H\u0016J\u0015\u0010\u0094\u0001\u001a\u00020C2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0016J-\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\t\u0010\u0015\u001a\u0005\u0018\u00010\u009b\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0016J\u001c\u0010\u009d\u0001\u001a\u00020C2\u0007\u0010\u009e\u0001\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\t\u0010\u009f\u0001\u001a\u00020CH\u0016J\t\u0010 \u0001\u001a\u00020\u0013H\u0002J\u001f\u0010¡\u0001\u001a\u00020C2\b\u0010¢\u0001\u001a\u00030\u0098\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0016J\t\u0010£\u0001\u001a\u00020CH\u0016J\u0012\u0010¤\u0001\u001a\u00020C2\u0007\u0010¥\u0001\u001a\u00020\u0010H\u0002J\u001b\u0010¦\u0001\u001a\u00020C2\u0007\u0010§\u0001\u001a\u00020\u00162\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\u001a\u0010¨\u0001\u001a\u00020C2\u0006\u0010}\u001a\u00020~2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\u001a\u0010©\u0001\u001a\u00020C2\u0006\u0010}\u001a\u00020~2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J!\u0010ª\u0001\u001a\u00020C2\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020a0`2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\u0012\u0010«\u0001\u001a\u00020C2\u0007\u0010¬\u0001\u001a\u00020\u0013H\u0002J\t\u0010\u00ad\u0001\u001a\u00020CH\u0002J\t\u0010®\u0001\u001a\u00020CH\u0002J\u0018\u0010¯\u0001\u001a\u00020C2\r\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018H\u0002J\u0012\u0010±\u0001\u001a\u00020C2\u0007\u0010²\u0001\u001a\u00020\u000eH\u0002J\t\u0010³\u0001\u001a\u00020CH\u0002J\u0014\u0010´\u0001\u001a\u00020C2\t\b\u0002\u0010µ\u0001\u001a\u00020\u0013H\u0002J\t\u0010¶\u0001\u001a\u00020CH\u0002J\t\u0010·\u0001\u001a\u00020CH\u0002J\t\u0010¸\u0001\u001a\u00020CH\u0002J\u0012\u0010¹\u0001\u001a\u00020C2\u0007\u0010²\u0001\u001a\u00020\u000eH\u0002J\t\u0010º\u0001\u001a\u00020CH\u0002J\t\u0010»\u0001\u001a\u00020CH\u0002J\u0013\u0010¼\u0001\u001a\u00020C2\b\u0010½\u0001\u001a\u00030\u0098\u0001H\u0002J\u0013\u0010¾\u0001\u001a\u00020C2\b\u0010½\u0001\u001a\u00030\u0098\u0001H\u0002J\t\u0010¿\u0001\u001a\u00020CH\u0002J\u0018\u0010À\u0001\u001a\u00020C2\r\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J\t\u0010Â\u0001\u001a\u00020CH\u0002J\u0015\u0010Ã\u0001\u001a\u00020C2\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001H\u0002J\u0015\u0010Æ\u0001\u001a\u00020C2\n\u0010Ç\u0001\u001a\u0005\u0018\u00010È\u0001H\u0002J\u0012\u0010É\u0001\u001a\u00020C2\u0007\u0010Ê\u0001\u001a\u00020\u000eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0085\u0001\u001a\u0014\u0012\u000f\u0012\r \u0088\u0001*\u0005\u0018\u00010\u0087\u00010\u0087\u00010\u0086\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0089\u0001\u001a\u0014\u0012\u000f\u0012\r \u0088\u0001*\u0005\u0018\u00010\u0087\u00010\u0087\u00010\u0086\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u008a\u0001\u001a\u0014\u0012\u000f\u0012\r \u0088\u0001*\u0005\u0018\u00010\u0087\u00010\u0087\u00010\u0086\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u009c\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ì\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/BrowseListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/OnMTFullCardClickListener;", "Lcom/studiolaganne/lengendarylens/FilterDialogListener;", "Lcom/studiolaganne/lengendarylens/OnFilterClickListener;", "Lcom/studiolaganne/lengendarylens/OnCardLongPressListener;", "Lcom/studiolaganne/lengendarylens/OnCardSelectionListener;", "Lcom/studiolaganne/lengendarylens/ImportCsvDialogListener;", "Lcom/studiolaganne/lengendarylens/UnifiedFiltersListener;", "<init>", "()V", "currentLayout", "Lcom/studiolaganne/lengendarylens/CardsLayout;", "lang", "", "listId", "", "otherUserId", "isOtherUserList", "", "()Z", "container", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "sets", "", "Lcom/studiolaganne/lengendarylens/CardSet;", "currentCards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "currentGroupedCards", "Lcom/studiolaganne/lengendarylens/MTCardGroup;", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentBrowseListBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentBrowseListBinding;", "searchJob", "Lkotlinx/coroutines/Job;", "getSearchJob", "()Lkotlinx/coroutines/Job;", "setSearchJob", "(Lkotlinx/coroutines/Job;)V", "lastQuery", "pickACardMode", "shouldShowIntFields", "filtersCollapsed", "scrollStoppedRunnable", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "currentEditDialog", "Lcom/studiolaganne/lengendarylens/EditCardDialogFragment;", "selectionMode", "selectedCards", "", "currentPage", "totalCards", "isLoading", "hasMorePages", "cardsPerPage", "currentNameFilter", "currentScryfallFilter", "currentOrderBy", "currentOrderDirection", "currentGroupBy", "forceRefresh", "downloadAndShareFile", "", "url", "shareFile", "file", "Ljava/io/File;", "exportList", "exportListAsTxt", "downloadAndParseCsvForTxt", "showImportDialog", "onImportCollection", "result", "Lcom/studiolaganne/lengendarylens/CollectionImportResult;", "processCsvImport", "inputStream", "Ljava/io/InputStream;", "fileName", "processTxtImport", "parsedCards", "Lcom/studiolaganne/lengendarylens/ParsedCard;", "showCsvPreviewDialog", "parseResult", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$CsvParseResult;", "csvContent", "handleImportResult", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$ImportResult;", "showContainerImportConfirmation", "cards", "processImportIntoCurrentContainer", "addCardsToContainerSync", "Lretrofit2/Response;", "Lcom/studiolaganne/lengendarylens/MTCardListResponse;", "userId", "containerId", "(IILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showContainerImportResults", "processedCards", "failedCards", "failedCardsList", "Lcom/studiolaganne/lengendarylens/MTSimpleCard;", "editContainer", "enterSelectionMode", "exitSelectionMode", "updateSelectionCountText", "toggleCardSelection", "card", "position", FirebaseAnalytics.Param.QUANTITY, "updateSelectionQuantity", "isCardSelected", "getSelectedQuantity", "getAllCardsFlat", "onCardLongPress", "onCardSelectionToggle", "onQuantityChange", "newQuantity", "moveSelectedCardsToContainer", "destinationId", "moveCardsFromSingleList", "currentUser", "Lcom/studiolaganne/lengendarylens/MTUser;", "prefs", "Lcom/studiolaganne/lengendarylens/PreferencesManager;", "moveCardsFromMultipleLists", "handleSingleListMoveResponse", "response", "Lcom/studiolaganne/lengendarylens/MTMoveCardsResponse;", "allPrintsActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "cardActivityLauncher", "scanActivityLauncher", "onFilterClick", "filter", "Lcom/studiolaganne/lengendarylens/SearchCondition;", "onFilterDelete", "onFilterSubmitButton", "onFiltersApplied", "scryfallQuery", "onMTFullCardClick", FirebaseAnalytics.Param.INDEX, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "lastKnownContainerVersion", "updateTitleWithPrice", "name", "onResume", "isSmallCards", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "onDestroyView", "loadListData", "page", "displayContainerFromCache", "list", "deleteCardsFromSingleList", "deleteCardsFromMultipleLists", "handleSingleListDeleteResponse", "showLoadingFooter", "show", "resetAndRefreshList", "refreshListMaintainingPosition", "mergeGroupedCards", "newGroups", "updateFiltersAndRefreshList", SearchIntents.EXTRA_QUERY, "clearFiltersAndRefreshList", "setupRecyclerViewForCurrentLayout", "keepSelectionMode", "hideAddButton", "showAddButton", "updateCardCount", "updateFilterListFromQuery", "setupSortAndGroupButtons", "setupToolbarMarketplaceSelector", "showSortByPopupMenu", "anchor", "showGroupByPopupMenu", "saveSortingGroupingSettings", "addScannedCardsToList", "scannedCards", "setupPrivacyToolbar", "updateOtherUserInfo", "user", "Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "updatePrivacyToolbar", "privacy", "Lcom/studiolaganne/lengendarylens/MTContainerPrivacy;", "updateListPrivacy", "newType", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseListFragment extends Fragment implements OnMTFullCardClickListener, FilterDialogListener, OnFilterClickListener, OnCardLongPressListener, OnCardSelectionListener, ImportCsvDialogListener, UnifiedFiltersListener {
    private FragmentBrowseListBinding _binding;
    private final ActivityResultLauncher<Intent> allPrintsActivityLauncher;
    private final ActivityResultLauncher<Intent> cardActivityLauncher;
    private MTCardContainer container;
    private EditCardDialogFragment currentEditDialog;
    private String currentGroupBy;
    private String currentNameFilter;
    private String currentScryfallFilter;
    private boolean filtersCollapsed;
    private boolean forceRefresh;
    private boolean isLoading;
    private int lastKnownContainerVersion;
    private boolean pickACardMode;
    private final ActivityResultLauncher<Intent> scanActivityLauncher;
    private Runnable scrollStoppedRunnable;
    private Job searchJob;
    private boolean selectionMode;
    private int totalCards;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private CardsLayout currentLayout = CardsLayout.GRID_BY_2;
    private String lang = "en";
    private int listId = -1;
    private int otherUserId = -1;
    private List<CardSet> sets = CollectionsKt.emptyList();
    private List<MTFullCard> currentCards = new ArrayList();
    private List<MTCardGroup> currentGroupedCards = new ArrayList();
    private String lastQuery = "";
    private boolean shouldShowIntFields = true;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Map<Integer, Integer> selectedCards = new LinkedHashMap();
    private int currentPage = 1;
    private boolean hasMorePages = true;
    private final int cardsPerPage = 100;
    private String currentOrderBy = "added_at";
    private String currentOrderDirection = "desc";

    /* JADX INFO: compiled from: BrowseListFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/BrowseListFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/BrowseCardsFragment;", "setCode", "", "lang", "pickACardMode", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ BrowseCardsFragment newInstance$default(Companion companion, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.newInstance(str, str2, z);
        }

        @JvmStatic
        public final BrowseCardsFragment newInstance(String setCode, String lang, boolean pickACardMode) {
            Intrinsics.checkNotNullParameter(setCode, "setCode");
            Intrinsics.checkNotNullParameter(lang, "lang");
            BrowseCardsFragment browseCardsFragment = new BrowseCardsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("setCode", setCode);
            bundle.putString("lang", lang);
            bundle.putBoolean("pickACardMode", pickACardMode);
            browseCardsFragment.setArguments(bundle);
            return browseCardsFragment;
        }
    }

    /* JADX INFO: compiled from: BrowseListFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardsLayout.values().length];
            try {
                iArr[CardsLayout.GRID_BY_2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CardsLayout.GRID_BY_3.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CardsLayout.LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.BrowseListFragment$downloadAndParseCsvForTxt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrowseListFragment.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/studiolaganne/lengendarylens/BrowseListFragment$downloadAndParseCsvForTxt$1", "Lokhttp3/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C11121 implements Callback {
        C11121() {
        }

        static final void onFailure$lambda$0(BrowseListFragment browseListFragment) {
            if (browseListFragment.getContext() == null || browseListFragment._binding == null) {
                return;
            }
            browseListFragment.getBinding().overlay.setVisibility(8);
            Toast.makeText(browseListFragment.requireContext(), R.string.export_list_error, 1).show();
        }

        static final void onResponse$lambda$1(BrowseListFragment browseListFragment) {
            if (browseListFragment.getContext() == null || browseListFragment._binding == null) {
                return;
            }
            browseListFragment.getBinding().overlay.setVisibility(8);
            Toast.makeText(browseListFragment.requireContext(), R.string.export_list_error, 1).show();
        }

        static final void onResponse$lambda$3(BrowseListFragment browseListFragment, List list) {
            if (browseListFragment.getContext() == null || browseListFragment._binding == null) {
                return;
            }
            browseListFragment.getBinding().overlay.setVisibility(8);
            ExportTxtDialogFragment.Builder cards = new ExportTxtDialogFragment.Builder().setCards(list);
            FragmentManager childFragmentManager = browseListFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            cards.show(childFragmentManager, "ExportTxtDialog");
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e, "e");
            FragmentActivity fragmentActivityRequireActivity = BrowseListFragment.this.requireActivity();
            final BrowseListFragment browseListFragment = BrowseListFragment.this;
            fragmentActivityRequireActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$downloadAndParseCsvForTxt$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BrowseListFragment.C11121.onFailure$lambda$0(browseListFragment);
                }
            });
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String strString;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (!response.isSuccessful()) {
                FragmentActivity fragmentActivityRequireActivity = BrowseListFragment.this.requireActivity();
                final BrowseListFragment browseListFragment = BrowseListFragment.this;
                fragmentActivityRequireActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$downloadAndParseCsvForTxt$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        BrowseListFragment.C11121.onResponse$lambda$1(browseListFragment);
                    }
                });
                return;
            }
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody == null || (strString = responseBodyBody.string()) == null) {
                strString = "";
            }
            List<MTCardContainer> containers = new MTGCsvImporter().importFromCsv(strString).getContainers();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = containers.iterator();
            while (it.hasNext()) {
                List<MTFullCard> cards = ((MTCardContainer) it.next()).getCards();
                if (cards == null) {
                    cards = CollectionsKt.emptyList();
                }
                CollectionsKt.addAll(arrayList, cards);
            }
            final ArrayList arrayList2 = arrayList;
            FragmentActivity fragmentActivityRequireActivity2 = BrowseListFragment.this.requireActivity();
            final BrowseListFragment browseListFragment2 = BrowseListFragment.this;
            fragmentActivityRequireActivity2.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$downloadAndParseCsvForTxt$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    BrowseListFragment.C11121.onResponse$lambda$3(browseListFragment2, arrayList2);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.BrowseListFragment$downloadAndShareFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrowseListFragment.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/BrowseListFragment$downloadAndShareFile$1", "Lokhttp3/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "Lokio/IOException;", "onResponse", "response", "Lokhttp3/Response;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C11131 implements Callback {
        C11131() {
        }

        static final void onFailure$lambda$0(BrowseListFragment browseListFragment) {
            if (browseListFragment.getContext() == null || browseListFragment._binding == null) {
                return;
            }
            browseListFragment.getBinding().overlay.setVisibility(8);
            Toast.makeText(browseListFragment.requireContext(), R.string.download_error_body, 1).show();
        }

        static final void onResponse$lambda$1(BrowseListFragment browseListFragment) {
            if (browseListFragment.getContext() == null || browseListFragment._binding == null) {
                return;
            }
            browseListFragment.getBinding().overlay.setVisibility(8);
            Toast.makeText(browseListFragment.requireContext(), R.string.download_error_body, 1).show();
        }

        static final void onResponse$lambda$3(BrowseListFragment browseListFragment, File file) {
            if (browseListFragment.getContext() == null || browseListFragment._binding == null) {
                return;
            }
            browseListFragment.shareFile(file);
        }

        static final void onResponse$lambda$4(BrowseListFragment browseListFragment) {
            if (browseListFragment.getContext() == null || browseListFragment._binding == null) {
                return;
            }
            browseListFragment.getBinding().overlay.setVisibility(8);
            Toast.makeText(browseListFragment.requireContext(), R.string.download_error_body, 1).show();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e, "e");
            if (BrowseListFragment.this.getContext() == null || BrowseListFragment.this._binding == null) {
                return;
            }
            FragmentActivity fragmentActivityRequireActivity = BrowseListFragment.this.requireActivity();
            final BrowseListFragment browseListFragment = BrowseListFragment.this;
            fragmentActivityRequireActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$downloadAndShareFile$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BrowseListFragment.C11131.onFailure$lambda$0(browseListFragment);
                }
            });
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (BrowseListFragment.this.getContext() == null || BrowseListFragment.this._binding == null) {
                return;
            }
            if (!response.isSuccessful()) {
                FragmentActivity fragmentActivityRequireActivity = BrowseListFragment.this.requireActivity();
                final BrowseListFragment browseListFragment = BrowseListFragment.this;
                fragmentActivityRequireActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$downloadAndShareFile$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        BrowseListFragment.C11131.onResponse$lambda$1(browseListFragment);
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
                final File file = new File(BrowseListFragment.this.requireContext().getCacheDir(), "list_export_" + System.currentTimeMillis() + ".csv");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    ByteStreamsKt.copyTo$default(inputStreamByteStream, fileOutputStream, 0, 2, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    FragmentActivity fragmentActivityRequireActivity2 = BrowseListFragment.this.requireActivity();
                    final BrowseListFragment browseListFragment2 = BrowseListFragment.this;
                    fragmentActivityRequireActivity2.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$downloadAndShareFile$1$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            BrowseListFragment.C11131.onResponse$lambda$3(browseListFragment2, file);
                        }
                    });
                } finally {
                }
            } catch (IOException unused) {
                FragmentActivity fragmentActivityRequireActivity3 = BrowseListFragment.this.requireActivity();
                final BrowseListFragment browseListFragment3 = BrowseListFragment.this;
                fragmentActivityRequireActivity3.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$downloadAndShareFile$1$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        BrowseListFragment.C11131.onResponse$lambda$4(browseListFragment3);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.BrowseListFragment$processCsvImport$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrowseListFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.BrowseListFragment$processCsvImport$1", f = "BrowseListFragment.kt", i = {0, 0, 0, 1}, l = {Videoio.CAP_PROP_XI_CC_MATRIX_12, Videoio.CAP_PROP_XI_CC_MATRIX_30}, m = "invokeSuspend", n = {"csvContent", "importer", "parseResult", "e"}, s = {"L$0", "L$1", "L$2", "L$0"}, v = 1)
    static final class C11211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InputStream $inputStream;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ BrowseListFragment this$0;

        /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.BrowseListFragment$processCsvImport$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BrowseListFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.studiolaganne.lengendarylens.BrowseListFragment$processCsvImport$1$1", f = "BrowseListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $csvContent;
            final /* synthetic */ MTGCsvImporter.CsvParseResult $parseResult;
            int label;
            final /* synthetic */ BrowseListFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01991(BrowseListFragment browseListFragment, MTGCsvImporter.CsvParseResult csvParseResult, String str, Continuation<? super C01991> continuation) {
                super(2, continuation);
                this.this$0 = browseListFragment;
                this.$parseResult = csvParseResult;
                this.$csvContent = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01991(this.this$0, this.$parseResult, this.$csvContent, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

        /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.BrowseListFragment$processCsvImport$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: BrowseListFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.studiolaganne.lengendarylens.BrowseListFragment$processCsvImport$1$2", f = "BrowseListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            int label;
            final /* synthetic */ BrowseListFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(BrowseListFragment browseListFragment, Exception exc, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = browseListFragment;
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
                Toast.makeText(this.this$0.requireContext(), "Import error: " + this.$e.getMessage(), 1).show();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11211(InputStream inputStream, BrowseListFragment browseListFragment, Continuation<? super C11211> continuation) {
            super(2, continuation);
            this.$inputStream = inputStream;
            this.this$0 = browseListFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C11211(this.$inputStream, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x008f, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.studiolaganne.lengendarylens.BrowseListFragment.C11211.C01991(r9.this$0, r5, r10, null), r9) == r0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00bc, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.studiolaganne.lengendarylens.BrowseListFragment.C11211.AnonymousClass2(r9.this$0, r10, null), r9) != r0) goto L31;
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

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.BrowseListFragment$processImportIntoCurrentContainer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrowseListFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.BrowseListFragment$processImportIntoCurrentContainer$1", f = "BrowseListFragment.kt", i = {0}, l = {635}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
    static final class C11221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<MTFullCard> $cards;
        final /* synthetic */ MTUser $currentUser;
        final /* synthetic */ Ref.IntRef $failedCards;
        final /* synthetic */ List<MTSimpleCard> $failedCardsList;
        final /* synthetic */ Ref.IntRef $processedCards;
        final /* synthetic */ int $totalCards;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11221(int i, Ref.IntRef intRef, Ref.IntRef intRef2, List<MTSimpleCard> list, MTUser mTUser, List<MTFullCard> list2, Continuation<? super C11221> continuation) {
            super(2, continuation);
            this.$totalCards = i;
            this.$processedCards = intRef;
            this.$failedCards = intRef2;
            this.$failedCardsList = list;
            this.$currentUser = mTUser;
            this.$cards = list2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11221 c11221 = BrowseListFragment.this.new C11221(this.$totalCards, this.$processedCards, this.$failedCards, this.$failedCardsList, this.$currentUser, this.$cards, continuation);
            c11221.L$0 = obj;
            return c11221;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objWithContext;
            MTAddCardsResult result;
            Object next;
            String name;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            String str = null;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new BrowseListFragment$processImportIntoCurrentContainer$1$addResponse$1(BrowseListFragment.this, this.$currentUser, this.$cards, null), this);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    objWithContext = obj;
                }
                retrofit2.Response response = (retrofit2.Response) objWithContext;
                if (response != null) {
                    List<MTFullCard> list = this.$cards;
                    List<MTSimpleCard> list2 = this.$failedCardsList;
                    Ref.IntRef intRef = this.$failedCards;
                    Ref.IntRef intRef2 = this.$processedCards;
                    int i2 = this.$totalCards;
                    MTCardListResponse mTCardListResponse = (MTCardListResponse) response.body();
                    if (mTCardListResponse == null || (result = mTCardListResponse.getResult()) == null) {
                        intRef.element = i2;
                    } else {
                        List<MTAddCardResult> failed_cards = result.getFailed_cards();
                        if (failed_cards == null || failed_cards.isEmpty()) {
                            intRef2.element = i2;
                        } else {
                            for (MTAddCardResult mTAddCardResult : failed_cards) {
                                MTSimpleCard mTSimpleCard = new MTSimpleCard(null, null, null, null, null, null, null, null, null, 511, null);
                                MTAddCardOriginalData original_data = mTAddCardResult.getOriginal_data();
                                mTSimpleCard.setLang(original_data != null ? original_data.getLang() : str);
                                MTAddCardOriginalData original_data2 = mTAddCardResult.getOriginal_data();
                                mTSimpleCard.setCollector_number(original_data2 != null ? original_data2.getCollector_number() : str);
                                MTAddCardOriginalData original_data3 = mTAddCardResult.getOriginal_data();
                                mTSimpleCard.setSet_code(original_data3 != null ? original_data3.getSet_code() : str);
                                Iterator<T> it = list.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        next = null;
                                        break;
                                    }
                                    next = it.next();
                                    MTFullCard mTFullCard = (MTFullCard) next;
                                    String lang = mTFullCard.getLang();
                                    MTAddCardOriginalData original_data4 = mTAddCardResult.getOriginal_data();
                                    if (Intrinsics.areEqual(lang, original_data4 != null ? original_data4.getLang() : null)) {
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
                                }
                                MTFullCard mTFullCard2 = (MTFullCard) next;
                                if (mTFullCard2 == null || (name = mTFullCard2.getName()) == null) {
                                    name = "";
                                }
                                mTSimpleCard.setName(name);
                                list2.add(mTSimpleCard);
                                str = null;
                            }
                            intRef.element = failed_cards.size();
                            intRef2.element = i2 - intRef.element;
                        }
                    }
                } else {
                    this.$failedCards.element = this.$totalCards;
                }
                BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                BrowseListFragment.this.showContainerImportResults(this.$totalCards, this.$processedCards.element, this.$failedCards.element, this.$failedCardsList);
                if (this.$processedCards.element > 0) {
                    CardContainerCache.INSTANCE.invalidate(BrowseListFragment.this.listId);
                    BrowseListFragment.this.resetAndRefreshList();
                }
            } catch (Exception e) {
                if (BrowseListFragment.this._binding == null) {
                    return Unit.INSTANCE;
                }
                BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                Toast.makeText(BrowseListFragment.this.requireContext(), "Import error: " + e.getMessage(), 1).show();
                Log.e("Import", "Container import error: " + e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.BrowseListFragment$setupRecyclerViewForCurrentLayout$3, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseListFragment.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/studiolaganne/lengendarylens/BrowseListFragment$setupRecyclerViewForCurrentLayout$3", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "onScrollStateChanged", "newState", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass3 extends RecyclerView.OnScrollListener {
        AnonymousClass3() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                final BrowseListFragment browseListFragment = BrowseListFragment.this;
                browseListFragment.scrollStoppedRunnable = new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$setupRecyclerViewForCurrentLayout$3$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        browseListFragment.showAddButton();
                    }
                };
                Handler handler = BrowseListFragment.this.handler;
                Runnable runnable = BrowseListFragment.this.scrollStoppedRunnable;
                Intrinsics.checkNotNull(runnable);
                handler.postDelayed(runnable, 2000L);
                return;
            }
            if (newState != 1) {
                return;
            }
            BrowseListFragment.this.hideAddButton();
            Runnable runnable2 = BrowseListFragment.this.scrollStoppedRunnable;
            if (runnable2 != null) {
                BrowseListFragment.this.handler.removeCallbacks(runnable2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
            if (dy > 0) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                int iIntValue = 0;
                int childCount = layoutManager != null ? layoutManager.getChildCount() : 0;
                int itemCount = layoutManager != null ? layoutManager.getItemCount() : 0;
                if (layoutManager instanceof LinearLayoutManager) {
                    iIntValue = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                } else if (layoutManager instanceof GridLayoutManager) {
                    iIntValue = ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
                } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                    int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
                    staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
                    Integer numMinOrNull = ArraysKt.minOrNull(iArr);
                    if (numMinOrNull != null) {
                        iIntValue = numMinOrNull.intValue();
                    }
                }
                if (BrowseListFragment.this.isLoading || !BrowseListFragment.this.hasMorePages || childCount + iIntValue < itemCount - 5) {
                    return;
                }
                BrowseListFragment.this.currentPage++;
                BrowseListFragment browseListFragment = BrowseListFragment.this;
                browseListFragment.loadListData(browseListFragment.currentPage);
            }
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.BrowseListFragment$updateFilterListFromQuery$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrowseListFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.BrowseListFragment$updateFilterListFromQuery$1", f = "BrowseListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11251(String str, Continuation<? super C11251> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11251 c11251 = BrowseListFragment.this.new C11251(this.$query, continuation);
            c11251.L$0 = obj;
            return c11251;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Context context;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (BrowseListFragment.this.isAdded() && (context = BrowseListFragment.this.getContext()) != null) {
                SearchElement searchQuery = SearchDataUtils.INSTANCE.getInstance().parseSearchQuery(this.$query);
                RecyclerView filtersRecyclerView = BrowseListFragment.this.getBinding().filtersRecyclerView;
                Intrinsics.checkNotNullExpressionValue(filtersRecyclerView, "filtersRecyclerView");
                filtersRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, 1));
                boolean z = BrowseListFragment.this.filtersCollapsed;
                BrowseListFragment browseListFragment = BrowseListFragment.this;
                if (z) {
                    TextView addFilterButton = browseListFragment.getBinding().addFilterButton;
                    Intrinsics.checkNotNullExpressionValue(addFilterButton, "addFilterButton");
                    addFilterButton.setVisibility(4);
                    TextView addFilterTextView = BrowseListFragment.this.getBinding().addFilterTextView;
                    Intrinsics.checkNotNullExpressionValue(addFilterTextView, "addFilterTextView");
                    addFilterTextView.setVisibility(8);
                    filtersRecyclerView.setAdapter(null);
                    ImageView collapseImageView = BrowseListFragment.this.getBinding().collapseImageView;
                    Intrinsics.checkNotNullExpressionValue(collapseImageView, "collapseImageView");
                    collapseImageView.setVisibility(0);
                    collapseImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.expand_24));
                    ConstraintLayout filterSummaryLayout = BrowseListFragment.this.getBinding().filterSummaryLayout;
                    Intrinsics.checkNotNullExpressionValue(filterSummaryLayout, "filterSummaryLayout");
                    filterSummaryLayout.setVisibility(0);
                    SearchGroup searchGroup = searchQuery instanceof SearchGroup ? (SearchGroup) searchQuery : null;
                    if (searchGroup != null) {
                        BrowseListFragment browseListFragment2 = BrowseListFragment.this;
                        TextView filterNumberTextView = browseListFragment2.getBinding().filterNumberTextView;
                        Intrinsics.checkNotNullExpressionValue(filterNumberTextView, "filterNumberTextView");
                        filterNumberTextView.setText(String.valueOf(searchGroup.getElements().size()));
                        TextView filterSummaryTextView = browseListFragment2.getBinding().filterSummaryTextView;
                        Intrinsics.checkNotNullExpressionValue(filterSummaryTextView, "filterSummaryTextView");
                        filterSummaryTextView.setText(browseListFragment2.getResources().getString(R.string.filters_selected));
                    }
                } else {
                    ConstraintLayout filterSummaryLayout2 = browseListFragment.getBinding().filterSummaryLayout;
                    Intrinsics.checkNotNullExpressionValue(filterSummaryLayout2, "filterSummaryLayout");
                    filterSummaryLayout2.setVisibility(8);
                    TextView addFilterButton2 = BrowseListFragment.this.getBinding().addFilterButton;
                    Intrinsics.checkNotNullExpressionValue(addFilterButton2, "addFilterButton");
                    addFilterButton2.setVisibility(0);
                    ImageView collapseImageView2 = BrowseListFragment.this.getBinding().collapseImageView;
                    Intrinsics.checkNotNullExpressionValue(collapseImageView2, "collapseImageView");
                    collapseImageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.collapse));
                    SearchGroup searchGroup2 = searchQuery instanceof SearchGroup ? (SearchGroup) searchQuery : null;
                    BrowseListFragment browseListFragment3 = BrowseListFragment.this;
                    if (searchGroup2 == null) {
                        TextView addFilterTextView2 = browseListFragment3.getBinding().addFilterTextView;
                        Intrinsics.checkNotNullExpressionValue(addFilterTextView2, "addFilterTextView");
                        addFilterTextView2.setVisibility(0);
                        filtersRecyclerView.setAdapter(null);
                        ImageView collapseImageView3 = browseListFragment3.getBinding().collapseImageView;
                        Intrinsics.checkNotNullExpressionValue(collapseImageView3, "collapseImageView");
                        collapseImageView3.setVisibility(8);
                    } else if (searchGroup2.getElements().isEmpty()) {
                        TextView addFilterTextView3 = browseListFragment3.getBinding().addFilterTextView;
                        Intrinsics.checkNotNullExpressionValue(addFilterTextView3, "addFilterTextView");
                        addFilterTextView3.setVisibility(0);
                        filtersRecyclerView.setAdapter(null);
                        ImageView collapseImageView4 = browseListFragment3.getBinding().collapseImageView;
                        Intrinsics.checkNotNullExpressionValue(collapseImageView4, "collapseImageView");
                        collapseImageView4.setVisibility(8);
                    } else {
                        filtersRecyclerView.setAdapter(new FilterListAdapter(browseListFragment3.lang, searchGroup2, browseListFragment3));
                        TextView addFilterTextView4 = browseListFragment3.getBinding().addFilterTextView;
                        Intrinsics.checkNotNullExpressionValue(addFilterTextView4, "addFilterTextView");
                        addFilterTextView4.setVisibility(8);
                        if (searchGroup2.getElements().size() > 2) {
                            ImageView collapseImageView5 = browseListFragment3.getBinding().collapseImageView;
                            Intrinsics.checkNotNullExpressionValue(collapseImageView5, "collapseImageView");
                            collapseImageView5.setVisibility(0);
                        } else {
                            ImageView collapseImageView6 = browseListFragment3.getBinding().collapseImageView;
                            Intrinsics.checkNotNullExpressionValue(collapseImageView6, "collapseImageView");
                            collapseImageView6.setVisibility(8);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    public BrowseListFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda39
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BrowseListFragment.allPrintsActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.allPrintsActivityLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda40
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BrowseListFragment.cardActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.cardActivityLauncher = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda41
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BrowseListFragment.scanActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(...)");
        this.scanActivityLauncher = activityResultLauncherRegisterForActivityResult3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object addCardsToContainerSync(int i, int i2, List<MTFullCard> list, Continuation<? super retrofit2.Response<MTCardListResponse>> continuation) {
        String str;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (isOtherUserList()) {
            cancellableContinuationImpl2.resume((Object) null, new Function1<Throwable, Unit>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$addCardsToContainerSync$2$1
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
            List<MTFullCard> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (MTFullCard mTFullCard : list2) {
                String lang = mTFullCard.getLang();
                String name = mTFullCard.getName();
                String collector_number = mTFullCard.getCollector_number();
                String set_code = mTFullCard.getSet_code();
                if (set_code != null) {
                    String lowerCase = set_code.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    str = lowerCase;
                } else {
                    str = null;
                }
                Integer quantity = mTFullCard.getQuantity();
                arrayList.add(new MTFullCard(null, mTFullCard.getAltered(), null, null, null, collector_number, null, null, null, mTFullCard.getCondition(), null, null, null, null, null, null, null, null, null, null, mTFullCard.getFinish(), null, null, null, null, null, null, null, lang, null, null, null, null, null, null, null, mTFullCard.getMissprint(), name, null, null, null, null, null, null, mTFullCard.getPurchase_price(), null, quantity, null, null, str, null, null, mTFullCard.getSigned(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1200177, 127, null));
            }
            List<MTFullCard> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
            for (MTFullCard mTFullCard2 : mutableList) {
                List<String> finishes = mTFullCard2.getFinishes();
                if (finishes == null) {
                    finishes = CollectionsKt.emptyList();
                }
                if (finishes.size() == 1) {
                    String str2 = finishes.get(0);
                    if (Intrinsics.areEqual(str2, "foil") || Intrinsics.areEqual(str2, "etched")) {
                        mTFullCard2.setFinish(str2);
                    }
                }
            }
            MTApiKt.getMtApi().addCardsToList(i, i2, null, null, null, null, null, null, new MTCardListBody(mutableList)).enqueue(new retrofit2.Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$addCardsToContainerSync$2$2
                @Override // retrofit2.Callback
                public void onFailure(retrofit2.Call<MTCardListResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    Log.e("Import", "Add cards error: " + t.getMessage());
                    cancellableContinuationImpl2.resume((retrofit2.Response<MTCardListResponse>) null, new Function1<Throwable, Unit>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$addCardsToContainerSync$2$2$onFailure$1
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
                    cancellableContinuationImpl2.resume(response, new Function1<Throwable, Unit>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$addCardsToContainerSync$2$2$onResponse$1
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
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final void addScannedCardsToList(final List<MTFullCard> scannedCards) {
        if (getActivity() == null || !isAdded()) {
            return;
        }
        if (this.listId == -1) {
            Toast.makeText(requireContext(), getString(R.string.error_adding_card), 0).show();
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser == null) {
            Toast.makeText(requireContext(), getString(R.string.error_adding_card), 0).show();
            return;
        }
        List<MTFullCard> mutableList = CollectionsKt.toMutableList((Collection) scannedCards);
        for (MTFullCard mTFullCard : mutableList) {
            List<String> finishes = mTFullCard.getFinishes();
            if (finishes == null) {
                finishes = CollectionsKt.emptyList();
            }
            if (finishes.size() == 1) {
                String str = finishes.get(0);
                if (Intrinsics.areEqual(str, "foil") || Intrinsics.areEqual(str, "etched")) {
                    mTFullCard.setFinish(str);
                }
            }
        }
        getBinding().overlay.setVisibility(0);
        MTApiKt.getMtApi().addCardsToList(currentUser.getId(), this.listId, this.currentGroupBy, this.currentOrderBy, this.currentOrderDirection, null, null, null, new MTCardListBody(mutableList)).enqueue(new retrofit2.Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment.addScannedCardsToList.1
            @Override // retrofit2.Callback
            public void onFailure(retrofit2.Call<MTCardListResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (BrowseListFragment.this.getActivity() == null || !BrowseListFragment.this.isAdded() || BrowseListFragment.this.getContext() == null || BrowseListFragment.this._binding == null) {
                    return;
                }
                BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                Toast.makeText(BrowseListFragment.this.requireContext(), R.string.error_adding_card, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(retrofit2.Call<MTCardListResponse> call, retrofit2.Response<MTCardListResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (BrowseListFragment.this.getActivity() == null || !BrowseListFragment.this.isAdded()) {
                    return;
                }
                if (response.isSuccessful()) {
                    Context contextRequireContext2 = BrowseListFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                    PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext2);
                    preferencesManager.clearCurrentListScanList(BrowseListFragment.this.listId);
                    MTCardListResponse mTCardListResponseBody = response.body();
                    MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                    if (list != null) {
                        BrowseListFragment browseListFragment = BrowseListFragment.this;
                        List<MTFullCard> list2 = scannedCards;
                        browseListFragment.container = list;
                        preferencesManager.incrementContainerVersion(list.getId());
                        preferencesManager.incrementCollectionVersion();
                        preferencesManager.incrementListsVersion();
                        CardContainerCache.INSTANCE.setCachedContainer(list, new CacheKey(list.getId(), browseListFragment.currentOrderBy, browseListFragment.currentOrderDirection, browseListFragment.currentGroupBy, browseListFragment.currentNameFilter, browseListFragment.currentScryfallFilter, browseListFragment.currentPage));
                        browseListFragment.resetAndRefreshList();
                        Iterator<T> it = list2.iterator();
                        int iIntValue = 0;
                        while (it.hasNext()) {
                            Integer quantity = ((MTFullCard) it.next()).getQuantity();
                            iIntValue += quantity != null ? quantity.intValue() : 1;
                        }
                        Toast.makeText(browseListFragment.requireContext(), browseListFragment.getString(R.string.cards_added_success, Integer.valueOf(iIntValue)), 0).show();
                    }
                } else {
                    Toast.makeText(BrowseListFragment.this.requireContext(), R.string.error_adding_card, 0).show();
                }
                BrowseListFragment.this.getBinding().overlay.setVisibility(8);
            }
        });
    }

    static final void allPrintsActivityLauncher$lambda$0(BrowseListFragment browseListFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Breadcrumbs.INSTANCE.leaveBreadcrumb("launching_all_prints");
        Intent data = result.getData();
        if ((data != null ? data.getStringExtra("newCardId") : null) == null || browseListFragment.getActivity() == null) {
            return;
        }
        Intent data2 = result.getData();
        String stringExtra = data2 != null ? data2.getStringExtra("newCardJson") : null;
        if (stringExtra != null) {
            MTFullCard mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class);
            EditCardDialogFragment editCardDialogFragment = browseListFragment.currentEditDialog;
            if (editCardDialogFragment != null) {
                Intrinsics.checkNotNull(mTFullCard);
                editCardDialogFragment.updatePrint(mTFullCard);
            }
        }
    }

    static final void cardActivityLauncher$lambda$0(final BrowseListFragment browseListFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Context context = browseListFragment.getContext();
        if (context != null) {
            PreferencesManager preferencesManager = new PreferencesManager(context);
            if (preferencesManager.getBoolean(PreferencesManager.CARD_RATING_PROMPT_SHOWN, false)) {
                return;
            }
            preferencesManager.setBoolean(PreferencesManager.CARD_RATING_PROMPT_SHOWN, true);
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("rating_prompt_card_from_list", null);
            final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(context);
            Intrinsics.checkNotNullExpressionValue(reviewManagerCreate, "create(...)");
            reviewManagerCreate.requestReviewFlow().addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    BrowseListFragment.cardActivityLauncher$lambda$0$0$0(this.f$0, reviewManagerCreate, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cardActivityLauncher$lambda$0$0$0(BrowseListFragment browseListFragment, ReviewManager reviewManager, Task it) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(it, "it");
        if (!it.isSuccessful() || (activity = browseListFragment.getActivity()) == null) {
            return;
        }
        reviewManager.launchReviewFlow(activity, (ReviewInfo) it.getResult());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearFiltersAndRefreshList() {
        this.currentNameFilter = null;
        this.currentScryfallFilter = null;
        resetAndRefreshList();
    }

    private final void deleteCardsFromMultipleLists(MTUser currentUser, PreferencesManager prefs) {
        Integer listid;
        if (isOtherUserList()) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<MTFullCard> allCardsFlat = getAllCardsFlat();
        for (Map.Entry<Integer, Integer> entry : this.selectedCards.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            MTFullCard mTFullCard = (MTFullCard) CollectionsKt.getOrNull(allCardsFlat, iIntValue);
            if (mTFullCard != null && (listid = mTFullCard.getListid()) != null) {
                int iIntValue3 = listid.intValue();
                if (!linkedHashMap.containsKey(Integer.valueOf(iIntValue3))) {
                    linkedHashMap.put(Integer.valueOf(iIntValue3), new ArrayList());
                }
                for (int i = 0; i < iIntValue2; i++) {
                    List<Integer> list_card_ids = mTFullCard.getList_card_ids();
                    MTCardReference mTCardReference = new MTCardReference(list_card_ids != null ? list_card_ids.get(i).intValue() : 0);
                    List list = (List) linkedHashMap.get(Integer.valueOf(iIntValue3));
                    if (list != null) {
                        list.add(mTCardReference);
                    }
                }
            }
        }
        if (!linkedHashMap.isEmpty()) {
            deleteCardsFromMultipleLists$processNextList(new Ref.IntRef(), CollectionsKt.toList(linkedHashMap.keySet()), this, new Ref.BooleanRef(), prefs, linkedHashMap, currentUser);
        } else {
            getBinding().overlay.setVisibility(8);
            Toast.makeText(requireContext(), R.string.error_deleting_card, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteCardsFromMultipleLists$processNextList(final Ref.IntRef intRef, final List<Integer> list, final BrowseListFragment browseListFragment, final Ref.BooleanRef booleanRef, final PreferencesManager preferencesManager, final Map<Integer, List<MTCardReference>> map, final MTUser mTUser) {
        if (intRef.element >= list.size()) {
            browseListFragment.getBinding().overlay.setVisibility(8);
            if (booleanRef.element) {
                Toast.makeText(browseListFragment.requireContext(), R.string.error_deleting_card, 0).show();
                return;
            }
            browseListFragment.exitSelectionMode();
            preferencesManager.incrementCollectionVersion();
            preferencesManager.incrementListsVersion();
            browseListFragment.refreshListMaintainingPosition();
            return;
        }
        final int iIntValue = list.get(intRef.element).intValue();
        ArrayList arrayList = map.get(Integer.valueOf(iIntValue));
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        MTEditCardBody mTEditCardBody = new MTEditCardBody(null, 1, null);
        mTEditCardBody.setCards(new MTEditCardActions(null, null, null, 7, null));
        MTEditCardActions cards = mTEditCardBody.getCards();
        if (cards != null) {
            cards.setDeleted(arrayList);
        }
        MTApiKt.getMtApi().editCardsFromList(mTUser.getId(), iIntValue, browseListFragment.currentNameFilter, browseListFragment.currentScryfallFilter, null, browseListFragment.currentOrderBy, browseListFragment.currentOrderDirection, false, null, null, null, mTEditCardBody).enqueue(new retrofit2.Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$deleteCardsFromMultipleLists$processNextList$1
            @Override // retrofit2.Callback
            public void onFailure(retrofit2.Call<MTCardListResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (this.this$0.getContext() == null || this.this$0._binding == null) {
                    return;
                }
                Log.e("BrowseListFragment", "Failed to delete cards from list " + iIntValue + ": " + t.getMessage());
                booleanRef.element = true;
                intRef.element++;
                BrowseListFragment.deleteCardsFromMultipleLists$processNextList(intRef, list, this.this$0, booleanRef, preferencesManager, map, mTUser);
            }

            @Override // retrofit2.Callback
            public void onResponse(retrofit2.Call<MTCardListResponse> call, retrofit2.Response<MTCardListResponse> response) {
                MTCardContainer list2;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (this.this$0.getActivity() == null || this.this$0.getContext() == null) {
                    return;
                }
                if (response.isSuccessful()) {
                    MTCardListResponse mTCardListResponseBody = response.body();
                    if (mTCardListResponseBody != null && (list2 = mTCardListResponseBody.getList()) != null) {
                        preferencesManager.incrementContainerVersion(list2.getId());
                        CardContainerCache.INSTANCE.setCachedContainer(list2, list2.getId());
                    }
                } else {
                    booleanRef.element = true;
                }
                intRef.element++;
                BrowseListFragment.deleteCardsFromMultipleLists$processNextList(intRef, list, this.this$0, booleanRef, preferencesManager, map, mTUser);
            }
        });
    }

    private final void deleteCardsFromSingleList(MTUser currentUser, final PreferencesManager prefs) {
        if (isOtherUserList()) {
            return;
        }
        MTEditCardBody mTEditCardBody = new MTEditCardBody(null, 1, null);
        mTEditCardBody.setCards(new MTEditCardActions(null, null, null, 7, null));
        ArrayList arrayList = new ArrayList();
        List<MTFullCard> allCardsFlat = getAllCardsFlat();
        for (Map.Entry<Integer, Integer> entry : this.selectedCards.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            MTFullCard mTFullCard = (MTFullCard) CollectionsKt.getOrNull(allCardsFlat, iIntValue);
            if (mTFullCard != null) {
                for (int i = 0; i < iIntValue2; i++) {
                    List<Integer> list_card_ids = mTFullCard.getList_card_ids();
                    arrayList.add(new MTCardReference(list_card_ids != null ? list_card_ids.get(i).intValue() : 0));
                }
            }
        }
        MTEditCardActions cards = mTEditCardBody.getCards();
        if (cards != null) {
            cards.setDeleted(arrayList);
        }
        MTApiKt.getMtApi().editCardsFromList(currentUser.getId(), this.listId, this.currentNameFilter, this.currentScryfallFilter, this.currentGroupBy, this.currentOrderBy, this.currentOrderDirection, false, null, null, null, mTEditCardBody).enqueue(new retrofit2.Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment.deleteCardsFromSingleList.2
            @Override // retrofit2.Callback
            public void onFailure(retrofit2.Call<MTCardListResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (BrowseListFragment.this.getContext() == null || BrowseListFragment.this._binding == null) {
                    return;
                }
                Log.e("BrowseListFragment", "Failed to delete cards: " + t.getMessage());
                BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                Toast.makeText(BrowseListFragment.this.requireContext(), R.string.error_deleting_card, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(retrofit2.Call<MTCardListResponse> call, retrofit2.Response<MTCardListResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                BrowseListFragment.this.handleSingleListDeleteResponse(response, prefs);
            }
        });
    }

    private final void displayContainerFromCache(MTCardContainer list, PreferencesManager prefs) {
        if (this._binding == null || getContext() == null) {
            return;
        }
        String name = list.getName();
        if (list.getId() == 4) {
            name = getString(R.string.list_bulk);
            Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
        }
        if (list.getId() == 1) {
            name = getString(R.string.list_recent_cards);
            Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
        }
        if (list.getId() == 2) {
            name = getString(R.string.list_wants);
            Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
        }
        if (list.getId() == 3) {
            name = getString(R.string.list_trade);
            Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
        }
        updateTitleWithPrice(name, list);
        this.container = list;
        updatePrivacyToolbar(list.getPrivacy());
        Integer count = list.getCount();
        int iIntValue = count != null ? count.intValue() : 0;
        this.totalCards = iIntValue;
        this.hasMorePages = this.cardsPerPage < iIntValue;
        if (this.currentGroupBy == null || list.getGrouped_cards() == null) {
            List<MTFullCard> cards = list.getCards();
            if (cards != null) {
                this.currentCards.clear();
                this.currentCards.addAll(cards);
                this.currentGroupedCards.clear();
                if (getBinding().cardsRecyclerView.getAdapter() == null) {
                    setupRecyclerViewForCurrentLayout(this.selectionMode);
                } else {
                    List<BrowseListCardItem> browseListCardItemsFromCards = BrowseListCardItemKt.toBrowseListCardItemsFromCards(this.currentCards);
                    RecyclerView.Adapter adapter = getBinding().cardsRecyclerView.getAdapter();
                    if (adapter instanceof MTFullCardsAdapter) {
                        ((MTFullCardsAdapter) adapter).updateItems(browseListCardItemsFromCards);
                    } else if (adapter instanceof MTFullCardListAdapter) {
                        ((MTFullCardListAdapter) adapter).updateItems(browseListCardItemsFromCards);
                    }
                }
            }
        } else {
            this.currentGroupedCards.clear();
            List<MTCardGroup> grouped_cards = list.getGrouped_cards();
            if (grouped_cards != null) {
                this.currentGroupedCards.addAll(grouped_cards);
            }
            this.currentCards.clear();
            if (getBinding().cardsRecyclerView.getAdapter() == null) {
                setupRecyclerViewForCurrentLayout(this.selectionMode);
            } else {
                List<BrowseListCardItem> browseListCardItemsFromGroups = BrowseListCardItemKt.toBrowseListCardItemsFromGroups(this.currentGroupedCards);
                RecyclerView.Adapter adapter2 = getBinding().cardsRecyclerView.getAdapter();
                if (adapter2 instanceof MTFullCardsAdapter) {
                    ((MTFullCardsAdapter) adapter2).updateItems(browseListCardItemsFromGroups);
                } else if (adapter2 instanceof MTFullCardListAdapter) {
                    ((MTFullCardListAdapter) adapter2).updateItems(browseListCardItemsFromGroups);
                }
            }
        }
        updateCardCount();
        getBinding().overlay.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadAndParseCsvForTxt(String url) {
        new OkHttpClient().newCall(new Request.Builder().url(url).build()).enqueue(new C11121());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadAndShareFile(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request requestBuild = new Request.Builder().url(url).build();
        getBinding().overlay.setVisibility(0);
        okHttpClient.newCall(requestBuild).enqueue(new C11131());
    }

    private final void editContainer() {
        final MTCardContainer mTCardContainer;
        if (isOtherUserList() || getContext() == null || (mTCardContainer = this.container) == null) {
            return;
        }
        exitSelectionMode();
        new EditContainerDialogFragment.Builder().setContainer(mTCardContainer).setOnEditClickedListener(new Function2() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BrowseListFragment.editContainer$lambda$0$0(this.f$0, mTCardContainer, (MTEditListBody) obj, ((Boolean) obj2).booleanValue());
            }
        }).build().show(getChildFragmentManager(), "edit_container_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit editContainer$lambda$0$0(BrowseListFragment browseListFragment, MTCardContainer mTCardContainer, MTEditListBody editBody, boolean z) {
        Intrinsics.checkNotNullParameter(editBody, "editBody");
        if (browseListFragment.getContext() == null || browseListFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = browseListFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout overlay = browseListFragment.getBinding().overlay;
            Intrinsics.checkNotNullExpressionValue(overlay, "overlay");
            overlay.setVisibility(0);
            (editBody.getIncludeNullColor() ? MTApiKt.getMtApi().updateList(currentUser.getId(), mTCardContainer.getId(), MTApiKt.toRequestBody(editBody)) : MTApiKt.getMtApi().updateList(currentUser.getId(), mTCardContainer.getId(), editBody)).enqueue(new BrowseListFragment$editContainer$1$dialog$1$1$1(browseListFragment, overlay));
        }
        return Unit.INSTANCE;
    }

    private final void enterSelectionMode() {
        this.selectionMode = true;
        getBinding().selectionLayout.setVisibility(0);
        updateSelectionCountText();
        RecyclerView.Adapter adapter = getBinding().cardsRecyclerView.getAdapter();
        MTFullCardsAdapter mTFullCardsAdapter = adapter instanceof MTFullCardsAdapter ? (MTFullCardsAdapter) adapter : null;
        if (mTFullCardsAdapter != null) {
            mTFullCardsAdapter.setSelectionMode(true);
        }
        RecyclerView.Adapter adapter2 = getBinding().cardsRecyclerView.getAdapter();
        MTFullCardListAdapter mTFullCardListAdapter = adapter2 instanceof MTFullCardListAdapter ? (MTFullCardListAdapter) adapter2 : null;
        if (mTFullCardListAdapter != null) {
            mTFullCardListAdapter.setSelectionMode(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void exitSelectionMode() {
        this.selectionMode = false;
        this.selectedCards.clear();
        getBinding().selectionLayout.setVisibility(8);
        RecyclerView.Adapter adapter = getBinding().cardsRecyclerView.getAdapter();
        MTFullCardsAdapter mTFullCardsAdapter = adapter instanceof MTFullCardsAdapter ? (MTFullCardsAdapter) adapter : null;
        if (mTFullCardsAdapter != null) {
            mTFullCardsAdapter.setSelectionMode(false);
        }
        RecyclerView.Adapter adapter2 = getBinding().cardsRecyclerView.getAdapter();
        MTFullCardListAdapter mTFullCardListAdapter = adapter2 instanceof MTFullCardListAdapter ? (MTFullCardListAdapter) adapter2 : null;
        if (mTFullCardListAdapter != null) {
            mTFullCardListAdapter.setSelectionMode(false);
        }
    }

    private final void exportList() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser == null) {
            return;
        }
        if (this.listId == -1) {
            retrofit2.Call<MTDBResponse> callExportCollection = MTApiKt.getMtApi().exportCollection(currentUser.getId());
            getBinding().overlay.setVisibility(0);
            callExportCollection.enqueue(new retrofit2.Callback<MTDBResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment.exportList.1
                @Override // retrofit2.Callback
                public void onFailure(retrofit2.Call<MTDBResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (BrowseListFragment.this.getContext() == null || BrowseListFragment.this._binding == null) {
                        return;
                    }
                    FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(BrowseListFragment.this.requireContext());
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                    firebaseAnalytics.logEvent("collection_export_failure", null);
                    BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                    Toast.makeText(BrowseListFragment.this.requireContext(), R.string.export_collection_error, 1).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(retrofit2.Call<MTDBResponse> call, retrofit2.Response<MTDBResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (BrowseListFragment.this.getContext() == null || BrowseListFragment.this._binding == null) {
                        return;
                    }
                    if (!response.isSuccessful()) {
                        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(BrowseListFragment.this.requireContext());
                        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                        firebaseAnalytics.logEvent("collection_export_error", null);
                        BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                        Toast.makeText(BrowseListFragment.this.requireContext(), R.string.export_collection_error, 1).show();
                        return;
                    }
                    MTDBResponse mTDBResponseBody = response.body();
                    String url = mTDBResponseBody != null ? mTDBResponseBody.getUrl() : null;
                    String str = url;
                    if (str != null && str.length() != 0) {
                        FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(BrowseListFragment.this.requireContext());
                        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
                        firebaseAnalytics2.logEvent("collection_export_ok", null);
                        BrowseListFragment.this.downloadAndShareFile(url);
                        return;
                    }
                    FirebaseAnalytics firebaseAnalytics3 = FirebaseAnalytics.getInstance(BrowseListFragment.this.requireContext());
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics3, "getInstance(...)");
                    firebaseAnalytics3.logEvent("collection_export_error", null);
                    BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                    Toast.makeText(BrowseListFragment.this.requireContext(), R.string.export_collection_error, 1).show();
                }
            });
        } else {
            retrofit2.Call<MTDBResponse> callExportList = MTApiKt.getMtApi().exportList(currentUser.getId(), this.listId);
            getBinding().overlay.setVisibility(0);
            callExportList.enqueue(new retrofit2.Callback<MTDBResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment.exportList.2
                @Override // retrofit2.Callback
                public void onFailure(retrofit2.Call<MTDBResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (BrowseListFragment.this.getContext() == null || BrowseListFragment.this._binding == null) {
                        return;
                    }
                    BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                    Toast.makeText(BrowseListFragment.this.requireContext(), R.string.export_list_error, 1).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(retrofit2.Call<MTDBResponse> call, retrofit2.Response<MTDBResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (BrowseListFragment.this.getContext() == null || BrowseListFragment.this._binding == null) {
                        return;
                    }
                    if (!response.isSuccessful()) {
                        BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                        Toast.makeText(BrowseListFragment.this.requireContext(), R.string.export_list_error, 1).show();
                        return;
                    }
                    MTDBResponse mTDBResponseBody = response.body();
                    String url = mTDBResponseBody != null ? mTDBResponseBody.getUrl() : null;
                    String str = url;
                    if (str != null && str.length() != 0) {
                        BrowseListFragment.this.downloadAndShareFile(url);
                    } else {
                        BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                        Toast.makeText(BrowseListFragment.this.requireContext(), R.string.export_list_error, 1).show();
                    }
                }
            });
        }
    }

    private final void exportListAsTxt() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser == null) {
            return;
        }
        if (this.listId == -1) {
            retrofit2.Call<MTDBResponse> callExportCollection = MTApiKt.getMtApi().exportCollection(currentUser.getId());
            getBinding().overlay.setVisibility(0);
            callExportCollection.enqueue(new retrofit2.Callback<MTDBResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment.exportListAsTxt.1
                @Override // retrofit2.Callback
                public void onFailure(retrofit2.Call<MTDBResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (BrowseListFragment.this.getContext() == null || BrowseListFragment.this._binding == null) {
                        return;
                    }
                    BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                    Toast.makeText(BrowseListFragment.this.requireContext(), R.string.export_collection_error, 1).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(retrofit2.Call<MTDBResponse> call, retrofit2.Response<MTDBResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (BrowseListFragment.this.getContext() == null || BrowseListFragment.this._binding == null) {
                        return;
                    }
                    if (!response.isSuccessful()) {
                        BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                        Toast.makeText(BrowseListFragment.this.requireContext(), R.string.export_collection_error, 1).show();
                        return;
                    }
                    MTDBResponse mTDBResponseBody = response.body();
                    String url = mTDBResponseBody != null ? mTDBResponseBody.getUrl() : null;
                    String str = url;
                    if (str != null && str.length() != 0) {
                        BrowseListFragment.this.downloadAndParseCsvForTxt(url);
                    } else {
                        BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                        Toast.makeText(BrowseListFragment.this.requireContext(), R.string.export_collection_error, 1).show();
                    }
                }
            });
        } else {
            retrofit2.Call<MTDBResponse> callExportList = MTApiKt.getMtApi().exportList(currentUser.getId(), this.listId);
            getBinding().overlay.setVisibility(0);
            callExportList.enqueue(new retrofit2.Callback<MTDBResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment.exportListAsTxt.2
                @Override // retrofit2.Callback
                public void onFailure(retrofit2.Call<MTDBResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (BrowseListFragment.this.getContext() == null || BrowseListFragment.this._binding == null) {
                        return;
                    }
                    BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                    Toast.makeText(BrowseListFragment.this.requireContext(), R.string.export_list_error, 1).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(retrofit2.Call<MTDBResponse> call, retrofit2.Response<MTDBResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (BrowseListFragment.this.getContext() == null || BrowseListFragment.this._binding == null) {
                        return;
                    }
                    if (!response.isSuccessful()) {
                        BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                        Toast.makeText(BrowseListFragment.this.requireContext(), R.string.export_list_error, 1).show();
                        return;
                    }
                    MTDBResponse mTDBResponseBody = response.body();
                    String url = mTDBResponseBody != null ? mTDBResponseBody.getUrl() : null;
                    String str = url;
                    if (str != null && str.length() != 0) {
                        BrowseListFragment.this.downloadAndParseCsvForTxt(url);
                    } else {
                        BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                        Toast.makeText(BrowseListFragment.this.requireContext(), R.string.export_list_error, 1).show();
                    }
                }
            });
        }
    }

    private final List<MTFullCard> getAllCardsFlat() {
        if (this.currentGroupBy == null || this.currentGroupedCards.isEmpty()) {
            return this.currentCards;
        }
        List<MTCardGroup> list = this.currentGroupedCards;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List<MTFullCard> cards = ((MTCardGroup) it.next()).getCards();
            if (cards == null) {
                cards = CollectionsKt.emptyList();
            }
            CollectionsKt.addAll(arrayList, cards);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentBrowseListBinding getBinding() {
        FragmentBrowseListBinding fragmentBrowseListBinding = this._binding;
        Intrinsics.checkNotNull(fragmentBrowseListBinding);
        return fragmentBrowseListBinding;
    }

    private final void handleImportResult(MTGCsvImporter.ImportResult result) {
        ArrayList arrayListEmptyList;
        String lowerCase;
        List<MTCardContainer> containers = result.getContainers();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = containers.iterator();
        while (it.hasNext()) {
            List<MTFullCard> cards = ((MTCardContainer) it.next()).getCards();
            if (cards != null) {
                List<MTFullCard> list = cards;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (MTFullCard mTFullCard : list) {
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
                    arrayList2.add(new MTFullCard(null, mTFullCard.getAltered(), null, null, null, collector_number, null, null, null, mTFullCard.getCondition(), null, null, null, null, null, null, null, null, null, null, mTFullCard.getFinish(), null, null, null, null, null, null, null, lang, null, null, null, null, null, null, null, mTFullCard.getMissprint(), name, null, null, null, null, null, null, null, null, quantity, null, null, lowerCase, null, null, mTFullCard.getSigned(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1196081, 127, null));
                }
                arrayListEmptyList = arrayList2;
            } else {
                arrayListEmptyList = CollectionsKt.emptyList();
            }
            CollectionsKt.addAll(arrayList, arrayListEmptyList);
        }
        final List<MTFullCard> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        int iIntValue = 0;
        if (mutableList.isEmpty()) {
            Toast.makeText(requireContext(), getString(R.string.no_valid_cards_found), 0).show();
            return;
        }
        if (result.getErrors().isEmpty()) {
            showContainerImportConfirmation(mutableList);
            return;
        }
        Iterator<T> it2 = mutableList.iterator();
        while (it2.hasNext()) {
            Integer quantity2 = ((MTFullCard) it2.next()).getQuantity();
            iIntValue += quantity2 != null ? quantity2.intValue() : 1;
        }
        String string = getString(R.string.import_partial, Integer.valueOf(iIntValue), Integer.valueOf(result.getErrors().size()));
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
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BrowseListFragment.handleImportResult$lambda$3(this.f$0, mutableList, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BrowseListFragment.handleImportResult$lambda$4(this.f$0, (CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "import_warning_dialog");
    }

    static final Unit handleImportResult$lambda$3(BrowseListFragment browseListFragment, List list, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        browseListFragment.showContainerImportConfirmation(list);
        return Unit.INSTANCE;
    }

    static final Unit handleImportResult$lambda$4(BrowseListFragment browseListFragment, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        Toast.makeText(browseListFragment.requireContext(), browseListFragment.getString(R.string.import_canceled), 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSingleListDeleteResponse(retrofit2.Response<MTCardListResponse> response, PreferencesManager prefs) {
        if (getActivity() == null || getContext() == null) {
            return;
        }
        if (!response.isSuccessful()) {
            getBinding().overlay.setVisibility(8);
            Toast.makeText(requireContext(), R.string.error_deleting_card, 0).show();
            return;
        }
        exitSelectionMode();
        MTCardListResponse mTCardListResponseBody = response.body();
        MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
        if (list != null) {
            if (this.listId != -1) {
                this.container = list;
            }
            prefs.incrementContainerVersion(list.getId());
            prefs.incrementCollectionVersion();
            prefs.incrementListsVersion();
            CardContainerCache.INSTANCE.setCachedContainer(list, list.getId());
            refreshListMaintainingPosition();
        }
        getBinding().overlay.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSingleListMoveResponse(retrofit2.Response<MTMoveCardsResponse> response, PreferencesManager prefs) {
        MTMoveCardsResponse mTMoveCardsResponseBody;
        getBinding().overlay.setVisibility(8);
        if (!response.isSuccessful() || (mTMoveCardsResponseBody = response.body()) == null || !mTMoveCardsResponseBody.getSuccess()) {
            Toast.makeText(requireContext(), R.string.error_moving_card, 0).show();
            return;
        }
        prefs.incrementCollectionVersion();
        prefs.incrementListsVersion();
        MTCardContainer target = mTMoveCardsResponseBody.getTarget();
        if (target != null) {
            prefs.incrementContainerVersion(target.getId());
            CardContainerCache.INSTANCE.setCachedContainer(target, target.getId());
            if (target.getId() == PreferencesManager.INSTANCE.getRecentCardListId()) {
                List<MTFullCard> cards = target.getCards();
                if (cards == null) {
                    cards = CollectionsKt.emptyList();
                }
                prefs.setRecentCardsNew(cards);
            }
        }
        MTCardContainer source = mTMoveCardsResponseBody.getSource();
        if (source != null) {
            prefs.incrementContainerVersion(source.getId());
            CardContainerCache.INSTANCE.setCachedContainer(source, new CacheKey(source.getId(), this.currentOrderBy, this.currentOrderDirection, this.currentGroupBy, this.currentNameFilter, this.currentScryfallFilter, this.currentPage));
            if (source.getId() == PreferencesManager.INSTANCE.getRecentCardListId()) {
                List<MTFullCard> cards2 = source.getCards();
                if (cards2 == null) {
                    cards2 = CollectionsKt.emptyList();
                }
                prefs.setRecentCardsNew(cards2);
            }
            exitSelectionMode();
            if (this.listId != -1) {
                this.container = source;
            }
            refreshListMaintainingPosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideAddButton() {
        getBinding().addButtonLayout.animate().cancel();
        getBinding().scanButtonLayout.animate().cancel();
        getBinding().addButtonLayout.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda47
            @Override // java.lang.Runnable
            public final void run() {
                BrowseListFragment.hideAddButton$lambda$0(this.f$0);
            }
        }).start();
        getBinding().scanButtonLayout.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda48
            @Override // java.lang.Runnable
            public final void run() {
                BrowseListFragment.hideAddButton$lambda$1(this.f$0);
            }
        }).start();
    }

    static final void hideAddButton$lambda$0(BrowseListFragment browseListFragment) {
        browseListFragment.getBinding().addButtonLayout.setClickable(false);
        browseListFragment.getBinding().addButtonLayout.setFocusable(false);
    }

    static final void hideAddButton$lambda$1(BrowseListFragment browseListFragment) {
        browseListFragment.getBinding().scanButtonLayout.setClickable(false);
        browseListFragment.getBinding().scanButtonLayout.setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isOtherUserList() {
        return this.otherUserId > 0;
    }

    private final boolean isSmallCards() {
        return this.currentLayout == CardsLayout.GRID_BY_3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadListData(final int page) {
        if (getActivity() == null || getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null) {
            return;
        }
        if (page == 1 && this.listId != -1 && !this.forceRefresh && !isOtherUserList()) {
            CachedContainer ifValid$default = CardContainerCache.getIfValid$default(CardContainerCache.INSTANCE, new CacheKey(this.listId, this.currentOrderBy, this.currentOrderDirection, this.currentGroupBy, this.currentNameFilter, this.currentScryfallFilter, 1), 0L, 2, null);
            if (ifValid$default != null) {
                displayContainerFromCache(ifValid$default.getContainer(), preferencesManager);
                return;
            }
        }
        this.isLoading = true;
        boolean zIsRefreshing = getBinding().swipeRefreshLayout.isRefreshing();
        if (page == 1 && !zIsRefreshing) {
            getBinding().overlay.setVisibility(0);
        } else if (page > 1) {
            showLoadingFooter(true);
        }
        String string = (Intrinsics.areEqual(this.currentOrderBy, FirebaseAnalytics.Param.PRICE) || Intrinsics.areEqual(this.currentOrderBy, "total_price")) ? preferencesManager.getPreferredCurrency().toString() : null;
        if (this.listId != -1) {
            (isOtherUserList() ? MTApi.getUserListById$default(MTApiKt.getMtApi(), currentUser.getId(), this.otherUserId, this.listId, this.currentNameFilter, this.currentScryfallFilter, Integer.valueOf(page), Integer.valueOf(this.cardsPerPage), this.currentOrderBy, this.currentGroupBy, this.currentOrderDirection, string, null, null, null, 14336, null) : MTApi.getUserList$default(MTApiKt.getMtApi(), currentUser.getId(), this.listId, this.currentNameFilter, this.currentScryfallFilter, Integer.valueOf(page), Integer.valueOf(this.cardsPerPage), this.currentOrderBy, this.currentGroupBy, this.currentOrderDirection, string, null, null, null, 7168, null)).enqueue(new retrofit2.Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment.loadListData.2
                @Override // retrofit2.Callback
                public void onFailure(retrofit2.Call<MTCardListResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (BrowseListFragment.this._binding == null || BrowseListFragment.this.getContext() == null) {
                        return;
                    }
                    BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                    BrowseListFragment.this.getBinding().swipeRefreshLayout.setRefreshing(false);
                    BrowseListFragment.this.forceRefresh = false;
                    BrowseListFragment.this.showLoadingFooter(false);
                    BrowseListFragment.this.isLoading = false;
                    Log.e("BrowseListFragment", "Error fetching list: " + t.getMessage());
                    Toast.makeText(BrowseListFragment.this.requireContext(), BrowseListFragment.this.isOtherUserList() ? R.string.error_list_access_denied : R.string.error_loading_list, 0).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(retrofit2.Call<MTCardListResponse> call, retrofit2.Response<MTCardListResponse> response) {
                    String string2;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (BrowseListFragment.this._binding == null || BrowseListFragment.this.getContext() == null) {
                        return;
                    }
                    BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                    BrowseListFragment.this.getBinding().swipeRefreshLayout.setRefreshing(false);
                    BrowseListFragment.this.forceRefresh = false;
                    BrowseListFragment.this.showLoadingFooter(false);
                    BrowseListFragment.this.isLoading = false;
                    MTPrivacyUser user = null;
                    if (!response.isSuccessful()) {
                        ResponseBody responseBodyErrorBody = response.errorBody();
                        Log.e("BrowseListFragment", "Error fetching list: " + (responseBodyErrorBody != null ? responseBodyErrorBody.string() : null));
                        Toast.makeText(BrowseListFragment.this.requireContext(), BrowseListFragment.this.isOtherUserList() ? R.string.error_list_access_denied : R.string.error_loading_list, 0).show();
                        return;
                    }
                    MTCardListResponse mTCardListResponseBody = response.body();
                    if (mTCardListResponseBody != null) {
                        BrowseListFragment browseListFragment = BrowseListFragment.this;
                        int i = page;
                        MTCardContainer list = mTCardListResponseBody.getList();
                        if (list == null || (string2 = list.getName()) == null) {
                            string2 = "";
                        }
                        MTCardContainer list2 = mTCardListResponseBody.getList();
                        if (list2 != null && list2.getId() == 4) {
                            string2 = browseListFragment.getString(R.string.list_bulk);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        }
                        MTCardContainer list3 = mTCardListResponseBody.getList();
                        if (list3 != null && list3.getId() == 1) {
                            string2 = browseListFragment.getString(R.string.list_recent_cards);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        }
                        MTCardContainer list4 = mTCardListResponseBody.getList();
                        if (list4 != null && list4.getId() == 2) {
                            string2 = browseListFragment.getString(R.string.list_wants);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        }
                        MTCardContainer list5 = mTCardListResponseBody.getList();
                        if (list5 != null && list5.getId() == 3) {
                            string2 = browseListFragment.getString(R.string.list_trade);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        }
                        browseListFragment.updateTitleWithPrice(string2, mTCardListResponseBody.getList());
                        MTContainerPrivacy privacy = mTCardListResponseBody.getPrivacy();
                        if (privacy == null) {
                            MTCardContainer list6 = mTCardListResponseBody.getList();
                            privacy = list6 != null ? list6.getPrivacy() : null;
                        }
                        browseListFragment.updatePrivacyToolbar(privacy);
                        if (browseListFragment.isOtherUserList()) {
                            MTPrivacyUser user2 = mTCardListResponseBody.getUser();
                            if (user2 == null) {
                                MTCardContainer list7 = mTCardListResponseBody.getList();
                                if (list7 != null) {
                                    user = list7.getUser();
                                }
                            } else {
                                user = user2;
                            }
                            browseListFragment.updateOtherUserInfo(user);
                        }
                        MTCardContainer list8 = mTCardListResponseBody.getList();
                        if (list8 != null) {
                            MTCardContainer mTCardContainerCopy$default = mTCardListResponseBody.getPrivacy() != null ? MTCardContainer.copy$default(list8, null, null, null, 0, null, null, null, null, null, null, null, null, null, mTCardListResponseBody.getPrivacy(), null, null, 57343, null) : list8;
                            browseListFragment.container = mTCardContainerCopy$default;
                            if (!browseListFragment.isOtherUserList()) {
                                CardContainerCache.INSTANCE.setCachedContainer(mTCardContainerCopy$default, new CacheKey(mTCardContainerCopy$default.getId(), browseListFragment.currentOrderBy, browseListFragment.currentOrderDirection, browseListFragment.currentGroupBy, browseListFragment.currentNameFilter, browseListFragment.currentScryfallFilter, i));
                            }
                            Integer count = list8.getCount();
                            browseListFragment.totalCards = count != null ? count.intValue() : 0;
                            browseListFragment.hasMorePages = browseListFragment.cardsPerPage * i < browseListFragment.totalCards;
                            if (browseListFragment.currentGroupBy != null && list8.getGrouped_cards() != null) {
                                List<MTCardGroup> grouped_cards = list8.getGrouped_cards();
                                if (i == 1) {
                                    browseListFragment.currentGroupedCards.clear();
                                    if (grouped_cards != null) {
                                        browseListFragment.currentGroupedCards.addAll(grouped_cards);
                                    }
                                    browseListFragment.currentCards.clear();
                                    if (browseListFragment.getBinding().cardsRecyclerView.getAdapter() == null) {
                                        browseListFragment.setupRecyclerViewForCurrentLayout(browseListFragment.selectionMode);
                                    } else {
                                        List<BrowseListCardItem> browseListCardItemsFromGroups = BrowseListCardItemKt.toBrowseListCardItemsFromGroups(browseListFragment.currentGroupedCards);
                                        RecyclerView.Adapter adapter = browseListFragment.getBinding().cardsRecyclerView.getAdapter();
                                        if (adapter instanceof MTFullCardsAdapter) {
                                            ((MTFullCardsAdapter) adapter).updateItems(browseListCardItemsFromGroups);
                                        } else if (adapter instanceof MTFullCardListAdapter) {
                                            ((MTFullCardListAdapter) adapter).updateItems(browseListCardItemsFromGroups);
                                        }
                                    }
                                } else if (grouped_cards != null) {
                                    browseListFragment.mergeGroupedCards(grouped_cards);
                                }
                                browseListFragment.updateCardCount();
                                return;
                            }
                            List<MTFullCard> cards = list8.getCards();
                            if (cards != null) {
                                if (i == 1) {
                                    browseListFragment.currentCards.clear();
                                    browseListFragment.currentCards.addAll(cards);
                                    browseListFragment.currentGroupedCards.clear();
                                    if (browseListFragment.getBinding().cardsRecyclerView.getAdapter() == null) {
                                        browseListFragment.setupRecyclerViewForCurrentLayout(browseListFragment.selectionMode);
                                    } else {
                                        List<BrowseListCardItem> browseListCardItemsFromCards = BrowseListCardItemKt.toBrowseListCardItemsFromCards(browseListFragment.currentCards);
                                        RecyclerView.Adapter adapter2 = browseListFragment.getBinding().cardsRecyclerView.getAdapter();
                                        if (adapter2 instanceof MTFullCardsAdapter) {
                                            ((MTFullCardsAdapter) adapter2).updateItems(browseListCardItemsFromCards);
                                        } else if (adapter2 instanceof MTFullCardListAdapter) {
                                            ((MTFullCardListAdapter) adapter2).updateItems(browseListCardItemsFromCards);
                                        }
                                    }
                                } else {
                                    browseListFragment.currentCards.addAll(cards);
                                    List<BrowseListCardItem> browseListCardItemsFromCards2 = BrowseListCardItemKt.toBrowseListCardItemsFromCards(browseListFragment.currentCards);
                                    RecyclerView.Adapter adapter3 = browseListFragment.getBinding().cardsRecyclerView.getAdapter();
                                    if (adapter3 instanceof MTFullCardsAdapter) {
                                        ((MTFullCardsAdapter) adapter3).updateItems(browseListCardItemsFromCards2);
                                    } else if (adapter3 instanceof MTFullCardListAdapter) {
                                        ((MTFullCardListAdapter) adapter3).updateItems(browseListCardItemsFromCards2);
                                    }
                                }
                                browseListFragment.updateCardCount();
                            }
                        }
                    }
                }
            });
        } else {
            updatePrivacyToolbar(null);
            MTApi.getAllCollectionCards$default(MTApiKt.getMtApi(), currentUser.getId(), this.currentNameFilter, this.currentScryfallFilter, Integer.valueOf(page), Integer.valueOf(this.cardsPerPage), this.currentGroupBy, this.currentOrderBy, this.currentOrderDirection, null, string, 256, null).enqueue(new retrofit2.Callback<MTCardsResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment.loadListData.1
                @Override // retrofit2.Callback
                public void onFailure(retrofit2.Call<MTCardsResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (BrowseListFragment.this._binding == null || BrowseListFragment.this.getContext() == null) {
                        return;
                    }
                    BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                    BrowseListFragment.this.getBinding().swipeRefreshLayout.setRefreshing(false);
                    BrowseListFragment.this.forceRefresh = false;
                    BrowseListFragment.this.showLoadingFooter(false);
                    BrowseListFragment.this.isLoading = false;
                    Log.e("BrowseListFragment", "Error fetching list: " + t.getMessage());
                    Toast.makeText(BrowseListFragment.this.requireContext(), R.string.error_loading_list, 0).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(retrofit2.Call<MTCardsResponse> call, retrofit2.Response<MTCardsResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (BrowseListFragment.this._binding == null || BrowseListFragment.this.getContext() == null) {
                        return;
                    }
                    BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                    BrowseListFragment.this.getBinding().swipeRefreshLayout.setRefreshing(false);
                    BrowseListFragment.this.forceRefresh = false;
                    BrowseListFragment.this.showLoadingFooter(false);
                    BrowseListFragment.this.isLoading = false;
                    if (!response.isSuccessful()) {
                        ResponseBody responseBodyErrorBody = response.errorBody();
                        Log.e("BrowseListFragment", "Error fetching list: " + (responseBodyErrorBody != null ? responseBodyErrorBody.string() : null));
                        Toast.makeText(BrowseListFragment.this.requireContext(), R.string.error_loading_list, 0).show();
                        return;
                    }
                    MTCardsResponse mTCardsResponseBody = response.body();
                    if (mTCardsResponseBody != null) {
                        BrowseListFragment browseListFragment = BrowseListFragment.this;
                        int i = page;
                        browseListFragment.getBinding().titleTextView.setText(browseListFragment.getString(R.string.collection));
                        MTPagination pagination = mTCardsResponseBody.getPagination();
                        if (pagination != null) {
                            Integer total = pagination.getTotal();
                            browseListFragment.totalCards = total != null ? total.intValue() : 0;
                            int i2 = browseListFragment.cardsPerPage * i;
                            Integer total2 = pagination.getTotal();
                            browseListFragment.hasMorePages = i2 < (total2 != null ? total2.intValue() : 0);
                        }
                        browseListFragment.container = null;
                        if (browseListFragment.currentGroupBy != null && mTCardsResponseBody.getGrouped_cards() != null) {
                            List<MTCardGroup> grouped_cards = mTCardsResponseBody.getGrouped_cards();
                            if (i == 1) {
                                browseListFragment.currentGroupedCards.clear();
                                if (grouped_cards != null) {
                                    browseListFragment.currentGroupedCards.addAll(grouped_cards);
                                }
                                browseListFragment.currentCards.clear();
                                if (browseListFragment.getBinding().cardsRecyclerView.getAdapter() == null) {
                                    browseListFragment.setupRecyclerViewForCurrentLayout(browseListFragment.selectionMode);
                                } else {
                                    List<BrowseListCardItem> browseListCardItemsFromGroups = BrowseListCardItemKt.toBrowseListCardItemsFromGroups(browseListFragment.currentGroupedCards);
                                    RecyclerView.Adapter adapter = browseListFragment.getBinding().cardsRecyclerView.getAdapter();
                                    if (adapter instanceof MTFullCardsAdapter) {
                                        ((MTFullCardsAdapter) adapter).updateItems(browseListCardItemsFromGroups);
                                    } else if (adapter instanceof MTFullCardListAdapter) {
                                        ((MTFullCardListAdapter) adapter).updateItems(browseListCardItemsFromGroups);
                                    }
                                }
                            } else if (grouped_cards != null) {
                                browseListFragment.mergeGroupedCards(grouped_cards);
                            }
                            browseListFragment.updateCardCount();
                            return;
                        }
                        List<MTFullCard> cards = mTCardsResponseBody.getCards();
                        if (cards != null) {
                            if (i == 1) {
                                browseListFragment.currentCards.clear();
                                browseListFragment.currentCards.addAll(cards);
                                browseListFragment.currentGroupedCards.clear();
                                if (browseListFragment.getBinding().cardsRecyclerView.getAdapter() == null) {
                                    browseListFragment.setupRecyclerViewForCurrentLayout(browseListFragment.selectionMode);
                                } else {
                                    List<BrowseListCardItem> browseListCardItemsFromCards = BrowseListCardItemKt.toBrowseListCardItemsFromCards(browseListFragment.currentCards);
                                    RecyclerView.Adapter adapter2 = browseListFragment.getBinding().cardsRecyclerView.getAdapter();
                                    if (adapter2 instanceof MTFullCardsAdapter) {
                                        ((MTFullCardsAdapter) adapter2).updateItems(browseListCardItemsFromCards);
                                    } else if (adapter2 instanceof MTFullCardListAdapter) {
                                        ((MTFullCardListAdapter) adapter2).updateItems(browseListCardItemsFromCards);
                                    }
                                }
                            } else {
                                browseListFragment.currentCards.addAll(cards);
                                List<BrowseListCardItem> browseListCardItemsFromCards2 = BrowseListCardItemKt.toBrowseListCardItemsFromCards(browseListFragment.currentCards);
                                RecyclerView.Adapter adapter3 = browseListFragment.getBinding().cardsRecyclerView.getAdapter();
                                if (adapter3 instanceof MTFullCardsAdapter) {
                                    ((MTFullCardsAdapter) adapter3).updateItems(browseListCardItemsFromCards2);
                                } else if (adapter3 instanceof MTFullCardListAdapter) {
                                    ((MTFullCardListAdapter) adapter3).updateItems(browseListCardItemsFromCards2);
                                }
                            }
                            browseListFragment.updateCardCount();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mergeGroupedCards(List<MTCardGroup> newGroups) {
        ArrayList arrayList;
        if (newGroups.isEmpty()) {
            return;
        }
        for (MTCardGroup mTCardGroup : newGroups) {
            Iterator<MTCardGroup> it = this.currentGroupedCards.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().getType(), mTCardGroup.getType())) {
                    break;
                } else {
                    i++;
                }
            }
            List<MTCardGroup> list = this.currentGroupedCards;
            if (i >= 0) {
                MTCardGroup mTCardGroup2 = list.get(i);
                List<MTFullCard> cards = mTCardGroup2.getCards();
                if (cards == null || (arrayList = CollectionsKt.toMutableList((Collection) cards)) == null) {
                    arrayList = new ArrayList();
                }
                List<MTFullCard> cards2 = mTCardGroup.getCards();
                if (cards2 == null) {
                    cards2 = CollectionsKt.emptyList();
                }
                arrayList.addAll(cards2);
                this.currentGroupedCards.set(i, new MTCardGroup(mTCardGroup2.getType(), arrayList.size(), mTCardGroup.getTotal_count(), arrayList));
            } else {
                list.add(mTCardGroup);
            }
        }
        List<BrowseListCardItem> browseListCardItemsFromGroups = BrowseListCardItemKt.toBrowseListCardItemsFromGroups(this.currentGroupedCards);
        RecyclerView.Adapter adapter = getBinding().cardsRecyclerView.getAdapter();
        if (adapter instanceof MTFullCardsAdapter) {
            ((MTFullCardsAdapter) adapter).updateItems(browseListCardItemsFromGroups);
        } else if (adapter instanceof MTFullCardListAdapter) {
            ((MTFullCardListAdapter) adapter).updateItems(browseListCardItemsFromGroups);
        }
    }

    private final void moveCardsFromMultipleLists(MTUser currentUser, int destinationId, PreferencesManager prefs) {
        Integer listid;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<MTFullCard> allCardsFlat = getAllCardsFlat();
        for (Map.Entry<Integer, Integer> entry : this.selectedCards.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            MTFullCard mTFullCard = (MTFullCard) CollectionsKt.getOrNull(allCardsFlat, iIntValue);
            if (mTFullCard != null && (listid = mTFullCard.getListid()) != null) {
                int iIntValue3 = listid.intValue();
                if (!linkedHashMap.containsKey(Integer.valueOf(iIntValue3))) {
                    linkedHashMap.put(Integer.valueOf(iIntValue3), new ArrayList());
                }
                for (int i = 0; i < iIntValue2; i++) {
                    List<Integer> list_card_ids = mTFullCard.getList_card_ids();
                    MTCardReference mTCardReference = new MTCardReference(list_card_ids != null ? list_card_ids.get(i).intValue() : 0);
                    List list = (List) linkedHashMap.get(Integer.valueOf(iIntValue3));
                    if (list != null) {
                        list.add(mTCardReference);
                    }
                }
            }
        }
        if (!linkedHashMap.isEmpty()) {
            moveCardsFromMultipleLists$processNextList(new Ref.IntRef(), CollectionsKt.toList(linkedHashMap.keySet()), this, new Ref.BooleanRef(), new Ref.ObjectRef(), prefs, linkedHashMap, destinationId, currentUser);
        } else {
            getBinding().overlay.setVisibility(8);
            Toast.makeText(requireContext(), R.string.error_moving_card, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moveCardsFromMultipleLists$processNextList(final Ref.IntRef intRef, final List<Integer> list, final BrowseListFragment browseListFragment, final Ref.BooleanRef booleanRef, final Ref.ObjectRef<MTMoveCardsResponse> objectRef, final PreferencesManager preferencesManager, final Map<Integer, List<MTCardReference>> map, final int i, final MTUser mTUser) {
        MTCardContainer target;
        if (intRef.element < list.size()) {
            final int iIntValue = list.get(intRef.element).intValue();
            ArrayList arrayList = map.get(Integer.valueOf(iIntValue));
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            MTMoveCardsBody mTMoveCardsBody = new MTMoveCardsBody(0, null, 3, null);
            mTMoveCardsBody.setCards(arrayList);
            mTMoveCardsBody.setTarget(i);
            MTApiKt.getMtApi().moveCardsFromList(mTUser.getId(), iIntValue, browseListFragment.currentNameFilter, browseListFragment.currentScryfallFilter, browseListFragment.currentGroupBy, browseListFragment.currentOrderBy, browseListFragment.currentOrderDirection, null, null, null, mTMoveCardsBody).enqueue(new retrofit2.Callback<MTMoveCardsResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$moveCardsFromMultipleLists$processNextList$2
                @Override // retrofit2.Callback
                public void onFailure(retrofit2.Call<MTMoveCardsResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    Log.e("BrowseListFragment", "Error moving cards from list " + iIntValue, t);
                    booleanRef.element = true;
                    intRef.element++;
                    BrowseListFragment.moveCardsFromMultipleLists$processNextList(intRef, list, this.this$0, booleanRef, objectRef, preferencesManager, map, i, mTUser);
                }

                /* JADX WARN: Type inference failed for: r10v12, types: [T, com.studiolaganne.lengendarylens.MTMoveCardsResponse] */
                @Override // retrofit2.Callback
                public void onResponse(retrofit2.Call<MTMoveCardsResponse> call, retrofit2.Response<MTMoveCardsResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getActivity() == null || this.this$0.getContext() == null) {
                        return;
                    }
                    if (response.isSuccessful()) {
                        MTMoveCardsResponse mTMoveCardsResponseBody = response.body();
                        if (mTMoveCardsResponseBody != 0) {
                            Ref.ObjectRef<MTMoveCardsResponse> objectRef2 = objectRef;
                            Ref.BooleanRef booleanRef2 = booleanRef;
                            PreferencesManager preferencesManager2 = preferencesManager;
                            if (mTMoveCardsResponseBody.getSuccess()) {
                                objectRef2.element = mTMoveCardsResponseBody;
                                MTCardContainer source = mTMoveCardsResponseBody.getSource();
                                if (source != null) {
                                    preferencesManager2.incrementContainerVersion(source.getId());
                                    CardContainerCache.INSTANCE.setCachedContainer(source, source.getId());
                                }
                                MTCardContainer target2 = mTMoveCardsResponseBody.getTarget();
                                if (target2 != null) {
                                    preferencesManager2.incrementContainerVersion(target2.getId());
                                    CardContainerCache.INSTANCE.setCachedContainer(target2, target2.getId());
                                }
                            } else {
                                booleanRef2.element = true;
                            }
                        }
                    } else {
                        booleanRef.element = true;
                    }
                    intRef.element++;
                    BrowseListFragment.moveCardsFromMultipleLists$processNextList(intRef, list, this.this$0, booleanRef, objectRef, preferencesManager, map, i, mTUser);
                }
            });
            return;
        }
        browseListFragment.getBinding().overlay.setVisibility(8);
        if (booleanRef.element) {
            Toast.makeText(browseListFragment.requireContext(), R.string.error_moving_card, 0).show();
            return;
        }
        if (objectRef.element != null) {
            preferencesManager.incrementCollectionVersion();
            preferencesManager.incrementListsVersion();
            MTMoveCardsResponse mTMoveCardsResponse = objectRef.element;
            if (mTMoveCardsResponse != null && (target = mTMoveCardsResponse.getTarget()) != null && target.getId() == PreferencesManager.INSTANCE.getRecentCardListId()) {
                List<MTFullCard> cards = target.getCards();
                if (cards == null) {
                    cards = CollectionsKt.emptyList();
                }
                preferencesManager.setRecentCardsNew(cards);
            }
            browseListFragment.exitSelectionMode();
            browseListFragment.refreshListMaintainingPosition();
        }
    }

    private final void moveCardsFromSingleList(MTUser currentUser, int destinationId, final PreferencesManager prefs) {
        MTMoveCardsBody mTMoveCardsBody = new MTMoveCardsBody(0, null, 3, null);
        ArrayList arrayList = new ArrayList();
        List<MTFullCard> allCardsFlat = getAllCardsFlat();
        for (Map.Entry<Integer, Integer> entry : this.selectedCards.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            MTFullCard mTFullCard = (MTFullCard) CollectionsKt.getOrNull(allCardsFlat, iIntValue);
            if (mTFullCard != null) {
                for (int i = 0; i < iIntValue2; i++) {
                    List<Integer> list_card_ids = mTFullCard.getList_card_ids();
                    arrayList.add(new MTCardReference(list_card_ids != null ? list_card_ids.get(i).intValue() : 0));
                }
            }
        }
        mTMoveCardsBody.setCards(arrayList);
        mTMoveCardsBody.setTarget(destinationId);
        MTApiKt.getMtApi().moveCardsFromList(currentUser.getId(), this.listId, this.currentNameFilter, this.currentScryfallFilter, this.currentGroupBy, this.currentOrderBy, this.currentOrderDirection, null, null, null, mTMoveCardsBody).enqueue(new retrofit2.Callback<MTMoveCardsResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment.moveCardsFromSingleList.2
            @Override // retrofit2.Callback
            public void onFailure(retrofit2.Call<MTMoveCardsResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (BrowseListFragment.this.getContext() == null || BrowseListFragment.this._binding == null) {
                    return;
                }
                BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                Log.e("BrowseListFragment", "Error moving card", t);
                Toast.makeText(BrowseListFragment.this.requireContext(), R.string.error_moving_card, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(retrofit2.Call<MTMoveCardsResponse> call, retrofit2.Response<MTMoveCardsResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (BrowseListFragment.this.getContext() == null || BrowseListFragment.this._binding == null) {
                    return;
                }
                BrowseListFragment.this.handleSingleListMoveResponse(response, prefs);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveSelectedCardsToContainer(int destinationId) {
        if (isOtherUserList() || getActivity() == null || getContext() == null || !this.selectionMode || this.selectedCards.isEmpty()) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null) {
            return;
        }
        getBinding().overlay.setVisibility(0);
        if (this.listId == -1) {
            moveCardsFromMultipleLists(currentUser, destinationId, preferencesManager);
        } else {
            moveCardsFromSingleList(currentUser, destinationId, preferencesManager);
        }
    }

    @JvmStatic
    public static final BrowseCardsFragment newInstance(String str, String str2, boolean z) {
        return INSTANCE.newInstance(str, str2, z);
    }

    static final void onMTFullCardClick$lambda$0(final BrowseListFragment browseListFragment, MTFullCard mTFullCard, int i) {
        if (browseListFragment.pickACardMode) {
            final FragmentActivity activity = browseListFragment.getActivity();
            if (activity != null) {
                Intent intent = new Intent();
                intent.putExtra("newCardId", mTFullCard.getScryfallid());
                Integer face = mTFullCard.getFace();
                intent.putExtra(OptionalModuleUtils.FACE, face != null ? face.intValue() : 0);
                intent.putExtra("cardPicked", new Gson().toJson(mTFullCard));
                activity.setResult(-1, intent);
                browseListFragment.getBinding().cardsRecyclerView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda34
                    @Override // java.lang.Runnable
                    public final void run() {
                        BrowseListFragment.onMTFullCardClick$lambda$0$0$0(this.f$0, activity);
                    }
                }, 150L);
                return;
            }
            return;
        }
        String json = new Gson().toJson(mTFullCard);
        Intent intent2 = new Intent(browseListFragment.requireContext(), (Class<?>) CardActivity.class);
        intent2.putExtra("singleMTCard", json);
        intent2.putExtra("lang", mTFullCard.getLang());
        intent2.putExtra("enTitle", mTFullCard.getName());
        intent2.putExtra(OptionalModuleUtils.FACE, mTFullCard.getFace());
        intent2.putExtra("localizedTypeLine", mTFullCard.getPrinted_type_line());
        intent2.putExtra("localizedTitle", mTFullCard.getPrinted_name());
        intent2.putExtra("localizedOracle", mTFullCard.getPrinted_text());
        intent2.putExtra("currentOrderBy", browseListFragment.currentOrderBy);
        intent2.putExtra("currentOrderDirection", browseListFragment.currentOrderDirection);
        intent2.putExtra("currentGroupBy", browseListFragment.currentGroupBy);
        intent2.putExtra("currentNameFilter", browseListFragment.currentNameFilter);
        intent2.putExtra("currentScryfallFilter", browseListFragment.currentScryfallFilter);
        intent2.putExtra("currentPage", browseListFragment.currentPage);
        intent2.putExtra("cardsPerPage", browseListFragment.cardsPerPage);
        intent2.putExtra("totalCards", browseListFragment.totalCards);
        CardDataStore.INSTANCE.setMtCardList(browseListFragment.getAllCardsFlat());
        intent2.putExtra("hasMTCards", true);
        intent2.putExtra("currentMTIndex", i);
        intent2.putExtra("mtCardListId", browseListFragment.listId);
        if (browseListFragment.isOtherUserList()) {
            intent2.putExtra("readOnly", true);
        }
        browseListFragment.cardActivityLauncher.launch(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMTFullCardClick$lambda$0$0$0(BrowseListFragment browseListFragment, FragmentActivity fragmentActivity) {
        if (browseListFragment.getActivity() == null) {
            return;
        }
        fragmentActivity.finish();
    }

    static final Unit onViewCreated$lambda$10(final BrowseListFragment browseListFragment) {
        if (browseListFragment.selectionMode && !browseListFragment.selectedCards.isEmpty()) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = browseListFragment.getString(R.string.are_you_sure_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = browseListFragment.getString(R.string.confirm_cards_delete);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
            String string3 = browseListFragment.getString(R.string.delete);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowseListFragment.onViewCreated$lambda$10$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string4 = browseListFragment.getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda43
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BrowseListFragment.onViewCreated$lambda$10$1(this.f$0, (CustomDialogFragment) obj);
                }
            });
            FragmentManager childFragmentManager = browseListFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            negativeButton.show(childFragmentManager, "CustomDialogFragment");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$10$0(BrowseListFragment browseListFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (browseListFragment.getContext() == null || browseListFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        Context contextRequireContext = browseListFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            browseListFragment.getBinding().overlay.setVisibility(0);
            if (browseListFragment.listId == -1) {
                browseListFragment.deleteCardsFromMultipleLists(currentUser, preferencesManager);
            } else {
                browseListFragment.deleteCardsFromSingleList(currentUser, preferencesManager);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$10$1(BrowseListFragment browseListFragment, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (browseListFragment.getContext() == null || browseListFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$11(final BrowseListFragment browseListFragment) {
        if (browseListFragment.selectionMode && !browseListFragment.selectedCards.isEmpty()) {
            Context contextRequireContext = browseListFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            if (preferencesManager.getCurrentUser() == null) {
                return Unit.INSTANCE;
            }
            MTCollection currentUserCollection = preferencesManager.getCurrentUserCollection();
            if (currentUserCollection == null) {
                currentUserCollection = new MTCollection(null, null, null, null, 0, 0, null, null, 255, null);
            }
            MTUserLists currentUserLists = preferencesManager.getCurrentUserLists();
            if (currentUserLists == null) {
                currentUserLists = new MTUserLists(null, null, 3, null);
            }
            new MoveCardDialogFragment.Builder().setCollection(currentUserCollection).setLists(currentUserLists).setListener(new MoveCardDialogListener() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$onViewCreated$12$moveCardDialog$1
                @Override // com.studiolaganne.lengendarylens.MoveCardDialogListener
                public void onCancelMoveCard() {
                }

                @Override // com.studiolaganne.lengendarylens.MoveCardDialogListener
                public void onMoveCard(int destinationContainerId, int quantity, boolean isNewContainer, String newContainerName, Integer newContainerType) {
                    if (this.this$0.getActivity() == null || this.this$0.getContext() == null) {
                        return;
                    }
                    Context contextRequireContext2 = this.this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                    MTUser currentUser = new PreferencesManager(contextRequireContext2).getCurrentUser();
                    if (currentUser == null) {
                        return;
                    }
                    if (!isNewContainer) {
                        this.this$0.moveSelectedCardsToContainer(destinationContainerId);
                        return;
                    }
                    MTEditListBody mTEditListBody = new MTEditListBody(null, null, null, null, null, null, 63, null);
                    if (newContainerName == null) {
                        newContainerName = "New List";
                    }
                    mTEditListBody.setName(newContainerName);
                    if (newContainerType == null) {
                        newContainerType = 0;
                    }
                    mTEditListBody.setType(newContainerType);
                    retrofit2.Call<MTCardListResponse> callCreateList = MTApiKt.getMtApi().createList(currentUser.getId(), mTEditListBody);
                    this.this$0.getBinding().overlay.setVisibility(0);
                    final BrowseListFragment browseListFragment2 = this.this$0;
                    callCreateList.enqueue(new retrofit2.Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$onViewCreated$12$moveCardDialog$1$onMoveCard$1
                        @Override // retrofit2.Callback
                        public void onFailure(retrofit2.Call<MTCardListResponse> call, Throwable t) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(t, "t");
                            if (browseListFragment2.getContext() == null || browseListFragment2._binding == null) {
                                return;
                            }
                            Log.e("ScanFragment", "Failed to create MT Card List: " + t.getMessage());
                            browseListFragment2.getBinding().overlay.setVisibility(8);
                            Toast.makeText(browseListFragment2.requireContext(), R.string.error_creating_list, 0).show();
                        }

                        @Override // retrofit2.Callback
                        public void onResponse(retrofit2.Call<MTCardListResponse> call, retrofit2.Response<MTCardListResponse> response) {
                            MTCardContainer list;
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(response, "response");
                            if (browseListFragment2.getActivity() == null || browseListFragment2.getContext() == null) {
                                return;
                            }
                            browseListFragment2.getBinding().overlay.setVisibility(8);
                            if (!response.isSuccessful()) {
                                Toast.makeText(browseListFragment2.requireContext(), R.string.error_creating_list, 0).show();
                                return;
                            }
                            MTCardListResponse mTCardListResponseBody = response.body();
                            if (mTCardListResponseBody == null || (list = mTCardListResponseBody.getList()) == null) {
                                return;
                            }
                            browseListFragment2.moveSelectedCardsToContainer(list.getId());
                        }
                    });
                }
            }).build().show(browseListFragment.getChildFragmentManager(), MoveCardDialogFragment.TAG);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$12(BrowseListFragment browseListFragment) {
        if (browseListFragment._binding != null && browseListFragment.getContext() != null) {
            Context contextRequireContext = browseListFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            Breadcrumbs.INSTANCE.leaveBreadcrumb("grid_click_from_browse_cards");
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(browseListFragment.requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("grid_click_from_browse_cards", null);
            boolean z = browseListFragment.selectionMode;
            int i = WhenMappings.$EnumSwitchMapping$0[browseListFragment.currentLayout.ordinal()];
            if (i == 1) {
                CardsLayout cardsLayout = CardsLayout.GRID_BY_3;
                browseListFragment.currentLayout = cardsLayout;
                preferencesManager.setPreferredCardLayout(cardsLayout);
                PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
                browseListFragment.getBinding().gridImage.setImageResource(R.drawable.grid_3);
                browseListFragment.setupRecyclerViewForCurrentLayout(z);
            } else if (i == 2) {
                CardsLayout cardsLayout2 = CardsLayout.LIST;
                browseListFragment.currentLayout = cardsLayout2;
                preferencesManager.setPreferredCardLayout(cardsLayout2);
                PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
                browseListFragment.getBinding().gridImage.setImageResource(R.drawable.view_list);
                browseListFragment.setupRecyclerViewForCurrentLayout(z);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                CardsLayout cardsLayout3 = CardsLayout.GRID_BY_2;
                browseListFragment.currentLayout = cardsLayout3;
                preferencesManager.setPreferredCardLayout(cardsLayout3);
                PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
                browseListFragment.getBinding().gridImage.setImageResource(R.drawable.grid_2);
                browseListFragment.setupRecyclerViewForCurrentLayout(z);
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    static final boolean onViewCreated$lambda$13(BrowseListFragment browseListFragment, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        Object systemService = browseListFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(textView.getWindowToken(), 0);
        return true;
    }

    static final boolean onViewCreated$lambda$14(EditText editText, BrowseListFragment browseListFragment, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 || editText.getCompoundDrawables()[2] == null || motionEvent.getRawX() < editText.getRight() - (editText.getCompoundDrawables()[2].getBounds().width() * 2.0f)) {
            return false;
        }
        if (browseListFragment.getContext() == null) {
            return true;
        }
        editText.setText("");
        editText.requestFocus();
        Object systemService = browseListFragment.requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
        return true;
    }

    static final boolean onViewCreated$lambda$15(View view, MotionEvent motionEvent) {
        return true;
    }

    static final Unit onViewCreated$lambda$16(BrowseListFragment browseListFragment) {
        if (browseListFragment.filtersCollapsed) {
            browseListFragment.filtersCollapsed = false;
            browseListFragment.updateFilterListFromQuery(browseListFragment.lastQuery);
        } else {
            browseListFragment.filtersCollapsed = true;
            browseListFragment.updateFilterListFromQuery(browseListFragment.lastQuery);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$17(BrowseListFragment browseListFragment) {
        if (browseListFragment.filtersCollapsed) {
            browseListFragment.filtersCollapsed = false;
            browseListFragment.updateFilterListFromQuery(browseListFragment.lastQuery);
        } else {
            browseListFragment.filtersCollapsed = true;
            browseListFragment.updateFilterListFromQuery(browseListFragment.lastQuery);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$18(BrowseListFragment browseListFragment) {
        if (browseListFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        UnifiedFiltersBottomSheetFragment.Builder listener = new UnifiedFiltersBottomSheetFragment.Builder().setMode(FilterMode.COLLECTION).setCurrentFilters(browseListFragment.getBinding().filterEditText.getText().toString()).setLang(browseListFragment.lang).setAlwaysKeywordsInEnglish(true).setListener(browseListFragment);
        FragmentManager childFragmentManager = browseListFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        listener.show(childFragmentManager, "UnifiedFiltersBottomSheet");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(browseListFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("add_filter_tap", null);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$19(BrowseListFragment browseListFragment) {
        String string;
        int i = browseListFragment.listId;
        if (i == -1 || i == 1 || browseListFragment.isOtherUserList()) {
            return Unit.INSTANCE;
        }
        MTCardContainer mTCardContainer = browseListFragment.container;
        if (mTCardContainer == null || (string = mTCardContainer.getName()) == null) {
            string = "";
        }
        MTCardContainer mTCardContainer2 = browseListFragment.container;
        if (mTCardContainer2 != null && mTCardContainer2.getId() == 4) {
            string = browseListFragment.getString(R.string.list_bulk);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        MTCardContainer mTCardContainer3 = browseListFragment.container;
        if (mTCardContainer3 != null && mTCardContainer3.getId() == 1) {
            string = browseListFragment.getString(R.string.list_recent_cards);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        MTCardContainer mTCardContainer4 = browseListFragment.container;
        if (mTCardContainer4 != null && mTCardContainer4.getId() == 2) {
            string = browseListFragment.getString(R.string.list_wants);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        MTCardContainer mTCardContainer5 = browseListFragment.container;
        if (mTCardContainer5 != null && mTCardContainer5.getId() == 3) {
            string = browseListFragment.getString(R.string.list_trade);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        Intent intent = new Intent(browseListFragment.requireContext(), (Class<?>) ScanToListActivity.class);
        intent.putExtra("scanToListId", browseListFragment.listId);
        intent.putExtra("scanToListName", string);
        browseListFragment.scanActivityLauncher.launch(intent);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$20(final BrowseListFragment browseListFragment, final EditText editText) {
        String string;
        int i = browseListFragment.listId;
        if (i == -1 || i == 1 || browseListFragment.isOtherUserList()) {
            return Unit.INSTANCE;
        }
        MTCardContainer mTCardContainer = browseListFragment.container;
        if (mTCardContainer == null || (string = mTCardContainer.getName()) == null) {
            string = "";
        }
        MTCardContainer mTCardContainer2 = browseListFragment.container;
        if (mTCardContainer2 != null && mTCardContainer2.getId() == 4) {
            string = browseListFragment.getString(R.string.list_bulk);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        MTCardContainer mTCardContainer3 = browseListFragment.container;
        if (mTCardContainer3 != null && mTCardContainer3.getId() == 1) {
            string = browseListFragment.getString(R.string.list_recent_cards);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        MTCardContainer mTCardContainer4 = browseListFragment.container;
        if (mTCardContainer4 != null && mTCardContainer4.getId() == 2) {
            string = browseListFragment.getString(R.string.list_wants);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        MTCardContainer mTCardContainer5 = browseListFragment.container;
        if (mTCardContainer5 != null && mTCardContainer5.getId() == 3) {
            string = browseListFragment.getString(R.string.list_trade);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        String str = string;
        if (browseListFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = browseListFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        String string2 = preferencesManager.getString(PreferencesManager.LAST_CARD_PICKER_LANGUAGE, preferencesManager.getDeviceLanguage());
        CardPickerBottomSheetFragment.Companion companion = CardPickerBottomSheetFragment.INSTANCE;
        CardPickerCallback cardPickerCallback = new CardPickerCallback() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$onViewCreated$22$cardPickerBottomSheet$1
            @Override // com.studiolaganne.lengendarylens.CardPickerCallback
            public void onCardPickerClosed() {
            }

            @Override // com.studiolaganne.lengendarylens.CardPickerCallback
            public void onCardSelected(MTSimpleCard card, int face) {
                Intrinsics.checkNotNullParameter(card, "card");
                if (this.this$0.getActivity() == null || this.this$0.getContext() == null) {
                    return;
                }
                this.this$0.getBinding().overlay.setVisibility(0);
                MTApi mtApi = MTApiKt.getMtApi();
                String lang = card.getLang();
                if (lang == null) {
                    lang = "en";
                }
                String set_code = card.getSet_code();
                if (set_code == null) {
                    set_code = "";
                }
                String collector_number = card.getCollector_number();
                String str2 = collector_number != null ? collector_number : "";
                MTUser currentUser = preferencesManager.getCurrentUser();
                retrofit2.Call<MTFullCardResponse> cardWithParameters = mtApi.getCardWithParameters(lang, set_code, str2, currentUser != null ? Integer.valueOf(currentUser.getId()) : null);
                Log.d("BrowseListFragment", "Fetching full card for: " + card.getSet_code() + " " + card.getCollector_number() + " " + card.getLang());
                cardWithParameters.enqueue(new BrowseListFragment$onViewCreated$22$cardPickerBottomSheet$1$onCardSelected$1(this.this$0, editText));
            }
        };
        String string3 = browseListFragment.getResources().getString(R.string.add_card_to_list_title);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        companion.newInstance(cardPickerCallback, StringsKt.replace$default(string3, "{1}", str, false, 4, (Object) null), "_blank_", string2).show(browseListFragment.getChildFragmentManager(), CardPickerBottomSheetFragment.TAG);
        return Unit.INSTANCE;
    }

    static final void onViewCreated$lambda$4(BrowseListFragment browseListFragment) {
        browseListFragment.forceRefresh = true;
        browseListFragment.currentPage = 1;
        browseListFragment.hasMorePages = true;
        browseListFragment.currentCards.clear();
        browseListFragment.currentGroupedCards.clear();
        browseListFragment.loadListData(1);
    }

    static final Unit onViewCreated$lambda$5(BrowseListFragment browseListFragment) {
        if (browseListFragment.getActivity() == null) {
            return Unit.INSTANCE;
        }
        FragmentActivity activity = browseListFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$7(final BrowseListFragment browseListFragment) {
        MTCardContainer mTCardContainer;
        MTCardContainer mTCardContainer2;
        MTCardContainer mTCardContainer3;
        Context contextRequireContext = browseListFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        IconPopupMenu iconPopupMenu = new IconPopupMenu(contextRequireContext);
        if (browseListFragment.isOtherUserList()) {
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.export_as_csv, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowseListFragment.onViewCreated$lambda$7$0(this.f$0);
                }
            }, 30, (Object) null);
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.export_as_txt, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowseListFragment.onViewCreated$lambda$7$1(this.f$0);
                }
            }, 30, (Object) null);
        } else {
            MTCardContainer mTCardContainer4 = browseListFragment.container;
            boolean z = (mTCardContainer4 != null && mTCardContainer4.getId() == 4) || ((mTCardContainer = browseListFragment.container) != null && mTCardContainer.getId() == 1) || (((mTCardContainer2 = browseListFragment.container) != null && mTCardContainer2.getId() == 3) || ((mTCardContainer3 = browseListFragment.container) != null && mTCardContainer3.getId() == 2));
            MTCardContainer mTCardContainer5 = browseListFragment.container;
            boolean z2 = mTCardContainer5 != null && mTCardContainer5.getId() == 1;
            if (!z) {
                IconPopupMenu.addItem$default(iconPopupMenu, R.string.edit_button, "\uf044", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BrowseListFragment.onViewCreated$lambda$7$2(this.f$0);
                    }
                }, 28, (Object) null);
            }
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.select_action, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowseListFragment.onViewCreated$lambda$7$3(this.f$0);
                }
            }, 30, (Object) null);
            iconPopupMenu.addDivider();
            if (!z2) {
                IconPopupMenu.addItem$default(iconPopupMenu, R.string.import_action, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda44
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BrowseListFragment.onViewCreated$lambda$7$4(this.f$0);
                    }
                }, 30, (Object) null);
            }
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.export_as_csv, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda50
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowseListFragment.onViewCreated$lambda$7$5(this.f$0);
                }
            }, 30, (Object) null);
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.export_as_txt, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda51
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowseListFragment.onViewCreated$lambda$7$6(this.f$0);
                }
            }, 30, (Object) null);
        }
        TextView menuTextView = browseListFragment.getBinding().menuTextView;
        Intrinsics.checkNotNullExpressionValue(menuTextView, "menuTextView");
        iconPopupMenu.show(menuTextView);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7$0(BrowseListFragment browseListFragment) {
        browseListFragment.exportList();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7$1(BrowseListFragment browseListFragment) {
        browseListFragment.exportListAsTxt();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7$2(BrowseListFragment browseListFragment) {
        browseListFragment.editContainer();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7$3(BrowseListFragment browseListFragment) {
        browseListFragment.enterSelectionMode();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7$4(BrowseListFragment browseListFragment) {
        browseListFragment.showImportDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7$5(BrowseListFragment browseListFragment) {
        browseListFragment.exportList();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7$6(BrowseListFragment browseListFragment) {
        browseListFragment.exportListAsTxt();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$8(BrowseListFragment browseListFragment) {
        browseListFragment.exitSelectionMode();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$9(BrowseListFragment browseListFragment) {
        if (browseListFragment.selectionMode) {
            browseListFragment.selectedCards.clear();
            int i = 0;
            for (Object obj : browseListFragment.getAllCardsFlat()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Map<Integer, Integer> map = browseListFragment.selectedCards;
                Integer numValueOf = Integer.valueOf(i);
                Integer quantity = ((MTFullCard) obj).getQuantity();
                map.put(numValueOf, Integer.valueOf(quantity != null ? quantity.intValue() : 1));
                i = i2;
            }
            browseListFragment.updateSelectionCountText();
            RecyclerView.Adapter adapter = browseListFragment.getBinding().cardsRecyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        return Unit.INSTANCE;
    }

    private final void processCsvImport(InputStream inputStream, String fileName) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C11211(inputStream, this, null), 2, null);
    }

    private final void processImportIntoCurrentContainer(List<MTFullCard> cards) {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser == null) {
            Toast.makeText(requireContext(), R.string.error_adding_card, 1).show();
            return;
        }
        if (this.listId == -1) {
            Toast.makeText(requireContext(), R.string.error_adding_card, 1).show();
            return;
        }
        int iIntValue = 0;
        getBinding().overlay.setVisibility(0);
        Iterator<T> it = cards.iterator();
        while (it.hasNext()) {
            Integer quantity = ((MTFullCard) it.next()).getQuantity();
            iIntValue += quantity != null ? quantity.intValue() : 1;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new C11221(iIntValue, new Ref.IntRef(), new Ref.IntRef(), new ArrayList(), currentUser, cards, null), 2, null);
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
        firebaseAnalytics.logEvent("container_import_txt", null);
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
        getBinding().overlay.setVisibility(8);
        showContainerImportConfirmation(arrayList);
    }

    private final void refreshListMaintainingPosition() {
        if (getActivity() == null || getContext() == null) {
            return;
        }
        int i = this.currentPage;
        int i2 = this.cardsPerPage;
        int i3 = i * i2;
        if (i <= 1 || i3 <= i2) {
            resetAndRefreshList();
            return;
        }
        getBinding().overlay.setVisibility(0);
        List mutableList = CollectionsKt.toMutableList((Collection) this.currentCards);
        List mutableList2 = CollectionsKt.toMutableList((Collection) this.currentGroupedCards);
        this.currentCards.clear();
        this.currentGroupedCards.clear();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null) {
            return;
        }
        String string = (Intrinsics.areEqual(this.currentOrderBy, FirebaseAnalytics.Param.PRICE) || Intrinsics.areEqual(this.currentOrderBy, "total_price")) ? preferencesManager.getPreferredCurrency().toString() : null;
        ArrayList arrayList = new ArrayList();
        int i4 = 1;
        int i5 = i3;
        while (i5 > 0) {
            int iMin = Math.min(i5, 500);
            arrayList.add(new Pair(Integer.valueOf(i4), Integer.valueOf(iMin)));
            i5 -= iMin;
            i4++;
        }
        refreshListMaintainingPosition$loadNextBatch(new Ref.IntRef(), arrayList, this, i3, currentUser, string, mutableList, mutableList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshListMaintainingPosition$loadNextBatch(final Ref.IntRef intRef, final List<Pair<Integer, Integer>> list, final BrowseListFragment browseListFragment, final int i, final MTUser mTUser, final String str, final List<MTFullCard> list2, final List<MTCardGroup> list3) {
        if (intRef.element < list.size()) {
            Pair<Integer, Integer> pair = list.get(intRef.element);
            int iIntValue = pair.component1().intValue();
            int iIntValue2 = pair.component2().intValue();
            if (browseListFragment.listId == -1) {
                MTApi.getAllCollectionCards$default(MTApiKt.getMtApi(), mTUser.getId(), browseListFragment.currentNameFilter, browseListFragment.currentScryfallFilter, Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), browseListFragment.currentGroupBy, browseListFragment.currentOrderBy, browseListFragment.currentOrderDirection, null, str, 256, null).enqueue(new retrofit2.Callback<MTCardsResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$refreshListMaintainingPosition$loadNextBatch$1
                    @Override // retrofit2.Callback
                    public void onFailure(retrofit2.Call<MTCardsResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        if (this.this$0.getContext() == null || this.this$0._binding == null) {
                            return;
                        }
                        this.this$0.currentCards.clear();
                        this.this$0.currentCards.addAll(list2);
                        this.this$0.currentGroupedCards.clear();
                        this.this$0.currentGroupedCards.addAll(list3);
                        this.this$0.getBinding().overlay.setVisibility(8);
                        Log.e("BrowseListFragment", "Error loading batch: " + t.getMessage());
                        Toast.makeText(this.this$0.requireContext(), R.string.error_loading_list, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(retrofit2.Call<MTCardsResponse> call, retrofit2.Response<MTCardsResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (this.this$0._binding == null || this.this$0.getContext() == null) {
                            return;
                        }
                        if (!response.isSuccessful()) {
                            this.this$0.currentCards.clear();
                            this.this$0.currentCards.addAll(list2);
                            this.this$0.currentGroupedCards.clear();
                            this.this$0.currentGroupedCards.addAll(list3);
                            this.this$0.getBinding().overlay.setVisibility(8);
                            ResponseBody responseBodyErrorBody = response.errorBody();
                            Log.e("BrowseListFragment", "Error loading batch: " + (responseBodyErrorBody != null ? responseBodyErrorBody.string() : null));
                            Toast.makeText(this.this$0.requireContext(), R.string.error_loading_list, 0).show();
                            return;
                        }
                        MTCardsResponse mTCardsResponseBody = response.body();
                        if (mTCardsResponseBody != null) {
                            BrowseListFragment browseListFragment2 = this.this$0;
                            Ref.IntRef intRef2 = intRef;
                            List<Pair<Integer, Integer>> list4 = list;
                            int i2 = i;
                            MTUser mTUser2 = mTUser;
                            String str2 = str;
                            List<MTFullCard> list5 = list2;
                            List<MTCardGroup> list6 = list3;
                            if (browseListFragment2.currentGroupBy == null || mTCardsResponseBody.getGrouped_cards() == null) {
                                List<MTFullCard> cards = mTCardsResponseBody.getCards();
                                if (cards != null) {
                                    browseListFragment2.currentCards.addAll(cards);
                                }
                            } else {
                                List<MTCardGroup> grouped_cards = mTCardsResponseBody.getGrouped_cards();
                                if (grouped_cards != null) {
                                    if (intRef2.element == 0) {
                                        browseListFragment2.currentGroupedCards.addAll(grouped_cards);
                                    } else {
                                        browseListFragment2.mergeGroupedCards(grouped_cards);
                                    }
                                }
                            }
                            intRef2.element++;
                            BrowseListFragment.refreshListMaintainingPosition$loadNextBatch(intRef2, list4, browseListFragment2, i2, mTUser2, str2, list5, list6);
                        }
                    }
                });
                return;
            } else {
                (browseListFragment.isOtherUserList() ? MTApi.getUserListById$default(MTApiKt.getMtApi(), mTUser.getId(), browseListFragment.otherUserId, browseListFragment.listId, browseListFragment.currentNameFilter, browseListFragment.currentScryfallFilter, Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), browseListFragment.currentOrderBy, browseListFragment.currentGroupBy, browseListFragment.currentOrderDirection, str, null, null, null, 14336, null) : MTApi.getUserList$default(MTApiKt.getMtApi(), mTUser.getId(), browseListFragment.listId, browseListFragment.currentNameFilter, browseListFragment.currentScryfallFilter, Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), browseListFragment.currentOrderBy, browseListFragment.currentGroupBy, browseListFragment.currentOrderDirection, str, null, null, null, 7168, null)).enqueue(new retrofit2.Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$refreshListMaintainingPosition$loadNextBatch$2
                    @Override // retrofit2.Callback
                    public void onFailure(retrofit2.Call<MTCardListResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        if (this.this$0.getContext() == null || this.this$0._binding == null) {
                            return;
                        }
                        this.this$0.currentCards.clear();
                        this.this$0.currentCards.addAll(list2);
                        this.this$0.currentGroupedCards.clear();
                        this.this$0.currentGroupedCards.addAll(list3);
                        this.this$0.getBinding().overlay.setVisibility(8);
                        Log.e("BrowseListFragment", "Error loading batch: " + t.getMessage());
                        Toast.makeText(this.this$0.requireContext(), this.this$0.isOtherUserList() ? R.string.error_list_access_denied : R.string.error_loading_list, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(retrofit2.Call<MTCardListResponse> call, retrofit2.Response<MTCardListResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (this.this$0._binding == null || this.this$0.getContext() == null) {
                            return;
                        }
                        if (!response.isSuccessful()) {
                            this.this$0.currentCards.clear();
                            this.this$0.currentCards.addAll(list2);
                            this.this$0.currentGroupedCards.clear();
                            this.this$0.currentGroupedCards.addAll(list3);
                            this.this$0.getBinding().overlay.setVisibility(8);
                            ResponseBody responseBodyErrorBody = response.errorBody();
                            Log.e("BrowseListFragment", "Error loading batch: " + (responseBodyErrorBody != null ? responseBodyErrorBody.string() : null));
                            Toast.makeText(this.this$0.requireContext(), this.this$0.isOtherUserList() ? R.string.error_list_access_denied : R.string.error_loading_list, 0).show();
                            return;
                        }
                        MTCardListResponse mTCardListResponseBody = response.body();
                        if (mTCardListResponseBody != null) {
                            Ref.IntRef intRef2 = intRef;
                            BrowseListFragment browseListFragment2 = this.this$0;
                            List<Pair<Integer, Integer>> list4 = list;
                            int i2 = i;
                            MTUser mTUser2 = mTUser;
                            String str2 = str;
                            List<MTFullCard> list5 = list2;
                            List<MTCardGroup> list6 = list3;
                            MTCardContainer list7 = mTCardListResponseBody.getList();
                            if (list7 != null) {
                                if (intRef2.element == 0) {
                                    browseListFragment2.container = list7;
                                    CardContainerCache.INSTANCE.setCachedContainer(list7, list7.getId());
                                    Integer count = list7.getCount();
                                    browseListFragment2.totalCards = count != null ? count.intValue() : 0;
                                }
                                if (browseListFragment2.currentGroupBy == null || list7.getGrouped_cards() == null) {
                                    List<MTFullCard> cards = list7.getCards();
                                    if (cards != null) {
                                        browseListFragment2.currentCards.addAll(cards);
                                    }
                                } else {
                                    List<MTCardGroup> grouped_cards = list7.getGrouped_cards();
                                    if (grouped_cards != null) {
                                        if (intRef2.element == 0) {
                                            browseListFragment2.currentGroupedCards.addAll(grouped_cards);
                                        } else {
                                            browseListFragment2.mergeGroupedCards(grouped_cards);
                                        }
                                    }
                                }
                                intRef2.element++;
                                BrowseListFragment.refreshListMaintainingPosition$loadNextBatch(intRef2, list4, browseListFragment2, i2, mTUser2, str2, list5, list6);
                            }
                        }
                    }
                });
                return;
            }
        }
        browseListFragment.getBinding().overlay.setVisibility(8);
        int size = browseListFragment.getAllCardsFlat().size();
        int i2 = browseListFragment.cardsPerPage;
        browseListFragment.currentPage = ((size + i2) - 1) / i2;
        browseListFragment.hasMorePages = browseListFragment.getAllCardsFlat().size() >= i;
        if (browseListFragment.getBinding().cardsRecyclerView.getAdapter() == null) {
            browseListFragment.setupRecyclerViewForCurrentLayout(browseListFragment.selectionMode);
        } else {
            List<BrowseListCardItem> browseListCardItemsFromCards = (browseListFragment.currentGroupBy == null || browseListFragment.currentGroupedCards.isEmpty()) ? BrowseListCardItemKt.toBrowseListCardItemsFromCards(browseListFragment.currentCards) : BrowseListCardItemKt.toBrowseListCardItemsFromGroups(browseListFragment.currentGroupedCards);
            RecyclerView.Adapter adapter = browseListFragment.getBinding().cardsRecyclerView.getAdapter();
            if (adapter instanceof MTFullCardsAdapter) {
                ((MTFullCardsAdapter) adapter).updateItems(browseListCardItemsFromCards);
            } else if (adapter instanceof MTFullCardListAdapter) {
                ((MTFullCardListAdapter) adapter).updateItems(browseListCardItemsFromCards);
            }
        }
        browseListFragment.updateCardCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetAndRefreshList() {
        this.currentPage = 1;
        this.hasMorePages = true;
        this.currentCards.clear();
        this.currentGroupedCards.clear();
        loadListData(1);
    }

    private final void saveSortingGroupingSettings() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        preferencesManager.setLastGroupBy(this.currentGroupBy);
        preferencesManager.setLastOrderBy(this.currentOrderBy);
        preferencesManager.setLastOrderDirection(this.currentOrderDirection);
        PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
    }

    static final void scanActivityLauncher$lambda$0(BrowseListFragment browseListFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            String stringExtra = data != null ? data.getStringExtra("scannedCardsId") : null;
            if (stringExtra != null) {
                List<MTFullCard> listRetrieveAndRemoveScannedCards = ScannedCardsTempStorage.INSTANCE.retrieveAndRemoveScannedCards(stringExtra);
                if (listRetrieveAndRemoveScannedCards == null || listRetrieveAndRemoveScannedCards.isEmpty()) {
                    Toast.makeText(browseListFragment.requireContext(), R.string.no_cards_to_add, 0).show();
                } else {
                    browseListFragment.addScannedCardsToList(listRetrieveAndRemoveScannedCards);
                }
            }
        }
    }

    private final void setupPrivacyToolbar() {
        getBinding().privacyToolbarLayout.getRoot().setVisibility(8);
        getBinding().toolbarSeparator.setVisibility(8);
        final View viewFindViewById = getBinding().getRoot().findViewById(R.id.privacySelectorContainer);
        if (viewFindViewById != null) {
            ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowseListFragment.setupPrivacyToolbar$lambda$0(this.f$0, viewFindViewById);
                }
            });
        }
        View viewFindViewById2 = getBinding().getRoot().findViewById(R.id.sharingIcon);
        if (viewFindViewById2 != null) {
            ViewExtensionsKt.setOnClickWithFade(viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowseListFragment.setupPrivacyToolbar$lambda$1(this.f$0);
                }
            });
        }
        View viewFindViewById3 = getBinding().getRoot().findViewById(R.id.privacySettingsIcon);
        if (viewFindViewById3 != null) {
            ViewExtensionsKt.setOnClickWithFade(viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowseListFragment.setupPrivacyToolbar$lambda$2(this.f$0);
                }
            });
        }
    }

    static final Unit setupPrivacyToolbar$lambda$0(final BrowseListFragment browseListFragment, View view) {
        MTContainerPrivacy privacy;
        final String type;
        MTCardContainer mTCardContainer = browseListFragment.container;
        if (mTCardContainer == null || (privacy = mTCardContainer.getPrivacy()) == null || (type = privacy.getType()) == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = browseListFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PrivacyPopupMenu.show$default(new PrivacyPopupMenu(contextRequireContext, type, null, new Function1() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda45
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BrowseListFragment.setupPrivacyToolbar$lambda$0$0(type, browseListFragment, (String) obj);
            }
        }, 4, null), view, false, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupPrivacyToolbar$lambda$0$0(String str, BrowseListFragment browseListFragment, String selectedType) {
        Intrinsics.checkNotNullParameter(selectedType, "selectedType");
        if (!Intrinsics.areEqual(selectedType, str)) {
            browseListFragment.updateListPrivacy(selectedType);
        }
        return Unit.INSTANCE;
    }

    static final Unit setupPrivacyToolbar$lambda$1(BrowseListFragment browseListFragment) {
        MTCardContainer mTCardContainer = browseListFragment.container;
        if (mTCardContainer == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = browseListFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser == null) {
            return Unit.INSTANCE;
        }
        String userListUrl = MythicLinkGenerator.INSTANCE.getUserListUrl(currentUser.getId(), mTCardContainer.getId());
        Object systemService = browseListFragment.requireContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Mythic Tools Link", userListUrl));
        Toast.makeText(browseListFragment.requireContext(), R.string.link_copied_to_clipboard, 0).show();
        return Unit.INSTANCE;
    }

    static final Unit setupPrivacyToolbar$lambda$2(final BrowseListFragment browseListFragment) {
        MTContainerPrivacy privacy;
        MTCardContainer mTCardContainer = browseListFragment.container;
        if (mTCardContainer == null || (privacy = mTCardContainer.getPrivacy()) == null) {
            return Unit.INSTANCE;
        }
        PrivacySettingsDialogFragment.Builder onPrivacyUpdated = new PrivacySettingsDialogFragment.Builder().setListId(browseListFragment.listId).setCurrentPrivacy(privacy).setOnPrivacyUpdated(new Function1() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BrowseListFragment.setupPrivacyToolbar$lambda$2$0(this.f$0, (MTContainerPrivacy) obj);
            }
        });
        FragmentManager childFragmentManager = browseListFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        onPrivacyUpdated.show(childFragmentManager, "PrivacySettingsDialog");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupPrivacyToolbar$lambda$2$0(BrowseListFragment browseListFragment, MTContainerPrivacy updatedPrivacy) {
        Intrinsics.checkNotNullParameter(updatedPrivacy, "updatedPrivacy");
        MTCardContainer mTCardContainer = browseListFragment.container;
        browseListFragment.container = mTCardContainer != null ? MTCardContainer.copy$default(mTCardContainer, null, null, null, 0, null, null, null, null, null, null, null, null, null, updatedPrivacy, null, null, 57343, null) : null;
        browseListFragment.updatePrivacyToolbar(updatedPrivacy);
        CardContainerCache.INSTANCE.invalidate(browseListFragment.listId);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setupRecyclerViewForCurrentLayout(boolean keepSelectionMode) {
        boolean z;
        boolean z2;
        boolean z3;
        RecyclerView cardsRecyclerView = getBinding().cardsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(cardsRecyclerView, "cardsRecyclerView");
        RecyclerView.Adapter adapter = cardsRecyclerView.getAdapter();
        List<BrowseListCardItem> browseListCardItemsFromCards = (this.currentGroupBy == null || this.currentGroupedCards.isEmpty()) ? BrowseListCardItemKt.toBrowseListCardItemsFromCards(this.currentCards) : BrowseListCardItemKt.toBrowseListCardItemsFromGroups(this.currentGroupedCards);
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentLayout.ordinal()];
        final int i2 = 2;
        if (i != 1) {
            final int i3 = 3;
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if ((cardsRecyclerView.getLayoutManager() instanceof LinearLayoutManager) && ((z3 = adapter instanceof MTFullCardListAdapter))) {
                    MTFullCardListAdapter mTFullCardListAdapter = z3 ? (MTFullCardListAdapter) adapter : null;
                    if (mTFullCardListAdapter != null) {
                        mTFullCardListAdapter.updateItems(browseListCardItemsFromCards);
                    }
                    if (keepSelectionMode) {
                        ((MTFullCardListAdapter) adapter).setSelectionMode(true);
                    }
                } else {
                    cardsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
                    MTFullCardListAdapter mTFullCardListAdapter2 = new MTFullCardListAdapter(browseListCardItemsFromCards, this.listId, this, this, this, null, null, 96, null);
                    cardsRecyclerView.setAdapter(mTFullCardListAdapter2);
                    if (keepSelectionMode) {
                        mTFullCardListAdapter2.setSelectionMode(true);
                    }
                }
            } else if (cardsRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
                RecyclerView.LayoutManager layoutManager = cardsRecyclerView.getLayoutManager();
                GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
                if (gridLayoutManager != null && gridLayoutManager.getSpanCount() == 3 && ((z2 = adapter instanceof MTFullCardsAdapter))) {
                    MTFullCardsAdapter mTFullCardsAdapter = z2 ? (MTFullCardsAdapter) adapter : null;
                    if (mTFullCardsAdapter != null) {
                        mTFullCardsAdapter.updateItems(browseListCardItemsFromCards);
                    }
                    if (keepSelectionMode) {
                        ((MTFullCardsAdapter) adapter).setSelectionMode(true);
                    }
                } else {
                    GridLayoutManager gridLayoutManager2 = new GridLayoutManager(requireContext(), 3);
                    final MTFullCardsAdapter mTFullCardsAdapter2 = new MTFullCardsAdapter(browseListCardItemsFromCards, this.listId, this.sets, isSmallCards(), this, this, this, null, null, 384, null);
                    gridLayoutManager2.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment.setupRecyclerViewForCurrentLayout.2
                        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                        public int getSpanSize(int position) {
                            if (mTFullCardsAdapter2.getItemAt(position) instanceof BrowseListCardItem.SectionHeader) {
                                return i3;
                            }
                            return 1;
                        }
                    });
                    cardsRecyclerView.setLayoutManager(gridLayoutManager2);
                    cardsRecyclerView.setAdapter(mTFullCardsAdapter2);
                    if (keepSelectionMode) {
                        mTFullCardsAdapter2.setSelectionMode(true);
                    }
                }
            }
        } else if (cardsRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
            RecyclerView.LayoutManager layoutManager2 = cardsRecyclerView.getLayoutManager();
            GridLayoutManager gridLayoutManager3 = layoutManager2 instanceof GridLayoutManager ? (GridLayoutManager) layoutManager2 : null;
            if (gridLayoutManager3 != null && gridLayoutManager3.getSpanCount() == 2 && ((z = adapter instanceof MTFullCardsAdapter))) {
                MTFullCardsAdapter mTFullCardsAdapter3 = z ? (MTFullCardsAdapter) adapter : null;
                if (mTFullCardsAdapter3 != null) {
                    mTFullCardsAdapter3.updateItems(browseListCardItemsFromCards);
                }
                if (keepSelectionMode) {
                    ((MTFullCardsAdapter) adapter).setSelectionMode(true);
                }
            } else {
                GridLayoutManager gridLayoutManager4 = new GridLayoutManager(requireContext(), 2);
                final MTFullCardsAdapter mTFullCardsAdapter4 = new MTFullCardsAdapter(browseListCardItemsFromCards, this.listId, this.sets, isSmallCards(), this, this, this, null, null, 384, null);
                gridLayoutManager4.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment.setupRecyclerViewForCurrentLayout.1
                    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                    public int getSpanSize(int position) {
                        if (mTFullCardsAdapter4.getItemAt(position) instanceof BrowseListCardItem.SectionHeader) {
                            return i2;
                        }
                        return 1;
                    }
                });
                cardsRecyclerView.setLayoutManager(gridLayoutManager4);
                cardsRecyclerView.setAdapter(mTFullCardsAdapter4);
                if (keepSelectionMode) {
                    mTFullCardsAdapter4.setSelectionMode(true);
                }
            }
        }
        cardsRecyclerView.clearOnScrollListeners();
        cardsRecyclerView.addOnScrollListener(new AnonymousClass3());
        updateCardCount();
    }

    static /* synthetic */ void setupRecyclerViewForCurrentLayout$default(BrowseListFragment browseListFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        browseListFragment.setupRecyclerViewForCurrentLayout(z);
    }

    private final void setupSortAndGroupButtons() {
        View viewFindViewById = getBinding().getRoot().findViewById(R.id.displayModeToggle);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        final TextView textView = (TextView) getBinding().getRoot().findViewById(R.id.sortByButton);
        final TextView textView2 = (TextView) getBinding().getRoot().findViewById(R.id.groupByButton);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.showSortByPopupMenu(textView);
                }
            });
        }
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.showGroupByPopupMenu(textView2);
                }
            });
        }
        setupToolbarMarketplaceSelector();
    }

    private final void setupToolbarMarketplaceSelector() {
        LinearLayout linearLayout = (LinearLayout) getBinding().getRoot().findViewById(R.id.toolbarMarketplaceSelectorContainer);
        final MarketplaceSelectorView marketplaceSelectorView = (MarketplaceSelectorView) getBinding().getRoot().findViewById(R.id.toolbarMarketplaceSelectorView);
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        if (marketplaceSelectorView != null) {
            marketplaceSelectorView.updateIcon();
        }
        if (marketplaceSelectorView != null) {
            ViewExtensionsKt.setOnClickWithFade(marketplaceSelectorView, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda52
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowseListFragment.setupToolbarMarketplaceSelector$lambda$0(this.f$0, marketplaceSelectorView);
                }
            });
        }
        if (linearLayout != null) {
            ViewExtensionsKt.setOnClickWithFade(linearLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda53
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowseListFragment.setupToolbarMarketplaceSelector$lambda$1(this.f$0, marketplaceSelectorView);
                }
            });
        }
        if (marketplaceSelectorView != null) {
            marketplaceSelectorView.setOnMarketplaceChangedListener(new Function1() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda54
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BrowseListFragment.setupToolbarMarketplaceSelector$lambda$2(this.f$0, (String) obj);
                }
            });
        }
    }

    static final Unit setupToolbarMarketplaceSelector$lambda$0(BrowseListFragment browseListFragment, MarketplaceSelectorView marketplaceSelectorView) {
        if (browseListFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        marketplaceSelectorView.showMarketplaceSelectionDialog();
        return Unit.INSTANCE;
    }

    static final Unit setupToolbarMarketplaceSelector$lambda$1(BrowseListFragment browseListFragment, MarketplaceSelectorView marketplaceSelectorView) {
        if (browseListFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        if (marketplaceSelectorView != null) {
            marketplaceSelectorView.showMarketplaceSelectionDialog();
        }
        return Unit.INSTANCE;
    }

    static final Unit setupToolbarMarketplaceSelector$lambda$2(final BrowseListFragment browseListFragment, String marketplace) {
        Intrinsics.checkNotNullParameter(marketplace, "marketplace");
        if (browseListFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = browseListFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        preferencesManager.invalidateAllContainers();
        preferencesManager.syncCurrentSettingsToAPI(new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseListFragment.setupToolbarMarketplaceSelector$lambda$2$0(this.f$0);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupToolbarMarketplaceSelector$lambda$2$0(BrowseListFragment browseListFragment) {
        if (browseListFragment.getContext() != null && browseListFragment._binding != null) {
            browseListFragment.resetAndRefreshList();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void shareFile(File file) {
        String name;
        try {
            Uri uriForFile = FileProvider.getUriForFile(requireContext(), requireContext().getPackageName() + ".fileprovider", file);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/csv");
            intent.putExtra("android.intent.extra.STREAM", uriForFile);
            MTCardContainer mTCardContainer = this.container;
            if (mTCardContainer == null || (name = mTCardContainer.getName()) == null) {
                name = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            intent.putExtra("android.intent.extra.SUBJECT", "Mythic Tools List Export (" + name + ")");
            intent.addFlags(1);
            getBinding().overlay.setVisibility(8);
            startActivity(Intent.createChooser(intent, "Export List"));
        } catch (Exception unused) {
            getBinding().overlay.setVisibility(8);
            Toast.makeText(requireContext(), R.string.failed_share, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAddButton() {
        int i;
        if (getContext() == null || this._binding == null || (i = this.listId) == -1 || i == 1 || isOtherUserList()) {
            return;
        }
        getBinding().addButtonLayout.animate().cancel();
        getBinding().scanButtonLayout.animate().cancel();
        getBinding().addButtonLayout.setVisibility(0);
        getBinding().addButtonLayout.setClickable(true);
        getBinding().addButtonLayout.setFocusable(true);
        getBinding().scanButtonLayout.setVisibility(0);
        getBinding().scanButtonLayout.setClickable(true);
        getBinding().scanButtonLayout.setFocusable(true);
        getBinding().addButtonLayout.animate().alpha(1.0f).setDuration(200L).start();
        getBinding().scanButtonLayout.animate().alpha(1.0f).setDuration(200L).start();
    }

    private final void showContainerImportConfirmation(List<MTFullCard> cards) {
        MTCardContainer mTCardContainer;
        String name;
        if (getContext() == null || this._binding == null || (mTCardContainer = this.container) == null || (name = mTCardContainer.getName()) == null) {
            return;
        }
        Iterator<T> it = cards.iterator();
        while (it.hasNext()) {
            Integer quantity = ((MTFullCard) it.next()).getQuantity();
            if (quantity != null) {
                quantity.intValue();
            }
        }
        ContainerImportConfirmationDialogFragment.Builder onCancel = new ContainerImportConfirmationDialogFragment.Builder().setContainerName(name).setCards(cards).setOnConfirm(new Function1() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BrowseListFragment.showContainerImportConfirmation$lambda$1(this.f$0, (List) obj);
            }
        }).setOnCancel(new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseListFragment.showContainerImportConfirmation$lambda$2(this.f$0);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        onCancel.show(childFragmentManager, "container_import_confirmation_dialog");
    }

    static final Unit showContainerImportConfirmation$lambda$1(BrowseListFragment browseListFragment, List confirmedCards) {
        Intrinsics.checkNotNullParameter(confirmedCards, "confirmedCards");
        browseListFragment.processImportIntoCurrentContainer(confirmedCards);
        return Unit.INSTANCE;
    }

    static final Unit showContainerImportConfirmation$lambda$2(BrowseListFragment browseListFragment) {
        Toast.makeText(browseListFragment.requireContext(), browseListFragment.getString(R.string.import_canceled), 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void showContainerImportResults(int totalCards, int processedCards, int failedCards, List<MTSimpleCard> failedCardsList) {
        String upperCase;
        if (getContext() == null) {
            return;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        if (failedCards == 0) {
            firebaseAnalytics.logEvent("container_import_finished_ok", null);
            Toast.makeText(requireContext(), getString(R.string.container_import_success, Integer.valueOf(processedCards)), 1).show();
            return;
        }
        if (processedCards <= 0) {
            firebaseAnalytics.logEvent("container_import_finished_error", null);
            Toast.makeText(requireContext(), getString(R.string.import_failed), 1).show();
            return;
        }
        firebaseAnalytics.logEvent("container_import_finished_partial", null);
        String string = getString(R.string.import_partial, Integer.valueOf(processedCards), Integer.valueOf(failedCards));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast.makeText(requireContext(), string, 1).show();
        if (failedCardsList.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.container_import_failed_cards_header));
        sb.append("\n\n");
        for (MTSimpleCard mTSimpleCard : failedCardsList) {
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
            String str = collector_number != null ? collector_number : "?";
            String lang = mTSimpleCard.getLang();
            if (lang == null) {
                lang = "--";
            }
            sb.append("• " + ((Object) name) + " (" + upperCase + " #" + str + " - " + lang + ")\n");
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string2 = getString(R.string.import_results);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string2);
        String string3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        CustomDialogFragment.Builder body = title.setBody(string3);
        String string4 = getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string4, new Function2() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda46
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BrowseListFragment.showContainerImportResults$lambda$1(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "import_results_dialog");
    }

    static final Unit showContainerImportResults$lambda$1(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCsvPreviewDialog(MTGCsvImporter.CsvParseResult parseResult, String csvContent) {
        if (getContext() == null || this._binding == null) {
            return;
        }
        CsvPreviewDialogFragment.Builder onCancel = new CsvPreviewDialogFragment.Builder().setParseResult(parseResult).setCsvContent(csvContent).setOnContinue(new Function2() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BrowseListFragment.showCsvPreviewDialog$lambda$0(this.f$0, (MTGCsvImporter.ImportResult) obj, (Map) obj2);
            }
        }).setOnCancel(new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseListFragment.showCsvPreviewDialog$lambda$1(this.f$0);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        onCancel.show(childFragmentManager, CsvPreviewDialogFragment.TAG);
    }

    static final Unit showCsvPreviewDialog$lambda$0(BrowseListFragment browseListFragment, MTGCsvImporter.ImportResult importResult, Map map) {
        Intrinsics.checkNotNullParameter(importResult, "importResult");
        if (map != null) {
            Log.d("ImportCSV", "User provided custom column mappings: " + map);
        }
        browseListFragment.handleImportResult(importResult);
        return Unit.INSTANCE;
    }

    static final Unit showCsvPreviewDialog$lambda$1(BrowseListFragment browseListFragment) {
        Toast.makeText(browseListFragment.requireContext(), browseListFragment.getString(R.string.import_canceled), 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void showGroupByPopupMenu(View anchor) {
        MenuItem menuItemFindItem;
        MenuItem menuItemFindItem2;
        MenuItem menuItemFindItem3;
        MenuItem menuItemFindItem4;
        MenuItem menuItemFindItem5;
        MenuItem menuItemFindItem6;
        if (getContext() == null) {
            return;
        }
        PopupMenu popupMenu = new PopupMenu(requireContext(), anchor);
        popupMenu.getMenuInflater().inflate(R.menu.browse_list_group_by_menu, popupMenu.getMenu());
        String str = this.currentGroupBy;
        if (str != null) {
            switch (str.hashCode()) {
                case -938161749:
                    if (str.equals("rarity") && (menuItemFindItem = popupMenu.getMenu().findItem(R.id.group_rarity)) != null) {
                        menuItemFindItem.setChecked(true);
                    }
                    break;
                case 3355:
                    if (str.equals("id") && (menuItemFindItem2 = popupMenu.getMenu().findItem(R.id.group_color_identity)) != null) {
                        menuItemFindItem2.setChecked(true);
                    }
                    break;
                case 98617:
                    if (str.equals("cmc") && (menuItemFindItem3 = popupMenu.getMenu().findItem(R.id.group_cmc)) != null) {
                        menuItemFindItem3.setChecked(true);
                    }
                    break;
                case 113762:
                    if (str.equals("set") && (menuItemFindItem4 = popupMenu.getMenu().findItem(R.id.group_set)) != null) {
                        menuItemFindItem4.setChecked(true);
                    }
                    break;
                case 3575610:
                    if (str.equals("type") && (menuItemFindItem5 = popupMenu.getMenu().findItem(R.id.group_type)) != null) {
                        menuItemFindItem5.setChecked(true);
                    }
                    break;
                case 94842723:
                    if (str.equals("color") && (menuItemFindItem6 = popupMenu.getMenu().findItem(R.id.group_color)) != null) {
                        menuItemFindItem6.setChecked(true);
                    }
                    break;
            }
        } else {
            MenuItem menuItemFindItem7 = popupMenu.getMenu().findItem(R.id.group_none);
            if (menuItemFindItem7 != null) {
                menuItemFindItem7.setChecked(true);
            }
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda49
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return BrowseListFragment.showGroupByPopupMenu$lambda$0(this.f$0, menuItem);
            }
        });
        popupMenu.show();
    }

    static final boolean showGroupByPopupMenu$lambda$0(BrowseListFragment browseListFragment, MenuItem menuItem) {
        if (browseListFragment.getContext() == null) {
            return false;
        }
        browseListFragment.exitSelectionMode();
        int itemId = menuItem.getItemId();
        if (itemId == R.id.group_none) {
            browseListFragment.currentGroupBy = null;
        } else if (itemId == R.id.group_type) {
            browseListFragment.currentGroupBy = "type";
        } else if (itemId == R.id.group_color) {
            browseListFragment.currentGroupBy = "color";
        } else if (itemId == R.id.group_color_identity) {
            browseListFragment.currentGroupBy = "id";
        } else if (itemId == R.id.group_cmc) {
            browseListFragment.currentGroupBy = "cmc";
        } else if (itemId == R.id.group_rarity) {
            browseListFragment.currentGroupBy = "rarity";
        } else if (itemId == R.id.group_set) {
            browseListFragment.currentGroupBy = "set";
        }
        browseListFragment.saveSortingGroupingSettings();
        browseListFragment.resetAndRefreshList();
        return true;
    }

    private final void showImportDialog() {
        MTCardContainer mTCardContainer;
        String name;
        if (isOtherUserList() || getContext() == null || this._binding == null || (mTCardContainer = this.container) == null || (name = mTCardContainer.getName()) == null) {
            return;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("container_import_start", null);
        ImportCsvDialogFragment.Builder listener = new ImportCsvDialogFragment.Builder().setListener(this);
        String string = getString(R.string.import_into_container, name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        listener.setCustomTitle(string).build().show(getParentFragmentManager(), ImportCsvDialogFragment.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadingFooter(boolean show) {
        getBinding().scrollAnimationView.setVisibility(show ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void showSortByPopupMenu(View anchor) {
        MenuItem menuItemFindItem;
        MenuItem menuItemFindItem2;
        MenuItem menuItemFindItem3;
        MenuItem menuItemFindItem4;
        MenuItem menuItemFindItem5;
        MenuItem menuItemFindItem6;
        MenuItem menuItemFindItem7;
        MenuItem menuItemFindItem8;
        MenuItem menuItemFindItem9;
        MenuItem menuItemFindItem10;
        MenuItem menuItemFindItem11;
        MenuItem menuItemFindItem12;
        MenuItem menuItemFindItem13;
        MenuItem menuItemFindItem14;
        MenuItem menuItemFindItem15;
        MenuItem menuItemFindItem16;
        MenuItem menuItemFindItem17;
        if (getContext() == null) {
            return;
        }
        PopupMenu popupMenu = new PopupMenu(requireContext(), anchor);
        popupMenu.getMenuInflater().inflate(R.menu.browse_list_sort_by_menu, popupMenu.getMenu());
        String str = this.currentOrderBy;
        if (str != null) {
            switch (str.hashCode()) {
                case -1613589672:
                    if (str.equals("language") && (menuItemFindItem2 = popupMenu.getMenu().findItem(R.id.sort_language)) != null) {
                        menuItemFindItem2.setChecked(true);
                    }
                    break;
                case -1285004149:
                    if (str.equals(FirebaseAnalytics.Param.QUANTITY) && (menuItemFindItem3 = popupMenu.getMenu().findItem(R.id.sort_quantity)) != null) {
                        menuItemFindItem3.setChecked(true);
                    }
                    break;
                case -1230770222:
                    if (str.equals("added_at") && (menuItemFindItem4 = popupMenu.getMenu().findItem(R.id.sort_added_at)) != null) {
                        menuItemFindItem4.setChecked(true);
                    }
                    break;
                case -1034364087:
                    if (str.equals("number") && (menuItemFindItem5 = popupMenu.getMenu().findItem(R.id.sort_number)) != null) {
                        menuItemFindItem5.setChecked(true);
                    }
                    break;
                case -938161749:
                    if (str.equals("rarity") && (menuItemFindItem6 = popupMenu.getMenu().findItem(R.id.sort_rarity)) != null) {
                        menuItemFindItem6.setChecked(true);
                    }
                    break;
                case -904257739:
                    if (str.equals("altered") && (menuItemFindItem7 = popupMenu.getMenu().findItem(R.id.sort_altered)) != null) {
                        menuItemFindItem7.setChecked(true);
                    }
                    break;
                case -902467812:
                    if (str.equals("signed") && (menuItemFindItem8 = popupMenu.getMenu().findItem(R.id.sort_signed)) != null) {
                        menuItemFindItem8.setChecked(true);
                    }
                    break;
                case -861311717:
                    if (str.equals("condition") && (menuItemFindItem9 = popupMenu.getMenu().findItem(R.id.sort_condition)) != null) {
                        menuItemFindItem9.setChecked(true);
                    }
                    break;
                case -395678578:
                    if (str.equals("total_price") && (menuItemFindItem10 = popupMenu.getMenu().findItem(R.id.sort_total_price)) != null) {
                        menuItemFindItem10.setChecked(true);
                    }
                    break;
                case 98617:
                    if (str.equals("cmc") && (menuItemFindItem11 = popupMenu.getMenu().findItem(R.id.sort_cmc)) != null) {
                        menuItemFindItem11.setChecked(true);
                    }
                    break;
                case 113762:
                    if (str.equals("set") && (menuItemFindItem12 = popupMenu.getMenu().findItem(R.id.sort_set)) != null) {
                        menuItemFindItem12.setChecked(true);
                    }
                    break;
                case 3148716:
                    if (str.equals("foil") && (menuItemFindItem13 = popupMenu.getMenu().findItem(R.id.sort_foil)) != null) {
                        menuItemFindItem13.setChecked(true);
                    }
                    break;
                case 3373707:
                    if (str.equals("name") && (menuItemFindItem14 = popupMenu.getMenu().findItem(R.id.sort_name)) != null) {
                        menuItemFindItem14.setChecked(true);
                    }
                    break;
                case 106934601:
                    if (str.equals(FirebaseAnalytics.Param.PRICE) && (menuItemFindItem15 = popupMenu.getMenu().findItem(R.id.sort_price)) != null) {
                        menuItemFindItem15.setChecked(true);
                    }
                    break;
                case 106941038:
                    if (str.equals("proxy") && (menuItemFindItem16 = popupMenu.getMenu().findItem(R.id.sort_proxy)) != null) {
                        menuItemFindItem16.setChecked(true);
                    }
                    break;
                case 1250446129:
                    if (str.equals("missprint") && (menuItemFindItem17 = popupMenu.getMenu().findItem(R.id.sort_printing_error)) != null) {
                        menuItemFindItem17.setChecked(true);
                    }
                    break;
            }
        }
        String str2 = this.currentOrderDirection;
        if (Intrinsics.areEqual(str2, "asc")) {
            MenuItem menuItemFindItem18 = popupMenu.getMenu().findItem(R.id.sort_ascending);
            if (menuItemFindItem18 != null) {
                menuItemFindItem18.setChecked(true);
            }
        } else if (Intrinsics.areEqual(str2, "desc") && (menuItemFindItem = popupMenu.getMenu().findItem(R.id.sort_descending)) != null) {
            menuItemFindItem.setChecked(true);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda8
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return BrowseListFragment.showSortByPopupMenu$lambda$0(this.f$0, menuItem);
            }
        });
        popupMenu.show();
    }

    static final boolean showSortByPopupMenu$lambda$0(BrowseListFragment browseListFragment, MenuItem menuItem) {
        if (browseListFragment.getContext() == null) {
            return false;
        }
        browseListFragment.exitSelectionMode();
        int itemId = menuItem.getItemId();
        if (itemId == R.id.sort_added_at) {
            browseListFragment.currentOrderBy = "added_at";
        } else if (itemId == R.id.sort_quantity) {
            browseListFragment.currentOrderBy = FirebaseAnalytics.Param.QUANTITY;
        } else if (itemId == R.id.sort_cmc) {
            browseListFragment.currentOrderBy = "cmc";
        } else if (itemId == R.id.sort_rarity) {
            browseListFragment.currentOrderBy = "rarity";
        } else if (itemId == R.id.sort_foil) {
            browseListFragment.currentOrderBy = "foil";
        } else if (itemId == R.id.sort_name) {
            browseListFragment.currentOrderBy = "name";
        } else if (itemId == R.id.sort_set) {
            browseListFragment.currentOrderBy = "set";
        } else if (itemId == R.id.sort_number) {
            browseListFragment.currentOrderBy = "number";
        } else if (itemId == R.id.sort_condition) {
            browseListFragment.currentOrderBy = "condition";
        } else if (itemId == R.id.sort_language) {
            browseListFragment.currentOrderBy = "language";
        } else if (itemId == R.id.sort_price) {
            browseListFragment.currentOrderBy = FirebaseAnalytics.Param.PRICE;
        } else if (itemId == R.id.sort_total_price) {
            browseListFragment.currentOrderBy = "total_price";
        } else if (itemId == R.id.sort_altered) {
            browseListFragment.currentOrderBy = "altered";
        } else if (itemId == R.id.sort_signed) {
            browseListFragment.currentOrderBy = "signed";
        } else if (itemId == R.id.sort_printing_error) {
            browseListFragment.currentOrderBy = "missprint";
        } else if (itemId == R.id.sort_proxy) {
            browseListFragment.currentOrderBy = "proxy";
        } else if (itemId == R.id.sort_ascending) {
            browseListFragment.currentOrderDirection = "asc";
        } else if (itemId == R.id.sort_descending) {
            browseListFragment.currentOrderDirection = "desc";
        }
        browseListFragment.saveSortingGroupingSettings();
        browseListFragment.resetAndRefreshList();
        return true;
    }

    public static /* synthetic */ void toggleCardSelection$default(BrowseListFragment browseListFragment, MTFullCard mTFullCard, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 1;
        }
        browseListFragment.toggleCardSelection(mTFullCard, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCardCount() {
        int i;
        String strReplace$default;
        String strReplace$default2;
        int iIntValue;
        int iIntValue2 = 0;
        if (this.currentGroupBy == null || this.currentGroupedCards.isEmpty()) {
            Iterator<T> it = this.currentCards.iterator();
            while (it.hasNext()) {
                Integer quantity = ((MTFullCard) it.next()).getQuantity();
                iIntValue2 += quantity != null ? quantity.intValue() : 1;
            }
            i = iIntValue2;
        } else {
            Iterator<T> it2 = this.currentGroupedCards.iterator();
            i = 0;
            while (it2.hasNext()) {
                List<MTFullCard> cards = ((MTCardGroup) it2.next()).getCards();
                if (cards != null) {
                    Iterator<T> it3 = cards.iterator();
                    iIntValue = 0;
                    while (it3.hasNext()) {
                        Integer quantity2 = ((MTFullCard) it3.next()).getQuantity();
                        iIntValue += quantity2 != null ? quantity2.intValue() : 1;
                    }
                } else {
                    iIntValue = 0;
                }
                i += iIntValue;
            }
        }
        if (i == 0) {
            getBinding().numCardsTextView.setText(getString(R.string.no_cards));
            return;
        }
        int i2 = this.totalCards;
        if (i2 <= 0 || i2 == i) {
            TextView textView = getBinding().numCardsTextView;
            if (i == 1) {
                strReplace$default = getString(R.string.one_card);
            } else {
                String string = getString(R.string.x_cards);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                strReplace$default = StringsKt.replace$default(string, "{1}", String.valueOf(i), false, 4, (Object) null);
            }
            textView.setText(strReplace$default);
            return;
        }
        TextView textView2 = getBinding().numCardsTextView;
        if (i == 1 && i2 == 1) {
            strReplace$default2 = getString(R.string.showing_one_card_out_of_one);
        } else if (i == 1) {
            String string2 = getString(R.string.showing_one_card_out_of_y);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            strReplace$default2 = StringsKt.replace$default(string2, "{1}", String.valueOf(i2), false, 4, (Object) null);
        } else if (i2 == 1) {
            String string3 = getString(R.string.showing_x_cards_out_of_one);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            strReplace$default2 = StringsKt.replace$default(string3, "{1}", String.valueOf(i), false, 4, (Object) null);
        } else {
            String string4 = getString(R.string.showing_x_cards_out_of_y);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            strReplace$default2 = StringsKt.replace$default(StringsKt.replace$default(string4, "{1}", String.valueOf(i), false, 4, (Object) null), "{2}", String.valueOf(i2), false, 4, (Object) null);
        }
        textView2.setText(strReplace$default2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFilterListFromQuery(String query) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C11251(query, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFiltersAndRefreshList(String query) {
        if (query.length() == 0) {
            clearFiltersAndRefreshList();
            return;
        }
        this.lastQuery = query;
        updateFilterListFromQuery(query);
        this.currentNameFilter = null;
        this.currentScryfallFilter = null;
        SearchElement searchQuery = SearchDataUtils.INSTANCE.getInstance().parseSearchQuery(query);
        SearchGroup searchGroup = searchQuery instanceof SearchGroup ? (SearchGroup) searchQuery : null;
        if (searchGroup != null) {
            for (SearchElement searchElement : searchGroup.getElements()) {
                if (searchElement instanceof SearchCondition) {
                    SearchCondition searchCondition = (SearchCondition) searchElement;
                    if (searchCondition.getKeyword() == SearchKeyword.NAME) {
                        String str = this.currentNameFilter;
                        if (str != null) {
                            if (str.length() > 0) {
                                this.currentNameFilter += " ";
                            }
                            this.currentNameFilter += searchCondition.getValue();
                        } else {
                            this.currentNameFilter = searchCondition.getValue();
                        }
                    } else {
                        String originalToken = searchCondition.getOriginalToken();
                        String str2 = this.currentScryfallFilter;
                        if (str2 == null) {
                            this.currentScryfallFilter = originalToken;
                        } else {
                            Intrinsics.checkNotNull(str2);
                            if (str2.length() > 0) {
                                this.currentScryfallFilter += " " + originalToken;
                            }
                        }
                    }
                }
            }
        } else {
            this.currentNameFilter = query;
            this.currentScryfallFilter = null;
        }
        resetAndRefreshList();
    }

    private final void updateListPrivacy(String newType) {
        if (isOtherUserList()) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser == null || this.listId == -1) {
            return;
        }
        getBinding().overlay.setVisibility(0);
        MTApiKt.getMtApi().updateListPrivacy(currentUser.getId(), this.listId, new MTUpdatePrivacyBody(newType, null, null, 6, null)).enqueue(new retrofit2.Callback<MTContainerPrivacyResponse>() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment.updateListPrivacy.1
            @Override // retrofit2.Callback
            public void onFailure(retrofit2.Call<MTContainerPrivacyResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (BrowseListFragment.this._binding == null || BrowseListFragment.this.getContext() == null) {
                    return;
                }
                BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                Toast.makeText(BrowseListFragment.this.requireContext(), R.string.error_loading_list, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(retrofit2.Call<MTContainerPrivacyResponse> call, retrofit2.Response<MTContainerPrivacyResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (BrowseListFragment.this._binding == null || BrowseListFragment.this.getContext() == null) {
                    return;
                }
                BrowseListFragment.this.getBinding().overlay.setVisibility(8);
                if (!response.isSuccessful()) {
                    Toast.makeText(BrowseListFragment.this.requireContext(), R.string.error_loading_list, 0).show();
                    return;
                }
                MTContainerPrivacyResponse mTContainerPrivacyResponseBody = response.body();
                MTContainerPrivacy privacy = mTContainerPrivacyResponseBody != null ? mTContainerPrivacyResponseBody.getPrivacy() : null;
                BrowseListFragment browseListFragment = BrowseListFragment.this;
                MTCardContainer mTCardContainer = browseListFragment.container;
                browseListFragment.container = mTCardContainer != null ? MTCardContainer.copy$default(mTCardContainer, null, null, null, 0, null, null, null, null, null, null, null, null, null, privacy, null, null, 57343, null) : null;
                BrowseListFragment.this.updatePrivacyToolbar(privacy);
                CardContainerCache.INSTANCE.invalidate(BrowseListFragment.this.listId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateOtherUserInfo(MTPrivacyUser user) {
        if (this._binding == null) {
            return;
        }
        if (user == null) {
            getBinding().userInfoLayout.setVisibility(8);
            return;
        }
        getBinding().userInfoLayout.setVisibility(0);
        TextView textView = getBinding().userFirstName;
        String firstname = user.getFirstname();
        textView.setText(firstname != null ? firstname : "");
        TextView textView2 = getBinding().userName;
        String username = user.getUsername();
        textView2.setText("@" + (username != null ? username : ""));
        String picture = user.getPicture();
        String str = picture;
        if (str == null || str.length() == 0) {
            getBinding().profileIcon.setVisibility(4);
            getBinding().noPhotoIcon.setVisibility(0);
            return;
        }
        getBinding().profileIcon.setVisibility(0);
        getBinding().profileIcon.setOutlineProvider(new CircularOutlineProvider());
        getBinding().profileIcon.setClipToOutline(true);
        getBinding().profileIcon.reset();
        getBinding().profileIcon.setAutoLoad(false);
        getBinding().profileIcon.loadImage(picture);
        getBinding().noPhotoIcon.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void updatePrivacyToolbar(MTContainerPrivacy privacy) {
        Pair pair;
        if (this._binding == null) {
            return;
        }
        if (!isOtherUserList()) {
            if ((privacy != null ? privacy.getType() : null) != null) {
                getBinding().privacyToolbarLayout.getRoot().setVisibility(0);
                getBinding().toolbarSeparator.setVisibility(0);
                TextView textView = (TextView) getBinding().getRoot().findViewById(R.id.privacyLabel);
                View viewFindViewById = getBinding().getRoot().findViewById(R.id.privacySelectorContainer);
                View viewFindViewById2 = getBinding().getRoot().findViewById(R.id.sharingIcon);
                View viewFindViewById3 = getBinding().getRoot().findViewById(R.id.separatorIcon);
                String type = privacy.getType();
                if (type != null) {
                    switch (type.hashCode()) {
                        case -977423767:
                            if (!type.equals(MTApiKt.PRIVACY_TYPE_PUBLIC)) {
                                return;
                            } else {
                                pair = TuplesKt.to(Integer.valueOf(R.string.privacy_public), Integer.valueOf(R.drawable.privacy_selector_background_public));
                            }
                            break;
                        case -903566235:
                            if (!type.equals(MTApiKt.PRIVACY_TYPE_SHARED)) {
                                return;
                            } else {
                                pair = TuplesKt.to(Integer.valueOf(R.string.privacy_shared), Integer.valueOf(R.drawable.privacy_selector_background_shared));
                            }
                            break;
                        case -314497661:
                            if (!type.equals(MTApiKt.PRIVACY_TYPE_PRIVATE)) {
                                return;
                            } else {
                                pair = TuplesKt.to(Integer.valueOf(R.string.privacy_private), Integer.valueOf(R.drawable.privacy_selector_background_private));
                            }
                            break;
                        case -216005226:
                            if (!type.equals(MTApiKt.PRIVACY_TYPE_UNLISTED)) {
                                return;
                            } else {
                                pair = TuplesKt.to(Integer.valueOf(R.string.privacy_unlisted), Integer.valueOf(R.drawable.privacy_selector_background_unlisted));
                            }
                            break;
                        default:
                            return;
                    }
                    int iIntValue = ((Number) pair.component1()).intValue();
                    int iIntValue2 = ((Number) pair.component2()).intValue();
                    if (textView != null) {
                        textView.setText(getString(iIntValue));
                    }
                    if (viewFindViewById != null) {
                        viewFindViewById.setBackgroundResource(iIntValue2);
                    }
                    boolean zAreEqual = Intrinsics.areEqual(privacy.getType(), MTApiKt.PRIVACY_TYPE_PRIVATE);
                    if (viewFindViewById2 != null) {
                        viewFindViewById2.setVisibility(zAreEqual ? 8 : 0);
                    }
                    if (viewFindViewById3 != null) {
                        viewFindViewById3.setVisibility(zAreEqual ? 8 : 0);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        getBinding().privacyToolbarLayout.getRoot().setVisibility(8);
        getBinding().toolbarSeparator.setVisibility(8);
    }

    private final void updateSelectionCountText() {
        int iSumOfInt = CollectionsKt.sumOfInt(this.selectedCards.values());
        if (iSumOfInt == 1) {
            String string = getString(R.string.x_card_selected);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            getBinding().selectionCountTextView.setText(StringsKt.replace$default(string, "{1}", String.valueOf(iSumOfInt), false, 4, (Object) null));
            return;
        }
        String string2 = getString(R.string.x_cards_selected);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        getBinding().selectionCountTextView.setText(StringsKt.replace$default(string2, "{1}", String.valueOf(iSumOfInt), false, 4, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTitleWithPrice(String name, MTCardContainer container) {
        Map<String, MTCardsValue> values;
        MTCardsValue containerValue;
        if (this._binding == null || getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String preferredCurrency = new PreferencesManager(contextRequireContext).getPreferredCurrency();
        String price = null;
        if (container != null && (values = container.getValues()) != null && (containerValue = GameUtils.INSTANCE.getInstance().getContainerValue(values, preferredCurrency)) != null) {
            price = GameUtils.INSTANCE.getInstance().formatPrice(containerValue.getTotal_value(), preferredCurrency);
        }
        getBinding().titleTextView.setText(price != null ? name + " - " + price : name);
    }

    public final Job getSearchJob() {
        return this.searchJob;
    }

    public final int getSelectedQuantity(int position) {
        Integer num = this.selectedCards.get(Integer.valueOf(position));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final boolean isCardSelected(int position) {
        return this.selectedCards.containsKey(Integer.valueOf(position));
    }

    @Override // com.studiolaganne.lengendarylens.OnCardLongPressListener
    public void onCardLongPress(MTFullCard card, int position) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (isOtherUserList() || this.selectionMode) {
            return;
        }
        enterSelectionMode();
        Integer quantity = card.getQuantity();
        toggleCardSelection(card, position, quantity != null ? quantity.intValue() : 1);
    }

    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
    public void onCardSelectionToggle(MTFullCard card, int position) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (!this.selectionMode) {
            onMTFullCardClick(card, position);
        } else {
            Integer quantity = card.getQuantity();
            toggleCardSelection(card, position, quantity != null ? quantity.intValue() : 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.pickACardMode = arguments.getBoolean("pickACardMode", false);
        }
        this.sets = CardSetsManager.INSTANCE.getCardSets();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentBrowseListBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Runnable runnable = this.scrollStoppedRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        this.scrollStoppedRunnable = null;
        this._binding = null;
    }

    @Override // com.studiolaganne.lengendarylens.OnFilterClickListener
    public void onFilterClick(SearchCondition filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        final EditText filterEditText = getBinding().filterEditText;
        Intrinsics.checkNotNullExpressionValue(filterEditText, "filterEditText");
        final String string = filterEditText.getText().toString();
        new FilterDialogFragment.Builder().setSearchElement(filter).setLang(this.lang).setAlwaysKeywordsInEnglish(true).setListener(new FilterDialogListener() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$onFilterClick$1$filterDialog$1
            @Override // com.studiolaganne.lengendarylens.FilterDialogListener
            public void onFilterSubmitButton(SearchCondition filter2) {
                Intrinsics.checkNotNullParameter(filter2, "filter");
                String strReplace$default = StringsKt.replace$default(string, filter2.getOriginalToken(), filter2.toShortString(), false, 4, (Object) null);
                filterEditText.setText(strReplace$default);
                this.updateFilterListFromQuery(strReplace$default);
                this.updateFiltersAndRefreshList(strReplace$default);
            }
        }).build().show(getChildFragmentManager(), "FilterDialogFragment");
    }

    @Override // com.studiolaganne.lengendarylens.OnFilterClickListener
    public void onFilterDelete(SearchCondition filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        EditText filterEditText = getBinding().filterEditText;
        Intrinsics.checkNotNullExpressionValue(filterEditText, "filterEditText");
        String string = filterEditText.getText().toString();
        if (string != null) {
            String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(string, filter.getOriginalToken(), "", false, 4, (Object) null), "  ", " ", false, 4, (Object) null);
            String str = strReplace$default;
            if (StringsKt.trim((CharSequence) str).toString().length() > 0) {
                filterEditText.setText(str);
                updateFilterListFromQuery(strReplace$default);
                updateFiltersAndRefreshList(strReplace$default);
                return;
            }
            this.lastQuery = "";
            filterEditText.setText("");
            this.filtersCollapsed = false;
            updateFilterListFromQuery("");
            ImageView collapseImageView = getBinding().collapseImageView;
            Intrinsics.checkNotNullExpressionValue(collapseImageView, "collapseImageView");
            collapseImageView.setVisibility(8);
            ConstraintLayout filterSummaryLayout = getBinding().filterSummaryLayout;
            Intrinsics.checkNotNullExpressionValue(filterSummaryLayout, "filterSummaryLayout");
            filterSummaryLayout.setVisibility(8);
            clearFiltersAndRefreshList();
        }
    }

    @Override // com.studiolaganne.lengendarylens.FilterDialogListener
    public void onFilterSubmitButton(SearchCondition filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (getContext() == null) {
            return;
        }
        EditText filterEditText = getBinding().filterEditText;
        Intrinsics.checkNotNullExpressionValue(filterEditText, "filterEditText");
        String string = filterEditText.getText().toString();
        if (string != null) {
            String str = string + " " + filter.toShortString();
            String str2 = str;
            if (StringsKt.trim((CharSequence) str2).toString().length() > 0) {
                filterEditText.setText(str2);
                updateFilterListFromQuery(str);
                this.lastQuery = str;
                updateFiltersAndRefreshList(str);
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.UnifiedFiltersListener
    public void onFiltersApplied(String scryfallQuery) {
        Intrinsics.checkNotNullParameter(scryfallQuery, "scryfallQuery");
        if (getContext() == null) {
            return;
        }
        EditText filterEditText = getBinding().filterEditText;
        Intrinsics.checkNotNullExpressionValue(filterEditText, "filterEditText");
        String str = scryfallQuery;
        filterEditText.setText(str);
        updateFilterListFromQuery(scryfallQuery);
        if (StringsKt.trim((CharSequence) str).toString().length() > 0) {
            this.lastQuery = scryfallQuery;
            updateFiltersAndRefreshList(scryfallQuery);
        } else {
            this.lastQuery = "";
            this.filtersCollapsed = false;
            updateFilterListFromQuery("");
        }
    }

    @Override // com.studiolaganne.lengendarylens.ImportCsvDialogListener
    public void onImportCollection(CollectionImportResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("container_import_confirm", null);
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

    @Override // com.studiolaganne.lengendarylens.OnMTFullCardClickListener
    public void onMTFullCardClick(final MTFullCard card, final int index) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (this.selectionMode) {
            Integer quantity = card.getQuantity();
            toggleCardSelection(card, index, quantity != null ? quantity.intValue() : 1);
        } else {
            if (getContext() == null || this._binding == null) {
                return;
            }
            RecyclerView cardsRecyclerView = getBinding().cardsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(cardsRecyclerView, "cardsRecyclerView");
            cardsRecyclerView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    BrowseListFragment.onMTFullCardClick$lambda$0(this.f$0, card, index);
                }
            }, 150L);
        }
    }

    @Override // com.studiolaganne.lengendarylens.OnCardSelectionListener
    public void onQuantityChange(MTFullCard card, int position, int newQuantity) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (this.selectionMode) {
            updateSelectionQuantity(card, position, newQuantity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        int containerVersion;
        MarketplaceSelectorView marketplaceSelectorView;
        super.onResume();
        if (this._binding != null && (marketplaceSelectorView = (MarketplaceSelectorView) getBinding().getRoot().findViewById(R.id.toolbarMarketplaceSelectorView)) != null) {
            marketplaceSelectorView.updateIcon();
        }
        if (this.listId == -1 || (containerVersion = CardContainerCache.INSTANCE.getContainerVersion(this.listId)) <= this.lastKnownContainerVersion) {
            return;
        }
        this.lastKnownContainerVersion = containerVersion;
        loadListData(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        this.currentLayout = preferencesManager.getPreferredCardLayout();
        getBinding().titleTextView.setText("");
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt("listId")) : null;
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("lang") : null;
        this.listId = numValueOf != null ? numValueOf.intValue() : -1;
        Bundle arguments3 = getArguments();
        this.otherUserId = arguments3 != null ? arguments3.getInt("userId", -1) : -1;
        this.lang = preferencesManager.getDeviceLanguage();
        if (string != null) {
            this.lang = string;
        }
        if (preferencesManager.getSaveSortingGroupingSettings()) {
            String lastGroupBy = preferencesManager.getLastGroupBy();
            if (lastGroupBy != null) {
                this.currentGroupBy = lastGroupBy;
            }
            String lastOrderBy = preferencesManager.getLastOrderBy();
            if (lastOrderBy != null) {
                this.currentOrderBy = lastOrderBy;
            }
            String lastOrderDirection = preferencesManager.getLastOrderDirection();
            if (lastOrderDirection != null) {
                this.currentOrderDirection = lastOrderDirection;
            }
        }
        if (this.currentOrderBy == null) {
            this.currentOrderBy = "added_at";
            this.currentOrderDirection = "desc";
        }
        getBinding().selectionLayout.setVisibility(8);
        setupSortAndGroupButtons();
        setupPrivacyToolbar();
        loadListData(1);
        getBinding().swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda15
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                BrowseListFragment.onViewCreated$lambda$4(this.f$0);
            }
        });
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$onViewCreated$callback$1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                FragmentActivity activity;
                boolean z = this.this$0.selectionMode;
                BrowseListFragment browseListFragment = this.this$0;
                if (z) {
                    browseListFragment.exitSelectionMode();
                } else {
                    if (browseListFragment.getActivity() == null || (activity = this.this$0.getActivity()) == null) {
                        return;
                    }
                    activity.finish();
                }
            }
        };
        ImageView backImage = getBinding().backImage;
        Intrinsics.checkNotNullExpressionValue(backImage, "backImage");
        ViewExtensionsKt.setOnClickWithFade(backImage, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseListFragment.onViewCreated$lambda$5(this.f$0);
            }
        });
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback);
        LinearLayout topLayout = getBinding().topLayout;
        Intrinsics.checkNotNullExpressionValue(topLayout, "topLayout");
        ViewExtensionsKt.setOnClickWithFade(topLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        });
        TextView menuTextView = getBinding().menuTextView;
        Intrinsics.checkNotNullExpressionValue(menuTextView, "menuTextView");
        ViewExtensionsKt.setOnClickWithFade(menuTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseListFragment.onViewCreated$lambda$7(this.f$0);
            }
        });
        TextView clearTextView = getBinding().clearTextView;
        Intrinsics.checkNotNullExpressionValue(clearTextView, "clearTextView");
        ViewExtensionsKt.setOnClickWithFade(clearTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseListFragment.onViewCreated$lambda$8(this.f$0);
            }
        });
        TextView selectAllTextView = getBinding().selectAllTextView;
        Intrinsics.checkNotNullExpressionValue(selectAllTextView, "selectAllTextView");
        ViewExtensionsKt.setOnClickWithFade(selectAllTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseListFragment.onViewCreated$lambda$9(this.f$0);
            }
        });
        TextView deleteTextView = getBinding().deleteTextView;
        Intrinsics.checkNotNullExpressionValue(deleteTextView, "deleteTextView");
        ViewExtensionsKt.setOnClickWithFade(deleteTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseListFragment.onViewCreated$lambda$10(this.f$0);
            }
        });
        TextView moveTextView = getBinding().moveTextView;
        Intrinsics.checkNotNullExpressionValue(moveTextView, "moveTextView");
        ViewExtensionsKt.setOnClickWithFade(moveTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseListFragment.onViewCreated$lambda$11(this.f$0);
            }
        });
        ImageView gridImage = getBinding().gridImage;
        Intrinsics.checkNotNullExpressionValue(gridImage, "gridImage");
        ViewExtensionsKt.setOnClickWithFade(gridImage, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseListFragment.onViewCreated$lambda$12(this.f$0);
            }
        });
        final EditText filterEditText = getBinding().filterEditText;
        Intrinsics.checkNotNullExpressionValue(filterEditText, "filterEditText");
        filterEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda32
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return BrowseListFragment.onViewCreated$lambda$13(this.f$0, textView, i, keyEvent);
            }
        });
        filterEditText.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return BrowseListFragment.onViewCreated$lambda$14(filterEditText, this, view2, motionEvent);
            }
        });
        filterEditText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment.onViewCreated.16
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    filterEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {
                    filterEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_clear, 0);
                }
                String strValueOf = String.valueOf(s);
                this.lastQuery = strValueOf;
                int length = this.lastQuery.length();
                BrowseListFragment browseListFragment = this;
                if (length != 0) {
                    Job searchJob = browseListFragment.getSearchJob();
                    if (searchJob != null) {
                        Job.DefaultImpls.cancel$default(searchJob, (CancellationException) null, 1, (Object) null);
                    }
                    BrowseListFragment browseListFragment2 = this;
                    browseListFragment2.setSearchJob(BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(browseListFragment2), Dispatchers.getIO(), null, new BrowseListFragment$onViewCreated$16$afterTextChanged$1(this, strValueOf, null), 2, null));
                    return;
                }
                ImageView collapseImageView = browseListFragment.getBinding().collapseImageView;
                Intrinsics.checkNotNullExpressionValue(collapseImageView, "collapseImageView");
                collapseImageView.setVisibility(8);
                ConstraintLayout filterSummaryLayout = this.getBinding().filterSummaryLayout;
                Intrinsics.checkNotNullExpressionValue(filterSummaryLayout, "filterSummaryLayout");
                filterSummaryLayout.setVisibility(8);
                this.filtersCollapsed = false;
                this.updateFilterListFromQuery("");
                this.exitSelectionMode();
                this.clearFiltersAndRefreshList();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return BrowseListFragment.onViewCreated$lambda$15(view2, motionEvent);
            }
        });
        ImageView collapseImageView = getBinding().collapseImageView;
        Intrinsics.checkNotNullExpressionValue(collapseImageView, "collapseImageView");
        collapseImageView.setVisibility(8);
        ConstraintLayout filterSummaryLayout = getBinding().filterSummaryLayout;
        Intrinsics.checkNotNullExpressionValue(filterSummaryLayout, "filterSummaryLayout");
        filterSummaryLayout.setVisibility(8);
        ViewExtensionsKt.setOnClickWithFade(collapseImageView, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseListFragment.onViewCreated$lambda$16(this.f$0);
            }
        });
        ConstraintLayout filterSummaryLayout2 = getBinding().filterSummaryLayout;
        Intrinsics.checkNotNullExpressionValue(filterSummaryLayout2, "filterSummaryLayout");
        ViewExtensionsKt.setOnClickWithFade(filterSummaryLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseListFragment.onViewCreated$lambda$17(this.f$0);
            }
        });
        LinearLayout addFilterLayout = getBinding().addFilterLayout;
        Intrinsics.checkNotNullExpressionValue(addFilterLayout, "addFilterLayout");
        ViewExtensionsKt.setOnClickWithFade(addFilterLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseListFragment.onViewCreated$lambda$18(this.f$0);
            }
        });
        int i = this.listId;
        if (i == -1 || i == 1 || isOtherUserList()) {
            getBinding().addButtonLayout.setVisibility(8);
            getBinding().scanButtonLayout.setVisibility(8);
        }
        ConstraintLayout scanButtonLayout = getBinding().scanButtonLayout;
        Intrinsics.checkNotNullExpressionValue(scanButtonLayout, "scanButtonLayout");
        ViewExtensionsKt.setOnClickWithBounce(scanButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseListFragment.onViewCreated$lambda$19(this.f$0);
            }
        });
        ConstraintLayout addButtonLayout = getBinding().addButtonLayout;
        Intrinsics.checkNotNullExpressionValue(addButtonLayout, "addButtonLayout");
        ViewExtensionsKt.setOnClickWithBounce(addButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.BrowseListFragment$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BrowseListFragment.onViewCreated$lambda$20(this.f$0, filterEditText);
            }
        });
    }

    public final void setSearchJob(Job job) {
        this.searchJob = job;
    }

    public final void toggleCardSelection(MTFullCard card, int position, int quantity) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (card.getCardid() == null) {
            return;
        }
        if (this.selectedCards.containsKey(Integer.valueOf(position))) {
            this.selectedCards.remove(Integer.valueOf(position));
        } else {
            Integer quantity2 = card.getQuantity();
            this.selectedCards.put(Integer.valueOf(position), Integer.valueOf(Math.min(quantity, quantity2 != null ? quantity2.intValue() : 1)));
        }
        updateSelectionCountText();
        RecyclerView.Adapter adapter = getBinding().cardsRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final void updateSelectionQuantity(MTFullCard card, int position, int quantity) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (card.getCardid() == null) {
            return;
        }
        if (quantity <= 0) {
            this.selectedCards.remove(Integer.valueOf(position));
        } else {
            Integer quantity2 = card.getQuantity();
            this.selectedCards.put(Integer.valueOf(position), Integer.valueOf(Math.min(quantity, quantity2 != null ? quantity2.intValue() : 1)));
        }
        updateSelectionCountText();
        RecyclerView.Adapter adapter = getBinding().cardsRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
