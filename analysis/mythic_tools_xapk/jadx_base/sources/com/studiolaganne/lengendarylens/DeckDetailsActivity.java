package com.studiolaganne.lengendarylens;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Property;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.PopupMenu;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResultHandler;
import com.studiolaganne.lengendarylens.BatchCollectionStatusDialogFragment;
import com.studiolaganne.lengendarylens.BracketDialogFragment;
import com.studiolaganne.lengendarylens.CollectionRestoreDialogFragment;
import com.studiolaganne.lengendarylens.CollectionStatusDialogFragment;
import com.studiolaganne.lengendarylens.CsvPreviewDialogFragment;
import com.studiolaganne.lengendarylens.CustomDeleteDialogFragment;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.DeckDetailsActivity;
import com.studiolaganne.lengendarylens.DeckIDCardDetailsBottomSheetFragment;
import com.studiolaganne.lengendarylens.DeckImportConfirmationDialogFragment;
import com.studiolaganne.lengendarylens.DeckMoveCardDialogFragment;
import com.studiolaganne.lengendarylens.DeleteCardDialogFragment;
import com.studiolaganne.lengendarylens.EditCardDialogFragment;
import com.studiolaganne.lengendarylens.ExportTxtDialogFragment;
import com.studiolaganne.lengendarylens.ExternalDeckSyncConfirmationDialogFragment;
import com.studiolaganne.lengendarylens.ImportDeckDialogFragment;
import com.studiolaganne.lengendarylens.MTCardPickerBottomSheetFragment;
import com.studiolaganne.lengendarylens.MTGCsvImporter;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import com.studiolaganne.lengendarylens.MythicPlusBottomSheetFragment;
import com.studiolaganne.lengendarylens.MythicPlusInfoDialogFragment;
import com.studiolaganne.lengendarylens.PrivacySettingsDialogFragment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.opencv.videoio.Videoio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: DeckDetailsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u009c\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0002´\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u001eH\u0002J\u0010\u0010n\u001a\u00020l2\u0006\u0010m\u001a\u00020\u001eH\u0002J\b\u0010v\u001a\u00020lH\u0016J\u001e\u0010y\u001a\u00020l2\u0006\u0010z\u001a\u00020{2\f\u0010|\u001a\b\u0012\u0004\u0012\u0002030\u000bH\u0016J\u0010\u0010}\u001a\u00020l2\u0006\u0010~\u001a\u000203H\u0016J\u0011\u0010\u007f\u001a\u00020l2\u0007\u0010\u0080\u0001\u001a\u00020\u001bH\u0016J!\u0010\u0081\u0001\u001a\u00020l2\u0007\u0010\u0080\u0001\u001a\u00020\u001b2\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020N0\u000bH\u0002J\u0012\u0010\u0083\u0001\u001a\u00020l2\u0007\u0010\u0080\u0001\u001a\u00020\u001bH\u0016J\t\u0010\u0084\u0001\u001a\u00020lH\u0016J\u0011\u0010\u0085\u0001\u001a\u00020l2\u0006\u0010~\u001a\u000203H\u0016J\u0011\u0010\u0086\u0001\u001a\u00020l2\u0006\u0010~\u001a\u000203H\u0016J\u0011\u0010\u0087\u0001\u001a\u00020l2\u0006\u0010~\u001a\u000203H\u0016J\u001a\u0010\u0088\u0001\u001a\u00020l2\u000f\u0010\u0089\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bH\u0016J\u0012\u0010\u008a\u0001\u001a\u00020l2\u0007\u0010\u008b\u0001\u001a\u00020\tH\u0016J\u0012\u0010\u008c\u0001\u001a\u00020l2\u0007\u0010\u008b\u0001\u001a\u00020\tH\u0016J\u001b\u0010\u008d\u0001\u001a\u00020l2\u0007\u0010\u008b\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u008f\u0001\u001a\u00020lH\u0002J\t\u0010\u0090\u0001\u001a\u00020lH\u0002J\t\u0010\u0091\u0001\u001a\u00020lH\u0002J\u0018\u0010\u0092\u0001\u001a\u00020l2\r\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\t\u0010\u0094\u0001\u001a\u00020lH\u0002J\t\u0010\u0095\u0001\u001a\u00020lH\u0002J\u0013\u0010\u0096\u0001\u001a\u00020l2\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0002J\u0012\u0010\u0099\u0001\u001a\u00020l2\u0007\u0010\u009a\u0001\u001a\u00020\u001eH\u0002J\t\u0010\u009c\u0001\u001a\u00020lH\u0014J\u0015\u0010\u009d\u0001\u001a\u00020l2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0014J\t\u0010 \u0001\u001a\u00020lH\u0002J\t\u0010¡\u0001\u001a\u00020lH\u0002J#\u0010¢\u0001\u001a\u00020l2\b\u0010£\u0001\u001a\u00030¤\u00012\u000e\u0010¥\u0001\u001a\t\u0012\u0005\u0012\u00030¦\u00010\u000bH\u0002J\t\u0010§\u0001\u001a\u00020lH\u0002J\t\u0010¨\u0001\u001a\u00020lH\u0002J\t\u0010©\u0001\u001a\u00020lH\u0002J\t\u0010ª\u0001\u001a\u00020lH\u0002J\t\u0010«\u0001\u001a\u00020lH\u0002J\t\u0010¬\u0001\u001a\u00020lH\u0002J\t\u0010\u00ad\u0001\u001a\u00020lH\u0002J\t\u0010®\u0001\u001a\u00020lH\u0002J\u0013\u0010¯\u0001\u001a\u00020l2\b\u0010°\u0001\u001a\u00030±\u0001H\u0002J#\u0010²\u0001\u001a\u00020l2\b\u0010³\u0001\u001a\u00030±\u00012\u000e\u0010´\u0001\u001a\t\u0012\u0005\u0012\u00030µ\u000102H\u0002J\u0013\u0010¶\u0001\u001a\u00020l2\b\u0010°\u0001\u001a\u00030±\u0001H\u0002J\t\u0010·\u0001\u001a\u00020lH\u0002J\u001d\u0010¸\u0001\u001a\u00020l2\b\u0010³\u0001\u001a\u00030±\u00012\b\u0010¹\u0001\u001a\u00030º\u0001H\u0002J\t\u0010»\u0001\u001a\u00020lH\u0002J\u0013\u0010¼\u0001\u001a\u00020l2\b\u0010½\u0001\u001a\u00030¾\u0001H\u0002J\t\u0010¿\u0001\u001a\u00020lH\u0002J\t\u0010À\u0001\u001a\u00020lH\u0002J\t\u0010Á\u0001\u001a\u00020lH\u0002J\t\u0010Â\u0001\u001a\u00020lH\u0002J\t\u0010Ã\u0001\u001a\u00020lH\u0002J\u0013\u0010Ä\u0001\u001a\u00020l2\b\u0010°\u0001\u001a\u00030±\u0001H\u0002J\t\u0010Å\u0001\u001a\u00020lH\u0002J\u0012\u0010Æ\u0001\u001a\u00020l2\u0007\u0010Ç\u0001\u001a\u00020\u0012H\u0002J\t\u0010È\u0001\u001a\u00020lH\u0002J\t\u0010É\u0001\u001a\u00020lH\u0002J\t\u0010Ê\u0001\u001a\u00020lH\u0002J\t\u0010Ë\u0001\u001a\u00020lH\u0002J\t\u0010Ì\u0001\u001a\u00020lH\u0002J\t\u0010Í\u0001\u001a\u00020lH\u0002J\u0013\u0010Î\u0001\u001a\u00020l2\b\u0010Ï\u0001\u001a\u00030Ð\u0001H\u0002J\u001c\u0010Ñ\u0001\u001a\u00020l2\b\u0010Ò\u0001\u001a\u00030Ó\u00012\u0007\u0010Ô\u0001\u001a\u00020\u0015H\u0002J\"\u0010Õ\u0001\u001a\u00020l2\u000e\u0010Ö\u0001\u001a\t\u0012\u0005\u0012\u00030×\u00010\u000b2\u0007\u0010Ô\u0001\u001a\u00020\u0015H\u0002J\u001c\u0010Ø\u0001\u001a\u00020l2\b\u0010Ù\u0001\u001a\u00030Ú\u00012\u0007\u0010Ô\u0001\u001a\u00020\u0015H\u0002J\"\u0010Û\u0001\u001a\u00020l2\u000e\u0010Ö\u0001\u001a\t\u0012\u0005\u0012\u00030×\u00010\u000b2\u0007\u0010Ô\u0001\u001a\u00020\u0015H\u0002J\u001c\u0010Ü\u0001\u001a\u00020l2\b\u0010Ù\u0001\u001a\u00030Ú\u00012\u0007\u0010Ô\u0001\u001a\u00020\u0015H\u0002J)\u0010Ý\u0001\u001a\u00020l2\u000e\u0010Ö\u0001\u001a\t\u0012\u0005\u0012\u00030×\u00010\u000b2\u0007\u0010Ô\u0001\u001a\u00020\u0015H\u0082@¢\u0006\u0003\u0010Þ\u0001J#\u0010ß\u0001\u001a\u00020l2\b\u0010Ù\u0001\u001a\u00030Ú\u00012\u0007\u0010Ô\u0001\u001a\u00020\u0015H\u0082@¢\u0006\u0003\u0010à\u0001J\u0018\u0010á\u0001\u001a\u00020l2\r\u0010â\u0001\u001a\b\u0012\u0004\u0012\u00020N0\u000bH\u0002J*\u0010ã\u0001\u001a\u00020l2\r\u0010Ö\u0001\u001a\b\u0012\u0004\u0012\u00020N0\u000b2\u0007\u0010Ç\u0001\u001a\u00020\u00122\u0007\u0010\u008e\u0001\u001a\u00020\u0012H\u0002J\"\u0010ä\u0001\u001a\u00020l2\u0007\u0010\u008e\u0001\u001a\u00020\u00122\u0007\u0010Ç\u0001\u001a\u00020\u0012H\u0082@¢\u0006\u0003\u0010å\u0001J<\u0010æ\u0001\u001a\f\u0012\u0005\u0012\u00030è\u0001\u0018\u00010ç\u00012\u0007\u0010\u008e\u0001\u001a\u00020\u00122\u0007\u0010Ç\u0001\u001a\u00020\u00122\u000e\u0010é\u0001\u001a\t\u0012\u0005\u0012\u00030×\u00010\u000bH\u0082@¢\u0006\u0003\u0010ê\u0001J#\u0010ë\u0001\u001a\u00020l2\b\u0010Ï\u0001\u001a\u00030ì\u00012\u000e\u0010í\u0001\u001a\t\u0012\u0005\u0012\u00030×\u00010\u000bH\u0002J#\u0010î\u0001\u001a\u00020\u001e2\b\u0010Ï\u0001\u001a\u00030ì\u00012\u000e\u0010í\u0001\u001a\t\u0012\u0005\u0012\u00030×\u00010\u000bH\u0002J#\u0010ï\u0001\u001a\u00020l2\u000e\u0010ð\u0001\u001a\t\u0012\u0005\u0012\u00030ì\u00010\u000b2\b\u0010Ù\u0001\u001a\u00030Ú\u0001H\u0002J#\u0010ñ\u0001\u001a\u00020\u001e2\u000e\u0010ð\u0001\u001a\t\u0012\u0005\u0012\u00030ì\u00010\u000b2\b\u0010Ù\u0001\u001a\u00030Ú\u0001H\u0002J\t\u0010ò\u0001\u001a\u00020lH\u0002J\t\u0010ó\u0001\u001a\u00020lH\u0002J\u0013\u0010ô\u0001\u001a\u00020l2\b\u0010°\u0001\u001a\u00030±\u0001H\u0002J\u0013\u0010õ\u0001\u001a\u00020l2\b\u0010°\u0001\u001a\u00030±\u0001H\u0002J\t\u0010ö\u0001\u001a\u00020lH\u0002J\u0013\u0010÷\u0001\u001a\u00020l2\b\u0010ø\u0001\u001a\u00030ù\u0001H\u0002J\t\u0010ú\u0001\u001a\u00020lH\u0002J\t\u0010û\u0001\u001a\u00020lH\u0002J\t\u0010ü\u0001\u001a\u00020lH\u0002J\t\u0010ý\u0001\u001a\u00020lH\u0002J\u001a\u0010þ\u0001\u001a\u00020\u00122\u000f\u0010\u0093\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002J)\u0010ÿ\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000f\u0010\u0080\u0002\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0007\u0010\u0081\u0002\u001a\u00020\u001eH\u0002J\u0012\u0010\u0082\u0002\u001a\u00020l2\u0007\u0010\u0081\u0002\u001a\u00020\u001eH\u0002J\u001e\u0010\u0083\u0002\u001a\t\u0012\u0005\u0012\u00030\u0084\u00020\u000b2\f\u00101\u001a\b\u0012\u0004\u0012\u0002030\u000bH\u0002J*\u0010\u0085\u0002\u001a\t\u0012\u0005\u0012\u00030\u0084\u00020\u000b2\r\u0010\u0086\u0002\u001a\b\u0012\u0004\u0012\u0002030\u000b2\t\u0010\u0087\u0002\u001a\u0004\u0018\u00010\u001eH\u0002J\t\u0010\u0088\u0002\u001a\u00020lH\u0002J\t\u0010\u0089\u0002\u001a\u00020lH\u0002J\t\u0010\u008a\u0002\u001a\u00020lH\u0002J\u0014\u0010\u008b\u0002\u001a\u00020\u00152\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u001eH\u0002J\u0014\u0010\u008c\u0002\u001a\u00020\u00152\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u001eH\u0002J\u0012\u0010\u008d\u0002\u001a\u00020l2\u0007\u0010\u009a\u0001\u001a\u00020\u001eH\u0002J\u001c\u0010\u008e\u0002\u001a\u00020l2\b\u0010\u008f\u0002\u001a\u00030\u0090\u00022\u0007\u0010\u009a\u0001\u001a\u00020\u001eH\u0002J\u0012\u0010\u0091\u0002\u001a\u00020l2\u0007\u0010\u009a\u0001\u001a\u00020\u001eH\u0002J\t\u0010\u0092\u0002\u001a\u00020lH\u0002J\t\u0010\u0093\u0002\u001a\u00020lH\u0002J\u0012\u0010\u0094\u0002\u001a\u00020\u00152\u0007\u0010\u008b\u0001\u001a\u00020\tH\u0002J\u0012\u0010\u0095\u0002\u001a\u00020l2\u0007\u0010\u008b\u0001\u001a\u00020\tH\u0002J\t\u0010\u0096\u0002\u001a\u00020lH\u0002J\t\u0010\u0097\u0002\u001a\u00020lH\u0002J\t\u0010\u0098\u0002\u001a\u00020lH\u0002J\t\u0010\u0099\u0002\u001a\u00020lH\u0002J\t\u0010\u009a\u0002\u001a\u00020lH\u0002J\u0012\u0010\u009b\u0002\u001a\u00020l2\u0007\u0010\u009c\u0002\u001a\u00020\u0015H\u0002J'\u0010\u009d\u0002\u001a\u00020l2\t\u0010\u009e\u0002\u001a\u0004\u0018\u00010b2\u000b\b\u0002\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0003\u0010 \u0002J\u0012\u0010¡\u0002\u001a\u00020l2\u0007\u0010¢\u0002\u001a\u00020\u0012H\u0002J\t\u0010£\u0002\u001a\u00020lH\u0014J\u0018\u0010¤\u0002\u001a\b\u0012\u0004\u0012\u00020N0\u000b2\u0007\u0010¥\u0002\u001a\u00020NH\u0002J\u001b\u0010¦\u0002\u001a\u00020l2\u0007\u0010¥\u0002\u001a\u00020N2\u0007\u0010Ç\u0001\u001a\u00020\u0012H\u0016J&\u0010§\u0002\u001a\u00020l2\u0007\u0010¥\u0002\u001a\u00020N2\u0007\u0010Ç\u0001\u001a\u00020\u00122\t\u0010¨\u0002\u001a\u0004\u0018\u00010\u001eH\u0016J\u001b\u0010©\u0002\u001a\u00020l2\u0007\u0010¥\u0002\u001a\u00020N2\u0007\u0010Ç\u0001\u001a\u00020\u0012H\u0016J\u001b\u0010ª\u0002\u001a\u00020l2\u0007\u0010¥\u0002\u001a\u00020N2\u0007\u0010Ç\u0001\u001a\u00020\u0012H\u0016J\u001b\u0010«\u0002\u001a\u00020l2\u0007\u0010¥\u0002\u001a\u00020N2\u0007\u0010Ç\u0001\u001a\u00020\u0012H\u0016J$\u0010¬\u0002\u001a\u00020l2\u0007\u0010¥\u0002\u001a\u00020N2\u0007\u0010Ç\u0001\u001a\u00020\u00122\u0007\u0010\u00ad\u0002\u001a\u00020\u0015H\u0016J\u001b\u0010®\u0002\u001a\u00020l2\u0007\u0010¥\u0002\u001a\u00020N2\u0007\u0010Ç\u0001\u001a\u00020\u0012H\u0016J\u001b\u0010¯\u0002\u001a\u00020l2\u0007\u0010¥\u0002\u001a\u00020N2\u0007\u0010Ç\u0001\u001a\u00020\u0012H\u0016J\u001b\u0010°\u0002\u001a\u00020l2\u0007\u0010¥\u0002\u001a\u00020N2\u0007\u0010±\u0002\u001a\u00020\u001eH\u0016J\u001b\u0010²\u0002\u001a\u00020l2\u0007\u0010¥\u0002\u001a\u00020N2\u0007\u0010Ç\u0001\u001a\u00020\u0012H\u0016J)\u0010¶\u0002\u001a\u00020l2\u000b\b\u0002\u0010¥\u0002\u001a\u0004\u0018\u00010N2\u000b\b\u0002\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0003\u0010·\u0002J\t\u0010¸\u0002\u001a\u00020lH\u0002J\u0012\u0010¹\u0002\u001a\u00020l2\u0007\u0010º\u0002\u001a\u00020\u0015H\u0002J\u001b\u0010»\u0002\u001a\u00020l2\u0007\u0010¥\u0002\u001a\u00020N2\u0007\u0010Ç\u0001\u001a\u00020\u0012H\u0002J\u0012\u0010¼\u0002\u001a\u00020\u00152\u0007\u0010¥\u0002\u001a\u00020NH\u0002J\u0012\u0010½\u0002\u001a\u00020\u00152\u0007\u0010¥\u0002\u001a\u00020NH\u0002J\u0016\u0010¾\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020N0¿\u0002H\u0002J\t\u0010Á\u0002\u001a\u00020lH\u0002J\t\u0010Â\u0002\u001a\u00020lH\u0002J\t\u0010Ã\u0002\u001a\u00020lH\u0002J\t\u0010Ä\u0002\u001a\u00020lH\u0002J\t\u0010Å\u0002\u001a\u00020lH\u0002J\u0007\u0010Æ\u0002\u001a\u00020lJ\u0007\u0010Ç\u0002\u001a\u00020lJ\t\u0010È\u0002\u001a\u00020lH\u0002J\t\u0010É\u0002\u001a\u00020lH\u0002J\u0014\u0010Ê\u0002\u001a\u00020l2\t\u0010Ë\u0002\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010Ì\u0002\u001a\u00020l2\u0007\u0010Í\u0002\u001a\u00020\u001eH\u0002J\n\u0010Î\u0002\u001a\u00030Ï\u0002H\u0002J\n\u0010Ð\u0002\u001a\u00030Ñ\u0002H\u0002J\u0013\u0010Ò\u0002\u001a\u00030µ\u00012\u0007\u0010Ó\u0002\u001a\u00020\u001eH\u0002J\u0012\u0010Ô\u0002\u001a\u00020\u00122\u0007\u0010Õ\u0002\u001a\u00020\u0012H\u0002J\u0012\u0010Ö\u0002\u001a\u00020l2\u0007\u0010×\u0002\u001a\u00020\u001eH\u0002J\u0012\u0010Ø\u0002\u001a\u00020l2\u0007\u0010Ù\u0002\u001a\u00020\u001eH\u0002J\u0012\u0010Ú\u0002\u001a\u00020l2\u0007\u0010×\u0002\u001a\u00020\u001eH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010$\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020302X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u0002050\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020N0MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010O\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010P\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u000e\u0010T\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010`\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010c\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020jX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010o\u001a\b\u0012\u0004\u0012\u00020q0pX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010r\u001a\b\u0012\u0004\u0012\u00020q0pX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010s\u001a\b\u0012\u0004\u0012\u00020q0pX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010t\u001a\b\u0012\u0004\u0012\u00020q0pX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010u\u001a\b\u0012\u0004\u0012\u00020q0pX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010w\u001a\b\u0012\u0004\u0012\u00020q0pX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010x\u001a\b\u0012\u0004\u0012\u00020q0pX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u009b\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010³\u0002\u001a\u00030´\u0002X\u0082\u0004¢\u0006\u0005\n\u0003\u0010µ\u0002R\u000f\u0010À\u0002\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Û\u0002"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckDetailsActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "Lcom/studiolaganne/lengendarylens/CreateDeckCallback;", "Lcom/studiolaganne/lengendarylens/GamesClickListener;", "Lcom/studiolaganne/lengendarylens/DeckCardMenuCallback;", "Lcom/studiolaganne/lengendarylens/OnComboClickListener;", "<init>", "()V", "currentDeck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "currentGroupedCards", "", "Lcom/studiolaganne/lengendarylens/MTCardGroup;", "currentLists", "Lcom/studiolaganne/lengendarylens/MTDeckLists;", "currentDeckPrivacy", "Lcom/studiolaganne/lengendarylens/MTDeckPrivacy;", "bracketRecalcDeckId", "", "Ljava/lang/Integer;", "privacyToolbarSetup", "", "shouldShowLoadMore", "loaded", "currentTabIndex", "combosLoaded", "allCompleteCombos", "Lcom/studiolaganne/lengendarylens/MTCombo;", "allPartialCombos", "combosFilterQuery", "", "completeCombosSortBy", "completeCombosSortAsc", "partialCombosSortBy", "partialCombosSortAsc", "completeCombosMaxCards", "partialCombosMaxCards", "partialCombosPageSize", "partialCombosPagesLoaded", "combosFilterRunnable", "Ljava/lang/Runnable;", "combosUiWired", "currentSortBy", "currentGroupBy", "currentSortDirection", "currentEditDialog", "Lcom/studiolaganne/lengendarylens/EditCardDialogFragment;", "mythicPlusBottomSheet", "Lcom/studiolaganne/lengendarylens/MythicPlusBottomSheetFragment;", "games", "", "Lcom/studiolaganne/lengendarylens/MTGame;", "matchups", "Lcom/studiolaganne/lengendarylens/MTMatchupStats;", "deckCardsAdapter", "Lcom/studiolaganne/lengendarylens/DeckCardsAdapter;", "currentDisplayMode", "Lcom/studiolaganne/lengendarylens/DeckDisplayMode;", "sideboardCardsAdapter", "maybeboardCardsAdapter", "sideboardExpanded", "maybeboardExpanded", "formatsForFilter", "Lcom/studiolaganne/lengendarylens/MTFormat;", "filterDefinition", "Lcom/studiolaganne/lengendarylens/FilterDefinition;", "filterActive", "scrollStoppedRunnable", "handler", "Landroid/os/Handler;", "addButtonHidden", "lastScrollY", "ignoreCollection", "ignorePrintings", "ignoreBasicLands", "selectionMode", "selectedCards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "selectionLockedListId", "intentDeckId", "otherUserId", "isOtherUserDeck", "()Z", "isDuplicatedDeck", "deckOwnerUser", "Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "responseUser", "errorPopupManager", "Lcom/studiolaganne/lengendarylens/DeckErrorPopupManager;", "recalcValuesRotationAnimator", "Landroid/animation/ObjectAnimator;", "isDeckValuesRecalcInProgress", "smartDeckGlowAnimator", "isSmartDeck", "lastLoadedPlaymatUrl", "idCardFetchedForDeckId", "deckIdCardResponse", "Lcom/studiolaganne/lengendarylens/MTDeckIdCardResponse;", "idCardGaugesAnimatedForDeckId", "deckChangedWhileMythicPlusOpen", "cardPickerBottomSheet", "Lcom/studiolaganne/lengendarylens/MTCardPickerBottomSheetFragment;", "lastCardPickerQuery", "showLegacyAddButton", "paywallActivityLauncher", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityLauncher;", "showPaywallInfo", "", "carousel", "launchPaywall", "allPrintsActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "scanActivityLauncher", "searchActivityLauncher", "pickCardLauncher", "cardActivityLauncher", "onGameItemExpanded", "setDetailsLauncher", "gameDetailsLauncher", "onSetClicked", "set", "Lcom/studiolaganne/lengendarylens/MTSet;", "subgames", "onGameClicked", "game", "onComboClicked", "combo", "launchComboCardActivity", "cardList", "onComboOpenInSpellbook", "onLoadMoreGamesClicked", "onPublishGameClicked", "onUnpublishGameClicked", "onDeleteGameClicked", "onDeckCreated", "decks", "onDeckEdited", "deck", "onGhostDeckCreated", "onDeckCreatedForUser", "userId", "updateFilter", "showFilterBottomSheet", "updateDeck", "setupCardsAdapter", "groupedCards", "setupSideboardCards", "setupMaybeboardCards", "shareFile", "file", "Ljava/io/File;", "downloadAndShareFile", "url", "lastKnownDecksVersion", "onResume", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupManaCurveChart", "setupManaValueStats", "configureManaCurveChart", "chart", "Lcom/github/mikephil/charting/charts/CombinedChart;", "manaCurve", "Lcom/studiolaganne/lengendarylens/MTManaCurveEntry;", "setupManaProduction", "adjustManaProductionRecyclerViewHeight", "setupSeeTokensTextView", "updateSeeTokensTextViewVisibility", "setupDisplayModeToggle", "cycleDisplayMode", "updateDisplayModeIcon", "setupSortAndGroupButtons", "showDeckSettingsMenu", "anchor", "Landroid/view/View;", "findAllTextViews", ViewHierarchyConstants.VIEW_KEY, "textViews", "Landroid/widget/TextView;", "showSortByPopupMenu", "setupErrorPopupManager", "updateDeckValuesDialogView", "values", "Lcom/studiolaganne/lengendarylens/MTDeckValues;", "showDeckValuesPopup", "showSharedStatsDialog", "sharedStats", "Lcom/studiolaganne/lengendarylens/MTSharedStats;", "setupSideboardAndMaybeboard", "toggleSideboardExpansion", "toggleMaybeboardExpansion", "updateSideboardVisibility", "updateMaybeboardVisibility", "showGroupByPopupMenu", "refreshDeckCards", "refreshCurrentList", "listId", "showUpdateToCheapestDialog", "showLoadingOverlay", "hideLoadingOverlay", "hideAddButton", "showAddButton", "showImportDeckDialog", "handleDeckImport", "result", "Lcom/studiolaganne/lengendarylens/DeckImportResult;", "handleCsvDeckImport", "inputStream", "Ljava/io/InputStream;", "replaceAll", "showDeckImportConfirmation", "cards", "Lcom/studiolaganne/lengendarylens/ParsedCard;", "showDeckImportConfirmationWithSections", "parsedDeckList", "Lcom/studiolaganne/lengendarylens/ParsedDeckList;", "importCardsFromList", "importCardsFromListWithSections", "importCardsFromListAsync", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importCardsFromListWithSectionsAsync", "(Lcom/studiolaganne/lengendarylens/ParsedDeckList;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addScannedCardsToDeck", "scannedCards", "addCardsToList", "deleteAllCardsFromList", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addCardsToListSync", "Lretrofit2/Response;", "Lcom/studiolaganne/lengendarylens/MTCardListResponse;", "parsedCards", "(IILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showDeckImportResults", "Lcom/studiolaganne/lengendarylens/MTAddCardsResult;", "originalCards", "buildDeckImportResultMessage", "showDeckImportResultsWithSections", "results", "buildDeckImportResultMessageWithSections", "adjustRecyclerViewHeight", "wireCombosFilterAndSort", "showCompleteCombosSortPopup", "showPartialCombosSortPopup", "refreshCombosDisplay", "adjustCombosRecyclerViewHeight", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adjustCardsRecyclerViewHeight", "adjustMatchupsRecyclerViewHeight", "adjustSideboardRecyclerViewHeight", "adjustMaybeboardRecyclerViewHeight", "calculateCardCount", "filterGroupedCardsByName", "groups", SearchIntents.EXTRA_QUERY, "applyDeckCardsNameFilter", "groupGamesWithSeparators", "Lcom/studiolaganne/lengendarylens/GameItemHolder;", "groupNewGamesWithSeparators", "newGames", "lastExistingGameTimestamp", "updateDeckBottomBarUnknown", "updateBottomBar", "onDeckListModified", "isValidDeckUrl", "isMoxfieldUrl", "handleManualSync", "showExternalDeckSyncConfirmation", "syncResponse", "Lcom/studiolaganne/lengendarylens/MTGetExternalDeckResponse;", "applyExternalDeckSync", "updateUI", "updateAddButtonForSmartDeck", "computeIsSmartDeck", "showSmartDeckTeaser", "showConvertSmartDeckDialog", "showLegacyAddPanel", "showMythicPlusPanel", "clearSmartDeckEffects", "setupSmartDeckEffects", "fetchDeckIdCardIfNeeded", "force", "applyDeckIdCardScoresUi", "response", "animationDeckId", "(Lcom/studiolaganne/lengendarylens/MTDeckIdCardResponse;Ljava/lang/Integer;)V", "openIdCardDetails", "tab", "onDestroy", "buildCardListForCollectionStatus", "card", "onDeckCardCollectionStatus", "onDeckCardOpen", "groupType", "onDeckCardMove", "onDeckCardEdit", "onDeckCardDelete", "onDeckCardSetCompanion", "setAsCompanion", "onDeckCardCommanderColorClick", "onDeckCardEvaluate", "onDeckCardFindSimilar", "mode", "onDeckCardSelect", "selectionBackCallback", "com/studiolaganne/lengendarylens/DeckDetailsActivity$selectionBackCallback$1", "Lcom/studiolaganne/lengendarylens/DeckDetailsActivity$selectionBackCallback$1;", "enterSelectionMode", "(Lcom/studiolaganne/lengendarylens/MTFullCard;Ljava/lang/Integer;)V", "exitSelectionMode", "propagateSelectionMode", "enabled", "toggleCardSelection", "isCardSelected", "hasSpecialFlag", "filterSelectedCardsForAction", "", "selectionToolbarWired", "wireSelectionToolbar", "updateSelectionCountText", "selectAllCardsFromLockedList", "bulkMoveSelectedCards", "bulkDeleteSelectedCards", "activateDeckChanges", "duplicateDeck", "setupDeckOwnerLayout", "setupPrivacyToolbar", "updatePrivacyToolbar", "privacy", "updateDeckPrivacy", "newType", "buildDescriptionDialog", "Landroid/app/Dialog;", "buildDescriptionDialogRoot", "Landroid/widget/LinearLayout;", "buildDescriptionTitle", "text", "dp", "value", "showDescriptionViewDialog", "description", "showDescriptionEditDialog", "currentDescription", "submitDescription", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckDetailsActivity extends BaseActivity implements CreateDeckCallback, GamesClickListener, DeckCardMenuCallback, OnComboClickListener {
    public static final int $stable = 8;
    private boolean addButtonHidden;
    private Integer bracketRecalcDeckId;
    private MTCardPickerBottomSheetFragment cardPickerBottomSheet;
    private Runnable combosFilterRunnable;
    private boolean combosLoaded;
    private boolean combosUiWired;
    private Integer completeCombosMaxCards;
    private boolean completeCombosSortAsc;
    private MTDeck currentDeck;
    private MTDeckPrivacy currentDeckPrivacy;
    private EditCardDialogFragment currentEditDialog;
    private List<MTCardGroup> currentGroupedCards;
    private MTDeckLists currentLists;
    private int currentTabIndex;
    private DeckCardsAdapter deckCardsAdapter;
    private boolean deckChangedWhileMythicPlusOpen;
    private MTDeckIdCardResponse deckIdCardResponse;
    private MTPrivacyUser deckOwnerUser;
    private DeckErrorPopupManager errorPopupManager;
    private boolean filterActive;
    private Integer idCardFetchedForDeckId;
    private Integer idCardGaugesAnimatedForDeckId;
    private boolean ignoreCollection;
    private boolean ignorePrintings;
    private boolean isDeckValuesRecalcInProgress;
    private boolean isDuplicatedDeck;
    private boolean isSmartDeck;
    private int lastKnownDecksVersion;
    private String lastLoadedPlaymatUrl;
    private int lastScrollY;
    private boolean loaded;
    private DeckCardsAdapter maybeboardCardsAdapter;
    private boolean maybeboardExpanded;
    private MythicPlusBottomSheetFragment mythicPlusBottomSheet;
    private Integer partialCombosMaxCards;
    private boolean partialCombosSortAsc;
    private boolean privacyToolbarSetup;
    private ObjectAnimator recalcValuesRotationAnimator;
    private MTPrivacyUser responseUser;
    private Runnable scrollStoppedRunnable;
    private Integer selectionLockedListId;
    private boolean selectionMode;
    private boolean selectionToolbarWired;
    private boolean shouldShowLoadMore;
    private boolean showLegacyAddButton;
    private DeckCardsAdapter sideboardCardsAdapter;
    private boolean sideboardExpanded;
    private ObjectAnimator smartDeckGlowAnimator;
    private List<MTCombo> allCompleteCombos = CollectionsKt.emptyList();
    private List<MTCombo> allPartialCombos = CollectionsKt.emptyList();
    private String combosFilterQuery = "";
    private String completeCombosSortBy = "popularity";
    private String partialCombosSortBy = "popularity";
    private int partialCombosPageSize = 20;
    private int partialCombosPagesLoaded = 1;
    private String currentSortBy = "name";
    private String currentGroupBy = "type";
    private String currentSortDirection = "asc";
    private List<MTGame> games = new ArrayList();
    private List<MTMatchupStats> matchups = new ArrayList();
    private DeckDisplayMode currentDisplayMode = DeckDisplayMode.LIST;
    private List<MTFormat> formatsForFilter = CollectionsKt.emptyList();
    private FilterDefinition filterDefinition = new FilterDefinition(null, null, null, null, null, null, 63, null);
    private final Handler handler = new Handler(Looper.getMainLooper());
    private boolean ignoreBasicLands = true;
    private final Map<Integer, MTFullCard> selectedCards = new LinkedHashMap();
    private int intentDeckId = -1;
    private int otherUserId = -1;
    private String lastCardPickerQuery = "";
    private PaywallActivityLauncher paywallActivityLauncher = new PaywallActivityLauncher(this, new PaywallResultHandler() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$paywallActivityLauncher$1
        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(PaywallResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if ((result instanceof PaywallResult.Purchased) || (result instanceof PaywallResult.Restored)) {
                this.this$0.updateDeck();
            } else {
                if (result instanceof PaywallResult.Cancelled) {
                    return;
                }
                boolean z = result instanceof PaywallResult.Error;
            }
        }
    });
    private final ActivityResultLauncher<Intent> allPrintsActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda113
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            DeckDetailsActivity.allPrintsActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });
    private final ActivityResultLauncher<Intent> scanActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda114
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            DeckDetailsActivity.scanActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });
    private final ActivityResultLauncher<Intent> searchActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda116
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            DeckDetailsActivity.searchActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });
    private final ActivityResultLauncher<Intent> pickCardLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda117
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            DeckDetailsActivity.pickCardLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });
    private final ActivityResultLauncher<Intent> cardActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda118
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            Intrinsics.checkNotNullParameter((ActivityResult) obj, "result");
        }
    });
    private final ActivityResultLauncher<Intent> setDetailsLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda119
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            DeckDetailsActivity.setDetailsLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });
    private final ActivityResultLauncher<Intent> gameDetailsLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda120
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            DeckDetailsActivity.gameDetailsLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });
    private final DeckDetailsActivity$selectionBackCallback$1 selectionBackCallback = new OnBackPressedCallback() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$selectionBackCallback$1
        {
            super(false);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            this.this$0.exitSelectionMode();
        }
    };

    /* JADX INFO: compiled from: DeckDetailsActivity.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;

        static {
            int[] iArr = new int[DeckDisplayMode.values().length];
            try {
                iArr[DeckDisplayMode.TWO_COLUMN_STACKS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeckDisplayMode.LIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeckDisplayMode.ONE_COLUMN_STACKS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BatchCollectionStatusSameAction.values().length];
            try {
                iArr2[BatchCollectionStatusSameAction.ADD_TO_COLLECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[BatchCollectionStatusSameAction.MAKE_PROXY.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[BatchCollectionStatusOwnAction.values().length];
            try {
                iArr3[BatchCollectionStatusOwnAction.GRAB_EXACT_MATCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[BatchCollectionStatusOwnAction.GRAB_PARTIAL_MATCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[BatchCollectionStatusDontOwnAction.values().length];
            try {
                iArr4[BatchCollectionStatusDontOwnAction.ADD_TO_COLLECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr4[BatchCollectionStatusDontOwnAction.MARK_PROXY.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[BatchCollectionStatusInitialChoice.values().length];
            try {
                iArr5[BatchCollectionStatusInitialChoice.SAME_ACTION_FOR_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr5[BatchCollectionStatusInitialChoice.COLLECTION_BASED_ACTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$4 = iArr5;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.DeckDetailsActivity$applyExternalDeckSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeckDetailsActivity.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/DeckDetailsActivity$applyExternalDeckSync$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTPutExternalDeckResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C11471 implements Callback<MTPutExternalDeckResponse> {
        final /* synthetic */ ConstraintLayout $overlay;

        C11471(ConstraintLayout constraintLayout) {
            this.$overlay = constraintLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$1$0$0(boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<MTPutExternalDeckResponse> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            if (DeckDetailsActivity.this.isFinishing() || DeckDetailsActivity.this.isDestroyed()) {
                return;
            }
            ConstraintLayout constraintLayout = this.$overlay;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
            Toast.makeText(deckDetailsActivity, deckDetailsActivity.getString(R.string.server_error), 0).show();
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<MTPutExternalDeckResponse> call, Response<MTPutExternalDeckResponse> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (DeckDetailsActivity.this.isFinishing() || DeckDetailsActivity.this.isDestroyed()) {
                return;
            }
            ConstraintLayout constraintLayout = this.$overlay;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            if (!response.isSuccessful()) {
                ResponseBody responseBodyErrorBody = response.errorBody();
                Boolean boolValueOf = null;
                String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
                if (strString != null) {
                    DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
                    MTResponse mTResponse = (MTResponse) new Gson().fromJson(strString, MTResponse.class);
                    if (mTResponse != null) {
                        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                        String string = deckDetailsActivity.getString(R.string.server_error);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
                        String string2 = deckDetailsActivity.getString(R.string.ok);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$applyExternalDeckSync$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DeckDetailsActivity.C11471.onResponse$lambda$1$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                            }
                        });
                        FragmentManager supportFragmentManager = deckDetailsActivity.getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                        boolValueOf = Boolean.valueOf(positiveButton.show(supportFragmentManager, "mtapi_error_dialog"));
                    }
                    if (boolValueOf != null) {
                        return;
                    }
                }
                DeckDetailsActivity deckDetailsActivity2 = DeckDetailsActivity.this;
                Toast.makeText(deckDetailsActivity2, deckDetailsActivity2.getString(R.string.server_error), 0).show();
                Unit unit = Unit.INSTANCE;
                return;
            }
            MTPutExternalDeckResponse mTPutExternalDeckResponseBody = response.body();
            if (mTPutExternalDeckResponseBody != null) {
                DeckDetailsActivity deckDetailsActivity3 = DeckDetailsActivity.this;
                if (mTPutExternalDeckResponseBody.getSuccess()) {
                    MTExternalDeckResults results = mTPutExternalDeckResponseBody.getResults();
                    if (results != null) {
                        StringBuilder sb = new StringBuilder();
                        if (results.getAdded() > 0) {
                            sb.append(deckDetailsActivity3.getString(R.string.external_sync_added, new Object[]{Integer.valueOf(results.getAdded())}));
                        }
                        if (results.getAdded() > 0 && (results.getModified() > 0 || results.getRemoved() > 0 || results.getRestored() > 0)) {
                            sb.append("\n");
                        }
                        if (results.getModified() > 0) {
                            sb.append(deckDetailsActivity3.getString(R.string.external_sync_modified, new Object[]{Integer.valueOf(results.getModified())}));
                        }
                        if (results.getModified() > 0 && (results.getRemoved() > 0 || results.getRestored() > 0)) {
                            sb.append("\n");
                        }
                        if (results.getRemoved() > 0) {
                            sb.append(deckDetailsActivity3.getString(R.string.external_sync_removed, new Object[]{Integer.valueOf(results.getRemoved())}));
                        }
                        if (results.getRemoved() > 0 && results.getRestored() > 0) {
                            sb.append("\n");
                        }
                        if (results.getRestored() > 0) {
                            sb.append(deckDetailsActivity3.getString(R.string.external_sync_restored, new Object[]{Integer.valueOf(results.getRestored())}));
                        }
                        String string3 = sb.toString();
                        if (string3.length() > 0) {
                            Toast.makeText(deckDetailsActivity3, string3, 1).show();
                        }
                    }
                    deckDetailsActivity3.updateDeck();
                } else {
                    Toast.makeText(deckDetailsActivity3, deckDetailsActivity3.getString(R.string.external_sync_failed), 0).show();
                }
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.DeckDetailsActivity$downloadAndShareFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeckDetailsActivity.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/DeckDetailsActivity$downloadAndShareFile$1", "Lokhttp3/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "Lokio/IOException;", "onResponse", "response", "Lokhttp3/Response;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C11491 implements okhttp3.Callback {
        final /* synthetic */ ConstraintLayout $overlay;

        C11491(ConstraintLayout constraintLayout) {
            this.$overlay = constraintLayout;
        }

        static final void onFailure$lambda$0(DeckDetailsActivity deckDetailsActivity, ConstraintLayout constraintLayout) {
            if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
                return;
            }
            constraintLayout.setVisibility(8);
            Toast.makeText(deckDetailsActivity, R.string.download_error_body, 1).show();
        }

        static final void onResponse$lambda$1(DeckDetailsActivity deckDetailsActivity, ConstraintLayout constraintLayout) {
            if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
                return;
            }
            constraintLayout.setVisibility(8);
            Toast.makeText(deckDetailsActivity, R.string.download_error_body, 1).show();
        }

        static final void onResponse$lambda$3(DeckDetailsActivity deckDetailsActivity, File file) {
            if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
                return;
            }
            deckDetailsActivity.shareFile(file);
        }

        static final void onResponse$lambda$4(DeckDetailsActivity deckDetailsActivity, ConstraintLayout constraintLayout) {
            if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
                return;
            }
            constraintLayout.setVisibility(8);
            Toast.makeText(deckDetailsActivity, R.string.download_error_body, 1).show();
        }

        @Override // okhttp3.Callback
        public void onFailure(okhttp3.Call call, IOException e) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e, "e");
            if (DeckDetailsActivity.this.isDestroyed() || DeckDetailsActivity.this.isFinishing()) {
                return;
            }
            final DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
            final ConstraintLayout constraintLayout = this.$overlay;
            deckDetailsActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$downloadAndShareFile$1$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    DeckDetailsActivity.C11491.onFailure$lambda$0(deckDetailsActivity, constraintLayout);
                }
            });
        }

        @Override // okhttp3.Callback
        public void onResponse(okhttp3.Call call, okhttp3.Response response) {
            String name;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (DeckDetailsActivity.this.isDestroyed() || DeckDetailsActivity.this.isFinishing()) {
                return;
            }
            if (!response.isSuccessful()) {
                final DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
                final ConstraintLayout constraintLayout = this.$overlay;
                deckDetailsActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$downloadAndShareFile$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeckDetailsActivity.C11491.onResponse$lambda$1(deckDetailsActivity, constraintLayout);
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
                MTDeck mTDeck = DeckDetailsActivity.this.currentDeck;
                if (mTDeck == null || (name = mTDeck.getName()) == null) {
                    name = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                }
                final File file = new File(DeckDetailsActivity.this.getCacheDir(), "Deck_export_" + name + "_" + System.currentTimeMillis() + ".csv");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    ByteStreamsKt.copyTo$default(inputStreamByteStream, fileOutputStream, 0, 2, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    final DeckDetailsActivity deckDetailsActivity2 = DeckDetailsActivity.this;
                    deckDetailsActivity2.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$downloadAndShareFile$1$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            DeckDetailsActivity.C11491.onResponse$lambda$3(deckDetailsActivity2, file);
                        }
                    });
                } finally {
                }
            } catch (IOException unused) {
                final DeckDetailsActivity deckDetailsActivity3 = DeckDetailsActivity.this;
                final ConstraintLayout constraintLayout2 = this.$overlay;
                deckDetailsActivity3.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$downloadAndShareFile$1$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeckDetailsActivity.C11491.onResponse$lambda$4(deckDetailsActivity3, constraintLayout2);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.DeckDetailsActivity$handleCsvDeckImport$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeckDetailsActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.DeckDetailsActivity$handleCsvDeckImport$1", f = "DeckDetailsActivity.kt", i = {0, 0, 0, 1}, l = {4508, 4540}, m = "invokeSuspend", n = {"csvContent", "csvImporter", "parseResult", "e"}, s = {"L$0", "L$1", "L$2", "L$0"}, v = 1)
    static final class C11521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InputStream $inputStream;
        final /* synthetic */ boolean $replaceAll;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ DeckDetailsActivity this$0;

        /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.DeckDetailsActivity$handleCsvDeckImport$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: DeckDetailsActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.studiolaganne.lengendarylens.DeckDetailsActivity$handleCsvDeckImport$1$1", f = "DeckDetailsActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C02021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            final /* synthetic */ String $csvContent;
            final /* synthetic */ MTGCsvImporter.CsvParseResult $parseResult;
            final /* synthetic */ boolean $replaceAll;
            int label;
            final /* synthetic */ DeckDetailsActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02021(MTGCsvImporter.CsvParseResult csvParseResult, String str, DeckDetailsActivity deckDetailsActivity, boolean z, Continuation<? super C02021> continuation) {
                super(2, continuation);
                this.$parseResult = csvParseResult;
                this.$csvContent = str;
                this.this$0 = deckDetailsActivity;
                this.$replaceAll = z;
            }

            static final Unit invokeSuspend$lambda$0(DeckDetailsActivity deckDetailsActivity, boolean z, MTGCsvImporter.ImportResult importResult, Map map) {
                if (importResult.getContainers().isEmpty()) {
                    Toast.makeText(deckDetailsActivity, deckDetailsActivity.getString(R.string.no_cards_found_csv), 0).show();
                } else {
                    List<MTCardContainer> containers = importResult.getContainers();
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = containers.iterator();
                    while (it.hasNext()) {
                        List<MTFullCard> cards = ((MTCardContainer) it.next()).getCards();
                        if (cards == null) {
                            cards = CollectionsKt.emptyList();
                        }
                        CollectionsKt.addAll(arrayList, cards);
                    }
                    ArrayList<MTFullCard> arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    for (MTFullCard mTFullCard : arrayList2) {
                        Integer quantity = mTFullCard.getQuantity();
                        int iIntValue = quantity != null ? quantity.intValue() : 1;
                        String name = mTFullCard.getName();
                        if (name == null) {
                            name = "";
                        }
                        arrayList3.add(new ParsedCard(iIntValue, name, mTFullCard.getSet_code(), mTFullCard.getCollector_number(), mTFullCard.getFinish(), null, null, 64, null));
                    }
                    deckDetailsActivity.showDeckImportConfirmation(arrayList3, z);
                }
                return Unit.INSTANCE;
            }

            static final Unit invokeSuspend$lambda$1(DeckDetailsActivity deckDetailsActivity) {
                Toast.makeText(deckDetailsActivity, deckDetailsActivity.getString(R.string.import_canceled), 0).show();
                return Unit.INSTANCE;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02021(this.$parseResult, this.$csvContent, this.this$0, this.$replaceAll, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
                return ((C02021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                CsvPreviewDialogFragment.Builder csvContent = new CsvPreviewDialogFragment.Builder().setParseResult(this.$parseResult).setCsvContent(this.$csvContent);
                final DeckDetailsActivity deckDetailsActivity = this.this$0;
                final boolean z = this.$replaceAll;
                CsvPreviewDialogFragment.Builder onContinue = csvContent.setOnContinue(new Function2() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$handleCsvDeckImport$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return DeckDetailsActivity.C11521.C02021.invokeSuspend$lambda$0(deckDetailsActivity, z, (MTGCsvImporter.ImportResult) obj2, (Map) obj3);
                    }
                });
                final DeckDetailsActivity deckDetailsActivity2 = this.this$0;
                CsvPreviewDialogFragment.Builder onCancel = onContinue.setOnCancel(new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$handleCsvDeckImport$1$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckDetailsActivity.C11521.C02021.invokeSuspend$lambda$1(deckDetailsActivity2);
                    }
                });
                FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                return Boxing.boxBoolean(onCancel.show(supportFragmentManager, CsvPreviewDialogFragment.TAG));
            }
        }

        /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.DeckDetailsActivity$handleCsvDeckImport$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: DeckDetailsActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.studiolaganne.lengendarylens.DeckDetailsActivity$handleCsvDeckImport$1$2", f = "DeckDetailsActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            int label;
            final /* synthetic */ DeckDetailsActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DeckDetailsActivity deckDetailsActivity, Exception exc, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = deckDetailsActivity;
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
                Toast.makeText(this.this$0, "Import error: " + this.$e.getMessage(), 0).show();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11521(InputStream inputStream, DeckDetailsActivity deckDetailsActivity, boolean z, Continuation<? super C11521> continuation) {
            super(2, continuation);
            this.$inputStream = inputStream;
            this.this$0 = deckDetailsActivity;
            this.$replaceAll = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C11521(this.$inputStream, this.this$0, this.$replaceAll, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0092, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.studiolaganne.lengendarylens.DeckDetailsActivity.C11521.C02021(r7, r8, r12.this$0, r12.$replaceAll, null), r12) == r1) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00c1, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.studiolaganne.lengendarylens.DeckDetailsActivity.C11521.AnonymousClass2(r12.this$0, r0, null), r12) != r1) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00c3, code lost:
        
            return r1;
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

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.DeckDetailsActivity$handleManualSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeckDetailsActivity.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/DeckDetailsActivity$handleManualSync$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTGetExternalDeckResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C11531 implements Callback<MTGetExternalDeckResponse> {
        final /* synthetic */ ConstraintLayout $overlay;
        final /* synthetic */ String $url;

        C11531(ConstraintLayout constraintLayout, String str) {
            this.$overlay = constraintLayout;
            this.$url = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$1$0$0(boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<MTGetExternalDeckResponse> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            if (DeckDetailsActivity.this.isFinishing() || DeckDetailsActivity.this.isDestroyed()) {
                return;
            }
            ConstraintLayout constraintLayout = this.$overlay;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
            Toast.makeText(deckDetailsActivity, deckDetailsActivity.getString(R.string.server_error), 0).show();
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<MTGetExternalDeckResponse> call, Response<MTGetExternalDeckResponse> response) {
            List<MTDeckCardToModify> toModify;
            List<MTDeckCardToRemove> toRemove;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (DeckDetailsActivity.this.isFinishing() || DeckDetailsActivity.this.isDestroyed()) {
                return;
            }
            ConstraintLayout constraintLayout = this.$overlay;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            if (response.isSuccessful()) {
                MTGetExternalDeckResponse mTGetExternalDeckResponseBody = response.body();
                if (mTGetExternalDeckResponseBody != null) {
                    DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
                    String str = this.$url;
                    if ((mTGetExternalDeckResponseBody.getToAdd() == null || !(!r1.isEmpty())) && (((toModify = mTGetExternalDeckResponseBody.getToModify()) == null || !(!toModify.isEmpty())) && ((toRemove = mTGetExternalDeckResponseBody.getToRemove()) == null || !(!toRemove.isEmpty())))) {
                        Toast.makeText(deckDetailsActivity, deckDetailsActivity.getString(R.string.external_sync_no_changes_to_sync), 0).show();
                    } else {
                        deckDetailsActivity.showExternalDeckSyncConfirmation(mTGetExternalDeckResponseBody, str);
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                return;
            }
            ResponseBody responseBodyErrorBody = response.errorBody();
            Boolean boolValueOf = null;
            String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
            if (strString != null) {
                DeckDetailsActivity deckDetailsActivity2 = DeckDetailsActivity.this;
                MTResponse mTResponse = (MTResponse) new Gson().fromJson(strString, MTResponse.class);
                if (mTResponse != null) {
                    CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                    String string = deckDetailsActivity2.getString(R.string.server_error);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
                    String string2 = deckDetailsActivity2.getString(R.string.ok);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$handleManualSync$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DeckDetailsActivity.C11531.onResponse$lambda$1$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                        }
                    });
                    FragmentManager supportFragmentManager = deckDetailsActivity2.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                    boolValueOf = Boolean.valueOf(positiveButton.show(supportFragmentManager, "mtapi_error_dialog"));
                }
                if (boolValueOf != null) {
                    return;
                }
            }
            DeckDetailsActivity deckDetailsActivity3 = DeckDetailsActivity.this;
            Toast.makeText(deckDetailsActivity3, deckDetailsActivity3.getString(R.string.server_error), 0).show();
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.DeckDetailsActivity$importCardsFromList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeckDetailsActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.DeckDetailsActivity$importCardsFromList$1", f = "DeckDetailsActivity.kt", i = {}, l = {4616}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ParsedCard> $cards;
        final /* synthetic */ boolean $replaceAll;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11541(List<ParsedCard> list, boolean z, Continuation<? super C11541> continuation) {
            super(2, continuation);
            this.$cards = list;
            this.$replaceAll = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DeckDetailsActivity.this.new C11541(this.$cards, this.$replaceAll, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v11 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objImportCardsFromListAsync = DeckDetailsActivity.this.importCardsFromListAsync(this.$cards, this.$replaceAll, this);
                    this = objImportCardsFromListAsync;
                    if (objImportCardsFromListAsync == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this = this;
                }
            } catch (Exception e) {
                Log.e("DeckImport", "Import error: " + e.getMessage());
                DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
                Toast.makeText(deckDetailsActivity, deckDetailsActivity.getString(R.string.unable_to_import_cards), 0).show();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.DeckDetailsActivity$importCardsFromListAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeckDetailsActivity.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.DeckDetailsActivity", f = "DeckDetailsActivity.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {4659, 4663}, m = "importCardsFromListAsync", n = {"cards", "currentDeck", "listId", "prefs", "currentUser", "overlay", "replaceAll", "cards", "currentDeck", "listId", "prefs", "currentUser", "overlay", "replaceAll"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"}, v = 1)
    static final class C11551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C11551(Continuation<? super C11551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeckDetailsActivity.this.importCardsFromListAsync(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.DeckDetailsActivity$importCardsFromListWithSections$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeckDetailsActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.DeckDetailsActivity$importCardsFromListWithSections$1", f = "DeckDetailsActivity.kt", i = {}, l = {4628}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ParsedDeckList $parsedDeckList;
        final /* synthetic */ boolean $replaceAll;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11561(ParsedDeckList parsedDeckList, boolean z, Continuation<? super C11561> continuation) {
            super(2, continuation);
            this.$parsedDeckList = parsedDeckList;
            this.$replaceAll = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DeckDetailsActivity.this.new C11561(this.$parsedDeckList, this.$replaceAll, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v11 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objImportCardsFromListWithSectionsAsync = DeckDetailsActivity.this.importCardsFromListWithSectionsAsync(this.$parsedDeckList, this.$replaceAll, this);
                    this = objImportCardsFromListWithSectionsAsync;
                    if (objImportCardsFromListWithSectionsAsync == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this = this;
                }
            } catch (Exception e) {
                Log.e("DeckImport", "Import error: " + e.getMessage());
                DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
                Toast.makeText(deckDetailsActivity, deckDetailsActivity.getString(R.string.unable_to_import_cards), 0).show();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.DeckDetailsActivity$importCardsFromListWithSectionsAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeckDetailsActivity.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.DeckDetailsActivity", f = "DeckDetailsActivity.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {4731, 4732, 4741, 4773, 4799, 4829}, m = "importCardsFromListWithSectionsAsync", n = {"parsedDeckList", "allCards", "currentDeck", "mainListId", "sideboardListId", "maybeboardListId", "prefs", "currentUser", "overlay", "replaceAll", "parsedDeckList", "allCards", "currentDeck", "mainListId", "sideboardListId", "maybeboardListId", "prefs", "currentUser", "overlay", "replaceAll", "it", "$i$a$-let-DeckDetailsActivity$importCardsFromListWithSectionsAsync$2", "parsedDeckList", "allCards", "currentDeck", "mainListId", "sideboardListId", "maybeboardListId", "prefs", "currentUser", "overlay", "allResults", "allCards", "replaceAll", "parsedDeckList", "allCards", "currentDeck", "mainListId", "sideboardListId", "maybeboardListId", "prefs", "currentUser", "overlay", "allResults", "allCards", "replaceAll", "parsedDeckList", "allCards", "currentDeck", "mainListId", "sideboardListId", "maybeboardListId", "prefs", "currentUser", "overlay", "allResults", "allCards", "replaceAll", "parsedDeckList", "allCards", "currentDeck", "mainListId", "sideboardListId", "maybeboardListId", "prefs", "currentUser", "overlay", "allResults", "allCards", "replaceAll"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0"}, v = 1)
    static final class C11571 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C11571(Continuation<? super C11571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeckDetailsActivity.this.importCardsFromListWithSectionsAsync(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.DeckDetailsActivity$importCardsFromListWithSectionsAsync$6, reason: invalid class name */
    /* JADX INFO: compiled from: DeckDetailsActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.DeckDetailsActivity$importCardsFromListWithSectionsAsync$6", f = "DeckDetailsActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DeckDetailsActivity.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List list = DeckDetailsActivity.this.currentGroupedCards;
            if (list != null) {
                DeckDetailsActivity.this.setupCardsAdapter(list);
            }
            DeckDetailsActivity.this.onDeckListModified();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.DeckDetailsActivity$showLegacyAddPanel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeckDetailsActivity.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/studiolaganne/lengendarylens/DeckDetailsActivity$showLegacyAddPanel$1", "Lcom/studiolaganne/lengendarylens/MTCardPickerCallback;", "onCardSelected", "", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "onCardPickerClosed", "onQueryChanged", SearchIntents.EXTRA_QUERY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C11591 implements MTCardPickerCallback {
        C11591() {
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00f5  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        static final Unit onCardSelected$lambda$1(final DeckDetailsActivity deckDetailsActivity, MTFullCard mTFullCard, Integer num, Integer num2, String str, String str2, String str3, MTFullCard mTFullCard2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Integer num3, Double d) {
            final int iIntValue;
            String cardid;
            String lowerCase;
            String collector_number;
            String condition;
            Boolean altered;
            Boolean signed;
            Boolean missprint;
            Boolean proxy;
            String set_code;
            if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
                return Unit.INSTANCE;
            }
            int iIntValue2 = num != null ? num.intValue() : 1;
            MTEditCardBody mTEditCardBody = new MTEditCardBody(null, 1, null);
            mTEditCardBody.setCards(new MTEditCardActions(null, null, null, 7, null));
            if (iIntValue2 >= 1) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < iIntValue2; i++) {
                    MTFullCard mTFullCard3 = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                    if (mTFullCard2 == null || (cardid = mTFullCard2.getCardid()) == null) {
                        cardid = mTFullCard.getCardid();
                    }
                    mTFullCard3.setCardid(cardid);
                    mTFullCard3.setScryfallid(null);
                    if (mTFullCard2 == null || (set_code = mTFullCard2.getSet_code()) == null) {
                        String set_code2 = mTFullCard.getSet_code();
                        if (set_code2 != null) {
                            lowerCase = set_code2.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        } else {
                            lowerCase = null;
                        }
                    } else {
                        lowerCase = set_code.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        if (lowerCase == null) {
                        }
                    }
                    mTFullCard3.setSet_code(lowerCase);
                    if (mTFullCard2 == null || (collector_number = mTFullCard2.getCollector_number()) == null) {
                        collector_number = mTFullCard.getCollector_number();
                    }
                    mTFullCard3.setCollector_number(collector_number);
                    mTFullCard3.setLang(str == null ? mTFullCard.getLang() : str);
                    mTFullCard3.setFinish(str2 == null ? mTFullCard.getFinish() : str2);
                    if (str3 == null) {
                        condition = mTFullCard.getCondition();
                        if (condition == null) {
                            condition = GameUtils.CONDITION_NEAR_MINT;
                        }
                    } else {
                        condition = str3;
                    }
                    mTFullCard3.setCondition(condition);
                    if (bool == null) {
                        altered = mTFullCard.getAltered();
                        if (altered == null) {
                            altered = false;
                        }
                    } else {
                        altered = bool;
                    }
                    mTFullCard3.setAltered(altered);
                    if (bool2 == null) {
                        signed = mTFullCard.getSigned();
                        if (signed == null) {
                            signed = false;
                        }
                    } else {
                        signed = bool2;
                    }
                    mTFullCard3.setSigned(signed);
                    if (bool3 == null) {
                        missprint = mTFullCard.getMissprint();
                        if (missprint == null) {
                            missprint = false;
                        }
                    } else {
                        missprint = bool3;
                    }
                    mTFullCard3.setMissprint(missprint);
                    if (bool4 == null) {
                        proxy = mTFullCard.getProxy();
                        if (proxy == null) {
                            proxy = false;
                        }
                    } else {
                        proxy = bool4;
                    }
                    mTFullCard3.setProxy(proxy);
                    arrayList.add(mTFullCard3);
                }
                MTEditCardActions cards = mTEditCardBody.getCards();
                if (cards != null) {
                    cards.setAdded(arrayList);
                }
                MTUser currentUser = new PreferencesManager(deckDetailsActivity).getCurrentUser();
                if (currentUser != null) {
                    final ConstraintLayout constraintLayout = (ConstraintLayout) deckDetailsActivity.findViewById(R.id.overlay);
                    if (constraintLayout != null) {
                        constraintLayout.setVisibility(0);
                    }
                    if (num3 != null) {
                        iIntValue = num3.intValue();
                    } else {
                        MTDeck mTDeck = deckDetailsActivity.currentDeck;
                        Integer listid = mTDeck != null ? mTDeck.getListid() : null;
                        iIntValue = listid != null ? listid.intValue() : -1;
                    }
                    MTApiKt.getMtApi().editCardsFromList(currentUser.getId(), iIntValue, null, null, deckDetailsActivity.currentGroupBy, deckDetailsActivity.currentSortBy, deckDetailsActivity.currentSortDirection, true, Boolean.valueOf(deckDetailsActivity.ignoreCollection), Boolean.valueOf(deckDetailsActivity.ignoreBasicLands), Boolean.valueOf(deckDetailsActivity.ignorePrintings), mTEditCardBody).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$showLegacyAddPanel$1$onCardSelected$dialog$2$1$1
                        @Override // retrofit2.Callback
                        public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(t, "t");
                            constraintLayout.setVisibility(8);
                            Toast.makeText(deckDetailsActivity, R.string.error_adding_card, 0).show();
                        }

                        @Override // retrofit2.Callback
                        public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                            MTCardContainer maybeboard;
                            MTCardContainer sideboard;
                            MTCardContainer main;
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(response, "response");
                            if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
                                return;
                            }
                            if (!response.isSuccessful()) {
                                constraintLayout.setVisibility(8);
                                Toast.makeText(deckDetailsActivity, R.string.error_adding_card, 0).show();
                                return;
                            }
                            MTCardListResponse mTCardListResponseBody = response.body();
                            MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                            if (list != null) {
                                int i2 = iIntValue;
                                DeckDetailsActivity deckDetailsActivity2 = deckDetailsActivity;
                                MTDeckLists mTDeckLists = deckDetailsActivity2.currentLists;
                                if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || i2 != main.getId()) {
                                    MTDeckLists mTDeckLists2 = deckDetailsActivity2.currentLists;
                                    if (mTDeckLists2 == null || (sideboard = mTDeckLists2.getSideboard()) == null || i2 != sideboard.getId()) {
                                        MTDeckLists mTDeckLists3 = deckDetailsActivity2.currentLists;
                                        if (mTDeckLists3 != null && (maybeboard = mTDeckLists3.getMaybeboard()) != null && i2 == maybeboard.getId()) {
                                            MTDeckLists mTDeckLists4 = deckDetailsActivity2.currentLists;
                                            deckDetailsActivity2.currentLists = mTDeckLists4 != null ? MTDeckLists.copy$default(mTDeckLists4, null, null, list, 3, null) : null;
                                        }
                                    } else {
                                        MTDeckLists mTDeckLists5 = deckDetailsActivity2.currentLists;
                                        deckDetailsActivity2.currentLists = mTDeckLists5 != null ? MTDeckLists.copy$default(mTDeckLists5, null, list, null, 5, null) : null;
                                    }
                                } else {
                                    MTDeckLists mTDeckLists6 = deckDetailsActivity2.currentLists;
                                    deckDetailsActivity2.currentLists = mTDeckLists6 != null ? MTDeckLists.copy$default(mTDeckLists6, list, null, null, 6, null) : null;
                                    List<MTCardGroup> grouped_cards = list.getGrouped_cards();
                                    if (grouped_cards != null) {
                                        deckDetailsActivity2.currentGroupedCards = grouped_cards;
                                    }
                                }
                                List list2 = deckDetailsActivity2.currentGroupedCards;
                                if (list2 != null) {
                                    deckDetailsActivity2.setupCardsAdapter(list2);
                                }
                                deckDetailsActivity2.onDeckListModified();
                            }
                            constraintLayout.setVisibility(8);
                        }
                    });
                }
            }
            return Unit.INSTANCE;
        }

        @Override // com.studiolaganne.lengendarylens.MTCardPickerCallback
        public void onCardPickerClosed() {
        }

        @Override // com.studiolaganne.lengendarylens.MTCardPickerCallback
        public void onCardSelected(final MTFullCard card) {
            Dialog dialog;
            Intrinsics.checkNotNullParameter(card, "card");
            MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment = DeckDetailsActivity.this.cardPickerBottomSheet;
            if (mTCardPickerBottomSheetFragment != null && (dialog = mTCardPickerBottomSheetFragment.getDialog()) != null) {
                dialog.hide();
            }
            Log.d("CardPicker", "Selected: " + card.getName());
            EditCardDialogFragment.Builder deckMode = new EditCardDialogFragment.Builder().setCard(card).setAddMode(true).setDeckMode(true);
            MTDeck mTDeck = DeckDetailsActivity.this.currentDeck;
            if (mTDeck == null) {
                mTDeck = new MTDeck(0, 0, null, 0, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 2047, null);
            }
            EditCardDialogFragment.Builder onDismissListener = deckMode.setDeck(mTDeck).setAllPrintsLauncher(DeckDetailsActivity.this.allPrintsActivityLauncher).setOnDismissListener(new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$showLegacyAddPanel$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            });
            final DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
            EditCardDialogFragment editCardDialogFragmentBuild = onDismissListener.setOnEditClickedListener(new Function12() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$showLegacyAddPanel$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function12
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
                    return DeckDetailsActivity.C11591.onCardSelected$lambda$1(deckDetailsActivity, card, (Integer) obj, (Integer) obj2, (String) obj3, (String) obj4, (String) obj5, (MTFullCard) obj6, (Boolean) obj7, (Boolean) obj8, (Boolean) obj9, (Boolean) obj10, (Integer) obj11, (Double) obj12);
                }
            }).build();
            DeckDetailsActivity.this.currentEditDialog = editCardDialogFragmentBuild;
            editCardDialogFragmentBuild.show(DeckDetailsActivity.this.getSupportFragmentManager(), "edit_card_dialog");
        }

        @Override // com.studiolaganne.lengendarylens.MTCardPickerCallback
        public void onQueryChanged(String query) {
            Intrinsics.checkNotNullParameter(query, "query");
            DeckDetailsActivity.this.lastCardPickerQuery = query;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.DeckDetailsActivity$wireCombosFilterAndSort$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeckDetailsActivity.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/studiolaganne/lengendarylens/DeckDetailsActivity$wireCombosFilterAndSort$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C11631 implements TextWatcher {
        final /* synthetic */ ImageView $combosFilterClearButton;
        final /* synthetic */ EditText $combosFilterEditText;
        final /* synthetic */ DeckDetailsActivity this$0;

        C11631(ImageView imageView, DeckDetailsActivity deckDetailsActivity, EditText editText) {
            this.$combosFilterClearButton = imageView;
            this.this$0 = deckDetailsActivity;
            this.$combosFilterEditText = editText;
        }

        static final void afterTextChanged$lambda$1(DeckDetailsActivity deckDetailsActivity, EditText editText) {
            String string;
            String string2;
            Editable text = editText.getText();
            if (text == null || (string2 = text.toString()) == null || (string = StringsKt.trim((CharSequence) string2).toString()) == null) {
                string = "";
            }
            deckDetailsActivity.combosFilterQuery = string;
            deckDetailsActivity.partialCombosPagesLoaded = 1;
            deckDetailsActivity.refreshCombosDisplay();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            this.$combosFilterClearButton.setVisibility((s == null || s.length() <= 0) ? 8 : 0);
            Runnable runnable = this.this$0.combosFilterRunnable;
            if (runnable != null) {
                this.this$0.handler.removeCallbacks(runnable);
            }
            final DeckDetailsActivity deckDetailsActivity = this.this$0;
            final EditText editText = this.$combosFilterEditText;
            deckDetailsActivity.combosFilterRunnable = new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$wireCombosFilterAndSort$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DeckDetailsActivity.C11631.afterTextChanged$lambda$1(deckDetailsActivity, editText);
                }
            };
            Handler handler = this.this$0.handler;
            Runnable runnable2 = this.this$0.combosFilterRunnable;
            Intrinsics.checkNotNull(runnable2);
            handler.postDelayed(runnable2, 300L);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addCardsToList(final List<MTFullCard> cards, final int listId, int userId) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        List<MTFullCard> mutableList = CollectionsKt.toMutableList((Collection) cards);
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
        final ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        MTApiKt.getMtApi().addCardsToList(userId, listId, this.currentGroupBy, this.currentSortBy, this.currentSortDirection, Boolean.valueOf(this.ignoreCollection), Boolean.valueOf(this.ignoreBasicLands), Boolean.valueOf(this.ignorePrintings), new MTCardListBody(mutableList)).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity.addCardsToList.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (DeckDetailsActivity.this.isFinishing() || DeckDetailsActivity.this.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = constraintLayout;
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(8);
                }
                Toast.makeText(DeckDetailsActivity.this, R.string.error_adding_card, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                MTCardContainer maybeboard;
                MTCardContainer sideboard;
                MTCardContainer main;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (DeckDetailsActivity.this.isFinishing() || DeckDetailsActivity.this.isDestroyed()) {
                    return;
                }
                if (response.isSuccessful()) {
                    new PreferencesManager(DeckDetailsActivity.this).clearCurrentDeckScanList();
                    MTCardListResponse mTCardListResponseBody = response.body();
                    MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                    if (list != null) {
                        int i = listId;
                        DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
                        List<MTFullCard> list2 = cards;
                        MTDeckLists mTDeckLists = deckDetailsActivity.currentLists;
                        if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || i != main.getId()) {
                            MTDeckLists mTDeckLists2 = deckDetailsActivity.currentLists;
                            if (mTDeckLists2 == null || (sideboard = mTDeckLists2.getSideboard()) == null || i != sideboard.getId()) {
                                MTDeckLists mTDeckLists3 = deckDetailsActivity.currentLists;
                                if (mTDeckLists3 != null && (maybeboard = mTDeckLists3.getMaybeboard()) != null && i == maybeboard.getId()) {
                                    MTDeckLists mTDeckLists4 = deckDetailsActivity.currentLists;
                                    deckDetailsActivity.currentLists = mTDeckLists4 != null ? MTDeckLists.copy$default(mTDeckLists4, null, null, list, 3, null) : null;
                                }
                            } else {
                                MTDeckLists mTDeckLists5 = deckDetailsActivity.currentLists;
                                deckDetailsActivity.currentLists = mTDeckLists5 != null ? MTDeckLists.copy$default(mTDeckLists5, null, list, null, 5, null) : null;
                            }
                        } else {
                            MTDeckLists mTDeckLists6 = deckDetailsActivity.currentLists;
                            deckDetailsActivity.currentLists = mTDeckLists6 != null ? MTDeckLists.copy$default(mTDeckLists6, list, null, null, 6, null) : null;
                            List<MTCardGroup> grouped_cards = list.getGrouped_cards();
                            if (grouped_cards != null) {
                                deckDetailsActivity.currentGroupedCards = grouped_cards;
                            }
                        }
                        List list3 = deckDetailsActivity.currentGroupedCards;
                        if (list3 != null) {
                            deckDetailsActivity.setupCardsAdapter(list3);
                        }
                        deckDetailsActivity.onDeckListModified();
                        Iterator<T> it = list2.iterator();
                        int iIntValue = 0;
                        while (it.hasNext()) {
                            Integer quantity = ((MTFullCard) it.next()).getQuantity();
                            iIntValue += quantity != null ? quantity.intValue() : 1;
                        }
                        Toast.makeText(deckDetailsActivity, deckDetailsActivity.getString(R.string.cards_added_success, new Object[]{Integer.valueOf(iIntValue)}), 0).show();
                    }
                } else {
                    Toast.makeText(DeckDetailsActivity.this, R.string.error_adding_card, 0).show();
                }
                ConstraintLayout constraintLayout2 = constraintLayout;
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(8);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object addCardsToListSync(int i, int i2, List<ParsedCard> list, Continuation<? super Response<MTCardListResponse>> continuation) {
        Object lowerCase;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        List<ParsedCard> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (true) {
            lowerCase = null;
            if (!it.hasNext()) {
                break;
            }
            ParsedCard parsedCard = (ParsedCard) it.next();
            String setCode = parsedCard.getSetCode();
            if (setCode != null) {
                lowerCase = setCode.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            }
            String str = lowerCase;
            String collectorNumber = parsedCard.getCollectorNumber();
            int quantity = parsedCard.getQuantity();
            String cardName = parsedCard.getCardName();
            String finish = parsedCard.getFinish();
            if (finish == null) {
                finish = "nonfoil";
            }
            arrayList.add(new MTFullCard(null, Boxing.boxBoolean(false), null, null, null, collectorNumber, null, null, null, GameUtils.CONDITION_NEAR_MINT, null, null, null, null, null, null, null, null, null, null, finish, null, null, null, null, null, null, null, "en", null, null, null, null, null, null, null, Boxing.boxBoolean(false), cardName, null, null, null, null, null, null, null, null, Boxing.boxInt(quantity), null, null, str, null, null, Boxing.boxBoolean(false), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -269484579, -1196081, 127, null));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        MTDeck mTDeck = this.currentDeck;
        if (mTDeck != null) {
            DeckDetailsActivity deckDetailsActivity = this;
            Iterator<T> it2 = DecksDBHelper.INSTANCE.getInstance(deckDetailsActivity).getFormats().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (((MTFormat) next).getId() == mTDeck.getFormatid()) {
                    lowerCase = next;
                    break;
                }
            }
            MTFormat mTFormat = (MTFormat) lowerCase;
            if (mTFormat != null && mTFormat.getHascommander()) {
                String commander = mTDeck.getCommander();
                if (commander != null) {
                    Pair<String, Integer> pairExtractIdAndFace = DeckUtils.INSTANCE.extractIdAndFace(commander);
                    CardRecord cardLocal = GameUtils.INSTANCE.getInstance().getCardLocal(deckDetailsActivity, pairExtractIdAndFace.component1(), pairExtractIdAndFace.component2().intValue());
                    if (cardLocal != null) {
                        Boxing.boxBoolean(arrayList3.add(cardLocal.getTitle()));
                    }
                }
                String partner = mTDeck.getPartner();
                if (partner != null) {
                    Pair<String, Integer> pairExtractIdAndFace2 = DeckUtils.INSTANCE.extractIdAndFace(partner);
                    CardRecord cardLocal2 = GameUtils.INSTANCE.getInstance().getCardLocal(deckDetailsActivity, pairExtractIdAndFace2.component1(), pairExtractIdAndFace2.component2().intValue());
                    if (cardLocal2 != null) {
                        Boxing.boxBoolean(arrayList3.add(cardLocal2.getTitle()));
                    }
                }
            }
        }
        if (!arrayList3.isEmpty()) {
            ArrayList arrayList4 = new ArrayList();
            for (Object obj : arrayList2) {
                if (!CollectionsKt.contains(arrayList3, ((MTFullCard) obj).getName())) {
                    arrayList4.add(obj);
                }
            }
            arrayList2 = arrayList4;
        }
        MTApiKt.getMtApi().addCardsToList(i, i2, this.currentGroupBy, this.currentSortBy, this.currentSortDirection, Boxing.boxBoolean(this.ignoreCollection), Boxing.boxBoolean(this.ignoreBasicLands), Boxing.boxBoolean(this.ignorePrintings), new MTCardListBody(arrayList2)).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$addCardsToListSync$2$3
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Log.e("DeckImport", "Add cards error: " + t.getMessage());
                cancellableContinuationImpl2.resume((Response<MTCardListResponse>) null, new Function1<Throwable, Unit>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$addCardsToListSync$2$3$onFailure$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it3) {
                        Intrinsics.checkNotNullParameter(it3, "it");
                    }
                });
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                cancellableContinuationImpl2.resume(response, new Function1<Throwable, Unit>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$addCardsToListSync$2$3$onResponse$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it3) {
                        Intrinsics.checkNotNullParameter(it3, "it");
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

    private final void addScannedCardsToDeck(final List<MTFullCard> scannedCards) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        int iIntValue = 0;
        if (this.currentDeck == null) {
            Toast.makeText(this, getString(R.string.no_deck_loaded), 0).show();
            return;
        }
        DeckDetailsActivity deckDetailsActivity = this;
        final MTUser currentUser = new PreferencesManager(deckDetailsActivity).getCurrentUser();
        if (currentUser == null) {
            Toast.makeText(deckDetailsActivity, getString(R.string.error_adding_card), 0).show();
            return;
        }
        Iterator<T> it = scannedCards.iterator();
        while (it.hasNext()) {
            Integer quantity = ((MTFullCard) it.next()).getQuantity();
            iIntValue += quantity != null ? quantity.intValue() : 1;
        }
        DeckMoveCardDialogFragment.Builder mode = new DeckMoveCardDialogFragment.Builder().setMode(DeckCardDialogMode.ADD);
        MTDeckLists mTDeckLists = this.currentLists;
        if (mTDeckLists == null) {
            mTDeckLists = new MTDeckLists(null, null, null, 7, null);
        }
        mode.setCurrentLists(mTDeckLists).setCardCount(iIntValue).setListener(new DeckMoveCardDialogListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$addScannedCardsToDeck$dialog$1
            @Override // com.studiolaganne.lengendarylens.DeckMoveCardDialogListener
            public void onMoveCardToDeckList(int destinationListId, int quantity2) {
                if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                    return;
                }
                this.this$0.addCardsToList(scannedCards, destinationListId, currentUser.getId());
            }
        }).build().show(getSupportFragmentManager(), DeckMoveCardDialogFragment.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustCardsRecyclerViewHeight() {
        int measuredHeight;
        int iDpToPx;
        int measuredHeight2;
        View viewFindViewById = findViewById(R.id.cardsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return;
        }
        int itemCount = adapter.getItemCount();
        int i = 0;
        for (int i2 = 0; i2 < itemCount; i2++) {
            RecyclerView.ViewHolder viewHolderCreateViewHolder = adapter.createViewHolder(recyclerView, adapter.getItemViewType(i2));
            Intrinsics.checkNotNullExpressionValue(viewHolderCreateViewHolder, "createViewHolder(...)");
            adapter.onBindViewHolder(viewHolderCreateViewHolder, i2);
            if (adapter.getItemViewType(i2) == 3) {
                StackedCardsView stackedCardsView = (StackedCardsView) viewHolderCreateViewHolder.itemView.findViewById(R.id.stackedCardsView);
                if (stackedCardsView != null) {
                    stackedCardsView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                    measuredHeight2 = stackedCardsView.getMeasuredHeight();
                } else {
                    viewHolderCreateViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                    measuredHeight2 = viewHolderCreateViewHolder.itemView.getMeasuredHeight();
                }
            } else {
                if (adapter.getItemViewType(i2) == 2) {
                    viewHolderCreateViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                    measuredHeight = viewHolderCreateViewHolder.itemView.getMeasuredHeight();
                    iDpToPx = GameUtils.INSTANCE.getInstance().dpToPx(5, this);
                } else {
                    viewHolderCreateViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                    measuredHeight = viewHolderCreateViewHolder.itemView.getMeasuredHeight();
                    iDpToPx = GameUtils.INSTANCE.getInstance().dpToPx(4, this);
                }
                measuredHeight2 = measuredHeight + iDpToPx;
            }
            i += measuredHeight2;
        }
        int iDpToPx2 = i + GameUtils.INSTANCE.getInstance().dpToPx(20, this);
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.height = iDpToPx2;
        recyclerView.setLayoutParams(layoutParams);
    }

    private final void adjustCombosRecyclerViewHeight(RecyclerView recyclerView) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return;
        }
        int itemCount = adapter.getItemCount();
        int measuredHeight = 0;
        for (int i = 0; i < itemCount; i++) {
            RecyclerView.ViewHolder viewHolderCreateViewHolder = adapter.createViewHolder(recyclerView, adapter.getItemViewType(i));
            Intrinsics.checkNotNullExpressionValue(viewHolderCreateViewHolder, "createViewHolder(...)");
            adapter.onBindViewHolder(viewHolderCreateViewHolder, i);
            viewHolderCreateViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            measuredHeight += viewHolderCreateViewHolder.itemView.getMeasuredHeight();
            ViewGroup.LayoutParams layoutParams = viewHolderCreateViewHolder.itemView.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                measuredHeight += marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            }
        }
        int itemCount2 = measuredHeight + (adapter.getItemCount() * GameUtils.INSTANCE.getInstance().dpToPx(2, this));
        ViewGroup.LayoutParams layoutParams2 = recyclerView.getLayoutParams();
        layoutParams2.height = itemCount2;
        recyclerView.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustManaProductionRecyclerViewHeight() {
        int itemCount;
        View viewFindViewById = findViewById(R.id.manaProductionRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null || (itemCount = (adapter.getItemCount() + 2) / 3) == 0) {
            return;
        }
        RecyclerView.ViewHolder viewHolderCreateViewHolder = adapter.createViewHolder(recyclerView, adapter.getItemViewType(0));
        Intrinsics.checkNotNullExpressionValue(viewHolderCreateViewHolder, "createViewHolder(...)");
        adapter.onBindViewHolder(viewHolderCreateViewHolder, 0);
        int iDpToPx = GameUtils.INSTANCE.getInstance().dpToPx(4, this);
        viewHolderCreateViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec((recyclerView.getWidth() - (2 * iDpToPx)) / 3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = (viewHolderCreateViewHolder.itemView.getMeasuredHeight() * itemCount) + ((itemCount - 1) * iDpToPx);
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.height = measuredHeight;
        recyclerView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustMatchupsRecyclerViewHeight() {
        View viewFindViewById = findViewById(R.id.matchupsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return;
        }
        int itemCount = adapter.getItemCount();
        int measuredHeight = 0;
        for (int i = 0; i < itemCount; i++) {
            RecyclerView.ViewHolder viewHolderCreateViewHolder = adapter.createViewHolder(recyclerView, adapter.getItemViewType(i));
            Intrinsics.checkNotNullExpressionValue(viewHolderCreateViewHolder, "createViewHolder(...)");
            adapter.onBindViewHolder(viewHolderCreateViewHolder, i);
            viewHolderCreateViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            measuredHeight += viewHolderCreateViewHolder.itemView.getMeasuredHeight();
        }
        int itemCount2 = measuredHeight + (adapter.getItemCount() * GameUtils.INSTANCE.getInstance().dpToPx(8, this));
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.height = itemCount2;
        recyclerView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustMaybeboardRecyclerViewHeight() {
        int measuredHeight;
        int iDpToPx;
        int measuredHeight2;
        View viewFindViewById = findViewById(R.id.maybeboardRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return;
        }
        int itemCount = adapter.getItemCount();
        int i = 0;
        for (int i2 = 0; i2 < itemCount; i2++) {
            RecyclerView.ViewHolder viewHolderCreateViewHolder = adapter.createViewHolder(recyclerView, adapter.getItemViewType(i2));
            Intrinsics.checkNotNullExpressionValue(viewHolderCreateViewHolder, "createViewHolder(...)");
            adapter.onBindViewHolder(viewHolderCreateViewHolder, i2);
            if (adapter.getItemViewType(i2) == 3) {
                StackedCardsView stackedCardsView = (StackedCardsView) viewHolderCreateViewHolder.itemView.findViewById(R.id.stackedCardsView);
                if (stackedCardsView != null) {
                    stackedCardsView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                    measuredHeight2 = stackedCardsView.getMeasuredHeight();
                } else {
                    viewHolderCreateViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                    measuredHeight2 = viewHolderCreateViewHolder.itemView.getMeasuredHeight();
                }
            } else {
                if (adapter.getItemViewType(i2) == 2) {
                    viewHolderCreateViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                    measuredHeight = viewHolderCreateViewHolder.itemView.getMeasuredHeight();
                    iDpToPx = GameUtils.INSTANCE.getInstance().dpToPx(5, this);
                } else {
                    viewHolderCreateViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                    measuredHeight = viewHolderCreateViewHolder.itemView.getMeasuredHeight();
                    iDpToPx = GameUtils.INSTANCE.getInstance().dpToPx(4, this);
                }
                measuredHeight2 = measuredHeight + iDpToPx;
            }
            i += measuredHeight2;
        }
        int iDpToPx2 = i + GameUtils.INSTANCE.getInstance().dpToPx(20, this);
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.height = iDpToPx2;
        recyclerView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustRecyclerViewHeight() {
        View viewFindViewById = findViewById(R.id.gamesRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return;
        }
        int itemCount = adapter.getItemCount();
        int measuredHeight = 0;
        for (int i = 0; i < itemCount; i++) {
            RecyclerView.ViewHolder viewHolderCreateViewHolder = adapter.createViewHolder(recyclerView, adapter.getItemViewType(i));
            Intrinsics.checkNotNullExpressionValue(viewHolderCreateViewHolder, "createViewHolder(...)");
            adapter.onBindViewHolder(viewHolderCreateViewHolder, i);
            viewHolderCreateViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            measuredHeight += viewHolderCreateViewHolder.itemView.getMeasuredHeight();
        }
        int itemCount2 = measuredHeight + (adapter.getItemCount() * GameUtils.INSTANCE.getInstance().dpToPx(12, this));
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.height = itemCount2;
        recyclerView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustSideboardRecyclerViewHeight() {
        int measuredHeight;
        int iDpToPx;
        int measuredHeight2;
        View viewFindViewById = findViewById(R.id.sideboardRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return;
        }
        int itemCount = adapter.getItemCount();
        int i = 0;
        for (int i2 = 0; i2 < itemCount; i2++) {
            RecyclerView.ViewHolder viewHolderCreateViewHolder = adapter.createViewHolder(recyclerView, adapter.getItemViewType(i2));
            Intrinsics.checkNotNullExpressionValue(viewHolderCreateViewHolder, "createViewHolder(...)");
            adapter.onBindViewHolder(viewHolderCreateViewHolder, i2);
            if (adapter.getItemViewType(i2) == 3) {
                StackedCardsView stackedCardsView = (StackedCardsView) viewHolderCreateViewHolder.itemView.findViewById(R.id.stackedCardsView);
                if (stackedCardsView != null) {
                    stackedCardsView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                    measuredHeight2 = stackedCardsView.getMeasuredHeight();
                } else {
                    viewHolderCreateViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                    measuredHeight2 = viewHolderCreateViewHolder.itemView.getMeasuredHeight();
                }
            } else {
                if (adapter.getItemViewType(i2) == 2) {
                    viewHolderCreateViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                    measuredHeight = viewHolderCreateViewHolder.itemView.getMeasuredHeight();
                    iDpToPx = GameUtils.INSTANCE.getInstance().dpToPx(5, this);
                } else {
                    viewHolderCreateViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                    measuredHeight = viewHolderCreateViewHolder.itemView.getMeasuredHeight();
                    iDpToPx = GameUtils.INSTANCE.getInstance().dpToPx(4, this);
                }
                measuredHeight2 = measuredHeight + iDpToPx;
            }
            i += measuredHeight2;
        }
        int iDpToPx2 = i + GameUtils.INSTANCE.getInstance().dpToPx(20, this);
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.height = iDpToPx2;
        recyclerView.setLayoutParams(layoutParams);
    }

    static final void allPrintsActivityLauncher$lambda$0(DeckDetailsActivity deckDetailsActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Breadcrumbs.INSTANCE.leaveBreadcrumb("launching_all_prints");
        Intent data = result.getData();
        if ((data != null ? data.getStringExtra("newCardId") : null) == null || deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
            return;
        }
        Intent data2 = result.getData();
        String stringExtra = data2 != null ? data2.getStringExtra("newCardJson") : null;
        if (stringExtra != null) {
            MTFullCard mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class);
            EditCardDialogFragment editCardDialogFragment = deckDetailsActivity.currentEditDialog;
            if (editCardDialogFragment != null) {
                Intrinsics.checkNotNull(mTFullCard);
                editCardDialogFragment.updatePrint(mTFullCard);
            }
        }
    }

    private final void applyDeckCardsNameFilter(String query) {
        Map<String, Boolean> mapEmptyMap;
        Map<String, Boolean> mapEmptyMap2;
        Map<String, Boolean> mapEmptyMap3;
        List<MTListError> listEmptyList;
        Object obj;
        MTCardContainer main;
        MTCardContainer main2;
        View viewFindViewById = findViewById(R.id.cardsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.twoColumnStackedCardsView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TwoColumnStackedCardsView twoColumnStackedCardsView = (TwoColumnStackedCardsView) viewFindViewById2;
        List<MTCardGroup> listFilterGroupedCardsByName = filterGroupedCardsByName(this.currentGroupedCards, query);
        MTDeckLists mTDeckLists = this.currentLists;
        MTCardContainer sideboard = mTDeckLists != null ? mTDeckLists.getSideboard() : null;
        List<MTCardGroup> listFilterGroupedCardsByName2 = filterGroupedCardsByName(sideboard != null ? sideboard.getGrouped_cards() : null, query);
        MTDeckLists mTDeckLists2 = this.currentLists;
        MTCardContainer maybeboard = mTDeckLists2 != null ? mTDeckLists2.getMaybeboard() : null;
        List<MTCardGroup> listFilterGroupedCardsByName3 = filterGroupedCardsByName(maybeboard != null ? maybeboard.getGrouped_cards() : null, query);
        if (WhenMappings.$EnumSwitchMapping$0[this.currentDisplayMode.ordinal()] == 1) {
            MTDeckLists mTDeckLists3 = this.currentLists;
            if (mTDeckLists3 == null || (main2 = mTDeckLists3.getMain()) == null || (listEmptyList = main2.getErrors()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List<MTListError> list = listEmptyList;
            twoColumnStackedCardsView.setThemeMode(Intrinsics.areEqual(this.currentGroupBy, "theme"));
            Function1<? super MTFullCard, Unit> function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda150
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return DeckDetailsActivity.applyDeckCardsNameFilter$lambda$0((MTFullCard) obj2);
                }
            };
            DeckDetailsActivity deckDetailsActivity = this;
            MTDeckLists mTDeckLists4 = this.currentLists;
            twoColumnStackedCardsView.setCardGroups(listFilterGroupedCardsByName, list, function1, deckDetailsActivity, (mTDeckLists4 == null || (main = mTDeckLists4.getMain()) == null) ? -1 : main.getId(), this.ignoreCollection, this.currentDeck);
            if (sideboard != null) {
                View viewFindViewById3 = findViewById(R.id.sideboardTwoColumnStackedCardsView);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                TwoColumnStackedCardsView twoColumnStackedCardsView2 = (TwoColumnStackedCardsView) viewFindViewById3;
                twoColumnStackedCardsView2.setThemeMode(Intrinsics.areEqual(this.currentGroupBy, "theme"));
                List<MTListError> errors = sideboard.getErrors();
                if (errors == null) {
                    errors = CollectionsKt.emptyList();
                }
                obj = "theme";
                twoColumnStackedCardsView2.setCardGroups(listFilterGroupedCardsByName2, errors, new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda151
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return DeckDetailsActivity.applyDeckCardsNameFilter$lambda$1$0((MTFullCard) obj2);
                    }
                }, deckDetailsActivity, sideboard.getId(), this.ignoreCollection, this.currentDeck);
            } else {
                obj = "theme";
            }
            if (maybeboard != null) {
                View viewFindViewById4 = findViewById(R.id.maybeboardTwoColumnStackedCardsView);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                TwoColumnStackedCardsView twoColumnStackedCardsView3 = (TwoColumnStackedCardsView) viewFindViewById4;
                twoColumnStackedCardsView3.setThemeMode(Intrinsics.areEqual(this.currentGroupBy, obj));
                List<MTListError> errors2 = maybeboard.getErrors();
                if (errors2 == null) {
                    errors2 = CollectionsKt.emptyList();
                }
                twoColumnStackedCardsView3.setCardGroups(listFilterGroupedCardsByName3, errors2, new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda152
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return DeckDetailsActivity.applyDeckCardsNameFilter$lambda$2$0((MTFullCard) obj2);
                    }
                }, deckDetailsActivity, maybeboard.getId(), this.ignoreCollection, this.currentDeck);
            }
        } else {
            DeckCardsAdapter deckCardsAdapter = this.deckCardsAdapter;
            if (deckCardsAdapter == null || (mapEmptyMap = deckCardsAdapter.getExpandedCards()) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            Map<String, Boolean> map = mapEmptyMap;
            ArrayList arrayList = new ArrayList();
            for (MTCardGroup mTCardGroup : listFilterGroupedCardsByName) {
                DeckDisplayMode deckDisplayMode = this.currentDisplayMode;
                MTDeckLists mTDeckLists5 = this.currentLists;
                arrayList.addAll(DeckCardItemKt.toDeckCardItems(mTCardGroup, deckDisplayMode, mTDeckLists5 != null ? mTDeckLists5.getMain() : null, map, this.currentDeck, Intrinsics.areEqual(this.currentGroupBy, "theme")));
            }
            DeckCardsAdapter deckCardsAdapter2 = this.deckCardsAdapter;
            if (deckCardsAdapter2 != null) {
                deckCardsAdapter2.setExpandedCards(map);
            }
            DeckCardsAdapter deckCardsAdapter3 = this.deckCardsAdapter;
            if (deckCardsAdapter3 != null) {
                deckCardsAdapter3.updateItems(arrayList);
            }
            if (sideboard != null) {
                DeckCardsAdapter deckCardsAdapter4 = this.sideboardCardsAdapter;
                if (deckCardsAdapter4 == null || (mapEmptyMap3 = deckCardsAdapter4.getExpandedCards()) == null) {
                    mapEmptyMap3 = MapsKt.emptyMap();
                }
                Map<String, Boolean> map2 = mapEmptyMap3;
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = listFilterGroupedCardsByName2.iterator();
                while (it.hasNext()) {
                    MTCardContainer mTCardContainer = sideboard;
                    arrayList2.addAll(DeckCardItemKt.toDeckCardItems((MTCardGroup) it.next(), this.currentDisplayMode, mTCardContainer, map2, this.currentDeck, Intrinsics.areEqual(this.currentGroupBy, "theme")));
                    sideboard = mTCardContainer;
                }
                DeckCardsAdapter deckCardsAdapter5 = this.sideboardCardsAdapter;
                if (deckCardsAdapter5 != null) {
                    deckCardsAdapter5.setExpandedCards(map2);
                }
                DeckCardsAdapter deckCardsAdapter6 = this.sideboardCardsAdapter;
                if (deckCardsAdapter6 != null) {
                    deckCardsAdapter6.updateItems(arrayList2);
                }
            }
            if (maybeboard != null) {
                DeckCardsAdapter deckCardsAdapter7 = this.maybeboardCardsAdapter;
                if (deckCardsAdapter7 == null || (mapEmptyMap2 = deckCardsAdapter7.getExpandedCards()) == null) {
                    mapEmptyMap2 = MapsKt.emptyMap();
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<T> it2 = listFilterGroupedCardsByName3.iterator();
                while (it2.hasNext()) {
                    MTCardContainer mTCardContainer2 = maybeboard;
                    Map<String, Boolean> map3 = mapEmptyMap2;
                    arrayList3.addAll(DeckCardItemKt.toDeckCardItems((MTCardGroup) it2.next(), this.currentDisplayMode, mTCardContainer2, map3, this.currentDeck, Intrinsics.areEqual(this.currentGroupBy, "theme")));
                    mapEmptyMap2 = map3;
                    maybeboard = mTCardContainer2;
                }
                Map<String, Boolean> map4 = mapEmptyMap2;
                DeckCardsAdapter deckCardsAdapter8 = this.maybeboardCardsAdapter;
                if (deckCardsAdapter8 != null) {
                    deckCardsAdapter8.setExpandedCards(map4);
                }
                DeckCardsAdapter deckCardsAdapter9 = this.maybeboardCardsAdapter;
                if (deckCardsAdapter9 != null) {
                    deckCardsAdapter9.updateItems(arrayList3);
                }
            }
        }
        recyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda153
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.adjustCardsRecyclerViewHeight();
            }
        });
        if (this.sideboardExpanded) {
            ((RecyclerView) findViewById(R.id.sideboardRecyclerView)).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda154
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.adjustSideboardRecyclerViewHeight();
                }
            });
        }
        ((RecyclerView) findViewById(R.id.maybeboardRecyclerView)).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda155
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.adjustMaybeboardRecyclerViewHeight();
            }
        });
    }

    static final Unit applyDeckCardsNameFilter$lambda$0(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyDeckCardsNameFilter$lambda$1$0(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyDeckCardsNameFilter$lambda$2$0(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyDeckIdCardScoresUi(MTDeckIdCardResponse response, Integer animationDeckId) {
        DeckIdCardArcGaugeView deckIdCardArcGaugeView;
        DeckIdCardArcGaugeView deckIdCardArcGaugeView2;
        DeckIdCardArcGaugeView deckIdCardArcGaugeView3;
        DeckIdCardArcGaugeView deckIdCardArcGaugeView4;
        int iIntValue;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.deckIdCardScoresRow);
        if (linearLayout == null || (deckIdCardArcGaugeView = (DeckIdCardArcGaugeView) findViewById(R.id.deckScoreGaugeGlobal)) == null || (deckIdCardArcGaugeView2 = (DeckIdCardArcGaugeView) findViewById(R.id.deckScoreGaugePower)) == null || (deckIdCardArcGaugeView3 = (DeckIdCardArcGaugeView) findViewById(R.id.deckScoreGaugeMana)) == null || (deckIdCardArcGaugeView4 = (DeckIdCardArcGaugeView) findViewById(R.id.deckScoreGaugeHealth)) == null) {
            return;
        }
        List listListOf = CollectionsKt.listOf((Object[]) new DeckIdCardArcGaugeView[]{deckIdCardArcGaugeView, deckIdCardArcGaugeView2, deckIdCardArcGaugeView3, deckIdCardArcGaugeView4});
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            ((DeckIdCardArcGaugeView) it.next()).cancelScoreAnimation();
        }
        if (response == null) {
            linearLayout.setVisibility(8);
            return;
        }
        Integer globalScore = response.getGlobalScore();
        MTIdCardPowerLevel powerLevel = response.getPowerLevel();
        Integer score = powerLevel != null ? powerLevel.getScore() : null;
        MTIdCardManaBaseAnalysis manaBaseAnalysis = response.getManaBaseAnalysis();
        Integer score2 = manaBaseAnalysis != null ? manaBaseAnalysis.getScore() : null;
        MTIdCardDeckHealthScore deckHealthScore = response.getDeckHealthScore();
        Integer overall = deckHealthScore != null ? deckHealthScore.getOverall() : null;
        if (globalScore == null && score == null && score2 == null && overall == null) {
            linearLayout.setVisibility(8);
            return;
        }
        int iIntValue2 = globalScore != null ? globalScore.intValue() : 0;
        int iIntValue3 = score != null ? score.intValue() : 0;
        int iIntValue4 = score2 != null ? score2.intValue() : 0;
        int iIntValue5 = overall != null ? overall.intValue() : 0;
        int iArgb = Color.argb(15, 255, 255, 255);
        deckIdCardArcGaugeView.setCenterMode(DeckIdCardGaugeCenterMode.SCORE_TEXT);
        deckIdCardArcGaugeView.setTrackColor(iArgb);
        String string = getString(R.string.deck_id_card_score_global);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        deckIdCardArcGaugeView.setGaugeLabel(string);
        deckIdCardArcGaugeView.setFillColor(DeckIdCardScoreColors.MYTHIC_BLUE);
        deckIdCardArcGaugeView2.setCenterMode(DeckIdCardGaugeCenterMode.SCORE_TEXT);
        deckIdCardArcGaugeView2.setTrackColor(iArgb);
        String string2 = getString(R.string.deck_id_card_score_power);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        deckIdCardArcGaugeView2.setGaugeLabel(string2);
        deckIdCardArcGaugeView2.setFillColor(DeckIdCardScoreColors.INSTANCE.powerLevelColor(iIntValue3));
        deckIdCardArcGaugeView3.setCenterMode(DeckIdCardGaugeCenterMode.SCORE_TEXT);
        deckIdCardArcGaugeView3.setTrackColor(iArgb);
        String string3 = getString(R.string.deck_id_card_score_mana);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        deckIdCardArcGaugeView3.setGaugeLabel(string3);
        deckIdCardArcGaugeView3.setFillColor(DeckIdCardScoreColors.INSTANCE.healthBandColor(iIntValue4));
        deckIdCardArcGaugeView4.setCenterMode(DeckIdCardGaugeCenterMode.SCORE_TEXT);
        deckIdCardArcGaugeView4.setTrackColor(iArgb);
        String string4 = getString(R.string.deck_id_card_score_health);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        deckIdCardArcGaugeView4.setGaugeLabel(string4);
        DeckIdCardScoreColors deckIdCardScoreColors = DeckIdCardScoreColors.INSTANCE;
        MTIdCardDeckHealthScore deckHealthScore2 = response.getDeckHealthScore();
        Integer apiColor = deckIdCardScoreColors.parseApiColor(deckHealthScore2 != null ? deckHealthScore2.getColor() : null);
        deckIdCardArcGaugeView4.setFillColor(apiColor != null ? apiColor.intValue() : DeckIdCardScoreColors.INSTANCE.healthBandColor(iIntValue5));
        linearLayout.setVisibility(0);
        if (animationDeckId != null) {
            iIntValue = animationDeckId.intValue();
        } else {
            MTDeck mTDeck = this.currentDeck;
            Integer numValueOf = mTDeck != null ? Integer.valueOf(mTDeck.getId()) : null;
            if (numValueOf == null) {
                return;
            } else {
                iIntValue = numValueOf.intValue();
            }
        }
        Integer num = this.idCardGaugesAnimatedForDeckId;
        long j = (num != null && num.intValue() == iIntValue) ? 0L : 200L;
        this.idCardGaugesAnimatedForDeckId = Integer.valueOf(iIntValue);
        Iterator it2 = listListOf.iterator();
        while (it2.hasNext()) {
            ((DeckIdCardArcGaugeView) it2.next()).setScorePercentImmediate(0);
        }
        deckIdCardArcGaugeView.animateScorePercentTo(iIntValue2, 0, 900L, j);
        deckIdCardArcGaugeView2.animateScorePercentTo(iIntValue3, 0, 900L, j);
        deckIdCardArcGaugeView3.animateScorePercentTo(iIntValue4, 0, 900L, j);
        deckIdCardArcGaugeView4.animateScorePercentTo(iIntValue5, 0, 900L, j);
        ViewExtensionsKt.setOnClickWithFade(deckIdCardArcGaugeView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.applyDeckIdCardScoresUi$lambda$2(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(deckIdCardArcGaugeView2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.applyDeckIdCardScoresUi$lambda$3(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(deckIdCardArcGaugeView3, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.applyDeckIdCardScoresUi$lambda$4(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(deckIdCardArcGaugeView4, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.applyDeckIdCardScoresUi$lambda$5(this.f$0);
            }
        });
    }

    static /* synthetic */ void applyDeckIdCardScoresUi$default(DeckDetailsActivity deckDetailsActivity, MTDeckIdCardResponse mTDeckIdCardResponse, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        deckDetailsActivity.applyDeckIdCardScoresUi(mTDeckIdCardResponse, num);
    }

    static final Unit applyDeckIdCardScoresUi$lambda$2(DeckDetailsActivity deckDetailsActivity) {
        deckDetailsActivity.openIdCardDetails(0);
        return Unit.INSTANCE;
    }

    static final Unit applyDeckIdCardScoresUi$lambda$3(DeckDetailsActivity deckDetailsActivity) {
        deckDetailsActivity.openIdCardDetails(1);
        return Unit.INSTANCE;
    }

    static final Unit applyDeckIdCardScoresUi$lambda$4(DeckDetailsActivity deckDetailsActivity) {
        deckDetailsActivity.openIdCardDetails(2);
        return Unit.INSTANCE;
    }

    static final Unit applyDeckIdCardScoresUi$lambda$5(DeckDetailsActivity deckDetailsActivity) {
        deckDetailsActivity.openIdCardDetails(3);
        return Unit.INSTANCE;
    }

    private final void applyExternalDeckSync(String url) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        MTDeck mTDeck = this.currentDeck;
        if (mTDeck == null) {
            Toast.makeText(this, getString(R.string.no_deck_loaded), 0).show();
            return;
        }
        DeckDetailsActivity deckDetailsActivity = this;
        MTUser currentUser = new PreferencesManager(deckDetailsActivity).getCurrentUser();
        if (currentUser == null) {
            Toast.makeText(deckDetailsActivity, getString(R.string.server_error), 0).show();
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        MTApiKt.getMtApi().applyExternalDeckUpdates(currentUser.getId(), mTDeck.getId(), url).enqueue(new C11471(constraintLayout));
    }

    private final List<MTFullCard> buildCardListForCollectionStatus(MTFullCard card) {
        ArrayList arrayList = new ArrayList();
        Integer quantity = card.getQuantity();
        int iIntValue = quantity != null ? quantity.intValue() : 1;
        Integer variant_quantity = card.getVariant_quantity();
        boolean z = false;
        int iIntValue2 = variant_quantity != null ? variant_quantity.intValue() : 0;
        if (card.getVariants() != null) {
            List<MTFullCard> variants = card.getVariants();
            Intrinsics.checkNotNull(variants);
            if (!variants.isEmpty()) {
                z = true;
            }
        }
        List<Integer> list_card_ids = card.getList_card_ids();
        if (list_card_ids == null) {
            list_card_ids = CollectionsKt.emptyList();
        }
        List<Integer> variant_list_card_ids = card.getVariant_list_card_ids();
        if (variant_list_card_ids == null) {
            variant_list_card_ids = CollectionsKt.emptyList();
        }
        if (z) {
            if (iIntValue2 <= 0 || variant_list_card_ids.isEmpty()) {
                Iterator it = CollectionsKt.take(list_card_ids, iIntValue).iterator();
                while (it.hasNext()) {
                    arrayList.add(MTFullCard.copy$default(card, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(((Number) it.next()).intValue()), null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1073725438, 127, null));
                }
            } else {
                Iterator it2 = CollectionsKt.take(variant_list_card_ids, iIntValue2).iterator();
                while (it2.hasNext()) {
                    arrayList.add(MTFullCard.copy$default(card, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(((Number) it2.next()).intValue()), null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1073725438, 127, null));
                }
            }
        } else {
            if (iIntValue <= 1 || list_card_ids.isEmpty()) {
                arrayList.add(MTFullCard.copy$default(card, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1073725439, 127, null));
                return arrayList;
            }
            Iterator it3 = CollectionsKt.take(list_card_ids, iIntValue).iterator();
            while (it3.hasNext()) {
                arrayList.add(MTFullCard.copy$default(card, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(((Number) it3.next()).intValue()), null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1073725438, 127, null));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String buildDeckImportResultMessage(MTAddCardsResult result, List<ParsedCard> originalCards) {
        Object obj;
        String cardName;
        String upperCase;
        String collector_number;
        String set_code;
        StringBuilder sb = new StringBuilder();
        List<MTAddCardResult> failed_cards = result.getFailed_cards();
        int size = failed_cards != null ? failed_cards.size() : 0;
        sb.append(getString(R.string.deck_import_summary, new Object[]{Integer.valueOf(result.getAdded()), Integer.valueOf(size)}));
        sb.append("\n\n");
        if (size > 0) {
            sb.append(getString(R.string.deck_import_failed_cards));
            sb.append("\n");
            List<MTAddCardResult> failed_cards2 = result.getFailed_cards();
            if (failed_cards2 != null) {
                for (MTAddCardResult mTAddCardResult : failed_cards2) {
                    Iterator<T> it = originalCards.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        ParsedCard parsedCard = (ParsedCard) next;
                        String setCode = parsedCard.getSetCode();
                        if (setCode != null) {
                            MTAddCardOriginalData original_data = mTAddCardResult.getOriginal_data();
                            if (StringsKt.equals(setCode, original_data != null ? original_data.getSet_code() : null, true)) {
                                String collectorNumber = parsedCard.getCollectorNumber();
                                MTAddCardOriginalData original_data2 = mTAddCardResult.getOriginal_data();
                                if (Intrinsics.areEqual(collectorNumber, original_data2 != null ? original_data2.getCollector_number() : null)) {
                                    obj = next;
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    ParsedCard parsedCard2 = (ParsedCard) obj;
                    if (parsedCard2 == null || (cardName = parsedCard2.getCardName()) == null) {
                        cardName = "Unknown Card";
                    }
                    MTAddCardOriginalData original_data3 = mTAddCardResult.getOriginal_data();
                    String str = "?";
                    if (original_data3 == null || (set_code = original_data3.getSet_code()) == null) {
                        upperCase = "?";
                    } else {
                        upperCase = set_code.toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                        if (upperCase == null) {
                        }
                    }
                    MTAddCardOriginalData original_data4 = mTAddCardResult.getOriginal_data();
                    if (original_data4 != null && (collector_number = original_data4.getCollector_number()) != null) {
                        str = collector_number;
                    }
                    String reason = mTAddCardResult.getReason();
                    if (reason == null) {
                        reason = "Unknown error";
                    }
                    sb.append(getString(R.string.deck_import_card_failure, new Object[]{cardName, upperCase, str, reason}));
                    sb.append("\n");
                }
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String buildDeckImportResultMessageWithSections(List<MTAddCardsResult> results, ParsedDeckList parsedDeckList) {
        Object obj;
        String cardName;
        String upperCase;
        String collector_number;
        String set_code;
        StringBuilder sb = new StringBuilder();
        List<MTAddCardsResult> list = results;
        Iterator<T> it = list.iterator();
        int quantity = 0;
        int added = 0;
        while (it.hasNext()) {
            added += ((MTAddCardsResult) it.next()).getAdded();
        }
        Iterator<T> it2 = list.iterator();
        int size = 0;
        while (it2.hasNext()) {
            List<MTAddCardResult> failed_cards = ((MTAddCardsResult) it2.next()).getFailed_cards();
            size += failed_cards != null ? failed_cards.size() : 0;
        }
        sb.append(getString(R.string.deck_import_summary, new Object[]{Integer.valueOf(added), Integer.valueOf(size)}));
        sb.append("\n\n");
        Iterator<T> it3 = parsedDeckList.getMainDeckCards().iterator();
        int quantity2 = 0;
        while (it3.hasNext()) {
            quantity2 += ((ParsedCard) it3.next()).getQuantity();
        }
        Iterator<T> it4 = parsedDeckList.getSideboardCards().iterator();
        int quantity3 = 0;
        while (it4.hasNext()) {
            quantity3 += ((ParsedCard) it4.next()).getQuantity();
        }
        Iterator<T> it5 = parsedDeckList.getMaybeboardCards().iterator();
        while (it5.hasNext()) {
            quantity += ((ParsedCard) it5.next()).getQuantity();
        }
        sb.append("Main Deck: " + quantity2 + " cards\n");
        if (quantity3 > 0) {
            sb.append("Sideboard: " + quantity3 + " cards\n");
        }
        if (quantity > 0) {
            sb.append("Maybeboard: " + quantity + " cards\n");
        }
        if (size > 0) {
            sb.append("\n" + getString(R.string.deck_import_failed_cards) + "\n");
            Iterator<T> it6 = list.iterator();
            while (it6.hasNext()) {
                List<MTAddCardResult> failed_cards2 = ((MTAddCardsResult) it6.next()).getFailed_cards();
                if (failed_cards2 != null) {
                    for (MTAddCardResult mTAddCardResult : failed_cards2) {
                        Iterator it7 = CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) parsedDeckList.getMainDeckCards(), (Iterable) parsedDeckList.getSideboardCards()), (Iterable) parsedDeckList.getMaybeboardCards()).iterator();
                        while (true) {
                            if (!it7.hasNext()) {
                                break;
                            }
                            Object next = it7.next();
                            ParsedCard parsedCard = (ParsedCard) next;
                            String setCode = parsedCard.getSetCode();
                            if (setCode != null) {
                                MTAddCardOriginalData original_data = mTAddCardResult.getOriginal_data();
                                if (StringsKt.equals(setCode, original_data != null ? original_data.getSet_code() : null, true)) {
                                    String collectorNumber = parsedCard.getCollectorNumber();
                                    MTAddCardOriginalData original_data2 = mTAddCardResult.getOriginal_data();
                                    if (Intrinsics.areEqual(collectorNumber, original_data2 != null ? original_data2.getCollector_number() : null)) {
                                        obj = next;
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                        ParsedCard parsedCard2 = (ParsedCard) obj;
                        if (parsedCard2 == null || (cardName = parsedCard2.getCardName()) == null) {
                            cardName = "Unknown Card";
                        }
                        MTAddCardOriginalData original_data3 = mTAddCardResult.getOriginal_data();
                        String str = "?";
                        if (original_data3 == null || (set_code = original_data3.getSet_code()) == null) {
                            upperCase = "?";
                        } else {
                            upperCase = set_code.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                            if (upperCase == null) {
                            }
                        }
                        MTAddCardOriginalData original_data4 = mTAddCardResult.getOriginal_data();
                        if (original_data4 != null && (collector_number = original_data4.getCollector_number()) != null) {
                            str = collector_number;
                        }
                        String reason = mTAddCardResult.getReason();
                        if (reason == null) {
                            reason = "Unknown error";
                        }
                        sb.append(getString(R.string.deck_import_card_failure, new Object[]{cardName, upperCase, str, reason}));
                        sb.append("\n");
                    }
                }
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final Dialog buildDescriptionDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return dialog;
    }

    private final LinearLayout buildDescriptionDialogRoot() {
        DeckDetailsActivity deckDetailsActivity = this;
        LinearLayout linearLayout = new LinearLayout(deckDetailsActivity);
        linearLayout.setOrientation(1);
        linearLayout.setBackground(ContextCompat.getDrawable(deckDetailsActivity, R.drawable.rounded_background_dialog_darker_with_line));
        linearLayout.setPadding(dp(20), dp(18), dp(20), dp(18));
        return linearLayout;
    }

    private final TextView buildDescriptionTitle(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setTextSize(20.0f);
        textView.setTextColor(-1);
        textView.setTypeface(textView.getResources().getFont(R.font.be_vietnam_pro_regular));
        textView.setTypeface(textView.getTypeface(), 1);
        return textView;
    }

    private final void bulkDeleteSelectedCards() {
        Integer num;
        if (isFinishing() || isDestroyed() || (num = this.selectionLockedListId) == null) {
            return;
        }
        final int iIntValue = num.intValue();
        if (this.selectedCards.isEmpty()) {
            return;
        }
        final Map<Integer, MTFullCard> mapFilterSelectedCardsForAction = filterSelectedCardsForAction();
        if (mapFilterSelectedCardsForAction.isEmpty()) {
            Toast.makeText(this, R.string.cannot_delete_selected_cards, 0).show();
            return;
        }
        int size = mapFilterSelectedCardsForAction.size();
        String string = getString(R.string.delete_x_cards);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String strReplace$default = StringsKt.replace$default(string, "{1}", String.valueOf(size), false, 4, (Object) null);
        String string2 = getString(R.string.delete_x_cards_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        new CustomDeleteDialogFragment.Builder().setTitle(strReplace$default).setBody(StringsKt.replace$default(string2, "{1}", String.valueOf(size), false, 4, (Object) null)).setShowRestoreCheckBox(true).setPositiveButtonCallback(new Function3() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda71
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DeckDetailsActivity.bulkDeleteSelectedCards$lambda$0(this.f$0, mapFilterSelectedCardsForAction, iIntValue, (String) obj, ((Boolean) obj2).booleanValue(), (CustomDeleteDialogFragment) obj3);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda72
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeckDetailsActivity.bulkDeleteSelectedCards$lambda$1((CustomDeleteDialogFragment) obj);
            }
        }).build().show(getSupportFragmentManager(), "BulkDeleteCardsDialog");
    }

    static final Unit bulkDeleteSelectedCards$lambda$0(final DeckDetailsActivity deckDetailsActivity, Map map, final int i, String str, boolean z, CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        final PreferencesManager preferencesManager = new PreferencesManager(deckDetailsActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            final ConstraintLayout constraintLayout = (ConstraintLayout) deckDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            Set setKeySet = map.keySet();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(new MTCardReference(((Number) it.next()).intValue()));
            }
            MTRemoveCardsBody mTRemoveCardsBody = new MTRemoveCardsBody(arrayList);
            MTApi mtApi = MTApiKt.getMtApi();
            int id = currentUser.getId();
            String str2 = deckDetailsActivity.currentGroupBy;
            String str3 = deckDetailsActivity.currentSortBy;
            String str4 = deckDetailsActivity.currentSortDirection;
            boolean z2 = deckDetailsActivity.ignoreCollection;
            boolean z3 = deckDetailsActivity.ignoreBasicLands;
            MTApi.removeCardsFromList$default(mtApi, id, i, null, null, str2, str3, str4, Boolean.valueOf(z2), Boolean.valueOf(deckDetailsActivity.ignorePrintings), Boolean.valueOf(z3), Boolean.valueOf(z), mTRemoveCardsBody, 12, null).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$bulkDeleteSelectedCards$1$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    if (constraintLayout2 != null) {
                        constraintLayout2.setVisibility(8);
                    }
                    Toast.makeText(this.this$0, R.string.error_deleting_cards, 0).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                    MTCardContainer maybeboard;
                    MTCardContainer sideboard;
                    MTCardContainer main;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.isDestroyed() || this.this$0.isFinishing()) {
                        return;
                    }
                    if (!response.isSuccessful()) {
                        ConstraintLayout constraintLayout2 = constraintLayout;
                        if (constraintLayout2 != null) {
                            constraintLayout2.setVisibility(8);
                        }
                        Toast.makeText(this.this$0, R.string.error_deleting_cards, 0).show();
                        return;
                    }
                    preferencesManager.incrementCollectionVersion();
                    preferencesManager.incrementAllContainerVersions();
                    MTCardListResponse mTCardListResponseBody = response.body();
                    MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                    if (list != null) {
                        int i2 = i;
                        DeckDetailsActivity deckDetailsActivity2 = this.this$0;
                        MTDeckLists mTDeckLists = deckDetailsActivity2.currentLists;
                        if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || i2 != main.getId()) {
                            MTDeckLists mTDeckLists2 = deckDetailsActivity2.currentLists;
                            if (mTDeckLists2 == null || (sideboard = mTDeckLists2.getSideboard()) == null || i2 != sideboard.getId()) {
                                MTDeckLists mTDeckLists3 = deckDetailsActivity2.currentLists;
                                if (mTDeckLists3 != null && (maybeboard = mTDeckLists3.getMaybeboard()) != null && i2 == maybeboard.getId()) {
                                    MTDeckLists mTDeckLists4 = deckDetailsActivity2.currentLists;
                                    deckDetailsActivity2.currentLists = mTDeckLists4 != null ? MTDeckLists.copy$default(mTDeckLists4, null, null, list, 3, null) : null;
                                }
                            } else {
                                MTDeckLists mTDeckLists5 = deckDetailsActivity2.currentLists;
                                deckDetailsActivity2.currentLists = mTDeckLists5 != null ? MTDeckLists.copy$default(mTDeckLists5, null, list, null, 5, null) : null;
                            }
                        } else {
                            MTDeckLists mTDeckLists6 = deckDetailsActivity2.currentLists;
                            deckDetailsActivity2.currentLists = mTDeckLists6 != null ? MTDeckLists.copy$default(mTDeckLists6, list, null, null, 6, null) : null;
                            List<MTCardGroup> grouped_cards = list.getGrouped_cards();
                            if (grouped_cards != null) {
                                deckDetailsActivity2.currentGroupedCards = grouped_cards;
                            }
                        }
                    }
                    this.this$0.exitSelectionMode();
                    List list2 = this.this$0.currentGroupedCards;
                    if (list2 != null) {
                        this.this$0.setupCardsAdapter(list2);
                    }
                    this.this$0.onDeckListModified();
                    ConstraintLayout constraintLayout3 = constraintLayout;
                    if (constraintLayout3 != null) {
                        constraintLayout3.setVisibility(8);
                    }
                }
            });
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit bulkDeleteSelectedCards$lambda$1(CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void bulkMoveSelectedCards() {
        Integer num;
        if (isFinishing() || isDestroyed() || (num = this.selectionLockedListId) == null) {
            return;
        }
        final int iIntValue = num.intValue();
        if (this.selectedCards.isEmpty()) {
            return;
        }
        final Map<Integer, MTFullCard> mapFilterSelectedCardsForAction = filterSelectedCardsForAction();
        if (mapFilterSelectedCardsForAction.isEmpty()) {
            Toast.makeText(this, R.string.cannot_move_selected_cards, 0).show();
            return;
        }
        DeckMoveCardDialogFragment.Builder cardCount = new DeckMoveCardDialogFragment.Builder().setMode(DeckCardDialogMode.BULK_MOVE).setCardCount(mapFilterSelectedCardsForAction.size());
        MTDeckLists mTDeckLists = this.currentLists;
        if (mTDeckLists == null) {
            mTDeckLists = new MTDeckLists(null, null, null, 7, null);
        }
        cardCount.setCurrentLists(mTDeckLists).setCurrentListId(iIntValue).setListener(new DeckMoveCardDialogListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$bulkMoveSelectedCards$moveDialog$1
            @Override // com.studiolaganne.lengendarylens.DeckMoveCardDialogListener
            public void onMoveCardToDeckList(int destinationListId, int quantity) {
                MTUser currentUser;
                if (this.this$0.isFinishing() || this.this$0.isDestroyed() || (currentUser = new PreferencesManager(this.this$0).getCurrentUser()) == null) {
                    return;
                }
                final DeckDetailsActivity deckDetailsActivity = this.this$0;
                Map<Integer, MTFullCard> map = mapFilterSelectedCardsForAction;
                int i = iIntValue;
                final ConstraintLayout constraintLayout = (ConstraintLayout) deckDetailsActivity.findViewById(R.id.overlay);
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(0);
                }
                MTMoveCardsBody mTMoveCardsBody = new MTMoveCardsBody(0, null, 3, null);
                mTMoveCardsBody.setTarget(destinationListId);
                Set<Integer> setKeySet = map.keySet();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
                Iterator<T> it = setKeySet.iterator();
                while (it.hasNext()) {
                    arrayList.add(new MTCardReference(((Number) it.next()).intValue()));
                }
                mTMoveCardsBody.setCards(arrayList);
                MTApiKt.getMtApi().moveCardsFromList(currentUser.getId(), i, null, null, deckDetailsActivity.currentGroupBy, deckDetailsActivity.currentSortBy, deckDetailsActivity.currentSortDirection, Boolean.valueOf(deckDetailsActivity.ignoreCollection), Boolean.valueOf(deckDetailsActivity.ignoreBasicLands), Boolean.valueOf(deckDetailsActivity.ignorePrintings), mTMoveCardsBody).enqueue(new Callback<MTMoveCardsResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$bulkMoveSelectedCards$moveDialog$1$onMoveCardToDeckList$1$2
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTMoveCardsResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
                            return;
                        }
                        ConstraintLayout constraintLayout2 = constraintLayout;
                        if (constraintLayout2 != null) {
                            constraintLayout2.setVisibility(8);
                        }
                        Toast.makeText(deckDetailsActivity, R.string.error_moving_cards, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTMoveCardsResponse> call, Response<MTMoveCardsResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
                            return;
                        }
                        ConstraintLayout constraintLayout2 = constraintLayout;
                        if (constraintLayout2 != null) {
                            constraintLayout2.setVisibility(8);
                        }
                        if (!response.isSuccessful()) {
                            Toast.makeText(deckDetailsActivity, R.string.error_moving_cards, 0).show();
                            return;
                        }
                        MTMoveCardsResponse mTMoveCardsResponseBody = response.body();
                        if (mTMoveCardsResponseBody != null) {
                            DeckDetailsActivity deckDetailsActivity2 = deckDetailsActivity;
                            if (!mTMoveCardsResponseBody.getSuccess()) {
                                Toast.makeText(deckDetailsActivity2, R.string.error_moving_cards, 0).show();
                                return;
                            }
                            deckDetailsActivity2.exitSelectionMode();
                            MTCardContainer target = mTMoveCardsResponseBody.getTarget();
                            if (target != null) {
                                deckDetailsActivity2.refreshCurrentList(target.getId());
                            }
                            MTCardContainer source = mTMoveCardsResponseBody.getSource();
                            if (source != null) {
                                deckDetailsActivity2.refreshCurrentList(source.getId());
                            }
                            deckDetailsActivity2.fetchDeckIdCardIfNeeded(true);
                        }
                    }
                });
            }
        }).build().show(getSupportFragmentManager(), DeckMoveCardDialogFragment.TAG);
    }

    private final int calculateCardCount(List<MTCardGroup> groupedCards) {
        int iIntValue;
        if (groupedCards == null) {
            return 0;
        }
        Iterator<T> it = groupedCards.iterator();
        int i = 0;
        while (it.hasNext()) {
            List<MTFullCard> cards = ((MTCardGroup) it.next()).getCards();
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
        return i;
    }

    private final void clearSmartDeckEffects() {
        ObjectAnimator objectAnimator = this.smartDeckGlowAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.smartDeckGlowAnimator = null;
        CustomGlowView customGlowView = (CustomGlowView) findViewById(R.id.smartDeckGlowView);
        if (customGlowView != null) {
            customGlowView.setVisibility(8);
        }
        MythicBorderAnimationView mythicBorderAnimationView = (MythicBorderAnimationView) findViewById(R.id.smartDeckBorderView);
        if (mythicBorderAnimationView != null) {
            mythicBorderAnimationView.stopAnimation();
        }
        if (mythicBorderAnimationView != null) {
            mythicBorderAnimationView.setVisibility(8);
        }
        View viewFindViewById = findViewById(R.id.groupByButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((TextView) viewFindViewById).setBackgroundResource(R.drawable.dark_grey_box_mythic);
    }

    private final boolean computeIsSmartDeck(MTDeck deck) {
        if (isOtherUserDeck() || this.isDuplicatedDeck || deck.getFormatid() != 6) {
            return false;
        }
        if (MythicPlusManager.INSTANCE.isActive(this)) {
            return true;
        }
        return Intrinsics.areEqual((Object) deck.is_smart_deck(), (Object) true);
    }

    private final void configureManaCurveChart(CombinedChart chart, List<MTManaCurveEntry> manaCurve) {
        Integer numValueOf;
        chart.getDescription().setEnabled(false);
        chart.setDrawGridBackground(false);
        chart.setTouchEnabled(true);
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);
        chart.setPinchZoom(false);
        chart.getLegend().setEnabled(false);
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1.0f);
        xAxis.setLabelCount(manaCurve.size());
        xAxis.setValueFormatter(new ValueFormatter() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity.configureManaCurveChart.1
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String getFormattedValue(float value) {
                return String.valueOf((int) value);
            }
        });
        DeckDetailsActivity deckDetailsActivity = this;
        xAxis.setTextColor(ContextCompat.getColor(deckDetailsActivity, R.color.text_color));
        xAxis.setTextSize(12.0f);
        xAxis.setAxisLineColor(ContextCompat.getColor(deckDetailsActivity, R.color.text_color));
        xAxis.setAxisLineWidth(1.0f);
        xAxis.setCenterAxisLabels(false);
        xAxis.setLabelCount(manaCurve.size(), false);
        xAxis.setAxisMinimum(-0.5f);
        List<MTManaCurveEntry> list = manaCurve;
        Iterator<T> it = list.iterator();
        Integer num = null;
        if (it.hasNext()) {
            numValueOf = Integer.valueOf(((MTManaCurveEntry) it.next()).getCmc());
            while (it.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(((MTManaCurveEntry) it.next()).getCmc());
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
        } else {
            numValueOf = null;
        }
        xAxis.setAxisMaximum((numValueOf != null ? r8.intValue() : 0.0f) + 0.5f);
        xAxis.setLabelCount(manaCurve.size(), false);
        YAxis axisLeft = chart.getAxisLeft();
        axisLeft.setDrawGridLines(true);
        axisLeft.setGridColor(ContextCompat.getColor(deckDetailsActivity, R.color.text_color));
        axisLeft.setGridLineWidth(0.5f);
        axisLeft.setDrawAxisLine(true);
        axisLeft.setAxisLineColor(ContextCompat.getColor(deckDetailsActivity, R.color.text_color));
        axisLeft.setAxisLineWidth(1.0f);
        axisLeft.setTextColor(ContextCompat.getColor(deckDetailsActivity, R.color.text_color));
        axisLeft.setTextSize(12.0f);
        axisLeft.setAxisMinimum(0.0f);
        Iterator<T> it2 = list.iterator();
        if (it2.hasNext()) {
            Integer numValueOf3 = Integer.valueOf(((MTManaCurveEntry) it2.next()).getTotal());
            loop0: while (true) {
                num = numValueOf3;
                while (it2.hasNext()) {
                    numValueOf3 = Integer.valueOf(((MTManaCurveEntry) it2.next()).getTotal());
                    if (num.compareTo(numValueOf3) < 0) {
                        break;
                    }
                }
            }
        }
        axisLeft.setAxisMaximum((num != null ? r9.intValue() : 0.0f) + 2.0f);
        axisLeft.setGranularity(1.0f);
        axisLeft.setLabelCount(6, false);
        axisLeft.setSpaceTop(0.0f);
        axisLeft.setSpaceTop(0.0f);
        chart.getAxisRight().setEnabled(false);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it3 = list.iterator();
        while (it3.hasNext()) {
            float cmc = ((MTManaCurveEntry) it3.next()).getCmc();
            arrayList.add(new BarEntry(cmc, new float[]{r6.getPermanents(), r6.getSpells()}));
            arrayList2.add(new Entry(cmc, r6.getTotal()));
        }
        ArrayList arrayList3 = arrayList2;
        if ((arrayList3 instanceof Collection) && arrayList3.isEmpty()) {
            arrayList2.add(0, new Entry(0.0f, 0.0f));
        } else {
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                if (((Entry) it4.next()).getX() == 0.0f) {
                    break;
                }
            }
            arrayList2.add(0, new Entry(0.0f, 0.0f));
        }
        if (arrayList2.size() > 1) {
            CollectionsKt.sortWith(arrayList2, new Comparator() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$configureManaCurveChart$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Float.valueOf(((Entry) t).getX()), Float.valueOf(((Entry) t2).getX()));
                }
            });
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, "");
        barDataSet.setDrawValues(false);
        barDataSet.setColors(CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(ContextCompat.getColor(deckDetailsActivity, R.color.link_color)), Integer.valueOf(ContextCompat.getColor(deckDetailsActivity, R.color.selected_color_new))}));
        barDataSet.setStackLabels(new String[]{getString(R.string.mana_curve_permanents), getString(R.string.mana_curve_spells)});
        barDataSet.setHighlightEnabled(true);
        barDataSet.setHighLightColor(0);
        barDataSet.setHighLightAlpha(0);
        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.6f);
        chart.setExtraOffsets(10.0f, 10.0f, 10.0f, 10.0f);
        LineDataSet lineDataSet = new LineDataSet(arrayList2, getString(R.string.mana_curve_total));
        lineDataSet.setDrawValues(false);
        lineDataSet.setColor(ContextCompat.getColor(deckDetailsActivity, R.color.almost_white));
        lineDataSet.setLineWidth(2.5f);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet.setCubicIntensity(0.2f);
        lineDataSet.setHighlightEnabled(false);
        LineData lineData = new LineData(lineDataSet);
        CombinedData combinedData = new CombinedData();
        combinedData.setData(barData);
        combinedData.setData(lineData);
        chart.setData(combinedData);
        ManaCurveMarkerView manaCurveMarkerView = new ManaCurveMarkerView(deckDetailsActivity, manaCurve);
        manaCurveMarkerView.setChartView(chart);
        chart.setMarker(manaCurveMarkerView);
        chart.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cycleDisplayMode() {
        DeckDisplayMode deckDisplayMode;
        if (isFinishing() || isDestroyed()) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentDisplayMode.ordinal()];
        if (i == 1) {
            deckDisplayMode = DeckDisplayMode.LIST;
        } else if (i == 2) {
            deckDisplayMode = DeckDisplayMode.ONE_COLUMN_STACKS;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            deckDisplayMode = DeckDisplayMode.TWO_COLUMN_STACKS;
        }
        this.currentDisplayMode = deckDisplayMode;
        new PreferencesManager(this).setString(PreferencesManager.LAST_DECK_LAYOUT_TYPE, this.currentDisplayMode.getValue());
        updateDisplayModeIcon();
        List<MTCardGroup> list = this.currentGroupedCards;
        if (list != null) {
            setupCardsAdapter(list);
        }
        if (this.sideboardExpanded) {
            updateSideboardVisibility();
            View viewFindViewById = findViewById(R.id.sideboardRecyclerView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ((RecyclerView) viewFindViewById).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda96
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.adjustSideboardRecyclerViewHeight();
                }
            });
        }
        if (this.maybeboardExpanded) {
            updateMaybeboardVisibility();
            View viewFindViewById2 = findViewById(R.id.maybeboardRecyclerView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            ((RecyclerView) viewFindViewById2).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda97
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.adjustMaybeboardRecyclerViewHeight();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object deleteAllCardsFromList(int i, int i2, Continuation<? super Unit> continuation) {
        MTCardContainer main;
        List<MTCardGroup> grouped_cards;
        List<MTFullCard> cards;
        ArrayList arrayList = new ArrayList();
        MTDeckLists mTDeckLists = this.currentLists;
        if (mTDeckLists != null && (main = mTDeckLists.getMain()) != null && (grouped_cards = main.getGrouped_cards()) != null) {
            for (MTCardGroup mTCardGroup : grouped_cards) {
                if (!Intrinsics.areEqual(mTCardGroup.getType(), "commander") && !Intrinsics.areEqual(mTCardGroup.getType(), "oathbreaker") && (cards = mTCardGroup.getCards()) != null) {
                    Iterator<T> it = cards.iterator();
                    while (it.hasNext()) {
                        arrayList.add((MTFullCard) it.next());
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return Unit.INSTANCE;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            List<Integer> list_card_ids = ((MTFullCard) it2.next()).getList_card_ids();
            if (list_card_ids != null) {
                Iterator<Integer> it3 = list_card_ids.iterator();
                while (it3.hasNext()) {
                    int iIntValue = it3.next().intValue();
                    MTCardReference mTCardReference = new MTCardReference(0, 1, null);
                    mTCardReference.setList_card_id(iIntValue);
                    arrayList2.add(mTCardReference);
                }
            }
        }
        MTEditCardBody mTEditCardBody = new MTEditCardBody(null, 1, null);
        mTEditCardBody.setCards(new MTEditCardActions(null, null, null, 7, null));
        MTEditCardActions cards2 = mTEditCardBody.getCards();
        if (cards2 != null) {
            cards2.setDeleted(arrayList2);
        }
        Call<MTCardListResponse> callEditCardsFromList = MTApiKt.getMtApi().editCardsFromList(i, i2, null, null, this.currentGroupBy, this.currentSortBy, this.currentSortDirection, Boxing.boxBoolean(true), Boxing.boxBoolean(this.ignoreCollection), Boxing.boxBoolean(this.ignoreBasicLands), Boxing.boxBoolean(this.ignorePrintings), mTEditCardBody);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        callEditCardsFromList.enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$deleteAllCardsFromList$4$1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Log.e("DeckImport", "Failed to delete cards: " + t.getMessage());
                cancellableContinuationImpl2.resume(Unit.INSTANCE, new Function1<Throwable, Unit>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$deleteAllCardsFromList$4$1$onFailure$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it4) {
                        Intrinsics.checkNotNullParameter(it4, "it");
                    }
                });
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                cancellableContinuationImpl2.resume(Unit.INSTANCE, new Function1<Throwable, Unit>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$deleteAllCardsFromList$4$1$onResponse$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it4) {
                        Intrinsics.checkNotNullParameter(it4, "it");
                    }
                });
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadAndShareFile(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request requestBuild = new Request.Builder().url(url).build();
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
        constraintLayout.setVisibility(0);
        okHttpClient.newCall(requestBuild).enqueue(new C11491(constraintLayout));
    }

    private final int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    private final void enterSelectionMode(MTFullCard card, Integer listId) {
        if (isOtherUserDeck() || this.isDuplicatedDeck) {
            return;
        }
        this.selectionMode = true;
        setEnabled(true);
        View viewFindViewById = findViewById(R.id.deckCardsToolbarLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((LinearLayout) viewFindViewById).setVisibility(8);
        View viewFindViewById2 = findViewById(R.id.deckSelectionToolbarLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ((LinearLayout) viewFindViewById2).setVisibility(0);
        wireSelectionToolbar();
        if (card != null && listId != null) {
            toggleCardSelection(card, listId.intValue());
        }
        propagateSelectionMode(true);
    }

    static /* synthetic */ void enterSelectionMode$default(DeckDetailsActivity deckDetailsActivity, MTFullCard mTFullCard, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            mTFullCard = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        deckDetailsActivity.enterSelectionMode(mTFullCard, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void exitSelectionMode() {
        this.selectionMode = false;
        this.selectedCards.clear();
        this.selectionLockedListId = null;
        setEnabled(false);
        View viewFindViewById = findViewById(R.id.deckSelectionToolbarLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((LinearLayout) viewFindViewById).setVisibility(8);
        if (this.currentTabIndex == 0) {
            View viewFindViewById2 = findViewById(R.id.deckCardsToolbarLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            ((LinearLayout) viewFindViewById2).setVisibility(0);
        }
        propagateSelectionMode(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchDeckIdCardIfNeeded(boolean force) {
        final MTDeck mTDeck;
        Integer num;
        Integer num2;
        if (this.isSmartDeck && (mTDeck = this.currentDeck) != null) {
            final int id = mTDeck.getId();
            MTUser currentUser = new PreferencesManager(this).getCurrentUser();
            if (currentUser != null) {
                int id2 = currentUser.getId();
                if (force || (num2 = this.idCardFetchedForDeckId) == null || num2.intValue() != id) {
                    if (force || (num = this.idCardFetchedForDeckId) == null || num.intValue() != id) {
                        this.deckIdCardResponse = null;
                        applyDeckIdCardScoresUi$default(this, null, null, 2, null);
                    }
                    MTApiKt.getMtApi().getDeckIdCard(id2, id, null).enqueue(new Callback<MTDeckIdCardResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity.fetchDeckIdCardIfNeeded.1
                        @Override // retrofit2.Callback
                        public void onFailure(Call<MTDeckIdCardResponse> call, Throwable t) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(t, "t");
                            if (DeckDetailsActivity.this.isFinishing() || DeckDetailsActivity.this.isDestroyed()) {
                                return;
                            }
                            Log.e("DeckIdCard", "id-card failure deckId=" + id, t);
                        }

                        @Override // retrofit2.Callback
                        public void onResponse(Call<MTDeckIdCardResponse> call, Response<MTDeckIdCardResponse> response) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(response, "response");
                            if (DeckDetailsActivity.this.isFinishing() || DeckDetailsActivity.this.isDestroyed()) {
                                return;
                            }
                            if (!response.isSuccessful()) {
                                Log.w("DeckIdCard", "id-card HTTP " + response.code() + " deckId=" + id);
                                return;
                            }
                            MTDeckIdCardResponse mTDeckIdCardResponseBody = response.body();
                            if (mTDeckIdCardResponseBody == null) {
                                return;
                            }
                            DeckDetailsActivity.this.idCardFetchedForDeckId = Integer.valueOf(id);
                            DeckDetailsActivity.this.deckIdCardResponse = mTDeckIdCardResponseBody;
                            Integer globalScore = mTDeckIdCardResponseBody.getGlobalScore();
                            MTIdCardPowerLevel powerLevel = mTDeckIdCardResponseBody.getPowerLevel();
                            Integer score = powerLevel != null ? powerLevel.getScore() : null;
                            MTIdCardManaBaseAnalysis manaBaseAnalysis = mTDeckIdCardResponseBody.getManaBaseAnalysis();
                            Integer score2 = manaBaseAnalysis != null ? manaBaseAnalysis.getScore() : null;
                            MTIdCardDeckHealthScore deckHealthScore = mTDeckIdCardResponseBody.getDeckHealthScore();
                            Log.d("DeckIdCard", "deck=" + mTDeck.getName() + " id=" + id + " global=" + globalScore + " power=" + score + " manabase=" + score2 + " health=" + (deckHealthScore != null ? deckHealthScore.getOverall() : null));
                            DeckDetailsActivity.this.applyDeckIdCardScoresUi(mTDeckIdCardResponseBody, Integer.valueOf(id));
                        }
                    });
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<MTCardGroup> filterGroupedCardsByName(List<MTCardGroup> groups, String query) {
        ArrayList arrayListEmptyList;
        boolean z;
        boolean z2;
        if (groups == null) {
            return CollectionsKt.emptyList();
        }
        String string = StringsKt.trim((CharSequence) query).toString();
        if (string.length() == 0) {
            return groups;
        }
        String lowerCase = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        ArrayList arrayList = new ArrayList();
        for (MTCardGroup mTCardGroup : groups) {
            List<MTFullCard> cards = mTCardGroup.getCards();
            MTCardGroup mTCardGroup2 = null;
            int iIntValue = 0;
            if (cards != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : cards) {
                    MTFullCard mTFullCard = (MTFullCard) obj;
                    String name = mTFullCard.getName();
                    if (name != null) {
                        String lowerCase2 = name.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        z = lowerCase2 != null && StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) lowerCase, false, 2, (Object) null);
                    }
                    String printed_name = mTFullCard.getPrinted_name();
                    if (printed_name != null) {
                        String lowerCase3 = printed_name.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                        z2 = lowerCase3 != null && StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) lowerCase, false, 2, (Object) null);
                    }
                    if (z || z2) {
                        arrayList2.add(obj);
                    }
                }
                arrayListEmptyList = arrayList2;
            } else {
                arrayListEmptyList = CollectionsKt.emptyList();
            }
            if (!arrayListEmptyList.isEmpty()) {
                String type = mTCardGroup.getType();
                Iterator it = arrayListEmptyList.iterator();
                while (it.hasNext()) {
                    Integer quantity = ((MTFullCard) it.next()).getQuantity();
                    iIntValue += quantity != null ? quantity.intValue() : 1;
                }
                mTCardGroup2 = new MTCardGroup(type, iIntValue, mTCardGroup.getTotal_count(), arrayListEmptyList);
            }
            if (mTCardGroup2 != null) {
                arrayList.add(mTCardGroup2);
            }
        }
        return arrayList;
    }

    private final Map<Integer, MTFullCard> filterSelectedCardsForAction() {
        Map<Integer, MTFullCard> map = this.selectedCards;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Integer, MTFullCard> entry : map.entrySet()) {
            if (!hasSpecialFlag(entry.getValue())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private final void findAllTextViews(View view, List<TextView> textViews) {
        if (view instanceof TextView) {
            textViews.add(view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                findAllTextViews(childAt, textViews);
            }
        }
    }

    static final void gameDetailsLauncher$lambda$0(DeckDetailsActivity deckDetailsActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            String stringExtra = data != null ? data.getStringExtra("updatedGame") : null;
            if (stringExtra != null) {
                MTGame mTGame = (MTGame) new Gson().fromJson(stringExtra, MTGame.class);
                Iterator<MTGame> it = deckDetailsActivity.games.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else if (it.next().getId() == mTGame.getId()) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    List<MTGame> list = deckDetailsActivity.games;
                    Intrinsics.checkNotNull(mTGame);
                    list.set(i, mTGame);
                    List<GameItemHolder> listGroupGamesWithSeparators = deckDetailsActivity.groupGamesWithSeparators(deckDetailsActivity.games);
                    View viewFindViewById = deckDetailsActivity.findViewById(R.id.gamesRecyclerView);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                    RecyclerView.Adapter adapter = ((RecyclerView) viewFindViewById).getAdapter();
                    GamesAdapter gamesAdapter = adapter instanceof GamesAdapter ? (GamesAdapter) adapter : null;
                    if (gamesAdapter != null) {
                        gamesAdapter.updateGames(listGroupGamesWithSeparators);
                    }
                    deckDetailsActivity.adjustRecyclerViewHeight();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[PHI: r4 r5 r6
      0x00b6: PHI (r4v8 com.studiolaganne.lengendarylens.GameItemHolder) = (r4v1 com.studiolaganne.lengendarylens.GameItemHolder), (r4v16 com.studiolaganne.lengendarylens.GameItemHolder) binds: [B:13:0x004c, B:27:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x00b6: PHI (r5v7 java.lang.Integer) = (r5v1 java.lang.Integer), (r5v12 java.lang.Integer) binds: [B:13:0x004c, B:27:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x00b6: PHI (r6v6 java.lang.String) = (r6v1 java.lang.String), (r6v12 java.lang.String) binds: [B:13:0x004c, B:27:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0102 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x001e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<GameItemHolder> groupGamesWithSeparators(List<MTGame> games) {
        int i;
        Object objValueOf;
        List<MTGame> subgames;
        if (isFinishing() || isDestroyed()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        GameItemHolder gameItemHolder = null;
        Integer numValueOf = null;
        String str = null;
        for (MTGame mTGame : games) {
            String relativeTimestamp = ServerUtils.INSTANCE.getInstance().formatRelativeTimestamp(mTGame.getEnded_at(), this);
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                MTSet set = mTGame.getSet();
                if (set == null) {
                    if (gameItemHolder != null) {
                        arrayList.add(gameItemHolder);
                        gameItemHolder = null;
                        numValueOf = null;
                    }
                    if (!Intrinsics.areEqual(relativeTimestamp, str)) {
                        arrayList.add(new GameItemHolder(2, null, null, 0, null, relativeTimestamp, false, 94, null));
                        str = relativeTimestamp;
                    }
                    i = 1;
                    objValueOf = Boolean.valueOf(arrayList.add(new GameItemHolder(1, mTGame, null, 0, null, null, false, 124, null)));
                    if (objValueOf != null) {
                    }
                } else {
                    if (set.getId() == iIntValue) {
                        objValueOf = (gameItemHolder == null || (subgames = gameItemHolder.getSubgames()) == null) ? null : Boolean.valueOf(subgames.add(mTGame));
                    } else {
                        if (gameItemHolder != null) {
                            arrayList.add(gameItemHolder);
                        }
                        if (!Intrinsics.areEqual(relativeTimestamp, str)) {
                            arrayList.add(new GameItemHolder(2, null, null, 0, null, relativeTimestamp, false, 94, null));
                            str = relativeTimestamp;
                        }
                        numValueOf = Integer.valueOf(set.getId());
                        GameItemHolder gameItemHolder2 = new GameItemHolder(4, null, set, set.getOutOf(), CollectionsKt.mutableListOf(mTGame), null, false, 98, null);
                        objValueOf = Unit.INSTANCE;
                        gameItemHolder = gameItemHolder2;
                    }
                    if (objValueOf != null) {
                        i = 1;
                    }
                    if (objValueOf != null) {
                    }
                }
            } else {
                i = 1;
            }
            if (Intrinsics.areEqual(relativeTimestamp, str)) {
                relativeTimestamp = str;
            } else {
                arrayList.add(new GameItemHolder(2, null, null, 0, null, relativeTimestamp, false, 94, null));
            }
            MTSet set2 = mTGame.getSet();
            if (set2 != null) {
                numValueOf = Integer.valueOf(set2.getId());
                MTGame[] mTGameArr = new MTGame[i];
                mTGameArr[0] = mTGame;
                GameItemHolder gameItemHolder3 = new GameItemHolder(4, null, set2, set2.getOutOf(), CollectionsKt.mutableListOf(mTGameArr), null, false, 98, null);
                Unit unit = Unit.INSTANCE;
                gameItemHolder = gameItemHolder3;
            } else {
                Boolean.valueOf(arrayList.add(new GameItemHolder(1, mTGame, null, 0, null, null, false, 124, null)));
            }
            str = relativeTimestamp;
        }
        if (gameItemHolder != null) {
            arrayList.add(gameItemHolder);
        }
        if (this.shouldShowLoadMore) {
            arrayList.add(new GameItemHolder(3, null, null, 0, null, null, false, 126, null));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dc A[PHI: r4 r5
      0x00dc: PHI (r4v9 com.studiolaganne.lengendarylens.GameItemHolder) = (r4v4 com.studiolaganne.lengendarylens.GameItemHolder), (r4v16 com.studiolaganne.lengendarylens.GameItemHolder) binds: [B:22:0x0090, B:33:0x00d7] A[DONT_GENERATE, DONT_INLINE]
      0x00dc: PHI (r5v6 java.lang.Integer) = (r5v2 java.lang.Integer), (r5v12 java.lang.Integer) binds: [B:22:0x0090, B:33:0x00d7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x003e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<GameItemHolder> groupNewGamesWithSeparators(List<MTGame> newGames, String lastExistingGameTimestamp) {
        int i;
        Object objValueOf;
        List<MTGame> subgames;
        if (isFinishing() || isDestroyed()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        String relativeTimestamp = lastExistingGameTimestamp != null ? ServerUtils.INSTANCE.getInstance().formatRelativeTimestamp(lastExistingGameTimestamp, this) : null;
        GameItemHolder gameItemHolder = null;
        Integer numValueOf = null;
        for (MTGame mTGame : CollectionsKt.sortedWith(newGames, new Comparator() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$groupNewGamesWithSeparators$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((MTGame) t2).getEnded_at(), ((MTGame) t).getEnded_at());
            }
        })) {
            String relativeTimestamp2 = ServerUtils.INSTANCE.getInstance().formatRelativeTimestamp(mTGame.getEnded_at(), this);
            if (!Intrinsics.areEqual(relativeTimestamp2, relativeTimestamp)) {
                if (gameItemHolder != null) {
                    arrayList.add(gameItemHolder);
                    gameItemHolder = null;
                    numValueOf = null;
                }
                arrayList.add(new GameItemHolder(2, null, null, 0, null, relativeTimestamp2, false, 94, null));
                relativeTimestamp = relativeTimestamp2;
            }
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                MTSet set = mTGame.getSet();
                if (set == null) {
                    if (gameItemHolder != null) {
                        arrayList.add(gameItemHolder);
                        gameItemHolder = null;
                        numValueOf = null;
                    }
                    i = 1;
                    objValueOf = Boolean.valueOf(arrayList.add(new GameItemHolder(1, mTGame, null, 0, null, null, false, 124, null)));
                    if (objValueOf != null) {
                    }
                } else {
                    if (set.getId() == iIntValue) {
                        objValueOf = (gameItemHolder == null || (subgames = gameItemHolder.getSubgames()) == null) ? null : Boolean.valueOf(subgames.add(mTGame));
                    } else {
                        if (gameItemHolder != null) {
                            arrayList.add(gameItemHolder);
                        }
                        Integer numValueOf2 = Integer.valueOf(set.getId());
                        GameItemHolder gameItemHolder2 = new GameItemHolder(4, null, set, set.getOutOf(), CollectionsKt.mutableListOf(mTGame), null, false, 98, null);
                        objValueOf = Unit.INSTANCE;
                        numValueOf = numValueOf2;
                        gameItemHolder = gameItemHolder2;
                    }
                    if (objValueOf != null) {
                        i = 1;
                    }
                    if (objValueOf != null) {
                    }
                }
            } else {
                i = 1;
            }
            MTSet set2 = mTGame.getSet();
            if (set2 != null) {
                numValueOf = Integer.valueOf(set2.getId());
                MTGame[] mTGameArr = new MTGame[i];
                mTGameArr[0] = mTGame;
                GameItemHolder gameItemHolder3 = new GameItemHolder(4, null, set2, set2.getOutOf(), CollectionsKt.mutableListOf(mTGameArr), null, false, 98, null);
                Unit unit = Unit.INSTANCE;
                gameItemHolder = gameItemHolder3;
            } else {
                Boolean.valueOf(arrayList.add(new GameItemHolder(1, mTGame, null, 0, null, null, false, 124, null)));
            }
        }
        if (gameItemHolder != null) {
            arrayList.add(gameItemHolder);
        }
        return arrayList;
    }

    private final void handleCsvDeckImport(InputStream inputStream, boolean replaceAll) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C11521(inputStream, this, replaceAll, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDeckImport(DeckImportResult result) {
        if (result.getUrl() != null) {
            handleManualSync(result.getUrl());
            return;
        }
        if (result.getParsedDeckList() != null) {
            showDeckImportConfirmationWithSections(result.getParsedDeckList(), result.getReplaceAllCards());
            return;
        }
        if (result.getCards() != null) {
            showDeckImportConfirmation(result.getCards(), result.getReplaceAllCards());
            return;
        }
        if (result.getInputStream() == null) {
            Toast.makeText(this, getString(R.string.no_data_to_import), 0).show();
            return;
        }
        String fileName = result.getFileName();
        if (fileName == null) {
            fileName = "unknown";
        }
        if (StringsKt.endsWith(fileName, ".txt", true)) {
            showDeckImportConfirmationWithSections(new DeckListTxtParser().parseInputStream(result.getInputStream()), result.getReplaceAllCards());
            return;
        }
        if (StringsKt.endsWith(fileName, ".csv", true)) {
            handleCsvDeckImport(result.getInputStream(), result.getReplaceAllCards());
            return;
        }
        if (StringsKt.endsWith(fileName, ".dek", true)) {
            showDeckImportConfirmationWithSections(new DeckListDekParser().parseInputStream(result.getInputStream()), result.getReplaceAllCards());
        } else if (StringsKt.endsWith(fileName, ".xml", true)) {
            showDeckImportConfirmationWithSections(new DeckListDekParser().parseInputStream(result.getInputStream()), result.getReplaceAllCards());
        } else {
            Toast.makeText(this, getString(R.string.unsupported_file_format), 0).show();
        }
    }

    private final void handleManualSync(String url) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        MTDeck mTDeck = this.currentDeck;
        if (mTDeck == null) {
            Toast.makeText(this, getString(R.string.no_deck_loaded), 0).show();
            return;
        }
        DeckDetailsActivity deckDetailsActivity = this;
        MTUser currentUser = new PreferencesManager(deckDetailsActivity).getCurrentUser();
        if (currentUser == null) {
            Toast.makeText(deckDetailsActivity, getString(R.string.server_error), 0).show();
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        MTApiKt.getMtApi().getExternalDeckUpdates(currentUser.getId(), mTDeck.getId(), url).enqueue(new C11531(constraintLayout, url));
    }

    private final boolean hasSpecialFlag(MTFullCard card) {
        Integer flag = card.getFlag();
        if (flag == null) {
            return false;
        }
        int iIntValue = flag.intValue();
        return iIntValue == 1 || iIntValue == 2 || iIntValue == 3 || iIntValue == 4 || iIntValue == 5;
    }

    private final void hideAddButton() {
        if (this.addButtonHidden) {
            return;
        }
        this.addButtonHidden = true;
        View viewFindViewById = findViewById(R.id.addButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.scanButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.legacyAddButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        final ConstraintLayout constraintLayout3 = (ConstraintLayout) viewFindViewById3;
        constraintLayout.animate().cancel();
        constraintLayout2.animate().cancel();
        constraintLayout3.animate().cancel();
        constraintLayout.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda64
            @Override // java.lang.Runnable
            public final void run() {
                DeckDetailsActivity.hideAddButton$lambda$0(constraintLayout);
            }
        }).start();
        constraintLayout2.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda65
            @Override // java.lang.Runnable
            public final void run() {
                DeckDetailsActivity.hideAddButton$lambda$1(constraintLayout2);
            }
        }).start();
        if (this.showLegacyAddButton) {
            constraintLayout3.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda67
                @Override // java.lang.Runnable
                public final void run() {
                    DeckDetailsActivity.hideAddButton$lambda$2(constraintLayout3);
                }
            }).start();
            ((CustomGlowView) findViewById(R.id.addButtonGlowView)).setVisibility(8);
        }
    }

    static final void hideAddButton$lambda$0(ConstraintLayout constraintLayout) {
        constraintLayout.setClickable(false);
        constraintLayout.setFocusable(false);
    }

    static final void hideAddButton$lambda$1(ConstraintLayout constraintLayout) {
        constraintLayout.setClickable(false);
        constraintLayout.setFocusable(false);
    }

    static final void hideAddButton$lambda$2(ConstraintLayout constraintLayout) {
        constraintLayout.setClickable(false);
        constraintLayout.setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoadingOverlay() {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    private final void importCardsFromList(List<ParsedCard> cards, boolean replaceAll) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C11541(cards, replaceAll, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0131 A[Catch: all -> 0x004f, TryCatch #1 {all -> 0x004f, blocks: (B:13:0x004a, B:53:0x012d, B:55:0x0131, B:57:0x0137, B:59:0x013f, B:62:0x0147, B:63:0x014a, B:65:0x0152, B:68:0x015b, B:70:0x015f, B:72:0x0169, B:74:0x0171, B:75:0x0173, B:77:0x0177, B:78:0x017a, B:80:0x0182, B:82:0x0198), top: B:94:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0198 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #1 {all -> 0x004f, blocks: (B:13:0x004a, B:53:0x012d, B:55:0x0131, B:57:0x0137, B:59:0x013f, B:62:0x0147, B:63:0x014a, B:65:0x0152, B:68:0x015b, B:70:0x015f, B:72:0x0169, B:74:0x0171, B:75:0x0173, B:77:0x0177, B:78:0x017a, B:80:0x0182, B:82:0x0198), top: B:94:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01af  */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r1v16, types: [androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object importCardsFromListAsync(List<ParsedCard> list, boolean z, Continuation<? super Unit> continuation) throws Throwable {
        C11551 c11551;
        ?? r1;
        MTDeck mTDeck;
        Integer listid;
        PreferencesManager preferencesManager;
        MTUser currentUser;
        List<ParsedCard> list2;
        MTUser mTUser;
        List<ParsedCard> list3;
        ConstraintLayout constraintLayout;
        Response response;
        Unit unit;
        boolean z2 = z;
        if (continuation instanceof C11551) {
            c11551 = (C11551) continuation;
            if ((c11551.label & Integer.MIN_VALUE) != 0) {
                c11551.label -= Integer.MIN_VALUE;
            } else {
                c11551 = new C11551(continuation);
            }
        }
        Object objAddCardsToListSync = c11551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r5 = c11551.label;
        try {
            if (r5 == 0) {
                ResultKt.throwOnFailure(objAddCardsToListSync);
                if (list.isEmpty()) {
                    Toast.makeText(this, getString(R.string.no_valid_cards_found), 0).show();
                    return Unit.INSTANCE;
                }
                mTDeck = this.currentDeck;
                listid = mTDeck != null ? mTDeck.getListid() : null;
                if (mTDeck == null || listid == null) {
                    Toast.makeText(this, getString(R.string.no_deck_loaded), 0).show();
                    return Unit.INSTANCE;
                }
                preferencesManager = new PreferencesManager(this);
                currentUser = preferencesManager.getCurrentUser();
                if (currentUser == null) {
                    return Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R.id.overlay);
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(0);
                }
                if (!z2) {
                    list2 = list;
                    r5 = constraintLayout2;
                    int id = currentUser.getId();
                    int iIntValue = listid.intValue();
                    c11551.L$0 = list2;
                    c11551.L$1 = SpillingKt.nullOutSpilledVariable(mTDeck);
                    c11551.L$2 = SpillingKt.nullOutSpilledVariable(listid);
                    c11551.L$3 = SpillingKt.nullOutSpilledVariable(preferencesManager);
                    c11551.L$4 = SpillingKt.nullOutSpilledVariable(currentUser);
                    c11551.L$5 = r5;
                    c11551.Z$0 = z2;
                    c11551.label = 2;
                    objAddCardsToListSync = addCardsToListSync(id, iIntValue, list2, c11551);
                    if (objAddCardsToListSync != coroutine_suspended) {
                        r1 = r5;
                        list3 = list2;
                        response = (Response) objAddCardsToListSync;
                        if (response == null) {
                        }
                        if (r1 != 0) {
                        }
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
                int id2 = currentUser.getId();
                int iIntValue2 = listid.intValue();
                c11551.L$0 = list;
                c11551.L$1 = SpillingKt.nullOutSpilledVariable(mTDeck);
                c11551.L$2 = listid;
                c11551.L$3 = SpillingKt.nullOutSpilledVariable(preferencesManager);
                c11551.L$4 = currentUser;
                c11551.L$5 = constraintLayout2;
                c11551.Z$0 = z2;
                c11551.label = 1;
                if (deleteAllCardsFromList(id2, iIntValue2, c11551) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mTUser = currentUser;
                list2 = list;
                constraintLayout = constraintLayout2;
            } else {
                if (r5 != 1) {
                    if (r5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z3 = c11551.Z$0;
                    r1 = (ConstraintLayout) c11551.L$5;
                    list3 = (List) c11551.L$0;
                    try {
                        ResultKt.throwOnFailure(objAddCardsToListSync);
                        r1 = r1;
                        response = (Response) objAddCardsToListSync;
                        if (response == null) {
                            DeckDetailsActivity deckDetailsActivity = this;
                            Toast.makeText(this, getString(R.string.unable_to_import_cards), 0).show();
                        } else {
                            if (response.isSuccessful()) {
                                MTCardListResponse mTCardListResponse = (MTCardListResponse) response.body();
                                MTAddCardsResult result = mTCardListResponse != null ? mTCardListResponse.getResult() : null;
                                if (result != null) {
                                    showDeckImportResults(result, list3);
                                }
                                MTCardListResponse mTCardListResponse2 = (MTCardListResponse) response.body();
                                MTCardContainer list4 = mTCardListResponse2 != null ? mTCardListResponse2.getList() : null;
                                if (list4 != null) {
                                    MTDeckLists mTDeckLists = this.currentLists;
                                    this.currentLists = mTDeckLists != null ? MTDeckLists.copy$default(mTDeckLists, list4, null, null, 6, null) : null;
                                    List<MTCardGroup> grouped_cards = list4.getGrouped_cards();
                                    if (grouped_cards != null) {
                                        this.currentGroupedCards = grouped_cards;
                                    }
                                    List<MTCardGroup> list5 = this.currentGroupedCards;
                                    if (list5 != null) {
                                        setupCardsAdapter(list5);
                                    }
                                    onDeckListModified();
                                    unit = Unit.INSTANCE;
                                } else {
                                    unit = null;
                                }
                            } else {
                                Toast.makeText(this, getString(R.string.unable_to_import_cards), 0).show();
                                unit = Unit.INSTANCE;
                            }
                            if (unit == null) {
                            }
                        }
                        if (r1 != 0) {
                            r1.setVisibility(8);
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        if (r1 != 0) {
                            r1.setVisibility(8);
                        }
                        throw th;
                    }
                }
                z2 = c11551.Z$0;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) c11551.L$5;
                mTUser = (MTUser) c11551.L$4;
                preferencesManager = (PreferencesManager) c11551.L$3;
                listid = (Integer) c11551.L$2;
                mTDeck = (MTDeck) c11551.L$1;
                list2 = (List) c11551.L$0;
                ResultKt.throwOnFailure(objAddCardsToListSync);
                constraintLayout = constraintLayout3;
            }
            currentUser = mTUser;
            r5 = constraintLayout;
            int id3 = currentUser.getId();
            int iIntValue3 = listid.intValue();
            c11551.L$0 = list2;
            c11551.L$1 = SpillingKt.nullOutSpilledVariable(mTDeck);
            c11551.L$2 = SpillingKt.nullOutSpilledVariable(listid);
            c11551.L$3 = SpillingKt.nullOutSpilledVariable(preferencesManager);
            c11551.L$4 = SpillingKt.nullOutSpilledVariable(currentUser);
            c11551.L$5 = r5;
            c11551.Z$0 = z2;
            c11551.label = 2;
            objAddCardsToListSync = addCardsToListSync(id3, iIntValue3, list2, c11551);
            if (objAddCardsToListSync != coroutine_suspended) {
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            r1 = r5;
        }
    }

    private final void importCardsFromListWithSections(ParsedDeckList parsedDeckList, boolean replaceAll) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C11561(parsedDeckList, replaceAll, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x059d, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r9, r5, r3) == r4) goto L193;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x039c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0478 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04e2 A[Catch: all -> 0x0067, TryCatch #3 {all -> 0x0067, blocks: (B:13:0x0062, B:162:0x04d0, B:164:0x04d4, B:166:0x04da, B:168:0x04e2, B:171:0x04ea, B:172:0x04fa, B:174:0x0502, B:176:0x0508, B:178:0x050c, B:180:0x051c, B:181:0x051e, B:183:0x0522, B:184:0x0525, B:188:0x0538, B:190:0x0541, B:191:0x0544, B:133:0x03ff, B:155:0x046c, B:158:0x047a, B:90:0x0316, B:120:0x0390, B:123:0x039e), top: B:209:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04ea A[Catch: all -> 0x0067, TryCatch #3 {all -> 0x0067, blocks: (B:13:0x0062, B:162:0x04d0, B:164:0x04d4, B:166:0x04da, B:168:0x04e2, B:171:0x04ea, B:172:0x04fa, B:174:0x0502, B:176:0x0508, B:178:0x050c, B:180:0x051c, B:181:0x051e, B:183:0x0522, B:184:0x0525, B:188:0x0538, B:190:0x0541, B:191:0x0544, B:133:0x03ff, B:155:0x046c, B:158:0x047a, B:90:0x0316, B:120:0x0390, B:123:0x039e), top: B:209:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x050c A[Catch: all -> 0x0067, TryCatch #3 {all -> 0x0067, blocks: (B:13:0x0062, B:162:0x04d0, B:164:0x04d4, B:166:0x04da, B:168:0x04e2, B:171:0x04ea, B:172:0x04fa, B:174:0x0502, B:176:0x0508, B:178:0x050c, B:180:0x051c, B:181:0x051e, B:183:0x0522, B:184:0x0525, B:188:0x0538, B:190:0x0541, B:191:0x0544, B:133:0x03ff, B:155:0x046c, B:158:0x047a, B:90:0x0316, B:120:0x0390, B:123:0x039e), top: B:209:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0522 A[Catch: all -> 0x0067, TryCatch #3 {all -> 0x0067, blocks: (B:13:0x0062, B:162:0x04d0, B:164:0x04d4, B:166:0x04da, B:168:0x04e2, B:171:0x04ea, B:172:0x04fa, B:174:0x0502, B:176:0x0508, B:178:0x050c, B:180:0x051c, B:181:0x051e, B:183:0x0522, B:184:0x0525, B:188:0x0538, B:190:0x0541, B:191:0x0544, B:133:0x03ff, B:155:0x046c, B:158:0x047a, B:90:0x0316, B:120:0x0390, B:123:0x039e), top: B:209:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0541 A[Catch: all -> 0x0067, TryCatch #3 {all -> 0x0067, blocks: (B:13:0x0062, B:162:0x04d0, B:164:0x04d4, B:166:0x04da, B:168:0x04e2, B:171:0x04ea, B:172:0x04fa, B:174:0x0502, B:176:0x0508, B:178:0x050c, B:180:0x051c, B:181:0x051e, B:183:0x0522, B:184:0x0525, B:188:0x0538, B:190:0x0541, B:191:0x0544, B:133:0x03ff, B:155:0x046c, B:158:0x047a, B:90:0x0316, B:120:0x0390, B:123:0x039e), top: B:209:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x023d A[Catch: all -> 0x0285, TryCatch #1 {all -> 0x0285, blocks: (B:78:0x029b, B:80:0x02b5, B:68:0x023d, B:63:0x01fd), top: B:205:0x01fd }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02b5 A[Catch: all -> 0x0285, TRY_LEAVE, TryCatch #1 {all -> 0x0285, blocks: (B:78:0x029b, B:80:0x02b5, B:68:0x023d, B:63:0x01fd), top: B:205:0x01fd }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v59, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v64, types: [androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r1v67 */
    /* JADX WARN: Type inference failed for: r1v68 */
    /* JADX WARN: Type inference failed for: r1v69 */
    /* JADX WARN: Type inference failed for: r1v70 */
    /* JADX WARN: Type inference failed for: r1v71 */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r1v73 */
    /* JADX WARN: Type inference failed for: r1v74 */
    /* JADX WARN: Type inference failed for: r1v75 */
    /* JADX WARN: Type inference failed for: r1v76 */
    /* JADX WARN: Type inference failed for: r1v77 */
    /* JADX WARN: Type inference failed for: r1v78 */
    /* JADX WARN: Type inference failed for: r1v79 */
    /* JADX WARN: Type inference failed for: r1v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r1v81 */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.studiolaganne.lengendarylens.DeckDetailsActivity] */
    /* JADX WARN: Type inference failed for: r25v10 */
    /* JADX WARN: Type inference failed for: r25v11 */
    /* JADX WARN: Type inference failed for: r25v14 */
    /* JADX WARN: Type inference failed for: r25v15 */
    /* JADX WARN: Type inference failed for: r25v16 */
    /* JADX WARN: Type inference failed for: r25v17 */
    /* JADX WARN: Type inference failed for: r25v18 */
    /* JADX WARN: Type inference failed for: r25v20 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r25v6 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r25v8 */
    /* JADX WARN: Type inference failed for: r25v9 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object importCardsFromListWithSectionsAsync(ParsedDeckList parsedDeckList, boolean z, Continuation<? super Unit> continuation) throws Throwable {
        C11571 c11571;
        MTDeck mTDeck;
        Integer listid;
        ConstraintLayout constraintLayout;
        Integer num;
        Integer num2;
        List list;
        PreferencesManager preferencesManager;
        ParsedDeckList parsedDeckList2;
        Integer num3;
        MTUser mTUser;
        MTDeck mTDeck2;
        Integer num4;
        MTUser mTUser2;
        Integer num5;
        PreferencesManager preferencesManager2;
        List list2;
        ParsedDeckList parsedDeckList3;
        ?? r1;
        ConstraintLayout constraintLayout2;
        List list3;
        ?? r12;
        ArrayList arrayList;
        List list4;
        ParsedDeckList parsedDeckList4;
        MTDeck mTDeck3;
        ?? r2;
        ?? r13;
        Integer num6;
        Object objAddCardsToListSync;
        ?? r22;
        ?? r14;
        ?? r15;
        List list5;
        PreferencesManager preferencesManager3;
        List list6;
        Integer num7;
        List list7;
        Integer num8;
        MTUser mTUser3;
        ParsedDeckList parsedDeckList5;
        MTDeck mTDeck4;
        Integer num9;
        Object objAddCardsToListSync2;
        PreferencesManager preferencesManager4;
        Integer num10;
        Integer num11;
        Response response;
        ?? r25;
        MTAddCardsResult result;
        ?? r23;
        ?? r16;
        ParsedDeckList parsedDeckList6;
        List list8;
        MTUser mTUser4;
        Object objAddCardsToListSync3;
        List list9;
        List list10;
        ?? r24;
        Response response2;
        ?? r252;
        MTAddCardsResult result2;
        MTCardContainer list11;
        ?? r26;
        ?? r17;
        ?? r27;
        ?? r18;
        Response response3;
        MTAddCardsResult result3;
        MTCardListResponse mTCardListResponse;
        List<MTCardGroup> list12;
        MTCardContainer list13;
        ?? r19;
        ?? r110 = z;
        if (continuation instanceof C11571) {
            c11571 = (C11571) continuation;
            if ((c11571.label & Integer.MIN_VALUE) != 0) {
                c11571.label -= Integer.MIN_VALUE;
            } else {
                c11571 = new C11571(continuation);
            }
        }
        Object obj = c11571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r5 = c11571.label;
        try {
            try {
                try {
                    switch (r5) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            List listPlus = CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) parsedDeckList.getMainDeckCards(), (Iterable) parsedDeckList.getSideboardCards()), (Iterable) parsedDeckList.getMaybeboardCards());
                            if (listPlus.isEmpty()) {
                                Toast.makeText((Context) this, getString(R.string.no_valid_cards_found), 0).show();
                                return Unit.INSTANCE;
                            }
                            mTDeck = this.currentDeck;
                            listid = mTDeck != null ? mTDeck.getListid() : null;
                            Integer sideboardlistid = mTDeck != null ? mTDeck.getSideboardlistid() : null;
                            Integer maybeboardlistid = mTDeck != null ? mTDeck.getMaybeboardlistid() : null;
                            if (mTDeck == null || listid == null) {
                                Toast.makeText((Context) this, getString(R.string.no_deck_loaded), 0).show();
                                return Unit.INSTANCE;
                            }
                            PreferencesManager preferencesManager5 = new PreferencesManager((Context) this);
                            MTUser currentUser = preferencesManager5.getCurrentUser();
                            if (currentUser == null) {
                                return Unit.INSTANCE;
                            }
                            constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
                            if (constraintLayout != null) {
                                constraintLayout.setVisibility(0);
                            }
                            if (r110 != 0) {
                                try {
                                    int id = currentUser.getId();
                                    int iIntValue = listid.intValue();
                                    c11571.L$0 = parsedDeckList;
                                    c11571.L$1 = SpillingKt.nullOutSpilledVariable(listPlus);
                                    c11571.L$2 = SpillingKt.nullOutSpilledVariable(mTDeck);
                                    c11571.L$3 = listid;
                                    c11571.L$4 = sideboardlistid;
                                    c11571.L$5 = maybeboardlistid;
                                    c11571.L$6 = SpillingKt.nullOutSpilledVariable(preferencesManager5);
                                    c11571.L$7 = currentUser;
                                    c11571.L$8 = constraintLayout;
                                    c11571.Z$0 = r110;
                                    c11571.label = 1;
                                    if (deleteAllCardsFromList(id, iIntValue, c11571) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    Integer num12 = maybeboardlistid;
                                    num = sideboardlistid;
                                    num2 = num12;
                                    list = listPlus;
                                    preferencesManager = preferencesManager5;
                                    parsedDeckList2 = parsedDeckList;
                                    num3 = listid;
                                    mTUser = currentUser;
                                    mTDeck2 = mTDeck;
                                    r1 = r110;
                                    if (num == null) {
                                        int iIntValue2 = num.intValue();
                                        int id2 = mTUser.getId();
                                        c11571.L$0 = parsedDeckList2;
                                        c11571.L$1 = SpillingKt.nullOutSpilledVariable(list);
                                        c11571.L$2 = SpillingKt.nullOutSpilledVariable(mTDeck2);
                                        c11571.L$3 = num3;
                                        c11571.L$4 = num;
                                        c11571.L$5 = num2;
                                        c11571.L$6 = SpillingKt.nullOutSpilledVariable(preferencesManager);
                                        c11571.L$7 = mTUser;
                                        c11571.L$8 = constraintLayout;
                                        c11571.Z$0 = r1;
                                        c11571.I$0 = iIntValue2;
                                        c11571.I$1 = 0;
                                        c11571.label = 2;
                                        if (deleteAllCardsFromList(id2, iIntValue2, c11571) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        constraintLayout2 = constraintLayout;
                                        list3 = list;
                                        parsedDeckList3 = parsedDeckList2;
                                        r15 = r1;
                                        Integer num13 = num2;
                                        mTUser2 = mTUser;
                                        listid = num3;
                                        num5 = num13;
                                        list2 = list3;
                                        constraintLayout = constraintLayout2;
                                        r14 = r15;
                                        mTDeck = mTDeck2;
                                        num4 = num;
                                        preferencesManager2 = preferencesManager;
                                        r12 = r14;
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList = new ArrayList();
                                        if (parsedDeckList3.getMainDeckCards().isEmpty()) {
                                            int id3 = mTUser2.getId();
                                            MTDeck mTDeck5 = mTDeck;
                                            int iIntValue3 = listid.intValue();
                                            Integer num14 = listid;
                                            List<ParsedCard> mainDeckCards = parsedDeckList3.getMainDeckCards();
                                            c11571.L$0 = parsedDeckList3;
                                            PreferencesManager preferencesManager6 = preferencesManager2;
                                            c11571.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                                            c11571.L$2 = SpillingKt.nullOutSpilledVariable(mTDeck5);
                                            c11571.L$3 = SpillingKt.nullOutSpilledVariable(num14);
                                            c11571.L$4 = num4;
                                            c11571.L$5 = num5;
                                            c11571.L$6 = SpillingKt.nullOutSpilledVariable(preferencesManager6);
                                            c11571.L$7 = mTUser2;
                                            c11571.L$8 = constraintLayout;
                                            c11571.L$9 = arrayList2;
                                            c11571.L$10 = arrayList;
                                            c11571.Z$0 = r12;
                                            c11571.label = 3;
                                            objAddCardsToListSync = addCardsToListSync(id3, iIntValue3, mainDeckCards, c11571);
                                            if (objAddCardsToListSync != coroutine_suspended) {
                                                list4 = arrayList2;
                                                parsedDeckList4 = parsedDeckList3;
                                                preferencesManager2 = preferencesManager6;
                                                mTDeck3 = mTDeck5;
                                                r22 = r12;
                                                r110 = constraintLayout;
                                                num6 = num14;
                                                try {
                                                    response = (Response) objAddCardsToListSync;
                                                    if (response == null && response.isSuccessful()) {
                                                        MTCardListResponse mTCardListResponse2 = (MTCardListResponse) response.body();
                                                        if (mTCardListResponse2 != null) {
                                                            r25 = r110;
                                                            result = mTCardListResponse2.getResult();
                                                        } else {
                                                            r25 = r110;
                                                            result = null;
                                                        }
                                                        if (result != null) {
                                                            try {
                                                                list4.add(result);
                                                                Boxing.boxBoolean(arrayList.addAll(parsedDeckList4.getMainDeckCards()));
                                                            } catch (Throwable th) {
                                                                th = th;
                                                                r110 = r25;
                                                                if (r110 != 0) {
                                                                }
                                                                throw th;
                                                            }
                                                        }
                                                        MTCardListResponse mTCardListResponse3 = (MTCardListResponse) response.body();
                                                        MTCardContainer list14 = mTCardListResponse3 != null ? mTCardListResponse3.getList() : null;
                                                        if (list14 != null) {
                                                            MTDeckLists mTDeckLists = this.currentLists;
                                                            this.currentLists = mTDeckLists != null ? MTDeckLists.copy$default(mTDeckLists, list14, null, null, 6, null) : null;
                                                            List<MTCardGroup> grouped_cards = list14.getGrouped_cards();
                                                            if (grouped_cards != null) {
                                                                this.currentGroupedCards = grouped_cards;
                                                            }
                                                            List<MTCardGroup> list15 = this.currentGroupedCards;
                                                            if (list15 != null) {
                                                                setupCardsAdapter(list15);
                                                            }
                                                            updateBottomBar();
                                                        }
                                                    } else {
                                                        r25 = r110;
                                                    }
                                                    r13 = r25;
                                                    r2 = r22;
                                                    list5 = arrayList;
                                                    if (!parsedDeckList4.getSideboardCards().isEmpty() || num4 == null) {
                                                        Integer num15 = num4;
                                                        Integer num16 = num6;
                                                        preferencesManager3 = preferencesManager2;
                                                        list6 = list4;
                                                        num7 = num5;
                                                        list7 = list2;
                                                        num8 = num16;
                                                        mTUser3 = mTUser2;
                                                        parsedDeckList5 = parsedDeckList4;
                                                        mTDeck4 = mTDeck3;
                                                        num9 = num15;
                                                        r16 = r13;
                                                        r23 = r2;
                                                        if (!parsedDeckList5.getMaybeboardCards().isEmpty() || num7 == null) {
                                                            parsedDeckList6 = parsedDeckList5;
                                                            list8 = list7;
                                                            mTUser4 = mTUser3;
                                                            r17 = r16;
                                                            r26 = r23;
                                                            ParsedDeckList parsedDeckList7 = parsedDeckList6;
                                                            if (!list6.isEmpty()) {
                                                                showDeckImportResultsWithSections(list6, parsedDeckList7);
                                                            }
                                                            MainCoroutineDispatcher main = Dispatchers.getMain();
                                                            List list16 = list5;
                                                            AnonymousClass6 anonymousClass6 = new AnonymousClass6(null);
                                                            c11571.L$0 = SpillingKt.nullOutSpilledVariable(parsedDeckList7);
                                                            c11571.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                                                            c11571.L$2 = SpillingKt.nullOutSpilledVariable(mTDeck4);
                                                            c11571.L$3 = SpillingKt.nullOutSpilledVariable(num8);
                                                            c11571.L$4 = SpillingKt.nullOutSpilledVariable(num9);
                                                            c11571.L$5 = SpillingKt.nullOutSpilledVariable(num7);
                                                            c11571.L$6 = SpillingKt.nullOutSpilledVariable(preferencesManager3);
                                                            c11571.L$7 = SpillingKt.nullOutSpilledVariable(mTUser4);
                                                            c11571.L$8 = r17;
                                                            c11571.L$9 = SpillingKt.nullOutSpilledVariable(list6);
                                                            c11571.L$10 = SpillingKt.nullOutSpilledVariable(list16);
                                                            c11571.Z$0 = r26;
                                                            c11571.label = 6;
                                                            r19 = r17;
                                                            break;
                                                        } else {
                                                            int id4 = mTUser3.getId();
                                                            List list17 = list7;
                                                            int iIntValue4 = num7.intValue();
                                                            MTUser mTUser5 = mTUser3;
                                                            List<ParsedCard> maybeboardCards = parsedDeckList5.getMaybeboardCards();
                                                            c11571.L$0 = parsedDeckList5;
                                                            parsedDeckList6 = parsedDeckList5;
                                                            c11571.L$1 = SpillingKt.nullOutSpilledVariable(list17);
                                                            c11571.L$2 = SpillingKt.nullOutSpilledVariable(mTDeck4);
                                                            c11571.L$3 = SpillingKt.nullOutSpilledVariable(num8);
                                                            c11571.L$4 = SpillingKt.nullOutSpilledVariable(num9);
                                                            c11571.L$5 = SpillingKt.nullOutSpilledVariable(num7);
                                                            c11571.L$6 = SpillingKt.nullOutSpilledVariable(preferencesManager3);
                                                            c11571.L$7 = SpillingKt.nullOutSpilledVariable(mTUser5);
                                                            c11571.L$8 = r16;
                                                            c11571.L$9 = list6;
                                                            c11571.L$10 = list5;
                                                            c11571.Z$0 = r23;
                                                            c11571.label = 5;
                                                            objAddCardsToListSync3 = addCardsToListSync(id4, iIntValue4, maybeboardCards, c11571);
                                                            if (objAddCardsToListSync3 != coroutine_suspended) {
                                                                mTUser4 = mTUser5;
                                                                list9 = list6;
                                                                list10 = list17;
                                                                r18 = r16;
                                                                r27 = r23;
                                                                response3 = (Response) objAddCardsToListSync3;
                                                                if (response3 != null && response3.isSuccessful()) {
                                                                    MTCardListResponse mTCardListResponse4 = (MTCardListResponse) response3.body();
                                                                    result3 = mTCardListResponse4 == null ? mTCardListResponse4.getResult() : null;
                                                                    if (result3 != null) {
                                                                        list9.add(result3);
                                                                        Boxing.boxBoolean(list5.addAll(parsedDeckList6.getMaybeboardCards()));
                                                                    }
                                                                    mTCardListResponse = (MTCardListResponse) response3.body();
                                                                    if (mTCardListResponse != null && (list13 = mTCardListResponse.getList()) != null) {
                                                                        MTDeckLists mTDeckLists2 = this.currentLists;
                                                                        this.currentLists = mTDeckLists2 == null ? MTDeckLists.copy$default(mTDeckLists2, null, null, list13, 3, null) : null;
                                                                    }
                                                                    list12 = this.currentGroupedCards;
                                                                    if (list12 != null) {
                                                                        setupCardsAdapter(list12);
                                                                    }
                                                                    updateBottomBar();
                                                                }
                                                                list8 = list10;
                                                                list6 = list9;
                                                                r17 = r18;
                                                                r26 = r27;
                                                                ParsedDeckList parsedDeckList72 = parsedDeckList6;
                                                                if (!list6.isEmpty()) {
                                                                }
                                                                MainCoroutineDispatcher main2 = Dispatchers.getMain();
                                                                List list162 = list5;
                                                                AnonymousClass6 anonymousClass62 = new AnonymousClass6(null);
                                                                c11571.L$0 = SpillingKt.nullOutSpilledVariable(parsedDeckList72);
                                                                c11571.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                                                                c11571.L$2 = SpillingKt.nullOutSpilledVariable(mTDeck4);
                                                                c11571.L$3 = SpillingKt.nullOutSpilledVariable(num8);
                                                                c11571.L$4 = SpillingKt.nullOutSpilledVariable(num9);
                                                                c11571.L$5 = SpillingKt.nullOutSpilledVariable(num7);
                                                                c11571.L$6 = SpillingKt.nullOutSpilledVariable(preferencesManager3);
                                                                c11571.L$7 = SpillingKt.nullOutSpilledVariable(mTUser4);
                                                                c11571.L$8 = r17;
                                                                c11571.L$9 = SpillingKt.nullOutSpilledVariable(list6);
                                                                c11571.L$10 = SpillingKt.nullOutSpilledVariable(list162);
                                                                c11571.Z$0 = r26;
                                                                c11571.label = 6;
                                                                r19 = r17;
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        int id5 = mTUser2.getId();
                                                        PreferencesManager preferencesManager7 = preferencesManager2;
                                                        int iIntValue5 = num4.intValue();
                                                        Integer num17 = num4;
                                                        List<ParsedCard> sideboardCards = parsedDeckList4.getSideboardCards();
                                                        c11571.L$0 = parsedDeckList4;
                                                        Integer num18 = num6;
                                                        c11571.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                                                        c11571.L$2 = SpillingKt.nullOutSpilledVariable(mTDeck3);
                                                        c11571.L$3 = SpillingKt.nullOutSpilledVariable(num18);
                                                        c11571.L$4 = SpillingKt.nullOutSpilledVariable(num17);
                                                        c11571.L$5 = num5;
                                                        c11571.L$6 = SpillingKt.nullOutSpilledVariable(preferencesManager7);
                                                        c11571.L$7 = mTUser2;
                                                        c11571.L$8 = r13;
                                                        c11571.L$9 = list4;
                                                        c11571.L$10 = list5;
                                                        c11571.Z$0 = r2;
                                                        c11571.label = 4;
                                                        objAddCardsToListSync2 = addCardsToListSync(id5, iIntValue5, sideboardCards, c11571);
                                                        if (objAddCardsToListSync2 != coroutine_suspended) {
                                                            preferencesManager4 = preferencesManager7;
                                                            num10 = num17;
                                                            num11 = num18;
                                                            r110 = r13;
                                                            r24 = r2;
                                                            response2 = (Response) objAddCardsToListSync2;
                                                            if (response2 == null && response2.isSuccessful()) {
                                                                MTCardListResponse mTCardListResponse5 = (MTCardListResponse) response2.body();
                                                                if (mTCardListResponse5 != null) {
                                                                    r25 = r110;
                                                                    result2 = mTCardListResponse5.getResult();
                                                                } else {
                                                                    r25 = r110;
                                                                    result2 = null;
                                                                }
                                                                if (result2 != null) {
                                                                    list4.add(result2);
                                                                    Boxing.boxBoolean(list5.addAll(parsedDeckList4.getSideboardCards()));
                                                                }
                                                                MTCardListResponse mTCardListResponse6 = (MTCardListResponse) response2.body();
                                                                if (mTCardListResponse6 != null && (list11 = mTCardListResponse6.getList()) != null) {
                                                                    MTDeckLists mTDeckLists3 = this.currentLists;
                                                                    this.currentLists = mTDeckLists3 != null ? MTDeckLists.copy$default(mTDeckLists3, null, list11, null, 5, null) : null;
                                                                }
                                                                List<MTCardGroup> list18 = this.currentGroupedCards;
                                                                if (list18 != null) {
                                                                    setupCardsAdapter(list18);
                                                                }
                                                                updateBottomBar();
                                                                r252 = r25;
                                                            } else {
                                                                r252 = r110;
                                                            }
                                                            r16 = r252;
                                                            list6 = list4;
                                                            list7 = list2;
                                                            num8 = num11;
                                                            num7 = num5;
                                                            mTUser3 = mTUser2;
                                                            parsedDeckList5 = parsedDeckList4;
                                                            mTDeck4 = mTDeck3;
                                                            num9 = num10;
                                                            preferencesManager3 = preferencesManager4;
                                                            r23 = r24;
                                                            if (!parsedDeckList5.getMaybeboardCards().isEmpty()) {
                                                            }
                                                            parsedDeckList6 = parsedDeckList5;
                                                            list8 = list7;
                                                            mTUser4 = mTUser3;
                                                            r17 = r16;
                                                            r26 = r23;
                                                            ParsedDeckList parsedDeckList722 = parsedDeckList6;
                                                            if (!list6.isEmpty()) {
                                                            }
                                                            MainCoroutineDispatcher main22 = Dispatchers.getMain();
                                                            List list1622 = list5;
                                                            AnonymousClass6 anonymousClass622 = new AnonymousClass6(null);
                                                            c11571.L$0 = SpillingKt.nullOutSpilledVariable(parsedDeckList722);
                                                            c11571.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                                                            c11571.L$2 = SpillingKt.nullOutSpilledVariable(mTDeck4);
                                                            c11571.L$3 = SpillingKt.nullOutSpilledVariable(num8);
                                                            c11571.L$4 = SpillingKt.nullOutSpilledVariable(num9);
                                                            c11571.L$5 = SpillingKt.nullOutSpilledVariable(num7);
                                                            c11571.L$6 = SpillingKt.nullOutSpilledVariable(preferencesManager3);
                                                            c11571.L$7 = SpillingKt.nullOutSpilledVariable(mTUser4);
                                                            c11571.L$8 = r17;
                                                            c11571.L$9 = SpillingKt.nullOutSpilledVariable(list6);
                                                            c11571.L$10 = SpillingKt.nullOutSpilledVariable(list1622);
                                                            c11571.Z$0 = r26;
                                                            c11571.label = 6;
                                                            r19 = r17;
                                                        }
                                                        break;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    if (r110 != 0) {
                                                    }
                                                    throw th;
                                                }
                                            }
                                            return coroutine_suspended;
                                        }
                                        Integer num19 = listid;
                                        list4 = arrayList2;
                                        parsedDeckList4 = parsedDeckList3;
                                        mTDeck3 = mTDeck;
                                        r2 = r12;
                                        r13 = constraintLayout;
                                        num6 = num19;
                                        list5 = arrayList;
                                        if (!parsedDeckList4.getSideboardCards().isEmpty()) {
                                        }
                                        Integer num152 = num4;
                                        Integer num162 = num6;
                                        preferencesManager3 = preferencesManager2;
                                        list6 = list4;
                                        num7 = num5;
                                        list7 = list2;
                                        num8 = num162;
                                        mTUser3 = mTUser2;
                                        parsedDeckList5 = parsedDeckList4;
                                        mTDeck4 = mTDeck3;
                                        num9 = num152;
                                        r16 = r13;
                                        r23 = r2;
                                        if (!parsedDeckList5.getMaybeboardCards().isEmpty()) {
                                        }
                                        parsedDeckList6 = parsedDeckList5;
                                        list8 = list7;
                                        mTUser4 = mTUser3;
                                        r17 = r16;
                                        r26 = r23;
                                        ParsedDeckList parsedDeckList7222 = parsedDeckList6;
                                        if (!list6.isEmpty()) {
                                        }
                                        MainCoroutineDispatcher main222 = Dispatchers.getMain();
                                        List list16222 = list5;
                                        AnonymousClass6 anonymousClass6222 = new AnonymousClass6(null);
                                        c11571.L$0 = SpillingKt.nullOutSpilledVariable(parsedDeckList7222);
                                        c11571.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                                        c11571.L$2 = SpillingKt.nullOutSpilledVariable(mTDeck4);
                                        c11571.L$3 = SpillingKt.nullOutSpilledVariable(num8);
                                        c11571.L$4 = SpillingKt.nullOutSpilledVariable(num9);
                                        c11571.L$5 = SpillingKt.nullOutSpilledVariable(num7);
                                        c11571.L$6 = SpillingKt.nullOutSpilledVariable(preferencesManager3);
                                        c11571.L$7 = SpillingKt.nullOutSpilledVariable(mTUser4);
                                        c11571.L$8 = r17;
                                        c11571.L$9 = SpillingKt.nullOutSpilledVariable(list6);
                                        c11571.L$10 = SpillingKt.nullOutSpilledVariable(list16222);
                                        c11571.Z$0 = r26;
                                        c11571.label = 6;
                                        r19 = r17;
                                        break;
                                    } else {
                                        Integer num20 = num2;
                                        mTUser2 = mTUser;
                                        listid = num3;
                                        num5 = num20;
                                        ParsedDeckList parsedDeckList8 = parsedDeckList2;
                                        list2 = list;
                                        parsedDeckList3 = parsedDeckList8;
                                        r14 = r1;
                                        mTDeck = mTDeck2;
                                        num4 = num;
                                        preferencesManager2 = preferencesManager;
                                        r12 = r14;
                                        ArrayList arrayList22 = new ArrayList();
                                        arrayList = new ArrayList();
                                        if (parsedDeckList3.getMainDeckCards().isEmpty()) {
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    r110 = constraintLayout;
                                    if (r110 != 0) {
                                    }
                                    throw th;
                                }
                            } else {
                                num4 = sideboardlistid;
                                mTUser2 = currentUser;
                                num5 = maybeboardlistid;
                                preferencesManager2 = preferencesManager5;
                                list2 = listPlus;
                                parsedDeckList3 = parsedDeckList;
                                r12 = r110;
                                ArrayList arrayList222 = new ArrayList();
                                arrayList = new ArrayList();
                                if (parsedDeckList3.getMainDeckCards().isEmpty()) {
                                }
                            }
                            break;
                        case 1:
                            boolean z2 = c11571.Z$0;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) c11571.L$8;
                            mTUser = (MTUser) c11571.L$7;
                            PreferencesManager preferencesManager8 = (PreferencesManager) c11571.L$6;
                            Integer num21 = (Integer) c11571.L$5;
                            Integer num22 = (Integer) c11571.L$4;
                            Integer num23 = (Integer) c11571.L$3;
                            MTDeck mTDeck6 = (MTDeck) c11571.L$2;
                            list = (List) c11571.L$1;
                            parsedDeckList2 = (ParsedDeckList) c11571.L$0;
                            ResultKt.throwOnFailure(obj);
                            preferencesManager = preferencesManager8;
                            num2 = num21;
                            num = num22;
                            num3 = num23;
                            mTDeck2 = mTDeck6;
                            constraintLayout = constraintLayout3;
                            r1 = z2;
                            if (num == null) {
                            }
                            break;
                        case 2:
                            int i = c11571.I$1;
                            int i2 = c11571.I$0;
                            boolean z3 = c11571.Z$0;
                            constraintLayout2 = (ConstraintLayout) c11571.L$8;
                            mTUser = (MTUser) c11571.L$7;
                            preferencesManager = (PreferencesManager) c11571.L$6;
                            num2 = (Integer) c11571.L$5;
                            num = (Integer) c11571.L$4;
                            num3 = (Integer) c11571.L$3;
                            mTDeck2 = (MTDeck) c11571.L$2;
                            list3 = (List) c11571.L$1;
                            parsedDeckList3 = (ParsedDeckList) c11571.L$0;
                            ResultKt.throwOnFailure(obj);
                            r15 = z3;
                            Integer num132 = num2;
                            mTUser2 = mTUser;
                            listid = num3;
                            num5 = num132;
                            list2 = list3;
                            constraintLayout = constraintLayout2;
                            r14 = r15;
                            mTDeck = mTDeck2;
                            num4 = num;
                            preferencesManager2 = preferencesManager;
                            r12 = r14;
                            ArrayList arrayList2222 = new ArrayList();
                            arrayList = new ArrayList();
                            if (parsedDeckList3.getMainDeckCards().isEmpty()) {
                            }
                            break;
                        case 3:
                            boolean z4 = c11571.Z$0;
                            List list19 = (List) c11571.L$10;
                            list4 = (List) c11571.L$9;
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) c11571.L$8;
                            mTUser2 = (MTUser) c11571.L$7;
                            preferencesManager2 = (PreferencesManager) c11571.L$6;
                            num5 = (Integer) c11571.L$5;
                            num4 = (Integer) c11571.L$4;
                            num6 = (Integer) c11571.L$3;
                            mTDeck3 = (MTDeck) c11571.L$2;
                            list2 = (List) c11571.L$1;
                            parsedDeckList4 = (ParsedDeckList) c11571.L$0;
                            ResultKt.throwOnFailure(obj);
                            r22 = z4;
                            r110 = constraintLayout4;
                            arrayList = list19;
                            objAddCardsToListSync = obj;
                            response = (Response) objAddCardsToListSync;
                            if (response == null) {
                            }
                            r25 = r110;
                            r13 = r25;
                            r2 = r22;
                            list5 = arrayList;
                            if (!parsedDeckList4.getSideboardCards().isEmpty()) {
                            }
                            Integer num1522 = num4;
                            Integer num1622 = num6;
                            preferencesManager3 = preferencesManager2;
                            list6 = list4;
                            num7 = num5;
                            list7 = list2;
                            num8 = num1622;
                            mTUser3 = mTUser2;
                            parsedDeckList5 = parsedDeckList4;
                            mTDeck4 = mTDeck3;
                            num9 = num1522;
                            r16 = r13;
                            r23 = r2;
                            if (!parsedDeckList5.getMaybeboardCards().isEmpty()) {
                            }
                            parsedDeckList6 = parsedDeckList5;
                            list8 = list7;
                            mTUser4 = mTUser3;
                            r17 = r16;
                            r26 = r23;
                            ParsedDeckList parsedDeckList72222 = parsedDeckList6;
                            if (!list6.isEmpty()) {
                            }
                            MainCoroutineDispatcher main2222 = Dispatchers.getMain();
                            List list162222 = list5;
                            AnonymousClass6 anonymousClass62222 = new AnonymousClass6(null);
                            c11571.L$0 = SpillingKt.nullOutSpilledVariable(parsedDeckList72222);
                            c11571.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                            c11571.L$2 = SpillingKt.nullOutSpilledVariable(mTDeck4);
                            c11571.L$3 = SpillingKt.nullOutSpilledVariable(num8);
                            c11571.L$4 = SpillingKt.nullOutSpilledVariable(num9);
                            c11571.L$5 = SpillingKt.nullOutSpilledVariable(num7);
                            c11571.L$6 = SpillingKt.nullOutSpilledVariable(preferencesManager3);
                            c11571.L$7 = SpillingKt.nullOutSpilledVariable(mTUser4);
                            c11571.L$8 = r17;
                            c11571.L$9 = SpillingKt.nullOutSpilledVariable(list6);
                            c11571.L$10 = SpillingKt.nullOutSpilledVariable(list162222);
                            c11571.Z$0 = r26;
                            c11571.label = 6;
                            r19 = r17;
                            break;
                        case 4:
                            boolean z5 = c11571.Z$0;
                            list5 = (List) c11571.L$10;
                            list4 = (List) c11571.L$9;
                            ConstraintLayout constraintLayout5 = (ConstraintLayout) c11571.L$8;
                            mTUser2 = (MTUser) c11571.L$7;
                            preferencesManager4 = (PreferencesManager) c11571.L$6;
                            num5 = (Integer) c11571.L$5;
                            num10 = (Integer) c11571.L$4;
                            num11 = (Integer) c11571.L$3;
                            mTDeck3 = (MTDeck) c11571.L$2;
                            list2 = (List) c11571.L$1;
                            parsedDeckList4 = (ParsedDeckList) c11571.L$0;
                            ResultKt.throwOnFailure(obj);
                            r24 = z5;
                            r110 = constraintLayout5;
                            objAddCardsToListSync2 = obj;
                            response2 = (Response) objAddCardsToListSync2;
                            if (response2 == null) {
                            }
                            r252 = r110;
                            r16 = r252;
                            list6 = list4;
                            list7 = list2;
                            num8 = num11;
                            num7 = num5;
                            mTUser3 = mTUser2;
                            parsedDeckList5 = parsedDeckList4;
                            mTDeck4 = mTDeck3;
                            num9 = num10;
                            preferencesManager3 = preferencesManager4;
                            r23 = r24;
                            if (!parsedDeckList5.getMaybeboardCards().isEmpty()) {
                            }
                            parsedDeckList6 = parsedDeckList5;
                            list8 = list7;
                            mTUser4 = mTUser3;
                            r17 = r16;
                            r26 = r23;
                            ParsedDeckList parsedDeckList722222 = parsedDeckList6;
                            if (!list6.isEmpty()) {
                            }
                            MainCoroutineDispatcher main22222 = Dispatchers.getMain();
                            List list1622222 = list5;
                            AnonymousClass6 anonymousClass622222 = new AnonymousClass6(null);
                            c11571.L$0 = SpillingKt.nullOutSpilledVariable(parsedDeckList722222);
                            c11571.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                            c11571.L$2 = SpillingKt.nullOutSpilledVariable(mTDeck4);
                            c11571.L$3 = SpillingKt.nullOutSpilledVariable(num8);
                            c11571.L$4 = SpillingKt.nullOutSpilledVariable(num9);
                            c11571.L$5 = SpillingKt.nullOutSpilledVariable(num7);
                            c11571.L$6 = SpillingKt.nullOutSpilledVariable(preferencesManager3);
                            c11571.L$7 = SpillingKt.nullOutSpilledVariable(mTUser4);
                            c11571.L$8 = r17;
                            c11571.L$9 = SpillingKt.nullOutSpilledVariable(list6);
                            c11571.L$10 = SpillingKt.nullOutSpilledVariable(list1622222);
                            c11571.Z$0 = r26;
                            c11571.label = 6;
                            r19 = r17;
                            break;
                        case 5:
                            boolean z6 = c11571.Z$0;
                            list5 = (List) c11571.L$10;
                            List list20 = (List) c11571.L$9;
                            ConstraintLayout constraintLayout6 = (ConstraintLayout) c11571.L$8;
                            mTUser4 = (MTUser) c11571.L$7;
                            preferencesManager3 = (PreferencesManager) c11571.L$6;
                            num7 = (Integer) c11571.L$5;
                            num9 = (Integer) c11571.L$4;
                            num8 = (Integer) c11571.L$3;
                            mTDeck4 = (MTDeck) c11571.L$2;
                            List list21 = (List) c11571.L$1;
                            ParsedDeckList parsedDeckList9 = (ParsedDeckList) c11571.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                parsedDeckList6 = parsedDeckList9;
                                list9 = list20;
                                list10 = list21;
                                objAddCardsToListSync3 = obj;
                                r27 = z6;
                                r18 = constraintLayout6;
                                response3 = (Response) objAddCardsToListSync3;
                                if (response3 != null) {
                                    MTCardListResponse mTCardListResponse42 = (MTCardListResponse) response3.body();
                                    if (mTCardListResponse42 == null) {
                                    }
                                    if (result3 != null) {
                                    }
                                    mTCardListResponse = (MTCardListResponse) response3.body();
                                    if (mTCardListResponse != null) {
                                        MTDeckLists mTDeckLists22 = this.currentLists;
                                        this.currentLists = mTDeckLists22 == null ? MTDeckLists.copy$default(mTDeckLists22, null, null, list13, 3, null) : null;
                                    }
                                    list12 = this.currentGroupedCards;
                                    if (list12 != null) {
                                    }
                                    updateBottomBar();
                                }
                                list8 = list10;
                                list6 = list9;
                                r17 = r18;
                                r26 = r27;
                                ParsedDeckList parsedDeckList7222222 = parsedDeckList6;
                                if (!list6.isEmpty()) {
                                }
                                MainCoroutineDispatcher main222222 = Dispatchers.getMain();
                                List list16222222 = list5;
                                AnonymousClass6 anonymousClass6222222 = new AnonymousClass6(null);
                                c11571.L$0 = SpillingKt.nullOutSpilledVariable(parsedDeckList7222222);
                                c11571.L$1 = SpillingKt.nullOutSpilledVariable(list8);
                                c11571.L$2 = SpillingKt.nullOutSpilledVariable(mTDeck4);
                                c11571.L$3 = SpillingKt.nullOutSpilledVariable(num8);
                                c11571.L$4 = SpillingKt.nullOutSpilledVariable(num9);
                                c11571.L$5 = SpillingKt.nullOutSpilledVariable(num7);
                                c11571.L$6 = SpillingKt.nullOutSpilledVariable(preferencesManager3);
                                c11571.L$7 = SpillingKt.nullOutSpilledVariable(mTUser4);
                                c11571.L$8 = r17;
                                c11571.L$9 = SpillingKt.nullOutSpilledVariable(list6);
                                c11571.L$10 = SpillingKt.nullOutSpilledVariable(list16222222);
                                c11571.Z$0 = r26;
                                c11571.label = 6;
                                r19 = r17;
                            } catch (Throwable th4) {
                                th = th4;
                                r110 = constraintLayout6;
                                if (r110 != 0) {
                                    r110.setVisibility(8);
                                }
                                throw th;
                            }
                            break;
                        case 6:
                            boolean z7 = c11571.Z$0;
                            ConstraintLayout constraintLayout7 = (ConstraintLayout) c11571.L$8;
                            ResultKt.throwOnFailure(obj);
                            r19 = constraintLayout7;
                            if (r19 != 0) {
                                r19.setVisibility(8);
                            }
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
                r110 = 0;
            }
        } catch (Throwable th7) {
            th = th7;
            r110 = r5;
        }
    }

    private final boolean isCardSelected(MTFullCard card) {
        List<Integer> variant_list_card_ids = card.getVariant_list_card_ids();
        if (variant_list_card_ids == null && (variant_list_card_ids = card.getList_card_ids()) == null) {
            variant_list_card_ids = CollectionsKt.listOfNotNull(card.getList_card_id());
        }
        List<Integer> list = variant_list_card_ids;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (this.selectedCards.containsKey(Integer.valueOf(((Number) it.next()).intValue()))) {
                return true;
            }
        }
        return false;
    }

    private final boolean isMoxfieldUrl(String url) {
        String str = url;
        if (str != null && !StringsKt.isBlank(str)) {
            try {
                String host = Uri.parse(url).getHost();
                if (host == null) {
                    return false;
                }
                if (!StringsKt.equals(host, "moxfield.com", true)) {
                    if (!StringsKt.endsWith(host, ".moxfield.com", true)) {
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isOtherUserDeck() {
        return this.otherUserId != -1;
    }

    private final boolean isValidDeckUrl(String url) {
        String str = url;
        if (str != null && !StringsKt.isBlank(str)) {
            try {
                String host = Uri.parse(url).getHost();
                if (host == null) {
                    return false;
                }
                List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{"moxfield.com", "archidekt.com", "manabox.com", "manabox.app"});
                if ((listListOf instanceof Collection) && listListOf.isEmpty()) {
                    return false;
                }
                for (String str2 : listListOf) {
                    if (StringsKt.equals(host, str2, true) || StringsKt.endsWith(host, "." + str2, true)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private final void launchComboCardActivity(MTCombo combo, List<MTFullCard> cardList) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        CardDataStore.INSTANCE.setMtCardList(cardList);
        Intent intent = new Intent(this, (Class<?>) CardActivity.class);
        intent.putExtra("singleMTCard", new Gson().toJson(CollectionsKt.first((List) cardList)));
        intent.putExtra("hasMTCards", true);
        intent.putExtra("currentMTIndex", 0);
        intent.putExtra("comboMode", true);
        intent.putExtra("comboData", new Gson().toJson(combo));
        this.cardActivityLauncher.launch(intent);
    }

    private final void launchPaywall(final String carousel) {
        FirebaseAnalytics.getInstance(this).logEvent("subscription_paywall_show", null);
        Purchases.INSTANCE.getSharedInstance().getOfferings(new ReceiveOfferingsCallback() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity.launchPaywall.1
            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                if (DeckDetailsActivity.this.isFinishing() || DeckDetailsActivity.this.isDestroyed()) {
                    return;
                }
                Toast.makeText(DeckDetailsActivity.this, R.string.error_paywall, 1).show();
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onReceived(Offerings offerings) {
                Intrinsics.checkNotNullParameter(offerings, "offerings");
                Offering current = offerings.getCurrent();
                if (current != null) {
                    PaywallActivityLauncher.launch$default(DeckDetailsActivity.this.paywallActivityLauncher, current, null, false, false, MapsKt.mapOf(TuplesKt.to("carousel", new CustomVariableValue.String(carousel))), 14, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onComboClicked$tryFinish(Ref.IntRef intRef, int i, final DeckDetailsActivity deckDetailsActivity, final MTFullCard[] mTFullCardArr, final List<Pair<Integer, MTComboCard>> list, final MTCombo mTCombo, final List<MTFullCard> list2) {
        intRef.element++;
        if (intRef.element != i) {
            return;
        }
        deckDetailsActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda141
            @Override // java.lang.Runnable
            public final void run() {
                DeckDetailsActivity.onComboClicked$tryFinish$lambda$5(this.f$0, mTFullCardArr, list, mTCombo, list2);
            }
        });
    }

    static final void onComboClicked$tryFinish$lambda$5(DeckDetailsActivity deckDetailsActivity, MTFullCard[] mTFullCardArr, List list, MTCombo mTCombo, List list2) {
        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
            return;
        }
        deckDetailsActivity.hideLoadingOverlay();
        int i = 0;
        for (MTFullCard mTFullCard : mTFullCardArr) {
            if (mTFullCard == null) {
                Toast.makeText(deckDetailsActivity, R.string.combo_unavailable, 0).show();
                return;
            }
        }
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int iIntValue = ((Number) ((Pair) obj).component1()).intValue();
            MTFullCard mTFullCard2 = mTFullCardArr[i];
            Intrinsics.checkNotNull(mTFullCard2);
            list2.set(iIntValue, mTFullCard2);
            i = i2;
        }
        deckDetailsActivity.launchComboCardActivity(mTCombo, CollectionsKt.filterNotNull(list2));
    }

    static final Unit onCreate$lambda$10(final DeckDetailsActivity deckDetailsActivity, ConstraintLayout constraintLayout, final MTUser mTUser) {
        if (deckDetailsActivity.isOtherUserDeck() || deckDetailsActivity.isDuplicatedDeck) {
            IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(new IconPopupMenu(deckDetailsActivity), R.string.export_as_csv, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda121
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckDetailsActivity.onCreate$lambda$10$0(this.f$0);
                }
            }, 30, (Object) null), R.string.export_as_txt, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda122
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckDetailsActivity.onCreate$lambda$10$1(this.f$0);
                }
            }, 30, (Object) null).show(constraintLayout);
            return Unit.INSTANCE;
        }
        IconPopupMenu iconPopupMenuAddDivider = IconPopupMenu.addItem$default(new IconPopupMenu(deckDetailsActivity), R.string.edit_deck, "\uf044", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda123
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$10$2(mTUser, deckDetailsActivity);
            }
        }, 28, (Object) null).addDivider();
        if (deckDetailsActivity.currentTabIndex == 0) {
            IconPopupMenu.addItem$default(iconPopupMenuAddDivider, R.string.select_action, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda124
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckDetailsActivity.onCreate$lambda$10$3(this.f$0);
                }
            }, 30, (Object) null).addDivider();
        }
        IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(IconPopupMenu.addItem$default(iconPopupMenuAddDivider, R.string.import_action, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda125
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$10$4(this.f$0);
            }
        }, 30, (Object) null), R.string.export_as_csv, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda127
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$10$5(this.f$0);
            }
        }, 30, (Object) null), R.string.export_as_txt, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda128
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$10$6(this.f$0);
            }
        }, 30, (Object) null).addDivider(), R.string.update_to_cheapest, "\uf3d1", false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda129
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$10$7(this.f$0);
            }
        }, 28, (Object) null).addDivider(), R.string.delete_deck, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda130
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$10$8(mTUser, deckDetailsActivity);
            }
        }, 30, (Object) null), R.string.full_delete_deck, "\uf2ed", true, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda131
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$10$9(mTUser, deckDetailsActivity);
            }
        }, 24, (Object) null).show(constraintLayout);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$0(final DeckDetailsActivity deckDetailsActivity) {
        MTUser currentUser;
        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        MTDeck mTDeck = deckDetailsActivity.currentDeck;
        if (mTDeck != null && (currentUser = new PreferencesManager(deckDetailsActivity).getCurrentUser()) != null) {
            MTApi mtApi = MTApiKt.getMtApi();
            int id = currentUser.getId();
            Integer listid = mTDeck.getListid();
            Call<MTDBResponse> callExportList = mtApi.exportList(id, listid != null ? listid.intValue() : -1);
            final ConstraintLayout constraintLayout = (ConstraintLayout) deckDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            callExportList.enqueue(new Callback<MTDBResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onCreate$11$menu$1$1$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDBResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                        return;
                    }
                    FirebaseAnalytics.getInstance(this.this$0).logEvent("deck_export_failure", null);
                    constraintLayout.setVisibility(8);
                    Toast.makeText(this.this$0, R.string.export_deck_error, 1).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDBResponse> call, Response<MTDBResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                        return;
                    }
                    if (!response.isSuccessful()) {
                        FirebaseAnalytics.getInstance(this.this$0).logEvent("deck_export_error", null);
                        constraintLayout.setVisibility(8);
                        Toast.makeText(this.this$0, R.string.export_deck_error, 1).show();
                        return;
                    }
                    MTDBResponse mTDBResponseBody = response.body();
                    String url = mTDBResponseBody != null ? mTDBResponseBody.getUrl() : null;
                    String str = url;
                    if (str != null && str.length() != 0) {
                        FirebaseAnalytics.getInstance(this.this$0).logEvent("deck_export_ok", null);
                        this.this$0.downloadAndShareFile(url);
                    } else {
                        FirebaseAnalytics.getInstance(this.this$0).logEvent("deck_export_error", null);
                        constraintLayout.setVisibility(8);
                        Toast.makeText(this.this$0, R.string.export_deck_error, 1).show();
                    }
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$1(DeckDetailsActivity deckDetailsActivity) {
        String name;
        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        MTDeckLists mTDeckLists = deckDetailsActivity.currentLists;
        if (mTDeckLists != null) {
            ExportTxtDialogFragment.Builder builder = new ExportTxtDialogFragment.Builder();
            MTDeck mTDeck = deckDetailsActivity.currentDeck;
            if (mTDeck == null || (name = mTDeck.getName()) == null) {
                name = "Deck";
            }
            ExportTxtDialogFragment.Builder lists = builder.setDeckName(name).setLists(mTDeckLists);
            FragmentManager supportFragmentManager = deckDetailsActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            lists.show(supportFragmentManager, "ExportTxtDialog");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$2(MTUser mTUser, DeckDetailsActivity deckDetailsActivity) {
        MTDeck mTDeck;
        if (mTUser != null && (mTDeck = deckDetailsActivity.currentDeck) != null) {
            CreateDeckBottomSheetFragment.INSTANCE.newInstance(deckDetailsActivity, deckDetailsActivity.searchActivityLauncher, deckDetailsActivity.pickCardLauncher, mTUser, mTDeck).show(deckDetailsActivity.getSupportFragmentManager(), CreateDeckBottomSheetFragment.TAG);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$3(DeckDetailsActivity deckDetailsActivity) {
        enterSelectionMode$default(deckDetailsActivity, null, null, 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$4(DeckDetailsActivity deckDetailsActivity) {
        deckDetailsActivity.showImportDeckDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$5(final DeckDetailsActivity deckDetailsActivity) {
        MTUser currentUser;
        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        MTDeck mTDeck = deckDetailsActivity.currentDeck;
        if (mTDeck != null && (currentUser = new PreferencesManager(deckDetailsActivity).getCurrentUser()) != null) {
            MTApi mtApi = MTApiKt.getMtApi();
            int id = currentUser.getId();
            Integer listid = mTDeck.getListid();
            Call<MTDBResponse> callExportList = mtApi.exportList(id, listid != null ? listid.intValue() : -1);
            final ConstraintLayout constraintLayout = (ConstraintLayout) deckDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            callExportList.enqueue(new Callback<MTDBResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onCreate$11$3$1$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDBResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                        return;
                    }
                    FirebaseAnalytics.getInstance(this.this$0).logEvent("deck_export_failure", null);
                    constraintLayout.setVisibility(8);
                    Toast.makeText(this.this$0, R.string.export_deck_error, 1).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDBResponse> call, Response<MTDBResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                        return;
                    }
                    if (!response.isSuccessful()) {
                        FirebaseAnalytics.getInstance(this.this$0).logEvent("deck_export_error", null);
                        constraintLayout.setVisibility(8);
                        Toast.makeText(this.this$0, R.string.export_deck_error, 1).show();
                        return;
                    }
                    MTDBResponse mTDBResponseBody = response.body();
                    String url = mTDBResponseBody != null ? mTDBResponseBody.getUrl() : null;
                    String str = url;
                    if (str != null && str.length() != 0) {
                        FirebaseAnalytics.getInstance(this.this$0).logEvent("deck_export_ok", null);
                        this.this$0.downloadAndShareFile(url);
                    } else {
                        FirebaseAnalytics.getInstance(this.this$0).logEvent("deck_export_error", null);
                        constraintLayout.setVisibility(8);
                        Toast.makeText(this.this$0, R.string.export_deck_error, 1).show();
                    }
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$6(DeckDetailsActivity deckDetailsActivity) {
        String name;
        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        MTDeckLists mTDeckLists = deckDetailsActivity.currentLists;
        if (mTDeckLists != null) {
            ExportTxtDialogFragment.Builder builder = new ExportTxtDialogFragment.Builder();
            MTDeck mTDeck = deckDetailsActivity.currentDeck;
            if (mTDeck == null || (name = mTDeck.getName()) == null) {
                name = "Deck";
            }
            ExportTxtDialogFragment.Builder lists = builder.setDeckName(name).setLists(mTDeckLists);
            FragmentManager supportFragmentManager = deckDetailsActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            lists.show(supportFragmentManager, "ExportTxtDialog");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$7(DeckDetailsActivity deckDetailsActivity) {
        deckDetailsActivity.showUpdateToCheapestDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$8(MTUser mTUser, final DeckDetailsActivity deckDetailsActivity) {
        if (mTUser != null && deckDetailsActivity.currentDeck != null) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = deckDetailsActivity.getResources().getString(R.string.are_you_sure_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = deckDetailsActivity.getResources().getString(R.string.delete_deck_body);
            MTDeck mTDeck = deckDetailsActivity.currentDeck;
            CustomDialogFragment.Builder showRestoreCheckBox = title.setBody(string2 + (mTDeck != null ? Intrinsics.areEqual((Object) mTDeck.is_smart_deck(), (Object) true) : false ? deckDetailsActivity.getResources().getString(R.string.delete_deck_body_smart_deck_extra) : "")).setPositiveButtonRed().setShowRestoreCheckBox(true);
            String string3 = deckDetailsActivity.getResources().getString(R.string.archive_deck_button);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = showRestoreCheckBox.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda111
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeckDetailsActivity.onCreate$lambda$10$8$0$0$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string4 = deckDetailsActivity.getResources().getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda112
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeckDetailsActivity.onCreate$lambda$10$8$0$0$1((CustomDialogFragment) obj);
                }
            });
            FragmentManager supportFragmentManager = deckDetailsActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            negativeButton.show(supportFragmentManager, "CustomDialogFragment");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$8$0$0$0(DeckDetailsActivity deckDetailsActivity, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        PreferencesManager preferencesManager = new PreferencesManager(deckDetailsActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) deckDetailsActivity.findViewById(R.id.overlay);
            constraintLayout.setVisibility(0);
            MTApi mtApi = MTApiKt.getMtApi();
            int id = currentUser.getId();
            MTDeck mTDeck = deckDetailsActivity.currentDeck;
            mtApi.deleteDeck(id, mTDeck != null ? mTDeck.getId() : -1, Boolean.valueOf(z)).enqueue(new DeckDetailsActivity$onCreate$11$6$1$1$1$1$1(deckDetailsActivity, preferencesManager, constraintLayout));
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$8$0$0$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$9(MTUser mTUser, final DeckDetailsActivity deckDetailsActivity) {
        if (mTUser != null && deckDetailsActivity.currentDeck != null) {
            CustomDeleteDialogFragment.Builder builder = new CustomDeleteDialogFragment.Builder();
            String string = deckDetailsActivity.getString(R.string.are_you_sure_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDeleteDialogFragment.Builder title = builder.setTitle(string);
            String string2 = deckDetailsActivity.getString(R.string.full_delete_deck_body);
            MTDeck mTDeck = deckDetailsActivity.currentDeck;
            title.setBody(string2 + (mTDeck != null ? Intrinsics.areEqual((Object) mTDeck.is_smart_deck(), (Object) true) : false ? deckDetailsActivity.getResources().getString(R.string.delete_deck_body_smart_deck_extra) : "")).setShowRestoreCheckBox(true).setPositiveButtonCallback(new Function3() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DeckDetailsActivity.onCreate$lambda$10$9$0$0$0(this.f$0, (String) obj, ((Boolean) obj2).booleanValue(), (CustomDeleteDialogFragment) obj3);
                }
            }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeckDetailsActivity.onCreate$lambda$10$9$0$0$1((CustomDeleteDialogFragment) obj);
                }
            }).build().show(deckDetailsActivity.getSupportFragmentManager(), "CustomDeleteDialogFragment");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$9$0$0$0(DeckDetailsActivity deckDetailsActivity, String str, boolean z, CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        PreferencesManager preferencesManager = new PreferencesManager(deckDetailsActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) deckDetailsActivity.findViewById(R.id.overlay);
            constraintLayout.setVisibility(0);
            MTApi mtApi = MTApiKt.getMtApi();
            int id = currentUser.getId();
            MTDeck mTDeck = deckDetailsActivity.currentDeck;
            mtApi.fullDeleteDeck(id, mTDeck != null ? mTDeck.getId() : -1, Boolean.valueOf(z)).enqueue(new DeckDetailsActivity$onCreate$11$7$1$1$dialog$1$1$1(deckDetailsActivity, preferencesManager, constraintLayout));
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10$9$0$0$1(CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$11(final View view, EditText editText, final DeckDetailsActivity deckDetailsActivity) {
        view.setVisibility(0);
        editText.requestFocus();
        Object systemService = deckDetailsActivity.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(editText, 1);
        }
        final ScrollView scrollView = (ScrollView) deckDetailsActivity.findViewById(R.id.scrollableLayout);
        scrollView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                DeckDetailsActivity.onCreate$lambda$11$0(view, scrollView, deckDetailsActivity);
            }
        }, 350L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$11$0(View view, ScrollView scrollView, DeckDetailsActivity deckDetailsActivity) {
        int top = 0;
        while (view != null && !Intrinsics.areEqual(view, scrollView)) {
            top += view.getTop();
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = null;
            ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup2 != null && !Intrinsics.areEqual(viewGroup2, scrollView) && (viewGroup2 instanceof View)) {
                viewGroup = viewGroup2;
            }
            view = viewGroup;
        }
        scrollView.smoothScrollTo(0, RangesKt.coerceAtLeast(top - ((int) (100.0f * deckDetailsActivity.getResources().getDisplayMetrics().density)), 0));
    }

    static final boolean onCreate$lambda$12(DeckDetailsActivity deckDetailsActivity, EditText editText, TextView textView, int i, KeyEvent keyEvent) {
        String string;
        if (i != 3 && i != 6) {
            return false;
        }
        Object systemService = deckDetailsActivity.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
        Editable text = editText.getText();
        if (text == null || (string = text.toString()) == null) {
            string = "";
        }
        deckDetailsActivity.applyDeckCardsNameFilter(string);
        return true;
    }

    static final Unit onCreate$lambda$13(EditText editText, DeckDetailsActivity deckDetailsActivity) {
        editText.setText("");
        Object systemService = deckDetailsActivity.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
        deckDetailsActivity.applyDeckCardsNameFilter("");
        return Unit.INSTANCE;
    }

    static final void onCreate$lambda$14(View view) {
    }

    static final Unit onCreate$lambda$15(DeckDetailsActivity deckDetailsActivity, TextView textView) {
        deckDetailsActivity.showDeckSettingsMenu(textView);
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$16(final DeckDetailsActivity deckDetailsActivity) {
        BatchCollectionStatusDialogFragment.Builder onResultListener = new BatchCollectionStatusDialogFragment.Builder().setOnResultListener(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda78
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeckDetailsActivity.onCreate$lambda$16$0(this.f$0, (BatchCollectionStatusDialogResult) obj);
            }
        });
        FragmentManager supportFragmentManager = deckDetailsActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        onResultListener.show(supportFragmentManager, "BatchCollectionStatusDialogFragment");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014e  */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v36 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [int] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r6v18, types: [com.studiolaganne.lengendarylens.MTCollectionListEntry, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit onCreate$lambda$16$0(final DeckDetailsActivity deckDetailsActivity, BatchCollectionStatusDialogResult result) {
        boolean z;
        Integer list_card_id;
        MTCardCollectionMatches matches;
        Integer list_card_id2;
        MTCardCollectionMatches matches2;
        MTCardCollectionMatches matches3;
        MTCardCollectionMatches matches4;
        MTCardContainer main;
        MTCardContainer main2;
        List<MTCardGroup> grouped_cards;
        boolean z2;
        Intrinsics.checkNotNullParameter(result, "result");
        if (deckDetailsActivity.isDestroyed() || deckDetailsActivity.isFinishing()) {
            return Unit.INSTANCE;
        }
        ArrayList<MTFullCard> arrayList = new ArrayList();
        MTDeckLists mTDeckLists = deckDetailsActivity.currentLists;
        int i = 2;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = true;
        if (mTDeckLists != null && (main2 = mTDeckLists.getMain()) != null && (grouped_cards = main2.getGrouped_cards()) != null) {
            Iterator it = grouped_cards.iterator();
            while (it.hasNext()) {
                List<MTFullCard> cards = ((MTCardGroup) it.next()).getCards();
                if (cards != null) {
                    for (MTFullCard mTFullCard : cards) {
                        String type_line = mTFullCard.getType_line();
                        if (type_line == null) {
                            type_line = "";
                        }
                        String lowerCase = type_line.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "basic", false, 2, (Object) null)) {
                            String lowerCase2 = type_line.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                            z2 = StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "land", false, 2, (Object) null);
                        }
                        if (!z2 || !deckDetailsActivity.ignoreBasicLands) {
                            onCreate$lambda$16$0$addCardWithVariants(arrayList, mTFullCard);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            Unit unit2 = Unit.INSTANCE;
        }
        MTDeckLists mTDeckLists2 = deckDetailsActivity.currentLists;
        int id = (mTDeckLists2 == null || (main = mTDeckLists2.getMain()) == null) ? -1 : main.getId();
        if (arrayList.isEmpty()) {
            Toast.makeText(deckDetailsActivity, deckDetailsActivity.getResources().getString(R.string.no_cards_for_deck), 1).show();
            return Unit.INSTANCE;
        }
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        int i2 = WhenMappings.$EnumSwitchMapping$4[result.getInitialChoice().ordinal()];
        if (i2 == 1) {
            for (MTFullCard mTFullCard2 : arrayList) {
                if (!Intrinsics.areEqual((Object) mTFullCard2.getIncollection(), (Object) true)) {
                    BatchCollectionStatusSameAction sameAction = result.getSameAction();
                    int i3 = sameAction == null ? -1 : WhenMappings.$EnumSwitchMapping$1[sameAction.ordinal()];
                    if (i3 == 1) {
                        MTFullCard mTFullCard3 = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                        mTFullCard3.setList_card_id(mTFullCard2.getList_card_id());
                        mTFullCard3.setIncollection(true);
                        Boolean.valueOf(arrayList2.add(mTFullCard3));
                    } else if (i3 != 2) {
                        Unit unit3 = Unit.INSTANCE;
                    } else {
                        MTFullCard mTFullCard4 = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                        mTFullCard4.setList_card_id(mTFullCard2.getList_card_id());
                        mTFullCard4.setIncollection(true);
                        mTFullCard4.setProxy(true);
                        Boolean.valueOf(arrayList2.add(mTFullCard4));
                    }
                }
            }
            Unit unit4 = Unit.INSTANCE;
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (MTFullCard mTFullCard5 : arrayList) {
                if (!Intrinsics.areEqual(mTFullCard5.getIncollection(), Boolean.valueOf(z5))) {
                    MTCardCollectionStatus collection = mTFullCard5.getCollection();
                    if (collection == null || (matches4 = collection.getMatches()) == null) {
                        z = z3;
                    } else {
                        List<MTCollectionCardMatch> exact = matches4.getExact();
                        if ((exact == null || (exact.isEmpty() ^ z5) != z5) ? z3 : z5) {
                            z = z5;
                            Unit unit5 = Unit.INSTANCE;
                            Unit unit6 = Unit.INSTANCE;
                        } else {
                            List<MTCollectionCardMatch> all = matches4.getAll();
                            if (!((all == null || (all.isEmpty() ^ z5) != z5) ? z3 : z5)) {
                                z = z3;
                            }
                            Unit unit52 = Unit.INSTANCE;
                            Unit unit62 = Unit.INSTANCE;
                        }
                    }
                    if (z) {
                        BatchCollectionStatusOwnAction ownAction = result.getOwnAction();
                        int i4 = ownAction == null ? -1 : WhenMappings.$EnumSwitchMapping$2[ownAction.ordinal()];
                        if (i4 == z5) {
                            Integer quantity = mTFullCard5.getQuantity();
                            int iIntValue = quantity != null ? quantity.intValue() : 1;
                            for (int i5 = 0; i5 < iIntValue; i5++) {
                                List<Integer> list_card_ids = mTFullCard5.getList_card_ids();
                                if (list_card_ids == null || (list_card_id = (Integer) CollectionsKt.getOrNull(list_card_ids, i5)) == null) {
                                    list_card_id = mTFullCard5.getList_card_id();
                                }
                                MTCardCollectionStatus collection2 = mTFullCard5.getCollection();
                                MTCollectionCardMatch mTCollectionCardMatchOnCreate$lambda$16$0$findFirstUnusedExactMatch = onCreate$lambda$16$0$findFirstUnusedExactMatch(linkedHashSet, (collection2 == null || (matches = collection2.getMatches()) == null) ? null : matches.getExact());
                                if (mTCollectionCardMatchOnCreate$lambda$16$0$findFirstUnusedExactMatch != null) {
                                    onCreate$lambda$16$0$markMatchAsUsed(linkedHashSet, mTCollectionCardMatchOnCreate$lambda$16$0$findFirstUnusedExactMatch);
                                    MTCollectionStatusEdit mTCollectionStatusEdit = new MTCollectionStatusEdit(null, null, 3, null);
                                    mTCollectionStatusEdit.setOld(new MTCollectionListEntry(Integer.valueOf(id), list_card_id));
                                    MTCardContainer list = mTCollectionCardMatchOnCreate$lambda$16$0$findFirstUnusedExactMatch.getList();
                                    Integer numValueOf = list != null ? Integer.valueOf(list.getId()) : null;
                                    MTCardMatch card = mTCollectionCardMatchOnCreate$lambda$16$0$findFirstUnusedExactMatch.getCard();
                                    mTCollectionStatusEdit.setNew(new MTCollectionListEntry(numValueOf, card != null ? card.getList_card_id() : null));
                                    arrayList3.add(mTCollectionStatusEdit);
                                }
                            }
                            Unit unit7 = Unit.INSTANCE;
                        } else if (i4 != i) {
                            Unit unit8 = Unit.INSTANCE;
                        } else {
                            Integer quantity2 = mTFullCard5.getQuantity();
                            ?? IntValue = quantity2 != null ? quantity2.intValue() : z5;
                            ?? r6 = z4;
                            for (?? r15 = z3; r15 < IntValue; r15++) {
                                List<Integer> list_card_ids2 = mTFullCard5.getList_card_ids();
                                if (list_card_ids2 == null || (list_card_id2 = (Integer) CollectionsKt.getOrNull(list_card_ids2, r15)) == null) {
                                    list_card_id2 = mTFullCard5.getList_card_id();
                                }
                                MTCardCollectionStatus collection3 = mTFullCard5.getCollection();
                                ?? exact2 = (collection3 == null || (matches3 = collection3.getMatches()) == null) ? r6 : matches3.getExact();
                                MTCardCollectionStatus collection4 = mTFullCard5.getCollection();
                                MTCollectionCardMatch mTCollectionCardMatchOnCreate$lambda$16$0$findFirstUnusedPartialMatch = onCreate$lambda$16$0$findFirstUnusedPartialMatch(linkedHashSet, exact2, (collection4 == null || (matches2 = collection4.getMatches()) == null) ? r6 : matches2.getAll());
                                if (mTCollectionCardMatchOnCreate$lambda$16$0$findFirstUnusedPartialMatch != null) {
                                    onCreate$lambda$16$0$markMatchAsUsed(linkedHashSet, mTCollectionCardMatchOnCreate$lambda$16$0$findFirstUnusedPartialMatch);
                                    MTCollectionStatusEdit mTCollectionStatusEdit2 = new MTCollectionStatusEdit(r6, r6, 3, r6);
                                    mTCollectionStatusEdit2.setOld(new MTCollectionListEntry(Integer.valueOf(id), list_card_id2));
                                    MTCardContainer list2 = mTCollectionCardMatchOnCreate$lambda$16$0$findFirstUnusedPartialMatch.getList();
                                    Integer numValueOf2 = list2 != null ? Integer.valueOf(list2.getId()) : null;
                                    MTCardMatch card2 = mTCollectionCardMatchOnCreate$lambda$16$0$findFirstUnusedPartialMatch.getCard();
                                    mTCollectionStatusEdit2.setNew(new MTCollectionListEntry(numValueOf2, card2 != null ? card2.getList_card_id() : null));
                                    arrayList3.add(mTCollectionStatusEdit2);
                                }
                                r6 = 0;
                            }
                            Unit unit9 = Unit.INSTANCE;
                        }
                    } else {
                        BatchCollectionStatusDontOwnAction dontOwnAction = result.getDontOwnAction();
                        int i6 = dontOwnAction == null ? -1 : WhenMappings.$EnumSwitchMapping$3[dontOwnAction.ordinal()];
                        if (i6 == 1) {
                            MTFullCard mTFullCard6 = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                            mTFullCard6.setList_card_id(mTFullCard5.getList_card_id());
                            mTFullCard6.setIncollection(true);
                            Boolean.valueOf(arrayList2.add(mTFullCard6));
                        } else if (i6 != 2) {
                            Unit unit10 = Unit.INSTANCE;
                        } else {
                            MTFullCard mTFullCard7 = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                            mTFullCard7.setList_card_id(mTFullCard5.getList_card_id());
                            mTFullCard7.setIncollection(true);
                            mTFullCard7.setProxy(true);
                            Boolean.valueOf(arrayList2.add(mTFullCard7));
                        }
                    }
                    i = 2;
                    z3 = false;
                    z4 = false;
                    z5 = true;
                }
            }
            Unit unit11 = Unit.INSTANCE;
        }
        DeckDetailsActivity deckDetailsActivity2 = deckDetailsActivity;
        final PreferencesManager preferencesManager = new PreferencesManager(deckDetailsActivity2);
        final MTUser currentUser = preferencesManager.getCurrentUser();
        if (arrayList2.isEmpty() && arrayList3.isEmpty()) {
            return Unit.INSTANCE;
        }
        if (currentUser != null) {
            final ConstraintLayout constraintLayout = (ConstraintLayout) deckDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
                Unit unit12 = Unit.INSTANCE;
            }
            if (arrayList2.isEmpty()) {
                int i7 = id;
                if (!arrayList3.isEmpty()) {
                    onCreate$lambda$16$0$9$processCollectionStatusEdits(arrayList3, currentUser, i7, deckDetailsActivity, preferencesManager, constraintLayout, null);
                }
            } else {
                MTCardListBody mTCardListBody = new MTCardListBody(null, 1, null);
                mTCardListBody.setCards(arrayList2);
                final int i8 = id;
                MTApiKt.getMtApi().editCardCollectionStatusFromList(currentUser.getId(), id, null, null, deckDetailsActivity.currentGroupBy, deckDetailsActivity.currentSortBy, deckDetailsActivity.currentSortDirection, Boolean.valueOf(deckDetailsActivity.ignoreCollection), Boolean.valueOf(deckDetailsActivity.ignoreBasicLands), Boolean.valueOf(deckDetailsActivity.ignorePrintings), mTCardListBody).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onCreate$18$1$3$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        if (this.this$0.isDestroyed() || this.this$0.isFinishing()) {
                            return;
                        }
                        Log.e("DeckDetailsActivity", "Failed to edit card collection status: " + t.getMessage());
                        constraintLayout.setVisibility(8);
                        Toast.makeText(this.this$0, R.string.error_editing_card, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                            return;
                        }
                        if (!response.isSuccessful()) {
                            constraintLayout.setVisibility(8);
                            Toast.makeText(this.this$0, R.string.error_editing_card, 0).show();
                            return;
                        }
                        MTCardListResponse mTCardListResponseBody = response.body();
                        MTCardContainer list3 = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                        preferencesManager.incrementCollectionVersion();
                        preferencesManager.incrementAllContainerVersions();
                        if (arrayList3.isEmpty()) {
                            DeckDetailsActivity.onCreate$lambda$16$0$9$refreshUIAndHideOverlay(constraintLayout, i8, this.this$0, list3);
                        } else {
                            DeckDetailsActivity.onCreate$lambda$16$0$9$processCollectionStatusEdits(arrayList3, currentUser, i8, this.this$0, preferencesManager, constraintLayout, list3);
                        }
                    }
                });
            }
            Unit unit13 = Unit.INSTANCE;
        } else {
            Toast.makeText(deckDetailsActivity2, R.string.server_error, 0).show();
            Unit unit14 = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$16$0$9$processCollectionStatusEdits(List<MTCollectionStatusEdit> list, MTUser mTUser, final int i, final DeckDetailsActivity deckDetailsActivity, final PreferencesManager preferencesManager, final ConstraintLayout constraintLayout, final MTCardContainer mTCardContainer) {
        MTEditCollectionStatusBody mTEditCollectionStatusBody = new MTEditCollectionStatusBody(null, 1, null);
        mTEditCollectionStatusBody.setCards(list);
        MTApiKt.getMtApi().editCollectionStatusFromList(mTUser.getId(), i, null, null, deckDetailsActivity.currentGroupBy, deckDetailsActivity.currentSortBy, deckDetailsActivity.currentSortDirection, Boolean.valueOf(deckDetailsActivity.ignoreCollection), Boolean.valueOf(deckDetailsActivity.ignoreBasicLands), Boolean.valueOf(deckDetailsActivity.ignorePrintings), mTEditCollectionStatusBody).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onCreate$18$1$3$processCollectionStatusEdits$1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (this.this$0.isDestroyed() || this.this$0.isFinishing()) {
                    return;
                }
                Log.e("DeckDetailsActivity", "Failed to edit collection status: " + t.getMessage());
                constraintLayout.setVisibility(8);
                Toast.makeText(this.this$0, R.string.error_editing_card, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                    return;
                }
                if (!response.isSuccessful()) {
                    constraintLayout.setVisibility(8);
                    Toast.makeText(this.this$0, R.string.error_editing_card, 0).show();
                    return;
                }
                MTCardListResponse mTCardListResponseBody = response.body();
                MTCardContainer list2 = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                preferencesManager.incrementCollectionVersion();
                preferencesManager.incrementAllContainerVersions();
                ConstraintLayout constraintLayout2 = constraintLayout;
                int i2 = i;
                DeckDetailsActivity deckDetailsActivity2 = this.this$0;
                if (list2 == null) {
                    list2 = mTCardContainer;
                }
                DeckDetailsActivity.onCreate$lambda$16$0$9$refreshUIAndHideOverlay(constraintLayout2, i2, deckDetailsActivity2, list2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$16$0$9$refreshUIAndHideOverlay(ConstraintLayout constraintLayout, int i, DeckDetailsActivity deckDetailsActivity, MTCardContainer mTCardContainer) {
        MTCardContainer main;
        MTCardContainer mTCardContainer2;
        MTDeckLists mTDeckListsCopy$default;
        if (mTCardContainer != null) {
            MTDeckLists mTDeckLists = deckDetailsActivity.currentLists;
            if (mTDeckLists != null && (main = mTDeckLists.getMain()) != null && i == main.getId()) {
                MTDeckLists mTDeckLists2 = deckDetailsActivity.currentLists;
                if (mTDeckLists2 != null) {
                    mTCardContainer2 = mTCardContainer;
                    mTDeckListsCopy$default = MTDeckLists.copy$default(mTDeckLists2, mTCardContainer2, null, null, 6, null);
                } else {
                    mTCardContainer2 = mTCardContainer;
                    mTDeckListsCopy$default = null;
                }
                deckDetailsActivity.currentLists = mTDeckListsCopy$default;
                List<MTCardGroup> grouped_cards = mTCardContainer2.getGrouped_cards();
                if (grouped_cards != null) {
                    deckDetailsActivity.currentGroupedCards = grouped_cards;
                }
            }
            List<MTCardGroup> list = deckDetailsActivity.currentGroupedCards;
            if (list != null) {
                deckDetailsActivity.setupCardsAdapter(list);
            }
            deckDetailsActivity.updateBottomBar();
        }
        constraintLayout.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void onCreate$lambda$16$0$addCardWithVariants(List<MTFullCard> list, MTFullCard mTFullCard) {
        boolean z;
        int iIntValue;
        if (mTFullCard.getVariants() != null) {
            List<MTFullCard> variants = mTFullCard.getVariants();
            Intrinsics.checkNotNull(variants);
            if (variants.isEmpty()) {
                if (mTFullCard.getVariant_quantity() != null) {
                    Integer variant_quantity = mTFullCard.getVariant_quantity();
                    Intrinsics.checkNotNull(variant_quantity);
                    z = variant_quantity.intValue() > 0;
                }
            }
        }
        Integer quantity = mTFullCard.getQuantity();
        int iIntValue2 = quantity != null ? quantity.intValue() : 1;
        if (!z || iIntValue2 <= 1) {
            list.add(mTFullCard);
            return;
        }
        Integer variant_quantity2 = mTFullCard.getVariant_quantity();
        if (variant_quantity2 != null && (iIntValue = variant_quantity2.intValue()) > 0) {
            list.add(MTFullCard.copy$default(mTFullCard, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, mTFullCard.getVariant_list_card_ids(), null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(iIntValue), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -16387, 127, null));
        }
        List<MTFullCard> variants2 = mTFullCard.getVariants();
        if (variants2 != null) {
            Iterator<T> it = variants2.iterator();
            while (it.hasNext()) {
                list.add(MTFullCard.copy$default((MTFullCard) it.next(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null));
            }
        }
    }

    private static final MTCollectionCardMatch onCreate$lambda$16$0$findFirstUnusedExactMatch(Set<String> set, List<MTCollectionCardMatch> list) {
        Object obj = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!onCreate$lambda$16$0$isMatchUsed(set, (MTCollectionCardMatch) next)) {
                obj = next;
                break;
            }
        }
        return (MTCollectionCardMatch) obj;
    }

    private static final MTCollectionCardMatch onCreate$lambda$16$0$findFirstUnusedPartialMatch(Set<String> set, List<MTCollectionCardMatch> list, List<MTCollectionCardMatch> list2) {
        Object next;
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (!onCreate$lambda$16$0$isMatchUsed(set, (MTCollectionCardMatch) next)) {
                    break;
                }
            }
            MTCollectionCardMatch mTCollectionCardMatch = (MTCollectionCardMatch) next;
            if (mTCollectionCardMatch != null) {
                return mTCollectionCardMatch;
            }
        }
        if (list2 == null) {
            return null;
        }
        Iterator<T> it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (!onCreate$lambda$16$0$isMatchUsed(set, (MTCollectionCardMatch) next2)) {
                obj = next2;
                break;
            }
        }
        return (MTCollectionCardMatch) obj;
    }

    private static final String onCreate$lambda$16$0$getMatchKey(MTCollectionCardMatch mTCollectionCardMatch) {
        MTCardContainer list = mTCollectionCardMatch.getList();
        Integer numValueOf = list != null ? Integer.valueOf(list.getId()) : null;
        MTCardMatch card = mTCollectionCardMatch.getCard();
        Integer list_card_id = card != null ? card.getList_card_id() : null;
        if (numValueOf == null || list_card_id == null) {
            return null;
        }
        return numValueOf + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + list_card_id;
    }

    private static final boolean onCreate$lambda$16$0$isMatchUsed(Set<String> set, MTCollectionCardMatch mTCollectionCardMatch) {
        String strOnCreate$lambda$16$0$getMatchKey = onCreate$lambda$16$0$getMatchKey(mTCollectionCardMatch);
        return strOnCreate$lambda$16$0$getMatchKey != null && set.contains(strOnCreate$lambda$16$0$getMatchKey);
    }

    private static final void onCreate$lambda$16$0$markMatchAsUsed(Set<String> set, MTCollectionCardMatch mTCollectionCardMatch) {
        String strOnCreate$lambda$16$0$getMatchKey = onCreate$lambda$16$0$getMatchKey(mTCollectionCardMatch);
        if (strOnCreate$lambda$16$0$getMatchKey != null) {
            set.add(strOnCreate$lambda$16$0$getMatchKey);
        }
    }

    static final Unit onCreate$lambda$17(DeckDetailsActivity deckDetailsActivity) {
        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        Intent intent = new Intent(deckDetailsActivity, (Class<?>) ScanToDeckActivity.class);
        MTDeck mTDeck = deckDetailsActivity.currentDeck;
        intent.putExtra("scanToDeckName", mTDeck != null ? mTDeck.getName() : null);
        deckDetailsActivity.scanActivityLauncher.launch(intent);
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$18(DeckDetailsActivity deckDetailsActivity) {
        deckDetailsActivity.showLegacyAddPanel();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$19(DeckDetailsActivity deckDetailsActivity) {
        MTDeck mTDeck = deckDetailsActivity.currentDeck;
        if (mTDeck == null || mTDeck.getFormatid() != 6) {
            deckDetailsActivity.showLegacyAddPanel();
        } else {
            deckDetailsActivity.showMythicPlusPanel();
        }
        return Unit.INSTANCE;
    }

    static final void onCreate$lambda$21(ScrollView scrollView, final DeckDetailsActivity deckDetailsActivity) {
        int scrollY = scrollView.getScrollY();
        if (scrollY != deckDetailsActivity.lastScrollY) {
            deckDetailsActivity.lastScrollY = scrollY;
            Runnable runnable = deckDetailsActivity.scrollStoppedRunnable;
            if (runnable != null) {
                deckDetailsActivity.handler.removeCallbacks(runnable);
            }
            deckDetailsActivity.hideAddButton();
            Runnable runnable2 = new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda162
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.showAddButton();
                }
            };
            deckDetailsActivity.scrollStoppedRunnable = runnable2;
            Handler handler = deckDetailsActivity.handler;
            Intrinsics.checkNotNull(runnable2);
            handler.postDelayed(runnable2, 1500L);
        }
    }

    static final Unit onCreate$lambda$3(DeckDetailsActivity deckDetailsActivity, LinearLayout linearLayout, LinearLayout linearLayout2) {
        deckDetailsActivity.filterDefinition = new FilterDefinition(null, null, null, null, null, null, 63, null);
        deckDetailsActivity.filterActive = false;
        linearLayout.setVisibility(0);
        linearLayout2.setVisibility(8);
        deckDetailsActivity.updateFilter();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$4(DeckDetailsActivity deckDetailsActivity) {
        deckDetailsActivity.showFilterBottomSheet();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$5(DeckDetailsActivity deckDetailsActivity) {
        deckDetailsActivity.showFilterBottomSheet();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$7(DeckDetailsActivity deckDetailsActivity) {
        String description;
        MTDeck mTDeck = deckDetailsActivity.currentDeck;
        if (mTDeck == null || (description = mTDeck.getDescription()) == null) {
            description = "";
        }
        if (description.length() > 0) {
            deckDetailsActivity.showDescriptionViewDialog(description);
        } else if (!deckDetailsActivity.isOtherUserDeck() && !deckDetailsActivity.isDuplicatedDeck) {
            deckDetailsActivity.showDescriptionEditDialog(description);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$8(DeckDetailsActivity deckDetailsActivity) {
        String description;
        MTDeck mTDeck = deckDetailsActivity.currentDeck;
        if (mTDeck == null || (description = mTDeck.getDescription()) == null) {
            description = "";
        }
        deckDetailsActivity.showDescriptionEditDialog(description);
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$9(DeckDetailsActivity deckDetailsActivity) {
        deckDetailsActivity.finish();
        return Unit.INSTANCE;
    }

    static final Unit onDeckCardCollectionStatus$lambda$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeckCardCollectionStatus$lambda$1(final DeckDetailsActivity deckDetailsActivity, final int i, MultiCardCollectionRestoreDialogResult multiResult) {
        final PreferencesManager preferencesManager;
        MTUser currentUser;
        MTFullCard mTFullCard;
        Intrinsics.checkNotNullParameter(multiResult, "multiResult");
        List<CollectionRestoreDialogResult> results = multiResult.getResults();
        ArrayList arrayList = new ArrayList();
        for (Object obj : results) {
            if (((CollectionRestoreDialogResult) obj).getShouldRestore()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty() && (currentUser = (preferencesManager = new PreferencesManager(deckDetailsActivity)).getCurrentUser()) != null) {
            final ConstraintLayout constraintLayout = (ConstraintLayout) deckDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            MTCardListBody mTCardListBody = new MTCardListBody(null, 1, null);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Integer listCardId = ((CollectionRestoreDialogResult) it.next()).getListCardId();
                if (listCardId != null) {
                    int iIntValue = listCardId.intValue();
                    mTFullCard = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                    mTFullCard.setList_card_id(Integer.valueOf(iIntValue));
                } else {
                    mTFullCard = null;
                }
                if (mTFullCard != null) {
                    arrayList3.add(mTFullCard);
                }
            }
            mTCardListBody.setCards(arrayList3);
            MTApiKt.getMtApi().restoreToCollectionFromList(currentUser.getId(), i, null, null, deckDetailsActivity.currentGroupBy, deckDetailsActivity.currentSortBy, deckDetailsActivity.currentSortDirection, mTCardListBody).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onDeckCardCollectionStatus$2$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    Log.e("ScanFragment", "Failed to edit MT Card: " + t.getMessage());
                    constraintLayout.setVisibility(8);
                    Toast.makeText(this.this$0, R.string.error_editing_card, 0).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                    MTCardContainer maybeboard;
                    MTCardContainer sideboard;
                    MTCardContainer main;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                        return;
                    }
                    if (!response.isSuccessful()) {
                        constraintLayout.setVisibility(8);
                        Toast.makeText(this.this$0, R.string.error_editing_card, 0).show();
                        return;
                    }
                    preferencesManager.incrementCollectionVersion();
                    preferencesManager.incrementAllContainerVersions();
                    MTCardListResponse mTCardListResponseBody = response.body();
                    MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                    if (list != null) {
                        int i2 = i;
                        DeckDetailsActivity deckDetailsActivity2 = this.this$0;
                        MTDeckLists mTDeckLists = deckDetailsActivity2.currentLists;
                        if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || i2 != main.getId()) {
                            MTDeckLists mTDeckLists2 = deckDetailsActivity2.currentLists;
                            if (mTDeckLists2 == null || (sideboard = mTDeckLists2.getSideboard()) == null || i2 != sideboard.getId()) {
                                MTDeckLists mTDeckLists3 = deckDetailsActivity2.currentLists;
                                if (mTDeckLists3 != null && (maybeboard = mTDeckLists3.getMaybeboard()) != null && i2 == maybeboard.getId()) {
                                    MTDeckLists mTDeckLists4 = deckDetailsActivity2.currentLists;
                                    deckDetailsActivity2.currentLists = mTDeckLists4 != null ? MTDeckLists.copy$default(mTDeckLists4, null, null, list, 3, null) : null;
                                }
                            } else {
                                MTDeckLists mTDeckLists5 = deckDetailsActivity2.currentLists;
                                deckDetailsActivity2.currentLists = mTDeckLists5 != null ? MTDeckLists.copy$default(mTDeckLists5, null, list, null, 5, null) : null;
                            }
                        } else {
                            MTDeckLists mTDeckLists6 = deckDetailsActivity2.currentLists;
                            deckDetailsActivity2.currentLists = mTDeckLists6 != null ? MTDeckLists.copy$default(mTDeckLists6, list, null, null, 6, null) : null;
                            List<MTCardGroup> grouped_cards = list.getGrouped_cards();
                            if (grouped_cards != null) {
                                deckDetailsActivity2.currentGroupedCards = grouped_cards;
                            }
                        }
                        List list2 = deckDetailsActivity2.currentGroupedCards;
                        if (list2 != null) {
                            deckDetailsActivity2.setupCardsAdapter(list2);
                        }
                        deckDetailsActivity2.updateBottomBar();
                    }
                    constraintLayout.setVisibility(8);
                }
            });
        }
        return Unit.INSTANCE;
    }

    static final Unit onDeckCardCollectionStatus$lambda$2(final DeckDetailsActivity deckDetailsActivity, int i, MultiCardCollectionStatusDialogResult multiResult) {
        final int i2;
        ArrayList<CollectionStatusDialogResult> arrayList;
        MTUser mTUser;
        final ConstraintLayout constraintLayout;
        int i3;
        MTCardContainer list;
        MTCardMatch card;
        Intrinsics.checkNotNullParameter(multiResult, "multiResult");
        List<CollectionStatusDialogResult> results = multiResult.getResults();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : results) {
            if (((CollectionStatusDialogResult) obj).getChoice() == CollectionStatusChoice.ADD_TO_COLLECTION) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : results) {
            if (((CollectionStatusDialogResult) obj2).getChoice() == CollectionStatusChoice.MAKE_PROXY) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList();
        for (Object obj3 : results) {
            if (((CollectionStatusDialogResult) obj3).getChoice() == CollectionStatusChoice.GRAB_FROM_COLLECTION) {
                arrayList6.add(obj3);
            }
        }
        ArrayList arrayList7 = arrayList6;
        final PreferencesManager preferencesManager = new PreferencesManager(deckDetailsActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) deckDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(0);
            }
            List listPlus = CollectionsKt.plus((Collection) arrayList3, (Iterable) arrayList5);
            if (listPlus.isEmpty()) {
                i2 = i;
                arrayList = arrayList7;
                mTUser = currentUser;
                constraintLayout = constraintLayout2;
                i3 = 1;
            } else {
                MTCardListBody mTCardListBody = new MTCardListBody(null, 1, null);
                List<CollectionStatusDialogResult> list2 = listPlus;
                ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (CollectionStatusDialogResult collectionStatusDialogResult : list2) {
                    MTFullCard mTFullCard = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                    mTFullCard.setList_card_id(collectionStatusDialogResult.getListCardId());
                    mTFullCard.setIncollection(true);
                    if (collectionStatusDialogResult.getChoice() == CollectionStatusChoice.MAKE_PROXY) {
                        mTFullCard.setProxy(true);
                    }
                    arrayList8.add(mTFullCard);
                }
                mTCardListBody.setCards(arrayList8);
                mTUser = currentUser;
                i3 = 1;
                arrayList = arrayList7;
                constraintLayout = constraintLayout2;
                i2 = i;
                MTApiKt.getMtApi().editCardCollectionStatusFromList(currentUser.getId(), i2, null, null, deckDetailsActivity.currentGroupBy, deckDetailsActivity.currentSortBy, deckDetailsActivity.currentSortDirection, Boolean.valueOf(deckDetailsActivity.ignoreCollection), Boolean.valueOf(deckDetailsActivity.ignoreBasicLands), Boolean.valueOf(deckDetailsActivity.ignorePrintings), mTCardListBody).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onDeckCardCollectionStatus$3$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        Log.e("ScanFragment", "Failed to edit MT Card: " + t.getMessage());
                        constraintLayout.setVisibility(8);
                        Toast.makeText(this.this$0, R.string.error_editing_card, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                        MTCardContainer maybeboard;
                        MTCardContainer sideboard;
                        MTCardContainer main;
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                            return;
                        }
                        if (!response.isSuccessful()) {
                            constraintLayout.setVisibility(8);
                            Toast.makeText(this.this$0, R.string.error_editing_card, 0).show();
                            return;
                        }
                        preferencesManager.incrementCollectionVersion();
                        preferencesManager.incrementAllContainerVersions();
                        MTCardListResponse mTCardListResponseBody = response.body();
                        MTCardContainer list3 = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                        if (list3 != null) {
                            int i4 = i2;
                            DeckDetailsActivity deckDetailsActivity2 = this.this$0;
                            MTDeckLists mTDeckLists = deckDetailsActivity2.currentLists;
                            if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || i4 != main.getId()) {
                                MTDeckLists mTDeckLists2 = deckDetailsActivity2.currentLists;
                                if (mTDeckLists2 == null || (sideboard = mTDeckLists2.getSideboard()) == null || i4 != sideboard.getId()) {
                                    MTDeckLists mTDeckLists3 = deckDetailsActivity2.currentLists;
                                    if (mTDeckLists3 != null && (maybeboard = mTDeckLists3.getMaybeboard()) != null && i4 == maybeboard.getId()) {
                                        MTDeckLists mTDeckLists4 = deckDetailsActivity2.currentLists;
                                        deckDetailsActivity2.currentLists = mTDeckLists4 != null ? MTDeckLists.copy$default(mTDeckLists4, null, null, list3, 3, null) : null;
                                    }
                                } else {
                                    MTDeckLists mTDeckLists5 = deckDetailsActivity2.currentLists;
                                    deckDetailsActivity2.currentLists = mTDeckLists5 != null ? MTDeckLists.copy$default(mTDeckLists5, null, list3, null, 5, null) : null;
                                }
                            } else {
                                MTDeckLists mTDeckLists6 = deckDetailsActivity2.currentLists;
                                deckDetailsActivity2.currentLists = mTDeckLists6 != null ? MTDeckLists.copy$default(mTDeckLists6, list3, null, null, 6, null) : null;
                                List<MTCardGroup> grouped_cards = list3.getGrouped_cards();
                                if (grouped_cards != null) {
                                    deckDetailsActivity2.currentGroupedCards = grouped_cards;
                                }
                            }
                            List list4 = deckDetailsActivity2.currentGroupedCards;
                            if (list4 != null) {
                                deckDetailsActivity2.setupCardsAdapter(list4);
                            }
                            deckDetailsActivity2.updateBottomBar();
                        }
                        constraintLayout.setVisibility(8);
                    }
                });
            }
            if (!arrayList.isEmpty()) {
                ArrayList arrayList9 = new ArrayList();
                for (CollectionStatusDialogResult collectionStatusDialogResult2 : arrayList) {
                    MTCollectionListEntry mTCollectionListEntry = new MTCollectionListEntry(null, null, 3, null);
                    MTCollectionListEntry mTCollectionListEntry2 = new MTCollectionListEntry(null, null, 3, null);
                    mTCollectionListEntry.setList_card_id(collectionStatusDialogResult2.getListCardId());
                    mTCollectionListEntry.setList_id(Integer.valueOf(i2));
                    MTCollectionCardMatch selectedMatch = collectionStatusDialogResult2.getSelectedMatch();
                    mTCollectionListEntry2.setList_card_id((selectedMatch == null || (card = selectedMatch.getCard()) == null) ? null : card.getList_card_id());
                    MTCollectionCardMatch selectedMatch2 = collectionStatusDialogResult2.getSelectedMatch();
                    mTCollectionListEntry2.setList_id((selectedMatch2 == null || (list = selectedMatch2.getList()) == null) ? null : Integer.valueOf(list.getId()));
                    arrayList9.add(new MTCollectionStatusEdit(mTCollectionListEntry, mTCollectionListEntry2));
                }
                MTEditCollectionStatusBody mTEditCollectionStatusBody = new MTEditCollectionStatusBody(null, i3, null);
                mTEditCollectionStatusBody.setCards(arrayList9);
                MTApiKt.getMtApi().editCollectionStatusFromList(mTUser.getId(), i2, null, null, deckDetailsActivity.currentGroupBy, deckDetailsActivity.currentSortBy, deckDetailsActivity.currentSortDirection, Boolean.valueOf(deckDetailsActivity.ignoreCollection), Boolean.valueOf(deckDetailsActivity.ignoreBasicLands), Boolean.valueOf(deckDetailsActivity.ignorePrintings), mTEditCollectionStatusBody).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onDeckCardCollectionStatus$3$1$3
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        Log.e("ScanFragment", "Failed to edit MT Card: " + t.getMessage());
                        constraintLayout.setVisibility(8);
                        Toast.makeText(this.this$0, R.string.error_editing_card, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                        MTCardContainer maybeboard;
                        MTCardContainer sideboard;
                        MTCardContainer main;
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                            return;
                        }
                        if (response.isSuccessful()) {
                            preferencesManager.incrementCollectionVersion();
                            preferencesManager.incrementAllContainerVersions();
                            MTCardListResponse mTCardListResponseBody = response.body();
                            MTCardContainer list3 = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                            if (list3 != null) {
                                int i4 = i2;
                                DeckDetailsActivity deckDetailsActivity2 = this.this$0;
                                MTDeckLists mTDeckLists = deckDetailsActivity2.currentLists;
                                if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || i4 != main.getId()) {
                                    MTDeckLists mTDeckLists2 = deckDetailsActivity2.currentLists;
                                    if (mTDeckLists2 == null || (sideboard = mTDeckLists2.getSideboard()) == null || i4 != sideboard.getId()) {
                                        MTDeckLists mTDeckLists3 = deckDetailsActivity2.currentLists;
                                        if (mTDeckLists3 != null && (maybeboard = mTDeckLists3.getMaybeboard()) != null && i4 == maybeboard.getId()) {
                                            MTDeckLists mTDeckLists4 = deckDetailsActivity2.currentLists;
                                            deckDetailsActivity2.currentLists = mTDeckLists4 != null ? MTDeckLists.copy$default(mTDeckLists4, null, null, list3, 3, null) : null;
                                        }
                                    } else {
                                        MTDeckLists mTDeckLists5 = deckDetailsActivity2.currentLists;
                                        deckDetailsActivity2.currentLists = mTDeckLists5 != null ? MTDeckLists.copy$default(mTDeckLists5, null, list3, null, 5, null) : null;
                                    }
                                } else {
                                    MTDeckLists mTDeckLists6 = deckDetailsActivity2.currentLists;
                                    deckDetailsActivity2.currentLists = mTDeckLists6 != null ? MTDeckLists.copy$default(mTDeckLists6, list3, null, null, 6, null) : null;
                                    List<MTCardGroup> grouped_cards = list3.getGrouped_cards();
                                    if (grouped_cards != null) {
                                        deckDetailsActivity2.currentGroupedCards = grouped_cards;
                                    }
                                }
                                List list4 = deckDetailsActivity2.currentGroupedCards;
                                if (list4 != null) {
                                    deckDetailsActivity2.setupCardsAdapter(list4);
                                }
                                deckDetailsActivity2.updateBottomBar();
                            }
                        } else {
                            Toast.makeText(this.this$0, R.string.error_editing_card, 0).show();
                        }
                        constraintLayout.setVisibility(8);
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onDeckCardCommanderColorClick$lambda$1$0$0(Ref.ObjectRef objectRef, ImageView imageView, final boolean z, final String str, MTUser mTUser, MTDeck mTDeck, final DeckDetailsActivity deckDetailsActivity) {
        AlertDialog alertDialog = (AlertDialog) objectRef.element;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        final ConstraintLayout constraintLayout = (ConstraintLayout) imageView.findViewById(R.id.overlay);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        MTApiKt.getMtApi().editDeckCommanderColor(mTUser.getId(), mTDeck.getId(), z ? new MTColorOverrideBody(str, null, 2, null) : new MTColorOverrideBody(null, str, 1, null)).enqueue(new Callback<MTSingleDeckResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onDeckCardCommanderColorClick$1$iv$1$1$1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSingleDeckResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = constraintLayout;
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(8);
                }
                Toast.makeText(this.this$0, R.string.error_editing_card, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSingleDeckResponse> call, Response<MTSingleDeckResponse> response) {
                MTDeck mTDeckCopy$default;
                int i;
                Object obj;
                int i2;
                int i3;
                String str2;
                int i4;
                Boolean bool;
                boolean z2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                String str9;
                String str10;
                MTStats mTStats;
                String str11;
                String str12;
                String str13;
                Boolean bool2;
                MTBracket mTBracket;
                Integer num;
                Integer num2;
                Integer num3;
                Boolean bool3;
                String str14;
                String str15;
                MTDeckValues mTDeckValues;
                String str16;
                String str17;
                String str18;
                String str19;
                String str20;
                String str21;
                String str22;
                Integer num4;
                Integer num5;
                String str23;
                String str24;
                String str25;
                String str26;
                MTPrivacyUser mTPrivacyUser;
                Boolean bool4;
                Boolean bool5;
                int i5;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                    return;
                }
                ConstraintLayout constraintLayout2 = constraintLayout;
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(8);
                }
                boolean zIsSuccessful = response.isSuccessful();
                DeckDetailsActivity deckDetailsActivity2 = this.this$0;
                if (!zIsSuccessful) {
                    Toast.makeText(deckDetailsActivity2, R.string.error_editing_card, 0).show();
                    return;
                }
                MTSingleDeckResponse mTSingleDeckResponseBody = response.body();
                if (mTSingleDeckResponseBody == null || (mTDeckCopy$default = mTSingleDeckResponseBody.getDeck()) == null) {
                    MTDeck mTDeck2 = this.this$0.currentDeck;
                    if (mTDeck2 != null) {
                        boolean z3 = z;
                        String str27 = str;
                        if (z3) {
                            i = 2047;
                            obj = null;
                            i2 = 0;
                            i3 = 0;
                            str2 = null;
                            i4 = 0;
                            bool = null;
                            z2 = false;
                            str3 = null;
                            str4 = null;
                            str5 = null;
                            str6 = null;
                            str7 = null;
                            str8 = null;
                            str9 = null;
                            str10 = null;
                            mTStats = null;
                            str11 = null;
                            str12 = null;
                            str13 = null;
                            bool2 = null;
                            mTBracket = null;
                            num = null;
                            num2 = null;
                            num3 = null;
                            bool3 = null;
                            str14 = null;
                            mTDeckValues = null;
                            str16 = null;
                            str17 = null;
                            str18 = null;
                            str19 = null;
                            str20 = null;
                            str21 = null;
                            str22 = null;
                            num4 = null;
                            num5 = null;
                            str23 = null;
                            str24 = null;
                            str25 = null;
                            str26 = null;
                            mTPrivacyUser = null;
                            bool4 = null;
                            bool5 = null;
                            i5 = -16777217;
                            str15 = str27;
                        } else {
                            i = 2047;
                            obj = null;
                            i2 = 0;
                            i3 = 0;
                            str2 = null;
                            i4 = 0;
                            bool = null;
                            z2 = false;
                            str3 = null;
                            str4 = null;
                            str5 = null;
                            str6 = null;
                            str7 = null;
                            str8 = null;
                            str9 = null;
                            str10 = null;
                            mTStats = null;
                            str11 = null;
                            str12 = null;
                            str13 = null;
                            bool2 = null;
                            mTBracket = null;
                            num = null;
                            num2 = null;
                            num3 = null;
                            bool3 = null;
                            str14 = str27;
                            str15 = null;
                            mTDeckValues = null;
                            str16 = null;
                            str17 = null;
                            str18 = null;
                            str19 = null;
                            str20 = null;
                            str21 = null;
                            str22 = null;
                            num4 = null;
                            num5 = null;
                            str23 = null;
                            str24 = null;
                            str25 = null;
                            str26 = null;
                            mTPrivacyUser = null;
                            bool4 = null;
                            bool5 = null;
                            i5 = -33554433;
                        }
                        mTDeckCopy$default = MTDeck.copy$default(mTDeck2, i2, i3, str2, i4, bool, z2, str3, str4, str5, str6, str7, str8, str9, str10, mTStats, str11, str12, str13, bool2, mTBracket, num, num2, num3, bool3, str15, str14, mTDeckValues, str16, str17, str18, str19, str20, str21, str22, num4, num5, str23, str24, str25, str26, mTPrivacyUser, bool4, bool5, i5, i, obj);
                    } else {
                        mTDeckCopy$default = null;
                    }
                }
                deckDetailsActivity2.currentDeck = mTDeckCopy$default;
                List list = this.this$0.currentGroupedCards;
                if (list != null) {
                    this.this$0.setupCardsAdapter(list);
                }
                this.this$0.updateUI();
            }
        });
        return Unit.INSTANCE;
    }

    static final Unit onDeckCardDelete$lambda$0(final DeckDetailsActivity deckDetailsActivity, final int i, int i2, boolean z, List selectedIds) {
        Intrinsics.checkNotNullParameter(selectedIds, "selectedIds");
        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        final PreferencesManager preferencesManager = new PreferencesManager(deckDetailsActivity);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            final ConstraintLayout constraintLayout = (ConstraintLayout) deckDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            List list = selectedIds;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new MTCardReference(((Number) it.next()).intValue()));
            }
            MTRemoveCardsBody mTRemoveCardsBody = new MTRemoveCardsBody(arrayList);
            MTApi mtApi = MTApiKt.getMtApi();
            int id = currentUser.getId();
            String str = deckDetailsActivity.currentGroupBy;
            String str2 = deckDetailsActivity.currentSortBy;
            String str3 = deckDetailsActivity.currentSortDirection;
            boolean z2 = deckDetailsActivity.ignoreCollection;
            boolean z3 = deckDetailsActivity.ignoreBasicLands;
            MTApi.removeCardsFromList$default(mtApi, id, i, null, null, str, str2, str3, Boolean.valueOf(z2), Boolean.valueOf(deckDetailsActivity.ignorePrintings), Boolean.valueOf(z3), Boolean.valueOf(z), mTRemoveCardsBody, 12, null).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onDeckCardDelete$1$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    constraintLayout.setVisibility(8);
                    Toast.makeText(this.this$0, R.string.error_deleting_card, 0).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                    MTCardContainer maybeboard;
                    MTCardContainer sideboard;
                    MTCardContainer main;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.isDestroyed() || this.this$0.isFinishing()) {
                        return;
                    }
                    if (!response.isSuccessful()) {
                        constraintLayout.setVisibility(8);
                        Toast.makeText(this.this$0, R.string.error_deleting_card, 0).show();
                        return;
                    }
                    preferencesManager.incrementCollectionVersion();
                    preferencesManager.incrementAllContainerVersions();
                    MTCardListResponse mTCardListResponseBody = response.body();
                    MTCardContainer list2 = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                    if (list2 != null) {
                        int i3 = i;
                        DeckDetailsActivity deckDetailsActivity2 = this.this$0;
                        MTDeckLists mTDeckLists = deckDetailsActivity2.currentLists;
                        if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || i3 != main.getId()) {
                            MTDeckLists mTDeckLists2 = deckDetailsActivity2.currentLists;
                            if (mTDeckLists2 == null || (sideboard = mTDeckLists2.getSideboard()) == null || i3 != sideboard.getId()) {
                                MTDeckLists mTDeckLists3 = deckDetailsActivity2.currentLists;
                                if (mTDeckLists3 != null && (maybeboard = mTDeckLists3.getMaybeboard()) != null && i3 == maybeboard.getId()) {
                                    MTDeckLists mTDeckLists4 = deckDetailsActivity2.currentLists;
                                    deckDetailsActivity2.currentLists = mTDeckLists4 != null ? MTDeckLists.copy$default(mTDeckLists4, null, null, list2, 3, null) : null;
                                }
                            } else {
                                MTDeckLists mTDeckLists5 = deckDetailsActivity2.currentLists;
                                deckDetailsActivity2.currentLists = mTDeckLists5 != null ? MTDeckLists.copy$default(mTDeckLists5, null, list2, null, 5, null) : null;
                            }
                        } else {
                            MTDeckLists mTDeckLists6 = deckDetailsActivity2.currentLists;
                            deckDetailsActivity2.currentLists = mTDeckLists6 != null ? MTDeckLists.copy$default(mTDeckLists6, list2, null, null, 6, null) : null;
                            List<MTCardGroup> grouped_cards = list2.getGrouped_cards();
                            if (grouped_cards != null) {
                                deckDetailsActivity2.currentGroupedCards = grouped_cards;
                            }
                        }
                        List list3 = deckDetailsActivity2.currentGroupedCards;
                        if (list3 != null) {
                            deckDetailsActivity2.setupCardsAdapter(list3);
                        }
                        deckDetailsActivity2.onDeckListModified();
                    }
                    constraintLayout.setVisibility(8);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0207  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final Unit onDeckCardEdit$lambda$0(final DeckDetailsActivity deckDetailsActivity, MTFullCard mTFullCard, final int i, Integer num, Integer num2, String str, String str2, String str3, MTFullCard mTFullCard2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Integer num3, Double d) {
        ArrayList mutableList;
        int iIntValue;
        int iIntValue2;
        int i2;
        String cardid;
        String lowerCase;
        Boolean altered;
        Boolean signed;
        Boolean missprint;
        Boolean proxy;
        String set_code;
        String cardid2;
        String lowerCase2;
        Boolean altered2;
        Boolean signed2;
        Boolean missprint2;
        Boolean proxy2;
        String set_code2;
        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        List<Integer> variant_list_card_ids = mTFullCard.getVariant_list_card_ids();
        if (variant_list_card_ids == null || (mutableList = CollectionsKt.toMutableList((Collection) variant_list_card_ids)) == null) {
            List<Integer> list_card_ids = mTFullCard.getList_card_ids();
            mutableList = list_card_ids != null ? CollectionsKt.toMutableList((Collection) list_card_ids) : new ArrayList();
        }
        Integer variant_quantity = mTFullCard.getVariant_quantity();
        int iIntValue3 = (variant_quantity == null && (variant_quantity = mTFullCard.getQuantity()) == null) ? 1 : variant_quantity.intValue();
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            Integer variant_quantity2 = mTFullCard.getVariant_quantity();
            iIntValue = (variant_quantity2 == null && (variant_quantity2 = mTFullCard.getQuantity()) == null) ? 1 : variant_quantity2.intValue();
        }
        if (num2 != null) {
            iIntValue2 = num2.intValue();
        } else {
            Integer variant_quantity3 = mTFullCard.getVariant_quantity();
            iIntValue2 = (variant_quantity3 == null && (variant_quantity3 = mTFullCard.getQuantity()) == null) ? 1 : variant_quantity3.intValue();
        }
        int iIntValue4 = num2 != null ? num2.intValue() : 1;
        MTEditCardBody mTEditCardBody = new MTEditCardBody(null, 1, null);
        mTEditCardBody.setCards(new MTEditCardActions(null, null, null, 7, null));
        if (iIntValue < iIntValue3) {
            List listTake = CollectionsKt.take(mutableList, iIntValue3 - iIntValue);
            ArrayList arrayList = new ArrayList();
            mutableList.removeAll(listTake);
            Iterator it = listTake.iterator();
            while (it.hasNext()) {
                int iIntValue5 = ((Number) it.next()).intValue();
                MTCardReference mTCardReference = new MTCardReference(0, 1, null);
                mTCardReference.setList_card_id(iIntValue5);
                arrayList.add(mTCardReference);
            }
            MTEditCardActions cards = mTEditCardBody.getCards();
            if (cards != null) {
                cards.setDeleted(arrayList);
                Unit unit = Unit.INSTANCE;
            }
        }
        if (iIntValue > iIntValue3) {
            int i3 = iIntValue - iIntValue3;
            ArrayList arrayList2 = new ArrayList();
            i2 = 0;
            for (int i4 = 0; i4 < i3; i4++) {
                MTFullCard mTFullCard3 = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                if (i2 < iIntValue4) {
                    i2++;
                    if (mTFullCard2 == null || (cardid2 = mTFullCard2.getCardid()) == null) {
                        cardid2 = mTFullCard.getCardid();
                    }
                    mTFullCard3.setCardid(cardid2);
                    mTFullCard3.setScryfallid(null);
                    if (mTFullCard2 == null || (set_code2 = mTFullCard2.getSet_code()) == null) {
                        String set_code3 = mTFullCard.getSet_code();
                        if (set_code3 != null) {
                            lowerCase2 = set_code3.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        } else {
                            lowerCase2 = null;
                        }
                        mTFullCard3.setSet_code(lowerCase2);
                        if (mTFullCard2 != null || (collector_number = mTFullCard2.getCollector_number()) == null) {
                            String collector_number = mTFullCard.getCollector_number();
                        }
                        mTFullCard3.setCollector_number(collector_number);
                        mTFullCard3.setLang(str != null ? mTFullCard.getLang() : str);
                        mTFullCard3.setFinish(str2 != null ? mTFullCard.getFinish() : str2);
                        mTFullCard3.setCondition(str3 != null ? mTFullCard.getCondition() : str3);
                        if (bool != null) {
                            altered2 = mTFullCard.getAltered();
                            if (altered2 == null) {
                                altered2 = false;
                            }
                        } else {
                            altered2 = bool;
                        }
                        mTFullCard3.setAltered(altered2);
                        if (bool2 != null) {
                            signed2 = mTFullCard.getSigned();
                            if (signed2 == null) {
                                signed2 = false;
                            }
                        } else {
                            signed2 = bool2;
                        }
                        mTFullCard3.setSigned(signed2);
                        if (bool3 != null) {
                            missprint2 = mTFullCard.getMissprint();
                            if (missprint2 == null) {
                                missprint2 = false;
                            }
                        } else {
                            missprint2 = bool3;
                        }
                        mTFullCard3.setMissprint(missprint2);
                        if (bool4 != null) {
                            proxy2 = mTFullCard.getProxy();
                            if (proxy2 == null) {
                                proxy2 = false;
                            }
                        } else {
                            proxy2 = bool4;
                        }
                        mTFullCard3.setProxy(proxy2);
                    } else {
                        lowerCase2 = set_code2.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        if (lowerCase2 == null) {
                        }
                        mTFullCard3.setSet_code(lowerCase2);
                        if (mTFullCard2 != null) {
                            String collector_number2 = mTFullCard.getCollector_number();
                            mTFullCard3.setCollector_number(collector_number2);
                            mTFullCard3.setLang(str != null ? mTFullCard.getLang() : str);
                            mTFullCard3.setFinish(str2 != null ? mTFullCard.getFinish() : str2);
                            mTFullCard3.setCondition(str3 != null ? mTFullCard.getCondition() : str3);
                            if (bool != null) {
                            }
                            mTFullCard3.setAltered(altered2);
                            if (bool2 != null) {
                            }
                            mTFullCard3.setSigned(signed2);
                            if (bool3 != null) {
                            }
                            mTFullCard3.setMissprint(missprint2);
                            if (bool4 != null) {
                            }
                            mTFullCard3.setProxy(proxy2);
                        }
                    }
                } else {
                    mTFullCard3.setCardid(mTFullCard.getCardid());
                    mTFullCard3.setScryfallid(null);
                    mTFullCard3.setSet_code(mTFullCard.getSet_code());
                    mTFullCard3.setCollector_number(mTFullCard.getCollector_number());
                    mTFullCard3.setLang(mTFullCard.getLang());
                    mTFullCard3.setFinish(mTFullCard.getFinish());
                    mTFullCard3.setCondition(mTFullCard.getCondition());
                    boolean altered3 = mTFullCard.getAltered();
                    if (altered3 == null) {
                        altered3 = false;
                    }
                    mTFullCard3.setAltered(altered3);
                    boolean signed3 = mTFullCard.getSigned();
                    if (signed3 == null) {
                        signed3 = false;
                    }
                    mTFullCard3.setSigned(signed3);
                    boolean missprint3 = mTFullCard.getMissprint();
                    if (missprint3 == null) {
                        missprint3 = false;
                    }
                    mTFullCard3.setMissprint(missprint3);
                    boolean proxy3 = mTFullCard.getProxy();
                    if (proxy3 == null) {
                        proxy3 = false;
                    }
                    mTFullCard3.setProxy(proxy3);
                }
                arrayList2.add(mTFullCard3);
            }
            MTEditCardActions cards2 = mTEditCardBody.getCards();
            if (cards2 != null) {
                cards2.setAdded(arrayList2);
                Unit unit2 = Unit.INSTANCE;
            }
        } else {
            i2 = 0;
        }
        if (iIntValue2 > 0) {
            ArrayList arrayList3 = new ArrayList();
            for (int i5 = 0; i5 < iIntValue2; i5++) {
                if (i2 < iIntValue4) {
                    MTFullCard mTFullCard4 = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                    i2++;
                    if (mTFullCard2 == null || (cardid = mTFullCard2.getCardid()) == null) {
                        cardid = mTFullCard.getCardid();
                    }
                    mTFullCard4.setCardid(cardid);
                    if (mTFullCard2 == null || (set_code = mTFullCard2.getSet_code()) == null) {
                        String set_code4 = mTFullCard.getSet_code();
                        if (set_code4 != null) {
                            lowerCase = set_code4.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        } else {
                            lowerCase = null;
                        }
                        mTFullCard4.setSet_code(lowerCase);
                        if (mTFullCard2 != null || (collector_number = mTFullCard2.getCollector_number()) == null) {
                            String collector_number3 = mTFullCard.getCollector_number();
                        }
                        mTFullCard4.setCollector_number(collector_number3);
                        mTFullCard4.setLang(str != null ? mTFullCard.getLang() : str);
                        mTFullCard4.setFinish(str2 != null ? mTFullCard.getFinish() : str2);
                        mTFullCard4.setCondition(str3 != null ? mTFullCard.getCondition() : str3);
                        if (bool != null) {
                            altered = mTFullCard.getAltered();
                            if (altered == null) {
                                altered = false;
                            }
                        } else {
                            altered = bool;
                        }
                        mTFullCard4.setAltered(altered);
                        if (bool2 != null) {
                            signed = mTFullCard.getSigned();
                            if (signed == null) {
                                signed = false;
                            }
                        } else {
                            signed = bool2;
                        }
                        mTFullCard4.setSigned(signed);
                        if (bool3 != null) {
                            missprint = mTFullCard.getMissprint();
                            if (missprint == null) {
                                missprint = false;
                            }
                        } else {
                            missprint = bool3;
                        }
                        mTFullCard4.setMissprint(missprint);
                        if (bool4 != null) {
                            proxy = mTFullCard.getProxy();
                            if (proxy == null) {
                                proxy = false;
                            }
                        } else {
                            proxy = bool4;
                        }
                        mTFullCard4.setProxy(proxy);
                        mTFullCard4.setList_card_id((Integer) CollectionsKt.getOrNull(mutableList, i5));
                        arrayList3.add(mTFullCard4);
                    } else {
                        lowerCase = set_code.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        if (lowerCase == null) {
                        }
                        mTFullCard4.setSet_code(lowerCase);
                        if (mTFullCard2 != null) {
                            String collector_number32 = mTFullCard.getCollector_number();
                            mTFullCard4.setCollector_number(collector_number32);
                            mTFullCard4.setLang(str != null ? mTFullCard.getLang() : str);
                            mTFullCard4.setFinish(str2 != null ? mTFullCard.getFinish() : str2);
                            mTFullCard4.setCondition(str3 != null ? mTFullCard.getCondition() : str3);
                            if (bool != null) {
                            }
                            mTFullCard4.setAltered(altered);
                            if (bool2 != null) {
                            }
                            mTFullCard4.setSigned(signed);
                            if (bool3 != null) {
                            }
                            mTFullCard4.setMissprint(missprint);
                            if (bool4 != null) {
                            }
                            mTFullCard4.setProxy(proxy);
                            mTFullCard4.setList_card_id((Integer) CollectionsKt.getOrNull(mutableList, i5));
                            arrayList3.add(mTFullCard4);
                        }
                    }
                }
            }
            MTEditCardActions cards3 = mTEditCardBody.getCards();
            if (cards3 != null) {
                cards3.setEdited(arrayList3);
                Unit unit3 = Unit.INSTANCE;
            }
        }
        MTUser currentUser = new PreferencesManager(deckDetailsActivity).getCurrentUser();
        if (currentUser != null) {
            final ConstraintLayout constraintLayout = (ConstraintLayout) deckDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
                Unit unit4 = Unit.INSTANCE;
            }
            MTApiKt.getMtApi().editCardsFromList(currentUser.getId(), i, null, null, deckDetailsActivity.currentGroupBy, deckDetailsActivity.currentSortBy, deckDetailsActivity.currentSortDirection, true, Boolean.valueOf(deckDetailsActivity.ignoreCollection), Boolean.valueOf(deckDetailsActivity.ignoreBasicLands), Boolean.valueOf(deckDetailsActivity.ignorePrintings), mTEditCardBody).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onDeckCardEdit$dialog$1$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    Log.e("ScanFragment", "Failed to edit MT Card: " + t.getMessage());
                    constraintLayout.setVisibility(8);
                    Toast.makeText(this.this$0, R.string.error_editing_card, 0).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                    MTCardContainer maybeboard;
                    MTCardContainer sideboard;
                    MTCardContainer main;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                        return;
                    }
                    if (!response.isSuccessful()) {
                        constraintLayout.setVisibility(8);
                        Toast.makeText(this.this$0, R.string.error_editing_card, 0).show();
                        return;
                    }
                    MTCardListResponse mTCardListResponseBody = response.body();
                    MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                    if (list != null) {
                        int i6 = i;
                        DeckDetailsActivity deckDetailsActivity2 = this.this$0;
                        MTDeckLists mTDeckLists = deckDetailsActivity2.currentLists;
                        if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || i6 != main.getId()) {
                            MTDeckLists mTDeckLists2 = deckDetailsActivity2.currentLists;
                            if (mTDeckLists2 == null || (sideboard = mTDeckLists2.getSideboard()) == null || i6 != sideboard.getId()) {
                                MTDeckLists mTDeckLists3 = deckDetailsActivity2.currentLists;
                                if (mTDeckLists3 != null && (maybeboard = mTDeckLists3.getMaybeboard()) != null && i6 == maybeboard.getId()) {
                                    MTDeckLists mTDeckLists4 = deckDetailsActivity2.currentLists;
                                    deckDetailsActivity2.currentLists = mTDeckLists4 != null ? MTDeckLists.copy$default(mTDeckLists4, null, null, list, 3, null) : null;
                                }
                            } else {
                                MTDeckLists mTDeckLists5 = deckDetailsActivity2.currentLists;
                                deckDetailsActivity2.currentLists = mTDeckLists5 != null ? MTDeckLists.copy$default(mTDeckLists5, null, list, null, 5, null) : null;
                            }
                        } else {
                            MTDeckLists mTDeckLists6 = deckDetailsActivity2.currentLists;
                            deckDetailsActivity2.currentLists = mTDeckLists6 != null ? MTDeckLists.copy$default(mTDeckLists6, list, null, null, 6, null) : null;
                            List<MTCardGroup> grouped_cards = list.getGrouped_cards();
                            if (grouped_cards != null) {
                                deckDetailsActivity2.currentGroupedCards = grouped_cards;
                            }
                        }
                        List list2 = deckDetailsActivity2.currentGroupedCards;
                        if (list2 != null) {
                            deckDetailsActivity2.setupCardsAdapter(list2);
                        }
                        deckDetailsActivity2.onDeckListModified();
                    }
                    constraintLayout.setVisibility(8);
                }
            });
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void onDeckCardOpen$addCardWithVariants(List<MTFullCard> list, Ref.IntRef intRef, Ref.IntRef intRef2, MTFullCard mTFullCard, MTFullCard mTFullCard2) {
        boolean z;
        Ref.IntRef intRef3;
        MTFullCard mTFullCard3;
        MTFullCard mTFullCard4;
        int iIntValue;
        if (mTFullCard.getVariants() != null) {
            List<MTFullCard> variants = mTFullCard.getVariants();
            Intrinsics.checkNotNull(variants);
            if (variants.isEmpty()) {
                if (mTFullCard.getVariant_quantity() != null) {
                    Integer variant_quantity = mTFullCard.getVariant_quantity();
                    Intrinsics.checkNotNull(variant_quantity);
                    z = variant_quantity.intValue() > 0;
                }
            }
        }
        Integer quantity = mTFullCard.getQuantity();
        int iIntValue2 = quantity != null ? quantity.intValue() : 1;
        if (!z || iIntValue2 <= 1) {
            list.add(mTFullCard);
            if (onDeckCardOpen$addCardWithVariants$isTargetCard(mTFullCard2, mTFullCard)) {
                intRef.element = intRef2.element;
            }
            intRef2.element++;
            return;
        }
        Integer variant_quantity2 = mTFullCard.getVariant_quantity();
        if (variant_quantity2 == null || (iIntValue = variant_quantity2.intValue()) <= 0) {
            intRef3 = intRef;
            mTFullCard3 = mTFullCard;
            mTFullCard4 = mTFullCard2;
        } else {
            Integer numValueOf = Integer.valueOf(iIntValue);
            mTFullCard4 = mTFullCard2;
            mTFullCard3 = mTFullCard;
            MTFullCard mTFullCardCopy$default = MTFullCard.copy$default(mTFullCard3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, numValueOf, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -16385, 127, null);
            list.add(mTFullCardCopy$default);
            if (onDeckCardOpen$addCardWithVariants$isTargetCard(mTFullCard4, mTFullCardCopy$default)) {
                intRef3 = intRef;
                intRef3.element = intRef2.element;
            } else {
                intRef3 = intRef;
            }
            intRef2.element++;
        }
        List<MTFullCard> variants2 = mTFullCard3.getVariants();
        if (variants2 != null) {
            Iterator<T> it = variants2.iterator();
            while (it.hasNext()) {
                MTFullCard mTFullCardCopy$default2 = MTFullCard.copy$default((MTFullCard) it.next(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                list.add(mTFullCardCopy$default2);
                if (onDeckCardOpen$addCardWithVariants$isTargetCard(mTFullCard4, mTFullCardCopy$default2)) {
                    intRef3.element = intRef2.element;
                }
                intRef2.element++;
            }
        }
    }

    private static final boolean onDeckCardOpen$addCardWithVariants$isTargetCard(MTFullCard mTFullCard, MTFullCard mTFullCard2) {
        return (mTFullCard.getList_card_id() == null || mTFullCard2.getList_card_id() == null) ? Intrinsics.areEqual(mTFullCard2.getCardid(), mTFullCard.getCardid()) : Intrinsics.areEqual(mTFullCard2.getList_card_id(), mTFullCard.getList_card_id());
    }

    private static final void onDeckCardOpen$addCardsFromGroups(boolean z, String str, MTFullCard mTFullCard, List<MTFullCard> list, Ref.IntRef intRef, Ref.IntRef intRef2, List<MTCardGroup> list2) {
        if (list2 != null) {
            for (MTCardGroup mTCardGroup : list2) {
                if (!z || Intrinsics.areEqual(mTCardGroup.getType(), str)) {
                    List<MTFullCard> cards = mTCardGroup.getCards();
                    if (cards != null) {
                        Iterator<T> it = cards.iterator();
                        while (it.hasNext()) {
                            onDeckCardOpen$addCardWithVariants(list, intRef, intRef2, (MTFullCard) it.next(), mTFullCard);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDeckListModified() {
        updateBottomBar();
        fetchDeckIdCardIfNeeded(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onDeleteGameClicked$lambda$0$0(DeckDetailsActivity deckDetailsActivity, MTSet mTSet, String str, boolean z, CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        MTUser currentUser = new PreferencesManager(deckDetailsActivity).getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) deckDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            MTApiKt.getMtApi().deleteSet(currentUser.getId(), mTSet.getId()).enqueue(new DeckDetailsActivity$onDeleteGameClicked$1$dialog$1$1$1(deckDetailsActivity, constraintLayout, mTSet));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onDeleteGameClicked$lambda$0$1(CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeleteGameClicked$lambda$1(DeckDetailsActivity deckDetailsActivity, MTGame mTGame, String str, boolean z, CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        MTUser currentUser = new PreferencesManager(deckDetailsActivity).getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) deckDetailsActivity.findViewById(R.id.overlay);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            int id = mTGame.getId();
            MTApiKt.getMtApi().deleteGame(currentUser.getId(), id).enqueue(new DeckDetailsActivity$onDeleteGameClicked$dialog$1$1$1(deckDetailsActivity, constraintLayout, id));
        }
        return Unit.INSTANCE;
    }

    static final Unit onDeleteGameClicked$lambda$2(CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void openIdCardDetails(int tab) {
        ArrayList arrayListEmptyList;
        MTCardContainer main;
        List<MTCardGroup> grouped_cards;
        MTDeckIdCardResponse mTDeckIdCardResponse = this.deckIdCardResponse;
        if (mTDeckIdCardResponse == null) {
            return;
        }
        DeckIDCardDetailsBottomSheetFragment.Companion companion = DeckIDCardDetailsBottomSheetFragment.INSTANCE;
        MTDeckLists mTDeckLists = this.currentLists;
        if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || (grouped_cards = main.getGrouped_cards()) == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = grouped_cards.iterator();
            while (it.hasNext()) {
                List<MTFullCard> cards = ((MTCardGroup) it.next()).getCards();
                if (cards == null) {
                    cards = CollectionsKt.emptyList();
                }
                CollectionsKt.addAll(arrayList, cards);
            }
            arrayListEmptyList = arrayList;
        }
        companion.setDeckCardList(arrayListEmptyList);
        DeckIDCardDetailsBottomSheetFragment.INSTANCE.setOnFindCards(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeckDetailsActivity.openIdCardDetails$lambda$1(this.f$0, (String) obj);
            }
        });
        DeckIDCardDetailsBottomSheetFragment.INSTANCE.newInstance(mTDeckIdCardResponse, tab).show(getSupportFragmentManager(), DeckIDCardDetailsBottomSheetFragment.TAG);
    }

    static final Unit openIdCardDetails$lambda$1(DeckDetailsActivity deckDetailsActivity, String fillGap) {
        Intrinsics.checkNotNullParameter(fillGap, "fillGap");
        Fragment fragmentFindFragmentByTag = deckDetailsActivity.getSupportFragmentManager().findFragmentByTag(DeckIDCardDetailsBottomSheetFragment.TAG);
        DeckIDCardDetailsBottomSheetFragment deckIDCardDetailsBottomSheetFragment = fragmentFindFragmentByTag instanceof DeckIDCardDetailsBottomSheetFragment ? (DeckIDCardDetailsBottomSheetFragment) fragmentFindFragmentByTag : null;
        if (deckIDCardDetailsBottomSheetFragment != null) {
            deckIDCardDetailsBottomSheetFragment.dismiss();
        }
        deckDetailsActivity.showMythicPlusPanel();
        deckDetailsActivity.getSupportFragmentManager().executePendingTransactions();
        MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment = deckDetailsActivity.mythicPlusBottomSheet;
        if (mythicPlusBottomSheetFragment != null) {
            mythicPlusBottomSheetFragment.openSearchForGap(fillGap);
        }
        return Unit.INSTANCE;
    }

    static final void pickCardLauncher$lambda$0(DeckDetailsActivity deckDetailsActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        String stringExtra = data != null ? data.getStringExtra("cardPicked") : null;
        Intent data2 = result.getData();
        int intExtra = data2 != null ? data2.getIntExtra(OptionalModuleUtils.FACE, 0) : 0;
        if (stringExtra != null) {
            MTFullCard mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class);
            Fragment fragmentFindFragmentByTag = deckDetailsActivity.getSupportFragmentManager().findFragmentByTag(CreateDeckBottomSheetFragment.TAG);
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment = fragmentFindFragmentByTag instanceof CreateDeckBottomSheetFragment ? (CreateDeckBottomSheetFragment) fragmentFindFragmentByTag : null;
            if (createDeckBottomSheetFragment != null) {
                Intrinsics.checkNotNull(mTFullCard);
                createDeckBottomSheetFragment.cardScanned(mTFullCard, intExtra);
            }
        }
    }

    private final void propagateSelectionMode(boolean enabled) {
        Function1<? super MTFullCard, Boolean> function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda76
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(DeckDetailsActivity.propagateSelectionMode$lambda$0(this.f$0, (MTFullCard) obj));
            }
        };
        DeckCardsAdapter deckCardsAdapter = this.deckCardsAdapter;
        if (deckCardsAdapter != null) {
            deckCardsAdapter.setSelectionChecker(function1);
        }
        DeckCardsAdapter deckCardsAdapter2 = this.deckCardsAdapter;
        if (deckCardsAdapter2 != null) {
            deckCardsAdapter2.setSelectionMode(enabled);
        }
        DeckCardsAdapter deckCardsAdapter3 = this.sideboardCardsAdapter;
        if (deckCardsAdapter3 != null) {
            deckCardsAdapter3.setSelectionChecker(function1);
        }
        DeckCardsAdapter deckCardsAdapter4 = this.sideboardCardsAdapter;
        if (deckCardsAdapter4 != null) {
            deckCardsAdapter4.setSelectionMode(enabled);
        }
        DeckCardsAdapter deckCardsAdapter5 = this.maybeboardCardsAdapter;
        if (deckCardsAdapter5 != null) {
            deckCardsAdapter5.setSelectionChecker(function1);
        }
        DeckCardsAdapter deckCardsAdapter6 = this.maybeboardCardsAdapter;
        if (deckCardsAdapter6 != null) {
            deckCardsAdapter6.setSelectionMode(enabled);
        }
        View viewFindViewById = findViewById(R.id.twoColumnStackedCardsView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((TwoColumnStackedCardsView) viewFindViewById).setSelectionMode(enabled, function1);
        try {
            View viewFindViewById2 = findViewById(R.id.sideboardTwoColumnStackedCardsView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            ((TwoColumnStackedCardsView) viewFindViewById2).setSelectionMode(enabled, function1);
        } catch (Exception unused) {
        }
        try {
            View viewFindViewById3 = findViewById(R.id.maybeboardTwoColumnStackedCardsView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            ((TwoColumnStackedCardsView) viewFindViewById3).setSelectionMode(enabled, function1);
        } catch (Exception unused2) {
        }
    }

    static final boolean propagateSelectionMode$lambda$0(DeckDetailsActivity deckDetailsActivity, MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return deckDetailsActivity.isCardSelected(card);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v33, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v36, types: [T, java.util.List] */
    public final void refreshCombosDisplay() {
        LinkedHashMap linkedHashMap;
        MTCardContainer main;
        List<MTCardGroup> grouped_cards;
        String lowerCase = StringsKt.trim((CharSequence) this.combosFilterQuery).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str = lowerCase;
        int length = str.length();
        List<MTCombo> list = this.allCompleteCombos;
        T t = list;
        if (length != 0) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                List<MTComboCard> cards = ((MTCombo) obj).getCards();
                if (!(cards instanceof Collection) || !cards.isEmpty()) {
                    Iterator<T> it = cards.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (StringsKt.contains((CharSequence) ((MTComboCard) it.next()).getName(), (CharSequence) str, true)) {
                                arrayList.add(obj);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            t = arrayList;
        }
        objectRef.element = t;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        int length2 = str.length();
        List<MTCombo> list2 = this.allPartialCombos;
        T t2 = list2;
        if (length2 != 0) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                List<MTComboCard> cards2 = ((MTCombo) obj2).getCards();
                if (!(cards2 instanceof Collection) || !cards2.isEmpty()) {
                    Iterator<T> it2 = cards2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (StringsKt.contains((CharSequence) ((MTComboCard) it2.next()).getName(), (CharSequence) str, true)) {
                                arrayList2.add(obj2);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            t2 = arrayList2;
        }
        objectRef2.element = t2;
        Integer num = this.completeCombosMaxCards;
        if (num != null) {
            int iIntValue = num.intValue();
            Iterable iterable = (Iterable) objectRef.element;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : iterable) {
                if (((MTCombo) obj3).getCardCount() <= iIntValue) {
                    arrayList3.add(obj3);
                }
            }
            objectRef.element = arrayList3;
        }
        Integer num2 = this.partialCombosMaxCards;
        if (num2 != null) {
            int iIntValue2 = num2.intValue();
            Iterable iterable2 = (Iterable) objectRef2.element;
            ArrayList arrayList4 = new ArrayList();
            for (Object obj4 : iterable2) {
                if (((MTCombo) obj4).getCardCount() <= iIntValue2) {
                    arrayList4.add(obj4);
                }
            }
            objectRef2.element = arrayList4;
        }
        String str2 = this.completeCombosSortBy;
        Comparator comparatorReversed = Intrinsics.areEqual(str2, "missing_cards") ? new Comparator() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$refreshCombosDisplay$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                return ComparisonsKt.compareValues(Integer.valueOf(((MTCombo) t3).getMissingCards().size()), Integer.valueOf(((MTCombo) t4).getMissingCards().size()));
            }
        } : Intrinsics.areEqual(str2, "total_cards") ? new Comparator() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$refreshCombosDisplay$$inlined$compareBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                return ComparisonsKt.compareValues(Integer.valueOf(((MTCombo) t3).getCardCount()), Integer.valueOf(((MTCombo) t4).getCardCount()));
            }
        } : new Comparator() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$refreshCombosDisplay$$inlined$compareBy$3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                return ComparisonsKt.compareValues(Integer.valueOf(((MTCombo) t3).getPopularity()), Integer.valueOf(((MTCombo) t4).getPopularity()));
            }
        };
        if (!this.completeCombosSortAsc) {
            comparatorReversed = comparatorReversed.reversed();
        }
        String str3 = this.partialCombosSortBy;
        Comparator comparatorReversed2 = Intrinsics.areEqual(str3, "missing_cards") ? new Comparator() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$refreshCombosDisplay$$inlined$compareBy$4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                return ComparisonsKt.compareValues(Integer.valueOf(((MTCombo) t3).getMissingCards().size()), Integer.valueOf(((MTCombo) t4).getMissingCards().size()));
            }
        } : Intrinsics.areEqual(str3, "total_cards") ? new Comparator() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$refreshCombosDisplay$$inlined$compareBy$5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                return ComparisonsKt.compareValues(Integer.valueOf(((MTCombo) t3).getCardCount()), Integer.valueOf(((MTCombo) t4).getCardCount()));
            }
        } : new Comparator() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$refreshCombosDisplay$$inlined$compareBy$6
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                return ComparisonsKt.compareValues(Integer.valueOf(((MTCombo) t3).getPopularity()), Integer.valueOf(((MTCombo) t4).getPopularity()));
            }
        };
        if (!this.partialCombosSortAsc) {
            comparatorReversed2 = comparatorReversed2.reversed();
        }
        Iterable iterable3 = (Iterable) objectRef.element;
        Intrinsics.checkNotNull(comparatorReversed);
        List listSortedWith = CollectionsKt.sortedWith(iterable3, comparatorReversed);
        Iterable iterable4 = (Iterable) objectRef2.element;
        Intrinsics.checkNotNull(comparatorReversed2);
        List listSortedWith2 = CollectionsKt.sortedWith(iterable4, comparatorReversed2);
        List listTake = CollectionsKt.take(listSortedWith2, this.partialCombosPageSize * this.partialCombosPagesLoaded);
        boolean z = listSortedWith2.size() > listTake.size();
        MTDeckLists mTDeckLists = this.currentLists;
        if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || (grouped_cards = main.getGrouped_cards()) == null) {
            linkedHashMap = null;
        } else {
            ArrayList arrayList5 = new ArrayList();
            Iterator<T> it3 = grouped_cards.iterator();
            while (it3.hasNext()) {
                List<MTFullCard> cards3 = ((MTCardGroup) it3.next()).getCards();
                if (cards3 == null) {
                    cards3 = CollectionsKt.emptyList();
                }
                CollectionsKt.addAll(arrayList5, cards3);
            }
            ArrayList arrayList6 = new ArrayList();
            for (Object obj5 : arrayList5) {
                if (((MTFullCard) obj5).getOracleid() != null) {
                    arrayList6.add(obj5);
                }
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList7 = new ArrayList();
            for (Object obj6 : arrayList6) {
                if (hashSet.add(((MTFullCard) obj6).getOracleid())) {
                    arrayList7.add(obj6);
                }
            }
            ArrayList arrayList8 = arrayList7;
            linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList8, 10)), 16));
            for (Object obj7 : arrayList8) {
                String oracleid = ((MTFullCard) obj7).getOracleid();
                Intrinsics.checkNotNull(oracleid);
                linkedHashMap.put(oracleid, obj7);
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        View viewFindViewById = findViewById(R.id.completeCombosRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.partialCombosRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        RecyclerView recyclerView2 = (RecyclerView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.completeCombosSection);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        View viewFindViewById4 = findViewById(R.id.partialCombosSection);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        View viewFindViewById5 = findViewById(R.id.noCombosTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.combosFilterBar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView2.setNestedScrollingEnabled(false);
        if (recyclerView.getLayoutManager() == null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        if (recyclerView2.getLayoutManager() == null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        }
        DeckDetailsActivity deckDetailsActivity = this;
        boolean z2 = z;
        recyclerView.setAdapter(new CombosAdapter(listSortedWith, deckDetailsActivity, linkedHashMap2, false, null, 16, null));
        recyclerView2.setAdapter(new CombosAdapter(listTake, deckDetailsActivity, linkedHashMap2, z2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda110
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.refreshCombosDisplay$lambda$16(this.f$0);
            }
        }));
        boolean z3 = (this.allCompleteCombos.isEmpty() && this.allPartialCombos.isEmpty()) ? false : true;
        List list3 = listSortedWith;
        textView.setVisibility((z3 && (!list3.isEmpty() || !listTake.isEmpty())) ? 8 : 0);
        viewFindViewById3.setVisibility(!list3.isEmpty() ? 0 : 8);
        viewFindViewById4.setVisibility((!listTake.isEmpty() || z2) ? 0 : 8);
        viewFindViewById6.setVisibility(z3 ? 0 : 8);
        View viewFindViewById7 = findViewById(R.id.completeCombosCount);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        View viewFindViewById8 = findViewById(R.id.partialCombosCount);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        ((TextView) viewFindViewById7).setText(String.valueOf(listSortedWith.size()));
        ((TextView) viewFindViewById8).setText(String.valueOf(listSortedWith2.size()));
        adjustCombosRecyclerViewHeight(recyclerView);
        adjustCombosRecyclerViewHeight(recyclerView2);
    }

    static final Unit refreshCombosDisplay$lambda$16(DeckDetailsActivity deckDetailsActivity) {
        deckDetailsActivity.partialCombosPagesLoaded++;
        deckDetailsActivity.refreshCombosDisplay();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshCurrentList(final int listId) {
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        if (currentUser != null) {
            showLoadingOverlay();
            MTApi mtApi = MTApiKt.getMtApi();
            int id = currentUser.getId();
            String str = this.currentSortBy;
            String str2 = this.currentGroupBy;
            String str3 = this.currentSortDirection;
            boolean z = this.ignoreCollection;
            boolean z2 = this.ignoreBasicLands;
            MTApi.getUserList$default(mtApi, id, listId, null, null, null, null, str, str2, str3, null, Boolean.valueOf(z), Boolean.valueOf(this.ignorePrintings), Boolean.valueOf(z2), Videoio.CAP_PROP_XI_DEBUG_LEVEL, null).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$refreshCurrentList$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    this.this$0.hideLoadingOverlay();
                    Toast.makeText(this.this$0, R.string.error_moving_card, 0).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                    MTCardContainer maybeboard;
                    MTCardContainer sideboard;
                    MTCardContainer main;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    this.this$0.hideLoadingOverlay();
                    if (!response.isSuccessful()) {
                        Toast.makeText(this.this$0, R.string.error_moving_card, 0).show();
                        return;
                    }
                    MTCardListResponse mTCardListResponseBody = response.body();
                    MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                    if (list != null) {
                        int i = listId;
                        DeckDetailsActivity deckDetailsActivity = this.this$0;
                        MTDeckLists mTDeckLists = deckDetailsActivity.currentLists;
                        if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || i != main.getId()) {
                            MTDeckLists mTDeckLists2 = deckDetailsActivity.currentLists;
                            if (mTDeckLists2 == null || (sideboard = mTDeckLists2.getSideboard()) == null || i != sideboard.getId()) {
                                MTDeckLists mTDeckLists3 = deckDetailsActivity.currentLists;
                                if (mTDeckLists3 != null && (maybeboard = mTDeckLists3.getMaybeboard()) != null && i == maybeboard.getId()) {
                                    MTDeckLists mTDeckLists4 = deckDetailsActivity.currentLists;
                                    deckDetailsActivity.currentLists = mTDeckLists4 != null ? MTDeckLists.copy$default(mTDeckLists4, null, null, list, 3, null) : null;
                                }
                            } else {
                                MTDeckLists mTDeckLists5 = deckDetailsActivity.currentLists;
                                deckDetailsActivity.currentLists = mTDeckLists5 != null ? MTDeckLists.copy$default(mTDeckLists5, null, list, null, 5, null) : null;
                            }
                        } else {
                            MTDeckLists mTDeckLists6 = deckDetailsActivity.currentLists;
                            deckDetailsActivity.currentLists = mTDeckLists6 != null ? MTDeckLists.copy$default(mTDeckLists6, list, null, null, 6, null) : null;
                            List<MTCardGroup> grouped_cards = list.getGrouped_cards();
                            if (grouped_cards != null) {
                                deckDetailsActivity.currentGroupedCards = grouped_cards;
                            }
                        }
                        List list2 = deckDetailsActivity.currentGroupedCards;
                        if (list2 != null) {
                            deckDetailsActivity.setupCardsAdapter(list2);
                        }
                        deckDetailsActivity.updateBottomBar();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshDeckCards() {
        Integer listid;
        MTDeck mTDeck = this.currentDeck;
        if (mTDeck == null || (listid = mTDeck.getListid()) == null) {
            return;
        }
        final int iIntValue = listid.intValue();
        showLoadingOverlay();
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        MTApi.getUserList$default(MTApiKt.getMtApi(), currentUser != null ? currentUser.getId() : 0, iIntValue, null, null, null, null, this.currentSortBy, this.currentGroupBy, this.currentSortDirection, null, Boolean.valueOf(this.ignoreCollection), Boolean.valueOf(this.ignorePrintings), Boolean.valueOf(this.ignoreBasicLands), Videoio.CAP_PROP_XI_DEBUG_LEVEL, null).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$refreshDeckCards$1$1$1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                this.this$0.hideLoadingOverlay();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                MTCardListResponse mTCardListResponseBody;
                MTCardContainer list;
                List<MTCardGroup> grouped_cards;
                MTCardContainer maybeboard;
                MTCardContainer sideboard;
                Map<String, Boolean> mapEmptyMap;
                MTCardContainer main;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                this.this$0.hideLoadingOverlay();
                if (!response.isSuccessful() || (mTCardListResponseBody = response.body()) == null || (list = mTCardListResponseBody.getList()) == null || (grouped_cards = list.getGrouped_cards()) == null) {
                    return;
                }
                DeckDetailsActivity deckDetailsActivity = this.this$0;
                int i = iIntValue;
                deckDetailsActivity.currentGroupedCards = grouped_cards;
                MTDeckLists mTDeckLists = deckDetailsActivity.currentLists;
                MTDeckLists mTDeckListsCopy$default = null;
                MTDeckLists mTDeckListsCopy$default2 = null;
                MTDeckLists mTDeckListsCopy$default3 = null;
                if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || i != main.getId()) {
                    MTDeckLists mTDeckLists2 = deckDetailsActivity.currentLists;
                    if (mTDeckLists2 == null || (sideboard = mTDeckLists2.getSideboard()) == null || i != sideboard.getId()) {
                        MTDeckLists mTDeckLists3 = deckDetailsActivity.currentLists;
                        if (mTDeckLists3 != null && (maybeboard = mTDeckLists3.getMaybeboard()) != null && i == maybeboard.getId()) {
                            MTDeckLists mTDeckLists4 = deckDetailsActivity.currentLists;
                            if (mTDeckLists4 != null) {
                                MTCardListResponse mTCardListResponseBody2 = response.body();
                                mTDeckListsCopy$default = MTDeckLists.copy$default(mTDeckLists4, null, null, mTCardListResponseBody2 != null ? mTCardListResponseBody2.getList() : null, 3, null);
                            }
                            deckDetailsActivity.currentLists = mTDeckListsCopy$default;
                        }
                    } else {
                        MTDeckLists mTDeckLists5 = deckDetailsActivity.currentLists;
                        if (mTDeckLists5 != null) {
                            MTCardListResponse mTCardListResponseBody3 = response.body();
                            mTDeckListsCopy$default3 = MTDeckLists.copy$default(mTDeckLists5, null, mTCardListResponseBody3 != null ? mTCardListResponseBody3.getList() : null, null, 5, null);
                        }
                        deckDetailsActivity.currentLists = mTDeckListsCopy$default3;
                    }
                } else {
                    MTDeckLists mTDeckLists6 = deckDetailsActivity.currentLists;
                    if (mTDeckLists6 != null) {
                        MTCardListResponse mTCardListResponseBody4 = response.body();
                        mTDeckListsCopy$default2 = MTDeckLists.copy$default(mTDeckLists6, mTCardListResponseBody4 != null ? mTCardListResponseBody4.getList() : null, null, null, 6, null);
                    }
                    deckDetailsActivity.currentLists = mTDeckListsCopy$default2;
                }
                DeckCardsAdapter deckCardsAdapter = deckDetailsActivity.deckCardsAdapter;
                if (deckCardsAdapter == null || (mapEmptyMap = deckCardsAdapter.getExpandedCards()) == null) {
                    mapEmptyMap = MapsKt.emptyMap();
                }
                DeckCardsAdapter deckCardsAdapter2 = deckDetailsActivity.deckCardsAdapter;
                if (deckCardsAdapter2 != null) {
                    deckCardsAdapter2.setExpandedCards(mapEmptyMap);
                }
                deckDetailsActivity.setupCardsAdapter(grouped_cards);
                deckDetailsActivity.updateBottomBar();
            }
        });
    }

    static final void scanActivityLauncher$lambda$0(DeckDetailsActivity deckDetailsActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            String stringExtra = data != null ? data.getStringExtra("scannedCardsId") : null;
            if (stringExtra != null) {
                List<MTFullCard> listRetrieveAndRemoveScannedCards = ScannedCardsTempStorage.INSTANCE.retrieveAndRemoveScannedCards(stringExtra);
                if (listRetrieveAndRemoveScannedCards == null || listRetrieveAndRemoveScannedCards.isEmpty()) {
                    Toast.makeText(deckDetailsActivity, R.string.no_cards_to_add, 0).show();
                } else {
                    deckDetailsActivity.addScannedCardsToDeck(listRetrieveAndRemoveScannedCards);
                }
            }
        }
    }

    static final void searchActivityLauncher$lambda$0(DeckDetailsActivity deckDetailsActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        String stringExtra = data != null ? data.getStringExtra("cardPicked") : null;
        Intent data2 = result.getData();
        int intExtra = data2 != null ? data2.getIntExtra(OptionalModuleUtils.FACE, 0) : 0;
        if (stringExtra != null) {
            MTFullCard mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class);
            Fragment fragmentFindFragmentByTag = deckDetailsActivity.getSupportFragmentManager().findFragmentByTag(CreateDeckBottomSheetFragment.TAG);
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment = fragmentFindFragmentByTag instanceof CreateDeckBottomSheetFragment ? (CreateDeckBottomSheetFragment) fragmentFindFragmentByTag : null;
            if (createDeckBottomSheetFragment != null) {
                Intrinsics.checkNotNull(mTFullCard);
                createDeckBottomSheetFragment.updateCardId(mTFullCard, intExtra);
            }
        }
    }

    private final void selectAllCardsFromLockedList() {
        MTCardContainer maybeboard;
        MTCardContainer maybeboard2;
        MTCardContainer sideboard;
        MTCardContainer sideboard2;
        MTCardContainer main;
        MTCardContainer main2;
        MTCardContainer main3;
        Integer num = this.selectionLockedListId;
        List<MTCardGroup> grouped_cards = null;
        numValueOf = null;
        Integer numValueOf = null;
        grouped_cards = null;
        List<MTCardGroup> grouped_cards2 = null;
        grouped_cards = null;
        if (num == null) {
            MTDeckLists mTDeckLists = this.currentLists;
            if (mTDeckLists != null && (main3 = mTDeckLists.getMain()) != null) {
                numValueOf = Integer.valueOf(main3.getId());
            }
            this.selectionLockedListId = numValueOf;
            List<MTCardGroup> list = this.currentGroupedCards;
            MTDeckLists mTDeckLists2 = this.currentLists;
            selectAllCardsFromLockedList$selectFromGroupedCards(this, list, (mTDeckLists2 == null || (main2 = mTDeckLists2.getMain()) == null) ? -1 : main2.getId());
        } else {
            int iIntValue = num.intValue();
            MTDeckLists mTDeckLists3 = this.currentLists;
            if (mTDeckLists3 == null || (main = mTDeckLists3.getMain()) == null || iIntValue != main.getId()) {
                MTDeckLists mTDeckLists4 = this.currentLists;
                if (mTDeckLists4 == null || (sideboard = mTDeckLists4.getSideboard()) == null || iIntValue != sideboard.getId()) {
                    MTDeckLists mTDeckLists5 = this.currentLists;
                    if (mTDeckLists5 != null && (maybeboard = mTDeckLists5.getMaybeboard()) != null && iIntValue == maybeboard.getId()) {
                        MTDeckLists mTDeckLists6 = this.currentLists;
                        if (mTDeckLists6 != null && (maybeboard2 = mTDeckLists6.getMaybeboard()) != null) {
                            grouped_cards = maybeboard2.getGrouped_cards();
                        }
                        selectAllCardsFromLockedList$selectFromGroupedCards(this, grouped_cards, num.intValue());
                    }
                } else {
                    MTDeckLists mTDeckLists7 = this.currentLists;
                    if (mTDeckLists7 != null && (sideboard2 = mTDeckLists7.getSideboard()) != null) {
                        grouped_cards2 = sideboard2.getGrouped_cards();
                    }
                    selectAllCardsFromLockedList$selectFromGroupedCards(this, grouped_cards2, num.intValue());
                }
            } else {
                selectAllCardsFromLockedList$selectFromGroupedCards(this, this.currentGroupedCards, num.intValue());
            }
        }
        updateSelectionCountText();
        propagateSelectionMode(true);
    }

    private static final void selectAllCardsFromLockedList$selectFromGroupedCards(DeckDetailsActivity deckDetailsActivity, List<MTCardGroup> list, int i) {
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                List<MTFullCard> cards = ((MTCardGroup) it.next()).getCards();
                if (cards != null) {
                    for (MTFullCard mTFullCard : cards) {
                        List<Integer> variant_list_card_ids = mTFullCard.getVariant_list_card_ids();
                        if (variant_list_card_ids == null && (variant_list_card_ids = mTFullCard.getList_card_ids()) == null) {
                            variant_list_card_ids = CollectionsKt.listOfNotNull(mTFullCard.getList_card_id());
                        }
                        Iterator<T> it2 = variant_list_card_ids.iterator();
                        while (it2.hasNext()) {
                            deckDetailsActivity.selectedCards.put(Integer.valueOf(((Number) it2.next()).intValue()), mTFullCard);
                        }
                        List<MTFullCard> variants = mTFullCard.getVariants();
                        if (variants != null) {
                            for (MTFullCard mTFullCard2 : variants) {
                                List<Integer> variant_list_card_ids2 = mTFullCard2.getVariant_list_card_ids();
                                if (variant_list_card_ids2 == null && (variant_list_card_ids2 = mTFullCard2.getList_card_ids()) == null) {
                                    variant_list_card_ids2 = CollectionsKt.listOfNotNull(mTFullCard2.getList_card_id());
                                }
                                Iterator<T> it3 = variant_list_card_ids2.iterator();
                                while (it3.hasNext()) {
                                    deckDetailsActivity.selectedCards.put(Integer.valueOf(((Number) it3.next()).intValue()), mTFullCard2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static final void setDetailsLauncher$lambda$0(DeckDetailsActivity deckDetailsActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            String stringExtra = data != null ? data.getStringExtra("updatedSet") : null;
            if (stringExtra != null) {
                MTSet mTSet = (MTSet) new Gson().fromJson(stringExtra, MTSet.class);
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = deckDetailsActivity.games.iterator();
                int i = 0;
                while (it.hasNext()) {
                    int i2 = i + 1;
                    MTSet set = ((MTGame) it.next()).getSet();
                    if (set != null && set.getId() == mTSet.getId()) {
                        arrayList.add(Integer.valueOf(i));
                    }
                    i = i2;
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    int iIntValue = ((Number) it2.next()).intValue();
                    MTSet set2 = deckDetailsActivity.games.get(iIntValue).getSet();
                    if (set2 != null) {
                        set2.setNote(mTSet.getNote());
                    }
                    MTSet set3 = deckDetailsActivity.games.get(iIntValue).getSet();
                    if (set3 != null) {
                        set3.setTags(mTSet.getTags());
                    }
                }
                List<GameItemHolder> listGroupGamesWithSeparators = deckDetailsActivity.groupGamesWithSeparators(deckDetailsActivity.games);
                View viewFindViewById = deckDetailsActivity.findViewById(R.id.gamesRecyclerView);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                RecyclerView.Adapter adapter = ((RecyclerView) viewFindViewById).getAdapter();
                GamesAdapter gamesAdapter = adapter instanceof GamesAdapter ? (GamesAdapter) adapter : null;
                if (gamesAdapter != null) {
                    gamesAdapter.updateGames(listGroupGamesWithSeparators);
                }
                deckDetailsActivity.adjustRecyclerViewHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupCardsAdapter(List<MTCardGroup> groupedCards) {
        Map<String, Boolean> mapEmptyMap;
        Map<String, Boolean> mapEmptyMap2;
        DeckCardsAdapter deckCardsAdapter;
        MTCardContainer main;
        Editable text;
        String string;
        List<MTListError> listEmptyList;
        MTCardContainer main2;
        MTCardContainer main3;
        View viewFindViewById = findViewById(R.id.cardsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.twoColumnStackedCardsView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TwoColumnStackedCardsView twoColumnStackedCardsView = (TwoColumnStackedCardsView) viewFindViewById2;
        int id = -1;
        if (WhenMappings.$EnumSwitchMapping$0[this.currentDisplayMode.ordinal()] == 1) {
            recyclerView.setVisibility(8);
            twoColumnStackedCardsView.setVisibility(0);
            MTDeckLists mTDeckLists = this.currentLists;
            if (mTDeckLists == null || (main3 = mTDeckLists.getMain()) == null || (listEmptyList = main3.getErrors()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            twoColumnStackedCardsView.setSelectionChecker(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda82
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(DeckDetailsActivity.setupCardsAdapter$lambda$0(this.f$0, (MTFullCard) obj));
                }
            });
            twoColumnStackedCardsView.setThemeMode(Intrinsics.areEqual(this.currentGroupBy, "theme"));
            Function1<? super MTFullCard, Unit> function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda83
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeckDetailsActivity.setupCardsAdapter$lambda$1((MTFullCard) obj);
                }
            };
            DeckDetailsActivity deckDetailsActivity = this;
            MTDeckLists mTDeckLists2 = this.currentLists;
            if (mTDeckLists2 != null && (main2 = mTDeckLists2.getMain()) != null) {
                id = main2.getId();
            }
            twoColumnStackedCardsView.setCardGroups(groupedCards, listEmptyList, function1, deckDetailsActivity, id, this.ignoreCollection, this.currentDeck);
            if (this.selectionMode) {
                twoColumnStackedCardsView.setSelectionMode(true, new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda84
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DeckDetailsActivity.setupCardsAdapter$lambda$2(this.f$0, (MTFullCard) obj));
                    }
                });
            }
        } else {
            recyclerView.setVisibility(0);
            twoColumnStackedCardsView.setVisibility(8);
            ArrayList arrayList = new ArrayList();
            DeckCardsAdapter deckCardsAdapter2 = this.deckCardsAdapter;
            if (deckCardsAdapter2 == null || (mapEmptyMap = deckCardsAdapter2.getExpandedCards()) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            Map<String, Boolean> map = mapEmptyMap;
            for (MTCardGroup mTCardGroup : groupedCards) {
                DeckDisplayMode deckDisplayMode = this.currentDisplayMode;
                MTDeckLists mTDeckLists3 = this.currentLists;
                arrayList.addAll(DeckCardItemKt.toDeckCardItems(mTCardGroup, deckDisplayMode, mTDeckLists3 != null ? mTDeckLists3.getMain() : null, map, this.currentDeck, Intrinsics.areEqual(this.currentGroupBy, "theme")));
            }
            DeckCardsAdapter deckCardsAdapter3 = this.deckCardsAdapter;
            if (deckCardsAdapter3 == null) {
                DeckDisplayMode deckDisplayMode2 = this.currentDisplayMode;
                Function1 function12 = new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda85
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeckDetailsActivity.setupCardsAdapter$lambda$4((MTFullCard) obj);
                    }
                };
                DeckDetailsActivity deckDetailsActivity2 = this;
                MTDeckLists mTDeckLists4 = this.currentLists;
                if (mTDeckLists4 != null && (main = mTDeckLists4.getMain()) != null) {
                    id = main.getId();
                }
                DeckCardsAdapter deckCardsAdapter4 = new DeckCardsAdapter(arrayList, deckDisplayMode2, function12, deckDetailsActivity2, id, null, this.ignoreCollection, isOtherUserDeck() || this.isDuplicatedDeck);
                this.deckCardsAdapter = deckCardsAdapter4;
                deckCardsAdapter4.setOnExpansionChanged(new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda86
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckDetailsActivity.setupCardsAdapter$lambda$5(this.f$0, recyclerView);
                    }
                });
                recyclerView.setLayoutManager(DeckCardsAdapterKt.createDeckCardsLayoutManager(this, this.currentDisplayMode));
                recyclerView.setAdapter(this.deckCardsAdapter);
            } else {
                if (deckCardsAdapter3 == null || (mapEmptyMap2 = deckCardsAdapter3.getExpandedCards()) == null) {
                    mapEmptyMap2 = MapsKt.emptyMap();
                }
                DeckCardsAdapter deckCardsAdapter5 = this.deckCardsAdapter;
                if (deckCardsAdapter5 != null) {
                    deckCardsAdapter5.setExpandedCards(mapEmptyMap2);
                }
                DeckCardsAdapter deckCardsAdapter6 = this.deckCardsAdapter;
                if (deckCardsAdapter6 != null) {
                    deckCardsAdapter6.updateItems(arrayList);
                }
            }
            DeckCardsAdapter deckCardsAdapter7 = this.deckCardsAdapter;
            if (deckCardsAdapter7 != null) {
                deckCardsAdapter7.setSelectionChecker(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda87
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DeckDetailsActivity.setupCardsAdapter$lambda$6(this.f$0, (MTFullCard) obj));
                    }
                });
            }
            if (this.selectionMode && (deckCardsAdapter = this.deckCardsAdapter) != null) {
                deckCardsAdapter.setSelectionMode(true);
            }
            recyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda89
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.adjustCardsRecyclerViewHeight();
                }
            });
        }
        setupSideboardCards();
        setupMaybeboardCards();
        EditText editText = (EditText) findViewById(R.id.deckCardsFilterEditText);
        if (editText == null || (text = editText.getText()) == null || (string = text.toString()) == null) {
            return;
        }
        String str = string.length() > 0 ? string : null;
        if (str != null) {
            applyDeckCardsNameFilter(str);
        }
    }

    static final boolean setupCardsAdapter$lambda$0(DeckDetailsActivity deckDetailsActivity, MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return deckDetailsActivity.isCardSelected(card);
    }

    static final Unit setupCardsAdapter$lambda$1(MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return Unit.INSTANCE;
    }

    static final boolean setupCardsAdapter$lambda$2(DeckDetailsActivity deckDetailsActivity, MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return deckDetailsActivity.isCardSelected(card);
    }

    static final Unit setupCardsAdapter$lambda$4(MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return Unit.INSTANCE;
    }

    static final Unit setupCardsAdapter$lambda$5(final DeckDetailsActivity deckDetailsActivity, RecyclerView recyclerView) {
        Map<String, Boolean> mapEmptyMap;
        List<MTCardGroup> list = deckDetailsActivity.currentGroupedCards;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            DeckCardsAdapter deckCardsAdapter = deckDetailsActivity.deckCardsAdapter;
            if (deckCardsAdapter == null || (mapEmptyMap = deckCardsAdapter.getExpandedCards()) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            Map<String, Boolean> map = mapEmptyMap;
            for (MTCardGroup mTCardGroup : list) {
                DeckDisplayMode deckDisplayMode = deckDetailsActivity.currentDisplayMode;
                MTDeckLists mTDeckLists = deckDetailsActivity.currentLists;
                arrayList.addAll(DeckCardItemKt.toDeckCardItems(mTCardGroup, deckDisplayMode, mTDeckLists != null ? mTDeckLists.getMain() : null, map, deckDetailsActivity.currentDeck, Intrinsics.areEqual(deckDetailsActivity.currentGroupBy, "theme")));
            }
            DeckCardsAdapter deckCardsAdapter2 = deckDetailsActivity.deckCardsAdapter;
            if (deckCardsAdapter2 != null) {
                deckCardsAdapter2.updateItems(arrayList);
            }
            recyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda165
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.adjustCardsRecyclerViewHeight();
                }
            });
        }
        return Unit.INSTANCE;
    }

    static final boolean setupCardsAdapter$lambda$6(DeckDetailsActivity deckDetailsActivity, MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return deckDetailsActivity.isCardSelected(card);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupDeckOwnerLayout() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.deckOwnerLayout);
        if (linearLayout == null) {
            return;
        }
        final MTPrivacyUser mTPrivacyUser = this.deckOwnerUser;
        if (mTPrivacyUser == null) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        CachedImageView cachedImageView = (CachedImageView) linearLayout.findViewById(R.id.profile_icon);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.no_photo_icon);
        TextView textView = (TextView) linearLayout.findViewById(R.id.userFirstName);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.userName);
        View viewFindViewById = linearLayout.findViewById(R.id.duplicateLayout);
        String firstname = mTPrivacyUser.getFirstname();
        textView.setText(firstname != null ? firstname : "");
        textView2.setText(mTPrivacyUser.getUsername() != null ? "@" + mTPrivacyUser.getUsername() : "");
        cachedImageView.setOutlineProvider(new CircularOutlineProvider());
        cachedImageView.setClipToOutline(true);
        String picture = mTPrivacyUser.getPicture();
        String str = picture;
        if (str == null || str.length() == 0) {
            cachedImageView.setVisibility(4);
            imageView.setVisibility(0);
        } else {
            cachedImageView.setAutoLoad(false);
            cachedImageView.loadImage(picture);
            cachedImageView.setVisibility(0);
            imageView.setVisibility(4);
        }
        viewFindViewById.setVisibility(0);
        View viewFindViewById2 = viewFindViewById.findViewById(R.id.duplicateIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView3 = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewFindViewById.findViewById(R.id.duplicateLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        TextView textView4 = (TextView) viewFindViewById3;
        if (this.isDuplicatedDeck) {
            textView3.setText("\uf044");
            textView4.setText(getString(R.string.activate_changes));
        } else {
            textView3.setText("\uf0c5");
            textView4.setText(getString(R.string.duplicate_deck));
        }
        Intrinsics.checkNotNull(viewFindViewById);
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.setupDeckOwnerLayout$lambda$0(this.f$0, mTPrivacyUser);
            }
        });
        View viewFindViewById4 = findViewById(R.id.duplicateInfoIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((TextView) viewFindViewById4, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.setupDeckOwnerLayout$lambda$1(this.f$0, mTPrivacyUser);
            }
        });
    }

    static final Unit setupDeckOwnerLayout$lambda$0(final DeckDetailsActivity deckDetailsActivity, MTPrivacyUser mTPrivacyUser) {
        if (deckDetailsActivity.isDuplicatedDeck) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = deckDetailsActivity.getString(R.string.activate_changes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = deckDetailsActivity.getString(R.string.activate_changes_help_text);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String username = mTPrivacyUser.getUsername();
            CustomDialogFragment.Builder positiveButtonRed = title.setBody(StringsKt.replace$default(string2, "{1}", username == null ? "user" : username, false, 4, (Object) null)).setPositiveButtonRed();
            String string3 = deckDetailsActivity.getString(R.string.activate_button);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeckDetailsActivity.setupDeckOwnerLayout$lambda$0$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string4 = deckDetailsActivity.getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeckDetailsActivity.setupDeckOwnerLayout$lambda$0$1((CustomDialogFragment) obj);
                }
            });
            FragmentManager supportFragmentManager = deckDetailsActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            negativeButton.show(supportFragmentManager, "DuplicateDeckHelpDialog");
        } else {
            CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
            String string5 = deckDetailsActivity.getString(R.string.duplicate_deck);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            CustomDialogFragment.Builder title2 = builder2.setTitle(string5);
            String string6 = deckDetailsActivity.getString(R.string.duplicate_deck_help_text);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            String username2 = mTPrivacyUser.getUsername();
            CustomDialogFragment.Builder positiveButtonRed2 = title2.setBody(StringsKt.replace$default(string6, "{1}", username2 == null ? "user" : username2, false, 4, (Object) null)).setPositiveButtonRed();
            String string7 = deckDetailsActivity.getString(R.string.duplicate_deck);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            CustomDialogFragment.Builder positiveButton2 = positiveButtonRed2.setPositiveButton(string7, new Function2() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeckDetailsActivity.setupDeckOwnerLayout$lambda$0$2(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string8 = deckDetailsActivity.getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            CustomDialogFragment.Builder negativeButton2 = positiveButton2.setNegativeButton(string8, new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeckDetailsActivity.setupDeckOwnerLayout$lambda$0$3((CustomDialogFragment) obj);
                }
            });
            FragmentManager supportFragmentManager2 = deckDetailsActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
            negativeButton2.show(supportFragmentManager2, "DuplicateDeckHelpDialog");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupDeckOwnerLayout$lambda$0$0(DeckDetailsActivity deckDetailsActivity, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        deckDetailsActivity.activateDeckChanges();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupDeckOwnerLayout$lambda$0$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupDeckOwnerLayout$lambda$0$2(DeckDetailsActivity deckDetailsActivity, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        deckDetailsActivity.duplicateDeck();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupDeckOwnerLayout$lambda$0$3(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit setupDeckOwnerLayout$lambda$1(DeckDetailsActivity deckDetailsActivity, MTPrivacyUser mTPrivacyUser) {
        if (deckDetailsActivity.isDuplicatedDeck) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = deckDetailsActivity.getString(R.string.activate_changes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = deckDetailsActivity.getString(R.string.activate_changes_help_text);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String username = mTPrivacyUser.getUsername();
            CustomDialogFragment.Builder body = title.setBody(StringsKt.replace$default(string2, "{1}", username == null ? "user" : username, false, 4, (Object) null));
            String string3 = deckDetailsActivity.getString(R.string.close);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda106
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeckDetailsActivity.setupDeckOwnerLayout$lambda$1$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager supportFragmentManager = deckDetailsActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            positiveButton.show(supportFragmentManager, "DuplicateDeckHelpDialog");
        } else {
            CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
            String string4 = deckDetailsActivity.getString(R.string.duplicate_deck);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder title2 = builder2.setTitle(string4);
            String string5 = deckDetailsActivity.getString(R.string.duplicate_deck_help_text);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            String username2 = mTPrivacyUser.getUsername();
            CustomDialogFragment.Builder body2 = title2.setBody(StringsKt.replace$default(string5, "{1}", username2 == null ? "user" : username2, false, 4, (Object) null));
            String string6 = deckDetailsActivity.getString(R.string.close);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            CustomDialogFragment.Builder positiveButton2 = body2.setPositiveButton(string6, new Function2() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda107
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeckDetailsActivity.setupDeckOwnerLayout$lambda$1$1(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager supportFragmentManager2 = deckDetailsActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
            positiveButton2.show(supportFragmentManager2, "DuplicateDeckHelpDialog");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupDeckOwnerLayout$lambda$1$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupDeckOwnerLayout$lambda$1$1(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void setupDisplayModeToggle() {
        View viewFindViewById = findViewById(R.id.displayModeToggle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        updateDisplayModeIcon();
        ((TextView) viewFindViewById).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.cycleDisplayMode();
            }
        });
    }

    private final void setupErrorPopupManager() {
        View viewFindViewById = findViewById(R.id.legalityLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        this.errorPopupManager = new DeckErrorPopupManager(this, constraintLayout);
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda92
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeckDetailsActivity.setupErrorPopupManager$lambda$0(this.f$0, view);
            }
        });
        View viewFindViewById2 = findViewById(R.id.bottomRightLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById2;
        if (isOtherUserDeck() || this.isDuplicatedDeck) {
            return;
        }
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda94
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.setupErrorPopupManager$lambda$1(this.f$0);
            }
        });
    }

    static final void setupErrorPopupManager$lambda$0(DeckDetailsActivity deckDetailsActivity, View view) {
        MTCardContainer main;
        List<MTListError> errors;
        DeckErrorPopupManager deckErrorPopupManager;
        MTDeckLists mTDeckLists = deckDetailsActivity.currentLists;
        if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || (errors = main.getErrors()) == null || errors.isEmpty() || (deckErrorPopupManager = deckDetailsActivity.errorPopupManager) == null) {
            return;
        }
        deckErrorPopupManager.toggleErrorPopup(errors);
    }

    static final Unit setupErrorPopupManager$lambda$1(DeckDetailsActivity deckDetailsActivity) {
        MTDeck mTDeck = deckDetailsActivity.currentDeck;
        if ((mTDeck != null ? mTDeck.getValues() : null) != null) {
            deckDetailsActivity.showDeckValuesPopup();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupManaCurveChart() {
        MTCardContainer main;
        MTCardContainerStats stats;
        View viewFindViewById = findViewById(R.id.manaCurveSection);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.manaCurveChart);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        CombinedChart combinedChart = (CombinedChart) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.manaCurveSeparator);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        linearLayout.setVisibility(8);
        viewFindViewById3.setVisibility(8);
        MTDeckLists mTDeckLists = this.currentLists;
        List<MTManaCurveEntry> mana_curve = (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || (stats = main.getStats()) == null) ? null : stats.getMana_curve();
        if (mana_curve != null && !mana_curve.isEmpty()) {
            linearLayout.setVisibility(0);
            viewFindViewById3.setVisibility(0);
            configureManaCurveChart(combinedChart, mana_curve);
        }
        setupManaValueStats();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupManaProduction() {
        MTCardContainer main;
        MTCardContainerStats stats;
        View viewFindViewById = findViewById(R.id.manaProductionSection);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.manaProductionSeparator);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        View viewFindViewById3 = findViewById(R.id.manaProductionRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById3;
        linearLayout.setVisibility(8);
        viewFindViewById2.setVisibility(8);
        MTDeckLists mTDeckLists = this.currentLists;
        List<MTManaCostProductionEntry> mana_cost_production = (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || (stats = main.getStats()) == null) ? null : stats.getMana_cost_production();
        if (mana_cost_production == null || mana_cost_production.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = mana_cost_production.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MTProductionEntry costs = ((MTManaCostProductionEntry) next).getCosts();
            if ((costs != null ? costs.getSymbols() : 0) > 0) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return;
        }
        linearLayout.setVisibility(0);
        viewFindViewById2.setVisibility(0);
        DeckDetailsActivity deckDetailsActivity = this;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(deckDetailsActivity, 3);
        gridLayoutManager.setSmoothScrollbarEnabled(true);
        gridLayoutManager.setItemPrefetchEnabled(false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, GameUtils.INSTANCE.getInstance().dpToPx(4, deckDetailsActivity), true));
        recyclerView.setAdapter(new ManaProductionAdapter(arrayList2));
        recyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda95
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.adjustManaProductionRecyclerViewHeight();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setupManaValueStats() {
        Double average_mana_value_without_lands;
        String str;
        String str2;
        String str3;
        String strValueOf;
        MTCardContainer main;
        MTCardContainerStats stats;
        View viewFindViewById = findViewById(R.id.avgManaValueLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.avgManaValueNumber);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.avgManaValueDetails);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        final TextView textView2 = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.avgManaValueInfoIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        TextView textView3 = (TextView) viewFindViewById4;
        linearLayout.setVisibility(8);
        MTDeckLists mTDeckLists = this.currentLists;
        MTManaValueStats mana_value_stats = (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || (stats = main.getStats()) == null) ? null : stats.getMana_value_stats();
        if (mana_value_stats == null || (average_mana_value_without_lands = mana_value_stats.getAverage_mana_value_without_lands()) == null) {
            return;
        }
        double dDoubleValue = average_mana_value_without_lands.doubleValue();
        linearLayout.setVisibility(0);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str4 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dDoubleValue)}, 1));
        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
        textView.setText(str4);
        Double average_mana_value = mana_value_stats.getAverage_mana_value();
        String str5 = "–";
        if (average_mana_value != null) {
            double dDoubleValue2 = average_mana_value.doubleValue();
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            str = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dDoubleValue2)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            if (str == null) {
                str = "–";
            }
        }
        Double median_mana_value = mana_value_stats.getMedian_mana_value();
        if (median_mana_value != null) {
            double dDoubleValue3 = median_mana_value.doubleValue();
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            str2 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dDoubleValue3)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            if (str2 == null) {
                str2 = "–";
            }
        }
        Double median_mana_value_without_lands = mana_value_stats.getMedian_mana_value_without_lands();
        if (median_mana_value_without_lands != null) {
            double dDoubleValue4 = median_mana_value_without_lands.doubleValue();
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            str3 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dDoubleValue4)}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            if (str3 == null) {
                str3 = "–";
            }
        }
        Double total_mana_value = mana_value_stats.getTotal_mana_value();
        if (total_mana_value != null && (strValueOf = String.valueOf(total_mana_value.doubleValue())) != null) {
            str5 = strValueOf;
        }
        int i = R.string.avg_mana_value_details;
        StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
        String str6 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dDoubleValue)}, 1));
        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
        textView2.setText(getString(i, new Object[]{str, str6, str2, str3, str5}));
        ViewExtensionsKt.setOnClickWithBounce(textView3, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda175
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.setupManaValueStats$lambda$3(textView2);
            }
        });
    }

    static final Unit setupManaValueStats$lambda$3(final TextView textView) {
        if (textView.getVisibility() == 0) {
            textView.animate().alpha(0.0f).setDuration(150L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda90
                @Override // java.lang.Runnable
                public final void run() {
                    textView.setVisibility(8);
                }
            }).start();
        } else {
            textView.setAlpha(0.0f);
            textView.setVisibility(0);
            textView.animate().alpha(1.0f).setDuration(150L).start();
        }
        return Unit.INSTANCE;
    }

    private final void setupMaybeboardCards() {
        Map<String, Boolean> mapEmptyMap;
        Map<String, Boolean> mapEmptyMap2;
        DeckCardsAdapter deckCardsAdapter;
        MTDeckLists mTDeckLists = this.currentLists;
        final MTCardContainer maybeboard = mTDeckLists != null ? mTDeckLists.getMaybeboard() : null;
        List<MTCardGroup> grouped_cards = maybeboard != null ? maybeboard.getGrouped_cards() : null;
        if (maybeboard != null) {
            View viewFindViewById = findViewById(R.id.maybeboardSection);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ((LinearLayout) viewFindViewById).setVisibility(0);
            View viewFindViewById2 = findViewById(R.id.maybeboardTitle);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            TextView textView = (TextView) viewFindViewById2;
            int iCalculateCardCount = calculateCardCount(grouped_cards);
            textView.setText(getString(R.string.maybeboard) + (iCalculateCardCount > 0 ? " (" + iCalculateCardCount + ")" : ""));
            View viewFindViewById3 = findViewById(R.id.maybeboardRecyclerView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            final RecyclerView recyclerView = (RecyclerView) viewFindViewById3;
            View viewFindViewById4 = findViewById(R.id.maybeboardTwoColumnStackedCardsView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            TwoColumnStackedCardsView twoColumnStackedCardsView = (TwoColumnStackedCardsView) viewFindViewById4;
            View viewFindViewById5 = findViewById(R.id.maybeboardNoCardsTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            TextView textView2 = (TextView) viewFindViewById5;
            if (grouped_cards == null || grouped_cards.isEmpty()) {
                recyclerView.setVisibility(8);
                twoColumnStackedCardsView.setVisibility(8);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
                if (WhenMappings.$EnumSwitchMapping$0[this.currentDisplayMode.ordinal()] == 1) {
                    recyclerView.setVisibility(8);
                    twoColumnStackedCardsView.setVisibility(0);
                    List<MTListError> errors = maybeboard.getErrors();
                    if (errors == null) {
                        errors = CollectionsKt.emptyList();
                    }
                    twoColumnStackedCardsView.setSelectionChecker(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(DeckDetailsActivity.setupMaybeboardCards$lambda$0(this.f$0, (MTFullCard) obj));
                        }
                    });
                    twoColumnStackedCardsView.setThemeMode(Intrinsics.areEqual(this.currentGroupBy, "theme"));
                    twoColumnStackedCardsView.setCardGroups(grouped_cards, errors, new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DeckDetailsActivity.setupMaybeboardCards$lambda$1((MTFullCard) obj);
                        }
                    }, this, maybeboard.getId(), this.ignoreCollection, this.currentDeck);
                    if (this.selectionMode) {
                        twoColumnStackedCardsView.setSelectionMode(true, new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Boolean.valueOf(DeckDetailsActivity.setupMaybeboardCards$lambda$2(this.f$0, (MTFullCard) obj));
                            }
                        });
                    }
                } else {
                    recyclerView.setVisibility(0);
                    twoColumnStackedCardsView.setVisibility(8);
                    ArrayList arrayList = new ArrayList();
                    DeckCardsAdapter deckCardsAdapter2 = this.maybeboardCardsAdapter;
                    if (deckCardsAdapter2 == null || (mapEmptyMap = deckCardsAdapter2.getExpandedCards()) == null) {
                        mapEmptyMap = MapsKt.emptyMap();
                    }
                    Map<String, Boolean> map = mapEmptyMap;
                    Iterator<T> it = grouped_cards.iterator();
                    while (it.hasNext()) {
                        arrayList.addAll(DeckCardItemKt.toDeckCardItems((MTCardGroup) it.next(), this.currentDisplayMode, maybeboard, map, this.currentDeck, Intrinsics.areEqual(this.currentGroupBy, "theme")));
                    }
                    DeckCardsAdapter deckCardsAdapter3 = this.maybeboardCardsAdapter;
                    if (deckCardsAdapter3 == null) {
                        DeckCardsAdapter deckCardsAdapter4 = new DeckCardsAdapter(arrayList, this.currentDisplayMode, new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeckDetailsActivity.setupMaybeboardCards$lambda$4((MTFullCard) obj);
                            }
                        }, this, maybeboard.getId(), null, this.ignoreCollection, isOtherUserDeck() || this.isDuplicatedDeck);
                        this.maybeboardCardsAdapter = deckCardsAdapter4;
                        deckCardsAdapter4.setOnExpansionChanged(new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeckDetailsActivity.setupMaybeboardCards$lambda$5(maybeboard, this, recyclerView);
                            }
                        });
                        recyclerView.setLayoutManager(DeckCardsAdapterKt.createDeckCardsLayoutManager(this, this.currentDisplayMode));
                        recyclerView.setAdapter(this.maybeboardCardsAdapter);
                    } else {
                        if (deckCardsAdapter3 == null || (mapEmptyMap2 = deckCardsAdapter3.getExpandedCards()) == null) {
                            mapEmptyMap2 = MapsKt.emptyMap();
                        }
                        DeckCardsAdapter deckCardsAdapter5 = this.maybeboardCardsAdapter;
                        if (deckCardsAdapter5 != null) {
                            deckCardsAdapter5.setExpandedCards(mapEmptyMap2);
                        }
                        DeckCardsAdapter deckCardsAdapter6 = this.maybeboardCardsAdapter;
                        if (deckCardsAdapter6 != null) {
                            deckCardsAdapter6.updateItems(arrayList);
                        }
                    }
                    DeckCardsAdapter deckCardsAdapter7 = this.maybeboardCardsAdapter;
                    if (deckCardsAdapter7 != null) {
                        deckCardsAdapter7.setSelectionChecker(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Boolean.valueOf(DeckDetailsActivity.setupMaybeboardCards$lambda$6(this.f$0, (MTFullCard) obj));
                            }
                        });
                    }
                    if (this.selectionMode && (deckCardsAdapter = this.maybeboardCardsAdapter) != null) {
                        deckCardsAdapter.setSelectionMode(true);
                    }
                    recyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda13
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.adjustMaybeboardRecyclerViewHeight();
                        }
                    });
                }
            }
        } else {
            View viewFindViewById6 = findViewById(R.id.maybeboardSection);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            ((LinearLayout) viewFindViewById6).setVisibility(8);
        }
        updateMaybeboardVisibility();
    }

    static final boolean setupMaybeboardCards$lambda$0(DeckDetailsActivity deckDetailsActivity, MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return deckDetailsActivity.isCardSelected(card);
    }

    static final Unit setupMaybeboardCards$lambda$1(MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return Unit.INSTANCE;
    }

    static final boolean setupMaybeboardCards$lambda$2(DeckDetailsActivity deckDetailsActivity, MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return deckDetailsActivity.isCardSelected(card);
    }

    static final Unit setupMaybeboardCards$lambda$4(MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return Unit.INSTANCE;
    }

    static final Unit setupMaybeboardCards$lambda$5(MTCardContainer mTCardContainer, final DeckDetailsActivity deckDetailsActivity, RecyclerView recyclerView) {
        Map<String, Boolean> mapEmptyMap;
        List<MTCardGroup> grouped_cards = mTCardContainer.getGrouped_cards();
        if (grouped_cards != null) {
            ArrayList arrayList = new ArrayList();
            DeckCardsAdapter deckCardsAdapter = deckDetailsActivity.maybeboardCardsAdapter;
            if (deckCardsAdapter == null || (mapEmptyMap = deckCardsAdapter.getExpandedCards()) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            Map<String, Boolean> map = mapEmptyMap;
            Iterator<T> it = grouped_cards.iterator();
            while (it.hasNext()) {
                MTCardContainer mTCardContainer2 = mTCardContainer;
                arrayList.addAll(DeckCardItemKt.toDeckCardItems((MTCardGroup) it.next(), deckDetailsActivity.currentDisplayMode, mTCardContainer2, map, deckDetailsActivity.currentDeck, Intrinsics.areEqual(deckDetailsActivity.currentGroupBy, "theme")));
                mTCardContainer = mTCardContainer2;
            }
            DeckCardsAdapter deckCardsAdapter2 = deckDetailsActivity.maybeboardCardsAdapter;
            if (deckCardsAdapter2 != null) {
                deckCardsAdapter2.updateItems(arrayList);
            }
            recyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda35
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.adjustMaybeboardRecyclerViewHeight();
                }
            });
        }
        return Unit.INSTANCE;
    }

    static final boolean setupMaybeboardCards$lambda$6(DeckDetailsActivity deckDetailsActivity, MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return deckDetailsActivity.isCardSelected(card);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupPrivacyToolbar() {
        View viewFindViewById;
        if (isOtherUserDeck() || this.isDuplicatedDeck || (viewFindViewById = findViewById(R.id.privacyToolbarLayout)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
        final View viewFindViewById2 = viewFindViewById.findViewById(R.id.privacySelectorContainer);
        if (viewFindViewById2 != null) {
            ViewExtensionsKt.setOnClickWithFade(viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda68
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckDetailsActivity.setupPrivacyToolbar$lambda$0(this.f$0, viewFindViewById2);
                }
            });
        }
        View viewFindViewById3 = viewFindViewById.findViewById(R.id.sharingIcon);
        if (viewFindViewById3 != null) {
            ViewExtensionsKt.setOnClickWithFade(viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda69
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckDetailsActivity.setupPrivacyToolbar$lambda$1(this.f$0);
                }
            });
        }
        View viewFindViewById4 = viewFindViewById.findViewById(R.id.privacySettingsIcon);
        if (viewFindViewById4 != null) {
            ViewExtensionsKt.setOnClickWithFade(viewFindViewById4, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda70
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckDetailsActivity.setupPrivacyToolbar$lambda$2(this.f$0);
                }
            });
        }
    }

    static final Unit setupPrivacyToolbar$lambda$0(final DeckDetailsActivity deckDetailsActivity, View view) {
        final String type;
        MTDeckPrivacy mTDeckPrivacy = deckDetailsActivity.currentDeckPrivacy;
        if (mTDeckPrivacy == null || (type = mTDeckPrivacy.getType()) == null) {
            return Unit.INSTANCE;
        }
        PrivacyPopupMenu.show$default(new PrivacyPopupMenu(deckDetailsActivity, type, PrivacyContext.DECK, new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda75
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeckDetailsActivity.setupPrivacyToolbar$lambda$0$0(type, deckDetailsActivity, (String) obj);
            }
        }), view, false, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupPrivacyToolbar$lambda$0$0(String str, DeckDetailsActivity deckDetailsActivity, String selectedType) {
        Intrinsics.checkNotNullParameter(selectedType, "selectedType");
        if (!Intrinsics.areEqual(selectedType, str)) {
            deckDetailsActivity.updateDeckPrivacy(selectedType);
        }
        return Unit.INSTANCE;
    }

    static final Unit setupPrivacyToolbar$lambda$1(DeckDetailsActivity deckDetailsActivity) {
        MTDeck mTDeck = deckDetailsActivity.currentDeck;
        if (mTDeck == null) {
            return Unit.INSTANCE;
        }
        DeckDetailsActivity deckDetailsActivity2 = deckDetailsActivity;
        MTUser currentUser = new PreferencesManager(deckDetailsActivity2).getCurrentUser();
        if (currentUser == null) {
            return Unit.INSTANCE;
        }
        String userDeckUrl = MythicLinkGenerator.INSTANCE.getUserDeckUrl(currentUser.getId(), mTDeck.getId());
        Object systemService = deckDetailsActivity.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Mythic Tools Link", userDeckUrl));
        Toast.makeText(deckDetailsActivity2, R.string.link_copied_to_clipboard, 0).show();
        return Unit.INSTANCE;
    }

    static final Unit setupPrivacyToolbar$lambda$2(final DeckDetailsActivity deckDetailsActivity) {
        MTDeck mTDeck;
        MTDeckPrivacy mTDeckPrivacy = deckDetailsActivity.currentDeckPrivacy;
        if (mTDeckPrivacy != null && (mTDeck = deckDetailsActivity.currentDeck) != null) {
            PrivacySettingsDialogFragment.Builder onDeckPrivacyUpdated = new PrivacySettingsDialogFragment.Builder().setPrivacyContext(PrivacyContext.DECK).setDeckId(mTDeck.getId()).setCurrentDeckPrivacy(mTDeckPrivacy).setOnDeckPrivacyUpdated(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda103
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeckDetailsActivity.setupPrivacyToolbar$lambda$2$0(this.f$0, (MTDeckPrivacy) obj);
                }
            });
            FragmentManager supportFragmentManager = deckDetailsActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            onDeckPrivacyUpdated.show(supportFragmentManager, "PrivacySettingsDialog");
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupPrivacyToolbar$lambda$2$0(DeckDetailsActivity deckDetailsActivity, MTDeckPrivacy updatedPrivacy) {
        Intrinsics.checkNotNullParameter(updatedPrivacy, "updatedPrivacy");
        deckDetailsActivity.currentDeckPrivacy = updatedPrivacy;
        deckDetailsActivity.updatePrivacyToolbar(updatedPrivacy);
        return Unit.INSTANCE;
    }

    private final void setupSeeTokensTextView() {
        View viewFindViewById = findViewById(R.id.seeTokensTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById;
        textView.setVisibility(8);
        ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.setupSeeTokensTextView$lambda$0(this.f$0);
            }
        });
    }

    static final Unit setupSeeTokensTextView$lambda$0(DeckDetailsActivity deckDetailsActivity) {
        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
            return Unit.INSTANCE;
        }
        MTDeck mTDeck = deckDetailsActivity.currentDeck;
        if (mTDeck != null) {
            Intent intent = new Intent(deckDetailsActivity, (Class<?>) DeckTokensActivity.class);
            intent.putExtra("deckId", mTDeck.getId());
            intent.putExtra("deckName", mTDeck.getName());
            deckDetailsActivity.startActivity(intent);
        }
        return Unit.INSTANCE;
    }

    private final void setupSideboardAndMaybeboard() {
        View viewFindViewById = findViewById(R.id.sideboardHeader);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = findViewById(R.id.maybeboardHeader);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ((LinearLayout) viewFindViewById).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda108
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.toggleSideboardExpansion();
            }
        });
        ((LinearLayout) viewFindViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda109
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.toggleMaybeboardExpansion();
            }
        });
    }

    private final void setupSideboardCards() {
        Map<String, Boolean> mapEmptyMap;
        Map<String, Boolean> mapEmptyMap2;
        DeckCardsAdapter deckCardsAdapter;
        MTDeckLists mTDeckLists = this.currentLists;
        final MTCardContainer sideboard = mTDeckLists != null ? mTDeckLists.getSideboard() : null;
        List<MTCardGroup> grouped_cards = sideboard != null ? sideboard.getGrouped_cards() : null;
        if (sideboard != null) {
            View viewFindViewById = findViewById(R.id.sideboardSection);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ((LinearLayout) viewFindViewById).setVisibility(0);
            View viewFindViewById2 = findViewById(R.id.sideboardTitle);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            TextView textView = (TextView) viewFindViewById2;
            int iCalculateCardCount = calculateCardCount(grouped_cards);
            textView.setText(getString(R.string.sideboard) + (iCalculateCardCount > 0 ? " (" + iCalculateCardCount + ")" : ""));
            View viewFindViewById3 = findViewById(R.id.sideboardRecyclerView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            final RecyclerView recyclerView = (RecyclerView) viewFindViewById3;
            View viewFindViewById4 = findViewById(R.id.sideboardTwoColumnStackedCardsView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            TwoColumnStackedCardsView twoColumnStackedCardsView = (TwoColumnStackedCardsView) viewFindViewById4;
            View viewFindViewById5 = findViewById(R.id.sideboardNoCardsTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            TextView textView2 = (TextView) viewFindViewById5;
            if (grouped_cards == null || grouped_cards.isEmpty()) {
                recyclerView.setVisibility(8);
                twoColumnStackedCardsView.setVisibility(8);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
                if (WhenMappings.$EnumSwitchMapping$0[this.currentDisplayMode.ordinal()] == 1) {
                    recyclerView.setVisibility(8);
                    twoColumnStackedCardsView.setVisibility(0);
                    List<MTListError> errors = sideboard.getErrors();
                    if (errors == null) {
                        errors = CollectionsKt.emptyList();
                    }
                    twoColumnStackedCardsView.setSelectionChecker(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda115
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(DeckDetailsActivity.setupSideboardCards$lambda$0(this.f$0, (MTFullCard) obj));
                        }
                    });
                    twoColumnStackedCardsView.setThemeMode(Intrinsics.areEqual(this.currentGroupBy, "theme"));
                    twoColumnStackedCardsView.setCardGroups(grouped_cards, errors, new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda126
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DeckDetailsActivity.setupSideboardCards$lambda$1((MTFullCard) obj);
                        }
                    }, this, sideboard.getId(), this.ignoreCollection, this.currentDeck);
                    if (this.selectionMode) {
                        twoColumnStackedCardsView.setSelectionMode(true, new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda137
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Boolean.valueOf(DeckDetailsActivity.setupSideboardCards$lambda$2(this.f$0, (MTFullCard) obj));
                            }
                        });
                    }
                } else {
                    recyclerView.setVisibility(0);
                    twoColumnStackedCardsView.setVisibility(8);
                    ArrayList arrayList = new ArrayList();
                    DeckCardsAdapter deckCardsAdapter2 = this.sideboardCardsAdapter;
                    if (deckCardsAdapter2 == null || (mapEmptyMap = deckCardsAdapter2.getExpandedCards()) == null) {
                        mapEmptyMap = MapsKt.emptyMap();
                    }
                    Map<String, Boolean> map = mapEmptyMap;
                    Iterator<T> it = grouped_cards.iterator();
                    while (it.hasNext()) {
                        arrayList.addAll(DeckCardItemKt.toDeckCardItems((MTCardGroup) it.next(), this.currentDisplayMode, sideboard, map, this.currentDeck, Intrinsics.areEqual(this.currentGroupBy, "theme")));
                    }
                    DeckCardsAdapter deckCardsAdapter3 = this.sideboardCardsAdapter;
                    if (deckCardsAdapter3 == null) {
                        DeckCardsAdapter deckCardsAdapter4 = new DeckCardsAdapter(arrayList, this.currentDisplayMode, new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda148
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeckDetailsActivity.setupSideboardCards$lambda$4((MTFullCard) obj);
                            }
                        }, this, sideboard.getId(), null, this.ignoreCollection, isOtherUserDeck() || this.isDuplicatedDeck);
                        this.sideboardCardsAdapter = deckCardsAdapter4;
                        deckCardsAdapter4.setOnExpansionChanged(new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda159
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeckDetailsActivity.setupSideboardCards$lambda$5(sideboard, this, recyclerView);
                            }
                        });
                        recyclerView.setLayoutManager(DeckCardsAdapterKt.createDeckCardsLayoutManager(this, this.currentDisplayMode));
                        recyclerView.setAdapter(this.sideboardCardsAdapter);
                    } else {
                        if (deckCardsAdapter3 == null || (mapEmptyMap2 = deckCardsAdapter3.getExpandedCards()) == null) {
                            mapEmptyMap2 = MapsKt.emptyMap();
                        }
                        DeckCardsAdapter deckCardsAdapter5 = this.sideboardCardsAdapter;
                        if (deckCardsAdapter5 != null) {
                            deckCardsAdapter5.setExpandedCards(mapEmptyMap2);
                        }
                        DeckCardsAdapter deckCardsAdapter6 = this.sideboardCardsAdapter;
                        if (deckCardsAdapter6 != null) {
                            deckCardsAdapter6.updateItems(arrayList);
                        }
                    }
                    DeckCardsAdapter deckCardsAdapter7 = this.sideboardCardsAdapter;
                    if (deckCardsAdapter7 != null) {
                        deckCardsAdapter7.setSelectionChecker(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda170
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Boolean.valueOf(DeckDetailsActivity.setupSideboardCards$lambda$6(this.f$0, (MTFullCard) obj));
                            }
                        });
                    }
                    if (this.selectionMode && (deckCardsAdapter = this.sideboardCardsAdapter) != null) {
                        deckCardsAdapter.setSelectionMode(true);
                    }
                    if (this.sideboardExpanded) {
                        recyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda181
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.adjustSideboardRecyclerViewHeight();
                            }
                        });
                    }
                }
            }
        } else {
            View viewFindViewById6 = findViewById(R.id.sideboardSection);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            ((LinearLayout) viewFindViewById6).setVisibility(8);
        }
        updateSideboardVisibility();
    }

    static final boolean setupSideboardCards$lambda$0(DeckDetailsActivity deckDetailsActivity, MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return deckDetailsActivity.isCardSelected(card);
    }

    static final Unit setupSideboardCards$lambda$1(MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return Unit.INSTANCE;
    }

    static final boolean setupSideboardCards$lambda$2(DeckDetailsActivity deckDetailsActivity, MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return deckDetailsActivity.isCardSelected(card);
    }

    static final Unit setupSideboardCards$lambda$4(MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return Unit.INSTANCE;
    }

    static final Unit setupSideboardCards$lambda$5(MTCardContainer mTCardContainer, final DeckDetailsActivity deckDetailsActivity, RecyclerView recyclerView) {
        Map<String, Boolean> mapEmptyMap;
        List<MTCardGroup> grouped_cards = mTCardContainer.getGrouped_cards();
        if (grouped_cards != null) {
            ArrayList arrayList = new ArrayList();
            DeckCardsAdapter deckCardsAdapter = deckDetailsActivity.sideboardCardsAdapter;
            if (deckCardsAdapter == null || (mapEmptyMap = deckCardsAdapter.getExpandedCards()) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            Map<String, Boolean> map = mapEmptyMap;
            Iterator<T> it = grouped_cards.iterator();
            while (it.hasNext()) {
                MTCardContainer mTCardContainer2 = mTCardContainer;
                arrayList.addAll(DeckCardItemKt.toDeckCardItems((MTCardGroup) it.next(), deckDetailsActivity.currentDisplayMode, mTCardContainer2, map, deckDetailsActivity.currentDeck, Intrinsics.areEqual(deckDetailsActivity.currentGroupBy, "theme")));
                mTCardContainer = mTCardContainer2;
            }
            DeckCardsAdapter deckCardsAdapter2 = deckDetailsActivity.sideboardCardsAdapter;
            if (deckCardsAdapter2 != null) {
                deckCardsAdapter2.updateItems(arrayList);
            }
            if (deckDetailsActivity.sideboardExpanded) {
                recyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda54
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.adjustSideboardRecyclerViewHeight();
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    static final boolean setupSideboardCards$lambda$6(DeckDetailsActivity deckDetailsActivity, MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        return deckDetailsActivity.isCardSelected(card);
    }

    private final void setupSmartDeckEffects() {
        ObjectAnimator objectAnimator = this.smartDeckGlowAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.smartDeckGlowAnimator = null;
        View viewFindViewById = findViewById(R.id.smartDeckGlowView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        CustomGlowView customGlowView = (CustomGlowView) viewFindViewById;
        customGlowView.setLayerType(1, null);
        customGlowView.setVisibility(0);
        customGlowView.setGlowColor(ContextCompat.getColor(this, R.color.mythic_plus));
        customGlowView.setGlowSize(GameUtils.INSTANCE.getInstance().dpToPx(10, r3));
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(customGlowView, "alpha", 0.4f, 0.85f);
        objectAnimatorOfFloat.setDuration(3000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.start();
        this.smartDeckGlowAnimator = objectAnimatorOfFloat;
        View viewFindViewById2 = findViewById(R.id.smartDeckBorderView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ((MythicBorderAnimationView) viewFindViewById2).setVisibility(0);
        View viewFindViewById3 = findViewById(R.id.groupByButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ((TextView) viewFindViewById3).setBackgroundResource(R.drawable.dark_grey_box_mythic);
    }

    private final void setupSortAndGroupButtons() {
        View viewFindViewById = findViewById(R.id.sortByButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final TextView textView = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.groupByButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final TextView textView2 = (TextView) viewFindViewById2;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showSortByPopupMenu(textView);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showGroupByPopupMenu(textView2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void shareFile(File file) {
        String name;
        try {
            Uri uriForFile = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", file);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/csv");
            intent.putExtra("android.intent.extra.STREAM", uriForFile);
            MTDeck mTDeck = this.currentDeck;
            if (mTDeck == null || (name = mTDeck.getName()) == null) {
                name = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            intent.putExtra("android.intent.extra.SUBJECT", "Mythic Tools Deck Export (" + name + ")");
            intent.addFlags(1);
            ((ConstraintLayout) findViewById(R.id.overlay)).setVisibility(8);
            startActivity(Intent.createChooser(intent, getString(R.string.export_list)));
        } catch (Exception unused) {
            ((ConstraintLayout) findViewById(R.id.overlay)).setVisibility(8);
            Toast.makeText(this, R.string.failed_share, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAddButton() {
        if (isOtherUserDeck() || this.isDuplicatedDeck) {
            return;
        }
        this.addButtonHidden = false;
        View viewFindViewById = findViewById(R.id.addButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.scanButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.legacyAddButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ConstraintLayout constraintLayout3 = (ConstraintLayout) viewFindViewById3;
        if (this.currentTabIndex != 0) {
            constraintLayout.setAlpha(1.0f);
            constraintLayout2.setAlpha(1.0f);
            constraintLayout3.setAlpha(1.0f);
            constraintLayout.setVisibility(8);
            constraintLayout2.setVisibility(8);
            constraintLayout3.setVisibility(8);
            ((CustomGlowView) findViewById(R.id.addButtonGlowView)).setVisibility(8);
            return;
        }
        constraintLayout.animate().cancel();
        constraintLayout2.animate().cancel();
        constraintLayout3.animate().cancel();
        constraintLayout.setVisibility(0);
        constraintLayout.setClickable(true);
        constraintLayout.setFocusable(true);
        constraintLayout2.setVisibility(0);
        constraintLayout2.setClickable(true);
        constraintLayout2.setFocusable(true);
        constraintLayout.animate().alpha(1.0f).setDuration(200L).start();
        constraintLayout2.animate().alpha(1.0f).setDuration(200L).start();
        if (this.showLegacyAddButton) {
            constraintLayout3.setVisibility(0);
            constraintLayout3.setClickable(true);
            constraintLayout3.setFocusable(true);
            constraintLayout3.animate().alpha(1.0f).setDuration(200L).start();
            ((CustomGlowView) findViewById(R.id.addButtonGlowView)).setVisibility(0);
        }
    }

    private final void showCompleteCombosSortPopup(View anchor) {
        PopupMenu popupMenu = new PopupMenu(this, anchor);
        popupMenu.getMenuInflater().inflate(R.menu.sort_combos_menu, popupMenu.getMenu());
        MenuItem menuItemFindItem = popupMenu.getMenu().findItem(R.id.sort_combos_popularity);
        if (menuItemFindItem != null) {
            menuItemFindItem.setChecked(Intrinsics.areEqual(this.completeCombosSortBy, "popularity"));
        }
        MenuItem menuItemFindItem2 = popupMenu.getMenu().findItem(R.id.sort_combos_missing_cards);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setChecked(Intrinsics.areEqual(this.completeCombosSortBy, "missing_cards"));
        }
        MenuItem menuItemFindItem3 = popupMenu.getMenu().findItem(R.id.sort_combos_total_cards);
        if (menuItemFindItem3 != null) {
            menuItemFindItem3.setChecked(Intrinsics.areEqual(this.completeCombosSortBy, "total_cards"));
        }
        MenuItem menuItemFindItem4 = popupMenu.getMenu().findItem(R.id.sort_combos_ascending);
        if (menuItemFindItem4 != null) {
            menuItemFindItem4.setChecked(this.completeCombosSortAsc);
        }
        MenuItem menuItemFindItem5 = popupMenu.getMenu().findItem(R.id.sort_combos_descending);
        if (menuItemFindItem5 != null) {
            menuItemFindItem5.setChecked(!this.completeCombosSortAsc);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda60
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return DeckDetailsActivity.showCompleteCombosSortPopup$lambda$0(this.f$0, menuItem);
            }
        });
        popupMenu.show();
    }

    static final boolean showCompleteCombosSortPopup$lambda$0(DeckDetailsActivity deckDetailsActivity, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.sort_combos_popularity) {
            deckDetailsActivity.completeCombosSortBy = "popularity";
        } else if (itemId == R.id.sort_combos_missing_cards) {
            deckDetailsActivity.completeCombosSortBy = "missing_cards";
        } else if (itemId == R.id.sort_combos_total_cards) {
            deckDetailsActivity.completeCombosSortBy = "total_cards";
        } else if (itemId == R.id.sort_combos_ascending) {
            deckDetailsActivity.completeCombosSortAsc = true;
        } else if (itemId == R.id.sort_combos_descending) {
            deckDetailsActivity.completeCombosSortAsc = false;
        }
        deckDetailsActivity.refreshCombosDisplay();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showConvertSmartDeckDialog() {
        final MTDeck mTDeck = this.currentDeck;
        if (mTDeck == null) {
            return;
        }
        DeckDetailsActivity deckDetailsActivity = this;
        MTUser currentUser = new PreferencesManager(deckDetailsActivity).getCurrentUser();
        if (currentUser != null) {
            final int id = currentUser.getId();
            FirebaseAnalytics.getInstance(deckDetailsActivity).logEvent("smart_deck_dialog_show", null);
            SmartDeckConvertDialogFragment smartDeckConvertDialogFragment = new SmartDeckConvertDialogFragment();
            smartDeckConvertDialogFragment.setOnConvert(new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckDetailsActivity.showConvertSmartDeckDialog$lambda$0(this.f$0, id, mTDeck);
                }
            });
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            FragmentExtensionsKt.showSafely(smartDeckConvertDialogFragment, supportFragmentManager, "smart_deck_convert");
        }
    }

    static final Unit showConvertSmartDeckDialog$lambda$0(final DeckDetailsActivity deckDetailsActivity, int i, MTDeck mTDeck) {
        FirebaseAnalytics.getInstance(deckDetailsActivity).logEvent("smart_deck_dialog_convert", null);
        MTApiKt.getMtApi().toggleSmartDeck(i, mTDeck.getId()).enqueue(new Callback<MTSmartDeckToggleResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$showConvertSmartDeckDialog$1$1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSmartDeckToggleResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                    return;
                }
                Toast.makeText(this.this$0, R.string.error_loading_deck_info, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSmartDeckToggleResponse> call, Response<MTSmartDeckToggleResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                    return;
                }
                if (response.isSuccessful()) {
                    MTSmartDeckToggleResponse mTSmartDeckToggleResponseBody = response.body();
                    if (mTSmartDeckToggleResponseBody != null ? Intrinsics.areEqual((Object) mTSmartDeckToggleResponseBody.is_smart_deck(), (Object) true) : false) {
                        MTDeck mTDeck2 = this.this$0.currentDeck;
                        if (mTDeck2 != null) {
                            mTDeck2.set_smart_deck(true);
                        }
                        this.this$0.isSmartDeck = true;
                        MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment = this.this$0.mythicPlusBottomSheet;
                        if (mythicPlusBottomSheetFragment != null) {
                            mythicPlusBottomSheetFragment.updateSmartDeckState(true, true);
                        }
                        Toast.makeText(this.this$0, R.string.smart_deck_convert_success, 0).show();
                        this.this$0.updateUI();
                        this.this$0.fetchDeckIdCardIfNeeded(true);
                        return;
                    }
                }
                int iCode = response.code();
                DeckDetailsActivity deckDetailsActivity2 = this.this$0;
                if (iCode == 409) {
                    Toast.makeText(deckDetailsActivity2, R.string.smart_deck_convert_error_exists, 1).show();
                } else {
                    Toast.makeText(deckDetailsActivity2, R.string.error_loading_deck_info, 0).show();
                }
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDeckImportConfirmation(final List<ParsedCard> cards, final boolean replaceAll) {
        if (cards.isEmpty()) {
            Toast.makeText(this, getString(R.string.no_valid_cards_found), 0).show();
            return;
        }
        DeckImportConfirmationDialogFragment.Builder onCancel = new DeckImportConfirmationDialogFragment.Builder().setCards(cards).setReplaceAll(replaceAll).setOnConfirm(new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda146
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showDeckImportConfirmation$lambda$0(this.f$0, cards, replaceAll);
            }
        }).setOnCancel(new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda147
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showDeckImportConfirmation$lambda$1(this.f$0);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        onCancel.show(supportFragmentManager, "deck_import_confirmation_dialog");
    }

    static final Unit showDeckImportConfirmation$lambda$0(DeckDetailsActivity deckDetailsActivity, List list, boolean z) {
        deckDetailsActivity.importCardsFromList(list, z);
        return Unit.INSTANCE;
    }

    static final Unit showDeckImportConfirmation$lambda$1(DeckDetailsActivity deckDetailsActivity) {
        Toast.makeText(deckDetailsActivity, deckDetailsActivity.getString(R.string.import_canceled), 0).show();
        return Unit.INSTANCE;
    }

    private final void showDeckImportConfirmationWithSections(final ParsedDeckList parsedDeckList, final boolean replaceAll) {
        if (CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) parsedDeckList.getMainDeckCards(), (Iterable) parsedDeckList.getSideboardCards()), (Iterable) parsedDeckList.getMaybeboardCards()).isEmpty()) {
            Toast.makeText(this, getString(R.string.no_valid_cards_found), 0).show();
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!parsedDeckList.getMainDeckCards().isEmpty()) {
            arrayList.addAll(parsedDeckList.getMainDeckCards());
        }
        if (!parsedDeckList.getSideboardCards().isEmpty()) {
            arrayList.add(new ParsedCard(0, "SIDEBOARD:", null, null, null, null, CardSection.SIDEBOARD, 60, null));
            arrayList.addAll(parsedDeckList.getSideboardCards());
        }
        if (!parsedDeckList.getMaybeboardCards().isEmpty()) {
            arrayList.add(new ParsedCard(0, "MAYBEBOARD:", null, null, null, null, CardSection.MAYBEBOARD, 60, null));
            arrayList.addAll(parsedDeckList.getMaybeboardCards());
        }
        DeckImportConfirmationDialogFragment.Builder onCancel = new DeckImportConfirmationDialogFragment.Builder().setCards(arrayList).setReplaceAll(replaceAll).setOnConfirm(new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showDeckImportConfirmationWithSections$lambda$0(this.f$0, parsedDeckList, replaceAll);
            }
        }).setOnCancel(new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showDeckImportConfirmationWithSections$lambda$1(this.f$0);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        onCancel.show(supportFragmentManager, "deck_import_confirmation_dialog");
    }

    static final Unit showDeckImportConfirmationWithSections$lambda$0(DeckDetailsActivity deckDetailsActivity, ParsedDeckList parsedDeckList, boolean z) {
        deckDetailsActivity.importCardsFromListWithSections(parsedDeckList, z);
        return Unit.INSTANCE;
    }

    static final Unit showDeckImportConfirmationWithSections$lambda$1(DeckDetailsActivity deckDetailsActivity) {
        Toast.makeText(deckDetailsActivity, deckDetailsActivity.getString(R.string.import_canceled), 0).show();
        return Unit.INSTANCE;
    }

    private final void showDeckImportResults(MTAddCardsResult result, List<ParsedCard> originalCards) {
        List<MTAddCardResult> failed_cards;
        if (result.getSuccess() && ((failed_cards = result.getFailed_cards()) == null || failed_cards.isEmpty())) {
            String string = getString(R.string.deck_import_success, new Object[]{Integer.valueOf(result.getAdded())});
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast.makeText(this, string, 1).show();
            return;
        }
        if (result.getAdded() <= 0) {
            Toast.makeText(this, getString(R.string.deck_import_failed), 1).show();
            return;
        }
        List<MTAddCardResult> failed_cards2 = result.getFailed_cards();
        int size = failed_cards2 != null ? failed_cards2.size() : 0;
        String string2 = getString(R.string.deck_import_partial, new Object[]{Integer.valueOf(result.getAdded()), Integer.valueOf(size)});
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        Toast.makeText(this, string2, 1).show();
        if (size > 0) {
            String strBuildDeckImportResultMessage = buildDeckImportResultMessage(result, originalCards);
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string3 = getString(R.string.deck_import_results);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder body = builder.setTitle(string3).setBody(strBuildDeckImportResultMessage);
            String string4 = getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string4, new Function2() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda93
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeckDetailsActivity.showDeckImportResults$lambda$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            positiveButton.show(supportFragmentManager, "deck_import_results_dialog");
        }
    }

    static final Unit showDeckImportResults$lambda$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void showDeckImportResultsWithSections(List<MTAddCardsResult> results, ParsedDeckList parsedDeckList) {
        List<MTAddCardsResult> list = results;
        Iterator<T> it = list.iterator();
        int quantity = 0;
        int added = 0;
        while (it.hasNext()) {
            added += ((MTAddCardsResult) it.next()).getAdded();
        }
        Iterator<T> it2 = list.iterator();
        int size = 0;
        while (it2.hasNext()) {
            List<MTAddCardResult> failed_cards = ((MTAddCardsResult) it2.next()).getFailed_cards();
            size += failed_cards != null ? failed_cards.size() : 0;
        }
        if (size != 0) {
            String string = getString(R.string.deck_import_partial, new Object[]{Integer.valueOf(added), Integer.valueOf(size)});
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast.makeText(this, string, 1).show();
            String strBuildDeckImportResultMessageWithSections = buildDeckImportResultMessageWithSections(results, parsedDeckList);
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string2 = getString(R.string.deck_import_results);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = builder.setTitle(string2).setBody(strBuildDeckImportResultMessageWithSections);
            String string3 = getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda138
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeckDetailsActivity.showDeckImportResultsWithSections$lambda$7(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            positiveButton.show(supportFragmentManager, "deck_import_results_dialog");
            return;
        }
        Iterator<T> it3 = parsedDeckList.getMainDeckCards().iterator();
        int quantity2 = 0;
        while (it3.hasNext()) {
            quantity2 += ((ParsedCard) it3.next()).getQuantity();
        }
        Iterator<T> it4 = parsedDeckList.getSideboardCards().iterator();
        int quantity3 = 0;
        while (it4.hasNext()) {
            quantity3 += ((ParsedCard) it4.next()).getQuantity();
        }
        Iterator<T> it5 = parsedDeckList.getMaybeboardCards().iterator();
        while (it5.hasNext()) {
            quantity += ((ParsedCard) it5.next()).getQuantity();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.deck_import_success, new Object[]{Integer.valueOf(quantity2)}));
        if (quantity3 > 0) {
            sb.append("\n" + getString(R.string.deck_import_sideboard_success, new Object[]{Integer.valueOf(quantity3)}));
        }
        if (quantity > 0) {
            sb.append("\n" + getString(R.string.deck_import_maybeboard_success, new Object[]{Integer.valueOf(quantity)}));
        }
        String string4 = sb.toString();
        CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
        String string5 = getString(R.string.deck_import_results);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        CustomDialogFragment.Builder body2 = builder2.setTitle(string5).setBody(string4);
        String string6 = getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        CustomDialogFragment.Builder positiveButton2 = body2.setPositiveButton(string6, new Function2() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda136
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DeckDetailsActivity.showDeckImportResultsWithSections$lambda$6(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager supportFragmentManager2 = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
        positiveButton2.show(supportFragmentManager2, "deck_import_results_dialog");
    }

    static final Unit showDeckImportResultsWithSections$lambda$6(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit showDeckImportResultsWithSections$lambda$7(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void showDeckSettingsMenu(View anchor) {
        PopupMenu popupMenu = new PopupMenu(this, anchor);
        MenuItem menuItemAdd = popupMenu.getMenu().add(0, 1, 0, getString(R.string.deck_ignore_collection_status));
        menuItemAdd.setCheckable(true);
        menuItemAdd.setChecked(this.ignoreCollection);
        MenuItem menuItemAdd2 = popupMenu.getMenu().add(0, 2, 0, getString(R.string.deck_ignore_printings));
        menuItemAdd2.setCheckable(true);
        menuItemAdd2.setChecked(this.ignorePrintings);
        MenuItem menuItemAdd3 = popupMenu.getMenu().add(0, 3, 1, getString(R.string.deck_ignore_basic_lands_collection_status));
        menuItemAdd3.setCheckable(true);
        menuItemAdd3.setChecked(this.ignoreBasicLands);
        menuItemAdd3.setEnabled(!this.ignorePrintings);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda139
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return DeckDetailsActivity.showDeckSettingsMenu$lambda$3(this.f$0, menuItem);
            }
        });
        popupMenu.show();
        try {
            Field declaredField = PopupMenu.class.getDeclaredField("mPopup");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(popupMenu);
            Object objInvoke = obj.getClass().getDeclaredMethod("getListView", new Class[0]).invoke(obj, new Object[0]);
            final ListView listView = objInvoke instanceof ListView ? (ListView) objInvoke : null;
            if (listView != null) {
                listView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda140
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeckDetailsActivity.showDeckSettingsMenu$lambda$4$0(listView, this);
                    }
                });
            }
        } catch (Exception e) {
            Log.e("DeckDetailsActivity", "Failed to enable multiline in popup menu", e);
        }
    }

    static final boolean showDeckSettingsMenu$lambda$3(DeckDetailsActivity deckDetailsActivity, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 1) {
            deckDetailsActivity.ignoreCollection = !deckDetailsActivity.ignoreCollection;
            PreferencesManager preferencesManager = new PreferencesManager(deckDetailsActivity);
            preferencesManager.setBoolean(PreferencesManager.IGNORE_COLLECTION, deckDetailsActivity.ignoreCollection);
            PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
            View viewFindViewById = deckDetailsActivity.findViewById(R.id.toolbarCollectionStatusView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ((CollectionStatusView) viewFindViewById).setVisibility(deckDetailsActivity.ignoreCollection ? 8 : 0);
            DeckCardsAdapter deckCardsAdapter = deckDetailsActivity.deckCardsAdapter;
            if (deckCardsAdapter != null) {
                deckCardsAdapter.updateIgnoreCollection(deckDetailsActivity.ignoreCollection);
            }
            DeckCardsAdapter deckCardsAdapter2 = deckDetailsActivity.sideboardCardsAdapter;
            if (deckCardsAdapter2 != null) {
                deckCardsAdapter2.updateIgnoreCollection(deckDetailsActivity.ignoreCollection);
            }
            DeckCardsAdapter deckCardsAdapter3 = deckDetailsActivity.maybeboardCardsAdapter;
            if (deckCardsAdapter3 != null) {
                deckCardsAdapter3.updateIgnoreCollection(deckDetailsActivity.ignoreCollection);
            }
            deckDetailsActivity.refreshDeckCards();
        } else if (itemId == 2) {
            deckDetailsActivity.ignorePrintings = !deckDetailsActivity.ignorePrintings;
            PreferencesManager preferencesManager2 = new PreferencesManager(deckDetailsActivity);
            preferencesManager2.setBoolean(PreferencesManager.IGNORE_PRINTINGS, deckDetailsActivity.ignorePrintings);
            PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager2, null, 1, null);
            deckDetailsActivity.refreshDeckCards();
        } else if (itemId == 3 && !deckDetailsActivity.ignorePrintings) {
            deckDetailsActivity.ignoreBasicLands = !deckDetailsActivity.ignoreBasicLands;
            PreferencesManager preferencesManager3 = new PreferencesManager(deckDetailsActivity);
            preferencesManager3.setBoolean(PreferencesManager.IGNORE_BASIC_LANDS, deckDetailsActivity.ignoreBasicLands);
            PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager3, null, 1, null);
            deckDetailsActivity.refreshDeckCards();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeckSettingsMenu$lambda$4$0(ListView listView, DeckDetailsActivity deckDetailsActivity) {
        int childCount = listView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = listView.getChildAt(i);
            ArrayList<TextView> arrayList = new ArrayList();
            Intrinsics.checkNotNull(childAt);
            deckDetailsActivity.findAllTextViews(childAt, arrayList);
            for (TextView textView : arrayList) {
                textView.setSingleLine(false);
                textView.setMaxLines(3);
            }
        }
    }

    private final void showDeckValuesPopup() {
        MTDeckValues values;
        MTDeck mTDeck = this.currentDeck;
        if (mTDeck == null || (values = mTDeck.getValues()) == null) {
            return;
        }
        DeckDetailsActivity deckDetailsActivity = this;
        final Dialog dialog = new Dialog(deckDetailsActivity);
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
        final View viewInflate = LayoutInflater.from(deckDetailsActivity).inflate(R.layout.dialog_deck_values, (ViewGroup) null);
        dialog.setContentView(viewInflate);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda56
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DeckDetailsActivity.showDeckValuesPopup$lambda$0(this.f$0, dialogInterface);
            }
        });
        viewInflate.findViewById(R.id.deck_values_overlay).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda57
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        viewInflate.findViewById(R.id.deck_values_card).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda58
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeckDetailsActivity.showDeckValuesPopup$lambda$2(view);
            }
        });
        Intrinsics.checkNotNull(viewInflate);
        updateDeckValuesDialogView(viewInflate, values);
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.deck_values_update_button);
        Intrinsics.checkNotNull(constraintLayout);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda59
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showDeckValuesPopup$lambda$3(this.f$0, constraintLayout, viewInflate);
            }
        });
        dialog.show();
        Window window3 = dialog.getWindow();
        if (window3 != null) {
            window3.setLayout(-1, -1);
        }
    }

    static final void showDeckValuesPopup$lambda$0(DeckDetailsActivity deckDetailsActivity, DialogInterface dialogInterface) {
        deckDetailsActivity.isDeckValuesRecalcInProgress = false;
        ObjectAnimator objectAnimator = deckDetailsActivity.recalcValuesRotationAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        deckDetailsActivity.recalcValuesRotationAnimator = null;
    }

    static final void showDeckValuesPopup$lambda$2(View view) {
    }

    static final Unit showDeckValuesPopup$lambda$3(final DeckDetailsActivity deckDetailsActivity, final ConstraintLayout constraintLayout, final View view) {
        if (deckDetailsActivity.isDeckValuesRecalcInProgress) {
            return Unit.INSTANCE;
        }
        DeckDetailsActivity deckDetailsActivity2 = deckDetailsActivity;
        MTUser currentUser = new PreferencesManager(deckDetailsActivity2).getCurrentUser();
        if (currentUser == null) {
            Toast.makeText(deckDetailsActivity2, deckDetailsActivity.getString(R.string.deck_values_recalc_error), 0).show();
            return Unit.INSTANCE;
        }
        int id = currentUser.getId();
        MTDeck mTDeck = deckDetailsActivity.currentDeck;
        if (mTDeck == null) {
            Toast.makeText(deckDetailsActivity2, deckDetailsActivity.getString(R.string.deck_values_recalc_error), 0).show();
            return Unit.INSTANCE;
        }
        int id2 = mTDeck.getId();
        deckDetailsActivity.isDeckValuesRecalcInProgress = true;
        constraintLayout.setClickable(false);
        TextView textView = (TextView) view.findViewById(R.id.recalcTextView);
        ObjectAnimator objectAnimator = deckDetailsActivity.recalcValuesRotationAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ROTATION, 0.0f, 360.0f);
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        deckDetailsActivity.recalcValuesRotationAnimator = objectAnimatorOfFloat;
        if (objectAnimatorOfFloat != null) {
            objectAnimatorOfFloat.start();
        }
        MTApiKt.getMtApi().calculateDeckValues(id, id2, Boolean.valueOf(deckDetailsActivity.ignoreBasicLands)).enqueue(new Callback<MTCalculateValuesResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$showDeckValuesPopup$4$2
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCalculateValuesResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                ObjectAnimator objectAnimator2 = this.this$0.recalcValuesRotationAnimator;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                }
                this.this$0.recalcValuesRotationAnimator = null;
                this.this$0.isDeckValuesRecalcInProgress = false;
                constraintLayout.setClickable(true);
                DeckDetailsActivity deckDetailsActivity3 = this.this$0;
                Toast.makeText(deckDetailsActivity3, deckDetailsActivity3.getString(R.string.deck_values_recalc_error), 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCalculateValuesResponse> call, Response<MTCalculateValuesResponse> response) {
                MTDeckValues values;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                ObjectAnimator objectAnimator2 = this.this$0.recalcValuesRotationAnimator;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                }
                this.this$0.recalcValuesRotationAnimator = null;
                this.this$0.isDeckValuesRecalcInProgress = false;
                constraintLayout.setClickable(true);
                if (!response.isSuccessful()) {
                    DeckDetailsActivity deckDetailsActivity3 = this.this$0;
                    Toast.makeText(deckDetailsActivity3, deckDetailsActivity3.getString(R.string.deck_values_recalc_error), 0).show();
                    return;
                }
                MTCalculateValuesResponse mTCalculateValuesResponseBody = response.body();
                if (mTCalculateValuesResponseBody == null || (values = mTCalculateValuesResponseBody.getValues()) == null) {
                    DeckDetailsActivity deckDetailsActivity4 = this.this$0;
                    Toast.makeText(deckDetailsActivity4, deckDetailsActivity4.getString(R.string.deck_values_recalc_error), 0).show();
                    return;
                }
                DeckDetailsActivity deckDetailsActivity5 = this.this$0;
                View view2 = view;
                MTDeck mTDeck2 = deckDetailsActivity5.currentDeck;
                if (mTDeck2 != null) {
                    mTDeck2.setValues(values);
                }
                Intrinsics.checkNotNull(view2);
                deckDetailsActivity5.updateDeckValuesDialogView(view2, values);
                Toast.makeText(deckDetailsActivity5, deckDetailsActivity5.getString(R.string.deck_values_recalc_success), 0).show();
            }
        });
        return Unit.INSTANCE;
    }

    private final void showDescriptionEditDialog(String currentDescription) {
        final Dialog dialogBuildDescriptionDialog = buildDescriptionDialog();
        LinearLayout linearLayoutBuildDescriptionDialogRoot = buildDescriptionDialogRoot();
        String string = getString(R.string.edit_description);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        linearLayoutBuildDescriptionDialogRoot.addView(buildDescriptionTitle(string));
        DeckDetailsActivity deckDetailsActivity = this;
        final EditText editText = new EditText(deckDetailsActivity);
        editText.setText(currentDescription);
        editText.setHint(getString(R.string.add_descrpition));
        editText.setTextSize(15.0f);
        editText.setTextColor(ContextCompat.getColor(deckDetailsActivity, R.color.text_color));
        editText.setHintTextColor(ContextCompat.getColor(deckDetailsActivity, R.color.text_color_transparent));
        editText.setTypeface(editText.getResources().getFont(R.font.be_vietnam_pro_regular));
        editText.setMinLines(3);
        editText.setInputType(131073);
        editText.setBackground(ContextCompat.getDrawable(deckDetailsActivity, R.drawable.background_box_small));
        editText.setPadding(dp(10), dp(8), dp(10), dp(8));
        editText.setSelection(editText.getText().length());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = dp(12);
        editText.setLayoutParams(layoutParams);
        linearLayoutBuildDescriptionDialogRoot.addView(editText);
        LinearLayout linearLayout = new LinearLayout(deckDetailsActivity);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = dp(18);
        linearLayout.setLayoutParams(layoutParams2);
        View view = new View(deckDetailsActivity);
        view.setLayoutParams(new LinearLayout.LayoutParams(0, 1, 1.0f));
        linearLayout.addView(view);
        MaterialButton materialButton = new MaterialButton(deckDetailsActivity);
        materialButton.setText(getString(R.string.cancel));
        materialButton.setAllCaps(false);
        materialButton.setBackgroundResource(R.drawable.custom_button_background_blue);
        materialButton.setBackgroundTintList(null);
        materialButton.setTextColor(-1);
        materialButton.setMinimumWidth(dp(70));
        materialButton.setMinimumHeight(0);
        MaterialButton materialButton2 = materialButton;
        ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda73
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showDescriptionEditDialog$lambda$4(dialogBuildDescriptionDialog);
            }
        });
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMarginEnd(dp(6));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(materialButton2, layoutParams3);
        MaterialButton materialButton3 = new MaterialButton(deckDetailsActivity);
        materialButton3.setText(getString(R.string.save));
        materialButton3.setAllCaps(false);
        materialButton3.setBackgroundResource(R.drawable.custom_button_background);
        materialButton3.setBackgroundTintList(null);
        materialButton3.setTextColor(-1);
        materialButton3.setMinimumWidth(dp(70));
        materialButton3.setMinimumHeight(0);
        MaterialButton materialButton4 = materialButton3;
        ViewExtensionsKt.setOnClickWithFade(materialButton4, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda74
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showDescriptionEditDialog$lambda$7(editText, dialogBuildDescriptionDialog, this);
            }
        });
        linearLayout.addView(materialButton4);
        linearLayoutBuildDescriptionDialogRoot.addView(linearLayout);
        dialogBuildDescriptionDialog.setContentView(linearLayoutBuildDescriptionDialogRoot);
        Window window = dialogBuildDescriptionDialog.getWindow();
        if (window != null) {
            window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
        }
        dialogBuildDescriptionDialog.show();
        Window window2 = dialogBuildDescriptionDialog.getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(4);
        }
        editText.requestFocus();
    }

    static final Unit showDescriptionEditDialog$lambda$4(Dialog dialog) {
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit showDescriptionEditDialog$lambda$7(EditText editText, Dialog dialog, DeckDetailsActivity deckDetailsActivity) {
        String string = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
        dialog.dismiss();
        deckDetailsActivity.submitDescription(string);
        return Unit.INSTANCE;
    }

    private final void showDescriptionViewDialog(final String description) {
        final Dialog dialogBuildDescriptionDialog = buildDescriptionDialog();
        LinearLayout linearLayoutBuildDescriptionDialogRoot = buildDescriptionDialogRoot();
        String string = getString(R.string.deck_description);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        linearLayoutBuildDescriptionDialogRoot.addView(buildDescriptionTitle(string));
        DeckDetailsActivity deckDetailsActivity = this;
        ScrollView scrollView = new ScrollView(deckDetailsActivity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = dp(12);
        scrollView.setLayoutParams(layoutParams);
        int i = scrollView.getResources().getDisplayMetrics().heightPixels;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = dp(12);
        scrollView.setLayoutParams(layoutParams2);
        scrollView.setVerticalScrollBarEnabled(true);
        TextView textView = new TextView(deckDetailsActivity);
        textView.setText(description);
        textView.setTextSize(16.0f);
        textView.setTextColor(ContextCompat.getColor(deckDetailsActivity, R.color.text_color));
        textView.setTypeface(textView.getResources().getFont(R.font.be_vietnam_pro_regular));
        scrollView.addView(textView);
        linearLayoutBuildDescriptionDialogRoot.addView(scrollView);
        LinearLayout linearLayout = new LinearLayout(deckDetailsActivity);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = dp(18);
        linearLayout.setLayoutParams(layoutParams3);
        if (!isOtherUserDeck() && !this.isDuplicatedDeck) {
            MaterialButton materialButton = new MaterialButton(deckDetailsActivity);
            materialButton.setText(getString(R.string.edit_description));
            materialButton.setAllCaps(false);
            materialButton.setBackgroundResource(R.drawable.custom_button_background_black_border);
            materialButton.setBackgroundTintList(null);
            materialButton.setTextColor(-1);
            materialButton.setMinimumWidth(dp(70));
            materialButton.setMinimumHeight(0);
            MaterialButton materialButton2 = materialButton;
            ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda176
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckDetailsActivity.showDescriptionViewDialog$lambda$4(dialogBuildDescriptionDialog, this, description);
                }
            });
            linearLayout.addView(materialButton2);
        }
        View view = new View(deckDetailsActivity);
        view.setLayoutParams(new LinearLayout.LayoutParams(0, 1, 1.0f));
        linearLayout.addView(view);
        MaterialButton materialButton3 = new MaterialButton(deckDetailsActivity);
        materialButton3.setText(getString(R.string.close));
        materialButton3.setAllCaps(false);
        materialButton3.setBackgroundResource(R.drawable.custom_button_background_blue);
        materialButton3.setBackgroundTintList(null);
        materialButton3.setTextColor(-1);
        materialButton3.setMinimumWidth(dp(70));
        materialButton3.setMinimumHeight(0);
        MaterialButton materialButton4 = materialButton3;
        ViewExtensionsKt.setOnClickWithFade(materialButton4, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda177
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showDescriptionViewDialog$lambda$7(dialogBuildDescriptionDialog);
            }
        });
        linearLayout.addView(materialButton4);
        linearLayoutBuildDescriptionDialogRoot.addView(linearLayout);
        dialogBuildDescriptionDialog.setContentView(linearLayoutBuildDescriptionDialogRoot);
        Window window = dialogBuildDescriptionDialog.getWindow();
        if (window != null) {
            window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
        }
        dialogBuildDescriptionDialog.show();
    }

    static final Unit showDescriptionViewDialog$lambda$4(Dialog dialog, DeckDetailsActivity deckDetailsActivity, String str) {
        dialog.dismiss();
        deckDetailsActivity.showDescriptionEditDialog(str);
        return Unit.INSTANCE;
    }

    static final Unit showDescriptionViewDialog$lambda$7(Dialog dialog) {
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showExternalDeckSyncConfirmation(MTGetExternalDeckResponse syncResponse, final String url) {
        ExternalDeckSyncConfirmationDialogFragment.Builder builder = new ExternalDeckSyncConfirmationDialogFragment.Builder();
        List<MTDeckCardToAdd> toAdd = syncResponse.getToAdd();
        if (toAdd == null) {
            toAdd = CollectionsKt.emptyList();
        }
        ExternalDeckSyncConfirmationDialogFragment.Builder toAdd2 = builder.setToAdd(toAdd);
        List<MTDeckCardToModify> toModify = syncResponse.getToModify();
        if (toModify == null) {
            toModify = CollectionsKt.emptyList();
        }
        ExternalDeckSyncConfirmationDialogFragment.Builder toModify2 = toAdd2.setToModify(toModify);
        List<MTDeckCardToRemove> toRemove = syncResponse.getToRemove();
        if (toRemove == null) {
            toRemove = CollectionsKt.emptyList();
        }
        ExternalDeckSyncConfirmationDialogFragment.Builder onCancel = toModify2.setToRemove(toRemove).setOnConfirm(new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda156
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showExternalDeckSyncConfirmation$lambda$0(this.f$0, url);
            }
        }).setOnCancel(new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda157
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showExternalDeckSyncConfirmation$lambda$1(this.f$0);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        onCancel.show(supportFragmentManager, "external_deck_sync_confirmation_dialog");
    }

    static final Unit showExternalDeckSyncConfirmation$lambda$0(DeckDetailsActivity deckDetailsActivity, String str) {
        deckDetailsActivity.applyExternalDeckSync(str);
        return Unit.INSTANCE;
    }

    static final Unit showExternalDeckSyncConfirmation$lambda$1(DeckDetailsActivity deckDetailsActivity) {
        Toast.makeText(deckDetailsActivity, deckDetailsActivity.getString(R.string.import_canceled), 0).show();
        return Unit.INSTANCE;
    }

    private final void showFilterBottomSheet() {
        FilterBottomSheetFragment.INSTANCE.newInstance(new FilterCallback() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$showFilterBottomSheet$bottomSheet$1
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
                        DeckDetailsActivity deckDetailsActivity = this.this$0;
                        tagId.intValue();
                        Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        objectRef.element = "";
                        MTUserTags currentUserTags = new PreferencesManager(deckDetailsActivity).getCurrentUserTags();
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
    public final void showGroupByPopupMenu(View anchor) {
        DeckDetailsActivity deckDetailsActivity = this;
        SelectionPopupMenu selectionPopupMenu = new SelectionPopupMenu(deckDetailsActivity);
        final MTDeck mTDeck = this.currentDeck;
        if (mTDeck != null && !isOtherUserDeck() && !this.isDuplicatedDeck && mTDeck.getFormatid() == 6) {
            String string = getString(R.string.group_theme);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            selectionPopupMenu.addItem(string, ContextCompat.getDrawable(deckDetailsActivity, R.drawable.mythic_plus_small), Integer.valueOf(ContextCompat.getColor(deckDetailsActivity, R.color.mythic_plus)), Intrinsics.areEqual(this.currentGroupBy, "theme"), new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda179
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckDetailsActivity.showGroupByPopupMenu$lambda$0(this.f$0, mTDeck);
                }
            });
        }
        String string2 = getString(R.string.group_type);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        SelectionPopupMenu.addItem$default(selectionPopupMenu, string2, null, null, Intrinsics.areEqual(this.currentGroupBy, "type"), new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda180
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showGroupByPopupMenu$lambda$1(this.f$0);
            }
        }, 6, null);
        String string3 = getString(R.string.group_color);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        SelectionPopupMenu.addItem$default(selectionPopupMenu, string3, null, null, Intrinsics.areEqual(this.currentGroupBy, "color"), new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showGroupByPopupMenu$lambda$2(this.f$0);
            }
        }, 6, null);
        String string4 = getString(R.string.group_color_identity);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        SelectionPopupMenu.addItem$default(selectionPopupMenu, string4, null, null, Intrinsics.areEqual(this.currentGroupBy, "id"), new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showGroupByPopupMenu$lambda$3(this.f$0);
            }
        }, 6, null);
        String string5 = getString(R.string.group_cmc);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        SelectionPopupMenu.addItem$default(selectionPopupMenu, string5, null, null, Intrinsics.areEqual(this.currentGroupBy, "cmc"), new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showGroupByPopupMenu$lambda$4(this.f$0);
            }
        }, 6, null);
        String string6 = getString(R.string.group_rarity);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        SelectionPopupMenu.addItem$default(selectionPopupMenu, string6, null, null, Intrinsics.areEqual(this.currentGroupBy, "rarity"), new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showGroupByPopupMenu$lambda$5(this.f$0);
            }
        }, 6, null);
        String string7 = getString(R.string.group_set);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        SelectionPopupMenu.addItem$default(selectionPopupMenu, string7, null, null, Intrinsics.areEqual(this.currentGroupBy, "set"), new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showGroupByPopupMenu$lambda$6(this.f$0);
            }
        }, 6, null);
        selectionPopupMenu.show(anchor);
    }

    static final Unit showGroupByPopupMenu$lambda$0(DeckDetailsActivity deckDetailsActivity, MTDeck mTDeck) {
        if (deckDetailsActivity.isSmartDeck) {
            showGroupByPopupMenu$selectGroup(deckDetailsActivity, "theme");
        } else if (Intrinsics.areEqual((Object) mTDeck.getHas_smart_deck(), (Object) true)) {
            deckDetailsActivity.showPaywallInfo("groupbytheme");
        } else {
            deckDetailsActivity.showConvertSmartDeckDialog();
        }
        return Unit.INSTANCE;
    }

    static final Unit showGroupByPopupMenu$lambda$1(DeckDetailsActivity deckDetailsActivity) {
        showGroupByPopupMenu$selectGroup(deckDetailsActivity, "type");
        return Unit.INSTANCE;
    }

    static final Unit showGroupByPopupMenu$lambda$2(DeckDetailsActivity deckDetailsActivity) {
        showGroupByPopupMenu$selectGroup(deckDetailsActivity, "color");
        return Unit.INSTANCE;
    }

    static final Unit showGroupByPopupMenu$lambda$3(DeckDetailsActivity deckDetailsActivity) {
        showGroupByPopupMenu$selectGroup(deckDetailsActivity, "id");
        return Unit.INSTANCE;
    }

    static final Unit showGroupByPopupMenu$lambda$4(DeckDetailsActivity deckDetailsActivity) {
        showGroupByPopupMenu$selectGroup(deckDetailsActivity, "cmc");
        return Unit.INSTANCE;
    }

    static final Unit showGroupByPopupMenu$lambda$5(DeckDetailsActivity deckDetailsActivity) {
        showGroupByPopupMenu$selectGroup(deckDetailsActivity, "rarity");
        return Unit.INSTANCE;
    }

    static final Unit showGroupByPopupMenu$lambda$6(DeckDetailsActivity deckDetailsActivity) {
        showGroupByPopupMenu$selectGroup(deckDetailsActivity, "set");
        return Unit.INSTANCE;
    }

    private static final void showGroupByPopupMenu$selectGroup(DeckDetailsActivity deckDetailsActivity, String str) {
        deckDetailsActivity.currentGroupBy = str;
        deckDetailsActivity.refreshDeckCards();
        PreferencesManager preferencesManager = new PreferencesManager(deckDetailsActivity);
        preferencesManager.setLastDeckListGroupBy(deckDetailsActivity.currentGroupBy);
        PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
    }

    private final void showImportDeckDialog() {
        new ImportDeckDialogFragment.Builder().setListener(new ImportDeckDialogListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$showImportDeckDialog$dialog$1
            @Override // com.studiolaganne.lengendarylens.ImportDeckDialogListener
            public void onImportDeck(DeckImportResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                this.this$0.handleDeckImport(result);
            }
        }).build().show(getSupportFragmentManager(), ImportDeckDialogFragment.TAG);
    }

    private final void showLegacyAddPanel() {
        Dialog dialog;
        if (this.cardPickerBottomSheet == null) {
            MTCardPickerBottomSheetFragment.Companion companion = MTCardPickerBottomSheetFragment.INSTANCE;
            C11591 c11591 = new C11591();
            String string = getString(R.string.pick_a_card);
            String str = this.lastCardPickerQuery;
            MTDeck mTDeck = this.currentDeck;
            this.cardPickerBottomSheet = companion.newInstance(c11591, string, str, mTDeck != null ? Integer.valueOf(mTDeck.getId()) : null);
        }
        MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment = this.cardPickerBottomSheet;
        if (mTCardPickerBottomSheetFragment == null || !mTCardPickerBottomSheetFragment.isAdded()) {
            MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment2 = this.cardPickerBottomSheet;
            if (mTCardPickerBottomSheetFragment2 != null) {
                mTCardPickerBottomSheetFragment2.show(getSupportFragmentManager(), "MTCardPicker");
                return;
            }
            return;
        }
        MTCardPickerBottomSheetFragment mTCardPickerBottomSheetFragment3 = this.cardPickerBottomSheet;
        if (mTCardPickerBottomSheetFragment3 == null || (dialog = mTCardPickerBottomSheetFragment3.getDialog()) == null) {
            return;
        }
        dialog.show();
    }

    private final void showLoadingOverlay() {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
    }

    private final void showMythicPlusPanel() {
        Dialog dialog;
        int iIntValue;
        MTCardContainer maybeboard;
        MTCardContainer sideboard;
        MTCardContainer main;
        if (this.mythicPlusBottomSheet == null) {
            MythicPlusBottomSheetFragment.Companion companion = MythicPlusBottomSheetFragment.INSTANCE;
            MTDeck mTDeck = this.currentDeck;
            if (mTDeck == null) {
                return;
            }
            int id = mTDeck.getId();
            MTDeckLists mTDeckLists = this.currentLists;
            int id2 = -1;
            if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null) {
                MTDeck mTDeck2 = this.currentDeck;
                Integer listid = mTDeck2 != null ? mTDeck2.getListid() : null;
                iIntValue = listid != null ? listid.intValue() : -1;
            } else {
                iIntValue = main.getId();
            }
            MTDeckLists mTDeckLists2 = this.currentLists;
            int id3 = (mTDeckLists2 == null || (sideboard = mTDeckLists2.getSideboard()) == null) ? -1 : sideboard.getId();
            MTDeckLists mTDeckLists3 = this.currentLists;
            if (mTDeckLists3 != null && (maybeboard = mTDeckLists3.getMaybeboard()) != null) {
                id2 = maybeboard.getId();
            }
            int i = id2;
            boolean z = this.isSmartDeck;
            MTDeck mTDeck3 = this.currentDeck;
            this.mythicPlusBottomSheet = companion.newInstance(id, iIntValue, id3, i, z, mTDeck3 != null ? Intrinsics.areEqual((Object) mTDeck3.getHas_smart_deck(), (Object) true) : false, new MythicPlusCallback() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity.showMythicPlusPanel.1
                /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
                @Override // com.studiolaganne.lengendarylens.MythicPlusCallback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onAddCardToDeck(final MTFullCard card, final String listType) {
                    Integer listid2;
                    MTCardContainer main2;
                    MTCardContainer sideboard2;
                    String lowerCase;
                    MTCardContainer maybeboard2;
                    Intrinsics.checkNotNullParameter(card, "card");
                    Intrinsics.checkNotNullParameter(listType, "listType");
                    if (DeckDetailsActivity.this.isFinishing() || DeckDetailsActivity.this.isDestroyed()) {
                        return;
                    }
                    if (Intrinsics.areEqual(listType, "maybeboard")) {
                        MTDeckLists mTDeckLists4 = DeckDetailsActivity.this.currentLists;
                        listid2 = (mTDeckLists4 == null || (maybeboard2 = mTDeckLists4.getMaybeboard()) == null) ? null : Integer.valueOf(maybeboard2.getId());
                    } else {
                        boolean zAreEqual = Intrinsics.areEqual(listType, "sideboard");
                        DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
                        if (zAreEqual) {
                            MTDeckLists mTDeckLists5 = deckDetailsActivity.currentLists;
                            if (mTDeckLists5 != null && (sideboard2 = mTDeckLists5.getSideboard()) != null) {
                                listid2 = Integer.valueOf(sideboard2.getId());
                            }
                        } else {
                            MTDeckLists mTDeckLists6 = deckDetailsActivity.currentLists;
                            if (mTDeckLists6 == null || (main2 = mTDeckLists6.getMain()) == null) {
                                MTDeck mTDeck4 = DeckDetailsActivity.this.currentDeck;
                                if (mTDeck4 != null) {
                                    listid2 = mTDeck4.getListid();
                                }
                            } else {
                                listid2 = Integer.valueOf(main2.getId());
                            }
                        }
                    }
                    if (listid2 != null) {
                        final int iIntValue2 = listid2.intValue();
                        MTFullCard mTFullCard = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                        mTFullCard.setCardid(card.getCardid());
                        mTFullCard.setScryfallid(null);
                        String set_code = card.getSet_code();
                        if (set_code != null) {
                            lowerCase = set_code.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        } else {
                            lowerCase = null;
                        }
                        mTFullCard.setSet_code(lowerCase);
                        mTFullCard.setCollector_number(card.getCollector_number());
                        mTFullCard.setLang(card.getLang());
                        mTFullCard.setFinish(card.getFinish());
                        String condition = card.getCondition();
                        if (condition == null) {
                            condition = GameUtils.CONDITION_NEAR_MINT;
                        }
                        mTFullCard.setCondition(condition);
                        boolean altered = card.getAltered();
                        if (altered == null) {
                            altered = false;
                        }
                        mTFullCard.setAltered(altered);
                        boolean signed = card.getSigned();
                        if (signed == null) {
                            signed = false;
                        }
                        mTFullCard.setSigned(signed);
                        boolean missprint = card.getMissprint();
                        if (missprint == null) {
                            missprint = false;
                        }
                        mTFullCard.setMissprint(missprint);
                        boolean proxy = card.getProxy();
                        if (proxy == null) {
                            proxy = false;
                        }
                        mTFullCard.setProxy(proxy);
                        MTEditCardBody mTEditCardBody = new MTEditCardBody(null, 1, null);
                        MTEditCardActions mTEditCardActions = new MTEditCardActions(null, null, null, 7, null);
                        mTEditCardActions.setAdded(CollectionsKt.mutableListOf(mTFullCard));
                        mTEditCardBody.setCards(mTEditCardActions);
                        MTUser currentUser = new PreferencesManager(DeckDetailsActivity.this).getCurrentUser();
                        if (currentUser != null) {
                            final DeckDetailsActivity deckDetailsActivity2 = DeckDetailsActivity.this;
                            MTApiKt.getMtApi().editCardsFromList(currentUser.getId(), iIntValue2, null, null, deckDetailsActivity2.currentGroupBy, deckDetailsActivity2.currentSortBy, deckDetailsActivity2.currentSortDirection, true, Boolean.valueOf(deckDetailsActivity2.ignoreCollection), Boolean.valueOf(deckDetailsActivity2.ignoreBasicLands), Boolean.valueOf(deckDetailsActivity2.ignorePrintings), mTEditCardBody).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$showMythicPlusPanel$1$onAddCardToDeck$1$1
                                @Override // retrofit2.Callback
                                public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                                    Intrinsics.checkNotNullParameter(call, "call");
                                    Intrinsics.checkNotNullParameter(t, "t");
                                    Toast.makeText(deckDetailsActivity2, R.string.error_adding_card, 0).show();
                                }

                                @Override // retrofit2.Callback
                                public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                                    MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment;
                                    MTCardContainer maybeboard3;
                                    MTCardContainer sideboard3;
                                    MTCardContainer main3;
                                    Intrinsics.checkNotNullParameter(call, "call");
                                    Intrinsics.checkNotNullParameter(response, "response");
                                    if (!response.isSuccessful()) {
                                        Toast.makeText(deckDetailsActivity2, R.string.error_adding_card, 0).show();
                                        return;
                                    }
                                    MTCardListResponse mTCardListResponseBody = response.body();
                                    MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                                    if (list != null) {
                                        int i2 = iIntValue2;
                                        DeckDetailsActivity deckDetailsActivity3 = deckDetailsActivity2;
                                        MTDeckLists mTDeckLists7 = deckDetailsActivity3.currentLists;
                                        if (mTDeckLists7 == null || (main3 = mTDeckLists7.getMain()) == null || i2 != main3.getId()) {
                                            MTDeckLists mTDeckLists8 = deckDetailsActivity3.currentLists;
                                            if (mTDeckLists8 == null || (sideboard3 = mTDeckLists8.getSideboard()) == null || i2 != sideboard3.getId()) {
                                                MTDeckLists mTDeckLists9 = deckDetailsActivity3.currentLists;
                                                if (mTDeckLists9 != null && (maybeboard3 = mTDeckLists9.getMaybeboard()) != null && i2 == maybeboard3.getId()) {
                                                    MTDeckLists mTDeckLists10 = deckDetailsActivity3.currentLists;
                                                    deckDetailsActivity3.currentLists = mTDeckLists10 != null ? MTDeckLists.copy$default(mTDeckLists10, null, null, list, 3, null) : null;
                                                }
                                            } else {
                                                MTDeckLists mTDeckLists11 = deckDetailsActivity3.currentLists;
                                                deckDetailsActivity3.currentLists = mTDeckLists11 != null ? MTDeckLists.copy$default(mTDeckLists11, null, list, null, 5, null) : null;
                                            }
                                        } else {
                                            MTDeckLists mTDeckLists12 = deckDetailsActivity3.currentLists;
                                            deckDetailsActivity3.currentLists = mTDeckLists12 != null ? MTDeckLists.copy$default(mTDeckLists12, list, null, null, 6, null) : null;
                                            List<MTCardGroup> grouped_cards = list.getGrouped_cards();
                                            if (grouped_cards != null) {
                                                deckDetailsActivity3.currentGroupedCards = grouped_cards;
                                            }
                                        }
                                        List list2 = deckDetailsActivity3.currentGroupedCards;
                                        if (list2 != null) {
                                            deckDetailsActivity3.setupCardsAdapter(list2);
                                        }
                                        deckDetailsActivity3.updateBottomBar();
                                    }
                                    deckDetailsActivity2.deckChangedWhileMythicPlusOpen = true;
                                    String printed_name = card.getPrinted_name();
                                    if (printed_name == null && (printed_name = card.getName()) == null) {
                                        printed_name = "";
                                    }
                                    MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment2 = deckDetailsActivity2.mythicPlusBottomSheet;
                                    if (mythicPlusBottomSheetFragment2 != null) {
                                        mythicPlusBottomSheetFragment2.showAddedToast(printed_name, listType);
                                    }
                                    String oracleid = card.getOracleid();
                                    if (oracleid == null || (mythicPlusBottomSheetFragment = deckDetailsActivity2.mythicPlusBottomSheet) == null) {
                                        return;
                                    }
                                    mythicPlusBottomSheetFragment.markCardAsAdded(oracleid);
                                }
                            });
                        }
                    }
                }

                @Override // com.studiolaganne.lengendarylens.MythicPlusCallback
                public void onConvertSmartDeck() {
                    DeckDetailsActivity.this.showConvertSmartDeckDialog();
                }

                @Override // com.studiolaganne.lengendarylens.MythicPlusCallback
                public void onDeckChanged() {
                    if (DeckDetailsActivity.this.isFinishing() || DeckDetailsActivity.this.isDestroyed()) {
                        return;
                    }
                    DeckDetailsActivity.this.refreshDeckCards();
                    DeckDetailsActivity.this.updateBottomBar();
                    DeckDetailsActivity.this.deckChangedWhileMythicPlusOpen = true;
                }

                @Override // com.studiolaganne.lengendarylens.MythicPlusCallback
                public void onMoveCard(final MTFullCard card, final String listType) {
                    Integer list_card_id;
                    int iIntValue2;
                    MTDeckLists mTDeckLists4;
                    MTCardContainer maybeboard2;
                    MTCardContainer sideboard2;
                    MTCardContainer main2;
                    Intrinsics.checkNotNullParameter(card, "card");
                    Intrinsics.checkNotNullParameter(listType, "listType");
                    if (DeckDetailsActivity.this.isFinishing() || DeckDetailsActivity.this.isDestroyed() || (list_card_id = card.getList_card_id()) == null) {
                        return;
                    }
                    int iIntValue3 = list_card_id.intValue();
                    MTDeckLists mTDeckLists5 = DeckDetailsActivity.this.currentLists;
                    Integer numValueOf = null;
                    if (mTDeckLists5 == null || (main2 = mTDeckLists5.getMain()) == null) {
                        MTDeck mTDeck4 = DeckDetailsActivity.this.currentDeck;
                        Integer listid2 = mTDeck4 != null ? mTDeck4.getListid() : null;
                        if (listid2 == null) {
                            return;
                        } else {
                            iIntValue2 = listid2.intValue();
                        }
                    } else {
                        iIntValue2 = main2.getId();
                    }
                    int i2 = iIntValue2;
                    if (Intrinsics.areEqual(listType, "sideboard")) {
                        MTDeckLists mTDeckLists6 = DeckDetailsActivity.this.currentLists;
                        if (mTDeckLists6 != null && (sideboard2 = mTDeckLists6.getSideboard()) != null) {
                            numValueOf = Integer.valueOf(sideboard2.getId());
                        }
                    } else if (Intrinsics.areEqual(listType, "maybeboard") && (mTDeckLists4 = DeckDetailsActivity.this.currentLists) != null && (maybeboard2 = mTDeckLists4.getMaybeboard()) != null) {
                        numValueOf = Integer.valueOf(maybeboard2.getId());
                    }
                    if (numValueOf != null) {
                        int iIntValue4 = numValueOf.intValue();
                        MTUser currentUser = new PreferencesManager(DeckDetailsActivity.this).getCurrentUser();
                        if (currentUser == null) {
                            return;
                        }
                        Call<MTMoveCardsResponse> callMoveCardsFromList = MTApiKt.getMtApi().moveCardsFromList(currentUser.getId(), i2, null, null, DeckDetailsActivity.this.currentGroupBy, DeckDetailsActivity.this.currentSortBy, DeckDetailsActivity.this.currentSortDirection, Boolean.valueOf(DeckDetailsActivity.this.ignoreCollection), Boolean.valueOf(DeckDetailsActivity.this.ignoreBasicLands), Boolean.valueOf(DeckDetailsActivity.this.ignorePrintings), new MTMoveCardsBody(iIntValue4, CollectionsKt.listOf(new MTCardReference(iIntValue3))));
                        final DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
                        callMoveCardsFromList.enqueue(new Callback<MTMoveCardsResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$showMythicPlusPanel$1$onMoveCard$1
                            @Override // retrofit2.Callback
                            public void onFailure(Call<MTMoveCardsResponse> call, Throwable t) {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(t, "t");
                            }

                            @Override // retrofit2.Callback
                            public void onResponse(Call<MTMoveCardsResponse> call, Response<MTMoveCardsResponse> response) {
                                MTMoveCardsResponse mTMoveCardsResponseBody;
                                MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment;
                                MTCardContainer source;
                                MTCardContainer target;
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(response, "response");
                                if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed() || !response.isSuccessful() || (mTMoveCardsResponseBody = response.body()) == null || !mTMoveCardsResponseBody.getSuccess()) {
                                    return;
                                }
                                MTMoveCardsResponse mTMoveCardsResponseBody2 = response.body();
                                if (mTMoveCardsResponseBody2 != null && (target = mTMoveCardsResponseBody2.getTarget()) != null) {
                                    deckDetailsActivity.refreshCurrentList(target.getId());
                                }
                                MTMoveCardsResponse mTMoveCardsResponseBody3 = response.body();
                                if (mTMoveCardsResponseBody3 != null && (source = mTMoveCardsResponseBody3.getSource()) != null) {
                                    deckDetailsActivity.refreshCurrentList(source.getId());
                                }
                                String printed_name = card.getPrinted_name();
                                if (printed_name == null && (printed_name = card.getName()) == null) {
                                    printed_name = "";
                                }
                                int i3 = Intrinsics.areEqual(listType, "sideboard") ? R.string.eval_moved_to_sideboard : R.string.eval_moved_to_maybeboard;
                                MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment2 = deckDetailsActivity.mythicPlusBottomSheet;
                                if (mythicPlusBottomSheetFragment2 != null) {
                                    String string = deckDetailsActivity.getString(i3, new Object[]{printed_name});
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                    mythicPlusBottomSheetFragment2.showToast(string);
                                }
                                String oracleid = card.getOracleid();
                                if (oracleid != null && (mythicPlusBottomSheetFragment = deckDetailsActivity.mythicPlusBottomSheet) != null) {
                                    mythicPlusBottomSheetFragment.markCardAsActed(oracleid);
                                }
                                deckDetailsActivity.deckChangedWhileMythicPlusOpen = true;
                            }
                        });
                    }
                }

                @Override // com.studiolaganne.lengendarylens.MythicPlusCallback
                public void onMythicPlusClosed() {
                    if (DeckDetailsActivity.this.deckChangedWhileMythicPlusOpen) {
                        DeckDetailsActivity.this.deckChangedWhileMythicPlusOpen = false;
                        DeckDetailsActivity.this.fetchDeckIdCardIfNeeded(true);
                        DeckDetailsActivity.this.updateBottomBar();
                    }
                }

                @Override // com.studiolaganne.lengendarylens.MythicPlusCallback
                public void onRemoveCardFromDeck(final MTFullCard card) {
                    Integer list_card_id;
                    int iIntValue2;
                    MTCardContainer main2;
                    Intrinsics.checkNotNullParameter(card, "card");
                    if (DeckDetailsActivity.this.isFinishing() || DeckDetailsActivity.this.isDestroyed() || (list_card_id = card.getList_card_id()) == null) {
                        return;
                    }
                    int iIntValue3 = list_card_id.intValue();
                    MTDeckLists mTDeckLists4 = DeckDetailsActivity.this.currentLists;
                    if (mTDeckLists4 == null || (main2 = mTDeckLists4.getMain()) == null) {
                        MTDeck mTDeck4 = DeckDetailsActivity.this.currentDeck;
                        Integer listid2 = mTDeck4 != null ? mTDeck4.getListid() : null;
                        if (listid2 == null) {
                            return;
                        } else {
                            iIntValue2 = listid2.intValue();
                        }
                    } else {
                        iIntValue2 = main2.getId();
                    }
                    final int i2 = iIntValue2;
                    MTUser currentUser = new PreferencesManager(DeckDetailsActivity.this).getCurrentUser();
                    if (currentUser == null) {
                        return;
                    }
                    Call callRemoveCardsFromList$default = MTApi.removeCardsFromList$default(MTApiKt.getMtApi(), currentUser.getId(), i2, null, null, DeckDetailsActivity.this.currentGroupBy, DeckDetailsActivity.this.currentSortBy, DeckDetailsActivity.this.currentSortDirection, null, null, null, true, new MTRemoveCardsBody(CollectionsKt.listOf(new MTCardReference(iIntValue3))), 908, null);
                    final DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
                    callRemoveCardsFromList$default.enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$showMythicPlusPanel$1$onRemoveCardFromDeck$1
                        @Override // retrofit2.Callback
                        public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(t, "t");
                        }

                        @Override // retrofit2.Callback
                        public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                            MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment;
                            MTCardContainer maybeboard2;
                            MTCardContainer sideboard2;
                            MTCardContainer main3;
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(response, "response");
                            if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed() || !response.isSuccessful()) {
                                return;
                            }
                            MTCardListResponse mTCardListResponseBody = response.body();
                            MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                            if (list != null) {
                                int i3 = i2;
                                DeckDetailsActivity deckDetailsActivity2 = deckDetailsActivity;
                                MTDeckLists mTDeckLists5 = deckDetailsActivity2.currentLists;
                                if (mTDeckLists5 == null || (main3 = mTDeckLists5.getMain()) == null || i3 != main3.getId()) {
                                    MTDeckLists mTDeckLists6 = deckDetailsActivity2.currentLists;
                                    if (mTDeckLists6 == null || (sideboard2 = mTDeckLists6.getSideboard()) == null || i3 != sideboard2.getId()) {
                                        MTDeckLists mTDeckLists7 = deckDetailsActivity2.currentLists;
                                        if (mTDeckLists7 != null && (maybeboard2 = mTDeckLists7.getMaybeboard()) != null && i3 == maybeboard2.getId()) {
                                            MTDeckLists mTDeckLists8 = deckDetailsActivity2.currentLists;
                                            deckDetailsActivity2.currentLists = mTDeckLists8 != null ? MTDeckLists.copy$default(mTDeckLists8, null, null, list, 3, null) : null;
                                        }
                                    } else {
                                        MTDeckLists mTDeckLists9 = deckDetailsActivity2.currentLists;
                                        deckDetailsActivity2.currentLists = mTDeckLists9 != null ? MTDeckLists.copy$default(mTDeckLists9, null, list, null, 5, null) : null;
                                    }
                                } else {
                                    MTDeckLists mTDeckLists10 = deckDetailsActivity2.currentLists;
                                    deckDetailsActivity2.currentLists = mTDeckLists10 != null ? MTDeckLists.copy$default(mTDeckLists10, list, null, null, 6, null) : null;
                                    List<MTCardGroup> grouped_cards = list.getGrouped_cards();
                                    if (grouped_cards != null) {
                                        deckDetailsActivity2.currentGroupedCards = grouped_cards;
                                    }
                                }
                                List list2 = deckDetailsActivity2.currentGroupedCards;
                                if (list2 != null) {
                                    deckDetailsActivity2.setupCardsAdapter(list2);
                                }
                                deckDetailsActivity2.updateBottomBar();
                            }
                            String printed_name = card.getPrinted_name();
                            if (printed_name == null && (printed_name = card.getName()) == null) {
                                printed_name = "";
                            }
                            MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment2 = deckDetailsActivity.mythicPlusBottomSheet;
                            if (mythicPlusBottomSheetFragment2 != null) {
                                String string = deckDetailsActivity.getString(R.string.eval_removed_from_deck, new Object[]{printed_name});
                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                mythicPlusBottomSheetFragment2.showToast(string);
                            }
                            String oracleid = card.getOracleid();
                            if (oracleid != null && (mythicPlusBottomSheetFragment = deckDetailsActivity.mythicPlusBottomSheet) != null) {
                                mythicPlusBottomSheetFragment.markCardAsActed(oracleid);
                            }
                            deckDetailsActivity.refreshDeckCards();
                            deckDetailsActivity.deckChangedWhileMythicPlusOpen = true;
                        }
                    });
                }

                @Override // com.studiolaganne.lengendarylens.MythicPlusCallback
                public void onSubscribeMythicPlus(String location) {
                    Intrinsics.checkNotNullParameter(location, "location");
                    MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment = DeckDetailsActivity.this.mythicPlusBottomSheet;
                    if (mythicPlusBottomSheetFragment != null) {
                        mythicPlusBottomSheetFragment.hide();
                    }
                    DeckDetailsActivity.this.showPaywallInfo(location);
                }
            });
        }
        MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment = this.mythicPlusBottomSheet;
        if (mythicPlusBottomSheetFragment == null || !mythicPlusBottomSheetFragment.isAdded()) {
            MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment2 = this.mythicPlusBottomSheet;
            if (mythicPlusBottomSheetFragment2 != null) {
                mythicPlusBottomSheetFragment2.show(getSupportFragmentManager(), "MythicPlus");
                return;
            }
            return;
        }
        MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment3 = this.mythicPlusBottomSheet;
        if (mythicPlusBottomSheetFragment3 != null) {
            mythicPlusBottomSheetFragment3.setManuallyHidden(false);
        }
        MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment4 = this.mythicPlusBottomSheet;
        if (mythicPlusBottomSheetFragment4 == null || (dialog = mythicPlusBottomSheetFragment4.getDialog()) == null) {
            return;
        }
        dialog.show();
    }

    private final void showPartialCombosSortPopup(View anchor) {
        PopupMenu popupMenu = new PopupMenu(this, anchor);
        popupMenu.getMenuInflater().inflate(R.menu.sort_combos_menu, popupMenu.getMenu());
        MenuItem menuItemFindItem = popupMenu.getMenu().findItem(R.id.sort_combos_popularity);
        if (menuItemFindItem != null) {
            menuItemFindItem.setChecked(Intrinsics.areEqual(this.partialCombosSortBy, "popularity"));
        }
        MenuItem menuItemFindItem2 = popupMenu.getMenu().findItem(R.id.sort_combos_missing_cards);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setChecked(Intrinsics.areEqual(this.partialCombosSortBy, "missing_cards"));
        }
        MenuItem menuItemFindItem3 = popupMenu.getMenu().findItem(R.id.sort_combos_total_cards);
        if (menuItemFindItem3 != null) {
            menuItemFindItem3.setChecked(Intrinsics.areEqual(this.partialCombosSortBy, "total_cards"));
        }
        MenuItem menuItemFindItem4 = popupMenu.getMenu().findItem(R.id.sort_combos_ascending);
        if (menuItemFindItem4 != null) {
            menuItemFindItem4.setChecked(this.partialCombosSortAsc);
        }
        MenuItem menuItemFindItem5 = popupMenu.getMenu().findItem(R.id.sort_combos_descending);
        if (menuItemFindItem5 != null) {
            menuItemFindItem5.setChecked(!this.partialCombosSortAsc);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda104
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return DeckDetailsActivity.showPartialCombosSortPopup$lambda$0(this.f$0, menuItem);
            }
        });
        popupMenu.show();
    }

    static final boolean showPartialCombosSortPopup$lambda$0(DeckDetailsActivity deckDetailsActivity, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.sort_combos_popularity) {
            deckDetailsActivity.partialCombosSortBy = "popularity";
        } else if (itemId == R.id.sort_combos_missing_cards) {
            deckDetailsActivity.partialCombosSortBy = "missing_cards";
        } else if (itemId == R.id.sort_combos_total_cards) {
            deckDetailsActivity.partialCombosSortBy = "total_cards";
        } else if (itemId == R.id.sort_combos_ascending) {
            deckDetailsActivity.partialCombosSortAsc = true;
        } else if (itemId == R.id.sort_combos_descending) {
            deckDetailsActivity.partialCombosSortAsc = false;
        }
        deckDetailsActivity.partialCombosPagesLoaded = 1;
        deckDetailsActivity.refreshCombosDisplay();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPaywallInfo(final String carousel) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        MythicPlusInfoDialogFragment.Companion.show$default(MythicPlusInfoDialogFragment.INSTANCE, this, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda149
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.showPaywallInfo$lambda$0(this.f$0, carousel);
            }
        }, null, 4, null);
    }

    static final Unit showPaywallInfo$lambda$0(DeckDetailsActivity deckDetailsActivity, String str) {
        deckDetailsActivity.launchPaywall(str);
        return Unit.INSTANCE;
    }

    private final void showSharedStatsDialog(MTSharedStats sharedStats) {
        String rate;
        MTDeck mTDeck = this.currentDeck;
        if (mTDeck == null) {
            return;
        }
        DeckDetailsActivity deckDetailsActivity = this;
        final Dialog dialog = new Dialog(deckDetailsActivity);
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
        View viewInflate = LayoutInflater.from(deckDetailsActivity).inflate(R.layout.dialog_shared_stats, (ViewGroup) null);
        dialog.setContentView(viewInflate);
        viewInflate.findViewById(R.id.shared_stats_overlay).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda66
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        viewInflate.findViewById(R.id.shared_stats_card).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda77
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeckDetailsActivity.showSharedStatsDialog$lambda$1(view);
            }
        });
        viewInflate.findViewById(R.id.sharedStatsDialogClose).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda88
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        TextView textView = (TextView) viewInflate.findViewById(R.id.sharedStatsDialogWinrate);
        if (sharedStats.getGames() == 0) {
            textView.setText("--");
            textView.setTextColor(ContextCompat.getColor(deckDetailsActivity, R.color.text_color));
        } else {
            try {
                float f = Float.parseFloat(sharedStats.getRate());
                if (Math.abs(f) <= Float.MAX_VALUE) {
                    textView.setText(MathKt.roundToInt(f) + "%");
                    textView.setTextColor(GameUtils.INSTANCE.getInstance().getWinRateColor(this, f, Integer.valueOf(mTDeck.getFormatid())));
                } else {
                    textView.setText("--");
                    textView.setTextColor(ContextCompat.getColor(this, R.color.text_color));
                }
            } catch (NumberFormatException unused) {
                textView.setText("--");
                textView.setTextColor(ContextCompat.getColor(deckDetailsActivity, R.color.text_color));
            }
        }
        String string = getString(sharedStats.getGames() == 1 ? R.string.games_singular : R.string.games_plural);
        Intrinsics.checkNotNull(string);
        ((TextView) viewInflate.findViewById(R.id.sharedStatsDialogNumGames)).setText(sharedStats.getGames() + " " + string);
        ((TextView) viewInflate.findViewById(R.id.sharedStatsDialogWins)).setText(String.valueOf(sharedStats.getWins()));
        ((TextView) viewInflate.findViewById(R.id.sharedStatsDialogLosses)).setText(String.valueOf(sharedStats.getLosses()));
        ((TextView) viewInflate.findViewById(R.id.sharedStatsDialogDraws)).setText(String.valueOf(sharedStats.getDraws()));
        List<MTSharedPlayer> players = sharedStats.getPlayers();
        int size = (players != null ? players.size() : 0) + (!isOtherUserDeck() ? 1 : 0);
        ((TextView) viewInflate.findViewById(R.id.sharedStatsDialogPlayerCount)).setText(getResources().getString(size == 1 ? R.string.player_singular : R.string.players_plural_count, Integer.valueOf(size)));
        ArrayList arrayList = new ArrayList();
        if (!isOtherUserDeck()) {
            MTUser currentUser = new PreferencesManager(deckDetailsActivity).getCurrentUser();
            MTStats stats = mTDeck.getStats();
            if (stats != null) {
                arrayList.add(new SharedStatsPlayerItem(currentUser != null ? currentUser.getPicture() : null, currentUser != null ? currentUser.getFirstname() : null, currentUser != null ? currentUser.getUsername() : null, stats.getWins(), stats.getLosses(), stats.getDraws(), stats.getGames(), stats.getRate(), Integer.valueOf(mTDeck.getFormatid())));
            }
        }
        List<MTSharedPlayer> players2 = sharedStats.getPlayers();
        if (players2 != null) {
            for (MTSharedPlayer mTSharedPlayer : players2) {
                String picture = mTSharedPlayer.getPicture();
                String firstname = mTSharedPlayer.getFirstname();
                String username = mTSharedPlayer.getUsername();
                MTSharedPlayerStats stats2 = mTSharedPlayer.getStats();
                int wins = stats2 != null ? stats2.getWins() : 0;
                MTSharedPlayerStats stats3 = mTSharedPlayer.getStats();
                int losses = stats3 != null ? stats3.getLosses() : 0;
                MTSharedPlayerStats stats4 = mTSharedPlayer.getStats();
                int draws = stats4 != null ? stats4.getDraws() : 0;
                MTSharedPlayerStats stats5 = mTSharedPlayer.getStats();
                int games = stats5 != null ? stats5.getGames() : 0;
                MTSharedPlayerStats stats6 = mTSharedPlayer.getStats();
                if (stats6 == null || (rate = stats6.getRate()) == null) {
                    rate = "0.0";
                }
                arrayList.add(new SharedStatsPlayerItem(picture, firstname, username, wins, losses, draws, games, rate, Integer.valueOf(mTDeck.getFormatid())));
            }
        }
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.sharedStatsPlayerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(deckDetailsActivity));
        recyclerView.setAdapter(new SharedStatsPlayerAdapter(deckDetailsActivity, arrayList));
        dialog.show();
        Window window3 = dialog.getWindow();
        if (window3 != null) {
            window3.setLayout(-1, -1);
        }
    }

    static final void showSharedStatsDialog$lambda$1(View view) {
    }

    private final void showSmartDeckTeaser(MTDeck deck) {
        DeckIdCardArcGaugeView deckIdCardArcGaugeView;
        DeckIdCardArcGaugeView deckIdCardArcGaugeView2;
        DeckIdCardArcGaugeView deckIdCardArcGaugeView3;
        DeckIdCardArcGaugeView deckIdCardArcGaugeView4;
        TextView textView;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.deckIdCardScoresRow);
        if (linearLayout == null || (deckIdCardArcGaugeView = (DeckIdCardArcGaugeView) findViewById(R.id.deckScoreGaugeGlobal)) == null || (deckIdCardArcGaugeView2 = (DeckIdCardArcGaugeView) findViewById(R.id.deckScoreGaugePower)) == null || (deckIdCardArcGaugeView3 = (DeckIdCardArcGaugeView) findViewById(R.id.deckScoreGaugeMana)) == null || (deckIdCardArcGaugeView4 = (DeckIdCardArcGaugeView) findViewById(R.id.deckScoreGaugeHealth)) == null || (textView = (TextView) findViewById(R.id.smartDeckConvertButton)) == null) {
            return;
        }
        int iArgb = Color.argb(15, 255, 255, 255);
        final boolean zAreEqual = Intrinsics.areEqual((Object) deck.getHas_smart_deck(), (Object) true);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeckDetailsActivity.showSmartDeckTeaser$lambda$0(zAreEqual, this, view);
            }
        };
        for (DeckIdCardArcGaugeView deckIdCardArcGaugeView5 : CollectionsKt.listOf((Object[]) new DeckIdCardArcGaugeView[]{deckIdCardArcGaugeView, deckIdCardArcGaugeView2, deckIdCardArcGaugeView3, deckIdCardArcGaugeView4})) {
            deckIdCardArcGaugeView5.cancelScoreAnimation();
            deckIdCardArcGaugeView5.setCenterMode(DeckIdCardGaugeCenterMode.QUESTION_MARK);
            deckIdCardArcGaugeView5.setTrackColor(iArgb);
            deckIdCardArcGaugeView5.setOnClickListener(onClickListener);
        }
        String string = getString(R.string.deck_id_card_score_global);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        deckIdCardArcGaugeView.setGaugeLabel(string);
        deckIdCardArcGaugeView.setFillColor(DeckIdCardScoreColors.MYTHIC_BLUE);
        deckIdCardArcGaugeView.setScorePercentImmediate(72);
        String string2 = getString(R.string.deck_id_card_score_power);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        deckIdCardArcGaugeView2.setGaugeLabel(string2);
        deckIdCardArcGaugeView2.setFillColor(DeckIdCardScoreColors.INSTANCE.powerLevelColor(58));
        deckIdCardArcGaugeView2.setScorePercentImmediate(58);
        String string3 = getString(R.string.deck_id_card_score_mana);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        deckIdCardArcGaugeView3.setGaugeLabel(string3);
        deckIdCardArcGaugeView3.setFillColor(DeckIdCardScoreColors.INSTANCE.healthBandColor(81));
        deckIdCardArcGaugeView3.setScorePercentImmediate(81);
        String string4 = getString(R.string.deck_id_card_score_health);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        deckIdCardArcGaugeView4.setGaugeLabel(string4);
        deckIdCardArcGaugeView4.setFillColor(DeckIdCardScoreColors.INSTANCE.healthBandColor(65));
        deckIdCardArcGaugeView4.setScorePercentImmediate(65);
        linearLayout.setVisibility(0);
        textView.setText(getString(zAreEqual ? R.string.smart_deck_convert_subscribe : R.string.smart_deck_convert_free));
        textView.setVisibility(0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeckDetailsActivity.showSmartDeckTeaser$lambda$2(zAreEqual, this, view);
            }
        });
    }

    static final void showSmartDeckTeaser$lambda$0(boolean z, DeckDetailsActivity deckDetailsActivity, View view) {
        if (z) {
            deckDetailsActivity.showPaywallInfo("analysis");
        } else {
            deckDetailsActivity.showConvertSmartDeckDialog();
        }
    }

    static final void showSmartDeckTeaser$lambda$2(boolean z, DeckDetailsActivity deckDetailsActivity, View view) {
        if (z) {
            deckDetailsActivity.showPaywallInfo("analysis");
        } else {
            deckDetailsActivity.showConvertSmartDeckDialog();
        }
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
        PopupMenu popupMenu = new PopupMenu(this, anchor);
        popupMenu.getMenuInflater().inflate(R.menu.sort_by_menu, popupMenu.getMenu());
        String str = this.currentSortBy;
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
            case -1034364087:
                if (str.equals("number") && (menuItemFindItem4 = popupMenu.getMenu().findItem(R.id.sort_number)) != null) {
                    menuItemFindItem4.setChecked(true);
                }
                break;
            case -938161749:
                if (str.equals("rarity") && (menuItemFindItem5 = popupMenu.getMenu().findItem(R.id.sort_rarity)) != null) {
                    menuItemFindItem5.setChecked(true);
                }
                break;
            case -904257739:
                if (str.equals("altered") && (menuItemFindItem6 = popupMenu.getMenu().findItem(R.id.sort_altered)) != null) {
                    menuItemFindItem6.setChecked(true);
                }
                break;
            case -902467812:
                if (str.equals("signed") && (menuItemFindItem7 = popupMenu.getMenu().findItem(R.id.sort_signed)) != null) {
                    menuItemFindItem7.setChecked(true);
                }
                break;
            case -861311717:
                if (str.equals("condition") && (menuItemFindItem8 = popupMenu.getMenu().findItem(R.id.sort_condition)) != null) {
                    menuItemFindItem8.setChecked(true);
                }
                break;
            case -395678578:
                if (str.equals("total_price") && (menuItemFindItem9 = popupMenu.getMenu().findItem(R.id.sort_total_price)) != null) {
                    menuItemFindItem9.setChecked(true);
                }
                break;
            case 98617:
                if (str.equals("cmc") && (menuItemFindItem10 = popupMenu.getMenu().findItem(R.id.sort_cmc)) != null) {
                    menuItemFindItem10.setChecked(true);
                }
                break;
            case 113762:
                if (str.equals("set") && (menuItemFindItem11 = popupMenu.getMenu().findItem(R.id.sort_set)) != null) {
                    menuItemFindItem11.setChecked(true);
                }
                break;
            case 3148716:
                if (str.equals("foil") && (menuItemFindItem12 = popupMenu.getMenu().findItem(R.id.sort_foil)) != null) {
                    menuItemFindItem12.setChecked(true);
                }
                break;
            case 3373707:
                if (str.equals("name") && (menuItemFindItem13 = popupMenu.getMenu().findItem(R.id.sort_name)) != null) {
                    menuItemFindItem13.setChecked(true);
                }
                break;
            case 106934601:
                if (str.equals(FirebaseAnalytics.Param.PRICE) && (menuItemFindItem14 = popupMenu.getMenu().findItem(R.id.sort_price)) != null) {
                    menuItemFindItem14.setChecked(true);
                }
                break;
            case 106941038:
                if (str.equals("proxy") && (menuItemFindItem15 = popupMenu.getMenu().findItem(R.id.sort_proxy)) != null) {
                    menuItemFindItem15.setChecked(true);
                }
                break;
            case 1250446129:
                if (str.equals("missprint") && (menuItemFindItem16 = popupMenu.getMenu().findItem(R.id.sort_printing_error)) != null) {
                    menuItemFindItem16.setChecked(true);
                }
                break;
        }
        String str2 = this.currentSortDirection;
        if (Intrinsics.areEqual(str2, "asc")) {
            MenuItem menuItemFindItem17 = popupMenu.getMenu().findItem(R.id.sort_ascending);
            if (menuItemFindItem17 != null) {
                menuItemFindItem17.setChecked(true);
            }
        } else if (Intrinsics.areEqual(str2, "desc") && (menuItemFindItem = popupMenu.getMenu().findItem(R.id.sort_descending)) != null) {
            menuItemFindItem.setChecked(true);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda178
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return DeckDetailsActivity.showSortByPopupMenu$lambda$0(this.f$0, menuItem);
            }
        });
        popupMenu.show();
    }

    static final boolean showSortByPopupMenu$lambda$0(DeckDetailsActivity deckDetailsActivity, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.sort_quantity) {
            deckDetailsActivity.currentSortBy = FirebaseAnalytics.Param.QUANTITY;
        } else if (itemId == R.id.sort_cmc) {
            deckDetailsActivity.currentSortBy = "cmc";
        } else if (itemId == R.id.sort_rarity) {
            deckDetailsActivity.currentSortBy = "rarity";
        } else if (itemId == R.id.sort_foil) {
            deckDetailsActivity.currentSortBy = "foil";
        } else if (itemId == R.id.sort_name) {
            deckDetailsActivity.currentSortBy = "name";
        } else if (itemId == R.id.sort_set) {
            deckDetailsActivity.currentSortBy = "set";
        } else if (itemId == R.id.sort_number) {
            deckDetailsActivity.currentSortBy = "number";
        } else if (itemId == R.id.sort_condition) {
            deckDetailsActivity.currentSortBy = "condition";
        } else if (itemId == R.id.sort_language) {
            deckDetailsActivity.currentSortBy = "language";
        } else if (itemId == R.id.sort_price) {
            deckDetailsActivity.currentSortBy = FirebaseAnalytics.Param.PRICE;
        } else if (itemId == R.id.sort_total_price) {
            deckDetailsActivity.currentSortBy = "total_price";
        } else if (itemId == R.id.sort_altered) {
            deckDetailsActivity.currentSortBy = "altered";
        } else if (itemId == R.id.sort_signed) {
            deckDetailsActivity.currentSortBy = "signed";
        } else if (itemId == R.id.sort_printing_error) {
            deckDetailsActivity.currentSortBy = "missprint";
        } else if (itemId == R.id.sort_proxy) {
            deckDetailsActivity.currentSortBy = "proxy";
        } else if (itemId == R.id.sort_ascending) {
            deckDetailsActivity.currentSortDirection = "asc";
        } else if (itemId == R.id.sort_descending) {
            deckDetailsActivity.currentSortDirection = "desc";
        }
        deckDetailsActivity.refreshDeckCards();
        PreferencesManager preferencesManager = new PreferencesManager(deckDetailsActivity);
        preferencesManager.setLastDeckListOrderBy(deckDetailsActivity.currentSortBy);
        preferencesManager.setLastDeckListOrderDirection(deckDetailsActivity.currentSortDirection);
        PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
        return true;
    }

    private final void showUpdateToCheapestDialog() {
        MTCardContainer main;
        DeckDetailsActivity deckDetailsActivity = this;
        MTUser currentUser = new PreferencesManager(deckDetailsActivity).getCurrentUser();
        if (currentUser != null) {
            final int id = currentUser.getId();
            MTDeckLists mTDeckLists = this.currentLists;
            if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null) {
                return;
            }
            final int id2 = main.getId();
            final Dialog dialog = new Dialog(deckDetailsActivity);
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
            View viewInflate = LayoutInflater.from(deckDetailsActivity).inflate(R.layout.dialog_update_to_cheapest, (ViewGroup) null);
            dialog.setContentView(viewInflate);
            final Map mapMapOf = MapsKt.mapOf(TuplesKt.to(viewInflate.findViewById(R.id.checkEn), "en"), TuplesKt.to(viewInflate.findViewById(R.id.checkFr), "fr"), TuplesKt.to(viewInflate.findViewById(R.id.checkEs), "es"), TuplesKt.to(viewInflate.findViewById(R.id.checkDe), "de"), TuplesKt.to(viewInflate.findViewById(R.id.checkIt), "it"), TuplesKt.to(viewInflate.findViewById(R.id.checkPt), "pt"), TuplesKt.to(viewInflate.findViewById(R.id.checkJa), "ja"), TuplesKt.to(viewInflate.findViewById(R.id.checkKo), "ko"), TuplesKt.to(viewInflate.findViewById(R.id.checkZht), "zht"), TuplesKt.to(viewInflate.findViewById(R.id.checkZhs), "zhs"), TuplesKt.to(viewInflate.findViewById(R.id.checkRu), "ru"));
            viewInflate.findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda160
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            viewInflate.findViewById(R.id.updateButton).setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda161
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DeckDetailsActivity.showUpdateToCheapestDialog$lambda$1(mapMapOf, dialog, this, id, id2, view);
                }
            });
            dialog.show();
            Window window3 = dialog.getWindow();
            if (window3 != null) {
                window3.setLayout(-1, -2);
            }
        }
    }

    static final void showUpdateToCheapestDialog$lambda$1(Map map, Dialog dialog, final DeckDetailsActivity deckDetailsActivity, int i, int i2, View view) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (((CheckBox) entry.getKey()).isChecked()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getValue());
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
        if (strJoinToString$default.length() == 0) {
            strJoinToString$default = null;
        }
        dialog.dismiss();
        deckDetailsActivity.showLoadingOverlay();
        MTApiKt.getMtApi().updateListToCheapest(i, i2, deckDetailsActivity.currentSortBy, deckDetailsActivity.currentSortDirection, deckDetailsActivity.currentGroupBy, strJoinToString$default, Boolean.valueOf(deckDetailsActivity.ignoreBasicLands)).enqueue(new Callback<MTUpdateToCheapestResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$showUpdateToCheapestDialog$2$1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTUpdateToCheapestResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                    return;
                }
                this.this$0.hideLoadingOverlay();
                Toast.makeText(this.this$0, R.string.update_to_cheapest_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTUpdateToCheapestResponse> call, Response<MTUpdateToCheapestResponse> response) {
                MTCheapestResult result;
                MTCheapestDeckResult deck;
                MTDeckValues values;
                MTDeck mTDeck;
                MTCardContainer list;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                    return;
                }
                if (response.isSuccessful()) {
                    MTUpdateToCheapestResponse mTUpdateToCheapestResponseBody = response.body();
                    if (mTUpdateToCheapestResponseBody != null && (list = mTUpdateToCheapestResponseBody.getList()) != null) {
                        DeckDetailsActivity deckDetailsActivity2 = this.this$0;
                        MTDeckLists mTDeckLists = deckDetailsActivity2.currentLists;
                        deckDetailsActivity2.currentLists = mTDeckLists != null ? MTDeckLists.copy$default(mTDeckLists, list, null, null, 6, null) : null;
                        List<MTCardGroup> grouped_cards = list.getGrouped_cards();
                        if (grouped_cards != null) {
                            deckDetailsActivity2.currentGroupedCards = grouped_cards;
                        }
                        List list2 = deckDetailsActivity2.currentGroupedCards;
                        if (list2 != null) {
                            deckDetailsActivity2.setupCardsAdapter(list2);
                        }
                    }
                    MTUpdateToCheapestResponse mTUpdateToCheapestResponseBody2 = response.body();
                    if (mTUpdateToCheapestResponseBody2 != null && (result = mTUpdateToCheapestResponseBody2.getResult()) != null && (deck = result.getDeck()) != null && (values = deck.getValues()) != null && (mTDeck = this.this$0.currentDeck) != null) {
                        mTDeck.setValues(values);
                    }
                    this.this$0.updateBottomBar();
                    Toast.makeText(this.this$0, R.string.update_to_cheapest_success, 0).show();
                } else {
                    Toast.makeText(this.this$0, R.string.update_to_cheapest_error, 0).show();
                }
                this.this$0.hideLoadingOverlay();
            }
        });
    }

    private final void submitDescription(final String description) {
        MTDeck mTDeck;
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        if (currentUser == null || (mTDeck = this.currentDeck) == null) {
            return;
        }
        final View viewFindViewById = findViewById(R.id.overlay);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
        MTApiKt.getMtApi().updateDeckDescription(currentUser.getId(), mTDeck.getId(), new MTDescriptionBody(description)).enqueue(new Callback<MTDescriptionResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity.submitDescription.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTDescriptionResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (DeckDetailsActivity.this.isDestroyed() || DeckDetailsActivity.this.isFinishing()) {
                    return;
                }
                View view = viewFindViewById;
                if (view != null) {
                    view.setVisibility(8);
                }
                DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
                Toast.makeText(deckDetailsActivity, deckDetailsActivity.getString(R.string.server_error), 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTDescriptionResponse> call, Response<MTDescriptionResponse> response) {
                String description2;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (DeckDetailsActivity.this.isDestroyed() || DeckDetailsActivity.this.isFinishing()) {
                    return;
                }
                View view = viewFindViewById;
                if (view != null) {
                    view.setVisibility(8);
                }
                boolean zIsSuccessful = response.isSuccessful();
                DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
                if (!zIsSuccessful) {
                    Toast.makeText(deckDetailsActivity, deckDetailsActivity.getString(R.string.server_error), 0).show();
                    return;
                }
                MTDeck mTDeck2 = deckDetailsActivity.currentDeck;
                if (mTDeck2 != null) {
                    MTDescriptionResponse mTDescriptionResponseBody = response.body();
                    if (mTDescriptionResponseBody == null || (description2 = mTDescriptionResponseBody.getDescription()) == null) {
                        description2 = description;
                    }
                    mTDeck2.setDescription(description2);
                }
                DeckDetailsActivity.this.updateUI();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0094 A[LOOP:0: B:34:0x008e->B:36:0x0094, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void toggleCardSelection(MTFullCard card, int listId) {
        Iterator<T> it;
        Integer num = this.selectionLockedListId;
        if (num == null) {
            this.selectionLockedListId = Integer.valueOf(listId);
        } else if (num == null || listId != num.intValue()) {
            Toast.makeText(this, R.string.select_cards_same_list_only, 0).show();
            return;
        }
        List<Integer> variant_list_card_ids = card.getVariant_list_card_ids();
        if (variant_list_card_ids == null && (variant_list_card_ids = card.getList_card_ids()) == null) {
            variant_list_card_ids = CollectionsKt.listOfNotNull(card.getList_card_id());
        }
        if (variant_list_card_ids.isEmpty()) {
            return;
        }
        List<Integer> list = variant_list_card_ids;
        if ((list instanceof Collection) && list.isEmpty()) {
            it = list.iterator();
            while (it.hasNext()) {
            }
        } else {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (this.selectedCards.containsKey(Integer.valueOf(((Number) it2.next()).intValue()))) {
                    Iterator<T> it3 = list.iterator();
                    while (it3.hasNext()) {
                        this.selectedCards.remove(Integer.valueOf(((Number) it3.next()).intValue()));
                    }
                }
            }
            it = list.iterator();
            while (it.hasNext()) {
                this.selectedCards.put(Integer.valueOf(((Number) it.next()).intValue()), card);
            }
        }
        if (this.selectedCards.isEmpty()) {
            this.selectionLockedListId = null;
        }
        updateSelectionCountText();
        propagateSelectionMode(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleMaybeboardExpansion() {
        this.maybeboardExpanded = !this.maybeboardExpanded;
        updateMaybeboardVisibility();
        if (this.maybeboardExpanded) {
            final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollableLayout);
            View viewFindViewById = findViewById(R.id.maybeboardSection);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            final LinearLayout linearLayout = (LinearLayout) viewFindViewById;
            scrollView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda91
                @Override // java.lang.Runnable
                public final void run() {
                    scrollView.smoothScrollTo(0, linearLayout.getBottom());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleSideboardExpansion() {
        this.sideboardExpanded = !this.sideboardExpanded;
        updateSideboardVisibility();
        if (this.sideboardExpanded) {
            final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollableLayout);
            View viewFindViewById = findViewById(R.id.sideboardSection);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            final LinearLayout linearLayout = (LinearLayout) viewFindViewById;
            scrollView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda105
                @Override // java.lang.Runnable
                public final void run() {
                    DeckDetailsActivity.toggleSideboardExpansion$lambda$0(this.f$0, scrollView, linearLayout);
                }
            });
        }
    }

    static final void toggleSideboardExpansion$lambda$0(final DeckDetailsActivity deckDetailsActivity, final ScrollView scrollView, final LinearLayout linearLayout) {
        View viewFindViewById = deckDetailsActivity.findViewById(R.id.sideboardRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((RecyclerView) viewFindViewById).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda102
            @Override // java.lang.Runnable
            public final void run() {
                DeckDetailsActivity.toggleSideboardExpansion$lambda$0$0(this.f$0, scrollView, linearLayout);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toggleSideboardExpansion$lambda$0$0(DeckDetailsActivity deckDetailsActivity, final ScrollView scrollView, final LinearLayout linearLayout) {
        deckDetailsActivity.adjustSideboardRecyclerViewHeight();
        scrollView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                DeckDetailsActivity.toggleSideboardExpansion$lambda$0$0$0(scrollView, linearLayout);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toggleSideboardExpansion$lambda$0$0$0(ScrollView scrollView, LinearLayout linearLayout) {
        scrollView.smoothScrollTo(0, linearLayout.getBottom());
    }

    private final void updateAddButtonForSmartDeck() {
        if (isOtherUserDeck() || this.isDuplicatedDeck || !this.loaded) {
            return;
        }
        View viewFindViewById = findViewById(R.id.addButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.plusImageView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.legacyAddButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById3;
        MTDeck mTDeck = this.currentDeck;
        if (mTDeck == null || mTDeck.getFormatid() != 6) {
            constraintLayout.setBackgroundResource(R.drawable.floating_button_box);
            imageView.setImageResource(R.drawable.plus_sign);
            imageView.setImageTintList(ContextCompat.getColorStateList(this, R.color.almost_black));
            constraintLayout.setElevation(8.0f);
            this.showLegacyAddButton = false;
            constraintLayout2.setVisibility(8);
            ((CustomGlowView) findViewById(R.id.addButtonGlowView)).setVisibility(8);
            return;
        }
        constraintLayout.setBackgroundResource(R.drawable.floating_button_box_mythic);
        imageView.setImageResource(R.drawable.mythic_plus_small);
        DeckDetailsActivity deckDetailsActivity = this;
        imageView.setImageTintList(ContextCompat.getColorStateList(deckDetailsActivity, R.color.mythic_plus));
        constraintLayout.setElevation(12.0f);
        this.showLegacyAddButton = true;
        constraintLayout2.setVisibility(0);
        CustomGlowView customGlowView = (CustomGlowView) findViewById(R.id.addButtonGlowView);
        customGlowView.setLayerType(1, null);
        customGlowView.setGlowColor(ContextCompat.getColor(deckDetailsActivity, R.color.mythic_plus));
        customGlowView.setGlowSize(GameUtils.INSTANCE.getInstance().dpToPx(16, deckDetailsActivity));
        customGlowView.setAlpha(1.0f);
        customGlowView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBottomBar() {
        if (isDestroyed() || isFinishing()) {
            return;
        }
        MTDeckLists mTDeckLists = this.currentLists;
        if (mTDeckLists == null) {
            updateDeckBottomBarUnknown();
            return;
        }
        MTCardContainer main = mTDeckLists.getMain();
        if (main == null) {
            updateDeckBottomBarUnknown();
            return;
        }
        View viewFindViewById = findViewById(R.id.legalityLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.validDeckIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.validDeckLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.cardCountLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.deckPriceLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        TextView textView3 = (TextView) viewFindViewById5;
        Integer count = main.getCount();
        if (count != null && count.intValue() == 0) {
            textView2.setText(getResources().getString(R.string.no_cards_decks));
        } else if (count != null && count.intValue() == 1) {
            textView2.setText(getResources().getString(R.string.one_card_count));
        } else {
            String string = getResources().getString(R.string.cards_count);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textView2.setText(StringsKt.replace$default(string, "{1}", String.valueOf(count), false, 4, (Object) null));
        }
        textView3.setText(GameUtils.INSTANCE.getInstance().formatContainerTotal(main.getValues(), new PreferencesManager(this).getPreferredCurrency()));
        List<MTListError> errors = main.getErrors();
        if (errors == null) {
            constraintLayout.setBackgroundResource(R.drawable.valid_deck_box);
            imageView.setImageResource(R.drawable.ic_checkmark);
            textView.setText(getResources().getString(R.string.valid_deck));
        } else if (errors.isEmpty()) {
            constraintLayout.setBackgroundResource(R.drawable.valid_deck_box);
            imageView.setImageResource(R.drawable.ic_checkmark);
            textView.setText(getResources().getString(R.string.valid_deck));
        } else {
            constraintLayout.setBackgroundResource(R.drawable.invalid_deck_box);
            imageView.setImageResource(R.drawable.warning);
            textView.setText(getResources().getString(R.string.invalid_deck));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDeck() {
        TextView textView;
        Call<MTDeckResponse> userDeckById;
        if (isDestroyed() || isFinishing()) {
            return;
        }
        final MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        final LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.loadingAnimationViewRecyclerView);
        lottieAnimationView.setVisibility(0);
        View viewFindViewById = findViewById(R.id.noGamesTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.noMatchupsTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final TextView textView3 = (TextView) viewFindViewById2;
        textView3.setVisibility(8);
        textView2.setVisibility(8);
        if (currentUser != null) {
            MTDeck mTDeck = this.currentDeck;
            int id = mTDeck != null ? mTDeck.getId() : this.intentDeckId;
            if (isOtherUserDeck()) {
                MTApi mtApi = MTApiKt.getMtApi();
                int id2 = currentUser.getId();
                int i = this.otherUserId;
                String str = this.currentSortBy;
                String str2 = this.currentSortDirection;
                textView = textView2;
                userDeckById = mtApi.getUserDeckById(id2, i, id, str, this.currentGroupBy, str2, this.filterDefinition.getFormatId(), this.filterDefinition.getSubformatId(), this.filterDefinition.getTagId(), Boolean.valueOf(this.ignoreCollection), Boolean.valueOf(this.ignorePrintings), Boolean.valueOf(this.ignoreBasicLands));
            } else {
                textView = textView2;
                MTApi mtApi2 = MTApiKt.getMtApi();
                int id3 = currentUser.getId();
                int id4 = currentUser.getId();
                String str3 = this.currentSortBy;
                String str4 = this.currentSortDirection;
                userDeckById = mtApi2.getUserDeckById(id3, id4, id, str3, this.currentGroupBy, str4, this.filterDefinition.getFormatId(), this.filterDefinition.getSubformatId(), this.filterDefinition.getTagId(), Boolean.valueOf(this.ignoreCollection), Boolean.valueOf(this.ignorePrintings), Boolean.valueOf(this.ignoreBasicLands));
            }
            final TextView textView4 = textView;
            userDeckById.enqueue(new Callback<MTDeckResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$updateDeck$1$1

                /* JADX INFO: compiled from: DeckDetailsActivity.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[DeckDisplayMode.values().length];
                        try {
                            iArr[DeckDisplayMode.TWO_COLUMN_STACKS.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<MTDeckResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.isDestroyed() || this.this$0.isFinishing()) {
                        return;
                    }
                    Log.e("DeckDetails", "Failed to load deck", t);
                    DeckDetailsActivity deckDetailsActivity = this.this$0;
                    Toast.makeText(deckDetailsActivity, deckDetailsActivity.getString(R.string.deep_link_error), 0).show();
                    this.this$0.finish();
                }

                /* JADX WARN: Removed duplicated region for block: B:131:0x02e9  */
                /* JADX WARN: Removed duplicated region for block: B:134:0x02fa  */
                /* JADX WARN: Removed duplicated region for block: B:150:0x033d  */
                @Override // retrofit2.Callback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResponse(Call<MTDeckResponse> call, Response<MTDeckResponse> response) {
                    MTDeckPrivacyOptions options;
                    MTDeck deck;
                    MTStats stats;
                    MTDeckPrivacyOptions options2;
                    MTDeck deck2;
                    MTCardContainer main;
                    List<MTCardGroup> grouped_cards;
                    MTPrivacyUser owner;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.isDestroyed() || this.this$0.isFinishing()) {
                        return;
                    }
                    this.this$0.loaded = true;
                    lottieAnimationView.setVisibility(8);
                    if (!response.isSuccessful()) {
                        Log.w("DeckDetails", "Failed to load deck: HTTP " + response.code());
                        int iCode = response.code();
                        DeckDetailsActivity deckDetailsActivity = this.this$0;
                        String string = iCode == 404 ? deckDetailsActivity.getString(R.string.deck_not_found) : deckDetailsActivity.getString(R.string.deep_link_error);
                        Intrinsics.checkNotNull(string);
                        Toast.makeText(this.this$0, string, 0).show();
                        this.this$0.finish();
                        return;
                    }
                    MTDeckResponse mTDeckResponseBody = response.body();
                    List<MTMatchupStats> matchups = null;
                    MTDeck deck3 = mTDeckResponseBody != null ? mTDeckResponseBody.getDeck() : null;
                    if (deck3 != null) {
                        final DeckDetailsActivity deckDetailsActivity2 = this.this$0;
                        MTUser mTUser = currentUser;
                        deckDetailsActivity2.currentDeck = deck3;
                        if (deckDetailsActivity2.isOtherUserDeck()) {
                            MTDeckResponse mTDeckResponseBody2 = response.body();
                            if (mTDeckResponseBody2 == null || (owner = mTDeckResponseBody2.getUser()) == null) {
                                owner = deck3.getOwner();
                            }
                            deckDetailsActivity2.deckOwnerUser = owner;
                            deckDetailsActivity2.setupDeckOwnerLayout();
                        } else {
                            MTDeckResponse mTDeckResponseBody3 = response.body();
                            deckDetailsActivity2.deckOwnerUser = (mTDeckResponseBody3 == null || (deck2 = mTDeckResponseBody3.getDeck()) == null) ? null : deck2.getOwner();
                            MTDeckResponse mTDeckResponseBody4 = response.body();
                            deckDetailsActivity2.responseUser = mTDeckResponseBody4 != null ? mTDeckResponseBody4.getUser() : null;
                            MTPrivacyUser mTPrivacyUser = deckDetailsActivity2.deckOwnerUser;
                            if (!(mTPrivacyUser != null && mTPrivacyUser.getId() == mTUser.getId())) {
                                MTPrivacyUser mTPrivacyUser2 = deckDetailsActivity2.responseUser;
                                if (mTPrivacyUser2 != null && mTPrivacyUser2.getId() == mTUser.getId()) {
                                    deckDetailsActivity2.isDuplicatedDeck = true;
                                }
                            }
                            if (deckDetailsActivity2.isDuplicatedDeck) {
                                deckDetailsActivity2.ignoreCollection = true;
                            }
                            View viewFindViewById3 = deckDetailsActivity2.findViewById(R.id.toolbarSettingsIcon);
                            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                            ((TextView) viewFindViewById3).setVisibility((deckDetailsActivity2.isOtherUserDeck() || deckDetailsActivity2.isDuplicatedDeck) ? 8 : 0);
                            View viewFindViewById4 = deckDetailsActivity2.findViewById(R.id.toolbarCollectionStatusView);
                            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                            ((CollectionStatusView) viewFindViewById4).setVisibility((deckDetailsActivity2.ignoreCollection || deckDetailsActivity2.isOtherUserDeck() || deckDetailsActivity2.isDuplicatedDeck) ? 8 : 0);
                            MTPrivacyUser mTPrivacyUser3 = deckDetailsActivity2.deckOwnerUser;
                            if (mTPrivacyUser3 != null && mTPrivacyUser3.getId() == mTUser.getId()) {
                                deckDetailsActivity2.deckOwnerUser = null;
                            }
                            deckDetailsActivity2.setupDeckOwnerLayout();
                        }
                        MTDeckResponse mTDeckResponseBody5 = response.body();
                        deckDetailsActivity2.currentDeckPrivacy = mTDeckResponseBody5 != null ? mTDeckResponseBody5.getPrivacy() : null;
                        if (!deckDetailsActivity2.privacyToolbarSetup) {
                            deckDetailsActivity2.setupPrivacyToolbar();
                            deckDetailsActivity2.privacyToolbarSetup = true;
                        }
                        deckDetailsActivity2.updatePrivacyToolbar(deckDetailsActivity2.currentDeckPrivacy);
                        MTDeckResponse mTDeckResponseBody6 = response.body();
                        MTDeckLists lists = mTDeckResponseBody6 != null ? mTDeckResponseBody6.getLists() : null;
                        deckDetailsActivity2.currentLists = lists;
                        if (lists == null || (main = lists.getMain()) == null || (grouped_cards = main.getGrouped_cards()) == null) {
                            View viewFindViewById5 = deckDetailsActivity2.findViewById(R.id.cardsRecyclerView);
                            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
                            View viewFindViewById6 = deckDetailsActivity2.findViewById(R.id.twoColumnStackedCardsView);
                            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
                            View viewFindViewById7 = deckDetailsActivity2.findViewById(R.id.deckCardsToolbarLayout);
                            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
                            ((LinearLayout) viewFindViewById7).setVisibility(8);
                            ((RecyclerView) viewFindViewById5).setVisibility(8);
                            ((TwoColumnStackedCardsView) viewFindViewById6).setVisibility(8);
                            View viewFindViewById8 = deckDetailsActivity2.findViewById(R.id.noCardsTextView);
                            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
                            ((TextView) viewFindViewById8).setVisibility(0);
                        } else {
                            deckDetailsActivity2.currentGroupedCards = grouped_cards;
                            View viewFindViewById9 = deckDetailsActivity2.findViewById(R.id.cardsRecyclerView);
                            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
                            RecyclerView recyclerView = (RecyclerView) viewFindViewById9;
                            View viewFindViewById10 = deckDetailsActivity2.findViewById(R.id.twoColumnStackedCardsView);
                            Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
                            TwoColumnStackedCardsView twoColumnStackedCardsView = (TwoColumnStackedCardsView) viewFindViewById10;
                            View viewFindViewById11 = deckDetailsActivity2.findViewById(R.id.deckCardsToolbarLayout);
                            Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
                            ((LinearLayout) viewFindViewById11).setVisibility(0);
                            if (WhenMappings.$EnumSwitchMapping$0[deckDetailsActivity2.currentDisplayMode.ordinal()] == 1) {
                                recyclerView.setVisibility(8);
                                twoColumnStackedCardsView.setVisibility(0);
                            } else {
                                recyclerView.setVisibility(0);
                                twoColumnStackedCardsView.setVisibility(8);
                            }
                            View viewFindViewById12 = deckDetailsActivity2.findViewById(R.id.noCardsTextView);
                            Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
                            ((TextView) viewFindViewById12).setVisibility(8);
                            deckDetailsActivity2.setupCardsAdapter(grouped_cards);
                        }
                        deckDetailsActivity2.updateSideboardVisibility();
                        deckDetailsActivity2.updateMaybeboardVisibility();
                        deckDetailsActivity2.updateUI();
                        deckDetailsActivity2.updateSeeTokensTextViewVisibility();
                        deckDetailsActivity2.setupManaCurveChart();
                        deckDetailsActivity2.setupManaProduction();
                        if (deck3.getFormatid() == 6) {
                            MTBracket bracket = deck3.getBracket();
                            if ((bracket != null ? Intrinsics.areEqual((Object) bracket.getNeeds_recalc(), (Object) true) : false) && deckDetailsActivity2.bracketRecalcDeckId == null) {
                                final int id5 = deck3.getId();
                                deckDetailsActivity2.bracketRecalcDeckId = Integer.valueOf(id5);
                                MTApiKt.getMtApi().updateDeckBracketSuggestion(mTUser.getId(), id5, true).enqueue(new Callback<MTBracketSuggestionResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$updateDeck$1$1$onResponse$1$3
                                    @Override // retrofit2.Callback
                                    public void onFailure(Call<MTBracketSuggestionResponse> call2, Throwable t) {
                                        Intrinsics.checkNotNullParameter(call2, "call");
                                        Intrinsics.checkNotNullParameter(t, "t");
                                        deckDetailsActivity2.bracketRecalcDeckId = null;
                                    }

                                    @Override // retrofit2.Callback
                                    public void onResponse(Call<MTBracketSuggestionResponse> call2, Response<MTBracketSuggestionResponse> response2) {
                                        MTDeck mTDeck2;
                                        MTBracketSuggestionResponse mTBracketSuggestionResponseBody;
                                        Intrinsics.checkNotNullParameter(call2, "call");
                                        Intrinsics.checkNotNullParameter(response2, "response");
                                        deckDetailsActivity2.bracketRecalcDeckId = null;
                                        if (deckDetailsActivity2.isDestroyed() || deckDetailsActivity2.isFinishing() || (mTDeck2 = deckDetailsActivity2.currentDeck) == null || mTDeck2.getId() != id5 || !response2.isSuccessful() || (mTBracketSuggestionResponseBody = response2.body()) == null) {
                                            return;
                                        }
                                        DeckDetailsActivity deckDetailsActivity3 = deckDetailsActivity2;
                                        MTDeck mTDeck3 = deckDetailsActivity3.currentDeck;
                                        if (mTDeck3 != null) {
                                            if (mTDeck3.getBracket() == null) {
                                                mTDeck3.setBracket(new MTBracket(null, null, null, null, null, 31, null));
                                            }
                                            MTBracket bracket2 = mTDeck3.getBracket();
                                            if (bracket2 != null) {
                                                bracket2.setAuto(Integer.valueOf(mTBracketSuggestionResponseBody.getSuggested()));
                                            }
                                            MTBracket bracket3 = mTDeck3.getBracket();
                                            if (bracket3 != null) {
                                                bracket3.setNeeds_recalc(false);
                                            }
                                            MTBracket bracket4 = mTDeck3.getBracket();
                                            if (bracket4 != null) {
                                                bracket4.setMetrics(mTBracketSuggestionResponseBody.getMetrics());
                                            }
                                        }
                                        deckDetailsActivity3.updateUI();
                                    }
                                });
                            }
                        }
                    }
                    MTDeckResponse mTDeckResponseBody7 = response.body();
                    List<MTGame> games = mTDeckResponseBody7 != null ? mTDeckResponseBody7.getGames() : null;
                    DeckDetailsActivity deckDetailsActivity3 = this.this$0;
                    if (games != null) {
                        TextView textView5 = textView4;
                        deckDetailsActivity3.games = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(games, new Comparator() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$updateDeck$1$1$onResponse$lambda$1$$inlined$sortedByDescending$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(((MTGame) t2).getEnded_at(), ((MTGame) t).getEnded_at());
                            }
                        }));
                        deckDetailsActivity3.shouldShowLoadMore = games.size() >= 20;
                        List listGroupGamesWithSeparators = deckDetailsActivity3.groupGamesWithSeparators(games);
                        View viewFindViewById13 = deckDetailsActivity3.findViewById(R.id.gamesRecyclerView);
                        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
                        ((RecyclerView) viewFindViewById13).setAdapter(new GamesAdapter(CollectionsKt.toMutableList((Collection) listGroupGamesWithSeparators), false, deckDetailsActivity3, false, 8, null));
                        if (games.isEmpty() && deckDetailsActivity3.isOtherUserDeck()) {
                            MTDeckPrivacy mTDeckPrivacy = deckDetailsActivity3.currentDeckPrivacy;
                            if ((mTDeckPrivacy == null || (options2 = mTDeckPrivacy.getOptions()) == null) ? false : Intrinsics.areEqual((Object) options2.getShare_games(), (Object) false)) {
                                textView5.setText(deckDetailsActivity3.getString(R.string.games_not_shared));
                            }
                            if (deckDetailsActivity3.currentTabIndex == 1) {
                            }
                            deckDetailsActivity3.adjustRecyclerViewHeight();
                        } else {
                            textView5.setText(deckDetailsActivity3.getString(R.string.no_games_for_deck));
                            if (deckDetailsActivity3.currentTabIndex == 1) {
                                textView5.setVisibility(games.isEmpty() ? 0 : 8);
                            }
                            deckDetailsActivity3.adjustRecyclerViewHeight();
                        }
                    } else {
                        TextView textView6 = textView4;
                        if (deckDetailsActivity3.isOtherUserDeck()) {
                            MTDeckPrivacy mTDeckPrivacy2 = deckDetailsActivity3.currentDeckPrivacy;
                            if ((mTDeckPrivacy2 == null || (options = mTDeckPrivacy2.getOptions()) == null) ? false : Intrinsics.areEqual((Object) options.getShare_games(), (Object) false)) {
                                textView6.setText(deckDetailsActivity3.getString(R.string.games_not_shared));
                            }
                            textView6.setVisibility(0);
                        } else {
                            textView6.setText(deckDetailsActivity3.getString(R.string.no_games_for_deck));
                            textView6.setVisibility(0);
                        }
                    }
                    MTDeckResponse mTDeckResponseBody8 = response.body();
                    if (mTDeckResponseBody8 != null && (deck = mTDeckResponseBody8.getDeck()) != null && (stats = deck.getStats()) != null) {
                        matchups = stats.getMatchups();
                    }
                    TextView textView7 = textView3;
                    if (matchups != null) {
                        DeckDetailsActivity deckDetailsActivity4 = this.this$0;
                        textView7.setVisibility(8);
                        deckDetailsActivity4.matchups = matchups;
                        View viewFindViewById14 = deckDetailsActivity4.findViewById(R.id.matchupsRecyclerView);
                        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
                        RecyclerView recyclerView2 = (RecyclerView) viewFindViewById14;
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(deckDetailsActivity4);
                        linearLayoutManager.setSmoothScrollbarEnabled(true);
                        linearLayoutManager.setItemPrefetchEnabled(false);
                        recyclerView2.setNestedScrollingEnabled(false);
                        recyclerView2.setLayoutManager(linearLayoutManager);
                        MTDeck mTDeck2 = deckDetailsActivity4.currentDeck;
                        if (mTDeck2 == null) {
                            mTDeck2 = new MTDeck(0, 0, null, 0, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 2047, null);
                        }
                        recyclerView2.setAdapter(new MatchupsAdapter(matchups, mTDeck2));
                        deckDetailsActivity4.adjustMatchupsRecyclerViewHeight();
                    } else {
                        textView7.setVisibility(0);
                    }
                    this.this$0.updateUI();
                    this.this$0.fetchDeckIdCardIfNeeded(false);
                }
            });
        }
    }

    private final void updateDeckBottomBarUnknown() {
        View viewFindViewById = findViewById(R.id.legalityLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = findViewById(R.id.validDeckIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        View viewFindViewById3 = findViewById(R.id.validDeckLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        View viewFindViewById4 = findViewById(R.id.cardCountLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        View viewFindViewById5 = findViewById(R.id.deckPriceLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        ((ConstraintLayout) viewFindViewById).setBackgroundResource(R.drawable.unknown_deck_box);
        ((ImageView) viewFindViewById2).setImageResource(R.drawable.ic_help);
        ((TextView) viewFindViewById3).setText(getResources().getString(R.string.unknown));
        ((TextView) viewFindViewById4).setText("--");
        ((TextView) viewFindViewById5).setText("---");
    }

    private final void updateDeckPrivacy(String newType) {
        MTDeck mTDeck;
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        if (currentUser == null || (mTDeck = this.currentDeck) == null) {
            return;
        }
        final View viewFindViewById = findViewById(R.id.overlay);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
        MTApiKt.getMtApi().updateDeckPrivacy(currentUser.getId(), mTDeck.getId(), new MTUpdatePrivacyBody(newType, null, null, 6, null)).enqueue(new Callback<MTDeckPrivacyResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity.updateDeckPrivacy.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTDeckPrivacyResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (DeckDetailsActivity.this.isDestroyed() || DeckDetailsActivity.this.isFinishing()) {
                    return;
                }
                View view = viewFindViewById;
                if (view != null) {
                    view.setVisibility(8);
                }
                Toast.makeText(DeckDetailsActivity.this, R.string.privacy_update_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTDeckPrivacyResponse> call, Response<MTDeckPrivacyResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (DeckDetailsActivity.this.isDestroyed() || DeckDetailsActivity.this.isFinishing()) {
                    return;
                }
                View view = viewFindViewById;
                if (view != null) {
                    view.setVisibility(8);
                }
                if (!response.isSuccessful()) {
                    Toast.makeText(DeckDetailsActivity.this, R.string.privacy_update_error, 0).show();
                    return;
                }
                MTDeckPrivacyResponse mTDeckPrivacyResponseBody = response.body();
                MTDeckPrivacy privacy = mTDeckPrivacyResponseBody != null ? mTDeckPrivacyResponseBody.getPrivacy() : null;
                DeckDetailsActivity.this.currentDeckPrivacy = privacy;
                DeckDetailsActivity.this.updatePrivacyToolbar(privacy);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDeckValuesDialogView(View view, MTDeckValues values) {
        Set<String> setEmptySet;
        MTDeckCardCountDetails sideboard;
        MTDeckCardCountDetails sideboard2;
        MTDeckCardCountDetails main;
        MTDeckCardCountDetails main2;
        MTDeckCardCountDetails sideboard3;
        MTDeckCardCountDetails sideboard4;
        MTDeckCardCountDetails main3;
        MTDeckCardCountDetails main4;
        Map<String, MTDeckValueDetail> sideboard5;
        MTDeckValueDetail mTDeckValueDetail;
        Map<String, MTDeckValueDetail> main5;
        MTDeckValueDetail mTDeckValueDetail2;
        Map<String, MTDeckValueDetail> sideboard6;
        MTDeckValueDetail mTDeckValueDetail3;
        Double total_value;
        Map<String, MTDeckValueDetail> main6;
        MTDeckValueDetail mTDeckValueDetail4;
        Double total_value2;
        Map<String, MTDeckValueDetail> sideboard7;
        MTDeckValueDetail mTDeckValueDetail5;
        Map<String, MTDeckValueDetail> main7;
        MTDeckValueDetail mTDeckValueDetail6;
        Map<String, MTDeckValueDetail> sideboard8;
        MTDeckValueDetail mTDeckValueDetail7;
        Double total_value3;
        Map<String, MTDeckValueDetail> main8;
        MTDeckValueDetail mTDeckValueDetail8;
        Double total_value4;
        Map<String, MTDeckValueDetail> sideboard9;
        MTDeckValueDetail mTDeckValueDetail9;
        Map<String, MTDeckValueDetail> main9;
        MTDeckValueDetail mTDeckValueDetail10;
        Map<String, MTDeckValueDetail> sideboard10;
        MTDeckValueDetail mTDeckValueDetail11;
        Double total_value5;
        Map<String, MTDeckValueDetail> main10;
        MTDeckValueDetail mTDeckValueDetail12;
        Double total_value6;
        Map<String, MTDeckValueDetail> main11;
        String preferredCurrency = new PreferencesManager(this).getPreferredCurrency();
        MTDeckValueItems raw = values.getRaw();
        if (raw == null || (main11 = raw.getMain()) == null || (setEmptySet = main11.keySet()) == null) {
            setEmptySet = SetsKt.emptySet();
        }
        if (!setEmptySet.contains(preferredCurrency)) {
            preferredCurrency = "USD";
            if (!setEmptySet.contains("USD") && setEmptySet.contains("EUR")) {
                preferredCurrency = "EUR";
            }
        }
        MTDeckValueItems raw2 = values.getRaw();
        double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        ((TextView) view.findViewById(R.id.deck_values_total_row1)).setText(updateDeckValuesDialogView$formatPriceOrDash(preferredCurrency, Double.valueOf(((raw2 == null || (main10 = raw2.getMain()) == null || (mTDeckValueDetail12 = main10.get(preferredCurrency)) == null || (total_value6 = mTDeckValueDetail12.getTotal_value()) == null) ? 0.0d : total_value6.doubleValue()) + ((raw2 == null || (sideboard10 = raw2.getSideboard()) == null || (mTDeckValueDetail11 = sideboard10.get(preferredCurrency)) == null || (total_value5 = mTDeckValueDetail11.getTotal_value()) == null) ? 0.0d : total_value5.doubleValue()))));
        Integer total_card_count = null;
        ((TextView) view.findViewById(R.id.deck_values_deck_row1)).setText(updateDeckValuesDialogView$formatPriceOrDash(preferredCurrency, (raw2 == null || (main9 = raw2.getMain()) == null || (mTDeckValueDetail10 = main9.get(preferredCurrency)) == null) ? null : mTDeckValueDetail10.getTotal_value()));
        ((TextView) view.findViewById(R.id.deck_values_sideboard_row1)).setText(updateDeckValuesDialogView$formatPriceOrDash(preferredCurrency, (raw2 == null || (sideboard9 = raw2.getSideboard()) == null || (mTDeckValueDetail9 = sideboard9.get(preferredCurrency)) == null) ? null : mTDeckValueDetail9.getTotal_value()));
        MTDeckValueItems cheapest_printing = values.getCheapest_printing();
        ((TextView) view.findViewById(R.id.deck_values_total_row2)).setText(updateDeckValuesDialogView$formatPriceOrDash(preferredCurrency, Double.valueOf(((cheapest_printing == null || (main8 = cheapest_printing.getMain()) == null || (mTDeckValueDetail8 = main8.get(preferredCurrency)) == null || (total_value4 = mTDeckValueDetail8.getTotal_value()) == null) ? 0.0d : total_value4.doubleValue()) + ((cheapest_printing == null || (sideboard8 = cheapest_printing.getSideboard()) == null || (mTDeckValueDetail7 = sideboard8.get(preferredCurrency)) == null || (total_value3 = mTDeckValueDetail7.getTotal_value()) == null) ? 0.0d : total_value3.doubleValue()))));
        ((TextView) view.findViewById(R.id.deck_values_deck_row2)).setText(updateDeckValuesDialogView$formatPriceOrDash(preferredCurrency, (cheapest_printing == null || (main7 = cheapest_printing.getMain()) == null || (mTDeckValueDetail6 = main7.get(preferredCurrency)) == null) ? null : mTDeckValueDetail6.getTotal_value()));
        ((TextView) view.findViewById(R.id.deck_values_sideboard_row2)).setText(updateDeckValuesDialogView$formatPriceOrDash(preferredCurrency, (cheapest_printing == null || (sideboard7 = cheapest_printing.getSideboard()) == null || (mTDeckValueDetail5 = sideboard7.get(preferredCurrency)) == null) ? null : mTDeckValueDetail5.getTotal_value()));
        MTDeckValueItems unowned = values.getUnowned();
        double dDoubleValue2 = (unowned == null || (main6 = unowned.getMain()) == null || (mTDeckValueDetail4 = main6.get(preferredCurrency)) == null || (total_value2 = mTDeckValueDetail4.getTotal_value()) == null) ? 0.0d : total_value2.doubleValue();
        if (unowned != null && (sideboard6 = unowned.getSideboard()) != null && (mTDeckValueDetail3 = sideboard6.get(preferredCurrency)) != null && (total_value = mTDeckValueDetail3.getTotal_value()) != null) {
            dDoubleValue = total_value.doubleValue();
        }
        ((TextView) view.findViewById(R.id.deck_values_total_row3)).setText(updateDeckValuesDialogView$formatPriceOrDash(preferredCurrency, Double.valueOf(dDoubleValue2 + dDoubleValue)));
        ((TextView) view.findViewById(R.id.deck_values_deck_row3)).setText(updateDeckValuesDialogView$formatPriceOrDash(preferredCurrency, (unowned == null || (main5 = unowned.getMain()) == null || (mTDeckValueDetail2 = main5.get(preferredCurrency)) == null) ? null : mTDeckValueDetail2.getTotal_value()));
        ((TextView) view.findViewById(R.id.deck_values_sideboard_row3)).setText(updateDeckValuesDialogView$formatPriceOrDash(preferredCurrency, (unowned == null || (sideboard5 = unowned.getSideboard()) == null || (mTDeckValueDetail = sideboard5.get(preferredCurrency)) == null) ? null : mTDeckValueDetail.getTotal_value()));
        MTDeckCardCounts collection_owned_exact = values.getCollection_owned_exact();
        ((TextView) view.findViewById(R.id.deck_values_total_row4)).setText(updateDeckValuesDialogView$formatCount(collection_owned_exact != null ? collection_owned_exact.getCard_count() : null, collection_owned_exact != null ? collection_owned_exact.getTotal_card_count() : null));
        ((TextView) view.findViewById(R.id.deck_values_deck_row4)).setText(updateDeckValuesDialogView$formatCount((collection_owned_exact == null || (main4 = collection_owned_exact.getMain()) == null) ? null : main4.getCard_count(), (collection_owned_exact == null || (main3 = collection_owned_exact.getMain()) == null) ? null : main3.getTotal_card_count()));
        ((TextView) view.findViewById(R.id.deck_values_sideboard_row4)).setText(updateDeckValuesDialogView$formatCount((collection_owned_exact == null || (sideboard4 = collection_owned_exact.getSideboard()) == null) ? null : sideboard4.getCard_count(), (collection_owned_exact == null || (sideboard3 = collection_owned_exact.getSideboard()) == null) ? null : sideboard3.getTotal_card_count()));
        MTDeckCardCounts collection_owned_any = values.getCollection_owned_any();
        ((TextView) view.findViewById(R.id.deck_values_total_row5)).setText(updateDeckValuesDialogView$formatCount(collection_owned_any != null ? collection_owned_any.getCard_count() : null, collection_owned_any != null ? collection_owned_any.getTotal_card_count() : null));
        ((TextView) view.findViewById(R.id.deck_values_deck_row5)).setText(updateDeckValuesDialogView$formatCount((collection_owned_any == null || (main2 = collection_owned_any.getMain()) == null) ? null : main2.getCard_count(), (collection_owned_any == null || (main = collection_owned_any.getMain()) == null) ? null : main.getTotal_card_count()));
        TextView textView = (TextView) view.findViewById(R.id.deck_values_sideboard_row5);
        Integer card_count = (collection_owned_any == null || (sideboard2 = collection_owned_any.getSideboard()) == null) ? null : sideboard2.getCard_count();
        if (collection_owned_any != null && (sideboard = collection_owned_any.getSideboard()) != null) {
            total_card_count = sideboard.getTotal_card_count();
        }
        textView.setText(updateDeckValuesDialogView$formatCount(card_count, total_card_count));
    }

    private static final String updateDeckValuesDialogView$formatCount(Integer num, Integer num2) {
        return (num == null || num2 == null || num2.intValue() == 0) ? "--" : num + DomExceptionUtils.SEPARATOR + num2;
    }

    private static final String updateDeckValuesDialogView$formatPriceOrDash(String str, Double d) {
        return d == null ? "--" : GameUtils.INSTANCE.getInstance().formatPrice(d.doubleValue(), str);
    }

    private final void updateDisplayModeIcon() {
        String str;
        View viewFindViewById = findViewById(R.id.displayModeToggle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById;
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentDisplayMode.ordinal()];
        if (i == 1) {
            str = "\uf0db";
        } else if (i == 2) {
            str = "\uf022";
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = "\uf0c8";
        }
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFilter() {
        updateDeck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMaybeboardVisibility() {
        View viewFindViewById = findViewById(R.id.maybeboardRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.maybeboardTwoColumnStackedCardsView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TwoColumnStackedCardsView twoColumnStackedCardsView = (TwoColumnStackedCardsView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.maybeboardNoCardsTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.maybeboardExpandArrow);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById4;
        if (!this.maybeboardExpanded) {
            imageView.setRotation(0.0f);
            recyclerView.setVisibility(8);
            twoColumnStackedCardsView.setVisibility(8);
            textView.setVisibility(8);
            return;
        }
        imageView.setRotation(180.0f);
        MTDeckLists mTDeckLists = this.currentLists;
        MTCardContainer maybeboard = mTDeckLists != null ? mTDeckLists.getMaybeboard() : null;
        List<MTCardGroup> grouped_cards = maybeboard != null ? maybeboard.getGrouped_cards() : null;
        if (grouped_cards == null || grouped_cards.isEmpty()) {
            recyclerView.setVisibility(8);
            twoColumnStackedCardsView.setVisibility(8);
            textView.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
        if (WhenMappings.$EnumSwitchMapping$0[this.currentDisplayMode.ordinal()] == 1) {
            recyclerView.setVisibility(8);
            twoColumnStackedCardsView.setVisibility(0);
        } else {
            recyclerView.setVisibility(0);
            twoColumnStackedCardsView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void updatePrivacyToolbar(MTDeckPrivacy privacy) {
        Pair pair;
        View viewFindViewById = findViewById(R.id.privacyToolbarLayout);
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
        if (isOtherUserDeck() || this.isDuplicatedDeck) {
            return;
        }
        if ((privacy != null ? privacy.getType() : null) == null) {
            return;
        }
        viewFindViewById.setVisibility(0);
        TextView textView = (TextView) viewFindViewById.findViewById(R.id.privacyLabel);
        View viewFindViewById2 = viewFindViewById.findViewById(R.id.privacySelectorContainer);
        View viewFindViewById3 = viewFindViewById.findViewById(R.id.sharingIcon);
        View viewFindViewById4 = viewFindViewById.findViewById(R.id.separatorIcon);
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
            if (viewFindViewById2 != null) {
                viewFindViewById2.setBackgroundResource(iIntValue2);
            }
            boolean zAreEqual = Intrinsics.areEqual(privacy.getType(), MTApiKt.PRIVACY_TYPE_PRIVATE);
            if (viewFindViewById3 != null) {
                viewFindViewById3.setVisibility(zAreEqual ? 8 : 0);
            }
            if (viewFindViewById4 != null) {
                viewFindViewById4.setVisibility(zAreEqual ? 8 : 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSeeTokensTextViewVisibility() {
        View viewFindViewById = findViewById(R.id.seeTokensTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((TextView) viewFindViewById).setVisibility((this.loaded && this.currentTabIndex == 0) ? 0 : 8);
    }

    private final void updateSelectionCountText() {
        String strReplace$default;
        View viewFindViewById = findViewById(R.id.selectionCountTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById;
        int size = this.selectedCards.size();
        if (size == 1) {
            String string = getString(R.string.x_card_selected);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            strReplace$default = StringsKt.replace$default(string, "{1}", String.valueOf(size), false, 4, (Object) null);
        } else {
            String string2 = getString(R.string.x_cards_selected);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            strReplace$default = StringsKt.replace$default(string2, "{1}", String.valueOf(size), false, 4, (Object) null);
        }
        textView.setText(strReplace$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSideboardVisibility() {
        View viewFindViewById = findViewById(R.id.sideboardRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.sideboardTwoColumnStackedCardsView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TwoColumnStackedCardsView twoColumnStackedCardsView = (TwoColumnStackedCardsView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.sideboardNoCardsTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.sideboardExpandArrow);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById4;
        if (!this.sideboardExpanded) {
            imageView.setRotation(0.0f);
            recyclerView.setVisibility(8);
            twoColumnStackedCardsView.setVisibility(8);
            textView.setVisibility(8);
            return;
        }
        imageView.setRotation(180.0f);
        MTDeckLists mTDeckLists = this.currentLists;
        MTCardContainer sideboard = mTDeckLists != null ? mTDeckLists.getSideboard() : null;
        List<MTCardGroup> grouped_cards = sideboard != null ? sideboard.getGrouped_cards() : null;
        if (grouped_cards == null || grouped_cards.isEmpty()) {
            recyclerView.setVisibility(8);
            twoColumnStackedCardsView.setVisibility(8);
            textView.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
        if (WhenMappings.$EnumSwitchMapping$0[this.currentDisplayMode.ordinal()] == 1) {
            recyclerView.setVisibility(8);
            twoColumnStackedCardsView.setVisibility(0);
        } else {
            recyclerView.setVisibility(0);
            twoColumnStackedCardsView.setVisibility(8);
            recyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda63
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.adjustSideboardRecyclerViewHeight();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:235:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x06bd  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x06ce  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0759  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x086c  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x08c3  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x09d8  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0a2f  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0b8b  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0cbe  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0cdc  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0d20  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0d7d  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0dae  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0dc7  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0dcb  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0df1  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0e0b  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0e24  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0e3b  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0e5e  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0e65  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0e91  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0ec0  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0ed5  */
    /* JADX WARN: Type inference failed for: r0v211, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r15v8, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r15v9, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v74 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v78, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r40v0 */
    /* JADX WARN: Type inference failed for: r40v1 */
    /* JADX WARN: Type inference failed for: r40v10 */
    /* JADX WARN: Type inference failed for: r40v11 */
    /* JADX WARN: Type inference failed for: r40v12 */
    /* JADX WARN: Type inference failed for: r40v13 */
    /* JADX WARN: Type inference failed for: r40v14 */
    /* JADX WARN: Type inference failed for: r40v15 */
    /* JADX WARN: Type inference failed for: r40v16 */
    /* JADX WARN: Type inference failed for: r40v17 */
    /* JADX WARN: Type inference failed for: r40v18 */
    /* JADX WARN: Type inference failed for: r40v19 */
    /* JADX WARN: Type inference failed for: r40v2 */
    /* JADX WARN: Type inference failed for: r40v3 */
    /* JADX WARN: Type inference failed for: r40v4 */
    /* JADX WARN: Type inference failed for: r40v6 */
    /* JADX WARN: Type inference failed for: r40v7 */
    /* JADX WARN: Type inference failed for: r42v0 */
    /* JADX WARN: Type inference failed for: r42v1 */
    /* JADX WARN: Type inference failed for: r42v10 */
    /* JADX WARN: Type inference failed for: r42v11 */
    /* JADX WARN: Type inference failed for: r42v12 */
    /* JADX WARN: Type inference failed for: r42v2 */
    /* JADX WARN: Type inference failed for: r42v3 */
    /* JADX WARN: Type inference failed for: r42v4 */
    /* JADX WARN: Type inference failed for: r42v5 */
    /* JADX WARN: Type inference failed for: r42v7 */
    /* JADX WARN: Type inference failed for: r42v8 */
    /* JADX WARN: Type inference failed for: r42v9 */
    /* JADX WARN: Type inference failed for: r4v50, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v22, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v36, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v52 */
    /* JADX WARN: Type inference failed for: r5v78 */
    /* JADX WARN: Type inference failed for: r7v46, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r7v61, types: [android.widget.TextView] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateUI() {
        Object next;
        DeckDetailsActivity deckDetailsActivity;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        LinearLayout linearLayout;
        final MTDeck mTDeck;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        int i;
        final String externalurl;
        final LoadingImageViewPlaymat loadingImageViewPlaymat;
        DeckDetailsActivity deckDetailsActivity2;
        MTDeck mTDeck2;
        boolean zComputeIsSmartDeck;
        ConstraintLayout constraintLayout;
        TextView textView;
        ConstraintLayout constraintLayout2;
        ConstraintLayout constraintLayout3;
        ConstraintLayout constraintLayout4;
        CustomGlowView customGlowView;
        MTDeckPrivacyOptions options;
        ?? r40;
        ?? r42;
        TextView textView2;
        TextView textView3;
        MTInnerStats onThePlay;
        ?? r5;
        MTInnerStats onTheDraw;
        final MTSharedStats sharedStats;
        boolean z;
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        if (isDestroyed() || isFinishing()) {
            return;
        }
        updateBottomBar();
        MTDeck mTDeck3 = this.currentDeck;
        if (mTDeck3 != null) {
            View viewFindViewById = findViewById(R.id.deckName);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            View viewFindViewById2 = findViewById(R.id.deckFormat);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            TextView textView4 = (TextView) viewFindViewById2;
            ((TextView) viewFindViewById).setText(mTDeck3.getName());
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.descriptionLayout);
            TextView textView5 = (TextView) findViewById(R.id.descriptionTextView);
            TextView textView6 = (TextView) findViewById(R.id.editIconTextView);
            String description = mTDeck3.getDescription();
            if (description != null && description.length() > 0) {
                linearLayout2.setVisibility(0);
                textView5.setText(mTDeck3.getDescription());
                textView5.setTextColor(ContextCompat.getColor(this, R.color.text_color));
                textView5.setTypeface(textView5.getTypeface(), 0);
            } else if (isOtherUserDeck() || this.isDuplicatedDeck) {
                linearLayout2.setVisibility(8);
            } else {
                linearLayout2.setVisibility(0);
                textView5.setText(getString(R.string.add_descrpition));
                textView5.setTextColor(ContextCompat.getColor(this, R.color.text_color_transparent));
                textView5.setTypeface(textView5.getTypeface(), 2);
            }
            textView6.setVisibility((isOtherUserDeck() || this.isDuplicatedDeck) ? 8 : 0);
            DeckDetailsActivity deckDetailsActivity3 = this;
            Iterator it = DecksDBHelper.INSTANCE.getInstance(deckDetailsActivity3).getFormats().iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (((MTFormat) next).getId() == mTDeck3.getFormatid()) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            MTFormat mTFormat = (MTFormat) next;
            View viewFindViewById3 = findViewById(R.id.manaLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            LinearLayout linearLayout3 = (LinearLayout) viewFindViewById3;
            View viewFindViewById4 = findViewById(R.id.w_mana);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            ImageView imageView7 = (ImageView) viewFindViewById4;
            View viewFindViewById5 = findViewById(R.id.u_mana);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            ImageView imageView8 = (ImageView) viewFindViewById5;
            View viewFindViewById6 = findViewById(R.id.b_mana);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            ImageView imageView9 = (ImageView) viewFindViewById6;
            View viewFindViewById7 = findViewById(R.id.r_mana);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            ImageView imageView10 = (ImageView) viewFindViewById7;
            View viewFindViewById8 = findViewById(R.id.g_mana);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            ImageView imageView11 = (ImageView) viewFindViewById8;
            View viewFindViewById9 = findViewById(R.id.c_mana);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
            ImageView imageView12 = (ImageView) viewFindViewById9;
            final ConstraintLayout constraintLayout5 = (ConstraintLayout) findViewById(R.id.bracketLayout);
            final TextView textView7 = (TextView) findViewById(R.id.bracketValueTextView);
            final TextView textView8 = (TextView) findViewById(R.id.bracketNameTextView);
            final TextView textView9 = (TextView) findViewById(R.id.staleBracketIndicator);
            final ConstraintLayout constraintLayout6 = (ConstraintLayout) findViewById(R.id.autoBracketIconLayout);
            if (constraintLayout5 != null) {
                constraintLayout5.setVisibility(8);
                Unit unit = Unit.INSTANCE;
            }
            if (textView9 != null) {
                textView9.setVisibility(8);
                Unit unit2 = Unit.INSTANCE;
            }
            Object obj = "%";
            if (mTDeck3.getFormatid() == 6) {
                MTBracket bracket = mTDeck3.getBracket();
                if (bracket != null) {
                    Boolean needs_recalc = bracket.getNeeds_recalc();
                    if (needs_recalc != null) {
                        if (needs_recalc.booleanValue() && textView9 != null) {
                            textView9.setVisibility(0);
                            Unit unit3 = Unit.INSTANCE;
                        }
                        Unit unit4 = Unit.INSTANCE;
                        Unit unit5 = Unit.INSTANCE;
                    }
                    Integer user = bracket.getUser();
                    if (user != null) {
                        int iIntValue = user.intValue();
                        if (constraintLayout5 != null) {
                            constraintLayout5.setVisibility(0);
                            Unit unit6 = Unit.INSTANCE;
                        }
                        if (textView7 != null) {
                            textView7.setText(String.valueOf(iIntValue));
                            Unit unit7 = Unit.INSTANCE;
                        }
                        if (iIntValue != 1) {
                            if (iIntValue != 2) {
                                if (iIntValue != 3) {
                                    if (iIntValue != 4) {
                                        if (iIntValue == 5 && textView8 != null) {
                                            textView8.setText(getString(R.string.cedh_caps));
                                            Unit unit8 = Unit.INSTANCE;
                                        }
                                    } else if (textView8 != null) {
                                        textView8.setText(getString(R.string.optimized_caps));
                                        Unit unit9 = Unit.INSTANCE;
                                    }
                                } else if (textView8 != null) {
                                    textView8.setText(getString(R.string.upgraded_caps));
                                    Unit unit10 = Unit.INSTANCE;
                                }
                            } else if (textView8 != null) {
                                textView8.setText(getString(R.string.core_caps));
                                Unit unit11 = Unit.INSTANCE;
                            }
                        } else if (textView8 != null) {
                            textView8.setText(getString(R.string.exhibition_caps));
                            Unit unit12 = Unit.INSTANCE;
                        }
                        constraintLayout6.setVisibility(8);
                        Unit unit13 = Unit.INSTANCE;
                        Unit unit14 = Unit.INSTANCE;
                        z3 = false;
                        i2 = 0;
                        i3 = 1;
                    } else {
                        Integer auto = bracket.getAuto();
                        if (auto != null) {
                            int iIntValue2 = auto.intValue();
                            if (constraintLayout5 != null) {
                                constraintLayout5.setVisibility(0);
                                Unit unit15 = Unit.INSTANCE;
                            }
                            if (textView7 != null) {
                                textView7.setText(String.valueOf(iIntValue2));
                                Unit unit16 = Unit.INSTANCE;
                            }
                            if (iIntValue2 != 1) {
                                if (iIntValue2 != 2) {
                                    if (iIntValue2 != 3) {
                                        if (iIntValue2 != 4) {
                                            if (iIntValue2 == 5 && textView8 != null) {
                                                textView8.setText(getString(R.string.cedh_caps));
                                                Unit unit17 = Unit.INSTANCE;
                                            }
                                        } else if (textView8 != null) {
                                            textView8.setText(getString(R.string.optimized_caps));
                                            Unit unit18 = Unit.INSTANCE;
                                        }
                                    } else if (textView8 != null) {
                                        textView8.setText(getString(R.string.upgraded_caps));
                                        Unit unit19 = Unit.INSTANCE;
                                    }
                                } else if (textView8 != null) {
                                    textView8.setText(getString(R.string.core_caps));
                                    Unit unit20 = Unit.INSTANCE;
                                }
                            } else if (textView8 != null) {
                                textView8.setText(getString(R.string.exhibition_caps));
                                Unit unit21 = Unit.INSTANCE;
                            }
                            i2 = 0;
                            constraintLayout6.setVisibility(0);
                            Unit unit22 = Unit.INSTANCE;
                            Unit unit23 = Unit.INSTANCE;
                            z2 = true;
                        } else {
                            i2 = 0;
                            z2 = false;
                        }
                        z3 = z2;
                        i3 = i2;
                    }
                    if (i3 == 0 && !z3) {
                        if (constraintLayout5 != null) {
                            constraintLayout5.setVisibility(i2);
                            Unit unit24 = Unit.INSTANCE;
                        }
                        if (textView7 != null) {
                            textView7.setText("?");
                            Unit unit25 = Unit.INSTANCE;
                        }
                        if (textView8 != null) {
                            textView8.setText(getString(R.string.bracket_caps));
                            Unit unit26 = Unit.INSTANCE;
                        }
                        constraintLayout6.setVisibility(8);
                        if (textView9 != null) {
                            textView9.setVisibility(0);
                            Unit unit27 = Unit.INSTANCE;
                        }
                    }
                    Unit unit28 = Unit.INSTANCE;
                } else {
                    if (constraintLayout5 != null) {
                        constraintLayout5.setVisibility(0);
                        Unit unit29 = Unit.INSTANCE;
                    }
                    if (textView7 != null) {
                        textView7.setText("?");
                        Unit unit30 = Unit.INSTANCE;
                    }
                    if (textView8 != null) {
                        textView8.setText(getString(R.string.bracket_caps));
                        Unit unit31 = Unit.INSTANCE;
                    }
                    constraintLayout6.setVisibility(8);
                    if (textView9 != null) {
                        textView9.setVisibility(0);
                        Unit unit32 = Unit.INSTANCE;
                    }
                    Unit unit33 = Unit.INSTANCE;
                }
            }
            if (isOtherUserDeck() || this.isDuplicatedDeck || constraintLayout5 == null) {
                deckDetailsActivity = this;
                imageView = imageView8;
                imageView2 = imageView9;
                imageView3 = imageView11;
                linearLayout = linearLayout3;
                mTDeck = mTDeck3;
                imageView4 = imageView7;
                imageView5 = imageView12;
                imageView6 = imageView10;
            } else {
                ConstraintLayout constraintLayout7 = constraintLayout5;
                imageView2 = imageView9;
                imageView3 = imageView11;
                linearLayout = linearLayout3;
                imageView5 = imageView12;
                mTDeck = mTDeck3;
                imageView6 = imageView10;
                imageView = imageView8;
                imageView4 = imageView7;
                Function0 function0 = new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda166
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckDetailsActivity.updateUI$lambda$0$3(this.f$0, mTDeck, textView9, constraintLayout5, textView7, textView8, constraintLayout6);
                    }
                };
                deckDetailsActivity = this;
                ViewExtensionsKt.setOnClickWithFade(constraintLayout7, function0);
                Unit unit34 = Unit.INSTANCE;
            }
            if (mTFormat != null) {
                textView4.setVisibility(0);
                textView4.setText(mTFormat.getName());
                final ArrayList<String> arrayList = new ArrayList();
                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                String commander = mTDeck.getCommander();
                if (commander != null) {
                    Pair<String, Integer> pairExtractIdAndFace = DeckUtils.INSTANCE.extractIdAndFace(commander);
                    GameUtils.INSTANCE.getInstance().getCard(deckDetailsActivity3, pairExtractIdAndFace.component1(), pairExtractIdAndFace.component2().intValue(), new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda167
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return DeckDetailsActivity.updateUI$lambda$0$4$0$0(objectRef, booleanRef, mTDeck, arrayList, (CardRecord) obj2);
                        }
                    });
                    Unit unit35 = Unit.INSTANCE;
                    Unit unit36 = Unit.INSTANCE;
                }
                String partner = mTDeck.getPartner();
                if (partner != null) {
                    Pair<String, Integer> pairExtractIdAndFace2 = DeckUtils.INSTANCE.extractIdAndFace(partner);
                    GameUtils.INSTANCE.getInstance().getCard(deckDetailsActivity3, pairExtractIdAndFace2.component1(), pairExtractIdAndFace2.component2().intValue(), new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda168
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return DeckDetailsActivity.updateUI$lambda$0$4$1$0(booleanRef, mTDeck, arrayList, (CardRecord) obj2);
                        }
                    });
                    Unit unit37 = Unit.INSTANCE;
                    Unit unit38 = Unit.INSTANCE;
                }
                String colors = mTDeck.getColors();
                if (colors != null) {
                    char[] charArray = colors.toCharArray();
                    Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
                    for (char c : charArray) {
                        if (!arrayList.contains(String.valueOf(c))) {
                            arrayList.add(String.valueOf(c));
                        }
                    }
                    Unit unit39 = Unit.INSTANCE;
                    Unit unit40 = Unit.INSTANCE;
                    z = true;
                } else {
                    z = false;
                }
                if (booleanRef.element || z) {
                    linearLayout.setVisibility(0);
                    imageView4.setVisibility(8);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    imageView6.setVisibility(8);
                    ImageView imageView13 = imageView3;
                    imageView13.setVisibility(8);
                    ImageView imageView14 = imageView5;
                    imageView14.setVisibility(8);
                    for (String str : arrayList) {
                        int iHashCode = str.hashCode();
                        if (iHashCode != 66) {
                            if (iHashCode != 71) {
                                if (iHashCode != 82) {
                                    if (iHashCode != 85) {
                                        if (iHashCode == 87 && str.equals(ExifInterface.LONGITUDE_WEST)) {
                                            imageView4.setVisibility(0);
                                        }
                                    } else if (str.equals("U")) {
                                        imageView.setVisibility(0);
                                    }
                                } else if (str.equals("R")) {
                                    imageView6.setVisibility(0);
                                }
                            } else if (str.equals(GameUtils.CONDITION_GOOD)) {
                                imageView13.setVisibility(0);
                            }
                        } else if (str.equals("B")) {
                            imageView2.setVisibility(0);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        imageView14.setVisibility(0);
                    }
                } else {
                    linearLayout.setVisibility(8);
                }
                Unit unit41 = Unit.INSTANCE;
            } else {
                linearLayout.setVisibility(8);
                textView4.setVisibility(8);
                Unit unit42 = Unit.INSTANCE;
            }
            View viewFindViewById10 = deckDetailsActivity.findViewById(R.id.winrateValue);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
            TextView textView10 = (TextView) viewFindViewById10;
            View viewFindViewById11 = deckDetailsActivity.findViewById(R.id.numGamesLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
            TextView textView11 = (TextView) viewFindViewById11;
            View viewFindViewById12 = deckDetailsActivity.findViewById(R.id.numGamesValueLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
            TextView textView12 = (TextView) viewFindViewById12;
            View viewFindViewById13 = deckDetailsActivity.findViewById(R.id.numWinsLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
            TextView textView13 = (TextView) viewFindViewById13;
            View viewFindViewById14 = deckDetailsActivity.findViewById(R.id.numWinsValueLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
            TextView textView14 = (TextView) viewFindViewById14;
            View viewFindViewById15 = deckDetailsActivity.findViewById(R.id.numLossesLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
            TextView textView15 = (TextView) viewFindViewById15;
            View viewFindViewById16 = deckDetailsActivity.findViewById(R.id.numLossesValueLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
            TextView textView16 = (TextView) viewFindViewById16;
            View viewFindViewById17 = deckDetailsActivity.findViewById(R.id.numDrawsLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
            TextView textView17 = (TextView) viewFindViewById17;
            View viewFindViewById18 = deckDetailsActivity.findViewById(R.id.numDrawsValueLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
            TextView textView18 = (TextView) viewFindViewById18;
            TextView textView19 = (TextView) deckDetailsActivity.findViewById(R.id.otpWinrate);
            TextView textView20 = (TextView) deckDetailsActivity.findViewById(R.id.otpNumGames);
            TextView textView21 = (TextView) deckDetailsActivity.findViewById(R.id.otpNumWinsValueLabel);
            MTDeck mTDeck4 = mTDeck;
            ?? r2 = (TextView) deckDetailsActivity.findViewById(R.id.otpNumLossesValueLabel);
            TextView textView22 = (TextView) deckDetailsActivity.findViewById(R.id.otpNumDrawsValueLabel);
            TextView textView23 = (TextView) deckDetailsActivity.findViewById(R.id.otdWinrate);
            TextView textView24 = (TextView) deckDetailsActivity.findViewById(R.id.otdNumGames);
            TextView textView25 = (TextView) deckDetailsActivity.findViewById(R.id.otdNumWinsValueLabel);
            TextView textView26 = (TextView) deckDetailsActivity.findViewById(R.id.otdNumLossesValueLabel);
            TextView textView27 = (TextView) deckDetailsActivity.findViewById(R.id.otdNumDrawsValueLabel);
            LinearLayout linearLayout4 = (LinearLayout) deckDetailsActivity.findViewById(R.id.sharedStatsLayout);
            TextView textView28 = (TextView) deckDetailsActivity.findViewById(R.id.sharedStatsWinrate);
            TextView textView29 = (TextView) deckDetailsActivity.findViewById(R.id.sharedStatsNumGames);
            TextView textView30 = (TextView) deckDetailsActivity.findViewById(R.id.sharedStatsNumWinsValueLabel);
            TextView textView31 = (TextView) deckDetailsActivity.findViewById(R.id.sharedStatsNumLossesValueLabel);
            TextView textView32 = (TextView) deckDetailsActivity.findViewById(R.id.sharedStatsNumDrawsValueLabel);
            TextView textView33 = (TextView) deckDetailsActivity.findViewById(R.id.sharedStatsPlayerCount);
            MTStats stats = mTDeck4.getStats();
            if (stats != null) {
                if (stats.getGames() > 0) {
                    try {
                        textView2 = textView33;
                        try {
                            float f = Float.parseFloat(stats.getRate());
                            r40 = Math.abs(f) <= Float.MAX_VALUE ? 1 : 0;
                            try {
                                if (r40 != 0) {
                                    r40 = "0 ";
                                    try {
                                        r42 = r2;
                                        try {
                                            r2 = obj;
                                            try {
                                                textView10.setText(new StringBuilder().append(MathKt.roundToInt(f)).append(r2).toString());
                                                obj = textView21;
                                            } catch (NumberFormatException unused) {
                                                textView3 = textView20;
                                                r2 = r2;
                                                r40 = r40;
                                                r42 = r42;
                                                obj = textView21;
                                                textView10.setText("--");
                                                textView10.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                                                textView12.setText(String.valueOf(stats.getGames()));
                                                if (stats.getGames() != 1) {
                                                }
                                                if (mTFormat != null) {
                                                }
                                                textView17.setVisibility(8);
                                                textView14.setText(String.valueOf(stats.getWins()));
                                                textView16.setText(String.valueOf(stats.getLosses()));
                                                textView18.setText(String.valueOf(stats.getDraws()));
                                                textView13.setText("-");
                                                textView13.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                                                textView15.setText("-");
                                                textView15.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                                                onThePlay = stats.getOnThePlay();
                                                if (onThePlay == null) {
                                                }
                                                onTheDraw = stats.getOnTheDraw();
                                                if (onTheDraw == null) {
                                                }
                                                sharedStats = stats.getSharedStats();
                                                if (sharedStats == null) {
                                                }
                                                Unit unit43 = Unit.INSTANCE;
                                                FrameLayout frameLayout = (FrameLayout) findViewById(R.id.statsPrivacyOverlay);
                                                if (isOtherUserDeck()) {
                                                }
                                                frameLayout.setVisibility(i);
                                                View viewFindViewById19 = findViewById(R.id.externalURLLayout);
                                                Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
                                                ConstraintLayout constraintLayout8 = (ConstraintLayout) viewFindViewById19;
                                                View viewFindViewById20 = findViewById(R.id.row1Layout);
                                                Intrinsics.checkNotNullExpressionValue(viewFindViewById20, "findViewById(...)");
                                                LinearLayout linearLayout5 = (LinearLayout) viewFindViewById20;
                                                View viewFindViewById21 = findViewById(R.id.row2Layout);
                                                Intrinsics.checkNotNullExpressionValue(viewFindViewById21, "findViewById(...)");
                                                LinearLayout linearLayout6 = (LinearLayout) viewFindViewById21;
                                                View viewFindViewById22 = findViewById(R.id.externalURLValueLabel);
                                                Intrinsics.checkNotNullExpressionValue(viewFindViewById22, "findViewById(...)");
                                                TextView textView34 = (TextView) viewFindViewById22;
                                                View viewFindViewById23 = findViewById(R.id.syncButtonLayout);
                                                Intrinsics.checkNotNullExpressionValue(viewFindViewById23, "findViewById(...)");
                                                ConstraintLayout constraintLayout9 = (ConstraintLayout) viewFindViewById23;
                                                externalurl = mTDeck4.getExternalurl();
                                                if (externalurl == null) {
                                                }
                                                View viewFindViewById24 = findViewById(R.id.playmatLayoutInner);
                                                Intrinsics.checkNotNullExpressionValue(viewFindViewById24, "findViewById(...)");
                                                ((ConstraintLayout) viewFindViewById24).setClipToOutline(true);
                                                View viewFindViewById25 = findViewById(R.id.playmatImageView);
                                                Intrinsics.checkNotNullExpressionValue(viewFindViewById25, "findViewById(...)");
                                                loadingImageViewPlaymat = (LoadingImageViewPlaymat) viewFindViewById25;
                                                loadingImageViewPlaymat.setAutoLoad(false);
                                                if (mTDeck4.getRightplaymat() == null) {
                                                    if (this.lastLoadedPlaymatUrl == null) {
                                                    }
                                                    DeckUtils companion = DeckUtils.INSTANCE.getInstance();
                                                    Function1<? super MTPlaymatData, Unit> function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda173
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj2) {
                                                            return DeckDetailsActivity.updateUI$lambda$0$10(this.f$0, loadingImageViewPlaymat, (MTPlaymatData) obj2);
                                                        }
                                                    };
                                                    Function1<? super String, Unit> function12 = new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda174
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj2) {
                                                            return DeckDetailsActivity.updateUI$lambda$0$11(this.f$0, loadingImageViewPlaymat, (String) obj2);
                                                        }
                                                    };
                                                    deckDetailsActivity2 = this;
                                                    companion.fetchPlaymatURL(deckDetailsActivity3, mTDeck4, "right", function1, function12);
                                                    mTDeck2 = mTDeck4;
                                                }
                                                zComputeIsSmartDeck = deckDetailsActivity2.computeIsSmartDeck(mTDeck2);
                                                deckDetailsActivity2.isSmartDeck = zComputeIsSmartDeck;
                                                if (!zComputeIsSmartDeck) {
                                                    deckDetailsActivity2.currentGroupBy = "type";
                                                }
                                                constraintLayout = (ConstraintLayout) deckDetailsActivity2.findViewById(R.id.smartDeckHeaderLayout);
                                                if (constraintLayout != null) {
                                                }
                                                textView = (TextView) deckDetailsActivity2.findViewById(R.id.smartDeckConvertButton);
                                                if (deckDetailsActivity2.isSmartDeck) {
                                                    deckDetailsActivity2.clearSmartDeckEffects();
                                                    deckDetailsActivity2.deckIdCardResponse = null;
                                                    deckDetailsActivity2.idCardFetchedForDeckId = null;
                                                    deckDetailsActivity2.idCardGaugesAnimatedForDeckId = null;
                                                    if (deckDetailsActivity2.loaded) {
                                                        applyDeckIdCardScoresUi$default(deckDetailsActivity2, null, null, 2, null);
                                                        if (textView != null) {
                                                        }
                                                    }
                                                }
                                                View viewFindViewById26 = deckDetailsActivity2.findViewById(R.id.addButtonLayout);
                                                Intrinsics.checkNotNullExpressionValue(viewFindViewById26, "findViewById(...)");
                                                constraintLayout2 = (ConstraintLayout) viewFindViewById26;
                                                View viewFindViewById27 = deckDetailsActivity2.findViewById(R.id.scanButtonLayout);
                                                Intrinsics.checkNotNullExpressionValue(viewFindViewById27, "findViewById(...)");
                                                constraintLayout3 = (ConstraintLayout) viewFindViewById27;
                                                View viewFindViewById28 = deckDetailsActivity2.findViewById(R.id.legacyAddButtonLayout);
                                                Intrinsics.checkNotNullExpressionValue(viewFindViewById28, "findViewById(...)");
                                                constraintLayout4 = (ConstraintLayout) viewFindViewById28;
                                                if (deckDetailsActivity2.loaded) {
                                                    constraintLayout3.setVisibility(8);
                                                    constraintLayout2.setVisibility(8);
                                                    constraintLayout4.setVisibility(8);
                                                    customGlowView = (CustomGlowView) deckDetailsActivity2.findViewById(R.id.addButtonGlowView);
                                                    if (customGlowView != null) {
                                                    }
                                                }
                                                deckDetailsActivity2.updateAddButtonForSmartDeck();
                                                Unit unit44 = Unit.INSTANCE;
                                                Unit unit45 = Unit.INSTANCE;
                                            }
                                            try {
                                                textView3 = textView20;
                                                textView10.setTextColor(GameUtils.INSTANCE.getInstance().getWinRateColor(this, f, Integer.valueOf(mTDeck4.getFormatid())));
                                                r2 = r2;
                                                obj = obj;
                                                r40 = r40;
                                                r42 = r42;
                                            } catch (NumberFormatException unused2) {
                                                textView3 = textView20;
                                                textView10.setText("--");
                                                textView10.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                                            }
                                        } catch (NumberFormatException unused3) {
                                            textView3 = textView20;
                                            r2 = obj;
                                            r40 = r40;
                                            r42 = r42;
                                            obj = textView21;
                                            textView10.setText("--");
                                            textView10.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                                            textView12.setText(String.valueOf(stats.getGames()));
                                            if (stats.getGames() != 1) {
                                            }
                                            if (mTFormat != null) {
                                            }
                                            textView17.setVisibility(8);
                                            textView14.setText(String.valueOf(stats.getWins()));
                                            textView16.setText(String.valueOf(stats.getLosses()));
                                            textView18.setText(String.valueOf(stats.getDraws()));
                                            textView13.setText("-");
                                            textView13.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                                            textView15.setText("-");
                                            textView15.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                                            onThePlay = stats.getOnThePlay();
                                            if (onThePlay == null) {
                                            }
                                            onTheDraw = stats.getOnTheDraw();
                                            if (onTheDraw == null) {
                                            }
                                            sharedStats = stats.getSharedStats();
                                            if (sharedStats == null) {
                                            }
                                            Unit unit432 = Unit.INSTANCE;
                                            FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.statsPrivacyOverlay);
                                            if (isOtherUserDeck()) {
                                            }
                                            frameLayout2.setVisibility(i);
                                            View viewFindViewById192 = findViewById(R.id.externalURLLayout);
                                            Intrinsics.checkNotNullExpressionValue(viewFindViewById192, "findViewById(...)");
                                            ConstraintLayout constraintLayout82 = (ConstraintLayout) viewFindViewById192;
                                            View viewFindViewById202 = findViewById(R.id.row1Layout);
                                            Intrinsics.checkNotNullExpressionValue(viewFindViewById202, "findViewById(...)");
                                            LinearLayout linearLayout52 = (LinearLayout) viewFindViewById202;
                                            View viewFindViewById212 = findViewById(R.id.row2Layout);
                                            Intrinsics.checkNotNullExpressionValue(viewFindViewById212, "findViewById(...)");
                                            LinearLayout linearLayout62 = (LinearLayout) viewFindViewById212;
                                            View viewFindViewById222 = findViewById(R.id.externalURLValueLabel);
                                            Intrinsics.checkNotNullExpressionValue(viewFindViewById222, "findViewById(...)");
                                            TextView textView342 = (TextView) viewFindViewById222;
                                            View viewFindViewById232 = findViewById(R.id.syncButtonLayout);
                                            Intrinsics.checkNotNullExpressionValue(viewFindViewById232, "findViewById(...)");
                                            ConstraintLayout constraintLayout92 = (ConstraintLayout) viewFindViewById232;
                                            externalurl = mTDeck4.getExternalurl();
                                            if (externalurl == null) {
                                            }
                                            View viewFindViewById242 = findViewById(R.id.playmatLayoutInner);
                                            Intrinsics.checkNotNullExpressionValue(viewFindViewById242, "findViewById(...)");
                                            ((ConstraintLayout) viewFindViewById242).setClipToOutline(true);
                                            View viewFindViewById252 = findViewById(R.id.playmatImageView);
                                            Intrinsics.checkNotNullExpressionValue(viewFindViewById252, "findViewById(...)");
                                            loadingImageViewPlaymat = (LoadingImageViewPlaymat) viewFindViewById252;
                                            loadingImageViewPlaymat.setAutoLoad(false);
                                            if (mTDeck4.getRightplaymat() == null) {
                                            }
                                            zComputeIsSmartDeck = deckDetailsActivity2.computeIsSmartDeck(mTDeck2);
                                            deckDetailsActivity2.isSmartDeck = zComputeIsSmartDeck;
                                            if (!zComputeIsSmartDeck) {
                                            }
                                            constraintLayout = (ConstraintLayout) deckDetailsActivity2.findViewById(R.id.smartDeckHeaderLayout);
                                            if (constraintLayout != null) {
                                            }
                                            textView = (TextView) deckDetailsActivity2.findViewById(R.id.smartDeckConvertButton);
                                            if (deckDetailsActivity2.isSmartDeck) {
                                            }
                                            View viewFindViewById262 = deckDetailsActivity2.findViewById(R.id.addButtonLayout);
                                            Intrinsics.checkNotNullExpressionValue(viewFindViewById262, "findViewById(...)");
                                            constraintLayout2 = (ConstraintLayout) viewFindViewById262;
                                            View viewFindViewById272 = deckDetailsActivity2.findViewById(R.id.scanButtonLayout);
                                            Intrinsics.checkNotNullExpressionValue(viewFindViewById272, "findViewById(...)");
                                            constraintLayout3 = (ConstraintLayout) viewFindViewById272;
                                            View viewFindViewById282 = deckDetailsActivity2.findViewById(R.id.legacyAddButtonLayout);
                                            Intrinsics.checkNotNullExpressionValue(viewFindViewById282, "findViewById(...)");
                                            constraintLayout4 = (ConstraintLayout) viewFindViewById282;
                                            if (deckDetailsActivity2.loaded) {
                                            }
                                            deckDetailsActivity2.updateAddButtonForSmartDeck();
                                            Unit unit442 = Unit.INSTANCE;
                                            Unit unit452 = Unit.INSTANCE;
                                        }
                                    } catch (NumberFormatException unused4) {
                                        r42 = r2;
                                        textView3 = textView20;
                                        r2 = obj;
                                        r40 = r40;
                                        r42 = r42;
                                        obj = textView21;
                                        textView10.setText("--");
                                        textView10.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                                        textView12.setText(String.valueOf(stats.getGames()));
                                        if (stats.getGames() != 1) {
                                        }
                                        if (mTFormat != null) {
                                        }
                                        textView17.setVisibility(8);
                                        textView14.setText(String.valueOf(stats.getWins()));
                                        textView16.setText(String.valueOf(stats.getLosses()));
                                        textView18.setText(String.valueOf(stats.getDraws()));
                                        textView13.setText("-");
                                        textView13.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                                        textView15.setText("-");
                                        textView15.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                                        onThePlay = stats.getOnThePlay();
                                        if (onThePlay == null) {
                                        }
                                        onTheDraw = stats.getOnTheDraw();
                                        if (onTheDraw == null) {
                                        }
                                        sharedStats = stats.getSharedStats();
                                        if (sharedStats == null) {
                                        }
                                        Unit unit4322 = Unit.INSTANCE;
                                        FrameLayout frameLayout22 = (FrameLayout) findViewById(R.id.statsPrivacyOverlay);
                                        if (isOtherUserDeck()) {
                                        }
                                        frameLayout22.setVisibility(i);
                                        View viewFindViewById1922 = findViewById(R.id.externalURLLayout);
                                        Intrinsics.checkNotNullExpressionValue(viewFindViewById1922, "findViewById(...)");
                                        ConstraintLayout constraintLayout822 = (ConstraintLayout) viewFindViewById1922;
                                        View viewFindViewById2022 = findViewById(R.id.row1Layout);
                                        Intrinsics.checkNotNullExpressionValue(viewFindViewById2022, "findViewById(...)");
                                        LinearLayout linearLayout522 = (LinearLayout) viewFindViewById2022;
                                        View viewFindViewById2122 = findViewById(R.id.row2Layout);
                                        Intrinsics.checkNotNullExpressionValue(viewFindViewById2122, "findViewById(...)");
                                        LinearLayout linearLayout622 = (LinearLayout) viewFindViewById2122;
                                        View viewFindViewById2222 = findViewById(R.id.externalURLValueLabel);
                                        Intrinsics.checkNotNullExpressionValue(viewFindViewById2222, "findViewById(...)");
                                        TextView textView3422 = (TextView) viewFindViewById2222;
                                        View viewFindViewById2322 = findViewById(R.id.syncButtonLayout);
                                        Intrinsics.checkNotNullExpressionValue(viewFindViewById2322, "findViewById(...)");
                                        ConstraintLayout constraintLayout922 = (ConstraintLayout) viewFindViewById2322;
                                        externalurl = mTDeck4.getExternalurl();
                                        if (externalurl == null) {
                                        }
                                        View viewFindViewById2422 = findViewById(R.id.playmatLayoutInner);
                                        Intrinsics.checkNotNullExpressionValue(viewFindViewById2422, "findViewById(...)");
                                        ((ConstraintLayout) viewFindViewById2422).setClipToOutline(true);
                                        View viewFindViewById2522 = findViewById(R.id.playmatImageView);
                                        Intrinsics.checkNotNullExpressionValue(viewFindViewById2522, "findViewById(...)");
                                        loadingImageViewPlaymat = (LoadingImageViewPlaymat) viewFindViewById2522;
                                        loadingImageViewPlaymat.setAutoLoad(false);
                                        if (mTDeck4.getRightplaymat() == null) {
                                        }
                                        zComputeIsSmartDeck = deckDetailsActivity2.computeIsSmartDeck(mTDeck2);
                                        deckDetailsActivity2.isSmartDeck = zComputeIsSmartDeck;
                                        if (!zComputeIsSmartDeck) {
                                        }
                                        constraintLayout = (ConstraintLayout) deckDetailsActivity2.findViewById(R.id.smartDeckHeaderLayout);
                                        if (constraintLayout != null) {
                                        }
                                        textView = (TextView) deckDetailsActivity2.findViewById(R.id.smartDeckConvertButton);
                                        if (deckDetailsActivity2.isSmartDeck) {
                                        }
                                        View viewFindViewById2622 = deckDetailsActivity2.findViewById(R.id.addButtonLayout);
                                        Intrinsics.checkNotNullExpressionValue(viewFindViewById2622, "findViewById(...)");
                                        constraintLayout2 = (ConstraintLayout) viewFindViewById2622;
                                        View viewFindViewById2722 = deckDetailsActivity2.findViewById(R.id.scanButtonLayout);
                                        Intrinsics.checkNotNullExpressionValue(viewFindViewById2722, "findViewById(...)");
                                        constraintLayout3 = (ConstraintLayout) viewFindViewById2722;
                                        View viewFindViewById2822 = deckDetailsActivity2.findViewById(R.id.legacyAddButtonLayout);
                                        Intrinsics.checkNotNullExpressionValue(viewFindViewById2822, "findViewById(...)");
                                        constraintLayout4 = (ConstraintLayout) viewFindViewById2822;
                                        if (deckDetailsActivity2.loaded) {
                                        }
                                        deckDetailsActivity2.updateAddButtonForSmartDeck();
                                        Unit unit4422 = Unit.INSTANCE;
                                        Unit unit4522 = Unit.INSTANCE;
                                    }
                                } else {
                                    r40 = "0 ";
                                    r42 = r2;
                                    textView3 = textView20;
                                    r2 = obj;
                                    obj = textView21;
                                    textView10.setText("--");
                                    textView10.setTextColor(ContextCompat.getColor(this, R.color.text_color));
                                }
                            } catch (NumberFormatException unused5) {
                            }
                        } catch (NumberFormatException unused6) {
                            r40 = "0 ";
                        }
                    } catch (NumberFormatException unused7) {
                        r40 = "0 ";
                        r42 = r2;
                        textView2 = textView33;
                    }
                    textView12.setText(String.valueOf(stats.getGames()));
                    if (stats.getGames() != 1) {
                        textView11.setText(getResources().getString(R.string.games_singular));
                    } else {
                        textView11.setText(getResources().getString(R.string.games_plural));
                    }
                    if (mTFormat != null) {
                        if (mTFormat.getPlayersmax() == 2 && mTFormat.getPlayersmin() == 2) {
                            if (stats.getGames() == 1) {
                                textView11.setText(getResources().getString(R.string.matches_singular));
                            } else {
                                textView11.setText(getResources().getString(R.string.matches_plural));
                            }
                        }
                        Unit unit46 = Unit.INSTANCE;
                        Unit unit47 = Unit.INSTANCE;
                    }
                    textView17.setVisibility(8);
                    textView14.setText(String.valueOf(stats.getWins()));
                    textView16.setText(String.valueOf(stats.getLosses()));
                    textView18.setText(String.valueOf(stats.getDraws()));
                    textView13.setText("-");
                    textView13.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                    textView15.setText("-");
                    textView15.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                    onThePlay = stats.getOnThePlay();
                    if (onThePlay == null) {
                        if (onThePlay.getGames() == 0) {
                            textView19.setText("--");
                            textView19.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                        } else {
                            try {
                                float f2 = Float.parseFloat(onThePlay.getRate());
                                if (Math.abs(f2) <= Float.MAX_VALUE) {
                                    textView19.setText(new StringBuilder().append(MathKt.roundToInt(f2)).append(r2).toString());
                                    textView19.setTextColor(GameUtils.INSTANCE.getInstance().getWinRateColor(this, f2, Integer.valueOf(mTDeck4.getFormatid())));
                                } else {
                                    textView19.setText("--");
                                    textView19.setTextColor(ContextCompat.getColor(this, R.color.text_color));
                                }
                            } catch (NumberFormatException unused8) {
                                textView19.setText("--");
                                textView19.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                            }
                        }
                        if (onThePlay.getGames() == 1) {
                            textView3.setText(onThePlay.getGames() + " " + getResources().getString(R.string.games_singular));
                        } else {
                            textView3.setText(onThePlay.getGames() + " " + getResources().getString(R.string.games_plural));
                        }
                        obj.setText(String.valueOf(onThePlay.getWins()));
                        r42.setText(String.valueOf(onThePlay.getLosses()));
                        textView22.setText(String.valueOf(onThePlay.getDraws()));
                        Unit unit48 = Unit.INSTANCE;
                        r5 = r40;
                    } else {
                        textView19.setText("--");
                        textView19.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                        ?? r52 = r40;
                        textView3.setText(((String) r52) + getResources().getString(R.string.games_singular));
                        obj.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        r42.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        textView22.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        Unit unit49 = Unit.INSTANCE;
                        r5 = r52;
                    }
                    onTheDraw = stats.getOnTheDraw();
                    if (onTheDraw == null) {
                        if (onTheDraw.getGames() == 0) {
                            textView23.setText("--");
                            textView23.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                        } else {
                            try {
                                float f3 = Float.parseFloat(onTheDraw.getRate());
                                if (Math.abs(f3) <= Float.MAX_VALUE) {
                                    textView23.setText(new StringBuilder().append(MathKt.roundToInt(f3)).append(r2).toString());
                                    textView23.setTextColor(GameUtils.INSTANCE.getInstance().getWinRateColor(this, f3, Integer.valueOf(mTDeck4.getFormatid())));
                                } else {
                                    textView23.setText("--");
                                    textView23.setTextColor(ContextCompat.getColor(this, R.color.text_color));
                                }
                            } catch (NumberFormatException unused9) {
                                textView23.setText("--");
                                textView23.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                            }
                        }
                        if (onTheDraw.getGames() == 1) {
                            textView24.setText(onTheDraw.getGames() + " " + getResources().getString(R.string.games_singular));
                        } else {
                            textView24.setText(onTheDraw.getGames() + " " + getResources().getString(R.string.games_plural));
                        }
                        textView25.setText(String.valueOf(onTheDraw.getWins()));
                        textView26.setText(String.valueOf(onTheDraw.getLosses()));
                        textView27.setText(String.valueOf(onTheDraw.getDraws()));
                        Unit unit50 = Unit.INSTANCE;
                    } else {
                        textView23.setText("--");
                        textView23.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                        textView24.setText(((String) r5) + getResources().getString(R.string.games_singular));
                        textView25.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        textView26.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        textView27.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        Unit unit51 = Unit.INSTANCE;
                    }
                    sharedStats = stats.getSharedStats();
                    if (sharedStats == null) {
                        linearLayout4.setVisibility(0);
                        if (sharedStats.getGames() == 0) {
                            textView28.setText("--");
                            textView28.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                        } else {
                            try {
                                float f4 = Float.parseFloat(sharedStats.getRate());
                                if (Math.abs(f4) <= Float.MAX_VALUE) {
                                    textView28.setText(new StringBuilder().append(MathKt.roundToInt(f4)).append(r2).toString());
                                    textView28.setTextColor(GameUtils.INSTANCE.getInstance().getWinRateColor(this, f4, Integer.valueOf(mTDeck4.getFormatid())));
                                } else {
                                    textView28.setText("--");
                                    textView28.setTextColor(ContextCompat.getColor(this, R.color.text_color));
                                }
                            } catch (NumberFormatException unused10) {
                                textView28.setText("--");
                                textView28.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                            }
                        }
                        if (sharedStats.getGames() == 1) {
                            textView29.setText(sharedStats.getGames() + " " + getResources().getString(R.string.games_singular));
                        } else {
                            textView29.setText(sharedStats.getGames() + " " + getResources().getString(R.string.games_plural));
                        }
                        textView30.setText(String.valueOf(sharedStats.getWins()));
                        textView31.setText(String.valueOf(sharedStats.getLosses()));
                        textView32.setText(String.valueOf(sharedStats.getDraws()));
                        List<MTSharedPlayer> players = sharedStats.getPlayers();
                        int size = (players != null ? players.size() : 0) + (!isOtherUserDeck() ? 1 : 0);
                        textView2.setText(getResources().getString(size == 1 ? R.string.player_singular : R.string.players_plural_count, Integer.valueOf(size)));
                        Intrinsics.checkNotNull(linearLayout4);
                        ViewExtensionsKt.setOnClickWithFade(linearLayout4, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda169
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeckDetailsActivity.updateUI$lambda$0$6$5$0(this.f$0, sharedStats);
                            }
                        });
                        Unit unit52 = Unit.INSTANCE;
                    } else {
                        linearLayout4.setVisibility(8);
                        Unit unit53 = Unit.INSTANCE;
                    }
                } else {
                    textView10.setText("--");
                    textView10.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                    textView12.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    textView11.setText(getResources().getString(R.string.games_singular));
                    textView17.setVisibility(8);
                    textView14.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    textView16.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    textView18.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    textView13.setText("-");
                    textView13.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                    textView15.setText("-");
                    textView15.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                    textView19.setText("--");
                    textView19.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                    textView20.setText("0 " + getResources().getString(R.string.games_singular));
                    textView21.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    r2.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    textView22.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    textView23.setText("--");
                    textView23.setTextColor(ContextCompat.getColor(deckDetailsActivity3, R.color.text_color));
                    textView24.setText("0 " + getResources().getString(R.string.games_singular));
                    textView25.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    textView26.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    textView27.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    linearLayout4.setVisibility(8);
                }
                Unit unit43222 = Unit.INSTANCE;
            } else {
                linearLayout4.setVisibility(8);
                Unit unit54 = Unit.INSTANCE;
            }
            FrameLayout frameLayout222 = (FrameLayout) findViewById(R.id.statsPrivacyOverlay);
            if (isOtherUserDeck()) {
                MTDeckPrivacy mTDeckPrivacy = this.currentDeckPrivacy;
                if ((mTDeckPrivacy == null || (options = mTDeckPrivacy.getOptions()) == null) ? false : Intrinsics.areEqual((Object) options.getShare_stats(), (Object) false)) {
                    i = 0;
                }
            } else {
                i = 8;
            }
            frameLayout222.setVisibility(i);
            View viewFindViewById19222 = findViewById(R.id.externalURLLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById19222, "findViewById(...)");
            ConstraintLayout constraintLayout8222 = (ConstraintLayout) viewFindViewById19222;
            View viewFindViewById20222 = findViewById(R.id.row1Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById20222, "findViewById(...)");
            LinearLayout linearLayout5222 = (LinearLayout) viewFindViewById20222;
            View viewFindViewById21222 = findViewById(R.id.row2Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById21222, "findViewById(...)");
            LinearLayout linearLayout6222 = (LinearLayout) viewFindViewById21222;
            View viewFindViewById22222 = findViewById(R.id.externalURLValueLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById22222, "findViewById(...)");
            TextView textView34222 = (TextView) viewFindViewById22222;
            View viewFindViewById23222 = findViewById(R.id.syncButtonLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById23222, "findViewById(...)");
            ConstraintLayout constraintLayout9222 = (ConstraintLayout) viewFindViewById23222;
            externalurl = mTDeck4.getExternalurl();
            if (externalurl == null) {
                String str2 = externalurl;
                if (str2.length() == 0) {
                    constraintLayout8222.setVisibility(8);
                    linearLayout6222.setVisibility(8);
                } else {
                    constraintLayout8222.setVisibility(0);
                    textView34222.setText(str2);
                    boolean zIsValidDeckUrl = isValidDeckUrl(externalurl);
                    if (isOtherUserDeck() || this.isDuplicatedDeck) {
                        linearLayout6222.setVisibility(8);
                    } else if (zIsValidDeckUrl) {
                        linearLayout6222.setVisibility(0);
                        constraintLayout9222.setVisibility(0);
                        ViewExtensionsKt.setOnClickWithFade(constraintLayout9222, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda171
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeckDetailsActivity.updateUI$lambda$0$8$0(this.f$0, externalurl);
                            }
                        });
                    } else {
                        linearLayout6222.setVisibility(0);
                        constraintLayout9222.setVisibility(8);
                    }
                    ViewExtensionsKt.setOnClickWithFade(linearLayout5222, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda172
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeckDetailsActivity.updateUI$lambda$0$8$1(this.f$0, externalurl);
                        }
                    });
                }
                Unit unit55 = Unit.INSTANCE;
            } else {
                constraintLayout8222.setVisibility(8);
                linearLayout6222.setVisibility(8);
                Unit unit56 = Unit.INSTANCE;
            }
            View viewFindViewById24222 = findViewById(R.id.playmatLayoutInner);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById24222, "findViewById(...)");
            ((ConstraintLayout) viewFindViewById24222).setClipToOutline(true);
            View viewFindViewById25222 = findViewById(R.id.playmatImageView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById25222, "findViewById(...)");
            loadingImageViewPlaymat = (LoadingImageViewPlaymat) viewFindViewById25222;
            loadingImageViewPlaymat.setAutoLoad(false);
            if (mTDeck4.getRightplaymat() == null || mTDeck4.getLeftplaymat() != null) {
                if (this.lastLoadedPlaymatUrl == null) {
                    loadingImageViewPlaymat.showLoading();
                }
                DeckUtils companion2 = DeckUtils.INSTANCE.getInstance();
                Function1<? super MTPlaymatData, Unit> function13 = new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda173
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return DeckDetailsActivity.updateUI$lambda$0$10(this.f$0, loadingImageViewPlaymat, (MTPlaymatData) obj2);
                    }
                };
                Function1<? super String, Unit> function122 = new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda174
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return DeckDetailsActivity.updateUI$lambda$0$11(this.f$0, loadingImageViewPlaymat, (String) obj2);
                    }
                };
                deckDetailsActivity2 = this;
                companion2.fetchPlaymatURL(deckDetailsActivity3, mTDeck4, "right", function13, function122);
                mTDeck2 = mTDeck4;
            } else {
                if (!Intrinsics.areEqual(this.lastLoadedPlaymatUrl, "")) {
                    this.lastLoadedPlaymatUrl = "";
                    loadingImageViewPlaymat.loadDefault();
                }
                deckDetailsActivity2 = this;
                mTDeck2 = mTDeck4;
            }
            zComputeIsSmartDeck = deckDetailsActivity2.computeIsSmartDeck(mTDeck2);
            deckDetailsActivity2.isSmartDeck = zComputeIsSmartDeck;
            if (!zComputeIsSmartDeck && Intrinsics.areEqual(deckDetailsActivity2.currentGroupBy, "theme")) {
                deckDetailsActivity2.currentGroupBy = "type";
            }
            constraintLayout = (ConstraintLayout) deckDetailsActivity2.findViewById(R.id.smartDeckHeaderLayout);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(deckDetailsActivity2.isSmartDeck ? 0 : 8);
                Unit unit57 = Unit.INSTANCE;
            }
            textView = (TextView) deckDetailsActivity2.findViewById(R.id.smartDeckConvertButton);
            if (deckDetailsActivity2.isSmartDeck || deckDetailsActivity2.isOtherUserDeck() || deckDetailsActivity2.isDuplicatedDeck) {
                deckDetailsActivity2.clearSmartDeckEffects();
                deckDetailsActivity2.deckIdCardResponse = null;
                deckDetailsActivity2.idCardFetchedForDeckId = null;
                deckDetailsActivity2.idCardGaugesAnimatedForDeckId = null;
                if (deckDetailsActivity2.loaded || deckDetailsActivity2.isOtherUserDeck() || deckDetailsActivity2.isDuplicatedDeck || mTDeck2.getFormatid() != 6) {
                    applyDeckIdCardScoresUi$default(deckDetailsActivity2, null, null, 2, null);
                    if (textView != null) {
                        textView.setVisibility(8);
                        Unit unit58 = Unit.INSTANCE;
                    }
                } else {
                    deckDetailsActivity2.showSmartDeckTeaser(mTDeck2);
                }
            } else {
                deckDetailsActivity2.setupSmartDeckEffects();
                if (textView != null) {
                    textView.setVisibility(8);
                    Unit unit59 = Unit.INSTANCE;
                }
            }
            View viewFindViewById26222 = deckDetailsActivity2.findViewById(R.id.addButtonLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById26222, "findViewById(...)");
            constraintLayout2 = (ConstraintLayout) viewFindViewById26222;
            View viewFindViewById27222 = deckDetailsActivity2.findViewById(R.id.scanButtonLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById27222, "findViewById(...)");
            constraintLayout3 = (ConstraintLayout) viewFindViewById27222;
            View viewFindViewById28222 = deckDetailsActivity2.findViewById(R.id.legacyAddButtonLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById28222, "findViewById(...)");
            constraintLayout4 = (ConstraintLayout) viewFindViewById28222;
            if (deckDetailsActivity2.loaded || deckDetailsActivity2.isOtherUserDeck() || deckDetailsActivity2.isDuplicatedDeck) {
                constraintLayout3.setVisibility(8);
                constraintLayout2.setVisibility(8);
                constraintLayout4.setVisibility(8);
                customGlowView = (CustomGlowView) deckDetailsActivity2.findViewById(R.id.addButtonGlowView);
                if (customGlowView != null) {
                    customGlowView.setVisibility(8);
                    Unit unit60 = Unit.INSTANCE;
                }
            } else if (deckDetailsActivity2.currentTabIndex == 0) {
                constraintLayout3.setVisibility(0);
                constraintLayout2.setVisibility(0);
                MTDeck mTDeck5 = deckDetailsActivity2.currentDeck;
                if (mTDeck5 != null && mTDeck5.getFormatid() == 6) {
                    constraintLayout4.setVisibility(0);
                } else {
                    constraintLayout4.setVisibility(8);
                }
            }
            deckDetailsActivity2.updateAddButtonForSmartDeck();
            Unit unit44222 = Unit.INSTANCE;
            Unit unit45222 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUI$lambda$0$10(DeckDetailsActivity deckDetailsActivity, LoadingImageViewPlaymat loadingImageViewPlaymat, MTPlaymatData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(data.getPlaymatImageURL(), deckDetailsActivity.lastLoadedPlaymatUrl)) {
            return Unit.INSTANCE;
        }
        deckDetailsActivity.lastLoadedPlaymatUrl = data.getPlaymatImageURL();
        loadingImageViewPlaymat.setImageUrl(data.getPlaymatImageURL());
        loadingImageViewPlaymat.setRightArtCrop(data.isArtCrop());
        loadingImageViewPlaymat.loadImages();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUI$lambda$0$11(DeckDetailsActivity deckDetailsActivity, LoadingImageViewPlaymat loadingImageViewPlaymat, String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        if (!Intrinsics.areEqual(deckDetailsActivity.lastLoadedPlaymatUrl, "")) {
            deckDetailsActivity.lastLoadedPlaymatUrl = "";
            loadingImageViewPlaymat.loadDefault();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUI$lambda$0$3(final DeckDetailsActivity deckDetailsActivity, final MTDeck mTDeck, final TextView textView, final ConstraintLayout constraintLayout, final TextView textView2, final TextView textView3, final ConstraintLayout constraintLayout2) {
        ArrayList arrayListEmptyList;
        MTCardContainer main;
        List<MTCardGroup> grouped_cards;
        if (deckDetailsActivity.isDuplicatedDeck) {
            return Unit.INSTANCE;
        }
        BracketDialogFragment.Companion companion = BracketDialogFragment.INSTANCE;
        MTDeckLists mTDeckLists = deckDetailsActivity.currentLists;
        if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || (grouped_cards = main.getGrouped_cards()) == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = grouped_cards.iterator();
            while (it.hasNext()) {
                List<MTFullCard> cards = ((MTCardGroup) it.next()).getCards();
                if (cards == null) {
                    cards = CollectionsKt.emptyList();
                }
                CollectionsKt.addAll(arrayList, cards);
            }
            arrayListEmptyList = arrayList;
        }
        companion.setDeckCardList(arrayListEmptyList);
        BracketDialogFragment.Builder bracketInfo = new BracketDialogFragment.Builder().setBracketInfo(mTDeck.getBracket());
        MTBracket bracket = mTDeck.getBracket();
        BracketDialogFragment.Builder onBracketRecalculated = bracketInfo.setInitialUserBracket(bracket != null ? bracket.getUser() : null).setDeckId(Integer.valueOf(mTDeck.getId())).setOnCloseCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda61
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeckDetailsActivity.updateUI$lambda$0$3$1(mTDeck, deckDetailsActivity, (Integer) obj);
            }
        }).setOnBracketRecalculated(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda62
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeckDetailsActivity.updateUI$lambda$0$3$2(textView, mTDeck, constraintLayout, textView2, textView3, deckDetailsActivity, constraintLayout2, ((Integer) obj).intValue());
            }
        });
        FragmentManager supportFragmentManager = deckDetailsActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        onBracketRecalculated.show(supportFragmentManager, "BracketDialogFragment");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUI$lambda$0$3$1(MTDeck mTDeck, final DeckDetailsActivity deckDetailsActivity, Integer num) {
        MTBracket bracket = mTDeck.getBracket();
        if (!Intrinsics.areEqual(num, bracket != null ? bracket.getUser() : null)) {
            MTUser currentUser = new PreferencesManager(deckDetailsActivity).getCurrentUser();
            if ((currentUser != null ? Integer.valueOf(currentUser.getId()) : null) == null) {
                return Unit.INSTANCE;
            }
            deckDetailsActivity.showLoadingOverlay();
            (num != null ? MTApiKt.getMtApi().setBracket(currentUser.getId(), mTDeck.getId(), new MTBracketBody(num)) : MTApiKt.getMtApi().setBracket(currentUser.getId(), mTDeck.getId(), RequestBody.INSTANCE.create("{\"bracket\":null}", MediaType.INSTANCE.parse("application/json")))).enqueue(new Callback<MTSingleDeckResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$updateUI$1$3$2$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTSingleDeckResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.isDestroyed() || this.this$0.isFinishing()) {
                        return;
                    }
                    this.this$0.hideLoadingOverlay();
                    DeckDetailsActivity deckDetailsActivity2 = this.this$0;
                    Toast.makeText(deckDetailsActivity2, deckDetailsActivity2.getString(R.string.server_error), 0).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTSingleDeckResponse> call, Response<MTSingleDeckResponse> response) {
                    MTDeck deck;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.isDestroyed() || this.this$0.isFinishing()) {
                        return;
                    }
                    this.this$0.hideLoadingOverlay();
                    if (!response.isSuccessful()) {
                        DeckDetailsActivity deckDetailsActivity2 = this.this$0;
                        Toast.makeText(deckDetailsActivity2, deckDetailsActivity2.getString(R.string.server_error), 0).show();
                        return;
                    }
                    MTSingleDeckResponse mTSingleDeckResponseBody = response.body();
                    if (mTSingleDeckResponseBody == null || (deck = mTSingleDeckResponseBody.getDeck()) == null) {
                        return;
                    }
                    DeckDetailsActivity deckDetailsActivity3 = this.this$0;
                    MTDeck mTDeck2 = deckDetailsActivity3.currentDeck;
                    if (mTDeck2 != null) {
                        mTDeck2.setBracket(deck.getBracket());
                    }
                    deckDetailsActivity3.updateUI();
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUI$lambda$0$3$2(TextView textView, MTDeck mTDeck, ConstraintLayout constraintLayout, TextView textView2, TextView textView3, DeckDetailsActivity deckDetailsActivity, ConstraintLayout constraintLayout2, int i) {
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (mTDeck.getBracket() == null) {
            mTDeck.setBracket(new MTBracket(null, null, null, null, null, 31, null));
        }
        MTBracket bracket = mTDeck.getBracket();
        if (bracket != null) {
            bracket.setAuto(Integer.valueOf(i));
        }
        MTBracket bracket2 = mTDeck.getBracket();
        if (bracket2 != null) {
            bracket2.setNeeds_recalc(false);
        }
        MTBracket bracket3 = mTDeck.getBracket();
        if ((bracket3 != null ? bracket3.getUser() : null) != null) {
            return Unit.INSTANCE;
        }
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        if (textView2 != null) {
            textView2.setText(String.valueOf(i));
        }
        if (textView3 != null) {
            textView3.setText(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? deckDetailsActivity.getString(R.string.bracket_caps) : deckDetailsActivity.getString(R.string.cedh_caps) : deckDetailsActivity.getString(R.string.optimized_caps) : deckDetailsActivity.getString(R.string.upgraded_caps) : deckDetailsActivity.getString(R.string.core_caps) : deckDetailsActivity.getString(R.string.exhibition_caps));
        }
        constraintLayout2.setVisibility(0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit updateUI$lambda$0$4$0$0(Ref.ObjectRef objectRef, Ref.BooleanRef booleanRef, MTDeck mTDeck, List list, CardRecord cardRecord) {
        String commander_color_override;
        if (cardRecord != 0) {
            objectRef.element = cardRecord;
            booleanRef.element = true;
            if (!GameUtilsKt.getColorChoosingCommanders().contains(cardRecord.getOracle_id()) || (commander_color_override = mTDeck.getCommander_color_override()) == null || commander_color_override.length() == 0) {
                for (String str : StringsKt.split$default((CharSequence) cardRecord.getIdentity(), new String[]{"|"}, false, 0, 6, (Object) null)) {
                    if (!list.contains(str) && str.length() > 0) {
                        list.add(str);
                    }
                }
            } else {
                String commander_color_override2 = mTDeck.getCommander_color_override();
                Intrinsics.checkNotNull(commander_color_override2);
                if (!list.contains(commander_color_override2)) {
                    list.add(commander_color_override2);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUI$lambda$0$4$1$0(Ref.BooleanRef booleanRef, MTDeck mTDeck, List list, CardRecord cardRecord) {
        String partner_color_override;
        if (cardRecord != null) {
            booleanRef.element = true;
            if (!GameUtilsKt.getColorChoosingCommanders().contains(cardRecord.getOracle_id()) || (partner_color_override = mTDeck.getPartner_color_override()) == null || partner_color_override.length() == 0) {
                for (String str : StringsKt.split$default((CharSequence) cardRecord.getIdentity(), new String[]{"|"}, false, 0, 6, (Object) null)) {
                    if (!list.contains(str) && str.length() > 0) {
                        list.add(str);
                    }
                }
            } else {
                String partner_color_override2 = mTDeck.getPartner_color_override();
                Intrinsics.checkNotNull(partner_color_override2);
                if (!list.contains(partner_color_override2)) {
                    list.add(partner_color_override2);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUI$lambda$0$6$5$0(DeckDetailsActivity deckDetailsActivity, MTSharedStats mTSharedStats) {
        deckDetailsActivity.showSharedStatsDialog(mTSharedStats);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUI$lambda$0$8$0(DeckDetailsActivity deckDetailsActivity, String str) {
        deckDetailsActivity.handleManualSync(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUI$lambda$0$8$1(DeckDetailsActivity deckDetailsActivity, String str) {
        Intent intent = new Intent(deckDetailsActivity, (Class<?>) WebActivity.class);
        intent.putExtra("url", str);
        deckDetailsActivity.startActivity(intent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wireCombosFilterAndSort() {
        View viewFindViewById = findViewById(R.id.combosFilterEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final EditText editText = (EditText) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.combosFilterClearButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById2;
        editText.addTextChangedListener(new C11631(imageView, this, editText));
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda98
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return DeckDetailsActivity.wireCombosFilterAndSort$lambda$0(this.f$0, editText, textView, i, keyEvent);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda99
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.wireCombosFilterAndSort$lambda$1(editText, this);
            }
        });
        View viewFindViewById3 = findViewById(R.id.completeCombosSortButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        final TextView textView = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.partialCombosSortButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        final TextView textView2 = (TextView) viewFindViewById4;
        ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda100
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.wireCombosFilterAndSort$lambda$2(this.f$0, textView);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(textView2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda101
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.wireCombosFilterAndSort$lambda$3(this.f$0, textView2);
            }
        });
        String[] stringArray = getResources().getStringArray(R.array.combos_max_cards_array);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        View viewFindViewById5 = findViewById(R.id.completeCombosMaxCardsSpinner);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        Spinner spinner = (Spinner) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.partialCombosMaxCardsSpinner);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        Spinner spinner2 = (Spinner) viewFindViewById6;
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, stringArray);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter);
        Integer num = this.completeCombosMaxCards;
        int i = 1;
        spinner.setSelection((num != null && num.intValue() == 2) ? 0 : (num != null && num.intValue() == 3) ? 1 : (num != null && num.intValue() == 4) ? 2 : 3);
        Integer num2 = this.partialCombosMaxCards;
        if (num2 != null && num2.intValue() == 2) {
            i = 0;
        } else if (num2 == null || num2.intValue() != 3) {
            i = (num2 != null && num2.intValue() == 4) ? 2 : 3;
        }
        spinner2.setSelection(i);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity.wireCombosFilterAndSort.6
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Integer numValueOf;
                DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
                int i2 = 2;
                if (position == 0) {
                    numValueOf = Integer.valueOf(i2);
                } else {
                    if (position == 1) {
                        i2 = 3;
                    } else if (position != 2) {
                        numValueOf = null;
                    } else {
                        i2 = 4;
                    }
                    numValueOf = Integer.valueOf(i2);
                }
                deckDetailsActivity.completeCombosMaxCards = numValueOf;
                DeckDetailsActivity.this.refreshCombosDisplay();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity.wireCombosFilterAndSort.7
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Integer numValueOf;
                DeckDetailsActivity deckDetailsActivity = DeckDetailsActivity.this;
                int i2 = 2;
                if (position == 0) {
                    numValueOf = Integer.valueOf(i2);
                } else {
                    if (position == 1) {
                        i2 = 3;
                    } else if (position != 2) {
                        numValueOf = null;
                    } else {
                        i2 = 4;
                    }
                    numValueOf = Integer.valueOf(i2);
                }
                deckDetailsActivity.partialCombosMaxCards = numValueOf;
                DeckDetailsActivity.this.partialCombosPagesLoaded = 1;
                DeckDetailsActivity.this.refreshCombosDisplay();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    static final boolean wireCombosFilterAndSort$lambda$0(DeckDetailsActivity deckDetailsActivity, EditText editText, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3 && i != 6) {
            return false;
        }
        Object systemService = deckDetailsActivity.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
        editText.clearFocus();
        return true;
    }

    static final Unit wireCombosFilterAndSort$lambda$1(EditText editText, DeckDetailsActivity deckDetailsActivity) {
        editText.setText("");
        Object systemService = deckDetailsActivity.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
        deckDetailsActivity.combosFilterQuery = "";
        deckDetailsActivity.partialCombosPagesLoaded = 1;
        deckDetailsActivity.refreshCombosDisplay();
        return Unit.INSTANCE;
    }

    static final Unit wireCombosFilterAndSort$lambda$2(DeckDetailsActivity deckDetailsActivity, TextView textView) {
        deckDetailsActivity.showCompleteCombosSortPopup(textView);
        return Unit.INSTANCE;
    }

    static final Unit wireCombosFilterAndSort$lambda$3(DeckDetailsActivity deckDetailsActivity, TextView textView) {
        deckDetailsActivity.showPartialCombosSortPopup(textView);
        return Unit.INSTANCE;
    }

    private final void wireSelectionToolbar() {
        if (this.selectionToolbarWired) {
            updateSelectionCountText();
            return;
        }
        this.selectionToolbarWired = true;
        getOnBackPressedDispatcher().addCallback(this, this.selectionBackCallback);
        View viewFindViewById = findViewById(R.id.selectionClearTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = findViewById(R.id.selectionSelectAllTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        View viewFindViewById3 = findViewById(R.id.selectionMoveTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        View viewFindViewById4 = findViewById(R.id.selectionDeleteTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((TextView) viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda142
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.wireSelectionToolbar$lambda$0(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade((TextView) viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda143
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.wireSelectionToolbar$lambda$1(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade((TextView) viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda144
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.wireSelectionToolbar$lambda$2(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade((TextView) viewFindViewById4, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda145
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.wireSelectionToolbar$lambda$3(this.f$0);
            }
        });
        updateSelectionCountText();
    }

    static final Unit wireSelectionToolbar$lambda$0(DeckDetailsActivity deckDetailsActivity) {
        deckDetailsActivity.exitSelectionMode();
        return Unit.INSTANCE;
    }

    static final Unit wireSelectionToolbar$lambda$1(DeckDetailsActivity deckDetailsActivity) {
        if (!deckDetailsActivity.selectionMode) {
            return Unit.INSTANCE;
        }
        deckDetailsActivity.selectAllCardsFromLockedList();
        return Unit.INSTANCE;
    }

    static final Unit wireSelectionToolbar$lambda$2(DeckDetailsActivity deckDetailsActivity) {
        if (!deckDetailsActivity.selectionMode || deckDetailsActivity.selectedCards.isEmpty()) {
            return Unit.INSTANCE;
        }
        deckDetailsActivity.bulkMoveSelectedCards();
        return Unit.INSTANCE;
    }

    static final Unit wireSelectionToolbar$lambda$3(DeckDetailsActivity deckDetailsActivity) {
        if (!deckDetailsActivity.selectionMode || deckDetailsActivity.selectedCards.isEmpty()) {
            return Unit.INSTANCE;
        }
        deckDetailsActivity.bulkDeleteSelectedCards();
        return Unit.INSTANCE;
    }

    public final void activateDeckChanges() {
        final PreferencesManager preferencesManager = new PreferencesManager(this);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null) {
            return;
        }
        MTDeck mTDeck = this.currentDeck;
        int id = mTDeck != null ? mTDeck.getId() : this.intentDeckId;
        showLoadingOverlay();
        MTApiKt.getMtApi().forkDeck(currentUser.getId(), currentUser.getId(), id).enqueue(new Callback<MTForkDeckResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity.activateDeckChanges.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTForkDeckResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (DeckDetailsActivity.this.isDestroyed() || DeckDetailsActivity.this.isFinishing()) {
                    return;
                }
                DeckDetailsActivity.this.hideLoadingOverlay();
                Toast.makeText(DeckDetailsActivity.this, R.string.fork_deck_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTForkDeckResponse> call, Response<MTForkDeckResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (DeckDetailsActivity.this.isDestroyed() || DeckDetailsActivity.this.isFinishing()) {
                    return;
                }
                DeckDetailsActivity.this.hideLoadingOverlay();
                MTForkDeckResponse mTForkDeckResponseBody = response.body();
                Integer newDeckId = mTForkDeckResponseBody != null ? mTForkDeckResponseBody.getNewDeckId() : null;
                if (!response.isSuccessful() || newDeckId == null) {
                    Toast.makeText(DeckDetailsActivity.this, R.string.fork_deck_error, 0).show();
                    return;
                }
                preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                preferencesManager.setForcedApiUpdate(true);
                Intent intent = new Intent(DeckDetailsActivity.this, (Class<?>) DeckDetailsActivity.class);
                intent.putExtra("deckId", newDeckId.intValue());
                DeckDetailsActivity.this.startActivity(intent);
                DeckDetailsActivity.this.finish();
            }
        });
    }

    public final void duplicateDeck() {
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        if (currentUser == null) {
            return;
        }
        MTDeck mTDeck = this.currentDeck;
        int id = mTDeck != null ? mTDeck.getId() : this.intentDeckId;
        showLoadingOverlay();
        MTApiKt.getMtApi().duplicateDeck(currentUser.getId(), this.otherUserId, id).enqueue(new Callback<MTDuplicateDeckResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity.duplicateDeck.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTDuplicateDeckResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (DeckDetailsActivity.this.isDestroyed() || DeckDetailsActivity.this.isFinishing()) {
                    return;
                }
                DeckDetailsActivity.this.hideLoadingOverlay();
                Toast.makeText(DeckDetailsActivity.this, R.string.duplicate_deck_error, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTDuplicateDeckResponse> call, Response<MTDuplicateDeckResponse> response) {
                MTDuplicateDeckResponse mTDuplicateDeckResponseBody;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (DeckDetailsActivity.this.isDestroyed() || DeckDetailsActivity.this.isFinishing()) {
                    return;
                }
                DeckDetailsActivity.this.hideLoadingOverlay();
                if (!response.isSuccessful() || (mTDuplicateDeckResponseBody = response.body()) == null || !mTDuplicateDeckResponseBody.getSuccess()) {
                    Toast.makeText(DeckDetailsActivity.this, R.string.duplicate_deck_error, 0).show();
                } else {
                    DeckDetailsActivity.this.otherUserId = -1;
                    DeckDetailsActivity.this.updateDeck();
                }
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.OnComboClickListener
    public void onComboClicked(final MTCombo combo) {
        LinkedHashMap linkedHashMapEmptyMap;
        MTCardContainer main;
        List<MTCardGroup> grouped_cards;
        MTCombo combo2 = combo;
        Intrinsics.checkNotNullParameter(combo2, "combo");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        MTDeckLists mTDeckLists = this.currentLists;
        if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || (grouped_cards = main.getGrouped_cards()) == null) {
            linkedHashMapEmptyMap = MapsKt.emptyMap();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = grouped_cards.iterator();
            while (it.hasNext()) {
                List<MTFullCard> cards = ((MTCardGroup) it.next()).getCards();
                if (cards == null) {
                    cards = CollectionsKt.emptyList();
                }
                CollectionsKt.addAll(arrayList, cards);
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((MTFullCard) obj).getOracleid() != null) {
                    arrayList2.add(obj);
                }
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : arrayList2) {
                if (hashSet.add(((MTFullCard) obj2).getOracleid())) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = arrayList3;
            linkedHashMapEmptyMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList4, 10)), 16));
            for (Object obj3 : arrayList4) {
                String oracleid = ((MTFullCard) obj3).getOracleid();
                Intrinsics.checkNotNull(oracleid);
                linkedHashMapEmptyMap.put(oracleid, obj3);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        int i = 0;
        for (Object obj4 : combo2.getCards()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MTComboCard mTComboCard = (MTComboCard) obj4;
            MTFullCard mTFullCard = (MTFullCard) linkedHashMapEmptyMap.get(mTComboCard.getOracleId());
            if (mTFullCard != null) {
                arrayList5.add(mTFullCard);
            } else {
                arrayList5.add(null);
                arrayList6.add(TuplesKt.to(Integer.valueOf(i), mTComboCard));
            }
            i = i2;
        }
        if (arrayList6.isEmpty()) {
            launchComboCardActivity(combo2, CollectionsKt.filterNotNull(arrayList5));
            return;
        }
        showLoadingOverlay();
        int size = arrayList6.size();
        final MTFullCard[] mTFullCardArr = new MTFullCard[size];
        for (int i3 = 0; i3 < size; i3++) {
            mTFullCardArr[i3] = null;
        }
        Ref.IntRef intRef = new Ref.IntRef();
        int size2 = arrayList6.size();
        DeckDetailsActivity deckDetailsActivity = this;
        MTGDBHelper companion = MTGDBHelper.INSTANCE.getInstance(deckDetailsActivity);
        MTUser currentUser = new PreferencesManager(deckDetailsActivity).getCurrentUser();
        Integer numValueOf = currentUser != null ? Integer.valueOf(currentUser.getId()) : null;
        final int i4 = 0;
        for (Object obj5 : arrayList6) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MTGDBHelper.FirstPrintInfo firstPrintInfo = companion.getFirstPrintInfo(((MTComboCard) ((Pair) obj5).component2()).getOracleId(), 0);
            if (firstPrintInfo == null) {
                mTFullCardArr[i4] = null;
                MTFullCard[] mTFullCardArr2 = mTFullCardArr;
                onComboClicked$tryFinish(intRef, size2, this, mTFullCardArr2, arrayList6, combo2, arrayList5);
                mTFullCardArr = mTFullCardArr2;
            } else {
                Call<MTFullCardResponse> cardWithParameters = MTApiKt.getMtApi().getCardWithParameters("en", firstPrintInfo.getSetCode(), firstPrintInfo.getCollectorNumber(), numValueOf);
                final ArrayList arrayList7 = arrayList5;
                final ArrayList arrayList8 = arrayList6;
                final Ref.IntRef intRef2 = intRef;
                final int i6 = size2;
                Callback<MTFullCardResponse> callback = new Callback<MTFullCardResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onComboClicked$2$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTFullCardResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                            return;
                        }
                        MTFullCard[] mTFullCardArr3 = mTFullCardArr;
                        mTFullCardArr3[i4] = null;
                        DeckDetailsActivity.onComboClicked$tryFinish(intRef2, i6, this.this$0, mTFullCardArr3, arrayList8, combo, arrayList7);
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTFullCardResponse> call, Response<MTFullCardResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                            return;
                        }
                        MTFullCard[] mTFullCardArr3 = mTFullCardArr;
                        int i7 = i4;
                        MTFullCardResponse mTFullCardResponseBody = response.body();
                        mTFullCardArr3[i7] = mTFullCardResponseBody != null ? mTFullCardResponseBody.getCard() : null;
                        DeckDetailsActivity.onComboClicked$tryFinish(intRef2, i6, this.this$0, mTFullCardArr, arrayList8, combo, arrayList7);
                    }
                };
                intRef = intRef2;
                size2 = i6;
                arrayList6 = arrayList8;
                arrayList5 = arrayList7;
                cardWithParameters.enqueue(callback);
            }
            combo2 = combo;
            i4 = i5;
        }
    }

    @Override // com.studiolaganne.lengendarylens.OnComboClickListener
    public void onComboOpenInSpellbook(MTCombo combo) {
        Intrinsics.checkNotNullParameter(combo, "combo");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        String str = "https://commanderspellbook.com/combo/" + combo.getId();
        Intent intent = new Intent(this, (Class<?>) WebActivity.class);
        intent.putExtra("url", str);
        startActivity(intent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onCreate(Bundle savedInstanceState) {
        DeckDisplayMode deckDisplayMode;
        Object next;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_details);
        int intExtra = getIntent().getIntExtra("deckId", -1);
        if (intExtra == -1) {
            finish();
            return;
        }
        this.intentDeckId = intExtra;
        this.otherUserId = getIntent().getIntExtra("otherUserId", -1);
        DeckDetailsActivity deckDetailsActivity = this;
        PreferencesManager preferencesManager = new PreferencesManager(deckDetailsActivity);
        String string = preferencesManager.getString(PreferencesManager.LAST_DECK_LAYOUT_TYPE, "list");
        switch (string.hashCode()) {
            case 3322014:
                deckDisplayMode = !string.equals("list") ? DeckDisplayMode.TWO_COLUMN_STACKS : DeckDisplayMode.LIST;
                break;
            case 1302694877:
                if (string.equals("stacks_1")) {
                    deckDisplayMode = DeckDisplayMode.ONE_COLUMN_STACKS;
                    break;
                }
                break;
            case 1302694878:
                if (string.equals("stacks_2")) {
                    deckDisplayMode = DeckDisplayMode.TWO_COLUMN_STACKS;
                    break;
                }
                break;
        }
        this.currentDisplayMode = deckDisplayMode;
        this.ignoreCollection = preferencesManager.getBoolean(PreferencesManager.IGNORE_COLLECTION, false);
        this.ignorePrintings = preferencesManager.getBoolean(PreferencesManager.IGNORE_PRINTINGS, false);
        this.ignoreBasicLands = preferencesManager.getBoolean(PreferencesManager.IGNORE_BASIC_LANDS, true);
        if (preferencesManager.getSaveDeckListSortingGroupingSettings()) {
            String lastDeckListGroupBy = preferencesManager.getLastDeckListGroupBy();
            if (lastDeckListGroupBy != null) {
                this.currentGroupBy = lastDeckListGroupBy;
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            String lastDeckListOrderBy = preferencesManager.getLastDeckListOrderBy();
            if (lastDeckListOrderBy != null) {
                this.currentSortBy = lastDeckListOrderBy;
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
            String lastDeckListOrderDirection = preferencesManager.getLastDeckListOrderDirection();
            if (lastDeckListOrderDirection != null) {
                this.currentSortDirection = lastDeckListOrderDirection;
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
            }
        }
        ImageView imageView = (ImageView) findViewById(R.id.clearFilterImage);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.filterLayout);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.masterFilterLayout);
        final View viewFindViewById = findViewById(R.id.separator3);
        final LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.activeFilterLayout);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R.id.filterSummaryLayout);
        this.formatsForFilter = DecksDBHelper.INSTANCE.getInstance(deckDetailsActivity).getFormats();
        linearLayout.setVisibility(8);
        viewFindViewById.setVisibility(8);
        linearLayout2.setVisibility(8);
        Intrinsics.checkNotNull(imageView);
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$3(this.f$0, linearLayout, linearLayout2);
            }
        });
        Intrinsics.checkNotNull(constraintLayout2);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda45
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$4(this.f$0);
            }
        });
        Intrinsics.checkNotNull(constraintLayout);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda46
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$5(this.f$0);
            }
        });
        final MTUser currentUser = preferencesManager.getCurrentUser();
        if (isOtherUserDeck()) {
            this.ignoreCollection = true;
        }
        if (currentUser != null) {
            if (isOtherUserDeck()) {
                String stringExtra = getIntent().getStringExtra("otherUserDeck");
                if (stringExtra != null) {
                    try {
                        this.currentDeck = (MTDeck) new Gson().fromJson(stringExtra, MTDeck.class);
                    } catch (Exception unused) {
                    }
                    Unit unit7 = Unit.INSTANCE;
                    Unit unit8 = Unit.INSTANCE;
                }
            } else {
                Iterator<T> it = preferencesManager.getCurrentUserDecks().iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (((MTDeck) next).getId() == intExtra) {
                        }
                    } else {
                        next = null;
                    }
                }
                this.currentDeck = (MTDeck) next;
                Unit unit9 = Unit.INSTANCE;
            }
            preferencesManager.resetDeckListSelection();
            Unit unit10 = Unit.INSTANCE;
            Unit unit11 = Unit.INSTANCE;
        }
        TextView textView = (TextView) findViewById(R.id.descriptionTextView);
        TextView textView2 = (TextView) findViewById(R.id.editIconTextView);
        Intrinsics.checkNotNull(textView);
        ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda47
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$7(this.f$0);
            }
        });
        Intrinsics.checkNotNull(textView2);
        ViewExtensionsKt.setOnClickWithFade(textView2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda48
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$8(this.f$0);
            }
        });
        View viewFindViewById2 = findViewById(R.id.backLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda49
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$9(this.f$0);
            }
        });
        View viewFindViewById3 = findViewById(R.id.dotsLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        final ConstraintLayout constraintLayout3 = (ConstraintLayout) viewFindViewById3;
        ViewExtensionsKt.setOnClickWithFade(constraintLayout3, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda50
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$10(this.f$0, constraintLayout3, currentUser);
            }
        });
        View viewFindViewById4 = findViewById(R.id.cardsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        final RecyclerView recyclerView = (RecyclerView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.sideboardRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        RecyclerView recyclerView2 = (RecyclerView) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.maybeboardRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        RecyclerView recyclerView3 = (RecyclerView) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.twoColumnStackedCardsView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        final TwoColumnStackedCardsView twoColumnStackedCardsView = (TwoColumnStackedCardsView) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.deckCardsToolbarLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        final LinearLayout linearLayout3 = (LinearLayout) viewFindViewById8;
        View viewFindViewById9 = findViewById(R.id.displayModeToggle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        View viewFindViewById10 = findViewById(R.id.gamesRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        final RecyclerView recyclerView4 = (RecyclerView) viewFindViewById10;
        View viewFindViewById11 = findViewById(R.id.noGamesTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        final TextView textView3 = (TextView) viewFindViewById11;
        final LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.loadingAnimationViewRecyclerView);
        View viewFindViewById12 = findViewById(R.id.statsLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        final ConstraintLayout constraintLayout4 = (ConstraintLayout) viewFindViewById12;
        final View viewFindViewById13 = findViewById(R.id.combosLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        View viewFindViewById14 = findViewById(R.id.noCombosTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        final TextView textView4 = (TextView) viewFindViewById14;
        View viewFindViewById15 = findViewById(R.id.completeCombosSection);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        final LinearLayout linearLayout4 = (LinearLayout) viewFindViewById15;
        View viewFindViewById16 = findViewById(R.id.partialCombosSection);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        final LinearLayout linearLayout5 = (LinearLayout) viewFindViewById16;
        View viewFindViewById17 = findViewById(R.id.matchupsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        final RecyclerView recyclerView5 = (RecyclerView) viewFindViewById17;
        View viewFindViewById18 = findViewById(R.id.noMatchupsTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        final TextView textView5 = (TextView) viewFindViewById18;
        View viewFindViewById19 = findViewById(R.id.bottomBarLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        final LinearLayout linearLayout6 = (LinearLayout) viewFindViewById19;
        View viewFindViewById20 = findViewById(R.id.addButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById20, "findViewById(...)");
        final ConstraintLayout constraintLayout5 = (ConstraintLayout) viewFindViewById20;
        View viewFindViewById21 = findViewById(R.id.scanButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById21, "findViewById(...)");
        final ConstraintLayout constraintLayout6 = (ConstraintLayout) viewFindViewById21;
        View viewFindViewById22 = findViewById(R.id.filterIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById22, "findViewById(...)");
        TextView textView6 = (TextView) viewFindViewById22;
        textView6.setVisibility(0);
        final View viewFindViewById23 = findViewById(R.id.deckCardsFilterBarLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById23, "findViewById(...)");
        View viewFindViewById24 = findViewById(R.id.deckCardsFilterEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById24, "findViewById(...)");
        final EditText editText = (EditText) viewFindViewById24;
        View viewFindViewById25 = findViewById(R.id.deckCardsFilterClearButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById25, "findViewById(...)");
        final ImageView imageView2 = (ImageView) viewFindViewById25;
        ViewExtensionsKt.setOnClickWithFade(textView6, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda51
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$11(viewFindViewById23, editText, this);
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity.onCreate.13
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                imageView2.setVisibility((s == null || s.length() <= 0) ? 8 : 0);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda52
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView7, int i, KeyEvent keyEvent) {
                return DeckDetailsActivity.onCreate$lambda$12(this.f$0, editText, textView7, i, keyEvent);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda53
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$13(editText, this);
            }
        });
        linearLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeckDetailsActivity.onCreate$lambda$14(view);
            }
        });
        View viewFindViewById26 = findViewById(R.id.toolbarSettingsIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById26, "findViewById(...)");
        final TextView textView7 = (TextView) viewFindViewById26;
        textView7.setVisibility((isOtherUserDeck() || this.isDuplicatedDeck) ? 8 : 0);
        if (!isOtherUserDeck() && !this.isDuplicatedDeck) {
            ViewExtensionsKt.setOnClickWithFade(textView7, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda38
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DeckDetailsActivity.onCreate$lambda$15(this.f$0, textView7);
                }
            });
        }
        View viewFindViewById27 = findViewById(R.id.toolbarCollectionStatusView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById27, "findViewById(...)");
        CollectionStatusView collectionStatusView = (CollectionStatusView) viewFindViewById27;
        collectionStatusView.setVisibility((this.ignoreCollection || isOtherUserDeck() || this.isDuplicatedDeck) ? 8 : 0);
        collectionStatusView.setStatus(CollectionStatus.EXACT_MATCH_NOT_FETCHED);
        ViewExtensionsKt.setOnClickWithFade(collectionStatusView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$16(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithBounce(constraintLayout6, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$17(this.f$0);
            }
        });
        final ConstraintLayout constraintLayout7 = (ConstraintLayout) findViewById(R.id.legacyAddButtonLayout);
        Intrinsics.checkNotNull(constraintLayout7);
        ViewExtensionsKt.setOnClickWithBounce(constraintLayout7, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$18(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithBounce(constraintLayout5, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckDetailsActivity.onCreate$lambda$19(this.f$0);
            }
        });
        constraintLayout6.setVisibility(8);
        constraintLayout5.setVisibility(8);
        constraintLayout7.setVisibility(8);
        linearLayout6.setVisibility(0);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        Iterator it2 = CollectionsKt.listOf((Object[]) new String[]{getString(R.string.cards_tab), getString(R.string.games_tab), getString(R.string.stats_tab), getString(R.string.combos_tab)}).iterator();
        while (it2.hasNext()) {
            tabLayout.addTab(tabLayout.newTab().setText((String) it2.next()));
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity.onCreate.23

            /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.DeckDetailsActivity$onCreate$23$WhenMappings */
            /* JADX INFO: compiled from: DeckDetailsActivity.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[DeckDisplayMode.values().length];
                    try {
                        iArr[DeckDisplayMode.TWO_COLUMN_STACKS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                Integer numValueOf = tab != null ? Integer.valueOf(tab.getPosition()) : null;
                if (numValueOf != null && numValueOf.intValue() == 0) {
                    DeckDetailsActivity.this.currentTabIndex = 0;
                    linearLayout.setVisibility(8);
                    linearLayout2.setVisibility(8);
                    viewFindViewById.setVisibility(8);
                    linearLayout6.setVisibility(0);
                    if (!DeckDetailsActivity.this.isOtherUserDeck() && !DeckDetailsActivity.this.isDuplicatedDeck) {
                        constraintLayout5.setVisibility(0);
                        constraintLayout6.setVisibility(0);
                        MTDeck mTDeck = DeckDetailsActivity.this.currentDeck;
                        if (mTDeck != null && mTDeck.getFormatid() == 6) {
                            constraintLayout7.setVisibility(0);
                        }
                    }
                    linearLayout3.setVisibility(0);
                    View viewFindViewById28 = DeckDetailsActivity.this.findViewById(R.id.cardsRecyclerView);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById28, "findViewById(...)");
                    RecyclerView recyclerView6 = (RecyclerView) viewFindViewById28;
                    View viewFindViewById29 = DeckDetailsActivity.this.findViewById(R.id.twoColumnStackedCardsView);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById29, "findViewById(...)");
                    TwoColumnStackedCardsView twoColumnStackedCardsView2 = (TwoColumnStackedCardsView) viewFindViewById29;
                    if (WhenMappings.$EnumSwitchMapping$0[DeckDetailsActivity.this.currentDisplayMode.ordinal()] == 1) {
                        recyclerView6.setVisibility(8);
                        twoColumnStackedCardsView2.setVisibility(0);
                    } else {
                        recyclerView6.setVisibility(0);
                        twoColumnStackedCardsView2.setVisibility(8);
                    }
                    View viewFindViewById30 = DeckDetailsActivity.this.findViewById(R.id.sideboardSection);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById30, "findViewById(...)");
                    LinearLayout linearLayout7 = (LinearLayout) viewFindViewById30;
                    View viewFindViewById31 = DeckDetailsActivity.this.findViewById(R.id.maybeboardSection);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById31, "findViewById(...)");
                    LinearLayout linearLayout8 = (LinearLayout) viewFindViewById31;
                    MTDeckLists mTDeckLists = DeckDetailsActivity.this.currentLists;
                    if ((mTDeckLists != null ? mTDeckLists.getSideboard() : null) != null) {
                        linearLayout7.setVisibility(0);
                    } else {
                        linearLayout7.setVisibility(8);
                    }
                    MTDeckLists mTDeckLists2 = DeckDetailsActivity.this.currentLists;
                    if ((mTDeckLists2 != null ? mTDeckLists2.getMaybeboard() : null) != null) {
                        linearLayout8.setVisibility(0);
                    } else {
                        linearLayout8.setVisibility(8);
                    }
                    recyclerView4.setVisibility(8);
                    textView3.setVisibility(8);
                    lottieAnimationView.setVisibility(8);
                    constraintLayout4.setVisibility(8);
                    viewFindViewById13.setVisibility(8);
                    recyclerView5.setVisibility(8);
                    textView5.setVisibility(8);
                    View viewFindViewById32 = DeckDetailsActivity.this.findViewById(R.id.manaCurveSection);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById32, "findViewById(...)");
                    View viewFindViewById33 = DeckDetailsActivity.this.findViewById(R.id.manaCurveSeparator);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById33, "findViewById(...)");
                    ((LinearLayout) viewFindViewById32).setVisibility(8);
                    viewFindViewById33.setVisibility(8);
                    DeckDetailsActivity.this.updateSeeTokensTextViewVisibility();
                    View viewFindViewById34 = DeckDetailsActivity.this.findViewById(R.id.manaProductionSection);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById34, "findViewById(...)");
                    View viewFindViewById35 = DeckDetailsActivity.this.findViewById(R.id.manaProductionSeparator);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById35, "findViewById(...)");
                    ((LinearLayout) viewFindViewById34).setVisibility(8);
                    viewFindViewById35.setVisibility(8);
                    return;
                }
                if (numValueOf != null && numValueOf.intValue() == 1) {
                    if (DeckDetailsActivity.this.selectionMode) {
                        DeckDetailsActivity.this.exitSelectionMode();
                    }
                    DeckDetailsActivity.this.currentTabIndex = 1;
                    recyclerView.setVisibility(8);
                    twoColumnStackedCardsView.setVisibility(8);
                    linearLayout3.setVisibility(8);
                    linearLayout.setVisibility(0);
                    linearLayout6.setVisibility(8);
                    constraintLayout5.setVisibility(8);
                    constraintLayout6.setVisibility(8);
                    constraintLayout7.setVisibility(8);
                    View viewFindViewById36 = DeckDetailsActivity.this.findViewById(R.id.sideboardSection);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById36, "findViewById(...)");
                    View viewFindViewById37 = DeckDetailsActivity.this.findViewById(R.id.maybeboardSection);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById37, "findViewById(...)");
                    ((LinearLayout) viewFindViewById36).setVisibility(8);
                    ((LinearLayout) viewFindViewById37).setVisibility(8);
                    View viewFindViewById38 = DeckDetailsActivity.this.findViewById(R.id.manaCurveSection);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById38, "findViewById(...)");
                    View viewFindViewById39 = DeckDetailsActivity.this.findViewById(R.id.manaCurveSeparator);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById39, "findViewById(...)");
                    ((LinearLayout) viewFindViewById38).setVisibility(8);
                    viewFindViewById39.setVisibility(8);
                    View viewFindViewById40 = DeckDetailsActivity.this.findViewById(R.id.manaProductionSection);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById40, "findViewById(...)");
                    View viewFindViewById41 = DeckDetailsActivity.this.findViewById(R.id.manaProductionSeparator);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById41, "findViewById(...)");
                    ((LinearLayout) viewFindViewById40).setVisibility(8);
                    viewFindViewById41.setVisibility(8);
                    DeckDetailsActivity.this.updateSeeTokensTextViewVisibility();
                    boolean z = DeckDetailsActivity.this.loaded;
                    RecyclerView recyclerView7 = recyclerView4;
                    if (z) {
                        recyclerView7.setVisibility(0);
                        textView3.setVisibility(DeckDetailsActivity.this.games.isEmpty() ? 0 : 8);
                        lottieAnimationView.setVisibility(8);
                    } else {
                        recyclerView7.setVisibility(0);
                        textView3.setVisibility(8);
                        lottieAnimationView.setVisibility(0);
                    }
                    constraintLayout4.setVisibility(8);
                    viewFindViewById13.setVisibility(8);
                    recyclerView5.setVisibility(8);
                    textView5.setVisibility(8);
                    return;
                }
                if (numValueOf != null && numValueOf.intValue() == 2) {
                    if (DeckDetailsActivity.this.selectionMode) {
                        DeckDetailsActivity.this.exitSelectionMode();
                    }
                    DeckDetailsActivity.this.currentTabIndex = 2;
                    linearLayout.setVisibility(0);
                    recyclerView.setVisibility(8);
                    twoColumnStackedCardsView.setVisibility(8);
                    linearLayout3.setVisibility(8);
                    recyclerView4.setVisibility(8);
                    textView3.setVisibility(8);
                    lottieAnimationView.setVisibility(8);
                    constraintLayout4.setVisibility(0);
                    recyclerView5.setVisibility(0);
                    linearLayout6.setVisibility(8);
                    constraintLayout5.setVisibility(8);
                    constraintLayout6.setVisibility(8);
                    constraintLayout7.setVisibility(8);
                    View viewFindViewById42 = DeckDetailsActivity.this.findViewById(R.id.sideboardSection);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById42, "findViewById(...)");
                    View viewFindViewById43 = DeckDetailsActivity.this.findViewById(R.id.maybeboardSection);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById43, "findViewById(...)");
                    ((LinearLayout) viewFindViewById42).setVisibility(8);
                    ((LinearLayout) viewFindViewById43).setVisibility(8);
                    DeckDetailsActivity.this.updateSeeTokensTextViewVisibility();
                    DeckDetailsActivity.this.setupManaCurveChart();
                    DeckDetailsActivity.this.setupManaProduction();
                    boolean zIsEmpty = DeckDetailsActivity.this.matchups.isEmpty();
                    TextView textView8 = textView5;
                    if (zIsEmpty) {
                        textView8.setVisibility(0);
                    } else {
                        textView8.setVisibility(8);
                    }
                    viewFindViewById13.setVisibility(8);
                    return;
                }
                if (numValueOf != null && numValueOf.intValue() == 3) {
                    if (DeckDetailsActivity.this.selectionMode) {
                        DeckDetailsActivity.this.exitSelectionMode();
                    }
                    DeckDetailsActivity.this.currentTabIndex = 3;
                    linearLayout.setVisibility(8);
                    linearLayout2.setVisibility(8);
                    viewFindViewById.setVisibility(8);
                    linearLayout6.setVisibility(8);
                    constraintLayout5.setVisibility(8);
                    constraintLayout6.setVisibility(8);
                    constraintLayout7.setVisibility(8);
                    linearLayout3.setVisibility(8);
                    recyclerView.setVisibility(8);
                    twoColumnStackedCardsView.setVisibility(8);
                    recyclerView4.setVisibility(8);
                    textView3.setVisibility(8);
                    constraintLayout4.setVisibility(8);
                    recyclerView5.setVisibility(8);
                    textView5.setVisibility(8);
                    View viewFindViewById44 = DeckDetailsActivity.this.findViewById(R.id.sideboardSection);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById44, "findViewById(...)");
                    View viewFindViewById45 = DeckDetailsActivity.this.findViewById(R.id.maybeboardSection);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById45, "findViewById(...)");
                    ((LinearLayout) viewFindViewById44).setVisibility(8);
                    ((LinearLayout) viewFindViewById45).setVisibility(8);
                    View viewFindViewById46 = DeckDetailsActivity.this.findViewById(R.id.manaCurveSection);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById46, "findViewById(...)");
                    View viewFindViewById47 = DeckDetailsActivity.this.findViewById(R.id.manaCurveSeparator);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById47, "findViewById(...)");
                    ((LinearLayout) viewFindViewById46).setVisibility(8);
                    viewFindViewById47.setVisibility(8);
                    View viewFindViewById48 = DeckDetailsActivity.this.findViewById(R.id.manaProductionSection);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById48, "findViewById(...)");
                    View viewFindViewById49 = DeckDetailsActivity.this.findViewById(R.id.manaProductionSeparator);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById49, "findViewById(...)");
                    ((LinearLayout) viewFindViewById48).setVisibility(8);
                    viewFindViewById49.setVisibility(8);
                    DeckDetailsActivity.this.updateSeeTokensTextViewVisibility();
                    if (DeckDetailsActivity.this.combosLoaded) {
                        lottieAnimationView.setVisibility(8);
                        viewFindViewById13.setVisibility(0);
                        return;
                    }
                    MTUser currentUser2 = new PreferencesManager(DeckDetailsActivity.this).getCurrentUser();
                    MTDeck mTDeck2 = DeckDetailsActivity.this.currentDeck;
                    Integer numValueOf2 = mTDeck2 != null ? Integer.valueOf(mTDeck2.getId()) : null;
                    if (currentUser2 == null || numValueOf2 == null || numValueOf2.intValue() < 0) {
                        lottieAnimationView.setVisibility(8);
                        viewFindViewById13.setVisibility(0);
                        textView4.setVisibility(0);
                        linearLayout4.setVisibility(8);
                        linearLayout5.setVisibility(8);
                        return;
                    }
                    lottieAnimationView.setVisibility(0);
                    viewFindViewById13.setVisibility(8);
                    Call<MTCombosResponse> combosForDeck = MTApiKt.getMtApi().getCombosForDeck(currentUser2.getId(), numValueOf2.intValue(), 1);
                    final DeckDetailsActivity deckDetailsActivity2 = DeckDetailsActivity.this;
                    final LottieAnimationView lottieAnimationView2 = lottieAnimationView;
                    final View view = viewFindViewById13;
                    final TextView textView9 = textView4;
                    final LinearLayout linearLayout9 = linearLayout4;
                    final LinearLayout linearLayout10 = linearLayout5;
                    combosForDeck.enqueue(new Callback<MTCombosResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onCreate$23$onTabSelected$1
                        @Override // retrofit2.Callback
                        public void onFailure(Call<MTCombosResponse> call, Throwable t) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(t, "t");
                            if (deckDetailsActivity2.isDestroyed() || deckDetailsActivity2.isFinishing()) {
                                return;
                            }
                            deckDetailsActivity2.combosLoaded = true;
                            lottieAnimationView2.setVisibility(8);
                            view.setVisibility(0);
                            textView9.setVisibility(0);
                            linearLayout9.setVisibility(8);
                            linearLayout10.setVisibility(8);
                        }

                        @Override // retrofit2.Callback
                        public void onResponse(Call<MTCombosResponse> call, Response<MTCombosResponse> response) {
                            List<MTCombo> listEmptyList;
                            List<MTCombo> listEmptyList2;
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(response, "response");
                            if (deckDetailsActivity2.isDestroyed() || deckDetailsActivity2.isFinishing()) {
                                return;
                            }
                            deckDetailsActivity2.combosLoaded = true;
                            lottieAnimationView2.setVisibility(8);
                            view.setVisibility(0);
                            MTCombosResponse mTCombosResponseBody = response.body();
                            if (mTCombosResponseBody == null || (listEmptyList = mTCombosResponseBody.getComplete()) == null) {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            if (mTCombosResponseBody == null || (listEmptyList2 = mTCombosResponseBody.getPartial()) == null) {
                                listEmptyList2 = CollectionsKt.emptyList();
                            }
                            deckDetailsActivity2.allCompleteCombos = listEmptyList;
                            deckDetailsActivity2.allPartialCombos = listEmptyList2;
                            deckDetailsActivity2.partialCombosPagesLoaded = 1;
                            if (!deckDetailsActivity2.combosUiWired) {
                                deckDetailsActivity2.wireCombosFilterAndSort();
                                deckDetailsActivity2.combosUiWired = true;
                            }
                            deckDetailsActivity2.refreshCombosDisplay();
                        }
                    });
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(deckDetailsActivity);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setItemPrefetchEnabled(false);
        recyclerView4.setLayoutManager(linearLayoutManager);
        recyclerView4.setNestedScrollingEnabled(false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView2.setNestedScrollingEnabled(false);
        recyclerView3.setNestedScrollingEnabled(false);
        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollableLayout);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda43
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                DeckDetailsActivity.onCreate$lambda$21(scrollView, this);
            }
        });
        updateUI();
        setupDisplayModeToggle();
        setupSortAndGroupButtons();
        setupErrorPopupManager();
        setupSideboardAndMaybeboard();
        setupSeeTokensTextView();
        setupManaCurveChart();
        setupManaProduction();
        updateDeck();
    }

    @Override // com.studiolaganne.lengendarylens.DeckCardMenuCallback
    public void onDeckCardCollectionStatus(MTFullCard card, final int listId) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        if (this.ignoreBasicLands) {
            String type_line = card.getType_line();
            if (type_line == null) {
                type_line = "";
            }
            String lowerCase = type_line.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "basic", false, 2, (Object) null)) {
                String lowerCase2 = type_line.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "land", false, 2, (Object) null)) {
                    CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                    String string = getString(R.string.collection_status_not_available);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    CustomDialogFragment.Builder title = builder.setTitle(string);
                    String string2 = getString(R.string.collection_status_basic_land_info);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    CustomDialogFragment.Builder body = title.setBody(string2);
                    String string3 = getString(R.string.ok);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda79
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DeckDetailsActivity.onDeckCardCollectionStatus$lambda$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                        }
                    });
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                    positiveButton.show(supportFragmentManager, "collection_status_basic_land_info_dialog");
                    return;
                }
            }
        }
        MTCardCollectionStatus collection = card.getCollection();
        boolean zAreEqual = collection != null ? Intrinsics.areEqual((Object) collection.getIn(), (Object) true) : false;
        if (Intrinsics.areEqual((Object) card.getProxy(), (Object) true)) {
            onDeckCardEdit(card, listId);
            return;
        }
        if (zAreEqual) {
            CollectionRestoreDialogFragment.Builder onResultListener = new CollectionRestoreDialogFragment.Builder().setCards(buildCardListForCollectionStatus(card)).setOnResultListener(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda80
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeckDetailsActivity.onDeckCardCollectionStatus$lambda$1(this.f$0, listId, (MultiCardCollectionRestoreDialogResult) obj);
                }
            });
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
            onResultListener.show(supportFragmentManager2, "collection_restore_dialog");
            return;
        }
        CollectionStatusDialogFragment.Builder onResultListener2 = new CollectionStatusDialogFragment.Builder().setCards(buildCardListForCollectionStatus(card)).setOnResultListener(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda81
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeckDetailsActivity.onDeckCardCollectionStatus$lambda$2(this.f$0, listId, (MultiCardCollectionStatusDialogResult) obj);
            }
        });
        FragmentManager supportFragmentManager3 = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager3, "getSupportFragmentManager(...)");
        onResultListener2.show(supportFragmentManager3, "collection_status_dialog");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v6, types: [T, android.app.AlertDialog] */
    @Override // com.studiolaganne.lengendarylens.DeckCardMenuCallback
    public void onDeckCardCommanderColorClick(MTFullCard card, int listId) {
        final MTDeck mTDeck;
        Intrinsics.checkNotNullParameter(card, "card");
        if (isFinishing() || isDestroyed() || (mTDeck = this.currentDeck) == null) {
            return;
        }
        Intrinsics.checkNotNull(mTDeck);
        DeckDetailsActivity deckDetailsActivity = this;
        final MTUser currentUser = new PreferencesManager(deckDetailsActivity).getCurrentUser();
        if (currentUser == null) {
            return;
        }
        Integer flag = card.getFlag();
        final boolean z = flag != null && flag.intValue() == 1;
        Integer flag2 = card.getFlag();
        boolean z2 = flag2 != null && flag2.intValue() == 2;
        if (z || z2) {
            List<Pair> listListOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(ExifInterface.LONGITUDE_WEST, Integer.valueOf(R.drawable.symbol_w)), TuplesKt.to("U", Integer.valueOf(R.drawable.symbol_u)), TuplesKt.to("B", Integer.valueOf(R.drawable.symbol_b)), TuplesKt.to("R", Integer.valueOf(R.drawable.symbol_r)), TuplesKt.to(GameUtils.CONDITION_GOOD, Integer.valueOf(R.drawable.symbol_g))});
            LinearLayout linearLayout = new LinearLayout(deckDetailsActivity);
            linearLayout.setOrientation(0);
            linearLayout.setPadding(GameUtils.INSTANCE.getInstance().dpToPx(24, deckDetailsActivity), GameUtils.INSTANCE.getInstance().dpToPx(16, deckDetailsActivity), GameUtils.INSTANCE.getInstance().dpToPx(24, deckDetailsActivity), GameUtils.INSTANCE.getInstance().dpToPx(16, deckDetailsActivity));
            int iDpToPx = GameUtils.INSTANCE.getInstance().dpToPx(48, deckDetailsActivity);
            int iDpToPx2 = GameUtils.INSTANCE.getInstance().dpToPx(8, deckDetailsActivity);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            for (Pair pair : listListOf) {
                final String str = (String) pair.component1();
                int iIntValue = ((Number) pair.component2()).intValue();
                final ImageView imageView = new ImageView(deckDetailsActivity);
                imageView.setImageResource(iIntValue);
                imageView.setPadding(iDpToPx2, iDpToPx2, iDpToPx2, iDpToPx2);
                ImageView imageView2 = imageView;
                final DeckDetailsActivity deckDetailsActivity2 = this;
                ViewExtensionsKt.setOnClickWithFade(imageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda163
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeckDetailsActivity.onDeckCardCommanderColorClick$lambda$1$0$0(objectRef, imageView, z, str, currentUser, mTDeck, deckDetailsActivity2);
                    }
                });
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iDpToPx, iDpToPx);
                layoutParams.setMargins(iDpToPx2, 0, iDpToPx2, 0);
                Unit unit = Unit.INSTANCE;
                linearLayout.addView(imageView2, layoutParams);
                this = deckDetailsActivity2;
            }
            DeckDetailsActivity deckDetailsActivity3 = this;
            objectRef.element = new AlertDialog.Builder(deckDetailsActivity).setTitle(deckDetailsActivity3.getString(R.string.commander_color_choose_title)).setView(linearLayout).setNegativeButton(deckDetailsActivity3.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda164
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).create();
            AlertDialog alertDialog = (AlertDialog) objectRef.element;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.DeckCardMenuCallback
    public void onDeckCardDelete(MTFullCard card, final int listId) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        List<Integer> variant_list_card_ids = card.getVariant_list_card_ids();
        if (variant_list_card_ids == null && (variant_list_card_ids = card.getList_card_ids()) == null) {
            variant_list_card_ids = CollectionsKt.emptyList();
        }
        int size = variant_list_card_ids.size();
        if (size == 0) {
            return;
        }
        String printed_name = card.getPrinted_name();
        if (printed_name == null && (printed_name = card.getName()) == null) {
            printed_name = "";
        }
        DeleteCardDialogFragment.Builder onDeleteConfirmed = new DeleteCardDialogFragment.Builder().setCardName(printed_name).setMaxQuantity(size).setListCardIds(variant_list_card_ids).setOnDeleteConfirmed(new Function3() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda55
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DeckDetailsActivity.onDeckCardDelete$lambda$0(this.f$0, listId, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue(), (List) obj3);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        onDeleteConfirmed.show(supportFragmentManager, "DeleteCardDialogFragment");
    }

    @Override // com.studiolaganne.lengendarylens.DeckCardMenuCallback
    public void onDeckCardEdit(final MTFullCard card, final int listId) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        EditCardDialogFragment editCardDialogFragmentBuild = new EditCardDialogFragment.Builder().setCard(card).setAllPrintsLauncher(this.allPrintsActivityLauncher).setOnEditClickedListener(new Function12() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda158
            @Override // kotlin.jvm.functions.Function12
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
                return DeckDetailsActivity.onDeckCardEdit$lambda$0(this.f$0, card, listId, (Integer) obj, (Integer) obj2, (String) obj3, (String) obj4, (String) obj5, (MTFullCard) obj6, (Boolean) obj7, (Boolean) obj8, (Boolean) obj9, (Boolean) obj10, (Integer) obj11, (Double) obj12);
            }
        }).build();
        this.currentEditDialog = editCardDialogFragmentBuild;
        editCardDialogFragmentBuild.show(getSupportFragmentManager(), "edit_card_dialog");
    }

    @Override // com.studiolaganne.lengendarylens.DeckCardMenuCallback
    public void onDeckCardEvaluate(MTFullCard card, int listId) {
        Intrinsics.checkNotNullParameter(card, "card");
        MTDeck mTDeck = this.currentDeck;
        if (mTDeck == null) {
            return;
        }
        if (this.isSmartDeck) {
            CardEvaluationDetailHelper.INSTANCE.show(this, mTDeck.getId(), card);
        } else if (Intrinsics.areEqual((Object) mTDeck.getHas_smart_deck(), (Object) true)) {
            showPaywallInfo("cardranking");
        } else {
            showConvertSmartDeckDialog();
        }
    }

    @Override // com.studiolaganne.lengendarylens.DeckCardMenuCallback
    public void onDeckCardFindSimilar(MTFullCard card, String mode) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(mode, "mode");
        MTDeck mTDeck = this.currentDeck;
        if (mTDeck == null) {
            return;
        }
        if (!this.isSmartDeck) {
            if (Intrinsics.areEqual((Object) mTDeck.getHas_smart_deck(), (Object) true)) {
                showPaywallInfo(Intrinsics.areEqual(mode, "hybrid") ? "similarsearch" : "oftenplayed");
                return;
            } else {
                showConvertSmartDeckDialog();
                return;
            }
        }
        String oracleid = card.getOracleid();
        if (oracleid == null) {
            return;
        }
        String printed_name = card.getPrinted_name();
        if (printed_name == null && (printed_name = card.getName()) == null) {
            return;
        }
        showMythicPlusPanel();
        getSupportFragmentManager().executePendingTransactions();
        MythicPlusBottomSheetFragment mythicPlusBottomSheetFragment = this.mythicPlusBottomSheet;
        if (mythicPlusBottomSheetFragment != null) {
            mythicPlusBottomSheetFragment.openSearchForSimilar(oracleid, mode, printed_name);
        }
    }

    @Override // com.studiolaganne.lengendarylens.DeckCardMenuCallback
    public void onDeckCardMove(final MTFullCard card, final int listId) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        DeckMoveCardDialogFragment.Builder card2 = new DeckMoveCardDialogFragment.Builder().setCard(card);
        MTDeckLists mTDeckLists = this.currentLists;
        if (mTDeckLists == null) {
            mTDeckLists = new MTDeckLists(null, null, null, 7, null);
        }
        card2.setCurrentLists(mTDeckLists).setCurrentListId(listId).setListener(new DeckMoveCardDialogListener() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onDeckCardMove$moveDialog$1
            @Override // com.studiolaganne.lengendarylens.DeckMoveCardDialogListener
            public void onMoveCardToDeckList(int destinationListId, int quantity) {
                MTUser currentUser;
                if (this.this$0.isFinishing() || this.this$0.isDestroyed() || (currentUser = new PreferencesManager(this.this$0).getCurrentUser()) == null) {
                    return;
                }
                final DeckDetailsActivity deckDetailsActivity = this.this$0;
                MTFullCard mTFullCard = card;
                int i = listId;
                final ConstraintLayout constraintLayout = (ConstraintLayout) deckDetailsActivity.findViewById(R.id.overlay);
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(0);
                }
                MTMoveCardsBody mTMoveCardsBody = new MTMoveCardsBody(0, null, 3, null);
                mTMoveCardsBody.setTarget(destinationListId);
                ArrayList arrayList = new ArrayList();
                List<Integer> variant_list_card_ids = mTFullCard.getVariant_list_card_ids();
                if (variant_list_card_ids != null) {
                    Iterator it = CollectionsKt.take(variant_list_card_ids, quantity).iterator();
                    while (it.hasNext()) {
                        int iIntValue = ((Number) it.next()).intValue();
                        MTCardReference mTCardReference = new MTCardReference(0, 1, null);
                        mTCardReference.setList_card_id(iIntValue);
                        arrayList.add(mTCardReference);
                    }
                } else {
                    List<Integer> list_card_ids = mTFullCard.getList_card_ids();
                    if (list_card_ids != null) {
                        Iterator it2 = CollectionsKt.take(list_card_ids, quantity).iterator();
                        while (it2.hasNext()) {
                            int iIntValue2 = ((Number) it2.next()).intValue();
                            MTCardReference mTCardReference2 = new MTCardReference(0, 1, null);
                            mTCardReference2.setList_card_id(iIntValue2);
                            arrayList.add(mTCardReference2);
                        }
                    }
                }
                mTMoveCardsBody.setCards(arrayList);
                MTApiKt.getMtApi().moveCardsFromList(currentUser.getId(), i, null, null, deckDetailsActivity.currentGroupBy, deckDetailsActivity.currentSortBy, deckDetailsActivity.currentSortDirection, Boolean.valueOf(deckDetailsActivity.ignoreCollection), Boolean.valueOf(deckDetailsActivity.ignoreBasicLands), Boolean.valueOf(deckDetailsActivity.ignorePrintings), mTMoveCardsBody).enqueue(new Callback<MTMoveCardsResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onDeckCardMove$moveDialog$1$onMoveCardToDeckList$1$3
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTMoveCardsResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
                            return;
                        }
                        ConstraintLayout constraintLayout2 = constraintLayout;
                        if (constraintLayout2 != null) {
                            constraintLayout2.setVisibility(8);
                        }
                        Toast.makeText(deckDetailsActivity, R.string.error_moving_card, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTMoveCardsResponse> call, Response<MTMoveCardsResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (deckDetailsActivity.isFinishing() || deckDetailsActivity.isDestroyed()) {
                            return;
                        }
                        ConstraintLayout constraintLayout2 = constraintLayout;
                        if (constraintLayout2 != null) {
                            constraintLayout2.setVisibility(8);
                        }
                        if (!response.isSuccessful()) {
                            Toast.makeText(deckDetailsActivity, R.string.error_moving_card, 0).show();
                            return;
                        }
                        MTMoveCardsResponse mTMoveCardsResponseBody = response.body();
                        if (mTMoveCardsResponseBody != null) {
                            DeckDetailsActivity deckDetailsActivity2 = deckDetailsActivity;
                            if (!mTMoveCardsResponseBody.getSuccess()) {
                                Toast.makeText(deckDetailsActivity2, R.string.error_moving_card, 0).show();
                                return;
                            }
                            MTCardContainer target = mTMoveCardsResponseBody.getTarget();
                            if (target != null) {
                                deckDetailsActivity2.refreshCurrentList(target.getId());
                            }
                            MTCardContainer source = mTMoveCardsResponseBody.getSource();
                            if (source != null) {
                                deckDetailsActivity2.refreshCurrentList(source.getId());
                            }
                            deckDetailsActivity2.fetchDeckIdCardIfNeeded(true);
                        }
                    }
                });
            }
        }).build().show(getSupportFragmentManager(), DeckMoveCardDialogFragment.TAG);
    }

    @Override // com.studiolaganne.lengendarylens.DeckCardMenuCallback
    public void onDeckCardOpen(MTFullCard card, int listId, String groupType) {
        MTCardContainer maybeboard;
        MTCardContainer sideboard;
        MTCardContainer main;
        MTCardContainer maybeboard2;
        MTCardContainer maybeboard3;
        MTCardContainer sideboard2;
        MTCardContainer sideboard3;
        MTCardContainer main2;
        MTCardContainer main3;
        Intrinsics.checkNotNullParameter(card, "card");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        Gson gson = new Gson();
        String json = gson.toJson(card);
        Intent intent = new Intent(this, (Class<?>) CardActivity.class);
        intent.putExtra("singleMTCard", json);
        intent.putExtra("lang", card.getLang());
        intent.putExtra("enTitle", card.getName());
        intent.putExtra(OptionalModuleUtils.FACE, card.getFace());
        intent.putExtra("localizedTypeLine", card.getType_line());
        intent.putExtra("localizedTitle", card.getPrinted_name());
        intent.putExtra("localizedOracle", card.getOracle_text());
        ArrayList arrayList = new ArrayList();
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        boolean z = Intrinsics.areEqual(this.currentGroupBy, "theme") && groupType != null;
        MTDeckLists mTDeckLists = this.currentLists;
        List<MTCardGroup> grouped_cards = null;
        if (mTDeckLists != null && (main2 = mTDeckLists.getMain()) != null && listId == main2.getId()) {
            MTDeckLists mTDeckLists2 = this.currentLists;
            onDeckCardOpen$addCardsFromGroups(z, groupType, card, arrayList, intRef2, intRef, (mTDeckLists2 == null || (main3 = mTDeckLists2.getMain()) == null) ? null : main3.getGrouped_cards());
        }
        MTDeckLists mTDeckLists3 = this.currentLists;
        if (mTDeckLists3 != null && (sideboard2 = mTDeckLists3.getSideboard()) != null && listId == sideboard2.getId()) {
            MTDeckLists mTDeckLists4 = this.currentLists;
            onDeckCardOpen$addCardsFromGroups(z, groupType, card, arrayList, intRef2, intRef, (mTDeckLists4 == null || (sideboard3 = mTDeckLists4.getSideboard()) == null) ? null : sideboard3.getGrouped_cards());
        }
        MTDeckLists mTDeckLists5 = this.currentLists;
        if (mTDeckLists5 != null && (maybeboard2 = mTDeckLists5.getMaybeboard()) != null && listId == maybeboard2.getId()) {
            MTDeckLists mTDeckLists6 = this.currentLists;
            if (mTDeckLists6 != null && (maybeboard3 = mTDeckLists6.getMaybeboard()) != null) {
                grouped_cards = maybeboard3.getGrouped_cards();
            }
            onDeckCardOpen$addCardsFromGroups(z, groupType, card, arrayList, intRef2, intRef, grouped_cards);
        }
        intent.putExtra("currentGroupBy", this.currentGroupBy);
        intent.putExtra("currentOrderBy", this.currentSortBy);
        intent.putExtra("currentOrderDirection", this.currentSortDirection);
        CardDataStore.INSTANCE.setMtCardList(arrayList);
        intent.putExtra("hasMTCards", true);
        intent.putExtra("currentMTIndex", intRef2.element);
        intent.putExtra("mtDeckListId", listId);
        if (isOtherUserDeck() || this.isDuplicatedDeck) {
            intent.putExtra("readOnly", true);
        }
        MTDeck mTDeck = this.currentDeck;
        if (mTDeck != null) {
            intent.putExtra("mtDeck", gson.toJson(mTDeck));
        }
        MTDeckLists mTDeckLists7 = this.currentLists;
        if (mTDeckLists7 != null && (main = mTDeckLists7.getMain()) != null) {
            intent.putExtra("mtDeckMainListId", main.getId());
            Integer count = main.getCount();
            intent.putExtra("mtDeckMainListCount", count != null ? count.intValue() : 0);
        }
        MTDeckLists mTDeckLists8 = this.currentLists;
        if (mTDeckLists8 != null && (sideboard = mTDeckLists8.getSideboard()) != null) {
            intent.putExtra("mtDeckSideboardListId", sideboard.getId());
            Integer count2 = sideboard.getCount();
            intent.putExtra("mtDeckSideboardListCount", count2 != null ? count2.intValue() : 0);
        }
        MTDeckLists mTDeckLists9 = this.currentLists;
        if (mTDeckLists9 != null && (maybeboard = mTDeckLists9.getMaybeboard()) != null) {
            intent.putExtra("mtDeckMaybeboardListId", maybeboard.getId());
            Integer count3 = maybeboard.getCount();
            intent.putExtra("mtDeckMaybeboardListCount", count3 != null ? count3.intValue() : 0);
        }
        this.cardActivityLauncher.launch(intent);
    }

    @Override // com.studiolaganne.lengendarylens.DeckCardMenuCallback
    public void onDeckCardSelect(MTFullCard card, int listId) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (isFinishing() || isDestroyed() || isOtherUserDeck() || this.isDuplicatedDeck) {
            return;
        }
        if (this.selectionMode) {
            toggleCardSelection(card, listId);
        } else {
            enterSelectionMode(card, Integer.valueOf(listId));
        }
    }

    @Override // com.studiolaganne.lengendarylens.DeckCardMenuCallback
    public void onDeckCardSetCompanion(MTFullCard card, final int listId, boolean setAsCompanion) {
        MTUser currentUser;
        Intrinsics.checkNotNullParameter(card, "card");
        if (isFinishing() || isDestroyed() || (currentUser = new PreferencesManager(this).getCurrentUser()) == null) {
            return;
        }
        final ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        MTEditCardBody mTEditCardBody = new MTEditCardBody(null, 1, null);
        MTEditCardActions mTEditCardActions = new MTEditCardActions(null, null, null, 7, null);
        mTEditCardBody.setCards(mTEditCardActions);
        MTFullCard mTFullCard = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
        mTFullCard.setCardid(card.getCardid());
        mTFullCard.setList_card_id(card.getList_card_id());
        mTFullCard.setFlag(setAsCompanion ? 5 : 0);
        mTEditCardActions.setEdited(CollectionsKt.listOf(mTFullCard));
        MTApiKt.getMtApi().editCardsFromList(currentUser.getId(), listId, null, null, this.currentGroupBy, this.currentSortBy, this.currentSortDirection, true, Boolean.valueOf(this.ignoreCollection), Boolean.valueOf(this.ignoreBasicLands), Boolean.valueOf(this.ignorePrintings), mTEditCardBody).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onDeckCardSetCompanion$1$1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                constraintLayout.setVisibility(8);
                Toast.makeText(this.this$0, R.string.error_editing_card, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                MTCardContainer maybeboard;
                MTCardContainer sideboard;
                MTCardContainer main;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                    return;
                }
                if (!response.isSuccessful()) {
                    constraintLayout.setVisibility(8);
                    Toast.makeText(this.this$0, R.string.error_editing_card, 0).show();
                    return;
                }
                MTCardListResponse mTCardListResponseBody = response.body();
                MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                if (list != null) {
                    int i = listId;
                    DeckDetailsActivity deckDetailsActivity = this.this$0;
                    MTDeckLists mTDeckLists = deckDetailsActivity.currentLists;
                    if (mTDeckLists == null || (main = mTDeckLists.getMain()) == null || i != main.getId()) {
                        MTDeckLists mTDeckLists2 = deckDetailsActivity.currentLists;
                        if (mTDeckLists2 == null || (sideboard = mTDeckLists2.getSideboard()) == null || i != sideboard.getId()) {
                            MTDeckLists mTDeckLists3 = deckDetailsActivity.currentLists;
                            if (mTDeckLists3 != null && (maybeboard = mTDeckLists3.getMaybeboard()) != null && i == maybeboard.getId()) {
                                MTDeckLists mTDeckLists4 = deckDetailsActivity.currentLists;
                                deckDetailsActivity.currentLists = mTDeckLists4 != null ? MTDeckLists.copy$default(mTDeckLists4, null, null, list, 3, null) : null;
                            }
                        } else {
                            MTDeckLists mTDeckLists5 = deckDetailsActivity.currentLists;
                            deckDetailsActivity.currentLists = mTDeckLists5 != null ? MTDeckLists.copy$default(mTDeckLists5, null, list, null, 5, null) : null;
                        }
                    } else {
                        MTDeckLists mTDeckLists6 = deckDetailsActivity.currentLists;
                        deckDetailsActivity.currentLists = mTDeckLists6 != null ? MTDeckLists.copy$default(mTDeckLists6, list, null, null, 6, null) : null;
                        List<MTCardGroup> grouped_cards = list.getGrouped_cards();
                        if (grouped_cards != null) {
                            deckDetailsActivity.currentGroupedCards = grouped_cards;
                        }
                    }
                    List list2 = deckDetailsActivity.currentGroupedCards;
                    if (list2 != null) {
                        deckDetailsActivity.setupCardsAdapter(list2);
                    }
                    deckDetailsActivity.updateBottomBar();
                }
                constraintLayout.setVisibility(8);
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onDeckCreated(List<MTDeck> decks) {
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onDeckCreatedForUser(MTDeck deck, int userId) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onDeckEdited(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.currentDeck = deck;
        PreferencesManager preferencesManager = new PreferencesManager(this);
        preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
        List<MTDeck> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getCurrentUserDecks());
        Iterator<MTDeck> it = mutableList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().getId() == deck.getId()) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            mutableList.set(i, deck);
            preferencesManager.saveCurrentUserDecks(mutableList);
        }
        updateUI();
        fetchDeckIdCardIfNeeded(true);
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onDeleteGameClicked(final MTGame game) {
        Intrinsics.checkNotNullParameter(game, "game");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        final MTSet set = game.getSet();
        if (set != null) {
            CustomDeleteDialogFragment.Builder builder = new CustomDeleteDialogFragment.Builder();
            String string = getString(R.string.are_you_sure_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDeleteDialogFragment.Builder title = builder.setTitle(string);
            String string2 = getString(R.string.delete_set_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            title.setBody(string2).setPositiveButtonCallback(new Function3() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda132
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DeckDetailsActivity.onDeleteGameClicked$lambda$0$0(this.f$0, set, (String) obj, ((Boolean) obj2).booleanValue(), (CustomDeleteDialogFragment) obj3);
                }
            }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda133
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeckDetailsActivity.onDeleteGameClicked$lambda$0$1((CustomDeleteDialogFragment) obj);
                }
            }).build().show(getSupportFragmentManager(), "delete_game_dialog");
            return;
        }
        CustomDeleteDialogFragment.Builder builder2 = new CustomDeleteDialogFragment.Builder();
        String string3 = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDeleteDialogFragment.Builder title2 = builder2.setTitle(string3);
        String string4 = getString(R.string.delete_game_body);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        title2.setBody(string4).setPositiveButtonCallback(new Function3() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda134
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DeckDetailsActivity.onDeleteGameClicked$lambda$1(this.f$0, game, (String) obj, ((Boolean) obj2).booleanValue(), (CustomDeleteDialogFragment) obj3);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$$ExternalSyntheticLambda135
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeckDetailsActivity.onDeleteGameClicked$lambda$2((CustomDeleteDialogFragment) obj);
            }
        }).build().show(getSupportFragmentManager(), "delete_game_dialog");
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        DeckErrorPopupManager deckErrorPopupManager = this.errorPopupManager;
        if (deckErrorPopupManager != null) {
            deckErrorPopupManager.cleanup();
        }
        this.errorPopupManager = null;
        ObjectAnimator objectAnimator = this.smartDeckGlowAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.smartDeckGlowAnimator = null;
        clearSmartDeckEffects();
        this.cardPickerBottomSheet = null;
        View viewFindViewById = findViewById(R.id.twoColumnStackedCardsView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((TwoColumnStackedCardsView) viewFindViewById).cleanup();
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onGameClicked(MTGame game) {
        Intrinsics.checkNotNullParameter(game, "game");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) GameDetailsActivity.class);
        intent.putExtra("gameJson", new Gson().toJson(game));
        this.gameDetailsLauncher.launch(intent);
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onGameItemExpanded() {
        adjustRecyclerViewHeight();
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onGhostDeckCreated(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onLoadMoreGamesClicked() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        MTGame mTGame = (MTGame) CollectionsKt.lastOrNull((List) this.games);
        String ended_at = mTGame != null ? mTGame.getEnded_at() : null;
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        if (currentUser != null) {
            MTApi mtApi = MTApiKt.getMtApi();
            int id = currentUser.getId();
            MTDeck mTDeck = this.currentDeck;
            int id2 = mTDeck != null ? mTDeck.getId() : -1;
            if (ended_at == null) {
                ended_at = "";
            }
            mtApi.getDeckByIdWithGamesBeforeTimestamp(id, id2, ended_at, this.filterDefinition.getFormatId(), this.filterDefinition.getSubformatId(), this.filterDefinition.getTagId()).enqueue(new Callback<MTDeckResponse>() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onLoadMoreGamesClicked$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTDeckResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTDeckResponse> call, Response<MTDeckResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.isDestroyed() || this.this$0.isFinishing() || !response.isSuccessful()) {
                        return;
                    }
                    MTDeckResponse mTDeckResponseBody = response.body();
                    List<MTGame> games = mTDeckResponseBody != null ? mTDeckResponseBody.getGames() : null;
                    View viewFindViewById = this.this$0.findViewById(R.id.noGamesTextView);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                    TextView textView = (TextView) viewFindViewById;
                    if (games == null) {
                        textView.setVisibility(0);
                        return;
                    }
                    DeckDetailsActivity deckDetailsActivity = this.this$0;
                    String ended_at2 = !games.isEmpty() ? ((MTGame) CollectionsKt.last((List) games)).getEnded_at() : null;
                    Log.d("onLoadMoreGamesClicked", "Received new games : " + games);
                    deckDetailsActivity.games.addAll(CollectionsKt.sortedWith(games, new Comparator() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onLoadMoreGamesClicked$1$1$onResponse$lambda$0$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(((MTGame) t2).getEnded_at(), ((MTGame) t).getEnded_at());
                        }
                    }));
                    deckDetailsActivity.shouldShowLoadMore = games.size() >= 20;
                    List<GameItemHolder> listGroupNewGamesWithSeparators = deckDetailsActivity.groupNewGamesWithSeparators(games, ended_at2);
                    View viewFindViewById2 = deckDetailsActivity.findViewById(R.id.gamesRecyclerView);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                    RecyclerView.Adapter adapter = ((RecyclerView) viewFindViewById2).getAdapter();
                    GamesAdapter gamesAdapter = adapter instanceof GamesAdapter ? (GamesAdapter) adapter : null;
                    if (gamesAdapter != null) {
                        gamesAdapter.addMoreGames(listGroupNewGamesWithSeparators);
                        gamesAdapter.setLoadMoreVisible(deckDetailsActivity.shouldShowLoadMore);
                    }
                    deckDetailsActivity.adjustRecyclerViewHeight();
                }
            });
        }
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onPublishGameClicked(MTGame game) {
        MTUser currentUser;
        Intrinsics.checkNotNullParameter(game, "game");
        if (isDestroyed() || isFinishing() || (currentUser = new PreferencesManager(this).getCurrentUser()) == null) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        MTSet set = game.getSet();
        if (set != null) {
            MTApiKt.getMtApi().publishSet(currentUser.getId(), set.getId()).enqueue(new DeckDetailsActivity$onPublishGameClicked$1$1$1(this, constraintLayout, set));
        } else {
            MTApiKt.getMtApi().publishGame(currentUser.getId(), game.getId()).enqueue(new DeckDetailsActivity$onPublishGameClicked$1$2$1(this, this, constraintLayout, game));
        }
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        int decksVersion = new PreferencesManager(this).getDecksVersion();
        if (decksVersion > this.lastKnownDecksVersion) {
            this.lastKnownDecksVersion = decksVersion;
            updateDeck();
        }
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onSetClicked(MTSet set, List<MTGame> subgames) {
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(subgames, "subgames");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) SetDetailsActivity.class);
        intent.putExtra("setJson", new Gson().toJson(set));
        MTSubgames mTSubgames = new MTSubgames(null, 1, null);
        mTSubgames.setSubgames(CollectionsKt.toMutableList((Collection) subgames));
        intent.putExtra("subgamesJson", new Gson().toJson(mTSubgames));
        this.setDetailsLauncher.launch(intent);
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onUnpublishGameClicked(MTGame game) {
        MTUser currentUser;
        Intrinsics.checkNotNullParameter(game, "game");
        if (isFinishing() || isDestroyed() || (currentUser = new PreferencesManager(this).getCurrentUser()) == null) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.overlay);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        MTSet set = game.getSet();
        if (set != null) {
            MTApiKt.getMtApi().unpublishSet(currentUser.getId(), set.getId()).enqueue(new DeckDetailsActivity$onUnpublishGameClicked$1$1$1(this, constraintLayout, set));
        } else {
            MTApiKt.getMtApi().unpublishGame(currentUser.getId(), game.getId()).enqueue(new DeckDetailsActivity$onUnpublishGameClicked$1$2$1(this, this, constraintLayout, game));
        }
    }
}
