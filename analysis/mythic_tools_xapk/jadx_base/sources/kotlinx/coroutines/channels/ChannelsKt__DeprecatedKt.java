package kotlinx.coroutines.channels;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.apache.commons.codec.language.bm.Languages;
import org.apache.commons.io.FilenameUtils;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: Deprecated.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001aC\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\u0002\b\u0007H\u0087\b¢\u0006\u0002\u0010\b\u001a2\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\n0\u0005H\u0087H¢\u0006\u0002\u0010\f\u001aJ\u0010\r\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u00122\u001a\u0010\u0013\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0014\"\u0006\u0012\u0002\b\u00030\u0006H\u0001¢\u0006\u0002\u0010\u0015\u001a&\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0087@¢\u0006\u0002\u0010\u0019\u001a(\u0010\u001a\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0087@¢\u0006\u0002\u0010\u0019\u001a\u001e\u0010\u001b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a \u0010\u001d\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a&\u0010\u001e\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u001f\u001a\u0002H\u0002H\u0087@¢\u0006\u0002\u0010 \u001a\u001e\u0010!\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a&\u0010\"\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u001f\u001a\u0002H\u0002H\u0087@¢\u0006\u0002\u0010 \u001a \u0010#\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a\u001e\u0010$\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a \u0010%\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a0\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020)H\u0007\u001aQ\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001aQ\u00101\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0001¢\u0006\u0002\u00100\u001af\u00102\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)27\u0010+\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/03H\u0007¢\u0006\u0002\u00104\u001aQ\u00105\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001a$\u00106\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020/*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0006H\u0001\u001a>\u00107\u001a\u0002H8\"\b\b\u0000\u0010\u0002*\u00020/\"\u0010\b\u0001\u00108*\n\u0012\u0006\b\u0000\u0012\u0002H\u000209*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00062\u0006\u0010:\u001a\u0002H8H\u0087@¢\u0006\u0002\u0010;\u001a<\u00107\u001a\u0002H8\"\b\b\u0000\u0010\u0002*\u00020/\"\u000e\b\u0001\u00108*\b\u0012\u0004\u0012\u0002H\u00020<*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00062\u0006\u0010:\u001a\u0002H8H\u0087@¢\u0006\u0002\u0010=\u001a0\u0010>\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020)H\u0007\u001aQ\u0010?\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010+\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001a6\u0010@\u001a\u0002H8\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u00108*\b\u0012\u0004\u0012\u0002H\u00020<*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010:\u001a\u0002H8H\u0081@¢\u0006\u0002\u0010=\u001a8\u0010A\u001a\u0002H8\"\u0004\b\u0000\u0010\u0002\"\u0010\b\u0001\u00108*\n\u0012\u0006\b\u0000\u0012\u0002H\u000209*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010:\u001a\u0002H8H\u0081@¢\u0006\u0002\u0010;\u001a<\u0010B\u001a\u000e\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HE0C\"\u0004\b\u0000\u0010D\"\u0004\b\u0001\u0010E*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HE0F0\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001aR\u0010B\u001a\u0002HG\"\u0004\b\u0000\u0010D\"\u0004\b\u0001\u0010E\"\u0018\b\u0002\u0010G*\u0012\u0012\u0006\b\u0000\u0012\u0002HD\u0012\u0006\b\u0000\u0012\u0002HE0H*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HE0F0\u00062\u0006\u0010:\u001a\u0002HGH\u0081@¢\u0006\u0002\u0010I\u001a$\u0010J\u001a\b\u0012\u0004\u0012\u0002H\u00020K\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a$\u0010L\u001a\b\u0012\u0004\u0012\u0002H\u00020M\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a]\u0010N\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2(\u0010O\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00060-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001aW\u0010P\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010O\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0001¢\u0006\u0002\u00100\u001al\u0010Q\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)27\u0010O\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/03H\u0001¢\u0006\u0002\u00104\u001ar\u0010R\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020/*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)29\u0010O\u001a5\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/03H\u0007¢\u0006\u0002\u00104\u001a]\u0010S\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020/*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2$\u0010O\u001a \b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001a.\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020U0\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)H\u0007\u001a\u001e\u0010V\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0007\u001aW\u0010W\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010D*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)2\"\u0010X\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002HD0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0001¢\u0006\u0002\u00100\u001a$\u0010Y\u001a\b\u0012\u0004\u0012\u0002H\u00020Z\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0081@¢\u0006\u0002\u0010\u001c\u001a\u001e\u0010[\u001a\u00020.\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a\u001e\u0010\\\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a<\u0010]\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u001a\u0010^\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020_j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002``H\u0087@¢\u0006\u0002\u0010a\u001a<\u0010b\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u001a\u0010^\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020_j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002``H\u0087@¢\u0006\u0002\u0010a\u001a\u001e\u0010c\u001a\u00020.\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001c\u001a$\u0010d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020/*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0006H\u0007\u001a?\u0010e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010F0\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\f\u0010f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0087\u0004\u001az\u0010e\u001a\b\u0012\u0004\u0012\u0002HE0\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010E*\b\u0012\u0004\u0012\u0002H\u00020\u00062\f\u0010f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00062\b\b\u0002\u0010(\u001a\u00020)26\u0010O\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(g\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(h\u0012\u0004\u0012\u0002HE0,H\u0001\u001a1\u0010i\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u0012*\u0006\u0012\u0002\b\u00030\u0006H\u0001¨\u0006j"}, d2 = {"consume", "R", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BroadcastChannel;", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "", NativeProtocol.WEB_DIALOG_ACTION, "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumesAll", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "channels", "", "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", "elementAt", FirebaseAnalytics.Param.INDEX, "", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrNull", "first", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstOrNull", "indexOf", "element", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastIndexOf", "lastOrNull", "single", "singleOrNull", "drop", "n", "context", "Lkotlin/coroutines/CoroutineContext;", "dropWhile", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filter", "filterIndexed", "Lkotlin/Function3;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filterNot", "filterNotNull", "filterNotNullTo", "C", "", FirebaseAnalytics.Param.DESTINATION, "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "take", "takeWhile", "toChannel", "toCollection", "toMap", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "M", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMutableList", "", "toSet", "", "flatMap", "transform", "map", "mapIndexed", "mapIndexedNotNull", "mapNotNull", "withIndex", "Lkotlin/collections/IndexedValue;", "distinct", "distinctBy", "selector", "toMutableSet", "", Languages.ANY, "count", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minWith", "none", "requireNoNulls", "zip", "other", "a", "b", "consumes", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
final /* synthetic */ class ChannelsKt__DeprecatedKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1, reason: invalid class name */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {Videoio.CAP_PROP_XI_DECIMATION_PATTERN}, m = Languages.ANY, n = {"$this$consume$iv"}, s = {"L$0"})
    static final class AnonymousClass1<E> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.any(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$consumeEach$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {41}, m = "consumeEach", n = {NativeProtocol.WEB_DIALOG_ACTION, "channel$iv"}, s = {"L$0", "L$1"})
    static final class C12911<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12911(Continuation<? super C12911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.consumeEach(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {514}, m = "count", n = {"count", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class C12921<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12921(Continuation<? super C12921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.count(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H\n"}, d2 = {"<anonymous>", ExifInterface.LONGITUDE_EAST, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C12931<E> extends SuspendLambda implements Function2<E, Continuation<? super E>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C12931(Continuation<? super C12931> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12931 c12931 = new C12931(continuation);
            c12931.L$0 = obj;
            return c12931;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(E e, Continuation<? super E> continuation) {
            return ((C12931) create(e, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return this.L$0;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {Videoio.CAP_PROP_XI_AE_MAX_LIMIT, Videoio.CAP_PROP_XI_AG_MAX_LIMIT, 420}, m = "invokeSuspend", n = {"$this$produce", UserMetadata.KEYDATA_FILENAME, "$this$produce", UserMetadata.KEYDATA_FILENAME, "e", "$this$produce", UserMetadata.KEYDATA_FILENAME, "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
    static final class C12941<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super K>, Object> $selector;
        final /* synthetic */ ReceiveChannel<E> $this_distinctBy;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C12941(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super C12941> continuation) {
            super(2, continuation);
            this.$this_distinctBy = receiveChannel;
            this.$selector = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12941 c12941 = new C12941(this.$this_distinctBy, this.$selector, continuation);
            c12941.L$0 = obj;
            return c12941;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
            return ((C12941) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v13, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v16 */
        /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v7 */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r7v11 */
        /* JADX WARN: Type inference failed for: r7v12 */
        /* JADX WARN: Type inference failed for: r7v13 */
        /* JADX WARN: Type inference failed for: r7v14 */
        /* JADX WARN: Type inference failed for: r7v15 */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a4 -> B:29:0x00c3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ba -> B:28:0x00bc). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1<E> for r10v3 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 201
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.C12941.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0, 0, 1, 2}, l = {194, 199, 200}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$0"})
    static final class C12951<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $n;
        final /* synthetic */ ReceiveChannel<E> $this_drop;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C12951(int i, ReceiveChannel<? extends E> receiveChannel, Continuation<? super C12951> continuation) {
            super(2, continuation);
            this.$n = i;
            this.$this_drop = receiveChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12951 c12951 = new C12951(this.$n, this.$this_drop, continuation);
            c12951.L$0 = obj;
            return c12951;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
            return ((C12951) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
        
            if (r9 == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
        
            if (r1 == 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00ae, code lost:
        
            if (r4.send(r1.next(), r8) == r0) goto L37;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b1  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0069 -> B:23:0x006c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00ae -> B:8:0x001c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ProducerScope producerScope;
            int i;
            ChannelIterator<E> it;
            ProducerScope producerScope2;
            ChannelIterator<E> it2;
            ProducerScope producerScope3;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                producerScope = (ProducerScope) this.L$0;
                i = this.$n;
                if (!(i >= 0)) {
                    throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
                }
                if (i > 0) {
                    it = this.$this_drop.iterator();
                    producerScope2 = producerScope;
                    this.L$0 = producerScope2;
                    this.L$1 = it;
                    this.I$0 = i;
                    this.label = 1;
                    obj = it.hasNext(this);
                }
                it2 = this.$this_drop.iterator();
                this.L$0 = producerScope;
                this.L$1 = it2;
                this.label = 2;
                objHasNext = it2.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                i = this.I$0;
                it = (ChannelIterator) this.L$1;
                producerScope2 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    it.next();
                    i--;
                }
                producerScope = producerScope2;
                it2 = this.$this_drop.iterator();
                this.L$0 = producerScope;
                this.L$1 = it2;
                this.label = 2;
                objHasNext = it2.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it2 = (ChannelIterator) this.L$1;
                producerScope3 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                producerScope = producerScope3;
                this.L$0 = producerScope;
                this.L$1 = it2;
                this.label = 2;
                objHasNext = it2.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                    producerScope3 = producerScope;
                    obj = objHasNext;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    this.L$0 = producerScope3;
                    this.L$1 = it2;
                    this.label = 3;
                }
                return coroutine_suspended;
            }
            it2 = (ChannelIterator) this.L$1;
            producerScope3 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {211, 212, 213, 217, 218}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
    static final class C12961<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
        final /* synthetic */ ReceiveChannel<E> $this_dropWhile;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C12961(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super C12961> continuation) {
            super(2, continuation);
            this.$this_dropWhile = receiveChannel;
            this.$predicate = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12961 c12961 = new C12961(this.$this_dropWhile, this.$predicate, continuation);
            c12961.L$0 = obj;
            return c12961;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
            return ((C12961) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x00f9, code lost:
        
            if (r12 == r0) goto L45;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0061 A[PHI: r1 r8 r12
          0x0061: PHI (r1v3 kotlinx.coroutines.channels.ChannelIterator<E>) = (r1v5 kotlinx.coroutines.channels.ChannelIterator<E>), (r1v15 kotlinx.coroutines.channels.ChannelIterator<E>) binds: [B:21:0x0082, B:17:0x0056] A[DONT_GENERATE, DONT_INLINE]
          0x0061: PHI (r8v1 ??) = (r8v12 ??), (r8v13 ??) binds: [B:21:0x0082, B:17:0x0056] A[DONT_GENERATE, DONT_INLINE]
          0x0061: PHI (r12v3 java.lang.Object) = (r12v10 java.lang.Object), (r12v0 java.lang.Object) binds: [B:21:0x0082, B:17:0x0056] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00fc  */
        /* JADX WARN: Type inference failed for: r10v0 */
        /* JADX WARN: Type inference failed for: r10v3 */
        /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v13 */
        /* JADX WARN: Type inference failed for: r4v5 */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r8v0 */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v12 */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r9v6 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a3 -> B:16:0x0054). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00f9 -> B:10:0x0023). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator<E> it;
            ?? r8;
            ?? r82;
            ?? r1;
            ChannelIterator<E> it2;
            ?? r4;
            ChannelIterator<E> channelIterator;
            ?? r12;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                it = this.$this_dropWhile.iterator();
                r8 = producerScope;
                this.L$0 = r8;
                this.L$1 = it;
                this.L$2 = null;
                this.label = 1;
                obj = it.hasNext(this);
                r82 = r8;
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                it = (ChannelIterator) this.L$1;
                ProducerScope producerScope2 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                r82 = producerScope2;
                ?? r10 = r82;
                ChannelIterator<E> channelIterator2 = it;
                ?? r13 = r10;
                r1 = r13;
                if (((Boolean) obj).booleanValue()) {
                }
                it2 = this.$this_dropWhile.iterator();
                r12 = r1;
                this.L$0 = r12;
                this.L$1 = it2;
                this.label = 4;
                objHasNext = it2.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 2) {
                Object obj2 = this.L$2;
                ChannelIterator<E> channelIterator3 = (ChannelIterator) this.L$1;
                ProducerScope producerScope3 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                ChannelIterator<E> channelIterator4 = channelIterator3;
                Object obj3 = obj2;
                ?? r9 = producerScope3;
                it = channelIterator4;
                if (((Boolean) obj).booleanValue()) {
                    this.L$0 = r9;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 3;
                    if (r9.send(obj3, this) != coroutine_suspended) {
                        r1 = r9;
                        it2 = this.$this_dropWhile.iterator();
                        r12 = r1;
                        this.L$0 = r12;
                        this.L$1 = it2;
                        this.label = 4;
                        objHasNext = it2.hasNext(this);
                        if (objHasNext != coroutine_suspended) {
                        }
                    }
                    return coroutine_suspended;
                }
                r8 = r9;
                this.L$0 = r8;
                this.L$1 = it;
                this.L$2 = null;
                this.label = 1;
                obj = it.hasNext(this);
                r82 = r8;
                if (obj != coroutine_suspended) {
                    ?? r102 = r82;
                    ChannelIterator<E> channelIterator22 = it;
                    ?? r132 = r102;
                    r1 = r132;
                    if (((Boolean) obj).booleanValue()) {
                        E next = channelIterator22.next();
                        Function2<E, Continuation<? super Boolean>, Object> function2 = this.$predicate;
                        this.L$0 = r132;
                        this.L$1 = channelIterator22;
                        this.L$2 = next;
                        this.label = 2;
                        Object objInvoke = function2.invoke(next, this);
                        if (objInvoke != coroutine_suspended) {
                            channelIterator4 = channelIterator22;
                            obj3 = next;
                            obj = objInvoke;
                            r9 = r132;
                            it = channelIterator4;
                            if (((Boolean) obj).booleanValue()) {
                            }
                        }
                    }
                    it2 = this.$this_dropWhile.iterator();
                    r12 = r1;
                    this.L$0 = r12;
                    this.L$1 = it2;
                    this.label = 4;
                    objHasNext = it2.hasNext(this);
                    if (objHasNext != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            if (i == 3) {
                ProducerScope producerScope4 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                r1 = producerScope4;
                it2 = this.$this_dropWhile.iterator();
                r12 = r1;
                this.L$0 = r12;
                this.L$1 = it2;
                this.label = 4;
                objHasNext = it2.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 4) {
                if (i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelIterator = (ChannelIterator) this.L$1;
                ProducerScope producerScope5 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                ?? r42 = producerScope5;
                it2 = channelIterator;
                r12 = r42;
                this.L$0 = r12;
                this.L$1 = it2;
                this.label = 4;
                objHasNext = it2.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                    ?? r103 = r12;
                    channelIterator = it2;
                    obj = objHasNext;
                    r4 = r103;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    this.L$0 = r4;
                    this.L$1 = channelIterator;
                    this.label = 5;
                    Object objSend = r4.send(channelIterator.next(), this);
                    r42 = r4;
                }
                return coroutine_suspended;
            }
            channelIterator = (ChannelIterator) this.L$1;
            ProducerScope producerScope6 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            r4 = producerScope6;
            if (((Boolean) obj).booleanValue()) {
            }
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {68}, m = "elementAt", n = {"$this$consume$iv", FirebaseAnalytics.Param.INDEX, "count"}, s = {"L$0", "I$0", "I$1"})
    static final class C12971<E> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12971(Continuation<? super C12971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.elementAt(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {Imgproc.COLOR_RGB2YUV}, m = "elementAtOrNull", n = {"$this$consume$iv", FirebaseAnalytics.Param.INDEX, "count"}, s = {"L$0", "I$0", "I$1"})
    static final class C12981<E> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12981(Continuation<? super C12981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.elementAtOrNull(null, 0, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {228, 229, 229}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
    static final class C12991<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
        final /* synthetic */ ReceiveChannel<E> $this_filter;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C12991(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super C12991> continuation) {
            super(2, continuation);
            this.$this_filter = receiveChannel;
            this.$predicate = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12991 c12991 = new C12991(this.$this_filter, this.$predicate, continuation);
            c12991.L$0 = obj;
            return c12991;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
            return ((C12991) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0051, code lost:
        
            r6 = r7;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00a0  */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v13, types: [kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r6v14 */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r8v0 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator<E> it;
            ?? r6;
            ?? r7;
            Object obj2;
            ?? r62;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                it = this.$this_filter.iterator();
                r6 = producerScope;
            } else {
                if (i == 1) {
                    it = (ChannelIterator) this.L$1;
                    ProducerScope producerScope2 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r62 = producerScope2;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    E next = it.next();
                    Function2<E, Continuation<? super Boolean>, Object> function2 = this.$predicate;
                    this.L$0 = r62;
                    this.L$1 = it;
                    this.L$2 = next;
                    this.label = 2;
                    Object objInvoke = function2.invoke(next, this);
                    if (objInvoke != coroutine_suspended) {
                        ?? r8 = r62;
                        obj2 = next;
                        obj = objInvoke;
                        r7 = r8;
                        if (!((Boolean) obj).booleanValue()) {
                        }
                    }
                    return coroutine_suspended;
                }
                if (i == 2) {
                    Object obj3 = this.L$2;
                    ChannelIterator<E> channelIterator = (ChannelIterator) this.L$1;
                    ProducerScope producerScope3 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj3;
                    it = channelIterator;
                    r7 = producerScope3;
                    if (!((Boolean) obj).booleanValue()) {
                        this.L$0 = r7;
                        this.L$1 = it;
                        this.L$2 = null;
                        this.label = 3;
                        if (r7.send(obj2, this) != coroutine_suspended) {
                            r6 = r7;
                        }
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (ChannelIterator) this.L$1;
                    r6 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
            }
            this.L$0 = r6;
            this.L$1 = it;
            this.L$2 = null;
            this.label = 1;
            obj = it.hasNext(this);
            r62 = r6;
            if (obj != coroutine_suspended) {
                if (((Boolean) obj).booleanValue()) {
                }
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION, 242, 242}, m = "invokeSuspend", n = {"$this$produce", FirebaseAnalytics.Param.INDEX, "$this$produce", "e", FirebaseAnalytics.Param.INDEX, "$this$produce", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
    static final class C13001<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<Integer, E, Continuation<? super Boolean>, Object> $predicate;
        final /* synthetic */ ReceiveChannel<E> $this_filterIndexed;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C13001(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> function3, Continuation<? super C13001> continuation) {
            super(2, continuation);
            this.$this_filterIndexed = receiveChannel;
            this.$predicate = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13001 c13001 = new C13001(this.$this_filterIndexed, this.$predicate, continuation);
            c13001.L$0 = obj;
            return c13001;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
            return ((C13001) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x005b, code lost:
        
            r7 = r8;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v14, types: [kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r7v15 */
        /* JADX WARN: Type inference failed for: r7v16 */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r8v5 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator<E> it;
            int i;
            ?? r7;
            ?? r8;
            Object obj2;
            ?? r72;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                it = this.$this_filterIndexed.iterator();
                i = 0;
                r7 = producerScope;
            } else {
                if (i2 == 1) {
                    i = this.I$0;
                    it = (ChannelIterator) this.L$1;
                    ProducerScope producerScope2 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r72 = producerScope2;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    E next = it.next();
                    Function3<Integer, E, Continuation<? super Boolean>, Object> function3 = this.$predicate;
                    int i3 = i + 1;
                    Integer numBoxInt = Boxing.boxInt(i);
                    this.L$0 = r72;
                    this.L$1 = it;
                    this.L$2 = next;
                    this.I$0 = i3;
                    this.label = 2;
                    Object objInvoke = function3.invoke(numBoxInt, next, this);
                    if (objInvoke != coroutine_suspended) {
                        r8 = r72;
                        obj2 = next;
                        obj = objInvoke;
                        i = i3;
                        if (!((Boolean) obj).booleanValue()) {
                        }
                    }
                    return coroutine_suspended;
                }
                if (i2 == 2) {
                    i = this.I$0;
                    Object obj3 = this.L$2;
                    ChannelIterator<E> channelIterator = (ChannelIterator) this.L$1;
                    ProducerScope producerScope3 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj3;
                    it = channelIterator;
                    r8 = producerScope3;
                    if (!((Boolean) obj).booleanValue()) {
                        this.L$0 = r8;
                        this.L$1 = it;
                        this.L$2 = null;
                        this.I$0 = i;
                        this.label = 3;
                        if (r8.send(obj2, this) != coroutine_suspended) {
                            r7 = r8;
                        }
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = this.I$0;
                    it = (ChannelIterator) this.L$1;
                    r7 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
            }
            this.L$0 = r7;
            this.L$1 = it;
            this.L$2 = null;
            this.I$0 = i;
            this.label = 1;
            obj = it.hasNext(this);
            r72 = r7;
            if (obj != coroutine_suspended) {
                if (((Boolean) obj).booleanValue()) {
                }
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1", f = "Deprecated.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
    static final class C13011<E> extends SuspendLambda implements Function2<E, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C13011(Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super C13011> continuation) {
            super(2, continuation);
            this.$predicate = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13011 c13011 = new C13011(this.$predicate, continuation);
            c13011.L$0 = obj;
            return c13011;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(E e, Continuation<? super Boolean> continuation) {
            return ((C13011) create(e, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1<E> for r3v5 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r4)
                goto L27
            Lf:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r4)
                throw r3
            L17:
                kotlin.ResultKt.throwOnFailure(r4)
                java.lang.Object r4 = r3.L$0
                kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r1 = r3.$predicate
                r3.label = r2
                java.lang.Object r4 = r1.invoke(r4, r3)
                if (r4 != r0) goto L27
                return r0
            L27:
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r3 = r4.booleanValue()
                r3 = r3 ^ r2
                java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.C13011.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0002H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C13021<E> extends SuspendLambda implements Function2<E, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C13021(Continuation<? super C13021> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13021 c13021 = new C13021(continuation);
            c13021.L$0 = obj;
            return c13021;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(E e, Continuation<? super Boolean> continuation) {
            return ((C13021) create(e, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(this.L$0 != null);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {514}, m = "filterNotNullTo", n = {FirebaseAnalytics.Param.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class C13031<E, C extends Collection<? super E>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13031(Continuation<? super C13031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.filterNotNullTo((ReceiveChannel) null, (Collection) null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3, reason: invalid class name */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {514, Imgcodecs.IMWRITE_JPEG2000_COMPRESSION_X1000}, m = "filterNotNullTo", n = {FirebaseAnalytics.Param.DESTINATION, "$this$consume$iv$iv", FirebaseAnalytics.Param.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class AnonymousClass3<E, C extends SendChannel<? super E>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.filterNotNullTo((ReceiveChannel) null, (SendChannel) null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {Imgproc.COLOR_YUV2BGRA_NV12}, m = "first", n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
    static final class C13041<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13041(Continuation<? super C13041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.first(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {105}, m = "firstOrNull", n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
    static final class C13051<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13051(Continuation<? super C13051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.firstOrNull(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {351, 352, 352}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
    static final class C13061<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_flatMap;
        final /* synthetic */ Function2<E, Continuation<? super ReceiveChannel<? extends R>>, Object> $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C13061(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super ReceiveChannel<? extends R>>, ? extends Object> function2, Continuation<? super C13061> continuation) {
            super(2, continuation);
            this.$this_flatMap = receiveChannel;
            this.$transform = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13061 c13061 = new C13061(this.$this_flatMap, this.$transform, continuation);
            c13061.L$0 = obj;
            return c13061;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
            return ((C13061) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0088 -> B:13:0x004b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1<R> for r8v3 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L3d
                if (r1 == r4) goto L31
                if (r1 == r3) goto L25
                if (r1 != r2) goto L1d
                java.lang.Object r1 = r8.L$1
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r5 = r8.L$0
                kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
                kotlin.ResultKt.throwOnFailure(r9)
                goto L4b
            L1d:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L25:
                java.lang.Object r1 = r8.L$1
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r5 = r8.L$0
                kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
                kotlin.ResultKt.throwOnFailure(r9)
                goto L76
            L31:
                java.lang.Object r1 = r8.L$1
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r5 = r8.L$0
                kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
                kotlin.ResultKt.throwOnFailure(r9)
                goto L5b
            L3d:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.Object r9 = r8.L$0
                kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
                kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r8.$this_flatMap
                kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
                r5 = r9
            L4b:
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r8.L$0 = r5
                r8.L$1 = r1
                r8.label = r4
                java.lang.Object r9 = r1.hasNext(r9)
                if (r9 != r0) goto L5b
                goto L8a
            L5b:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto L8b
                java.lang.Object r9 = r1.next()
                kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ReceiveChannel<? extends R>>, java.lang.Object> r6 = r8.$transform
                r8.L$0 = r5
                r8.L$1 = r1
                r8.label = r3
                java.lang.Object r9 = r6.invoke(r9, r8)
                if (r9 != r0) goto L76
                goto L8a
            L76:
                kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
                r6 = r5
                kotlinx.coroutines.channels.SendChannel r6 = (kotlinx.coroutines.channels.SendChannel) r6
                r7 = r8
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r8.L$0 = r5
                r8.L$1 = r1
                r8.label = r2
                java.lang.Object r9 = kotlinx.coroutines.channels.ChannelsKt.toChannel(r9, r6, r7)
                if (r9 != r0) goto L4b
            L8a:
                return r0
            L8b:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.C13061.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {514}, m = "indexOf", n = {"element", FirebaseAnalytics.Param.INDEX, "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class C13071<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C13071(Continuation<? super C13071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.indexOf(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {127, 130}, m = "last", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class C13081<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13081(Continuation<? super C13081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.last(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0}, l = {514}, m = "lastIndexOf", n = {"element", "lastIndex", FirebaseAnalytics.Param.INDEX, "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C13091<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C13091(Continuation<? super C13091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.lastIndexOf(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {Imgproc.COLOR_RGBA2YUV_YVYU, WebmConstants.MkvEbmlElement.FLAG_LACING}, m = "lastOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class C13101<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13101(Continuation<? super C13101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.lastOrNull(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {514, 363, 363}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
    static final class C13111<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_map;
        final /* synthetic */ Function2<E, Continuation<? super R>, Object> $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C13111(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super C13111> continuation) {
            super(2, continuation);
            this.$this_map = receiveChannel;
            this.$transform = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13111 c13111 = new C13111(this.$this_map, this.$transform, continuation);
            c13111.L$0 = obj;
            return c13111;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
            return ((C13111) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0092 A[Catch: all -> 0x00d0, TRY_LEAVE, TryCatch #0 {all -> 0x00d0, blocks: (B:8:0x0022, B:23:0x0075, B:27:0x008a, B:29:0x0092, B:37:0x00c8, B:18:0x005d, B:21:0x006d), top: B:45:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00c8 A[Catch: all -> 0x00d0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00d0, blocks: (B:8:0x0022, B:23:0x0075, B:27:0x008a, B:29:0x0092, B:37:0x00c8, B:18:0x005d, B:21:0x006d), top: B:45:0x000a }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c2 -> B:23:0x0075). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ReceiveChannel receiveChannel;
            ProducerScope producerScope;
            Function2 function2;
            ChannelIterator it;
            Throwable th;
            Throwable th2;
            Throwable th3;
            ProducerScope producerScope2;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Throwable th4) {
                th = th4;
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                producerScope = (ProducerScope) this.L$0;
                receiveChannel = this.$this_map;
                function2 = this.$transform;
                it = receiveChannel.iterator();
            } else {
                if (i == 1) {
                    it = (ChannelIterator) this.L$3;
                    receiveChannel = (ReceiveChannel) this.L$2;
                    function2 = (Function2) this.L$1;
                    producerScope2 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    th3 = null;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    throw th;
                }
                if (i == 2) {
                    ProducerScope producerScope3 = (ProducerScope) this.L$4;
                    ChannelIterator channelIterator = (ChannelIterator) this.L$3;
                    ReceiveChannel receiveChannel2 = (ReceiveChannel) this.L$2;
                    Function2 function22 = (Function2) this.L$1;
                    ProducerScope producerScope4 = (ProducerScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        th = null;
                        this.L$0 = producerScope4;
                        this.L$1 = function22;
                        this.L$2 = receiveChannel2;
                        this.L$3 = channelIterator;
                        this.L$4 = null;
                        this.label = 3;
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel = receiveChannel2;
                    }
                    if (producerScope3.send(obj, this) != coroutine_suspended) {
                        it = channelIterator;
                        receiveChannel = receiveChannel2;
                        function2 = function22;
                        producerScope = producerScope4;
                        th2 = th;
                        this.L$0 = producerScope;
                        this.L$1 = function2;
                        this.L$2 = receiveChannel;
                        this.L$3 = it;
                        this.label = 1;
                        objHasNext = it.hasNext(this);
                        if (objHasNext == coroutine_suspended) {
                            Throwable th6 = th2;
                            producerScope2 = producerScope;
                            obj = objHasNext;
                            th3 = th6;
                            if (((Boolean) obj).booleanValue()) {
                                Unit unit = Unit.INSTANCE;
                                ChannelsKt.cancelConsumed(receiveChannel, th3);
                                return Unit.INSTANCE;
                            }
                            Object next = it.next();
                            this.L$0 = producerScope2;
                            this.L$1 = function2;
                            this.L$2 = receiveChannel;
                            this.L$3 = it;
                            this.L$4 = producerScope2;
                            this.label = 2;
                            obj = function2.invoke(next, this);
                            if (obj != coroutine_suspended) {
                                th = th3;
                                producerScope4 = producerScope2;
                                function22 = function2;
                                receiveChannel2 = receiveChannel;
                                channelIterator = it;
                                producerScope3 = producerScope4;
                                this.L$0 = producerScope4;
                                this.L$1 = function22;
                                this.L$2 = receiveChannel2;
                                this.L$3 = channelIterator;
                                this.L$4 = null;
                                this.label = 3;
                                if (producerScope3.send(obj, this) != coroutine_suspended) {
                                }
                            }
                            try {
                                throw th;
                            } catch (Throwable th7) {
                                ChannelsKt.cancelConsumed(receiveChannel, th);
                                throw th7;
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (ChannelIterator) this.L$3;
                receiveChannel = (ReceiveChannel) this.L$2;
                function2 = (Function2) this.L$1;
                ProducerScope producerScope5 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                producerScope = producerScope5;
            }
            th2 = null;
            this.L$0 = producerScope;
            this.L$1 = function2;
            this.L$2 = receiveChannel;
            this.L$3 = it;
            this.label = 1;
            objHasNext = it.hasNext(this);
            if (objHasNext == coroutine_suspended) {
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {374, 375, 375}, m = "invokeSuspend", n = {"$this$produce", FirebaseAnalytics.Param.INDEX, "$this$produce", FirebaseAnalytics.Param.INDEX, "$this$produce", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    static final class C13121<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_mapIndexed;
        final /* synthetic */ Function3<Integer, E, Continuation<? super R>, Object> $transform;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C13121(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super C13121> continuation) {
            super(2, continuation);
            this.$this_mapIndexed = receiveChannel;
            this.$transform = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13121 c13121 = new C13121(this.$this_mapIndexed, this.$transform, continuation);
            c13121.L$0 = obj;
            return c13121;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
            return ((C13121) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ac -> B:13:0x0059). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1<R> for r11v3 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L48
                if (r1 == r4) goto L3a
                if (r1 == r3) goto L28
                if (r1 != r2) goto L20
                int r1 = r11.I$0
                java.lang.Object r5 = r11.L$1
                kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
                java.lang.Object r6 = r11.L$0
                kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
                kotlin.ResultKt.throwOnFailure(r12)
                r12 = r6
                goto L59
            L20:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L28:
                int r1 = r11.I$0
                java.lang.Object r5 = r11.L$2
                kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
                java.lang.Object r6 = r11.L$1
                kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
                java.lang.Object r7 = r11.L$0
                kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
                kotlin.ResultKt.throwOnFailure(r12)
                goto L97
            L3a:
                int r1 = r11.I$0
                java.lang.Object r5 = r11.L$1
                kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
                java.lang.Object r6 = r11.L$0
                kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
                kotlin.ResultKt.throwOnFailure(r12)
                goto L6e
            L48:
                kotlin.ResultKt.throwOnFailure(r12)
                java.lang.Object r12 = r11.L$0
                kotlinx.coroutines.channels.ProducerScope r12 = (kotlinx.coroutines.channels.ProducerScope) r12
                kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r11.$this_mapIndexed
                kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
                r5 = 0
                r10 = r5
                r5 = r1
                r1 = r10
            L59:
                r6 = r11
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r11.L$0 = r12
                r11.L$1 = r5
                r11.I$0 = r1
                r11.label = r4
                java.lang.Object r6 = r5.hasNext(r6)
                if (r6 != r0) goto L6b
                goto Lab
            L6b:
                r10 = r6
                r6 = r12
                r12 = r10
            L6e:
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                if (r12 == 0) goto Laf
                java.lang.Object r12 = r5.next()
                kotlin.jvm.functions.Function3<java.lang.Integer, E, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r7 = r11.$transform
                int r8 = r1 + 1
                java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
                r11.L$0 = r6
                r11.L$1 = r5
                r11.L$2 = r6
                r11.I$0 = r8
                r11.label = r3
                java.lang.Object r12 = r7.invoke(r1, r12, r11)
                if (r12 != r0) goto L93
                goto Lab
            L93:
                r7 = r6
                r1 = r8
                r6 = r5
                r5 = r7
            L97:
                r8 = r11
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r11.L$0 = r7
                r11.L$1 = r6
                r9 = 0
                r11.L$2 = r9
                r11.I$0 = r1
                r11.label = r2
                java.lang.Object r12 = r5.send(r12, r8)
                if (r12 != r0) goto Lac
            Lab:
                return r0
            Lac:
                r5 = r6
                r12 = r7
                goto L59
            Laf:
                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.C13121.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {Videoio.CAP_PROP_XI_WB_KB, Videoio.CAP_PROP_XI_HEIGHT}, m = "maxWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "max"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class C13131<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C13131(Continuation<? super C13131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.maxWith(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {Videoio.CAP_PROP_XI_OUTPUT_DATA_PACKING_TYPE, Videoio.CAP_PROP_XI_COOLING}, m = "minWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "min"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class C13141<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C13141(Continuation<? super C13141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.minWith(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {Videoio.CAP_PROP_XI_GAMMAC}, m = "none", n = {"$this$consume$iv"}, s = {"L$0"})
    static final class C13151<E> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C13151(Continuation<? super C13151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.none(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0001H\n"}, d2 = {"<anonymous>", ExifInterface.LONGITUDE_EAST, "", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C13161<E> extends SuspendLambda implements Function2<E, Continuation<? super E>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_requireNoNulls;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C13161(ReceiveChannel<? extends E> receiveChannel, Continuation<? super C13161> continuation) {
            super(2, continuation);
            this.$this_requireNoNulls = receiveChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13161 c13161 = new C13161(this.$this_requireNoNulls, continuation);
            c13161.L$0 = obj;
            return c13161;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(E e, Continuation<? super E> continuation) {
            return ((C13161) create(e, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            if (obj2 != null) {
                return obj2;
            }
            throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + FilenameUtils.EXTENSION_SEPARATOR);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {WebmConstants.MkvEbmlElement.BLOCK_MORE, 169}, m = "single", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C13171<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13171(Continuation<? super C13171> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.single(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {WebmConstants.MkvEbmlElement.CUE_TIME, 182}, m = "singleOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C13181<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13181(Continuation<? super C13181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.singleOrNull(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {284, 285}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
    static final class C13191<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $n;
        final /* synthetic */ ReceiveChannel<E> $this_take;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C13191(int i, ReceiveChannel<? extends E> receiveChannel, Continuation<? super C13191> continuation) {
            super(2, continuation);
            this.$n = i;
            this.$this_take = receiveChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13191 c13191 = new C13191(this.$n, this.$this_take, continuation);
            c13191.L$0 = obj;
            return c13191;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
            return ((C13191) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x007e, code lost:
        
            if (r5.send(r4.next(), r8) == r0) goto L28;
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0088  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007e -> B:7:0x001b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ProducerScope producerScope;
            int i;
            ChannelIterator<E> it;
            ProducerScope producerScope2;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                producerScope = (ProducerScope) this.L$0;
                i = this.$n;
                if (i == 0) {
                    return Unit.INSTANCE;
                }
                if (!(i >= 0)) {
                    throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
                }
                it = this.$this_take.iterator();
                this.L$0 = producerScope;
                this.L$1 = it;
                this.I$0 = i;
                this.label = 1;
                objHasNext = it.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                it = (ChannelIterator) this.L$1;
                producerScope2 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                producerScope = producerScope2;
                i--;
                if (i == 0) {
                    return Unit.INSTANCE;
                }
                this.L$0 = producerScope;
                this.L$1 = it;
                this.I$0 = i;
                this.label = 1;
                objHasNext = it.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                    producerScope2 = producerScope;
                    obj = objHasNext;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    this.L$0 = producerScope2;
                    this.L$1 = it;
                    this.I$0 = i;
                    this.label = 2;
                }
                return coroutine_suspended;
            }
            i = this.I$0;
            it = (ChannelIterator) this.L$1;
            producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {299, 300, 301}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
    static final class C13201<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
        final /* synthetic */ ReceiveChannel<E> $this_takeWhile;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C13201(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super C13201> continuation) {
            super(2, continuation);
            this.$this_takeWhile = receiveChannel;
            this.$predicate = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13201 c13201 = new C13201(this.$this_takeWhile, this.$predicate, continuation);
            c13201.L$0 = obj;
            return c13201;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
            return ((C13201) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v13 */
        /* JADX WARN: Type inference failed for: r5v14 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v6 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x009d -> B:13:0x004d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator<E> it;
            ?? r5;
            ?? r6;
            ChannelIterator<E> channelIterator;
            Object obj2;
            ?? r52;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                it = this.$this_takeWhile.iterator();
                r5 = producerScope;
            } else {
                if (i == 1) {
                    it = (ChannelIterator) this.L$1;
                    ProducerScope producerScope2 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r52 = producerScope2;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    E next = it.next();
                    Function2<E, Continuation<? super Boolean>, Object> function2 = this.$predicate;
                    this.L$0 = r52;
                    this.L$1 = it;
                    this.L$2 = next;
                    this.label = 2;
                    Object objInvoke = function2.invoke(next, this);
                    if (objInvoke != coroutine_suspended) {
                        ChannelIterator<E> channelIterator2 = it;
                        obj2 = next;
                        obj = objInvoke;
                        r6 = r52;
                        channelIterator = channelIterator2;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    }
                    return coroutine_suspended;
                }
                if (i == 2) {
                    obj2 = this.L$2;
                    channelIterator = (ChannelIterator) this.L$1;
                    ProducerScope producerScope3 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r6 = producerScope3;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    this.L$0 = r6;
                    this.L$1 = channelIterator;
                    this.L$2 = null;
                    this.label = 3;
                    if (r6.send(obj2, this) != coroutine_suspended) {
                        it = channelIterator;
                        r5 = r6;
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (ChannelIterator) this.L$1;
                ProducerScope producerScope4 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                r5 = producerScope4;
            }
            this.L$0 = r5;
            this.L$1 = it;
            this.label = 1;
            obj = it.hasNext(this);
            r52 = r5;
            if (obj != coroutine_suspended) {
                if (((Boolean) obj).booleanValue()) {
                }
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {514, 308}, m = "toChannel", n = {FirebaseAnalytics.Param.DESTINATION, "$this$consume$iv$iv", FirebaseAnalytics.Param.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C13211<E, C extends SendChannel<? super E>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13211(Continuation<? super C13211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.toChannel(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {514}, m = "toCollection", n = {FirebaseAnalytics.Param.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class C13221<E, C extends Collection<? super E>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13221(Continuation<? super C13221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.toCollection(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2, reason: invalid class name */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {514}, m = "toMap", n = {FirebaseAnalytics.Param.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class AnonymousClass2<K, V, M extends Map<? super K, ? super V>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.toMap(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/collections/IndexedValue;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {400, 401}, m = "invokeSuspend", n = {"$this$produce", FirebaseAnalytics.Param.INDEX, "$this$produce", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "I$0", "L$0", "I$0"})
    static final class C13231<E> extends SuspendLambda implements Function2<ProducerScope<? super IndexedValue<? extends E>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_withIndex;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C13231(ReceiveChannel<? extends E> receiveChannel, Continuation<? super C13231> continuation) {
            super(2, continuation);
            this.$this_withIndex = receiveChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13231 c13231 = new C13231(this.$this_withIndex, continuation);
            c13231.L$0 = obj;
            return c13231;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super IndexedValue<? extends E>> producerScope, Continuation<? super Unit> continuation) {
            return ((C13231) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0081 -> B:7:0x001e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ProducerScope producerScope;
            ChannelIterator<E> it;
            int i;
            ProducerScope producerScope2;
            ChannelIterator<E> channelIterator;
            int i2;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                producerScope = (ProducerScope) this.L$0;
                it = this.$this_withIndex.iterator();
                i = 0;
                this.L$0 = producerScope;
                this.L$1 = it;
                this.I$0 = i;
                this.label = 1;
                objHasNext = it.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i4 = this.I$0;
                ChannelIterator<E> channelIterator2 = (ChannelIterator) this.L$1;
                producerScope2 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                i = i4;
                it = channelIterator2;
                producerScope = producerScope2;
                this.L$0 = producerScope;
                this.L$1 = it;
                this.I$0 = i;
                this.label = 1;
                objHasNext = it.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                    producerScope2 = producerScope;
                    obj = objHasNext;
                    int i5 = i;
                    channelIterator = it;
                    i2 = i5;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    int i6 = i2 + 1;
                    this.L$0 = producerScope2;
                    this.L$1 = channelIterator;
                    this.I$0 = i6;
                    this.label = 2;
                    if (producerScope2.send(new IndexedValue(i2, channelIterator.next()), this) != coroutine_suspended) {
                        it = channelIterator;
                        i = i6;
                        producerScope = producerScope2;
                        this.L$0 = producerScope;
                        this.L$1 = it;
                        this.I$0 = i;
                        this.label = 1;
                        objHasNext = it.hasNext(this);
                        if (objHasNext != coroutine_suspended) {
                        }
                    }
                }
                return coroutine_suspended;
            }
            i2 = this.I$0;
            channelIterator = (ChannelIterator) this.L$1;
            producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {514, Videoio.CAP_PROP_XI_ACQ_FRAME_BURST_COUNT, TypedValues.PositionType.TYPE_TRANSITION_EASING}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
    static final class C13242<V> extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<R> $other;
        final /* synthetic */ ReceiveChannel<E> $this_zip;
        final /* synthetic */ Function2<E, R, V> $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C13242(ReceiveChannel<? extends R> receiveChannel, ReceiveChannel<? extends E> receiveChannel2, Function2<? super E, ? super R, ? extends V> function2, Continuation<? super C13242> continuation) {
            super(2, continuation);
            this.$other = receiveChannel;
            this.$this_zip = receiveChannel2;
            this.$transform = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13242 c13242 = new C13242(this.$other, this.$this_zip, this.$transform, continuation);
            c13242.L$0 = obj;
            return c13242;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super V> producerScope, Continuation<? super Unit> continuation) {
            return ((C13242) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:57:0x0092, code lost:
        
            r14 = r7;
            r6 = r8;
            r7 = r9;
            r8 = r10;
            r9 = r11;
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b8 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #3 {all -> 0x0056, blocks: (B:27:0x00b0, B:29:0x00b8, B:41:0x0108, B:13:0x0049), top: B:55:0x0049 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00e2 A[Catch: all -> 0x0105, TRY_LEAVE, TryCatch #2 {all -> 0x0105, blocks: (B:33:0x00da, B:35:0x00e2), top: B:53:0x00da }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0108 A[Catch: all -> 0x0056, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0056, blocks: (B:27:0x00b0, B:29:0x00b8, B:41:0x0108, B:13:0x0049), top: B:55:0x0049 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ReceiveChannel receiveChannel;
            Function2 function2;
            ChannelIterator channelIterator;
            ChannelIterator it;
            ProducerScope producerScope;
            ReceiveChannel receiveChannel2;
            Throwable th;
            ProducerScope producerScope2;
            ChannelIterator channelIterator2;
            Function2 function22;
            ChannelIterator channelIterator3;
            Throwable th2;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ProducerScope producerScope3 = (ProducerScope) this.L$0;
                    ChannelIterator it2 = this.$other.iterator();
                    receiveChannel = this.$this_zip;
                    function2 = this.$transform;
                    channelIterator = it2;
                    it = receiveChannel.iterator();
                    producerScope = producerScope3;
                } else if (i == 1) {
                    ChannelIterator channelIterator4 = (ChannelIterator) this.L$4;
                    ReceiveChannel receiveChannel3 = (ReceiveChannel) this.L$3;
                    Function2 function23 = (Function2) this.L$2;
                    ChannelIterator channelIterator5 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope4 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    producerScope2 = producerScope4;
                    channelIterator2 = channelIterator5;
                    function22 = function23;
                    receiveChannel2 = receiveChannel3;
                    channelIterator3 = channelIterator4;
                    th2 = null;
                    if (((Boolean) obj).booleanValue()) {
                    }
                } else {
                    if (i == 2) {
                        Object obj2 = this.L$5;
                        ChannelIterator channelIterator6 = (ChannelIterator) this.L$4;
                        receiveChannel2 = (ReceiveChannel) this.L$3;
                        Function2 function24 = (Function2) this.L$2;
                        ChannelIterator channelIterator7 = (ChannelIterator) this.L$1;
                        ProducerScope producerScope5 = (ProducerScope) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            Object obj3 = obj2;
                            it = channelIterator6;
                            ProducerScope producerScope6 = producerScope5;
                            ChannelIterator channelIterator8 = channelIterator7;
                            Function2 function25 = function24;
                            ReceiveChannel receiveChannel4 = receiveChannel2;
                            Throwable th3 = null;
                            try {
                                if (!((Boolean) obj).booleanValue()) {
                                    Object objInvoke = function25.invoke(obj3, channelIterator8.next());
                                    this.L$0 = producerScope6;
                                    this.L$1 = channelIterator8;
                                    this.L$2 = function25;
                                    this.L$3 = receiveChannel4;
                                    this.L$4 = it;
                                    this.L$5 = null;
                                    this.label = 3;
                                    if (producerScope6.send(objInvoke, this) != coroutine_suspended) {
                                        th = th3;
                                        receiveChannel = receiveChannel4;
                                        function2 = function25;
                                        channelIterator = channelIterator8;
                                        producerScope = producerScope6;
                                    }
                                    return coroutine_suspended;
                                }
                                this.L$0 = producerScope;
                                this.L$1 = channelIterator;
                                this.L$2 = function2;
                                this.L$3 = receiveChannel;
                                this.L$4 = it;
                                this.L$5 = null;
                                this.label = 1;
                                objHasNext = it.hasNext(this);
                                if (objHasNext != coroutine_suspended) {
                                    ChannelIterator channelIterator9 = it;
                                    th2 = th;
                                    obj = objHasNext;
                                    producerScope2 = producerScope;
                                    channelIterator2 = channelIterator;
                                    function22 = function2;
                                    receiveChannel2 = receiveChannel;
                                    channelIterator3 = channelIterator9;
                                    if (((Boolean) obj).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                                        return Unit.INSTANCE;
                                    }
                                    Object next = channelIterator3.next();
                                    this.L$0 = producerScope2;
                                    this.L$1 = channelIterator2;
                                    this.L$2 = function22;
                                    this.L$3 = receiveChannel2;
                                    this.L$4 = channelIterator3;
                                    this.L$5 = next;
                                    this.label = 2;
                                    Object objHasNext2 = channelIterator2.hasNext(this);
                                    if (objHasNext2 != coroutine_suspended) {
                                        ChannelIterator channelIterator10 = channelIterator3;
                                        obj3 = next;
                                        obj = objHasNext2;
                                        producerScope6 = producerScope2;
                                        channelIterator8 = channelIterator2;
                                        function25 = function22;
                                        receiveChannel4 = receiveChannel2;
                                        th3 = th2;
                                        it = channelIterator10;
                                        if (!((Boolean) obj).booleanValue()) {
                                        }
                                        this.L$0 = producerScope;
                                        this.L$1 = channelIterator;
                                        this.L$2 = function2;
                                        this.L$3 = receiveChannel;
                                        this.L$4 = it;
                                        this.L$5 = null;
                                        this.label = 1;
                                        objHasNext = it.hasNext(this);
                                        if (objHasNext != coroutine_suspended) {
                                        }
                                    }
                                }
                                return coroutine_suspended;
                            } catch (Throwable th4) {
                                th = th4;
                                receiveChannel = receiveChannel4;
                                try {
                                    throw th;
                                } catch (Throwable th5) {
                                    ChannelsKt.cancelConsumed(receiveChannel, th);
                                    throw th5;
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel = receiveChannel2;
                            throw th;
                        }
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (ChannelIterator) this.L$4;
                    receiveChannel = (ReceiveChannel) this.L$3;
                    function2 = (Function2) this.L$2;
                    channelIterator = (ChannelIterator) this.L$1;
                    producerScope = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                th = null;
                this.L$0 = producerScope;
                this.L$1 = channelIterator;
                this.L$2 = function2;
                this.L$3 = receiveChannel;
                this.L$4 = it;
                this.L$5 = null;
                this.label = 1;
                objHasNext = it.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object any(ReceiveChannel receiveChannel, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objHasNext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objHasNext);
                ChannelIterator it = receiveChannel.iterator();
                anonymousClass1.L$0 = receiveChannel;
                anonymousClass1.label = 1;
                objHasNext = it.hasNext(anonymousClass1);
                if (objHasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                receiveChannel = (ReceiveChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objHasNext);
            }
            ChannelsKt.cancelConsumed(receiveChannel, null);
            return objHasNext;
        } finally {
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E, R> R consume(BroadcastChannel<E> broadcastChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        ReceiveChannel<E> receiveChannelOpenSubscription = broadcastChannel.openSubscription();
        try {
            return function1.invoke(receiveChannelOpenSubscription);
        } finally {
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannelOpenSubscription, (CancellationException) null, 1, (Object) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:26:0x0066, B:28:0x006e, B:29:0x0078), top: B:40:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078 A[Catch: all -> 0x0080, TRY_LEAVE, TryCatch #0 {all -> 0x0080, blocks: (B:26:0x0066, B:28:0x006e, B:29:0x0078), top: B:40:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0062 -> B:14:0x0039). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.ERROR, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object consumeEach(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) throws Throwable {
        C12911 c12911;
        ReceiveChannel<E> receiveChannel;
        Throwable th;
        ReceiveChannel<E> receiveChannel2;
        ChannelIterator it;
        Object objHasNext;
        if (continuation instanceof C12911) {
            c12911 = (C12911) continuation;
            if ((c12911.label & Integer.MIN_VALUE) != 0) {
                c12911.label -= Integer.MIN_VALUE;
            } else {
                c12911 = new C12911(continuation);
            }
        }
        Object obj = c12911.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12911.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ReceiveChannel<E> receiveChannelOpenSubscription = broadcastChannel.openSubscription();
            try {
                receiveChannel2 = receiveChannelOpenSubscription;
                it = receiveChannelOpenSubscription.iterator();
                c12911.L$0 = function1;
                c12911.L$1 = receiveChannel2;
                c12911.L$2 = it;
                c12911.label = 1;
                objHasNext = it.hasNext(c12911);
                if (objHasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                receiveChannel = receiveChannelOpenSubscription;
                th = th2;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (ChannelIterator) c12911.L$2;
            receiveChannel = (ReceiveChannel) c12911.L$1;
            Function1<? super E, Unit> function12 = (Function1) c12911.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                C12911 c129112 = c12911;
                ReceiveChannel<E> receiveChannel3 = receiveChannel;
                function1 = function12;
                C12911 c129113 = c129112;
                try {
                    if (!((Boolean) obj).booleanValue()) {
                        function1.invoke((Object) it.next());
                        receiveChannel2 = receiveChannel3;
                        c12911 = c129113;
                        try {
                            c12911.L$0 = function1;
                            c12911.L$1 = receiveChannel2;
                            c12911.L$2 = it;
                            c12911.label = 1;
                            objHasNext = it.hasNext(c12911);
                            if (objHasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            c129112 = c12911;
                            receiveChannel3 = receiveChannel2;
                            obj = objHasNext;
                            C12911 c1291132 = c129112;
                            if (!((Boolean) obj).booleanValue()) {
                                Unit unit = Unit.INSTANCE;
                                ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel3, (CancellationException) null, 1, (Object) null);
                                return Unit.INSTANCE;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            receiveChannel = receiveChannel2;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    receiveChannel = receiveChannel3;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel, (CancellationException) null, 1, (Object) null);
        throw th;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    private static final <E> Object consumeEach$$forInline(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel<E> receiveChannelOpenSubscription = broadcastChannel.openSubscription();
        try {
            ReceiveChannel<E> receiveChannel = receiveChannelOpenSubscription;
            ChannelIterator<E> it = receiveChannelOpenSubscription.iterator();
            while (((Boolean) it.hasNext(null)).booleanValue()) {
                function1.invoke(it.next());
            }
            Unit unit = Unit.INSTANCE;
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannelOpenSubscription, (CancellationException) null, 1, (Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannelOpenSubscription, (CancellationException) null, 1, (Object) null);
            throw th;
        }
    }

    public static final Function1<Throwable, Unit> consumes(final ReceiveChannel<?> receiveChannel) {
        return new Function1() { // from class: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChannelsKt__DeprecatedKt.consumes$lambda$24$ChannelsKt__DeprecatedKt(receiveChannel, (Throwable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit consumes$lambda$24$ChannelsKt__DeprecatedKt(ReceiveChannel receiveChannel, Throwable th) {
        ChannelsKt.cancelConsumed(receiveChannel, th);
        return Unit.INSTANCE;
    }

    public static final Function1<Throwable, Unit> consumesAll(final ReceiveChannel<?>... receiveChannelArr) {
        return new Function1() { // from class: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChannelsKt__DeprecatedKt.consumesAll$lambda$2$ChannelsKt__DeprecatedKt(receiveChannelArr, (Throwable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit consumesAll$lambda$2$ChannelsKt__DeprecatedKt(ReceiveChannel[] receiveChannelArr, Throwable th) throws Throwable {
        Throwable th2 = null;
        for (ReceiveChannel receiveChannel : receiveChannelArr) {
            try {
                ChannelsKt.cancelConsumed(receiveChannel, th);
            } catch (Throwable th3) {
                if (th2 == null) {
                    th2 = th3;
                } else {
                    ExceptionsKt.addSuppressed(th2, th3);
                }
            }
        }
        if (th2 == null) {
            return Unit.INSTANCE;
        }
        throw th2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006a A[Catch: all -> 0x0037, TryCatch #3 {all -> 0x0037, blocks: (B:12:0x0033, B:25:0x0062, B:27:0x006a, B:28:0x0074), top: B:45:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074 A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #3 {all -> 0x0037, blocks: (B:12:0x0033, B:25:0x0062, B:27:0x006a, B:28:0x0074), top: B:45:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005f -> B:25:0x0062). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object count(ReceiveChannel receiveChannel, Continuation continuation) {
        C12921 c12921;
        ReceiveChannel receiveChannel2;
        Throwable th;
        Ref.IntRef intRef;
        ReceiveChannel receiveChannel3;
        ChannelIterator it;
        Object objHasNext;
        if (continuation instanceof C12921) {
            c12921 = (C12921) continuation;
            if ((c12921.label & Integer.MIN_VALUE) != 0) {
                c12921.label -= Integer.MIN_VALUE;
            } else {
                c12921 = new C12921(continuation);
            }
        }
        Object obj = c12921.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12921.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                intRef = new Ref.IntRef();
                receiveChannel3 = receiveChannel;
                it = receiveChannel.iterator();
                c12921.L$0 = intRef;
                c12921.L$1 = receiveChannel3;
                c12921.L$2 = it;
                c12921.label = 1;
                objHasNext = it.hasNext(c12921);
                if (objHasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (ChannelIterator) c12921.L$2;
            receiveChannel2 = (ReceiveChannel) c12921.L$1;
            intRef = (Ref.IntRef) c12921.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                    it.next();
                    intRef.element++;
                    receiveChannel3 = receiveChannel2;
                    try {
                        c12921.L$0 = intRef;
                        c12921.L$1 = receiveChannel3;
                        c12921.L$2 = it;
                        c12921.label = 1;
                        objHasNext = it.hasNext(c12921);
                        if (objHasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel3;
                        obj = objHasNext;
                        if (!((Boolean) obj).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel2, null);
                            return Boxing.boxInt(intRef.element);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                throw th;
            }
        }
    }

    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C12941(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel drop(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C12951(i, receiveChannel, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return drop(receiveChannel, i, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel dropWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C12961(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return dropWhile(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #2 {all -> 0x003b, blocks: (B:12:0x0037, B:25:0x0066, B:27:0x006e, B:33:0x007e, B:34:0x0098), top: B:46:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007e A[Catch: all -> 0x003b, TRY_ENTER, TryCatch #2 {all -> 0x003b, blocks: (B:12:0x0037, B:25:0x0066, B:27:0x006e, B:33:0x007e, B:34:0x0098), top: B:46:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0061 -> B:25:0x0066). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object elementAt(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        C12971 c12971;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator it;
        int i2;
        Object objHasNext;
        if (continuation instanceof C12971) {
            c12971 = (C12971) continuation;
            if ((c12971.label & Integer.MIN_VALUE) != 0) {
                c12971.label -= Integer.MIN_VALUE;
            } else {
                c12971 = new C12971(continuation);
            }
        }
        Object obj = c12971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c12971.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                if (i < 0) {
                    throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + FilenameUtils.EXTENSION_SEPARATOR);
                }
                it = receiveChannel.iterator();
                i2 = 0;
                c12971.L$0 = receiveChannel;
                c12971.L$1 = it;
                c12971.I$0 = i;
                c12971.I$1 = i2;
                c12971.label = 1;
                objHasNext = it.hasNext(c12971);
                if (objHasNext != coroutine_suspended) {
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i4 = c12971.I$1;
                i = c12971.I$0;
                ChannelIterator channelIterator = (ChannelIterator) c12971.L$1;
                receiveChannel2 = (ReceiveChannel) c12971.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        Object next = channelIterator.next();
                        int i5 = i4 + 1;
                        if (i == i4) {
                            ChannelsKt.cancelConsumed(receiveChannel2, null);
                            return next;
                        }
                        it = channelIterator;
                        receiveChannel = receiveChannel2;
                        i2 = i5;
                        c12971.L$0 = receiveChannel;
                        c12971.L$1 = it;
                        c12971.I$0 = i;
                        c12971.I$1 = i2;
                        c12971.label = 1;
                        objHasNext = it.hasNext(c12971);
                        if (objHasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        i4 = i2;
                        channelIterator = it;
                        obj = objHasNext;
                        if (!((Boolean) obj).booleanValue()) {
                            throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + FilenameUtils.EXTENSION_SEPARATOR);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        ChannelsKt.cancelConsumed(receiveChannel2, th);
                        throw th3;
                    }
                }
            }
        } catch (Throwable th4) {
            receiveChannel2 = receiveChannel;
            th = th4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0074 A[Catch: all -> 0x0089, TRY_LEAVE, TryCatch #0 {all -> 0x0089, blocks: (B:27:0x006c, B:29:0x0074, B:23:0x0056, B:22:0x0050), top: B:43:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0085 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0067 -> B:27:0x006c). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object elementAtOrNull(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        C12981 c12981;
        ChannelIterator it;
        int i2;
        Throwable th;
        Throwable th2;
        ReceiveChannel receiveChannel2;
        Object objHasNext;
        if (continuation instanceof C12981) {
            c12981 = (C12981) continuation;
            if ((c12981.label & Integer.MIN_VALUE) != 0) {
                c12981.label -= Integer.MIN_VALUE;
            } else {
                c12981 = new C12981(continuation);
            }
        }
        Object obj = c12981.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c12981.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (i < 0) {
                ChannelsKt.cancelConsumed(receiveChannel, null);
                return null;
            }
            try {
                it = receiveChannel.iterator();
                i2 = 0;
                th = null;
                c12981.L$0 = receiveChannel;
                c12981.L$1 = it;
                c12981.I$0 = i;
                c12981.I$1 = i2;
                c12981.label = 1;
                objHasNext = it.hasNext(c12981);
                if (objHasNext != coroutine_suspended) {
                }
            } catch (Throwable th3) {
                receiveChannel2 = receiveChannel;
                th2 = th3;
                throw th2;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = c12981.I$1;
            i = c12981.I$0;
            ChannelIterator channelIterator = (ChannelIterator) c12981.L$1;
            receiveChannel2 = (ReceiveChannel) c12981.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                i2 = i4;
                receiveChannel = receiveChannel2;
                C12981 c129812 = c12981;
                ChannelIterator channelIterator2 = channelIterator;
                Throwable th4 = null;
                if (!((Boolean) obj).booleanValue()) {
                    Object next = channelIterator2.next();
                    int i5 = i2 + 1;
                    if (i == i2) {
                        return next;
                    }
                    it = channelIterator2;
                    c12981 = c129812;
                    th = th2;
                    i2 = i5;
                    c12981.L$0 = receiveChannel;
                    c12981.L$1 = it;
                    c12981.I$0 = i;
                    c12981.I$1 = i2;
                    c12981.label = 1;
                    objHasNext = it.hasNext(c12981);
                    if (objHasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    C12981 c129813 = c12981;
                    channelIterator2 = it;
                    obj = objHasNext;
                    th4 = th;
                    c129812 = c129813;
                    if (!((Boolean) obj).booleanValue()) {
                        return null;
                    }
                }
            } catch (Throwable th5) {
                th2 = th5;
                try {
                    throw th2;
                } finally {
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                }
            }
        }
    }

    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C12991(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.filter(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterIndexed(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13001(receiveChannel, function3, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return filterIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterNot(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt.filter(receiveChannel, coroutineContext, new C13011(function2, null));
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return filterNot(receiveChannel, coroutineContext, function2);
    }

    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> receiveChannel) {
        ReceiveChannel<E> receiveChannelFilter$default = filter$default(receiveChannel, null, new C13021(null), 1, null);
        Intrinsics.checkNotNull(receiveChannelFilter$default, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNull>");
        return receiveChannelFilter$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:25:0x005e, B:27:0x0066, B:29:0x006c, B:21:0x004c, B:31:0x0071), top: B:42:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0071 A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:25:0x005e, B:27:0x0066, B:29:0x006c, B:21:0x004c, B:31:0x0071), top: B:42:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005b -> B:25:0x005e). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel receiveChannel, Collection collection, Continuation continuation) {
        C13031 c13031;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator it;
        Collection collection2;
        Object objHasNext;
        if (continuation instanceof C13031) {
            c13031 = (C13031) continuation;
            if ((c13031.label & Integer.MIN_VALUE) != 0) {
                c13031.label -= Integer.MIN_VALUE;
            } else {
                c13031 = new C13031(continuation);
            }
        }
        Object obj = c13031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13031.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                receiveChannel2 = receiveChannel;
                it = receiveChannel.iterator();
                collection2 = collection;
                c13031.L$0 = collection2;
                c13031.L$1 = receiveChannel2;
                c13031.L$2 = it;
                c13031.label = 1;
                objHasNext = it.hasNext(c13031);
                if (objHasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (ChannelIterator) c13031.L$2;
            receiveChannel2 = (ReceiveChannel) c13031.L$1;
            Collection collection3 = (Collection) c13031.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return collection3;
                }
                Object next = it.next();
                if (next != null) {
                    collection3.add(next);
                }
                collection2 = collection3;
                c13031.L$0 = collection2;
                c13031.L$1 = receiveChannel2;
                c13031.L$2 = it;
                c13031.label = 1;
                objHasNext = it.hasNext(c13031);
                if (objHasNext != coroutine_suspended) {
                    return coroutine_suspended;
                }
                collection3 = collection2;
                obj = objHasNext;
                if (!((Boolean) obj).booleanValue()) {
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                    throw th4;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0089, code lost:
    
        if (r9 == r1) goto L34;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:13:0x0036, B:28:0x006f, B:30:0x0077, B:32:0x007d, B:36:0x0090, B:18:0x004e), top: B:45:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:13:0x0036, B:28:0x006f, B:30:0x0077, B:32:0x007d, B:36:0x0090, B:18:0x004e), top: B:45:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object, kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007b -> B:35:0x008c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0089 -> B:35:0x008c). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel receiveChannel, SendChannel sendChannel, Continuation continuation) {
        AnonymousClass3 anonymousClass3;
        ChannelIterator it;
        ChannelIterator channelIterator;
        ?? r2;
        ?? r8;
        Object objHasNext;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            if ((anonymousClass3.label & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        }
        Object obj = anonymousClass3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass3.label;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (i != 0) {
            if (i == 1) {
                channelIterator = (ChannelIterator) anonymousClass3.L$2;
                ReceiveChannel receiveChannel2 = (ReceiveChannel) anonymousClass3.L$1;
                SendChannel sendChannel2 = (SendChannel) anonymousClass3.L$0;
                ResultKt.throwOnFailure(obj);
                r2 = sendChannel2;
                sendChannel = receiveChannel2;
                if (((Boolean) obj).booleanValue()) {
                }
                throw th;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            channelIterator = (ChannelIterator) anonymousClass3.L$2;
            ReceiveChannel receiveChannel3 = (ReceiveChannel) anonymousClass3.L$1;
            SendChannel sendChannel3 = (SendChannel) anonymousClass3.L$0;
            ResultKt.throwOnFailure(obj);
            ?? r22 = sendChannel3;
            ?? r82 = receiveChannel3;
            it = channelIterator;
            receiveChannel = r82;
            r8 = r22;
            anonymousClass3.L$0 = r8;
            anonymousClass3.L$1 = receiveChannel;
            anonymousClass3.L$2 = it;
            anonymousClass3.label = 1;
            objHasNext = it.hasNext(anonymousClass3);
            if (objHasNext != coroutine_suspended) {
                ?? r6 = r8;
                sendChannel = receiveChannel;
                channelIterator = it;
                obj = objHasNext;
                r2 = r6;
                if (((Boolean) obj).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(sendChannel, null);
                    return r2;
                }
                Object next = channelIterator.next();
                r22 = r2;
                r82 = sendChannel;
                if (next != null) {
                    anonymousClass3.L$0 = r2;
                    anonymousClass3.L$1 = sendChannel;
                    anonymousClass3.L$2 = channelIterator;
                    anonymousClass3.label = 2;
                    Object objSend = r2.send(next, anonymousClass3);
                    r22 = r2;
                    r82 = sendChannel;
                }
                it = channelIterator;
                receiveChannel = r82;
                r8 = r22;
                anonymousClass3.L$0 = r8;
                anonymousClass3.L$1 = receiveChannel;
                anonymousClass3.L$2 = it;
                anonymousClass3.label = 1;
                objHasNext = it.hasNext(anonymousClass3);
                if (objHasNext != coroutine_suspended) {
                }
                try {
                    throw th;
                } catch (Throwable th2) {
                    ChannelsKt.cancelConsumed(sendChannel, th);
                    throw th2;
                }
            }
            return coroutine_suspended;
        }
        ResultKt.throwOnFailure(obj);
        try {
            it = receiveChannel.iterator();
            receiveChannel = receiveChannel;
            r8 = sendChannel;
            anonymousClass3.L$0 = r8;
            anonymousClass3.L$1 = receiveChannel;
            anonymousClass3.L$2 = it;
            anonymousClass3.label = 1;
            objHasNext = it.hasNext(anonymousClass3);
            if (objHasNext != coroutine_suspended) {
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            sendChannel = receiveChannel;
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c A[Catch: all -> 0x0032, TRY_LEAVE, TryCatch #1 {all -> 0x0032, blocks: (B:12:0x002e, B:23:0x0054, B:25:0x005c, B:28:0x0065, B:29:0x006c), top: B:38:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065 A[Catch: all -> 0x0032, TRY_ENTER, TryCatch #1 {all -> 0x0032, blocks: (B:12:0x002e, B:23:0x0054, B:25:0x005c, B:28:0x0065, B:29:0x006c), top: B:38:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object first(ReceiveChannel receiveChannel, Continuation continuation) {
        C13041 c13041;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        if (continuation instanceof C13041) {
            c13041 = (C13041) continuation;
            if ((c13041.label & Integer.MIN_VALUE) != 0) {
                c13041.label -= Integer.MIN_VALUE;
            } else {
                c13041 = new C13041(continuation);
            }
        }
        Object obj = c13041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13041.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            channelIterator = (ChannelIterator) c13041.L$1;
            receiveChannel2 = (ReceiveChannel) c13041.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                Object next = channelIterator.next();
                ChannelsKt.cancelConsumed(receiveChannel2, null);
                return next;
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                    throw th3;
                }
            }
        }
        ResultKt.throwOnFailure(obj);
        try {
            ChannelIterator it = receiveChannel.iterator();
            c13041.L$0 = receiveChannel;
            c13041.L$1 = it;
            c13041.label = 1;
            Object objHasNext = it.hasNext(c13041);
            if (objHasNext == coroutine_suspended) {
                return coroutine_suspended;
            }
            receiveChannel2 = receiveChannel;
            channelIterator = it;
            obj = objHasNext;
            if (((Boolean) obj).booleanValue()) {
            }
        } catch (Throwable th4) {
            receiveChannel2 = receiveChannel;
            th = th4;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object firstOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        C13051 c13051;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        if (continuation instanceof C13051) {
            c13051 = (C13051) continuation;
            if ((c13051.label & Integer.MIN_VALUE) != 0) {
                c13051.label -= Integer.MIN_VALUE;
            } else {
                c13051 = new C13051(continuation);
            }
        }
        Object obj = c13051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13051.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                ChannelIterator it = receiveChannel.iterator();
                c13051.L$0 = receiveChannel;
                c13051.L$1 = it;
                c13051.label = 1;
                Object objHasNext = it.hasNext(c13051);
                if (objHasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                receiveChannel2 = receiveChannel;
                channelIterator = it;
                obj = objHasNext;
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            channelIterator = (ChannelIterator) c13051.L$1;
            receiveChannel2 = (ReceiveChannel) c13051.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                    throw th4;
                }
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            ChannelsKt.cancelConsumed(receiveChannel2, null);
            return null;
        }
        Object next = channelIterator.next();
        ChannelsKt.cancelConsumed(receiveChannel2, null);
        return next;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel flatMap(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13061(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return flatMap(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070 A[Catch: all -> 0x0039, TryCatch #1 {all -> 0x0039, blocks: (B:12:0x0035, B:25:0x0068, B:27:0x0070, B:29:0x007a, B:32:0x0084, B:21:0x0054, B:33:0x008b), top: B:44:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008b A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #1 {all -> 0x0039, blocks: (B:12:0x0035, B:25:0x0068, B:27:0x0070, B:29:0x007a, B:32:0x0084, B:21:0x0054, B:33:0x008b), top: B:44:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0065 -> B:25:0x0068). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object indexOf(ReceiveChannel receiveChannel, Object obj, Continuation continuation) {
        C13071 c13071;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator it;
        Ref.IntRef intRef;
        Object obj2;
        Object objHasNext;
        if (continuation instanceof C13071) {
            c13071 = (C13071) continuation;
            if ((c13071.label & Integer.MIN_VALUE) != 0) {
                c13071.label -= Integer.MIN_VALUE;
            } else {
                c13071 = new C13071(continuation);
            }
        }
        Object obj3 = c13071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13071.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj3);
            Ref.IntRef intRef2 = new Ref.IntRef();
            try {
                receiveChannel2 = receiveChannel;
                it = receiveChannel.iterator();
                intRef = intRef2;
                obj2 = obj;
                c13071.L$0 = obj2;
                c13071.L$1 = intRef;
                c13071.L$2 = receiveChannel2;
                c13071.L$3 = it;
                c13071.label = 1;
                objHasNext = it.hasNext(c13071);
                if (objHasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (ChannelIterator) c13071.L$3;
            receiveChannel2 = (ReceiveChannel) c13071.L$2;
            intRef = (Ref.IntRef) c13071.L$1;
            Object obj4 = c13071.L$0;
            try {
                ResultKt.throwOnFailure(obj3);
                if (!((Boolean) obj3).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return Boxing.boxInt(-1);
                }
                if (Intrinsics.areEqual(obj4, it.next())) {
                    Integer numBoxInt = Boxing.boxInt(intRef.element);
                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return numBoxInt;
                }
                intRef.element++;
                obj2 = obj4;
                c13071.L$0 = obj2;
                c13071.L$1 = intRef;
                c13071.L$2 = receiveChannel2;
                c13071.L$3 = it;
                c13071.label = 1;
                objHasNext = it.hasNext(c13071);
                if (objHasNext != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj4 = obj2;
                obj3 = objHasNext;
                if (!((Boolean) obj3).booleanValue()) {
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        try {
            throw th;
        } catch (Throwable th4) {
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0094 A[Catch: all -> 0x0038, TRY_LEAVE, TryCatch #2 {all -> 0x0038, blocks: (B:13:0x0034, B:37:0x008c, B:39:0x0094), top: B:54:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0088 -> B:37:0x008c). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object last(ReceiveChannel receiveChannel, Continuation continuation) {
        C13081 c13081;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Object next;
        ChannelIterator channelIterator2;
        Object objHasNext;
        if (continuation instanceof C13081) {
            c13081 = (C13081) continuation;
            if ((c13081.label & Integer.MIN_VALUE) != 0) {
                c13081.label -= Integer.MIN_VALUE;
            } else {
                c13081 = new C13081(continuation);
            }
        }
        Object obj = c13081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13081.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                ChannelIterator it = receiveChannel.iterator();
                c13081.L$0 = receiveChannel;
                c13081.L$1 = it;
                c13081.label = 1;
                Object objHasNext2 = it.hasNext(c13081);
                if (objHasNext2 != coroutine_suspended) {
                    receiveChannel2 = receiveChannel;
                    channelIterator = it;
                    obj = objHasNext2;
                }
                return coroutine_suspended;
            } catch (Throwable th) {
                receiveChannel2 = receiveChannel;
                th = th;
                throw th;
            }
        }
        if (i == 1) {
            channelIterator = (ChannelIterator) c13081.L$1;
            receiveChannel2 = (ReceiveChannel) c13081.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj2 = c13081.L$2;
            channelIterator2 = (ChannelIterator) c13081.L$1;
            ReceiveChannel receiveChannel3 = (ReceiveChannel) c13081.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                    next = channelIterator2.next();
                    receiveChannel = receiveChannel3;
                    c13081.L$0 = receiveChannel;
                    c13081.L$1 = channelIterator2;
                    c13081.L$2 = next;
                    c13081.label = 2;
                    objHasNext = channelIterator2.hasNext(c13081);
                    if (objHasNext != coroutine_suspended) {
                        receiveChannel3 = receiveChannel;
                        obj2 = next;
                        obj = objHasNext;
                        if (!((Boolean) obj).booleanValue()) {
                            ChannelsKt.cancelConsumed(receiveChannel3, null);
                            return obj2;
                        }
                    }
                    return coroutine_suspended;
                }
            } catch (Throwable th3) {
                th = th3;
                receiveChannel2 = receiveChannel3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                    throw th4;
                }
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            throw new NoSuchElementException("ReceiveChannel is empty.");
        }
        next = channelIterator.next();
        ReceiveChannel receiveChannel4 = receiveChannel2;
        channelIterator2 = channelIterator;
        receiveChannel = receiveChannel4;
        c13081.L$0 = receiveChannel;
        c13081.L$1 = channelIterator2;
        c13081.L$2 = next;
        c13081.label = 2;
        objHasNext = channelIterator2.hasNext(c13081);
        if (objHasNext != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f A[Catch: all -> 0x003d, TryCatch #2 {all -> 0x003d, blocks: (B:12:0x0039, B:25:0x0077, B:27:0x007f, B:29:0x0089, B:30:0x008d, B:21:0x0061, B:31:0x0094), top: B:44:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #2 {all -> 0x003d, blocks: (B:12:0x0039, B:25:0x0077, B:27:0x007f, B:29:0x0089, B:30:0x008d, B:21:0x0061, B:31:0x0094), top: B:44:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0074 -> B:25:0x0077). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object lastIndexOf(ReceiveChannel receiveChannel, Object obj, Continuation continuation) {
        C13091 c13091;
        Ref.IntRef intRef;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator it;
        Ref.IntRef intRef2;
        Object obj2;
        Object objHasNext;
        if (continuation instanceof C13091) {
            c13091 = (C13091) continuation;
            if ((c13091.label & Integer.MIN_VALUE) != 0) {
                c13091.label -= Integer.MIN_VALUE;
            } else {
                c13091 = new C13091(continuation);
            }
        }
        Object obj3 = c13091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13091.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj3);
            Ref.IntRef intRef3 = new Ref.IntRef();
            intRef3.element = -1;
            intRef = new Ref.IntRef();
            try {
                receiveChannel2 = receiveChannel;
                it = receiveChannel.iterator();
                intRef2 = intRef3;
                obj2 = obj;
                c13091.L$0 = obj2;
                c13091.L$1 = intRef2;
                c13091.L$2 = intRef;
                c13091.L$3 = receiveChannel2;
                c13091.L$4 = it;
                c13091.label = 1;
                objHasNext = it.hasNext(c13091);
                if (objHasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (ChannelIterator) c13091.L$4;
            receiveChannel2 = (ReceiveChannel) c13091.L$3;
            intRef = (Ref.IntRef) c13091.L$2;
            intRef2 = (Ref.IntRef) c13091.L$1;
            Object obj4 = c13091.L$0;
            try {
                ResultKt.throwOnFailure(obj3);
                if (!((Boolean) obj3).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return Boxing.boxInt(intRef2.element);
                }
                if (Intrinsics.areEqual(obj4, it.next())) {
                    intRef2.element = intRef.element;
                }
                intRef.element++;
                obj2 = obj4;
                c13091.L$0 = obj2;
                c13091.L$1 = intRef2;
                c13091.L$2 = intRef;
                c13091.L$3 = receiveChannel2;
                c13091.L$4 = it;
                c13091.label = 1;
                objHasNext = it.hasNext(c13091);
                if (objHasNext != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj4 = obj2;
                obj3 = objHasNext;
                if (!((Boolean) obj3).booleanValue()) {
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                    throw th4;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0098 A[Catch: all -> 0x0038, TRY_LEAVE, TryCatch #3 {all -> 0x0038, blocks: (B:13:0x0034, B:39:0x0090, B:41:0x0098), top: B:57:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x008c -> B:39:0x0090). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object lastOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        C13101 c13101;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Object next;
        ChannelIterator channelIterator2;
        Object objHasNext;
        if (continuation instanceof C13101) {
            c13101 = (C13101) continuation;
            if ((c13101.label & Integer.MIN_VALUE) != 0) {
                c13101.label -= Integer.MIN_VALUE;
            } else {
                c13101 = new C13101(continuation);
            }
        }
        Object obj = c13101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13101.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                ChannelIterator it = receiveChannel.iterator();
                c13101.L$0 = receiveChannel;
                c13101.L$1 = it;
                c13101.label = 1;
                Object objHasNext2 = it.hasNext(c13101);
                if (objHasNext2 != coroutine_suspended) {
                    receiveChannel2 = receiveChannel;
                    channelIterator = it;
                    obj = objHasNext2;
                }
                return coroutine_suspended;
            } catch (Throwable th) {
                receiveChannel2 = receiveChannel;
                th = th;
                throw th;
            }
        }
        if (i == 1) {
            channelIterator = (ChannelIterator) c13101.L$1;
            receiveChannel2 = (ReceiveChannel) c13101.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj2 = c13101.L$2;
            channelIterator2 = (ChannelIterator) c13101.L$1;
            ReceiveChannel receiveChannel3 = (ReceiveChannel) c13101.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                    next = channelIterator2.next();
                    receiveChannel = receiveChannel3;
                    c13101.L$0 = receiveChannel;
                    c13101.L$1 = channelIterator2;
                    c13101.L$2 = next;
                    c13101.label = 2;
                    objHasNext = channelIterator2.hasNext(c13101);
                    if (objHasNext != coroutine_suspended) {
                        receiveChannel3 = receiveChannel;
                        obj2 = next;
                        obj = objHasNext;
                        if (!((Boolean) obj).booleanValue()) {
                            ChannelsKt.cancelConsumed(receiveChannel3, null);
                            return obj2;
                        }
                    }
                    return coroutine_suspended;
                }
            } catch (Throwable th3) {
                th = th3;
                receiveChannel2 = receiveChannel3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                    throw th4;
                }
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            ChannelsKt.cancelConsumed(receiveChannel2, null);
            return null;
        }
        next = channelIterator.next();
        ReceiveChannel receiveChannel4 = receiveChannel2;
        channelIterator2 = channelIterator;
        receiveChannel = receiveChannel4;
        c13101.L$0 = receiveChannel;
        c13101.L$1 = channelIterator2;
        c13101.L$2 = next;
        c13101.label = 2;
        objHasNext = channelIterator2.hasNext(c13101);
        if (objHasNext != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13111(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.map(receiveChannel, coroutineContext, function2);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13121(receiveChannel, function3, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapIndexedNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3) {
        return ChannelsKt.filterNotNull(ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3));
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return mapIndexedNotNull(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapNotNull(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ChannelsKt.filterNotNull(ChannelsKt.map(receiveChannel, coroutineContext, function2));
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return mapNotNull(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ac A[Catch: all -> 0x00be, TRY_LEAVE, TryCatch #3 {all -> 0x00be, blocks: (B:40:0x00a4, B:42:0x00ac, B:36:0x008f, B:26:0x0063), top: B:61:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00a0 -> B:15:0x003e). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object maxWith(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        C13131 c13131;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Comparator comparator2;
        Object next;
        ChannelIterator channelIterator2;
        Comparator comparator3;
        Object objHasNext;
        if (continuation instanceof C13131) {
            c13131 = (C13131) continuation;
            if ((c13131.label & Integer.MIN_VALUE) != 0) {
                c13131.label -= Integer.MIN_VALUE;
            } else {
                c13131 = new C13131(continuation);
            }
        }
        Object obj = c13131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13131.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                ChannelIterator it = receiveChannel.iterator();
                c13131.L$0 = comparator;
                c13131.L$1 = receiveChannel;
                c13131.L$2 = it;
                c13131.label = 1;
                Object objHasNext2 = it.hasNext(c13131);
                if (objHasNext2 != coroutine_suspended) {
                    receiveChannel2 = receiveChannel;
                    channelIterator = it;
                    obj = objHasNext2;
                    comparator2 = comparator;
                }
                return coroutine_suspended;
            } catch (Throwable th) {
                receiveChannel2 = receiveChannel;
                th = th;
                throw th;
            }
        }
        if (i == 1) {
            channelIterator = (ChannelIterator) c13131.L$2;
            receiveChannel2 = (ReceiveChannel) c13131.L$1;
            comparator2 = (Comparator) c13131.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj2 = c13131.L$3;
            channelIterator2 = (ChannelIterator) c13131.L$2;
            ReceiveChannel receiveChannel3 = (ReceiveChannel) c13131.L$1;
            comparator3 = (Comparator) c13131.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                C13131 c131312 = c13131;
                Object obj3 = obj2;
                receiveChannel = receiveChannel3;
                C13131 c131313 = c131312;
                if (!((Boolean) obj).booleanValue()) {
                    next = channelIterator2.next();
                    if (comparator3.compare(obj3, next) >= 0) {
                        next = obj3;
                    }
                    c13131 = c131313;
                    c13131.L$0 = comparator3;
                    c13131.L$1 = receiveChannel;
                    c13131.L$2 = channelIterator2;
                    c13131.L$3 = next;
                    c13131.label = 2;
                    objHasNext = channelIterator2.hasNext(c13131);
                    if (objHasNext != coroutine_suspended) {
                        c131312 = c13131;
                        obj3 = next;
                        obj = objHasNext;
                        C13131 c1313132 = c131312;
                        if (!((Boolean) obj).booleanValue()) {
                            ChannelsKt.cancelConsumed(receiveChannel, null);
                            return obj3;
                        }
                    }
                    return coroutine_suspended;
                }
            } catch (Throwable th3) {
                th = th3;
                receiveChannel2 = receiveChannel3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                    throw th4;
                }
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            ChannelsKt.cancelConsumed(receiveChannel2, null);
            return null;
        }
        next = channelIterator.next();
        ReceiveChannel receiveChannel4 = receiveChannel2;
        channelIterator2 = channelIterator;
        receiveChannel = receiveChannel4;
        comparator3 = comparator2;
        c13131.L$0 = comparator3;
        c13131.L$1 = receiveChannel;
        c13131.L$2 = channelIterator2;
        c13131.L$3 = next;
        c13131.label = 2;
        objHasNext = channelIterator2.hasNext(c13131);
        if (objHasNext != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ac A[Catch: all -> 0x00be, TRY_LEAVE, TryCatch #3 {all -> 0x00be, blocks: (B:40:0x00a4, B:42:0x00ac, B:36:0x008f, B:26:0x0063), top: B:61:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00a0 -> B:15:0x003e). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object minWith(ReceiveChannel receiveChannel, Comparator comparator, Continuation continuation) {
        C13141 c13141;
        ReceiveChannel receiveChannel2;
        ChannelIterator channelIterator;
        Comparator comparator2;
        Object next;
        ChannelIterator channelIterator2;
        Comparator comparator3;
        Object objHasNext;
        if (continuation instanceof C13141) {
            c13141 = (C13141) continuation;
            if ((c13141.label & Integer.MIN_VALUE) != 0) {
                c13141.label -= Integer.MIN_VALUE;
            } else {
                c13141 = new C13141(continuation);
            }
        }
        Object obj = c13141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13141.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                ChannelIterator it = receiveChannel.iterator();
                c13141.L$0 = comparator;
                c13141.L$1 = receiveChannel;
                c13141.L$2 = it;
                c13141.label = 1;
                Object objHasNext2 = it.hasNext(c13141);
                if (objHasNext2 != coroutine_suspended) {
                    receiveChannel2 = receiveChannel;
                    channelIterator = it;
                    obj = objHasNext2;
                    comparator2 = comparator;
                }
                return coroutine_suspended;
            } catch (Throwable th) {
                receiveChannel2 = receiveChannel;
                th = th;
                throw th;
            }
        }
        if (i == 1) {
            channelIterator = (ChannelIterator) c13141.L$2;
            receiveChannel2 = (ReceiveChannel) c13141.L$1;
            comparator2 = (Comparator) c13141.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj2 = c13141.L$3;
            channelIterator2 = (ChannelIterator) c13141.L$2;
            ReceiveChannel receiveChannel3 = (ReceiveChannel) c13141.L$1;
            comparator3 = (Comparator) c13141.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                C13141 c131412 = c13141;
                Object obj3 = obj2;
                receiveChannel = receiveChannel3;
                C13141 c131413 = c131412;
                if (!((Boolean) obj).booleanValue()) {
                    next = channelIterator2.next();
                    if (comparator3.compare(obj3, next) <= 0) {
                        next = obj3;
                    }
                    c13141 = c131413;
                    c13141.L$0 = comparator3;
                    c13141.L$1 = receiveChannel;
                    c13141.L$2 = channelIterator2;
                    c13141.L$3 = next;
                    c13141.label = 2;
                    objHasNext = channelIterator2.hasNext(c13141);
                    if (objHasNext != coroutine_suspended) {
                        c131412 = c13141;
                        obj3 = next;
                        obj = objHasNext;
                        C13141 c1314132 = c131412;
                        if (!((Boolean) obj).booleanValue()) {
                            ChannelsKt.cancelConsumed(receiveChannel, null);
                            return obj3;
                        }
                    }
                    return coroutine_suspended;
                }
            } catch (Throwable th3) {
                th = th3;
                receiveChannel2 = receiveChannel3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                    throw th4;
                }
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            ChannelsKt.cancelConsumed(receiveChannel2, null);
            return null;
        }
        next = channelIterator.next();
        ReceiveChannel receiveChannel4 = receiveChannel2;
        channelIterator2 = channelIterator;
        receiveChannel = receiveChannel4;
        comparator3 = comparator2;
        c13141.L$0 = comparator3;
        c13141.L$1 = receiveChannel;
        c13141.L$2 = channelIterator2;
        c13141.L$3 = next;
        c13141.label = 2;
        objHasNext = channelIterator2.hasNext(c13141);
        if (objHasNext != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object none(ReceiveChannel receiveChannel, Continuation continuation) {
        C13151 c13151;
        if (continuation instanceof C13151) {
            c13151 = (C13151) continuation;
            if ((c13151.label & Integer.MIN_VALUE) != 0) {
                c13151.label -= Integer.MIN_VALUE;
            } else {
                c13151 = new C13151(continuation);
            }
        }
        Object objHasNext = c13151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13151.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objHasNext);
                ChannelIterator it = receiveChannel.iterator();
                c13151.L$0 = receiveChannel;
                c13151.label = 1;
                objHasNext = it.hasNext(c13151);
                if (objHasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                receiveChannel = (ReceiveChannel) c13151.L$0;
                ResultKt.throwOnFailure(objHasNext);
            }
            Boolean boolBoxBoolean = Boxing.boxBoolean(!((Boolean) objHasNext).booleanValue());
            ChannelsKt.cancelConsumed(receiveChannel, null);
            return boolBoxBoolean;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006d A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #2 {all -> 0x004b, blocks: (B:20:0x0047, B:29:0x0065, B:31:0x006d, B:41:0x0097, B:42:0x009e), top: B:53:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008f A[Catch: all -> 0x0033, TRY_ENTER, TryCatch #1 {all -> 0x0033, blocks: (B:13:0x002f, B:35:0x0082, B:39:0x008f, B:40:0x0096), top: B:51:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0097 A[Catch: all -> 0x004b, TRY_ENTER, TryCatch #2 {all -> 0x004b, blocks: (B:20:0x0047, B:29:0x0065, B:31:0x006d, B:41:0x0097, B:42:0x009e), top: B:53:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object single(ReceiveChannel receiveChannel, Continuation continuation) {
        C13171 c13171;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        Object obj;
        ReceiveChannel receiveChannel3;
        if (continuation instanceof C13171) {
            c13171 = (C13171) continuation;
            if ((c13171.label & Integer.MIN_VALUE) != 0) {
                c13171.label -= Integer.MIN_VALUE;
            } else {
                c13171 = new C13171(continuation);
            }
        }
        Object obj2 = c13171.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13171.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj2);
            try {
                ChannelIterator it = receiveChannel.iterator();
                c13171.L$0 = receiveChannel;
                c13171.L$1 = it;
                c13171.label = 1;
                Object objHasNext = it.hasNext(c13171);
                if (objHasNext != coroutine_suspended) {
                    receiveChannel2 = receiveChannel;
                    channelIterator = it;
                    obj2 = objHasNext;
                    if (((Boolean) obj2).booleanValue()) {
                    }
                }
                return coroutine_suspended;
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
                throw th;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = c13171.L$1;
            receiveChannel3 = (ReceiveChannel) c13171.L$0;
            try {
                ResultKt.throwOnFailure(obj2);
                if (!((Boolean) obj2).booleanValue()) {
                    throw new IllegalArgumentException("ReceiveChannel has more than one element.");
                }
                ChannelsKt.cancelConsumed(receiveChannel3, null);
                return obj;
            } catch (Throwable th3) {
                th = th3;
                receiveChannel2 = receiveChannel3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                    throw th4;
                }
            }
        }
        channelIterator = (ChannelIterator) c13171.L$1;
        receiveChannel2 = (ReceiveChannel) c13171.L$0;
        try {
            ResultKt.throwOnFailure(obj2);
            if (((Boolean) obj2).booleanValue()) {
                throw new NoSuchElementException("ReceiveChannel is empty.");
            }
            Object next = channelIterator.next();
            c13171.L$0 = receiveChannel2;
            c13171.L$1 = next;
            c13171.label = 2;
            Object objHasNext2 = channelIterator.hasNext(c13171);
            if (objHasNext2 != coroutine_suspended) {
                obj2 = objHasNext2;
                obj = next;
                receiveChannel3 = receiveChannel2;
                if (!((Boolean) obj2).booleanValue()) {
                }
            }
            return coroutine_suspended;
        } catch (Throwable th5) {
            th = th5;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object singleOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        C13181 c13181;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ChannelIterator channelIterator;
        Object obj;
        ReceiveChannel receiveChannel3;
        if (continuation instanceof C13181) {
            c13181 = (C13181) continuation;
            if ((c13181.label & Integer.MIN_VALUE) != 0) {
                c13181.label -= Integer.MIN_VALUE;
            } else {
                c13181 = new C13181(continuation);
            }
        }
        Object obj2 = c13181.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13181.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj2);
            try {
                ChannelIterator it = receiveChannel.iterator();
                c13181.L$0 = receiveChannel;
                c13181.L$1 = it;
                c13181.label = 1;
                Object objHasNext = it.hasNext(c13181);
                if (objHasNext != coroutine_suspended) {
                    receiveChannel2 = receiveChannel;
                    channelIterator = it;
                    obj2 = objHasNext;
                }
                return coroutine_suspended;
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
                throw th;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = c13181.L$1;
            receiveChannel3 = (ReceiveChannel) c13181.L$0;
            try {
                ResultKt.throwOnFailure(obj2);
                if (((Boolean) obj2).booleanValue()) {
                    ChannelsKt.cancelConsumed(receiveChannel3, null);
                    return obj;
                }
                ChannelsKt.cancelConsumed(receiveChannel3, null);
                return null;
            } catch (Throwable th3) {
                th = th3;
                receiveChannel2 = receiveChannel3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                    throw th4;
                }
            }
        }
        channelIterator = (ChannelIterator) c13181.L$1;
        receiveChannel2 = (ReceiveChannel) c13181.L$0;
        try {
            ResultKt.throwOnFailure(obj2);
        } catch (Throwable th5) {
            th = th5;
            throw th;
        }
        if (!((Boolean) obj2).booleanValue()) {
            ChannelsKt.cancelConsumed(receiveChannel2, null);
            return null;
        }
        Object next = channelIterator.next();
        c13181.L$0 = receiveChannel2;
        c13181.L$1 = next;
        c13181.label = 2;
        Object objHasNext2 = channelIterator.hasNext(c13181);
        if (objHasNext2 != coroutine_suspended) {
            obj2 = objHasNext2;
            obj = next;
            receiveChannel3 = receiveChannel2;
            if (((Boolean) obj2).booleanValue()) {
            }
        }
        return coroutine_suspended;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel take(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13191(i, receiveChannel, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return take(receiveChannel, i, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel takeWhile(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13201(receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return takeWhile(receiveChannel, coroutineContext, function2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
    
        if (r9 == r1) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a A[Catch: all -> 0x0055, TryCatch #1 {all -> 0x0055, blocks: (B:13:0x0036, B:28:0x0072, B:30:0x007a, B:33:0x008d, B:18:0x0051), top: B:44:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #1 {all -> 0x0055, blocks: (B:13:0x0036, B:28:0x0072, B:30:0x007a, B:33:0x008d, B:18:0x0051), top: B:44:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r8v0, types: [C extends kotlinx.coroutines.channels.SendChannel<? super E>] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object, kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x008a -> B:14:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        C13211 c13211;
        ChannelIterator<? extends E> it;
        ChannelIterator<? extends E> channelIterator;
        ?? r2;
        ?? r8;
        Object objHasNext;
        if (continuation instanceof C13211) {
            c13211 = (C13211) continuation;
            if ((c13211.label & Integer.MIN_VALUE) != 0) {
                c13211.label -= Integer.MIN_VALUE;
            } else {
                c13211 = new C13211(continuation);
            }
        }
        Object obj = c13211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13211.label;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (i != 0) {
            if (i == 1) {
                channelIterator = (ChannelIterator) c13211.L$2;
                boolean z = (C) ((ReceiveChannel) c13211.L$1);
                SendChannel sendChannel = (SendChannel) c13211.L$0;
                ResultKt.throwOnFailure(obj);
                r2 = sendChannel;
                c = z;
                if (((Boolean) obj).booleanValue()) {
                }
                throw th;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            channelIterator = (ChannelIterator) c13211.L$2;
            boolean z2 = (C) ((ReceiveChannel) c13211.L$1);
            SendChannel sendChannel2 = (SendChannel) c13211.L$0;
            ResultKt.throwOnFailure(obj);
            ?? r22 = sendChannel2;
            ?? r82 = z2;
            it = channelIterator;
            receiveChannel = (ReceiveChannel<? extends E>) r82;
            r8 = (C) r22;
            c13211.L$0 = r8;
            c13211.L$1 = receiveChannel;
            c13211.L$2 = it;
            c13211.label = 1;
            objHasNext = it.hasNext(c13211);
            if (objHasNext != coroutine_suspended) {
                ?? r6 = r8;
                boolean z3 = (C) receiveChannel;
                channelIterator = it;
                obj = objHasNext;
                r2 = r6;
                c = z3;
                if (((Boolean) obj).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed((ReceiveChannel) c, null);
                    return r2;
                }
                E next = channelIterator.next();
                c13211.L$0 = r2;
                c13211.L$1 = (Object) c;
                c13211.L$2 = channelIterator;
                c13211.label = 2;
                Object objSend = r2.send(next, c13211);
                r22 = r2;
                r82 = c;
                try {
                    throw th;
                } catch (Throwable th2) {
                    ChannelsKt.cancelConsumed(c, th);
                    throw th2;
                }
            }
            return coroutine_suspended;
        }
        ResultKt.throwOnFailure(obj);
        try {
            it = receiveChannel.iterator();
            r8 = c;
            c13211.L$0 = r8;
            c13211.L$1 = receiveChannel;
            c13211.L$2 = it;
            c13211.label = 1;
            objHasNext = it.hasNext(c13211);
            if (objHasNext != coroutine_suspended) {
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            c = receiveChannel;
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:25:0x005e, B:27:0x0066, B:21:0x004c, B:28:0x006f), top: B:39:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:25:0x005e, B:27:0x0066, B:21:0x004c, B:28:0x006f), top: B:39:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005b -> B:25:0x005e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        C13221 c13221;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ChannelIterator it;
        ?? r8;
        Object objHasNext;
        if (continuation instanceof C13221) {
            c13221 = (C13221) continuation;
            if ((c13221.label & Integer.MIN_VALUE) != 0) {
                c13221.label -= Integer.MIN_VALUE;
            } else {
                c13221 = new C13221(continuation);
            }
        }
        Object obj = c13221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13221.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                receiveChannel2 = receiveChannel;
                it = receiveChannel.iterator();
                r8 = c;
                c13221.L$0 = r8;
                c13221.L$1 = receiveChannel2;
                c13221.L$2 = it;
                c13221.label = 1;
                objHasNext = it.hasNext(c13221);
                if (objHasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (ChannelIterator) c13221.L$2;
            receiveChannel2 = (ReceiveChannel) c13221.L$1;
            Collection collection = (Collection) c13221.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                ?? r2 = collection;
                if (!((Boolean) obj).booleanValue()) {
                    r2.add(it.next());
                    r8 = r2;
                    c13221.L$0 = r8;
                    c13221.L$1 = receiveChannel2;
                    c13221.L$2 = it;
                    c13221.label = 1;
                    objHasNext = it.hasNext(c13221);
                    if (objHasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    r2 = r8;
                    obj = objHasNext;
                    if (!((Boolean) obj).booleanValue()) {
                        Unit unit = Unit.INSTANCE;
                        ChannelsKt.cancelConsumed(receiveChannel2, null);
                        return r2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                    throw th4;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:25:0x005e, B:27:0x0066, B:21:0x004c, B:28:0x0079), top: B:39:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079 A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #1 {all -> 0x0037, blocks: (B:12:0x0033, B:25:0x005e, B:27:0x0066, B:21:0x004c, B:28:0x0079), top: B:39:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005b -> B:25:0x005e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m, Continuation<? super M> continuation) {
        AnonymousClass2 anonymousClass2;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel2;
        Throwable th;
        ChannelIterator it;
        ?? r9;
        Object objHasNext;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            if ((anonymousClass2.label & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        }
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                receiveChannel2 = receiveChannel;
                it = receiveChannel.iterator();
                r9 = m;
                anonymousClass2.L$0 = r9;
                anonymousClass2.L$1 = receiveChannel2;
                anonymousClass2.L$2 = it;
                anonymousClass2.label = 1;
                objHasNext = it.hasNext(anonymousClass2);
                if (objHasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (ChannelIterator) anonymousClass2.L$2;
            receiveChannel2 = (ReceiveChannel) anonymousClass2.L$1;
            Map map = (Map) anonymousClass2.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                ?? r2 = map;
                if (!((Boolean) obj).booleanValue()) {
                    Pair pair = (Pair) it.next();
                    r2.put(pair.getFirst(), pair.getSecond());
                    r9 = r2;
                    anonymousClass2.L$0 = r9;
                    anonymousClass2.L$1 = receiveChannel2;
                    anonymousClass2.L$2 = it;
                    anonymousClass2.label = 1;
                    objHasNext = it.hasNext(anonymousClass2);
                    if (objHasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    r2 = r9;
                    obj = objHasNext;
                    if (!((Boolean) obj).booleanValue()) {
                        Unit unit = Unit.INSTANCE;
                        ChannelsKt.cancelConsumed(receiveChannel2, null);
                        return r2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                    throw th4;
                }
            }
        }
    }

    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<E>> continuation) {
        return ChannelsKt.toCollection(receiveChannel, new LinkedHashSet(), continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel withIndex(ReceiveChannel receiveChannel, CoroutineContext coroutineContext) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumes(receiveChannel), new C13231(receiveChannel, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return withIndex(receiveChannel, coroutineContext);
    }

    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2, CoroutineContext coroutineContext, Function2<? super E, ? super R, ? extends V> function2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, coroutineContext, 0, null, ChannelsKt.consumesAll(receiveChannel, receiveChannel2), new C13242(receiveChannel2, receiveChannel, function2, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }
}
