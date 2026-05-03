package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.video.AudioStats;
import androidx.camera.view.PreviewView;
import androidx.core.view.PointerIconCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.analytics.AnalyticsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.ParametersBuilder;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.studiolaganne.lengendarylens.CardClassifier;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.GroupingKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDouble;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: CombinedAnalyzer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 Ì\u00012\u00020\u0001:\u0004Ë\u0001Ì\u0001Bü\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u0012 \u0001\u0010\u0011\u001a\u009b\u0001\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0012\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0 ¢\u0006\u0004\b!\u0010\"J\b\u0010t\u001a\u00020\u001eH\u0002J\u0010\u0010\u0086\u0001\u001a\u00020\u001e2\u0007\u0010\u0087\u0001\u001a\u00020$J\u0007\u0010\u0088\u0001\u001a\u00020$J\u0007\u0010\u0089\u0001\u001a\u00020\u001eJ\u0007\u0010\u008a\u0001\u001a\u00020\u001eJ\u0007\u0010\u008b\u0001\u001a\u00020\u001eJ\u0015\u0010\u008c\u0001\u001a\u00020\u001e2\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0002J\u0015\u0010\u008f\u0001\u001a\u00020\u001e2\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0002J\t\u0010\u0092\u0001\u001a\u00020\u001eH\u0002J\t\u0010\u0093\u0001\u001a\u00020\u001eH\u0002J\u0013\u0010\u0094\u0001\u001a\u00020R2\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0002J\u0014\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u008e\u00012\b\u0010\u0096\u0001\u001a\u00030\u008e\u0001J\u0014\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u008e\u00012\b\u0010\u0096\u0001\u001a\u00030\u008e\u0001J\u001d\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u008e\u00012\b\u0010\u0096\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u0099\u0001\u001a\u00020\u0013J\u001d\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u008e\u00012\b\u0010\u0096\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u0099\u0001\u001a\u00020\u0013J\u001e\u0010\u009b\u0001\u001a\u00020\u001e2\b\u0010\u009c\u0001\u001a\u00030\u008e\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020$H\u0002J\u001e\u0010\u009e\u0001\u001a\u00020\u001e2\b\u0010\u009f\u0001\u001a\u00030\u008e\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020$H\u0002J\t\u0010 \u0001\u001a\u00020\u001eH\u0002JA\u0010¡\u0001\u001a\u00020\u001e2\u000e\u0010¢\u0001\u001a\t\u0012\u0005\u0012\u00030£\u00010\u000b2\b\u0010j\u001a\u0004\u0018\u00010k2\t\u0010¤\u0001\u001a\u0004\u0018\u00010k2\u0007\u0010¥\u0001\u001a\u00020$2\b\u0010¦\u0001\u001a\u00030§\u0001H\u0002J+\u0010¨\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b0©\u00012\r\u0010ª\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH\u0002J\t\u0010«\u0001\u001a\u00020\u001eH\u0002J/\u0010¬\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ad\u00010\u000b2\r\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u001b\u0010¯\u0001\u001a\u00020R2\u0007\u0010°\u0001\u001a\u00020\u00132\u0007\u0010±\u0001\u001a\u00020\u0013H\u0002J\u0010\u0010²\u0001\u001a\u00020\u00132\u0007\u0010³\u0001\u001a\u00020\u0013J\u000f\u0010´\u0001\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013J\t\u0010µ\u0001\u001a\u00020\u001eH\u0002J\u0011\u0010¶\u0001\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J\u0012\u0010·\u0001\u001a\u00020\u00132\u0007\u0010¸\u0001\u001a\u00020\u0013H\u0002J\u001b\u0010¹\u0001\u001a\u00020\u001b2\u0007\u0010º\u0001\u001a\u00020\u00132\u0007\u0010»\u0001\u001a\u00020\u0013H\u0002J\u0011\u0010¼\u0001\u001a\u00030½\u00012\u0007\u0010¾\u0001\u001a\u00020\u0013J\u0018\u0010¿\u0001\u001a\u00020R2\r\u0010À\u0001\u001a\b\u0012\u0004\u0012\u00020R0\u000bH\u0002J\u001c\u0010Á\u0001\u001a\u00030\u0084\u00012\u0007\u0010Â\u0001\u001a\u00020k2\u0007\u0010Ã\u0001\u001a\u00020kH\u0002J\u0013\u0010Ä\u0001\u001a\u00020\u001e2\b\u0010Å\u0001\u001a\u00030Æ\u0001H\u0003J/\u0010Ç\u0001\u001a\u00020\u001e2\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\b\u0010Å\u0001\u001a\u00030Æ\u00012\u0007\u0010È\u0001\u001a\u00020]2\u0007\u0010É\u0001\u001a\u00020]H\u0003J\u0013\u0010Ê\u0001\u001a\u00020\u001e2\b\u0010Å\u0001\u001a\u00030Æ\u0001H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R¨\u0001\u0010\u0011\u001a\u009b\u0001\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001a\u0010+\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u001a\u0010.\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'R\u001a\u00101\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010=\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\b?\u0010@R\u001b\u0010C\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010B\u001a\u0004\bE\u0010FR\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010M\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bM\u0010%R\u0013\u0010N\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u000e\u0010Q\u001a\u00020RX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020R0TX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u001bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020RX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020RX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020RX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020RX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00130`X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00130`X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00130`X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u001bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u001bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u001bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010h\u001a\b\u0012\u0004\u0012\u00020i0`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020RX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020RX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020RX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020RX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020RX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u001bX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010u\u001a\u00020v8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\by\u0010B\u001a\u0004\bw\u0010xR\u000e\u0010z\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020RX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010kX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0083\u0001\u001a\u00030\u0084\u0001X\u0082D¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Í\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/CombinedAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "context", "Landroid/content/Context;", "fragment", "Lcom/studiolaganne/lengendarylens/ScanFragment;", "overlayView", "Lcom/studiolaganne/lengendarylens/BoundingBoxOverlayView;", "viewFinder", "Landroidx/camera/view/PreviewView;", "cardSets", "", "Lcom/studiolaganne/lengendarylens/CardSet;", "dbHelper", "Lcom/studiolaganne/lengendarylens/MTGDBHelper;", "dbHelpers", "Lcom/studiolaganne/lengendarylens/MTGDBHelperLocalized;", "onCardDetected", "Lkotlin/Function7;", "", "Lkotlin/ParameterName;", "name", "oracleId", "scryfallId", Constants.GP_IAP_TITLE, "set", "number", "", OptionalModuleUtils.FACE, "lang", "", "onSameCardDetected", "Lkotlin/Function0;", "<init>", "(Landroid/content/Context;Lcom/studiolaganne/lengendarylens/ScanFragment;Lcom/studiolaganne/lengendarylens/BoundingBoxOverlayView;Landroidx/camera/view/PreviewView;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTGDBHelper;Ljava/util/List;Lkotlin/jvm/functions/Function7;Lkotlin/jvm/functions/Function0;)V", "isPaused", "", "()Z", "setPaused", "(Z)V", "processing", "getProcessing", "setProcessing", "lockedIn", "getLockedIn", "setLockedIn", "firstFrameSkipped", "getFirstFrameSkipped", "setFirstFrameSkipped", "ocrCounter", "getOcrCounter", "()I", "setOcrCounter", "(I)V", "discardedAttempts", "getDiscardedAttempts", "setDiscardedAttempts", "cardClassifier", "Lcom/studiolaganne/lengendarylens/CardClassifier;", "cardDetector", "Lcom/studiolaganne/lengendarylens/CardDetector;", "cardEmbeddings", "Lcom/studiolaganne/lengendarylens/CardEmbeddings;", "getCardEmbeddings", "()Lcom/studiolaganne/lengendarylens/CardEmbeddings;", "cardEmbeddings$delegate", "Lkotlin/Lazy;", "setSymbolEmbeddings", "Lcom/studiolaganne/lengendarylens/SetSymbolEmbeddings;", "getSetSymbolEmbeddings", "()Lcom/studiolaganne/lengendarylens/SetSymbolEmbeddings;", "setSymbolEmbeddings$delegate", "plistDetector", "Lcom/studiolaganne/lengendarylens/PlistDetector;", "textRecognizer", "Lcom/google/mlkit/vision/text/TextRecognizer;", "isCleanedUp", "isReady", "initializationError", "getInitializationError", "()Ljava/lang/String;", "maxObservedSharpness", "", "sharpnessHistory", "Lkotlin/collections/ArrayDeque;", "stableFrameCounter", "requiredStableFrames", "minSharpnessThreshold", "deviceRelativeThreshold", "runningAvgSharpness", "sharpnessCount", "SHARPNESS_WEIGHT", "lastProcessedFrameTime", "", "targetProcessingInterval", "titleDetections", "", "setCodeDetections", "cardNumberDetections", "maxOcrDetections", "maxTitleDetections", "maxBottomDetections", "titleDetectionCounter", "bottomDetectionCounter", "storedEmbeddingMatches", "Lcom/studiolaganne/lengendarylens/EmbeddingMatch;", "currentArtworkEmbedding", "", "EMBEDDING_WEIGHT", "SET_SYMBOL_WEIGHT", "PLIST_SCORE_BOOST", "PLIST_SCORE_PENALTY", "SERIALIZED_CARD_PENALTY", "ocrStartTime", "successfulScanCount", "GC_TRIGGER_INTERVAL", "onSuccessfulScan", "soundPool", "Landroid/media/SoundPool;", "getSoundPool", "()Landroid/media/SoundPool;", "soundPool$delegate", "debugSoundId1", "debugSoundId2", "firstBeepPlayed", "continuousMode", "lastCardDetectionTime", "isWaitingForNewCard", "cooldownPeriod", "lastDetectedOracleID", "lastDetectedEmbedding", "ARTWORK_SIMILARITY_THRESHOLD", "", "sameDetectionCounter", "setContinuousMode", "enabled", "getContinuousMode", "resetContinuousState", "reset", "cleanup", "recycleBitmapSafely", "bitmap", "Landroid/graphics/Bitmap;", "recycleSegmentationBitmaps", "segmentation", "Lcom/studiolaganne/lengendarylens/CardSegmentation;", "playDebugSound1", "playDebugSound2", "getSharpness", "extractPListStampRegion", "cardBitmap", "extractSetSymbolRegion", "extractTitleRegion", "cardType", "extractBottomLeftRegion", "detectTitleText", "titleBitmap", "shouldRecycleBitmap", "detectSetCodeAndNumber", "bottomLeftBitmap", "checkAndAnalyzeResults", "storeEmbeddingMatchesWithSetSymbolEmbedding", "similarCards", "Lcom/studiolaganne/lengendarylens/SimilarCard;", "setSymbolEmbedding", "hasPListHash", "borderColor", "Lcom/studiolaganne/lengendarylens/BorderColor;", "groupSimilarTitles", "", "titles", "analyzeAccumulatedDetectionsWithIndividualPrints", "compareOcrWithCard", "Lcom/studiolaganne/lengendarylens/TitleComparison;", "detectedTitles", "calculateTitleSimilarity", "title1", "title2", "removeDiacritics", "input", "cleanTitle", "resetAccumulatedDetections", "normalizeCardNumber", "validateAndCorrectSetCode", "detectedSetCode", "levenshteinDistance", "s1", "s2", "parseBottomText", "Lcom/studiolaganne/lengendarylens/CombinedAnalyzer$CardInfo;", "text", "calculateRecentVariation", "values", "cosineSimilarity", "a", "b", "analyzeInternal", "imageProxy", "Landroidx/camera/core/ImageProxy;", "analyzeInternalWithBitmap", "currentTime", "timeSinceLastProcessed", "analyze", "CardInfo", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CombinedAnalyzer implements ImageAnalysis.Analyzer {
    private static final long REINIT_COOLDOWN_MS = 5000;
    public static final String TAG = "CombinedAnalyzer";
    private static volatile long lastReinitAttempt;
    private static volatile Boolean openCVAvailable;
    private static volatile boolean reinitInProgress;
    private final float ARTWORK_SIMILARITY_THRESHOLD;
    private final double EMBEDDING_WEIGHT;
    private final int GC_TRIGGER_INTERVAL;
    private final double PLIST_SCORE_BOOST;
    private final double PLIST_SCORE_PENALTY;
    private final double SERIALIZED_CARD_PENALTY;
    private final double SET_SYMBOL_WEIGHT;
    private final double SHARPNESS_WEIGHT;
    private int bottomDetectionCounter;
    private CardClassifier cardClassifier;
    private final CardDetector cardDetector;

    /* JADX INFO: renamed from: cardEmbeddings$delegate, reason: from kotlin metadata */
    private final Lazy cardEmbeddings;
    private final List<String> cardNumberDetections;
    private final List<CardSet> cardSets;
    private final Context context;
    private boolean continuousMode;
    private final double cooldownPeriod;
    private float[] currentArtworkEmbedding;
    private final MTGDBHelper dbHelper;
    private List<MTGDBHelperLocalized> dbHelpers;
    private int debugSoundId1;
    private int debugSoundId2;
    private final double deviceRelativeThreshold;
    private int discardedAttempts;
    private boolean firstBeepPlayed;
    private boolean firstFrameSkipped;
    private final ScanFragment fragment;
    private volatile boolean isCleanedUp;
    private boolean isPaused;
    private boolean isWaitingForNewCard;
    private long lastCardDetectionTime;
    private float[] lastDetectedEmbedding;
    private String lastDetectedOracleID;
    private long lastProcessedFrameTime;
    private boolean lockedIn;
    private final int maxBottomDetections;
    private double maxObservedSharpness;
    private final int maxOcrDetections;
    private final int maxTitleDetections;
    private final double minSharpnessThreshold;
    private int ocrCounter;
    private long ocrStartTime;
    private final Function7<String, String, String, String, String, Integer, String, Unit> onCardDetected;
    private final Function0<Unit> onSameCardDetected;
    private final BoundingBoxOverlayView overlayView;
    private final PlistDetector plistDetector;
    private boolean processing;
    private final int requiredStableFrames;
    private double runningAvgSharpness;
    private int sameDetectionCounter;
    private final List<String> setCodeDetections;

    /* JADX INFO: renamed from: setSymbolEmbeddings$delegate, reason: from kotlin metadata */
    private final Lazy setSymbolEmbeddings;
    private int sharpnessCount;
    private final ArrayDeque<Double> sharpnessHistory;

    /* JADX INFO: renamed from: soundPool$delegate, reason: from kotlin metadata */
    private final Lazy soundPool;
    private int stableFrameCounter;
    private List<EmbeddingMatch> storedEmbeddingMatches;
    private int successfulScanCount;
    private long targetProcessingInterval;
    private final TextRecognizer textRecognizer;
    private int titleDetectionCounter;
    private final List<String> titleDetections;
    private final PreviewView viewFinder;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Object openCVLock = new Object();

    /* JADX INFO: compiled from: CombinedAnalyzer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/CombinedAnalyzer$CardInfo;", "", "rarity", "", "cardNumber", "setCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRarity", "()Ljava/lang/String;", "getCardNumber", "getSetCode", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CardInfo {
        public static final int $stable = 0;
        private final String cardNumber;
        private final String rarity;
        private final String setCode;

        public CardInfo() {
            this(null, null, null, 7, null);
        }

        public CardInfo(String rarity, String cardNumber, String setCode) {
            Intrinsics.checkNotNullParameter(rarity, "rarity");
            Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
            Intrinsics.checkNotNullParameter(setCode, "setCode");
            this.rarity = rarity;
            this.cardNumber = cardNumber;
            this.setCode = setCode;
        }

        public /* synthetic */ CardInfo(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
        }

        public static /* synthetic */ CardInfo copy$default(CardInfo cardInfo, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cardInfo.rarity;
            }
            if ((i & 2) != 0) {
                str2 = cardInfo.cardNumber;
            }
            if ((i & 4) != 0) {
                str3 = cardInfo.setCode;
            }
            return cardInfo.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getRarity() {
            return this.rarity;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCardNumber() {
            return this.cardNumber;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSetCode() {
            return this.setCode;
        }

        public final CardInfo copy(String rarity, String cardNumber, String setCode) {
            Intrinsics.checkNotNullParameter(rarity, "rarity");
            Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
            Intrinsics.checkNotNullParameter(setCode, "setCode");
            return new CardInfo(rarity, cardNumber, setCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CardInfo)) {
                return false;
            }
            CardInfo cardInfo = (CardInfo) other;
            return Intrinsics.areEqual(this.rarity, cardInfo.rarity) && Intrinsics.areEqual(this.cardNumber, cardInfo.cardNumber) && Intrinsics.areEqual(this.setCode, cardInfo.setCode);
        }

        public final String getCardNumber() {
            return this.cardNumber;
        }

        public final String getRarity() {
            return this.rarity;
        }

        public final String getSetCode() {
            return this.setCode;
        }

        public int hashCode() {
            return (((this.rarity.hashCode() * 31) + this.cardNumber.hashCode()) * 31) + this.setCode.hashCode();
        }

        public String toString() {
            return "CardInfo(rarity=" + this.rarity + ", cardNumber=" + this.cardNumber + ", setCode=" + this.setCode + ")";
        }
    }

    /* JADX INFO: compiled from: CombinedAnalyzer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/CombinedAnalyzer$Companion;", "", "<init>", "()V", "TAG", "", "openCVAvailable", "", "Ljava/lang/Boolean;", "reinitInProgress", "lastReinitAttempt", "", "REINIT_COOLDOWN_MS", "openCVLock", "isOpenCVAvailable", "isOpenCVUnavailable", "setOpenCVAvailable", "", "available", "tryReinitializeOpenCVIfNeeded", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isOpenCVAvailable() {
            return Intrinsics.areEqual((Object) CombinedAnalyzer.openCVAvailable, (Object) true);
        }

        public final boolean isOpenCVUnavailable() {
            return Intrinsics.areEqual((Object) CombinedAnalyzer.openCVAvailable, (Object) false);
        }

        public final void setOpenCVAvailable(boolean available) {
            CombinedAnalyzer.openCVAvailable = Boolean.valueOf(available);
        }

        public final boolean tryReinitializeOpenCVIfNeeded() {
            boolean z = true;
            if (Intrinsics.areEqual((Object) CombinedAnalyzer.openCVAvailable, (Object) true)) {
                return true;
            }
            boolean z2 = false;
            if (CombinedAnalyzer.reinitInProgress || System.currentTimeMillis() - CombinedAnalyzer.lastReinitAttempt < 5000) {
                return false;
            }
            synchronized (CombinedAnalyzer.openCVLock) {
                if (Intrinsics.areEqual((Object) CombinedAnalyzer.openCVAvailable, (Object) true)) {
                    return true;
                }
                if (CombinedAnalyzer.reinitInProgress) {
                    return false;
                }
                if (System.currentTimeMillis() - CombinedAnalyzer.lastReinitAttempt < 5000) {
                    return false;
                }
                Companion companion = CombinedAnalyzer.INSTANCE;
                CombinedAnalyzer.reinitInProgress = true;
                Companion companion2 = CombinedAnalyzer.INSTANCE;
                CombinedAnalyzer.lastReinitAttempt = System.currentTimeMillis();
                Unit unit = Unit.INSTANCE;
                try {
                    try {
                        try {
                        } catch (UnsatisfiedLinkError e) {
                            Log.e(CombinedAnalyzer.TAG, "OpenCV re-initialization threw UnsatisfiedLinkError", e);
                            CombinedAnalyzer.openCVAvailable = Boolean.valueOf(z2);
                            return z2;
                        }
                    } catch (Exception e2) {
                        Log.e(CombinedAnalyzer.TAG, "OpenCV re-initialization failed with exception", e2);
                        CombinedAnalyzer.openCVAvailable = Boolean.valueOf(z2);
                        return z2;
                    }
                    if (OpenCVLoader.initLocal()) {
                        try {
                            new Mat().release();
                            Log.d(CombinedAnalyzer.TAG, "OpenCV re-initialized successfully");
                        } catch (UnsatisfiedLinkError e3) {
                            Log.e(CombinedAnalyzer.TAG, "OpenCV JNI test failed during re-init", e3);
                            z = false;
                        }
                        CombinedAnalyzer.reinitInProgress = false;
                        z2 = z;
                        CombinedAnalyzer.openCVAvailable = Boolean.valueOf(z2);
                        return z2;
                    }
                    Log.e(CombinedAnalyzer.TAG, "OpenCV initLocal() returned false during re-init");
                    z = false;
                    CombinedAnalyzer.reinitInProgress = false;
                    z2 = z;
                    CombinedAnalyzer.openCVAvailable = Boolean.valueOf(z2);
                    return z2;
                } finally {
                    CombinedAnalyzer.reinitInProgress = false;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CombinedAnalyzer(Context context, ScanFragment fragment, BoundingBoxOverlayView overlayView, PreviewView viewFinder, List<CardSet> cardSets, MTGDBHelper dbHelper, List<MTGDBHelperLocalized> dbHelpers, Function7<? super String, ? super String, ? super String, ? super String, ? super String, ? super Integer, ? super String, Unit> onCardDetected, Function0<Unit> onSameCardDetected) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(overlayView, "overlayView");
        Intrinsics.checkNotNullParameter(viewFinder, "viewFinder");
        Intrinsics.checkNotNullParameter(cardSets, "cardSets");
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        Intrinsics.checkNotNullParameter(dbHelpers, "dbHelpers");
        Intrinsics.checkNotNullParameter(onCardDetected, "onCardDetected");
        Intrinsics.checkNotNullParameter(onSameCardDetected, "onSameCardDetected");
        this.context = context;
        this.fragment = fragment;
        this.overlayView = overlayView;
        this.viewFinder = viewFinder;
        this.cardSets = cardSets;
        this.dbHelper = dbHelper;
        this.dbHelpers = dbHelpers;
        this.onCardDetected = onCardDetected;
        this.onSameCardDetected = onSameCardDetected;
        this.cardClassifier = new CardClassifier(context);
        this.cardDetector = new CardDetector(context);
        this.cardEmbeddings = LazyKt.lazy(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EmbeddingsLoader.INSTANCE.getCardEmbeddings(this.f$0.context);
            }
        });
        this.setSymbolEmbeddings = LazyKt.lazy(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EmbeddingsLoader.INSTANCE.getSetSymbolEmbeddings(this.f$0.context);
            }
        });
        this.plistDetector = new PlistDetector(context);
        TextRecognizer client = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        this.textRecognizer = client;
        this.sharpnessHistory = new ArrayDeque<>(10);
        this.requiredStableFrames = 2;
        this.minSharpnessThreshold = 200.0d;
        this.deviceRelativeThreshold = 0.35d;
        this.SHARPNESS_WEIGHT = 0.3d;
        this.targetProcessingInterval = 100L;
        this.titleDetections = new ArrayList();
        this.setCodeDetections = new ArrayList();
        this.cardNumberDetections = new ArrayList();
        this.maxOcrDetections = 1;
        this.maxTitleDetections = 1;
        this.maxBottomDetections = 1;
        this.storedEmbeddingMatches = new ArrayList();
        this.EMBEDDING_WEIGHT = 0.7d;
        this.SET_SYMBOL_WEIGHT = 0.3d;
        this.PLIST_SCORE_BOOST = 1.5d;
        this.PLIST_SCORE_PENALTY = -1.5d;
        this.SERIALIZED_CARD_PENALTY = -2.0d;
        this.GC_TRIGGER_INTERVAL = 5;
        this.soundPool = LazyKt.lazy(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return new SoundPool.Builder().setMaxStreams(2).setAudioAttributes(new AudioAttributes.Builder().setUsage(13).setContentType(4).build()).build();
            }
        });
        this.cooldownPeriod = 0.5d;
        this.ARTWORK_SIMILARITY_THRESHOLD = 0.5f;
        this.debugSoundId2 = getSoundPool().load(context, R.raw.beep2, 1);
    }

    static final Unit analyze$lambda$0(CombinedAnalyzer combinedAnalyzer, ImageProxy imageProxy) {
        if (CombinedAnalyzerKt.getDEBUG_LOG()) {
            Log.d(TAG, "------------------------------------------------------------------------------------");
            Log.d(TAG, "------------------------- CombinedAnalyzer -- Analyzing... -------------------------");
            Log.d(TAG, "------------------------------------------------------------------------------------");
        }
        combinedAnalyzer.analyzeInternal(imageProxy);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r6v45 */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v48 */
    /* JADX WARN: Type inference failed for: r6v49 */
    /* JADX WARN: Type inference failed for: r6v50 */
    /* JADX WARN: Type inference failed for: r6v51 */
    /* JADX WARN: Type inference failed for: r6v52 */
    /* JADX WARN: Type inference failed for: r6v53 */
    /* JADX WARN: Type inference failed for: r6v54 */
    private final void analyzeAccumulatedDetectionsWithIndividualPrints() throws Throwable {
        ?? r6;
        ArrayList arrayList;
        ?? r62;
        Object next;
        CardRecord cardByOracleIdAndOptionalPrintData;
        double d;
        double d2;
        double d3;
        double d4;
        Iterator it;
        ?? r63;
        boolean zAreEqual;
        Double dValueOf;
        if (this.isPaused || this.processing) {
            return;
        }
        boolean z = true;
        this.processing = true;
        List<String> list = this.titleDetections;
        synchronized (list) {
            try {
                if (!this.storedEmbeddingMatches.isEmpty()) {
                    if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                        Log.d("AccumulatedAnalysis", "Starting analysis with " + this.storedEmbeddingMatches.size() + " print matches and " + this.titleDetections.size() + " title detections");
                    }
                    List listSortedWith = CollectionsKt.sortedWith(this.storedEmbeddingMatches, new Comparator() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$analyzeAccumulatedDetectionsWithIndividualPrints$lambda$0$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Double.valueOf(((EmbeddingMatch) t2).getSimilarity()), Double.valueOf(((EmbeddingMatch) t).getSimilarity()));
                        }
                    });
                    EmbeddingMatch embeddingMatch = (EmbeddingMatch) CollectionsKt.first(listSortedWith);
                    String oracleId = embeddingMatch.getOracleId();
                    if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                        Log.d("AccumulatedAnalysis", "*********************************************************");
                        Log.d("AccumulatedAnalysis", "*********************************************************");
                        Log.d("AccumulatedAnalysis", "Top match oracle ID is " + embeddingMatch.getOracleId() + ": " + embeddingMatch.getCardRecord().getTitle());
                        Log.d("AccumulatedAnalysis", "Title detections: " + this.titleDetections.size() + ", Set code detections: " + this.setCodeDetections.size() + ", Card number detections: " + this.cardNumberDetections.size());
                        Log.d("AccumulatedAnalysis", "*********************************************************");
                        Log.d("AccumulatedAnalysis", "*********************************************************");
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : listSortedWith) {
                        if (Intrinsics.areEqual(((EmbeddingMatch) obj).getOracleId(), oracleId)) {
                            arrayList2.add(obj);
                        }
                    }
                    ArrayList arrayList3 = arrayList2;
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it2 = arrayList3.iterator();
                    while (true) {
                        boolean zHasNext = it2.hasNext();
                        if (zHasNext) {
                            String set = ((EmbeddingMatch) it2.next()).getCardRecord().getSet();
                            if (arrayList4.isEmpty()) {
                                arrayList4.add(set);
                            } else {
                                String str = (String) CollectionsKt.first((List) arrayList4);
                                if (!Intrinsics.areEqual(set, str) && !Intrinsics.areEqual(set, "p" + str) && !(zAreEqual = Intrinsics.areEqual(str, "p" + set))) {
                                    if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                                        Log.d("AccumulatedAnalysis", "Matches are from different set codes, need to differentiate using set symbol similarity");
                                    }
                                    Iterator it3 = arrayList3.iterator();
                                    if (it3.hasNext()) {
                                        double similarity = ((EmbeddingMatch) it3.next()).getSimilarity();
                                        while (it3.hasNext()) {
                                            similarity = Math.max(similarity, ((EmbeddingMatch) it3.next()).getSimilarity());
                                        }
                                        dValueOf = Double.valueOf(similarity);
                                    } else {
                                        dValueOf = null;
                                    }
                                    double dDoubleValue = dValueOf != null ? dValueOf.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
                                    ArrayList<EmbeddingMatch> arrayList5 = arrayList3;
                                    ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
                                    for (EmbeddingMatch embeddingMatch2 : arrayList5) {
                                        arrayList6.add(EmbeddingMatch.copy$default(embeddingMatch2, null, null, 0, dDoubleValue, null, 0L, null, false, null, AudioStats.AUDIO_AMPLITUDE_NONE, (this.EMBEDDING_WEIGHT * dDoubleValue) + (embeddingMatch2.getSetSymbolSimilarity() * this.SET_SYMBOL_WEIGHT), PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, null));
                                    }
                                    arrayList = arrayList6;
                                    r62 = zAreEqual;
                                }
                            }
                        } else {
                            ?? r64 = zHasNext;
                            if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                                Object objFirst = CollectionsKt.first((List<? extends Object>) arrayList4);
                                StringBuilder sbAppend = new StringBuilder().append("All matches are from the same set code: ");
                                Log.d("AccumulatedAnalysis", sbAppend.append(objFirst).toString());
                                r64 = sbAppend;
                            }
                            ArrayList<EmbeddingMatch> arrayList7 = arrayList3;
                            ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
                            for (EmbeddingMatch embeddingMatch3 : arrayList7) {
                                arrayList8.add(EmbeddingMatch.copy$default(embeddingMatch3, null, null, 0, embeddingMatch3.getSimilarity(), null, 0L, null, false, null, AudioStats.AUDIO_AMPLITUDE_NONE, (embeddingMatch3.getSimilarity() * this.EMBEDDING_WEIGHT) + (embeddingMatch3.getSetSymbolSimilarity() * this.SET_SYMBOL_WEIGHT), PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, null));
                            }
                            arrayList = arrayList8;
                            r62 = r64;
                        }
                    }
                    ArrayList arrayList9 = arrayList;
                    ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList9, 10));
                    Iterator it4 = arrayList9.iterator();
                    List<String> list2 = list;
                    ?? r65 = r62;
                    while (it4.hasNext()) {
                        EmbeddingMatch embeddingMatch4 = (EmbeddingMatch) it4.next();
                        double d5 = -0.5d;
                        double d6 = (embeddingMatch4.getBorderColor() == BorderColor.BLACK && (Intrinsics.areEqual(embeddingMatch4.getCardRecord().getBorder_color(), "gold") || Intrinsics.areEqual(embeddingMatch4.getCardRecord().getBorder_color(), "silver"))) ? -0.5d : AudioStats.AUDIO_AMPLITUDE_NONE;
                        if (embeddingMatch4.getBorderColor() != BorderColor.WHITE || (!Intrinsics.areEqual(embeddingMatch4.getCardRecord().getBorder_color(), "gold") && !Intrinsics.areEqual(embeddingMatch4.getCardRecord().getBorder_color(), "silver"))) {
                            d5 = d6;
                        }
                        Iterator<String> it5 = this.setCodeDetections.iterator();
                        double d7 = AudioStats.AUDIO_AMPLITUDE_NONE;
                        List<String> list3 = list2;
                        ?? r66 = r65;
                        while (true) {
                            if (!it5.hasNext()) {
                                d3 = 0.5d;
                                r6 = r66;
                                break;
                            }
                            String next2 = it5.next();
                            if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                                d3 = 0.5d;
                                String str2 = "Checking set code: " + next2 + " against match: " + embeddingMatch4.getCardRecord().getSet();
                                Log.d("AccumulatedAnalysis", str2);
                                r63 = str2;
                            } else {
                                d3 = 0.5d;
                                r63 = r66;
                            }
                            if (StringsKt.equals(next2, embeddingMatch4.getCardRecord().getSet(), z)) {
                                d7 += 1.0d;
                                r6 = r63;
                                break;
                            }
                            String lowerCase = next2.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            String lowerCase2 = embeddingMatch4.getCardRecord().getSet().toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                            int iLevenshteinDistance = levenshteinDistance(lowerCase, lowerCase2);
                            List<String> list4 = list3;
                            double d8 = iLevenshteinDistance;
                            int iMax = Math.max(next2.length(), embeddingMatch4.getCardRecord().getSet().length());
                            EmbeddingMatch embeddingMatch5 = embeddingMatch4;
                            if (1.0d - (d8 / ((double) iMax)) > 0.7d) {
                                d7 += d3;
                            }
                            list3 = list4;
                            embeddingMatch4 = embeddingMatch5;
                            z = true;
                            r66 = list4;
                        }
                        try {
                            List<String> list5 = list3;
                            EmbeddingMatch embeddingMatch6 = embeddingMatch4;
                            Iterator<String> it6 = this.cardNumberDetections.iterator();
                            while (true) {
                                if (!it6.hasNext()) {
                                    d4 = AudioStats.AUDIO_AMPLITUDE_NONE;
                                    break;
                                }
                                String next3 = it6.next();
                                if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                                    Log.d("AccumulatedAnalysis", "Checking card number: " + next3 + " against match: " + embeddingMatch6.getCardRecord().getNumber());
                                }
                                String strNormalizeCardNumber = normalizeCardNumber(next3);
                                if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                                    Log.d("AccumulatedAnalysis", "Normalized card number: " + strNormalizeCardNumber);
                                }
                                if (StringsKt.equals(strNormalizeCardNumber, embeddingMatch6.getCardRecord().getNumber(), true)) {
                                    if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                                        Log.d("AccumulatedAnalysis", "Boosting score for: " + strNormalizeCardNumber);
                                    }
                                    d4 = d3;
                                }
                            }
                            if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                                Log.d("AccumulatedAnalysis", "Set score: " + d7 + ", Card number score: " + d4 + " for match: " + embeddingMatch6.getCardRecord().getTitle() + " / " + embeddingMatch6.getCardRecord().getNumber());
                            }
                            if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                                it = it4;
                                Log.d("AccumulatedAnalysis", "New combined score for match: " + embeddingMatch6.getCardRecord().getTitle() + " is " + (embeddingMatch6.getCombinedScore() + d7 + d4));
                            } else {
                                it = it4;
                            }
                            arrayList10.add(EmbeddingMatch.copy$default(embeddingMatch6, null, null, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null, 0L, null, false, null, AudioStats.AUDIO_AMPLITUDE_NONE, embeddingMatch6.getCombinedScore() + d7 + d4 + d5, 1023, null));
                            list2 = list5;
                            it4 = it;
                            z = true;
                            r65 = list5;
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                    List<String> list6 = list2;
                    ArrayList<EmbeddingMatch> arrayList11 = arrayList10;
                    ArrayList arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList11, 10));
                    for (EmbeddingMatch embeddingMatch7 : arrayList11) {
                        String lowerCase3 = embeddingMatch7.getCardRecord().getSet().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                        if (Intrinsics.areEqual(lowerCase3, "plst")) {
                            if (embeddingMatch7.getHasPListStamp()) {
                                d2 = this.PLIST_SCORE_BOOST;
                                if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                                    Log.d("AccumulatedAnalysis", "PLIST stamp detected for " + embeddingMatch7.getCardRecord().getTitle() + " / plst, boosting score by " + this.PLIST_SCORE_BOOST);
                                }
                            } else {
                                d2 = this.PLIST_SCORE_PENALTY;
                                if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                                    Log.d("AccumulatedAnalysis", "No PLIST stamp detected for " + embeddingMatch7.getCardRecord().getTitle() + " / plst, penalizing score by " + this.PLIST_SCORE_PENALTY);
                                }
                            }
                            d = d2;
                        } else {
                            d = AudioStats.AUDIO_AMPLITUDE_NONE;
                        }
                        if (StringsKt.endsWith(embeddingMatch7.getCardRecord().getNumber(), "z", false)) {
                            d += this.SERIALIZED_CARD_PENALTY;
                            if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                                Log.d("AccumulatedAnalysis", "Serialized card detected: " + embeddingMatch7.getCardRecord().getTitle() + " (" + embeddingMatch7.getCardRecord().getSet() + DomExceptionUtils.SEPARATOR + embeddingMatch7.getCardRecord().getNumber() + "), penalizing score by " + this.SERIALIZED_CARD_PENALTY);
                            }
                        }
                        arrayList12.add(EmbeddingMatch.copy$default(embeddingMatch7, null, null, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null, 0L, null, false, null, AudioStats.AUDIO_AMPLITUDE_NONE, embeddingMatch7.getCombinedScore() + d, 1023, null));
                    }
                    ArrayList<EmbeddingMatch> arrayList13 = arrayList12;
                    if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                        Log.d("AccumulatedAnalysis", "---------------------------------------------------------");
                        Log.d("AccumulatedAnalysis", "Top matches combined scores:");
                        for (EmbeddingMatch embeddingMatch8 : arrayList13) {
                            String title = embeddingMatch8.getCardRecord().getTitle();
                            String set2 = embeddingMatch8.getCardRecord().getSet();
                            String number = embeddingMatch8.getCardRecord().getNumber();
                            String border_color = embeddingMatch8.getCardRecord().getBorder_color();
                            if (border_color == null) {
                                border_color = "unknown";
                            }
                            String str3 = border_color;
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String str4 = String.format("%.3f", Arrays.copyOf(new Object[]{Double.valueOf(embeddingMatch8.getSimilarity())}, 1));
                            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                            String str5 = String.format("%.3f", Arrays.copyOf(new Object[]{Double.valueOf(embeddingMatch8.getSetSymbolSimilarity())}, 1));
                            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                            String str6 = String.format("%.3f", Arrays.copyOf(new Object[]{Double.valueOf(embeddingMatch8.getCombinedScore())}, 1));
                            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                            Log.d("AccumulatedAnalysis", "Print: " + title + " (" + set2 + DomExceptionUtils.SEPARATOR + number + ") - border = " + str3 + " - Embedding: " + str4 + ", SetSymbol: " + str5 + ", CombinedScore: " + str6);
                        }
                        Log.d("AccumulatedAnalysis", "---------------------------------------------------------");
                    }
                    Iterator it7 = arrayList13.iterator();
                    if (it7.hasNext()) {
                        next = it7.next();
                        if (it7.hasNext()) {
                            double combinedScore = ((EmbeddingMatch) next).getCombinedScore();
                            do {
                                Object next4 = it7.next();
                                double combinedScore2 = ((EmbeddingMatch) next4).getCombinedScore();
                                if (Double.compare(combinedScore, combinedScore2) < 0) {
                                    next = next4;
                                    combinedScore = combinedScore2;
                                }
                            } while (it7.hasNext());
                        }
                    } else {
                        next = null;
                    }
                    EmbeddingMatch embeddingMatch9 = (EmbeddingMatch) next;
                    if (embeddingMatch9 == null) {
                        if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                            Log.d("AccumulatedAnalysis", "No valid TOP match found - THIS IS A PROBLEM");
                        }
                        resetAccumulatedDetections();
                        this.processing = false;
                        return;
                    }
                    final List listFlatten = CollectionsKt.flatten(groupSimilarTitles(this.titleDetections).values());
                    List listSortedWith2 = CollectionsKt.sortedWith(MapsKt.toList(GroupingKt.eachCount(new Grouping<String, String>() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$analyzeAccumulatedDetectionsWithIndividualPrints$lambda$0$$inlined$groupingBy$1
                        @Override // kotlin.collections.Grouping
                        public String keyOf(String element) {
                            return element;
                        }

                        @Override // kotlin.collections.Grouping
                        public Iterator<String> sourceIterator() {
                            return listFlatten.iterator();
                        }
                    })), new Comparator() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$analyzeAccumulatedDetectionsWithIndividualPrints$lambda$0$$inlined$sortedByDescending$2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues((Integer) ((Pair) t2).getSecond(), (Integer) ((Pair) t).getSecond());
                        }
                    });
                    ArrayList arrayList14 = new ArrayList();
                    for (Object obj2 : listSortedWith2) {
                        if (((Number) ((Pair) obj2).getSecond()).intValue() >= 1) {
                            arrayList14.add(obj2);
                        }
                    }
                    List listTake = CollectionsKt.take(arrayList14, 5);
                    ArrayList arrayList15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listTake, 10));
                    Iterator it8 = listTake.iterator();
                    while (it8.hasNext()) {
                        arrayList15.add((String) ((Pair) it8.next()).getFirst());
                    }
                    ArrayList arrayList16 = arrayList15;
                    if (arrayList16.isEmpty()) {
                        if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                            Log.d("AccumulatedAnalysis", "No valid title detections found - using art match only");
                        }
                        playDebugSound2();
                        this.onCardDetected.invoke(embeddingMatch9.getCardRecord().getOracle_id(), embeddingMatch9.getCardRecord().getScryfall_id(), embeddingMatch9.getCardRecord().getTitle(), embeddingMatch9.getCardRecord().getSet(), embeddingMatch9.getCardRecord().getNumber(), Integer.valueOf(embeddingMatch9.getCardRecord().getFace()), embeddingMatch9.getCardRecord().getLang());
                        this.lastDetectedOracleID = embeddingMatch9.getCardRecord().getOracle_id();
                        this.lastDetectedEmbedding = this.currentArtworkEmbedding;
                        if (this.continuousMode) {
                            this.lastCardDetectionTime = System.currentTimeMillis();
                            this.isWaitingForNewCard = true;
                            this.targetProcessingInterval = 100L;
                            this.maxObservedSharpness = AudioStats.AUDIO_AMPLITUDE_NONE;
                            this.sharpnessHistory.clear();
                            this.stableFrameCounter = 0;
                            this.runningAvgSharpness = AudioStats.AUDIO_AMPLITUDE_NONE;
                            this.sharpnessCount = 0;
                            this.lastProcessedFrameTime = 0L;
                            this.sameDetectionCounter = 0;
                            this.processing = false;
                            this.lockedIn = false;
                            this.firstBeepPlayed = false;
                        } else {
                            this.isPaused = true;
                        }
                        resetAccumulatedDetections();
                        onSuccessfulScan();
                        return;
                    }
                    String language = "en";
                    String scryfallId = embeddingMatch9.getScryfallId();
                    String set3 = embeddingMatch9.getCardRecord().getSet();
                    int face = embeddingMatch9.getFace();
                    String number2 = embeddingMatch9.getCardRecord().getNumber();
                    List<TitleComparison> listCompareOcrWithCard = compareOcrWithCard(arrayList16, embeddingMatch9.getOracleId(), embeddingMatch9.getFace());
                    CardRecord cardByScryFallId = this.dbHelper.getCardByScryFallId(scryfallId, face);
                    if (cardByScryFallId == null) {
                        cardByScryFallId = this.dbHelper.getCardByOracleIdAndOptionalPrintData(embeddingMatch9.getOracleId(), face, set3, number2);
                    }
                    if (!listCompareOcrWithCard.isEmpty()) {
                        TitleComparison titleComparison = (TitleComparison) CollectionsKt.first((List) listCompareOcrWithCard);
                        if (!Intrinsics.areEqual(titleComparison.getLanguage(), "en") && !Intrinsics.areEqual(set3, "plst")) {
                            language = titleComparison.getLanguage();
                            Iterator<MTGDBHelperLocalized> it9 = this.dbHelpers.iterator();
                            while (true) {
                                if (!it9.hasNext()) {
                                    break;
                                }
                                MTGDBHelperLocalized next5 = it9.next();
                                if (next5.isValid() && Intrinsics.areEqual(next5.getLocale(), language) && (cardByOracleIdAndOptionalPrintData = next5.getCardByOracleIdAndOptionalPrintData(embeddingMatch9.getOracleId(), face, set3, number2)) != null) {
                                    cardByScryFallId = cardByOracleIdAndOptionalPrintData;
                                    break;
                                }
                            }
                        }
                    }
                    if (cardByScryFallId == null) {
                        if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                            Log.d("AccumulatedAnalysis", "------->>>>>>>>>>> UNABLE TO FIND FINAL CARD MATCH !!!!!");
                        }
                        this.processing = false;
                        resetAccumulatedDetections();
                        Unit unit = Unit.INSTANCE;
                        return;
                    }
                    if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                        String title2 = cardByScryFallId.getTitle();
                        String set4 = cardByScryFallId.getSet();
                        String number3 = cardByScryFallId.getNumber();
                        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                        String str7 = String.format("%.3f", Arrays.copyOf(new Object[]{Double.valueOf(embeddingMatch9.getCombinedScore())}, 1));
                        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                        Log.d("AccumulatedAnalysis", "FINAL PRINT MATCH: " + title2 + " (" + set4 + DomExceptionUtils.SEPARATOR + number3 + ") - Language: " + language + ", Final Score: " + str7);
                    }
                    playDebugSound2();
                    this.onCardDetected.invoke(cardByScryFallId.getOracle_id(), cardByScryFallId.getScryfall_id(), cardByScryFallId.getTitle(), cardByScryFallId.getSet(), cardByScryFallId.getNumber(), Integer.valueOf(cardByScryFallId.getFace()), cardByScryFallId.getLang());
                    this.lastDetectedOracleID = embeddingMatch9.getCardRecord().getOracle_id();
                    this.lastDetectedEmbedding = this.currentArtworkEmbedding;
                    if (this.continuousMode) {
                        this.lastCardDetectionTime = System.currentTimeMillis();
                        this.isWaitingForNewCard = true;
                        this.targetProcessingInterval = 100L;
                        this.maxObservedSharpness = AudioStats.AUDIO_AMPLITUDE_NONE;
                        this.sharpnessHistory.clear();
                        this.stableFrameCounter = 0;
                        this.runningAvgSharpness = AudioStats.AUDIO_AMPLITUDE_NONE;
                        this.sharpnessCount = 0;
                        this.lastProcessedFrameTime = 0L;
                        this.sameDetectionCounter = 0;
                        this.processing = false;
                        this.lockedIn = false;
                        this.firstBeepPlayed = false;
                    } else {
                        this.isPaused = true;
                    }
                    resetAccumulatedDetections();
                    onSuccessfulScan();
                    return;
                }
                if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                    Log.d("AccumulatedAnalysis", "----> No print candidates (embeddings) found");
                }
                this.processing = false;
            } catch (Throwable th2) {
                th = th2;
                r6 = list;
            }
        }
    }

    private final void analyzeInternal(final ImageProxy imageProxy) {
        if (this.isPaused || this.processing || this.lockedIn) {
            imageProxy.close();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.lastProcessedFrameTime;
        Object objMeasureTimeForResult = UtilsKt.measureTimeForResult(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return imageProxy.toBitmap();
            }
        }, "-------->>>>>>> CombinedAnalyzer::analyze() - toBitmap()");
        Intrinsics.checkNotNullExpressionValue(objMeasureTimeForResult, "measureTimeForResult(...)");
        Bitmap bitmap = (Bitmap) objMeasureTimeForResult;
        try {
            analyzeInternalWithBitmap(bitmap, imageProxy, jCurrentTimeMillis, j);
        } finally {
            bitmap.recycle();
            imageProxy.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x032a  */
    /* JADX WARN: Type inference failed for: r0v41, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v11, types: [T, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void analyzeInternalWithBitmap(final Bitmap bitmap, ImageProxy imageProxy, long currentTime, long timeSinceLastProcessed) {
        String str;
        String str2;
        double d;
        boolean z;
        double d2;
        boolean z2;
        boolean z3;
        BorderColorResult borderColorResult;
        float[] fArr;
        double dDoubleValue = ((Number) UtilsKt.measureTimeForResult(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Double.valueOf(this.f$0.getSharpness(bitmap));
            }
        }, "-------->>>>>>> CombinedAnalyzer::analyze() - getSharpness()")).doubleValue();
        this.maxObservedSharpness = Math.max(dDoubleValue, this.maxObservedSharpness * 0.99d);
        this.sharpnessHistory.add(Double.valueOf(dDoubleValue));
        if (this.sharpnessHistory.size() > 10) {
            this.sharpnessHistory.removeFirst();
        }
        int i = this.sharpnessCount;
        if (i == 0) {
            this.runningAvgSharpness = dDoubleValue;
        } else {
            double d3 = this.runningAvgSharpness;
            double d4 = this.SHARPNESS_WEIGHT;
            this.runningAvgSharpness = (d3 * (1.0d - d4)) + (d4 * dDoubleValue);
        }
        this.sharpnessCount = i + 1;
        double dCalculateRecentVariation = this.sharpnessHistory.size() >= 3 ? calculateRecentVariation(CollectionsKt.toList(this.sharpnessHistory)) : AudioStats.AUDIO_AMPLITUDE_NONE;
        double dMax = Math.max(this.minSharpnessThreshold, this.deviceRelativeThreshold * this.maxObservedSharpness);
        boolean z4 = dDoubleValue >= dMax;
        boolean z5 = dCalculateRecentVariation < 0.2d;
        boolean z6 = z4;
        boolean z7 = timeSinceLastProcessed >= this.targetProcessingInterval;
        if (z6 && z5) {
            int i2 = this.stableFrameCounter;
            this.stableFrameCounter = i2 + 1;
            Integer.valueOf(i2);
        } else {
            this.stableFrameCounter = 0;
            Unit unit = Unit.INSTANCE;
        }
        if (CombinedAnalyzerKt.getDEBUG_LOG()) {
            z = z7;
            int i3 = this.stableFrameCounter;
            str = "%";
            int i4 = this.requiredStableFrames;
            str2 = "--->Card Classification";
            StringBuilder sbAppend = new StringBuilder("Frame: sharpness=").append(dDoubleValue).append(", threshold=").append(dMax).append(", variation=");
            d = dMax;
            d2 = dCalculateRecentVariation;
            Log.d(TAG, sbAppend.append(d2).append(", stable=").append(z5).append(", stableCounter=").append(i3).append(DomExceptionUtils.SEPARATOR).append(i4).append(", time=").append(timeSinceLastProcessed).append("ms").toString());
        } else {
            str = "%";
            str2 = "--->Card Classification";
            d = dMax;
            z = z7;
            d2 = dCalculateRecentVariation;
        }
        int i5 = this.stableFrameCounter;
        int i6 = this.requiredStableFrames;
        if (i5 < i6 || !z) {
            if (!z6) {
                if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                    Log.d(TAG, "Skipping blurry frame: sharpness = " + dDoubleValue + " vs threshold = " + d);
                    return;
                }
                return;
            } else if (!z5) {
                if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                    Log.d(TAG, "Skipping unstable frame: variation = " + d2);
                    return;
                }
                return;
            } else {
                if (i5 >= i6 || !CombinedAnalyzerKt.getDEBUG_LOG()) {
                    return;
                }
                Log.d(TAG, "Waiting for more stable frames: " + this.stableFrameCounter + DomExceptionUtils.SEPARATOR + this.requiredStableFrames);
                return;
            }
        }
        this.stableFrameCounter = 0;
        this.lastProcessedFrameTime = currentTime;
        final int rotationDegrees = imageProxy.getImageInfo().getRotationDegrees();
        final CardSegmentation cardSegmentation = (CardSegmentation) UtilsKt.measureTimeForResult(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.cardDetector.detectCard(bitmap, rotationDegrees);
            }
        }, "-------->>>>>>> CombinedAnalyzer::analyze() - DETECT CARD TOTAL TIME");
        if (cardSegmentation == null || !this.firstFrameSkipped) {
            if (cardSegmentation != null) {
                this.firstFrameSkipped = true;
                if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                    Log.d(TAG, "-----------------------------------------------------------------------------");
                    Log.d(TAG, "      First frame with card detected, skipping until next detection");
                    Log.d(TAG, "-----------------------------------------------------------------------------");
                }
                this.targetProcessingInterval = 5L;
                return;
            }
            if (CombinedAnalyzerKt.getDEBUG_VIEWFINDER()) {
                this.overlayView.updateCardDetection(null, this.cardDetector.getDebugPreprocessedBitmap(), this.cardDetector.getDebugMaskBitmap(), "No card", "", bitmap.getWidth(), bitmap.getHeight(), this.viewFinder.getWidth(), this.viewFinder.getHeight());
                return;
            } else {
                if (CombinedAnalyzerKt.getDEBUG_VIEWFINDER()) {
                    this.overlayView.updateCardDetection(null, this.cardDetector.getDebugPreprocessedBitmap(), this.cardDetector.getDebugMaskBitmap(), "No card", "", bitmap.getWidth(), bitmap.getHeight(), this.viewFinder.getWidth(), this.viewFinder.getHeight());
                    return;
                }
                return;
            }
        }
        if (!this.firstBeepPlayed) {
            playDebugSound1();
            this.firstBeepPlayed = true;
        }
        this.targetProcessingInterval = 5L;
        final Bitmap cardBitmap = cardSegmentation.getCardBitmap();
        Intrinsics.checkNotNull(cardBitmap);
        SimilaritySearchResult similaritySearchResult = (SimilaritySearchResult) UtilsKt.measureTimeForResult(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.getCardEmbeddings().findSimilarCards(cardBitmap, 40);
            }
        }, "-------->>>>>>> CombinedAnalyzer::analyze() - findSimilarCards()");
        float[] queryEmbedding = similaritySearchResult.getQueryEmbedding();
        List mutableList = CollectionsKt.toMutableList((Collection) similaritySearchResult.getMatches());
        if (mutableList.isEmpty()) {
            if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                Log.d(TAG, "No similar cards found in the database.");
            }
            recycleSegmentationBitmaps(cardSegmentation);
            this.targetProcessingInterval = 1500L;
            this.discardedAttempts++;
            return;
        }
        int i7 = this.discardedAttempts;
        float f = i7 >= 4 ? 0.45f : i7 >= 2 ? 0.5f : 0.55f;
        ArrayList arrayList = new ArrayList();
        for (Object obj : mutableList) {
            if (((SimilarCard) obj).getSimilarity() >= f) {
                arrayList.add(obj);
            }
        }
        final List mutableList2 = CollectionsKt.toMutableList((Collection) arrayList);
        if (!mutableList.isEmpty() && mutableList2.isEmpty()) {
            recycleSegmentationBitmaps(cardSegmentation);
            this.targetProcessingInterval = 1500L;
            this.discardedAttempts++;
            return;
        }
        if (this.continuousMode && this.isWaitingForNewCard) {
            if ((currentTime - this.lastCardDetectionTime) / 1000.0d < this.cooldownPeriod) {
                recycleSegmentationBitmaps(cardSegmentation);
                this.processing = false;
                return;
            }
            if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                Log.d(TAG, "Continuous mode: resuming card detection...");
            }
            if (!mutableList2.isEmpty()) {
                SimilarCard similarCard = (SimilarCard) CollectionsKt.first(mutableList2);
                CardRecord cardByScryFallId = this.dbHelper.getCardByScryFallId(similarCard.getScryfallId(), similarCard.getFace());
                if (cardByScryFallId != null) {
                    if (Intrinsics.areEqual(cardByScryFallId.getLayout(), "art_series") && mutableList2.size() > 1) {
                        SimilarCard similarCard2 = (SimilarCard) mutableList2.get(1);
                        CardRecord cardByScryFallId2 = this.dbHelper.getCardByScryFallId(similarCard2.getScryfallId(), similarCard2.getFace());
                        if (cardByScryFallId2 != null) {
                            cardByScryFallId = cardByScryFallId2;
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    Unit unit3 = Unit.INSTANCE;
                }
                if (cardByScryFallId != null) {
                    String str3 = this.lastDetectedOracleID;
                    if (str3 == null) {
                        str3 = "";
                    }
                    if (!Intrinsics.areEqual(cardByScryFallId.getOracle_id(), str3)) {
                        System.out.print((Object) "--->>> Different card detected, processing !");
                        this.isWaitingForNewCard = false;
                        recycleSegmentationBitmaps(cardSegmentation);
                        this.processing = false;
                        this.targetProcessingInterval = 100L;
                        return;
                    }
                    if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                        System.out.print((Object) "-------------------------------------------------------");
                        System.out.print((Object) "-----> Continuous mode: Same card detected, skipping...");
                        System.out.print((Object) "-------------------------------------------------------");
                    }
                    float[] fArr2 = this.lastDetectedEmbedding;
                    if (fArr2 != null) {
                        float fCosineSimilarity = cosineSimilarity(fArr2, queryEmbedding);
                        if (fCosineSimilarity < this.ARTWORK_SIMILARITY_THRESHOLD) {
                            Log.d(TAG, "---> Different artwork detected (similarity: " + fCosineSimilarity + ")");
                            this.isWaitingForNewCard = false;
                            recycleSegmentationBitmaps(cardSegmentation);
                            this.processing = false;
                            this.targetProcessingInterval = 100L;
                            return;
                        }
                    }
                    int i8 = this.sameDetectionCounter + 1;
                    this.sameDetectionCounter = i8;
                    if (i8 >= 4) {
                        BoundingBoxOverlayView.flashCardDetection$default(this.overlayView, cardSegmentation, bitmap.getWidth(), bitmap.getHeight(), this.viewFinder.getWidth(), this.viewFinder.getHeight(), false, 32, null);
                        this.onSameCardDetected.invoke();
                        this.sameDetectionCounter = 0;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.lastCardDetectionTime = System.currentTimeMillis();
                    Unit unit4 = Unit.INSTANCE;
                    Unit unit5 = Unit.INSTANCE;
                } else {
                    z2 = false;
                }
                z3 = false;
            }
        } else {
            z2 = false;
            z3 = true;
        }
        if (!z3) {
            if (!z2) {
            }
            this.processing = false;
            return;
        }
        this.overlayView.flashCardDetection(cardSegmentation, bitmap.getWidth(), bitmap.getHeight(), this.viewFinder.getWidth(), this.viewFinder.getHeight(), false);
        final Bitmap bitmap2 = (Bitmap) UtilsKt.measureTimeForResult(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.extractSetSymbolRegion(cardSegmentation.getCardBitmap());
            }
        }, "-------->>>>>>> CombinedAnalyzer::analyze() - extractSetSymbolRegion()");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (bitmap2 != null) {
            objectRef.element = UtilsKt.measureTimeForResult(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.getSetSymbolEmbeddings().generateSetSymbolEmbedding(bitmap2);
                }
            }, "-------->>>>>>> CombinedAnalyzer::analyze() - generateSetSymbolEmbedding()");
            if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                float[] fArr3 = (float[]) objectRef.element;
                Log.d(TAG, "Set symbol embedding generated: " + (fArr3 != null ? Integer.valueOf(fArr3.length) : null) + " dimensions");
            }
            cardSegmentation.setSetSymbolBitmap(bitmap2);
            Unit unit6 = Unit.INSTANCE;
        } else {
            Integer.valueOf(Log.w(TAG, "Failed to extract set symbol region"));
        }
        BorderColorResult borderColorResult2 = (BorderColorResult) UtilsKt.measureTimeForResult(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CombinedAnalyzer.analyzeInternalWithBitmap$lambda$8(cardSegmentation);
            }
        }, "-------->>>>>>> CombinedAnalyzer::analyze() - extractBorderColorFromCard()");
        if (CombinedAnalyzerKt.getDEBUG_LOG()) {
            BorderColor borderColor = borderColorResult2.getBorderColor();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str4 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(borderColorResult2.getConfidence())}, 1));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            borderColorResult = borderColorResult2;
            fArr = queryEmbedding;
            Log.d("BorderColor", "Detected border: " + borderColor + ", Confidence: " + str4 + ", HSV: H=" + borderColorResult2.getAvgHue() + ", S=" + borderColorResult2.getAvgSaturation() + ", V=" + borderColorResult2.getAvgBrightness());
        } else {
            borderColorResult = borderColorResult2;
            fArr = queryEmbedding;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Bitmap bitmap3 = (Bitmap) UtilsKt.measureTimeForResult(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.extractPListStampRegion(cardSegmentation.getCardBitmap());
            }
        }, "-------->>>>>>> CombinedAnalyzer::analyze() - extractPListStampRegion()");
        if (bitmap3 != null) {
            cardSegmentation.setPListBitmap(bitmap3);
        }
        PlistDetectionResult plistDetectionResult = (PlistDetectionResult) UtilsKt.measureTimeForResult(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.plistDetector.detectPlist(cardBitmap, false);
            }
        }, "-------->>>>>>> CombinedAnalyzer::analyze() - detectPlist()");
        if (plistDetectionResult != null) {
            booleanRef.element = plistDetectionResult.getHasPlist();
            Log.d("PLIST", "PLIST stamp detection: " + plistDetectionResult.getHasPlist() + ", Confidence: " + plistDetectionResult.getConfidence());
        }
        final float[] fArr4 = fArr;
        final BorderColorResult borderColorResult3 = borderColorResult;
        UtilsKt.measureTime(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CombinedAnalyzer.analyzeInternalWithBitmap$lambda$11(this.f$0, mutableList2, fArr4, objectRef, booleanRef, borderColorResult3);
            }
        }, "-------->>>>>>> CombinedAnalyzer::analyze() - storeEmbeddingMatchesWithSetSymbolEmbedding()");
        if (this.storedEmbeddingMatches.isEmpty()) {
            return;
        }
        int i9 = this.ocrCounter + 1;
        this.ocrCounter = i9;
        if (i9 >= this.maxOcrDetections) {
            this.lockedIn = true;
        }
        try {
            final CardClassifier.ClassificationResult classificationResult = (CardClassifier.ClassificationResult) UtilsKt.measureTimeForResult(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.cardClassifier.classify(cardSegmentation.getCardBitmap());
                }
            }, "-------->>>>>>> CombinedAnalyzer::analyze() - classify()");
            if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                String str5 = str2;
                Log.d(str5, "Card Type: " + classificationResult.getClassLabel());
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str6 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(classificationResult.getConfidence() * 100.0f)}, 1));
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                String str7 = str;
                Log.d(str5, "Confidence: " + str6 + str7);
                for (Map.Entry<String, Float> entry : classificationResult.getAllProbabilities().entrySet()) {
                    String key = entry.getKey();
                    float fFloatValue = entry.getValue().floatValue();
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    String str8 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(fFloatValue * 100.0f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                    Log.d("Probabilities", key + ": " + str8 + str7);
                }
            }
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = UtilsKt.measureTimeForResult(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CardSegmentation.copy$default(cardSegmentation, 0.0f, null, null, null, null, classificationResult.getClassLabel(), 0L, null, null, null, null, 2015, null);
                }
            }, "-------->>>>>>> CombinedAnalyzer::analyze() - copy()");
            if (((CardSegmentation) objectRef2.element).getCardBitmap() != null) {
                if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                    Log.d("Title Detection", "Extracting title region...");
                }
                final Bitmap bitmap4 = (Bitmap) UtilsKt.measureTimeForResult(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        CombinedAnalyzer combinedAnalyzer = this.f$0;
                        Ref.ObjectRef objectRef3 = objectRef2;
                        return combinedAnalyzer.extractTitleRegion(((CardSegmentation) objectRef3.element).getCardBitmap(), ((CardSegmentation) objectRef3.element).getCardType());
                    }
                }, "-------->>>>>>> CombinedAnalyzer::analyze() - extractTitleRegion()");
                if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                    Log.d("Bottom Text Detection", "Extracting bottom text region...");
                }
                final Bitmap bitmap5 = (Bitmap) UtilsKt.measureTimeForResult(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        CombinedAnalyzer combinedAnalyzer = this.f$0;
                        Ref.ObjectRef objectRef3 = objectRef2;
                        return combinedAnalyzer.extractBottomLeftRegion(((CardSegmentation) objectRef3.element).getCardBitmap(), ((CardSegmentation) objectRef3.element).getCardType());
                    }
                }, "-------->>>>>>> CombinedAnalyzer::analyze() - extractBottomLeftRegion()");
                this.ocrStartTime = System.currentTimeMillis();
                if (bitmap4 != null) {
                    if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                        Log.d("Title Detection", "Detecting text...");
                    }
                    UtilsKt.measureTime(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CombinedAnalyzer.analyzeInternalWithBitmap$lambda$17(this.f$0, bitmap4);
                        }
                    }, "-------->>>>>>> CombinedAnalyzer::analyze() - detectTitleText()");
                    if (CombinedAnalyzerKt.getDEBUG_VIEWFINDER()) {
                        ((CardSegmentation) objectRef2.element).setTitleRegionBitmap(bitmap4);
                    }
                }
                if (bitmap5 != null) {
                    if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                        Log.d("Bottom Text Detection", "Detecting bottom text...");
                    }
                    UtilsKt.measureTime(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CombinedAnalyzer.analyzeInternalWithBitmap$lambda$18(this.f$0, bitmap5);
                        }
                    }, "-------->>>>>>> CombinedAnalyzer::analyze() - detectSetCodeAndNumber()");
                    if (CombinedAnalyzerKt.getDEBUG_VIEWFINDER()) {
                        ((CardSegmentation) objectRef2.element).setBottomTextRegionBitmap(bitmap5);
                    }
                }
            }
            if (CombinedAnalyzerKt.getDEBUG_VIEWFINDER()) {
                this.overlayView.updateCardDetection((CardSegmentation) objectRef2.element, this.cardDetector.getDebugPreprocessedBitmap(), this.cardDetector.getDebugMaskBitmap(), "", ((CardSegmentation) objectRef2.element).getCardType(), bitmap.getWidth(), bitmap.getHeight(), this.viewFinder.getWidth(), this.viewFinder.getHeight());
            }
        } catch (Exception e) {
            Log.e("Card Classification", "Error classifying card", e);
        } finally {
            recycleSegmentationBitmaps(cardSegmentation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final Unit analyzeInternalWithBitmap$lambda$11(CombinedAnalyzer combinedAnalyzer, List list, float[] fArr, Ref.ObjectRef objectRef, Ref.BooleanRef booleanRef, BorderColorResult borderColorResult) {
        combinedAnalyzer.storeEmbeddingMatchesWithSetSymbolEmbedding(list, fArr, (float[]) objectRef.element, booleanRef.element, borderColorResult.getBorderColor());
        return Unit.INSTANCE;
    }

    static final Unit analyzeInternalWithBitmap$lambda$17(CombinedAnalyzer combinedAnalyzer, Bitmap bitmap) {
        combinedAnalyzer.detectTitleText(bitmap, !CombinedAnalyzerKt.getDEBUG_VIEWFINDER());
        return Unit.INSTANCE;
    }

    static final Unit analyzeInternalWithBitmap$lambda$18(CombinedAnalyzer combinedAnalyzer, Bitmap bitmap) {
        combinedAnalyzer.detectSetCodeAndNumber(bitmap, !CombinedAnalyzerKt.getDEBUG_VIEWFINDER());
        return Unit.INSTANCE;
    }

    static final BorderColorResult analyzeInternalWithBitmap$lambda$8(CardSegmentation cardSegmentation) {
        Bitmap cardBitmap = cardSegmentation.getCardBitmap();
        Intrinsics.checkNotNull(cardBitmap);
        return MTGBorderColorDetectorKt.extractBorderColorFromCard(cardBitmap);
    }

    private final double calculateRecentVariation(List<Double> values) {
        int size = values.size();
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (size < 2) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        List listTakeLast = CollectionsKt.takeLast(values, 3);
        List list = listTakeLast;
        double dAverageOfDouble = CollectionsKt.averageOfDouble(list);
        if (dAverageOfDouble == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            double dDoubleValue = ((Number) it.next()).doubleValue() - dAverageOfDouble;
            d += dDoubleValue * dDoubleValue;
        }
        return Math.sqrt(d / ((double) listTakeLast.size())) / dAverageOfDouble;
    }

    private final double calculateTitleSimilarity(String title1, String title2) {
        String str = title1;
        int length = str.length();
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (length != 0) {
            String str2 = title2;
            if (str2.length() != 0) {
                if (Intrinsics.areEqual(title1, title2)) {
                    return 1.0d;
                }
                double dLevenshteinDistance = 1.0d - (((double) levenshteinDistance(title1, title2)) / ((double) Math.max(title1.length(), title2.length())));
                List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList();
                for (Object obj : listSplit$default) {
                    if (((String) obj).length() > 0) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = arrayList;
                List listSplit$default2 = StringsKt.split$default((CharSequence) str2, new String[]{" "}, false, 0, 6, (Object) null);
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : listSplit$default2) {
                    if (((String) obj2).length() > 0) {
                        arrayList3.add(obj2);
                    }
                }
                ArrayList arrayList4 = arrayList3;
                int size = CollectionsKt.intersect(arrayList2, CollectionsKt.toSet(arrayList4)).size();
                int iMax = Math.max(arrayList2.size(), arrayList4.size());
                if (iMax > 0) {
                    d = ((double) size) / ((double) iMax);
                }
                return (dLevenshteinDistance * 0.7d) + (d * 0.3d);
            }
        }
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private final void checkAndAnalyzeResults() {
        if (this.titleDetectionCounter < this.maxTitleDetections || this.bottomDetectionCounter < this.maxBottomDetections) {
            return;
        }
        UtilsKt.measureTimeForResult(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CombinedAnalyzer.checkAndAnalyzeResults$lambda$0(this.f$0);
            }
        }, "-------->>>>>>> CombinedAnalyzer::analyzeAccumulatedDetections() - total time");
    }

    static final Unit checkAndAnalyzeResults$lambda$0(CombinedAnalyzer combinedAnalyzer) throws Throwable {
        Log.d("Card Accumulator", "-------->>>>>>> TOTAL OCR processing time: " + (System.currentTimeMillis() - combinedAnalyzer.ocrStartTime) + "ms");
        combinedAnalyzer.analyzeAccumulatedDetectionsWithIndividualPrints();
        return Unit.INSTANCE;
    }

    private final List<TitleComparison> compareOcrWithCard(List<String> detectedTitles, String oracleId, int face) {
        ArrayList arrayList = new ArrayList();
        CardRecord cardByOracleIdAndOptionalPrintData$default = MTGDBHelper.getCardByOracleIdAndOptionalPrintData$default(this.dbHelper, oracleId, face, null, null, 12, null);
        if (cardByOracleIdAndOptionalPrintData$default == null) {
            if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                Log.w("TitleComparison", "Could not find card with oracle_id: " + oracleId + " and face: " + face);
            }
            return arrayList;
        }
        String strCleanTitle = cleanTitle(cardByOracleIdAndOptionalPrintData$default.getTitle());
        Iterator<T> it = detectedTitles.iterator();
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        while (it.hasNext()) {
            double dCalculateTitleSimilarity = calculateTitleSimilarity(cleanTitle((String) it.next()), strCleanTitle);
            if (dCalculateTitleSimilarity > d) {
                d = dCalculateTitleSimilarity;
            }
        }
        arrayList.add(new TitleComparison("en", d));
        if (CombinedAnalyzerKt.getDEBUG_LOG()) {
            Log.d("TitleComparison", "Oracle: " + oracleId + ", Lang: en, Title: '" + cardByOracleIdAndOptionalPrintData$default.getTitle() + "', Best Similarity: " + d);
        }
        for (MTGDBHelperLocalized mTGDBHelperLocalized : this.dbHelpers) {
            if (mTGDBHelperLocalized.isValid()) {
                try {
                    CardRecord cardByOracleIdAndOptionalPrintData$default2 = MTGDBHelperLocalized.getCardByOracleIdAndOptionalPrintData$default(mTGDBHelperLocalized, cardByOracleIdAndOptionalPrintData$default.getOracle_id(), cardByOracleIdAndOptionalPrintData$default.getFace(), null, null, 12, null);
                    if (cardByOracleIdAndOptionalPrintData$default2 != null) {
                        String strCleanTitle2 = cleanTitle(cardByOracleIdAndOptionalPrintData$default2.getTitle());
                        Iterator<T> it2 = detectedTitles.iterator();
                        double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                        while (it2.hasNext()) {
                            double dCalculateTitleSimilarity2 = calculateTitleSimilarity(cleanTitle((String) it2.next()), strCleanTitle2);
                            if (dCalculateTitleSimilarity2 > d2) {
                                d2 = dCalculateTitleSimilarity2;
                            }
                        }
                        arrayList.add(new TitleComparison(mTGDBHelperLocalized.getLocale(), d2));
                        if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                            Log.d("TitleComparison", "Oracle: " + oracleId + ", Lang: " + mTGDBHelperLocalized.getLocale() + ", Title: '" + cardByOracleIdAndOptionalPrintData$default2.getTitle() + "', Best Similarity: " + d2);
                        }
                    }
                } catch (Exception e) {
                    Log.e("TitleComparison", "Error comparing title for oracle_id " + oracleId + " in language " + mTGDBHelperLocalized.getLocale() + ": " + e.getMessage());
                }
            }
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$compareOcrWithCard$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Double.valueOf(((TitleComparison) t2).getSimilarity()), Double.valueOf(((TitleComparison) t).getSimilarity()));
            }
        });
    }

    private final float cosineSimilarity(float[] a2, float[] b) {
        float f = 0.0f;
        if (a2.length != b.length) {
            return 0.0f;
        }
        int length = a2.length;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i = 0; i < length; i++) {
            float f4 = a2[i];
            float f5 = b[i];
            f += f4 * f5;
            f2 += f4 * f4;
            f3 += f5 * f5;
        }
        return f / (((float) Math.sqrt(f2)) * ((float) Math.sqrt(f3)));
    }

    private final void detectSetCodeAndNumber(final Bitmap bottomLeftBitmap, final boolean shouldRecycleBitmap) {
        if (this.isCleanedUp || this.isPaused || this.processing) {
            if (shouldRecycleBitmap) {
                recycleBitmapSafely(bottomLeftBitmap);
            }
        } else {
            InputImage inputImageFromBitmap = InputImage.fromBitmap(bottomLeftBitmap, 0);
            Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap, "fromBitmap(...)");
            Task<Text> taskProcess = this.textRecognizer.process(inputImageFromBitmap);
            final Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CombinedAnalyzer.detectSetCodeAndNumber$lambda$0(this.f$0, shouldRecycleBitmap, bottomLeftBitmap, (Text) obj);
                }
            };
            taskProcess.addOnSuccessListener(new OnSuccessListener() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda11
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda21
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    CombinedAnalyzer.detectSetCodeAndNumber$lambda$2(this.f$0, shouldRecycleBitmap, bottomLeftBitmap, exc);
                }
            });
        }
    }

    static /* synthetic */ void detectSetCodeAndNumber$default(CombinedAnalyzer combinedAnalyzer, Bitmap bitmap, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        combinedAnalyzer.detectSetCodeAndNumber(bitmap, z);
    }

    static final Unit detectSetCodeAndNumber$lambda$0(CombinedAnalyzer combinedAnalyzer, boolean z, Bitmap bitmap, Text text) {
        if (combinedAnalyzer.isCleanedUp || combinedAnalyzer.isPaused || combinedAnalyzer.processing) {
            if (z) {
                combinedAnalyzer.recycleBitmapSafely(bitmap);
            }
            return Unit.INSTANCE;
        }
        Log.d("Card Accumulator", "-------->>>>>>> OCR processing time for bottom text: " + (System.currentTimeMillis() - combinedAnalyzer.ocrStartTime) + "ms");
        combinedAnalyzer.bottomDetectionCounter++;
        String text2 = text.getText();
        Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
        if (CombinedAnalyzerKt.getDEBUG_LOG()) {
            Log.d("Card Accumulator", "============================================================");
            Log.d("Card Accumulator", "Detected BOTTOM text: " + text2);
            Log.d("Card Accumulator", "============================================================");
        }
        CardInfo bottomText = combinedAnalyzer.parseBottomText(text2);
        String setCode = bottomText.getSetCode();
        String strNormalizeCardNumber = combinedAnalyzer.normalizeCardNumber(bottomText.getCardNumber());
        if (setCode.length() > 0) {
            setCode = combinedAnalyzer.validateAndCorrectSetCode(setCode);
        }
        synchronized (combinedAnalyzer.setCodeDetections) {
            if (!combinedAnalyzer.isCleanedUp && !combinedAnalyzer.isPaused && !combinedAnalyzer.processing) {
                if (setCode.length() > 0) {
                    combinedAnalyzer.setCodeDetections.add(setCode);
                    if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                        Log.d("Card Accumulator", "Added set code: " + ((Object) setCode) + " (" + combinedAnalyzer.setCodeDetections.size() + DomExceptionUtils.SEPARATOR + combinedAnalyzer.maxBottomDetections + ")");
                    }
                }
                if (strNormalizeCardNumber.length() > 0) {
                    combinedAnalyzer.cardNumberDetections.add(strNormalizeCardNumber);
                    if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                        Log.d("Card Accumulator", "Added card number: " + strNormalizeCardNumber + " (" + combinedAnalyzer.cardNumberDetections.size() + DomExceptionUtils.SEPARATOR + combinedAnalyzer.maxBottomDetections + ")");
                    }
                }
                if (setCode.length() > 0 || strNormalizeCardNumber.length() > 0) {
                    if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                        Log.d("Card Accumulator", "Detection counter: " + combinedAnalyzer.bottomDetectionCounter + DomExceptionUtils.SEPARATOR + combinedAnalyzer.maxBottomDetections);
                    }
                }
                combinedAnalyzer.checkAndAnalyzeResults();
                if (z) {
                    combinedAnalyzer.recycleBitmapSafely(bitmap);
                }
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            }
            if (z) {
                combinedAnalyzer.recycleBitmapSafely(bitmap);
            }
            return Unit.INSTANCE;
        }
    }

    static final void detectSetCodeAndNumber$lambda$2(CombinedAnalyzer combinedAnalyzer, boolean z, Bitmap bitmap, Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (!combinedAnalyzer.isCleanedUp) {
            Log.e(TAG, "Bottom text detection failed: " + e.getMessage());
        }
        combinedAnalyzer.bottomDetectionCounter++;
        combinedAnalyzer.checkAndAnalyzeResults();
        if (z) {
            combinedAnalyzer.recycleBitmapSafely(bitmap);
        }
    }

    private final void detectTitleText(final Bitmap titleBitmap, final boolean shouldRecycleBitmap) {
        if (this.isCleanedUp || this.isPaused || this.processing) {
            if (shouldRecycleBitmap) {
                recycleBitmapSafely(titleBitmap);
            }
        } else {
            InputImage inputImageFromBitmap = InputImage.fromBitmap(titleBitmap, 0);
            Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap, "fromBitmap(...)");
            Task<Text> taskProcess = this.textRecognizer.process(inputImageFromBitmap);
            final Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CombinedAnalyzer.detectTitleText$lambda$0(this.f$0, shouldRecycleBitmap, titleBitmap, (Text) obj);
                }
            };
            taskProcess.addOnSuccessListener(new OnSuccessListener() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda19
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda20
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    CombinedAnalyzer.detectTitleText$lambda$2(this.f$0, shouldRecycleBitmap, titleBitmap, exc);
                }
            });
        }
    }

    static /* synthetic */ void detectTitleText$default(CombinedAnalyzer combinedAnalyzer, Bitmap bitmap, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        combinedAnalyzer.detectTitleText(bitmap, z);
    }

    static final Unit detectTitleText$lambda$0(CombinedAnalyzer combinedAnalyzer, boolean z, Bitmap bitmap, Text text) {
        if (combinedAnalyzer.isCleanedUp || combinedAnalyzer.isPaused || combinedAnalyzer.processing) {
            if (z) {
                combinedAnalyzer.recycleBitmapSafely(bitmap);
            }
            return Unit.INSTANCE;
        }
        Log.d("Card Accumulator", "-------->>>>>>> OCR processing time for title: " + (System.currentTimeMillis() - combinedAnalyzer.ocrStartTime) + "ms");
        combinedAnalyzer.titleDetectionCounter++;
        String text2 = text.getText();
        Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
        if (CombinedAnalyzerKt.getDEBUG_LOG()) {
            Log.d("Card Accumulator", "============================================================");
            Log.d("Card Accumulator", "Detected TITLE text: " + text2);
            Log.d("Card Accumulator", "============================================================");
        }
        String string = StringsKt.trim((CharSequence) new Regex("\\s+").replace(new Regex("[0-9{}]").replace(text2, ""), " ")).toString();
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) string, "(", 0, false, 6, (Object) null);
        if (iIndexOf$default != -1) {
            String strSubstring = string.substring(0, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            string = StringsKt.trim((CharSequence) strSubstring).toString();
        }
        if (string.length() > 0) {
            synchronized (combinedAnalyzer.titleDetections) {
                if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                    Log.d("Card Accumulator", "Added title: " + ((Object) string) + " (" + combinedAnalyzer.titleDetections.size() + DomExceptionUtils.SEPARATOR + combinedAnalyzer.maxTitleDetections + ")");
                }
                combinedAnalyzer.titleDetections.add(string);
            }
        }
        combinedAnalyzer.checkAndAnalyzeResults();
        if (z) {
            combinedAnalyzer.recycleBitmapSafely(bitmap);
        }
        return Unit.INSTANCE;
    }

    static final void detectTitleText$lambda$2(CombinedAnalyzer combinedAnalyzer, boolean z, Bitmap bitmap, Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (!combinedAnalyzer.isCleanedUp) {
            Log.e(TAG, "Text detection failed: " + e.getMessage());
        }
        combinedAnalyzer.titleDetectionCounter++;
        combinedAnalyzer.checkAndAnalyzeResults();
        if (z) {
            combinedAnalyzer.recycleBitmapSafely(bitmap);
        }
    }

    private final CardEmbeddings getCardEmbeddings() {
        return (CardEmbeddings) this.cardEmbeddings.getValue();
    }

    private final SetSymbolEmbeddings getSetSymbolEmbeddings() {
        return (SetSymbolEmbeddings) this.setSymbolEmbeddings.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01cd A[Catch: all -> 0x02d7, TryCatch #25 {all -> 0x02d7, blocks: (B:118:0x01c4, B:120:0x01cd, B:139:0x0229, B:140:0x0242, B:123:0x01e0, B:125:0x01e6, B:128:0x01f5, B:130:0x01fb, B:134:0x020e, B:136:0x0214, B:138:0x021c), top: B:178:0x01c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01e0 A[Catch: all -> 0x02d7, TryCatch #25 {all -> 0x02d7, blocks: (B:118:0x01c4, B:120:0x01cd, B:139:0x0229, B:140:0x0242, B:123:0x01e0, B:125:0x01e6, B:128:0x01f5, B:130:0x01fb, B:134:0x020e, B:136:0x0214, B:138:0x021c), top: B:178:0x01c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01f5 A[Catch: all -> 0x02d7, TryCatch #25 {all -> 0x02d7, blocks: (B:118:0x01c4, B:120:0x01cd, B:139:0x0229, B:140:0x0242, B:123:0x01e0, B:125:0x01e6, B:128:0x01f5, B:130:0x01fb, B:134:0x020e, B:136:0x0214, B:138:0x021c), top: B:178:0x01c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01fb A[Catch: all -> 0x02d7, TryCatch #25 {all -> 0x02d7, blocks: (B:118:0x01c4, B:120:0x01cd, B:139:0x0229, B:140:0x0242, B:123:0x01e0, B:125:0x01e6, B:128:0x01f5, B:130:0x01fb, B:134:0x020e, B:136:0x0214, B:138:0x021c), top: B:178:0x01c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0214 A[Catch: all -> 0x02d7, TryCatch #25 {all -> 0x02d7, blocks: (B:118:0x01c4, B:120:0x01cd, B:139:0x0229, B:140:0x0242, B:123:0x01e0, B:125:0x01e6, B:128:0x01f5, B:130:0x01fb, B:134:0x020e, B:136:0x0214, B:138:0x021c), top: B:178:0x01c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02ef  */
    /* JADX WARN: Type inference failed for: r20v10 */
    /* JADX WARN: Type inference failed for: r20v11 */
    /* JADX WARN: Type inference failed for: r20v8 */
    /* JADX WARN: Type inference failed for: r20v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final double getSharpness(Bitmap bitmap) throws Throwable {
        Mat mat;
        Bitmap bitmap2;
        char c;
        Boolean bool;
        double d;
        Bitmap bitmapCreateScaledBitmap;
        Mat mat2;
        Mat mat3;
        Boolean bool2;
        Mat mat4;
        Boolean bool3;
        Mat mat5;
        Boolean bool4;
        String message;
        String message2;
        String message3;
        String str;
        String str2 = "cvtColor";
        Boolean bool5 = openCVAvailable;
        if (Intrinsics.areEqual((Object) bool5, (Object) false)) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        if (bool5 == null) {
            if (!INSTANCE.tryReinitializeOpenCVIfNeeded()) {
                return AudioStats.AUDIO_AMPLITUDE_NONE;
            }
        } else if (!Intrinsics.areEqual((Object) bool5, (Object) true)) {
            throw new NoWhenBranchMatchedException();
        }
        try {
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, 320, (int) ((320.0f / bitmap.getWidth()) * bitmap.getHeight()), true);
            try {
                mat2 = new Mat();
            } catch (Exception e) {
                e = e;
                d = 0.0d;
                bitmap2 = bitmapCreateScaledBitmap;
                mat2 = null;
                mat3 = null;
                mat4 = null;
                mat5 = null;
                try {
                    Log.e(ExifInterface.TAG_SHARPNESS, "Error calculating sharpness: " + e.getMessage());
                    if (bitmap2 != null) {
                    }
                    if (mat2 != null) {
                    }
                    if (mat3 != null) {
                    }
                    if (mat4 != null) {
                    }
                    if (mat5 != null) {
                    }
                    return d;
                } catch (Throwable th) {
                    th = th;
                    mat = mat5;
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                    }
                    if (mat2 != null) {
                        mat2.release();
                    }
                    if (mat3 != null) {
                        mat3.release();
                    }
                    if (mat4 != null) {
                        mat4.release();
                    }
                    if (mat != null) {
                        mat.release();
                    }
                    throw th;
                }
            } catch (UnsatisfiedLinkError e2) {
                e = e2;
                c = 0;
                bool = false;
                d = 0.0d;
                mat = null;
                mat2 = null;
                bool2 = bool;
                mat3 = null;
                bool3 = bool2;
                mat4 = null;
                bool4 = bool3;
                try {
                    openCVAvailable = bool4;
                    message = e.getMessage();
                    if (message == null) {
                    }
                    Log.e(ExifInterface.TAG_SHARPNESS, "OpenCV runtime crash at: " + str2 + " - marking unavailable", e);
                    try {
                        FirebaseAnalytics analytics = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
                        ParametersBuilder parametersBuilder = new ParametersBuilder();
                        parametersBuilder.param("crash_location", str2);
                        String name = Thread.currentThread().getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        parametersBuilder.param("thread_name", name);
                        String MANUFACTURER = Build.MANUFACTURER;
                        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                        parametersBuilder.param(AndroidContextPlugin.DEVICE_MANUFACTURER_KEY, MANUFACTURER);
                        String MODEL = Build.MODEL;
                        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                        parametersBuilder.param(AndroidContextPlugin.DEVICE_MODEL_KEY, MODEL);
                        parametersBuilder.param("available_memory_mb", String.valueOf((Runtime.getRuntime().freeMemory() / 1024) / 1024));
                        analytics.logEvent("opencv_runtime_jni_crash", parametersBuilder.getZza());
                        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
                        firebaseCrashlytics.setCustomKey("opencv_crash_type", "runtime_jni");
                        firebaseCrashlytics.setCustomKey("crash_location", str2);
                        firebaseCrashlytics.setCustomKey("thread", Thread.currentThread().getName());
                        firebaseCrashlytics.recordException(e);
                        Intrinsics.checkNotNull(firebaseCrashlytics);
                    } catch (Exception unused) {
                    }
                    if (bitmapCreateScaledBitmap != null) {
                    }
                    if (mat2 != null) {
                    }
                    if (mat3 != null) {
                    }
                    if (mat4 != null) {
                    }
                    if (mat != null) {
                    }
                    return d;
                } catch (Throwable th2) {
                    th = th2;
                    bitmap2 = bitmapCreateScaledBitmap;
                    if (bitmap2 != null) {
                    }
                    if (mat2 != null) {
                    }
                    if (mat3 != null) {
                    }
                    if (mat4 != null) {
                    }
                    if (mat != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bitmap2 = bitmapCreateScaledBitmap;
                mat = null;
                mat2 = null;
                mat3 = null;
                mat4 = null;
                if (bitmap2 != null) {
                }
                if (mat2 != null) {
                }
                if (mat3 != null) {
                }
                if (mat4 != null) {
                }
                if (mat != null) {
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            d = 0.0d;
            bitmap2 = null;
        } catch (UnsatisfiedLinkError e4) {
            e = e4;
            c = 0;
            bool = false;
            d = 0.0d;
            mat = null;
            bitmapCreateScaledBitmap = null;
        } catch (Throwable th4) {
            th = th4;
            mat = null;
            bitmap2 = null;
        }
        try {
            Utils.bitmapToMat(bitmapCreateScaledBitmap, mat2);
            mat3 = new Mat();
            try {
                Imgproc.cvtColor(mat2, mat3, 11);
                mat4 = new Mat();
            } catch (Exception e5) {
                e = e5;
                d = 0.0d;
                bitmap2 = bitmapCreateScaledBitmap;
                mat4 = null;
                mat5 = null;
                Log.e(ExifInterface.TAG_SHARPNESS, "Error calculating sharpness: " + e.getMessage());
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                if (mat2 != null) {
                    mat2.release();
                }
                if (mat3 != null) {
                    mat3.release();
                }
                if (mat4 != null) {
                    mat4.release();
                }
                if (mat5 != null) {
                    mat5.release();
                }
                return d;
            } catch (UnsatisfiedLinkError e6) {
                e = e6;
                c = 0;
                bool3 = false;
                d = 0.0d;
                mat = null;
                mat4 = null;
                bool4 = bool3;
                openCVAvailable = bool4;
                message = e.getMessage();
                if (message == null || !StringsKt.contains$default((CharSequence) message, (CharSequence) "Mat.n_Mat", (boolean) c, 2, (Object) null)) {
                    message2 = e.getMessage();
                    if (message2 != null || !StringsKt.contains$default((CharSequence) message2, (CharSequence) "cvtColor", false, 2, (Object) null)) {
                        message3 = e.getMessage();
                        if (message3 == null) {
                            str = null;
                            if (StringsKt.contains$default((CharSequence) message3, (CharSequence) "Laplacian", false, 2, (Object) null)) {
                                str2 = "laplacian";
                            }
                        } else {
                            str = null;
                        }
                        String message4 = e.getMessage();
                        str2 = "unknown_" + (message4 == null ? StringsKt.take(message4, 50) : str);
                    }
                } else {
                    str2 = "mat_constructor";
                }
                Log.e(ExifInterface.TAG_SHARPNESS, "OpenCV runtime crash at: " + str2 + " - marking unavailable", e);
                FirebaseAnalytics analytics2 = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
                ParametersBuilder parametersBuilder2 = new ParametersBuilder();
                parametersBuilder2.param("crash_location", str2);
                String name2 = Thread.currentThread().getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                parametersBuilder2.param("thread_name", name2);
                String MANUFACTURER2 = Build.MANUFACTURER;
                Intrinsics.checkNotNullExpressionValue(MANUFACTURER2, "MANUFACTURER");
                parametersBuilder2.param(AndroidContextPlugin.DEVICE_MANUFACTURER_KEY, MANUFACTURER2);
                String MODEL2 = Build.MODEL;
                Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                parametersBuilder2.param(AndroidContextPlugin.DEVICE_MODEL_KEY, MODEL2);
                parametersBuilder2.param("available_memory_mb", String.valueOf((Runtime.getRuntime().freeMemory() / 1024) / 1024));
                analytics2.logEvent("opencv_runtime_jni_crash", parametersBuilder2.getZza());
                FirebaseCrashlytics firebaseCrashlytics2 = FirebaseCrashlytics.getInstance();
                firebaseCrashlytics2.setCustomKey("opencv_crash_type", "runtime_jni");
                firebaseCrashlytics2.setCustomKey("crash_location", str2);
                firebaseCrashlytics2.setCustomKey("thread", Thread.currentThread().getName());
                firebaseCrashlytics2.recordException(e);
                Intrinsics.checkNotNull(firebaseCrashlytics2);
                if (bitmapCreateScaledBitmap != null) {
                    bitmapCreateScaledBitmap.recycle();
                }
                if (mat2 != null) {
                    mat2.release();
                }
                if (mat3 != null) {
                    mat3.release();
                }
                if (mat4 != null) {
                    mat4.release();
                }
                if (mat != null) {
                    mat.release();
                }
                return d;
            } catch (Throwable th5) {
                th = th5;
                bitmap2 = bitmapCreateScaledBitmap;
                mat = null;
                mat4 = null;
                if (bitmap2 != null) {
                }
                if (mat2 != null) {
                }
                if (mat3 != null) {
                }
                if (mat4 != null) {
                }
                if (mat != null) {
                }
                throw th;
            }
            try {
                Core.normalize(mat3, mat4, AudioStats.AUDIO_AMPLITUDE_NONE, 255.0d, 32);
                Mat mat6 = new Mat();
                bool4 = 4607182418800017408;
                c = 3;
                try {
                    Imgproc.Laplacian(mat4, mat6, 0, 3, 1.0d, AudioStats.AUDIO_AMPLITUDE_NONE);
                    mat = mat6;
                    d = 0.0d;
                    try {
                        try {
                            MatOfDouble matOfDouble = new MatOfDouble();
                            MatOfDouble matOfDouble2 = new MatOfDouble();
                            try {
                                Core.meanStdDev(mat, matOfDouble, matOfDouble2);
                                try {
                                    try {
                                        double dPow = Math.pow(matOfDouble2.get(0, 0)[0], 2.0d);
                                        matOfDouble.release();
                                        matOfDouble2.release();
                                        if (bitmapCreateScaledBitmap != null) {
                                            bitmapCreateScaledBitmap.recycle();
                                        }
                                        mat2.release();
                                        mat3.release();
                                        mat4.release();
                                        mat.release();
                                        return dPow;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        matOfDouble.release();
                                        matOfDouble2.release();
                                        throw th;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    matOfDouble.release();
                                    matOfDouble2.release();
                                    throw th;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            bitmap2 = bitmap;
                            mat5 = mat;
                            Log.e(ExifInterface.TAG_SHARPNESS, "Error calculating sharpness: " + e.getMessage());
                            if (bitmap2 != null) {
                            }
                            if (mat2 != null) {
                            }
                            if (mat3 != null) {
                            }
                            if (mat4 != null) {
                            }
                            if (mat5 != null) {
                            }
                            return d;
                        } catch (UnsatisfiedLinkError e8) {
                            e = e8;
                            bitmapCreateScaledBitmap = bitmap;
                            openCVAvailable = bool4;
                            message = e.getMessage();
                            if (message == null) {
                                message2 = e.getMessage();
                                if (message2 != null) {
                                    message3 = e.getMessage();
                                    if (message3 == null) {
                                    }
                                    String message42 = e.getMessage();
                                    str2 = "unknown_" + (message42 == null ? StringsKt.take(message42, 50) : str);
                                }
                            }
                            Log.e(ExifInterface.TAG_SHARPNESS, "OpenCV runtime crash at: " + str2 + " - marking unavailable", e);
                            FirebaseAnalytics analytics22 = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
                            ParametersBuilder parametersBuilder22 = new ParametersBuilder();
                            parametersBuilder22.param("crash_location", str2);
                            String name22 = Thread.currentThread().getName();
                            Intrinsics.checkNotNullExpressionValue(name22, "getName(...)");
                            parametersBuilder22.param("thread_name", name22);
                            String MANUFACTURER22 = Build.MANUFACTURER;
                            Intrinsics.checkNotNullExpressionValue(MANUFACTURER22, "MANUFACTURER");
                            parametersBuilder22.param(AndroidContextPlugin.DEVICE_MANUFACTURER_KEY, MANUFACTURER22);
                            String MODEL22 = Build.MODEL;
                            Intrinsics.checkNotNullExpressionValue(MODEL22, "MODEL");
                            parametersBuilder22.param(AndroidContextPlugin.DEVICE_MODEL_KEY, MODEL22);
                            parametersBuilder22.param("available_memory_mb", String.valueOf((Runtime.getRuntime().freeMemory() / 1024) / 1024));
                            analytics22.logEvent("opencv_runtime_jni_crash", parametersBuilder22.getZza());
                            FirebaseCrashlytics firebaseCrashlytics22 = FirebaseCrashlytics.getInstance();
                            firebaseCrashlytics22.setCustomKey("opencv_crash_type", "runtime_jni");
                            firebaseCrashlytics22.setCustomKey("crash_location", str2);
                            firebaseCrashlytics22.setCustomKey("thread", Thread.currentThread().getName());
                            firebaseCrashlytics22.recordException(e);
                            Intrinsics.checkNotNull(firebaseCrashlytics22);
                            if (bitmapCreateScaledBitmap != null) {
                            }
                            if (mat2 != null) {
                            }
                            if (mat3 != null) {
                            }
                            if (mat4 != null) {
                            }
                            if (mat != null) {
                            }
                            return d;
                        } catch (Throwable th9) {
                            th = th9;
                            bitmap2 = bitmap;
                            if (bitmap2 != null) {
                            }
                            if (mat2 != null) {
                            }
                            if (mat3 != null) {
                            }
                            if (mat4 != null) {
                            }
                            if (mat != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        bitmap = bitmapCreateScaledBitmap;
                        bitmap2 = bitmap;
                        mat5 = mat;
                        Log.e(ExifInterface.TAG_SHARPNESS, "Error calculating sharpness: " + e.getMessage());
                        if (bitmap2 != null) {
                        }
                        if (mat2 != null) {
                        }
                        if (mat3 != null) {
                        }
                        if (mat4 != null) {
                        }
                        if (mat5 != null) {
                        }
                        return d;
                    } catch (UnsatisfiedLinkError e10) {
                        e = e10;
                        c = 0;
                        bool4 = false;
                        openCVAvailable = bool4;
                        message = e.getMessage();
                        if (message == null) {
                        }
                        Log.e(ExifInterface.TAG_SHARPNESS, "OpenCV runtime crash at: " + str2 + " - marking unavailable", e);
                        FirebaseAnalytics analytics222 = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
                        ParametersBuilder parametersBuilder222 = new ParametersBuilder();
                        parametersBuilder222.param("crash_location", str2);
                        String name222 = Thread.currentThread().getName();
                        Intrinsics.checkNotNullExpressionValue(name222, "getName(...)");
                        parametersBuilder222.param("thread_name", name222);
                        String MANUFACTURER222 = Build.MANUFACTURER;
                        Intrinsics.checkNotNullExpressionValue(MANUFACTURER222, "MANUFACTURER");
                        parametersBuilder222.param(AndroidContextPlugin.DEVICE_MANUFACTURER_KEY, MANUFACTURER222);
                        String MODEL222 = Build.MODEL;
                        Intrinsics.checkNotNullExpressionValue(MODEL222, "MODEL");
                        parametersBuilder222.param(AndroidContextPlugin.DEVICE_MODEL_KEY, MODEL222);
                        parametersBuilder222.param("available_memory_mb", String.valueOf((Runtime.getRuntime().freeMemory() / 1024) / 1024));
                        analytics222.logEvent("opencv_runtime_jni_crash", parametersBuilder222.getZza());
                        FirebaseCrashlytics firebaseCrashlytics222 = FirebaseCrashlytics.getInstance();
                        firebaseCrashlytics222.setCustomKey("opencv_crash_type", "runtime_jni");
                        firebaseCrashlytics222.setCustomKey("crash_location", str2);
                        firebaseCrashlytics222.setCustomKey("thread", Thread.currentThread().getName());
                        firebaseCrashlytics222.recordException(e);
                        Intrinsics.checkNotNull(firebaseCrashlytics222);
                        if (bitmapCreateScaledBitmap != null) {
                        }
                        if (mat2 != null) {
                        }
                        if (mat3 != null) {
                        }
                        if (mat4 != null) {
                        }
                        if (mat != null) {
                        }
                        return d;
                    } catch (Throwable th10) {
                        th = th10;
                        bitmap = bitmapCreateScaledBitmap;
                        bitmap2 = bitmap;
                        if (bitmap2 != null) {
                        }
                        if (mat2 != null) {
                        }
                        if (mat3 != null) {
                        }
                        if (mat4 != null) {
                        }
                        if (mat != null) {
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    mat = mat6;
                    d = 0.0d;
                } catch (UnsatisfiedLinkError e12) {
                    e = e12;
                    mat = mat6;
                    d = 0.0d;
                } catch (Throwable th11) {
                    th = th11;
                    bitmap = bitmapCreateScaledBitmap;
                    mat = mat6;
                }
            } catch (Exception e13) {
                e = e13;
                d = 0.0d;
                bitmap2 = bitmapCreateScaledBitmap;
                mat5 = null;
                Log.e(ExifInterface.TAG_SHARPNESS, "Error calculating sharpness: " + e.getMessage());
                if (bitmap2 != null) {
                }
                if (mat2 != null) {
                }
                if (mat3 != null) {
                }
                if (mat4 != null) {
                }
                if (mat5 != null) {
                }
                return d;
            } catch (UnsatisfiedLinkError e14) {
                e = e14;
                c = 0;
                bool4 = false;
                d = 0.0d;
                mat = null;
            } catch (Throwable th12) {
                th = th12;
                bitmap2 = bitmapCreateScaledBitmap;
                mat = null;
            }
        } catch (Exception e15) {
            e = e15;
            d = 0.0d;
            bitmap2 = bitmapCreateScaledBitmap;
            mat3 = null;
            mat4 = null;
            mat5 = null;
            Log.e(ExifInterface.TAG_SHARPNESS, "Error calculating sharpness: " + e.getMessage());
            if (bitmap2 != null) {
            }
            if (mat2 != null) {
            }
            if (mat3 != null) {
            }
            if (mat4 != null) {
            }
            if (mat5 != null) {
            }
            return d;
        } catch (UnsatisfiedLinkError e16) {
            e = e16;
            c = 0;
            bool2 = false;
            d = 0.0d;
            mat = null;
            mat3 = null;
            bool3 = bool2;
            mat4 = null;
            bool4 = bool3;
            openCVAvailable = bool4;
            message = e.getMessage();
            if (message == null) {
            }
            Log.e(ExifInterface.TAG_SHARPNESS, "OpenCV runtime crash at: " + str2 + " - marking unavailable", e);
            FirebaseAnalytics analytics2222 = AnalyticsKt.getAnalytics(Firebase.INSTANCE);
            ParametersBuilder parametersBuilder2222 = new ParametersBuilder();
            parametersBuilder2222.param("crash_location", str2);
            String name2222 = Thread.currentThread().getName();
            Intrinsics.checkNotNullExpressionValue(name2222, "getName(...)");
            parametersBuilder2222.param("thread_name", name2222);
            String MANUFACTURER2222 = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER2222, "MANUFACTURER");
            parametersBuilder2222.param(AndroidContextPlugin.DEVICE_MANUFACTURER_KEY, MANUFACTURER2222);
            String MODEL2222 = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL2222, "MODEL");
            parametersBuilder2222.param(AndroidContextPlugin.DEVICE_MODEL_KEY, MODEL2222);
            parametersBuilder2222.param("available_memory_mb", String.valueOf((Runtime.getRuntime().freeMemory() / 1024) / 1024));
            analytics2222.logEvent("opencv_runtime_jni_crash", parametersBuilder2222.getZza());
            FirebaseCrashlytics firebaseCrashlytics2222 = FirebaseCrashlytics.getInstance();
            firebaseCrashlytics2222.setCustomKey("opencv_crash_type", "runtime_jni");
            firebaseCrashlytics2222.setCustomKey("crash_location", str2);
            firebaseCrashlytics2222.setCustomKey("thread", Thread.currentThread().getName());
            firebaseCrashlytics2222.recordException(e);
            Intrinsics.checkNotNull(firebaseCrashlytics2222);
            if (bitmapCreateScaledBitmap != null) {
            }
            if (mat2 != null) {
            }
            if (mat3 != null) {
            }
            if (mat4 != null) {
            }
            if (mat != null) {
            }
            return d;
        } catch (Throwable th13) {
            th = th13;
            bitmap2 = bitmapCreateScaledBitmap;
            mat = null;
            mat3 = null;
            mat4 = null;
            if (bitmap2 != null) {
            }
            if (mat2 != null) {
            }
            if (mat3 != null) {
            }
            if (mat4 != null) {
            }
            if (mat != null) {
            }
            throw th;
        }
    }

    private final SoundPool getSoundPool() {
        Object value = this.soundPool.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SoundPool) value;
    }

    private final Map<String, List<String>> groupSimilarTitles(List<String> titles) {
        Object next;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : titles) {
            String strCleanTitle = cleanTitle(str);
            Iterator it = linkedHashMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                String str2 = (String) next;
                if (1.0d - (((double) levenshteinDistance(strCleanTitle, cleanTitle(str2))) / ((double) Math.max(strCleanTitle.length(), cleanTitle(str2).length()))) >= 0.75d) {
                    break;
                }
            }
            String str3 = (String) next;
            if (str3 != null) {
                List list = (List) linkedHashMap.get(str3);
                if (list != null) {
                    list.add(str);
                }
            } else {
                linkedHashMap.put(str, CollectionsKt.mutableListOf(str));
            }
        }
        return linkedHashMap;
    }

    private final int levenshteinDistance(String s1, String s2) {
        int iMin;
        int length = s1.length();
        int length2 = s2.length();
        int i = length + 1;
        int[][] iArr = new int[i][];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = new int[length2 + 1];
        }
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                iArr[i3][0] = i3;
                if (i3 == length) {
                    break;
                }
                i3++;
            }
        }
        if (length2 >= 0) {
            int i4 = 0;
            while (true) {
                iArr[0][i4] = i4;
                if (i4 == length2) {
                    break;
                }
                i4++;
            }
        }
        if (1 <= length) {
            int i5 = 1;
            while (true) {
                if (1 <= length2) {
                    int i6 = 1;
                    while (true) {
                        int[] iArr2 = iArr[i5];
                        int i7 = i5 - 1;
                        int i8 = i6 - 1;
                        if (s1.charAt(i7) == s2.charAt(i8)) {
                            iMin = iArr[i7][i8];
                        } else {
                            int[] iArr3 = iArr[i7];
                            iMin = Math.min(iArr3[i8], Math.min(iArr3[i6], iArr[i5][i8])) + 1;
                        }
                        iArr2[i6] = iMin;
                        if (i6 == length2) {
                            break;
                        }
                        i6++;
                    }
                }
                if (i5 == length) {
                    break;
                }
                i5++;
            }
        }
        return iArr[length][length2];
    }

    private final String normalizeCardNumber(String number) {
        return StringsKt.trimStart(new Regex("[^0-9]").replace(number, ""), '0');
    }

    private final void onSuccessfulScan() {
        int i = this.successfulScanCount + 1;
        this.successfulScanCount = i;
        if (i >= this.GC_TRIGGER_INTERVAL) {
            this.successfulScanCount = 0;
            System.gc();
            if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                Log.d(TAG, "Suggested GC after " + this.GC_TRIGGER_INTERVAL + " successful scans");
            }
        }
    }

    static final String parseBottomText$lambda$6(kotlin.text.MatchResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String upperCase = it.getValue().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private final void playDebugSound1() {
    }

    private final void playDebugSound2() {
        if (new PreferencesManager(this.context).getBoolean(PreferencesManager.ENABLE_SCAN_BEEPS, true)) {
            getSoundPool().play(this.debugSoundId2, 0.35f, 0.35f, 0, 0, 1.0f);
        }
    }

    private final void recycleBitmapSafely(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                bitmap.recycle();
            } catch (Exception e) {
                Log.e(TAG, "Error recycling bitmap: " + e.getMessage());
            }
        }
    }

    private final void recycleSegmentationBitmaps(CardSegmentation segmentation) {
        if (segmentation == null) {
            return;
        }
        try {
            Bitmap cardBitmap = segmentation.getCardBitmap();
            if (cardBitmap != null) {
                cardBitmap.recycle();
            }
            Bitmap enhancedCardBitmap = segmentation.getEnhancedCardBitmap();
            if (enhancedCardBitmap != null) {
                enhancedCardBitmap.recycle();
            }
            Bitmap setSymbolBitmap = segmentation.getSetSymbolBitmap();
            if (setSymbolBitmap != null) {
                setSymbolBitmap.recycle();
            }
            Bitmap pListBitmap = segmentation.getPListBitmap();
            if (pListBitmap != null) {
                pListBitmap.recycle();
            }
        } catch (Exception e) {
            Log.e(TAG, "Error recycling segmentation bitmaps: " + e.getMessage());
        }
    }

    private final void resetAccumulatedDetections() {
        synchronized (this.titleDetections) {
            this.titleDetections.clear();
            this.setCodeDetections.clear();
            this.cardNumberDetections.clear();
            this.titleDetectionCounter = 0;
            this.bottomDetectionCounter = 0;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void storeEmbeddingMatchesWithSetSymbolEmbedding(List<SimilarCard> similarCards, float[] currentArtworkEmbedding, float[] setSymbolEmbedding, boolean hasPListHash, BorderColor borderColor) {
        double dCalculateSimilarityToCard;
        synchronized (this.storedEmbeddingMatches) {
            this.currentArtworkEmbedding = currentArtworkEmbedding;
            this.storedEmbeddingMatches.clear();
            List<SimilarCard> list = similarCards;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (SimilarCard similarCard : list) {
                arrayList.add(TuplesKt.to(similarCard.getScryfallId(), Integer.valueOf(similarCard.getFace())));
            }
            final ArrayList arrayList2 = arrayList;
            Map map = (Map) UtilsKt.measureTimeForResult(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CombinedAnalyzer.storeEmbeddingMatchesWithSetSymbolEmbedding$lambda$0$1(this.f$0, arrayList2);
                }
            }, "-------->>>>>>> CombinedAnalyzer::dbHelper.getCardsByScryFallIds()");
            for (SimilarCard similarCard2 : similarCards) {
                CardRecord cardRecord = (CardRecord) map.get(similarCard2.getScryfallId() + "_" + similarCard2.getFace());
                if (cardRecord != null) {
                    String lowerCase = cardRecord.getLayout().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (!Intrinsics.areEqual(lowerCase, "art_series")) {
                        EmbeddingMatch embeddingMatch = new EmbeddingMatch(cardRecord, similarCard2.getScryfallId(), similarCard2.getFace(), similarCard2.getSimilarity(), cardRecord.getOracle_id(), 0L, "", hasPListHash, borderColor, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 1536, null);
                        if (setSymbolEmbedding != null) {
                            dCalculateSimilarityToCard = getSetSymbolEmbeddings().calculateSimilarityToCard(setSymbolEmbedding, similarCard2.getScryfallId(), similarCard2.getFace());
                            embeddingMatch.setSetSymbolSimilarity(dCalculateSimilarityToCard);
                        } else {
                            dCalculateSimilarityToCard = AudioStats.AUDIO_AMPLITUDE_NONE;
                        }
                        if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                            String title = cardRecord.getTitle();
                            String set = cardRecord.getSet();
                            String number = cardRecord.getNumber();
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String str = String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(similarCard2.getSimilarity())}, 1));
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                            String str2 = String.format("%.3f", Arrays.copyOf(new Object[]{Double.valueOf(dCalculateSimilarityToCard)}, 1));
                            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                            Log.d("SetSymbolEmbeddingScoring", "Print: " + title + " (" + set + DomExceptionUtils.SEPARATOR + number + ") - Artwork: " + str + ", SetSymbol: " + str2);
                        }
                        this.storedEmbeddingMatches.add(embeddingMatch);
                    } else if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                        Log.d("SetSymbolEmbeddingScoring", "Skipping art series card: " + cardRecord.getTitle() + " (" + cardRecord.getSet() + DomExceptionUtils.SEPARATOR + cardRecord.getNumber() + ")");
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map storeEmbeddingMatchesWithSetSymbolEmbedding$lambda$0$1(CombinedAnalyzer combinedAnalyzer, List list) {
        return combinedAnalyzer.dbHelper.getCardsByScryFallIds(list);
    }

    private final String validateAndCorrectSetCode(String detectedSetCode) {
        Object obj;
        String str = detectedSetCode;
        if (str.length() == 0) {
            return detectedSetCode;
        }
        List<CardSet> list = this.cardSets;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String upperCase = ((CardSet) it.next()).getCode().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            arrayList.add(upperCase);
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.contains(detectedSetCode)) {
            Map mapMapOf = MapsKt.mapOf(TuplesKt.to("O", "D"), TuplesKt.to(AppEventsConstants.EVENT_PARAM_VALUE_NO, "O"), TuplesKt.to("1", "I"), TuplesKt.to("I", "1"), TuplesKt.to("8", "B"), TuplesKt.to("B", "8"), TuplesKt.to("5", ExifInterface.LATITUDE_SOUTH), TuplesKt.to(ExifInterface.LATITUDE_SOUTH, "5"), TuplesKt.to("Z", ExifInterface.GPS_MEASUREMENT_2D), TuplesKt.to(ExifInterface.GPS_MEASUREMENT_2D, "Z"), TuplesKt.to(GameUtils.CONDITION_GOOD, "6"), TuplesKt.to("6", GameUtils.CONDITION_GOOD));
            ArrayList<String> arrayList3 = new ArrayList();
            arrayList3.add(detectedSetCode);
            int length = str.length();
            for (int i = 0; i < length; i++) {
                String str2 = (String) mapMapOf.get(String.valueOf(detectedSetCode.charAt(i)));
                if (str2 != null) {
                    String strSubstring = detectedSetCode.substring(0, i);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    String strSubstring2 = detectedSetCode.substring(i + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    arrayList3.add(strSubstring + str2 + strSubstring2);
                }
            }
            for (String str3 : arrayList3) {
                if (arrayList2.contains(str3)) {
                    return str3;
                }
            }
            if (detectedSetCode.length() == 3) {
                ArrayList arrayList4 = new ArrayList();
                for (Object obj2 : arrayList2) {
                    if (((String) obj2).length() == 3) {
                        arrayList4.add(obj2);
                    }
                }
                Iterator it2 = arrayList4.iterator();
                if (it2.hasNext()) {
                    Object next = it2.next();
                    if (it2.hasNext()) {
                        int iLevenshteinDistance = levenshteinDistance((String) next, detectedSetCode);
                        do {
                            Object next2 = it2.next();
                            int iLevenshteinDistance2 = levenshteinDistance((String) next2, detectedSetCode);
                            if (iLevenshteinDistance > iLevenshteinDistance2) {
                                next = next2;
                                iLevenshteinDistance = iLevenshteinDistance2;
                            }
                        } while (it2.hasNext());
                    }
                    obj = next;
                } else {
                    obj = null;
                }
                String str4 = (String) obj;
                if (str4 != null && levenshteinDistance(str4, detectedSetCode) <= 1) {
                    return str4;
                }
            }
        }
        return detectedSetCode;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(final ImageProxy imageProxy) {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        if (this.isPaused || this.processing) {
            imageProxy.close();
            return;
        }
        if (this.fragment.getIsDeviceStable()) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                Log.d(TAG, "@@@@@@@@@@@@@@@@@@ WARNING: analyze() is called from UI THREAD @@@@@@@@@@@@@@@@@@");
            }
            UtilsKt.measureTime(new Function0() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CombinedAnalyzer.analyze$lambda$0(this.f$0, imageProxy);
                }
            }, "-------->>>>>>> CombinedAnalyzer::analyze() - ************ ANALYZE TOTAL TIME ************");
        } else {
            if (CombinedAnalyzerKt.getDEBUG_LOG()) {
                Log.d(TAG, "-------------- Device is not stable - skipping frame");
            }
            imageProxy.close();
        }
    }

    public final String cleanTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        String lowerCase = title.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return StringsKt.trim((CharSequence) new Regex("\\s+").replace(new Regex("[^\\p{L}\\p{N} ]+").replace(removeDiacritics(lowerCase), " "), " ")).toString();
    }

    public final void cleanup() {
        this.isCleanedUp = true;
        try {
            getSoundPool().release();
            this.textRecognizer.close();
        } catch (Exception e) {
            Log.e(TAG, "Error during cleanup: " + e.getMessage());
        }
    }

    public final Bitmap extractBottomLeftRegion(Bitmap cardBitmap, String cardType) {
        Intrinsics.checkNotNullParameter(cardBitmap, "cardBitmap");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        int width = cardBitmap.getWidth();
        int height = cardBitmap.getHeight();
        int i = (int) (((double) height) * 0.1d);
        return Bitmap.createBitmap(cardBitmap, 0, height - i, width / 4, i);
    }

    public final Bitmap extractPListStampRegion(Bitmap cardBitmap) {
        Intrinsics.checkNotNullParameter(cardBitmap, "cardBitmap");
        int width = (int) (cardBitmap.getWidth() * 0.1f);
        return Bitmap.createBitmap(cardBitmap, 0, cardBitmap.getHeight() - width, width, width);
    }

    public final Bitmap extractSetSymbolRegion(Bitmap cardBitmap) {
        Intrinsics.checkNotNullParameter(cardBitmap, "cardBitmap");
        double width = cardBitmap.getWidth();
        double height = cardBitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(cardBitmap, (int) (0.82d * width), (int) (0.53d * height), (int) (width * 0.16d), (int) (height * 0.1066d));
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Bitmap extractTitleRegion(Bitmap cardBitmap, String cardType) {
        Intrinsics.checkNotNullParameter(cardBitmap, "cardBitmap");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        int width = cardBitmap.getWidth();
        int height = cardBitmap.getHeight();
        switch (cardType.hashCode()) {
            case -1396158280:
                if (!cardType.equals("battle")) {
                    return null;
                }
                double d = width;
                double d2 = height;
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(cardBitmap, (int) (d * 0.025d), (int) (d2 * 0.15d), (int) (0.2d * d), (int) (0.75d * d2));
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                Matrix matrix = new Matrix();
                matrix.postRotate(90.0f);
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, true);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(...)");
                if (bitmapCreateBitmap2 != bitmapCreateBitmap) {
                    bitmapCreateBitmap.recycle();
                }
                return bitmapCreateBitmap2;
            case -1039745817:
                if (!cardType.equals("normal")) {
                    return null;
                }
                break;
            case -340330219:
                if (!cardType.equals("split_card")) {
                    return null;
                }
                double d3 = width;
                double d4 = height;
                Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(cardBitmap, (int) (d3 * 0.025d), (int) (d4 * 0.5d), (int) (0.2d * d3), (int) (0.475d * d4));
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap3, "createBitmap(...)");
                Matrix matrix2 = new Matrix();
                matrix2.postRotate(90.0f);
                Bitmap bitmapCreateBitmap4 = Bitmap.createBitmap(bitmapCreateBitmap3, 0, 0, bitmapCreateBitmap3.getWidth(), bitmapCreateBitmap3.getHeight(), matrix2, true);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap4, "createBitmap(...)");
                if (bitmapCreateBitmap4 != bitmapCreateBitmap3) {
                    bitmapCreateBitmap3.recycle();
                }
                return bitmapCreateBitmap4;
            case 110541305:
                if (cardType.equals("token")) {
                    return Bitmap.createBitmap(cardBitmap, 0, 0, width, (int) (((double) height) * 0.2d));
                }
                return null;
            case 1019985636:
                if (!cardType.equals("aftermath")) {
                    return null;
                }
                break;
            default:
                return null;
        }
        return Bitmap.createBitmap(cardBitmap, 0, 0, width, (int) (((double) height) * 0.17d));
    }

    public final boolean getContinuousMode() {
        return this.continuousMode;
    }

    public final int getDiscardedAttempts() {
        return this.discardedAttempts;
    }

    public final boolean getFirstFrameSkipped() {
        return this.firstFrameSkipped;
    }

    public final String getInitializationError() {
        String initializationError = this.cardDetector.getInitializationError();
        return (initializationError == null && (initializationError = this.cardClassifier.getInitializationError()) == null && (initializationError = getCardEmbeddings().getInitializationError()) == null && (initializationError = getSetSymbolEmbeddings().getInitializationError()) == null) ? this.plistDetector.getInitializationError() : initializationError;
    }

    public final boolean getLockedIn() {
        return this.lockedIn;
    }

    public final int getOcrCounter() {
        return this.ocrCounter;
    }

    public final boolean getProcessing() {
        return this.processing;
    }

    /* JADX INFO: renamed from: isPaused, reason: from getter */
    public final boolean getIsPaused() {
        return this.isPaused;
    }

    public final boolean isReady() {
        return this.cardDetector.getIsReady() && this.cardClassifier.getIsReady() && getCardEmbeddings().getIsReady() && getSetSymbolEmbeddings().getIsReady();
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0294  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CardInfo parseBottomText(String text) {
        String value;
        String str;
        String strReplace$default;
        kotlin.text.MatchResult matchResultFind$default;
        String str2;
        Intrinsics.checkNotNullParameter(text, "text");
        List listSplit$default = StringsKt.split$default((CharSequence) text, new String[]{"\n", "\r\n"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            return new CardInfo(null, null, null, 7, null);
        }
        Set of = SetsKt.setOf((Object[]) new String[]{"EN", "FR", "DE", "ES", "IT", "JA", "RU", "PT", "KO", "ZHS", "ZHT"});
        Set<String> of2 = SetsKt.setOf((Object[]) new String[]{"C", "U", "R", "M", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH});
        List<String> listReversed = CollectionsKt.reversed(arrayList3);
        value = "";
        if (!listReversed.isEmpty()) {
            List<String> listSplit = new Regex("[^A-Za-z0-9]").split((String) listReversed.get(0), 0);
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : listSplit) {
                if (!StringsKt.isBlank((String) obj2)) {
                    arrayList4.add(obj2);
                }
            }
            ArrayList arrayList5 = arrayList4;
            ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
            Iterator it2 = arrayList5.iterator();
            while (it2.hasNext()) {
                String upperCase = ((String) it2.next()).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                arrayList6.add(upperCase);
            }
            ArrayList<String> arrayList7 = arrayList6;
            if (arrayList7.size() >= 2) {
                ArrayList arrayList8 = arrayList7;
                ArrayList arrayList9 = new ArrayList();
                for (Object obj3 : arrayList8) {
                    String str3 = (String) obj3;
                    if (str3.length() == 3 && Character.isLetter(str3.charAt(0))) {
                        arrayList9.add(obj3);
                    }
                }
                ArrayList arrayList10 = arrayList9;
                str = !arrayList10.isEmpty() ? (String) arrayList10.get(0) : "";
                ArrayList arrayList11 = new ArrayList();
                for (Object obj4 : arrayList8) {
                    String str4 = (String) obj4;
                    int length = str4.length();
                    if (2 <= length && length < 4 && of.contains(str4)) {
                        arrayList11.add(obj4);
                    }
                }
                ArrayList arrayList12 = arrayList11;
                if (arrayList12.isEmpty()) {
                    String str5 = str;
                    String str6 = "";
                    for (String str7 : arrayList7) {
                        if (str7.length() > 3) {
                            Iterator it3 = of.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    String str8 = (String) it3.next();
                                    if (StringsKt.endsWith$default(str7, str8, false, 2, (Object) null)) {
                                        String strSubstring = str7.substring(0, str7.length() - str8.length());
                                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                        if (strSubstring.length() == 3 && Character.isLetter(strSubstring.charAt(0)) && str5.length() == 0) {
                                            str5 = strSubstring;
                                        }
                                        str6 = str8;
                                    }
                                }
                            }
                        }
                    }
                    str2 = str6;
                    str = str5;
                } else {
                    str2 = (String) arrayList12.get(0);
                }
                if (str.length() == 0 && str2.length() == 0) {
                    for (String str9 : arrayList7) {
                        if (str9.length() >= 5) {
                            String strSubstring2 = str9.substring(0, 3);
                            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                            if (Character.isLetter(strSubstring2.charAt(0))) {
                                Iterator it4 = of.iterator();
                                while (true) {
                                    if (!it4.hasNext()) {
                                        break;
                                    }
                                    if (StringsKt.endsWith$default(str9, (String) it4.next(), false, 2, (Object) null)) {
                                        str = strSubstring2;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                str = "";
            }
        }
        if (listReversed.size() >= 2) {
            String str10 = (String) listReversed.get(1);
            kotlin.text.MatchResult matchResultFind$default2 = Regex.find$default(new Regex("^[CRUMTS]"), str10, 0, 2, null);
            String value2 = matchResultFind$default2 != null ? matchResultFind$default2.getValue() : "";
            kotlin.text.MatchResult matchResultFind$default3 = Regex.find$default(new Regex("\\d+"), str10, 0, 2, null);
            value = matchResultFind$default3 != null ? matchResultFind$default3.getValue() : "";
            if (value.length() != 0 || (matchResultFind$default = Regex.find$default(new Regex("[O0-9lI]+"), str10, 0, 2, null)) == null) {
                strReplace$default = value;
                value = value2;
            } else {
                strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(matchResultFind$default.getValue(), "O", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, 4, (Object) null), "o", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, 4, (Object) null), "l", "1", false, 4, (Object) null), "I", "1", false, 4, (Object) null), "i", "1", false, 4, (Object) null);
                if (!new Regex("\\d+").matches(strReplace$default)) {
                }
                value = value2;
            }
        } else {
            strReplace$default = "";
        }
        if (value.length() == 0 || strReplace$default.length() == 0 || str.length() == 0) {
            for (String str11 : listReversed) {
                if (str.length() == 0) {
                    List list = SequencesKt.toList(SequencesKt.map(Regex.findAll$default(new Regex("[A-Za-z][A-Za-z0-9]{2}"), str11, 0, 2, null), new Function1() { // from class: com.studiolaganne.lengendarylens.CombinedAnalyzer$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj5) {
                            return CombinedAnalyzer.parseBottomText$lambda$6((kotlin.text.MatchResult) obj5);
                        }
                    }));
                    if (!list.isEmpty()) {
                        str = (String) list.get(0);
                    }
                }
                if (strReplace$default.length() == 0) {
                    String str12 = str11;
                    kotlin.text.MatchResult matchResultFind$default4 = Regex.find$default(new Regex("\\d+"), str12, 0, 2, null);
                    if (matchResultFind$default4 != null) {
                        strReplace$default = matchResultFind$default4.getValue();
                    } else {
                        kotlin.text.MatchResult matchResultFind$default5 = Regex.find$default(new Regex("[O0]+\\d+"), str12, 0, 2, null);
                        if (matchResultFind$default5 != null) {
                            strReplace$default = StringsKt.replace$default(matchResultFind$default5.getValue(), "O", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, 4, (Object) null);
                        }
                    }
                }
                if (value.length() == 0) {
                    for (String str13 : of2) {
                        if (StringsKt.startsWith$default(str11, str13, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str11, (CharSequence) (" " + str13 + " "), false, 2, (Object) null)) {
                            value = str13;
                            break;
                        }
                    }
                }
            }
        }
        return new CardInfo(value, strReplace$default, str);
    }

    public final String removeDiacritics(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String strNormalize = Normalizer.normalize(input, Normalizer.Form.NFD);
        Intrinsics.checkNotNull(strNormalize);
        return new Regex("\\p{M}").replace(strNormalize, "");
    }

    public final void reset() {
        this.titleDetections.clear();
        this.setCodeDetections.clear();
        this.cardNumberDetections.clear();
        this.storedEmbeddingMatches.clear();
        this.targetProcessingInterval = 100L;
        this.firstBeepPlayed = false;
        this.titleDetectionCounter = 0;
        this.bottomDetectionCounter = 0;
        this.runningAvgSharpness = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.sharpnessCount = 0;
        this.lastProcessedFrameTime = 0L;
        this.stableFrameCounter = 0;
        this.maxObservedSharpness = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.sharpnessHistory.clear();
        this.isPaused = false;
        this.processing = false;
        this.lockedIn = false;
        this.ocrCounter = 0;
        this.firstFrameSkipped = false;
        this.discardedAttempts = 0;
        if (this.continuousMode) {
            this.lockedIn = false;
            this.processing = false;
        }
    }

    public final void resetContinuousState() {
        this.lastCardDetectionTime = 0L;
        this.sameDetectionCounter = 0;
        this.isWaitingForNewCard = false;
        this.lastDetectedOracleID = null;
        this.lastDetectedEmbedding = null;
    }

    public final void setContinuousMode(boolean enabled) {
        this.continuousMode = enabled;
        if (enabled) {
            resetContinuousState();
        }
    }

    public final void setDiscardedAttempts(int i) {
        this.discardedAttempts = i;
    }

    public final void setFirstFrameSkipped(boolean z) {
        this.firstFrameSkipped = z;
    }

    public final void setLockedIn(boolean z) {
        this.lockedIn = z;
    }

    public final void setOcrCounter(int i) {
        this.ocrCounter = i;
    }

    public final void setPaused(boolean z) {
        this.isPaused = z;
    }

    public final void setProcessing(boolean z) {
        this.processing = z;
    }
}
