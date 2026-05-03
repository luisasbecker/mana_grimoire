package com.studiolaganne.lengendarylens;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.credentials.provider.CredentialEntry;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.work.PeriodicWorkRequest;
import com.bumptech.glide.Glide;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResultHandler;
import com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import com.studiolaganne.lengendarylens.HomeFragment;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelperLocalized;
import com.studiolaganne.lengendarylens.MessagesDBHelper;
import com.studiolaganne.lengendarylens.MythicPlusInfoDialogFragment;
import com.studiolaganne.lengendarylens.ProfileBottomSheetFragment;
import com.studiolaganne.lengendarylens.QRScanBottomSheetFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentHomeBinding;
import io.customer.sdk.CustomerIO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: HomeFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 µ\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f:\u0002µ\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010.\u001a\u00020/2\u000e\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101H\u0016J\u0010\u00103\u001a\u00020/2\u0006\u00104\u001a\u000202H\u0016J\u0010\u00105\u001a\u00020/2\u0006\u00104\u001a\u000202H\u0016J\u0018\u00106\u001a\u00020/2\u0006\u00104\u001a\u0002022\u0006\u00107\u001a\u00020\u001aH\u0016J\u0018\u00108\u001a\u00020/2\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000101H\u0016J\u0018\u0010;\u001a\u00020/2\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000101H\u0016J\u0010\u0010<\u001a\u00020/2\u0006\u00104\u001a\u000202H\u0016J\u0010\u0010=\u001a\u00020/2\u0006\u00104\u001a\u000202H\u0016J\u0010\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020:H\u0016J\u0018\u0010@\u001a\u00020/2\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000101H\u0016J\u0018\u0010A\u001a\u00020/2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u000101H\u0016J\u0018\u0010D\u001a\u00020/2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u000101H\u0016J\b\u0010E\u001a\u00020/H\u0016J\u0010\u0010F\u001a\u00020/2\u0006\u00107\u001a\u00020\u001aH\u0016J\u0010\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020,H\u0016J\b\u0010I\u001a\u00020/H\u0002J\b\u0010J\u001a\u00020/H\u0016J\u0010\u0010K\u001a\u00020/2\u0006\u0010L\u001a\u00020CH\u0016J\b\u0010M\u001a\u00020/H\u0016J\u0006\u0010N\u001a\u00020/J\b\u0010O\u001a\u00020/H\u0016J\b\u0010P\u001a\u00020/H\u0016J\u0018\u0010Q\u001a\u00020/2\u0006\u0010R\u001a\u00020,2\u0006\u0010S\u001a\u00020,H\u0016J\u0012\u0010T\u001a\u00020/2\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J$\u0010W\u001a\u00020/2\u0006\u0010X\u001a\u00020,2\b\u0010Y\u001a\u0004\u0018\u00010,2\b\u0010Z\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010[\u001a\u00020/2\u0006\u0010\\\u001a\u00020,H\u0016J\b\u0010]\u001a\u00020/H\u0016J\b\u0010^\u001a\u00020/H\u0016J\u0010\u0010_\u001a\u00020/2\u0006\u0010`\u001a\u00020aH\u0016J\u0012\u0010b\u001a\u00020/2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J\b\u0010e\u001a\u00020/H\u0002J\b\u0010f\u001a\u00020/H\u0003J\u0010\u0010g\u001a\u00020/2\u0006\u0010h\u001a\u00020\u001aH\u0002J\u0010\u0010i\u001a\u00020/2\u0006\u0010j\u001a\u00020\u001aH\u0002J&\u0010k\u001a\u0004\u0018\u00010l2\u0006\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010p2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J\b\u0010q\u001a\u00020/H\u0016J\u0018\u0010r\u001a\u00020/2\b\b\u0002\u0010s\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010tJ\u0016\u0010u\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010vJ\u0016\u0010w\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010vJ\u0016\u0010x\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010vJ\u0016\u0010y\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010vJ\u0016\u0010z\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010vJ\u0016\u0010{\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010vJ\u0016\u0010|\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010vJ\u0016\u0010}\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010vJ)\u0010~\u001a\t\u0012\u0005\u0012\u0003H\u0080\u00010\u007f\"\u0005\b\u0000\u0010\u0080\u0001*\n\u0012\u0005\u0012\u0003H\u0080\u00010\u0081\u0001H\u0082@¢\u0006\u0003\u0010\u0082\u0001J\u0013\u0010\u0083\u0001\u001a\u00020/2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0002J\u001a\u0010\u0086\u0001\u001a\u00020/2\u0006\u00107\u001a\u00020\u001a2\u0007\u0010\u0087\u0001\u001a\u00020\u001aH\u0002J\t\u0010\u0088\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020/2\u0007\u0010\u008a\u0001\u001a\u00020\u0015H\u0016J\u0013\u0010\u008b\u0001\u001a\u00020/2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0002J\u0013\u0010\u008e\u0001\u001a\u00020/2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0002J\u0013\u0010\u008f\u0001\u001a\u00020/2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0002J\u0013\u0010\u0090\u0001\u001a\u00020/2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\u0013\u0010\u0093\u0001\u001a\u00020/2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0002J\t\u0010\u0094\u0001\u001a\u00020/H\u0002J\u0013\u0010\u0095\u0001\u001a\u00020/2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0002J\u0013\u0010\u0096\u0001\u001a\u00020/2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0002J\u0013\u0010\u0097\u0001\u001a\u00020/2\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0002J\u0013\u0010\u009a\u0001\u001a\u00020/2\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0002J\t\u0010\u009d\u0001\u001a\u00020/H\u0002J\u001b\u0010\u009e\u0001\u001a\u00020\u00152\u0007\u0010\u009f\u0001\u001a\u00020,2\u0007\u0010 \u0001\u001a\u00020,H\u0002J!\u0010¡\u0001\u001a\u00020/2\b\u0010¢\u0001\u001a\u00030£\u00012\f\u00109\u001a\b\u0012\u0004\u0012\u00020:01H\u0002J!\u0010¤\u0001\u001a\u00020/2\b\u0010¢\u0001\u001a\u00030£\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0002J\"\u0010¥\u0001\u001a\u00020/2\b\u0010¢\u0001\u001a\u00030£\u00012\r\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020C01H\u0002J\u0013\u0010§\u0001\u001a\u00020/2\b\u0010¢\u0001\u001a\u00030£\u0001H\u0002J\t\u0010¨\u0001\u001a\u00020/H\u0002J\t\u0010©\u0001\u001a\u00020/H\u0002J\t\u0010ª\u0001\u001a\u00020/H\u0002J\t\u0010«\u0001\u001a\u00020/H\u0002J\t\u0010¬\u0001\u001a\u00020/H\u0002J\u0013\u0010\u00ad\u0001\u001a\u00020/2\b\u0010®\u0001\u001a\u00030¯\u0001H\u0002JJ\u0010°\u0001\u001a\u00020/2\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\n\u0010¢\u0001\u001a\u0005\u0018\u00010£\u00012\f\u00109\u001a\b\u0012\u0004\u0012\u00020:012\f\u00100\u001a\b\u0012\u0004\u0012\u000202012\r\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020C01H\u0002J\u001c\u0010±\u0001\u001a\u00020/2\u0007\u0010²\u0001\u001a\u00020l2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J\u0010\u0010³\u0001\u001a\u00020/2\u0007\u0010´\u0001\u001a\u00020,R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010,0,0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010,0,0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¶\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/HomeFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/NewRecentCardClickListener;", "Lcom/studiolaganne/lengendarylens/SignInCallback;", "Lcom/studiolaganne/lengendarylens/ProfileCallback;", "Lcom/studiolaganne/lengendarylens/FriendsClickListener;", "Lcom/studiolaganne/lengendarylens/QRScanCallback;", "Lcom/studiolaganne/lengendarylens/AcceptFriendCallback;", "Lcom/studiolaganne/lengendarylens/CreatePlaygroupCallback;", "Lcom/studiolaganne/lengendarylens/PlaygroupsClickListener;", "Lcom/studiolaganne/lengendarylens/AcceptPlaygroupCallback;", "Lcom/studiolaganne/lengendarylens/CreateDeckCallback;", "Lcom/studiolaganne/lengendarylens/DecksClickListener;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentHomeBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentHomeBinding;", "isUpdatingUserData", "", "lastSuccessfulUpdate", "", "UPDATE_INTERVAL", "cameraPermissionRequestCode", "", "receiver", "Landroid/content/BroadcastReceiver;", "playgroupActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "paywallActivityLauncher", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityLauncher;", "deckActivityLauncher", "eventActivityLauncher", "settingsActivityLauncher", "aboutActivityLauncher", "cardActivityLauncher", "pickCardLauncher", "rulesActivityLauncher", "searchActivityLauncher", "requestNotificationPermissionLauncher", "", "requestCameraPermissionLauncher", "onDeckCreated", "", "decks", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "onDeckEdited", "deck", "onGhostDeckCreated", "onDeckCreatedForUser", "userId", "onPlaygroupAccepted", "playgroups", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "onPlaygroupDeclined", "onDeckSelected", "onDeckTemporary", "onPlaygroupSelected", "playgroup", "onPlaygroupCreated", "onFriendAccepted", "friendlist", "Lcom/studiolaganne/lengendarylens/MTFriend;", "onFriendDeclined", "onQRClosed", "onFriendCodeConfirmed", "onQRScanned", "value", "openAppSettings", "onAddFriendTapped", "onFriendSelected", "friend", "onProfileClose", "showSignedOutState", "onProfileLogout", "onProfilePictureUpdated", "onOAuthSignInSuccess", "code", "type", "handleSuccessfulFirebaseLogin", "response", "Lcom/studiolaganne/lengendarylens/MTLoginResponse;", "onSignInSuccess", "token", "firstname", "email", "onSignInFailure", NotificationCompat.CATEGORY_MESSAGE, "onSignInCancel", "onRandomCardClickNew", "onRecentCardClickNew", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "requestNotificationPermission", "showRationaleDialog", "fetchPlaygroupListAndShowPending", "playgroupId", "fetchFriendListAndShowPending", "friendId", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPause", "updateUserDataWithTokenValidation", "forceRefresh", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncSharedCollectionBadge", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserProfile", "updateUserFriends", "updateUserDecks", "updateUserPlaygroups", "updateFormats", "updateCollection", "updateLists", "await", "Lretrofit2/Response;", ExifInterface.GPS_DIRECTION_TRUE, "Lretrofit2/Call;", "(Lretrofit2/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showOnboardingDialog", "onboarding", "Lcom/studiolaganne/lengendarylens/MTOnboarding;", "markOnboardingSeen", "onboardingId", "onResume", "onHiddenChanged", "hidden", "handleLocalUpdates", "prefs", "Lcom/studiolaganne/lengendarylens/PreferencesManager;", "updateRecentCardsUI", "handleResumeActions", "setupHorizontalScrollDetection", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "handlePendingOAuthResponses", "clearNotifications", "processStoredFCMIntents", "processNotificationIntents", "processRecentCards", "list", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "checkState", "currentState", "Lcom/studiolaganne/lengendarylens/MTUserState;", "randomKeyword", "isNotValid", "cardName", "lang", "updatePlaygroups", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "updateDecks", "updateFriends", NativeProtocol.AUDIENCE_FRIENDS, "updateProfile", "refreshFormats", "updateEmailBanner", "updateRatingBanner", "updateStoreBanner", "updateMythicPlusBanner", "showEventBanner", NotificationCompat.CATEGORY_EVENT, "Lcom/studiolaganne/lengendarylens/MTCommunityEvent;", "updateUserUI", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "handleQREventURL", "url", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HomeFragment extends Fragment implements NewRecentCardClickListener, SignInCallback, ProfileCallback, FriendsClickListener, QRScanCallback, AcceptFriendCallback, CreatePlaygroupCallback, PlaygroupsClickListener, AcceptPlaygroupCallback, CreateDeckCallback, DecksClickListener {
    private FragmentHomeBinding _binding;
    private final ActivityResultLauncher<Intent> aboutActivityLauncher;
    private final ActivityResultLauncher<Intent> cardActivityLauncher;
    private final ActivityResultLauncher<Intent> deckActivityLauncher;
    private final ActivityResultLauncher<Intent> eventActivityLauncher;
    private boolean isUpdatingUserData;
    private long lastSuccessfulUpdate;
    private final PaywallActivityLauncher paywallActivityLauncher;
    private final ActivityResultLauncher<Intent> pickCardLauncher;
    private final ActivityResultLauncher<Intent> playgroupActivityLauncher;
    private BroadcastReceiver receiver;
    private final ActivityResultLauncher<String> requestCameraPermissionLauncher;
    private final ActivityResultLauncher<String> requestNotificationPermissionLauncher;
    private final ActivityResultLauncher<Intent> rulesActivityLauncher;
    private final ActivityResultLauncher<Intent> searchActivityLauncher;
    private final ActivityResultLauncher<Intent> settingsActivityLauncher;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final long UPDATE_INTERVAL = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    private final int cameraPermissionRequestCode = 100;

    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/HomeFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/HomeFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final HomeFragment newInstance() {
            HomeFragment homeFragment = new HomeFragment();
            homeFragment.setArguments(new Bundle());
            return homeFragment;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$onHiddenChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$onHiddenChanged$1", f = "HomeFragment.kt", i = {}, l = {2346}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C11701(Continuation<? super C11701> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new C11701(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (HomeFragment.updateUserDataWithTokenValidation$default(HomeFragment.this, false, this, 1, null) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$onOAuthSignInSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/HomeFragment$onOAuthSignInSuccess$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTLoginResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C11711 implements Callback<MTLoginResponse> {
        final /* synthetic */ PreferencesManager $prefs;

        C11711(PreferencesManager preferencesManager) {
            this.$prefs = preferencesManager;
        }

        static final Unit onResponse$lambda$0(final PreferencesManager preferencesManager, final HomeFragment homeFragment, final Response response, AuthResult authResult) {
            Task<GetTokenResult> idToken;
            FirebaseUser user = authResult.getUser();
            if (user != null && (idToken = user.getIdToken(true)) != null) {
                final Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onOAuthSignInSuccess$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HomeFragment.C11711.onResponse$lambda$0$0(preferencesManager, homeFragment, response, (GetTokenResult) obj);
                    }
                };
                idToken.addOnSuccessListener(new OnSuccessListener() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onOAuthSignInSuccess$1$$ExternalSyntheticLambda1
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        function1.invoke(obj);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$0$0(PreferencesManager preferencesManager, HomeFragment homeFragment, Response response, GetTokenResult getTokenResult) {
            String token = getTokenResult.getToken();
            String str = token;
            if (str == null || str.length() == 0) {
                Log.w("MTApi", "FIREBASE SIGNIN: Token was null or empty");
                homeFragment.getBinding().overlay.setVisibility(8);
            } else {
                preferencesManager.setString(PreferencesManager.FIREBASE_TOKEN, token);
                preferencesManager.setString(PreferencesManager.AUTH_PROVIDER, FirebaseAuthProvider.PROVIDER_ID);
                preferencesManager.setTokenExpiryTime(System.currentTimeMillis() + 3300000);
                homeFragment.handleSuccessfulFirebaseLogin((MTLoginResponse) response.body());
                homeFragment.getBinding().overlay.setVisibility(8);
            }
            return Unit.INSTANCE;
        }

        static final void onResponse$lambda$2(HomeFragment homeFragment, Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            Log.e("MTApi", "Firebase sign-in with custom token failed", e);
            homeFragment.getBinding().overlay.setVisibility(8);
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<MTLoginResponse> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            if (HomeFragment.this.getContext() == null || HomeFragment.this._binding == null) {
                return;
            }
            HomeFragment.this.getBinding().overlay.setVisibility(8);
            Log.d("MTApi", "Login failed: " + t.getLocalizedMessage());
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<MTLoginResponse> call, final Response<MTLoginResponse> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (HomeFragment.this.getContext() == null || HomeFragment.this._binding == null) {
                return;
            }
            if (response.isSuccessful()) {
                if (HomeFragment.this.getContext() == null) {
                    return;
                }
                MTLoginResponse mTLoginResponseBody = response.body();
                String customToken = mTLoginResponseBody != null ? mTLoginResponseBody.getCustomToken() : null;
                String str = customToken;
                if (str != null && str.length() != 0) {
                    Task<AuthResult> taskSignInWithCustomToken = FirebaseAuth.getInstance().signInWithCustomToken(customToken);
                    final PreferencesManager preferencesManager = this.$prefs;
                    final HomeFragment homeFragment = HomeFragment.this;
                    final Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onOAuthSignInSuccess$1$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return HomeFragment.C11711.onResponse$lambda$0(preferencesManager, homeFragment, response, (AuthResult) obj);
                        }
                    };
                    Task<AuthResult> taskAddOnSuccessListener = taskSignInWithCustomToken.addOnSuccessListener(new OnSuccessListener() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onOAuthSignInSuccess$1$$ExternalSyntheticLambda3
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public final void onSuccess(Object obj) {
                            function1.invoke(obj);
                        }
                    });
                    final HomeFragment homeFragment2 = HomeFragment.this;
                    taskAddOnSuccessListener.addOnFailureListener(new OnFailureListener() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onOAuthSignInSuccess$1$$ExternalSyntheticLambda4
                        @Override // com.google.android.gms.tasks.OnFailureListener
                        public final void onFailure(Exception exc) {
                            HomeFragment.C11711.onResponse$lambda$2(homeFragment2, exc);
                        }
                    });
                    return;
                }
            }
            HomeFragment.this.getBinding().overlay.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$onProfileClose$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$onProfileClose$1", f = "HomeFragment.kt", i = {}, l = {1048}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C11721(Continuation<? super C11721> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new C11721(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (HomeFragment.updateUserDataWithTokenValidation$default(HomeFragment.this, false, this, 1, null) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$onResume$1", f = "HomeFragment.kt", i = {}, l = {2195}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C11731(Continuation<? super C11731> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new C11731(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (HomeFragment.updateUserDataWithTokenValidation$default(HomeFragment.this, false, this, 1, null) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$onSignInSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/HomeFragment$onSignInSuccess$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTLoginResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C11741 implements Callback<MTLoginResponse> {
        final /* synthetic */ PreferencesManager $prefs;

        C11741(PreferencesManager preferencesManager) {
            this.$prefs = preferencesManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$0$0(PurchasesError it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$0$1(HomeFragment homeFragment, CustomerInfo customerInfo, boolean z) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            MythicPlusManager mythicPlusManager = MythicPlusManager.INSTANCE;
            Context contextRequireContext = homeFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            mythicPlusManager.handleCustomerInfoUpdate(contextRequireContext, customerInfo);
            return Unit.INSTANCE;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<MTLoginResponse> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            if (HomeFragment.this.getContext() == null || HomeFragment.this._binding == null) {
                return;
            }
            HomeFragment.this.getBinding().overlay.setVisibility(8);
            Log.d("MTApi", "Login failed: " + t.getLocalizedMessage());
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<MTLoginResponse> call, Response<MTLoginResponse> response) {
            List<MTPlaygroup> listEmptyList;
            List<MTFriend> listEmptyList2;
            List<MTDeck> listEmptyList3;
            MTCommunityEvent event;
            MTUserPrivacy privacy;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (HomeFragment.this.getContext() == null || HomeFragment.this._binding == null) {
                return;
            }
            if (response.isSuccessful()) {
                if (HomeFragment.this.getContext() == null) {
                    return;
                }
                MTLoginResponse mTLoginResponseBody = response.body();
                MTUser user = mTLoginResponseBody != null ? mTLoginResponseBody.getUser() : null;
                MTLoginResponse mTLoginResponseBody2 = response.body();
                if (mTLoginResponseBody2 == null || (listEmptyList = mTLoginResponseBody2.getPlaygroups()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List<MTPlaygroup> list = listEmptyList;
                MTLoginResponse mTLoginResponseBody3 = response.body();
                if (mTLoginResponseBody3 == null || (listEmptyList2 = mTLoginResponseBody3.getFriends()) == null) {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                List<MTFriend> list2 = listEmptyList2;
                MTLoginResponse mTLoginResponseBody4 = response.body();
                if (mTLoginResponseBody4 == null || (listEmptyList3 = mTLoginResponseBody4.getDecks()) == null) {
                    listEmptyList3 = CollectionsKt.emptyList();
                }
                List<MTDeck> list3 = listEmptyList3;
                MTLoginResponse mTLoginResponseBody5 = response.body();
                String result = mTLoginResponseBody5 != null ? mTLoginResponseBody5.getResult() : null;
                if (user != null) {
                    PreferencesManager preferencesManager = this.$prefs;
                    final HomeFragment homeFragment = HomeFragment.this;
                    CustomerIOHelper.INSTANCE.maybeIdentifyAfterLogin(user, preferencesManager);
                    ListenerConversionsKt.logInWith(Purchases.INSTANCE.getSharedInstance(), String.valueOf(user.getId()), new Function1() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onSignInSuccess$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return HomeFragment.C11741.onResponse$lambda$0$0((PurchasesError) obj);
                        }
                    }, new Function2() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onSignInSuccess$1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return HomeFragment.C11741.onResponse$lambda$0$1(homeFragment, (CustomerInfo) obj, ((Boolean) obj2).booleanValue());
                        }
                    });
                    FirebaseAnalytics.getInstance(homeFragment.requireContext()).setUserProperty("is_logged_in", "true");
                    preferencesManager.saveCurrentUser(user);
                    preferencesManager.saveCurrentUserPlaygroups(list);
                    preferencesManager.saveCurrentUserFriends(list2);
                    preferencesManager.saveCurrentUserDecks(list3);
                    homeFragment.updateUserUI(preferencesManager, user, list, list3, list2);
                    homeFragment.updateMythicPlusBanner();
                    FragmentActivity activity = homeFragment.getActivity();
                    MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
                    if (mainActivity != null) {
                        mainActivity.userLoggedIn();
                    }
                    MTLoginResponse mTLoginResponseBody6 = response.body();
                    MTUserState state = mTLoginResponseBody6 != null ? mTLoginResponseBody6.getState() : null;
                    if (state != null) {
                        homeFragment.checkState(state);
                    }
                    MTLoginResponse mTLoginResponseBody7 = response.body();
                    MTFavorites favorites = mTLoginResponseBody7 != null ? mTLoginResponseBody7.getFavorites() : null;
                    if (favorites != null) {
                        preferencesManager.saveCurrentUserFavorites(favorites);
                    }
                    MTLoginResponse mTLoginResponseBody8 = response.body();
                    MTUserTags tags = mTLoginResponseBody8 != null ? mTLoginResponseBody8.getTags() : null;
                    if (tags != null) {
                        preferencesManager.saveCurrentUserTags(tags);
                    }
                    MTLoginResponse mTLoginResponseBody9 = response.body();
                    List<MTTrophy> trophies = mTLoginResponseBody9 != null ? mTLoginResponseBody9.getTrophies() : null;
                    if (trophies != null) {
                        preferencesManager.saveCurrentUserTrophies(trophies);
                    }
                    MTLoginResponse mTLoginResponseBody10 = response.body();
                    if (mTLoginResponseBody10 != null && (privacy = mTLoginResponseBody10.getPrivacy()) != null) {
                        preferencesManager.saveCurrentUserPrivacy(privacy);
                    }
                    MTLoginResponse mTLoginResponseBody11 = response.body();
                    if (mTLoginResponseBody11 != null && (event = mTLoginResponseBody11.getEvent()) != null) {
                        homeFragment.showEventBanner(event);
                    }
                    MTLoginResponse mTLoginResponseBody12 = response.body();
                    MTCollection collection = mTLoginResponseBody12 != null ? mTLoginResponseBody12.getCollection() : null;
                    if (collection != null) {
                        preferencesManager.saveCurrentUserCollection(collection);
                    }
                    MTLoginResponse mTLoginResponseBody13 = response.body();
                    MTUserLists lists = mTLoginResponseBody13 != null ? mTLoginResponseBody13.getLists() : null;
                    if (lists != null) {
                        preferencesManager.saveCurrentUserLists(lists);
                        List<MTCardContainer> global = lists.getGlobal();
                        if (global != null) {
                            for (MTCardContainer mTCardContainer : global) {
                                if (Intrinsics.areEqual(mTCardContainer.getName(), PreferencesManager.RECENT_CARDS_LIST_NAME)) {
                                    homeFragment.processRecentCards(mTCardContainer);
                                }
                            }
                        }
                    }
                    if (trophies != null) {
                        preferencesManager.saveCurrentUserTrophies(trophies);
                    }
                    MessagesManager companion = MessagesManager.INSTANCE.getInstance();
                    Context contextRequireContext = homeFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    companion.updateAllMessages(contextRequireContext, new MessagesManagerListener() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onSignInSuccess$1$onResponse$1$13
                        @Override // com.studiolaganne.lengendarylens.MessagesManagerListener
                        public void onMessagesUpdated(int playgroupId) {
                            if (homeFragment.getContext() == null || homeFragment._binding == null) {
                                return;
                            }
                            RecyclerView playgroupsRecyclerView = homeFragment.getBinding().playgroupsRecyclerView;
                            Intrinsics.checkNotNullExpressionValue(playgroupsRecyclerView, "playgroupsRecyclerView");
                            RecyclerView.Adapter adapter = playgroupsRecyclerView.getAdapter();
                            PlaygroupsAdapter playgroupsAdapter = adapter instanceof PlaygroupsAdapter ? (PlaygroupsAdapter) adapter : null;
                            if (playgroupsAdapter != null) {
                                playgroupsAdapter.notifyDataSetChanged();
                            }
                        }
                    });
                    homeFragment.requestNotificationPermission();
                    if (Intrinsics.areEqual(result, "signup")) {
                        Breadcrumbs.INSTANCE.leaveBreadcrumb("home_sign_up");
                        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(homeFragment.requireContext());
                        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                        firebaseAnalytics.logEvent("home_sign_up", null);
                        ProfileBottomSheetFragment.Companion.newInstance$default(ProfileBottomSheetFragment.INSTANCE, homeFragment, user, null, null, 12, null).show(homeFragment.getChildFragmentManager(), ProfileBottomSheetFragment.TAG);
                    }
                    homeFragment.refreshFormats();
                }
            }
            HomeFragment.this.getBinding().overlay.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$onViewCreated$1", f = "HomeFragment.kt", i = {}, l = {3460}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: HomeFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$onViewCreated$1$1", f = "HomeFragment.kt", i = {}, l = {3461}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C02071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ HomeFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02071(HomeFragment homeFragment, Continuation<? super C02071> continuation) {
                super(2, continuation);
                this.this$0 = homeFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02071(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow<Boolean> stateFlowIsActiveFlow = MythicPlusManager.INSTANCE.isActiveFlow();
                    final HomeFragment homeFragment = this.this$0;
                    this.label = 1;
                    if (stateFlowIsActiveFlow.collect(new FlowCollector() { // from class: com.studiolaganne.lengendarylens.HomeFragment.onViewCreated.1.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                            Context contextRequireContext = homeFragment.requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                            MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
                            if (currentUser != null) {
                                homeFragment.updateProfile(currentUser);
                            }
                            homeFragment.updateMythicPlusBanner();
                            RecyclerView.Adapter adapter = homeFragment.getBinding().decksRecyclerView.getAdapter();
                            DecksAdapter decksAdapter = adapter instanceof DecksAdapter ? (DecksAdapter) adapter : null;
                            if (decksAdapter != null) {
                                decksAdapter.notifyDataSetChanged();
                            }
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        C11751(Continuation<? super C11751> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new C11751(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = HomeFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new C02071(HomeFragment.this, null), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$syncSharedCollectionBadge$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$syncSharedCollectionBadge$2", f = "HomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11772 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ int $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11772(int i, Continuation<? super C11772> continuation) {
            super(2, continuation);
            this.$userId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new C11772(this.$userId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C11772) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0090 A[Catch: Exception -> 0x00ce, TryCatch #0 {Exception -> 0x00ce, blocks: (B:12:0x0036, B:14:0x004a, B:17:0x0054, B:19:0x005a, B:21:0x0060, B:24:0x006a, B:25:0x006f, B:27:0x0075, B:29:0x0085, B:31:0x0089, B:34:0x0090, B:36:0x0096, B:38:0x009c, B:41:0x00a6, B:42:0x00aa, B:44:0x00b0, B:46:0x00c0, B:48:0x00c4, B:49:0x00c8, B:51:0x00cb), top: B:57:0x0036 }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00a6 A[Catch: Exception -> 0x00ce, TryCatch #0 {Exception -> 0x00ce, blocks: (B:12:0x0036, B:14:0x004a, B:17:0x0054, B:19:0x005a, B:21:0x0060, B:24:0x006a, B:25:0x006f, B:27:0x0075, B:29:0x0085, B:31:0x0089, B:34:0x0090, B:36:0x0096, B:38:0x009c, B:41:0x00a6, B:42:0x00aa, B:44:0x00b0, B:46:0x00c0, B:48:0x00c4, B:49:0x00c8, B:51:0x00cb), top: B:57:0x0036 }] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00b0 A[Catch: Exception -> 0x00ce, TryCatch #0 {Exception -> 0x00ce, blocks: (B:12:0x0036, B:14:0x004a, B:17:0x0054, B:19:0x005a, B:21:0x0060, B:24:0x006a, B:25:0x006f, B:27:0x0075, B:29:0x0085, B:31:0x0089, B:34:0x0090, B:36:0x0096, B:38:0x009c, B:41:0x00a6, B:42:0x00aa, B:44:0x00b0, B:46:0x00c0, B:48:0x00c4, B:49:0x00c8, B:51:0x00cb), top: B:57:0x0036 }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00cb A[Catch: Exception -> 0x00ce, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ce, blocks: (B:12:0x0036, B:14:0x004a, B:17:0x0054, B:19:0x005a, B:21:0x0060, B:24:0x006a, B:25:0x006f, B:27:0x0075, B:29:0x0085, B:31:0x0089, B:34:0x0090, B:36:0x0096, B:38:0x009c, B:41:0x00a6, B:42:0x00aa, B:44:0x00b0, B:46:0x00c0, B:48:0x00c4, B:49:0x00c8, B:51:0x00cb), top: B:57:0x0036 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            int i2;
            List<MTUnshareRequest> unshare_requests;
            List<MTUnshareRequest> list;
            Iterator<T> it;
            List<MTSharedCollectionInvite> invites;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int i3 = 0;
            if (HomeFragment.this.getContext() == null) {
                return Boxing.boxBoolean(false);
            }
            Context contextRequireContext = HomeFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            if (preferencesManager.getInt(PreferencesManager.SHARED_COLLECTION_BADGE_COUNT, 0) > 0) {
                return Boxing.boxBoolean(true);
            }
            try {
                Response<MTSharedCollectionsResponse> responseExecute = MTApiKt.getMtApi().getSharedCollections(this.$userId).execute();
                if (responseExecute.isSuccessful()) {
                    MTSharedCollectionsResponse mTSharedCollectionsResponseBody = responseExecute.body();
                    if (mTSharedCollectionsResponseBody == null || (invites = mTSharedCollectionsResponseBody.getInvites()) == null) {
                        i = 0;
                        if (mTSharedCollectionsResponseBody != null && (unshare_requests = mTSharedCollectionsResponseBody.getUnshare_requests()) != null) {
                            list = unshare_requests;
                            if ((list instanceof Collection) || !list.isEmpty()) {
                                it = list.iterator();
                                while (it.hasNext()) {
                                    if (Intrinsics.areEqual(((MTUnshareRequest) it.next()).getStatus(), "requested") && (i3 = i3 + 1) < 0) {
                                        CollectionsKt.throwCountOverflow();
                                    }
                                }
                            }
                        }
                        i2 = i + i3;
                        if (i2 > 0) {
                            preferencesManager.setInt(PreferencesManager.SHARED_COLLECTION_BADGE_COUNT, i2);
                        }
                    } else {
                        List<MTSharedCollectionInvite> list2 = invites;
                        if ((list2 instanceof Collection) && list2.isEmpty()) {
                            i = 0;
                            if (mTSharedCollectionsResponseBody != null) {
                            }
                            i2 = i + i3;
                            if (i2 > 0) {
                            }
                        } else {
                            Iterator<T> it2 = list2.iterator();
                            i = 0;
                            while (it2.hasNext()) {
                                if (Intrinsics.areEqual(((MTSharedCollectionInvite) it2.next()).getStatus(), "requested") && (i = i + 1) < 0) {
                                    CollectionsKt.throwCountOverflow();
                                }
                            }
                            if (mTSharedCollectionsResponseBody != null) {
                                list = unshare_requests;
                                if (list instanceof Collection) {
                                    it = list.iterator();
                                    while (it.hasNext()) {
                                    }
                                }
                            }
                            i2 = i + i3;
                            if (i2 > 0) {
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return Boxing.boxBoolean(true);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$updateCollection$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$updateCollection$2", f = "HomeFragment.kt", i = {1, 1, 1}, l = {2110, 2113}, m = "invokeSuspend", n = {"response", "collection", "$i$a$-let-HomeFragment$updateCollection$2$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C11782 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ int $userId;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11782(int i, Continuation<? super C11782> continuation) {
            super(2, continuation);
            this.$userId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new C11782(this.$userId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C11782) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r6, r7, r9) == r0) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            MTCollection collection;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = HomeFragment.this.await(MTApiKt.getMtApi().getCollection(this.$userId), this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxBoolean(true);
                }
                ResultKt.throwOnFailure(obj);
                Response response = (Response) obj;
                if (response.isSuccessful()) {
                    MTCollectionResponse mTCollectionResponse = (MTCollectionResponse) response.body();
                    if (mTCollectionResponse != null && (collection = mTCollectionResponse.getCollection()) != null) {
                        HomeFragment homeFragment = HomeFragment.this;
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        HomeFragment$updateCollection$2$1$1 homeFragment$updateCollection$2$1$1 = new HomeFragment$updateCollection$2$1$1(homeFragment, collection, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(collection);
                        this.I$0 = 0;
                        this.label = 2;
                    }
                    return Boxing.boxBoolean(true);
                }
            } catch (Exception e) {
                Log.e("HomeFragment", "Error updating collection", e);
            }
            return Boxing.boxBoolean(false);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$updateFormats$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$updateFormats$2", f = "HomeFragment.kt", i = {1, 1, 1}, l = {2085, 2088}, m = "invokeSuspend", n = {"response", "formats", "$i$a$-let-HomeFragment$updateFormats$2$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C11792 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ int $userId;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11792(int i, Continuation<? super C11792> continuation) {
            super(2, continuation);
            this.$userId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new C11792(this.$userId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C11792) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r6, r7, r9) == r0) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            List<MTFormat> formats;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = HomeFragment.this.await(MTApiKt.getMtApi().getFormats(this.$userId), this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxBoolean(true);
                }
                ResultKt.throwOnFailure(obj);
                Response response = (Response) obj;
                if (response.isSuccessful()) {
                    MTFormatsResponse mTFormatsResponse = (MTFormatsResponse) response.body();
                    if (mTFormatsResponse != null && (formats = mTFormatsResponse.getFormats()) != null) {
                        HomeFragment homeFragment = HomeFragment.this;
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        HomeFragment$updateFormats$2$1$1 homeFragment$updateFormats$2$1$1 = new HomeFragment$updateFormats$2$1$1(homeFragment, formats, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(formats);
                        this.I$0 = 0;
                        this.label = 2;
                    }
                    return Boxing.boxBoolean(true);
                }
            } catch (Exception e) {
                Log.e("HomeFragment", "Error updating formats", e);
            }
            return Boxing.boxBoolean(false);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$updateLists$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$updateLists$2", f = "HomeFragment.kt", i = {1, 1, 1}, l = {2128, 2131}, m = "invokeSuspend", n = {"response", "lists", "$i$a$-let-HomeFragment$updateLists$2$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C11802 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ int $userId;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11802(int i, Continuation<? super C11802> continuation) {
            super(2, continuation);
            this.$userId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new C11802(this.$userId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C11802) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r6, r7, r9) == r0) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            MTUserLists lists;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = HomeFragment.this.await(MTApiKt.getMtApi().getLists(this.$userId), this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxBoolean(true);
                }
                ResultKt.throwOnFailure(obj);
                Response response = (Response) obj;
                if (response.isSuccessful()) {
                    MTListsResponse mTListsResponse = (MTListsResponse) response.body();
                    if (mTListsResponse != null && (lists = mTListsResponse.getLists()) != null) {
                        HomeFragment homeFragment = HomeFragment.this;
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        HomeFragment$updateLists$2$1$1 homeFragment$updateLists$2$1$1 = new HomeFragment$updateLists$2$1$1(homeFragment, lists, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(lists);
                        this.I$0 = 0;
                        this.label = 2;
                    }
                    return Boxing.boxBoolean(true);
                }
            } catch (Exception e) {
                Log.e("HomeFragment", "Error updating lists", e);
            }
            return Boxing.boxBoolean(false);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment", f = "HomeFragment.kt", i = {0, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9}, l = {1838, 1852, 1878, 1887, 1893, 1939, 1907, 1939, 1939, 1939}, m = "updateUserDataWithTokenValidation", n = {"forceRefresh", "prefs", "forceRefresh", "prefs", "user", "forceRefresh", "now", "needsUpdate", "prefs", "user", "forceRefresh", "now", "needsUpdate", "prefs", "user", "token", "forceRefresh", "now", "needsUpdate", "prefs", "user", "forceRefresh", "now", "needsUpdate", "prefs", "user", "token", "forceRefresh", "now", "needsUpdate", "prefs", "user", "forceRefresh", "now", "needsUpdate", "prefs", "user", "forceRefresh", "now", "needsUpdate", "prefs", "user", "forceRefresh", "now", "needsUpdate"}, s = {"Z$0", "L$0", "Z$0", "L$0", "L$1", "Z$0", "J$0", "I$0", "L$0", "L$1", "Z$0", "J$0", "I$0", "L$0", "L$1", "L$2", "Z$0", "J$0", "I$0", "L$0", "L$1", "Z$0", "J$0", "I$0", "L$0", "L$1", "L$2", "Z$0", "J$0", "I$0", "L$0", "L$1", "Z$0", "J$0", "I$0", "L$0", "L$1", "Z$0", "J$0", "I$0", "L$0", "L$1", "Z$0", "J$0", "I$0"}, v = 1)
    static final class C11811 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C11811(Continuation<? super C11811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomeFragment.this.updateUserDataWithTokenValidation(false, this);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$2", f = "HomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11822 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C11822(Continuation<? super C11822> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new C11822(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11822) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (HomeFragment.this.getContext() != null && HomeFragment.this._binding != null) {
                HomeFragment.this.getBinding().swipeRefreshLayout.setRefreshing(false);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$3, reason: invalid class name */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$3", f = "HomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (HomeFragment.this.getContext() != null && HomeFragment.this._binding != null) {
                HomeFragment.this.getBinding().swipeRefreshLayout.setRefreshing(false);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$4, reason: invalid class name */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$4", f = "HomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (HomeFragment.this.getContext() != null && HomeFragment.this._binding != null) {
                HomeFragment.this.getBinding().swipeRefreshLayout.setRefreshing(true);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$5, reason: invalid class name */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$5", f = "HomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (HomeFragment.this.getContext() != null && HomeFragment.this._binding != null) {
                HomeFragment.this.getBinding().swipeRefreshLayout.setRefreshing(false);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$6, reason: invalid class name */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$6", f = "HomeFragment.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {1918}, m = "invokeSuspend", n = {"$this$coroutineScope", "userDeferred", "friendsDeferred", "decksDeferred", "playgroupsDeferred", "formatsDeferred", "collectionDeferred", "listsDeferred", "sharedCollectionsBadgeDeferred"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Boolean>>, Object> {
        final /* synthetic */ MTUser $user;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(MTUser mTUser, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$user = mTUser;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass6 anonymousClass6 = HomeFragment.this.new AnonymousClass6(this.$user, continuation);
            anonymousClass6.L$0 = obj;
            return anonymousClass6;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Boolean>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<Boolean>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Boolean>> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new HomeFragment$updateUserDataWithTokenValidation$6$userDeferred$1(HomeFragment.this, this.$user, null), 3, null);
            Deferred deferredAsync$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new HomeFragment$updateUserDataWithTokenValidation$6$friendsDeferred$1(HomeFragment.this, this.$user, null), 3, null);
            Deferred deferredAsync$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new HomeFragment$updateUserDataWithTokenValidation$6$decksDeferred$1(HomeFragment.this, this.$user, null), 3, null);
            Deferred deferredAsync$default4 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new HomeFragment$updateUserDataWithTokenValidation$6$playgroupsDeferred$1(HomeFragment.this, this.$user, null), 3, null);
            Deferred deferredAsync$default5 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new HomeFragment$updateUserDataWithTokenValidation$6$formatsDeferred$1(HomeFragment.this, this.$user, null), 3, null);
            Deferred deferredAsync$default6 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new HomeFragment$updateUserDataWithTokenValidation$6$collectionDeferred$1(HomeFragment.this, this.$user, null), 3, null);
            Deferred deferredAsync$default7 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new HomeFragment$updateUserDataWithTokenValidation$6$listsDeferred$1(HomeFragment.this, this.$user, null), 3, null);
            Deferred deferredAsync$default8 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new HomeFragment$updateUserDataWithTokenValidation$6$sharedCollectionsBadgeDeferred$1(HomeFragment.this, this.$user, null), 3, null);
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(deferredAsync$default);
            this.L$2 = SpillingKt.nullOutSpilledVariable(deferredAsync$default2);
            this.L$3 = SpillingKt.nullOutSpilledVariable(deferredAsync$default3);
            this.L$4 = SpillingKt.nullOutSpilledVariable(deferredAsync$default4);
            this.L$5 = SpillingKt.nullOutSpilledVariable(deferredAsync$default5);
            this.L$6 = SpillingKt.nullOutSpilledVariable(deferredAsync$default6);
            this.L$7 = SpillingKt.nullOutSpilledVariable(deferredAsync$default7);
            this.L$8 = SpillingKt.nullOutSpilledVariable(deferredAsync$default8);
            this.label = 1;
            Object objAwaitAll = AwaitKt.awaitAll(new Deferred[]{deferredAsync$default, deferredAsync$default2, deferredAsync$default3, deferredAsync$default4, deferredAsync$default5, deferredAsync$default6, deferredAsync$default7, deferredAsync$default8}, this);
            return objAwaitAll == coroutine_suspended ? coroutine_suspended : objAwaitAll;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$7, reason: invalid class name */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$7", f = "HomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass7(Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new AnonymousClass7(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (HomeFragment.this.getContext() != null && HomeFragment.this._binding != null) {
                HomeFragment.this.getBinding().swipeRefreshLayout.setRefreshing(false);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$updateUserDecks$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$updateUserDecks$2", f = "HomeFragment.kt", i = {1, 1, 1}, l = {2035, 2038}, m = "invokeSuspend", n = {"response", "decks", "$i$a$-let-HomeFragment$updateUserDecks$2$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C11832 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ int $userId;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11832(int i, Continuation<? super C11832> continuation) {
            super(2, continuation);
            this.$userId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new C11832(this.$userId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C11832) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
        
            if (r10 == r0) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            List<MTDeck> decks;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = HomeFragment.this.await(MTApiKt.getMtApi().getDecks(this.$userId), this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxBoolean(true);
                }
                ResultKt.throwOnFailure(obj);
                Response response = (Response) obj;
                if (response.isSuccessful()) {
                    MTDecksResponse mTDecksResponse = (MTDecksResponse) response.body();
                    if (mTDecksResponse != null && (decks = mTDecksResponse.getDecks()) != null) {
                        HomeFragment homeFragment = HomeFragment.this;
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        HomeFragment$updateUserDecks$2$1$1 homeFragment$updateUserDecks$2$1$1 = new HomeFragment$updateUserDecks$2$1$1(homeFragment, decks, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(decks);
                        this.I$0 = 0;
                        this.label = 2;
                        obj = BuildersKt.withContext(main, homeFragment$updateUserDecks$2$1$1, this);
                    }
                    return Boxing.boxBoolean(true);
                }
            } catch (Exception e) {
                Log.e("HomeFragment", "Error updating decks", e);
            }
            return Boxing.boxBoolean(false);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$updateUserFriends$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$updateUserFriends$2", f = "HomeFragment.kt", i = {1, 1, 1}, l = {2015, 2018}, m = "invokeSuspend", n = {"response", NativeProtocol.AUDIENCE_FRIENDS, "$i$a$-let-HomeFragment$updateUserFriends$2$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C11842 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ int $userId;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11842(int i, Continuation<? super C11842> continuation) {
            super(2, continuation);
            this.$userId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new C11842(this.$userId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C11842) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
        
            if (r10 == r0) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            List<MTFriend> friends;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = HomeFragment.this.await(MTApiKt.getMtApi().getFriends(this.$userId), this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxBoolean(true);
                }
                ResultKt.throwOnFailure(obj);
                Response response = (Response) obj;
                if (response.isSuccessful()) {
                    MTFriendResponse mTFriendResponse = (MTFriendResponse) response.body();
                    if (mTFriendResponse != null && (friends = mTFriendResponse.getFriends()) != null) {
                        HomeFragment homeFragment = HomeFragment.this;
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        HomeFragment$updateUserFriends$2$1$1 homeFragment$updateUserFriends$2$1$1 = new HomeFragment$updateUserFriends$2$1$1(homeFragment, friends, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(friends);
                        this.I$0 = 0;
                        this.label = 2;
                        obj = BuildersKt.withContext(main, homeFragment$updateUserFriends$2$1$1, this);
                    }
                    return Boxing.boxBoolean(true);
                }
            } catch (Exception e) {
                Log.e("HomeFragment", "Error updating friends", e);
            }
            return Boxing.boxBoolean(false);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$updateUserPlaygroups$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$updateUserPlaygroups$2", f = "HomeFragment.kt", i = {1, 1, 1}, l = {2055, 2058}, m = "invokeSuspend", n = {"response", "playgroups", "$i$a$-let-HomeFragment$updateUserPlaygroups$2$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C11852 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ int $userId;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11852(int i, Continuation<? super C11852> continuation) {
            super(2, continuation);
            this.$userId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new C11852(this.$userId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C11852) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
        
            if (r10 == r0) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            List<MTPlaygroup> playgroups;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = HomeFragment.this.await(MTApiKt.getMtApi().getPlaygroups(this.$userId), this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxBoolean(true);
                }
                ResultKt.throwOnFailure(obj);
                Response response = (Response) obj;
                if (response.isSuccessful()) {
                    MTPlaygroupResponse mTPlaygroupResponse = (MTPlaygroupResponse) response.body();
                    if (mTPlaygroupResponse != null && (playgroups = mTPlaygroupResponse.getPlaygroups()) != null) {
                        HomeFragment homeFragment = HomeFragment.this;
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        HomeFragment$updateUserPlaygroups$2$1$1 homeFragment$updateUserPlaygroups$2$1$1 = new HomeFragment$updateUserPlaygroups$2$1$1(homeFragment, playgroups, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(playgroups);
                        this.I$0 = 0;
                        this.label = 2;
                        obj = BuildersKt.withContext(main, homeFragment$updateUserPlaygroups$2$1$1, this);
                    }
                    return Boxing.boxBoolean(true);
                }
            } catch (Exception e) {
                Log.e("HomeFragment", "Error updating playgroups", e);
            }
            return Boxing.boxBoolean(false);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.HomeFragment$updateUserProfile$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.HomeFragment$updateUserProfile$2", f = "HomeFragment.kt", i = {1, 1, 1}, l = {1970, 1973}, m = "invokeSuspend", n = {"response", "userResponse", "$i$a$-let-HomeFragment$updateUserProfile$2$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C11862 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ int $userId;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11862(int i, Continuation<? super C11862> continuation) {
            super(2, continuation);
            this.$userId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new C11862(this.$userId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C11862) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x007a, code lost:
        
            if (r11 == r0) goto L25;
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
                    this.label = 1;
                    obj = HomeFragment.this.await(MTApiKt.getMtApi().user(this.$userId), this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxBoolean(true);
                }
                ResultKt.throwOnFailure(obj);
                Response response = (Response) obj;
                if (response.isSuccessful()) {
                    MTUserResponse mTUserResponse = (MTUserResponse) response.body();
                    if (mTUserResponse != null) {
                        HomeFragment homeFragment = HomeFragment.this;
                        int i2 = this.$userId;
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        HomeFragment$updateUserProfile$2$1$1 homeFragment$updateUserProfile$2$1$1 = new HomeFragment$updateUserProfile$2$1$1(homeFragment, mTUserResponse, i2, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(mTUserResponse);
                        this.I$0 = 0;
                        this.label = 2;
                        obj = BuildersKt.withContext(main, homeFragment$updateUserProfile$2$1$1, this);
                    }
                    return Boxing.boxBoolean(true);
                }
            } catch (Exception e) {
                Log.e("HomeFragment", "Error updating user profile", e);
            }
            return Boxing.boxBoolean(false);
        }
    }

    public HomeFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda51
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Intrinsics.checkNotNullParameter((ActivityResult) obj, "<unused var>");
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.playgroupActivityLauncher = activityResultLauncherRegisterForActivityResult;
        this.paywallActivityLauncher = new PaywallActivityLauncher(this, new PaywallResultHandler() { // from class: com.studiolaganne.lengendarylens.HomeFragment$paywallActivityLauncher$1
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(PaywallResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (!(result instanceof PaywallResult.Purchased)) {
                    if (result instanceof PaywallResult.Restored) {
                        Context context = this.this$0.getContext();
                        if (context != null) {
                            MythicPlusManager.INSTANCE.refreshStatus(context);
                        }
                        this.this$0.updateMythicPlusBanner();
                        return;
                    }
                    return;
                }
                Context context2 = this.this$0.getContext();
                if (context2 != null) {
                    MythicPlusManager.INSTANCE.refreshStatus(context2);
                }
                this.this$0.updateMythicPlusBanner();
                FragmentActivity activity = this.this$0.getActivity();
                if (!(activity instanceof FragmentActivity)) {
                    activity = null;
                }
                if (activity != null) {
                    MythicPlusThankYouDialog.INSTANCE.show(activity);
                }
            }
        });
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda53
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Intrinsics.checkNotNullParameter((ActivityResult) obj, "<unused var>");
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.deckActivityLauncher = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda54
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Intrinsics.checkNotNullParameter((ActivityResult) obj, "<unused var>");
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(...)");
        this.eventActivityLauncher = activityResultLauncherRegisterForActivityResult3;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda56
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Intrinsics.checkNotNullParameter((ActivityResult) obj, "<unused var>");
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult4, "registerForActivityResult(...)");
        this.settingsActivityLauncher = activityResultLauncherRegisterForActivityResult4;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult5 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda57
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Intrinsics.checkNotNullParameter((ActivityResult) obj, "<unused var>");
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult5, "registerForActivityResult(...)");
        this.aboutActivityLauncher = activityResultLauncherRegisterForActivityResult5;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult6 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda58
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                HomeFragment.cardActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult6, "registerForActivityResult(...)");
        this.cardActivityLauncher = activityResultLauncherRegisterForActivityResult6;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult7 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda59
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                HomeFragment.pickCardLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult7, "registerForActivityResult(...)");
        this.pickCardLauncher = activityResultLauncherRegisterForActivityResult7;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult8 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda60
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Intrinsics.checkNotNullParameter((ActivityResult) obj, "<unused var>");
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult8, "registerForActivityResult(...)");
        this.rulesActivityLauncher = activityResultLauncherRegisterForActivityResult8;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult9 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda61
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                HomeFragment.searchActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult9, "registerForActivityResult(...)");
        this.searchActivityLauncher = activityResultLauncherRegisterForActivityResult9;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult10 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda62
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                HomeFragment.requestNotificationPermissionLauncher$lambda$0(((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult10, "registerForActivityResult(...)");
        this.requestNotificationPermissionLauncher = activityResultLauncherRegisterForActivityResult10;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult11 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda52
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                HomeFragment.requestCameraPermissionLauncher$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult11, "registerForActivityResult(...)");
        this.requestCameraPermissionLauncher = activityResultLauncherRegisterForActivityResult11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object await(Call<T> call, Continuation<? super Response<T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        call.enqueue(new Callback<T>() { // from class: com.studiolaganne.lengendarylens.HomeFragment$await$2$1
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                CancellableContinuation<Response<T>> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(t)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                CancellableContinuation<Response<T>> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m11445constructorimpl(response));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    static final void cardActivityLauncher$lambda$0(final HomeFragment homeFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "<unused var>");
        Context context = homeFragment.getContext();
        if (context != null) {
            PreferencesManager preferencesManager = new PreferencesManager(context);
            if (preferencesManager.getBoolean(PreferencesManager.CARD_RATING_PROMPT_SHOWN, false)) {
                return;
            }
            preferencesManager.setBoolean(PreferencesManager.CARD_RATING_PROMPT_SHOWN, true);
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("rating_prompt_card", null);
            final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(context);
            Intrinsics.checkNotNullExpressionValue(reviewManagerCreate, "create(...)");
            reviewManagerCreate.requestReviewFlow().addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda35
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    HomeFragment.cardActivityLauncher$lambda$0$0$0(this.f$0, reviewManagerCreate, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cardActivityLauncher$lambda$0$0$0(HomeFragment homeFragment, ReviewManager reviewManager, Task it) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(it, "it");
        if (!it.isSuccessful() || (activity = homeFragment.getActivity()) == null) {
            return;
        }
        reviewManager.launchReviewFlow(activity, (ReviewInfo) it.getResult());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkState(MTUserState currentState) {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null) {
            return;
        }
        MTUserSettings settings = currentState.getSettings();
        if (settings != null) {
            preferencesManager.applyMTUserSettings(settings);
        } else {
            MTUser currentUser2 = preferencesManager.getCurrentUser();
            if (currentUser2 != null) {
                MTApiKt.getMtApi().syncSettings(currentUser2.getId(), preferencesManager.getMTUserSettings()).enqueue(new Callback<MTSuccessResponse>() { // from class: com.studiolaganne.lengendarylens.HomeFragment$checkState$2$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTSuccessResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTSuccessResponse> call, Response<MTSuccessResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                    }
                });
            }
        }
        List<MTPurchase> purchases = currentState.getPurchases();
        if (purchases != null) {
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (Object obj : purchases) {
                if (hashSet.add(((MTPurchase) obj).getName())) {
                    arrayList.add(obj);
                }
            }
            ArrayList<MTPurchase> arrayList2 = arrayList;
            for (final MTPurchase mTPurchase : arrayList2) {
                if (Intrinsics.areEqual(mTPurchase.getName(), PreferencesManager.SOLRING_PURCHASE)) {
                    preferencesManager.addThemePurchased(PreferencesManager.SOLRING_THEME);
                    Map<String, String> mutableMap = MapsKt.toMutableMap(preferencesManager.getAllThemeTokens());
                    if (!mutableMap.containsKey(PreferencesManager.SOLRING_THEME)) {
                        mutableMap.put(PreferencesManager.SOLRING_THEME, "restored_from_account_v3");
                    }
                    preferencesManager.saveAllThemeTokens(mutableMap);
                } else if (Intrinsics.areEqual(mTPurchase.getName(), PreferencesManager.XMAS_PURCHASE)) {
                    preferencesManager.addThemePurchased(PreferencesManager.XMAS_THEME);
                    Map<String, String> mutableMap2 = MapsKt.toMutableMap(preferencesManager.getAllThemeTokens());
                    if (!mutableMap2.containsKey(PreferencesManager.XMAS_THEME)) {
                        mutableMap2.put(PreferencesManager.XMAS_THEME, "restored_from_account_v3");
                    }
                    preferencesManager.saveAllThemeTokens(mutableMap2);
                } else if (Intrinsics.areEqual(mTPurchase.getName(), PreferencesManager.BURN_PURCHASE)) {
                    preferencesManager.addThemePurchased(PreferencesManager.BURN_THEME);
                    Map<String, String> mutableMap3 = MapsKt.toMutableMap(preferencesManager.getAllThemeTokens());
                    if (!mutableMap3.containsKey(PreferencesManager.BURN_THEME)) {
                        mutableMap3.put(PreferencesManager.BURN_THEME, "restored_from_account_v3");
                    }
                    preferencesManager.saveAllThemeTokens(mutableMap3);
                } else if (Intrinsics.areEqual(mTPurchase.getName(), PreferencesManager.LOVE_PURCHASE)) {
                    preferencesManager.addThemePurchased(PreferencesManager.LOVE_THEME);
                    Map<String, String> mutableMap4 = MapsKt.toMutableMap(preferencesManager.getAllThemeTokens());
                    if (!mutableMap4.containsKey(PreferencesManager.LOVE_THEME)) {
                        mutableMap4.put(PreferencesManager.LOVE_THEME, "restored_from_account_v3");
                    }
                    preferencesManager.saveAllThemeTokens(mutableMap4);
                } else if (Intrinsics.areEqual(mTPurchase.getName(), PreferencesManager.AF_PURCHASE)) {
                    preferencesManager.addThemePurchased(PreferencesManager.AF_THEME);
                    Map<String, String> mutableMap5 = MapsKt.toMutableMap(preferencesManager.getAllThemeTokens());
                    if (!mutableMap5.containsKey(PreferencesManager.AF_THEME)) {
                        mutableMap5.put(PreferencesManager.AF_THEME, "restored_from_account_v3");
                    }
                    preferencesManager.saveAllThemeTokens(mutableMap5);
                } else if (Intrinsics.areEqual(mTPurchase.getName(), PreferencesManager.LUPO_PURCHASE)) {
                    preferencesManager.addThemePurchased(PreferencesManager.LUPO_THEME);
                    Map<String, String> mutableMap6 = MapsKt.toMutableMap(preferencesManager.getAllThemeTokens());
                    if (!mutableMap6.containsKey(PreferencesManager.LUPO_THEME)) {
                        mutableMap6.put(PreferencesManager.LUPO_THEME, "restored_from_account_v3");
                    }
                    preferencesManager.saveAllThemeTokens(mutableMap6);
                } else if (StringsKt.startsWith$default(mTPurchase.getGoogleproductid(), "free_", false, 2, (Object) null) || StringsKt.startsWith$default(mTPurchase.getGoogleproductid(), "theme_", false, 2, (Object) null)) {
                    if (!preferencesManager.getAllThemeTokens().containsKey(mTPurchase.getName())) {
                        MTApiKt.getMtApi().getThemeByPurchaseId(currentUser.getId(), mTPurchase.getGoogleproductid(), preferencesManager.getDeviceLanguage()).enqueue(new Callback<MTSingleThemeResponse>() { // from class: com.studiolaganne.lengendarylens.HomeFragment$checkState$3$1
                            @Override // retrofit2.Callback
                            public void onFailure(Call<MTSingleThemeResponse> call, Throwable t) {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(t, "t");
                                Log.d("HomeFragment", "Failed to fetch theme details for purchase " + mTPurchase.getGoogleproductid(), t);
                            }

                            @Override // retrofit2.Callback
                            public void onResponse(Call<MTSingleThemeResponse> call, Response<MTSingleThemeResponse> response) {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(response, "response");
                                if (!response.isSuccessful()) {
                                    Map<String, String> mutableMap7 = MapsKt.toMutableMap(preferencesManager.getAllThemeTokens());
                                    mutableMap7.put(mTPurchase.getName(), "restored_from_account_v2_failed");
                                    preferencesManager.saveAllThemeTokens(mutableMap7);
                                    return;
                                }
                                MTSingleThemeResponse mTSingleThemeResponseBody = response.body();
                                MTTheme theme = mTSingleThemeResponseBody != null ? mTSingleThemeResponseBody.getTheme() : null;
                                if (theme != null) {
                                    PreferencesManager preferencesManager2 = preferencesManager;
                                    MTPurchase mTPurchase2 = mTPurchase;
                                    Map<String, String> mutableMap8 = MapsKt.toMutableMap(preferencesManager2.getAllThemeTokens());
                                    mutableMap8.put(mTPurchase2.getName(), "restored_from_account_v3");
                                    preferencesManager2.saveAllThemeTokens(mutableMap8);
                                    List<MTTheme> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager2.getLocalThemesCache());
                                    List<MTTheme> list = mutableList;
                                    if ((list instanceof Collection) && list.isEmpty()) {
                                        mutableList.add(theme);
                                        preferencesManager2.setBoolean(PreferencesManager.REFRESH_THEMES, true);
                                    } else {
                                        Iterator<T> it = list.iterator();
                                        while (it.hasNext()) {
                                            if (((MTTheme) it.next()).getId() == theme.getId()) {
                                                break;
                                            }
                                        }
                                        mutableList.add(theme);
                                        preferencesManager2.setBoolean(PreferencesManager.REFRESH_THEMES, true);
                                    }
                                    preferencesManager2.saveLocalThemesCache(mutableList);
                                }
                            }
                        });
                    }
                }
            }
            List<String> themesPurchased = preferencesManager.getThemesPurchased();
            List<String> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getThemesPurchased());
            for (final String str : themesPurchased) {
                ArrayList arrayList3 = arrayList2;
                if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(((MTPurchase) it.next()).getGoogleproductid(), str)) {
                            break;
                        }
                    }
                }
                CollectionsKt.removeAll((List) mutableList, new Function1() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Boolean.valueOf(HomeFragment.checkState$lambda$2$2(str, (String) obj2));
                    }
                });
            }
            preferencesManager.setThemesPurchased(mutableList);
            List<MTTheme> localThemesCache = preferencesManager.getLocalThemesCache();
            List<MTTheme> mutableList2 = CollectionsKt.toMutableList((Collection) preferencesManager.getLocalThemesCache());
            for (final MTTheme mTTheme : localThemesCache) {
                ArrayList arrayList4 = arrayList2;
                if (!(arrayList4 instanceof Collection) || !arrayList4.isEmpty()) {
                    Iterator it2 = arrayList4.iterator();
                    while (it2.hasNext()) {
                        if (Intrinsics.areEqual(((MTPurchase) it2.next()).getGoogleproductid(), mTTheme.getGoogleproductid())) {
                            break;
                        }
                    }
                }
                CollectionsKt.removeAll((List) mutableList2, new Function1() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Boolean.valueOf(HomeFragment.checkState$lambda$2$4(mTTheme, (MTTheme) obj2));
                    }
                });
            }
            preferencesManager.saveLocalThemesCache(mutableList2);
        }
        List<MTTutorialState> tutorials = currentState.getTutorials();
        if (tutorials != null) {
            for (MTTutorialState mTTutorialState : tutorials) {
                if (mTTutorialState.getId() == 1 && mTTutorialState.getSeen()) {
                    preferencesManager.setBoolean(PreferencesManager.GAME_TUTORIAL_SHOWN, true);
                    PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean checkState$lambda$2$2(String str, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean checkState$lambda$2$4(MTTheme mTTheme, MTTheme it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getGoogleproductid(), mTTheme.getGoogleproductid());
    }

    private final void clearNotifications() {
        ((NotificationManager) requireContext().getSystemService(NotificationManager.class)).cancelAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchFriendListAndShowPending(final int friendId) {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        final MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            MTApiKt.getMtApi().getFriends(currentUser.getId()).enqueue(new Callback<MTFriendResponse>() { // from class: com.studiolaganne.lengendarylens.HomeFragment$fetchFriendListAndShowPending$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTFriendResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTFriendResponse> call, Response<MTFriendResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getContext() == null || this.this$0.getChildFragmentManager().isStateSaved() || !response.isSuccessful() || this.this$0.getContext() == null) {
                        return;
                    }
                    MTFriendResponse mTFriendResponseBody = response.body();
                    Object obj = null;
                    List<MTFriend> friends = mTFriendResponseBody != null ? mTFriendResponseBody.getFriends() : null;
                    if (friends != null) {
                        PreferencesManager preferencesManager2 = preferencesManager;
                        HomeFragment homeFragment = this.this$0;
                        MTUser mTUser = currentUser;
                        int i = friendId;
                        preferencesManager2.saveCurrentUserFriends(friends);
                        homeFragment.updateFriends(mTUser, friends);
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
                        if (mTFriend == null || homeFragment.getChildFragmentManager().isStateSaved()) {
                            return;
                        }
                        new AcceptFriendBottomSheetFragment(homeFragment, mTUser, mTFriend).show(homeFragment.getChildFragmentManager(), AcceptFriendBottomSheetFragment.TAG);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchPlaygroupListAndShowPending(final int playgroupId) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        final MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            MTApiKt.getMtApi().getPlaygroups(currentUser.getId()).enqueue(new Callback<MTPlaygroupResponse>() { // from class: com.studiolaganne.lengendarylens.HomeFragment$fetchPlaygroupListAndShowPending$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTPlaygroupResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTPlaygroupResponse> call, Response<MTPlaygroupResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getContext() == null || this.this$0._binding == null || !response.isSuccessful() || this.this$0.getContext() == null) {
                        return;
                    }
                    MTPlaygroupResponse mTPlaygroupResponseBody = response.body();
                    Object obj = null;
                    List<MTPlaygroup> playgroups = mTPlaygroupResponseBody != null ? mTPlaygroupResponseBody.getPlaygroups() : null;
                    if (playgroups != null) {
                        PreferencesManager preferencesManager2 = preferencesManager;
                        HomeFragment homeFragment = this.this$0;
                        MTUser mTUser = currentUser;
                        int i = playgroupId;
                        preferencesManager2.saveCurrentUserPlaygroups(playgroups);
                        homeFragment.updatePlaygroups(mTUser, playgroups);
                        Iterator<T> it = playgroups.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object next = it.next();
                            if (((MTPlaygroup) next).getId() == i) {
                                obj = next;
                                break;
                            }
                        }
                        MTPlaygroup mTPlaygroup = (MTPlaygroup) obj;
                        if (mTPlaygroup == null || homeFragment.getChildFragmentManager().isStateSaved()) {
                            return;
                        }
                        new AcceptPlaygroupBottomSheetFragment(homeFragment, mTUser, mTPlaygroup).show(homeFragment.getChildFragmentManager(), AcceptPlaygroupBottomSheetFragment.TAG);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentHomeBinding getBinding() {
        FragmentHomeBinding fragmentHomeBinding = this._binding;
        Intrinsics.checkNotNull(fragmentHomeBinding);
        return fragmentHomeBinding;
    }

    private final void handleLocalUpdates(PreferencesManager prefs) {
        MTUser currentUser = prefs.getCurrentUser();
        if (!prefs.getBoolean(PreferencesManager.NEED_USER_RELOAD, false) || currentUser == null) {
            return;
        }
        updateUserUI(prefs, currentUser, prefs.getCurrentUserPlaygroups(), prefs.getCurrentUserDecks(), prefs.getCurrentUserFriends());
        prefs.setBoolean(PreferencesManager.NEED_USER_RELOAD, false);
    }

    private final void handlePendingOAuthResponses(PreferencesManager prefs) {
        String string = prefs.getString("pending_oauth_code", "");
        String string2 = prefs.getString("pending_oauth_provider", "");
        if (string.length() <= 0 || string2.length() <= 0 || getChildFragmentManager().isStateSaved()) {
            return;
        }
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(SignInBottomSheetFragment.TAG);
        SignInBottomSheetFragment signInBottomSheetFragment = fragmentFindFragmentByTag instanceof SignInBottomSheetFragment ? (SignInBottomSheetFragment) fragmentFindFragmentByTag : null;
        if (signInBottomSheetFragment != null) {
            signInBottomSheetFragment.onOAuthCodeReceived(string, string2);
        }
        prefs.setString("pending_oauth_code", "");
        prefs.setString("pending_oauth_provider", "");
    }

    private final void handleResumeActions(PreferencesManager prefs) {
        handlePendingOAuthResponses(prefs);
        clearNotifications();
        processStoredFCMIntents(prefs);
        processNotificationIntents(prefs);
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
        List<MTPlaygroup> list = listEmptyList;
        if (response == null || (listEmptyList2 = response.getFriends()) == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        List<MTFriend> list2 = listEmptyList2;
        if (response == null || (listEmptyList3 = response.getDecks()) == null) {
            listEmptyList3 = CollectionsKt.emptyList();
        }
        List<MTDeck> list3 = listEmptyList3;
        String result = response != null ? response.getResult() : null;
        if (user != null) {
            FirebaseAnalytics.getInstance(requireContext()).setUserProperty("is_logged_in", "true");
            preferencesManager.saveCurrentUser(user);
            preferencesManager.saveCurrentUserPlaygroups(list);
            preferencesManager.saveCurrentUserFriends(list2);
            preferencesManager.saveCurrentUserDecks(list3);
            updateUserUI(preferencesManager, user, list, list3, list2);
            FragmentActivity activity = getActivity();
            MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
            if (mainActivity != null) {
                mainActivity.userLoggedIn();
            }
            MTUserState state = response.getState();
            if (state != null) {
                checkState(state);
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
                        processRecentCards(mTCardContainer);
                    }
                }
            }
            MTCommunityEvent event = response.getEvent();
            if (event != null) {
                showEventBanner(event);
            }
            MessagesManager companion = MessagesManager.INSTANCE.getInstance();
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            companion.updateAllMessages(contextRequireContext2, new MessagesManagerListener() { // from class: com.studiolaganne.lengendarylens.HomeFragment$handleSuccessfulFirebaseLogin$1$10
                @Override // com.studiolaganne.lengendarylens.MessagesManagerListener
                public void onMessagesUpdated(int playgroupId) {
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    RecyclerView.Adapter adapter = this.this$0.getBinding().playgroupsRecyclerView.getAdapter();
                    PlaygroupsAdapter playgroupsAdapter = adapter instanceof PlaygroupsAdapter ? (PlaygroupsAdapter) adapter : null;
                    if (playgroupsAdapter != null) {
                        playgroupsAdapter.notifyDataSetChanged();
                    }
                }
            });
            requestNotificationPermission();
            if (Intrinsics.areEqual(result, "signup")) {
                Breadcrumbs.INSTANCE.leaveBreadcrumb("home_sign_up");
                FirebaseAnalytics.getInstance(requireContext()).logEvent("home_sign_up", null);
                ProfileBottomSheetFragment.Companion.newInstance$default(ProfileBottomSheetFragment.INSTANCE, this, user, null, null, 12, null).show(getChildFragmentManager(), ProfileBottomSheetFragment.TAG);
            }
            refreshFormats();
        }
    }

    private final boolean isNotValid(String cardName, String lang) {
        if (Intrinsics.areEqual(lang, "fr")) {
            String[] strArr = {"plaine", "marais", "forêt", "île", "montagne"};
            Locale FRANCE = Locale.FRANCE;
            Intrinsics.checkNotNullExpressionValue(FRANCE, "FRANCE");
            String lowerCase = cardName.toLowerCase(FRANCE);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (ArraysKt.contains(strArr, lowerCase)) {
                return true;
            }
        } else {
            String[] strArr2 = {"plains", "swamp", "forest", "island", "mountain"};
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String lowerCase2 = cardName.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (ArraysKt.contains(strArr2, lowerCase2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markOnboardingSeen(int userId, int onboardingId) {
        MTApiKt.getMtApi().onboardingSeen(userId, onboardingId).enqueue(new Callback<MTSuccessResponse>() { // from class: com.studiolaganne.lengendarylens.HomeFragment.markOnboardingSeen.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSuccessResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSuccessResponse> call, Response<MTSuccessResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
            }
        });
    }

    @JvmStatic
    public static final HomeFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAddFriendTapped$lambda$0$0(HomeFragment homeFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        homeFragment.requestCameraPermissionLauncher.launch("android.permission.CAMERA");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAddFriendTapped$lambda$0$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAddFriendTapped$lambda$0$2(HomeFragment homeFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        homeFragment.openAppSettings();
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAddFriendTapped$lambda$0$3(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final void onDeckCreated$lambda$1(final HomeFragment homeFragment) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return;
        }
        final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(homeFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(reviewManagerCreate, "create(...)");
        reviewManagerCreate.requestReviewFlow().addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                HomeFragment.onDeckCreated$lambda$1$0(this.f$0, reviewManagerCreate, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDeckCreated$lambda$1$0(HomeFragment homeFragment, ReviewManager reviewManager, Task it) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(it, "it");
        if (!it.isSuccessful() || (activity = homeFragment.getActivity()) == null) {
            return;
        }
        reviewManager.launchReviewFlow(activity, (ReviewInfo) it.getResult());
    }

    static final Unit onDeckTemporary$lambda$0(HomeFragment homeFragment, MTDeck mTDeck, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Context contextRequireContext = homeFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            homeFragment.getBinding().overlay.setVisibility(0);
            homeFragment.getBinding().connectingTextView.setText(homeFragment.getString(R.string.updating));
            MTApiKt.getMtApi().acceptDeck(currentUser.getId(), mTDeck.getId()).enqueue(new HomeFragment$onDeckTemporary$1$1$1(homeFragment, preferencesManager, currentUser));
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeckTemporary$lambda$1(HomeFragment homeFragment, MTDeck mTDeck, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = homeFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            homeFragment.getBinding().overlay.setVisibility(0);
            homeFragment.getBinding().connectingTextView.setText(homeFragment.getString(R.string.deleting));
            MTApiKt.getMtApi().deleteDeck(currentUser.getId(), mTDeck.getId(), false).enqueue(new HomeFragment$onDeckTemporary$2$1$1(homeFragment, preferencesManager, mTDeck, currentUser));
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onFriendSelected$lambda$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onFriendSelected$lambda$1(HomeFragment homeFragment, MTFriend mTFriend, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (homeFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        Context contextRequireContext = homeFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            MTApiKt.getMtApi().removeFriend(currentUser.getId(), mTFriend.getId()).enqueue(new HomeFragment$onFriendSelected$2$1$1(homeFragment, preferencesManager, currentUser));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onQRScanned$lambda$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final void onRandomCardClickNew$lambda$0(HomeFragment homeFragment, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        Intent intent = new Intent(homeFragment.requireContext(), (Class<?>) CardActivity.class);
        intent.putExtra("scryfallId", ((CardRecord) objectRef.element).getScryfall_id());
        intent.putExtra("enScryfallId", (String) objectRef2.element);
        intent.putExtra("oracleId", ((CardRecord) objectRef.element).getOracle_id());
        intent.putExtra("lang", "fr");
        homeFragment.cardActivityLauncher.launch(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final void onRandomCardClickNew$lambda$1(HomeFragment homeFragment, Ref.ObjectRef objectRef) {
        Intent intent = new Intent(homeFragment.requireContext(), (Class<?>) CardActivity.class);
        intent.putExtra("scryfallId", ((CardRecord) objectRef.element).getScryfall_id());
        intent.putExtra("oracleId", ((CardRecord) objectRef.element).getOracle_id());
        intent.putExtra("lang", "en");
        homeFragment.cardActivityLauncher.launch(intent);
    }

    static final Unit onSignInFailure$lambda$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final void onViewCreated$lambda$0(HomeFragment homeFragment) {
        LifecycleOwner viewLifecycleOwner = homeFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new HomeFragment$onViewCreated$2$1(homeFragment, null), 3, null);
    }

    static final Unit onViewCreated$lambda$1(HomeFragment homeFragment) {
        if (homeFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(homeFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("store_open", null);
        homeFragment.startActivity(new Intent(homeFragment.requireContext(), (Class<?>) StoreActivity.class));
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$10(HomeFragment homeFragment) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        homeFragment.startActivity(new Intent(homeFragment.requireContext(), (Class<?>) FriendsListActivity.class));
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$11(HomeFragment homeFragment) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        homeFragment.startActivity(new Intent(homeFragment.requireContext(), (Class<?>) PlaygroupListActivity.class));
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$12(HomeFragment homeFragment) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        homeFragment.startActivity(new Intent(homeFragment.requireContext(), (Class<?>) DecksListActivity.class));
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$13(HomeFragment homeFragment) {
        homeFragment.randomKeyword();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$14(HomeFragment homeFragment) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("home_profile_click");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(homeFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("home_profile_click", null);
        Context contextRequireContext = homeFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            if (!homeFragment.getChildFragmentManager().isStateSaved()) {
                ProfileBottomSheetFragment.Companion.newInstance$default(ProfileBottomSheetFragment.INSTANCE, homeFragment, currentUser, null, null, 12, null).show(homeFragment.getChildFragmentManager(), ProfileBottomSheetFragment.TAG);
            }
        } else if (!homeFragment.getChildFragmentManager().isStateSaved()) {
            SignInBottomSheetFragment.INSTANCE.newInstance(homeFragment).show(homeFragment.getChildFragmentManager(), SignInBottomSheetFragment.TAG);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$15(HomeFragment homeFragment) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        if (homeFragment.getChildFragmentManager().isStateSaved()) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("home_login_click");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(homeFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("home_login_click", null);
        SignInBottomSheetFragment.INSTANCE.newInstance(homeFragment).show(homeFragment.getChildFragmentManager(), SignInBottomSheetFragment.TAG);
        return Unit.INSTANCE;
    }

    static final void onViewCreated$lambda$16(HomeFragment homeFragment) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return;
        }
        MTApiKt.getMtApi().getVersion().enqueue(new HomeFragment$onViewCreated$18$1(homeFragment));
    }

    static final Unit onViewCreated$lambda$2(HomeFragment homeFragment) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("home_settings_click");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(homeFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("home_settings_click", null);
        homeFragment.settingsActivityLauncher.launch(new Intent(homeFragment.requireContext(), (Class<?>) SettingsActivity.class));
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$3(HomeFragment homeFragment) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("home_about_click");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(homeFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("home_about_click", null);
        homeFragment.aboutActivityLauncher.launch(new Intent(homeFragment.requireContext(), (Class<?>) AboutActivity.class));
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$4(final HomeFragment homeFragment) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("home_rules_click");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(homeFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("home_rules_click", null);
        homeFragment.getBinding().rulebookButtonLayout.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.onViewCreated$lambda$4$0(this.f$0);
            }
        }, 100L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4$0(HomeFragment homeFragment) {
        homeFragment.rulesActivityLauncher.launch(new Intent(homeFragment.requireContext(), (Class<?>) RulesActivity.class));
    }

    static final Unit onViewCreated$lambda$5(HomeFragment homeFragment) {
        FragmentActivity activity = homeFragment.getActivity();
        if (activity != null) {
            MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
            if (mainActivity != null) {
                mainActivity.goToSearch();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$6(HomeFragment homeFragment) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("create_playgroup_click");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(homeFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("create_playgroup_click", null);
        Context contextRequireContext = homeFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null && !homeFragment.getChildFragmentManager().isStateSaved()) {
            new CreatePlaygroupBottomSheetFragment(homeFragment, currentUser).show(homeFragment.getChildFragmentManager(), CreatePlaygroupBottomSheetFragment.TAG);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$7(HomeFragment homeFragment) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("create_playgroup_click");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(homeFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("create_playgroup_click", null);
        Context contextRequireContext = homeFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null && !homeFragment.getChildFragmentManager().isStateSaved()) {
            new CreatePlaygroupBottomSheetFragment(homeFragment, currentUser).show(homeFragment.getChildFragmentManager(), CreatePlaygroupBottomSheetFragment.TAG);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$8(HomeFragment homeFragment) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("create_deck_click");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(homeFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("create_deck_click", null);
        Context contextRequireContext = homeFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null && !homeFragment.getChildFragmentManager().isStateSaved()) {
            CreateDeckBottomSheetFragment.Companion.newInstance$default(CreateDeckBottomSheetFragment.INSTANCE, homeFragment, homeFragment.searchActivityLauncher, homeFragment.pickCardLauncher, currentUser, null, 16, null).show(homeFragment.getChildFragmentManager(), CreateDeckBottomSheetFragment.TAG);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$9(HomeFragment homeFragment) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("create_deck_click");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(homeFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("create_deck_click", null);
        Context contextRequireContext = homeFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null && !homeFragment.getChildFragmentManager().isStateSaved()) {
            CreateDeckBottomSheetFragment.Companion.newInstance$default(CreateDeckBottomSheetFragment.INSTANCE, homeFragment, homeFragment.searchActivityLauncher, homeFragment.pickCardLauncher, currentUser, null, 16, null).show(homeFragment.getChildFragmentManager(), CreateDeckBottomSheetFragment.TAG);
        }
        return Unit.INSTANCE;
    }

    private final void openAppSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", requireContext().getPackageName(), null));
        startActivity(intent);
    }

    static final void pickCardLauncher$lambda$0(HomeFragment homeFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (homeFragment.getChildFragmentManager().isStateSaved()) {
            return;
        }
        Intent data = result.getData();
        String stringExtra = data != null ? data.getStringExtra("cardPicked") : null;
        Intent data2 = result.getData();
        int intExtra = data2 != null ? data2.getIntExtra(OptionalModuleUtils.FACE, 0) : 0;
        if (stringExtra != null) {
            MTFullCard mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class);
            Fragment fragmentFindFragmentByTag = homeFragment.getChildFragmentManager().findFragmentByTag(CreateDeckBottomSheetFragment.TAG);
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment = fragmentFindFragmentByTag instanceof CreateDeckBottomSheetFragment ? (CreateDeckBottomSheetFragment) fragmentFindFragmentByTag : null;
            if (createDeckBottomSheetFragment != null) {
                Intrinsics.checkNotNull(mTFullCard);
                createDeckBottomSheetFragment.cardScanned(mTFullCard, intExtra);
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void processNotificationIntents(PreferencesManager prefs) {
        String str;
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        String string = prefs.getString(PreferencesManager.INTENT_TO_PROCESS, "");
        if (string.length() > 0) {
            Object objFromJson = new Gson().fromJson(string, new TypeToken<Map<String, ? extends Object>>() { // from class: com.studiolaganne.lengendarylens.HomeFragment$processNotificationIntents$type$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
            Map map = (Map) objFromJson;
            Object obj = map.get("type");
            String str2 = obj instanceof String ? (String) obj : null;
            if (str2 != null) {
                prefs.setString(PreferencesManager.INTENT_TO_PROCESS, "");
                switch (str2.hashCode()) {
                    case -1814490512:
                        if (!str2.equals(PreferencesManager.MSG_TYPE_SHARED_COLLECTION_INVITE)) {
                            return;
                        }
                        break;
                    case -1707926102:
                        if (str2.equals(PreferencesManager.MSG_TYPE_FRIENDSHIP_REQUEST)) {
                            Object obj2 = map.get("fromUserId");
                            str = obj2 instanceof String ? (String) obj2 : null;
                            if (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
                                return;
                            }
                            fetchFriendListAndShowPending(intOrNull.intValue());
                            return;
                        }
                        return;
                    case -1208568283:
                        if (!str2.equals(PreferencesManager.MSG_TYPE_SHARED_COLLECTION_REJECTED)) {
                            return;
                        }
                        break;
                    case -517166289:
                        if (!str2.equals(PreferencesManager.MSG_TYPE_UNSHARE_COLLECTION_ACCEPTED)) {
                            return;
                        }
                        break;
                    case 610173073:
                        if (!str2.equals(PreferencesManager.MSG_TYPE_UNSHARE_COLLECTION_INVITE)) {
                            return;
                        }
                        break;
                    case 987952009:
                        if (str2.equals(PreferencesManager.MSG_TYPE_PLAYGROUP_JOIN)) {
                            fetchPlaygroupListAndShowPending(-1);
                            return;
                        }
                        return;
                    case 1020862470:
                        if (!str2.equals(PreferencesManager.MSG_TYPE_UNSHARE_COLLECTION_REJECTED)) {
                            return;
                        }
                        break;
                    case 1548370254:
                        if (!str2.equals(PreferencesManager.MSG_TYPE_SHARED_COLLECTION_ACCEPTED)) {
                            return;
                        }
                        break;
                    case 1586226284:
                        if (str2.equals(PreferencesManager.MSG_TYPE_FRIENDSHIP_ACCEPTED)) {
                            fetchFriendListAndShowPending(-1);
                            return;
                        }
                        return;
                    case 1964028755:
                        if (str2.equals(PreferencesManager.MSG_TYPE_PLAYGROUP_MESSAGE)) {
                            prefs.setBoolean(PreferencesManager.UPDATE_MESSAGES, true);
                            Object obj3 = map.get("playgroupId");
                            str = obj3 instanceof String ? (String) obj3 : null;
                            if (str == null || (intOrNull2 = StringsKt.toIntOrNull(str)) == null) {
                                return;
                            }
                            int iIntValue = intOrNull2.intValue();
                            Intent intent = new Intent(requireContext(), (Class<?>) PlaygroupDetailsActivity.class);
                            intent.putExtra("playgroupId", iIntValue);
                            this.playgroupActivityLauncher.launch(intent);
                            return;
                        }
                        return;
                    case 2035441181:
                        if (str2.equals(PreferencesManager.MSG_TYPE_PLAYGROUP_INVITE)) {
                            Object obj4 = map.get("playgroupId");
                            str = obj4 instanceof String ? (String) obj4 : null;
                            if (str == null || (intOrNull3 = StringsKt.toIntOrNull(str)) == null) {
                                return;
                            }
                            fetchPlaygroupListAndShowPending(intOrNull3.intValue());
                            return;
                        }
                        return;
                    default:
                        return;
                }
                startActivity(new Intent(requireContext(), (Class<?>) SharedCollectionsActivity.class));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processRecentCards(final MTCardContainer list) {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        PreferencesManager.INSTANCE.setRecentCardListId(list.getId());
        Integer count = list.getCount();
        if ((count != null ? count.intValue() : 0) > 0) {
            MTUser currentUser = preferencesManager.getCurrentUser();
            if (currentUser != null) {
                MTApi.getUserList$default(MTApiKt.getMtApi(), currentUser.getId(), list.getId(), null, null, null, null, null, null, null, null, null, null, null, 8188, null).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.HomeFragment$processRecentCards$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (!response.isSuccessful() || this.this$0.getContext() == null || this.this$0._binding == null) {
                            return;
                        }
                        MTCardListResponse mTCardListResponseBody = response.body();
                        MTCardContainer list2 = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                        if (list2 != null) {
                            PreferencesManager preferencesManager2 = preferencesManager;
                            HomeFragment homeFragment = this.this$0;
                            List<MTFullCard> cards = list2.getCards();
                            if (cards == null) {
                                cards = CollectionsKt.emptyList();
                            }
                            preferencesManager2.setRecentCardsNew(cards);
                            homeFragment.getBinding().recentRecyclerView.setLayoutManager(new LinearLayoutManager(homeFragment.getContext(), 0, false));
                            List<MTFullCard> cards2 = list2.getCards();
                            if (cards2 == null) {
                                cards2 = CollectionsKt.emptyList();
                            }
                            homeFragment.getBinding().recentRecyclerView.setAdapter(new NewRecentListAdapter(cards2, homeFragment));
                        }
                    }
                });
                return;
            }
            return;
        }
        List<MTFullCard> recentCardsNew = preferencesManager.getRecentCardsNew();
        MTUser currentUser2 = preferencesManager.getCurrentUser();
        if (currentUser2 == null || recentCardsNew.isEmpty()) {
            return;
        }
        MTApiKt.getMtApi().addCardsToList(currentUser2.getId(), list.getId(), null, null, null, null, null, null, new MTCardListBody(recentCardsNew)).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.HomeFragment$processRecentCards$2$1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (this.this$0.getContext() == null || this.this$0._binding == null || !response.isSuccessful()) {
                    return;
                }
                Context contextRequireContext2 = this.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                new PreferencesManager(contextRequireContext2).incrementContainerVersion(list.getId());
            }
        });
    }

    private final void processStoredFCMIntents(PreferencesManager prefs) {
        String string = prefs.getString(PreferencesManager.INTENT_TO_PROCESS, "");
        if (string.length() > 0) {
            Map map = (Map) new Gson().fromJson(string, new TypeToken<Map<String, ? extends Object>>() { // from class: com.studiolaganne.lengendarylens.HomeFragment$processStoredFCMIntents$dataMap$1
            }.getType());
            Object obj = map.get("type");
            Log.d("HomeFragment", "Intent message to process: " + (obj instanceof String ? (String) obj : null));
            Object obj2 = map.get("type");
            if (Intrinsics.areEqual(obj2 instanceof String ? (String) obj2 : null, PreferencesManager.MSG_TYPE_PLAYGROUP_MESSAGE)) {
                prefs.setBoolean(PreferencesManager.UPDATE_MESSAGES, true);
                Object obj3 = map.get("playgroupId");
                String str = obj3 instanceof String ? (String) obj3 : null;
                Integer intOrNull = str != null ? StringsKt.toIntOrNull(str) : null;
                if (intOrNull != null) {
                    int iIntValue = intOrNull.intValue();
                    Intent intent = new Intent(requireContext(), (Class<?>) PlaygroupDetailsActivity.class);
                    intent.putExtra("playgroupId", iIntValue);
                    this.playgroupActivityLauncher.launch(intent);
                }
            }
            prefs.setString(PreferencesManager.INTENT_TO_PROCESS, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void randomKeyword() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (Intrinsics.areEqual(new PreferencesManager(contextRequireContext).getDeviceLanguage(), "fr")) {
            GlossaryEntry glossaryEntry = (GlossaryEntry) CollectionsKt.randomOrNull(GlossaryManager.INSTANCE.getFrGlossaryEntries(), Random.INSTANCE);
            if (glossaryEntry == null) {
                getBinding().keywordContent.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda43
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.randomKeyword();
                    }
                }, 1000L);
                return;
            }
            getBinding().keywordTitle.setText(glossaryEntry.getKey());
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            SymbolToImage symbolToImage = new SymbolToImage(contextRequireContext2);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.symbol_oracle_size);
            String value = glossaryEntry.getValue();
            Context contextRequireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
            getBinding().keywordContent.setText(symbolToImage.stringToAttributedStringWithSymbolsAndLinks(value, dimensionPixelSize, contextRequireContext3, new Function1() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HomeFragment.randomKeyword$lambda$0$0(this.f$0, (String) obj);
                }
            }, new CharacterStyle[0]));
            getBinding().keywordContent.setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
        GlossaryEntry glossaryEntry2 = (GlossaryEntry) CollectionsKt.randomOrNull(GlossaryManager.INSTANCE.getEnGlossaryEntries(), Random.INSTANCE);
        if (glossaryEntry2 == null) {
            getBinding().keywordContent.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda46
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.randomKeyword();
                }
            }, 1000L);
            return;
        }
        getBinding().keywordTitle.setText(glossaryEntry2.getKey());
        Context contextRequireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
        SymbolToImage symbolToImage2 = new SymbolToImage(contextRequireContext4);
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context contextRequireContext5 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
        int iDpToPx = companion.dpToPx(16, contextRequireContext5);
        String value2 = glossaryEntry2.getValue();
        Context contextRequireContext6 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext6, "requireContext(...)");
        getBinding().keywordContent.setText(symbolToImage2.stringToAttributedStringWithSymbolsAndLinks(value2, iDpToPx, contextRequireContext6, new Function1() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda45
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HomeFragment.randomKeyword$lambda$2$0(this.f$0, (String) obj);
            }
        }, new CharacterStyle[0]));
        getBinding().keywordContent.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit randomKeyword$lambda$0$0(HomeFragment homeFragment, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (homeFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Intent intent = new Intent(homeFragment.requireContext(), (Class<?>) RulesActivity.class);
        intent.putExtra("section", it);
        homeFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit randomKeyword$lambda$2$0(HomeFragment homeFragment, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (homeFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Intent intent = new Intent(homeFragment.requireContext(), (Class<?>) RulesActivity.class);
        intent.putExtra("section", it);
        homeFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshFormats() {
        MTUser currentUser;
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (preferencesManager.hasValidUser() && (currentUser = preferencesManager.getCurrentUser()) != null) {
            MTApiKt.getMtApi().getFormats(currentUser.getId()).enqueue(new Callback<MTFormatsResponse>() { // from class: com.studiolaganne.lengendarylens.HomeFragment$refreshFormats$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTFormatsResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTFormatsResponse> call, Response<MTFormatsResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (!response.isSuccessful() || this.this$0.getContext() == null) {
                        return;
                    }
                    MTFormatsResponse mTFormatsResponseBody = response.body();
                    List<MTFormat> formats = mTFormatsResponseBody != null ? mTFormatsResponseBody.getFormats() : null;
                    if (formats != null) {
                        HomeFragment homeFragment = this.this$0;
                        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
                        Context contextRequireContext2 = homeFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        DecksDBHelper companion2 = companion.getInstance(contextRequireContext2);
                        companion2.clearFormats();
                        companion2.clearSubformats();
                        companion2.addFormats(formats);
                        for (MTFormat mTFormat : formats) {
                            List<MTSubformat> subformats = mTFormat.getSubformats();
                            if (subformats != null) {
                                Iterator<MTSubformat> it = subformats.iterator();
                                while (it.hasNext()) {
                                    companion2.addSubformat(it.next(), mTFormat);
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    static final void requestCameraPermissionLauncher$lambda$0(HomeFragment homeFragment, boolean z) {
        if (homeFragment.getContext() == null || homeFragment._binding == null || homeFragment.getChildFragmentManager().isStateSaved()) {
            return;
        }
        Context contextRequireContext = homeFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        preferencesManager.setBoolean(PreferencesManager.CAMERA_PERMISSION_ASKED_BEFORE, true);
        if (!z) {
            Toast.makeText(homeFragment.requireContext(), homeFragment.getString(R.string.camera_permission_denied_friend), 1).show();
            return;
        }
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (!preferencesManager.hasValidUser() || currentUser == null) {
            return;
        }
        QRScanBottomSheetFragment.Companion.newInstance$default(QRScanBottomSheetFragment.INSTANCE, homeFragment, currentUser, false, 4, null).show(homeFragment.getChildFragmentManager(), QRScanBottomSheetFragment.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestNotificationPermission() {
        if (getActivity() == null || Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(requireActivity(), "android.permission.POST_NOTIFICATIONS") == 0) {
            return;
        }
        showRationaleDialog();
    }

    static final void requestNotificationPermissionLauncher$lambda$0(boolean z) {
    }

    static final void searchActivityLauncher$lambda$0(HomeFragment homeFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (homeFragment.getChildFragmentManager().isStateSaved()) {
            return;
        }
        Intent data = result.getData();
        String stringExtra = data != null ? data.getStringExtra("cardPicked") : null;
        Intent data2 = result.getData();
        int intExtra = data2 != null ? data2.getIntExtra(OptionalModuleUtils.FACE, 0) : 0;
        if (stringExtra != null) {
            MTFullCard mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class);
            Fragment fragmentFindFragmentByTag = homeFragment.getChildFragmentManager().findFragmentByTag(CreateDeckBottomSheetFragment.TAG);
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment = fragmentFindFragmentByTag instanceof CreateDeckBottomSheetFragment ? (CreateDeckBottomSheetFragment) fragmentFindFragmentByTag : null;
            if (createDeckBottomSheetFragment != null) {
                Intrinsics.checkNotNull(mTFullCard);
                createDeckBottomSheetFragment.updateCardId(mTFullCard, intExtra);
            }
        }
    }

    private final void setupHorizontalScrollDetection(RecyclerView recyclerView) {
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() { // from class: com.studiolaganne.lengendarylens.HomeFragment.setupHorizontalScrollDetection.1
            private float startX;
            private float startY;

            /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                Intrinsics.checkNotNullParameter(rv, "rv");
                Intrinsics.checkNotNullParameter(e, "e");
                int action = e.getAction();
                if (action == 0) {
                    this.startX = e.getX();
                    this.startY = e.getY();
                    HomeFragment.this.getBinding().swipeRefreshLayout.setEnabled(true);
                } else if (action == 1) {
                    HomeFragment.this.getBinding().swipeRefreshLayout.setEnabled(true);
                } else if (action == 2) {
                    float fAbs = Math.abs(e.getX() - this.startX);
                    if (fAbs > Math.abs(e.getY() - this.startY) && fAbs > 10.0f) {
                        HomeFragment.this.getBinding().swipeRefreshLayout.setEnabled(false);
                    }
                } else if (action == 3) {
                }
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                Intrinsics.checkNotNullParameter(rv, "rv");
                Intrinsics.checkNotNullParameter(e, "e");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEventBanner(final MTCommunityEvent event) {
        List<MTChallenge> challenges;
        if (getContext() == null || this._binding == null) {
            return;
        }
        if (event.getTrivia() == null && event.getChallenges() == null) {
            return;
        }
        List<MTTrivia> trivia = event.getTrivia();
        if (trivia == null || !trivia.isEmpty() || (challenges = event.getChallenges()) == null || !challenges.isEmpty()) {
            getBinding().eventBannerLayout.setVisibility(0);
            getBinding().eventNameTextView.setText(event.getName());
            getBinding().eventDescriptionTextView.setText(event.getDescription());
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            String deviceLanguage = new PreferencesManager(contextRequireContext).getDeviceLanguage();
            for (MTEntryLocalization mTEntryLocalization : event.getLocalization()) {
                String lowerCase = mTEntryLocalization.getLocale().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = deviceLanguage.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                    getBinding().eventNameTextView.setText(mTEntryLocalization.getName());
                    getBinding().eventDescriptionTextView.setText(mTEntryLocalization.getDescription());
                }
            }
            String logo_url = event.getLogo_url();
            if (logo_url != null && logo_url.length() > 0) {
                Glide.with(requireContext()).load(logo_url).placeholder(R.drawable.medal_outline).into(getBinding().eventImage);
            }
            ConstraintLayout eventBannerLayout = getBinding().eventBannerLayout;
            Intrinsics.checkNotNullExpressionValue(eventBannerLayout, "eventBannerLayout");
            ViewExtensionsKt.setOnClickWithFade(eventBannerLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HomeFragment.showEventBanner$lambda$1(this.f$0, event);
                }
            });
        }
    }

    static final Unit showEventBanner$lambda$1(HomeFragment homeFragment, MTCommunityEvent mTCommunityEvent) {
        Intent intent = new Intent(homeFragment.requireContext(), (Class<?>) CommunityEventActivity.class);
        intent.putExtra("eventId", mTCommunityEvent.getId());
        homeFragment.eventActivityLauncher.launch(intent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showOnboardingDialog(MTOnboarding onboarding) {
        if (getContext() == null || getChildFragmentManager().isStateSaved()) {
            return;
        }
        OnboardingDialogFragment.INSTANCE.newInstance(onboarding.getPages()).show(getChildFragmentManager(), "OnboardingDialog");
        FirebaseAnalytics.getInstance(requireContext()).logEvent("new_version_onboarding_logged", null);
    }

    private final void showRationaleDialog() {
        if (getContext() == null) {
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.permissions_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.notification_permission_rationale);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HomeFragment.showRationaleDialog$lambda$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HomeFragment.showRationaleDialog$lambda$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "notification_permission_dialog");
    }

    static final Unit showRationaleDialog$lambda$0(HomeFragment homeFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        homeFragment.requestNotificationPermissionLauncher.launch("android.permission.POST_NOTIFICATIONS");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit showRationaleDialog$lambda$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object syncSharedCollectionBadge(int i, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C11772(i, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateCollection(int i, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C11782(i, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDecks(MTUser user, List<MTDeck> decks) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : decks) {
            if (((MTDeck) obj).getType() == 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (getContext() == null) {
            return;
        }
        if (decks.isEmpty()) {
            getBinding().noDecksLayout.setVisibility(0);
            getBinding().emptyDecksLabel.setText(getString(R.string.no_deck));
            getBinding().decksRecyclerView.setVisibility(8);
            getBinding().allDecksLayout.setVisibility(0);
            return;
        }
        if (arrayList2.isEmpty()) {
            getBinding().noDecksLayout.setVisibility(0);
            getBinding().emptyDecksLabel.setText(getString(R.string.no_constructed_deck));
            getBinding().decksRecyclerView.setVisibility(8);
            getBinding().allDecksLayout.setVisibility(0);
            return;
        }
        getBinding().noDecksLayout.setVisibility(8);
        getBinding().decksRecyclerView.setVisibility(0);
        getBinding().decksRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        List<MTFormat> formats = companion.getInstance(contextRequireContext).getFormats();
        MTGDBHelper.Companion companion2 = MTGDBHelper.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        MTGDBHelper companion3 = companion2.getInstance(contextRequireContext2);
        ArrayList arrayList3 = new ArrayList();
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        for (String str : new PreferencesManager(contextRequireContext3).getEnabledLanguages()) {
            if (!Intrinsics.areEqual(str, "en")) {
                MTGDBHelperLocalized.Companion companion4 = MTGDBHelperLocalized.INSTANCE;
                Context contextRequireContext4 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                arrayList3.add(companion4.getInstance(contextRequireContext4, str));
            }
        }
        getBinding().decksRecyclerView.setAdapter(new DecksAdapter(arrayList2, formats, companion3, arrayList3, this));
        if (decks.isEmpty()) {
            getBinding().allDecksLayout.setVisibility(8);
        } else {
            getBinding().allDecksLayout.setVisibility(0);
        }
    }

    private final void updateEmailBanner() {
        if (getContext() == null) {
            return;
        }
        getBinding().emailBannerLayout.setVisibility(8);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (preferencesManager.getCurrentUser() == null) {
            return;
        }
        boolean z = preferencesManager.getBoolean(PreferencesManager.RATING_BANNER_DISMISSED, false);
        boolean z2 = preferencesManager.getBoolean(PreferencesManager.EMAIL_BANNER_DISMISSED, false);
        boolean zIsSecondRun = preferencesManager.isSecondRun();
        if (z && zIsSecondRun && !z2) {
            getBinding().emailBannerLayout.setVisibility(0);
            ImageView emailBannerCloseImage = getBinding().emailBannerCloseImage;
            Intrinsics.checkNotNullExpressionValue(emailBannerCloseImage, "emailBannerCloseImage");
            ViewExtensionsKt.setOnClickWithFade(emailBannerCloseImage, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda48
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HomeFragment.updateEmailBanner$lambda$0(preferencesManager, this);
                }
            });
            ConstraintLayout emailBannerLayout = getBinding().emailBannerLayout;
            Intrinsics.checkNotNullExpressionValue(emailBannerLayout, "emailBannerLayout");
            ViewExtensionsKt.setOnClickWithFade(emailBannerLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda49
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HomeFragment.updateEmailBanner$lambda$1(this.f$0, preferencesManager);
                }
            });
        }
    }

    static final Unit updateEmailBanner$lambda$0(PreferencesManager preferencesManager, HomeFragment homeFragment) {
        preferencesManager.setBoolean(PreferencesManager.EMAIL_BANNER_DISMISSED, true);
        homeFragment.getBinding().emailBannerLayout.setVisibility(8);
        return Unit.INSTANCE;
    }

    static final Unit updateEmailBanner$lambda$1(final HomeFragment homeFragment, final PreferencesManager preferencesManager) {
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(homeFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("android_email_opt_in", null);
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = homeFragment.getString(R.string.opt_in_dialog_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = homeFragment.getString(R.string.opt_in_dialog_text);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = homeFragment.getString(R.string.yes);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HomeFragment.updateEmailBanner$lambda$1$0(this.f$0, preferencesManager, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = homeFragment.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HomeFragment.updateEmailBanner$lambda$1$1(this.f$0, (CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = homeFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "opt_in_dialog");
        preferencesManager.setBoolean(PreferencesManager.EMAIL_BANNER_DISMISSED, true);
        homeFragment.getBinding().emailBannerLayout.setVisibility(8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateEmailBanner$lambda$1$0(HomeFragment homeFragment, PreferencesManager preferencesManager, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            CustomerIOHelper.INSTANCE.identifyOptedInUser(currentUser, preferencesManager);
        } else {
            preferencesManager.setBoolean(PreferencesManager.EMAIL_OPT_IN, true);
        }
        Toast.makeText(homeFragment.requireContext(), R.string.thank_you_email, 0);
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateEmailBanner$lambda$1$1(HomeFragment homeFragment, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateFormats(int i, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C11792(i, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFriends(MTUser user, List<MTFriend> friends) {
        FriendsAdapter friendsAdapter = new FriendsAdapter(CollectionsKt.sortedWith(friends, new Comparator() { // from class: com.studiolaganne.lengendarylens.HomeFragment$updateFriends$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((MTFriend) t2).getStatus(), ((MTFriend) t).getStatus());
            }
        }), this);
        getBinding().friendsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        getBinding().friendsRecyclerView.setAdapter(friendsAdapter);
        if (friends.isEmpty()) {
            getBinding().allFriendsLayout.setVisibility(8);
        } else {
            getBinding().allFriendsLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateLists(int i, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C11802(i, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMythicPlusBanner() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (preferencesManager.getCurrentUser() == null) {
            getBinding().mythicPlusBannerLayout.setVisibility(8);
            return;
        }
        MythicPlusManager mythicPlusManager = MythicPlusManager.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        if (mythicPlusManager.isActive(contextRequireContext2)) {
            getBinding().mythicPlusBannerLayout.setVisibility(8);
            return;
        }
        if (preferencesManager.isMythicPlusBannerDismissed()) {
            getBinding().mythicPlusBannerLayout.setVisibility(8);
            return;
        }
        getBinding().mythicPlusBannerLayout.setVisibility(0);
        ImageView mythicPlusBannerCloseImage = getBinding().mythicPlusBannerCloseImage;
        Intrinsics.checkNotNullExpressionValue(mythicPlusBannerCloseImage, "mythicPlusBannerCloseImage");
        ViewExtensionsKt.setOnClickWithFade(mythicPlusBannerCloseImage, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.updateMythicPlusBanner$lambda$0(this.f$0, preferencesManager);
            }
        });
        final Function0 function0 = new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.updateMythicPlusBanner$lambda$1(this.f$0);
            }
        };
        final Function0 function02 = new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.updateMythicPlusBanner$lambda$2(this.f$0, function0);
            }
        };
        ConstraintLayout mythicPlusBannerCtaLayout = getBinding().mythicPlusBannerCtaLayout;
        Intrinsics.checkNotNullExpressionValue(mythicPlusBannerCtaLayout, "mythicPlusBannerCtaLayout");
        ViewExtensionsKt.setOnClickWithFade(mythicPlusBannerCtaLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.updateMythicPlusBanner$lambda$3(function02);
            }
        });
        ConstraintLayout mythicPlusBannerLayout = getBinding().mythicPlusBannerLayout;
        Intrinsics.checkNotNullExpressionValue(mythicPlusBannerLayout, "mythicPlusBannerLayout");
        ViewExtensionsKt.setOnClickWithFade(mythicPlusBannerLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.updateMythicPlusBanner$lambda$4(function02);
            }
        });
    }

    static final Unit updateMythicPlusBanner$lambda$0(final HomeFragment homeFragment, PreferencesManager preferencesManager) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        preferencesManager.setMythicPlusBannerDismissed(true);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(homeFragment.getBinding().mythicPlusBannerLayout.getMeasuredHeight(), 0);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda26
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeFragment.updateMythicPlusBanner$lambda$0$0(this.f$0, valueAnimator);
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.studiolaganne.lengendarylens.HomeFragment$updateMythicPlusBanner$1$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (this.this$0._binding == null) {
                    return;
                }
                this.this$0.getBinding().mythicPlusBannerLayout.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = this.this$0.getBinding().mythicPlusBannerLayout.getLayoutParams();
                layoutParams.height = -2;
                this.this$0.getBinding().mythicPlusBannerLayout.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.start();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateMythicPlusBanner$lambda$0$0(HomeFragment homeFragment, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = homeFragment.getBinding().mythicPlusBannerLayout.getLayoutParams();
        layoutParams.height = iIntValue;
        homeFragment.getBinding().mythicPlusBannerLayout.setLayoutParams(layoutParams);
    }

    static final Unit updateMythicPlusBanner$lambda$1(final HomeFragment homeFragment) {
        if (homeFragment.getContext() != null) {
            FirebaseAnalytics.getInstance(homeFragment.requireContext()).logEvent("subscription_paywall_show", null);
            Purchases.INSTANCE.getSharedInstance().getOfferings(new ReceiveOfferingsCallback() { // from class: com.studiolaganne.lengendarylens.HomeFragment$updateMythicPlusBanner$launchPaywall$1$1
                @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
                public void onError(PurchasesError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    if (this.this$0.getContext() == null) {
                        return;
                    }
                    Toast.makeText(this.this$0.requireContext(), R.string.error_paywall, 1).show();
                }

                @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
                public void onReceived(Offerings offerings) {
                    Intrinsics.checkNotNullParameter(offerings, "offerings");
                    Offering current = offerings.getCurrent();
                    if (current != null) {
                        PaywallActivityLauncher.launch$default(this.this$0.paywallActivityLauncher, current, null, false, false, MapsKt.mapOf(TuplesKt.to("carousel", new CustomVariableValue.String("default"))), 14, null);
                    }
                }
            });
        }
        return Unit.INSTANCE;
    }

    static final Unit updateMythicPlusBanner$lambda$2(HomeFragment homeFragment, final Function0 function0) {
        FragmentActivity activity = homeFragment.getActivity();
        if (activity != null) {
            MythicPlusInfoDialogFragment.Companion.show$default(MythicPlusInfoDialogFragment.INSTANCE, activity, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda50
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HomeFragment.updateMythicPlusBanner$lambda$2$0(function0);
                }
            }, null, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateMythicPlusBanner$lambda$2$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit updateMythicPlusBanner$lambda$3(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit updateMythicPlusBanner$lambda$4(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePlaygroups(MTUser user, List<MTPlaygroup> playgroups) {
        if (getContext() == null) {
            return;
        }
        if (playgroups.isEmpty()) {
            getBinding().noPlaygroupsLayout.setVisibility(0);
            getBinding().playgroupsRecyclerView.setVisibility(8);
            getBinding().allPlaygroupsLayout.setVisibility(8);
            return;
        }
        getBinding().noPlaygroupsLayout.setVisibility(8);
        getBinding().playgroupsRecyclerView.setVisibility(0);
        getBinding().playgroupsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        MessagesDBHelper.Companion companion = MessagesDBHelper.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MessagesDBHelper companion2 = companion.getInstance(contextRequireContext);
        for (MTPlaygroup mTPlaygroup : playgroups) {
            mTPlaygroup.setUnreadCount(companion2.getUnreadMessagesCountForPlaygroup(mTPlaygroup.getId()));
        }
        final Comparator comparator = new Comparator() { // from class: com.studiolaganne.lengendarylens.HomeFragment$updatePlaygroups$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((MTPlaygroup) t2).getStatus(), ((MTPlaygroup) t).getStatus());
            }
        };
        getBinding().playgroupsRecyclerView.setAdapter(new PlaygroupsAdapter(CollectionsKt.sortedWith(playgroups, new Comparator() { // from class: com.studiolaganne.lengendarylens.HomeFragment$updatePlaygroups$$inlined$thenByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(Integer.valueOf(((MTPlaygroup) t2).getUnreadCount()), Integer.valueOf(((MTPlaygroup) t).getUnreadCount()));
            }
        }), this));
        if (playgroups.isEmpty()) {
            getBinding().allPlaygroupsLayout.setVisibility(8);
        } else {
            getBinding().allPlaygroupsLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateProfile(MTUser user) {
        String picture = user.getPicture();
        getBinding().noProfileIcon.setVisibility(4);
        String str = picture;
        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            getBinding().noPhotoIcon.setVisibility(0);
            getBinding().profileMythicBorder.setVisibility(8);
            getBinding().profileMythicBorder.stopAnimation();
            return;
        }
        getBinding().profileIcon.setVisibility(0);
        getBinding().profileIcon.setAutoLoad(false);
        getBinding().profileIcon.reset();
        getBinding().profileIcon.loadImage(picture);
        MythicPlusManager mythicPlusManager = MythicPlusManager.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (!mythicPlusManager.isActive(contextRequireContext)) {
            getBinding().profileMythicBorder.setVisibility(8);
            getBinding().profileMythicBorder.stopAnimation();
        } else {
            getBinding().profileMythicBorder.setVisibility(0);
            getBinding().profileMythicBorder.setPulseEnabled(true);
            getBinding().profileMythicBorder.setHighlightEnabled(true);
            getBinding().profileMythicBorder.startAnimation();
        }
    }

    private final void updateRatingBanner() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        boolean z = preferencesManager.getBoolean(PreferencesManager.RATING_BANNER_DISMISSED, false);
        boolean zIsSecondRun = preferencesManager.isSecondRun();
        if (z || !zIsSecondRun) {
            getBinding().ratingBannerLayout.setVisibility(8);
            return;
        }
        getBinding().ratingBannerLayout.setVisibility(0);
        ImageView ratingBannerCloseImage = getBinding().ratingBannerCloseImage;
        Intrinsics.checkNotNullExpressionValue(ratingBannerCloseImage, "ratingBannerCloseImage");
        ViewExtensionsKt.setOnClickWithFade(ratingBannerCloseImage, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.updateRatingBanner$lambda$0(preferencesManager, this);
            }
        });
        ConstraintLayout ratingBannerLayout = getBinding().ratingBannerLayout;
        Intrinsics.checkNotNullExpressionValue(ratingBannerLayout, "ratingBannerLayout");
        ViewExtensionsKt.setOnClickWithFade(ratingBannerLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.updateRatingBanner$lambda$1(this.f$0, preferencesManager);
            }
        });
    }

    static final Unit updateRatingBanner$lambda$0(PreferencesManager preferencesManager, HomeFragment homeFragment) {
        preferencesManager.setBoolean(PreferencesManager.RATING_BANNER_DISMISSED, true);
        homeFragment.getBinding().ratingBannerLayout.setVisibility(8);
        return Unit.INSTANCE;
    }

    static final Unit updateRatingBanner$lambda$1(HomeFragment homeFragment, PreferencesManager preferencesManager) {
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(homeFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("android_review_from_home_banner", null);
        String packageName = homeFragment.requireContext().getPackageName();
        try {
            homeFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException unused) {
            homeFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
        preferencesManager.setBoolean(PreferencesManager.RATING_BANNER_DISMISSED, true);
        homeFragment.getBinding().ratingBannerLayout.setVisibility(8);
        return Unit.INSTANCE;
    }

    private final void updateRecentCardsUI(PreferencesManager prefs) {
        List<MTFullCard> recentCardsNew = prefs.getRecentCardsNew();
        getBinding().recentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        getBinding().recentRecyclerView.setAdapter(new NewRecentListAdapter(recentCardsNew, this));
    }

    private final void updateStoreBanner() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext);
        getBinding().storeBannerLayout.setVisibility(8);
    }

    private static final Unit updateStoreBanner$lambda$1(HomeFragment homeFragment) {
        if (homeFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(homeFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("store_open", null);
        homeFragment.startActivity(new Intent(homeFragment.requireContext(), (Class<?>) StoreActivity.class));
        return Unit.INSTANCE;
    }

    private static final Unit updateStoreBanner$lambda$2(PreferencesManager preferencesManager, ObjectAnimator objectAnimator, final HomeFragment homeFragment) {
        preferencesManager.setBoolean(PreferencesManager.STORE_BANNER_DISMISSED, true);
        PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
        objectAnimator.cancel();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(homeFragment.getBinding().storeBannerLayout.getMeasuredHeight(), 0);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda16
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeFragment.updateStoreBanner$lambda$2$0(this.f$0, valueAnimator);
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.studiolaganne.lengendarylens.HomeFragment$updateStoreBanner$2$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.getBinding().storeBannerLayout.setVisibility(8);
            }
        });
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.start();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateStoreBanner$lambda$2$0(HomeFragment homeFragment, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = homeFragment.getBinding().storeBannerLayout.getLayoutParams();
        layoutParams.height = iIntValue;
        homeFragment.getBinding().storeBannerLayout.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02bb, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r0, r3, r15) != r4) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0307, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r0, r3, r15) != r4) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0356, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r3, r6, r15) == r4) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0149, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r2, r5, r3) == r4) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x021d, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r6, r9, r15) == r4) goto L133;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cf A[PHI: r0 r3 r5 r11 r13 r14 r15
      0x00cf: PHI (r0v32 java.lang.Object) = (r0v28 java.lang.Object), (r0v43 java.lang.Object) binds: [B:77:0x01c4, B:28:0x00cc] A[DONT_GENERATE, DONT_INLINE]
      0x00cf: PHI (r3v16 boolean) = (r3v14 boolean), (r3v17 boolean) binds: [B:77:0x01c4, B:28:0x00cc] A[DONT_GENERATE, DONT_INLINE]
      0x00cf: PHI (r5v15 int) = (r5v12 int), (r5v16 int) binds: [B:77:0x01c4, B:28:0x00cc] A[DONT_GENERATE, DONT_INLINE]
      0x00cf: PHI (r11v9 long) = (r11v6 long), (r11v10 long) binds: [B:77:0x01c4, B:28:0x00cc] A[DONT_GENERATE, DONT_INLINE]
      0x00cf: PHI (r13v12 com.studiolaganne.lengendarylens.MTUser) = (r13v6 com.studiolaganne.lengendarylens.MTUser), (r13v15 com.studiolaganne.lengendarylens.MTUser) binds: [B:77:0x01c4, B:28:0x00cc] A[DONT_GENERATE, DONT_INLINE]
      0x00cf: PHI (r14v5 com.studiolaganne.lengendarylens.PreferencesManager) = 
      (r14v1 com.studiolaganne.lengendarylens.PreferencesManager)
      (r14v7 com.studiolaganne.lengendarylens.PreferencesManager)
     binds: [B:77:0x01c4, B:28:0x00cc] A[DONT_GENERATE, DONT_INLINE]
      0x00cf: PHI (r15v15 com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$1) = 
      (r15v12 com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$1)
      (r15v18 com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$1)
     binds: [B:77:0x01c4, B:28:0x00cc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a8 A[PHI: r0 r3 r11 r13 r14 r15
      0x01a8: PHI (r0v24 boolean) = (r0v0 boolean), (r0v0 boolean), (r0v30 boolean) binds: [B:71:0x0182, B:73:0x01a4, B:35:0x00e2] A[DONT_GENERATE, DONT_INLINE]
      0x01a8: PHI (r3v13 int) = (r3v11 int), (r3v11 int), (r3v15 int) binds: [B:71:0x0182, B:73:0x01a4, B:35:0x00e2] A[DONT_GENERATE, DONT_INLINE]
      0x01a8: PHI (r11v6 long) = (r11v5 long), (r11v5 long), (r11v7 long) binds: [B:71:0x0182, B:73:0x01a4, B:35:0x00e2] A[DONT_GENERATE, DONT_INLINE]
      0x01a8: PHI (r13v6 com.studiolaganne.lengendarylens.MTUser) = 
      (r13v5 com.studiolaganne.lengendarylens.MTUser)
      (r13v5 com.studiolaganne.lengendarylens.MTUser)
      (r13v9 com.studiolaganne.lengendarylens.MTUser)
     binds: [B:71:0x0182, B:73:0x01a4, B:35:0x00e2] A[DONT_GENERATE, DONT_INLINE]
      0x01a8: PHI (r14v1 com.studiolaganne.lengendarylens.PreferencesManager) = 
      (r14v0 com.studiolaganne.lengendarylens.PreferencesManager)
      (r14v0 com.studiolaganne.lengendarylens.PreferencesManager)
      (r14v3 com.studiolaganne.lengendarylens.PreferencesManager)
     binds: [B:71:0x0182, B:73:0x01a4, B:35:0x00e2] A[DONT_GENERATE, DONT_INLINE]
      0x01a8: PHI (r15v12 com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$1) = 
      (r15v10 com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$1)
      (r15v10 com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$1)
      (r15v13 com.studiolaganne.lengendarylens.HomeFragment$updateUserDataWithTokenValidation$1)
     binds: [B:71:0x0182, B:73:0x01a4, B:35:0x00e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d9 A[Catch: all -> 0x02c3, Exception -> 0x02c6, TryCatch #8 {Exception -> 0x02c6, all -> 0x02c3, blocks: (B:79:0x01c8, B:81:0x01cf, B:98:0x025b, B:85:0x01d9, B:87:0x01e9, B:89:0x01f0), top: B:142:0x01c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e9 A[Catch: all -> 0x02c3, Exception -> 0x02c6, TryCatch #8 {Exception -> 0x02c6, all -> 0x02c3, blocks: (B:79:0x01c8, B:81:0x01cf, B:98:0x025b, B:85:0x01d9, B:87:0x01e9, B:89:0x01f0), top: B:142:0x01c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x025a A[RETURN] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.studiolaganne.lengendarylens.HomeFragment] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.studiolaganne.lengendarylens.HomeFragment] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.studiolaganne.lengendarylens.HomeFragment] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [com.studiolaganne.lengendarylens.MTUser, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateUserDataWithTokenValidation(boolean z, Continuation<? super Unit> continuation) throws Throwable {
        C11811 c11811;
        C11811 c118112;
        boolean z2;
        PreferencesManager preferencesManager;
        long jCurrentTimeMillis;
        ?? r8;
        ?? r6;
        ?? r1;
        MainCoroutineDispatcher main;
        AnonymousClass7 anonymousClass7;
        PreferencesManager preferencesManager2;
        MTUser currentUser;
        int i;
        boolean z3;
        Object objEnsureFreshToken;
        String str;
        String str2;
        boolean z4;
        boolean z5;
        ?? r82;
        Object objWithContext;
        ?? r83;
        ?? r12 = this;
        boolean z6 = z;
        if (continuation instanceof C11811) {
            c11811 = (C11811) continuation;
            if ((c11811.label & Integer.MIN_VALUE) != 0) {
                c11811.label -= Integer.MIN_VALUE;
            } else {
                c11811 = new C11811(continuation);
            }
        }
        Object obj = c11811.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c11811.label;
        ?? r62 = PreferencesManager.NEED_USER_RELOAD;
        ?? r7 = "HomeFragment";
        ?? r84 = "requireContext(...)";
        try {
            try {
                try {
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            c118112 = c11811;
        } catch (Throwable th2) {
            th = th2;
            c118112 = c11811;
            z2 = false;
            r1 = r12;
            r6 = r62;
            r8 = r84;
        }
        switch (i2) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (r12.getContext() == null || r12.isUpdatingUserData) {
                    C11811 c118113 = c11811;
                    if (z6) {
                        MainCoroutineDispatcher main2 = Dispatchers.getMain();
                        C11822 c11822 = new C11822(null);
                        c118113.Z$0 = z6;
                        c118113.label = 1;
                        break;
                    }
                    return Unit.INSTANCE;
                }
                Context contextRequireContext = r12.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                preferencesManager2 = new PreferencesManager(contextRequireContext);
                if (!preferencesManager2.hasValidUser()) {
                    if (z6) {
                        MainCoroutineDispatcher main3 = Dispatchers.getMain();
                        AnonymousClass3 anonymousClass3 = new AnonymousClass3(null);
                        c11811.L$0 = SpillingKt.nullOutSpilledVariable(preferencesManager2);
                        c11811.Z$0 = z6;
                        c11811.label = 2;
                        break;
                    }
                    return Unit.INSTANCE;
                }
                currentUser = preferencesManager2.getCurrentUser();
                if (currentUser == null) {
                    return Unit.INSTANCE;
                }
                jCurrentTimeMillis = System.currentTimeMillis();
                if (z6 || preferencesManager2.getBoolean(PreferencesManager.NEED_USER_RELOAD, false) || preferencesManager2.getForcedApiUpdate()) {
                    c118112 = c11811;
                } else {
                    c118112 = c11811;
                    if (jCurrentTimeMillis - r12.lastSuccessfulUpdate <= r12.UPDATE_INTERVAL) {
                        i = 0;
                    }
                    if (i != 0) {
                        return Unit.INSTANCE;
                    }
                    r12.isUpdatingUserData = true;
                    if (z6) {
                        MainCoroutineDispatcher main4 = Dispatchers.getMain();
                        AnonymousClass4 anonymousClass4 = new AnonymousClass4(null);
                        c118112.L$0 = preferencesManager2;
                        c118112.L$1 = currentUser;
                        c118112.Z$0 = z6;
                        c118112.J$0 = jCurrentTimeMillis;
                        c118112.I$0 = i;
                        c118112.label = 3;
                        if (BuildersKt.withContext(main4, anonymousClass4, c118112) != coroutine_suspended) {
                            i2 = i;
                            z3 = z6;
                            try {
                                FirebaseTokenManager firebaseTokenManager = FirebaseTokenManager.INSTANCE;
                                Context contextRequireContext2 = r12.requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                                c118112.L$0 = preferencesManager2;
                                c118112.L$1 = currentUser;
                                c118112.Z$0 = z3;
                                c118112.J$0 = jCurrentTimeMillis;
                                c118112.I$0 = i2;
                                c118112.label = 4;
                                objEnsureFreshToken = firebaseTokenManager.ensureFreshToken(contextRequireContext2, c118112);
                                if (objEnsureFreshToken != coroutine_suspended) {
                                    r84 = currentUser;
                                    preferencesManager = preferencesManager2;
                                    try {
                                        str = (String) objEnsureFreshToken;
                                        str2 = str;
                                        if (str2 != null || str2.length() == 0) {
                                            if (!Intrinsics.areEqual(preferencesManager.getString(PreferencesManager.AUTH_PROVIDER, ""), FirebaseAuthProvider.PROVIDER_ID)) {
                                                Log.w("HomeFragment", "Failed to refresh Firebase token, skipping API calls");
                                                if (z3) {
                                                    MainCoroutineDispatcher main5 = Dispatchers.getMain();
                                                    AnonymousClass5 anonymousClass5 = new AnonymousClass5(null);
                                                    c118112.L$0 = SpillingKt.nullOutSpilledVariable(preferencesManager);
                                                    c118112.L$1 = SpillingKt.nullOutSpilledVariable(r84);
                                                    c118112.L$2 = SpillingKt.nullOutSpilledVariable(str);
                                                    c118112.Z$0 = z3;
                                                    c118112.J$0 = jCurrentTimeMillis;
                                                    c118112.I$0 = i2;
                                                    c118112.label = 5;
                                                }
                                                z4 = z3;
                                                r82 = r84;
                                                Unit unit = Unit.INSTANCE;
                                                r12.isUpdatingUserData = false;
                                                MainCoroutineDispatcher main6 = Dispatchers.getMain();
                                                AnonymousClass7 anonymousClass72 = new AnonymousClass7(null);
                                                c118112.L$0 = SpillingKt.nullOutSpilledVariable(preferencesManager);
                                                Object objNullOutSpilledVariable = SpillingKt.nullOutSpilledVariable(r82);
                                                c118112.L$1 = objNullOutSpilledVariable;
                                                c118112.L$2 = SpillingKt.nullOutSpilledVariable(str);
                                                c118112.L$3 = unit;
                                                c118112.Z$0 = z4;
                                                c118112.J$0 = jCurrentTimeMillis;
                                                c118112.I$0 = i2;
                                                c118112.label = 6;
                                                objWithContext = BuildersKt.withContext(main6, anonymousClass72, c118112);
                                                r12 = objNullOutSpilledVariable;
                                                r62 = z4;
                                                r7 = main6;
                                                r84 = r82;
                                                if (objWithContext != coroutine_suspended) {
                                                    return unit;
                                                }
                                            } else {
                                                preferencesManager.setForcedApiUpdate(false);
                                                preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, false);
                                                AnonymousClass6 anonymousClass6 = new AnonymousClass6(r84, null);
                                                c118112.L$0 = preferencesManager;
                                                c118112.L$1 = SpillingKt.nullOutSpilledVariable(r84);
                                                c118112.L$2 = SpillingKt.nullOutSpilledVariable(str);
                                                c118112.Z$0 = z3;
                                                c118112.J$0 = jCurrentTimeMillis;
                                                c118112.I$0 = i2;
                                                c118112.label = 7;
                                                if (CoroutineScopeKt.coroutineScope(anonymousClass6, c118112) != coroutine_suspended) {
                                                    z5 = z3;
                                                    r83 = r84;
                                                    r12.lastSuccessfulUpdate = jCurrentTimeMillis;
                                                    preferencesManager.setLastApiUpdate(jCurrentTimeMillis);
                                                    r7 = 0;
                                                    r12.isUpdatingUserData = false;
                                                    MainCoroutineDispatcher main7 = Dispatchers.getMain();
                                                    AnonymousClass7 anonymousClass73 = new AnonymousClass7(null);
                                                    c118112.L$0 = SpillingKt.nullOutSpilledVariable(preferencesManager);
                                                    c118112.L$1 = SpillingKt.nullOutSpilledVariable(r83);
                                                    c118112.L$2 = null;
                                                    c118112.Z$0 = z5;
                                                    c118112.J$0 = jCurrentTimeMillis;
                                                    c118112.I$0 = i2;
                                                    r12 = 8;
                                                    c118112.label = 8;
                                                    r62 = z5;
                                                    r84 = r83;
                                                }
                                            }
                                            break;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        r62 = z3;
                                        Log.e(r7, "Error updating user data", e);
                                        r12.isUpdatingUserData = false;
                                        MainCoroutineDispatcher main8 = Dispatchers.getMain();
                                        AnonymousClass7 anonymousClass74 = new AnonymousClass7(null);
                                        c118112.L$0 = SpillingKt.nullOutSpilledVariable(preferencesManager);
                                        c118112.L$1 = SpillingKt.nullOutSpilledVariable(r84);
                                        c118112.L$2 = null;
                                        c118112.Z$0 = r62;
                                        c118112.J$0 = jCurrentTimeMillis;
                                        c118112.I$0 = i2;
                                        c118112.label = 9;
                                        break;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        r62 = z3;
                                        z2 = false;
                                        r1 = r12;
                                        r6 = r62;
                                        r8 = r84;
                                        r1.isUpdatingUserData = z2;
                                        main = Dispatchers.getMain();
                                        anonymousClass7 = new AnonymousClass7(null);
                                        c118112.L$0 = SpillingKt.nullOutSpilledVariable(preferencesManager);
                                        c118112.L$1 = SpillingKt.nullOutSpilledVariable(r8);
                                        c118112.L$2 = th;
                                        c118112.Z$0 = r6;
                                        c118112.J$0 = jCurrentTimeMillis;
                                        c118112.I$0 = i2;
                                        c118112.label = 10;
                                        if (BuildersKt.withContext(main, anonymousClass7, c118112) == coroutine_suspended) {
                                        }
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                r62 = z3;
                                r84 = currentUser;
                                preferencesManager = preferencesManager2;
                                Log.e(r7, "Error updating user data", e);
                                r12.isUpdatingUserData = false;
                                MainCoroutineDispatcher main82 = Dispatchers.getMain();
                                AnonymousClass7 anonymousClass742 = new AnonymousClass7(null);
                                c118112.L$0 = SpillingKt.nullOutSpilledVariable(preferencesManager);
                                c118112.L$1 = SpillingKt.nullOutSpilledVariable(r84);
                                c118112.L$2 = null;
                                c118112.Z$0 = r62;
                                c118112.J$0 = jCurrentTimeMillis;
                                c118112.I$0 = i2;
                                c118112.label = 9;
                                break;
                            } catch (Throwable th4) {
                                th = th4;
                                r62 = z3;
                                r84 = currentUser;
                                preferencesManager = preferencesManager2;
                                z2 = false;
                                r1 = r12;
                                r6 = r62;
                                r8 = r84;
                                r1.isUpdatingUserData = z2;
                                main = Dispatchers.getMain();
                                anonymousClass7 = new AnonymousClass7(null);
                                c118112.L$0 = SpillingKt.nullOutSpilledVariable(preferencesManager);
                                c118112.L$1 = SpillingKt.nullOutSpilledVariable(r8);
                                c118112.L$2 = th;
                                c118112.Z$0 = r6;
                                c118112.J$0 = jCurrentTimeMillis;
                                c118112.I$0 = i2;
                                c118112.label = 10;
                                if (BuildersKt.withContext(main, anonymousClass7, c118112) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                throw th;
                            }
                        }
                    }
                }
                i = 1;
                if (i != 0) {
                }
                return coroutine_suspended;
            case 1:
                boolean z7 = c11811.Z$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 2:
                boolean z8 = c11811.Z$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 3:
                int i3 = c11811.I$0;
                jCurrentTimeMillis = c11811.J$0;
                boolean z9 = c11811.Z$0;
                currentUser = (MTUser) c11811.L$1;
                preferencesManager2 = (PreferencesManager) c11811.L$0;
                ResultKt.throwOnFailure(obj);
                c118112 = c11811;
                i = i3;
                z6 = z9;
                i2 = i;
                z3 = z6;
                FirebaseTokenManager firebaseTokenManager2 = FirebaseTokenManager.INSTANCE;
                Context contextRequireContext22 = r12.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext22, "requireContext(...)");
                c118112.L$0 = preferencesManager2;
                c118112.L$1 = currentUser;
                c118112.Z$0 = z3;
                c118112.J$0 = jCurrentTimeMillis;
                c118112.I$0 = i2;
                c118112.label = 4;
                objEnsureFreshToken = firebaseTokenManager2.ensureFreshToken(contextRequireContext22, c118112);
                if (objEnsureFreshToken != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 4:
                i2 = c11811.I$0;
                jCurrentTimeMillis = c11811.J$0;
                boolean z10 = c11811.Z$0;
                currentUser = (MTUser) c11811.L$1;
                preferencesManager2 = (PreferencesManager) c11811.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    objEnsureFreshToken = obj;
                    c118112 = c11811;
                    z3 = z10;
                    r84 = currentUser;
                    preferencesManager = preferencesManager2;
                    str = (String) objEnsureFreshToken;
                    str2 = str;
                    if (str2 != null) {
                        if (!Intrinsics.areEqual(preferencesManager.getString(PreferencesManager.AUTH_PROVIDER, ""), FirebaseAuthProvider.PROVIDER_ID)) {
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    c118112 = c11811;
                    r62 = z10;
                    r84 = currentUser;
                    preferencesManager = preferencesManager2;
                    Log.e(r7, "Error updating user data", e);
                    r12.isUpdatingUserData = false;
                    MainCoroutineDispatcher main822 = Dispatchers.getMain();
                    AnonymousClass7 anonymousClass7422 = new AnonymousClass7(null);
                    c118112.L$0 = SpillingKt.nullOutSpilledVariable(preferencesManager);
                    c118112.L$1 = SpillingKt.nullOutSpilledVariable(r84);
                    c118112.L$2 = null;
                    c118112.Z$0 = r62;
                    c118112.J$0 = jCurrentTimeMillis;
                    c118112.I$0 = i2;
                    c118112.label = 9;
                    break;
                } catch (Throwable th5) {
                    th = th5;
                    c118112 = c11811;
                    r6 = z10;
                    z2 = false;
                    r8 = currentUser;
                    preferencesManager = preferencesManager2;
                    r1 = r12;
                    r1.isUpdatingUserData = z2;
                    main = Dispatchers.getMain();
                    anonymousClass7 = new AnonymousClass7(null);
                    c118112.L$0 = SpillingKt.nullOutSpilledVariable(preferencesManager);
                    c118112.L$1 = SpillingKt.nullOutSpilledVariable(r8);
                    c118112.L$2 = th;
                    c118112.Z$0 = r6;
                    c118112.J$0 = jCurrentTimeMillis;
                    c118112.I$0 = i2;
                    c118112.label = 10;
                    if (BuildersKt.withContext(main, anonymousClass7, c118112) == coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            case 5:
                i2 = c11811.I$0;
                jCurrentTimeMillis = c11811.J$0;
                boolean z11 = c11811.Z$0;
                str = (String) c11811.L$2;
                MTUser mTUser = (MTUser) c11811.L$1;
                preferencesManager = (PreferencesManager) c11811.L$0;
                ResultKt.throwOnFailure(obj);
                c118112 = c11811;
                z4 = z11;
                r82 = mTUser;
                Unit unit2 = Unit.INSTANCE;
                r12.isUpdatingUserData = false;
                MainCoroutineDispatcher main62 = Dispatchers.getMain();
                AnonymousClass7 anonymousClass722 = new AnonymousClass7(null);
                c118112.L$0 = SpillingKt.nullOutSpilledVariable(preferencesManager);
                Object objNullOutSpilledVariable2 = SpillingKt.nullOutSpilledVariable(r82);
                c118112.L$1 = objNullOutSpilledVariable2;
                c118112.L$2 = SpillingKt.nullOutSpilledVariable(str);
                c118112.L$3 = unit2;
                c118112.Z$0 = z4;
                c118112.J$0 = jCurrentTimeMillis;
                c118112.I$0 = i2;
                c118112.label = 6;
                objWithContext = BuildersKt.withContext(main62, anonymousClass722, c118112);
                r12 = objNullOutSpilledVariable2;
                r62 = z4;
                r7 = main62;
                r84 = r82;
                if (objWithContext != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 6:
                int i4 = c11811.I$0;
                long j = c11811.J$0;
                boolean z12 = c11811.Z$0;
                Unit unit3 = (Unit) c11811.L$3;
                ResultKt.throwOnFailure(obj);
                return unit3;
            case 7:
                i2 = c11811.I$0;
                jCurrentTimeMillis = c11811.J$0;
                boolean z13 = c11811.Z$0;
                MTUser mTUser2 = (MTUser) c11811.L$1;
                preferencesManager = (PreferencesManager) c11811.L$0;
                ResultKt.throwOnFailure(obj);
                c118112 = c11811;
                z5 = z13;
                r83 = mTUser2;
                r12.lastSuccessfulUpdate = jCurrentTimeMillis;
                preferencesManager.setLastApiUpdate(jCurrentTimeMillis);
                r7 = 0;
                r12.isUpdatingUserData = false;
                MainCoroutineDispatcher main72 = Dispatchers.getMain();
                AnonymousClass7 anonymousClass732 = new AnonymousClass7(null);
                c118112.L$0 = SpillingKt.nullOutSpilledVariable(preferencesManager);
                c118112.L$1 = SpillingKt.nullOutSpilledVariable(r83);
                c118112.L$2 = null;
                c118112.Z$0 = z5;
                c118112.J$0 = jCurrentTimeMillis;
                c118112.I$0 = i2;
                r12 = 8;
                c118112.label = 8;
                r62 = z5;
                r84 = r83;
                break;
            case 8:
            case 9:
                int i5 = c11811.I$0;
                long j2 = c11811.J$0;
                boolean z14 = c11811.Z$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 10:
                int i6 = c11811.I$0;
                long j3 = c11811.J$0;
                boolean z15 = c11811.Z$0;
                Throwable th6 = (Throwable) c11811.L$2;
                ResultKt.throwOnFailure(obj);
                throw th6;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static /* synthetic */ Object updateUserDataWithTokenValidation$default(HomeFragment homeFragment, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return homeFragment.updateUserDataWithTokenValidation(z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateUserDecks(int i, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C11832(i, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateUserFriends(int i, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C11842(i, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateUserPlaygroups(int i, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C11852(i, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateUserProfile(int i, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C11862(i, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUserUI(PreferencesManager prefs, MTUser user, List<MTPlaygroup> playgroups, List<MTDeck> decks, List<MTFriend> friends) {
        if (prefs.hasValidUser()) {
            getBinding().accountInfoLayout.setVisibility(8);
            getBinding().playgroupsHeaderLayout.setVisibility(0);
            getBinding().decksHeaderLayout.setVisibility(0);
            getBinding().friendsHeaderLayout.setVisibility(0);
            getBinding().friendsRecyclerView.setVisibility(0);
            if (user != null) {
                updatePlaygroups(user, playgroups);
                updateDecks(user, decks);
                updateFriends(user, friends);
                updateProfile(user);
                return;
            }
            return;
        }
        getBinding().playgroupsHeaderLayout.setVisibility(8);
        getBinding().noPlaygroupsLayout.setVisibility(8);
        getBinding().playgroupsRecyclerView.setVisibility(8);
        getBinding().friendsHeaderLayout.setVisibility(8);
        getBinding().friendsRecyclerView.setVisibility(8);
        getBinding().noDecksLayout.setVisibility(8);
        getBinding().decksRecyclerView.setVisibility(8);
        getBinding().decksHeaderLayout.setVisibility(8);
        getBinding().allFriendsLayout.setVisibility(8);
        getBinding().allPlaygroupsLayout.setVisibility(8);
        getBinding().allDecksLayout.setVisibility(8);
        getBinding().noProfileIcon.setVisibility(0);
        getBinding().profileIcon.setVisibility(4);
        getBinding().noPhotoIcon.setVisibility(4);
        getBinding().profileMythicBorder.setVisibility(8);
        getBinding().profileMythicBorder.stopAnimation();
        getBinding().accountInfoLayout.setVisibility(0);
    }

    public final void handleQREventURL(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser == null || getChildFragmentManager().isStateSaved()) {
            return;
        }
        ProfileBottomSheetFragment.INSTANCE.newInstance(this, currentUser, false, url).show(getChildFragmentManager(), ProfileBottomSheetFragment.TAG);
    }

    @Override // com.studiolaganne.lengendarylens.FriendsClickListener
    public void onAddFriendTapped() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("add_friend_tap_home", null);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (!preferencesManager.hasValidUser() || currentUser == null) {
            return;
        }
        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.CAMERA") == 0) {
            if (getChildFragmentManager().isStateSaved()) {
                return;
            }
            QRScanBottomSheetFragment.Companion.newInstance$default(QRScanBottomSheetFragment.INSTANCE, this, currentUser, false, 4, null).show(getChildFragmentManager(), QRScanBottomSheetFragment.TAG);
            return;
        }
        if (!preferencesManager.getBoolean(PreferencesManager.CAMERA_PERMISSION_ASKED_BEFORE, false)) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = getString(R.string.permissions_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = getString(R.string.camera_permission_rationale);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
            String string3 = getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeFragment.onAddFriendTapped$lambda$0$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string4 = getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HomeFragment.onAddFriendTapped$lambda$0$1((CustomDialogFragment) obj);
                }
            });
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            negativeButton.show(childFragmentManager, "camera_permission_dialog");
            return;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.CAMERA")) {
            this.requestCameraPermissionLauncher.launch("android.permission.CAMERA");
            return;
        }
        CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
        String string5 = getString(R.string.permissions_title);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        CustomDialogFragment.Builder title2 = builder2.setTitle(string5);
        String string6 = getString(R.string.camera_permission_denied_message);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed2 = title2.setBody(string6).setPositiveButtonRed();
        String string7 = getString(R.string.open_settings);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        CustomDialogFragment.Builder positiveButton2 = positiveButtonRed2.setPositiveButton(string7, new Function2() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HomeFragment.onAddFriendTapped$lambda$0$2(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string8 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        CustomDialogFragment.Builder negativeButton2 = positiveButton2.setNegativeButton(string8, new Function1() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HomeFragment.onAddFriendTapped$lambda$0$3((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        negativeButton2.show(childFragmentManager2, "camera_permission_settings_dialog");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (preferencesManager.getCurrentUser() != null) {
            preferencesManager.setForcedApiUpdate(true);
        } else {
            MTApiKt.getMtApi().getOnboarding().enqueue(new Callback<MTOnboardingResponse>() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onCreate$2$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTOnboardingResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.$this_run.getContext() == null || this.$this_run._binding == null) {
                        return;
                    }
                    Log.d("MTApi", "Onboarding failed: " + t.getLocalizedMessage());
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTOnboardingResponse> call, Response<MTOnboardingResponse> response) {
                    MTOnboardingResponse mTOnboardingResponseBody;
                    MTOnboarding onboarding;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.$this_run.getContext() == null || this.$this_run.getChildFragmentManager().isStateSaved() || (mTOnboardingResponseBody = response.body()) == null || (onboarding = mTOnboardingResponseBody.getOnboarding()) == null) {
                        return;
                    }
                    PreferencesManager preferencesManager2 = preferencesManager;
                    HomeFragment homeFragment = this.$this_run;
                    if (preferencesManager2.wasOnboardingSeen(onboarding.getId())) {
                        return;
                    }
                    OnboardingDialogFragment.INSTANCE.newInstance(onboarding.getPages()).show(homeFragment.getChildFragmentManager(), "OnboardingDialog");
                    FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(homeFragment.requireContext());
                    Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                    firebaseAnalytics.logEvent("new_version_onboarding_unlogged", null);
                    preferencesManager2.setOnboardingSeen(onboarding.getId());
                }
            });
        }
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentHomeBinding.inflate(inflater, container, false);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).setLastApiUpdate(0L);
        return getBinding().getRoot();
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onDeckCreated(List<MTDeck> decks) {
        List<MTDeck> list = decks;
        if (list == null || list.isEmpty() || getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null && decks != null) {
            preferencesManager.saveCurrentUserDecks(decks);
            updateDecks(currentUser, decks);
        }
        if (preferencesManager.getBoolean(PreferencesManager.DECK_RATING_PROMPT_SHOWN, false)) {
            return;
        }
        preferencesManager.setBoolean(PreferencesManager.DECK_RATING_PROMPT_SHOWN, true);
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("rating_prompt_deck", null);
        View view = getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.onDeckCreated$lambda$1(this.f$0);
                }
            }, 2000L);
        }
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onDeckCreatedForUser(MTDeck deck, int userId) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onDeckEdited(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }

    @Override // com.studiolaganne.lengendarylens.DecksClickListener
    public void onDeckSelected(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        if (getContext() == null || this._binding == null) {
            return;
        }
        Intent intent = new Intent(requireContext(), (Class<?>) DeckDetailsActivity.class);
        intent.putExtra("deckId", deck.getId());
        this.deckActivityLauncher.launch(intent);
    }

    @Override // com.studiolaganne.lengendarylens.DecksClickListener
    public void onDeckTemporary(final MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
        if (getContext() == null || this._binding == null) {
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.temporary_deck_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.temporary_deck_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = getString(R.string.keep_button);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HomeFragment.onDeckTemporary$lambda$0(this.f$0, deck, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.discard_button);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HomeFragment.onDeckTemporary$lambda$1(this.f$0, deck, (CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "temp_deck_dialog");
    }

    @Override // com.studiolaganne.lengendarylens.AcceptFriendCallback
    public void onFriendAccepted(List<MTFriend> friendlist) {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (preferencesManager.getCurrentUser() == null || friendlist == null) {
            return;
        }
        preferencesManager.saveCurrentUserFriends(friendlist);
        getBinding().friendsRecyclerView.setAdapter(new FriendsAdapter(CollectionsKt.sortedWith(friendlist, new Comparator() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onFriendAccepted$lambda$0$0$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((MTFriend) t2).getStatus(), ((MTFriend) t).getStatus());
            }
        }), this));
    }

    @Override // com.studiolaganne.lengendarylens.QRScanCallback
    public void onFriendCodeConfirmed(int userId) {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (!preferencesManager.hasValidUser() || currentUser == null || userId == -1 || userId == currentUser.getId()) {
            return;
        }
        getBinding().overlay.setVisibility(0);
        getBinding().connectingTextView.setText(getString(R.string.adding));
        MTApiKt.getMtApi().addFriend(currentUser.getId(), userId).enqueue(new HomeFragment$onFriendCodeConfirmed$1$1(this, userId, preferencesManager));
    }

    @Override // com.studiolaganne.lengendarylens.AcceptFriendCallback
    public void onFriendDeclined(List<MTFriend> friendlist) {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (preferencesManager.getCurrentUser() == null || friendlist == null) {
            return;
        }
        preferencesManager.saveCurrentUserFriends(friendlist);
        getBinding().friendsRecyclerView.setAdapter(new FriendsAdapter(CollectionsKt.sortedWith(friendlist, new Comparator() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onFriendDeclined$lambda$0$0$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((MTFriend) t2).getStatus(), ((MTFriend) t).getStatus());
            }
        }), this));
    }

    @Override // com.studiolaganne.lengendarylens.FriendsClickListener
    public void onFriendSelected(final MTFriend friend) {
        Intrinsics.checkNotNullParameter(friend, "friend");
        if (getContext() == null || this._binding == null) {
            return;
        }
        if (!Intrinsics.areEqual(friend.getStatus(), "pending")) {
            if (getChildFragmentManager().isStateSaved()) {
                return;
            }
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("home_friend_click", null);
            ProfileBottomSheetFragment.Companion.newInstance$default(ProfileBottomSheetFragment.INSTANCE, this, new MTUser(false, friend.getId(), friend.getFirstname(), friend.getEmail(), friend.getUsername(), friend.getPicture(), null, null, null, null, 960, null), null, null, 12, null).show(getChildFragmentManager(), ProfileBottomSheetFragment.TAG);
            return;
        }
        if (!friend.is_requester()) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
            if (currentUser == null || getChildFragmentManager().isStateSaved()) {
                return;
            }
            Breadcrumbs.INSTANCE.leaveBreadcrumb("accept_friend_tap");
            FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
            firebaseAnalytics2.logEvent("accept_friend_tap", null);
            new AcceptFriendBottomSheetFragment(this, currentUser, friend).show(getChildFragmentManager(), AcceptFriendBottomSheetFragment.TAG);
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.friend_request_pending_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.friend_request_pending_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HomeFragment.onFriendSelected$lambda$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = getString(R.string.remove_invite);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder destructiveButton = positiveButton.setDestructiveButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HomeFragment.onFriendSelected$lambda$1(this.f$0, friend, (CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        destructiveButton.show(childFragmentManager, "friend_request_pending_dialog");
    }

    @Override // com.studiolaganne.lengendarylens.CreateDeckCallback
    public void onGhostDeckCreated(MTDeck deck) {
        Intrinsics.checkNotNullParameter(deck, "deck");
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden || getContext() == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (mainActivity != null) {
            mainActivity.ensureNavigationBarsVisible();
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        updateRecentCardsUI(preferencesManager);
        randomKeyword();
        if (preferencesManager.getForcedApiUpdate() || preferencesManager.getBoolean(PreferencesManager.NEED_USER_RELOAD, false)) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C11701(null), 3, null);
        }
    }

    @Override // com.studiolaganne.lengendarylens.SignInCallback
    public void onOAuthSignInSuccess(String code, String type) {
        String str;
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(type, "type");
        if (getContext() == null || this._binding == null || getChildFragmentManager().isStateSaved()) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("home_oauth_success");
        FirebaseAnalytics.getInstance(requireContext()).logEvent("home_oauth_success", null);
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
        MTApiKt.getMtApi().exchange(mTLoginBody).enqueue(new C11711(preferencesManager));
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(requireContext());
        BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiver");
            broadcastReceiver = null;
        }
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
    }

    @Override // com.studiolaganne.lengendarylens.AcceptPlaygroupCallback
    public void onPlaygroupAccepted(List<MTPlaygroup> playgroups) {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null || playgroups == null) {
            return;
        }
        preferencesManager.saveCurrentUserPlaygroups(playgroups);
        updatePlaygroups(currentUser, playgroups);
    }

    @Override // com.studiolaganne.lengendarylens.CreatePlaygroupCallback
    public void onPlaygroupCreated(List<MTPlaygroup> playgroups) {
        List<MTPlaygroup> list = playgroups;
        if (list == null || list.isEmpty() || getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null && playgroups != null) {
            preferencesManager.saveCurrentUserPlaygroups(playgroups);
            updatePlaygroups(currentUser, playgroups);
        }
        this.playgroupActivityLauncher.launch(new Intent(requireContext(), (Class<?>) PlaygroupDetailsActivity.class));
    }

    @Override // com.studiolaganne.lengendarylens.AcceptPlaygroupCallback
    public void onPlaygroupDeclined(List<MTPlaygroup> playgroups) {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null || playgroups == null) {
            return;
        }
        preferencesManager.saveCurrentUserPlaygroups(playgroups);
        updatePlaygroups(currentUser, playgroups);
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupsClickListener
    public void onPlaygroupSelected(MTPlaygroup playgroup) {
        Intrinsics.checkNotNullParameter(playgroup, "playgroup");
        if (getContext() == null || this._binding == null || getChildFragmentManager().isStateSaved()) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            if (Intrinsics.areEqual(playgroup.getStatus(), "pending")) {
                new AcceptPlaygroupBottomSheetFragment(this, currentUser, playgroup).show(getChildFragmentManager(), AcceptPlaygroupBottomSheetFragment.TAG);
                return;
            }
            Intent intent = new Intent(requireContext(), (Class<?>) PlaygroupDetailsActivity.class);
            intent.putExtra("playgroupId", playgroup.getId());
            this.playgroupActivityLauncher.launch(intent);
        }
    }

    @Override // com.studiolaganne.lengendarylens.ProfileCallback
    public void onProfileClose() {
        if (getChildFragmentManager().isStateSaved()) {
            return;
        }
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(ProfileBottomSheetFragment.TAG);
        ProfileBottomSheetFragment profileBottomSheetFragment = fragmentFindFragmentByTag instanceof ProfileBottomSheetFragment ? (ProfileBottomSheetFragment) fragmentFindFragmentByTag : null;
        if (profileBottomSheetFragment != null) {
            profileBottomSheetFragment.dismiss();
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C11721(null), 3, null);
    }

    @Override // com.studiolaganne.lengendarylens.ProfileCallback
    public void onProfileLogout() {
        if (getContext() == null || getChildFragmentManager().isStateSaved()) {
            return;
        }
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(ProfileBottomSheetFragment.TAG);
        ProfileBottomSheetFragment profileBottomSheetFragment = fragmentFindFragmentByTag instanceof ProfileBottomSheetFragment ? (ProfileBottomSheetFragment) fragmentFindFragmentByTag : null;
        if (profileBottomSheetFragment != null) {
            profileBottomSheetFragment.dismiss();
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser != null) {
            MTApiKt.getMtApi().logout(currentUser.getId(), new MTLoginBody(preferencesManager.getString(PreferencesManager.FCM_TOKEN, ""), preferencesManager.getDeviceLanguage(), null, null, null, null, 60, null)).enqueue(new Callback<MTResponse>() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onProfileLogout$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTResponse> call, Response<MTResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getContext() != null) {
                        FragmentHomeBinding unused = this.this$0._binding;
                    }
                }
            });
            FirebaseAuth.getInstance().signOut();
            CustomerIO.INSTANCE.instance().clearIdentify();
            Purchases.logOut$default(Purchases.INSTANCE.getSharedInstance(), null, 1, null);
        }
        FirebaseAnalytics.getInstance(requireContext()).setUserProperty("is_logged_in", CredentialEntry.FALSE_STRING);
        preferencesManager.clearCurrentUser();
        preferencesManager.clearAllUsersDecks();
        preferencesManager.clearUnSyncedGames();
        preferencesManager.clearUnSyncedSets();
        preferencesManager.clearCurrentUserFavorites();
        preferencesManager.clearRecentCardsNew();
        preferencesManager.clearCurrentUserTags();
        preferencesManager.clearCurrentUserPrivacy();
        preferencesManager.clearAllThemeTokens();
        preferencesManager.clearAllThemesPurchased();
        preferencesManager.clearLocalThemesCache();
        getBinding().recentRecyclerView.setAdapter(new NewRecentListAdapter(CollectionsKt.emptyList(), this));
        MessagesDBHelper.Companion companion = MessagesDBHelper.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        companion.getInstance(contextRequireContext2).clearAll();
        updateUserUI(preferencesManager, null, CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
        getBinding().eventBannerLayout.setVisibility(8);
        updateMythicPlusBanner();
        FragmentActivity activity = getActivity();
        MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (mainActivity != null) {
            mainActivity.userLoggedOut();
        }
    }

    @Override // com.studiolaganne.lengendarylens.ProfileCallback
    public void onProfilePictureUpdated() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            updateProfile(currentUser);
        }
    }

    @Override // com.studiolaganne.lengendarylens.QRScanCallback
    public void onQRClosed() {
        if (getChildFragmentManager().isStateSaved()) {
            return;
        }
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(QRScanBottomSheetFragment.TAG);
        QRScanBottomSheetFragment qRScanBottomSheetFragment = fragmentFindFragmentByTag instanceof QRScanBottomSheetFragment ? (QRScanBottomSheetFragment) fragmentFindFragmentByTag : null;
        if (qRScanBottomSheetFragment != null) {
            qRScanBottomSheetFragment.dismiss();
        }
    }

    @Override // com.studiolaganne.lengendarylens.QRScanCallback
    public void onQRScanned(String value) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(value, "value");
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
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
            getBinding().overlay.setVisibility(0);
            getBinding().connectingTextView.setText(getString(R.string.adding));
            MTApiKt.getMtApi().addFriend(currentUser.getId(), iIntValue).enqueue(new HomeFragment$onQRScanned$1$2$1(this, iIntValue, preferencesManager));
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
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HomeFragment.onQRScanned$lambda$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "qr_code_error_dialog");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v39, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, com.studiolaganne.lengendarylens.CardRecord] */
    /* JADX WARN: Type inference failed for: r4v8, types: [T, com.studiolaganne.lengendarylens.CardRecord] */
    /* JADX WARN: Type inference failed for: r9v1, types: [T, com.studiolaganne.lengendarylens.CardRecord] */
    /* JADX WARN: Type inference failed for: r9v12, types: [T, com.studiolaganne.lengendarylens.CardRecord] */
    @Override // com.studiolaganne.lengendarylens.NewRecentCardClickListener
    public void onRandomCardClickNew() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("home_random_card_click");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("home_random_card_click", null);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (!Intrinsics.areEqual(preferencesManager.getDeviceLanguage(), "fr")) {
            MTGDBHelper.Companion companion = MTGDBHelper.INSTANCE;
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            MTGDBHelper companion2 = companion.getInstance(contextRequireContext2);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = companion2.getRandomCard();
            while (isNotValid(((CardRecord) objectRef.element).getTitle(), "en")) {
                objectRef.element = companion2.getRandomCard();
            }
            MTFullCard mTFullCard = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
            mTFullCard.setScryfallid(((CardRecord) objectRef.element).getScryfall_id());
            mTFullCard.setOracleid(((CardRecord) objectRef.element).getOracle_id());
            String lowerCase = ((CardRecord) objectRef.element).getSet().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            mTFullCard.setSet_code(lowerCase);
            mTFullCard.setCollector_number(((CardRecord) objectRef.element).getNumber());
            mTFullCard.setLang("en");
            preferencesManager.syncRecentCard(mTFullCard);
            getBinding().recentRecyclerView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.onRandomCardClickNew$lambda$1(this.f$0, objectRef);
                }
            }, 100L);
            return;
        }
        MTGDBHelperLocalized.Companion companion3 = MTGDBHelperLocalized.INSTANCE;
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        MTGDBHelperLocalized companion4 = companion3.getInstance(contextRequireContext3, "fr");
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = companion4.getRandomCard();
        while (isNotValid(((CardRecord) objectRef2.element).getTitle(), "fr")) {
            objectRef2.element = companion4.getRandomCard();
        }
        MTGDBHelper.Companion companion5 = MTGDBHelper.INSTANCE;
        Context contextRequireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
        CardRecord cardByOracleIdAndPrintData = companion5.getInstance(contextRequireContext4).getCardByOracleIdAndPrintData(((CardRecord) objectRef2.element).getOracle_id(), ((CardRecord) objectRef2.element).getSet(), ((CardRecord) objectRef2.element).getNumber(), ((CardRecord) objectRef2.element).getFace());
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = "";
        if (cardByOracleIdAndPrintData != null) {
            objectRef3.element = cardByOracleIdAndPrintData.getScryfall_id();
        }
        MTFullCard mTFullCard2 = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
        mTFullCard2.setScryfallid(((CardRecord) objectRef2.element).getScryfall_id());
        mTFullCard2.setOracleid(((CardRecord) objectRef2.element).getOracle_id());
        String lowerCase2 = ((CardRecord) objectRef2.element).getSet().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        mTFullCard2.setSet_code(lowerCase2);
        mTFullCard2.setCollector_number(((CardRecord) objectRef2.element).getNumber());
        mTFullCard2.setLang("fr");
        preferencesManager.syncRecentCard(mTFullCard2);
        getBinding().recentRecyclerView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.onRandomCardClickNew$lambda$0(this.f$0, objectRef2, objectRef3);
            }
        }, 100L);
    }

    @Override // com.studiolaganne.lengendarylens.NewRecentCardClickListener
    public void onRecentCardClickNew(MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (getContext() == null || this._binding == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("recent_card_click");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("recent_card_click", null);
        Intent intent = new Intent(requireContext(), (Class<?>) CardActivity.class);
        intent.putExtra("scryfallId", card.getScryfallid());
        intent.putExtra("oracleId", card.getOracleid());
        intent.putExtra("lang", card.getLocale());
        intent.putExtra(OptionalModuleUtils.FACE, card.getFace());
        this.cardActivityLauncher.launch(intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (preferencesManager.getCurrentUser() != null) {
            handleLocalUpdates(preferencesManager);
        }
        FragmentActivity activity = getActivity();
        BroadcastReceiver broadcastReceiver = null;
        MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (mainActivity != null) {
            mainActivity.ensureNavigationBarsVisible();
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C11731(null), 3, null);
        this.receiver = new BroadcastReceiver() { // from class: com.studiolaganne.lengendarylens.HomeFragment.onResume.2
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // android.content.BroadcastReceiver
            public void onReceive(final Context context, Intent intent) {
                final MTUser currentUser;
                String stringExtra = intent != null ? intent.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE) : null;
                Log.d("HomeFragment", "----->>>> Received message type: " + stringExtra);
                if (stringExtra != null) {
                    switch (stringExtra.hashCode()) {
                        case -1707926102:
                            if (stringExtra.equals(PreferencesManager.MSG_TYPE_FRIENDSHIP_REQUEST) && context != null) {
                                String stringExtra2 = intent.getStringExtra("message_fromUserId");
                                Integer intOrNull = stringExtra2 != null ? StringsKt.toIntOrNull(stringExtra2) : null;
                                if (intOrNull != null) {
                                    HomeFragment homeFragment = HomeFragment.this;
                                    intOrNull.intValue();
                                    if (!homeFragment.getChildFragmentManager().isStateSaved()) {
                                        Fragment fragmentFindFragmentByTag = homeFragment.getChildFragmentManager().findFragmentByTag(ProfileBottomSheetFragment.TAG);
                                        ProfileBottomSheetFragment profileBottomSheetFragment = fragmentFindFragmentByTag instanceof ProfileBottomSheetFragment ? (ProfileBottomSheetFragment) fragmentFindFragmentByTag : null;
                                        if (profileBottomSheetFragment != null) {
                                            profileBottomSheetFragment.closeQRDialog();
                                        }
                                        if (profileBottomSheetFragment != null) {
                                            profileBottomSheetFragment.dismiss();
                                        }
                                        Fragment fragmentFindFragmentByTag2 = homeFragment.getChildFragmentManager().findFragmentByTag(QRScanBottomSheetFragment.TAG);
                                        QRScanBottomSheetFragment qRScanBottomSheetFragment = fragmentFindFragmentByTag2 instanceof QRScanBottomSheetFragment ? (QRScanBottomSheetFragment) fragmentFindFragmentByTag2 : null;
                                        if (qRScanBottomSheetFragment != null) {
                                            qRScanBottomSheetFragment.closeQRDialog();
                                        }
                                        if (qRScanBottomSheetFragment != null) {
                                            qRScanBottomSheetFragment.dismiss();
                                        }
                                        homeFragment.fetchFriendListAndShowPending(intOrNull.intValue());
                                        break;
                                    }
                                }
                            }
                            break;
                        case 987952009:
                            if (stringExtra.equals(PreferencesManager.MSG_TYPE_PLAYGROUP_JOIN) && context != null && (currentUser = preferencesManager.getCurrentUser()) != null) {
                                final HomeFragment homeFragment2 = HomeFragment.this;
                                final PreferencesManager preferencesManager2 = preferencesManager;
                                MTApiKt.getMtApi().getPlaygroups(currentUser.getId()).enqueue(new Callback<MTPlaygroupResponse>() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onResume$2$onReceive$2$1
                                    @Override // retrofit2.Callback
                                    public void onFailure(Call<MTPlaygroupResponse> call, Throwable t) {
                                        Intrinsics.checkNotNullParameter(call, "call");
                                        Intrinsics.checkNotNullParameter(t, "t");
                                    }

                                    @Override // retrofit2.Callback
                                    public void onResponse(Call<MTPlaygroupResponse> call, Response<MTPlaygroupResponse> response) {
                                        Intrinsics.checkNotNullParameter(call, "call");
                                        Intrinsics.checkNotNullParameter(response, "response");
                                        if (context == null || homeFragment2._binding == null || !response.isSuccessful()) {
                                            return;
                                        }
                                        MTPlaygroupResponse mTPlaygroupResponseBody = response.body();
                                        List<MTPlaygroup> playgroups = mTPlaygroupResponseBody != null ? mTPlaygroupResponseBody.getPlaygroups() : null;
                                        if (playgroups != null) {
                                            PreferencesManager preferencesManager3 = preferencesManager2;
                                            HomeFragment homeFragment3 = homeFragment2;
                                            MTUser mTUser = currentUser;
                                            preferencesManager3.saveCurrentUserPlaygroups(playgroups);
                                            homeFragment3.updatePlaygroups(mTUser, playgroups);
                                        }
                                    }
                                });
                            }
                            break;
                        case 1586226284:
                            if (stringExtra.equals(PreferencesManager.MSG_TYPE_FRIENDSHIP_ACCEPTED) && context != null) {
                                HomeFragment.this.fetchFriendListAndShowPending(-1);
                            }
                            break;
                        case 1964028755:
                            if (stringExtra.equals(PreferencesManager.MSG_TYPE_PLAYGROUP_MESSAGE) && context != null) {
                                Context contextRequireContext2 = HomeFragment.this.requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                                MTUser currentUser2 = new PreferencesManager(contextRequireContext2).getCurrentUser();
                                if (currentUser2 != null) {
                                    final HomeFragment homeFragment3 = HomeFragment.this;
                                    String stringExtra3 = intent.getStringExtra("message_playgroupId");
                                    Integer intOrNull2 = stringExtra3 != null ? StringsKt.toIntOrNull(stringExtra3) : null;
                                    if (intOrNull2 != null) {
                                        intOrNull2.intValue();
                                        MessagesManager companion = MessagesManager.INSTANCE.getInstance();
                                        Context contextRequireContext3 = homeFragment3.requireContext();
                                        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                                        companion.updatePlaygroupMessages(contextRequireContext3, currentUser2, intOrNull2.intValue(), new MessagesManagerListener() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onResume$2$onReceive$4$1$1
                                            @Override // com.studiolaganne.lengendarylens.MessagesManagerListener
                                            public void onMessagesUpdated(int playgroupId) {
                                                if (context == null || homeFragment3._binding == null) {
                                                    return;
                                                }
                                                RecyclerView playgroupsRecyclerView = homeFragment3.getBinding().playgroupsRecyclerView;
                                                Intrinsics.checkNotNullExpressionValue(playgroupsRecyclerView, "playgroupsRecyclerView");
                                                RecyclerView.Adapter adapter = playgroupsRecyclerView.getAdapter();
                                                PlaygroupsAdapter playgroupsAdapter = adapter instanceof PlaygroupsAdapter ? (PlaygroupsAdapter) adapter : null;
                                                if (playgroupsAdapter != null) {
                                                    playgroupsAdapter.notifyDataSetChanged();
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                            break;
                        case 2035441181:
                            if (stringExtra.equals(PreferencesManager.MSG_TYPE_PLAYGROUP_INVITE) && context != null) {
                                String stringExtra4 = intent.getStringExtra("message_playgroupId");
                                Integer intOrNull3 = stringExtra4 != null ? StringsKt.toIntOrNull(stringExtra4) : null;
                                if (intOrNull3 != null) {
                                    HomeFragment.this.fetchPlaygroupListAndShowPending(intOrNull3.intValue());
                                }
                            }
                            break;
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(PreferencesManager.MESSAGE_INTENT);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(requireContext());
        BroadcastReceiver broadcastReceiver2 = this.receiver;
        if (broadcastReceiver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiver");
        } else {
            broadcastReceiver = broadcastReceiver2;
        }
        localBroadcastManager.registerReceiver(broadcastReceiver, intentFilter);
        handleResumeActions(preferencesManager);
    }

    @Override // com.studiolaganne.lengendarylens.SignInCallback
    public void onSignInCancel() {
        if (getContext() == null || this._binding == null || getChildFragmentManager().isStateSaved()) {
            return;
        }
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(SignInBottomSheetFragment.TAG);
        SignInBottomSheetFragment signInBottomSheetFragment = fragmentFindFragmentByTag instanceof SignInBottomSheetFragment ? (SignInBottomSheetFragment) fragmentFindFragmentByTag : null;
        if (signInBottomSheetFragment != null) {
            signInBottomSheetFragment.dismiss();
        }
    }

    @Override // com.studiolaganne.lengendarylens.SignInCallback
    public void onSignInFailure(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (getContext() == null || this._binding == null || getChildFragmentManager().isStateSaved()) {
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
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda47
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HomeFragment.onSignInFailure$lambda$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
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
        if (getContext() == null || this._binding == null || getChildFragmentManager().isStateSaved()) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("home_login_success");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("home_login_success", null);
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
        MTApiKt.getMtApi().signin(mTLoginBody).enqueue(new C11741(preferencesManager));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String id;
        String oracle_id;
        String lang;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C11751(null), 3, null);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        updateStoreBanner();
        updateRatingBanner();
        updateEmailBanner();
        updateMythicPlusBanner();
        getBinding().swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                HomeFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        RecyclerView friendsRecyclerView = getBinding().friendsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(friendsRecyclerView, "friendsRecyclerView");
        setupHorizontalScrollDetection(friendsRecyclerView);
        RecyclerView playgroupsRecyclerView = getBinding().playgroupsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(playgroupsRecyclerView, "playgroupsRecyclerView");
        setupHorizontalScrollDetection(playgroupsRecyclerView);
        RecyclerView decksRecyclerView = getBinding().decksRecyclerView;
        Intrinsics.checkNotNullExpressionValue(decksRecyclerView, "decksRecyclerView");
        setupHorizontalScrollDetection(decksRecyclerView);
        RecyclerView recentRecyclerView = getBinding().recentRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recentRecyclerView, "recentRecyclerView");
        setupHorizontalScrollDetection(recentRecyclerView);
        ImageView storeImage = getBinding().storeImage;
        Intrinsics.checkNotNullExpressionValue(storeImage, "storeImage");
        ViewExtensionsKt.setOnClickWithFade(storeImage, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda65
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.onViewCreated$lambda$1(this.f$0);
            }
        });
        ImageView settingsImage = getBinding().settingsImage;
        Intrinsics.checkNotNullExpressionValue(settingsImage, "settingsImage");
        ViewExtensionsKt.setOnClickWithFade(settingsImage, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda66
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.onViewCreated$lambda$2(this.f$0);
            }
        });
        getBinding().profilePictureLayout.setOutlineProvider(new CircularOutlineProvider());
        getBinding().profilePictureLayout.setClipToOutline(true);
        LinearLayout aboutLayout = getBinding().aboutLayout;
        Intrinsics.checkNotNullExpressionValue(aboutLayout, "aboutLayout");
        ViewExtensionsKt.setOnClickWithFade(aboutLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.onViewCreated$lambda$3(this.f$0);
            }
        });
        ConstraintLayout rulebookButtonLayout = getBinding().rulebookButtonLayout;
        Intrinsics.checkNotNullExpressionValue(rulebookButtonLayout, "rulebookButtonLayout");
        ViewExtensionsKt.setOnClickWithFade(rulebookButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.onViewCreated$lambda$4(this.f$0);
            }
        });
        ConstraintLayout searchButtonLayout = getBinding().searchButtonLayout;
        Intrinsics.checkNotNullExpressionValue(searchButtonLayout, "searchButtonLayout");
        ViewExtensionsKt.setOnClickWithFade(searchButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.onViewCreated$lambda$5(this.f$0);
            }
        });
        ConstraintLayout createPlaygroupButtonLayout = getBinding().createPlaygroupButtonLayout;
        Intrinsics.checkNotNullExpressionValue(createPlaygroupButtonLayout, "createPlaygroupButtonLayout");
        ViewExtensionsKt.setOnClickWithFade(createPlaygroupButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.onViewCreated$lambda$6(this.f$0);
            }
        });
        ConstraintLayout noPlaygroupsLayout = getBinding().noPlaygroupsLayout;
        Intrinsics.checkNotNullExpressionValue(noPlaygroupsLayout, "noPlaygroupsLayout");
        ViewExtensionsKt.setOnClickWithFade(noPlaygroupsLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.onViewCreated$lambda$7(this.f$0);
            }
        });
        ConstraintLayout createDeckButtonLayout = getBinding().createDeckButtonLayout;
        Intrinsics.checkNotNullExpressionValue(createDeckButtonLayout, "createDeckButtonLayout");
        ViewExtensionsKt.setOnClickWithFade(createDeckButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.onViewCreated$lambda$8(this.f$0);
            }
        });
        ConstraintLayout noDecksLayout = getBinding().noDecksLayout;
        Intrinsics.checkNotNullExpressionValue(noDecksLayout, "noDecksLayout");
        ViewExtensionsKt.setOnClickWithFade(noDecksLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.onViewCreated$lambda$9(this.f$0);
            }
        });
        LinearLayout allFriendsLayout = getBinding().allFriendsLayout;
        Intrinsics.checkNotNullExpressionValue(allFriendsLayout, "allFriendsLayout");
        ViewExtensionsKt.setOnClickWithFade(allFriendsLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.onViewCreated$lambda$10(this.f$0);
            }
        });
        LinearLayout allPlaygroupsLayout = getBinding().allPlaygroupsLayout;
        Intrinsics.checkNotNullExpressionValue(allPlaygroupsLayout, "allPlaygroupsLayout");
        ViewExtensionsKt.setOnClickWithFade(allPlaygroupsLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.onViewCreated$lambda$11(this.f$0);
            }
        });
        LinearLayout allDecksLayout = getBinding().allDecksLayout;
        Intrinsics.checkNotNullExpressionValue(allDecksLayout, "allDecksLayout");
        ViewExtensionsKt.setOnClickWithFade(allDecksLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.onViewCreated$lambda$12(this.f$0);
            }
        });
        ImageView randomKeywordIcon = getBinding().randomKeywordIcon;
        Intrinsics.checkNotNullExpressionValue(randomKeywordIcon, "randomKeywordIcon");
        ViewExtensionsKt.setOnClickWithFade(randomKeywordIcon, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.onViewCreated$lambda$13(this.f$0);
            }
        });
        FrameLayout profilePictureContainer = getBinding().profilePictureContainer;
        Intrinsics.checkNotNullExpressionValue(profilePictureContainer, "profilePictureContainer");
        ViewExtensionsKt.setOnClickWithFade(profilePictureContainer, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda55
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.onViewCreated$lambda$14(this.f$0);
            }
        });
        ConstraintLayout loginButtonLayout = getBinding().loginButtonLayout;
        Intrinsics.checkNotNullExpressionValue(loginButtonLayout, "loginButtonLayout");
        ViewExtensionsKt.setOnClickWithFade(loginButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda63
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HomeFragment.onViewCreated$lambda$15(this.f$0);
            }
        });
        updateUserUI(preferencesManager, preferencesManager.getCurrentUser(), preferencesManager.getCurrentUserPlaygroups(), preferencesManager.getCurrentUserDecks(), preferencesManager.getCurrentUserFriends());
        List<CardState> recentCardsOld = preferencesManager.getRecentCardsOld();
        if (!recentCardsOld.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (CardState cardState : recentCardsOld) {
                CardMatch cardMatch = cardState.getCardMatch();
                if (cardMatch == null || (id = cardMatch.getScryfallId()) == null) {
                    Card card = cardState.getCard();
                    id = card != null ? card.getId() : null;
                }
                CardMatch cardMatch2 = cardState.getCardMatch();
                if (cardMatch2 == null || (oracle_id = cardMatch2.getOracleId()) == null) {
                    Card card2 = cardState.getCard();
                    oracle_id = card2 != null ? card2.getOracle_id() : null;
                }
                CardMatch cardMatch3 = cardState.getCardMatch();
                if (cardMatch3 == null || (lang = cardMatch3.getLang()) == null) {
                    Card card3 = cardState.getCard();
                    lang = card3 != null ? card3.getLang() : null;
                }
                CardMatch cardMatch4 = cardState.getCardMatch();
                if (cardMatch4 != null) {
                    cardMatch4.getFace();
                }
                if (id != null && oracle_id != null && lang != null) {
                    MTFullCard mTFullCard = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                    mTFullCard.setOracleid(oracle_id);
                    arrayList.add(mTFullCard);
                }
            }
            preferencesManager.clearRecentCardsOld();
            preferencesManager.setRecentCardsNew(arrayList);
        }
        List<MTFullCard> recentCardsNew = preferencesManager.getRecentCardsNew();
        getBinding().recentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        getBinding().recentRecyclerView.setAdapter(new NewRecentListAdapter(recentCardsNew, this));
        View view2 = getView();
        if (view2 != null) {
            view2.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.HomeFragment$$ExternalSyntheticLambda64
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.onViewCreated$lambda$16(this.f$0);
                }
            }, 500L);
        }
        if (preferencesManager.getBoolean(PreferencesManager.GO_TO_SIGN_IN, false)) {
            preferencesManager.setBoolean(PreferencesManager.GO_TO_SIGN_IN, false);
            SignInBottomSheetFragment.INSTANCE.newInstance(this).show(getChildFragmentManager(), SignInBottomSheetFragment.TAG);
        }
        if (preferencesManager.getBoolean(PreferencesManager.ASK_FOR_NOTIFICATIONS, false)) {
            preferencesManager.setBoolean(PreferencesManager.ASK_FOR_NOTIFICATIONS, false);
            requestNotificationPermission();
        }
    }

    public final void showSignedOutState() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        getBinding().recentRecyclerView.setAdapter(new NewRecentListAdapter(CollectionsKt.emptyList(), this));
        updateUserUI(preferencesManager, null, CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
        getBinding().eventBannerLayout.setVisibility(8);
    }
}
