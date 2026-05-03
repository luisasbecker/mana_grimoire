package com.studiolaganne.lengendarylens;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Property;
import android.util.Size;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.ZoomState;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.AudioStats;
import androidx.camera.view.PreviewView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.content.res.ResourcesCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.media3.common.MimeTypes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.window.reflection.WindowExtensionsConstants;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.studiolaganne.lengendarylens.CollectionMatchesViewerDialogFragment;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.DeckMoveCardDialogFragment;
import com.studiolaganne.lengendarylens.EditCardDialogFragment;
import com.studiolaganne.lengendarylens.MTCardCsvExporter;
import com.studiolaganne.lengendarylens.MTCardPriceRow;
import com.studiolaganne.lengendarylens.MTGDBHelper;
import com.studiolaganne.lengendarylens.MTGDBHelperLocalized;
import com.studiolaganne.lengendarylens.MoveCardDialogFragment;
import com.studiolaganne.lengendarylens.RulingsDBHelper;
import com.studiolaganne.lengendarylens.ScanFragment;
import com.studiolaganne.lengendarylens.ScanSettingsDialogFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentScanBinding;
import com.vanniktech.ui.ColorKt;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: ScanFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000²\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 Ö\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Ö\u0002B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u009d\u0001\u001a\u00030\u009e\u00012\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0016J\u001d\u0010¡\u0001\u001a\u00030\u009e\u00012\b\u0010¢\u0001\u001a\u00030\u008c\u00012\u0007\u0010£\u0001\u001a\u00020&H\u0016J\n\u0010¤\u0001\u001a\u00030\u009e\u0001H\u0016J\n\u0010¥\u0001\u001a\u00030\u009e\u0001H\u0016J\u001c\u0010§\u0001\u001a\u00030\u009e\u00012\u0007\u0010¨\u0001\u001a\u0002022\u0007\u0010©\u0001\u001a\u00020&H\u0016J\u001c\u0010ª\u0001\u001a\u00030\u009e\u00012\u0007\u0010¨\u0001\u001a\u0002022\u0007\u0010©\u0001\u001a\u00020&H\u0016J\u001c\u0010«\u0001\u001a\u00030\u009e\u00012\u0007\u0010¨\u0001\u001a\u0002022\u0007\u0010©\u0001\u001a\u00020&H\u0016J%\u0010¬\u0001\u001a\u00030\u009e\u00012\u0007\u0010¨\u0001\u001a\u0002022\u0007\u0010©\u0001\u001a\u00020&2\u0007\u0010\u00ad\u0001\u001a\u00020&H\u0016J\u001c\u0010®\u0001\u001a\u00030\u009e\u00012\u0007\u0010¨\u0001\u001a\u0002022\u0007\u0010©\u0001\u001a\u00020&H\u0016J\u001c\u0010¯\u0001\u001a\u00030\u009e\u00012\u0007\u0010¨\u0001\u001a\u0002022\u0007\u0010©\u0001\u001a\u00020&H\u0016J\n\u0010°\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010±\u0001\u001a\u00030\u009e\u0001H\u0002J\u001d\u0010²\u0001\u001a\u00030\u009e\u00012\u0007\u0010³\u0001\u001a\u00020P2\b\u0010´\u0001\u001a\u00030µ\u0001H\u0002J\u001d\u0010¶\u0001\u001a\u00030\u009e\u00012\u0007\u0010¨\u0001\u001a\u0002022\b\u0010´\u0001\u001a\u00030µ\u0001H\u0002J\u001d\u0010·\u0001\u001a\u00030\u009e\u00012\u0007\u0010¨\u0001\u001a\u0002022\b\u0010´\u0001\u001a\u00030µ\u0001H\u0002J\u001d\u0010¸\u0001\u001a\u00030\u009e\u00012\u0007\u0010¨\u0001\u001a\u0002022\b\u0010´\u0001\u001a\u00030µ\u0001H\u0002J\n\u0010¹\u0001\u001a\u00030\u009e\u0001H\u0002J\u001c\u0010º\u0001\u001a\u00030\u009e\u00012\u0007\u0010¨\u0001\u001a\u0002022\u0007\u0010³\u0001\u001a\u00020PH\u0002J\u0013\u0010»\u0001\u001a\u00030\u009e\u00012\u0007\u0010³\u0001\u001a\u00020PH\u0002J\u0013\u0010¼\u0001\u001a\u00030\u009e\u00012\u0007\u0010³\u0001\u001a\u00020PH\u0002J8\u0010½\u0001\u001a\u00030\u009e\u00012\u0007\u0010³\u0001\u001a\u00020P2\b\u0010´\u0001\u001a\u00030µ\u00012\u0007\u0010¾\u0001\u001a\u00020\u00132\u0007\u0010¿\u0001\u001a\u00020\u00132\u0007\u0010À\u0001\u001a\u00020\rH\u0002J@\u0010Á\u0001\u001a\u00030\u009e\u00012\u0007\u0010Â\u0001\u001a\u00020\u00132\u0007\u0010Ã\u0001\u001a\u00020\u00132\u0007\u0010Ä\u0001\u001a\u00020\u00132\u0007\u0010Å\u0001\u001a\u00020\u00132\u0007\u0010Æ\u0001\u001a\u00020\u00132\u0007\u0010Ç\u0001\u001a\u00020\u0013H\u0016J\b\u0010È\u0001\u001a\u00030\u009e\u0001J\n\u0010É\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030\u009e\u0001H\u0002J\u001b\u0010Ë\u0001\u001a\u00030\u009e\u00012\b\u0010Ì\u0001\u001a\u00030Í\u00012\u0007\u0010Î\u0001\u001a\u00020&J\u001c\u0010Ï\u0001\u001a\u00030\u009e\u00012\u0007\u0010Ð\u0001\u001a\u00020\u00132\u0007\u0010Ñ\u0001\u001a\u00020\u0013H\u0002J\n\u0010Ò\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010Ó\u0001\u001a\u00030\u009e\u0001H\u0002J\u001e\u0010Ô\u0001\u001a\u00030\u009e\u00012\u0007\u0010Õ\u0001\u001a\u00020\u00132\t\u0010Ö\u0001\u001a\u0004\u0018\u00010\u0013H\u0002J\t\u0010×\u0001\u001a\u00020\rH\u0002J\t\u0010Ø\u0001\u001a\u00020\rH\u0002J\t\u0010Ù\u0001\u001a\u00020\u0013H\u0002J'\u0010Ú\u0001\u001a\u00030\u009e\u00012\b\u0010Û\u0001\u001a\u00030Ü\u00012\u0007\u0010Ý\u0001\u001a\u00020\u00132\b\u0010Þ\u0001\u001a\u00030ß\u0001H\u0002J\u001c\u0010à\u0001\u001a\u00030\u009e\u00012\b\u0010á\u0001\u001a\u00030â\u00012\b\u0010ã\u0001\u001a\u00030â\u0001J,\u0010ä\u0001\u001a\u00030\u009e\u00012\u0007\u0010Ý\u0001\u001a\u00020\u00132\b\u0010Þ\u0001\u001a\u00030â\u00012\u000f\u0010å\u0001\u001a\n\u0012\u0005\u0012\u00030\u009e\u00010æ\u0001J0\u0010ç\u0001\u001a\u00030\u009e\u00012\u0007\u0010Ý\u0001\u001a\u00020\u00132\b\u0010Þ\u0001\u001a\u00030â\u00012\u0013\b\u0002\u0010è\u0001\u001a\f\u0012\u0005\u0012\u00030\u009e\u0001\u0018\u00010æ\u0001J\u001e\u0010é\u0001\u001a\u00030\u009e\u00012\b\u0010ê\u0001\u001a\u00030ë\u00012\b\u0010ì\u0001\u001a\u00030í\u0001H\u0002J\n\u0010î\u0001\u001a\u00030\u009e\u0001H\u0002J\u001b\u0010ï\u0001\u001a\u0005\u0018\u00010ð\u00012\u0007\u0010ñ\u0001\u001a\u00020\u0013H\u0002¢\u0006\u0003\u0010ò\u0001J\u001a\u0010ó\u0001\u001a\u0004\u0018\u00010&2\u0007\u0010ñ\u0001\u001a\u00020\u0013H\u0002¢\u0006\u0003\u0010ô\u0001J\u0014\u0010õ\u0001\u001a\u00020\r2\t\u0010¨\u0001\u001a\u0004\u0018\u000102H\u0002J)\u0010ö\u0001\u001a\u00030\u009e\u00012\u0007\u0010¨\u0001\u001a\u0002022\t\b\u0002\u0010÷\u0001\u001a\u00020\r2\t\b\u0002\u0010ø\u0001\u001a\u00020\rH\u0002J\u0012\u0010ù\u0001\u001a\u00020\u00132\u0007\u0010¨\u0001\u001a\u000202H\u0002J\u0012\u0010ú\u0001\u001a\u00020\u00132\u0007\u0010¨\u0001\u001a\u000202H\u0002J\n\u0010û\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010ü\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010ý\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010þ\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010ÿ\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010\u0080\u0002\u001a\u00030\u009e\u0001H\u0002J\n\u0010\u0081\u0002\u001a\u00030\u009e\u0001H\u0002J\u001e\u0010\u0082\u0002\u001a\u00030\u009e\u00012\u0007\u0010\u0083\u0002\u001a\u00020P2\t\b\u0002\u0010÷\u0001\u001a\u00020\rH\u0002J\u001e\u0010\u0084\u0002\u001a\u00030\u009e\u00012\u0007\u0010\u0083\u0002\u001a\u00020P2\t\b\u0002\u0010÷\u0001\u001a\u00020\rH\u0002J\u001a\u0010\u0085\u0002\u001a\u00020&2\u0007\u0010\u0086\u0002\u001a\u00020&2\b\u0010Û\u0001\u001a\u00030Ü\u0001J\u001d\u0010\u0087\u0002\u001a\u00030\u009e\u00012\b\u0010\u0088\u0002\u001a\u00030í\u00012\u0007\u0010\u0089\u0002\u001a\u00020&H\u0002J\n\u0010\u008a\u0002\u001a\u00030\u009e\u0001H\u0002J\n\u0010\u008b\u0002\u001a\u00030\u009e\u0001H\u0002J\n\u0010\u008c\u0002\u001a\u00030\u009e\u0001H\u0002J\u0013\u0010\u008d\u0002\u001a\u00030\u009e\u00012\u0007\u0010Ý\u0001\u001a\u00020\u0013H\u0002J\n\u0010\u008f\u0002\u001a\u00030\u009e\u0001H\u0016J\n\u0010\u0090\u0002\u001a\u00030\u009e\u0001H\u0016J\n\u0010\u0091\u0002\u001a\u00030\u009e\u0001H\u0016J\n\u0010\u0092\u0002\u001a\u00030\u009e\u0001H\u0016J-\u0010\u0093\u0002\u001a\u0004\u0018\u00010_2\b\u0010\u0094\u0002\u001a\u00030\u0095\u00022\n\u0010\u0096\u0002\u001a\u0005\u0018\u00010\u0097\u00022\n\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u0099\u0002H\u0016J\u0016\u0010\u009a\u0002\u001a\u00030\u009e\u00012\n\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u0099\u0002H\u0016J\n\u0010\u009b\u0002\u001a\u00030\u009e\u0001H\u0002J\n\u0010\u009c\u0002\u001a\u00030\u009e\u0001H\u0002J\u0014\u0010\u009d\u0002\u001a\u00030\u009e\u00012\b\u0010\u009e\u0002\u001a\u00030\u009f\u0002H\u0002J\n\u0010 \u0002\u001a\u00030\u009e\u0001H\u0002J\u0013\u0010¡\u0002\u001a\u00030\u009e\u00012\u0007\u0010¢\u0002\u001a\u00020&H\u0002J\n\u0010£\u0002\u001a\u00030\u009e\u0001H\u0002J\u001c\u0010¤\u0002\u001a\u00030\u009e\u00012\u0007\u0010¢\u0002\u001a\u00020&2\u0007\u0010¨\u0001\u001a\u000202H\u0002J\u0013\u0010¥\u0002\u001a\u00030\u009e\u00012\u0007\u0010¨\u0001\u001a\u000202H\u0002J\u001c\u0010¦\u0002\u001a\u00030\u009e\u00012\u0007\u0010§\u0002\u001a\u00020&2\u0007\u0010¨\u0002\u001a\u00020&H\u0002J\u0013\u0010©\u0002\u001a\u00030\u009e\u00012\u0007\u0010ª\u0002\u001a\u00020\rH\u0016J\u001f\u0010«\u0002\u001a\u00030\u009e\u00012\u0007\u0010¬\u0002\u001a\u00020_2\n\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u0099\u0002H\u0016J\n\u0010\u00ad\u0002\u001a\u00030\u009e\u0001H\u0002J(\u0010®\u0002\u001a\u00030¯\u00022\u0007\u0010°\u0002\u001a\u00020_2\u0007\u0010±\u0002\u001a\u00020_2\n\b\u0002\u0010²\u0002\u001a\u00030\u008e\u0001H\u0002J\u0015\u0010³\u0002\u001a\u00030\u009e\u00012\t\u0010´\u0002\u001a\u0004\u0018\u00010\u0013H\u0002J\n\u0010µ\u0002\u001a\u00030\u009e\u0001H\u0002J\u001e\u0010¶\u0002\u001a\u00030·\u00022\b\u0010¸\u0002\u001a\u00030·\u00022\b\u0010¹\u0002\u001a\u00030\u0090\u0001H\u0002J9\u0010º\u0002\u001a\u00030\u009e\u00012\b\u0010Û\u0001\u001a\u00030Ü\u00012\b\u0010¸\u0002\u001a\u00030·\u00022\u0007\u0010»\u0002\u001a\u00020\u00132\u0007\u0010¼\u0002\u001a\u00020\u00132\u0007\u0010½\u0002\u001a\u00020\rH\u0002J\n\u0010¾\u0002\u001a\u00030\u009e\u0001H\u0002J\u001d\u0010¿\u0002\u001a\u00030\u009e\u00012\b\u0010Û\u0001\u001a\u00030Ü\u00012\u0007\u0010À\u0002\u001a\u00020\u0013H\u0002J\u0012\u0010Á\u0002\u001a\u00020\u00132\u0007\u0010Â\u0002\u001a\u00020\u0013H\u0002J&\u0010Ã\u0002\u001a\u00030\u009e\u00012\b\u0010Ä\u0002\u001a\u00030·\u00022\u0007\u0010Â\u0002\u001a\u00020\u00132\u0007\u0010½\u0002\u001a\u00020\rH\u0002J\u0016\u0010Å\u0002\u001a\u0005\u0018\u00010·\u00022\b\u0010Þ\u0001\u001a\u00030â\u0001H\u0002J\n\u0010Æ\u0002\u001a\u00030\u009e\u0001H\u0002J\n\u0010Ç\u0002\u001a\u00030\u009e\u0001H\u0002J\n\u0010È\u0002\u001a\u00030\u009e\u0001H\u0002J\b\u0010É\u0002\u001a\u00030\u009e\u0001J\t\u0010Ê\u0002\u001a\u00020\rH\u0002J&\u0010Ë\u0002\u001a\u00030\u009e\u00012\b\u0010Ì\u0002\u001a\u00030Í\u00022\u0007\u0010Î\u0002\u001a\u00020\u00132\u0007\u0010Ï\u0002\u001a\u00020&H\u0002J\t\u0010Ð\u0002\u001a\u00020\u0013H\u0002J\u0013\u0010Ñ\u0002\u001a\u00030\u009e\u00012\u0007\u0010¬\u0002\u001a\u00020_H\u0002J\n\u0010Ò\u0002\u001a\u00030\u009e\u0001H\u0003J\u0014\u0010Ó\u0002\u001a\u00030\u009e\u00012\b\u0010Ô\u0002\u001a\u00030\u0090\u0001H\u0002J\n\u0010Õ\u0002\u001a\u00030\u009e\u0001H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00108\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b:\u0010;R\u000e\u0010>\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u0002020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010T\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130U01X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\b\u0012\u0004\u0012\u00020&01X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001301X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001301X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001301X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020_X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010a\u001a\b\u0012\u0004\u0012\u00020b01X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u0004\u0018\u00010jX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010l\u001a\b\u0012\u0004\u0012\u00020m01X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020oX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010p\u001a\b\u0012\u0004\u0012\u00020q01X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010r\u001a\b\u0012\u0004\u0012\u00020q01X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010s\u001a\b\u0012\u0004\u0012\u00020t0@X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010u\u001a\n w*\u0004\u0018\u00010v0vX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020yX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020{X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u0004\u0018\u00010}X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010~\u001a\u0004\u0018\u00010\u007fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u008d\u0001\u001a\u00030\u008e\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0091\u0001\u001a\u00030\u0090\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0092\u0001\u001a\u00030\u0090\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0094\u0001\u001a\u00020\rX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R,\u0010\u0098\u0001\u001a\u001f\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0013 w*\u000b\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u009a\u00010\u009a\u00010\u0099\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u009b\u0001\u001a\u0013\u0012\u000e\u0012\f w*\u0005\u0018\u00010\u009c\u00010\u009c\u00010\u0099\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010¦\u0001\u001a\u0013\u0012\u000e\u0012\f w*\u0005\u0018\u00010\u009c\u00010\u009c\u00010\u0099\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u008e\u0002\u001a\u0013\u0012\u000e\u0012\f w*\u0005\u0018\u00010\u009c\u00010\u009c\u00010\u0099\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006×\u0002"}, d2 = {"Lcom/studiolaganne/lengendarylens/ScanFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/CardLanguageClickListener;", "Landroid/hardware/SensorEventListener;", "Lcom/studiolaganne/lengendarylens/OnScannedCardClickListener;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentScanBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentScanBinding;", "offline", "", "scanTutorialActive", "scanPaused", "stopping", "noScanMode", "mtCardJson", "", "hasMTCards", "animatingCards", "scryfallIdToLoad", "enScryfallId", "oracleIdToLoad", "observing", "processing", "cardTapped", "translateCardIfPossible", "displayingCard", "comboMode", "comboForViewing", "Lcom/studiolaganne/lengendarylens/MTCombo;", ScanFragment.PICK_A_CARD_MODE, "scanToDeckMode", ScanFragment.SCAN_TO_DECK_NAME, "scanToListMode", ScanFragment.SCAN_TO_LIST_ID, "", ScanFragment.SCAN_TO_LIST_NAME, ScanFragment.SHOULD_START_CAMERA, "backFromGame", "visible", "currentGroupBy", "currentOrderBy", "currentOrderDirection", "currentNameFilter", "currentScryfallFilter", "currentScanList", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "currentScanListIndex", "scannedCardsAdapter", "Lcom/studiolaganne/lengendarylens/ScannedCardsAdapter;", "sameCardPrompted", "sameCardPromptedCount", "highPriceSoundPool", "Landroid/media/SoundPool;", "getHighPriceSoundPool", "()Landroid/media/SoundPool;", "highPriceSoundPool$delegate", "Lkotlin/Lazy;", "highPriceSoundId", "currentMTCardList", "", "currentCardListIndex", "currentListId", "currentDeckListId", "currentDeck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "currentDeckLists", "Lcom/studiolaganne/lengendarylens/MTDeckLists;", "readOnly", "currentPage", "cardsPerPage", "totalCards", "isLoadingNextPage", "currentMTCard", "currentFace", "currentCardMatch", "Lcom/studiolaganne/lengendarylens/CardMatch;", "nextMTCard", "previousMTCard", "numberOfAnalyzerCallbacks", "detectedTitles", "Lkotlin/Pair;", "detectedCardNumbers", "detectedCardSets", "detectedCardDates", "detectedLanguages", "symbolToImage", "Lcom/studiolaganne/lengendarylens/SymbolToImage;", "popupWindow", "Landroid/widget/PopupWindow;", "popupView", "Landroid/view/View;", "cardLang", "rulings", "Landroid/text/SpannableString;", "prices", "Lcom/studiolaganne/lengendarylens/Prices;", "enPrices", "hasFoil", "hasNonFoil", "isFoil", "editDialog", "Lcom/studiolaganne/lengendarylens/EditCardDialogFragment;", "editDialogShowing", "pricesData", "Lcom/studiolaganne/lengendarylens/CardPriceRow;", "mtgdbHelper", "Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "mtgdbHelpersEnabled", "Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "mtgdbHelpers", "cardSets", "Lcom/studiolaganne/lengendarylens/CardSet;", "backgroundExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "handlerThread", "Landroid/os/HandlerThread;", "backgroundHandler", "Landroid/os/Handler;", "combinedAnalyzer", "Lcom/studiolaganne/lengendarylens/CombinedAnalyzer;", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "camera", "Landroidx/camera/core/Camera;", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "tapGestureDetector", "Landroid/view/GestureDetector;", "zoomIndicatorHandler", "zoomIndicatorRunnable", "Ljava/lang/Runnable;", "sensorManager", "Landroid/hardware/SensorManager;", "accelerometer", "Landroid/hardware/Sensor;", "lastUpdate", "", "last_x", "", "last_y", "last_z", "shakeThreshold", "isDeviceStable", "()Z", "setDeviceStable", "(Z)V", "requestPermissionsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "purchaseLauncher", "Landroid/content/Intent;", "onSensorChanged", "", NotificationCompat.CATEGORY_EVENT, "Landroid/hardware/SensorEvent;", "onAccuracyChanged", "sensor", "accuracy", "onStop", "onStart", "searchActivityLauncher", "onScannedCardClick", "card", FirebaseAnalytics.Param.INDEX, "onScannedCardDeleteClick", "onScannedCardEditClick", "onScannedCardQuantityChanged", "newQuantity", "onScannedCardFinishToggled", "onScannedCardCollectionTapped", "initializeScannedCardAdapter", "updateScanSettingsOverrideIndicator", "applyLanguageAndSetOverrides", "match", "prefs", "Lcom/studiolaganne/lengendarylens/PreferencesManager;", "applyFinishOverride", "applyPurchasePriceOverride", "playHighPriceSoundIfNeeded", "updateCardCountAndTotalPrice", "addFinalScannedCard", "addScannedCardWithLocalData", "addScannedCardMatch", "fetchCardWithParameters", "originalLang", "originalSet", "isRetry", "onCardLanguageClick", "newScId", "oracleId", Constants.GP_IAP_TITLE, "language", "typeLine", "oracle", "showInternetError", "showInternetAlert", "resetCapture", "adjustTextViewHeight", "textView", "Landroid/widget/TextView;", "numLines", "handleKeywordTap", "keyword", "lang", "noRulings", "fetchRulings", "addMaybeLegalityButton", "format", "legality", "isLegendaryCreature", "isAftermath", "currentCardNameToEDHREC", "loadSvgImage", "context", "Landroid/content/Context;", "url", "imageView", "Landroid/widget/ImageView;", "replaceCardImage", "toImageView", "Lcom/studiolaganne/lengendarylens/LoadingImageView;", "fromImageView", "loadCardImageWithCallback", "callback", "Lkotlin/Function0;", "loadCardImage", "onImageReady", "updatePricesRecyclerView", "pricesRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "overlay", "Landroidx/constraintlayout/widget/ConstraintLayout;", "updatePricesUI", "zoneToIconChar", "", "zone", "(Ljava/lang/String;)Ljava/lang/Character;", "zoneToLabelRes", "(Ljava/lang/String;)Ljava/lang/Integer;", "isComboCardMissing", "displayMTCard", "sceneAlreadyExists", "ignoreCardImage", "getMTCardImageURL", "getBackFaceMTCardImageURL", "resetSplitCardRotation", "resetToFrontFace", "applySplitCardRotationIfNeeded", "moveToNextCard", "moveToPreviousCard", "fetchPreviousCard", "fetchNextCard", "fetchCardOffline", "cardMatch", "fetchCard", "dpToPx", "dp", "animateMarginTop", WindowExtensionsConstants.LAYOUT_PACKAGE, "screenHeight", "animateCardFlip", "showScanTutorial", "updateFaceInformation", "openWebActivity", "allPrintsActivityLauncher", "onDestroy", "onResume", "onPause", "onDetach", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "startCameraCapture", "stopCameraCapture", "updateCardListFromNewContainer", "list", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "loadNextPageOfCards", "addScanListToContainer", "containerId", "clearCurrentScanListAndUI", "addCardToContainer", "showAddCardContainerSelection", "moveCardToContainer", "destinationId", "applyToQTy", "onHiddenChanged", "hidden", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "updateNextPrevious", "createMoveAndScaleAnimation", "Landroid/animation/AnimatorSet;", "fromView", "toView", TypedValues.TransitionType.S_DURATION, "showScannerUnavailableError", "error", "onBack", "getRoundedCornerBitmap", "Landroid/graphics/Bitmap;", "bitmap", "cornerRadius", "saveImageToPicturesFolder", "folderName", "fileName", "isAlpha", "showFileSavedMessage", "showFileError", "message", "sanitizeFileName", "cardName", "shareImage", MimeTypes.BASE_TYPE_IMAGE, "getBitmapFromImageView", "playProgressAnimation", "removeProgressAnimation", "playCheckmarkAnimation", "removeCheckmarkAnimation", "allPermissionsGranted", "setFontAwesomeIconAndText", "button", "Landroid/widget/Button;", "iconCode", "labelTextId", "getCurrentDateString", "triggerTapToFocus", "setupCameraGestures", "showZoomIndicator", "zoomRatio", "startCamera", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScanFragment extends Fragment implements CardLanguageClickListener, SensorEventListener, OnScannedCardClickListener {
    private static final boolean DebugUI = false;
    private static final String PICK_A_CARD_MODE = "pickACardMode";
    private static final String[] REQUIRED_PERMISSIONS;
    private static final String SCAN_TO_DECK_MODE = "scanToDeck";
    private static final String SCAN_TO_DECK_NAME = "scanToDeckName";
    private static final String SCAN_TO_LIST_ID = "scanToListId";
    private static final String SCAN_TO_LIST_MODE = "scanToList";
    private static final String SCAN_TO_LIST_NAME = "scanToListName";
    private static final String SHOULD_START_CAMERA = "shouldStartCamera";
    private static final String TAG = "ScanFragment";
    private FragmentScanBinding _binding;
    private Sensor accelerometer;
    private final ActivityResultLauncher<Intent> allPrintsActivityLauncher;
    private boolean animatingCards;
    private boolean backFromGame;
    private final Handler backgroundHandler;
    private Camera camera;
    private ProcessCameraProvider cameraProvider;
    private List<CardSet> cardSets;
    private boolean cardTapped;
    private CombinedAnalyzer combinedAnalyzer;
    private MTCombo comboForViewing;
    private boolean comboMode;
    private int currentCardListIndex;
    private CardMatch currentCardMatch;
    private MTDeck currentDeck;
    private MTDeckLists currentDeckLists;
    private int currentFace;
    private String currentGroupBy;
    private MTFullCard currentMTCard;
    private String currentNameFilter;
    private int currentScanListIndex;
    private String currentScryfallFilter;
    private boolean displayingCard;
    private EditCardDialogFragment editDialog;
    private boolean editDialogShowing;
    private Prices enPrices;
    private final HandlerThread handlerThread;
    private boolean hasFoil;
    private boolean hasMTCards;
    private int highPriceSoundId;
    private boolean isDeviceStable;
    private boolean isFoil;
    private boolean isLoadingNextPage;
    private long lastUpdate;
    private float last_x;
    private float last_y;
    private float last_z;
    private MTGDBHelper mtgdbHelper;
    private List<MTGDBHelperLocalized> mtgdbHelpers;
    private List<MTGDBHelperLocalized> mtgdbHelpersEnabled;
    private MTFullCard nextMTCard;
    private boolean noScanMode;
    private int numberOfAnalyzerCallbacks;
    private boolean offline;
    private boolean pickACardMode;
    private View popupView;
    private PopupWindow popupWindow;
    private MTFullCard previousMTCard;
    private Prices prices;
    private boolean processing;
    private final ActivityResultLauncher<Intent> purchaseLauncher;
    private boolean readOnly;
    private final ActivityResultLauncher<String[]> requestPermissionsLauncher;
    private boolean sameCardPrompted;
    private int sameCardPromptedCount;
    private ScaleGestureDetector scaleGestureDetector;
    private boolean scanPaused;
    private boolean scanToDeckMode;
    private boolean scanToListMode;
    private boolean scanTutorialActive;
    private ScannedCardsAdapter scannedCardsAdapter;
    private final ActivityResultLauncher<Intent> searchActivityLauncher;
    private SensorManager sensorManager;
    private int shakeThreshold;
    private boolean shouldStartCamera;
    private boolean stopping;
    private SymbolToImage symbolToImage;
    private GestureDetector tapGestureDetector;
    private int totalCards;
    private Handler zoomIndicatorHandler;
    private Runnable zoomIndicatorRunnable;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private String mtCardJson = "";
    private String scryfallIdToLoad = "";
    private String enScryfallId = "";
    private String oracleIdToLoad = "";
    private boolean observing = true;
    private boolean translateCardIfPossible = true;
    private String scanToDeckName = "Deck";
    private int scanToListId = -1;
    private String scanToListName = "List";
    private boolean visible = true;
    private String currentOrderBy = "name";
    private String currentOrderDirection = "asc";
    private List<MTFullCard> currentScanList = new ArrayList();

    /* JADX INFO: renamed from: highPriceSoundPool$delegate, reason: from kotlin metadata */
    private final Lazy highPriceSoundPool = LazyKt.lazy(new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda156
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(13).setContentType(4).build()).build();
        }
    });
    private List<MTFullCard> currentMTCardList = new ArrayList();
    private int currentListId = -1;
    private int currentDeckListId = -1;
    private int currentPage = 1;
    private int cardsPerPage = 100;
    private List<Pair<String, String>> detectedTitles = new ArrayList();
    private List<Integer> detectedCardNumbers = new ArrayList();
    private List<String> detectedCardSets = new ArrayList();
    private List<String> detectedCardDates = new ArrayList();
    private List<String> detectedLanguages = new ArrayList();
    private String cardLang = "en";
    private List<SpannableString> rulings = new ArrayList();
    private boolean hasNonFoil = true;
    private List<CardPriceRow> pricesData = CollectionsKt.mutableListOf(new CardPriceRow(1, null, null, null, null, null, null, null, null, 510, null), new CardPriceRow(2, null, null, null, null, null, null, null, null, 510, null), new CardPriceRow(3, null, null, null, null, null, null, null, null, 510, null));
    private final ExecutorService backgroundExecutor = Executors.newFixedThreadPool(4);

    /* JADX INFO: compiled from: ScanFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/ScanFragment$Companion;", "", "<init>", "()V", "PICK_A_CARD_MODE", "", "SHOULD_START_CAMERA", "SCAN_TO_DECK_MODE", "SCAN_TO_DECK_NAME", "SCAN_TO_LIST_MODE", "SCAN_TO_LIST_ID", "SCAN_TO_LIST_NAME", "newInstance", "Lcom/studiolaganne/lengendarylens/ScanFragment;", ScanFragment.PICK_A_CARD_MODE, "", ScanFragment.SHOULD_START_CAMERA, "newScanToDeckInstance", "deckName", "newScanToListInstance", "listId", "", "listName", "DebugUI", "TAG", "REQUIRED_PERMISSIONS", "", "[Ljava/lang/String;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ScanFragment newInstance$default(Companion companion, boolean z, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            return companion.newInstance(z, z2);
        }

        public final ScanFragment newInstance(boolean pickACardMode, boolean shouldStartCamera) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(ScanFragment.PICK_A_CARD_MODE, pickACardMode);
            bundle.putBoolean(ScanFragment.SHOULD_START_CAMERA, shouldStartCamera);
            ScanFragment scanFragment = new ScanFragment();
            scanFragment.setArguments(bundle);
            return scanFragment;
        }

        public final ScanFragment newScanToDeckInstance(String deckName) {
            Intrinsics.checkNotNullParameter(deckName, "deckName");
            Bundle bundle = new Bundle();
            bundle.putBoolean(ScanFragment.SCAN_TO_DECK_MODE, true);
            bundle.putString(ScanFragment.SCAN_TO_DECK_NAME, deckName);
            bundle.putBoolean(ScanFragment.SHOULD_START_CAMERA, true);
            ScanFragment scanFragment = new ScanFragment();
            scanFragment.setArguments(bundle);
            return scanFragment;
        }

        public final ScanFragment newScanToListInstance(int listId, String listName) {
            Intrinsics.checkNotNullParameter(listName, "listName");
            Bundle bundle = new Bundle();
            bundle.putBoolean(ScanFragment.SCAN_TO_LIST_MODE, true);
            bundle.putInt(ScanFragment.SCAN_TO_LIST_ID, listId);
            bundle.putString(ScanFragment.SCAN_TO_LIST_NAME, listName);
            bundle.putBoolean(ScanFragment.SHOULD_START_CAMERA, true);
            ScanFragment scanFragment = new ScanFragment();
            scanFragment.setArguments(bundle);
            return scanFragment;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.ScanFragment$addScanListToContainer$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScanFragment.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/ScanFragment$addScanListToContainer$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTCardListResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 implements Callback<MTCardListResponse> {
        final /* synthetic */ int $containerId;

        AnonymousClass1(int i) {
            this.$containerId = i;
        }

        static final Unit onResponse$lambda$0(ScanFragment scanFragment, PreferencesManager preferencesManager, boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            if (scanFragment.getContext() == null || scanFragment.isDetached()) {
                return Unit.INSTANCE;
            }
            dialog.dismiss();
            preferencesManager.setClearScanListAfterAdd(z);
            if (z) {
                scanFragment.clearCurrentScanListAndUI();
            }
            return Unit.INSTANCE;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<MTCardListResponse> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            ScanFragment.this.getBinding().loadingOverlay.setVisibility(8);
            Toast.makeText(ScanFragment.this.requireContext(), R.string.add_cards_to_list_error, 0).show();
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (ScanFragment.this.getContext() == null || ScanFragment.this.getActivity() == null || ScanFragment.this._binding == null) {
                return;
            }
            ScanFragment.this.getBinding().loadingOverlay.setVisibility(8);
            Context contextRequireContext = ScanFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            preferencesManager.incrementCollectionVersion();
            preferencesManager.incrementListsVersion();
            CardContainerCache.INSTANCE.invalidate(this.$containerId);
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = ScanFragment.this.getString(R.string.success_add_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = ScanFragment.this.getString(R.string.add_cards_to_list_success);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder checkBoxDefaultChecked = title.setBody(string2).setShowRestoreCheckBox(true).setCheckBoxLabel(ScanFragment.this.getString(R.string.clear_scan_list_after_add_label)).setCheckBoxDefaultChecked(preferencesManager.getClearScanListAfterAdd());
            String string3 = ScanFragment.this.getString(R.string.close);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            final ScanFragment scanFragment = ScanFragment.this;
            CustomDialogFragment.Builder positiveButton = checkBoxDefaultChecked.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ScanFragment$addScanListToContainer$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScanFragment.AnonymousClass1.onResponse$lambda$0(scanFragment, preferencesManager, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager childFragmentManager = ScanFragment.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            positiveButton.show(childFragmentManager, "AddToListSuccessDialog");
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.ScanFragment$addScannedCardWithLocalData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScanFragment.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/ScanFragment$addScannedCardWithLocalData$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/Card;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C12301 implements Callback<Card> {
        final /* synthetic */ CardMatch $match;
        final /* synthetic */ MTFullCard $newCard;

        C12301(CardMatch cardMatch, MTFullCard mTFullCard) {
            this.$match = cardMatch;
            this.$newCard = mTFullCard;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<Card> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            if (ScanFragment.this.getActivity() == null) {
                return;
            }
            FragmentActivity fragmentActivityRequireActivity = ScanFragment.this.requireActivity();
            final ScanFragment scanFragment = ScanFragment.this;
            final MTFullCard mTFullCard = this.$newCard;
            final CardMatch cardMatch = this.$match;
            fragmentActivityRequireActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$addScannedCardWithLocalData$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    scanFragment.addFinalScannedCard(mTFullCard, cardMatch);
                }
            });
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<Card> call, Response<Card> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (ScanFragment.this.getActivity() == null) {
                return;
            }
            if (!response.isSuccessful()) {
                FragmentActivity fragmentActivityRequireActivity = ScanFragment.this.requireActivity();
                final ScanFragment scanFragment = ScanFragment.this;
                final MTFullCard mTFullCard = this.$newCard;
                final CardMatch cardMatch = this.$match;
                fragmentActivityRequireActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$addScannedCardWithLocalData$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        scanFragment.addFinalScannedCard(mTFullCard, cardMatch);
                    }
                });
                return;
            }
            Card cardBody = response.body();
            final ScanFragment scanFragment2 = ScanFragment.this;
            if (cardBody != null) {
                scanFragment2.addFinalScannedCard(GameUtils.INSTANCE.getInstance().convertScryFallCard(cardBody), this.$match);
            } else {
                final MTFullCard mTFullCard2 = this.$newCard;
                final CardMatch cardMatch2 = this.$match;
                scanFragment2.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$addScannedCardWithLocalData$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScanFragment.access$addFinalScannedCard(scanFragment2, mTFullCard2, cardMatch2);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.ScanFragment$fetchCardOffline$2, reason: invalid class name */
    /* JADX INFO: compiled from: ScanFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.ScanFragment$fetchCardOffline$2", f = "ScanFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MTFullCard $result;
        final /* synthetic */ boolean $sceneAlreadyExists;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MTFullCard mTFullCard, boolean z, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$result = mTFullCard;
            this.$sceneAlreadyExists = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ScanFragment.this.new AnonymousClass2(this.$result, this.$sceneAlreadyExists, continuation);
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
            if (!ScanFragment.this.isAdded()) {
                return Unit.INSTANCE;
            }
            ScanFragment.displayMTCard$default(ScanFragment.this, this.$result, this.$sceneAlreadyExists, false, 4, null);
            ScanFragment.this.noRulings();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.ScanFragment$fetchCardWithParameters$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScanFragment.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/ScanFragment$fetchCardWithParameters$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTFullCardResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C12321 implements Callback<MTFullCardResponse> {
        final /* synthetic */ boolean $isRetry;
        final /* synthetic */ CardMatch $match;
        final /* synthetic */ String $originalLang;
        final /* synthetic */ String $originalSet;
        final /* synthetic */ PreferencesManager $prefs;

        C12321(CardMatch cardMatch, boolean z, PreferencesManager preferencesManager, String str, String str2) {
            this.$match = cardMatch;
            this.$isRetry = z;
            this.$prefs = preferencesManager;
            this.$originalLang = str;
            this.$originalSet = str2;
        }

        static final void onFailure$lambda$2(ScanFragment scanFragment, CardMatch cardMatch) {
            Toast.makeText(scanFragment.requireContext(), scanFragment.getString(R.string.offline_add), 1).show();
            scanFragment.addScannedCardWithLocalData(cardMatch);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onResponse$lambda$1$0(ScanFragment scanFragment) {
            Toast.makeText(scanFragment.requireContext(), scanFragment.getString(R.string.card_not_found_with_overrides_retrying), 1).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onResponse$lambda$1$1(ScanFragment scanFragment, CardMatch cardMatch) {
            Toast.makeText(scanFragment.requireContext(), scanFragment.getString(R.string.unable_to_add_card), 1).show();
            scanFragment.addScannedCardWithLocalData(cardMatch);
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<MTFullCardResponse> call, Throwable t) {
            FragmentActivity activity;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            if (ScanFragment.this.getContext() == null || ScanFragment.this._binding == null || (activity = ScanFragment.this.getActivity()) == null) {
                return;
            }
            final ScanFragment scanFragment = ScanFragment.this;
            final CardMatch cardMatch = this.$match;
            activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$fetchCardWithParameters$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ScanFragment.C12321.onFailure$lambda$2(scanFragment, cardMatch);
                }
            });
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0090  */
        @Override // retrofit2.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResponse(Call<MTFullCardResponse> call, Response<MTFullCardResponse> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (ScanFragment.this.getActivity() == null) {
                return;
            }
            MTFullCardResponse mTFullCardResponseBody = response.body();
            MTFullCard card = mTFullCardResponseBody != null ? mTFullCardResponseBody.getCard() : null;
            if (card != null) {
                ScanFragment.this.addFinalScannedCard(card, this.$match);
                return;
            }
            boolean z = this.$isRetry;
            PreferencesManager preferencesManager = this.$prefs;
            final ScanFragment scanFragment = ScanFragment.this;
            final CardMatch cardMatch = this.$match;
            String str = this.$originalLang;
            String str2 = this.$originalSet;
            if (z) {
                FragmentActivity activity = scanFragment.getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$fetchCardWithParameters$1$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            ScanFragment.C12321.onResponse$lambda$1$1(scanFragment, cardMatch);
                        }
                    });
                    return;
                }
                return;
            }
            MTUserSettings mTUserSettings = preferencesManager.getMTUserSettings();
            boolean zAreEqual = Intrinsics.areEqual((Object) mTUserSettings.getScan_override_language_enabled(), (Object) true);
            boolean zAreEqual2 = Intrinsics.areEqual((Object) mTUserSettings.getScan_override_set_enabled(), (Object) true);
            if (zAreEqual || zAreEqual2) {
                scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$fetchCardWithParameters$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScanFragment.C12321.onResponse$lambda$1$0(scanFragment);
                    }
                });
                cardMatch.setLang(str);
                cardMatch.setSet(str2);
                scanFragment.fetchCardWithParameters(cardMatch, preferencesManager, str, str2, true);
                return;
            }
            cardMatch.setLang("en");
            String lowerCase = cardMatch.getSet().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!Intrinsics.areEqual(lowerCase, "soa")) {
                String lowerCase2 = cardMatch.getSet().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase2, "sta")) {
                    cardMatch.setLang("ja");
                }
            }
            scanFragment.fetchCardWithParameters(cardMatch, preferencesManager, str, str2, true);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.ScanFragment$noRulings$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScanFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.ScanFragment$noRulings$1", f = "ScanFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C12351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C12351(Continuation<? super C12351> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ScanFragment.this.new C12351(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!ScanFragment.this.isAdded()) {
                return Unit.INSTANCE;
            }
            LinearLayout detailsRulingLayout = ScanFragment.this.getBinding().detailsRulingLayout;
            Intrinsics.checkNotNullExpressionValue(detailsRulingLayout, "detailsRulingLayout");
            detailsRulingLayout.removeAllViews();
            for (SpannableString spannableString : ScanFragment.this.rulings) {
                View viewInflate = ScanFragment.this.getLayoutInflater().inflate(R.layout.ruling_item, (ViewGroup) detailsRulingLayout, false);
                ((TextView) viewInflate.findViewById(R.id.rulingTextView)).setText(spannableString);
                detailsRulingLayout.addView(viewInflate);
            }
            return Unit.INSTANCE;
        }
    }

    static {
        List listMutableListOf = CollectionsKt.mutableListOf("android.permission.CAMERA");
        if (Build.VERSION.SDK_INT <= 28) {
            listMutableListOf.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        REQUIRED_PERMISSIONS = (String[]) listMutableListOf.toArray(new String[0]);
    }

    public ScanFragment() {
        HandlerThread handlerThread = new HandlerThread("BackgroundHandlerThread");
        handlerThread.start();
        this.handlerThread = handlerThread;
        this.backgroundHandler = new Handler(handlerThread.getLooper());
        this.shakeThreshold = 45;
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda157
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ScanFragment.requestPermissionsLauncher$lambda$0(this.f$0, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.requestPermissionsLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda158
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ScanFragment.purchaseLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.purchaseLauncher = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda159
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ScanFragment.searchActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(...)");
        this.searchActivityLauncher = activityResultLauncherRegisterForActivityResult3;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda160
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ScanFragment.allPrintsActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult4, "registerForActivityResult(...)");
        this.allPrintsActivityLauncher = activityResultLauncherRegisterForActivityResult4;
    }

    public static final /* synthetic */ void access$addFinalScannedCard(ScanFragment scanFragment, MTFullCard mTFullCard, CardMatch cardMatch) {
        scanFragment.addFinalScannedCard(mTFullCard, cardMatch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addCardToContainer(final int containerId, final MTFullCard card) {
        if (getActivity() == null || getContext() == null) {
            return;
        }
        EditCardDialogFragment editCardDialogFragmentBuild = new EditCardDialogFragment.Builder().setCard(card).setAddMode(true).setShowPurchasePrice(this.currentDeckListId == -1).setAllPrintsLauncher(this.allPrintsActivityLauncher).setOnDismissListener(new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda121
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.addCardToContainer$lambda$0(this.f$0);
            }
        }).setOnEditClickedListener(new Function12() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda122
            @Override // kotlin.jvm.functions.Function12
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
                return ScanFragment.addCardToContainer$lambda$1(this.f$0, card, containerId, (Integer) obj, (Integer) obj2, (String) obj3, (String) obj4, (String) obj5, (MTFullCard) obj6, (Boolean) obj7, (Boolean) obj8, (Boolean) obj9, (Boolean) obj10, (Integer) obj11, (Double) obj12);
            }
        }).build();
        this.editDialogShowing = true;
        this.editDialog = editCardDialogFragmentBuild;
        editCardDialogFragmentBuild.show(getChildFragmentManager(), "edit_card_dialog");
    }

    static final Unit addCardToContainer$lambda$0(ScanFragment scanFragment) {
        scanFragment.editDialogShowing = false;
        return Unit.INSTANCE;
    }

    static final Unit addCardToContainer$lambda$1(final ScanFragment scanFragment, MTFullCard mTFullCard, int i, Integer num, Integer num2, String str, String str2, String str3, MTFullCard mTFullCard2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Integer num3, Double d) {
        String cardid;
        String set_code;
        String collector_number;
        String condition;
        Boolean altered;
        Boolean signed;
        Boolean missprint;
        Boolean proxy;
        if (scanFragment.getActivity() == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        if (scanFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        scanFragment.editDialogShowing = false;
        int iIntValue = num != null ? num.intValue() : 1;
        MTEditCardBody mTEditCardBody = new MTEditCardBody(null, 1, null);
        mTEditCardBody.setCards(new MTEditCardActions(null, null, null, 7, null));
        if (iIntValue >= 1) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < iIntValue; i2++) {
                MTFullCard mTFullCard3 = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                if (mTFullCard2 == null || (cardid = mTFullCard2.getCardid()) == null) {
                    cardid = mTFullCard.getCardid();
                }
                mTFullCard3.setCardid(cardid);
                mTFullCard3.setScryfallid(null);
                if (mTFullCard2 == null || (set_code = mTFullCard2.getSet_code()) == null) {
                    set_code = mTFullCard.getSet_code();
                }
                mTFullCard3.setSet_code(set_code);
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
                mTFullCard3.setPurchase_price(d);
                arrayList.add(mTFullCard3);
            }
            MTEditCardActions cards = mTEditCardBody.getCards();
            if (cards != null) {
                cards.setAdded(arrayList);
            }
            Context contextRequireContext = scanFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            MTUser currentUser = preferencesManager.getCurrentUser();
            if (currentUser != null) {
                scanFragment.getBinding().loadingOverlay.setVisibility(0);
                MTApiKt.getMtApi().editCardsFromList(currentUser.getId(), i, scanFragment.currentNameFilter, scanFragment.currentScryfallFilter, null, scanFragment.currentOrderBy, scanFragment.currentOrderDirection, true, null, null, null, mTEditCardBody).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.ScanFragment$addCardToContainer$dialog$2$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        Log.e("BrowseListFragment", "Failed to add MT Card: " + t.getMessage());
                        this.this$0.getBinding().loadingOverlay.setVisibility(8);
                        Toast.makeText(this.this$0.requireContext(), R.string.error_adding_card, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (this.this$0.getActivity() == null || this.this$0.getContext() == null) {
                            return;
                        }
                        if (!response.isSuccessful()) {
                            this.this$0.getBinding().loadingOverlay.setVisibility(8);
                            Toast.makeText(this.this$0.requireContext(), R.string.error_adding_card, 0).show();
                            return;
                        }
                        MTCardListResponse mTCardListResponseBody = response.body();
                        MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                        if (list != null) {
                            ScanFragment scanFragment2 = this.this$0;
                            PreferencesManager preferencesManager2 = preferencesManager;
                            CardContainerCache.INSTANCE.setCachedContainer(list, new CacheKey(list.getId(), scanFragment2.currentOrderBy, scanFragment2.currentOrderDirection, scanFragment2.currentGroupBy, scanFragment2.currentNameFilter, scanFragment2.currentScryfallFilter, scanFragment2.currentPage));
                            preferencesManager2.incrementContainerVersion(list.getId());
                            preferencesManager2.incrementCollectionVersion();
                            preferencesManager2.incrementListsVersion();
                            Toast.makeText(scanFragment2.requireContext(), R.string.card_added_successfully, 0).show();
                        }
                        this.this$0.getBinding().loadingOverlay.setVisibility(8);
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addFinalScannedCard(MTFullCard card, CardMatch match) {
        if (getContext() == null || getActivity() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        applyFinishOverride(card, preferencesManager);
        applyPurchasePriceOverride(card, preferencesManager);
        if (this.currentScanList.isEmpty() && !preferencesManager.getBoolean(PreferencesManager.SCAN_TUTORIAL_DONE, false)) {
            showScanTutorial();
            preferencesManager.setBoolean(PreferencesManager.SCAN_TUTORIAL_DONE, true);
        }
        this.currentScanList.add(card);
        if (this.scanToDeckMode) {
            preferencesManager.saveCurrentDeckScanList(this.currentScanList);
        } else if (this.scanToListMode) {
            preferencesManager.saveCurrentListScanList(this.scanToListId, this.currentScanList);
        } else {
            preferencesManager.saveCurrentUserScanList(this.currentScanList);
        }
        final RecyclerView scanListRecyclerView = getBinding().scanListRecyclerView;
        Intrinsics.checkNotNullExpressionValue(scanListRecyclerView, "scanListRecyclerView");
        ScannedCardsAdapter scannedCardsAdapter = this.scannedCardsAdapter;
        if (scannedCardsAdapter != null) {
            scannedCardsAdapter.addCard(card);
        }
        scanListRecyclerView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.addFinalScannedCard$lambda$0(this.f$0, scanListRecyclerView);
            }
        }, 200L);
        getBinding().scanListTopLayout.setVisibility(0);
        getBinding().addToButton.setVisibility(0);
        getBinding().scanListBottomLayout.setVisibility(0);
        playHighPriceSoundIfNeeded(card, preferencesManager);
        updateCardCountAndTotalPrice();
        updateScanSettingsOverrideIndicator();
    }

    static final void addFinalScannedCard$lambda$0(ScanFragment scanFragment, RecyclerView recyclerView) {
        ScannedCardsAdapter scannedCardsAdapter = scanFragment.scannedCardsAdapter;
        int itemCount = scannedCardsAdapter != null ? scannedCardsAdapter.getItemCount() : 0;
        if (itemCount > 0) {
            recyclerView.smoothScrollToPosition(itemCount - 1);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addMaybeLegalityButton(String format, String legality) {
        GridLayout legalityGridLayout = getBinding().legalityGridLayout;
        Intrinsics.checkNotNullExpressionValue(legalityGridLayout, "legalityGridLayout");
        View viewInflate = getLayoutInflater().inflate(R.layout.legality_item, (ViewGroup) legalityGridLayout, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.formatTextView);
        Button button = (Button) viewInflate.findViewById(R.id.legalityButton);
        textView.setText(format);
        if (legality == null) {
            button.setText(getResources().getString(R.string.not_legal));
            button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.not_legal_color));
            legalityGridLayout.addView(viewInflate);
            return;
        }
        switch (legality.hashCode()) {
            case -1396343010:
                if (!legality.equals("banned")) {
                    button.setText(getResources().getString(R.string.na));
                    button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.na_color));
                } else {
                    button.setText(getResources().getString(R.string.banned));
                    button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.banned_color));
                }
                break;
            case -1297282981:
                if (legality.equals("restricted")) {
                    button.setText(getResources().getString(R.string.restricted));
                    button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.restricted_color));
                    break;
                }
                break;
            case 102851257:
                if (legality.equals("legal")) {
                    button.setText(getResources().getString(R.string.legal));
                    button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.legal_color));
                    break;
                }
                break;
            case 1620756045:
                if (legality.equals("not_legal")) {
                    button.setText(getResources().getString(R.string.not_legal));
                    button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.not_legal_color));
                    break;
                }
                break;
        }
        legalityGridLayout.addView(viewInflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addScanListToContainer(int containerId) {
        if (getActivity() == null || getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser == null) {
            return;
        }
        getBinding().loadingOverlay.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        for (MTFullCard mTFullCard : this.currentScanList) {
            MTFullCard mTFullCard2 = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
            int quantity = mTFullCard.getQuantity();
            if (quantity == null) {
                quantity = 1;
            }
            mTFullCard2.setQuantity(quantity);
            mTFullCard2.setSet_code(mTFullCard.getSet_code());
            mTFullCard2.setCollector_number(mTFullCard.getCollector_number());
            mTFullCard2.setLang(mTFullCard.getLang());
            mTFullCard2.setFinish(mTFullCard.getFinish());
            mTFullCard2.setCondition(mTFullCard.getCondition());
            mTFullCard2.setAltered(mTFullCard.getAltered());
            mTFullCard2.setSigned(mTFullCard.getSigned());
            mTFullCard2.setMissprint(mTFullCard.getMissprint());
            mTFullCard2.setPurchase_price(mTFullCard.getPurchase_price());
            List<String> finishes = mTFullCard.getFinishes();
            if (finishes == null) {
                finishes = CollectionsKt.emptyList();
            }
            if (finishes.size() == 1) {
                String str = finishes.get(0);
                if (Intrinsics.areEqual(str, "foil") || Intrinsics.areEqual(str, "etched")) {
                    mTFullCard2.setFinish(str);
                }
            }
            arrayList.add(mTFullCard2);
        }
        MTApiKt.getMtApi().addCardsToList(currentUser.getId(), containerId, null, null, null, null, null, null, new MTCardListBody(arrayList)).enqueue(new AnonymousClass1(containerId));
    }

    private final void addScannedCardMatch(final CardMatch match) {
        if (getActivity() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (this.offline) {
            applyLanguageAndSetOverrides(match, preferencesManager);
            requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda54
                @Override // java.lang.Runnable
                public final void run() {
                    ScanFragment.addScannedCardMatch$lambda$0(this.f$0, match);
                }
            });
        } else {
            String lang = match.getLang();
            String set = match.getSet();
            applyLanguageAndSetOverrides(match, preferencesManager);
            fetchCardWithParameters(match, preferencesManager, lang, set, false);
        }
    }

    static final void addScannedCardMatch$lambda$0(ScanFragment scanFragment, CardMatch cardMatch) {
        Toast.makeText(scanFragment.requireContext(), scanFragment.getString(R.string.offline_add), 1).show();
        scanFragment.addScannedCardWithLocalData(cardMatch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addScannedCardWithLocalData(CardMatch match) {
        MTFullCard mTFullCard = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
        mTFullCard.setScryfallid(match.getScryfallId());
        mTFullCard.setOracleid(match.getOracleId());
        mTFullCard.setLang(match.getLang());
        mTFullCard.setSet_code(match.getSet());
        mTFullCard.setCollector_number(match.getNumber());
        if (this.offline) {
            addFinalScannedCard(mTFullCard, match);
            return;
        }
        if (CombinedAnalyzerKt.getDEBUG_LOG()) {
            Log.d(TAG, "----> addScannedCardWithLocalData - Fetching card from ScryFall");
        }
        ScryFallApiKt.getApi().getCardById(match.getScryfallId()).enqueue(new C12301(match, mTFullCard));
    }

    private final boolean allPermissionsGranted() {
        for (String str : REQUIRED_PERMISSIONS) {
            if (getContext() == null || ContextCompat.checkSelfPermission(requireContext(), str) != 0) {
                return false;
            }
        }
        return true;
    }

    static final void allPrintsActivityLauncher$lambda$0(final ScanFragment scanFragment, ActivityResult result) {
        final MTFullCard mTFullCard;
        MTFullCard mTFullCard2;
        MTFullCard mTFullCard3;
        Intrinsics.checkNotNullParameter(result, "result");
        if (scanFragment.getContext() == null || scanFragment.getActivity() == null) {
            return;
        }
        if (scanFragment.comboMode) {
            Intent data = result.getData();
            String stringExtra = data != null ? data.getStringExtra("newCardJson") : null;
            if (stringExtra == null || (mTFullCard3 = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class)) == null) {
                return;
            }
            scanFragment.currentMTCard = mTFullCard3;
            displayMTCard$default(scanFragment, mTFullCard3, true, false, 4, null);
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
            return;
        }
        Intent data2 = result.getData();
        if ((data2 != null ? data2.getStringExtra("newCardId") : null) != null) {
            if (scanFragment.getActivity() != null) {
                if (scanFragment.editDialogShowing) {
                    Intent data3 = result.getData();
                    String stringExtra2 = data3 != null ? data3.getStringExtra("newCardJson") : null;
                    if (stringExtra2 != null) {
                        MTFullCard mTFullCard4 = (MTFullCard) new Gson().fromJson(stringExtra2, MTFullCard.class);
                        EditCardDialogFragment editCardDialogFragment = scanFragment.editDialog;
                        if (editCardDialogFragment != null) {
                            Intrinsics.checkNotNull(mTFullCard4);
                            editCardDialogFragment.updatePrint(mTFullCard4);
                            Unit unit3 = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                    return;
                }
                MTFullCard mTFullCard5 = scanFragment.currentMTCard;
                if (mTFullCard5 != null) {
                    if (!scanFragment.currentScanList.isEmpty() && !scanFragment.noScanMode) {
                        Intent data4 = result.getData();
                        String stringExtra3 = data4 != null ? data4.getStringExtra("newCardJson") : null;
                        if (stringExtra3 == null || (mTFullCard2 = (MTFullCard) new Gson().fromJson(stringExtra3, MTFullCard.class)) == null) {
                            return;
                        }
                        MTFullCard mTFullCard6 = scanFragment.currentMTCard;
                        if (mTFullCard6 == null) {
                            mTFullCard6 = mTFullCard2;
                        }
                        mTFullCard6.setCardid(mTFullCard2.getCardid());
                        mTFullCard6.setOracleid(mTFullCard2.getOracleid());
                        mTFullCard6.setScryfallid(mTFullCard2.getScryfallid());
                        mTFullCard6.setSet_code(mTFullCard2.getSet_code());
                        mTFullCard6.setLang(mTFullCard2.getLang());
                        mTFullCard6.setCollector_number(mTFullCard2.getCollector_number());
                        mTFullCard6.setCurrent_value_usd(mTFullCard2.getCurrent_value_usd());
                        mTFullCard6.setCurrent_value_eur(mTFullCard2.getCurrent_value_eur());
                        mTFullCard6.setCurrent_value_usd_foil(mTFullCard2.getCurrent_value_usd_foil());
                        mTFullCard6.setCurrent_value_eur_foil(mTFullCard2.getCurrent_value_eur_foil());
                        mTFullCard6.setCurrent_value_usd_etched(mTFullCard2.getCurrent_value_usd_etched());
                        mTFullCard6.setCurrent_value_eur_etched(mTFullCard2.getCurrent_value_eur_etched());
                        mTFullCard6.setValues(mTFullCard2.getValues());
                        mTFullCard6.setRarity(mTFullCard2.getRarity());
                        mTFullCard6.setImages(mTFullCard2.getImages());
                        mTFullCard6.setEn_images(mTFullCard2.getEn_images());
                        mTFullCard6.setValues(mTFullCard2.getValues());
                        mTFullCard6.setFinishes(mTFullCard2.getFinishes());
                        MTFullCard mTFullCard7 = scanFragment.currentMTCard;
                        Object finish = mTFullCard7 != null ? mTFullCard7.getFinish() : null;
                        List<String> finishes = mTFullCard2.getFinishes();
                        if (finishes != null) {
                            if (!CollectionsKt.contains(finishes, finish)) {
                                finish = CollectionsKt.firstOrNull((List<? extends Object>) finishes);
                            }
                            Unit unit4 = Unit.INSTANCE;
                            Unit unit5 = Unit.INSTANCE;
                        }
                        mTFullCard6.setFinish((String) finish);
                        scanFragment.currentScanList.set(scanFragment.currentScanListIndex, mTFullCard6);
                        ScannedCardsAdapter scannedCardsAdapter = scanFragment.scannedCardsAdapter;
                        if (scannedCardsAdapter != null) {
                            scannedCardsAdapter.updateCard(scanFragment.currentScanListIndex, mTFullCard6);
                            Unit unit6 = Unit.INSTANCE;
                        }
                        scanFragment.updateCardCountAndTotalPrice();
                        Context contextRequireContext = scanFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
                        if (scanFragment.scanToDeckMode) {
                            preferencesManager.saveCurrentDeckScanList(scanFragment.currentScanList);
                        } else if (scanFragment.scanToListMode) {
                            preferencesManager.saveCurrentListScanList(scanFragment.scanToListId, scanFragment.currentScanList);
                        } else {
                            preferencesManager.saveCurrentUserScanList(scanFragment.currentScanList);
                        }
                        scanFragment.currentMTCard = mTFullCard6;
                        displayMTCard$default(scanFragment, mTFullCard6, true, false, 4, null);
                        Unit unit7 = Unit.INSTANCE;
                        Unit unit8 = Unit.INSTANCE;
                        return;
                    }
                    Intent data5 = result.getData();
                    String stringExtra4 = data5 != null ? data5.getStringExtra("newCardJson") : null;
                    if (stringExtra4 == null || (mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra4, MTFullCard.class)) == null) {
                        return;
                    }
                    int iIntValue = scanFragment.currentListId;
                    int i = scanFragment.currentDeckListId;
                    if (i != -1) {
                        iIntValue = i;
                    }
                    if (iIntValue == -1) {
                        Integer listid = mTFullCard5.getListid();
                        iIntValue = listid != null ? listid.intValue() : -1;
                    }
                    int i2 = iIntValue;
                    if (i2 != -1 && scanFragment.noScanMode && !scanFragment.readOnly) {
                        Context contextRequireContext2 = scanFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        MTUser currentUser = new PreferencesManager(contextRequireContext2).getCurrentUser();
                        if (currentUser != null) {
                            MTEditCardBody mTEditCardBody = new MTEditCardBody(null, 1, null);
                            mTEditCardBody.setCards(new MTEditCardActions(null, null, null, 7, null));
                            ArrayList arrayList = new ArrayList();
                            List<Integer> variant_list_card_ids = mTFullCard5.getVariant_list_card_ids();
                            if (variant_list_card_ids == null) {
                                variant_list_card_ids = mTFullCard5.getList_card_ids();
                            }
                            if (variant_list_card_ids == null || variant_list_card_ids.isEmpty()) {
                                scanFragment.currentMTCard = mTFullCard;
                                displayMTCard$default(scanFragment, mTFullCard, true, false, 4, null);
                                return;
                            }
                            int size = variant_list_card_ids.size();
                            for (int i3 = 0; i3 < size; i3++) {
                                MTFullCard mTFullCard8 = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                                mTFullCard8.setCardid(mTFullCard.getCardid());
                                mTFullCard8.setSet_code(mTFullCard.getSet_code());
                                mTFullCard8.setCollector_number(mTFullCard.getCollector_number());
                                mTFullCard8.setLang(mTFullCard.getLang());
                                mTFullCard8.setFinish(mTFullCard5.getFinish());
                                mTFullCard8.setCondition(mTFullCard5.getCondition());
                                boolean altered = mTFullCard5.getAltered();
                                if (altered == null) {
                                    altered = false;
                                }
                                mTFullCard8.setAltered(altered);
                                boolean signed = mTFullCard5.getSigned();
                                if (signed == null) {
                                    signed = false;
                                }
                                mTFullCard8.setSigned(signed);
                                boolean missprint = mTFullCard5.getMissprint();
                                if (missprint == null) {
                                    missprint = false;
                                }
                                mTFullCard8.setMissprint(missprint);
                                boolean proxy = mTFullCard5.getProxy();
                                if (proxy == null) {
                                    proxy = false;
                                }
                                mTFullCard8.setProxy(proxy);
                                mTFullCard8.setList_card_id((Integer) CollectionsKt.getOrNull(variant_list_card_ids, i3));
                                arrayList.add(mTFullCard8);
                            }
                            MTEditCardActions cards = mTEditCardBody.getCards();
                            if (cards != null) {
                                cards.setEdited(arrayList);
                                Unit unit9 = Unit.INSTANCE;
                            }
                            scanFragment.getBinding().loadingOverlay.setVisibility(0);
                            MTApiKt.getMtApi().editCardsFromList(currentUser.getId(), i2, scanFragment.currentNameFilter, scanFragment.currentScryfallFilter, scanFragment.currentGroupBy, scanFragment.currentOrderBy, scanFragment.currentOrderDirection, true, null, null, null, mTEditCardBody).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.ScanFragment$allPrintsActivityLauncher$1$2$2$2$1$1$1
                                @Override // retrofit2.Callback
                                public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                                    Intrinsics.checkNotNullParameter(call, "call");
                                    Intrinsics.checkNotNullParameter(t, "t");
                                    if (this.this$0.getActivity() == null || this.this$0.getContext() == null) {
                                        return;
                                    }
                                    this.this$0.getBinding().loadingOverlay.setVisibility(8);
                                    Log.e("ScanFragment", "Failed to update card print in list: " + t.getMessage());
                                    Toast.makeText(this.this$0.requireContext(), R.string.error_editing_card, 0).show();
                                    this.this$0.currentMTCard = mTFullCard;
                                    ScanFragment.displayMTCard$default(this.this$0, mTFullCard, true, false, 4, null);
                                }

                                @Override // retrofit2.Callback
                                public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                                    Intrinsics.checkNotNullParameter(call, "call");
                                    Intrinsics.checkNotNullParameter(response, "response");
                                    if (this.this$0.getActivity() == null || this.this$0.getContext() == null) {
                                        return;
                                    }
                                    this.this$0.getBinding().loadingOverlay.setVisibility(8);
                                    if (!response.isSuccessful()) {
                                        Toast.makeText(this.this$0.requireContext(), R.string.error_editing_card, 0).show();
                                        this.this$0.currentMTCard = mTFullCard;
                                        ScanFragment.displayMTCard$default(this.this$0, mTFullCard, true, false, 4, null);
                                    } else {
                                        MTCardListResponse mTCardListResponseBody = response.body();
                                        MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                                        if (list != null) {
                                            this.this$0.updateCardListFromNewContainer(list);
                                        }
                                    }
                                }
                            });
                            return;
                        }
                    }
                    scanFragment.currentMTCard = mTFullCard;
                    displayMTCard$default(scanFragment, mTFullCard, true, false, 4, null);
                    Unit unit10 = Unit.INSTANCE;
                    Unit unit11 = Unit.INSTANCE;
                    return;
                }
            }
            Unit unit12 = Unit.INSTANCE;
            Unit unit13 = Unit.INSTANCE;
        }
    }

    private final void animateCardFlip() {
        boolean zAreEqual;
        List<MTFace> card_faces;
        String layout;
        String lowerCase;
        if (this._binding == null) {
            return;
        }
        TextView helpLabel = getBinding().helpLabel;
        Intrinsics.checkNotNullExpressionValue(helpLabel, "helpLabel");
        helpLabel.setVisibility(8);
        getBinding().pausedLabel.setVisibility(8);
        getBinding().cardZone.setVisibility(8);
        getBinding().scrollView.scrollTo(0, 0);
        getBinding().backToGameButton.setVisibility(4);
        getBinding().backToGameLabel.setVisibility(4);
        Button mainSearchButton = getBinding().mainSearchButton;
        Intrinsics.checkNotNullExpressionValue(mainSearchButton, "mainSearchButton");
        if (mainSearchButton.getVisibility() == 0) {
            getBinding().mainSearchButton.setVisibility(4);
        }
        TextView priceButton = getBinding().priceButton;
        Intrinsics.checkNotNullExpressionValue(priceButton, "priceButton");
        if (priceButton.getVisibility() == 8) {
            getBinding().priceButton.setVisibility(0);
        }
        getBinding().scrollView.setVisibility(0);
        getBinding().topBar.setVisibility(0);
        getBinding().overlayView.dim();
        if (this.pickACardMode) {
            TextView detailManaCostLabel = getBinding().detailManaCostLabel;
            Intrinsics.checkNotNullExpressionValue(detailManaCostLabel, "detailManaCostLabel");
            detailManaCostLabel.setVisibility(8);
            ConstraintLayout typeLinearLayout = getBinding().typeLinearLayout;
            Intrinsics.checkNotNullExpressionValue(typeLinearLayout, "typeLinearLayout");
            typeLinearLayout.setVisibility(8);
            GridLayout buttonsGridLayout = getBinding().buttonsGridLayout;
            Intrinsics.checkNotNullExpressionValue(buttonsGridLayout, "buttonsGridLayout");
            buttonsGridLayout.setVisibility(8);
            TextView linksLabel = getBinding().linksLabel;
            Intrinsics.checkNotNullExpressionValue(linksLabel, "linksLabel");
            linksLabel.setVisibility(8);
            View separator2 = getBinding().separator2;
            Intrinsics.checkNotNullExpressionValue(separator2, "separator2");
            separator2.setVisibility(8);
            TextView detailOracleTextLabel = getBinding().detailOracleTextLabel;
            Intrinsics.checkNotNullExpressionValue(detailOracleTextLabel, "detailOracleTextLabel");
            detailOracleTextLabel.setVisibility(8);
            LinearLayout rulingsHeaderLinearLayout = getBinding().rulingsHeaderLinearLayout;
            Intrinsics.checkNotNullExpressionValue(rulingsHeaderLinearLayout, "rulingsHeaderLinearLayout");
            rulingsHeaderLinearLayout.setVisibility(8);
            LinearLayout detailsRulingLayout = getBinding().detailsRulingLayout;
            Intrinsics.checkNotNullExpressionValue(detailsRulingLayout, "detailsRulingLayout");
            detailsRulingLayout.setVisibility(8);
            GridLayout legalityGridLayout = getBinding().legalityGridLayout;
            Intrinsics.checkNotNullExpressionValue(legalityGridLayout, "legalityGridLayout");
            legalityGridLayout.setVisibility(8);
            MaterialButton pickACardButton = getBinding().pickACardButton;
            Intrinsics.checkNotNullExpressionValue(pickACardButton, "pickACardButton");
            pickACardButton.setVisibility(0);
            View pickACardPadding = getBinding().pickACardPadding;
            Intrinsics.checkNotNullExpressionValue(pickACardPadding, "pickACardPadding");
            pickACardPadding.setVisibility(0);
            ViewExtensionsKt.setOnClickWithBounce(pickACardButton, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda135
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.animateCardFlip$lambda$0(this.f$0);
                }
            });
        }
        ConstraintLayout cardInfoLayout = getBinding().cardInfoLayout;
        Intrinsics.checkNotNullExpressionValue(cardInfoLayout, "cardInfoLayout");
        if (getContext() != null) {
            animateMarginTop(cardInfoLayout, getResources().getDisplayMetrics().heightPixels);
        }
        final ConstraintLayout cardFrontContainer = getBinding().cardFrontContainer;
        Intrinsics.checkNotNullExpressionValue(cardFrontContainer, "cardFrontContainer");
        final ConstraintLayout cardBackContainer = getBinding().cardBackContainer;
        Intrinsics.checkNotNullExpressionValue(cardBackContainer, "cardBackContainer");
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(cardFrontContainer, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 0.0f, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 0.0f, 1.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(450L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder, "apply(...)");
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(cardBackContainer, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 0.0f, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 0.0f, 1.0f));
        objectAnimatorOfPropertyValuesHolder2.setDuration(450L);
        objectAnimatorOfPropertyValuesHolder2.setInterpolator(new DecelerateInterpolator());
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder2, "apply(...)");
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(cardFrontContainer, "rotationY", -180.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(450L);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda136
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScanFragment.animateCardFlip$lambda$4$0(cardFrontContainer, valueAnimator);
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(cardBackContainer, "rotationY", 0.0f, 180.0f);
        objectAnimatorOfFloat2.setDuration(450L);
        objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda137
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScanFragment.animateCardFlip$lambda$5$0(cardBackContainer, valueAnimator);
            }
        });
        MTFullCard mTFullCard = this.currentMTCard;
        if (mTFullCard != null) {
            String layout2 = mTFullCard.getLayout();
            if (layout2 != null) {
                lowerCase = layout2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            zAreEqual = Intrinsics.areEqual(lowerCase, "split");
        } else {
            zAreEqual = false;
        }
        if (this.currentFace == 1 && !zAreEqual) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(cardFrontContainer, "rotationY", 0.0f, 180.0f);
            objectAnimatorOfFloat.setDuration(450L);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda138
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ScanFragment.animateCardFlip$lambda$7$0(cardFrontContainer, valueAnimator);
                }
            });
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(cardBackContainer, "rotationY", -180.0f, 0.0f);
            objectAnimatorOfFloat2.setDuration(450L);
            objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda139
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ScanFragment.animateCardFlip$lambda$8$0(cardBackContainer, valueAnimator);
                }
            });
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2, objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.start();
        ImageView halo = getBinding().halo;
        Intrinsics.checkNotNullExpressionValue(halo, "halo");
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(halo, "alpha", 0.0f, 0.275f);
        objectAnimatorOfFloat3.setDuration(1000L);
        objectAnimatorOfFloat3.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat3.start();
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(halo, Key.ROTATION, 0.0f, 360.0f);
        objectAnimatorOfFloat4.setDuration(120000L);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat4.start();
        MTFullCard mTFullCard2 = this.currentMTCard;
        String str = "";
        if (mTFullCard2 != null && (layout = mTFullCard2.getLayout()) != null) {
            str = layout;
        }
        if (str.length() > 0) {
            String lowerCase2 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            boolean zAreEqual2 = Intrinsics.areEqual(lowerCase2, "split");
            boolean zIsAftermath = isAftermath();
            final CardMatch cardMatch = this.currentCardMatch;
            if (cardMatch != null) {
                if (zAreEqual2 && !zIsAftermath) {
                    cardFrontContainer.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda140
                        @Override // java.lang.Runnable
                        public final void run() {
                            ScanFragment.animateCardFlip$lambda$13$0(cardMatch, cardFrontContainer, cardBackContainer);
                        }
                    }, 1200L);
                }
                if (zAreEqual2 && zIsAftermath && cardMatch.getFace() == 1) {
                    cardFrontContainer.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda141
                        @Override // java.lang.Runnable
                        public final void run() {
                            ScanFragment.animateCardFlip$lambda$13$1(cardFrontContainer, cardBackContainer);
                        }
                    }, 1200L);
                }
            }
        }
        final MTFullCard mTFullCard3 = this.currentMTCard;
        if (mTFullCard3 == null || (card_faces = mTFullCard3.getCard_faces()) == null || getContext() == null) {
            return;
        }
        if (card_faces.size() < 2) {
            getBinding().flipCardButton.setVisibility(8);
        } else {
            getBinding().flipCardButton.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda143
                @Override // java.lang.Runnable
                public final void run() {
                    ScanFragment.animateCardFlip$lambda$14$0$0(mTFullCard3, this);
                }
            }, 750L);
        }
    }

    static final Unit animateCardFlip$lambda$0(ScanFragment scanFragment) {
        MTFullCard mTFullCard = scanFragment.currentMTCard;
        if (mTFullCard != null) {
            Breadcrumbs.INSTANCE.leaveBreadcrumb("card_picked");
            FragmentActivity activity = scanFragment.getActivity();
            PickACardActivity pickACardActivity = activity instanceof PickACardActivity ? (PickACardActivity) activity : null;
            if (pickACardActivity != null) {
                pickACardActivity.finishWithResult(mTFullCard, scanFragment.currentFace);
            }
        }
        FragmentActivity activity2 = scanFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateCardFlip$lambda$13$0(CardMatch cardMatch, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        if (cardMatch.getFace() != 1) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(constraintLayout, "scaleX", 1.0f, 1.25f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(constraintLayout, "scaleY", 1.0f, 1.25f);
            float height = constraintLayout.getHeight() * 0.25f;
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(constraintLayout, "translationX", 0.0f, height);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(constraintLayout, (Property<ConstraintLayout, Float>) View.ROTATION, 0.0f, 90.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
            animatorSet.setDuration(350L);
            animatorSet.start();
            ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(constraintLayout2, "scaleX", 1.0f, 1.25f);
            ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(constraintLayout2, "scaleY", 1.0f, 1.25f);
            ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(constraintLayout2, "translationX", 0.0f, height);
            ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(constraintLayout2, (Property<ConstraintLayout, Float>) View.ROTATION, 0.0f, 90.0f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(objectAnimatorOfFloat5, objectAnimatorOfFloat6, objectAnimatorOfFloat7, objectAnimatorOfFloat8);
            animatorSet2.setDuration(350L);
            animatorSet2.start();
            return;
        }
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(constraintLayout, "scaleX", 1.0f, 1.25f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(constraintLayout, "scaleY", 1.0f, 1.25f);
        constraintLayout.getHeight();
        float f = -(constraintLayout.getHeight() * 0.35f);
        ObjectAnimator objectAnimatorOfFloat11 = ObjectAnimator.ofFloat(constraintLayout, "translationX", 0.0f, f);
        ObjectAnimator objectAnimatorOfFloat12 = ObjectAnimator.ofFloat(constraintLayout, (Property<ConstraintLayout, Float>) View.ROTATION, 0.0f, 90.0f);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(objectAnimatorOfFloat9, objectAnimatorOfFloat10, objectAnimatorOfFloat11, objectAnimatorOfFloat12);
        animatorSet3.setDuration(350L);
        animatorSet3.start();
        ObjectAnimator objectAnimatorOfFloat13 = ObjectAnimator.ofFloat(constraintLayout2, "scaleX", 1.0f, 1.25f);
        ObjectAnimator objectAnimatorOfFloat14 = ObjectAnimator.ofFloat(constraintLayout2, "scaleY", 1.0f, 1.25f);
        ObjectAnimator objectAnimatorOfFloat15 = ObjectAnimator.ofFloat(constraintLayout2, "translationX", 0.0f, f);
        ObjectAnimator objectAnimatorOfFloat16 = ObjectAnimator.ofFloat(constraintLayout2, (Property<ConstraintLayout, Float>) View.ROTATION, 0.0f, 90.0f);
        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.playTogether(objectAnimatorOfFloat13, objectAnimatorOfFloat14, objectAnimatorOfFloat15, objectAnimatorOfFloat16);
        animatorSet4.setDuration(350L);
        animatorSet4.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateCardFlip$lambda$13$1(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(constraintLayout, "scaleX", 1.0f, 1.25f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(constraintLayout, "scaleY", 1.0f, 1.25f);
        float f = -(constraintLayout.getHeight() * 0.35f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(constraintLayout, "translationX", 0.0f, f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(constraintLayout, (Property<ConstraintLayout, Float>) View.ROTATION, 0.0f, -90.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        animatorSet.setDuration(350L);
        animatorSet.start();
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(constraintLayout2, "scaleX", 1.0f, 1.25f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(constraintLayout2, "scaleY", 1.0f, 1.25f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(constraintLayout2, "translationX", 0.0f, f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(constraintLayout2, (Property<ConstraintLayout, Float>) View.ROTATION, 0.0f, -90.0f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(objectAnimatorOfFloat5, objectAnimatorOfFloat6, objectAnimatorOfFloat7, objectAnimatorOfFloat8);
        animatorSet2.setDuration(350L);
        animatorSet2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateCardFlip$lambda$14$0$0(MTFullCard mTFullCard, ScanFragment scanFragment) {
        String lowerCase;
        String lowerCase2;
        String layout = mTFullCard.getLayout();
        String lowerCase3 = null;
        if (layout != null) {
            lowerCase = layout.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        boolean zAreEqual = Intrinsics.areEqual(lowerCase, "split");
        String layout2 = mTFullCard.getLayout();
        if (layout2 != null) {
            lowerCase2 = layout2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        } else {
            lowerCase2 = null;
        }
        boolean zAreEqual2 = Intrinsics.areEqual(lowerCase2, "adventure");
        String layout3 = mTFullCard.getLayout();
        if (layout3 != null) {
            lowerCase3 = layout3.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        }
        boolean zAreEqual3 = Intrinsics.areEqual(lowerCase3, "prepare");
        boolean zIsAftermath = scanFragment.isAftermath();
        if (!zAreEqual || zIsAftermath) {
            if (zAreEqual2 || zAreEqual3) {
                scanFragment.getBinding().flipCardButton.setText("\uf063");
            } else {
                scanFragment.getBinding().flipCardButton.setText("\uf021");
            }
        } else if (scanFragment.currentFace == 0) {
            scanFragment.getBinding().flipCardButton.setText("\uf061");
        } else {
            scanFragment.getBinding().flipCardButton.setText("\uf060");
        }
        scanFragment.getBinding().flipCardButton.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateCardFlip$lambda$4$0(ConstraintLayout constraintLayout, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        if ((fFloatValue < -90.0f || fFloatValue >= 180.0f) && fFloatValue < 270.0f) {
            if (constraintLayout.getVisibility() == 0) {
                constraintLayout.setVisibility(4);
            }
        } else if (constraintLayout.getVisibility() == 4) {
            constraintLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateCardFlip$lambda$5$0(ConstraintLayout constraintLayout, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        if ((fFloatValue < 90.0f || fFloatValue >= 270.0f) && fFloatValue < 450.0f) {
            if (constraintLayout.getVisibility() == 4) {
                constraintLayout.setVisibility(0);
            }
        } else if (constraintLayout.getVisibility() == 0) {
            constraintLayout.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateCardFlip$lambda$7$0(ConstraintLayout constraintLayout, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        if (fFloatValue < -90.0f || fFloatValue >= 180.0f) {
            if (constraintLayout.getVisibility() == 0) {
                constraintLayout.setVisibility(4);
            }
        } else if (constraintLayout.getVisibility() == 4) {
            constraintLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateCardFlip$lambda$8$0(ConstraintLayout constraintLayout, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        if (fFloatValue < 90.0f || fFloatValue >= 270.0f) {
            if (constraintLayout.getVisibility() == 4) {
                constraintLayout.setVisibility(0);
            }
        } else if (constraintLayout.getVisibility() == 0) {
            constraintLayout.setVisibility(4);
        }
    }

    private final void animateMarginTop(final ConstraintLayout layout, int screenHeight) {
        ViewGroup.LayoutParams layoutParams = layout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        final ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(screenHeight, dpToPx(38, contextRequireContext));
        valueAnimatorOfInt.setDuration(450L);
        valueAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda127
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScanFragment.animateMarginTop$lambda$1(layoutParams2, layout, valueAnimator);
            }
        });
        Intrinsics.checkNotNull(valueAnimatorOfInt);
        valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$animateMarginTop$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                this.this$0.getBinding().actionItemsLayout.setAlpha(0.0f);
                this.this$0.getBinding().actionItemsLayout.setVisibility(0);
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.this$0.getBinding().actionItemsLayout, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setDuration(150L);
                objectAnimatorOfFloat.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        valueAnimatorOfInt.start();
    }

    static final void animateMarginTop$lambda$1(ConstraintLayout.LayoutParams layoutParams, ConstraintLayout constraintLayout, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.topMargin = ((Integer) animatedValue).intValue();
        constraintLayout.setLayoutParams(layoutParams);
    }

    private final void applyFinishOverride(MTFullCard card, PreferencesManager prefs) {
        MTUserSettings mTUserSettings = prefs.getMTUserSettings();
        if (Intrinsics.areEqual((Object) mTUserSettings.getScan_override_finish_enabled(), (Object) true)) {
            String scan_override_finish = mTUserSettings.getScan_override_finish();
            if (scan_override_finish == null) {
                scan_override_finish = "nonfoil";
            }
            String lowerCase = scan_override_finish.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "nonfoil")) {
                return;
            }
            List<String> finishes = card.getFinishes();
            List<String> list = finishes;
            if (list == null || list.isEmpty()) {
                card.setFinish(scan_override_finish);
                return;
            }
            if (finishes.size() == 1 && finishes.contains("nonfoil")) {
                requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda114
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScanFragment scanFragment = this.f$0;
                        Toast.makeText(scanFragment.requireContext(), scanFragment.getString(R.string.card_not_available_in_foil), 0).show();
                    }
                });
                return;
            }
            if (finishes.contains("foil")) {
                card.setFinish("foil");
            } else if (!finishes.contains("etched") || finishes.contains("foil")) {
                card.setFinish(scan_override_finish);
            } else {
                card.setFinish("etched");
            }
        }
    }

    private final void applyLanguageAndSetOverrides(CardMatch match, PreferencesManager prefs) {
        MTUserSettings mTUserSettings = prefs.getMTUserSettings();
        if (Intrinsics.areEqual((Object) mTUserSettings.getScan_override_language_enabled(), (Object) true)) {
            String scan_override_language = mTUserSettings.getScan_override_language();
            if (scan_override_language == null) {
                scan_override_language = "en";
            }
            match.setLang(scan_override_language);
        }
        if (Intrinsics.areEqual((Object) mTUserSettings.getScan_override_set_enabled(), (Object) true)) {
            String scan_override_set = mTUserSettings.getScan_override_set();
            if (scan_override_set == null) {
                scan_override_set = "";
            }
            if (scan_override_set.length() > 0) {
                MTGDBHelper mTGDBHelper = this.mtgdbHelper;
                if (mTGDBHelper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelper");
                    mTGDBHelper = null;
                }
                String oracleId = match.getOracleId();
                int face = match.getFace();
                String lowerCase = scan_override_set.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                CardRecord cardByOracleIdAndOptionalPrintData$default = MTGDBHelper.getCardByOracleIdAndOptionalPrintData$default(mTGDBHelper, oracleId, face, lowerCase, null, 8, null);
                if (cardByOracleIdAndOptionalPrintData$default != null) {
                    String lowerCase2 = scan_override_set.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    match.setSet(lowerCase2);
                    match.setNumber(cardByOracleIdAndOptionalPrintData$default.getNumber());
                }
            }
        }
    }

    private final void applyPurchasePriceOverride(MTFullCard card, PreferencesManager prefs) {
        MTUserSettings mTUserSettings = prefs.getMTUserSettings();
        if (Intrinsics.areEqual((Object) mTUserSettings.getScan_purchase_price_enabled(), (Object) true)) {
            String scan_purchase_price_mode = mTUserSettings.getScan_purchase_price_mode();
            if (scan_purchase_price_mode == null) {
                scan_purchase_price_mode = "current";
            }
            if (!Intrinsics.areEqual(scan_purchase_price_mode, "fixed")) {
                card.setPurchase_price(Double.valueOf(GameUtils.INSTANCE.getInstance().getCardPrice(card, prefs.getPreferredMarket())));
            } else {
                card.setPurchase_price(Double.valueOf(mTUserSettings.getScan_purchase_price_fixed() != null ? r2.floatValue() : AudioStats.AUDIO_AMPLITUDE_NONE));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applySplitCardRotationIfNeeded() {
        String layout;
        if (getContext() == null || this._binding == null) {
            return;
        }
        final ConstraintLayout cardFrontContainer = getBinding().cardFrontContainer;
        Intrinsics.checkNotNullExpressionValue(cardFrontContainer, "cardFrontContainer");
        final ConstraintLayout cardBackContainer = getBinding().cardBackContainer;
        Intrinsics.checkNotNullExpressionValue(cardBackContainer, "cardBackContainer");
        MTFullCard mTFullCard = this.currentMTCard;
        String str = "";
        if (mTFullCard != null && (layout = mTFullCard.getLayout()) != null) {
            str = layout;
        }
        if (str.length() > 0) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            boolean zAreEqual = Intrinsics.areEqual(lowerCase, "split");
            boolean zIsAftermath = isAftermath();
            if (this.currentCardMatch == null || !zAreEqual || zIsAftermath) {
                return;
            }
            this.animatingCards = true;
            cardFrontContainer.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda53
                @Override // java.lang.Runnable
                public final void run() {
                    ScanFragment.applySplitCardRotationIfNeeded$lambda$1$0(this.f$0, cardFrontContainer, cardBackContainer);
                }
            }, 250L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applySplitCardRotationIfNeeded$lambda$1$0(final ScanFragment scanFragment, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        if (scanFragment.getContext() == null || scanFragment._binding == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(constraintLayout, "scaleX", 1.0f, 1.25f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(constraintLayout, "scaleY", 1.0f, 1.25f);
        float height = constraintLayout.getHeight() * 0.25f;
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(constraintLayout, "translationX", 0.0f, height);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(constraintLayout, (Property<ConstraintLayout, Float>) View.ROTATION, 0.0f, 90.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        animatorSet.setDuration(250L);
        animatorSet.start();
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(constraintLayout2, "scaleX", 1.0f, 1.25f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(constraintLayout2, "scaleY", 1.0f, 1.25f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(constraintLayout2, "translationX", 0.0f, height);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(constraintLayout2, (Property<ConstraintLayout, Float>) View.ROTATION, 0.0f, 90.0f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(objectAnimatorOfFloat5, objectAnimatorOfFloat6, objectAnimatorOfFloat7, objectAnimatorOfFloat8);
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.studiolaganne.lengendarylens.ScanFragment$applySplitCardRotationIfNeeded$2$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.animatingCards = false;
            }
        });
        animatorSet2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearCurrentScanListAndUI() {
        this.currentScanList.clear();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (this.scanToDeckMode) {
            preferencesManager.clearCurrentDeckScanList();
        } else if (this.scanToListMode) {
            preferencesManager.clearCurrentListScanList(this.scanToListId);
        } else {
            preferencesManager.clearCurrentUserScanList();
        }
        CombinedAnalyzer combinedAnalyzer = this.combinedAnalyzer;
        if (combinedAnalyzer != null) {
            combinedAnalyzer.resetContinuousState();
        }
        ScannedCardsAdapter scannedCardsAdapter = this.scannedCardsAdapter;
        if (scannedCardsAdapter != null) {
            scannedCardsAdapter.clearCards();
        }
        ScannedCardsAdapter scannedCardsAdapter2 = this.scannedCardsAdapter;
        if (scannedCardsAdapter2 != null) {
            scannedCardsAdapter2.notifyDataSetChanged();
        }
        getBinding().addToButton.setVisibility(8);
        getBinding().scanListBottomLayout.setVisibility(8);
        updateCardCountAndTotalPrice();
    }

    private final AnimatorSet createMoveAndScaleAnimation(View fromView, View toView, long duration) {
        float x = fromView.getX();
        float y = fromView.getY();
        float x2 = toView.getX();
        float y2 = toView.getY();
        float width = fromView.getWidth();
        float height = fromView.getHeight();
        float width2 = toView.getWidth() / width;
        float height2 = toView.getHeight() / height;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(fromView, (Property<View, Float>) View.X, x, x2 + ((width * (width2 - 1.0f)) / 2.0f));
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(fromView, (Property<View, Float>) View.Y, y, y2 + ((height * (height2 - 1.0f)) / 2.0f));
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(fromView, (Property<View, Float>) View.SCALE_X, 1.0f, width2);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(fromView, (Property<View, Float>) View.SCALE_Y, 1.0f, height2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(duration);
        return animatorSet;
    }

    static /* synthetic */ AnimatorSet createMoveAndScaleAnimation$default(ScanFragment scanFragment, View view, View view2, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 300;
        }
        return scanFragment.createMoveAndScaleAnimation(view, view2, j);
    }

    private final String currentCardNameToEDHREC() {
        MTFullCard mTFullCard = this.currentMTCard;
        if (mTFullCard == null) {
            return "";
        }
        String name = mTFullCard.getName();
        String string = name != null ? name : "";
        String str = string;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "//", false, 2, (Object) null)) {
            string = StringsKt.trim((CharSequence) StringsKt.split$default((CharSequence) str, new String[]{"//"}, false, 0, 6, (Object) null).get(this.currentFace)).toString();
        }
        String lowerCase = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return StringsKt.trim((CharSequence) StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(lowerCase, "'", "", false, 4, (Object) null), ",", "", false, 4, (Object) null), " ", "-", false, 4, (Object) null)).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0464 A[PHI: r4 r5
      0x0464: PHI (r4v13 java.lang.String) = 
      (r4v12 java.lang.String)
      (r4v12 java.lang.String)
      (r4v12 java.lang.String)
      (r4v12 java.lang.String)
      (r4v12 java.lang.String)
      (r4v12 java.lang.String)
      (r4v12 java.lang.String)
      (r4v171 java.lang.String)
     binds: [B:125:0x03a3, B:147:0x044b, B:143:0x042c, B:139:0x040d, B:135:0x03ed, B:132:0x03cd, B:128:0x03ae, B:130:0x03b2] A[DONT_GENERATE, DONT_INLINE]
      0x0464: PHI (r5v6 int) = (r5v5 int), (r5v5 int), (r5v5 int), (r5v5 int), (r5v5 int), (r5v5 int), (r5v5 int), (r5v39 int) binds: [B:125:0x03a3, B:147:0x044b, B:143:0x042c, B:139:0x040d, B:135:0x03ed, B:132:0x03cd, B:128:0x03ae, B:130:0x03b2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0622  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x086a  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x086d  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0875  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0878  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0912  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x105d  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x10a1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02ee  */
    /* JADX WARN: Type inference failed for: r10v46, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v58, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v27, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v30, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v64, types: [T, android.widget.TextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v64, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void displayMTCard(final MTFullCard card, boolean sceneAlreadyExists, boolean ignoreCardImage) {
        CardRecord cardRecord;
        CardRecord cardByScryFallId;
        String str;
        Object next;
        String str2;
        PreferencesManager preferencesManager;
        String typeLine;
        String oracleText;
        boolean z;
        String str3;
        boolean z2;
        String str4;
        String str5;
        SymbolToImage symbolToImage;
        String strValueOf;
        Function0<Unit> function0;
        boolean z3;
        List<MTImageURIs> en_images;
        boolean z4;
        boolean z5;
        Object next2;
        String str6;
        String str7;
        PreferencesManager preferencesManager2;
        Iterator<String> it;
        String oracle_text;
        String type_line;
        String str8;
        String str9;
        String str10;
        int i;
        final ScanFragment scanFragment = this;
        if (scanFragment.getContext() == null) {
            return;
        }
        Log.d(TAG, "------>>> Displaying MT card " + card.getName() + " / " + card.getOracleid() + " / " + card.getScryfallid() + " / " + card.getSet_code() + " / face " + card.getFace());
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_display_mt_card");
        CardMatch cardMatch = new CardMatch(null, null, 0, 0L, null, null, null, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, false, null, 2097151, null);
        scanFragment.currentCardMatch = cardMatch;
        cardMatch.setLang(card.getLang());
        Unit unit = Unit.INSTANCE;
        CardMatch cardMatch2 = scanFragment.currentCardMatch;
        if (cardMatch2 != null) {
            String oracleid = card.getOracleid();
            if (oracleid == null) {
                oracleid = "";
            }
            cardMatch2.setOracleId(oracleid);
            Unit unit2 = Unit.INSTANCE;
        }
        CardMatch cardMatch3 = scanFragment.currentCardMatch;
        if (cardMatch3 != null) {
            String set_code = card.getSet_code();
            if (set_code == null) {
                set_code = "";
            }
            cardMatch3.setSet(set_code);
            Unit unit3 = Unit.INSTANCE;
        }
        CardMatch cardMatch4 = scanFragment.currentCardMatch;
        if (cardMatch4 != null) {
            Integer face = card.getFace();
            cardMatch4.setFace(face != null ? face.intValue() : 0);
            Unit unit4 = Unit.INSTANCE;
        }
        CardMatch cardMatch5 = scanFragment.currentCardMatch;
        if (cardMatch5 != null) {
            String collector_number = card.getCollector_number();
            if (collector_number == null) {
                collector_number = "";
            }
            cardMatch5.setNumber(collector_number);
            Unit unit5 = Unit.INSTANCE;
        }
        CardMatch cardMatch6 = scanFragment.currentCardMatch;
        if (cardMatch6 != null) {
            String scryfallid = card.getScryfallid();
            if (scryfallid == null) {
                scryfallid = "";
            }
            cardMatch6.setScryfallId(scryfallid);
            Unit unit6 = Unit.INSTANCE;
        }
        CardMatch cardMatch7 = scanFragment.currentCardMatch;
        if (cardMatch7 != null) {
            String name = card.getName();
            if (name == null) {
                name = "";
            }
            cardMatch7.setTitle(name);
            Unit unit7 = Unit.INSTANCE;
        }
        CardMatch cardMatch8 = scanFragment.currentCardMatch;
        if (cardMatch8 != null) {
            cardMatch8.setDetectedCardLang(card.getLang());
            Unit unit8 = Unit.INSTANCE;
        }
        scanFragment.removeProgressAnimation();
        Context contextRequireContext = scanFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager3 = new PreferencesManager(contextRequireContext);
        if (Intrinsics.areEqual(card.getLang(), "en")) {
            MTGDBHelper mTGDBHelper = scanFragment.mtgdbHelper;
            if (mTGDBHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelper");
                mTGDBHelper = null;
            }
            String scryfallid2 = card.getScryfallid();
            if (scryfallid2 == null) {
                scryfallid2 = "";
            }
            CardRecord cardByScryFallId2 = mTGDBHelper.getCardByScryFallId(scryfallid2, 0);
            MTGDBHelper mTGDBHelper2 = scanFragment.mtgdbHelper;
            if (mTGDBHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelper");
                mTGDBHelper2 = null;
            }
            String scryfallid3 = card.getScryfallid();
            if (scryfallid3 == null) {
                scryfallid3 = "";
            }
            cardRecord = cardByScryFallId2;
            cardByScryFallId = mTGDBHelper2.getCardByScryFallId(scryfallid3, 1);
        } else {
            List<MTGDBHelperLocalized> list = scanFragment.mtgdbHelpers;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelpers");
                list = null;
            }
            CardRecord cardByOracleIdAndOptionalPrintData$default = null;
            CardRecord cardByOracleIdAndOptionalPrintData$default2 = null;
            for (MTGDBHelperLocalized mTGDBHelperLocalized : list) {
                if (Intrinsics.areEqual(mTGDBHelperLocalized.getLocale(), card.getLang()) && mTGDBHelperLocalized.isValid()) {
                    String oracleid2 = card.getOracleid();
                    cardByOracleIdAndOptionalPrintData$default = MTGDBHelperLocalized.getCardByOracleIdAndOptionalPrintData$default(mTGDBHelperLocalized, oracleid2 == null ? "" : oracleid2, 0, null, null, 12, null);
                    String oracleid3 = card.getOracleid();
                    cardByOracleIdAndOptionalPrintData$default2 = MTGDBHelperLocalized.getCardByOracleIdAndOptionalPrintData$default(mTGDBHelperLocalized, oracleid3 == null ? "" : oracleid3, 1, null, null, 12, null);
                }
            }
            cardRecord = cardByOracleIdAndOptionalPrintData$default;
            cardByScryFallId = cardByOracleIdAndOptionalPrintData$default2;
        }
        MTFullCard mTFullCardCopy$default = MTFullCard.copy$default(card, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
        if (cardRecord != null) {
            if (mTFullCardCopy$default.getLayout() != null) {
                String layout = mTFullCardCopy$default.getLayout();
                Intrinsics.checkNotNull(layout);
                if (layout.length() == 0) {
                    mTFullCardCopy$default.setLayout(cardRecord.getLayout());
                }
                Unit unit9 = Unit.INSTANCE;
                Unit unit10 = Unit.INSTANCE;
            }
        }
        scanFragment.currentMTCard = mTFullCardCopy$default;
        Integer face2 = mTFullCardCopy$default.getFace();
        scanFragment.currentFace = face2 != null ? face2.intValue() : 0;
        scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.displayMTCard$lambda$1(this.f$0);
            }
        });
        scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.displayMTCard$lambda$2(this.f$0, card);
            }
        });
        String set_code2 = card.getSet_code();
        if (set_code2 != null) {
            String lowerCase = set_code2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            str = lowerCase == null ? "" : lowerCase;
        }
        List<CardSet> list2 = scanFragment.cardSets;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardSets");
            list2 = null;
        }
        Iterator<T> it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            } else {
                next = it2.next();
                if (Intrinsics.areEqual(((CardSet) next).getCode(), str)) {
                    break;
                }
            }
        }
        CardSet cardSet = (CardSet) next;
        if (cardSet == null) {
            String set_name = card.getSet_name();
            cardSet = new CardSet(set_name == null ? "" : set_name, "", str, "", 0);
        }
        String name2 = cardSet.getName();
        String code = cardSet.getCode();
        String collector_number2 = card.getCollector_number();
        if (collector_number2 == null) {
            collector_number2 = "";
        }
        String rarity = card.getRarity();
        if (rarity == null) {
            rarity = "common";
        }
        int color = ContextCompat.getColor(scanFragment.requireContext(), R.color.common);
        switch (rarity.hashCode()) {
            case -2008465223:
                if (rarity.equals("special")) {
                    rarity = scanFragment.getString(R.string.special);
                    Intrinsics.checkNotNullExpressionValue(rarity, "getString(...)");
                    color = ContextCompat.getColor(scanFragment.requireContext(), R.color.special);
                    Unit unit11 = Unit.INSTANCE;
                } else {
                    Unit unit12 = Unit.INSTANCE;
                }
                break;
            case -1354814997:
                if (rarity.equals("common")) {
                    rarity = scanFragment.getString(R.string.common);
                    Intrinsics.checkNotNullExpressionValue(rarity, "getString(...)");
                    color = ContextCompat.getColor(scanFragment.requireContext(), R.color.common);
                    Unit unit13 = Unit.INSTANCE;
                    break;
                }
                break;
            case -1059084742:
                if (rarity.equals("mythic")) {
                    rarity = scanFragment.getString(R.string.mythic);
                    Intrinsics.checkNotNullExpressionValue(rarity, "getString(...)");
                    color = ContextCompat.getColor(scanFragment.requireContext(), R.color.mythic);
                    Unit unit14 = Unit.INSTANCE;
                    break;
                }
                break;
            case -468311612:
                if (rarity.equals("uncommon")) {
                    rarity = scanFragment.getString(R.string.uncommon);
                    Intrinsics.checkNotNullExpressionValue(rarity, "getString(...)");
                    color = ContextCompat.getColor(scanFragment.requireContext(), R.color.uncommon);
                    Unit unit15 = Unit.INSTANCE;
                    break;
                }
                break;
            case 3493026:
                if (rarity.equals("rare")) {
                    rarity = scanFragment.getString(R.string.rare);
                    Intrinsics.checkNotNullExpressionValue(rarity, "getString(...)");
                    color = ContextCompat.getColor(scanFragment.requireContext(), R.color.rare);
                    Unit unit16 = Unit.INSTANCE;
                    break;
                }
                break;
            case 93921311:
                if (rarity.equals("bonus")) {
                    rarity = scanFragment.getString(R.string.bonus);
                    Intrinsics.checkNotNullExpressionValue(rarity, "getString(...)");
                    color = ContextCompat.getColor(scanFragment.requireContext(), R.color.bonus);
                }
                Unit unit122 = Unit.INSTANCE;
                break;
        }
        SpannableString spannableString = new SpannableString(name2);
        spannableString.setSpan(new StyleSpan(1), 0, name2.length(), 0);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(scanFragment.requireContext(), android.R.color.black)), 0, name2.length(), 0);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = code.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        SpannableString spannableString2 = new SpannableString("(" + upperCase + ")");
        spannableString2.setSpan(new StyleSpan(0), 0, code.length() + 2, 0);
        spannableString2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(scanFragment.requireContext(), R.color.darker_grey)), 0, code.length() + 2, 0);
        SpannableString spannableString3 = new SpannableString(ColorKt.HEX_PREFIX + collector_number2);
        spannableString3.setSpan(new StyleSpan(1), 0, collector_number2.length() + 1, 0);
        spannableString3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(scanFragment.requireContext(), R.color.dark_gold)), 0, collector_number2.length() + 1, 0);
        SpannableString spannableString4 = new SpannableString("- " + ((Object) rarity));
        spannableString4.setSpan(new StyleSpan(1), 0, rarity.length() + 2, 0);
        spannableString4.setSpan(new ForegroundColorSpan(color), 0, rarity.length() + 2, 0);
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) spannableString);
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.append((CharSequence) spannableString2);
        String str11 = "\n";
        spannableStringBuilder.append((CharSequence) "\n");
        spannableStringBuilder.append((CharSequence) spannableString3);
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.append((CharSequence) spannableString4);
        final TextView detailSetLabel = scanFragment.getBinding().detailSetLabel;
        Intrinsics.checkNotNullExpressionValue(detailSetLabel, "detailSetLabel");
        scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda37
            @Override // java.lang.Runnable
            public final void run() {
                detailSetLabel.setText(spannableStringBuilder);
            }
        });
        final ImageView detailSetImage = scanFragment.getBinding().detailSetImage;
        Intrinsics.checkNotNullExpressionValue(detailSetImage, "detailSetImage");
        final int identifier = scanFragment.getResources().getIdentifier("set_" + str, "drawable", detailSetImage.getContext().getPackageName());
        if (identifier != 0) {
            scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda39
                @Override // java.lang.Runnable
                public final void run() {
                    detailSetImage.setImageResource(identifier);
                }
            });
            str2 = "requireContext(...)";
        } else {
            String icon_svg_uri = cardSet.getIcon_svg_uri();
            Context contextRequireContext2 = scanFragment.requireContext();
            str2 = "requireContext(...)";
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, str2);
            scanFragment.loadSvgImage(contextRequireContext2, icon_svg_uri, detailSetImage);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "en";
        ?? lang = card.getLang();
        if (lang != 0) {
            if (!Intrinsics.areEqual((Object) lang, "en")) {
                objectRef.element = lang;
            }
            Unit unit17 = Unit.INSTANCE;
            Unit unit18 = Unit.INSTANCE;
        }
        CardMatch cardMatch9 = scanFragment.currentCardMatch;
        if (!Intrinsics.areEqual(cardMatch9 != null ? cardMatch9.getDetectedCardLang() : null, "en")) {
            CardMatch cardMatch10 = scanFragment.currentCardMatch;
            if (cardMatch10 != null) {
                String detectedCardLang = cardMatch10.getDetectedCardLang();
                T t = detectedCardLang;
                if (detectedCardLang == null) {
                    t = "en";
                }
                objectRef.element = t;
            }
        }
        scanFragment.cardLang = (String) objectRef.element;
        final ImageView flagImage = scanFragment.getBinding().flagImage;
        Intrinsics.checkNotNullExpressionValue(flagImage, "flagImage");
        String str12 = scanFragment.cardLang;
        if (Intrinsics.areEqual(str12, UserDataStore.PHONE)) {
            str12 = "en";
        }
        final int identifier2 = scanFragment.getResources().getIdentifier("flag_" + str12, "drawable", flagImage.getContext().getPackageName());
        scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda40
            @Override // java.lang.Runnable
            public final void run() {
                flagImage.setImageResource(identifier2);
            }
        });
        if (Intrinsics.areEqual(preferencesManager3.getDeviceLanguage(), "fr")) {
            preferencesManager = preferencesManager3;
            if (preferencesManager.getBoolean(PreferencesManager.TRANSLATE_RULINGS, false)) {
                final ImageView translateFlagImage = scanFragment.getBinding().translateFlagImage;
                Intrinsics.checkNotNullExpressionValue(translateFlagImage, "translateFlagImage");
                final int identifier3 = scanFragment.getResources().getIdentifier("flag_en", "drawable", translateFlagImage.getContext().getPackageName());
                scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda41
                    @Override // java.lang.Runnable
                    public final void run() {
                        translateFlagImage.setImageResource(identifier3);
                    }
                });
                TextView detailTranslateRulingsLabel = scanFragment.getBinding().detailTranslateRulingsLabel;
                Intrinsics.checkNotNullExpressionValue(detailTranslateRulingsLabel, "detailTranslateRulingsLabel");
                detailTranslateRulingsLabel.setText(scanFragment.getString(R.string.show_orignal));
            } else {
                final ImageView translateFlagImage2 = scanFragment.getBinding().translateFlagImage;
                Intrinsics.checkNotNullExpressionValue(translateFlagImage2, "translateFlagImage");
                final int identifier4 = scanFragment.getResources().getIdentifier("flag_fr", "drawable", translateFlagImage2.getContext().getPackageName());
                scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda42
                    @Override // java.lang.Runnable
                    public final void run() {
                        translateFlagImage2.setImageResource(identifier4);
                    }
                });
                TextView detailTranslateRulingsLabel2 = scanFragment.getBinding().detailTranslateRulingsLabel;
                Intrinsics.checkNotNullExpressionValue(detailTranslateRulingsLabel2, "detailTranslateRulingsLabel");
                detailTranslateRulingsLabel2.setText(scanFragment.getString(R.string.translate));
            }
        } else {
            preferencesManager = preferencesManager3;
            LinearLayout translateLinearLayout = scanFragment.getBinding().translateLinearLayout;
            Intrinsics.checkNotNullExpressionValue(translateLinearLayout, "translateLinearLayout");
            translateLinearLayout.setVisibility(4);
        }
        String printed_name = card.getPrinted_name();
        String name3 = card.getName();
        if (name3 == null) {
            name3 = "";
        }
        List<MTFace> card_faces = card.getCard_faces();
        if (card_faces != null) {
            if (scanFragment.currentFace < card_faces.size()) {
                MTFace mTFace = card_faces.get(scanFragment.currentFace);
                String printed_name2 = mTFace.getPrinted_name();
                String name4 = mTFace.getName();
                if (name4 == null && (name4 = card.getName()) == null) {
                    name4 = "";
                }
                name3 = name4;
                printed_name = printed_name2;
            }
            Unit unit19 = Unit.INSTANCE;
            Unit unit20 = Unit.INSTANCE;
        }
        List<String> available_lang = card.getAvailable_lang();
        if (available_lang == null) {
            available_lang = CollectionsKt.mutableListOf("en");
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it3 = available_lang.iterator();
        while (it3.hasNext()) {
            String next3 = it3.next();
            String name5 = card.getName();
            if (name5 == null) {
                name5 = "";
            }
            if (Intrinsics.areEqual(next3, "en")) {
                MTGDBHelper mTGDBHelper3 = scanFragment.mtgdbHelper;
                if (mTGDBHelper3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelper");
                    mTGDBHelper3 = null;
                }
                String oracleid4 = card.getOracleid();
                str6 = str11;
                String str13 = oracleid4 == null ? "" : oracleid4;
                String set_code3 = card.getSet_code();
                str7 = printed_name;
                String str14 = set_code3 == null ? "" : set_code3;
                String collector_number3 = card.getCollector_number();
                preferencesManager2 = preferencesManager;
                String str15 = collector_number3 == null ? "" : collector_number3;
                Integer face3 = card.getFace();
                if (face3 != null) {
                    int iIntValue = face3.intValue();
                    it = it3;
                    i = iIntValue;
                } else {
                    it = it3;
                    i = 0;
                }
                CardRecord cardByOracleIdAndPrintData = mTGDBHelper3.getCardByOracleIdAndPrintData(str13, str14, str15, i);
                if (cardByOracleIdAndPrintData != null) {
                    name5 = cardByOracleIdAndPrintData.getTitle();
                    type_line = cardByOracleIdAndPrintData.getType_line();
                    oracle_text = cardByOracleIdAndPrintData.getOracle_text();
                    Unit unit21 = Unit.INSTANCE;
                    Unit unit22 = Unit.INSTANCE;
                } else {
                    str10 = name5;
                    str9 = "";
                    str8 = str9;
                    String scryfallid4 = card.getScryfallid();
                    String str16 = scryfallid4 != null ? "" : scryfallid4;
                    String oracleid5 = card.getOracleid();
                    arrayList.add(new CardLanguageRow(next3, str10, str16, oracleid5 != null ? "" : oracleid5, str9, str8));
                    it3 = it;
                    str11 = str6;
                    printed_name = str7;
                    preferencesManager = preferencesManager2;
                }
            } else {
                str6 = str11;
                str7 = printed_name;
                preferencesManager2 = preferencesManager;
                it = it3;
                List<MTGDBHelperLocalized> list3 = scanFragment.mtgdbHelpers;
                if (list3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelpers");
                    list3 = null;
                }
                Iterator<MTGDBHelperLocalized> it4 = list3.iterator();
                while (true) {
                    if (it4.hasNext()) {
                        MTGDBHelperLocalized next4 = it4.next();
                        if (Intrinsics.areEqual(next4.getLocale(), next3) && next4.isValid()) {
                            String oracleid6 = card.getOracleid();
                            if (oracleid6 == null) {
                                oracleid6 = "";
                            }
                            String set_code4 = card.getSet_code();
                            if (set_code4 == null) {
                                set_code4 = "";
                            }
                            String collector_number4 = card.getCollector_number();
                            if (collector_number4 == null) {
                                collector_number4 = "";
                            }
                            Integer face4 = card.getFace();
                            CardRecord cardByOracleIdAndPrintData2 = next4.getCardByOracleIdAndPrintData(oracleid6, set_code4, collector_number4, face4 != null ? face4.intValue() : 0);
                            if (cardByOracleIdAndPrintData2 != null) {
                                name5 = cardByOracleIdAndPrintData2.getTitle();
                                type_line = cardByOracleIdAndPrintData2.getType_line();
                                oracle_text = cardByOracleIdAndPrintData2.getOracle_text();
                                Unit unit23 = Unit.INSTANCE;
                                Unit unit24 = Unit.INSTANCE;
                            }
                        }
                    }
                }
                oracle_text = "";
                type_line = oracle_text;
                Unit unit25 = Unit.INSTANCE;
            }
            str8 = oracle_text;
            str9 = type_line;
            str10 = name5;
            String scryfallid42 = card.getScryfallid();
            if (scryfallid42 != null) {
            }
            String oracleid52 = card.getOracleid();
            arrayList.add(new CardLanguageRow(next3, str10, str16, oracleid52 != null ? "" : oracleid52, str9, str8));
            it3 = it;
            str11 = str6;
            printed_name = str7;
            preferencesManager = preferencesManager2;
        }
        String str17 = str11;
        String str18 = printed_name;
        PreferencesManager preferencesManager4 = preferencesManager;
        final CardLanguageAdapter cardLanguageAdapter = new CardLanguageAdapter(arrayList, scanFragment);
        View view = scanFragment.popupView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupView");
            view = null;
        }
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.language_recycler_view);
        scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda43
            @Override // java.lang.Runnable
            public final void run() {
                recyclerView.setAdapter(cardLanguageAdapter);
            }
        });
        if (preferencesManager4.getScanDisplayLanguage() == ScanDisplayLanguage.TRANSLATED && scanFragment.translateCardIfPossible) {
            String deviceLanguage = preferencesManager4.getDeviceLanguage();
            if (!Intrinsics.areEqual(deviceLanguage, card.getLang()) && !Intrinsics.areEqual(deviceLanguage, "en")) {
                Iterator it5 = arrayList.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        next2 = it5.next();
                        if (Intrinsics.areEqual(((CardLanguageRow) next2).getLang(), deviceLanguage)) {
                        }
                    } else {
                        next2 = null;
                    }
                }
                CardLanguageRow cardLanguageRow = (CardLanguageRow) next2;
                if (cardLanguageRow != null) {
                    String title = cardLanguageRow.getTitle();
                    typeLine = cardLanguageRow.getTypeLine();
                    oracleText = cardLanguageRow.getOracleText();
                    Unit unit26 = Unit.INSTANCE;
                    Unit unit27 = Unit.INSTANCE;
                    str18 = title;
                    z = true;
                }
            }
        } else {
            typeLine = "";
            oracleText = typeLine;
            z = false;
        }
        final TextView detailTitleLabel = scanFragment.getBinding().detailTitleLabel;
        Intrinsics.checkNotNullExpressionValue(detailTitleLabel, "detailTitleLabel");
        if ((z || !Intrinsics.areEqual(objectRef.element, "en")) && str18 != null) {
            List listListOf = CollectionsKt.listOf(new StyleSpan(1), new AbsoluteSizeSpan(20, true), new ForegroundColorSpan(-1));
            str3 = typeLine;
            List listListOf2 = CollectionsKt.listOf(new StyleSpan(0), new AbsoluteSizeSpan(17, true), new ForegroundColorSpan(-3355444));
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str18);
            Iterator it6 = listListOf.iterator();
            while (it6.hasNext()) {
                spannableStringBuilder2.setSpan(it6.next(), 0, str18.length(), 33);
                listListOf2 = listListOf2;
                z = z;
            }
            z2 = z;
            spannableStringBuilder2.append((CharSequence) str17);
            spannableStringBuilder2.append((CharSequence) ("(" + ((Object) name3) + ")"));
            Iterator it7 = listListOf2.iterator();
            while (it7.hasNext()) {
                spannableStringBuilder2.setSpan(it7.next(), str18.length() + 1, spannableStringBuilder2.length(), 33);
            }
            scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda45
                @Override // java.lang.Runnable
                public final void run() {
                    detailTitleLabel.setText(spannableStringBuilder2);
                }
            });
        } else {
            str3 = typeLine;
            z2 = z;
            List listListOf3 = CollectionsKt.listOf(new StyleSpan(1), new AbsoluteSizeSpan(20, true), new ForegroundColorSpan(-1));
            final SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(name3);
            Iterator it8 = listListOf3.iterator();
            while (it8.hasNext()) {
                spannableStringBuilder3.setSpan(it8.next(), 0, name3.length(), 33);
            }
            scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda46
                @Override // java.lang.Runnable
                public final void run() {
                    detailTitleLabel.setText(spannableStringBuilder3);
                }
            });
        }
        String mana_cost = card.getMana_cost();
        if (mana_cost == null) {
            mana_cost = "";
        }
        if (card.getCard_faces() != null) {
            List<MTFace> card_faces2 = card.getCard_faces();
            Intrinsics.checkNotNull(card_faces2);
            if (card_faces2.size() > scanFragment.currentFace) {
                List<MTFace> card_faces3 = card.getCard_faces();
                Intrinsics.checkNotNull(card_faces3);
                String mana_cost2 = card_faces3.get(scanFragment.currentFace).getMana_cost();
                if (mana_cost2 != null) {
                    mana_cost = mana_cost2;
                }
            }
        }
        String strReplace$default = StringsKt.replace$default(mana_cost, "}{", "} {", false, 4, (Object) null);
        int dimensionPixelSize = scanFragment.getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size);
        SymbolToImage symbolToImage2 = scanFragment.symbolToImage;
        if (symbolToImage2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("symbolToImage");
            symbolToImage2 = null;
        }
        final SpannableString spannableStringStringToAttributedStringWithSymbols = symbolToImage2.stringToAttributedStringWithSymbols(strReplace$default, dimensionPixelSize, new CharacterStyle[0]);
        final TextView detailManaCostLabel = scanFragment.getBinding().detailManaCostLabel;
        Intrinsics.checkNotNullExpressionValue(detailManaCostLabel, "detailManaCostLabel");
        scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                detailManaCostLabel.setText(spannableStringStringToAttributedStringWithSymbols);
            }
        });
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        ?? detailTypeLabel = scanFragment.getBinding().detailTypeLabel;
        Intrinsics.checkNotNullExpressionValue(detailTypeLabel, "detailTypeLabel");
        objectRef2.element = detailTypeLabel;
        String printed_type_line = card.getPrinted_type_line();
        String type_line2 = card.getType_line();
        List<MTFace> card_faces4 = card.getCard_faces();
        if (card_faces4 != null) {
            if (scanFragment.currentFace < card_faces4.size()) {
                MTFace mTFace2 = card_faces4.get(scanFragment.currentFace);
                String printed_type_line2 = mTFace2.getPrinted_type_line();
                if (printed_type_line2 == null) {
                    printed_type_line2 = "";
                }
                String type_line3 = mTFace2.getType_line();
                if (type_line3 != null) {
                    type_line2 = type_line3;
                }
                printed_type_line = printed_type_line2;
            }
            Unit unit28 = Unit.INSTANCE;
            Unit unit29 = Unit.INSTANCE;
        }
        if ((printed_type_line == null || printed_type_line.length() == 0) && Intrinsics.areEqual(card.getLang(), "fr")) {
            if (scanFragment.currentFace == 0) {
                if (cardRecord != null) {
                    printed_type_line = cardRecord.getType_line();
                    Unit unit30 = Unit.INSTANCE;
                    Unit unit31 = Unit.INSTANCE;
                }
            } else if (cardByScryFallId != null) {
                printed_type_line = cardByScryFallId.getType_line();
                Unit unit32 = Unit.INSTANCE;
                Unit unit33 = Unit.INSTANCE;
            }
        }
        if (z2 && str3.length() > 0) {
            printed_type_line = str3;
        }
        if ((z2 || !Intrinsics.areEqual(objectRef.element, "en")) && printed_type_line != null) {
            String str19 = printed_type_line;
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(str19);
            String str20 = printed_type_line;
            str4 = oracleText;
            spannableStringBuilder4.setSpan(new AbsoluteSizeSpan(18, true), 0, str20.length(), 33);
            spannableStringBuilder4.setSpan(new ForegroundColorSpan(-16777216), 0, str20.length(), 33);
            SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder("(" + ((Object) type_line2) + ")");
            str5 = "symbolToImage";
            int i2 = 33;
            spannableStringBuilder5.setSpan(new AbsoluteSizeSpan(16, true), 0, spannableStringBuilder5.length(), 33);
            int i3 = 0;
            spannableStringBuilder5.setSpan(new ForegroundColorSpan(ContextCompat.getColor(scanFragment.requireContext(), R.color.middle_grey)), 0, spannableStringBuilder5.length(), 33);
            final SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder(str19);
            SpannableStringBuilder spannableStringBuilder7 = spannableStringBuilder4;
            int i4 = 0;
            while (i4 < spannableStringBuilder7.length()) {
                spannableStringBuilder6.setSpan(Character.valueOf(spannableStringBuilder7.charAt(i4)), i3, str20.length(), i2);
                i4++;
                spannableStringBuilder5 = spannableStringBuilder5;
                i3 = 0;
                i2 = 33;
            }
            spannableStringBuilder6.append((CharSequence) str17);
            spannableStringBuilder6.append((CharSequence) ("(" + ((Object) type_line2) + ")"));
            SpannableStringBuilder spannableStringBuilder8 = spannableStringBuilder5;
            for (int i5 = 0; i5 < spannableStringBuilder8.length(); i5++) {
                spannableStringBuilder6.setSpan(Character.valueOf(spannableStringBuilder8.charAt(i5)), str20.length() + 1, spannableStringBuilder6.length(), 33);
            }
            scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    ((TextView) objectRef2.element).setText(spannableStringBuilder6);
                }
            });
            Unit unit34 = Unit.INSTANCE;
        } else {
            str4 = oracleText;
            str5 = "symbolToImage";
            if (type_line2 != null) {
                String str21 = type_line2;
                SpannableStringBuilder spannableStringBuilder9 = new SpannableStringBuilder(str21);
                int i6 = 0;
                spannableStringBuilder9.setSpan(new AbsoluteSizeSpan(18, true), 0, type_line2.length(), 33);
                spannableStringBuilder9.setSpan(new ForegroundColorSpan(-16777216), 0, type_line2.length(), 33);
                final SpannableStringBuilder spannableStringBuilder10 = new SpannableStringBuilder(str21);
                SpannableStringBuilder spannableStringBuilder11 = spannableStringBuilder9;
                int i7 = 0;
                while (i7 < spannableStringBuilder11.length()) {
                    spannableStringBuilder10.setSpan(Character.valueOf(spannableStringBuilder11.charAt(i7)), i6, type_line2.length(), 33);
                    i7++;
                    i6 = 0;
                }
                scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda16
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScanFragment.displayMTCard$lambda$33$2(objectRef2, spannableStringBuilder10);
                    }
                });
                Unit unit35 = Unit.INSTANCE;
                Unit unit36 = Unit.INSTANCE;
            }
        }
        final TextView detailOracleTextLabel = scanFragment.getBinding().detailOracleTextLabel;
        Intrinsics.checkNotNullExpressionValue(detailOracleTextLabel, "detailOracleTextLabel");
        final TextView detailOracleTextLabelOriginal = scanFragment.getBinding().detailOracleTextLabelOriginal;
        Intrinsics.checkNotNullExpressionValue(detailOracleTextLabelOriginal, "detailOracleTextLabelOriginal");
        final TextView detailOracleTextShowOriginal = scanFragment.getBinding().detailOracleTextShowOriginal;
        Intrinsics.checkNotNullExpressionValue(detailOracleTextShowOriginal, "detailOracleTextShowOriginal");
        detailOracleTextLabelOriginal.setVisibility(8);
        detailOracleTextShowOriginal.setVisibility(0);
        detailOracleTextShowOriginal.setPaintFlags(detailOracleTextShowOriginal.getPaintFlags() | 8);
        ViewExtensionsKt.setOnClickWithFade(detailOracleTextShowOriginal, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.displayMTCard$lambda$34(detailOracleTextShowOriginal, detailOracleTextLabelOriginal);
            }
        });
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        String oracle_text2 = card.getOracle_text();
        T t2 = oracle_text2;
        if (oracle_text2 == null) {
            t2 = "";
        }
        objectRef3.element = t2;
        String printed_text = card.getPrinted_text();
        if (printed_text == null) {
            printed_text = "";
        }
        List<MTFace> card_faces5 = card.getCard_faces();
        if (card_faces5 != null) {
            if (scanFragment.currentFace < card_faces5.size()) {
                MTFace mTFace3 = card_faces5.get(scanFragment.currentFace);
                String oracle_text3 = mTFace3.getOracle_text();
                T t3 = oracle_text3;
                if (oracle_text3 == null) {
                    t3 = (String) objectRef3.element;
                }
                objectRef3.element = t3;
                String printed_text2 = mTFace3.getPrinted_text();
                if (printed_text2 != null) {
                    printed_text = printed_text2;
                }
            }
            Unit unit37 = Unit.INSTANCE;
            Unit unit38 = Unit.INSTANCE;
        }
        if (!Intrinsics.areEqual(card.getLang(), "en")) {
            List<MTGDBHelperLocalized> list4 = scanFragment.mtgdbHelpersEnabled;
            if (list4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelpersEnabled");
                list4 = null;
            }
            Iterator<MTGDBHelperLocalized> it9 = list4.iterator();
            while (true) {
                if (it9.hasNext()) {
                    MTGDBHelperLocalized next5 = it9.next();
                    if (Intrinsics.areEqual(next5.getLocale(), card.getLang())) {
                        String oracleid7 = card.getOracleid();
                        if (oracleid7 == null) {
                            oracleid7 = "";
                        }
                        printed_text = next5.getOracleForCard(oracleid7, scanFragment.currentFace);
                    }
                }
            }
        }
        if (Intrinsics.areEqual(card.getLang(), "en")) {
            MTGDBHelper mTGDBHelper4 = scanFragment.mtgdbHelper;
            if (mTGDBHelper4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelper");
                mTGDBHelper4 = null;
            }
            String oracleid8 = card.getOracleid();
            if (oracleid8 == null) {
                oracleid8 = "";
            }
            ?? oracleForCard = mTGDBHelper4.getOracleForCard(oracleid8, scanFragment.currentFace);
            if (((CharSequence) oracleForCard).length() > 0) {
                objectRef3.element = oracleForCard;
            }
        }
        String str22 = (!z2 || str4.length() <= 0) ? printed_text : str4;
        objectRef3.element = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default((String) objectRef3.element, "\n", "\n\n", false, 4, (Object) null), "}:", "} :", false, 4, (Object) null), "}{", "} {", false, 4, (Object) null);
        String strReplace$default2 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str22, "\n", "\n\n", false, 4, (Object) null), "}:", "} :", false, 4, (Object) null), "}{", "} {", false, 4, (Object) null);
        SymbolToImage symbolToImage3 = scanFragment.symbolToImage;
        if (symbolToImage3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str5);
            symbolToImage3 = null;
        }
        objectRef3.element = symbolToImage3.removeDuplicateParentheses((String) objectRef3.element);
        SymbolToImage symbolToImage4 = scanFragment.symbolToImage;
        if (symbolToImage4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str5);
            symbolToImage4 = null;
        }
        String strRemoveDuplicateParentheses = symbolToImage4.removeDuplicateParentheses(strReplace$default2);
        if ((z2 || !Intrinsics.areEqual(objectRef.element, "en")) && strRemoveDuplicateParentheses.length() > 0) {
            final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            objectRef4.element = objectRef.element;
            if (z2) {
                objectRef4.element = preferencesManager4.getDeviceLanguage();
            }
            int dimensionPixelSize2 = scanFragment.getResources().getDimensionPixelSize(R.dimen.symbol_oracle_size);
            SymbolToImage symbolToImage5 = scanFragment.symbolToImage;
            if (symbolToImage5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str5);
                symbolToImage = null;
            } else {
                symbolToImage = symbolToImage5;
            }
            Context contextRequireContext3 = scanFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, str2);
            final SpannableString spannableStringStringToAttributedStringWithSymbolsAndLinks = symbolToImage.stringToAttributedStringWithSymbolsAndLinks(strRemoveDuplicateParentheses, dimensionPixelSize2, contextRequireContext3, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScanFragment.displayMTCard$lambda$36(this.f$0, objectRef4, (String) obj);
                }
            }, new ForegroundColorSpan(-1));
            SymbolToImage symbolToImage6 = scanFragment.symbolToImage;
            if (symbolToImage6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str5);
                symbolToImage6 = null;
            }
            String str23 = (String) objectRef3.element;
            Context contextRequireContext4 = scanFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext4, str2);
            final SpannableString spannableStringStringToAttributedStringWithSymbolsAndLinks2 = symbolToImage6.stringToAttributedStringWithSymbolsAndLinks(str23, dimensionPixelSize2, contextRequireContext4, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScanFragment.displayMTCard$lambda$37(this.f$0, objectRef4, (String) obj);
                }
            }, new CharacterStyle[0]);
            scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    ScanFragment.displayMTCard$lambda$38(detailOracleTextLabel, spannableStringStringToAttributedStringWithSymbolsAndLinks, detailOracleTextLabelOriginal, spannableStringStringToAttributedStringWithSymbolsAndLinks2);
                }
            });
        } else {
            final int dimensionPixelSize3 = scanFragment.getResources().getDimensionPixelSize(R.dimen.symbol_oracle_size);
            detailOracleTextShowOriginal.setVisibility(4);
            scanFragment = this;
            scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    ScanFragment.displayMTCard$lambda$39(detailOracleTextLabel, this, objectRef3, dimensionPixelSize3, objectRef);
                }
            });
        }
        String cmc = card.getCmc();
        if (cmc == null || (strValueOf = String.valueOf((int) Double.parseDouble(cmc))) == null) {
            strValueOf = "-";
        }
        final String strValueOf2 = String.valueOf(strValueOf);
        final TextView cmcValueLabel = scanFragment.getBinding().cmcValueLabel;
        Intrinsics.checkNotNullExpressionValue(cmcValueLabel, "cmcValueLabel");
        scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                cmcValueLabel.setText(strValueOf2);
            }
        });
        final MTLegalities legalities = card.getLegalities();
        if (legalities != null) {
            scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda24
                @Override // java.lang.Runnable
                public final void run() {
                    ScanFragment.displayMTCard$lambda$41$0(this.f$0, legalities);
                }
            });
            Unit unit39 = Unit.INSTANCE;
            Unit unit40 = Unit.INSTANCE;
        }
        scanFragment.hasFoil = false;
        scanFragment.hasNonFoil = false;
        List<String> finishes = card.getFinishes();
        if (finishes != null) {
            if (finishes.contains("foil") || finishes.contains("etched")) {
                z5 = true;
                scanFragment.hasFoil = true;
            } else {
                z5 = true;
            }
            if (finishes.contains("nonfoil")) {
                scanFragment.hasNonFoil = z5;
            }
            Unit unit41 = Unit.INSTANCE;
            Unit unit42 = Unit.INSTANCE;
        }
        if (card.getFinish() != null) {
            scanFragment.isFoil = Intrinsics.areEqual(card.getFinish(), "foil") || Intrinsics.areEqual(card.getFinish(), "etched");
            Unit unit43 = Unit.INSTANCE;
            Unit unit44 = Unit.INSTANCE;
        } else {
            List<String> finishes2 = card.getFinishes();
            if (finishes2 != null) {
                if (finishes2.size() == 1 && (finishes2.contains("foil") || finishes2.contains("etched"))) {
                    scanFragment.isFoil = true;
                }
                Unit unit45 = Unit.INSTANCE;
                Unit unit46 = Unit.INSTANCE;
            }
        }
        if (scanFragment.isFoil) {
            scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.getBinding().foilEffectImage.setVisibility(0);
                }
            });
        } else {
            scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.getBinding().foilEffectImage.setVisibility(8);
                }
            });
        }
        if (scanFragment.getActivity() != null) {
            scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.updatePricesUI();
                }
            });
        }
        scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.displayMTCard$lambda$48(this.f$0, card);
            }
        });
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.displayMTCard$lambda$49(this.f$0, card, booleanRef);
            }
        });
        if (scanFragment.offline) {
            if (sceneAlreadyExists) {
                LoadingImageView cardFront = scanFragment.getBinding().cardFront;
                Intrinsics.checkNotNullExpressionValue(cardFront, "cardFront");
                loadCardImage$default(scanFragment, "", cardFront, null, 4, null);
                return;
            } else {
                LoadingImageView cardFront2 = scanFragment.getBinding().cardFront;
                Intrinsics.checkNotNullExpressionValue(cardFront2, "cardFront");
                scanFragment.loadCardImage("", cardFront2, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ScanFragment.displayMTCard$lambda$50(this.f$0);
                    }
                });
                return;
            }
        }
        if (ignoreCardImage) {
            return;
        }
        List<MTImageURIs> images = card.getImages();
        if (images != null) {
            List<MTImageURIs> list5 = images;
            if (list5.size() <= 0) {
                z3 = false;
                if (list5.size() > 1) {
                    String png = images.get(1).getPng();
                    if (png != null) {
                        LoadingImageView cardBack = scanFragment.getBinding().cardBack;
                        Intrinsics.checkNotNullExpressionValue(cardBack, "cardBack");
                        function0 = null;
                        scanFragment.loadCardImage(png, cardBack, null);
                        Unit unit47 = Unit.INSTANCE;
                        Unit unit48 = Unit.INSTANCE;
                    } else {
                        function0 = null;
                        String gatherer = images.get(1).getGatherer();
                        if (gatherer != null) {
                            LoadingImageView cardBack2 = scanFragment.getBinding().cardBack;
                            Intrinsics.checkNotNullExpressionValue(cardBack2, "cardBack");
                            scanFragment.loadCardImage(gatherer, cardBack2, null);
                            Unit unit49 = Unit.INSTANCE;
                            Unit unit50 = Unit.INSTANCE;
                        } else {
                            z4 = z3;
                            z3 = z4;
                        }
                    }
                    z4 = true;
                    z3 = z4;
                } else {
                    function0 = null;
                }
                Unit unit51 = Unit.INSTANCE;
                Unit unit52 = Unit.INSTANCE;
            } else {
                String png2 = ((MTImageURIs) CollectionsKt.first((List) images)).getPng();
                if (png2 != null) {
                    if (sceneAlreadyExists) {
                        LoadingImageView cardFront3 = scanFragment.getBinding().cardFront;
                        Intrinsics.checkNotNullExpressionValue(cardFront3, "cardFront");
                        loadCardImage$default(scanFragment, png2, cardFront3, null, 4, null);
                    } else {
                        LoadingImageView cardFront4 = scanFragment.getBinding().cardFront;
                        Intrinsics.checkNotNullExpressionValue(cardFront4, "cardFront");
                        scanFragment.loadCardImage(png2, cardFront4, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda32
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ScanFragment.displayMTCard$lambda$51$0$0(this.f$0);
                            }
                        });
                    }
                    Unit unit53 = Unit.INSTANCE;
                    Unit unit54 = Unit.INSTANCE;
                } else {
                    String gatherer2 = ((MTImageURIs) CollectionsKt.first((List) images)).getGatherer();
                    if (gatherer2 != null) {
                        if (sceneAlreadyExists) {
                            LoadingImageView cardFront5 = scanFragment.getBinding().cardFront;
                            Intrinsics.checkNotNullExpressionValue(cardFront5, "cardFront");
                            loadCardImage$default(scanFragment, gatherer2, cardFront5, null, 4, null);
                        } else {
                            LoadingImageView cardFront6 = scanFragment.getBinding().cardFront;
                            Intrinsics.checkNotNullExpressionValue(cardFront6, "cardFront");
                            scanFragment.loadCardImage(gatherer2, cardFront6, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda34
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ScanFragment.displayMTCard$lambda$51$1$0$0(this.f$0);
                                }
                            });
                        }
                        Unit unit55 = Unit.INSTANCE;
                        Unit unit56 = Unit.INSTANCE;
                    }
                    z3 = false;
                    if (list5.size() > 1) {
                    }
                    Unit unit512 = Unit.INSTANCE;
                    Unit unit522 = Unit.INSTANCE;
                }
                z3 = true;
                if (list5.size() > 1) {
                }
                Unit unit5122 = Unit.INSTANCE;
                Unit unit5222 = Unit.INSTANCE;
            }
        } else {
            function0 = null;
            z3 = false;
        }
        if (!z3 && (en_images = card.getEn_images()) != null) {
            List<MTImageURIs> list6 = en_images;
            if (list6.size() > 0) {
                String png3 = ((MTImageURIs) CollectionsKt.first((List) en_images)).getPng();
                if (png3 != null) {
                    if (sceneAlreadyExists) {
                        LoadingImageView cardFront7 = scanFragment.getBinding().cardFront;
                        Intrinsics.checkNotNullExpressionValue(cardFront7, "cardFront");
                        loadCardImage$default(scanFragment, png3, cardFront7, null, 4, null);
                    } else {
                        LoadingImageView cardFront8 = scanFragment.getBinding().cardFront;
                        Intrinsics.checkNotNullExpressionValue(cardFront8, "cardFront");
                        scanFragment.loadCardImage(png3, cardFront8, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda35
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ScanFragment.displayMTCard$lambda$52$0$0(this.f$0);
                            }
                        });
                    }
                    Unit unit57 = Unit.INSTANCE;
                    Unit unit58 = Unit.INSTANCE;
                } else {
                    String gatherer3 = ((MTImageURIs) CollectionsKt.first((List) en_images)).getGatherer();
                    if (gatherer3 != null) {
                        if (sceneAlreadyExists) {
                            LoadingImageView cardFront9 = scanFragment.getBinding().cardFront;
                            Intrinsics.checkNotNullExpressionValue(cardFront9, "cardFront");
                            loadCardImage$default(scanFragment, gatherer3, cardFront9, null, 4, null);
                        } else {
                            LoadingImageView cardFront10 = scanFragment.getBinding().cardFront;
                            Intrinsics.checkNotNullExpressionValue(cardFront10, "cardFront");
                            scanFragment.loadCardImage(gatherer3, cardFront10, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda36
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ScanFragment.displayMTCard$lambda$52$1$0$0(this.f$0);
                                }
                            });
                        }
                        Unit unit59 = Unit.INSTANCE;
                        Unit unit60 = Unit.INSTANCE;
                    }
                }
            }
            if (list6.size() > 1) {
                String png4 = en_images.get(1).getPng();
                if (png4 != null) {
                    LoadingImageView cardBack3 = scanFragment.getBinding().cardBack;
                    Intrinsics.checkNotNullExpressionValue(cardBack3, "cardBack");
                    scanFragment.loadCardImage(png4, cardBack3, function0);
                    Unit unit61 = Unit.INSTANCE;
                    Unit unit62 = Unit.INSTANCE;
                } else {
                    String gatherer4 = en_images.get(1).getGatherer();
                    if (gatherer4 != null) {
                        LoadingImageView cardBack4 = scanFragment.getBinding().cardBack;
                        Intrinsics.checkNotNullExpressionValue(cardBack4, "cardBack");
                        scanFragment.loadCardImage(gatherer4, cardBack4, function0);
                        Unit unit63 = Unit.INSTANCE;
                        Unit unit64 = Unit.INSTANCE;
                    }
                }
            }
            Unit unit65 = Unit.INSTANCE;
            Unit unit66 = Unit.INSTANCE;
        }
        scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.displayMTCard$lambda$53(this.f$0);
            }
        });
    }

    static /* synthetic */ void displayMTCard$default(ScanFragment scanFragment, MTFullCard mTFullCard, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        scanFragment.displayMTCard(mTFullCard, z, z2);
    }

    static final void displayMTCard$lambda$1(ScanFragment scanFragment) {
        MaterialButton detailAllPrintsButton = scanFragment.getBinding().detailAllPrintsButton;
        Intrinsics.checkNotNullExpressionValue(detailAllPrintsButton, "detailAllPrintsButton");
        detailAllPrintsButton.setEnabled(true);
    }

    static final void displayMTCard$lambda$2(final ScanFragment scanFragment, MTFullCard mTFullCard) {
        MTComboCard mTComboCard;
        String zone;
        List<MTComboCard> cards;
        Object next;
        int iIntValue;
        String list_name;
        int iIntValue2;
        String list_name2;
        LinearLayout specialTagsLayout = scanFragment.getBinding().specialTagsLayout;
        Intrinsics.checkNotNullExpressionValue(specialTagsLayout, "specialTagsLayout");
        TextView gameChangerTag = scanFragment.getBinding().gameChangerTag;
        Intrinsics.checkNotNullExpressionValue(gameChangerTag, "gameChangerTag");
        TextView reservedListTag = scanFragment.getBinding().reservedListTag;
        Intrinsics.checkNotNullExpressionValue(reservedListTag, "reservedListTag");
        ImageView collectionImage = scanFragment.getBinding().collectionImage;
        Intrinsics.checkNotNullExpressionValue(collectionImage, "collectionImage");
        TextView containerLabel = scanFragment.getBinding().containerLabel;
        Intrinsics.checkNotNullExpressionValue(containerLabel, "containerLabel");
        TextView deckLabel = scanFragment.getBinding().deckLabel;
        Intrinsics.checkNotNullExpressionValue(deckLabel, "deckLabel");
        TextView deckNameLabel = scanFragment.getBinding().deckNameLabel;
        Intrinsics.checkNotNullExpressionValue(deckNameLabel, "deckNameLabel");
        View spacerTags = scanFragment.getBinding().spacerTags;
        Intrinsics.checkNotNullExpressionValue(spacerTags, "spacerTags");
        specialTagsLayout.setVisibility(8);
        gameChangerTag.setVisibility(8);
        reservedListTag.setVisibility(8);
        spacerTags.setVisibility(0);
        collectionImage.setVisibility(8);
        containerLabel.setVisibility(8);
        deckLabel.setVisibility(8);
        deckNameLabel.setVisibility(8);
        Boolean game_changer = mTFullCard.getGame_changer();
        if (game_changer != null && game_changer.booleanValue()) {
            specialTagsLayout.setVisibility(0);
            gameChangerTag.setVisibility(0);
        }
        Boolean reserved = mTFullCard.getReserved();
        if (reserved != null && reserved.booleanValue()) {
            specialTagsLayout.setVisibility(0);
            reservedListTag.setVisibility(0);
        }
        ViewExtensionsKt.setOnClickWithFade(gameChangerTag, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.displayMTCard$lambda$2$2(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(reservedListTag, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.displayMTCard$lambda$2$3(this.f$0);
            }
        });
        Integer list_type = mTFullCard.getList_type();
        if (list_type != null && (((iIntValue2 = list_type.intValue()) == 1 || iIntValue2 == 2) && (list_name2 = mTFullCard.getList_name()) != null)) {
            specialTagsLayout.setVisibility(0);
            collectionImage.setVisibility(0);
            containerLabel.setVisibility(0);
            spacerTags.setVisibility(8);
            if (Intrinsics.areEqual(list_name2, "bulk")) {
                list_name2 = scanFragment.requireContext().getString(R.string.list_bulk);
                Intrinsics.checkNotNullExpressionValue(list_name2, "getString(...)");
            }
            containerLabel.setText(list_name2);
        }
        Integer list_type2 = mTFullCard.getList_type();
        if (list_type2 != null && (((iIntValue = list_type2.intValue()) == 3 || iIntValue == 4 || iIntValue == 5) && (list_name = mTFullCard.getList_name()) != null)) {
            deckLabel.setVisibility(0);
            deckNameLabel.setVisibility(0);
            specialTagsLayout.setVisibility(0);
            spacerTags.setVisibility(8);
            deckNameLabel.setText(list_name);
        }
        if (!scanFragment.comboMode) {
            scanFragment.getBinding().cardZoneLayout.setVisibility(8);
            return;
        }
        MTCombo mTCombo = scanFragment.comboForViewing;
        String str = null;
        if (mTCombo == null || (cards = mTCombo.getCards()) == null) {
            mTComboCard = null;
        } else {
            Iterator<T> it = cards.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((MTComboCard) next).getOracleId(), mTFullCard.getOracleid())) {
                        break;
                    }
                }
            }
            mTComboCard = (MTComboCard) next;
        }
        if (mTComboCard != null && (zone = mTComboCard.getZone()) != null && !StringsKt.isBlank(zone)) {
            str = zone;
        }
        if (str == null) {
            scanFragment.getBinding().cardZoneLayout.setVisibility(8);
            return;
        }
        Character chZoneToIconChar = scanFragment.zoneToIconChar(str);
        Integer numZoneToLabelRes = scanFragment.zoneToLabelRes(str);
        if (chZoneToIconChar == null || numZoneToLabelRes == null) {
            scanFragment.getBinding().cardZoneLayout.setVisibility(8);
            return;
        }
        scanFragment.getBinding().cardZoneIconTextView.setText(String.valueOf(chZoneToIconChar.charValue()));
        scanFragment.getBinding().cardZoneTextView.setText(numZoneToLabelRes.intValue());
        scanFragment.getBinding().cardZoneLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit displayMTCard$lambda$2$2(ScanFragment scanFragment) {
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = scanFragment.getString(R.string.game_changer);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = scanFragment.getString(R.string.game_changer_help);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = scanFragment.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda51
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ScanFragment.displayMTCard$lambda$2$2$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = scanFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "game_changer_help");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit displayMTCard$lambda$2$2$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit displayMTCard$lambda$2$3(ScanFragment scanFragment) {
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = scanFragment.getString(R.string.reserved_list);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = scanFragment.getString(R.string.reserved_list_help);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = scanFragment.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda146
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ScanFragment.displayMTCard$lambda$2$3$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = scanFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "reserved_list_help");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit displayMTCard$lambda$2$3$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void displayMTCard$lambda$33$2(Ref.ObjectRef objectRef, SpannableStringBuilder spannableStringBuilder) {
        ((TextView) objectRef.element).setText(spannableStringBuilder);
    }

    static final Unit displayMTCard$lambda$34(TextView textView, TextView textView2) {
        textView.setVisibility(8);
        textView2.setVisibility(0);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final Unit displayMTCard$lambda$36(ScanFragment scanFragment, Ref.ObjectRef objectRef, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        scanFragment.handleKeywordTap(it, (String) objectRef.element);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final Unit displayMTCard$lambda$37(ScanFragment scanFragment, Ref.ObjectRef objectRef, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        scanFragment.handleKeywordTap(it, (String) objectRef.element);
        return Unit.INSTANCE;
    }

    static final void displayMTCard$lambda$38(TextView textView, SpannableString spannableString, TextView textView2, SpannableString spannableString2) {
        textView.setText(spannableString);
        textView2.setText(spannableString2);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final void displayMTCard$lambda$39(TextView textView, final ScanFragment scanFragment, Ref.ObjectRef objectRef, int i, final Ref.ObjectRef objectRef2) {
        SymbolToImage symbolToImage = scanFragment.symbolToImage;
        if (symbolToImage == null) {
            Intrinsics.throwUninitializedPropertyAccessException("symbolToImage");
            symbolToImage = null;
        }
        String str = (String) objectRef.element;
        Context contextRequireContext = scanFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        textView.setText(symbolToImage.stringToAttributedStringWithSymbolsAndLinks(str, i, contextRequireContext, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda147
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScanFragment.displayMTCard$lambda$39$0(this.f$0, objectRef2, (String) obj);
            }
        }, new ForegroundColorSpan(-3355444)));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit displayMTCard$lambda$39$0(ScanFragment scanFragment, Ref.ObjectRef objectRef, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        scanFragment.handleKeywordTap(it, (String) objectRef.element);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayMTCard$lambda$41$0(ScanFragment scanFragment, MTLegalities mTLegalities) {
        GridLayout legalityGridLayout = scanFragment.getBinding().legalityGridLayout;
        Intrinsics.checkNotNullExpressionValue(legalityGridLayout, "legalityGridLayout");
        legalityGridLayout.removeAllViews();
        String string = scanFragment.getResources().getString(R.string.standard);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        scanFragment.addMaybeLegalityButton(string, mTLegalities.getStandard());
        String string2 = scanFragment.getResources().getString(R.string.pioneer);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        scanFragment.addMaybeLegalityButton(string2, mTLegalities.getPioneer());
        String string3 = scanFragment.getResources().getString(R.string.modern);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        scanFragment.addMaybeLegalityButton(string3, mTLegalities.getModern());
        String string4 = scanFragment.getResources().getString(R.string.legacy);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        scanFragment.addMaybeLegalityButton(string4, mTLegalities.getLegacy());
        String string5 = scanFragment.getResources().getString(R.string.pauper);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        scanFragment.addMaybeLegalityButton(string5, mTLegalities.getPauper());
        String string6 = scanFragment.getResources().getString(R.string.vintage);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        scanFragment.addMaybeLegalityButton(string6, mTLegalities.getVintage());
        String string7 = scanFragment.getResources().getString(R.string.commander);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        scanFragment.addMaybeLegalityButton(string7, mTLegalities.getCommander());
        String string8 = scanFragment.getResources().getString(R.string.duel);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        scanFragment.addMaybeLegalityButton(string8, mTLegalities.getDuel());
        String string9 = scanFragment.getResources().getString(R.string.oathbreaker);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        scanFragment.addMaybeLegalityButton(string9, mTLegalities.getOathbreaker());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final void displayMTCard$lambda$48(ScanFragment scanFragment, MTFullCard mTFullCard) {
        Integer quantity;
        int iIntValue;
        scanFragment.getBinding().qtyTextView.setVisibility(8);
        scanFragment.getBinding().cornerView.setVisibility(8);
        if (mTFullCard.getVariant_quantity() == null || Intrinsics.areEqual(mTFullCard.getVariant_quantity(), mTFullCard.getQuantity())) {
            quantity = mTFullCard.getQuantity();
        } else {
            Integer variant_quantity = mTFullCard.getVariant_quantity();
            Intrinsics.checkNotNull(variant_quantity);
            if (variant_quantity.intValue() > 0) {
                quantity = mTFullCard.getVariant_quantity();
            }
        }
        if (quantity == null || (iIntValue = quantity.intValue()) <= 1) {
            return;
        }
        scanFragment.getBinding().cornerView.setVisibility(0);
        scanFragment.getBinding().qtyTextView.setVisibility(0);
        scanFragment.getBinding().qtyTextView.setText(String.valueOf(iIntValue));
    }

    static final void displayMTCard$lambda$49(ScanFragment scanFragment, MTFullCard mTFullCard, Ref.BooleanRef booleanRef) {
        if (scanFragment.getContext() == null || scanFragment._binding == null) {
            return;
        }
        scanFragment.getBinding().extrasLayout.setVisibility(8);
        Boolean altered = mTFullCard.getAltered();
        if (altered != null) {
            if (altered.booleanValue()) {
                scanFragment.getBinding().alteredTextView.setVisibility(0);
                booleanRef.element = true;
            } else {
                scanFragment.getBinding().alteredTextView.setVisibility(8);
            }
        }
        Boolean signed = mTFullCard.getSigned();
        if (signed != null) {
            if (signed.booleanValue()) {
                scanFragment.getBinding().signedTextView.setVisibility(0);
                booleanRef.element = true;
            } else {
                scanFragment.getBinding().signedTextView.setVisibility(8);
            }
        }
        Boolean missprint = mTFullCard.getMissprint();
        if (missprint != null) {
            if (missprint.booleanValue()) {
                scanFragment.getBinding().misprintTextView.setVisibility(0);
                booleanRef.element = true;
            } else {
                scanFragment.getBinding().misprintTextView.setVisibility(8);
            }
        }
        Boolean proxy = mTFullCard.getProxy();
        if (proxy != null) {
            if (proxy.booleanValue()) {
                scanFragment.getBinding().proxyTextView.setText("\uf0c5");
                scanFragment.getBinding().proxyTextView.setVisibility(0);
                booleanRef.element = true;
            } else {
                scanFragment.getBinding().proxyTextView.setVisibility(8);
            }
        }
        String condition = mTFullCard.getCondition();
        if (condition != null) {
            if (condition.length() > 0) {
                scanFragment.getBinding().conditionTextView.setVisibility(0);
                TextView textView = scanFragment.getBinding().conditionTextView;
                GameUtils companion = GameUtils.INSTANCE.getInstance();
                Context contextRequireContext = scanFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                String upperCase = condition.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                textView.setTextColor(companion.colorForCardCondition(contextRequireContext, upperCase));
                booleanRef.element = true;
            } else {
                scanFragment.getBinding().conditionTextView.setVisibility(8);
            }
        }
        String finish = mTFullCard.getFinish();
        if (finish != null) {
            String lowerCase = finish.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "foil")) {
                scanFragment.getBinding().isFoilImage.setVisibility(0);
                booleanRef.element = true;
            } else {
                scanFragment.getBinding().isFoilImage.setVisibility(8);
            }
        } else {
            List<String> finishes = mTFullCard.getFinishes();
            if (finishes != null && finishes.size() == 1 && (finishes.contains("foil") || finishes.contains("etched"))) {
                scanFragment.getBinding().isFoilImage.setVisibility(0);
                booleanRef.element = true;
            }
        }
        if (booleanRef.element) {
            scanFragment.getBinding().extrasLayout.setVisibility(0);
        }
    }

    static final Unit displayMTCard$lambda$50(ScanFragment scanFragment) {
        scanFragment.animateCardFlip();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit displayMTCard$lambda$51$0$0(ScanFragment scanFragment) {
        scanFragment.animateCardFlip();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit displayMTCard$lambda$51$1$0$0(ScanFragment scanFragment) {
        scanFragment.animateCardFlip();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit displayMTCard$lambda$52$0$0(ScanFragment scanFragment) {
        scanFragment.animateCardFlip();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit displayMTCard$lambda$52$1$0$0(ScanFragment scanFragment) {
        scanFragment.animateCardFlip();
        return Unit.INSTANCE;
    }

    static final void displayMTCard$lambda$53(ScanFragment scanFragment) {
        scanFragment.getBinding().cardFront.setImageColorDimmed(scanFragment.isComboCardMissing(scanFragment.currentMTCard));
        scanFragment.getBinding().cardBack.setImageColorDimmed(scanFragment.isComboCardMissing(scanFragment.currentMTCard));
    }

    private final void fetchCard(CardMatch cardMatch, final boolean sceneAlreadyExists) {
        if (getContext() == null) {
            return;
        }
        NetworkHelper networkHelper = NetworkHelper.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (networkHelper.isNetworkAvailable(contextRequireContext)) {
            MTApiKt.getMtApi().getCardByScryfallId(cardMatch.getScryfallId()).enqueue(new Callback<MTCardResponse>() { // from class: com.studiolaganne.lengendarylens.ScanFragment.fetchCard.1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCardResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    Log.d(ScanFragment.TAG, "FetchCard Error");
                    ScanFragment.this.showInternetError();
                    ScanFragment.this.animatingCards = false;
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCardResponse> call, Response<MTCardResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (response.isSuccessful()) {
                        MTCardResponse mTCardResponseBody = response.body();
                        MTFullCard card = mTCardResponseBody != null ? mTCardResponseBody.getCard() : null;
                        if (card != null) {
                            ScanFragment scanFragment = ScanFragment.this;
                            boolean z = sceneAlreadyExists;
                            if (scanFragment.getActivity() == null || scanFragment.getContext() == null) {
                                return;
                            }
                            ScanFragment.displayMTCard$default(scanFragment, card, z, false, 4, null);
                        }
                    }
                }
            });
        } else {
            fetchCardOffline(cardMatch, sceneAlreadyExists);
        }
    }

    static /* synthetic */ void fetchCard$default(ScanFragment scanFragment, CardMatch cardMatch, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        scanFragment.fetchCard(cardMatch, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x020f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void fetchCardOffline(CardMatch cardMatch, boolean sceneAlreadyExists) {
        ArrayList arrayList;
        String set;
        String number;
        String layout;
        String title;
        String type_line;
        String oracle_text;
        String title2;
        String title3;
        if (getContext() == null) {
            return;
        }
        this.currentFace = cardMatch.getFace();
        this.currentCardMatch = cardMatch;
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        CardRecord cardLocal = companion.getCardLocal(contextRequireContext, cardMatch.getScryfallId(), 0);
        GameUtils companion2 = GameUtils.INSTANCE.getInstance();
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        CardRecord cardLocal2 = companion2.getCardLocal(contextRequireContext2, cardMatch.getScryfallId(), 1);
        if (cardLocal2 != null) {
            MTFace mTFace = new MTFace(null, (cardLocal == null || (title3 = cardLocal.getTitle()) == null) ? "" : title3, cardLocal != null ? cardLocal.getMana_cost() : null, cardLocal != null ? cardLocal.getType_line() : null, cardLocal != null ? cardLocal.getOracle_text() : null, null, null, null, null, (cardLocal == null || (title2 = cardLocal.getTitle()) == null) ? "" : title2, null, null, null, 7649, null);
            MTFace mTFace2 = new MTFace(null, cardLocal2.getTitle(), cardLocal2.getMana_cost(), cardLocal2.getType_line(), cardLocal2.getOracle_text(), null, null, null, null, cardLocal2.getTitle(), null, null, null, 7649, null);
            arrayList = new ArrayList();
            arrayList.add(mTFace);
            arrayList.add(mTFace2);
        } else {
            arrayList = null;
        }
        MTFullCard mTFullCard = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
        mTFullCard.setCard_faces(arrayList);
        mTFullCard.setScryfallid(cardMatch.getScryfallId());
        mTFullCard.setOracleid(cardMatch.getOracleId());
        if (cardLocal == null || (set = cardLocal.getSet()) == null) {
            set = cardMatch.getSet();
        }
        mTFullCard.setSet_code(set);
        if (cardLocal == null || (number = cardLocal.getNumber()) == null) {
            number = cardMatch.getNumber();
        }
        mTFullCard.setCollector_number(number);
        mTFullCard.setLang(cardMatch.getLang());
        if (cardLocal == null || (layout = cardLocal.getLayout()) == null) {
            layout = "normal";
        }
        mTFullCard.setLayout(layout);
        mTFullCard.setFinish(null);
        mTFullCard.setFinishes(null);
        if (cardMatch.getFace() == 0) {
            title = cardLocal != null ? cardLocal.getTitle() : null;
        } else if (cardLocal2 != null) {
            title = cardLocal2.getTitle();
        }
        if (title == null) {
            title = "";
        }
        mTFullCard.setName(title);
        mTFullCard.setCurrent_value_eur(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        mTFullCard.setCurrent_value_usd(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        mTFullCard.setCurrent_value_eur_foil(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        mTFullCard.setCurrent_value_usd_foil(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        mTFullCard.setImages(CollectionsKt.emptyList());
        mTFullCard.setRarity("");
        if (cardMatch.getFace() == 0) {
            type_line = cardLocal != null ? cardLocal.getType_line() : null;
        } else if (cardLocal2 != null) {
            type_line = cardLocal2.getType_line();
        }
        if (type_line == null) {
            type_line = "";
        }
        mTFullCard.setType_line(type_line);
        if (cardMatch.getFace() == 0) {
            oracle_text = cardLocal != null ? cardLocal.getOracle_text() : null;
        } else if (cardLocal2 != null) {
            oracle_text = cardLocal2.getOracle_text();
        }
        mTFullCard.setOracle_text(oracle_text != null ? oracle_text : "");
        mTFullCard.setMana_cost(cardLocal != null ? cardLocal.getMana_cost() : null);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass2(mTFullCard, sceneAlreadyExists, null), 3, null);
    }

    static /* synthetic */ void fetchCardOffline$default(ScanFragment scanFragment, CardMatch cardMatch, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        scanFragment.fetchCardOffline(cardMatch, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchCardWithParameters(CardMatch match, PreferencesManager prefs, String originalLang, String originalSet, boolean isRetry) {
        if (CombinedAnalyzerKt.getDEBUG_LOG()) {
            Log.d(TAG, "--->>> fetchCardWithParameters - Fetching card : " + match.getTitle() + " - " + match.getLang() + " - " + match.getSet() + " - " + match.getNumber() + " (retry: " + isRetry + ")");
        }
        MTApi mtApi = MTApiKt.getMtApi();
        String lang = match.getLang();
        String set = match.getSet();
        String number = match.getNumber();
        MTUser currentUser = prefs.getCurrentUser();
        mtApi.getCardWithParameters(lang, set, number, currentUser != null ? Integer.valueOf(currentUser.getId()) : null).enqueue(new C12321(match, isRetry, prefs, originalLang, originalSet));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchNextCard() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        this.animatingCards = true;
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_fetch_next_card");
        if (this.hasMTCards) {
            final MTFullCard mTFullCard = this.currentMTCardList.get(this.currentCardListIndex + 1);
            final LoadingImageView cardNext = getBinding().cardNext;
            Intrinsics.checkNotNullExpressionValue(cardNext, "cardNext");
            loadCardImageWithCallback(getMTCardImageURL(mTFullCard), cardNext, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.fetchNextCard$lambda$0(this.f$0, mTFullCard, cardNext);
                }
            });
            this.animatingCards = false;
        }
    }

    static final Unit fetchNextCard$lambda$0(ScanFragment scanFragment, MTFullCard mTFullCard, LoadingImageView loadingImageView) {
        scanFragment.nextMTCard = mTFullCard;
        loadingImageView.setImageColorDimmed(scanFragment.isComboCardMissing(mTFullCard));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchPreviousCard() {
        int i;
        if (getContext() == null || this._binding == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_fetch_previous_card");
        this.animatingCards = true;
        if (this.hasMTCards) {
            if (this.currentMTCardList.isEmpty() || (i = this.currentCardListIndex) == 0 || i >= this.currentMTCardList.size()) {
                this.animatingCards = false;
                return;
            }
            final MTFullCard mTFullCard = this.currentMTCardList.get(this.currentCardListIndex - 1);
            final LoadingImageView cardPrevious = getBinding().cardPrevious;
            Intrinsics.checkNotNullExpressionValue(cardPrevious, "cardPrevious");
            loadCardImageWithCallback(getMTCardImageURL(mTFullCard), cardPrevious, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda131
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.fetchPreviousCard$lambda$0(this.f$0, mTFullCard, cardPrevious);
                }
            });
            this.animatingCards = false;
        }
    }

    static final Unit fetchPreviousCard$lambda$0(ScanFragment scanFragment, MTFullCard mTFullCard, LoadingImageView loadingImageView) {
        scanFragment.previousMTCard = mTFullCard;
        loadingImageView.setImageColorDimmed(scanFragment.isComboCardMissing(mTFullCard));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchRulings() {
        CardMatch cardMatch;
        if (getContext() == null || this.offline || (cardMatch = this.currentCardMatch) == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (new PreferencesManager(contextRequireContext).getBoolean(PreferencesManager.TRANSLATE_RULINGS, false)) {
            RulingsDBHelper.Companion companion = RulingsDBHelper.INSTANCE;
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            RulingsDBHelper companion2 = companion.getInstance(contextRequireContext2, "fr");
            if (companion2.isValid()) {
                List<String> rulingsForCard = companion2.getRulingsForCard(cardMatch.getOracleId());
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.symbol_oracle_size);
                this.rulings.clear();
                for (String str : rulingsForCard) {
                    List<SpannableString> list = this.rulings;
                    SymbolToImage symbolToImage = this.symbolToImage;
                    if (symbolToImage == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("symbolToImage");
                        symbolToImage = null;
                    }
                    if (str == null) {
                        str = "";
                    }
                    list.add(symbolToImage.stringToAttributedStringWithSymbols(str, dimensionPixelSize, new CharacterStyle[0]));
                }
                if (rulingsForCard.isEmpty()) {
                    this.rulings.add(new SpannableString(getResources().getString(R.string.no_rules)));
                }
                LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new ScanFragment$fetchRulings$1$1(this, null), 3, null);
                return;
            }
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("rulings_db_invalid", null);
        }
        ScryFallApiKt.getApi().getCardRulings("https://api.scryfall.com/cards/" + cardMatch.getScryfallId() + "/rulings").enqueue(new Callback<Rules>() { // from class: com.studiolaganne.lengendarylens.ScanFragment$fetchRulings$1$2
            @Override // retrofit2.Callback
            public void onFailure(Call<Rules> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<Rules> call, Response<Rules> response) {
                Rules rulesBody;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isSuccessful() || this.this$0.getActivity() == null || (rulesBody = response.body()) == null) {
                    return;
                }
                List<Ruling> data = rulesBody.getData();
                if (data == null) {
                    data = CollectionsKt.emptyList();
                }
                int dimensionPixelSize2 = this.this$0.getResources().getDimensionPixelSize(R.dimen.symbol_oracle_size);
                this.this$0.rulings.clear();
                for (Ruling ruling : data) {
                    List list2 = this.this$0.rulings;
                    SymbolToImage symbolToImage2 = this.this$0.symbolToImage;
                    if (symbolToImage2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("symbolToImage");
                        symbolToImage2 = null;
                    }
                    String comment = ruling.getComment();
                    if (comment == null) {
                        comment = "";
                    }
                    list2.add(symbolToImage2.stringToAttributedStringWithSymbols(comment, dimensionPixelSize2, new CharacterStyle[0]));
                }
                if (this.this$0.rulings.isEmpty()) {
                    this.this$0.rulings.add(new SpannableString(this.this$0.getResources().getString(R.string.no_rules)));
                }
                LinearLayout detailsRulingLayout = this.this$0.getBinding().detailsRulingLayout;
                Intrinsics.checkNotNullExpressionValue(detailsRulingLayout, "detailsRulingLayout");
                detailsRulingLayout.removeAllViews();
                for (SpannableString spannableString : this.this$0.rulings) {
                    View viewInflate = this.this$0.getLayoutInflater().inflate(R.layout.ruling_item, (ViewGroup) detailsRulingLayout, false);
                    ((TextView) viewInflate.findViewById(R.id.rulingTextView)).setText(spannableString);
                    detailsRulingLayout.addView(viewInflate);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getBackFaceMTCardImageURL(MTFullCard card) {
        return card.getImageUrl(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentScanBinding getBinding() {
        FragmentScanBinding fragmentScanBinding = this._binding;
        Intrinsics.checkNotNull(fragmentScanBinding);
        return fragmentScanBinding;
    }

    private final Bitmap getBitmapFromImageView(LoadingImageView imageView) {
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_get_bitmap");
        Drawable drawable = imageView.getDrawable();
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private final String getCurrentDateString() {
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final SoundPool getHighPriceSoundPool() {
        Object value = this.highPriceSoundPool.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SoundPool) value;
    }

    private final String getMTCardImageURL(MTFullCard card) {
        return card.getImageUrl(0);
    }

    private final Bitmap getRoundedCornerBitmap(Bitmap bitmap, float cornerRadius) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-16777216);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), cornerRadius, cornerRadius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19, types: [T, com.studiolaganne.lengendarylens.GlossaryEntry] */
    /* JADX WARN: Type inference failed for: r2v7, types: [T, com.studiolaganne.lengendarylens.GlossaryEntry] */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, com.studiolaganne.lengendarylens.GlossaryEntry] */
    private final void handleKeywordTap(final String keyword, String lang) {
        Object next;
        Object next2;
        SymbolToImage symbolToImage;
        Object next3;
        if (getActivity() == null || getContext() == null) {
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (this.currentMTCard != null) {
            if (Intrinsics.areEqual(lang, "en")) {
                String strProcessKeyword = SearchDataUtils.INSTANCE.getInstance().processKeyword(keyword, "en");
                Iterator<T> it = GlossaryManager.INSTANCE.getEnGlossaryEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it.next();
                    String lowerCase = ((GlossaryEntry) next3).getKey().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = strProcessKeyword.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                        break;
                    }
                }
                ?? r1 = (GlossaryEntry) next3;
                if (r1 != 0) {
                    objectRef.element = r1;
                }
            } else if (Intrinsics.areEqual(lang, "fr")) {
                String strProcessKeyword2 = SearchDataUtils.INSTANCE.getInstance().processKeyword(keyword, "fr");
                List<GlossaryEntry> frGlossaryEntries = GlossaryManager.INSTANCE.getFrGlossaryEntries();
                Iterator<T> it2 = frGlossaryEntries.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    String lowerCase3 = ((GlossaryEntry) next).getKey().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    String lowerCase4 = strProcessKeyword2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                    if (Intrinsics.areEqual(lowerCase3, lowerCase4)) {
                        break;
                    }
                }
                ?? r6 = (GlossaryEntry) next;
                if (r6 != 0) {
                    objectRef.element = r6;
                } else {
                    Iterator<T> it3 = frGlossaryEntries.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it3.next();
                        String lowerCase5 = ((GlossaryEntry) next2).getKey().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                        String lowerCase6 = strProcessKeyword2.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase6, "toLowerCase(...)");
                        if (StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) lowerCase6, false, 2, (Object) null)) {
                            break;
                        }
                    }
                    ?? r2 = (GlossaryEntry) next2;
                    if (r2 != 0) {
                        objectRef.element = r2;
                    } else {
                        new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda118
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ScanFragment.handleKeywordTap$lambda$4$2(keyword, objectRef);
                            }
                        };
                    }
                }
            }
            GlossaryEntry glossaryEntry = (GlossaryEntry) objectRef.element;
            if (glossaryEntry != null) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), R.style.TransparentBottomSheetDialog);
                View viewInflate = getLayoutInflater().inflate(R.layout.bottom_sheet_glossary_layout, (ViewGroup) null);
                Window window = bottomSheetDialog.getWindow();
                if (window != null) {
                    window.setBackgroundDrawableResource(android.R.color.transparent);
                }
                bottomSheetDialog.setContentView(viewInflate);
                TextView textView = (TextView) viewInflate.findViewById(R.id.title);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.body);
                textView.setText(glossaryEntry.getKey());
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.symbol_oracle_size);
                SymbolToImage symbolToImage2 = this.symbolToImage;
                if (symbolToImage2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("symbolToImage");
                    symbolToImage = null;
                } else {
                    symbolToImage = symbolToImage2;
                }
                String value = glossaryEntry.getValue();
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                textView2.setText(symbolToImage.stringToAttributedStringWithSymbolsAndLinks(value, dimensionPixelSize, contextRequireContext, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda119
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ScanFragment.handleKeywordTap$lambda$5$0(this.f$0, (String) obj);
                    }
                }, new CharacterStyle[0]));
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                bottomSheetDialog.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, com.studiolaganne.lengendarylens.GlossaryEntry] */
    public static final Unit handleKeywordTap$lambda$4$2(String str, Ref.ObjectRef objectRef) {
        Object next;
        Iterator<T> it = GlossaryManager.INSTANCE.getEnGlossaryEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            String lowerCase = ((GlossaryEntry) next).getKey().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String lowerCase2 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                break;
            }
        }
        ?? r1 = (GlossaryEntry) next;
        if (r1 == 0) {
            return null;
        }
        objectRef.element = r1;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleKeywordTap$lambda$5$0(ScanFragment scanFragment, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (scanFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Intent intent = new Intent(scanFragment.requireContext(), (Class<?>) RulesActivity.class);
        intent.putExtra("section", it);
        scanFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    private final void initializeScannedCardAdapter() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        this.scannedCardsAdapter = new ScannedCardsAdapter(this);
        getBinding().scanListRecyclerView.setAdapter(this.scannedCardsAdapter);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (this.scanToDeckMode) {
            List<MTFullCard> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getCurrentDeckScanList());
            this.currentScanList = mutableList;
            if (mutableList.isEmpty()) {
                getBinding().addToButton.setVisibility(8);
            } else {
                getBinding().addToButton.setVisibility(0);
            }
            getBinding().scanListExportTextView.setVisibility(8);
            getBinding().addToDeckTextView.setText(getString(R.string.add_to_deck));
            ConstraintLayout addToButton = getBinding().addToButton;
            Intrinsics.checkNotNullExpressionValue(addToButton, "addToButton");
            ViewExtensionsKt.setOnClickWithFade(addToButton, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda62
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.initializeScannedCardAdapter$lambda$0(this.f$0);
                }
            });
            getBinding().scanListTitle.setText(this.scanToDeckName);
            getBinding().scanListBackImage.setVisibility(0);
            ImageView scanListBackImage = getBinding().scanListBackImage;
            Intrinsics.checkNotNullExpressionValue(scanListBackImage, "scanListBackImage");
            ViewExtensionsKt.setOnClickWithFade(scanListBackImage, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda63
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.initializeScannedCardAdapter$lambda$1(this.f$0);
                }
            });
            TextView scanListTitle = getBinding().scanListTitle;
            Intrinsics.checkNotNullExpressionValue(scanListTitle, "scanListTitle");
            ViewExtensionsKt.setOnClickWithFade(scanListTitle, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda64
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.initializeScannedCardAdapter$lambda$2(this.f$0);
                }
            });
        } else if (this.scanToListMode) {
            List<MTFullCard> mutableList2 = CollectionsKt.toMutableList((Collection) preferencesManager.getCurrentListScanList(this.scanToListId));
            this.currentScanList = mutableList2;
            if (mutableList2.isEmpty()) {
                getBinding().addToButton.setVisibility(8);
            } else {
                getBinding().addToButton.setVisibility(0);
            }
            getBinding().scanListExportTextView.setVisibility(8);
            getBinding().addToDeckTextView.setText(getString(R.string.add_to_list));
            ConstraintLayout addToButton2 = getBinding().addToButton;
            Intrinsics.checkNotNullExpressionValue(addToButton2, "addToButton");
            ViewExtensionsKt.setOnClickWithFade(addToButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda65
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.initializeScannedCardAdapter$lambda$3(this.f$0);
                }
            });
            getBinding().scanListTitle.setText(this.scanToListName);
            getBinding().scanListBackImage.setVisibility(0);
            ImageView scanListBackImage2 = getBinding().scanListBackImage;
            Intrinsics.checkNotNullExpressionValue(scanListBackImage2, "scanListBackImage");
            ViewExtensionsKt.setOnClickWithFade(scanListBackImage2, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda67
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.initializeScannedCardAdapter$lambda$4(this.f$0);
                }
            });
            TextView scanListTitle2 = getBinding().scanListTitle;
            Intrinsics.checkNotNullExpressionValue(scanListTitle2, "scanListTitle");
            ViewExtensionsKt.setOnClickWithFade(scanListTitle2, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda68
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.initializeScannedCardAdapter$lambda$5(this.f$0);
                }
            });
        } else {
            List<MTFullCard> mutableList3 = CollectionsKt.toMutableList((Collection) preferencesManager.getCurrentUserScanList());
            this.currentScanList = mutableList3;
            if (mutableList3.isEmpty()) {
                getBinding().addToButton.setVisibility(8);
            } else {
                getBinding().addToButton.setVisibility(0);
            }
            getBinding().addToDeckTextView.setText(getString(R.string.add_to_ellipsis));
            ConstraintLayout addToButton3 = getBinding().addToButton;
            Intrinsics.checkNotNullExpressionValue(addToButton3, "addToButton");
            ViewExtensionsKt.setOnClickWithFade(addToButton3, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda69
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.initializeScannedCardAdapter$lambda$6(this.f$0);
                }
            });
        }
        if (this.currentScanList.isEmpty() || this.pickACardMode) {
            return;
        }
        ScannedCardsAdapter scannedCardsAdapter = this.scannedCardsAdapter;
        if (scannedCardsAdapter != null) {
            scannedCardsAdapter.updateCards(this.currentScanList);
        }
        getBinding().scanListRecyclerView.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda70
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.initializeScannedCardAdapter$lambda$7(this.f$0);
            }
        }, 200L);
        getBinding().scanListTopLayout.setVisibility(0);
        getBinding().scanListBottomLayout.setVisibility(0);
        updateCardCountAndTotalPrice();
        updateScanSettingsOverrideIndicator();
    }

    static final Unit initializeScannedCardAdapter$lambda$0(ScanFragment scanFragment) {
        if (scanFragment.currentScanList.isEmpty()) {
            Toast.makeText(scanFragment.requireContext(), R.string.no_cards_to_add, 0).show();
            return Unit.INSTANCE;
        }
        Intent intent = new Intent();
        intent.putExtra("scannedCardsId", ScannedCardsTempStorage.INSTANCE.storeScannedCards(scanFragment.currentScanList));
        FragmentActivity activity = scanFragment.getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = scanFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        return Unit.INSTANCE;
    }

    static final Unit initializeScannedCardAdapter$lambda$1(ScanFragment scanFragment) {
        Intent intent = new Intent();
        intent.putExtra("scanCancelled", true);
        FragmentActivity activity = scanFragment.getActivity();
        if (activity != null) {
            activity.setResult(0, intent);
        }
        FragmentActivity activity2 = scanFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        return Unit.INSTANCE;
    }

    static final Unit initializeScannedCardAdapter$lambda$2(ScanFragment scanFragment) {
        Intent intent = new Intent();
        intent.putExtra("scanCancelled", true);
        FragmentActivity activity = scanFragment.getActivity();
        if (activity != null) {
            activity.setResult(0, intent);
        }
        FragmentActivity activity2 = scanFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        return Unit.INSTANCE;
    }

    static final Unit initializeScannedCardAdapter$lambda$3(ScanFragment scanFragment) {
        if (scanFragment.currentScanList.isEmpty()) {
            Toast.makeText(scanFragment.requireContext(), R.string.no_cards_to_add, 0).show();
            return Unit.INSTANCE;
        }
        Intent intent = new Intent();
        intent.putExtra("scannedCardsId", ScannedCardsTempStorage.INSTANCE.storeScannedCards(scanFragment.currentScanList));
        FragmentActivity activity = scanFragment.getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = scanFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        return Unit.INSTANCE;
    }

    static final Unit initializeScannedCardAdapter$lambda$4(ScanFragment scanFragment) {
        Intent intent = new Intent();
        intent.putExtra("scanCancelled", true);
        FragmentActivity activity = scanFragment.getActivity();
        if (activity != null) {
            activity.setResult(0, intent);
        }
        FragmentActivity activity2 = scanFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        return Unit.INSTANCE;
    }

    static final Unit initializeScannedCardAdapter$lambda$5(ScanFragment scanFragment) {
        Intent intent = new Intent();
        intent.putExtra("scanCancelled", true);
        FragmentActivity activity = scanFragment.getActivity();
        if (activity != null) {
            activity.setResult(0, intent);
        }
        FragmentActivity activity2 = scanFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        return Unit.INSTANCE;
    }

    static final Unit initializeScannedCardAdapter$lambda$6(final ScanFragment scanFragment) {
        if (!scanFragment.currentScanList.isEmpty() && !scanFragment.scanTutorialActive) {
            if (scanFragment.getContext() == null || scanFragment.getActivity() == null) {
                return Unit.INSTANCE;
            }
            Context contextRequireContext = scanFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            if (preferencesManager.getCurrentUser() == null) {
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string = scanFragment.getString(R.string.scan_list_account_required_title);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CustomDialogFragment.Builder title = builder.setTitle(string);
                String string2 = scanFragment.getString(R.string.scan_list_account_required_body);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder body = title.setBody(string2);
                String string3 = scanFragment.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda115
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScanFragment.initializeScannedCardAdapter$lambda$6$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                });
                FragmentManager childFragmentManager = scanFragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                positiveButton.show(childFragmentManager, "CustomDialogFragment");
                return Unit.INSTANCE;
            }
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
            List<MTDeck> currentUserDecks = preferencesManager.getCurrentUserDecks();
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(scanFragment.requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("scan_cards_save_to_collection", null);
            scanFragment.observing = false;
            CombinedAnalyzer combinedAnalyzer = scanFragment.combinedAnalyzer;
            if (combinedAnalyzer != null) {
                combinedAnalyzer.setPaused(true);
            }
            new MoveCardDialogFragment.Builder().setAddMode(true).setCollection(currentUserCollection).setLists(currentUserLists).setDecks(currentUserDecks).setListener(new MoveCardDialogListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$initializeScannedCardAdapter$7$moveCardDialog$1
                @Override // com.studiolaganne.lengendarylens.MoveCardDialogListener
                public void onCancelMoveCard() {
                    this.this$0.observing = true;
                    CombinedAnalyzer combinedAnalyzer2 = this.this$0.combinedAnalyzer;
                    if (combinedAnalyzer2 != null) {
                        combinedAnalyzer2.setPaused(false);
                    }
                }

                @Override // com.studiolaganne.lengendarylens.MoveCardDialogListener
                public void onMoveCard(int destinationContainerId, int quantity, boolean isNewContainer, String newContainerName, Integer newContainerType) {
                    this.this$0.observing = true;
                    CombinedAnalyzer combinedAnalyzer2 = this.this$0.combinedAnalyzer;
                    if (combinedAnalyzer2 != null) {
                        combinedAnalyzer2.setPaused(false);
                    }
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
                        this.this$0.addScanListToContainer(destinationContainerId);
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
                    Call<MTCardListResponse> callCreateList = MTApiKt.getMtApi().createList(currentUser.getId(), mTEditListBody);
                    this.this$0.getBinding().loadingOverlay.setVisibility(0);
                    final ScanFragment scanFragment2 = this.this$0;
                    callCreateList.enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.ScanFragment$initializeScannedCardAdapter$7$moveCardDialog$1$onMoveCard$1
                        @Override // retrofit2.Callback
                        public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(t, "t");
                            if (scanFragment2.getContext() == null || scanFragment2._binding == null) {
                                return;
                            }
                            Log.e("ScanFragment", "Failed to create MT Card List: " + t.getMessage());
                            scanFragment2.getBinding().loadingOverlay.setVisibility(8);
                            Toast.makeText(scanFragment2.requireContext(), R.string.error_creating_list, 0).show();
                        }

                        @Override // retrofit2.Callback
                        public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                            MTCardContainer list;
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(response, "response");
                            if (scanFragment2.getActivity() == null || scanFragment2.getContext() == null) {
                                return;
                            }
                            scanFragment2.getBinding().loadingOverlay.setVisibility(8);
                            if (!response.isSuccessful()) {
                                Toast.makeText(scanFragment2.requireContext(), R.string.error_creating_list, 0).show();
                                return;
                            }
                            MTCardListResponse mTCardListResponseBody = response.body();
                            if (mTCardListResponseBody == null || (list = mTCardListResponseBody.getList()) == null) {
                                return;
                            }
                            scanFragment2.addScanListToContainer(list.getId());
                        }
                    });
                }
            }).build().show(scanFragment.getChildFragmentManager(), MoveCardDialogFragment.TAG);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initializeScannedCardAdapter$lambda$6$0(ScanFragment scanFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (scanFragment._binding == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final void initializeScannedCardAdapter$lambda$7(ScanFragment scanFragment) {
        RecyclerView recyclerView = scanFragment.getBinding().scanListRecyclerView;
        ScannedCardsAdapter scannedCardsAdapter = scanFragment.scannedCardsAdapter;
        recyclerView.scrollToPosition((scannedCardsAdapter != null ? scannedCardsAdapter.getItemCount() : 1) - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAftermath() {
        String lowerCase;
        String oracle_text;
        MTFace mTFace;
        String oracle_text2;
        MTFace mTFace2;
        MTFullCard mTFullCard = this.currentMTCard;
        if (mTFullCard != null) {
            String layout = mTFullCard.getLayout();
            if (layout != null) {
                lowerCase = layout.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (Intrinsics.areEqual(lowerCase, "split")) {
                List<MTFace> card_faces = mTFullCard.getCard_faces();
                String str = "";
                if (card_faces == null || (mTFace2 = card_faces.get(0)) == null || (oracle_text = mTFace2.getOracle_text()) == null) {
                    oracle_text = "";
                }
                List<MTFace> card_faces2 = mTFullCard.getCard_faces();
                if (card_faces2 != null && (mTFace = card_faces2.get(1)) != null && (oracle_text2 = mTFace.getOracle_text()) != null) {
                    str = oracle_text2;
                }
                String lowerCase2 = oracle_text.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (!StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "aftermath", false, 2, (Object) null)) {
                    String lowerCase3 = str.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    if (!StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "aftermath", false, 2, (Object) null)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isComboCardMissing(MTFullCard card) {
        MTCombo mTCombo;
        List<MTComboCard> cards;
        Object next;
        if (this.comboMode && card != null && (mTCombo = this.comboForViewing) != null && (cards = mTCombo.getCards()) != null) {
            Iterator<T> it = cards.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(((MTComboCard) next).getOracleId(), card.getOracleid())) {
                    break;
                }
            }
            MTComboCard mTComboCard = (MTComboCard) next;
            if (mTComboCard != null && !mTComboCard.getInDeck()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isLegendaryCreature() {
        String type_line;
        MTFullCard mTFullCard = this.currentMTCard;
        if (mTFullCard != null) {
            List<MTFace> card_faces = mTFullCard.getCard_faces();
            if (card_faces == null) {
                String type_line2 = mTFullCard.getType_line();
                if (type_line2 != null) {
                    String lowerCase = type_line2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    boolean zContains$default = lowerCase != null ? StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "legendary", false, 2, (Object) null) : false;
                    if (zContains$default) {
                        String type_line3 = mTFullCard.getType_line();
                        if (type_line3 != null) {
                            String lowerCase2 = type_line3.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                            boolean zContains$default2 = lowerCase2 != null ? StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "creature", false, 2, (Object) null) : false;
                            if (zContains$default2) {
                                return true;
                            }
                        }
                    }
                }
            } else if (this.currentFace < card_faces.size() && (type_line = card_faces.get(this.currentFace).getType_line()) != null) {
                String lowerCase3 = type_line.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "legendary", false, 2, (Object) null)) {
                    String lowerCase4 = type_line.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) "creature", false, 2, (Object) null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadCardImage$default(ScanFragment scanFragment, String str, LoadingImageView loadingImageView, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        scanFragment.loadCardImage(str, loadingImageView, function0);
    }

    static final Unit loadCardImage$lambda$0(ScanFragment scanFragment, Function0 function0) {
        if (scanFragment.getContext() == null || scanFragment.getActivity() == null) {
            return Unit.INSTANCE;
        }
        Log.d(TAG, "------>>> loadCardImageWithCallback : IMAGE READY - onImageReady = " + (function0 != null));
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    static final Unit loadCardImage$lambda$1(Function0 function0) {
        Log.d(TAG, "!!!! loadCardImage - failed to load image");
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    static final Unit loadCardImageWithCallback$lambda$0(ScanFragment scanFragment, Function0 function0) {
        if (scanFragment.getContext() == null || scanFragment.getActivity() == null) {
            return Unit.INSTANCE;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_card_image_ready");
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit loadCardImageWithCallback$lambda$1(Function0 function0) {
        Log.d(TAG, "!!!! loadCardImageWithCallback - failed to load image");
        function0.invoke();
        return Unit.INSTANCE;
    }

    private final void loadNextPageOfCards() {
        if (getActivity() == null || getContext() == null || this._binding == null || this.currentListId <= 0 || this.currentDeckListId > 0 || this.isLoadingNextPage) {
            return;
        }
        this.isLoadingNextPage = true;
        getBinding().loadingOverlay.setVisibility(0);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null) {
            return;
        }
        final int i = this.currentPage + 1;
        MTApi.getUserList$default(MTApiKt.getMtApi(), currentUser.getId(), this.currentListId, this.currentNameFilter, this.currentScryfallFilter, Integer.valueOf(i), Integer.valueOf(this.cardsPerPage), this.currentOrderBy, this.currentGroupBy, this.currentOrderDirection, (Intrinsics.areEqual(this.currentOrderBy, FirebaseAnalytics.Param.PRICE) || Intrinsics.areEqual(this.currentOrderBy, "total_price")) ? preferencesManager.getPreferredCurrency().toString() : null, null, null, null, 7168, null).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.ScanFragment.loadNextPageOfCards.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (ScanFragment.this.getActivity() == null || ScanFragment.this.getContext() == null || ScanFragment.this._binding == null) {
                    return;
                }
                ScanFragment.this.getBinding().loadingOverlay.setVisibility(8);
                ScanFragment.this.isLoadingNextPage = false;
                Log.e(ScanFragment.TAG, "Error loading next page: " + t.getMessage());
                Toast.makeText(ScanFragment.this.requireContext(), R.string.error_loading_list, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (ScanFragment.this.getActivity() == null || ScanFragment.this.getContext() == null || ScanFragment.this._binding == null) {
                    return;
                }
                ScanFragment.this.getBinding().loadingOverlay.setVisibility(8);
                ScanFragment.this.isLoadingNextPage = false;
                if (!response.isSuccessful()) {
                    ResponseBody responseBodyErrorBody = response.errorBody();
                    Log.e(ScanFragment.TAG, "Error loading next page: " + (responseBodyErrorBody != null ? responseBodyErrorBody.string() : null));
                    Toast.makeText(ScanFragment.this.requireContext(), R.string.error_loading_list, 0).show();
                    return;
                }
                MTCardListResponse mTCardListResponseBody = response.body();
                if (mTCardListResponseBody != null) {
                    ScanFragment scanFragment = ScanFragment.this;
                    int i2 = i;
                    MTCardContainer list = mTCardListResponseBody.getList();
                    if (list != null) {
                        ArrayList cards = list.getCards();
                        if (cards == null) {
                            cards = CollectionsKt.emptyList();
                        }
                        if (cards.isEmpty() && scanFragment.currentGroupBy != null && list.getGrouped_cards() != null) {
                            List<MTCardGroup> grouped_cards = list.getGrouped_cards();
                            if (grouped_cards == null) {
                                grouped_cards = CollectionsKt.emptyList();
                            }
                            cards = new ArrayList();
                            Iterator<MTCardGroup> it = grouped_cards.iterator();
                            while (it.hasNext()) {
                                List<MTFullCard> cards2 = it.next().getCards();
                                if (cards2 != null) {
                                    cards.addAll(cards2);
                                }
                            }
                        }
                        List<MTFullCard> list2 = cards;
                        if (list2.isEmpty()) {
                            return;
                        }
                        List<MTFullCard> mutableList = CollectionsKt.toMutableList((Collection) scanFragment.currentMTCardList);
                        mutableList.addAll(list2);
                        scanFragment.currentMTCardList = mutableList;
                        scanFragment.currentPage = i2;
                        CardDataStore.INSTANCE.setMtCardList(mutableList);
                        scanFragment.updateNextPrevious();
                        if (scanFragment.currentCardListIndex < scanFragment.currentMTCardList.size() - 1) {
                            scanFragment.fetchNextCard();
                        }
                    }
                }
            }
        });
    }

    private final void loadSvgImage(Context context, String url, ImageView imageView) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveCardToContainer(int destinationId, int applyToQTy) {
        MTFullCard mTFullCard;
        if (getActivity() == null || getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null || (mTFullCard = this.currentMTCard) == null) {
            return;
        }
        MTMoveCardsBody mTMoveCardsBody = new MTMoveCardsBody(0, null, 3, null);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < applyToQTy; i++) {
            MTCardReference mTCardReference = new MTCardReference(0, 1, null);
            List<Integer> list_card_ids = mTFullCard.getList_card_ids();
            mTCardReference.setList_card_id(list_card_ids != null ? list_card_ids.get(i).intValue() : 0);
            arrayList.add(mTCardReference);
        }
        mTMoveCardsBody.setCards(arrayList);
        mTMoveCardsBody.setTarget(destinationId);
        int iIntValue = this.currentListId;
        if (iIntValue == -1) {
            Integer listid = mTFullCard.getListid();
            iIntValue = listid != null ? listid.intValue() : -1;
        }
        Call<MTMoveCardsResponse> callMoveCardsFromList = MTApiKt.getMtApi().moveCardsFromList(currentUser.getId(), iIntValue, this.currentNameFilter, this.currentScryfallFilter, this.currentGroupBy, this.currentOrderBy, this.currentOrderDirection, null, null, null, mTMoveCardsBody);
        getBinding().loadingOverlay.setVisibility(0);
        callMoveCardsFromList.enqueue(new Callback<MTMoveCardsResponse>() { // from class: com.studiolaganne.lengendarylens.ScanFragment.moveCardToContainer.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTMoveCardsResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                ScanFragment.this.getBinding().loadingOverlay.setVisibility(8);
                Log.e(ScanFragment.TAG, "Error moving card", t);
                Toast.makeText(ScanFragment.this.requireContext(), R.string.error_moving_card, 0).show();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTMoveCardsResponse> call, Response<MTMoveCardsResponse> response) {
                MTMoveCardsResponse mTMoveCardsResponseBody;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                ScanFragment.this.getBinding().loadingOverlay.setVisibility(8);
                if (response.isSuccessful() && (mTMoveCardsResponseBody = response.body()) != null) {
                    PreferencesManager preferencesManager2 = preferencesManager;
                    ScanFragment scanFragment = ScanFragment.this;
                    if (mTMoveCardsResponseBody.getSuccess()) {
                        MTCardContainer target = mTMoveCardsResponseBody.getTarget();
                        if (target != null) {
                            preferencesManager2.incrementContainerVersion(target.getId());
                            CardContainerCache.INSTANCE.setCachedContainer(target, target.getId());
                        }
                        MTCardContainer source = mTMoveCardsResponseBody.getSource();
                        if (source != null) {
                            List<MTFullCard> cards = source.getCards();
                            if (cards == null || !cards.isEmpty()) {
                                scanFragment.updateCardListFromNewContainer(source);
                                return;
                            }
                            FragmentActivity activity = scanFragment.getActivity();
                            if (activity != null) {
                                activity.finish();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                Toast.makeText(ScanFragment.this.requireContext(), R.string.error_moving_card, 0).show();
            }
        });
    }

    private final void moveToNextCard() {
        String lowerCase;
        if (getContext() == null || this._binding == null || !this.hasMTCards || this.animatingCards) {
            return;
        }
        this.translateCardIfPossible = true;
        if (this.currentCardListIndex == this.currentMTCardList.size() - 1) {
            return;
        }
        if (this.hasMTCards && !this.isLoadingNextPage && this.currentListId > 0) {
            int size = this.currentMTCardList.size() - this.currentCardListIndex;
            boolean z = this.currentMTCardList.size() < this.totalCards;
            if (size <= 2 && z) {
                loadNextPageOfCards();
            }
        }
        if (this.currentFace == 1) {
            resetToFrontFace();
        } else {
            MTFullCard mTFullCard = this.currentMTCard;
            if (mTFullCard != null) {
                String layout = mTFullCard.getLayout();
                if (layout != null) {
                    lowerCase = layout.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                } else {
                    lowerCase = null;
                }
                boolean zAreEqual = Intrinsics.areEqual(lowerCase, "split");
                boolean zIsAftermath = isAftermath();
                if (zAreEqual && !zIsAftermath) {
                    resetSplitCardRotation();
                }
            }
        }
        ConstraintLayout cardNextContainer = getBinding().cardNextContainer;
        Intrinsics.checkNotNullExpressionValue(cardNextContainer, "cardNextContainer");
        ConstraintLayout cardPreviousContainer = getBinding().cardPreviousContainer;
        Intrinsics.checkNotNullExpressionValue(cardPreviousContainer, "cardPreviousContainer");
        this.animatingCards = true;
        getBinding().cardZoneLayout.setVisibility(8);
        getBinding().flipCardButton.setVisibility(4);
        ConstraintLayout cardFrontContainer = getBinding().cardFrontContainer;
        Intrinsics.checkNotNullExpressionValue(cardFrontContainer, "cardFrontContainer");
        ConstraintLayout cardBackContainer = getBinding().cardBackContainer;
        Intrinsics.checkNotNullExpressionValue(cardBackContainer, "cardBackContainer");
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(cardNextContainer, new Pair(Float.valueOf(cardNextContainer.getX()), Float.valueOf(cardNextContainer.getY()))), TuplesKt.to(cardPreviousContainer, new Pair(Float.valueOf(cardPreviousContainer.getX()), Float.valueOf(cardPreviousContainer.getY()))), TuplesKt.to(cardFrontContainer, new Pair(Float.valueOf(cardFrontContainer.getX()), Float.valueOf(cardFrontContainer.getY()))), TuplesKt.to(cardBackContainer, new Pair(Float.valueOf(cardBackContainer.getX()), Float.valueOf(cardBackContainer.getY()))));
        Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to(cardNextContainer, new Pair(Float.valueOf(cardNextContainer.getScaleX()), Float.valueOf(cardNextContainer.getScaleY()))), TuplesKt.to(cardPreviousContainer, new Pair(Float.valueOf(cardPreviousContainer.getScaleX()), Float.valueOf(cardPreviousContainer.getScaleY()))), TuplesKt.to(cardFrontContainer, new Pair(Float.valueOf(cardFrontContainer.getScaleX()), Float.valueOf(cardFrontContainer.getScaleY()))), TuplesKt.to(cardBackContainer, new Pair(Float.valueOf(cardBackContainer.getScaleX()), Float.valueOf(cardBackContainer.getScaleY()))));
        ObjectAnimator duration = ObjectAnimator.ofFloat(cardPreviousContainer, (Property<ConstraintLayout, Float>) View.ALPHA, 1.0f, 0.0f).setDuration(200L);
        Intrinsics.checkNotNullExpressionValue(duration, "setDuration(...)");
        ConstraintLayout constraintLayout = cardFrontContainer;
        AnimatorSet animatorSetCreateMoveAndScaleAnimation$default = createMoveAndScaleAnimation$default(this, cardNextContainer, constraintLayout, 0L, 4, null);
        ConstraintLayout constraintLayout2 = cardPreviousContainer;
        AnimatorSet animatorSetCreateMoveAndScaleAnimation$default2 = createMoveAndScaleAnimation$default(this, constraintLayout, constraintLayout2, 0L, 4, null);
        AnimatorSet animatorSetCreateMoveAndScaleAnimation$default3 = createMoveAndScaleAnimation$default(this, cardBackContainer, constraintLayout2, 0L, 4, null);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, animatorSetCreateMoveAndScaleAnimation$default, animatorSetCreateMoveAndScaleAnimation$default2, animatorSetCreateMoveAndScaleAnimation$default3);
        animatorSet.addListener(new ScanFragment$moveToNextCard$2$1(mapMapOf, mapMapOf2, cardPreviousContainer, this));
        animatorSet.start();
    }

    private final void moveToPreviousCard() {
        String lowerCase;
        if (getContext() == null || this._binding == null || !this.hasMTCards || this.animatingCards || this.currentCardListIndex == 0) {
            return;
        }
        this.translateCardIfPossible = true;
        ConstraintLayout cardNextContainer = getBinding().cardNextContainer;
        Intrinsics.checkNotNullExpressionValue(cardNextContainer, "cardNextContainer");
        ConstraintLayout cardPreviousContainer = getBinding().cardPreviousContainer;
        Intrinsics.checkNotNullExpressionValue(cardPreviousContainer, "cardPreviousContainer");
        if (this.currentFace == 1) {
            resetToFrontFace();
        } else {
            MTFullCard mTFullCard = this.currentMTCard;
            if (mTFullCard != null) {
                String layout = mTFullCard.getLayout();
                if (layout != null) {
                    lowerCase = layout.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                } else {
                    lowerCase = null;
                }
                boolean zAreEqual = Intrinsics.areEqual(lowerCase, "split");
                boolean zIsAftermath = isAftermath();
                if (zAreEqual && !zIsAftermath) {
                    resetSplitCardRotation();
                }
            }
        }
        this.animatingCards = true;
        getBinding().cardZoneLayout.setVisibility(8);
        getBinding().flipCardButton.setVisibility(4);
        ConstraintLayout cardFrontContainer = getBinding().cardFrontContainer;
        Intrinsics.checkNotNullExpressionValue(cardFrontContainer, "cardFrontContainer");
        ConstraintLayout cardBackContainer = getBinding().cardBackContainer;
        Intrinsics.checkNotNullExpressionValue(cardBackContainer, "cardBackContainer");
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(cardNextContainer, new Pair(Float.valueOf(cardNextContainer.getX()), Float.valueOf(cardNextContainer.getY()))), TuplesKt.to(cardPreviousContainer, new Pair(Float.valueOf(cardPreviousContainer.getX()), Float.valueOf(cardPreviousContainer.getY()))), TuplesKt.to(cardFrontContainer, new Pair(Float.valueOf(cardFrontContainer.getX()), Float.valueOf(cardFrontContainer.getY()))), TuplesKt.to(cardBackContainer, new Pair(Float.valueOf(cardBackContainer.getX()), Float.valueOf(cardBackContainer.getY()))));
        Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to(cardNextContainer, new Pair(Float.valueOf(cardNextContainer.getScaleX()), Float.valueOf(cardNextContainer.getScaleY()))), TuplesKt.to(cardPreviousContainer, new Pair(Float.valueOf(cardPreviousContainer.getScaleX()), Float.valueOf(cardPreviousContainer.getScaleY()))), TuplesKt.to(cardFrontContainer, new Pair(Float.valueOf(cardFrontContainer.getScaleX()), Float.valueOf(cardFrontContainer.getScaleY()))), TuplesKt.to(cardBackContainer, new Pair(Float.valueOf(cardBackContainer.getScaleX()), Float.valueOf(cardBackContainer.getScaleY()))));
        ObjectAnimator duration = ObjectAnimator.ofFloat(cardNextContainer, (Property<ConstraintLayout, Float>) View.ALPHA, 1.0f, 0.0f).setDuration(200L);
        Intrinsics.checkNotNullExpressionValue(duration, "setDuration(...)");
        ConstraintLayout constraintLayout = cardFrontContainer;
        AnimatorSet animatorSetCreateMoveAndScaleAnimation$default = createMoveAndScaleAnimation$default(this, cardPreviousContainer, constraintLayout, 0L, 4, null);
        ConstraintLayout constraintLayout2 = cardNextContainer;
        AnimatorSet animatorSetCreateMoveAndScaleAnimation$default2 = createMoveAndScaleAnimation$default(this, constraintLayout, constraintLayout2, 0L, 4, null);
        AnimatorSet animatorSetCreateMoveAndScaleAnimation$default3 = createMoveAndScaleAnimation$default(this, cardBackContainer, constraintLayout2, 0L, 4, null);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, animatorSetCreateMoveAndScaleAnimation$default, animatorSetCreateMoveAndScaleAnimation$default2, animatorSetCreateMoveAndScaleAnimation$default3);
        animatorSet.addListener(new ScanFragment$moveToPreviousCard$2$1(mapMapOf, mapMapOf2, cardNextContainer, this));
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void noRulings() {
        this.rulings.clear();
        this.rulings.add(new SpannableString(getResources().getString(R.string.no_rules_offline)));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C12351(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBack() {
        if (this._binding == null) {
            return;
        }
        if (this.noScanMode) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                Intent intent = new Intent();
                intent.putExtra("backFromCard", true);
                activity.setResult(-1, intent);
                activity.finish();
                return;
            }
            return;
        }
        getBinding().overlayView.undim();
        getBinding().scrollView.setVisibility(4);
        getBinding().topBar.setVisibility(4);
        getBinding().actionItemsLayout.setVisibility(4);
        if (!this.noScanMode) {
            getBinding().scanListTopLayout.setVisibility(0);
        }
        if (!this.currentScanList.isEmpty() && !this.pickACardMode) {
            getBinding().addToButton.setVisibility(0);
            getBinding().scanListBottomLayout.setVisibility(0);
            updateScanSettingsOverrideIndicator();
            startCameraCapture();
        }
        resetCapture();
        Context context = getContext();
        if (context != null) {
            PreferencesManager preferencesManager = new PreferencesManager(context);
            int i = preferencesManager.getInt(PreferencesManager.NUM_SCANS, 0);
            if (preferencesManager.getBoolean(PreferencesManager.SCAN_RATING_PROMPT_SHOWN, false) || i < 2) {
                return;
            }
            preferencesManager.setBoolean(PreferencesManager.SCAN_RATING_PROMPT_SHOWN, true);
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("rating_prompt_scan", null);
            final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(context);
            Intrinsics.checkNotNullExpressionValue(reviewManagerCreate, "create(...)");
            reviewManagerCreate.requestReviewFlow().addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda59
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    ScanFragment.onBack$lambda$1$0(this.f$0, reviewManagerCreate, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBack$lambda$1$0(ScanFragment scanFragment, ReviewManager reviewManager, Task it) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(it, "it");
        if (!it.isSuccessful() || (activity = scanFragment.getActivity()) == null) {
            return;
        }
        reviewManager.launchReviewFlow(activity, (ReviewInfo) it.getResult());
    }

    static final void onCardLanguageClick$lambda$0(ScanFragment scanFragment) {
        scanFragment.getBinding().scrollView.scrollTo(0, 0);
        scanFragment.getBinding().overlayView.undim();
        scanFragment.getBinding().scrollView.setVisibility(4);
        scanFragment.getBinding().topBar.setVisibility(4);
        scanFragment.getBinding().actionItemsLayout.setVisibility(4);
        scanFragment.prices = null;
        scanFragment.enPrices = null;
        scanFragment.hasFoil = false;
        scanFragment.hasNonFoil = true;
        scanFragment.isFoil = false;
        scanFragment.getBinding().cardZone.setBackgroundResource(R.drawable.custom_card_zone_background);
        scanFragment.removeCheckmarkAnimation();
        scanFragment.getBinding().flipCardButton.setVisibility(4);
        if (scanFragment.pickACardMode) {
            scanFragment.getBinding().backToGameButton.setVisibility(0);
            scanFragment.getBinding().backToGameLabel.setVisibility(4);
        } else if (scanFragment.backFromGame) {
            scanFragment.getBinding().backToGameButton.setVisibility(0);
            scanFragment.getBinding().backToGameLabel.setVisibility(0);
        } else {
            scanFragment.getBinding().backToGameButton.setVisibility(4);
            scanFragment.getBinding().backToGameLabel.setVisibility(4);
        }
        ConstraintLayout cardFrontContainer = scanFragment.getBinding().cardFrontContainer;
        Intrinsics.checkNotNullExpressionValue(cardFrontContainer, "cardFrontContainer");
        ConstraintLayout cardBackContainer = scanFragment.getBinding().cardBackContainer;
        Intrinsics.checkNotNullExpressionValue(cardBackContainer, "cardBackContainer");
        cardFrontContainer.setRotation(0.0f);
        cardFrontContainer.setTranslationX(0.0f);
        cardFrontContainer.setTranslationY(0.0f);
        cardFrontContainer.setScaleX(1.0f);
        cardFrontContainer.setScaleY(1.0f);
        cardBackContainer.setRotation(0.0f);
        cardBackContainer.setTranslationX(0.0f);
        cardBackContainer.setTranslationY(0.0f);
        cardBackContainer.setScaleX(1.0f);
        cardBackContainer.setScaleY(1.0f);
        LoadingImageView cardBack = scanFragment.getBinding().cardBack;
        Intrinsics.checkNotNullExpressionValue(cardBack, "cardBack");
        cardBack.setImageResource(R.drawable.card_back);
    }

    static final Unit onScannedCardEditClick$lambda$0(ScanFragment scanFragment) {
        scanFragment.editDialogShowing = false;
        if (scanFragment.scanPaused) {
            return Unit.INSTANCE;
        }
        scanFragment.observing = true;
        CombinedAnalyzer combinedAnalyzer = scanFragment.combinedAnalyzer;
        if (combinedAnalyzer != null) {
            combinedAnalyzer.setPaused(false);
        }
        return Unit.INSTANCE;
    }

    static final Unit onScannedCardEditClick$lambda$1(ScanFragment scanFragment, int i, Integer num, Integer num2, String str, String str2, String str3, MTFullCard mTFullCard, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Integer num3, Double d) {
        if (scanFragment.getActivity() == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        if (scanFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        scanFragment.editDialogShowing = false;
        MTFullCard mTFullCard2 = scanFragment.currentScanList.get(i);
        if (num != null) {
            mTFullCard2.setQuantity(Integer.valueOf(num.intValue()));
        }
        if (mTFullCard != null) {
            mTFullCard2.setCardid(mTFullCard.getCardid());
            mTFullCard2.setScryfallid(mTFullCard.getScryfallid());
            mTFullCard2.setLang(mTFullCard.getLang());
            mTFullCard2.setFinish(mTFullCard.getFinish());
            mTFullCard2.setSet_code(mTFullCard.getSet_code());
            mTFullCard2.setSet_name(mTFullCard.getSet_name());
            mTFullCard2.setCollector_number(mTFullCard.getCollector_number());
            mTFullCard2.setImages(mTFullCard.getImages());
            mTFullCard2.setEn_images(mTFullCard.getEn_images());
            mTFullCard2.setCurrent_value_eur(mTFullCard.getCurrent_value_eur());
            mTFullCard2.setCurrent_value_usd(mTFullCard.getCurrent_value_usd());
            mTFullCard2.setCurrent_value_eur_foil(mTFullCard.getCurrent_value_eur_foil());
            mTFullCard2.setCurrent_value_usd_foil(mTFullCard.getCurrent_value_usd_foil());
            mTFullCard2.setCurrent_value_eur_etched(mTFullCard.getCurrent_value_eur_etched());
            mTFullCard2.setCurrent_value_usd_etched(mTFullCard.getCurrent_value_usd_etched());
            mTFullCard2.setValues(mTFullCard.getValues());
            mTFullCard2.setFinishes(mTFullCard.getFinishes());
        }
        if (str != null) {
            mTFullCard2.setLang(str);
        }
        if (bool != null) {
            mTFullCard2.setAltered(Boolean.valueOf(bool.booleanValue()));
        }
        if (str3 != null) {
            mTFullCard2.setCondition(str3);
        }
        if (str2 != null) {
            mTFullCard2.setFinish(str2);
        }
        if (bool2 != null) {
            bool2.booleanValue();
            mTFullCard2.setSigned(bool2);
        }
        if (bool3 != null) {
            bool3.booleanValue();
            mTFullCard2.setMissprint(bool3);
        }
        if (bool4 != null) {
            bool4.booleanValue();
            mTFullCard2.setProxy(bool4);
        }
        if (d != null) {
            mTFullCard2.setPurchase_price(Double.valueOf(d.doubleValue()));
        }
        scanFragment.currentScanList.set(i, mTFullCard2);
        Context contextRequireContext = scanFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (scanFragment.scanToDeckMode) {
            preferencesManager.saveCurrentDeckScanList(scanFragment.currentScanList);
        } else if (scanFragment.scanToListMode) {
            preferencesManager.saveCurrentListScanList(scanFragment.scanToListId, scanFragment.currentScanList);
        } else {
            preferencesManager.saveCurrentUserScanList(scanFragment.currentScanList);
        }
        if (!scanFragment.scanPaused) {
            scanFragment.observing = true;
            CombinedAnalyzer combinedAnalyzer = scanFragment.combinedAnalyzer;
            if (combinedAnalyzer != null) {
                combinedAnalyzer.setPaused(false);
            }
        }
        ScannedCardsAdapter scannedCardsAdapter = scanFragment.scannedCardsAdapter;
        if (scannedCardsAdapter != null) {
            scannedCardsAdapter.updateCard(i, mTFullCard2);
        }
        scanFragment.updateCardCountAndTotalPrice();
        return Unit.INSTANCE;
    }

    static final void onScannedCardFinishToggled$lambda$1(ScanFragment scanFragment, int i, MTFullCard mTFullCard) {
        ScannedCardsAdapter scannedCardsAdapter = scanFragment.scannedCardsAdapter;
        if (scannedCardsAdapter != null) {
            scannedCardsAdapter.updateCard(i, mTFullCard);
        }
    }

    static final void onScannedCardQuantityChanged$lambda$0(ScanFragment scanFragment, int i, MTFullCard mTFullCard) {
        ScannedCardsAdapter scannedCardsAdapter = scanFragment.scannedCardsAdapter;
        if (scannedCardsAdapter != null) {
            scannedCardsAdapter.updateCard(i, mTFullCard);
        }
    }

    static final Unit onViewCreated$lambda$0(final ScanFragment scanFragment, final String oracleId, final String scryfallId, final String title, final String set, final String number, final int i, final String lang) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(lang, "lang");
        scanFragment.backgroundHandler.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda128
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.onViewCreated$lambda$0$0(this.f$0, oracleId, scryfallId, lang, i, set, number, title);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$0(ScanFragment scanFragment, String str, String str2, String str3, int i, String str4, String str5, String str6) {
        if (scanFragment.getActivity() == null || scanFragment.getContext() == null) {
            return;
        }
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            Log.d(TAG, "@@@@@@@@@@@@@@@@@@ WARNING: onCardDetected is called from UI THREAD @@@@@@@@@@@@@@@@@@");
        }
        if (!scanFragment.observing) {
            CombinedAnalyzer combinedAnalyzer = scanFragment.combinedAnalyzer;
            if (combinedAnalyzer != null) {
                combinedAnalyzer.resetContinuousState();
                return;
            }
            return;
        }
        CardMatch cardMatch = new CardMatch(null, null, 0, 0L, null, null, null, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, false, null, 2097151, null);
        cardMatch.setOracleId(str);
        cardMatch.setScryfallId(str2);
        cardMatch.setDetectedCardLang(str3);
        cardMatch.setLang(str3);
        cardMatch.setFace(i);
        cardMatch.setSet(str4);
        cardMatch.setNumber(str5);
        scanFragment.currentFace = i;
        scanFragment.currentCardMatch = cardMatch;
        Log.d(TAG, "==============================================================");
        Log.d(TAG, "==============================================================");
        Log.d(TAG, "Card detected: title = " + str6);
        Log.d(TAG, "Card detected: scryfallId = " + str2);
        Log.d(TAG, "Card detected: oracleId = " + str);
        Log.d(TAG, "Card detected: set = " + str4);
        Log.d(TAG, "Card detected: number = " + str5);
        Log.d(TAG, "Card detected: face = " + i);
        Log.d(TAG, "Card detected: lang = " + str3);
        Log.d(TAG, "==============================================================");
        Log.d(TAG, "==============================================================");
        Context contextRequireContext = scanFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        int i2 = preferencesManager.getInt(PreferencesManager.NUM_SCANS, 0) + 1;
        preferencesManager.setInt(PreferencesManager.NUM_SCANS, i2);
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(scanFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        if (i2 == 1) {
            Breadcrumbs.INSTANCE.leaveBreadcrumb("first_scan");
            firebaseAnalytics.logEvent("first_scan", null);
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("new_scan");
        firebaseAnalytics.logEvent("new_scan", null);
        preferencesManager.setString(PreferencesManager.LAST_SCAN_DATE, scanFragment.getCurrentDateString());
        MTFullCard mTFullCard = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
        mTFullCard.setScryfallid(cardMatch.getScryfallId());
        mTFullCard.setOracleid(cardMatch.getOracleId());
        mTFullCard.setSet_code(cardMatch.getSet());
        mTFullCard.setCollector_number(cardMatch.getNumber());
        mTFullCard.setLang(cardMatch.getLang());
        preferencesManager.syncRecentCard(mTFullCard);
        if (scanFragment.pickACardMode) {
            scanFragment.fetchCard(cardMatch, false);
            scanFragment.fetchRulings();
        } else {
            scanFragment.sameCardPrompted = false;
            scanFragment.addScannedCardMatch(cardMatch);
        }
    }

    static final Unit onViewCreated$lambda$1(final ScanFragment scanFragment) {
        if (scanFragment.getContext() == null || scanFragment.getActivity() == null) {
            return Unit.INSTANCE;
        }
        scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda162
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.onViewCreated$lambda$1$0(this.f$0);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$0(ScanFragment scanFragment) {
        int i;
        if (scanFragment.sameCardPrompted || (i = scanFragment.sameCardPromptedCount) >= 2) {
            scanFragment.sameCardPrompted = false;
            return;
        }
        scanFragment.sameCardPrompted = true;
        scanFragment.sameCardPromptedCount = i + 1;
        Toast toastMakeText = Toast.makeText(scanFragment.requireContext(), "Tap screen to allow adding the same card back to back.", 1);
        toastMakeText.setGravity(17, 0, 0);
        toastMakeText.show();
    }

    static final Unit onViewCreated$lambda$10(ScanFragment scanFragment) {
        if (scanFragment.currentMTCard != null && scanFragment.getContext() != null) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(scanFragment.requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("all_prints_tap", null);
            Intent intent = new Intent(scanFragment.requireContext(), (Class<?>) AllPrintsActivity.class);
            MTFullCard mTFullCard = scanFragment.currentMTCard;
            if (mTFullCard != null) {
                intent.putExtra("currentMTCardId", mTFullCard.getCardid());
            }
            intent.putExtra("currentFace", scanFragment.currentFace);
            scanFragment.allPrintsActivityLauncher.launch(intent);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    static final CharSequence onViewCreated$lambda$11(MTComboCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getName();
    }

    static final Unit onViewCreated$lambda$12(ScanFragment scanFragment) {
        FragmentActivity activity = scanFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$13(MTCombo mTCombo, ScanFragment scanFragment) {
        String str = "https://commanderspellbook.com/combo/" + mTCombo.getId();
        Intent intent = new Intent(scanFragment.requireContext(), (Class<?>) WebActivity.class);
        intent.putExtra("url", str);
        scanFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$15(final ScanFragment scanFragment) {
        if (scanFragment.getContext() == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = scanFragment.getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = scanFragment.getString(R.string.confirm_card_delete);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = scanFragment.getString(R.string.delete);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda60
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ScanFragment.onViewCreated$lambda$15$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = scanFragment.getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda61
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScanFragment.onViewCreated$lambda$15$1(this.f$0, (CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = scanFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "CustomDialogFragment");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$15$0(final ScanFragment scanFragment, boolean z, CustomDialogFragment dialog) {
        boolean z2;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (scanFragment.getContext() == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        Context contextRequireContext = scanFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        MTEditCardBody mTEditCardBody = new MTEditCardBody(null, 1, null);
        mTEditCardBody.setCards(new MTEditCardActions(null, null, null, 7, null));
        ArrayList arrayList = new ArrayList();
        int i = scanFragment.currentListId;
        int iIntValue = scanFragment.currentDeckListId;
        if (iIntValue != -1) {
            z2 = true;
        } else {
            iIntValue = i;
            z2 = false;
        }
        MTFullCard mTFullCard = scanFragment.currentMTCard;
        if (mTFullCard != null) {
            if (i == -1) {
                Integer listid = mTFullCard.getListid();
                iIntValue = listid != null ? listid.intValue() : -1;
            }
            List<Integer> list_card_ids = mTFullCard.getList_card_ids();
            if (list_card_ids != null) {
                Iterator<Integer> it = list_card_ids.iterator();
                while (it.hasNext()) {
                    int iIntValue2 = it.next().intValue();
                    MTCardReference mTCardReference = new MTCardReference(0, 1, null);
                    mTCardReference.setList_card_id(iIntValue2);
                    arrayList.add(mTCardReference);
                }
            }
        }
        int i2 = iIntValue;
        MTEditCardActions cards = mTEditCardBody.getCards();
        if (cards != null) {
            cards.setDeleted(arrayList);
        }
        if (currentUser != null) {
            scanFragment.getBinding().loadingOverlay.setVisibility(0);
            MTApiKt.getMtApi().editCardsFromList(currentUser.getId(), i2, scanFragment.currentNameFilter, scanFragment.currentScryfallFilter, scanFragment.currentGroupBy, scanFragment.currentOrderBy, scanFragment.currentOrderDirection, Boolean.valueOf(z2), null, null, null, mTEditCardBody).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.ScanFragment$onViewCreated$15$1$2$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    Log.e("ScanFragment", "Failed to edit MT Card: " + t.getMessage());
                    this.this$0.getBinding().loadingOverlay.setVisibility(8);
                    Toast.makeText(this.this$0.requireContext(), R.string.error_deleting_card, 0).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getActivity() == null || this.this$0.getContext() == null) {
                        return;
                    }
                    if (!response.isSuccessful()) {
                        this.this$0.getBinding().loadingOverlay.setVisibility(8);
                        Toast.makeText(this.this$0.requireContext(), R.string.error_deleting_card, 0).show();
                        return;
                    }
                    MTCardListResponse mTCardListResponseBody = response.body();
                    MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                    if (list != null) {
                        this.this$0.updateCardListFromNewContainer(list);
                    }
                    this.this$0.getBinding().loadingOverlay.setVisibility(8);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$15$1(ScanFragment scanFragment, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (scanFragment.getContext() == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$16(final ScanFragment scanFragment) {
        if (scanFragment.getContext() == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = scanFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        final MTFullCard mTFullCard = scanFragment.currentMTCard;
        if (mTFullCard != null && preferencesManager.getCurrentUser() != null) {
            if (scanFragment.currentDeck == null || scanFragment.currentDeckLists == null || scanFragment.currentDeckListId == -1) {
                MTCollection currentUserCollection = preferencesManager.getCurrentUserCollection();
                if (currentUserCollection == null) {
                    currentUserCollection = new MTCollection(null, null, null, null, 0, 0, null, null, 255, null);
                }
                MTUserLists currentUserLists = preferencesManager.getCurrentUserLists();
                if (currentUserLists == null) {
                    currentUserLists = new MTUserLists(null, null, 3, null);
                }
                new MoveCardDialogFragment.Builder().setCard(mTFullCard).setCollection(currentUserCollection).setLists(currentUserLists).setListener(new MoveCardDialogListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$onViewCreated$16$moveCardDialog$1
                    @Override // com.studiolaganne.lengendarylens.MoveCardDialogListener
                    public void onCancelMoveCard() {
                    }

                    @Override // com.studiolaganne.lengendarylens.MoveCardDialogListener
                    public void onMoveCard(int destinationContainerId, final int quantity, boolean isNewContainer, String newContainerName, Integer newContainerType) {
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
                            this.this$0.moveCardToContainer(destinationContainerId, quantity);
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
                        Call<MTCardListResponse> callCreateList = MTApiKt.getMtApi().createList(currentUser.getId(), mTEditListBody);
                        this.this$0.getBinding().loadingOverlay.setVisibility(0);
                        final ScanFragment scanFragment2 = this.this$0;
                        callCreateList.enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.ScanFragment$onViewCreated$16$moveCardDialog$1$onMoveCard$1
                            @Override // retrofit2.Callback
                            public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(t, "t");
                                Log.e("ScanFragment", "Failed to create MT Card List: " + t.getMessage());
                                scanFragment2.getBinding().loadingOverlay.setVisibility(8);
                                Toast.makeText(scanFragment2.requireContext(), R.string.error_creating_list, 0).show();
                            }

                            @Override // retrofit2.Callback
                            public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                                MTCardContainer list;
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(response, "response");
                                if (scanFragment2.getActivity() == null || scanFragment2.getContext() == null) {
                                    return;
                                }
                                scanFragment2.getBinding().loadingOverlay.setVisibility(8);
                                if (!response.isSuccessful()) {
                                    Toast.makeText(scanFragment2.requireContext(), R.string.error_creating_list, 0).show();
                                    return;
                                }
                                MTCardListResponse mTCardListResponseBody = response.body();
                                if (mTCardListResponseBody == null || (list = mTCardListResponseBody.getList()) == null) {
                                    return;
                                }
                                scanFragment2.moveCardToContainer(list.getId(), quantity);
                            }
                        });
                    }
                }).build().show(scanFragment.getChildFragmentManager(), MoveCardDialogFragment.TAG);
            } else {
                DeckMoveCardDialogFragment.Builder card = new DeckMoveCardDialogFragment.Builder().setCard(mTFullCard);
                MTDeckLists mTDeckLists = scanFragment.currentDeckLists;
                if (mTDeckLists == null) {
                    mTDeckLists = new MTDeckLists(null, null, null, 7, null);
                }
                card.setCurrentLists(mTDeckLists).setCurrentListId(scanFragment.currentDeckListId).setListener(new DeckMoveCardDialogListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$onViewCreated$16$moveDialog$1
                    @Override // com.studiolaganne.lengendarylens.DeckMoveCardDialogListener
                    public void onMoveCardToDeckList(int destinationListId, int quantity) {
                        if (this.this$0.getActivity() == null || this.this$0.getContext() == null) {
                            return;
                        }
                        Context contextRequireContext2 = this.this$0.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        MTUser currentUser = new PreferencesManager(contextRequireContext2).getCurrentUser();
                        if (currentUser == null) {
                            return;
                        }
                        this.this$0.getBinding().loadingOverlay.setVisibility(0);
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
                        Call<MTMoveCardsResponse> callMoveCardsFromList = MTApiKt.getMtApi().moveCardsFromList(currentUser.getId(), this.this$0.currentDeckListId, this.this$0.currentNameFilter, this.this$0.currentScryfallFilter, this.this$0.currentGroupBy, this.this$0.currentOrderBy, this.this$0.currentOrderDirection, null, null, null, mTMoveCardsBody);
                        final ScanFragment scanFragment2 = this.this$0;
                        callMoveCardsFromList.enqueue(new Callback<MTMoveCardsResponse>() { // from class: com.studiolaganne.lengendarylens.ScanFragment$onViewCreated$16$moveDialog$1$onMoveCardToDeckList$3
                            @Override // retrofit2.Callback
                            public void onFailure(Call<MTMoveCardsResponse> call, Throwable t) {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(t, "t");
                                if (scanFragment2.getActivity() == null || scanFragment2.getContext() == null) {
                                    return;
                                }
                                scanFragment2.getBinding().loadingOverlay.setVisibility(8);
                                Log.e("ScanFragment", "Error moving card", t);
                                Toast.makeText(scanFragment2.requireContext(), R.string.error_moving_card, 0).show();
                            }

                            @Override // retrofit2.Callback
                            public void onResponse(Call<MTMoveCardsResponse> call, Response<MTMoveCardsResponse> response) {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(response, "response");
                                if (scanFragment2.getActivity() == null || scanFragment2.getContext() == null) {
                                    return;
                                }
                                scanFragment2.getBinding().loadingOverlay.setVisibility(8);
                                if (!response.isSuccessful()) {
                                    Toast.makeText(scanFragment2.requireContext(), R.string.error_moving_card, 0).show();
                                    return;
                                }
                                MTMoveCardsResponse mTMoveCardsResponseBody = response.body();
                                if (mTMoveCardsResponseBody != null) {
                                    ScanFragment scanFragment3 = scanFragment2;
                                    if (!mTMoveCardsResponseBody.getSuccess()) {
                                        Toast.makeText(scanFragment3.requireContext(), R.string.error_moving_card, 0).show();
                                        return;
                                    }
                                    MTCardContainer source = mTMoveCardsResponseBody.getSource();
                                    if (source != null) {
                                        scanFragment3.updateCardListFromNewContainer(source);
                                    }
                                }
                            }
                        });
                    }
                }).build().show(scanFragment.getChildFragmentManager(), DeckMoveCardDialogFragment.TAG);
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$17(final ScanFragment scanFragment) {
        if (scanFragment.getContext() == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        final MTFullCard mTFullCard = scanFragment.currentMTCard;
        if (mTFullCard != null) {
            EditCardDialogFragment editCardDialogFragmentBuild = new EditCardDialogFragment.Builder().setCard(mTFullCard).setShowPurchasePrice(scanFragment.currentDeckListId == -1).setAllPrintsLauncher(scanFragment.allPrintsActivityLauncher).setOnDismissListener(new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda57
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.onViewCreated$lambda$17$0$0(this.f$0);
                }
            }).setOnEditClickedListener(new Function12() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda58
                @Override // kotlin.jvm.functions.Function12
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
                    return ScanFragment.onViewCreated$lambda$17$0$1(this.f$0, mTFullCard, (Integer) obj, (Integer) obj2, (String) obj3, (String) obj4, (String) obj5, (MTFullCard) obj6, (Boolean) obj7, (Boolean) obj8, (Boolean) obj9, (Boolean) obj10, (Integer) obj11, (Double) obj12);
                }
            }).build();
            scanFragment.editDialogShowing = true;
            scanFragment.editDialog = editCardDialogFragmentBuild;
            editCardDialogFragmentBuild.show(scanFragment.getChildFragmentManager(), "edit_card_dialog");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$17$0$0(ScanFragment scanFragment) {
        scanFragment.editDialogShowing = false;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$17$0$1(final ScanFragment scanFragment, MTFullCard mTFullCard, Integer num, Integer num2, String str, String str2, String str3, MTFullCard mTFullCard2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Integer num3, Double d) {
        ArrayList arrayList;
        int iIntValue;
        int iIntValue2;
        int i;
        String cardid;
        String set_code;
        String collector_number;
        Boolean altered;
        Boolean signed;
        Boolean missprint;
        Boolean proxy;
        String cardid2;
        String set_code2;
        String collector_number2;
        Boolean altered2;
        Boolean signed2;
        Boolean missprint2;
        Boolean proxy2;
        if (scanFragment.getActivity() == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        if (scanFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        scanFragment.editDialogShowing = false;
        List<Integer> list_card_ids = mTFullCard.getList_card_ids();
        if (list_card_ids == null || (arrayList = CollectionsKt.toMutableList((Collection) list_card_ids)) == null) {
            arrayList = new ArrayList();
        }
        Integer quantity = mTFullCard.getQuantity();
        int iIntValue3 = quantity != null ? quantity.intValue() : 1;
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            Integer quantity2 = mTFullCard.getQuantity();
            iIntValue = quantity2 != null ? quantity2.intValue() : 1;
        }
        if (num2 != null) {
            iIntValue2 = num2.intValue();
        } else {
            Integer quantity3 = mTFullCard.getQuantity();
            iIntValue2 = quantity3 != null ? quantity3.intValue() : 1;
        }
        int iIntValue4 = num2 != null ? num2.intValue() : 1;
        MTEditCardBody mTEditCardBody = new MTEditCardBody(null, 1, null);
        mTEditCardBody.setCards(new MTEditCardActions(null, null, null, 7, null));
        if (iIntValue < iIntValue3) {
            List listTake = CollectionsKt.take(arrayList, iIntValue3 - iIntValue);
            ArrayList arrayList2 = new ArrayList();
            arrayList.removeAll(listTake);
            Iterator it = listTake.iterator();
            while (it.hasNext()) {
                int iIntValue5 = ((Number) it.next()).intValue();
                MTCardReference mTCardReference = new MTCardReference(0, 1, null);
                mTCardReference.setList_card_id(iIntValue5);
                arrayList2.add(mTCardReference);
            }
            MTEditCardActions cards = mTEditCardBody.getCards();
            if (cards != null) {
                cards.setDeleted(arrayList2);
                Unit unit = Unit.INSTANCE;
            }
        }
        if (iIntValue > iIntValue3) {
            int i2 = iIntValue - iIntValue3;
            ArrayList arrayList3 = new ArrayList();
            i = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                MTFullCard mTFullCard3 = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                if (i < iIntValue4) {
                    i++;
                    if (mTFullCard2 == null || (cardid2 = mTFullCard2.getCardid()) == null) {
                        cardid2 = mTFullCard.getCardid();
                    }
                    mTFullCard3.setCardid(cardid2);
                    mTFullCard3.setScryfallid(null);
                    if (mTFullCard2 == null || (set_code2 = mTFullCard2.getSet_code()) == null) {
                        set_code2 = mTFullCard.getSet_code();
                    }
                    mTFullCard3.setSet_code(set_code2);
                    if (mTFullCard2 == null || (collector_number2 = mTFullCard2.getCollector_number()) == null) {
                        collector_number2 = mTFullCard.getCollector_number();
                    }
                    mTFullCard3.setCollector_number(collector_number2);
                    mTFullCard3.setLang(str == null ? mTFullCard.getLang() : str);
                    mTFullCard3.setFinish(str2 == null ? mTFullCard.getFinish() : str2);
                    mTFullCard3.setCondition(str3 == null ? mTFullCard.getCondition() : str3);
                    if (bool == null) {
                        altered2 = mTFullCard.getAltered();
                        if (altered2 == null) {
                            altered2 = false;
                        }
                    } else {
                        altered2 = bool;
                    }
                    mTFullCard3.setAltered(altered2);
                    if (bool2 == null) {
                        signed2 = mTFullCard.getSigned();
                        if (signed2 == null) {
                            signed2 = false;
                        }
                    } else {
                        signed2 = bool2;
                    }
                    mTFullCard3.setSigned(signed2);
                    if (bool3 == null) {
                        missprint2 = mTFullCard.getMissprint();
                        if (missprint2 == null) {
                            missprint2 = false;
                        }
                    } else {
                        missprint2 = bool3;
                    }
                    mTFullCard3.setMissprint(missprint2);
                    if (bool4 == null) {
                        proxy2 = mTFullCard.getProxy();
                        if (proxy2 == null) {
                            proxy2 = false;
                        }
                    } else {
                        proxy2 = bool4;
                    }
                    mTFullCard3.setProxy(proxy2);
                    mTFullCard3.setPurchase_price(d == null ? mTFullCard.getPurchase_price() : d);
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
                    mTFullCard3.setPurchase_price(mTFullCard.getPurchase_price());
                }
                arrayList3.add(mTFullCard3);
            }
            MTEditCardActions cards2 = mTEditCardBody.getCards();
            if (cards2 != null) {
                cards2.setAdded(arrayList3);
                Unit unit2 = Unit.INSTANCE;
            }
        } else {
            i = 0;
        }
        if (iIntValue2 > 0) {
            ArrayList arrayList4 = new ArrayList();
            for (int i4 = 0; i4 < iIntValue2; i4++) {
                if (i < iIntValue4) {
                    MTFullCard mTFullCard4 = new MTFullCard(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 127, null);
                    i++;
                    if (mTFullCard2 == null || (cardid = mTFullCard2.getCardid()) == null) {
                        cardid = mTFullCard.getCardid();
                    }
                    mTFullCard4.setCardid(cardid);
                    if (mTFullCard2 == null || (set_code = mTFullCard2.getSet_code()) == null) {
                        set_code = mTFullCard.getSet_code();
                    }
                    mTFullCard4.setSet_code(set_code);
                    if (mTFullCard2 == null || (collector_number = mTFullCard2.getCollector_number()) == null) {
                        collector_number = mTFullCard.getCollector_number();
                    }
                    mTFullCard4.setCollector_number(collector_number);
                    mTFullCard4.setLang(str == null ? mTFullCard.getLang() : str);
                    mTFullCard4.setFinish(str2 == null ? mTFullCard.getFinish() : str2);
                    mTFullCard4.setCondition(str3 == null ? mTFullCard.getCondition() : str3);
                    if (bool == null) {
                        altered = mTFullCard.getAltered();
                        if (altered == null) {
                            altered = false;
                        }
                    } else {
                        altered = bool;
                    }
                    mTFullCard4.setAltered(altered);
                    if (bool2 == null) {
                        signed = mTFullCard.getSigned();
                        if (signed == null) {
                            signed = false;
                        }
                    } else {
                        signed = bool2;
                    }
                    mTFullCard4.setSigned(signed);
                    if (bool3 == null) {
                        missprint = mTFullCard.getMissprint();
                        if (missprint == null) {
                            missprint = false;
                        }
                    } else {
                        missprint = bool3;
                    }
                    mTFullCard4.setMissprint(missprint);
                    if (bool4 == null) {
                        proxy = mTFullCard.getProxy();
                        if (proxy == null) {
                            proxy = false;
                        }
                    } else {
                        proxy = bool4;
                    }
                    mTFullCard4.setProxy(proxy);
                    mTFullCard4.setList_card_id((Integer) CollectionsKt.getOrNull(arrayList, i4));
                    mTFullCard4.setPurchase_price(d == null ? Double.valueOf(-1.0d) : d);
                    arrayList4.add(mTFullCard4);
                }
            }
            MTEditCardActions cards3 = mTEditCardBody.getCards();
            if (cards3 != null) {
                cards3.setEdited(arrayList4);
                Unit unit3 = Unit.INSTANCE;
            }
        }
        Context contextRequireContext = scanFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            scanFragment.getBinding().loadingOverlay.setVisibility(0);
            int iIntValue6 = scanFragment.currentListId;
            int i5 = scanFragment.currentDeckListId;
            if (i5 != -1) {
                iIntValue6 = i5;
            }
            if (iIntValue6 == -1) {
                Integer listid = mTFullCard.getListid();
                iIntValue6 = listid != null ? listid.intValue() : -1;
            }
            MTApiKt.getMtApi().editCardsFromList(currentUser.getId(), iIntValue6, scanFragment.currentNameFilter, scanFragment.currentScryfallFilter, scanFragment.currentGroupBy, scanFragment.currentOrderBy, scanFragment.currentOrderDirection, true, null, null, null, mTEditCardBody).enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.ScanFragment$onViewCreated$17$1$dialog$2$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    Log.e("ScanFragment", "Failed to edit MT Card: " + t.getMessage());
                    this.this$0.getBinding().loadingOverlay.setVisibility(8);
                    Toast.makeText(this.this$0.requireContext(), R.string.error_editing_card, 0).show();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getActivity() == null || this.this$0.getContext() == null) {
                        return;
                    }
                    if (!response.isSuccessful()) {
                        this.this$0.getBinding().loadingOverlay.setVisibility(8);
                        Toast.makeText(this.this$0.requireContext(), R.string.error_editing_card, 0).show();
                        return;
                    }
                    MTCardListResponse mTCardListResponseBody = response.body();
                    MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
                    if (list != null) {
                        this.this$0.updateCardListFromNewContainer(list);
                    }
                    this.this$0.getBinding().loadingOverlay.setVisibility(8);
                }
            });
            Unit unit4 = Unit.INSTANCE;
            Unit unit5 = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$18(ScanFragment scanFragment) {
        if (scanFragment.getContext() == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = scanFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (new PreferencesManager(contextRequireContext).getCurrentUser() == null) {
            return Unit.INSTANCE;
        }
        MTFullCard mTFullCard = scanFragment.currentMTCard;
        if (mTFullCard != null) {
            scanFragment.showAddCardContainerSelection(mTFullCard);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$19(ScanFragment scanFragment) {
        String str;
        boolean zAreEqual;
        Bitmap bitmapFromImageView;
        if (scanFragment.getContext() == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        MTFullCard mTFullCard = scanFragment.currentMTCard;
        str = "";
        if (mTFullCard != null) {
            String printed_name = mTFullCard.getPrinted_name();
            str = (printed_name == null && (printed_name = mTFullCard.getName()) == null) ? "" : printed_name;
            zAreEqual = Intrinsics.areEqual(mTFullCard.getSet_code(), "lea");
        } else {
            zAreEqual = false;
        }
        boolean z = zAreEqual;
        if (str.length() > 0) {
            if (scanFragment.currentFace == 0) {
                LoadingImageView cardFront = scanFragment.getBinding().cardFront;
                Intrinsics.checkNotNullExpressionValue(cardFront, "cardFront");
                bitmapFromImageView = scanFragment.getBitmapFromImageView(cardFront);
            } else {
                LoadingImageView cardBack = scanFragment.getBinding().cardBack;
                Intrinsics.checkNotNullExpressionValue(cardBack, "cardBack");
                bitmapFromImageView = scanFragment.getBitmapFromImageView(cardBack);
            }
            Bitmap bitmap = bitmapFromImageView;
            if (bitmap != null && scanFragment.getContext() != null) {
                String strSanitizeFileName = scanFragment.sanitizeFileName(str);
                Context contextRequireContext = scanFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                scanFragment.saveImageToPicturesFolder(contextRequireContext, bitmap, "Mythic Tools", strSanitizeFileName, z);
            }
        }
        return Unit.INSTANCE;
    }

    static final void onViewCreated$lambda$2(ImageView imageView, TextView textView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            imageView.setVisibility(0);
            textView.setVisibility(0);
        } else {
            imageView.setVisibility(4);
            textView.setVisibility(4);
        }
    }

    static final Unit onViewCreated$lambda$20(ScanFragment scanFragment) {
        String str;
        boolean zAreEqual;
        Bitmap bitmapFromImageView;
        if (scanFragment.getContext() == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        MTFullCard mTFullCard = scanFragment.currentMTCard;
        str = "";
        if (mTFullCard != null) {
            String printed_name = mTFullCard.getPrinted_name();
            str = (printed_name == null && (printed_name = mTFullCard.getName()) == null) ? "" : printed_name;
            zAreEqual = Intrinsics.areEqual(mTFullCard.getSet_code(), "lea");
        } else {
            zAreEqual = false;
        }
        if (str.length() > 0) {
            if (scanFragment.currentFace == 0) {
                LoadingImageView cardFront = scanFragment.getBinding().cardFront;
                Intrinsics.checkNotNullExpressionValue(cardFront, "cardFront");
                bitmapFromImageView = scanFragment.getBitmapFromImageView(cardFront);
            } else {
                LoadingImageView cardBack = scanFragment.getBinding().cardBack;
                Intrinsics.checkNotNullExpressionValue(cardBack, "cardBack");
                bitmapFromImageView = scanFragment.getBitmapFromImageView(cardBack);
            }
            if (bitmapFromImageView != null) {
                scanFragment.shareImage(bitmapFromImageView, str, zAreEqual);
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$21(ScanFragment scanFragment) {
        if (scanFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(scanFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("edhrec_button_tap", null);
        if (scanFragment.currentMTCard != null) {
            String strCurrentCardNameToEDHREC = scanFragment.currentCardNameToEDHREC();
            String str = "https://edhrec.com/cards/" + strCurrentCardNameToEDHREC;
            if (scanFragment.isLegendaryCreature()) {
                str = "https://edhrec.com/commanders/" + strCurrentCardNameToEDHREC;
            }
            scanFragment.openWebActivity(str);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$22(ScanFragment scanFragment) {
        if (scanFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(scanFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("scryfall_button_tap", null);
        MTFullCard mTFullCard = scanFragment.currentMTCard;
        if (mTFullCard != null) {
            scanFragment.openWebActivity("https://scryfall.com/card/" + mTFullCard.getScryfallid());
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$23(ScanFragment scanFragment) {
        if (scanFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(scanFragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("gatherer_button_tap", null);
        MTFullCard mTFullCard = scanFragment.currentMTCard;
        if (mTFullCard != null) {
            String name = mTFullCard.getName();
            if (name == null) {
                name = "";
            }
            Iterator it = StringsKt.split$default((CharSequence) name, new String[]{" "}, false, 0, 6, (Object) null).iterator();
            String str = "https://gatherer.wizards.com/Pages/Search/Default.aspx?name=";
            while (it.hasNext()) {
                str = str + "+[" + ((String) it.next()) + "]";
            }
            scanFragment.openWebActivity(str);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$24(final ScanFragment scanFragment) {
        if (scanFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = scanFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (preferencesManager.getBoolean(PreferencesManager.TRANSLATE_RULINGS, false)) {
            preferencesManager.setBoolean(PreferencesManager.TRANSLATE_RULINGS, false);
            final ImageView translateFlagImage = scanFragment.getBinding().translateFlagImage;
            Intrinsics.checkNotNullExpressionValue(translateFlagImage, "translateFlagImage");
            final int identifier = scanFragment.getResources().getIdentifier("flag_fr", "drawable", translateFlagImage.getContext().getPackageName());
            scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda47
                @Override // java.lang.Runnable
                public final void run() {
                    translateFlagImage.setImageResource(identifier);
                }
            });
            TextView detailTranslateRulingsLabel = scanFragment.getBinding().detailTranslateRulingsLabel;
            Intrinsics.checkNotNullExpressionValue(detailTranslateRulingsLabel, "detailTranslateRulingsLabel");
            detailTranslateRulingsLabel.setText(scanFragment.getString(R.string.translate));
            if (scanFragment.currentCardMatch != null) {
                scanFragment.fetchRulings();
            }
        } else {
            RulingsDBHelper.Companion companion = RulingsDBHelper.INSTANCE;
            Context contextRequireContext2 = scanFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            final RulingsDBHelper companion2 = companion.getInstance(contextRequireContext2, "fr");
            if (companion2.isValid()) {
                preferencesManager.setBoolean(PreferencesManager.TRANSLATE_RULINGS, true);
                if (scanFragment.currentCardMatch != null) {
                    scanFragment.fetchRulings();
                }
                final ImageView translateFlagImage2 = scanFragment.getBinding().translateFlagImage;
                Intrinsics.checkNotNullExpressionValue(translateFlagImage2, "translateFlagImage");
                final int identifier2 = scanFragment.getResources().getIdentifier("flag_en", "drawable", translateFlagImage2.getContext().getPackageName());
                scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda48
                    @Override // java.lang.Runnable
                    public final void run() {
                        translateFlagImage2.setImageResource(identifier2);
                    }
                });
                TextView detailTranslateRulingsLabel2 = scanFragment.getBinding().detailTranslateRulingsLabel;
                Intrinsics.checkNotNullExpressionValue(detailTranslateRulingsLabel2, "detailTranslateRulingsLabel");
                detailTranslateRulingsLabel2.setText(scanFragment.getString(R.string.show_orignal));
            } else {
                String string = scanFragment.getString(R.string.download_rulings_db_body);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String lowerCase = preferencesManager.getNameForLanguage("fr").toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String strReplace$default = StringsKt.replace$default(string, "{1}", lowerCase, false, 4, (Object) null);
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string2 = scanFragment.getString(R.string.download_db_title);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder positiveButtonRed = builder.setTitle(string2).setBody(strReplace$default).setPositiveButtonRed();
                String string3 = scanFragment.getString(R.string.download);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda49
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScanFragment.onViewCreated$lambda$24$4(this.f$0, companion2, preferencesManager, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                });
                String string4 = scanFragment.getString(R.string.cancel);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda50
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ScanFragment.onViewCreated$lambda$24$5(this.f$0, (CustomDialogFragment) obj);
                    }
                });
                FragmentManager childFragmentManager = scanFragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                negativeButton.show(childFragmentManager, "CustomDialogFragment");
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$24$4(final ScanFragment scanFragment, final RulingsDBHelper rulingsDBHelper, final PreferencesManager preferencesManager, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (scanFragment._binding == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        final ConstraintLayout downloadingLayout = scanFragment.getBinding().downloadingLayout;
        Intrinsics.checkNotNullExpressionValue(downloadingLayout, "downloadingLayout");
        downloadingLayout.setVisibility(0);
        rulingsDBHelper.downloadDBFile(new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda124
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScanFragment.onViewCreated$lambda$24$4$0(this.f$0, ((Integer) obj).intValue());
            }
        }, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda125
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$24$4$1(this.f$0, rulingsDBHelper, downloadingLayout, preferencesManager);
            }
        }, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda126
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScanFragment.onViewCreated$lambda$24$4$2(this.f$0, (String) obj);
            }
        });
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$24$4$0(ScanFragment scanFragment, int i) {
        if (scanFragment._binding == null) {
            return Unit.INSTANCE;
        }
        ProgressBar downloadProgressBar = scanFragment.getBinding().downloadProgressBar;
        Intrinsics.checkNotNullExpressionValue(downloadProgressBar, "downloadProgressBar");
        downloadProgressBar.setProgress(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$24$4$1(final ScanFragment scanFragment, RulingsDBHelper rulingsDBHelper, ConstraintLayout constraintLayout, PreferencesManager preferencesManager) {
        if (scanFragment._binding == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        if (rulingsDBHelper.hasDBInAppContext() && rulingsDBHelper.isValid()) {
            constraintLayout.setVisibility(8);
            preferencesManager.setBoolean(PreferencesManager.TRANSLATE_RULINGS, true);
            if (scanFragment.currentCardMatch != null) {
                scanFragment.fetchRulings();
            }
            final ImageView translateFlagImage = scanFragment.getBinding().translateFlagImage;
            Intrinsics.checkNotNullExpressionValue(translateFlagImage, "translateFlagImage");
            final int identifier = scanFragment.getResources().getIdentifier("flag_en", "drawable", translateFlagImage.getContext().getPackageName());
            scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda98
                @Override // java.lang.Runnable
                public final void run() {
                    translateFlagImage.setImageResource(identifier);
                }
            });
            TextView detailTranslateRulingsLabel = scanFragment.getBinding().detailTranslateRulingsLabel;
            Intrinsics.checkNotNullExpressionValue(detailTranslateRulingsLabel, "detailTranslateRulingsLabel");
            detailTranslateRulingsLabel.setText(scanFragment.getString(R.string.show_orignal));
        } else {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = scanFragment.getString(R.string.download_error_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = scanFragment.getString(R.string.download_error_title);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = scanFragment.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda109
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScanFragment.onViewCreated$lambda$24$4$1$2(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager childFragmentManager = scanFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            positiveButton.show(childFragmentManager, "CustomDialogFragment");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$24$4$1$2(ScanFragment scanFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (scanFragment._binding == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$24$4$2(final ScanFragment scanFragment, String errorStr) {
        Intrinsics.checkNotNullParameter(errorStr, "errorStr");
        if (scanFragment._binding == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = scanFragment.getString(R.string.download_error_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder body = builder.setTitle(string).setBody(scanFragment.getString(R.string.download_error_body) + "\n\n" + errorStr);
        String string2 = scanFragment.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda145
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ScanFragment.onViewCreated$lambda$24$4$2$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = scanFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "CustomDialogFragment");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$24$4$2$0(ScanFragment scanFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (scanFragment._binding == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$24$5(ScanFragment scanFragment, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (scanFragment._binding == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final void onViewCreated$lambda$25(ScanFragment scanFragment, View view) {
        PopupWindow popupWindow = scanFragment.popupWindow;
        if (popupWindow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupWindow");
            popupWindow = null;
        }
        popupWindow.showAsDropDown(view);
    }

    static final Unit onViewCreated$lambda$26(ScanFragment scanFragment) {
        if (scanFragment.scanPaused) {
            scanFragment.scanPaused = false;
            scanFragment.observing = true;
            CombinedAnalyzer combinedAnalyzer = scanFragment.combinedAnalyzer;
            if (combinedAnalyzer != null) {
                combinedAnalyzer.setPaused(false);
            }
            scanFragment.getBinding().pauseScanImageView.setImageResource(R.drawable.pause_button);
            scanFragment.getBinding().pausedLabel.setVisibility(8);
        } else {
            scanFragment.scanPaused = true;
            scanFragment.observing = false;
            CombinedAnalyzer combinedAnalyzer2 = scanFragment.combinedAnalyzer;
            if (combinedAnalyzer2 != null) {
                combinedAnalyzer2.setPaused(true);
            }
            scanFragment.getBinding().pauseScanImageView.setImageResource(R.drawable.play_button);
            scanFragment.getBinding().pausedLabel.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$27(final ScanFragment scanFragment) {
        new ScanSettingsDialogFragment.Builder().setOnSettingsSaved(new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda134
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$27$0(this.f$0);
            }
        }).build().show(scanFragment.getChildFragmentManager(), "ScanSettingsDialog");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$27$0(ScanFragment scanFragment) {
        Toast.makeText(scanFragment.requireContext(), R.string.settings_saved, 0).show();
        scanFragment.updateScanSettingsOverrideIndicator();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$28(ScanFragment scanFragment) {
        scanFragment.moveToNextCard();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$29(ScanFragment scanFragment) {
        scanFragment.moveToPreviousCard();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$3(ScanFragment scanFragment) {
        scanFragment.searchActivityLauncher.launch(new Intent(scanFragment.requireContext(), (Class<?>) SearchActivity.class));
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$30(ScanFragment scanFragment) {
        Bitmap bitmapFromImageView;
        if (scanFragment.getContext() == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        if (scanFragment.currentMTCard == null) {
            return Unit.INSTANCE;
        }
        if (scanFragment.currentFace == 0) {
            LoadingImageView cardFront = scanFragment.getBinding().cardFront;
            Intrinsics.checkNotNullExpressionValue(cardFront, "cardFront");
            bitmapFromImageView = scanFragment.getBitmapFromImageView(cardFront);
        } else {
            LoadingImageView cardBack = scanFragment.getBinding().cardBack;
            Intrinsics.checkNotNullExpressionValue(cardBack, "cardBack");
            bitmapFromImageView = scanFragment.getBitmapFromImageView(cardBack);
        }
        if (bitmapFromImageView != null) {
            Context contextRequireContext = scanFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            new FullscreenImageDialog(contextRequireContext, bitmapFromImageView).show();
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$31(ScanFragment scanFragment) {
        scanFragment.moveToNextCard();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$32(ScanFragment scanFragment) {
        scanFragment.moveToPreviousCard();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$33(ScanFragment scanFragment) {
        Bitmap bitmapFromImageView;
        if (scanFragment.getContext() == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        if (scanFragment.currentMTCard == null) {
            return Unit.INSTANCE;
        }
        if (scanFragment.currentFace == 0) {
            LoadingImageView cardFront = scanFragment.getBinding().cardFront;
            Intrinsics.checkNotNullExpressionValue(cardFront, "cardFront");
            bitmapFromImageView = scanFragment.getBitmapFromImageView(cardFront);
        } else {
            LoadingImageView cardBack = scanFragment.getBinding().cardBack;
            Intrinsics.checkNotNullExpressionValue(cardBack, "cardBack");
            bitmapFromImageView = scanFragment.getBitmapFromImageView(cardBack);
        }
        if (bitmapFromImageView != null) {
            Context contextRequireContext = scanFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            new FullscreenImageDialog(contextRequireContext, bitmapFromImageView).show();
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$34(ScanFragment scanFragment) {
        scanFragment.moveToNextCard();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$35(ScanFragment scanFragment) {
        scanFragment.moveToPreviousCard();
        return Unit.INSTANCE;
    }

    static final void onViewCreated$lambda$36(final ScanFragment scanFragment, final View view) {
        String str;
        int i;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        MTFullCard mTFullCard = scanFragment.currentMTCard;
        str = "";
        if (mTFullCard != null) {
            String layout = mTFullCard.getLayout();
            str = layout != null ? layout : "";
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        if (str.length() > 0) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            boolean zAreEqual = Intrinsics.areEqual(lowerCase, "adventure");
            String lowerCase2 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            boolean zAreEqual2 = Intrinsics.areEqual(lowerCase2, "prepare");
            String lowerCase3 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            boolean zAreEqual3 = Intrinsics.areEqual(lowerCase3, "split");
            String lowerCase4 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
            boolean zAreEqual4 = Intrinsics.areEqual(lowerCase4, "flip");
            boolean zIsAftermath = scanFragment.isAftermath();
            view.animate().scaleX(1.25f).scaleY(1.25f).setDuration(45L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda149
                @Override // java.lang.Runnable
                public final void run() {
                    ScanFragment.onViewCreated$lambda$36$1(view);
                }
            }).start();
            final ConstraintLayout cardFrontContainer = scanFragment.getBinding().cardFrontContainer;
            Intrinsics.checkNotNullExpressionValue(cardFrontContainer, "cardFrontContainer");
            final ConstraintLayout cardBackContainer = scanFragment.getBinding().cardBackContainer;
            Intrinsics.checkNotNullExpressionValue(cardBackContainer, "cardBackContainer");
            if (zAreEqual4) {
                if (scanFragment.currentFace == 0) {
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(cardFrontContainer, (Property<ConstraintLayout, Float>) View.ROTATION, 0.0f, 180.0f);
                    objectAnimatorOfFloat.setDuration(500L);
                    objectAnimatorOfFloat.start();
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(cardBackContainer, (Property<ConstraintLayout, Float>) View.ROTATION, 0.0f, 180.0f);
                    objectAnimatorOfFloat2.setDuration(500L);
                    objectAnimatorOfFloat2.start();
                } else {
                    ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(cardFrontContainer, (Property<ConstraintLayout, Float>) View.ROTATION, 180.0f, 0.0f);
                    objectAnimatorOfFloat3.setDuration(500L);
                    objectAnimatorOfFloat3.start();
                    ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(cardBackContainer, (Property<ConstraintLayout, Float>) View.ROTATION, 180.0f, 0.0f);
                    objectAnimatorOfFloat4.setDuration(500L);
                    objectAnimatorOfFloat4.start();
                }
                z = zAreEqual3;
                z2 = zIsAftermath;
                z3 = zAreEqual;
                z4 = zAreEqual2;
                i = 1;
                i2 = 0;
            } else {
                i = 1;
                i2 = 0;
                if (zAreEqual) {
                    if (scanFragment.currentFace == 0) {
                        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleX", 1.0f, 1.5f);
                        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleY", 1.0f, 1.5f);
                        float height = cardFrontContainer.getHeight() * 0.25f;
                        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(cardFrontContainer, "translationX", 0.0f, height);
                        z = zAreEqual3;
                        float f = -height;
                        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(cardFrontContainer, "translationY", 0.0f, f);
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(objectAnimatorOfFloat5, objectAnimatorOfFloat6, objectAnimatorOfFloat7, objectAnimatorOfFloat8);
                        animatorSet.setDuration(350L);
                        animatorSet.start();
                        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(cardBackContainer, "scaleX", 1.0f, 1.5f);
                        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(cardBackContainer, "scaleY", 1.0f, 1.5f);
                        ObjectAnimator objectAnimatorOfFloat11 = ObjectAnimator.ofFloat(cardBackContainer, "translationX", 0.0f, height);
                        ObjectAnimator objectAnimatorOfFloat12 = ObjectAnimator.ofFloat(cardBackContainer, "translationY", 0.0f, f);
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        animatorSet2.playTogether(objectAnimatorOfFloat9, objectAnimatorOfFloat10, objectAnimatorOfFloat11, objectAnimatorOfFloat12);
                        animatorSet2.setDuration(350L);
                        animatorSet2.start();
                        z2 = zIsAftermath;
                    } else {
                        z = zAreEqual3;
                        ObjectAnimator objectAnimatorOfFloat13 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleX", 1.5f, 1.0f);
                        ObjectAnimator objectAnimatorOfFloat14 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleY", 1.5f, 1.0f);
                        float height2 = cardFrontContainer.getHeight() * 0.25f;
                        ObjectAnimator objectAnimatorOfFloat15 = ObjectAnimator.ofFloat(cardFrontContainer, "translationX", height2, 0.0f);
                        float f2 = -height2;
                        z2 = zIsAftermath;
                        ObjectAnimator objectAnimatorOfFloat16 = ObjectAnimator.ofFloat(cardFrontContainer, "translationY", f2, 0.0f);
                        AnimatorSet animatorSet3 = new AnimatorSet();
                        animatorSet3.playTogether(objectAnimatorOfFloat13, objectAnimatorOfFloat14, objectAnimatorOfFloat15, objectAnimatorOfFloat16);
                        animatorSet3.setDuration(350L);
                        animatorSet3.start();
                        ObjectAnimator objectAnimatorOfFloat17 = ObjectAnimator.ofFloat(cardBackContainer, "scaleX", 1.5f, 1.0f);
                        ObjectAnimator objectAnimatorOfFloat18 = ObjectAnimator.ofFloat(cardBackContainer, "scaleY", 1.5f, 1.0f);
                        ObjectAnimator objectAnimatorOfFloat19 = ObjectAnimator.ofFloat(cardBackContainer, "translationX", height2, 0.0f);
                        ObjectAnimator objectAnimatorOfFloat20 = ObjectAnimator.ofFloat(cardBackContainer, "translationY", f2, 0.0f);
                        AnimatorSet animatorSet4 = new AnimatorSet();
                        animatorSet4.playTogether(objectAnimatorOfFloat17, objectAnimatorOfFloat18, objectAnimatorOfFloat19, objectAnimatorOfFloat20);
                        animatorSet4.setDuration(350L);
                        animatorSet4.start();
                    }
                    z3 = zAreEqual;
                    z4 = zAreEqual2;
                } else {
                    z = zAreEqual3;
                    z2 = zIsAftermath;
                    if (!zAreEqual2) {
                        z3 = zAreEqual;
                        z4 = zAreEqual2;
                        if (z) {
                            if (!z2) {
                                float height3 = cardFrontContainer.getHeight() * 0.25f;
                                float height4 = cardFrontContainer.getHeight() * 0.35f;
                                if (scanFragment.currentFace == 0) {
                                    float f3 = -height4;
                                    ObjectAnimator objectAnimatorOfFloat21 = ObjectAnimator.ofFloat(cardFrontContainer, "translationX", height3, f3);
                                    objectAnimatorOfFloat21.setDuration(350L);
                                    objectAnimatorOfFloat21.start();
                                    ObjectAnimator objectAnimatorOfFloat22 = ObjectAnimator.ofFloat(cardBackContainer, "translationX", height3, f3);
                                    objectAnimatorOfFloat22.setDuration(350L);
                                    objectAnimatorOfFloat22.start();
                                } else {
                                    float f4 = -height4;
                                    ObjectAnimator objectAnimatorOfFloat23 = ObjectAnimator.ofFloat(cardFrontContainer, "translationX", f4, height3);
                                    objectAnimatorOfFloat23.setDuration(350L);
                                    objectAnimatorOfFloat23.start();
                                    ObjectAnimator objectAnimatorOfFloat24 = ObjectAnimator.ofFloat(cardBackContainer, "translationX", f4, height3);
                                    objectAnimatorOfFloat24.setDuration(350L);
                                    objectAnimatorOfFloat24.start();
                                }
                            } else if (scanFragment.currentFace == 0) {
                                ObjectAnimator objectAnimatorOfFloat25 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleX", 1.0f, 1.25f);
                                ObjectAnimator objectAnimatorOfFloat26 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleY", 1.0f, 1.25f);
                                float f5 = -(cardFrontContainer.getHeight() * 0.35f);
                                ObjectAnimator objectAnimatorOfFloat27 = ObjectAnimator.ofFloat(cardFrontContainer, "translationX", 0.0f, f5);
                                ObjectAnimator objectAnimatorOfFloat28 = ObjectAnimator.ofFloat(cardFrontContainer, (Property<ConstraintLayout, Float>) View.ROTATION, 0.0f, -90.0f);
                                AnimatorSet animatorSet5 = new AnimatorSet();
                                animatorSet5.playTogether(objectAnimatorOfFloat25, objectAnimatorOfFloat26, objectAnimatorOfFloat27, objectAnimatorOfFloat28);
                                animatorSet5.setDuration(350L);
                                animatorSet5.start();
                                ObjectAnimator objectAnimatorOfFloat29 = ObjectAnimator.ofFloat(cardBackContainer, "scaleX", 1.0f, 1.25f);
                                ObjectAnimator objectAnimatorOfFloat30 = ObjectAnimator.ofFloat(cardBackContainer, "scaleY", 1.0f, 1.25f);
                                ObjectAnimator objectAnimatorOfFloat31 = ObjectAnimator.ofFloat(cardBackContainer, "translationX", 0.0f, f5);
                                ObjectAnimator objectAnimatorOfFloat32 = ObjectAnimator.ofFloat(cardBackContainer, (Property<ConstraintLayout, Float>) View.ROTATION, 0.0f, -90.0f);
                                AnimatorSet animatorSet6 = new AnimatorSet();
                                animatorSet6.playTogether(objectAnimatorOfFloat29, objectAnimatorOfFloat30, objectAnimatorOfFloat31, objectAnimatorOfFloat32);
                                animatorSet6.setDuration(350L);
                                animatorSet6.start();
                            } else {
                                ObjectAnimator objectAnimatorOfFloat33 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleX", 1.25f, 1.0f);
                                ObjectAnimator objectAnimatorOfFloat34 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleY", 1.25f, 1.0f);
                                float f6 = -(cardFrontContainer.getHeight() * 0.35f);
                                ObjectAnimator objectAnimatorOfFloat35 = ObjectAnimator.ofFloat(cardFrontContainer, "translationX", f6, 0.0f);
                                ObjectAnimator objectAnimatorOfFloat36 = ObjectAnimator.ofFloat(cardFrontContainer, (Property<ConstraintLayout, Float>) View.ROTATION, -90.0f, 0.0f);
                                AnimatorSet animatorSet7 = new AnimatorSet();
                                animatorSet7.playTogether(objectAnimatorOfFloat33, objectAnimatorOfFloat34, objectAnimatorOfFloat35, objectAnimatorOfFloat36);
                                animatorSet7.setDuration(350L);
                                animatorSet7.start();
                                ObjectAnimator objectAnimatorOfFloat37 = ObjectAnimator.ofFloat(cardBackContainer, "scaleX", 1.25f, 1.0f);
                                ObjectAnimator objectAnimatorOfFloat38 = ObjectAnimator.ofFloat(cardBackContainer, "scaleY", 1.25f, 1.0f);
                                ObjectAnimator objectAnimatorOfFloat39 = ObjectAnimator.ofFloat(cardBackContainer, "translationX", f6, 0.0f);
                                ObjectAnimator objectAnimatorOfFloat40 = ObjectAnimator.ofFloat(cardBackContainer, (Property<ConstraintLayout, Float>) View.ROTATION, -90.0f, 0.0f);
                                AnimatorSet animatorSet8 = new AnimatorSet();
                                animatorSet8.playTogether(objectAnimatorOfFloat37, objectAnimatorOfFloat38, objectAnimatorOfFloat39, objectAnimatorOfFloat40);
                                animatorSet8.setDuration(350L);
                                animatorSet8.start();
                            }
                        } else if (scanFragment.currentFace == 0) {
                            float f7 = 8000.0f * scanFragment.getResources().getDisplayMetrics().density;
                            cardFrontContainer.setCameraDistance(f7);
                            cardBackContainer.setCameraDistance(f7);
                            ObjectAnimator objectAnimatorOfFloat41 = ObjectAnimator.ofFloat(cardFrontContainer, "rotationY", 0.0f, 180.0f);
                            objectAnimatorOfFloat41.setDuration(500L);
                            objectAnimatorOfFloat41.setInterpolator(new DecelerateInterpolator());
                            objectAnimatorOfFloat41.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda150
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    ScanFragment.onViewCreated$lambda$36$2$0(cardFrontContainer, valueAnimator);
                                }
                            });
                            ObjectAnimator objectAnimatorOfFloat42 = ObjectAnimator.ofFloat(cardBackContainer, "rotationY", -180.0f, 0.0f);
                            objectAnimatorOfFloat42.setDuration(500L);
                            objectAnimatorOfFloat42.setInterpolator(new DecelerateInterpolator());
                            objectAnimatorOfFloat42.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda151
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    ScanFragment.onViewCreated$lambda$36$3$0(cardBackContainer, valueAnimator);
                                }
                            });
                            objectAnimatorOfFloat41.start();
                            objectAnimatorOfFloat42.start();
                        } else {
                            float f8 = 8000.0f * scanFragment.getResources().getDisplayMetrics().density;
                            cardFrontContainer.setCameraDistance(f8);
                            cardBackContainer.setCameraDistance(f8);
                            ObjectAnimator objectAnimatorOfFloat43 = ObjectAnimator.ofFloat(cardFrontContainer, "rotationY", 180.0f, 0.0f);
                            objectAnimatorOfFloat43.setDuration(500L);
                            objectAnimatorOfFloat43.setInterpolator(new DecelerateInterpolator());
                            objectAnimatorOfFloat43.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda152
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    ScanFragment.onViewCreated$lambda$36$4$0(cardFrontContainer, valueAnimator);
                                }
                            });
                            ObjectAnimator objectAnimatorOfFloat44 = ObjectAnimator.ofFloat(cardBackContainer, "rotationY", 0.0f, -180.0f);
                            objectAnimatorOfFloat44.setDuration(500L);
                            objectAnimatorOfFloat44.setInterpolator(new DecelerateInterpolator());
                            objectAnimatorOfFloat44.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda154
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    ScanFragment.onViewCreated$lambda$36$5$0(cardBackContainer, valueAnimator);
                                }
                            });
                            objectAnimatorOfFloat43.start();
                            objectAnimatorOfFloat44.start();
                        }
                    } else if (scanFragment.currentFace == 0) {
                        ObjectAnimator objectAnimatorOfFloat45 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleX", 1.0f, 1.5f);
                        ObjectAnimator objectAnimatorOfFloat46 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleY", 1.0f, 1.5f);
                        float f9 = -(cardFrontContainer.getHeight() * 0.25f);
                        ObjectAnimator objectAnimatorOfFloat47 = ObjectAnimator.ofFloat(cardFrontContainer, "translationX", 0.0f, f9);
                        ObjectAnimator objectAnimatorOfFloat48 = ObjectAnimator.ofFloat(cardFrontContainer, "translationY", 0.0f, f9);
                        AnimatorSet animatorSet9 = new AnimatorSet();
                        animatorSet9.playTogether(objectAnimatorOfFloat45, objectAnimatorOfFloat46, objectAnimatorOfFloat47, objectAnimatorOfFloat48);
                        z3 = zAreEqual;
                        z4 = zAreEqual2;
                        animatorSet9.setDuration(350L);
                        animatorSet9.start();
                        ObjectAnimator objectAnimatorOfFloat49 = ObjectAnimator.ofFloat(cardBackContainer, "scaleX", 1.0f, 1.5f);
                        ObjectAnimator objectAnimatorOfFloat50 = ObjectAnimator.ofFloat(cardBackContainer, "scaleY", 1.0f, 1.5f);
                        ObjectAnimator objectAnimatorOfFloat51 = ObjectAnimator.ofFloat(cardBackContainer, "translationX", 0.0f, f9);
                        ObjectAnimator objectAnimatorOfFloat52 = ObjectAnimator.ofFloat(cardBackContainer, "translationY", 0.0f, f9);
                        AnimatorSet animatorSet10 = new AnimatorSet();
                        animatorSet10.playTogether(objectAnimatorOfFloat49, objectAnimatorOfFloat50, objectAnimatorOfFloat51, objectAnimatorOfFloat52);
                        animatorSet10.setDuration(350L);
                        animatorSet10.start();
                    } else {
                        z3 = zAreEqual;
                        z4 = zAreEqual2;
                        ObjectAnimator objectAnimatorOfFloat53 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleX", 1.5f, 1.0f);
                        ObjectAnimator objectAnimatorOfFloat54 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleY", 1.5f, 1.0f);
                        float f10 = -(cardFrontContainer.getHeight() * 0.25f);
                        ObjectAnimator objectAnimatorOfFloat55 = ObjectAnimator.ofFloat(cardFrontContainer, "translationX", f10, 0.0f);
                        ObjectAnimator objectAnimatorOfFloat56 = ObjectAnimator.ofFloat(cardFrontContainer, "translationY", f10, 0.0f);
                        AnimatorSet animatorSet11 = new AnimatorSet();
                        animatorSet11.playTogether(objectAnimatorOfFloat53, objectAnimatorOfFloat54, objectAnimatorOfFloat55, objectAnimatorOfFloat56);
                        animatorSet11.setDuration(350L);
                        animatorSet11.start();
                        ObjectAnimator objectAnimatorOfFloat57 = ObjectAnimator.ofFloat(cardBackContainer, "scaleX", 1.5f, 1.0f);
                        ObjectAnimator objectAnimatorOfFloat58 = ObjectAnimator.ofFloat(cardBackContainer, "scaleY", 1.5f, 1.0f);
                        ObjectAnimator objectAnimatorOfFloat59 = ObjectAnimator.ofFloat(cardBackContainer, "translationX", f10, 0.0f);
                        ObjectAnimator objectAnimatorOfFloat60 = ObjectAnimator.ofFloat(cardBackContainer, "translationY", f10, 0.0f);
                        AnimatorSet animatorSet12 = new AnimatorSet();
                        animatorSet12.playTogether(objectAnimatorOfFloat57, objectAnimatorOfFloat58, objectAnimatorOfFloat59, objectAnimatorOfFloat60);
                        animatorSet12.setDuration(350L);
                        animatorSet12.start();
                    }
                }
            }
            final boolean z5 = z3;
            final boolean z6 = z4;
            final boolean z7 = z;
            final boolean z8 = z2;
            scanFragment.getBinding().flipCardButton.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda155
                @Override // java.lang.Runnable
                public final void run() {
                    ScanFragment.onViewCreated$lambda$36$6(z7, z8, scanFragment, z5, z6);
                }
            }, 800L);
            scanFragment.currentFace = scanFragment.currentFace == 0 ? i : i2;
            scanFragment.updateFaceInformation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$36$1(final View view) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(45L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.onViewCreated$lambda$36$1$0(view);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$36$1$0(View view) {
        view.animate().alpha(0.0f).setDuration(100L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$36$2$0(ConstraintLayout constraintLayout, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        if (((Float) animatedValue).floatValue() < 90.0f || constraintLayout.getVisibility() != 0) {
            return;
        }
        constraintLayout.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$36$3$0(ConstraintLayout constraintLayout, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        if (((Float) animatedValue).floatValue() < -90.0f || constraintLayout.getVisibility() != 4) {
            return;
        }
        constraintLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$36$4$0(ConstraintLayout constraintLayout, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        if (((Float) animatedValue).floatValue() > 90.0f || constraintLayout.getVisibility() != 4) {
            return;
        }
        constraintLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$36$5$0(ConstraintLayout constraintLayout, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        if (((Float) animatedValue).floatValue() > -90.0f || constraintLayout.getVisibility() != 0) {
            return;
        }
        constraintLayout.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$36$6(boolean z, boolean z2, ScanFragment scanFragment, boolean z3, boolean z4) {
        if (z) {
            if (z2) {
                int i = scanFragment.currentFace;
            } else if (scanFragment.currentFace == 0) {
                scanFragment.getBinding().flipCardButton.setText("\uf061");
            } else {
                scanFragment.getBinding().flipCardButton.setText("\uf060");
            }
        } else if (z3 || z4) {
            if (scanFragment.currentFace == 0) {
                scanFragment.getBinding().flipCardButton.setText("\uf063");
            } else {
                scanFragment.getBinding().flipCardButton.setText("\uf062");
            }
        }
        scanFragment.getBinding().flipCardButton.animate().alpha(1.0f).setDuration(350L).start();
    }

    static final void onViewCreated$lambda$37(ScanFragment scanFragment, View view) {
        if (scanFragment.scanToDeckMode) {
            Intent intent = new Intent();
            intent.putExtra("scanCancelled", true);
            FragmentActivity activity = scanFragment.getActivity();
            if (activity != null) {
                activity.setResult(0, intent);
            }
        }
        FragmentActivity activity2 = scanFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    static final void onViewCreated$lambda$38(ScanFragment scanFragment, View view) {
        FragmentActivity activity = scanFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    static final void onViewCreated$lambda$4(View view) {
    }

    static final void onViewCreated$lambda$5(ScanFragment scanFragment, View view) {
        if (scanFragment.scanTutorialActive) {
            scanFragment.scanTutorialActive = false;
            scanFragment.getBinding().scanTutorialContainer.setVisibility(8);
            scanFragment.getBinding().scanTutorialOverlay.setVisibility(8);
            scanFragment.observing = true;
            CombinedAnalyzer combinedAnalyzer = scanFragment.combinedAnalyzer;
            if (combinedAnalyzer != null) {
                combinedAnalyzer.setPaused(false);
            }
        }
    }

    static final Unit onViewCreated$lambda$6(ScanFragment scanFragment) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(scanFragment.requireContext(), R.style.TransparentBottomSheetDialog);
        View viewInflate = scanFragment.getLayoutInflater().inflate(R.layout.bottom_sheet_prices, (ViewGroup) null);
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        bottomSheetDialog.setContentView(viewInflate);
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.overlay);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.pricesRecyclerView);
        if (scanFragment.currentMTCard != null) {
            constraintLayout.setVisibility(0);
        }
        Intrinsics.checkNotNull(recyclerView);
        Intrinsics.checkNotNull(constraintLayout);
        scanFragment.updatePricesRecyclerView(recyclerView, constraintLayout);
        bottomSheetDialog.show();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$7(ScanFragment scanFragment) {
        if (!scanFragment.currentScanList.isEmpty() && !scanFragment.scanTutorialActive) {
            if (scanFragment.getContext() == null || scanFragment.getActivity() == null) {
                return Unit.INSTANCE;
            }
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(scanFragment.requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("scan_cards_export_to_csv", null);
            MTCardCsvExporter.Companion companion = MTCardCsvExporter.INSTANCE;
            List<MTFullCard> list = scanFragment.currentScanList;
            File cacheDir = scanFragment.requireContext().getCacheDir();
            Intrinsics.checkNotNullExpressionValue(cacheDir, "getCacheDir(...)");
            File fileCreateCsvFile = companion.createCsvFile(list, cacheDir);
            if (fileCreateCsvFile == null) {
                Toast.makeText(scanFragment.requireContext(), scanFragment.getString(R.string.failed_csv), 1).show();
                return Unit.INSTANCE;
            }
            try {
                Uri uriForFile = FileProvider.getUriForFile(scanFragment.requireContext(), scanFragment.requireActivity().getPackageName() + ".fileprovider", fileCreateCsvFile);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.setType("text/csv");
                intent.putExtra("android.intent.extra.STREAM", uriForFile);
                intent.putExtra("android.intent.extra.SUBJECT", "MythicTools Export " + System.currentTimeMillis());
                intent.putExtra("android.intent.extra.TEXT", scanFragment.getString(R.string.share_csv_body));
                intent.addFlags(1);
                Intent intentCreateChooser = Intent.createChooser(intent, "MythicTools ScanList Export " + System.currentTimeMillis());
                if (intent.resolveActivity(scanFragment.requireActivity().getPackageManager()) != null) {
                    scanFragment.startActivity(intentCreateChooser);
                } else {
                    Toast.makeText(scanFragment.requireContext(), scanFragment.getString(R.string.no_apps), 1).show();
                }
                return Unit.INSTANCE;
            } catch (Exception unused) {
                Toast.makeText(scanFragment.requireContext(), scanFragment.getString(R.string.failed_share), 1).show();
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$8(final ScanFragment scanFragment) {
        if (!scanFragment.currentScanList.isEmpty() && !scanFragment.scanTutorialActive) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = scanFragment.getString(R.string.are_you_sure_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = scanFragment.getString(R.string.confirm_scan_list_delete);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
            String string3 = scanFragment.getString(R.string.delete);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScanFragment.onViewCreated$lambda$8$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            String string4 = scanFragment.getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda76
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScanFragment.onViewCreated$lambda$8$1(this.f$0, (CustomDialogFragment) obj);
                }
            });
            FragmentManager childFragmentManager = scanFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            negativeButton.show(childFragmentManager, "CustomDialogFragment");
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$8$0(ScanFragment scanFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (scanFragment.getContext() == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        scanFragment.clearCurrentScanListAndUI();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$8$1(ScanFragment scanFragment, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (scanFragment.getContext() == null || scanFragment.isDetached()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void openWebActivity(String url) {
        if (getActivity() == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("open_web_activity");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
            requireActivity().startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(requireContext(), (Class<?>) WebActivity.class);
        intent2.setFlags(603979776);
        intent2.putExtra("url", url);
        requireActivity().startActivity(intent2);
    }

    private final void playCheckmarkAnimation() {
        if (this._binding == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_play_checkmark");
        if (getBinding().lottieAnimationView.getVisibility() == 4) {
            getBinding().lottieAnimationView.setScaleX(1.0f);
            getBinding().lottieAnimationView.setScaleY(1.0f);
            getBinding().lottieAnimationView.setAnimation(R.raw.checkmark);
            getBinding().lottieAnimationView.setRepeatCount(0);
            getBinding().lottieAnimationView.setVisibility(0);
            getBinding().lottieAnimationView.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.studiolaganne.lengendarylens.ScanFragment.playCheckmarkAnimation.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onAnimationEnd(animation);
                    ScanFragment.this.removeCheckmarkAnimation();
                }
            });
            getBinding().lottieAnimationView.playAnimation();
        }
    }

    private final void playHighPriceSoundIfNeeded(MTFullCard card, PreferencesManager prefs) {
        if (prefs.getBoolean(PreferencesManager.SCAN_HIGH_PRICE_BEEP_ENABLED, false)) {
            if (GameUtils.INSTANCE.getInstance().getCardPrice(card, prefs.getPreferredMarket()) < prefs.getFloat(PreferencesManager.SCAN_HIGH_PRICE_THRESHOLD, 2.0f) || this.highPriceSoundId == 0) {
                return;
            }
            try {
                getHighPriceSoundPool().play(this.highPriceSoundId, 0.6f, 0.6f, 1, 0, 1.0f);
            } catch (Exception e) {
                Log.e(TAG, "Error playing high price sound: " + e.getMessage());
            }
        }
    }

    private final void playProgressAnimation() {
        if (this._binding == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_play_progress");
        if (getBinding().lottieAnimationView.getVisibility() == 4) {
            TextView helpLabel = getBinding().helpLabel;
            Intrinsics.checkNotNullExpressionValue(helpLabel, "helpLabel");
            helpLabel.setVisibility(8);
            getBinding().lottieAnimationView.setScaleX(0.5f);
            getBinding().lottieAnimationView.setScaleY(0.5f);
            getBinding().lottieAnimationView.setAnimation(R.raw.progress);
            getBinding().lottieAnimationView.setVisibility(0);
            getBinding().lottieAnimationView.setRepeatCount(-1);
            getBinding().lottieAnimationView.playAnimation();
            getBinding().cardZone.setBackgroundResource(R.drawable.custom_card_zone_background_highlight);
        }
    }

    static final void purchaseLauncher$lambda$0(ScanFragment scanFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "<unused var>");
        scanFragment.resetCapture();
    }

    private final void removeProgressAnimation() {
        if (this._binding == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_remove_progress");
        if (getBinding().lottieAnimationView.getVisibility() == 0) {
            getBinding().lottieAnimationView.pauseAnimation();
            getBinding().lottieAnimationView.setVisibility(4);
        }
    }

    static final void requestPermissionsLauncher$lambda$0(ScanFragment scanFragment, Map permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        if (!permissions.isEmpty()) {
            Iterator it = permissions.entrySet().iterator();
            while (it.hasNext()) {
                if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                    return;
                }
            }
        }
        scanFragment.startCamera();
    }

    private final void resetCapture() {
        if (this._binding == null) {
            return;
        }
        this.currentFace = 0;
        this.prices = null;
        this.enPrices = null;
        this.hasFoil = false;
        this.hasNonFoil = true;
        this.isFoil = false;
        if (this.scanPaused) {
            getBinding().pausedLabel.setVisibility(0);
        } else {
            this.observing = true;
            CombinedAnalyzer combinedAnalyzer = this.combinedAnalyzer;
            if (combinedAnalyzer != null) {
                combinedAnalyzer.setPaused(false);
            }
        }
        this.displayingCard = false;
        this.processing = false;
        this.cardTapped = false;
        this.detectedTitles.clear();
        this.detectedLanguages.clear();
        this.detectedCardSets.clear();
        this.detectedCardNumbers.clear();
        this.detectedCardDates.clear();
        this.numberOfAnalyzerCallbacks = 0;
        getBinding().cardZone.setVisibility(0);
        getBinding().cardZone.setBackgroundResource(R.drawable.custom_card_zone_background);
        removeCheckmarkAnimation();
        getBinding().flipCardButton.setVisibility(4);
        getBinding().priceButton.setVisibility(8);
        if (this.pickACardMode) {
            getBinding().mainSearchButton.setVisibility(0);
        } else {
            getBinding().mainSearchButton.setVisibility(8);
        }
        if (this.pickACardMode) {
            getBinding().backToGameButton.setVisibility(0);
            getBinding().backToGameLabel.setVisibility(4);
        } else if (this.backFromGame) {
            getBinding().backToGameButton.setVisibility(0);
            getBinding().backToGameLabel.setVisibility(0);
        } else {
            getBinding().backToGameButton.setVisibility(4);
            getBinding().backToGameLabel.setVisibility(4);
        }
        ConstraintLayout cardFrontContainer = getBinding().cardFrontContainer;
        Intrinsics.checkNotNullExpressionValue(cardFrontContainer, "cardFrontContainer");
        ConstraintLayout cardBackContainer = getBinding().cardBackContainer;
        Intrinsics.checkNotNullExpressionValue(cardBackContainer, "cardBackContainer");
        cardFrontContainer.setRotation(0.0f);
        cardFrontContainer.setTranslationX(0.0f);
        cardFrontContainer.setTranslationY(0.0f);
        cardFrontContainer.setScaleX(1.0f);
        cardFrontContainer.setScaleY(1.0f);
        cardBackContainer.setRotation(0.0f);
        cardBackContainer.setTranslationX(0.0f);
        cardBackContainer.setTranslationY(0.0f);
        cardBackContainer.setScaleX(1.0f);
        cardBackContainer.setScaleY(1.0f);
        LoadingImageView cardBack = getBinding().cardBack;
        Intrinsics.checkNotNullExpressionValue(cardBack, "cardBack");
        cardBack.setImageResource(R.drawable.card_back);
        TextView helpLabel = getBinding().helpLabel;
        Intrinsics.checkNotNullExpressionValue(helpLabel, "helpLabel");
        helpLabel.setVisibility(0);
        CombinedAnalyzer combinedAnalyzer2 = this.combinedAnalyzer;
        if (combinedAnalyzer2 != null) {
            combinedAnalyzer2.reset();
        }
    }

    private final void resetSplitCardRotation() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        ConstraintLayout cardFrontContainer = getBinding().cardFrontContainer;
        Intrinsics.checkNotNullExpressionValue(cardFrontContainer, "cardFrontContainer");
        ConstraintLayout cardBackContainer = getBinding().cardBackContainer;
        Intrinsics.checkNotNullExpressionValue(cardBackContainer, "cardBackContainer");
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(cardFrontContainer, "scaleX", 1.25f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleY", 1.25f, 1.0f);
        float height = cardFrontContainer.getHeight() * 0.25f;
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(cardFrontContainer, "translationX", height, 0.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(cardFrontContainer, (Property<ConstraintLayout, Float>) View.ROTATION, 90.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        animatorSet.setDuration(0L);
        animatorSet.start();
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(cardBackContainer, "scaleX", 1.25f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(cardBackContainer, "scaleY", 1.25f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(cardBackContainer, "translationX", height, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(cardBackContainer, (Property<ConstraintLayout, Float>) View.ROTATION, 90.0f, 0.0f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(objectAnimatorOfFloat5, objectAnimatorOfFloat6, objectAnimatorOfFloat7, objectAnimatorOfFloat8);
        animatorSet2.setDuration(0L);
        animatorSet2.start();
    }

    private final void resetToFrontFace() {
        int i;
        int i2;
        String layout;
        MTFullCard mTFullCard = this.currentMTCard;
        String str = "";
        if (mTFullCard != null && (layout = mTFullCard.getLayout()) != null) {
            str = layout;
        }
        if (str.length() > 0) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            boolean zAreEqual = Intrinsics.areEqual(lowerCase, "adventure");
            String lowerCase2 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            boolean zAreEqual2 = Intrinsics.areEqual(lowerCase2, "prepare");
            String lowerCase3 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            boolean zAreEqual3 = Intrinsics.areEqual(lowerCase3, "split");
            String lowerCase4 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
            boolean zAreEqual4 = Intrinsics.areEqual(lowerCase4, "flip");
            boolean zIsAftermath = isAftermath();
            final ConstraintLayout cardFrontContainer = getBinding().cardFrontContainer;
            Intrinsics.checkNotNullExpressionValue(cardFrontContainer, "cardFrontContainer");
            final ConstraintLayout cardBackContainer = getBinding().cardBackContainer;
            Intrinsics.checkNotNullExpressionValue(cardBackContainer, "cardBackContainer");
            if (zAreEqual4) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(cardFrontContainer, (Property<ConstraintLayout, Float>) View.ROTATION, 180.0f, 0.0f);
                objectAnimatorOfFloat.setDuration(100L);
                objectAnimatorOfFloat.start();
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(cardBackContainer, (Property<ConstraintLayout, Float>) View.ROTATION, 180.0f, 0.0f);
                objectAnimatorOfFloat2.setDuration(100L);
                objectAnimatorOfFloat2.start();
                i2 = 0;
            } else {
                if (zAreEqual) {
                    ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleX", 1.5f, 1.0f);
                    ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleY", 1.5f, 1.0f);
                    float height = cardFrontContainer.getHeight() * 0.25f;
                    ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(cardFrontContainer, "translationX", height, 0.0f);
                    i = 0;
                    float f = -height;
                    ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(cardFrontContainer, "translationY", f, 0.0f);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat5, objectAnimatorOfFloat6);
                    animatorSet.setDuration(0L);
                    animatorSet.start();
                    ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(cardBackContainer, "scaleX", 1.5f, 1.0f);
                    ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(cardBackContainer, "scaleY", 1.5f, 1.0f);
                    ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(cardBackContainer, "translationX", height, 0.0f);
                    ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(cardBackContainer, "translationY", f, 0.0f);
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playTogether(objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat10);
                    animatorSet2.setDuration(0L);
                    animatorSet2.start();
                } else {
                    i = 0;
                    if (zAreEqual2) {
                        ObjectAnimator objectAnimatorOfFloat11 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleX", 1.5f, 1.0f);
                        ObjectAnimator objectAnimatorOfFloat12 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleY", 1.5f, 1.0f);
                        float f2 = -(cardFrontContainer.getHeight() * 0.25f);
                        ObjectAnimator objectAnimatorOfFloat13 = ObjectAnimator.ofFloat(cardFrontContainer, "translationX", f2, 0.0f);
                        ObjectAnimator objectAnimatorOfFloat14 = ObjectAnimator.ofFloat(cardFrontContainer, "translationY", f2, 0.0f);
                        AnimatorSet animatorSet3 = new AnimatorSet();
                        animatorSet3.playTogether(objectAnimatorOfFloat11, objectAnimatorOfFloat12, objectAnimatorOfFloat13, objectAnimatorOfFloat14);
                        animatorSet3.setDuration(0L);
                        animatorSet3.start();
                        ObjectAnimator objectAnimatorOfFloat15 = ObjectAnimator.ofFloat(cardBackContainer, "scaleX", 1.5f, 1.0f);
                        ObjectAnimator objectAnimatorOfFloat16 = ObjectAnimator.ofFloat(cardBackContainer, "scaleY", 1.5f, 1.0f);
                        ObjectAnimator objectAnimatorOfFloat17 = ObjectAnimator.ofFloat(cardBackContainer, "translationX", f2, 0.0f);
                        ObjectAnimator objectAnimatorOfFloat18 = ObjectAnimator.ofFloat(cardBackContainer, "translationY", f2, 0.0f);
                        AnimatorSet animatorSet4 = new AnimatorSet();
                        animatorSet4.playTogether(objectAnimatorOfFloat15, objectAnimatorOfFloat16, objectAnimatorOfFloat17, objectAnimatorOfFloat18);
                        animatorSet4.setDuration(0L);
                        animatorSet4.start();
                    } else if (!zAreEqual3) {
                        float f3 = 8000.0f * getResources().getDisplayMetrics().density;
                        cardFrontContainer.setCameraDistance(f3);
                        cardBackContainer.setCameraDistance(f3);
                        ObjectAnimator objectAnimatorOfFloat19 = ObjectAnimator.ofFloat(cardFrontContainer, "rotationY", 180.0f, 0.0f);
                        objectAnimatorOfFloat19.setDuration(100L);
                        objectAnimatorOfFloat19.setInterpolator(new DecelerateInterpolator());
                        objectAnimatorOfFloat19.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda116
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                ScanFragment.resetToFrontFace$lambda$1$0(cardFrontContainer, valueAnimator);
                            }
                        });
                        ObjectAnimator objectAnimatorOfFloat20 = ObjectAnimator.ofFloat(cardBackContainer, "rotationY", 0.0f, -180.0f);
                        objectAnimatorOfFloat20.setDuration(100L);
                        objectAnimatorOfFloat20.setInterpolator(new DecelerateInterpolator());
                        objectAnimatorOfFloat20.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda117
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                ScanFragment.resetToFrontFace$lambda$2$0(cardBackContainer, valueAnimator);
                            }
                        });
                        objectAnimatorOfFloat19.start();
                        objectAnimatorOfFloat20.start();
                    } else if (zIsAftermath) {
                        ObjectAnimator objectAnimatorOfFloat21 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleX", 1.25f, 1.0f);
                        ObjectAnimator objectAnimatorOfFloat22 = ObjectAnimator.ofFloat(cardFrontContainer, "scaleY", 1.25f, 1.0f);
                        float f4 = -(cardFrontContainer.getHeight() * 0.35f);
                        ObjectAnimator objectAnimatorOfFloat23 = ObjectAnimator.ofFloat(cardFrontContainer, "translationX", f4, 0.0f);
                        ObjectAnimator objectAnimatorOfFloat24 = ObjectAnimator.ofFloat(cardFrontContainer, (Property<ConstraintLayout, Float>) View.ROTATION, -90.0f, 0.0f);
                        AnimatorSet animatorSet5 = new AnimatorSet();
                        animatorSet5.playTogether(objectAnimatorOfFloat21, objectAnimatorOfFloat22, objectAnimatorOfFloat23, objectAnimatorOfFloat24);
                        animatorSet5.setDuration(0L);
                        animatorSet5.start();
                        ObjectAnimator objectAnimatorOfFloat25 = ObjectAnimator.ofFloat(cardBackContainer, "scaleX", 1.25f, 1.0f);
                        ObjectAnimator objectAnimatorOfFloat26 = ObjectAnimator.ofFloat(cardBackContainer, "scaleY", 1.25f, 1.0f);
                        ObjectAnimator objectAnimatorOfFloat27 = ObjectAnimator.ofFloat(cardBackContainer, "translationX", f4, 0.0f);
                        ObjectAnimator objectAnimatorOfFloat28 = ObjectAnimator.ofFloat(cardBackContainer, (Property<ConstraintLayout, Float>) View.ROTATION, -90.0f, 0.0f);
                        AnimatorSet animatorSet6 = new AnimatorSet();
                        animatorSet6.playTogether(objectAnimatorOfFloat25, objectAnimatorOfFloat26, objectAnimatorOfFloat27, objectAnimatorOfFloat28);
                        animatorSet6.setDuration(0L);
                        animatorSet6.start();
                    } else {
                        float height2 = cardFrontContainer.getHeight() * 0.25f;
                        float f5 = -(cardFrontContainer.getHeight() * 0.35f);
                        ObjectAnimator objectAnimatorOfFloat29 = ObjectAnimator.ofFloat(cardFrontContainer, "translationX", f5, height2);
                        objectAnimatorOfFloat29.setDuration(0L);
                        objectAnimatorOfFloat29.start();
                        ObjectAnimator objectAnimatorOfFloat30 = ObjectAnimator.ofFloat(cardBackContainer, "translationX", f5, height2);
                        objectAnimatorOfFloat30.setDuration(0L);
                        objectAnimatorOfFloat30.start();
                        resetSplitCardRotation();
                    }
                }
                i2 = i;
            }
            this.currentFace = i2;
            updateFaceInformation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetToFrontFace$lambda$1$0(ConstraintLayout constraintLayout, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        if (((Float) animatedValue).floatValue() > 90.0f || constraintLayout.getVisibility() != 4) {
            return;
        }
        constraintLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetToFrontFace$lambda$2$0(ConstraintLayout constraintLayout, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        if (((Float) animatedValue).floatValue() > -90.0f || constraintLayout.getVisibility() != 0) {
            return;
        }
        constraintLayout.setVisibility(4);
    }

    private final String sanitizeFileName(String cardName) {
        return new Regex("[/\\\\?%*:|\"<>]").replace(cardName, "_");
    }

    private final void saveImageToPicturesFolder(Context context, Bitmap bitmap, String folderName, String fileName, boolean isAlpha) {
        FileOutputStream fileOutputStream;
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_save_image");
        String strSanitizeFileName = sanitizeFileName(fileName);
        float width = bitmap.getWidth() * 0.05f;
        if (isAlpha) {
            width = 0.07f * bitmap.getWidth();
        }
        Bitmap roundedCornerBitmap = getRoundedCornerBitmap(bitmap, width);
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_display_name", strSanitizeFileName + ".png");
                contentValues.put("mime_type", MimeTypes.IMAGE_PNG);
                contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + DomExceptionUtils.SEPARATOR + folderName);
                Uri uriInsert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                if (uriInsert == null) {
                    Log.e("SaveImage", "Failed to create new MediaStore record.");
                    String string = getString(R.string.save_error);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    showFileError(context, string);
                    return;
                }
                fileOutputStream = context.getContentResolver().openOutputStream(uriInsert);
                Intrinsics.checkNotNull(fileOutputStream);
            } else {
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + File.separator + folderName);
                if (!file.exists() && !file.mkdirs()) {
                    Log.e("SaveImage", "Failed to create directory: " + file.getPath());
                    String string2 = getString(R.string.save_error);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    showFileError(context, string2);
                    return;
                }
                fileOutputStream = new FileOutputStream(new File(file, strSanitizeFileName + ".png"));
            }
            roundedCornerBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            showFileSavedMessage();
        } catch (Exception e) {
            Log.e("SaveImage", "Error saving image", e);
            String string3 = getString(R.string.save_error);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            showFileError(context, string3);
        }
    }

    static final void searchActivityLauncher$lambda$0(final ScanFragment scanFragment, ActivityResult result) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        MTGDBHelper mTGDBHelper = null;
        String stringExtra = data != null ? data.getStringExtra("cardPicked") : null;
        if (stringExtra == null || scanFragment.getActivity() == null) {
            return;
        }
        MTFullCard mTFullCard = (MTFullCard) new Gson().fromJson(stringExtra, MTFullCard.class);
        Intent data2 = result.getData();
        if (data2 != null) {
            iIntValue = data2.getIntExtra(OptionalModuleUtils.FACE, 0);
        } else {
            Integer face = mTFullCard.getFace();
            iIntValue = face != null ? face.intValue() : 0;
        }
        String lang = mTFullCard.getLang();
        String name = mTFullCard.getName();
        if (name == null) {
            name = "";
        }
        String set_code = mTFullCard.getSet_code();
        if (set_code == null) {
            set_code = "";
        }
        String collector_number = mTFullCard.getCollector_number();
        if (collector_number == null) {
            collector_number = "";
        }
        String scryfallid = mTFullCard.getScryfallid();
        if (scryfallid == null) {
            scryfallid = "";
        }
        CardMatch cardMatch = new CardMatch(null, null, 0, 0L, null, null, null, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, false, null, 2097151, null);
        cardMatch.setLang("en");
        cardMatch.setFace(iIntValue);
        cardMatch.setSet(set_code);
        cardMatch.setNumber(collector_number);
        cardMatch.setScryfallId(scryfallid);
        String oracleid = mTFullCard.getOracleid();
        cardMatch.setOracleId(oracleid != null ? oracleid : "");
        cardMatch.setDetectedCardLang("en");
        if (!Intrinsics.areEqual(lang, "en")) {
            cardMatch.setLang(lang);
            cardMatch.setDetectedCardLang(lang);
            if (name.length() > 0) {
                MTGDBHelper mTGDBHelper2 = scanFragment.mtgdbHelper;
                if (mTGDBHelper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelper");
                } else {
                    mTGDBHelper = mTGDBHelper2;
                }
                Iterator<CardRecord> it = mTGDBHelper.getExactMatch(name, cardMatch.getSet(), cardMatch.getFace(), cardMatch.getNumber()).iterator();
                if (it.hasNext()) {
                    cardMatch.setEnScryfallId(it.next().getScryfall_id());
                }
            } else {
                MTGDBHelper mTGDBHelper3 = scanFragment.mtgdbHelper;
                if (mTGDBHelper3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelper");
                    mTGDBHelper3 = null;
                }
                List<CardRecord> partialMatch = mTGDBHelper3.getPartialMatch(cardMatch.getSet(), cardMatch.getFace(), cardMatch.getNumber());
                if (partialMatch.isEmpty()) {
                    MTGDBHelper mTGDBHelper4 = scanFragment.mtgdbHelper;
                    if (mTGDBHelper4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelper");
                    } else {
                        mTGDBHelper = mTGDBHelper4;
                    }
                    partialMatch = mTGDBHelper.getPartialMatch(cardMatch.getSet(), 0, cardMatch.getNumber());
                }
                Iterator<CardRecord> it2 = partialMatch.iterator();
                if (it2.hasNext()) {
                    cardMatch.setEnScryfallId(it2.next().getScryfall_id());
                }
            }
            String type_line = mTFullCard.getType_line();
            if (type_line != null) {
                cardMatch.setLocalizedTypeLine(type_line);
            }
            String printed_name = mTFullCard.getPrinted_name();
            if (printed_name == null) {
                printed_name = mTFullCard.getName();
            }
            if (printed_name != null) {
                cardMatch.setLocalizedTitle(printed_name);
            }
            String oracle_text = mTFullCard.getOracle_text();
            if (oracle_text != null) {
                cardMatch.setLocalizedOracle(oracle_text);
            }
        }
        scanFragment.currentCardMatch = cardMatch;
        scanFragment.observing = false;
        CombinedAnalyzer combinedAnalyzer = scanFragment.combinedAnalyzer;
        if (combinedAnalyzer != null) {
            combinedAnalyzer.setPaused(true);
        }
        scanFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda144
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.searchActivityLauncher$lambda$0$0$3(this.f$0);
            }
        });
        ExecutorService executorService = scanFragment.backgroundExecutor;
        scanFragment.fetchCard(cardMatch, false);
        scanFragment.fetchRulings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void searchActivityLauncher$lambda$0$0$3(ScanFragment scanFragment) {
        scanFragment.getBinding().scrollView.scrollTo(0, 0);
    }

    private final void setFontAwesomeIconAndText(Button button, String iconCode, int labelTextId) {
        Typeface font = ResourcesCompat.getFont(button.getContext(), R.font.fa6regular);
        String string = button.getContext().getString(labelTextId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        button.setTypeface(font);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%s %s", Arrays.copyOf(new Object[]{iconCode, string}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        button.setText(str);
    }

    private final void setupCameraGestures() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.scaleGestureDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment.setupCameraGestures.1
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector detector) {
                CameraInfo cameraInfo;
                LiveData<ZoomState> zoomState;
                ZoomState value;
                CameraControl cameraControl;
                Intrinsics.checkNotNullParameter(detector, "detector");
                Camera camera = ScanFragment.this.camera;
                if (camera == null || (cameraInfo = camera.getCameraInfo()) == null || (zoomState = cameraInfo.getZoomState()) == null || (value = zoomState.getValue()) == null) {
                    return false;
                }
                float fCoerceIn = RangesKt.coerceIn(value.getZoomRatio() * detector.getScaleFactor(), value.getMinZoomRatio(), value.getMaxZoomRatio());
                Camera camera2 = ScanFragment.this.camera;
                if (camera2 != null && (cameraControl = camera2.getCameraControl()) != null) {
                    cameraControl.setZoomRatio(fCoerceIn);
                }
                ScanFragment.this.showZoomIndicator(fCoerceIn);
                return true;
            }
        });
        this.tapGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment.setupCameraGestures.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                CameraInfo cameraInfo;
                LiveData<ZoomState> zoomState;
                ZoomState value;
                CameraControl cameraControl;
                Intrinsics.checkNotNullParameter(e, "e");
                Camera camera = ScanFragment.this.camera;
                if (camera == null || (cameraInfo = camera.getCameraInfo()) == null || (zoomState = cameraInfo.getZoomState()) == null || (value = zoomState.getValue()) == null) {
                    return false;
                }
                float minZoomRatio = value.getZoomRatio() > 1.5f ? value.getMinZoomRatio() : RangesKt.coerceAtMost(2.0f, value.getMaxZoomRatio());
                Camera camera2 = ScanFragment.this.camera;
                if (camera2 != null && (cameraControl = camera2.getCameraControl()) != null) {
                    cameraControl.setZoomRatio(minZoomRatio);
                }
                ScanFragment.this.showZoomIndicator(minZoomRatio);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                if (ScanFragment.this.getContext() == null || ScanFragment.this.getActivity() == null) {
                    return false;
                }
                ScanFragment scanFragment = ScanFragment.this;
                View cardZone = scanFragment.getBinding().cardZone;
                Intrinsics.checkNotNullExpressionValue(cardZone, "cardZone");
                scanFragment.triggerTapToFocus(cardZone);
                boolean z = ScanFragment.this.scanPaused;
                ScanFragment scanFragment2 = ScanFragment.this;
                if (!z) {
                    CombinedAnalyzer combinedAnalyzer = scanFragment2.combinedAnalyzer;
                    if (combinedAnalyzer != null) {
                        combinedAnalyzer.resetContinuousState();
                    }
                    return true;
                }
                scanFragment2.scanPaused = false;
                ScanFragment.this.observing = true;
                CombinedAnalyzer combinedAnalyzer2 = ScanFragment.this.combinedAnalyzer;
                if (combinedAnalyzer2 != null) {
                    combinedAnalyzer2.setPaused(false);
                }
                ScanFragment.this.getBinding().pauseScanImageView.setImageResource(R.drawable.pause_button);
                ScanFragment.this.getBinding().pausedLabel.setVisibility(8);
                return true;
            }
        });
        getBinding().cardZoneContainer.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda52
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ScanFragment.setupCameraGestures$lambda$0(this.f$0, view, motionEvent);
            }
        });
    }

    static final boolean setupCameraGestures$lambda$0(ScanFragment scanFragment, View view, MotionEvent motionEvent) {
        if (scanFragment.getBinding().cardZone.getVisibility() != 0) {
            return false;
        }
        ScaleGestureDetector scaleGestureDetector = scanFragment.scaleGestureDetector;
        if (scaleGestureDetector != null) {
            scaleGestureDetector.onTouchEvent(motionEvent);
        }
        GestureDetector gestureDetector = scanFragment.tapGestureDetector;
        if (gestureDetector == null) {
            return true;
        }
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    private final void shareImage(Bitmap image, String cardName, boolean isAlpha) {
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_share_image");
        try {
            File file = new File(requireContext().getCacheDir(), "images");
            file.mkdirs();
            File file2 = new File(file, sanitizeFileName(cardName) + ".png");
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            float width = image.getWidth() * 0.05f;
            if (isAlpha) {
                width = 0.07f * image.getWidth();
            }
            getRoundedCornerBitmap(image, width).compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Uri uriForFile = FileProvider.getUriForFile(requireContext(), requireContext().getApplicationContext().getPackageName() + ".fileprovider", file2);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.addFlags(1);
            intent.setDataAndType(uriForFile, requireContext().getContentResolver().getType(uriForFile));
            intent.putExtra("android.intent.extra.STREAM", uriForFile);
            startActivity(Intent.createChooser(intent, "Share Card"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void showAddCardContainerSelection(final MTFullCard card) {
        if (getContext() == null || getActivity() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (preferencesManager.getCurrentUser() == null) {
            return;
        }
        MTCollection currentUserCollection = preferencesManager.getCurrentUserCollection();
        if (currentUserCollection == null) {
            currentUserCollection = new MTCollection(null, null, null, null, 0, 0, null, null, 255, null);
        }
        MTUserLists currentUserLists = preferencesManager.getCurrentUserLists();
        if (currentUserLists == null) {
            currentUserLists = new MTUserLists(null, null, 3, null);
        }
        new MoveCardDialogFragment.Builder().setCard(card).setAddMode(true).setCollection(currentUserCollection).setLists(currentUserLists).setDecks(preferencesManager.getCurrentUserDecks()).setListener(new MoveCardDialogListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$showAddCardContainerSelection$moveCardDialog$1
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
                    this.this$0.addCardToContainer(destinationContainerId, card);
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
                Call<MTCardListResponse> callCreateList = MTApiKt.getMtApi().createList(currentUser.getId(), mTEditListBody);
                this.this$0.getBinding().loadingOverlay.setVisibility(0);
                final ScanFragment scanFragment = this.this$0;
                final MTFullCard mTFullCard = card;
                callCreateList.enqueue(new Callback<MTCardListResponse>() { // from class: com.studiolaganne.lengendarylens.ScanFragment$showAddCardContainerSelection$moveCardDialog$1$onMoveCard$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCardListResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        Log.e("ScanFragment", "Failed to create MT Card List: " + t.getMessage());
                        scanFragment.getBinding().loadingOverlay.setVisibility(8);
                        Toast.makeText(scanFragment.requireContext(), R.string.error_creating_list, 0).show();
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
                        MTCardContainer list;
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (scanFragment.getActivity() == null || scanFragment.getContext() == null) {
                            return;
                        }
                        scanFragment.getBinding().loadingOverlay.setVisibility(8);
                        if (!response.isSuccessful()) {
                            Toast.makeText(scanFragment.requireContext(), R.string.error_creating_list, 0).show();
                            return;
                        }
                        MTCardListResponse mTCardListResponseBody = response.body();
                        if (mTCardListResponseBody == null || (list = mTCardListResponseBody.getList()) == null) {
                            return;
                        }
                        scanFragment.addCardToContainer(list.getId(), mTFullCard);
                    }
                });
            }
        }).build().show(getChildFragmentManager(), MoveCardDialogFragment.TAG);
    }

    private final void showFileError(final Context context, final String message) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(context, message, 1).show();
            }
        });
    }

    private final void showFileSavedMessage() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda113
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.showFileSavedMessage$lambda$0(this.f$0);
            }
        }, 200L);
    }

    static final void showFileSavedMessage$lambda$0(ScanFragment scanFragment) {
        final TextView imageSavedHelper = scanFragment.getBinding().imageSavedHelper;
        Intrinsics.checkNotNullExpressionValue(imageSavedHelper, "imageSavedHelper");
        imageSavedHelper.setVisibility(0);
        imageSavedHelper.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda112
            @Override // java.lang.Runnable
            public final void run() {
                imageSavedHelper.setVisibility(4);
            }
        }, 1500L);
    }

    private final void showInternetAlert() {
        if (getActivity() == null || this.stopping) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_internet_alert");
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.internet_error_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.internet_error_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = getString(R.string.internet_error_button);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder onDismissListener = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ScanFragment.showInternetAlert$lambda$0(this.f$0, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        }).setOnDismissListener(new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.showInternetAlert$lambda$1(this.f$0);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        onDismissListener.show(childFragmentManager, "CustomDialogFragment");
    }

    static final Unit showInternetAlert$lambda$0(ScanFragment scanFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        scanFragment.observing = true;
        scanFragment.displayingCard = false;
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit showInternetAlert$lambda$1(ScanFragment scanFragment) {
        scanFragment.observing = true;
        scanFragment.displayingCard = false;
        return Unit.INSTANCE;
    }

    static final void showInternetError$lambda$0(ScanFragment scanFragment) {
        scanFragment.removeCheckmarkAnimation();
        scanFragment.getBinding().overlayView.undim();
        scanFragment.getBinding().scrollView.setVisibility(4);
        scanFragment.getBinding().topBar.setVisibility(4);
        scanFragment.getBinding().actionItemsLayout.setVisibility(4);
        scanFragment.resetCapture();
        scanFragment.observing = false;
        scanFragment.displayingCard = false;
        scanFragment.showInternetAlert();
    }

    private final void showScanTutorial() {
        if (getContext() == null) {
            return;
        }
        this.observing = false;
        CombinedAnalyzer combinedAnalyzer = this.combinedAnalyzer;
        if (combinedAnalyzer != null) {
            combinedAnalyzer.setPaused(true);
        }
        this.scanTutorialActive = true;
        final View view = getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda71
                @Override // java.lang.Runnable
                public final void run() {
                    ScanFragment.showScanTutorial$lambda$0$0(this.f$0, view);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showScanTutorial$lambda$0$0(final ScanFragment scanFragment, View view) {
        if (scanFragment.getContext() == null) {
            scanFragment.observing = true;
            CombinedAnalyzer combinedAnalyzer = scanFragment.combinedAnalyzer;
            if (combinedAnalyzer != null) {
                combinedAnalyzer.setPaused(false);
                return;
            }
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.scanTutorialOverlay);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        View viewFindViewById = view.findViewById(R.id.scanTutorialContainer);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById;
        constraintLayout2.setVisibility(0);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(scanFragment.getContext());
        lottieAnimationView.setAnimation(R.raw.arrow);
        lottieAnimationView.setElevation(100.0f);
        lottieAnimationView.setRotation(30.0f);
        lottieAnimationView.setScaleX(-1.0f);
        lottieAnimationView.setRepeatCount(0);
        lottieAnimationView.setSpeed(2.0f);
        lottieAnimationView.setId(View.generateViewId());
        constraintLayout2.addView(lottieAnimationView);
        final int width = view.getWidth();
        view.getHeight();
        int height = scanFragment.getBinding().scanListRecyclerView.getHeight();
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(height / 2, height);
        layoutParams.leftMargin = 0;
        layoutParams.bottomMargin = (height * 3) / 4;
        lottieAnimationView.setLayoutParams(layoutParams);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout2);
        constraintSet.connect(lottieAnimationView.getId(), 6, 0, 6);
        constraintSet.connect(lottieAnimationView.getId(), 4, 0, 4);
        constraintSet.applyTo(constraintLayout2);
        lottieAnimationView.playAnimation();
        View viewInflate = LayoutInflater.from(scanFragment.getContext()).inflate(R.layout.tutorial_info_view, (ViewGroup) constraintLayout2, false);
        viewInflate.setElevation(100.0f);
        viewInflate.setId(View.generateViewId());
        TextView textView = (TextView) viewInflate.findViewById(R.id.tutorial_text);
        textView.setTextSize(15.0f);
        textView.setText(scanFragment.getResources().getString(R.string.scan_tutorial_text_1));
        constraintLayout2.addView(viewInflate);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(width / 2, -2);
        layoutParams2.bottomMargin = -((height * 2) / 3);
        viewInflate.setLayoutParams(layoutParams2);
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(constraintLayout2);
        constraintSet2.connect(viewInflate.getId(), 1, 0, 1);
        constraintSet2.connect(viewInflate.getId(), 4, lottieAnimationView.getId(), 3);
        constraintSet2.applyTo(constraintLayout2);
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda120
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.showScanTutorial$lambda$0$0$3(this.f$0, constraintLayout2, width);
            }
        }, 500L);
        viewInflate.setAlpha(0.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewInflate, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showScanTutorial$lambda$0$0$3(ScanFragment scanFragment, ConstraintLayout constraintLayout, int i) {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(scanFragment.getContext());
        lottieAnimationView.setAnimation(R.raw.arrow);
        lottieAnimationView.setElevation(100.0f);
        lottieAnimationView.setRotation(15.0f);
        lottieAnimationView.setScaleX(1.0f);
        lottieAnimationView.setRepeatCount(0);
        lottieAnimationView.setSpeed(2.0f);
        lottieAnimationView.setId(View.generateViewId());
        constraintLayout.addView(lottieAnimationView);
        int height = scanFragment.getBinding().scanListRecyclerView.getHeight();
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(height / 2, height);
        layoutParams.leftMargin = (height * 5) / 7;
        layoutParams.bottomMargin = 0;
        lottieAnimationView.setLayoutParams(layoutParams);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(lottieAnimationView.getId(), 6, 0, 6);
        constraintSet.connect(lottieAnimationView.getId(), 4, 0, 4);
        constraintSet.applyTo(constraintLayout);
        lottieAnimationView.playAnimation();
        View viewInflate = LayoutInflater.from(scanFragment.getContext()).inflate(R.layout.tutorial_info_view, (ViewGroup) constraintLayout, false);
        viewInflate.setElevation(100.0f);
        viewInflate.setId(View.generateViewId());
        TextView textView = (TextView) viewInflate.findViewById(R.id.tutorial_text);
        textView.setTextSize(15.0f);
        textView.setText(scanFragment.getResources().getString(R.string.scan_tutorial_text_2));
        constraintLayout.addView(viewInflate);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(i / 2, -2);
        layoutParams2.bottomMargin = -((height * 3) / 4);
        viewInflate.setLayoutParams(layoutParams2);
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(constraintLayout);
        constraintSet2.connect(viewInflate.getId(), 2, 0, 2);
        constraintSet2.connect(viewInflate.getId(), 4, lottieAnimationView.getId(), 3);
        constraintSet2.applyTo(constraintLayout);
    }

    private final void showScannerUnavailableError(String error) {
        if (getContext() == null || getActivity() == null) {
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.scanner_unavailable_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.scanner_unavailable_message);
        if (error == null) {
            error = "";
        }
        CustomDialogFragment.Builder body = title.setBody(string2 + "\n\n" + error);
        String string3 = getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda163
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ScanFragment.showScannerUnavailableError$lambda$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "ScannerUnavailableDialog");
    }

    static final Unit showScannerUnavailableError$lambda$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showZoomIndicator(float zoomRatio) {
        Handler handler;
        final TextView zoomIndicator = getBinding().zoomIndicator;
        Intrinsics.checkNotNullExpressionValue(zoomIndicator, "zoomIndicator");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%.1fx", Arrays.copyOf(new Object[]{Float.valueOf(zoomRatio)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        zoomIndicator.setText(str);
        zoomIndicator.animate().cancel();
        zoomIndicator.setAlpha(1.0f);
        Runnable runnable = this.zoomIndicatorRunnable;
        if (runnable != null && (handler = this.zoomIndicatorHandler) != null) {
            handler.removeCallbacks(runnable);
        }
        if (this.zoomIndicatorHandler == null) {
            this.zoomIndicatorHandler = new Handler(Looper.getMainLooper());
        }
        Runnable runnable2 = new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda87
            @Override // java.lang.Runnable
            public final void run() {
                zoomIndicator.animate().alpha(0.0f).setDuration(300L).start();
            }
        };
        this.zoomIndicatorRunnable = runnable2;
        Handler handler2 = this.zoomIndicatorHandler;
        if (handler2 != null) {
            handler2.postDelayed(runnable2, 1500L);
        }
    }

    private final void startCamera() {
        final Context context = getContext();
        if (context != null) {
            final ListenableFuture<ProcessCameraProvider> companion = ProcessCameraProvider.INSTANCE.getInstance(context);
            companion.addListener(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda148
                @Override // java.lang.Runnable
                public final void run() throws CameraAccessException {
                    ScanFragment.startCamera$lambda$0$0(this.f$0, companion, context);
                }
            }, ContextCompat.getMainExecutor(context));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v19, types: [android.util.Size] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, android.util.Size] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v21, types: [android.util.Size] */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    public static final void startCamera$lambda$0$0(ScanFragment scanFragment, ListenableFuture listenableFuture, Context context) throws CameraAccessException {
        String str;
        Size size;
        Size size2;
        scanFragment.cameraProvider = (ProcessCameraProvider) listenableFuture.get();
        CameraSelector cameraSelectorBuild = new CameraSelector.Builder().requireLensFacing(1).build();
        Intrinsics.checkNotNullExpressionValue(cameraSelectorBuild, "build(...)");
        Preview previewBuild = new Preview.Builder().build();
        previewBuild.setSurfaceProvider(scanFragment.getBinding().viewFinder.getSurfaceProvider());
        Intrinsics.checkNotNullExpressionValue(previewBuild, "also(...)");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new Size(new DisplayMetrics().heightPixels, new DisplayMetrics().widthPixels);
        Object systemService = context.getSystemService("camera");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        CameraManager cameraManager = (CameraManager) systemService;
        String[] cameraIdList = cameraManager.getCameraIdList();
        Intrinsics.checkNotNullExpressionValue(cameraIdList, "getCameraIdList(...)");
        String[] strArr = cameraIdList;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = null;
                break;
            }
            str = strArr[i];
            CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
            Intrinsics.checkNotNullExpressionValue(cameraCharacteristics, "getCameraCharacteristics(...)");
            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            if (num != null && num.intValue() == 1) {
                break;
            } else {
                i++;
            }
        }
        String str2 = str;
        if (str2 != null) {
            CameraCharacteristics cameraCharacteristics2 = cameraManager.getCameraCharacteristics(str2);
            Intrinsics.checkNotNullExpressionValue(cameraCharacteristics2, "getCameraCharacteristics(...)");
            Object obj = cameraCharacteristics2.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            Intrinsics.checkNotNull(obj);
            Size[] outputSizes = ((StreamConfigurationMap) obj).getOutputSizes(35);
            Intrinsics.checkNotNull(outputSizes);
            if (outputSizes.length == 0) {
                size = 0;
            } else {
                size = outputSizes[0];
                int lastIndex = ArraysKt.getLastIndex(outputSizes);
                if (lastIndex != 0) {
                    int width = size.getWidth() * size.getHeight();
                    if (1 <= lastIndex) {
                        int i2 = 1;
                        ?? r8 = size;
                        while (true) {
                            Size size3 = outputSizes[i2];
                            int width2 = size3.getWidth() * size3.getHeight();
                            size = r8;
                            if (width < width2) {
                                size = size3;
                                width = width2;
                            }
                            if (i2 == lastIndex) {
                                break;
                            }
                            i2++;
                            r8 = size;
                        }
                    }
                }
            }
            if (size == 0) {
                size = (Size) objectRef.element;
            }
            objectRef.element = size;
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
            Object systemService2 = context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.app.ActivityManager");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) systemService2).getMemoryInfo(memoryInfo);
            long j = memoryInfo.totalMem;
            if (iAvailableProcessors < 6 || j < 4000000000L) {
                if (outputSizes.length == 0) {
                    size2 = 0;
                } else {
                    size2 = outputSizes[0];
                    int lastIndex2 = ArraysKt.getLastIndex(outputSizes);
                    if (lastIndex2 != 0) {
                        int iAbs = Math.abs((size2.getWidth() * size2.getHeight()) - 2073600);
                        if (1 <= lastIndex2) {
                            int i3 = 1;
                            ?? r1 = size2;
                            while (true) {
                                Size size4 = outputSizes[i3];
                                int iAbs2 = Math.abs((size4.getWidth() * size4.getHeight()) - 2073600);
                                size2 = r1;
                                if (iAbs > iAbs2) {
                                    size2 = size4;
                                    iAbs = iAbs2;
                                }
                                if (i3 == lastIndex2) {
                                    break;
                                }
                                i3++;
                                r1 = size2;
                            }
                        }
                    }
                }
                if (size2 == 0) {
                    size2 = (Size) objectRef.element;
                }
                objectRef.element = size2;
            }
        }
        CombinedAnalyzer combinedAnalyzer = scanFragment.combinedAnalyzer;
        if (combinedAnalyzer != null) {
            ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setTargetResolution((Size) objectRef.element).setBackpressureStrategy(0).build();
            imageAnalysisBuild.setAnalyzer(scanFragment.backgroundExecutor, combinedAnalyzer);
            Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild, "also(...)");
            combinedAnalyzer.reset();
            ProcessCameraProvider processCameraProvider = scanFragment.cameraProvider;
            if (processCameraProvider != null) {
                processCameraProvider.unbindAll();
            }
            try {
                ProcessCameraProvider processCameraProvider2 = scanFragment.cameraProvider;
                scanFragment.camera = processCameraProvider2 != null ? processCameraProvider2.bindToLifecycle(scanFragment, cameraSelectorBuild, previewBuild, imageAnalysisBuild) : null;
            } catch (IllegalArgumentException unused) {
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string = scanFragment.getString(R.string.camera_unavailable_title);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CustomDialogFragment.Builder title = builder.setTitle(string);
                String string2 = scanFragment.getString(R.string.camera_unavailable_body);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder body = title.setBody(string2);
                String string3 = scanFragment.getString(R.string.internet_error_button);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda105
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return ScanFragment.startCamera$lambda$0$0$3$1(((Boolean) obj2).booleanValue(), (CustomDialogFragment) obj3);
                    }
                });
                FragmentManager parentFragmentManager = scanFragment.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
                positiveButton.show(parentFragmentManager, "camera_unavailable");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startCamera$lambda$0$0$3$1(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void startCameraCapture() {
        SensorManager sensorManager;
        if (!this.displayingCard && !this.scanPaused) {
            this.observing = true;
        }
        Sensor sensor = this.accelerometer;
        if (sensor != null && (sensorManager = this.sensorManager) != null) {
            sensorManager.registerListener(this, sensor, 3);
        }
        if (allPermissionsGranted()) {
            startCamera();
        } else {
            this.requestPermissionsLauncher.launch(REQUIRED_PERMISSIONS);
        }
    }

    private final void stopCameraCapture() {
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        ProcessCameraProvider processCameraProvider = this.cameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbindAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void triggerTapToFocus(View view) {
        Camera camera = this.camera;
        if (camera != null) {
            MeteringPointFactory meteringPointFactory = getBinding().viewFinder.getMeteringPointFactory();
            Intrinsics.checkNotNullExpressionValue(meteringPointFactory, "getMeteringPointFactory(...)");
            MeteringPoint meteringPointCreatePoint = meteringPointFactory.createPoint(view.getWidth() / 2.0f, view.getHeight() / 2.0f);
            Intrinsics.checkNotNullExpressionValue(meteringPointCreatePoint, "createPoint(...)");
            FocusMeteringAction focusMeteringActionBuild = new FocusMeteringAction.Builder(meteringPointCreatePoint).setAutoCancelDuration(3L, TimeUnit.SECONDS).build();
            Intrinsics.checkNotNullExpressionValue(focusMeteringActionBuild, "build(...)");
            camera.getCameraControl().startFocusAndMetering(focusMeteringActionBuild);
        }
    }

    private final void updateCardCountAndTotalPrice() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        String preferredCurrency = preferencesManager.getPreferredCurrency();
        String preferredMarket = preferencesManager.getPreferredMarket();
        Iterator<MTFullCard> it = this.currentScanList.iterator();
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        while (true) {
            int iIntValue = 1;
            if (!it.hasNext()) {
                break;
            }
            MTFullCard next = it.next();
            double cardPrice = GameUtils.INSTANCE.getInstance().getCardPrice(next, preferredMarket);
            Integer quantity = next.getQuantity();
            if (quantity != null) {
                iIntValue = quantity.intValue();
            }
            d += cardPrice * ((double) iIntValue);
        }
        Iterator<T> it2 = this.currentScanList.iterator();
        int iIntValue2 = 0;
        while (it2.hasNext()) {
            Integer quantity2 = ((MTFullCard) it2.next()).getQuantity();
            iIntValue2 += quantity2 != null ? quantity2.intValue() : 1;
        }
        if (iIntValue2 == 0) {
            getBinding().cardsCountTextView.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            getBinding().totalPriceTextView.setText("--");
        } else {
            getBinding().cardsCountTextView.setText(String.valueOf(iIntValue2));
            getBinding().totalPriceTextView.setText(GameUtils.INSTANCE.getInstance().formatPrice(d, preferredCurrency));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCardListFromNewContainer(MTCardContainer list) {
        if (getActivity() == null || getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (this.currentListId != -1) {
            preferencesManager.incrementContainerVersion(list.getId());
            preferencesManager.incrementCollectionVersion();
            preferencesManager.incrementListsVersion();
            CardContainerCache.INSTANCE.setCachedContainer(list, new CacheKey(list.getId(), this.currentOrderBy, this.currentOrderDirection, this.currentGroupBy, this.currentNameFilter, this.currentScryfallFilter, this.currentPage));
        }
        ArrayList cards = list.getCards();
        if (cards == null) {
            cards = CollectionsKt.emptyList();
        }
        if (cards.isEmpty() && this.currentGroupBy != null) {
            List<MTCardGroup> grouped_cards = list.getGrouped_cards();
            if (grouped_cards == null) {
                grouped_cards = CollectionsKt.emptyList();
            }
            cards = new ArrayList();
            Iterator<MTCardGroup> it = grouped_cards.iterator();
            while (it.hasNext()) {
                List<MTFullCard> cards2 = it.next().getCards();
                if (cards2 != null) {
                    cards.addAll(cards2);
                }
            }
            preferencesManager.incrementDecksVersion();
        }
        if (cards.isEmpty()) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        this.currentMTCardList = CollectionsKt.toMutableList((Collection) cards);
        if (this.currentCardListIndex >= cards.size()) {
            this.currentCardListIndex = cards.size() - 1;
        }
        displayMTCard$default(this, this.currentMTCardList.get(this.currentCardListIndex), true, false, 4, null);
        updateNextPrevious();
        if (this.currentCardListIndex < this.currentMTCardList.size() - 1) {
            fetchNextCard();
        }
        if (this.currentCardListIndex > 0) {
            fetchPreviousCard();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0291 A[LOOP:10: B:101:0x028b->B:103:0x0291, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0441 A[LOOP:7: B:150:0x043b->B:152:0x0441, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0486 A[LOOP:8: B:154:0x0480->B:156:0x0486, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x060d  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0683  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x06be  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x06ee  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x06f4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0248 A[LOOP:9: B:97:0x0242->B:99:0x0248, LOOP_END] */
    /* JADX WARN: Type inference failed for: r3v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v0, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v67, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateFaceInformation() {
        List<MTFace> card_faces;
        String oracleText;
        boolean z;
        TextView detailTitleLabel;
        String str;
        String str2;
        Iterator it;
        String str3;
        Iterator it2;
        SymbolToImage symbolToImage;
        TextView detailTypeLabel;
        String printed_type_line;
        String type_line;
        CardMatch cardMatch;
        String str4;
        PreferencesManager preferencesManager;
        SpannableStringBuilder spannableStringBuilder;
        int i;
        SpannableStringBuilder spannableStringBuilder2;
        int i2;
        TextView detailOracleTextLabel;
        final TextView detailOracleTextLabelOriginal;
        String oracle_text;
        String printed_text;
        CardMatch cardMatch2;
        SymbolToImage symbolToImage2;
        String strRemoveDuplicateParentheses;
        SymbolToImage symbolToImage3;
        String strRemoveDuplicateParentheses2;
        SymbolToImage symbolToImage4;
        SymbolToImage symbolToImage5;
        SymbolToImage symbolToImage6;
        SymbolToImage symbolToImage7;
        Object next;
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_update_face");
        MTFullCard mTFullCard = this.currentMTCard;
        if (mTFullCard == null || (card_faces = mTFullCard.getCard_faces()) == null) {
            return;
        }
        if (getContext() != null && this.currentFace < card_faces.size()) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "en";
            ?? lang = mTFullCard.getLang();
            if (lang != 0) {
                if (!Intrinsics.areEqual((Object) lang, "en")) {
                    objectRef.element = lang;
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            CardMatch cardMatch3 = this.currentCardMatch;
            if (cardMatch3 != null) {
                if (!Intrinsics.areEqual(cardMatch3.getDetectedCardLang(), "en")) {
                    objectRef.element = cardMatch3.getDetectedCardLang();
                }
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
            this.cardLang = (String) objectRef.element;
            MTFace mTFace = card_faces.get(this.currentFace);
            ImageView flagImage = getBinding().flagImage;
            Intrinsics.checkNotNullExpressionValue(flagImage, "flagImage");
            String str5 = this.cardLang;
            if (Intrinsics.areEqual(str5, UserDataStore.PHONE)) {
                str5 = "en";
            }
            flagImage.setImageResource(getResources().getIdentifier("flag_" + str5, "drawable", flagImage.getContext().getPackageName()));
            String printed_name = mTFace.getPrinted_name();
            String name = mTFace.getName();
            CardMatch cardMatch4 = this.currentCardMatch;
            if (cardMatch4 != null) {
                if (!Intrinsics.areEqual(cardMatch4.getDetectedCardLang(), "en")) {
                    List<MTGDBHelperLocalized> list = this.mtgdbHelpersEnabled;
                    if (list == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelpersEnabled");
                        list = null;
                    }
                    Iterator<MTGDBHelperLocalized> it3 = list.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        MTGDBHelperLocalized next2 = it3.next();
                        if (Intrinsics.areEqual(next2.getLocale(), cardMatch4.getDetectedCardLang())) {
                            String oracleid = mTFullCard.getOracleid();
                            if (oracleid == null) {
                                oracleid = "";
                            }
                            printed_name = next2.getNameForCard(oracleid, this.currentFace);
                        }
                    }
                }
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
            }
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            MTGDBHelper mTGDBHelper = this.mtgdbHelper;
            if (mTGDBHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelper");
                mTGDBHelper = null;
            }
            List<MTGDBHelperLocalized> list2 = this.mtgdbHelpers;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelpers");
                list2 = null;
            }
            CardLanguageHelper cardLanguageHelper = new CardLanguageHelper(contextRequireContext, mTGDBHelper, list2);
            String str6 = printed_name == null ? name == null ? "" : name : printed_name;
            String str7 = this.cardLang;
            String oracleid2 = mTFullCard.getOracleid();
            if (oracleid2 == null) {
                oracleid2 = "";
            }
            String scryfallid = mTFullCard.getScryfallid();
            if (scryfallid == null) {
                scryfallid = "";
            }
            String set_code = mTFullCard.getSet_code();
            if (set_code == null) {
                set_code = "";
            }
            String collector_number = mTFullCard.getCollector_number();
            if (collector_number == null) {
                collector_number = "";
            }
            List<CardLanguageRow> cardLanguageRows = cardLanguageHelper.getCardLanguageRows(str6, str7, oracleid2, scryfallid, set_code, collector_number, this.currentFace);
            final CardLanguageAdapter cardLanguageAdapter = new CardLanguageAdapter(cardLanguageRows, this);
            View view = this.popupView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popupView");
                view = null;
            }
            final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.language_recycler_view);
            requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda106
                @Override // java.lang.Runnable
                public final void run() {
                    ScanFragment.updateFaceInformation$lambda$0$0$3(recyclerView, cardLanguageAdapter);
                }
            });
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            PreferencesManager preferencesManager2 = new PreferencesManager(contextRequireContext2);
            if (preferencesManager2.getScanDisplayLanguage() == ScanDisplayLanguage.TRANSLATED && this.translateCardIfPossible) {
                String deviceLanguage = preferencesManager2.getDeviceLanguage();
                if (!Intrinsics.areEqual(deviceLanguage, mTFullCard.getLang()) && !Intrinsics.areEqual(deviceLanguage, "en")) {
                    Iterator<T> it4 = cardLanguageRows.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            next = it4.next();
                            if (Intrinsics.areEqual(((CardLanguageRow) next).getLang(), deviceLanguage)) {
                                break;
                            }
                        } else {
                            next = null;
                            break;
                        }
                    }
                    CardLanguageRow cardLanguageRow = (CardLanguageRow) next;
                    if (cardLanguageRow != null) {
                        printed_name = cardLanguageRow.getTitle();
                        cardLanguageRow.getTypeLine();
                        oracleText = cardLanguageRow.getOracleText();
                        Unit unit7 = Unit.INSTANCE;
                        Unit unit8 = Unit.INSTANCE;
                        z = true;
                    }
                    detailTitleLabel = getBinding().detailTitleLabel;
                    Intrinsics.checkNotNullExpressionValue(detailTitleLabel, "detailTitleLabel");
                    if (z) {
                        String str8 = printed_name;
                        str = "mtgdbHelpersEnabled";
                        str2 = "";
                        List listListOf = CollectionsKt.listOf(new StyleSpan(1), new AbsoluteSizeSpan(20, true), new ForegroundColorSpan(-1));
                        List listListOf2 = CollectionsKt.listOf(new StyleSpan(0), new AbsoluteSizeSpan(17, true), new ForegroundColorSpan(-3355444));
                        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(str8);
                        it = listListOf.iterator();
                        while (it.hasNext()) {
                        }
                        str3 = oracleText;
                        spannableStringBuilder3.append((CharSequence) "\n");
                        spannableStringBuilder3.append((CharSequence) ("(" + ((Object) name) + ")"));
                        it2 = listListOf2.iterator();
                        while (it2.hasNext()) {
                        }
                        detailTitleLabel.setText(spannableStringBuilder3);
                        String mana_cost = mTFace.getMana_cost();
                        String strReplace$default = StringsKt.replace$default(mana_cost == null ? str2 : mana_cost, "}{", "} {", false, 4, (Object) null);
                        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size);
                        symbolToImage = this.symbolToImage;
                        String str9 = "symbolToImage";
                        if (symbolToImage == null) {
                        }
                        SpannableString spannableStringStringToAttributedStringWithSymbols = symbolToImage.stringToAttributedStringWithSymbols(strReplace$default, dimensionPixelSize, new CharacterStyle[0]);
                        TextView detailManaCostLabel = getBinding().detailManaCostLabel;
                        Intrinsics.checkNotNullExpressionValue(detailManaCostLabel, "detailManaCostLabel");
                        detailManaCostLabel.setText(spannableStringStringToAttributedStringWithSymbols);
                        detailTypeLabel = getBinding().detailTypeLabel;
                        Intrinsics.checkNotNullExpressionValue(detailTypeLabel, "detailTypeLabel");
                        printed_type_line = mTFace.getPrinted_type_line();
                        type_line = mTFace.getType_line();
                        if (type_line == null) {
                        }
                        cardMatch = this.currentCardMatch;
                        if (cardMatch == null) {
                        }
                        if (z) {
                        }
                    } else {
                        String str82 = printed_name;
                        str = "mtgdbHelpersEnabled";
                        str2 = "";
                        List listListOf3 = CollectionsKt.listOf(new StyleSpan(1), new AbsoluteSizeSpan(20, true), new ForegroundColorSpan(-1));
                        List listListOf22 = CollectionsKt.listOf(new StyleSpan(0), new AbsoluteSizeSpan(17, true), new ForegroundColorSpan(-3355444));
                        SpannableStringBuilder spannableStringBuilder32 = new SpannableStringBuilder(str82);
                        it = listListOf3.iterator();
                        while (it.hasNext()) {
                        }
                        str3 = oracleText;
                        spannableStringBuilder32.append((CharSequence) "\n");
                        spannableStringBuilder32.append((CharSequence) ("(" + ((Object) name) + ")"));
                        it2 = listListOf22.iterator();
                        while (it2.hasNext()) {
                        }
                        detailTitleLabel.setText(spannableStringBuilder32);
                        String mana_cost2 = mTFace.getMana_cost();
                        String strReplace$default2 = StringsKt.replace$default(mana_cost2 == null ? str2 : mana_cost2, "}{", "} {", false, 4, (Object) null);
                        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size);
                        symbolToImage = this.symbolToImage;
                        String str92 = "symbolToImage";
                        if (symbolToImage == null) {
                        }
                        SpannableString spannableStringStringToAttributedStringWithSymbols2 = symbolToImage.stringToAttributedStringWithSymbols(strReplace$default2, dimensionPixelSize2, new CharacterStyle[0]);
                        TextView detailManaCostLabel2 = getBinding().detailManaCostLabel;
                        Intrinsics.checkNotNullExpressionValue(detailManaCostLabel2, "detailManaCostLabel");
                        detailManaCostLabel2.setText(spannableStringStringToAttributedStringWithSymbols2);
                        detailTypeLabel = getBinding().detailTypeLabel;
                        Intrinsics.checkNotNullExpressionValue(detailTypeLabel, "detailTypeLabel");
                        printed_type_line = mTFace.getPrinted_type_line();
                        type_line = mTFace.getType_line();
                        if (type_line == null) {
                        }
                        cardMatch = this.currentCardMatch;
                        if (cardMatch == null) {
                        }
                        if (z) {
                            String str10 = printed_type_line;
                            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(str10);
                            String str11 = printed_type_line;
                            preferencesManager = preferencesManager2;
                            spannableStringBuilder4.setSpan(new AbsoluteSizeSpan(18, true), 0, str11.length(), 33);
                            spannableStringBuilder4.setSpan(new ForegroundColorSpan(-16777216), 0, str11.length(), 33);
                            SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder("(" + ((Object) type_line) + ")");
                            int i3 = 0;
                            spannableStringBuilder5.setSpan(new AbsoluteSizeSpan(16, true), 0, spannableStringBuilder5.length(), 33);
                            spannableStringBuilder5.setSpan(new ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.middle_grey)), 0, spannableStringBuilder5.length(), 33);
                            SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder(str10);
                            spannableStringBuilder = spannableStringBuilder4;
                            i = 0;
                            while (i < spannableStringBuilder.length()) {
                            }
                            spannableStringBuilder6.append((CharSequence) "\n");
                            spannableStringBuilder6.append((CharSequence) ("(" + ((Object) type_line) + ")"));
                            spannableStringBuilder2 = spannableStringBuilder5;
                            while (i2 < spannableStringBuilder2.length()) {
                            }
                            detailTypeLabel.setText(spannableStringBuilder6);
                            detailOracleTextLabel = getBinding().detailOracleTextLabel;
                            Intrinsics.checkNotNullExpressionValue(detailOracleTextLabel, "detailOracleTextLabel");
                            detailOracleTextLabelOriginal = getBinding().detailOracleTextLabelOriginal;
                            Intrinsics.checkNotNullExpressionValue(detailOracleTextLabelOriginal, "detailOracleTextLabelOriginal");
                            final TextView detailOracleTextShowOriginal = getBinding().detailOracleTextShowOriginal;
                            Intrinsics.checkNotNullExpressionValue(detailOracleTextShowOriginal, "detailOracleTextShowOriginal");
                            detailOracleTextLabelOriginal.setVisibility(8);
                            detailOracleTextShowOriginal.setVisibility(0);
                            detailOracleTextShowOriginal.setPaintFlags(8 | detailOracleTextShowOriginal.getPaintFlags());
                            ViewExtensionsKt.setOnClickWithFade(detailOracleTextShowOriginal, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda107
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ScanFragment.updateFaceInformation$lambda$0$0$14(detailOracleTextShowOriginal, detailOracleTextLabelOriginal);
                                }
                            });
                            oracle_text = mTFace.getOracle_text();
                            if (oracle_text == null) {
                            }
                            printed_text = mTFace.getPrinted_text();
                            if (printed_text == null) {
                            }
                            cardMatch2 = this.currentCardMatch;
                            if (cardMatch2 != null) {
                            }
                            String str12 = oracle_text;
                            if (z) {
                                String strReplace$default3 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str12, "\n", "\n\n", false, 4, (Object) null), "}:", "} :", false, 4, (Object) null), "}{", "} {", false, 4, (Object) null);
                                String strReplace$default4 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "\n", "\n\n", false, 4, (Object) null), "}:", "} :", false, 4, (Object) null), "}{", "} {", false, 4, (Object) null);
                                symbolToImage2 = this.symbolToImage;
                                if (symbolToImage2 == null) {
                                }
                                strRemoveDuplicateParentheses = symbolToImage2.removeDuplicateParentheses(strReplace$default3);
                                symbolToImage3 = this.symbolToImage;
                                if (symbolToImage3 == null) {
                                }
                                strRemoveDuplicateParentheses2 = symbolToImage3.removeDuplicateParentheses(strReplace$default4);
                                if (z) {
                                    final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                                    objectRef2.element = objectRef.element;
                                    if (z) {
                                    }
                                    int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.symbol_oracle_size);
                                    symbolToImage4 = this.symbolToImage;
                                    if (symbolToImage4 == null) {
                                    }
                                    Context contextRequireContext3 = requireContext();
                                    Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                                    SpannableString spannableStringStringToAttributedStringWithSymbolsAndLinks = symbolToImage4.stringToAttributedStringWithSymbolsAndLinks(strRemoveDuplicateParentheses2, dimensionPixelSize3, contextRequireContext3, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda108
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ScanFragment.updateFaceInformation$lambda$0$0$16(this.f$0, objectRef2, (String) obj);
                                        }
                                    }, new ForegroundColorSpan(-1));
                                    symbolToImage5 = this.symbolToImage;
                                    if (symbolToImage5 == null) {
                                    }
                                    Context contextRequireContext4 = requireContext();
                                    Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                                    SpannableString spannableStringStringToAttributedStringWithSymbolsAndLinks2 = symbolToImage6.stringToAttributedStringWithSymbolsAndLinks(strRemoveDuplicateParentheses, dimensionPixelSize3, contextRequireContext4, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda110
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ScanFragment.updateFaceInformation$lambda$0$0$17(this.f$0, objectRef2, (String) obj);
                                        }
                                    }, new CharacterStyle[0]);
                                    detailOracleTextLabel.setText(spannableStringStringToAttributedStringWithSymbolsAndLinks);
                                    detailOracleTextLabelOriginal.setText(spannableStringStringToAttributedStringWithSymbolsAndLinks2);
                                    detailOracleTextLabel.setMovementMethod(LinkMovementMethod.getInstance());
                                    detailOracleTextLabelOriginal.setMovementMethod(LinkMovementMethod.getInstance());
                                } else {
                                    final Ref.ObjectRef objectRef22 = new Ref.ObjectRef();
                                    objectRef22.element = objectRef.element;
                                    if (z) {
                                    }
                                    int dimensionPixelSize32 = getResources().getDimensionPixelSize(R.dimen.symbol_oracle_size);
                                    symbolToImage4 = this.symbolToImage;
                                    if (symbolToImage4 == null) {
                                    }
                                    Context contextRequireContext32 = requireContext();
                                    Intrinsics.checkNotNullExpressionValue(contextRequireContext32, "requireContext(...)");
                                    SpannableString spannableStringStringToAttributedStringWithSymbolsAndLinks3 = symbolToImage4.stringToAttributedStringWithSymbolsAndLinks(strRemoveDuplicateParentheses2, dimensionPixelSize32, contextRequireContext32, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda108
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ScanFragment.updateFaceInformation$lambda$0$0$16(this.f$0, objectRef22, (String) obj);
                                        }
                                    }, new ForegroundColorSpan(-1));
                                    symbolToImage5 = this.symbolToImage;
                                    if (symbolToImage5 == null) {
                                    }
                                    Context contextRequireContext42 = requireContext();
                                    Intrinsics.checkNotNullExpressionValue(contextRequireContext42, "requireContext(...)");
                                    SpannableString spannableStringStringToAttributedStringWithSymbolsAndLinks22 = symbolToImage6.stringToAttributedStringWithSymbolsAndLinks(strRemoveDuplicateParentheses, dimensionPixelSize32, contextRequireContext42, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda110
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ScanFragment.updateFaceInformation$lambda$0$0$17(this.f$0, objectRef22, (String) obj);
                                        }
                                    }, new CharacterStyle[0]);
                                    detailOracleTextLabel.setText(spannableStringStringToAttributedStringWithSymbolsAndLinks3);
                                    detailOracleTextLabelOriginal.setText(spannableStringStringToAttributedStringWithSymbolsAndLinks22);
                                    detailOracleTextLabel.setMovementMethod(LinkMovementMethod.getInstance());
                                    detailOracleTextLabelOriginal.setMovementMethod(LinkMovementMethod.getInstance());
                                }
                            }
                        } else {
                            String str102 = printed_type_line;
                            SpannableStringBuilder spannableStringBuilder42 = new SpannableStringBuilder(str102);
                            String str112 = printed_type_line;
                            preferencesManager = preferencesManager2;
                            spannableStringBuilder42.setSpan(new AbsoluteSizeSpan(18, true), 0, str112.length(), 33);
                            spannableStringBuilder42.setSpan(new ForegroundColorSpan(-16777216), 0, str112.length(), 33);
                            SpannableStringBuilder spannableStringBuilder52 = new SpannableStringBuilder("(" + ((Object) type_line) + ")");
                            int i32 = 0;
                            spannableStringBuilder52.setSpan(new AbsoluteSizeSpan(16, true), 0, spannableStringBuilder52.length(), 33);
                            spannableStringBuilder52.setSpan(new ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.middle_grey)), 0, spannableStringBuilder52.length(), 33);
                            SpannableStringBuilder spannableStringBuilder62 = new SpannableStringBuilder(str102);
                            spannableStringBuilder = spannableStringBuilder42;
                            i = 0;
                            while (i < spannableStringBuilder.length()) {
                            }
                            spannableStringBuilder62.append((CharSequence) "\n");
                            spannableStringBuilder62.append((CharSequence) ("(" + ((Object) type_line) + ")"));
                            spannableStringBuilder2 = spannableStringBuilder52;
                            while (i2 < spannableStringBuilder2.length()) {
                            }
                            detailTypeLabel.setText(spannableStringBuilder62);
                            detailOracleTextLabel = getBinding().detailOracleTextLabel;
                            Intrinsics.checkNotNullExpressionValue(detailOracleTextLabel, "detailOracleTextLabel");
                            detailOracleTextLabelOriginal = getBinding().detailOracleTextLabelOriginal;
                            Intrinsics.checkNotNullExpressionValue(detailOracleTextLabelOriginal, "detailOracleTextLabelOriginal");
                            final TextView detailOracleTextShowOriginal2 = getBinding().detailOracleTextShowOriginal;
                            Intrinsics.checkNotNullExpressionValue(detailOracleTextShowOriginal2, "detailOracleTextShowOriginal");
                            detailOracleTextLabelOriginal.setVisibility(8);
                            detailOracleTextShowOriginal2.setVisibility(0);
                            detailOracleTextShowOriginal2.setPaintFlags(8 | detailOracleTextShowOriginal2.getPaintFlags());
                            ViewExtensionsKt.setOnClickWithFade(detailOracleTextShowOriginal2, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda107
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ScanFragment.updateFaceInformation$lambda$0$0$14(detailOracleTextShowOriginal2, detailOracleTextLabelOriginal);
                                }
                            });
                            oracle_text = mTFace.getOracle_text();
                            if (oracle_text == null) {
                            }
                            printed_text = mTFace.getPrinted_text();
                            if (printed_text == null) {
                            }
                            cardMatch2 = this.currentCardMatch;
                            if (cardMatch2 != null) {
                            }
                            String str122 = oracle_text;
                            if (z) {
                            }
                        }
                    }
                }
            } else {
                oracleText = "";
                z = false;
                detailTitleLabel = getBinding().detailTitleLabel;
                Intrinsics.checkNotNullExpressionValue(detailTitleLabel, "detailTitleLabel");
                if ((z || !Intrinsics.areEqual(this.cardLang, "en")) && printed_name != null) {
                    String str822 = printed_name;
                    str = "mtgdbHelpersEnabled";
                    str2 = "";
                    List listListOf32 = CollectionsKt.listOf(new StyleSpan(1), new AbsoluteSizeSpan(20, true), new ForegroundColorSpan(-1));
                    List listListOf222 = CollectionsKt.listOf(new StyleSpan(0), new AbsoluteSizeSpan(17, true), new ForegroundColorSpan(-3355444));
                    SpannableStringBuilder spannableStringBuilder322 = new SpannableStringBuilder(str822);
                    it = listListOf32.iterator();
                    while (it.hasNext()) {
                        spannableStringBuilder322.setSpan(it.next(), 0, str822.length(), 33);
                        listListOf222 = listListOf222;
                        it = it;
                        oracleText = oracleText;
                    }
                    str3 = oracleText;
                    spannableStringBuilder322.append((CharSequence) "\n");
                    spannableStringBuilder322.append((CharSequence) ("(" + ((Object) name) + ")"));
                    it2 = listListOf222.iterator();
                    while (it2.hasNext()) {
                        spannableStringBuilder322.setSpan(it2.next(), str822.length() + 1, spannableStringBuilder322.length(), 33);
                    }
                    detailTitleLabel.setText(spannableStringBuilder322);
                } else {
                    str = "mtgdbHelpersEnabled";
                    str2 = "";
                    str3 = oracleText;
                    List listListOf4 = CollectionsKt.listOf(new StyleSpan(1), new AbsoluteSizeSpan(20, true), new ForegroundColorSpan(-1));
                    SpannableStringBuilder spannableStringBuilder7 = new SpannableStringBuilder(name);
                    for (Iterator it5 = listListOf4.iterator(); it5.hasNext(); it5 = it5) {
                        spannableStringBuilder7.setSpan(it5.next(), 0, name != null ? name.length() : 0, 33);
                    }
                    detailTitleLabel.setText(spannableStringBuilder7);
                }
                String mana_cost22 = mTFace.getMana_cost();
                String strReplace$default22 = StringsKt.replace$default(mana_cost22 == null ? str2 : mana_cost22, "}{", "} {", false, 4, (Object) null);
                int dimensionPixelSize22 = getResources().getDimensionPixelSize(R.dimen.mana_symbol_image_size);
                symbolToImage = this.symbolToImage;
                String str922 = "symbolToImage";
                if (symbolToImage == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("symbolToImage");
                    symbolToImage = null;
                }
                SpannableString spannableStringStringToAttributedStringWithSymbols22 = symbolToImage.stringToAttributedStringWithSymbols(strReplace$default22, dimensionPixelSize22, new CharacterStyle[0]);
                TextView detailManaCostLabel22 = getBinding().detailManaCostLabel;
                Intrinsics.checkNotNullExpressionValue(detailManaCostLabel22, "detailManaCostLabel");
                detailManaCostLabel22.setText(spannableStringStringToAttributedStringWithSymbols22);
                detailTypeLabel = getBinding().detailTypeLabel;
                Intrinsics.checkNotNullExpressionValue(detailTypeLabel, "detailTypeLabel");
                printed_type_line = mTFace.getPrinted_type_line();
                type_line = mTFace.getType_line();
                if (type_line == null) {
                    type_line = str2;
                }
                cardMatch = this.currentCardMatch;
                if (cardMatch == null) {
                    str4 = "symbolToImage";
                } else if (Intrinsics.areEqual(cardMatch.getDetectedCardLang(), "en")) {
                    str4 = str922;
                    printed_type_line = printed_type_line;
                    Unit unit9 = Unit.INSTANCE;
                    Unit unit10 = Unit.INSTANCE;
                } else {
                    List<MTGDBHelperLocalized> list3 = this.mtgdbHelpersEnabled;
                    if (list3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                        list3 = null;
                    }
                    for (MTGDBHelperLocalized mTGDBHelperLocalized : list3) {
                        String str13 = printed_type_line;
                        str4 = str922;
                        if (Intrinsics.areEqual(mTGDBHelperLocalized.getLocale(), cardMatch.getDetectedCardLang())) {
                            String oracleid3 = mTFullCard.getOracleid();
                            if (oracleid3 == null) {
                                oracleid3 = str2;
                            }
                            printed_type_line = mTGDBHelperLocalized.getTypeLineForCard(oracleid3, this.currentFace);
                            Unit unit92 = Unit.INSTANCE;
                            Unit unit102 = Unit.INSTANCE;
                        } else {
                            printed_type_line = str13;
                            str922 = str4;
                        }
                    }
                    str4 = str922;
                    printed_type_line = printed_type_line;
                    Unit unit922 = Unit.INSTANCE;
                    Unit unit1022 = Unit.INSTANCE;
                }
                if ((z || !Intrinsics.areEqual(this.cardLang, "en")) && printed_type_line != null) {
                    String str1022 = printed_type_line;
                    SpannableStringBuilder spannableStringBuilder422 = new SpannableStringBuilder(str1022);
                    String str1122 = printed_type_line;
                    preferencesManager = preferencesManager2;
                    spannableStringBuilder422.setSpan(new AbsoluteSizeSpan(18, true), 0, str1122.length(), 33);
                    spannableStringBuilder422.setSpan(new ForegroundColorSpan(-16777216), 0, str1122.length(), 33);
                    SpannableStringBuilder spannableStringBuilder522 = new SpannableStringBuilder("(" + ((Object) type_line) + ")");
                    int i322 = 0;
                    spannableStringBuilder522.setSpan(new AbsoluteSizeSpan(16, true), 0, spannableStringBuilder522.length(), 33);
                    spannableStringBuilder522.setSpan(new ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.middle_grey)), 0, spannableStringBuilder522.length(), 33);
                    SpannableStringBuilder spannableStringBuilder622 = new SpannableStringBuilder(str1022);
                    spannableStringBuilder = spannableStringBuilder422;
                    i = 0;
                    while (i < spannableStringBuilder.length()) {
                        spannableStringBuilder622.setSpan(Character.valueOf(spannableStringBuilder.charAt(i)), i322, str1122.length(), 33);
                        i++;
                        spannableStringBuilder522 = spannableStringBuilder522;
                        spannableStringBuilder = spannableStringBuilder;
                        i322 = 0;
                    }
                    spannableStringBuilder622.append((CharSequence) "\n");
                    spannableStringBuilder622.append((CharSequence) ("(" + ((Object) type_line) + ")"));
                    spannableStringBuilder2 = spannableStringBuilder522;
                    for (i2 = 0; i2 < spannableStringBuilder2.length(); i2++) {
                        spannableStringBuilder622.setSpan(Character.valueOf(spannableStringBuilder2.charAt(i2)), str1122.length() + 1, spannableStringBuilder622.length(), 33);
                    }
                    detailTypeLabel.setText(spannableStringBuilder622);
                } else {
                    preferencesManager = preferencesManager2;
                    String str14 = type_line;
                    SpannableStringBuilder spannableStringBuilder8 = new SpannableStringBuilder(str14);
                    int i4 = 0;
                    spannableStringBuilder8.setSpan(new AbsoluteSizeSpan(18, true), 0, type_line.length(), 33);
                    spannableStringBuilder8.setSpan(new ForegroundColorSpan(-16777216), 0, type_line.length(), 33);
                    SpannableStringBuilder spannableStringBuilder9 = new SpannableStringBuilder(str14);
                    SpannableStringBuilder spannableStringBuilder10 = spannableStringBuilder8;
                    int i5 = 0;
                    while (i5 < spannableStringBuilder10.length()) {
                        spannableStringBuilder9.setSpan(Character.valueOf(spannableStringBuilder10.charAt(i5)), i4, type_line.length(), 33);
                        i5++;
                        i4 = 0;
                    }
                    detailTypeLabel.setText(spannableStringBuilder9);
                }
                detailOracleTextLabel = getBinding().detailOracleTextLabel;
                Intrinsics.checkNotNullExpressionValue(detailOracleTextLabel, "detailOracleTextLabel");
                detailOracleTextLabelOriginal = getBinding().detailOracleTextLabelOriginal;
                Intrinsics.checkNotNullExpressionValue(detailOracleTextLabelOriginal, "detailOracleTextLabelOriginal");
                final TextView detailOracleTextShowOriginal22 = getBinding().detailOracleTextShowOriginal;
                Intrinsics.checkNotNullExpressionValue(detailOracleTextShowOriginal22, "detailOracleTextShowOriginal");
                detailOracleTextLabelOriginal.setVisibility(8);
                detailOracleTextShowOriginal22.setVisibility(0);
                detailOracleTextShowOriginal22.setPaintFlags(8 | detailOracleTextShowOriginal22.getPaintFlags());
                ViewExtensionsKt.setOnClickWithFade(detailOracleTextShowOriginal22, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda107
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ScanFragment.updateFaceInformation$lambda$0$0$14(detailOracleTextShowOriginal22, detailOracleTextLabelOriginal);
                    }
                });
                oracle_text = mTFace.getOracle_text();
                if (oracle_text == null) {
                    oracle_text = str2;
                }
                printed_text = mTFace.getPrinted_text();
                if (printed_text == null) {
                    printed_text = str2;
                }
                cardMatch2 = this.currentCardMatch;
                if (cardMatch2 != null) {
                    if (!Intrinsics.areEqual(cardMatch2.getDetectedCardLang(), "en")) {
                        List<MTGDBHelperLocalized> list4 = this.mtgdbHelpersEnabled;
                        if (list4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(str);
                            list4 = null;
                        }
                        Iterator<MTGDBHelperLocalized> it6 = list4.iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                break;
                            }
                            MTGDBHelperLocalized next3 = it6.next();
                            if (Intrinsics.areEqual(next3.getLocale(), cardMatch2.getDetectedCardLang())) {
                                String oracleid4 = mTFullCard.getOracleid();
                                if (oracleid4 == null) {
                                    oracleid4 = str2;
                                }
                                printed_text = next3.getOracleForCard(oracleid4, this.currentFace);
                            }
                        }
                    }
                    if (Intrinsics.areEqual(mTFullCard.getLang(), "en") && (Intrinsics.areEqual(cardMatch2.getDetectedCardLang(), "en") || cardMatch2.getDetectedCardLang().length() == 0)) {
                        MTGDBHelper mTGDBHelper2 = this.mtgdbHelper;
                        if (mTGDBHelper2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelper");
                            mTGDBHelper2 = null;
                        }
                        String oracleid5 = mTFullCard.getOracleid();
                        if (oracleid5 == null) {
                            oracleid5 = str2;
                        }
                        String oracleForCard = mTGDBHelper2.getOracleForCard(oracleid5, this.currentFace);
                        if (oracleForCard.length() > 0) {
                            oracle_text = oracleForCard;
                        }
                    }
                    if (Intrinsics.areEqual(mTFullCard.getLang(), "fr")) {
                        List<MTGDBHelperLocalized> list5 = this.mtgdbHelpersEnabled;
                        if (list5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(str);
                            list5 = null;
                        }
                        Iterator<MTGDBHelperLocalized> it7 = list5.iterator();
                        while (true) {
                            if (!it7.hasNext()) {
                                break;
                            }
                            MTGDBHelperLocalized next4 = it7.next();
                            if (Intrinsics.areEqual(next4.getLocale(), "fr")) {
                                String oracleid6 = mTFullCard.getOracleid();
                                printed_text = next4.getOracleForCard(oracleid6 == null ? str2 : oracleid6, this.currentFace);
                            }
                        }
                    }
                    Unit unit11 = Unit.INSTANCE;
                    Unit unit12 = Unit.INSTANCE;
                }
                String str1222 = oracle_text;
                String str15 = (!z || str3.length() <= 0) ? printed_text : str3;
                String strReplace$default32 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str1222, "\n", "\n\n", false, 4, (Object) null), "}:", "} :", false, 4, (Object) null), "}{", "} {", false, 4, (Object) null);
                String strReplace$default42 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str15, "\n", "\n\n", false, 4, (Object) null), "}:", "} :", false, 4, (Object) null), "}{", "} {", false, 4, (Object) null);
                symbolToImage2 = this.symbolToImage;
                if (symbolToImage2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str4);
                    symbolToImage2 = null;
                }
                strRemoveDuplicateParentheses = symbolToImage2.removeDuplicateParentheses(strReplace$default32);
                symbolToImage3 = this.symbolToImage;
                if (symbolToImage3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str4);
                    symbolToImage3 = null;
                }
                strRemoveDuplicateParentheses2 = symbolToImage3.removeDuplicateParentheses(strReplace$default42);
                if ((z || !Intrinsics.areEqual(this.cardLang, "en")) && strRemoveDuplicateParentheses2.length() > 0) {
                    final Ref.ObjectRef objectRef222 = new Ref.ObjectRef();
                    objectRef222.element = objectRef.element;
                    if (z) {
                        objectRef222.element = preferencesManager.getDeviceLanguage();
                    }
                    int dimensionPixelSize322 = getResources().getDimensionPixelSize(R.dimen.symbol_oracle_size);
                    symbolToImage4 = this.symbolToImage;
                    if (symbolToImage4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str4);
                        symbolToImage4 = null;
                    }
                    Context contextRequireContext322 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext322, "requireContext(...)");
                    SpannableString spannableStringStringToAttributedStringWithSymbolsAndLinks32 = symbolToImage4.stringToAttributedStringWithSymbolsAndLinks(strRemoveDuplicateParentheses2, dimensionPixelSize322, contextRequireContext322, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda108
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ScanFragment.updateFaceInformation$lambda$0$0$16(this.f$0, objectRef222, (String) obj);
                        }
                    }, new ForegroundColorSpan(-1));
                    symbolToImage5 = this.symbolToImage;
                    if (symbolToImage5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str4);
                        symbolToImage6 = null;
                    } else {
                        symbolToImage6 = symbolToImage5;
                    }
                    Context contextRequireContext422 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext422, "requireContext(...)");
                    SpannableString spannableStringStringToAttributedStringWithSymbolsAndLinks222 = symbolToImage6.stringToAttributedStringWithSymbolsAndLinks(strRemoveDuplicateParentheses, dimensionPixelSize322, contextRequireContext422, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda110
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ScanFragment.updateFaceInformation$lambda$0$0$17(this.f$0, objectRef222, (String) obj);
                        }
                    }, new CharacterStyle[0]);
                    detailOracleTextLabel.setText(spannableStringStringToAttributedStringWithSymbolsAndLinks32);
                    detailOracleTextLabelOriginal.setText(spannableStringStringToAttributedStringWithSymbolsAndLinks222);
                    detailOracleTextLabel.setMovementMethod(LinkMovementMethod.getInstance());
                    detailOracleTextLabelOriginal.setMovementMethod(LinkMovementMethod.getInstance());
                } else {
                    int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.symbol_oracle_size);
                    SymbolToImage symbolToImage8 = this.symbolToImage;
                    if (symbolToImage8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str4);
                        symbolToImage7 = null;
                    } else {
                        symbolToImage7 = symbolToImage8;
                    }
                    Context contextRequireContext5 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
                    detailOracleTextLabel.setText(symbolToImage7.stringToAttributedStringWithSymbolsAndLinks(strRemoveDuplicateParentheses, dimensionPixelSize4, contextRequireContext5, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda111
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ScanFragment.updateFaceInformation$lambda$0$0$18(this.f$0, objectRef, (String) obj);
                        }
                    }, new ForegroundColorSpan(-3355444)));
                    detailOracleTextShowOriginal22.setVisibility(4);
                    detailOracleTextLabel.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
        }
        Unit unit13 = Unit.INSTANCE;
        Unit unit14 = Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateFaceInformation$lambda$0$0$14(TextView textView, TextView textView2) {
        textView.setVisibility(8);
        textView2.setVisibility(0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit updateFaceInformation$lambda$0$0$16(ScanFragment scanFragment, Ref.ObjectRef objectRef, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        scanFragment.handleKeywordTap(it, (String) objectRef.element);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit updateFaceInformation$lambda$0$0$17(ScanFragment scanFragment, Ref.ObjectRef objectRef, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        scanFragment.handleKeywordTap(it, (String) objectRef.element);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit updateFaceInformation$lambda$0$0$18(ScanFragment scanFragment, Ref.ObjectRef objectRef, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        scanFragment.handleKeywordTap(it, (String) objectRef.element);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateFaceInformation$lambda$0$0$3(RecyclerView recyclerView, CardLanguageAdapter cardLanguageAdapter) {
        recyclerView.setAdapter(cardLanguageAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateNextPrevious() {
        ConstraintLayout cardPreviousContainer = getBinding().cardPreviousContainer;
        Intrinsics.checkNotNullExpressionValue(cardPreviousContainer, "cardPreviousContainer");
        ConstraintLayout cardNextContainer = getBinding().cardNextContainer;
        Intrinsics.checkNotNullExpressionValue(cardNextContainer, "cardNextContainer");
        if (this.currentMTCardList.isEmpty()) {
            cardPreviousContainer.setVisibility(4);
            cardNextContainer.setVisibility(4);
            return;
        }
        if (this.currentCardListIndex > 0) {
            cardPreviousContainer.setVisibility(0);
        } else {
            cardPreviousContainer.setVisibility(4);
        }
        if (this.currentCardListIndex < this.currentMTCardList.size() - 1) {
            cardNextContainer.setVisibility(0);
        } else {
            cardNextContainer.setVisibility(4);
        }
    }

    private final void updatePricesRecyclerView(RecyclerView pricesRecyclerView, ConstraintLayout overlay) {
        MTFullCard mTFullCard;
        Double nonfoil;
        Double foil;
        Double etched;
        if (getActivity() == null || this._binding == null || isDetached() || (mTFullCard = this.currentMTCard) == null || getActivity() == null || getContext() == null) {
            return;
        }
        overlay.setVisibility(8);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String preferredCurrency = new PreferencesManager(contextRequireContext).getPreferredCurrency();
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        ArrayList arrayList = new ArrayList();
        MTCardMarketplaceValues values = mTFullCard.getValues();
        if (values != null) {
            for (ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo : CollectionsKt.listOf((Object[]) new ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo[]{new ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo(values.getMythictools(), R.drawable.marketplace_mythictools, R.string.marketplace_mythictools), new ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo(values.getTcgplayer(), R.drawable.marketplace_tcgplayer, R.string.provider_tcgplayer), new ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo(values.getCardmarket(), R.drawable.marketplace_cardmarket, R.string.provider_cardmarket), new ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo(values.getCardkingdom(), R.drawable.marketplace_cardkingdom, R.string.provider_cardkingdom), new ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo(values.getCardsphere(), R.drawable.marketplace_cardsphere, R.string.provider_cardsphere)})) {
                MTMarketplaceFinishPrices prices = scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo.getPrices();
                if ((prices != null ? prices.getEtched() : null) == null) {
                    MTMarketplaceFinishPrices prices2 = scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo.getPrices();
                    if ((prices2 != null ? prices2.getFoil() : null) == null) {
                        MTMarketplaceFinishPrices prices3 = scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo.getPrices();
                        if ((prices3 != null ? prices3.getNonfoil() : null) != null) {
                        }
                    }
                }
                int iconRes = scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo.getIconRes();
                String string = getString(scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo.getNameResId());
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                arrayList.add(new MTCardPriceRow.MarketplaceHeader(iconRes, string));
                MTMarketplaceFinishPrices prices4 = scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo.getPrices();
                if (prices4 != null && (etched = prices4.getEtched()) != null) {
                    String price = companion.formatPrice(etched.doubleValue(), preferredCurrency);
                    String string2 = getString(R.string.etched);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    arrayList.add(new MTCardPriceRow.PriceRow(true, string2, price, false, 8, null));
                }
                MTMarketplaceFinishPrices prices5 = scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo.getPrices();
                if (prices5 != null && (foil = prices5.getFoil()) != null) {
                    String price2 = companion.formatPrice(foil.doubleValue(), preferredCurrency);
                    String string3 = getString(R.string.foil);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    arrayList.add(new MTCardPriceRow.PriceRow(true, string3, price2, false, 8, null));
                }
                MTMarketplaceFinishPrices prices6 = scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo.getPrices();
                if (prices6 != null && (nonfoil = prices6.getNonfoil()) != null) {
                    String price3 = companion.formatPrice(nonfoil.doubleValue(), preferredCurrency);
                    String string4 = getString(R.string.non_foil);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    arrayList.add(new MTCardPriceRow.PriceRow(false, string4, price3, false, 8, null));
                }
            }
        }
        MTCardPriceAdapter mTCardPriceAdapter = new MTCardPriceAdapter(arrayList);
        pricesRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        pricesRecyclerView.setAdapter(mTCardPriceAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePricesUI() {
        if (getActivity() == null || getContext() == null || this._binding == null || isDetached()) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTFullCard mTFullCard = this.currentMTCard;
        if (mTFullCard != null) {
            Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_update_prices_ui_mt");
            String preferredCurrency = preferencesManager.getPreferredCurrency();
            getBinding().priceButton.setText(GameUtils.INSTANCE.getInstance().formatPrice(GameUtils.INSTANCE.getInstance().getCardPrice(mTFullCard, preferencesManager.getPreferredMarket()), preferredCurrency));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    private final void updateScanSettingsOverrideIndicator() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUserSettings mTUserSettings = new PreferencesManager(contextRequireContext).getMTUserSettings();
        ?? AreEqual = Intrinsics.areEqual((Object) mTUserSettings.getScan_override_language_enabled(), (Object) true);
        int i = AreEqual;
        if (Intrinsics.areEqual((Object) mTUserSettings.getScan_override_set_enabled(), (Object) true)) {
            i = AreEqual + 1;
        }
        int i2 = i;
        if (Intrinsics.areEqual((Object) mTUserSettings.getScan_override_finish_enabled(), (Object) true)) {
            i2 = i + 1;
        }
        int i3 = i2;
        if (Intrinsics.areEqual((Object) mTUserSettings.getScan_purchase_price_enabled(), (Object) true)) {
            i3 = i2 + 1;
        }
        if (i3 <= 0) {
            getBinding().scanSettingsOverridesLayout.setVisibility(8);
        } else {
            getBinding().scanSettingsOverridesLayout.setVisibility(0);
            getBinding().scanSettingsOverrideCountTextView.setText(String.valueOf(i3));
        }
    }

    private final Character zoneToIconChar(String zone) {
        int iHashCode = zone.hashCode();
        return iHashCode != 66 ? iHashCode != 71 ? (iHashCode == 72 && zone.equals("H")) ? (char) 62038 : null : !zone.equals(GameUtils.CONDITION_GOOD) ? null : (char) 63060 : !zone.equals("B") ? null : (char) 62445;
    }

    private final Integer zoneToLabelRes(String zone) {
        int iHashCode = zone.hashCode();
        if (iHashCode == 66) {
            if (zone.equals("B")) {
                return Integer.valueOf(R.string.card_on_the_battlefield);
            }
            return null;
        }
        if (iHashCode == 71) {
            if (zone.equals(GameUtils.CONDITION_GOOD)) {
                return Integer.valueOf(R.string.card_in_graveyard);
            }
            return null;
        }
        if (iHashCode == 72 && zone.equals("H")) {
            return Integer.valueOf(R.string.card_in_hand);
        }
        return null;
    }

    public final void adjustTextViewHeight(TextView textView, int numLines) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        textView.measure(View.MeasureSpec.makeMeasureSpec(textView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        textView.getLayoutParams().height = ((textView.getLayout().getLineBottom(0) - textView.getLayout().getLineTop(0)) * numLines) + textView.getPaddingTop() + textView.getPaddingBottom();
        textView.requestLayout();
    }

    public final int dpToPx(int dp, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    /* JADX INFO: renamed from: isDeviceStable, reason: from getter */
    public final boolean getIsDeviceStable() {
        return this.isDeviceStable;
    }

    public final void loadCardImage(String url, LoadingImageView imageView, final Function0<Unit> onImageReady) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (getActivity() == null || getContext() == null) {
            Log.d(TAG, "loadCardImage - bailing");
            return;
        }
        Log.d(TAG, "------>>> loadCardImageWithCallback : url = " + url + " - onImageReady = " + (onImageReady != null));
        Breadcrumbs.INSTANCE.leaveBreadcrumb("load_card_image");
        if (url.length() != 0 && !this.offline) {
            imageView.setAutoLoad(false);
            imageView.loadImageWithCallback(url, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda129
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.loadCardImage$lambda$0(this.f$0, onImageReady);
                }
            }, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda130
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.loadCardImage$lambda$1(onImageReady);
                }
            });
        } else {
            imageView.setImageResource(R.drawable.card_back);
            if (onImageReady != null) {
                onImageReady.invoke();
            }
        }
    }

    public final void loadCardImageWithCallback(String url, LoadingImageView imageView, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getActivity() == null || getContext() == null) {
            Log.d(TAG, "loadCardImageWithCallback - bailing");
            return;
        }
        if (this.offline) {
            imageView.setImageResource(R.drawable.card_back);
            callback.invoke();
        } else {
            Breadcrumbs.INSTANCE.leaveBreadcrumb("load_card_image_with_callback");
            imageView.reset();
            imageView.setAutoLoad(false);
            imageView.loadImageWithCallback(url, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda132
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.loadCardImageWithCallback$lambda$0(this.f$0, callback);
                }
            }, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda133
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.loadCardImageWithCallback$lambda$1(callback);
                }
            });
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    @Override // com.studiolaganne.lengendarylens.CardLanguageClickListener
    public void onCardLanguageClick(String newScId, String oracleId, String title, String language, String typeLine, String oracle) {
        Intrinsics.checkNotNullParameter(newScId, "newScId");
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(typeLine, "typeLine");
        Intrinsics.checkNotNullParameter(oracle, "oracle");
        if (getActivity() == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_card_language_click");
        requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda161
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.onCardLanguageClick$lambda$0(this.f$0);
            }
        });
        MTFullCard mTFullCard = this.currentMTCard;
        PopupWindow popupWindow = null;
        if (mTFullCard != null) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            MTApi mtApi = MTApiKt.getMtApi();
            String set_code = mTFullCard.getSet_code();
            if (set_code == null) {
                set_code = "";
            }
            String collector_number = mTFullCard.getCollector_number();
            String str = collector_number != null ? collector_number : "";
            MTUser currentUser = preferencesManager.getCurrentUser();
            mtApi.getCardWithParameters(language, set_code, str, currentUser != null ? Integer.valueOf(currentUser.getId()) : null).enqueue(new Callback<MTFullCardResponse>() { // from class: com.studiolaganne.lengendarylens.ScanFragment$onCardLanguageClick$2$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTFullCardResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.getActivity() == null || this.this$0.getContext() == null) {
                        return;
                    }
                    this.this$0.showInternetError();
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTFullCardResponse> call, Response<MTFullCardResponse> response) {
                    MTFullCard card;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getActivity() == null || this.this$0.getContext() == null) {
                        return;
                    }
                    MTFullCardResponse mTFullCardResponseBody = response.body();
                    if (mTFullCardResponseBody == null || (card = mTFullCardResponseBody.getCard()) == null) {
                        this.this$0.showInternetError();
                        return;
                    }
                    ScanFragment scanFragment = this.this$0;
                    scanFragment.translateCardIfPossible = false;
                    ScanFragment.displayMTCard$default(scanFragment, card, false, false, 6, null);
                }
            });
            PopupWindow popupWindow2 = this.popupWindow;
            if (popupWindow2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("popupWindow");
            } else {
                popupWindow = popupWindow2;
            }
            popupWindow.dismiss();
            return;
        }
        CardMatch cardMatch = new CardMatch(null, null, 0, 0L, null, null, null, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, false, null, 2097151, null);
        cardMatch.setLang(language);
        cardMatch.setFace(this.currentFace);
        cardMatch.setScryfallId(newScId);
        cardMatch.setOracleId(oracleId);
        cardMatch.setDetectedCardLang(language);
        if (!Intrinsics.areEqual(language, "en")) {
            cardMatch.setLocalizedTitle(title);
            cardMatch.setLocalizedTypeLine(typeLine);
            cardMatch.setLocalizedOracle(oracle);
        }
        this.currentCardMatch = cardMatch;
        this.translateCardIfPossible = false;
        fetchCard(cardMatch, false);
        PopupWindow popupWindow3 = this.popupWindow;
        if (popupWindow3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupWindow");
        } else {
            popupWindow = popupWindow3;
        }
        popupWindow.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String string;
        String string2;
        PreferencesManager preferencesManager;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        MTCombo mTCombo;
        String str;
        int iIntValue;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager2 = new PreferencesManager(contextRequireContext);
        super.onCreate(savedInstanceState);
        this.highPriceSoundId = getHighPriceSoundPool().load(requireContext(), R.raw.kaching, 1);
        this.noScanMode = false;
        Bundle arguments = getArguments();
        Boolean boolValueOf = arguments != null ? Boolean.valueOf(arguments.getBoolean("noScanMode")) : null;
        Bundle arguments2 = getArguments();
        String string3 = arguments2 != null ? arguments2.getString("singleMTCard") : null;
        Bundle arguments3 = getArguments();
        Boolean boolValueOf2 = arguments3 != null ? Boolean.valueOf(arguments3.getBoolean("hasMTCards")) : null;
        Bundle arguments4 = getArguments();
        Integer numValueOf = arguments4 != null ? Integer.valueOf(arguments4.getInt("currentMTIndex")) : null;
        Bundle arguments5 = getArguments();
        Integer numValueOf2 = arguments5 != null ? Integer.valueOf(arguments5.getInt("mtCardListId")) : null;
        Bundle arguments6 = getArguments();
        Integer numValueOf3 = arguments6 != null ? Integer.valueOf(arguments6.getInt("mtDeckListId")) : null;
        Bundle arguments7 = getArguments();
        boolean z = arguments7 != null ? arguments7.getBoolean("readOnly") : false;
        Bundle arguments8 = getArguments();
        if (arguments8 == null || (string = arguments8.getString("currentOrderBy")) == null) {
            string = "name";
        }
        this.currentOrderBy = string;
        Bundle arguments9 = getArguments();
        if (arguments9 == null || (string2 = arguments9.getString("currentOrderDirection")) == null) {
            string2 = "asc";
        }
        this.currentOrderDirection = string2;
        Bundle arguments10 = getArguments();
        this.currentGroupBy = arguments10 != null ? arguments10.getString("currentGroupBy") : null;
        Bundle arguments11 = getArguments();
        this.currentNameFilter = arguments11 != null ? arguments11.getString("currentNameFilter") : null;
        Bundle arguments12 = getArguments();
        this.currentScryfallFilter = arguments12 != null ? arguments12.getString("currentScryfallFilter") : null;
        Bundle arguments13 = getArguments();
        this.currentPage = arguments13 != null ? arguments13.getInt("currentPage") : 1;
        Bundle arguments14 = getArguments();
        this.cardsPerPage = arguments14 != null ? arguments14.getInt("cardsPerPage") : 100;
        Bundle arguments15 = getArguments();
        this.totalCards = arguments15 != null ? arguments15.getInt("totalCards") : 0;
        Bundle arguments16 = getArguments();
        String string4 = arguments16 != null ? arguments16.getString("scryfallId") : null;
        Bundle arguments17 = getArguments();
        String string5 = arguments17 != null ? arguments17.getString("oracleId") : null;
        Bundle arguments18 = getArguments();
        String string6 = arguments18 != null ? arguments18.getString("enScryfallId") : null;
        this.shouldStartCamera = false;
        Bundle arguments19 = getArguments();
        if (arguments19 != null && arguments19.getBoolean(SHOULD_START_CAMERA)) {
            this.shouldStartCamera = true;
        }
        if (boolValueOf != null) {
            this.noScanMode = boolValueOf.booleanValue();
        }
        if (string3 != null) {
            this.mtCardJson = string3;
        }
        if (numValueOf2 != null) {
            this.currentListId = numValueOf2.intValue();
        }
        if (numValueOf3 != null) {
            this.currentDeckListId = numValueOf3.intValue();
        }
        Bundle arguments20 = getArguments();
        String string7 = arguments20 != null ? arguments20.getString("mtDeck") : null;
        if (string7 != null) {
            try {
                this.currentDeck = (MTDeck) new Gson().fromJson(string7, MTDeck.class);
                Unit unit = Unit.INSTANCE;
            } catch (Exception e) {
                Integer.valueOf(Log.e(TAG, "Error parsing MTDeck: " + e.getMessage()));
            }
        }
        Bundle arguments21 = getArguments();
        int i6 = arguments21 != null ? arguments21.getInt("mtDeckMainListId", -1) : -1;
        Bundle arguments22 = getArguments();
        int i7 = arguments22 != null ? arguments22.getInt("mtDeckMainListCount", 0) : 0;
        Bundle arguments23 = getArguments();
        int i8 = arguments23 != null ? arguments23.getInt("mtDeckSideboardListId", -1) : -1;
        Bundle arguments24 = getArguments();
        int i9 = arguments24 != null ? arguments24.getInt("mtDeckSideboardListCount", 0) : 0;
        Bundle arguments25 = getArguments();
        if (arguments25 != null) {
            preferencesManager = preferencesManager2;
            i = -1;
            i2 = arguments25.getInt("mtDeckMaybeboardListId", -1);
        } else {
            preferencesManager = preferencesManager2;
            i = -1;
            i2 = -1;
        }
        Bundle arguments26 = getArguments();
        if (arguments26 != null) {
            i3 = i9;
            i5 = arguments26.getInt("mtDeckMaybeboardListCount", 0);
            i4 = -1;
        } else {
            i3 = i9;
            i4 = i;
            i5 = 0;
        }
        if (i6 != i4 || i8 != i4 || i2 != i4) {
            MTDeckLists mTDeckLists = new MTDeckLists(null, null, null, 7, null);
            int i10 = -1;
            if (i6 != -1) {
                mTDeckLists.setMain(new MTCardContainer(null, Integer.valueOf(i7), null, i6, null, null, null, null, null, null, null, null, null, null, null, null, 65525, null));
                i10 = -1;
            }
            if (i8 != i10) {
                mTDeckLists.setSideboard(new MTCardContainer(null, Integer.valueOf(i3), null, i8, null, null, null, null, null, null, null, null, null, null, null, null, 65525, null));
                i10 = -1;
            }
            if (i2 != i10) {
                mTDeckLists.setMaybeboard(new MTCardContainer(null, Integer.valueOf(i5), null, i2, null, null, null, null, null, null, null, null, null, null, null, null, 65525, null));
            }
            this.currentDeckLists = mTDeckLists;
        }
        this.readOnly = z;
        if (boolValueOf2 != null) {
            this.hasMTCards = boolValueOf2.booleanValue();
        } else {
            this.hasMTCards = false;
        }
        if (numValueOf != null && (iIntValue = numValueOf.intValue()) != -1) {
            this.currentCardListIndex = iIntValue;
        }
        if (string4 != null) {
            this.scryfallIdToLoad = string4;
        }
        if (string6 != null) {
            this.enScryfallId = string6;
        }
        if (string5 != null) {
            this.oracleIdToLoad = string5;
        }
        Bundle arguments27 = getArguments();
        boolean z2 = arguments27 != null ? arguments27.getBoolean("comboMode") : false;
        Bundle arguments28 = getArguments();
        String string8 = arguments28 != null ? arguments28.getString("comboData") : null;
        this.comboMode = z2;
        if (!z2 || (str = string8) == null || StringsKt.isBlank(str)) {
            mTCombo = null;
        } else {
            try {
                mTCombo = (MTCombo) new Gson().fromJson(string8, MTCombo.class);
            } catch (Exception e2) {
                Log.e(TAG, "Error parsing comboData: " + e2.getMessage());
                mTCombo = null;
            }
        }
        this.comboForViewing = mTCombo;
        NetworkHelper networkHelper = NetworkHelper.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(requireContext(), "requireContext(...)");
        this.offline = !networkHelper.isNetworkAvailable(r2);
        MTGDBHelper.Companion companion = MTGDBHelper.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        this.mtgdbHelper = companion.getInstance(contextRequireContext2);
        this.mtgdbHelpers = new ArrayList();
        this.mtgdbHelpersEnabled = new ArrayList();
        for (String str2 : preferencesManager.getSupportedLanguages()) {
            if (!Intrinsics.areEqual(str2, "en")) {
                MTGDBHelperLocalized.Companion companion2 = MTGDBHelperLocalized.INSTANCE;
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                MTGDBHelperLocalized companion3 = companion2.getInstance(contextRequireContext3, str2);
                List<MTGDBHelperLocalized> list = this.mtgdbHelpers;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelpers");
                    list = null;
                }
                list.add(companion3);
            }
        }
        for (String str3 : preferencesManager.getEnabledLanguages()) {
            if (!Intrinsics.areEqual(str3, "en")) {
                MTGDBHelperLocalized.Companion companion4 = MTGDBHelperLocalized.INSTANCE;
                Context contextRequireContext4 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                MTGDBHelperLocalized companion5 = companion4.getInstance(contextRequireContext4, str3);
                List<MTGDBHelperLocalized> list2 = this.mtgdbHelpersEnabled;
                if (list2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelpersEnabled");
                    list2 = null;
                }
                list2.add(companion5);
            }
        }
        this.cardSets = CardSetsManager.INSTANCE.getCardSets();
        Bundle arguments29 = getArguments();
        if (arguments29 != null) {
            this.pickACardMode = arguments29.getBoolean(PICK_A_CARD_MODE, false);
            this.scanToDeckMode = arguments29.getBoolean(SCAN_TO_DECK_MODE, false);
            String string9 = arguments29.getString(SCAN_TO_DECK_NAME, "Deck");
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            this.scanToDeckName = string9;
            this.scanToListMode = arguments29.getBoolean(SCAN_TO_LIST_MODE, false);
            this.scanToListId = arguments29.getInt(SCAN_TO_LIST_ID, -1);
            String string10 = arguments29.getString(SCAN_TO_LIST_NAME, "List");
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            this.scanToListName = string10;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentScanBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CombinedAnalyzer combinedAnalyzer = this.combinedAnalyzer;
        if (combinedAnalyzer != null) {
            combinedAnalyzer.cleanup();
        }
        try {
            if (this.highPriceSoundId != 0) {
                getHighPriceSoundPool().release();
            }
        } catch (Exception e) {
            Log.e(TAG, "Error releasing high price sound pool: " + e.getMessage());
        }
        this.handlerThread.quitSafely();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        stopCameraCapture();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        this.visible = !hidden;
        if (getContext() == null || isDetached() || this.noScanMode) {
            return;
        }
        if (hidden) {
            stopCameraCapture();
        } else {
            startCameraCapture();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.getWindow().clearFlags(128);
        }
        stopCameraCapture();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        FragmentActivity activity;
        super.onResume();
        if (this._binding != null) {
            updateScanSettingsOverrideIndicator();
        }
        if (!this.noScanMode && (activity = getActivity()) != null) {
            activity.getWindow().addFlags(128);
        }
        if ((this.observing || this.editDialogShowing || this.currentScanList.isEmpty()) && this.visible && !this.noScanMode) {
            startCameraCapture();
        }
    }

    @Override // com.studiolaganne.lengendarylens.OnScannedCardClickListener
    public void onScannedCardClick(MTFullCard card, int index) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (getActivity() == null || this._binding == null) {
            return;
        }
        this.hasMTCards = false;
        this.currentMTCardList = CollectionsKt.emptyList();
        getBinding().scanListTopLayout.setVisibility(8);
        getBinding().scanListBottomLayout.setVisibility(8);
        this.observing = false;
        CombinedAnalyzer combinedAnalyzer = this.combinedAnalyzer;
        if (combinedAnalyzer != null) {
            combinedAnalyzer.setPaused(true);
        }
        if (this.scanTutorialActive) {
            getBinding().scanTutorialOverlay.setVisibility(8);
            getBinding().scanTutorialContainer.setVisibility(8);
            this.scanTutorialActive = false;
        }
        this.currentMTCard = card;
        this.currentScanListIndex = index;
        displayMTCard$default(this, card, false, false, 4, null);
        fetchRulings();
        applySplitCardRotationIfNeeded();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004d  */
    @Override // com.studiolaganne.lengendarylens.OnScannedCardClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScannedCardCollectionTapped(MTFullCard card, int index) {
        boolean z;
        Intrinsics.checkNotNullParameter(card, "card");
        if (getContext() == null || this._binding == null) {
            return;
        }
        MTCardCollectionStatus collection = card.getCollection();
        MTCardCollectionMatches matches = collection != null ? collection.getMatches() : null;
        boolean z2 = true;
        if (matches != null ? Intrinsics.areEqual((Object) matches.getHas_exact(), (Object) true) : false) {
            z = true;
        } else {
            List<MTCollectionCardMatch> exact = matches != null ? matches.getExact() : null;
            if (exact == null || exact.isEmpty()) {
                z = false;
            }
        }
        List<MTCollectionCardMatch> all = matches != null ? matches.getAll() : null;
        if (all != null && !all.isEmpty()) {
            z2 = false;
        }
        if (!z && z2) {
            Toast.makeText(requireContext(), R.string.collection_no_match_toast, 0).show();
            return;
        }
        CollectionMatchesViewerDialogFragment.Builder card2 = new CollectionMatchesViewerDialogFragment.Builder().setCard(card);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        card2.show(childFragmentManager, "collection_matches_viewer");
    }

    @Override // com.studiolaganne.lengendarylens.OnScannedCardClickListener
    public void onScannedCardDeleteClick(MTFullCard card, int index) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (getContext() == null || this._binding == null) {
            return;
        }
        this.currentScanList.remove(index);
        if (this.scanTutorialActive) {
            this.observing = true;
            CombinedAnalyzer combinedAnalyzer = this.combinedAnalyzer;
            if (combinedAnalyzer != null) {
                combinedAnalyzer.setPaused(false);
            }
            getBinding().scanTutorialOverlay.setVisibility(8);
            getBinding().scanTutorialContainer.setVisibility(8);
            this.scanTutorialActive = false;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (this.scanToDeckMode) {
            preferencesManager.saveCurrentDeckScanList(this.currentScanList);
        } else if (this.scanToListMode) {
            preferencesManager.saveCurrentListScanList(this.scanToListId, this.currentScanList);
        } else {
            preferencesManager.saveCurrentUserScanList(this.currentScanList);
        }
        ScannedCardsAdapter scannedCardsAdapter = this.scannedCardsAdapter;
        if (scannedCardsAdapter != null) {
            scannedCardsAdapter.removeCard(index);
        }
        updateCardCountAndTotalPrice();
        if (this.currentScanList.isEmpty()) {
            getBinding().addToButton.setVisibility(8);
            getBinding().scanListBottomLayout.setVisibility(8);
        }
    }

    @Override // com.studiolaganne.lengendarylens.OnScannedCardClickListener
    public void onScannedCardEditClick(MTFullCard card, final int index) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (getActivity() == null || this._binding == null) {
            return;
        }
        if (this.scanTutorialActive) {
            getBinding().scanTutorialOverlay.setVisibility(8);
            getBinding().scanTutorialContainer.setVisibility(8);
            this.scanTutorialActive = false;
        }
        this.observing = false;
        CombinedAnalyzer combinedAnalyzer = this.combinedAnalyzer;
        if (combinedAnalyzer != null) {
            combinedAnalyzer.setPaused(true);
        }
        EditCardDialogFragment editCardDialogFragmentBuild = new EditCardDialogFragment.Builder().setCard(card).setShowPurchasePrice(this.currentDeckListId == -1).setAllPrintsLauncher(this.allPrintsActivityLauncher).setOnDismissListener(new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onScannedCardEditClick$lambda$0(this.f$0);
            }
        }).setOnEditClickedListener(new Function12() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function12
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
                return ScanFragment.onScannedCardEditClick$lambda$1(this.f$0, index, (Integer) obj, (Integer) obj2, (String) obj3, (String) obj4, (String) obj5, (MTFullCard) obj6, (Boolean) obj7, (Boolean) obj8, (Boolean) obj9, (Boolean) obj10, (Integer) obj11, (Double) obj12);
            }
        }).build();
        this.editDialogShowing = true;
        this.editDialog = editCardDialogFragmentBuild;
        editCardDialogFragmentBuild.show(getChildFragmentManager(), "edit_card_dialog");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    @Override // com.studiolaganne.lengendarylens.OnScannedCardClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScannedCardFinishToggled(MTFullCard card, final int index) {
        String lowerCase;
        ArrayList arrayListEmptyList;
        String str;
        Intrinsics.checkNotNullParameter(card, "card");
        if (getContext() == null || this._binding == null) {
            return;
        }
        String finish = card.getFinish();
        if (finish != null) {
            lowerCase = finish.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase == null) {
                lowerCase = "nonfoil";
            }
        }
        List<String> finishes = card.getFinishes();
        if (finishes != null) {
            List<String> list = finishes;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                arrayList.add(lowerCase2);
            }
            arrayListEmptyList = arrayList;
        } else {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        if (Intrinsics.areEqual(lowerCase, "foil") || Intrinsics.areEqual(lowerCase, "etched")) {
            str = "nonfoil";
        } else if (arrayListEmptyList.contains("foil")) {
            str = "foil";
        } else if (arrayListEmptyList.contains("etched")) {
            str = "etched";
        } else {
            arrayListEmptyList.isEmpty();
            str = "foil";
        }
        final MTFullCard mTFullCardCopy$default = MTFullCard.copy$default(card, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1048577, -1, 127, null);
        this.currentScanList.set(index, mTFullCardCopy$default);
        getBinding().scanListRecyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.onScannedCardFinishToggled$lambda$1(this.f$0, index, mTFullCardCopy$default);
            }
        });
        updateCardCountAndTotalPrice();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (this.scanToDeckMode) {
            preferencesManager.saveCurrentDeckScanList(this.currentScanList);
        } else if (this.scanToListMode) {
            preferencesManager.saveCurrentListScanList(this.scanToListId, this.currentScanList);
        } else {
            preferencesManager.saveCurrentUserScanList(this.currentScanList);
        }
    }

    @Override // com.studiolaganne.lengendarylens.OnScannedCardClickListener
    public void onScannedCardQuantityChanged(MTFullCard card, final int index, int newQuantity) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (getContext() == null || this._binding == null) {
            return;
        }
        final MTFullCard mTFullCardCopy$default = MTFullCard.copy$default(card, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(newQuantity), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -16385, 127, null);
        this.currentScanList.set(index, mTFullCardCopy$default);
        getBinding().scanListRecyclerView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda123
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.onScannedCardQuantityChanged$lambda$0(this.f$0, index, mTFullCardCopy$default);
            }
        });
        updateCardCountAndTotalPrice();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (this.scanToDeckMode) {
            preferencesManager.saveCurrentDeckScanList(this.currentScanList);
        } else if (this.scanToListMode) {
            preferencesManager.saveCurrentListScanList(this.scanToListId, this.currentScanList);
        } else {
            preferencesManager.saveCurrentUserScanList(this.currentScanList);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.lastUpdate;
        if (jCurrentTimeMillis - j > 100) {
            long j2 = jCurrentTimeMillis - j;
            this.lastUpdate = jCurrentTimeMillis;
            float f = event.values[0];
            float f2 = event.values[1];
            float f3 = event.values[2];
            this.isDeviceStable = (Math.abs(((((f + f2) + f3) - this.last_x) - this.last_y) - this.last_z) / ((float) j2)) * 10000.0f <= ((float) this.shakeThreshold);
            this.last_x = f;
            this.last_y = f2;
            this.last_z = f3;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.stopping = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.stopping = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        String string2;
        final MTCombo mTCombo;
        final ScanFragment scanFragment = this;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LoadingImageView cardBack = scanFragment.getBinding().cardBack;
        Intrinsics.checkNotNullExpressionValue(cardBack, "cardBack");
        cardBack.setImageResource(R.drawable.card_back);
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: com.studiolaganne.lengendarylens.ScanFragment$onViewCreated$callback$1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (this.this$0.getActivity() == null) {
                    return;
                }
                if (this.this$0.isVisible() && this.this$0.displayingCard) {
                    this.this$0.onBack();
                    return;
                }
                setEnabled(false);
                this.this$0.requireActivity().getOnBackPressedDispatcher().onBackPressed();
                setEnabled(true);
            }
        };
        OnBackPressedDispatcher onBackPressedDispatcher = scanFragment.requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = scanFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback);
        PopupWindow popupWindow = null;
        if (!scanFragment.noScanMode) {
            if (!scanFragment.pickACardMode) {
                scanFragment.getBinding().scanListTopLayout.setVisibility(0);
            }
            Object systemService = scanFragment.requireActivity().getSystemService("sensor");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
            SensorManager sensorManager = (SensorManager) systemService;
            scanFragment.sensorManager = sensorManager;
            if ((sensorManager != null ? sensorManager.getDefaultSensor(1) : null) != null) {
                SensorManager sensorManager2 = scanFragment.sensorManager;
                scanFragment.accelerometer = sensorManager2 != null ? sensorManager2.getDefaultSensor(1) : null;
            }
            scanFragment.getBinding().scanListRecyclerView.setLayoutManager(new LinearLayoutManager(scanFragment.requireContext(), 0, false));
            scanFragment.setupCameraGestures();
            scanFragment.initializeScannedCardAdapter();
            Context contextRequireContext = scanFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            BoundingBoxOverlayView boundingBoxOverlayView = scanFragment.getBinding().boundingBoxOverlayView;
            Intrinsics.checkNotNullExpressionValue(boundingBoxOverlayView, "boundingBoxOverlayView");
            PreviewView viewFinder = scanFragment.getBinding().viewFinder;
            Intrinsics.checkNotNullExpressionValue(viewFinder, "viewFinder");
            List<CardSet> list = scanFragment.cardSets;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardSets");
                list = null;
            }
            MTGDBHelper mTGDBHelper = scanFragment.mtgdbHelper;
            if (mTGDBHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelper");
                mTGDBHelper = null;
            }
            List<MTGDBHelperLocalized> list2 = scanFragment.mtgdbHelpersEnabled;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mtgdbHelpersEnabled");
                list2 = null;
            }
            CombinedAnalyzer combinedAnalyzer = new CombinedAnalyzer(contextRequireContext, scanFragment, boundingBoxOverlayView, viewFinder, list, mTGDBHelper, list2, new Function7() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda142
                @Override // kotlin.jvm.functions.Function7
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
                    return ScanFragment.onViewCreated$lambda$0(this.f$0, (String) obj, (String) obj2, (String) obj3, (String) obj4, (String) obj5, ((Integer) obj6).intValue(), (String) obj7);
                }
            }, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda74
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.onViewCreated$lambda$1(this.f$0);
                }
            });
            scanFragment = scanFragment;
            scanFragment.combinedAnalyzer = combinedAnalyzer;
            combinedAnalyzer.setContinuousMode(true);
            Unit unit = Unit.INSTANCE;
            CombinedAnalyzer combinedAnalyzer2 = scanFragment.combinedAnalyzer;
            if (combinedAnalyzer2 == null || !combinedAnalyzer2.isReady()) {
                CombinedAnalyzer combinedAnalyzer3 = scanFragment.combinedAnalyzer;
                scanFragment.showScannerUnavailableError(combinedAnalyzer3 != null ? combinedAnalyzer3.getInitializationError() : null);
            }
        }
        Context contextRequireContext2 = scanFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        scanFragment.symbolToImage = new SymbolToImage(contextRequireContext2);
        final ImageView cardCrop = scanFragment.getBinding().cardCrop;
        Intrinsics.checkNotNullExpressionValue(cardCrop, "cardCrop");
        final TextView consoleTextView = scanFragment.getBinding().consoleTextView;
        Intrinsics.checkNotNullExpressionValue(consoleTextView, "consoleTextView");
        SwitchCompat debugSwitch = scanFragment.getBinding().debugSwitch;
        Intrinsics.checkNotNullExpressionValue(debugSwitch, "debugSwitch");
        cardCrop.setVisibility(4);
        consoleTextView.setVisibility(4);
        debugSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda86
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ScanFragment.onViewCreated$lambda$2(cardCrop, consoleTextView, compoundButton, z);
            }
        });
        debugSwitch.setVisibility(4);
        scanFragment.getBinding().priceButton.setVisibility(8);
        if (scanFragment.pickACardMode) {
            scanFragment.getBinding().mainSearchButton.setVisibility(0);
        } else {
            scanFragment.getBinding().mainSearchButton.setVisibility(8);
        }
        Button mainSearchButton = scanFragment.getBinding().mainSearchButton;
        Intrinsics.checkNotNullExpressionValue(mainSearchButton, "mainSearchButton");
        ViewExtensionsKt.setOnClickWithFade(mainSearchButton, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda97
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$3(this.f$0);
            }
        });
        scanFragment.getBinding().actionItemsLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda99
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ScanFragment.onViewCreated$lambda$4(view2);
            }
        });
        scanFragment.getBinding().scanTutorialContainer.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda100
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ScanFragment.onViewCreated$lambda$5(this.f$0, view2);
            }
        });
        TextView priceButton = scanFragment.getBinding().priceButton;
        Intrinsics.checkNotNullExpressionValue(priceButton, "priceButton");
        ViewExtensionsKt.setOnClickWithFade(priceButton, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda101
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$6(this.f$0);
            }
        });
        TextView scanListExportTextView = scanFragment.getBinding().scanListExportTextView;
        Intrinsics.checkNotNullExpressionValue(scanListExportTextView, "scanListExportTextView");
        ViewExtensionsKt.setOnClickWithFade(scanListExportTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda102
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$7(this.f$0);
            }
        });
        TextView scanListDeleteTextView = scanFragment.getBinding().scanListDeleteTextView;
        Intrinsics.checkNotNullExpressionValue(scanListDeleteTextView, "scanListDeleteTextView");
        ViewExtensionsKt.setOnClickWithFade(scanListDeleteTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda103
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$8(this.f$0);
            }
        });
        scanFragment.getBinding().scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda104
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                this.f$0.getBinding().topBar.setBackgroundColor(Color.argb((int) (Math.min(1.0f, r0.getBinding().scrollView.getScrollY() / 200.0f) * 255.0f), 0, 0, 0));
            }
        });
        MaterialButton detailAllPrintsButton = scanFragment.getBinding().detailAllPrintsButton;
        Intrinsics.checkNotNullExpressionValue(detailAllPrintsButton, "detailAllPrintsButton");
        scanFragment.setFontAwesomeIconAndText(detailAllPrintsButton, "\uf06e", R.string.all_prints_label);
        ViewExtensionsKt.setOnClickWithBounce(detailAllPrintsButton, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda153
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$10(this.f$0);
            }
        });
        scanFragment.getBinding().editImage.setVisibility(8);
        scanFragment.getBinding().addToCollectionTextView.setVisibility(8);
        scanFragment.getBinding().moveTextView.setVisibility(8);
        scanFragment.getBinding().deleteTextView.setVisibility(8);
        scanFragment.getBinding().actionItemsSeparator1.setVisibility(8);
        scanFragment.getBinding().actionItemsSeparator2.setVisibility(8);
        if (!scanFragment.comboMode || (mTCombo = scanFragment.comboForViewing) == null) {
            Context contextRequireContext3 = scanFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
            if (new PreferencesManager(contextRequireContext3).getCurrentUser() != null) {
                boolean z = scanFragment.currentListId != 1;
                boolean z2 = scanFragment.currentDeckListId != -1;
                if ((scanFragment.currentMTCard != null || scanFragment.hasMTCards) && ((z || z2) && !scanFragment.readOnly)) {
                    scanFragment.getBinding().editImage.setVisibility(0);
                    scanFragment.getBinding().moveTextView.setVisibility(0);
                    scanFragment.getBinding().deleteTextView.setVisibility(0);
                    scanFragment.getBinding().actionItemsSeparator1.setVisibility(0);
                    if (scanFragment.currentDeckListId != -1 && scanFragment.currentDeck == null && scanFragment.currentDeckLists == null) {
                        scanFragment.getBinding().moveTextView.setVisibility(8);
                    }
                }
                scanFragment.getBinding().addToCollectionTextView.setVisibility(0);
                scanFragment.getBinding().actionItemsSeparator2.setVisibility(0);
                Unit unit2 = Unit.INSTANCE;
                Unit unit3 = Unit.INSTANCE;
            }
        } else {
            Intrinsics.checkNotNull(mTCombo);
            MaterialButton detailAllPrintsButton2 = scanFragment.getBinding().detailAllPrintsButton;
            Intrinsics.checkNotNullExpressionValue(detailAllPrintsButton2, "detailAllPrintsButton");
            detailAllPrintsButton2.setEnabled(false);
            MaterialButton pickACardButton = scanFragment.getBinding().pickACardButton;
            Intrinsics.checkNotNullExpressionValue(pickACardButton, "pickACardButton");
            pickACardButton.setVisibility(4);
            View pickACardPadding = scanFragment.getBinding().pickACardPadding;
            Intrinsics.checkNotNullExpressionValue(pickACardPadding, "pickACardPadding");
            pickACardPadding.setVisibility(0);
            scanFragment.getBinding().comboTopLayout.setVisibility(0);
            scanFragment.getBinding().comboBottomLayout.setVisibility(0);
            SpannableString spannableString = new SpannableString(CollectionsKt.joinToString$default(mTCombo.getCards(), " + ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda164
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScanFragment.onViewCreated$lambda$11((MTComboCard) obj);
                }
            }, 30, null));
            int color = ContextCompat.getColor(scanFragment.requireContext(), R.color.selected_color_new);
            int length = 0;
            for (MTComboCard mTComboCard : mTCombo.getCards()) {
                int length2 = mTComboCard.getName().length() + length;
                if (!mTComboCard.getInDeck()) {
                    spannableString.setSpan(new ForegroundColorSpan(color), length, length2, 33);
                }
                length = " + ".length() + length2;
            }
            scanFragment.getBinding().comboTitle.setText(spannableString);
            ConstraintLayout comboTopLayout = scanFragment.getBinding().comboTopLayout;
            Intrinsics.checkNotNullExpressionValue(comboTopLayout, "comboTopLayout");
            ViewExtensionsKt.setOnClickWithFade(comboTopLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.onViewCreated$lambda$12(this.f$0);
                }
            });
            ConstraintLayout openInSpellbookButtonLayout = scanFragment.getBinding().openInSpellbookButtonLayout;
            Intrinsics.checkNotNullExpressionValue(openInSpellbookButtonLayout, "openInSpellbookButtonLayout");
            ViewExtensionsKt.setOnClickWithFade(openInSpellbookButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScanFragment.onViewCreated$lambda$13(mTCombo, scanFragment);
                }
            });
            Unit unit4 = Unit.INSTANCE;
        }
        TextView deleteTextView = scanFragment.getBinding().deleteTextView;
        Intrinsics.checkNotNullExpressionValue(deleteTextView, "deleteTextView");
        ViewExtensionsKt.setOnClickWithFade(deleteTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$15(this.f$0);
            }
        });
        TextView moveTextView = scanFragment.getBinding().moveTextView;
        Intrinsics.checkNotNullExpressionValue(moveTextView, "moveTextView");
        ViewExtensionsKt.setOnClickWithFade(moveTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$16(this.f$0);
            }
        });
        ImageView editImage = scanFragment.getBinding().editImage;
        Intrinsics.checkNotNullExpressionValue(editImage, "editImage");
        ViewExtensionsKt.setOnClickWithFade(editImage, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda55
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$17(this.f$0);
            }
        });
        TextView addToCollectionTextView = scanFragment.getBinding().addToCollectionTextView;
        Intrinsics.checkNotNullExpressionValue(addToCollectionTextView, "addToCollectionTextView");
        ViewExtensionsKt.setOnClickWithFade(addToCollectionTextView, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda66
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$18(this.f$0);
            }
        });
        ImageView downloadImage = scanFragment.getBinding().downloadImage;
        Intrinsics.checkNotNullExpressionValue(downloadImage, "downloadImage");
        ViewExtensionsKt.setOnClickWithFade(downloadImage, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda72
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$19(this.f$0);
            }
        });
        ImageView shareImage = scanFragment.getBinding().shareImage;
        Intrinsics.checkNotNullExpressionValue(shareImage, "shareImage");
        ViewExtensionsKt.setOnClickWithFade(shareImage, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda73
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$20(this.f$0);
            }
        });
        ConstraintLayout edhrecLayout = scanFragment.getBinding().edhrecLayout;
        Intrinsics.checkNotNullExpressionValue(edhrecLayout, "edhrecLayout");
        ViewExtensionsKt.setOnClickWithBounce(edhrecLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda75
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$21(this.f$0);
            }
        });
        ConstraintLayout scryfallLayout = scanFragment.getBinding().scryfallLayout;
        Intrinsics.checkNotNullExpressionValue(scryfallLayout, "scryfallLayout");
        ViewExtensionsKt.setOnClickWithBounce(scryfallLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda77
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$22(this.f$0);
            }
        });
        ConstraintLayout gathererLayout = scanFragment.getBinding().gathererLayout;
        Intrinsics.checkNotNullExpressionValue(gathererLayout, "gathererLayout");
        ViewExtensionsKt.setOnClickWithFade(gathererLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda78
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$23(this.f$0);
            }
        });
        LinearLayout translateLinearLayout = scanFragment.getBinding().translateLinearLayout;
        Intrinsics.checkNotNullExpressionValue(translateLinearLayout, "translateLinearLayout");
        ViewExtensionsKt.setOnClickWithFade(translateLinearLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda79
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$24(this.f$0);
            }
        });
        View viewInflate = scanFragment.getLayoutInflater().inflate(R.layout.popup_language_list, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        scanFragment.popupView = viewInflate;
        if (viewInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupView");
            viewInflate = null;
        }
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.language_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(scanFragment.requireContext()));
        View view2 = scanFragment.popupView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupView");
            view2 = null;
        }
        PopupWindow popupWindow2 = new PopupWindow(view2, -2, -2);
        scanFragment.popupWindow = popupWindow2;
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0));
        PopupWindow popupWindow3 = scanFragment.popupWindow;
        if (popupWindow3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("popupWindow");
        } else {
            popupWindow = popupWindow3;
        }
        popupWindow.setOutsideTouchable(true);
        recyclerView.setAdapter(new CardLanguageAdapter(new ArrayList(), scanFragment));
        CardView flagContainer = scanFragment.getBinding().flagContainer;
        Intrinsics.checkNotNullExpressionValue(flagContainer, "flagContainer");
        flagContainer.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ScanFragment.onViewCreated$lambda$25(this.f$0, view3);
            }
        });
        scanFragment.getBinding().cardFrontContainer.setClipChildren(true);
        ConstraintLayout pauseScanButton = scanFragment.getBinding().pauseScanButton;
        Intrinsics.checkNotNullExpressionValue(pauseScanButton, "pauseScanButton");
        ViewExtensionsKt.setOnClickWithBounce(pauseScanButton, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda81
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$26(this.f$0);
            }
        });
        scanFragment.updateScanSettingsOverrideIndicator();
        ConstraintLayout scanSettingsButton = scanFragment.getBinding().scanSettingsButton;
        Intrinsics.checkNotNullExpressionValue(scanSettingsButton, "scanSettingsButton");
        ViewExtensionsKt.setOnClickWithBounce(scanSettingsButton, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda82
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$27(this.f$0);
            }
        });
        ConstraintLayout cardFrontContainer = scanFragment.getBinding().cardFrontContainer;
        Intrinsics.checkNotNullExpressionValue(cardFrontContainer, "cardFrontContainer");
        ViewExtensionsKt.setOnSwipeAndClickListener(cardFrontContainer, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda83
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$28(this.f$0);
            }
        }, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda84
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$29(this.f$0);
            }
        }, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda85
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$30(this.f$0);
            }
        });
        ConstraintLayout cardBackContainer = scanFragment.getBinding().cardBackContainer;
        Intrinsics.checkNotNullExpressionValue(cardBackContainer, "cardBackContainer");
        ViewExtensionsKt.setOnSwipeAndClickListener(cardBackContainer, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda88
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$31(this.f$0);
            }
        }, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda89
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$32(this.f$0);
            }
        }, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda90
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$33(this.f$0);
            }
        });
        ConstraintLayout cardNextContainer = scanFragment.getBinding().cardNextContainer;
        Intrinsics.checkNotNullExpressionValue(cardNextContainer, "cardNextContainer");
        ConstraintLayout cardPreviousContainer = scanFragment.getBinding().cardPreviousContainer;
        Intrinsics.checkNotNullExpressionValue(cardPreviousContainer, "cardPreviousContainer");
        ViewExtensionsKt.setOnClickWithFade(cardNextContainer, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda91
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$34(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(cardPreviousContainer, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda92
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanFragment.onViewCreated$lambda$35(this.f$0);
            }
        });
        scanFragment.getBinding().flipCardButton.setVisibility(4);
        scanFragment.getBinding().flipCardButton.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda93
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ScanFragment.onViewCreated$lambda$36(this.f$0, view3);
            }
        });
        scanFragment.getBinding().scrollView.setVisibility(4);
        scanFragment.getBinding().topBar.setVisibility(4);
        scanFragment.getBinding().actionItemsLayout.setVisibility(4);
        scanFragment.getBinding().backToGameButton.setVisibility(4);
        scanFragment.getBinding().backToGameLabel.setVisibility(4);
        scanFragment.getBinding().backToGameButton.setText(scanFragment.getString(R.string.fa_chevron_left));
        scanFragment.getBinding().backToGameButton.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda94
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ScanFragment.onViewCreated$lambda$37(this.f$0, view3);
            }
        });
        scanFragment.getBinding().backToGameLabel.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda95
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ScanFragment.onViewCreated$lambda$38(this.f$0, view3);
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda96
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.onBack();
            }
        };
        scanFragment.getBinding().backButton.setOnClickListener(onClickListener);
        scanFragment.getBinding().backLabel.setOnClickListener(onClickListener);
        if (scanFragment.pickACardMode) {
            scanFragment.getBinding().backToGameButton.setVisibility(0);
            scanFragment.getBinding().backToGameLabel.setVisibility(4);
        }
        if (scanFragment.scanToDeckMode || scanFragment.scanToListMode) {
            scanFragment.getBinding().backToGameButton.setVisibility(0);
            scanFragment.getBinding().backToGameLabel.setVisibility(4);
        }
        if (scanFragment.noScanMode && scanFragment.scryfallIdToLoad.length() > 0) {
            CardMatch cardMatch = new CardMatch(null, null, 0, 0L, null, null, null, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, false, null, 2097151, null);
            Bundle arguments = scanFragment.getArguments();
            String str = "en";
            if (arguments == null || (string = arguments.getString("lang")) == null) {
                string = "en";
            }
            cardMatch.setLang(string);
            cardMatch.setFace(0);
            cardMatch.setScryfallId(scanFragment.scryfallIdToLoad);
            cardMatch.setOracleId(scanFragment.oracleIdToLoad);
            Bundle arguments2 = scanFragment.getArguments();
            if (arguments2 != null && (string2 = arguments2.getString("lang")) != null) {
                str = string2;
            }
            cardMatch.setDetectedCardLang(str);
            cardMatch.setEnScryfallId(scanFragment.enScryfallId);
            cardMatch.setLocalizedTitle("");
            scanFragment.currentCardMatch = cardMatch;
            scanFragment.getBinding().cardZone.setVisibility(8);
            scanFragment.getBinding().helpLabel.setVisibility(8);
            scanFragment.playProgressAnimation();
            scanFragment.fetchCard(cardMatch, false);
            scanFragment.fetchRulings();
            Unit unit5 = Unit.INSTANCE;
        }
        if (scanFragment.noScanMode && scanFragment.mtCardJson.length() > 0) {
            Object objFromJson = new Gson().fromJson(scanFragment.mtCardJson, new TypeToken<MTFullCard>() { // from class: com.studiolaganne.lengendarylens.ScanFragment$onViewCreated$type$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
            MTFullCard mTFullCard = (MTFullCard) objFromJson;
            if (scanFragment.hasMTCards) {
                scanFragment.currentMTCardList = CardDataStore.INSTANCE.getMtCardList();
                scanFragment.updateNextPrevious();
                if (scanFragment.currentCardListIndex < scanFragment.currentMTCardList.size() - 1) {
                    scanFragment.fetchNextCard();
                }
                if (scanFragment.currentCardListIndex > 0) {
                    scanFragment.fetchPreviousCard();
                }
            }
            displayMTCard$default(scanFragment, mTFullCard, false, false, 4, null);
            scanFragment.fetchRulings();
        }
        if (scanFragment.shouldStartCamera) {
            scanFragment.startCameraCapture();
        }
    }

    public final void removeCheckmarkAnimation() {
        if (this._binding == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_remove_checkmark");
        if (getBinding().lottieAnimationView.getVisibility() == 0) {
            getBinding().lottieAnimationView.pauseAnimation();
            getBinding().lottieAnimationView.setVisibility(4);
        }
    }

    public final void replaceCardImage(LoadingImageView toImageView, LoadingImageView fromImageView) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(toImageView, "toImageView");
        Intrinsics.checkNotNullParameter(fromImageView, "fromImageView");
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_replace_card_image");
        Drawable drawable = fromImageView.getDrawable();
        if (drawable == null) {
            return;
        }
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            Integer numValueOf = Integer.valueOf(drawable.getIntrinsicWidth());
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            if (numValueOf == null) {
                return;
            }
            int iIntValue = numValueOf.intValue();
            Integer numValueOf2 = Integer.valueOf(drawable.getIntrinsicHeight());
            if (numValueOf2.intValue() <= 0) {
                numValueOf2 = null;
            }
            if (numValueOf2 == null) {
                return;
            }
            int iIntValue2 = numValueOf2.intValue();
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iIntValue, iIntValue2, Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawable.setBounds(0, 0, iIntValue, iIntValue2);
                drawable.draw(canvas);
                bitmap = bitmapCreateBitmap;
            } catch (Exception e) {
                Log.e(TAG, "replaceCardImage: Failed to render drawable to bitmap", e);
                bitmap = null;
            }
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        try {
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            Bitmap bitmapCopy = bitmap.copy(config, false);
            if (bitmapCopy != null) {
                toImageView.setImageDrawableWithoutClear(new BitmapDrawable(getResources(), bitmapCopy));
            }
        } catch (Exception e2) {
            Log.e(TAG, "replaceCardImage: Failed to copy bitmap", e2);
        }
    }

    public final void setDeviceStable(boolean z) {
        this.isDeviceStable = z;
    }

    public final void showInternetError() {
        if (getActivity() == null || this.stopping) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("scan_internet_error");
        requireActivity().runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$$ExternalSyntheticLambda56
            @Override // java.lang.Runnable
            public final void run() {
                ScanFragment.showInternetError$lambda$0(this.f$0);
            }
        });
    }
}
